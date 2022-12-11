package androidx.fragment.app;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.fragment.C0298R;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.SpecialEffectsController;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelStoreOwner;
import me.tvspark.outline;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes3.dex */
public class FragmentStateManager {
    public static final String TAG = "FragmentManager";
    public static final String TARGET_REQUEST_CODE_STATE_TAG = "android:target_req_state";
    public static final String TARGET_STATE_TAG = "android:target_state";
    public static final String USER_VISIBLE_HINT_TAG = "android:user_visible_hint";
    public static final String VIEW_REGISTRY_STATE_TAG = "android:view_registry_state";
    public static final String VIEW_STATE_TAG = "android:view_state";
    public final FragmentLifecycleCallbacksDispatcher mDispatcher;
    @NonNull
    public final Fragment mFragment;
    public final FragmentStore mFragmentStore;
    public boolean mMovingToState = false;
    public int mFragmentManagerState = -1;

    /* renamed from: androidx.fragment.app.FragmentStateManager$2 */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class C03522 {
        public static final /* synthetic */ int[] $SwitchMap$androidx$lifecycle$Lifecycle$State;

        static {
            int[] iArr = new int[Lifecycle.State.values().length];
            $SwitchMap$androidx$lifecycle$Lifecycle$State = iArr;
            try {
                Lifecycle.State state = Lifecycle.State.RESUMED;
                iArr[4] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = $SwitchMap$androidx$lifecycle$Lifecycle$State;
                Lifecycle.State state2 = Lifecycle.State.STARTED;
                iArr2[3] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = $SwitchMap$androidx$lifecycle$Lifecycle$State;
                Lifecycle.State state3 = Lifecycle.State.CREATED;
                iArr3[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                int[] iArr4 = $SwitchMap$androidx$lifecycle$Lifecycle$State;
                Lifecycle.State state4 = Lifecycle.State.INITIALIZED;
                iArr4[1] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public FragmentStateManager(@NonNull FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher, @NonNull FragmentStore fragmentStore, @NonNull Fragment fragment) {
        this.mDispatcher = fragmentLifecycleCallbacksDispatcher;
        this.mFragmentStore = fragmentStore;
        this.mFragment = fragment;
    }

    public FragmentStateManager(@NonNull FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher, @NonNull FragmentStore fragmentStore, @NonNull Fragment fragment, @NonNull FragmentState fragmentState) {
        this.mDispatcher = fragmentLifecycleCallbacksDispatcher;
        this.mFragmentStore = fragmentStore;
        this.mFragment = fragment;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
        fragment.mBackStackNesting = 0;
        fragment.mInLayout = false;
        fragment.mAdded = false;
        Fragment fragment2 = fragment.mTarget;
        fragment.mTargetWho = fragment2 != null ? fragment2.mWho : null;
        Fragment fragment3 = this.mFragment;
        fragment3.mTarget = null;
        Bundle bundle = fragmentState.mSavedFragmentState;
        fragment3.mSavedFragmentState = bundle == null ? new Bundle() : bundle;
    }

    public FragmentStateManager(@NonNull FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher, @NonNull FragmentStore fragmentStore, @NonNull ClassLoader classLoader, @NonNull FragmentFactory fragmentFactory, @NonNull FragmentState fragmentState) {
        this.mDispatcher = fragmentLifecycleCallbacksDispatcher;
        this.mFragmentStore = fragmentStore;
        this.mFragment = fragmentFactory.instantiate(classLoader, fragmentState.mClassName);
        Bundle bundle = fragmentState.mArguments;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        this.mFragment.setArguments(fragmentState.mArguments);
        Fragment fragment = this.mFragment;
        fragment.mWho = fragmentState.mWho;
        fragment.mFromLayout = fragmentState.mFromLayout;
        fragment.mRestored = true;
        fragment.mFragmentId = fragmentState.mFragmentId;
        fragment.mContainerId = fragmentState.mContainerId;
        fragment.mTag = fragmentState.mTag;
        fragment.mRetainInstance = fragmentState.mRetainInstance;
        fragment.mRemoving = fragmentState.mRemoving;
        fragment.mDetached = fragmentState.mDetached;
        fragment.mHidden = fragmentState.mHidden;
        fragment.mMaxState = Lifecycle.State.values()[fragmentState.mMaxLifecycleState];
        Bundle bundle2 = fragmentState.mSavedFragmentState;
        if (bundle2 != null) {
            this.mFragment.mSavedFragmentState = bundle2;
        } else {
            this.mFragment.mSavedFragmentState = new Bundle();
        }
        if (FragmentManager.isLoggingEnabled(2)) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Instantiated fragment ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mFragment);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
    }

    private boolean isFragmentViewChild(@NonNull View view) {
        if (view == this.mFragment.mView) {
            return true;
        }
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent == this.mFragment.mView) {
                return true;
            }
        }
        return false;
    }

    private Bundle saveBasicState() {
        Bundle bundle = new Bundle();
        this.mFragment.performSaveInstanceState(bundle);
        this.mDispatcher.dispatchOnFragmentSaveInstanceState(this.mFragment, bundle, false);
        if (bundle.isEmpty()) {
            bundle = null;
        }
        if (this.mFragment.mView != null) {
            saveViewState();
        }
        if (this.mFragment.mSavedViewState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray(VIEW_STATE_TAG, this.mFragment.mSavedViewState);
        }
        if (this.mFragment.mSavedViewRegistryState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBundle(VIEW_REGISTRY_STATE_TAG, this.mFragment.mSavedViewRegistryState);
        }
        if (!this.mFragment.mUserVisibleHint) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean(USER_VISIBLE_HINT_TAG, this.mFragment.mUserVisibleHint);
        }
        return bundle;
    }

    public void activityCreated() {
        if (FragmentManager.isLoggingEnabled(3)) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("moveto ACTIVITY_CREATED: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mFragment);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
        Fragment fragment = this.mFragment;
        fragment.performActivityCreated(fragment.mSavedFragmentState);
        FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher = this.mDispatcher;
        Fragment fragment2 = this.mFragment;
        fragmentLifecycleCallbacksDispatcher.dispatchOnFragmentActivityCreated(fragment2, fragment2.mSavedFragmentState, false);
    }

    public void addViewToContainer() {
        int findFragmentIndexInContainer = this.mFragmentStore.findFragmentIndexInContainer(this.mFragment);
        Fragment fragment = this.mFragment;
        fragment.mContainer.addView(fragment.mView, findFragmentIndexInContainer);
    }

    public void attach() {
        if (FragmentManager.isLoggingEnabled(3)) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("moveto ATTACHED: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mFragment);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
        Fragment fragment = this.mFragment;
        Fragment fragment2 = fragment.mTarget;
        FragmentStateManager fragmentStateManager = null;
        if (fragment2 != null) {
            FragmentStateManager fragmentStateManager2 = this.mFragmentStore.getFragmentStateManager(fragment2.mWho);
            if (fragmentStateManager2 == null) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Fragment ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.mFragment);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(" declared target fragment ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.mFragment.mTarget);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(" that does not belong to this FragmentManager!");
                throw new IllegalStateException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
            }
            Fragment fragment3 = this.mFragment;
            fragment3.mTargetWho = fragment3.mTarget.mWho;
            fragment3.mTarget = null;
            fragmentStateManager = fragmentStateManager2;
        } else {
            String str = fragment.mTargetWho;
            if (str != null && (fragmentStateManager = this.mFragmentStore.getFragmentStateManager(str)) == null) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Fragment ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(this.mFragment);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(" declared target fragment ");
                throw new IllegalStateException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, this.mFragment.mTargetWho, " that does not belong to this FragmentManager!"));
            }
        }
        if (fragmentStateManager != null && (FragmentManager.USE_STATE_MANAGER || fragmentStateManager.getFragment().mState < 1)) {
            fragmentStateManager.moveToExpectedState();
        }
        Fragment fragment4 = this.mFragment;
        fragment4.mHost = fragment4.mFragmentManager.getHost();
        Fragment fragment5 = this.mFragment;
        fragment5.mParentFragment = fragment5.mFragmentManager.getParent();
        this.mDispatcher.dispatchOnFragmentPreAttached(this.mFragment, false);
        this.mFragment.performAttach();
        this.mDispatcher.dispatchOnFragmentAttached(this.mFragment, false);
    }

    public int computeExpectedState() {
        Fragment fragment;
        ViewGroup viewGroup;
        Fragment fragment2 = this.mFragment;
        if (fragment2.mFragmentManager == null) {
            return fragment2.mState;
        }
        int i = this.mFragmentManagerState;
        int ordinal = fragment2.mMaxState.ordinal();
        if (ordinal == 1) {
            i = Math.min(i, 0);
        } else if (ordinal == 2) {
            i = Math.min(i, 1);
        } else if (ordinal == 3) {
            i = Math.min(i, 5);
        } else if (ordinal != 4) {
            i = Math.min(i, -1);
        }
        Fragment fragment3 = this.mFragment;
        if (fragment3.mFromLayout) {
            if (fragment3.mInLayout) {
                i = Math.max(this.mFragmentManagerState, 2);
                View view = this.mFragment.mView;
                if (view != null && view.getParent() == null) {
                    i = Math.min(i, 2);
                }
            } else {
                i = this.mFragmentManagerState < 4 ? Math.min(i, fragment3.mState) : Math.min(i, 1);
            }
        }
        if (!this.mFragment.mAdded) {
            i = Math.min(i, 1);
        }
        SpecialEffectsController.Operation.LifecycleImpact lifecycleImpact = null;
        if (FragmentManager.USE_STATE_MANAGER && (viewGroup = (fragment = this.mFragment).mContainer) != null) {
            lifecycleImpact = SpecialEffectsController.getOrCreateController(viewGroup, fragment.getParentFragmentManager()).getAwaitingCompletionLifecycleImpact(this);
        }
        if (lifecycleImpact == SpecialEffectsController.Operation.LifecycleImpact.ADDING) {
            i = Math.min(i, 6);
        } else if (lifecycleImpact == SpecialEffectsController.Operation.LifecycleImpact.REMOVING) {
            i = Math.max(i, 3);
        } else {
            Fragment fragment4 = this.mFragment;
            if (fragment4.mRemoving) {
                i = fragment4.isInBackStack() ? Math.min(i, 1) : Math.min(i, -1);
            }
        }
        Fragment fragment5 = this.mFragment;
        if (fragment5.mDeferStart && fragment5.mState < 5) {
            i = Math.min(i, 4);
        }
        if (FragmentManager.isLoggingEnabled(2)) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("computeExpectedState() of ", i, " for ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mFragment);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
        return i;
    }

    public void create() {
        if (FragmentManager.isLoggingEnabled(3)) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("moveto CREATED: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mFragment);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
        Fragment fragment = this.mFragment;
        if (fragment.mIsCreated) {
            fragment.restoreChildFragmentState(fragment.mSavedFragmentState);
            this.mFragment.mState = 1;
            return;
        }
        this.mDispatcher.dispatchOnFragmentPreCreated(fragment, fragment.mSavedFragmentState, false);
        Fragment fragment2 = this.mFragment;
        fragment2.performCreate(fragment2.mSavedFragmentState);
        FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher = this.mDispatcher;
        Fragment fragment3 = this.mFragment;
        fragmentLifecycleCallbacksDispatcher.dispatchOnFragmentCreated(fragment3, fragment3.mSavedFragmentState, false);
    }

    public void createView() {
        String str;
        if (this.mFragment.mFromLayout) {
            return;
        }
        if (FragmentManager.isLoggingEnabled(3)) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("moveto CREATE_VIEW: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mFragment);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
        Fragment fragment = this.mFragment;
        LayoutInflater performGetLayoutInflater = fragment.performGetLayoutInflater(fragment.mSavedFragmentState);
        ViewGroup viewGroup = null;
        Fragment fragment2 = this.mFragment;
        ViewGroup viewGroup2 = fragment2.mContainer;
        if (viewGroup2 != null) {
            viewGroup = viewGroup2;
        } else {
            int i = fragment2.mContainerId;
            if (i != 0) {
                if (i == -1) {
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Cannot create fragment ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.mFragment);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(" for a container view with no id");
                    throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
                }
                viewGroup = (ViewGroup) fragment2.mFragmentManager.getContainer().onFindViewById(this.mFragment.mContainerId);
                if (viewGroup == null) {
                    Fragment fragment3 = this.mFragment;
                    if (!fragment3.mRestored) {
                        try {
                            str = fragment3.getResources().getResourceName(this.mFragment.mContainerId);
                        } catch (Resources.NotFoundException unused) {
                            str = "unknown";
                        }
                        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("No view found for id 0x");
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(Integer.toHexString(this.mFragment.mContainerId));
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(" (");
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(str);
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(") for fragment ");
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(this.mFragment);
                        throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString());
                    }
                }
            }
        }
        Fragment fragment4 = this.mFragment;
        fragment4.mContainer = viewGroup;
        fragment4.performCreateView(performGetLayoutInflater, viewGroup, fragment4.mSavedFragmentState);
        View view = this.mFragment.mView;
        if (view != null) {
            boolean z = false;
            view.setSaveFromParentEnabled(false);
            Fragment fragment5 = this.mFragment;
            fragment5.mView.setTag(C0298R.C0301id.fragment_container_view_tag, fragment5);
            if (viewGroup != null) {
                addViewToContainer();
            }
            Fragment fragment6 = this.mFragment;
            if (fragment6.mHidden) {
                fragment6.mView.setVisibility(8);
            }
            if (ViewCompat.isAttachedToWindow(this.mFragment.mView)) {
                ViewCompat.requestApplyInsets(this.mFragment.mView);
            } else {
                final View view2 = this.mFragment.mView;
                view2.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: androidx.fragment.app.FragmentStateManager.1
                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewAttachedToWindow(View view3) {
                        view2.removeOnAttachStateChangeListener(this);
                        ViewCompat.requestApplyInsets(view2);
                    }

                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewDetachedFromWindow(View view3) {
                    }
                });
            }
            this.mFragment.performViewCreated();
            FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher = this.mDispatcher;
            Fragment fragment7 = this.mFragment;
            fragmentLifecycleCallbacksDispatcher.dispatchOnFragmentViewCreated(fragment7, fragment7.mView, fragment7.mSavedFragmentState, false);
            int visibility = this.mFragment.mView.getVisibility();
            float alpha = this.mFragment.mView.getAlpha();
            if (FragmentManager.USE_STATE_MANAGER) {
                this.mFragment.setPostOnViewCreatedAlpha(alpha);
                Fragment fragment8 = this.mFragment;
                if (fragment8.mContainer != null && visibility == 0) {
                    View findFocus = fragment8.mView.findFocus();
                    if (findFocus != null) {
                        this.mFragment.setFocusedView(findFocus);
                        if (FragmentManager.isLoggingEnabled(2)) {
                            String str2 = "requestFocus: Saved focused view " + findFocus + " for Fragment " + this.mFragment;
                        }
                    }
                    this.mFragment.mView.setAlpha(0.0f);
                }
            } else {
                Fragment fragment9 = this.mFragment;
                if (visibility == 0 && fragment9.mContainer != null) {
                    z = true;
                }
                fragment9.mIsNewlyAdded = z;
            }
        }
        this.mFragment.mState = 2;
    }

    public void destroy() {
        Fragment findActiveFragment;
        if (FragmentManager.isLoggingEnabled(3)) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("movefrom CREATED: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mFragment);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
        Fragment fragment = this.mFragment;
        boolean z = true;
        boolean z2 = fragment.mRemoving && !fragment.isInBackStack();
        if (!(z2 || this.mFragmentStore.getNonConfig().shouldDestroy(this.mFragment))) {
            String str = this.mFragment.mTargetWho;
            if (str != null && (findActiveFragment = this.mFragmentStore.findActiveFragment(str)) != null && findActiveFragment.mRetainInstance) {
                this.mFragment.mTarget = findActiveFragment;
            }
            this.mFragment.mState = 0;
            return;
        }
        FragmentHostCallback<?> fragmentHostCallback = this.mFragment.mHost;
        if (fragmentHostCallback instanceof ViewModelStoreOwner) {
            z = this.mFragmentStore.getNonConfig().isCleared();
        } else if (fragmentHostCallback.getContext() instanceof Activity) {
            z = true ^ ((Activity) fragmentHostCallback.getContext()).isChangingConfigurations();
        }
        if (z2 || z) {
            this.mFragmentStore.getNonConfig().clearNonConfigState(this.mFragment);
        }
        this.mFragment.performDestroy();
        this.mDispatcher.dispatchOnFragmentDestroyed(this.mFragment, false);
        for (FragmentStateManager fragmentStateManager : this.mFragmentStore.getActiveFragmentStateManagers()) {
            if (fragmentStateManager != null) {
                Fragment fragment2 = fragmentStateManager.getFragment();
                if (this.mFragment.mWho.equals(fragment2.mTargetWho)) {
                    fragment2.mTarget = this.mFragment;
                    fragment2.mTargetWho = null;
                }
            }
        }
        Fragment fragment3 = this.mFragment;
        String str2 = fragment3.mTargetWho;
        if (str2 != null) {
            fragment3.mTarget = this.mFragmentStore.findActiveFragment(str2);
        }
        this.mFragmentStore.makeInactive(this);
    }

    public void destroyFragmentView() {
        View view;
        if (FragmentManager.isLoggingEnabled(3)) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("movefrom CREATE_VIEW: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mFragment);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
        Fragment fragment = this.mFragment;
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null && (view = fragment.mView) != null) {
            viewGroup.removeView(view);
        }
        this.mFragment.performDestroyView();
        this.mDispatcher.dispatchOnFragmentViewDestroyed(this.mFragment, false);
        Fragment fragment2 = this.mFragment;
        fragment2.mContainer = null;
        fragment2.mView = null;
        fragment2.mViewLifecycleOwner = null;
        fragment2.mViewLifecycleOwnerLiveData.setValue(null);
        this.mFragment.mInLayout = false;
    }

    public void detach() {
        if (FragmentManager.isLoggingEnabled(3)) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("movefrom ATTACHED: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mFragment);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
        this.mFragment.performDetach();
        boolean z = false;
        this.mDispatcher.dispatchOnFragmentDetached(this.mFragment, false);
        Fragment fragment = this.mFragment;
        fragment.mState = -1;
        fragment.mHost = null;
        fragment.mParentFragment = null;
        fragment.mFragmentManager = null;
        if (fragment.mRemoving && !fragment.isInBackStack()) {
            z = true;
        }
        if (z || this.mFragmentStore.getNonConfig().shouldDestroy(this.mFragment)) {
            if (FragmentManager.isLoggingEnabled(3)) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("initState called for fragment: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.mFragment);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
            }
            this.mFragment.initState();
        }
    }

    public void ensureInflatedView() {
        Fragment fragment = this.mFragment;
        if (!fragment.mFromLayout || !fragment.mInLayout || fragment.mPerformedCreateView) {
            return;
        }
        if (FragmentManager.isLoggingEnabled(3)) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("moveto CREATE_VIEW: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mFragment);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
        Fragment fragment2 = this.mFragment;
        fragment2.performCreateView(fragment2.performGetLayoutInflater(fragment2.mSavedFragmentState), null, this.mFragment.mSavedFragmentState);
        View view = this.mFragment.mView;
        if (view == null) {
            return;
        }
        view.setSaveFromParentEnabled(false);
        Fragment fragment3 = this.mFragment;
        fragment3.mView.setTag(C0298R.C0301id.fragment_container_view_tag, fragment3);
        Fragment fragment4 = this.mFragment;
        if (fragment4.mHidden) {
            fragment4.mView.setVisibility(8);
        }
        this.mFragment.performViewCreated();
        FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher = this.mDispatcher;
        Fragment fragment5 = this.mFragment;
        fragmentLifecycleCallbacksDispatcher.dispatchOnFragmentViewCreated(fragment5, fragment5.mView, fragment5.mSavedFragmentState, false);
        this.mFragment.mState = 2;
    }

    @NonNull
    public Fragment getFragment() {
        return this.mFragment;
    }

    public void moveToExpectedState() {
        if (this.mMovingToState) {
            if (!FragmentManager.isLoggingEnabled(2)) {
                return;
            }
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Ignoring re-entrant call to moveToExpectedState() for ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getFragment());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
            return;
        }
        try {
            this.mMovingToState = true;
            while (true) {
                int computeExpectedState = computeExpectedState();
                if (computeExpectedState == this.mFragment.mState) {
                    if (FragmentManager.USE_STATE_MANAGER && this.mFragment.mHiddenChanged) {
                        if (this.mFragment.mView != null && this.mFragment.mContainer != null) {
                            SpecialEffectsController orCreateController = SpecialEffectsController.getOrCreateController(this.mFragment.mContainer, this.mFragment.getParentFragmentManager());
                            if (this.mFragment.mHidden) {
                                orCreateController.enqueueHide(this);
                            } else {
                                orCreateController.enqueueShow(this);
                            }
                        }
                        if (this.mFragment.mFragmentManager != null) {
                            this.mFragment.mFragmentManager.invalidateMenuForFragment(this.mFragment);
                        }
                        this.mFragment.mHiddenChanged = false;
                        this.mFragment.onHiddenChanged(this.mFragment.mHidden);
                    }
                    return;
                } else if (computeExpectedState > this.mFragment.mState) {
                    switch (this.mFragment.mState + 1) {
                        case 0:
                            attach();
                            continue;
                        case 1:
                            create();
                            continue;
                        case 2:
                            ensureInflatedView();
                            createView();
                            continue;
                        case 3:
                            activityCreated();
                            continue;
                        case 4:
                            if (this.mFragment.mView != null && this.mFragment.mContainer != null) {
                                SpecialEffectsController.getOrCreateController(this.mFragment.mContainer, this.mFragment.getParentFragmentManager()).enqueueAdd(SpecialEffectsController.Operation.State.from(this.mFragment.mView.getVisibility()), this);
                            }
                            this.mFragment.mState = 4;
                            continue;
                        case 5:
                            start();
                            continue;
                        case 6:
                            this.mFragment.mState = 6;
                            continue;
                        case 7:
                            resume();
                            continue;
                        default:
                            continue;
                    }
                } else {
                    switch (this.mFragment.mState - 1) {
                        case -1:
                            detach();
                            continue;
                        case 0:
                            destroy();
                            continue;
                        case 1:
                            destroyFragmentView();
                            this.mFragment.mState = 1;
                            continue;
                        case 2:
                            this.mFragment.mInLayout = false;
                            this.mFragment.mState = 2;
                            continue;
                        case 3:
                            if (FragmentManager.isLoggingEnabled(3)) {
                                String str = "movefrom ACTIVITY_CREATED: " + this.mFragment;
                            }
                            if (this.mFragment.mView != null && this.mFragment.mSavedViewState == null) {
                                saveViewState();
                            }
                            if (this.mFragment.mView != null && this.mFragment.mContainer != null) {
                                SpecialEffectsController.getOrCreateController(this.mFragment.mContainer, this.mFragment.getParentFragmentManager()).enqueueRemove(this);
                            }
                            this.mFragment.mState = 3;
                            continue;
                        case 4:
                            stop();
                            continue;
                        case 5:
                            this.mFragment.mState = 5;
                            continue;
                        case 6:
                            pause();
                            continue;
                        default:
                            continue;
                    }
                }
            }
        } finally {
            this.mMovingToState = false;
        }
    }

    public void pause() {
        if (FragmentManager.isLoggingEnabled(3)) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("movefrom RESUMED: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mFragment);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
        this.mFragment.performPause();
        this.mDispatcher.dispatchOnFragmentPaused(this.mFragment, false);
    }

    public void restoreState(@NonNull ClassLoader classLoader) {
        Bundle bundle = this.mFragment.mSavedFragmentState;
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        Fragment fragment = this.mFragment;
        fragment.mSavedViewState = fragment.mSavedFragmentState.getSparseParcelableArray(VIEW_STATE_TAG);
        Fragment fragment2 = this.mFragment;
        fragment2.mSavedViewRegistryState = fragment2.mSavedFragmentState.getBundle(VIEW_REGISTRY_STATE_TAG);
        Fragment fragment3 = this.mFragment;
        fragment3.mTargetWho = fragment3.mSavedFragmentState.getString(TARGET_STATE_TAG);
        Fragment fragment4 = this.mFragment;
        if (fragment4.mTargetWho != null) {
            fragment4.mTargetRequestCode = fragment4.mSavedFragmentState.getInt(TARGET_REQUEST_CODE_STATE_TAG, 0);
        }
        Fragment fragment5 = this.mFragment;
        Boolean bool = fragment5.mSavedUserVisibleHint;
        if (bool != null) {
            fragment5.mUserVisibleHint = bool.booleanValue();
            this.mFragment.mSavedUserVisibleHint = null;
        } else {
            fragment5.mUserVisibleHint = fragment5.mSavedFragmentState.getBoolean(USER_VISIBLE_HINT_TAG, true);
        }
        Fragment fragment6 = this.mFragment;
        if (fragment6.mUserVisibleHint) {
            return;
        }
        fragment6.mDeferStart = true;
    }

    public void resume() {
        if (FragmentManager.isLoggingEnabled(3)) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("moveto RESUMED: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mFragment);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
        View focusedView = this.mFragment.getFocusedView();
        if (focusedView != null && isFragmentViewChild(focusedView)) {
            boolean requestFocus = focusedView.requestFocus();
            if (FragmentManager.isLoggingEnabled(2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("requestFocus: Restoring focused view ");
                sb.append(focusedView);
                sb.append(StringUtils.SPACE);
                sb.append(requestFocus ? "succeeded" : "failed");
                sb.append(" on Fragment ");
                sb.append(this.mFragment);
                sb.append(" resulting in focused view ");
                sb.append(this.mFragment.mView.findFocus());
                sb.toString();
            }
        }
        this.mFragment.setFocusedView(null);
        this.mFragment.performResume();
        this.mDispatcher.dispatchOnFragmentResumed(this.mFragment, false);
        Fragment fragment = this.mFragment;
        fragment.mSavedFragmentState = null;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
    }

    @Nullable
    public Fragment.SavedState saveInstanceState() {
        Bundle saveBasicState;
        if (this.mFragment.mState <= -1 || (saveBasicState = saveBasicState()) == null) {
            return null;
        }
        return new Fragment.SavedState(saveBasicState);
    }

    @NonNull
    public FragmentState saveState() {
        FragmentState fragmentState = new FragmentState(this.mFragment);
        if (this.mFragment.mState <= -1 || fragmentState.mSavedFragmentState != null) {
            fragmentState.mSavedFragmentState = this.mFragment.mSavedFragmentState;
        } else {
            Bundle saveBasicState = saveBasicState();
            fragmentState.mSavedFragmentState = saveBasicState;
            if (this.mFragment.mTargetWho != null) {
                if (saveBasicState == null) {
                    fragmentState.mSavedFragmentState = new Bundle();
                }
                fragmentState.mSavedFragmentState.putString(TARGET_STATE_TAG, this.mFragment.mTargetWho);
                int i = this.mFragment.mTargetRequestCode;
                if (i != 0) {
                    fragmentState.mSavedFragmentState.putInt(TARGET_REQUEST_CODE_STATE_TAG, i);
                }
            }
        }
        return fragmentState;
    }

    public void saveViewState() {
        if (this.mFragment.mView == null) {
            return;
        }
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        this.mFragment.mView.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            this.mFragment.mSavedViewState = sparseArray;
        }
        Bundle bundle = new Bundle();
        this.mFragment.mViewLifecycleOwner.performSave(bundle);
        if (bundle.isEmpty()) {
            return;
        }
        this.mFragment.mSavedViewRegistryState = bundle;
    }

    public void setFragmentManagerState(int i) {
        this.mFragmentManagerState = i;
    }

    public void start() {
        if (FragmentManager.isLoggingEnabled(3)) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("moveto STARTED: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mFragment);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
        this.mFragment.performStart();
        this.mDispatcher.dispatchOnFragmentStarted(this.mFragment, false);
    }

    public void stop() {
        if (FragmentManager.isLoggingEnabled(3)) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("movefrom STARTED: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mFragment);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
        this.mFragment.performStop();
        this.mDispatcher.dispatchOnFragmentStopped(this.mFragment, false);
    }
}
