package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityOptionsCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public abstract class ActivityResultRegistry {
    public static final int INITIAL_REQUEST_CODE_VALUE = 65536;
    public static final String KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS = "KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS";
    public static final String KEY_COMPONENT_ACTIVITY_PENDING_RESULTS = "KEY_COMPONENT_ACTIVITY_PENDING_RESULT";
    public static final String KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT = "KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT";
    public static final String KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS = "KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS";
    public static final String KEY_COMPONENT_ACTIVITY_REGISTERED_RCS = "KEY_COMPONENT_ACTIVITY_REGISTERED_RCS";
    public static final String LOG_TAG = "ActivityResultRegistry";
    public Random mRandom = new Random();
    public final Map<Integer, String> mRcToKey = new HashMap();
    public final Map<String, Integer> mKeyToRc = new HashMap();
    public final Map<String, LifecycleContainer> mKeyToLifecycleContainers = new HashMap();
    public ArrayList<String> mLaunchedKeys = new ArrayList<>();
    public final transient Map<String, CallbackAndContract<?>> mKeyToCallback = new HashMap();
    public final Map<String, Object> mParsedPendingResults = new HashMap();
    public final Bundle mPendingResults = new Bundle();

    /* loaded from: classes3.dex */
    public static class CallbackAndContract<O> {
        public final ActivityResultCallback<O> mCallback;
        public final ActivityResultContract<?, O> mContract;

        public CallbackAndContract(ActivityResultCallback<O> activityResultCallback, ActivityResultContract<?, O> activityResultContract) {
            this.mCallback = activityResultCallback;
            this.mContract = activityResultContract;
        }
    }

    /* loaded from: classes3.dex */
    public static class LifecycleContainer {
        public final Lifecycle mLifecycle;
        public final ArrayList<LifecycleEventObserver> mObservers = new ArrayList<>();

        public LifecycleContainer(@NonNull Lifecycle lifecycle) {
            this.mLifecycle = lifecycle;
        }

        public void addObserver(@NonNull LifecycleEventObserver lifecycleEventObserver) {
            this.mLifecycle.addObserver(lifecycleEventObserver);
            this.mObservers.add(lifecycleEventObserver);
        }

        public void clearObservers() {
            Iterator<LifecycleEventObserver> it = this.mObservers.iterator();
            while (it.hasNext()) {
                this.mLifecycle.removeObserver(it.next());
            }
            this.mObservers.clear();
        }
    }

    private void bindRcKey(int i, String str) {
        this.mRcToKey.put(Integer.valueOf(i), str);
        this.mKeyToRc.put(str, Integer.valueOf(i));
    }

    private <O> void doDispatch(String str, int i, @Nullable Intent intent, @Nullable CallbackAndContract<O> callbackAndContract) {
        ActivityResultCallback<O> activityResultCallback;
        if (callbackAndContract != null && (activityResultCallback = callbackAndContract.mCallback) != null) {
            activityResultCallback.onActivityResult(callbackAndContract.mContract.mo4331parseResult(i, intent));
            return;
        }
        this.mParsedPendingResults.remove(str);
        this.mPendingResults.putParcelable(str, new ActivityResult(i, intent));
    }

    private int generateRandomNumber() {
        int nextInt = this.mRandom.nextInt(2147418112);
        while (true) {
            int i = nextInt + 65536;
            if (this.mRcToKey.containsKey(Integer.valueOf(i))) {
                nextInt = this.mRandom.nextInt(2147418112);
            } else {
                return i;
            }
        }
    }

    private int registerKey(String str) {
        Integer num = this.mKeyToRc.get(str);
        if (num != null) {
            return num.intValue();
        }
        int generateRandomNumber = generateRandomNumber();
        bindRcKey(generateRandomNumber, str);
        return generateRandomNumber;
    }

    @MainThread
    public final boolean dispatchResult(int i, int i2, @Nullable Intent intent) {
        String str = this.mRcToKey.get(Integer.valueOf(i));
        if (str == null) {
            return false;
        }
        this.mLaunchedKeys.remove(str);
        doDispatch(str, i2, intent, this.mKeyToCallback.get(str));
        return true;
    }

    @MainThread
    public final <O> boolean dispatchResult(int i, @SuppressLint({"UnknownNullness"}) O o) {
        ActivityResultCallback<?> activityResultCallback;
        String str = this.mRcToKey.get(Integer.valueOf(i));
        if (str == null) {
            return false;
        }
        this.mLaunchedKeys.remove(str);
        CallbackAndContract<?> callbackAndContract = this.mKeyToCallback.get(str);
        if (callbackAndContract != null && (activityResultCallback = callbackAndContract.mCallback) != null) {
            activityResultCallback.onActivityResult(o);
            return true;
        }
        this.mPendingResults.remove(str);
        this.mParsedPendingResults.put(str, o);
        return true;
    }

    @MainThread
    public abstract <I, O> void onLaunch(int i, @NonNull ActivityResultContract<I, O> activityResultContract, @SuppressLint({"UnknownNullness"}) I i2, @Nullable ActivityOptionsCompat activityOptionsCompat);

    public final void onRestoreInstanceState(@Nullable Bundle bundle) {
        if (bundle == null) {
            return;
        }
        ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList(KEY_COMPONENT_ACTIVITY_REGISTERED_RCS);
        ArrayList<String> stringArrayList = bundle.getStringArrayList(KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS);
        if (stringArrayList == null || integerArrayList == null) {
            return;
        }
        int size = stringArrayList.size();
        for (int i = 0; i < size; i++) {
            bindRcKey(integerArrayList.get(i).intValue(), stringArrayList.get(i));
        }
        this.mLaunchedKeys = bundle.getStringArrayList(KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS);
        this.mRandom = (Random) bundle.getSerializable(KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT);
        this.mPendingResults.putAll(bundle.getBundle(KEY_COMPONENT_ACTIVITY_PENDING_RESULTS));
    }

    public final void onSaveInstanceState(@NonNull Bundle bundle) {
        bundle.putIntegerArrayList(KEY_COMPONENT_ACTIVITY_REGISTERED_RCS, new ArrayList<>(this.mRcToKey.keySet()));
        bundle.putStringArrayList(KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS, new ArrayList<>(this.mRcToKey.values()));
        bundle.putStringArrayList(KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS, new ArrayList<>(this.mLaunchedKeys));
        bundle.putBundle(KEY_COMPONENT_ACTIVITY_PENDING_RESULTS, (Bundle) this.mPendingResults.clone());
        bundle.putSerializable(KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT, this.mRandom);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    public final <I, O> ActivityResultLauncher<I> register(@NonNull final String str, @NonNull final ActivityResultContract<I, O> activityResultContract, @NonNull ActivityResultCallback<O> activityResultCallback) {
        final int registerKey = registerKey(str);
        this.mKeyToCallback.put(str, new CallbackAndContract<>(activityResultCallback, activityResultContract));
        if (this.mParsedPendingResults.containsKey(str)) {
            Object obj = this.mParsedPendingResults.get(str);
            this.mParsedPendingResults.remove(str);
            activityResultCallback.onActivityResult(obj);
        }
        ActivityResult activityResult = (ActivityResult) this.mPendingResults.getParcelable(str);
        if (activityResult != null) {
            this.mPendingResults.remove(str);
            activityResultCallback.onActivityResult(activityResultContract.mo4331parseResult(activityResult.getResultCode(), activityResult.getData()));
        }
        return new ActivityResultLauncher<I>() { // from class: androidx.activity.result.ActivityResultRegistry.3
            @Override // androidx.activity.result.ActivityResultLauncher
            @NonNull
            public ActivityResultContract<I, ?> getContract() {
                return activityResultContract;
            }

            @Override // androidx.activity.result.ActivityResultLauncher
            public void launch(I i, @Nullable ActivityOptionsCompat activityOptionsCompat) {
                ActivityResultRegistry.this.mLaunchedKeys.add(str);
                ActivityResultRegistry.this.onLaunch(registerKey, activityResultContract, i, activityOptionsCompat);
            }

            @Override // androidx.activity.result.ActivityResultLauncher
            public void unregister() {
                ActivityResultRegistry.this.unregister(str);
            }
        };
    }

    @NonNull
    public final <I, O> ActivityResultLauncher<I> register(@NonNull final String str, @NonNull LifecycleOwner lifecycleOwner, @NonNull final ActivityResultContract<I, O> activityResultContract, @NonNull final ActivityResultCallback<O> activityResultCallback) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        if (!lifecycle.getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            final int registerKey = registerKey(str);
            LifecycleContainer lifecycleContainer = this.mKeyToLifecycleContainers.get(str);
            if (lifecycleContainer == null) {
                lifecycleContainer = new LifecycleContainer(lifecycle);
            }
            lifecycleContainer.addObserver(new LifecycleEventObserver() { // from class: androidx.activity.result.ActivityResultRegistry.1
                @Override // androidx.lifecycle.LifecycleEventObserver
                public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner2, @NonNull Lifecycle.Event event) {
                    if (!Lifecycle.Event.ON_START.equals(event)) {
                        if (Lifecycle.Event.ON_STOP.equals(event)) {
                            ActivityResultRegistry.this.mKeyToCallback.remove(str);
                            return;
                        } else if (!Lifecycle.Event.ON_DESTROY.equals(event)) {
                            return;
                        } else {
                            ActivityResultRegistry.this.unregister(str);
                            return;
                        }
                    }
                    ActivityResultRegistry.this.mKeyToCallback.put(str, new CallbackAndContract<>(activityResultCallback, activityResultContract));
                    if (ActivityResultRegistry.this.mParsedPendingResults.containsKey(str)) {
                        Object obj = ActivityResultRegistry.this.mParsedPendingResults.get(str);
                        ActivityResultRegistry.this.mParsedPendingResults.remove(str);
                        activityResultCallback.onActivityResult(obj);
                    }
                    ActivityResult activityResult = (ActivityResult) ActivityResultRegistry.this.mPendingResults.getParcelable(str);
                    if (activityResult == null) {
                        return;
                    }
                    ActivityResultRegistry.this.mPendingResults.remove(str);
                    activityResultCallback.onActivityResult(activityResultContract.mo4331parseResult(activityResult.getResultCode(), activityResult.getData()));
                }
            });
            this.mKeyToLifecycleContainers.put(str, lifecycleContainer);
            return new ActivityResultLauncher<I>() { // from class: androidx.activity.result.ActivityResultRegistry.2
                @Override // androidx.activity.result.ActivityResultLauncher
                @NonNull
                public ActivityResultContract<I, ?> getContract() {
                    return activityResultContract;
                }

                @Override // androidx.activity.result.ActivityResultLauncher
                public void launch(I i, @Nullable ActivityOptionsCompat activityOptionsCompat) {
                    ActivityResultRegistry.this.mLaunchedKeys.add(str);
                    ActivityResultRegistry.this.onLaunch(registerKey, activityResultContract, i, activityOptionsCompat);
                }

                @Override // androidx.activity.result.ActivityResultLauncher
                public void unregister() {
                    ActivityResultRegistry.this.unregister(str);
                }
            };
        }
        throw new IllegalStateException("LifecycleOwner " + lifecycleOwner + " is attempting to register while current state is " + lifecycle.getCurrentState() + ". LifecycleOwners must call register before they are STARTED.");
    }

    @MainThread
    public final void unregister(@NonNull String str) {
        Integer remove;
        if (!this.mLaunchedKeys.contains(str) && (remove = this.mKeyToRc.remove(str)) != null) {
            this.mRcToKey.remove(remove);
        }
        this.mKeyToCallback.remove(str);
        if (this.mParsedPendingResults.containsKey(str)) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Dropping pending result for request ", str, ": ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mParsedPendingResults.get(str));
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
            this.mParsedPendingResults.remove(str);
        }
        if (this.mPendingResults.containsKey(str)) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Dropping pending result for request ", str, ": ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.mPendingResults.getParcelable(str));
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
            this.mPendingResults.remove(str);
        }
        LifecycleContainer lifecycleContainer = this.mKeyToLifecycleContainers.get(str);
        if (lifecycleContainer != null) {
            lifecycleContainer.clearObservers();
            this.mKeyToLifecycleContainers.remove(str);
        }
    }
}
