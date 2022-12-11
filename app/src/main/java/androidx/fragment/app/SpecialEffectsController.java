package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.p003os.CancellationSignal;
import androidx.core.view.ViewCompat;
import androidx.fragment.C0298R;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public abstract class SpecialEffectsController {
    public final ViewGroup mContainer;
    public final ArrayList<Operation> mPendingOperations = new ArrayList<>();
    public final ArrayList<Operation> mRunningOperations = new ArrayList<>();
    public boolean mOperationDirectionIsPop = false;
    public boolean mIsContainerPostponed = false;

    /* renamed from: androidx.fragment.app.SpecialEffectsController$3 */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class C03733 {

        /* renamed from: $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$LifecycleImpact */
        public static final /* synthetic */ int[] f63xb9e640f0;

        /* renamed from: $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State */
        public static final /* synthetic */ int[] f64xe493b431;

        static {
            int[] iArr = new int[Operation.LifecycleImpact.values().length];
            f63xb9e640f0 = iArr;
            try {
                Operation.LifecycleImpact lifecycleImpact = Operation.LifecycleImpact.ADDING;
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = f63xb9e640f0;
                Operation.LifecycleImpact lifecycleImpact2 = Operation.LifecycleImpact.REMOVING;
                iArr2[2] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = f63xb9e640f0;
                Operation.LifecycleImpact lifecycleImpact3 = Operation.LifecycleImpact.NONE;
                iArr3[0] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr4 = new int[Operation.State.values().length];
            f64xe493b431 = iArr4;
            try {
                Operation.State state = Operation.State.REMOVED;
                iArr4[0] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                int[] iArr5 = f64xe493b431;
                Operation.State state2 = Operation.State.VISIBLE;
                iArr5[1] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                int[] iArr6 = f64xe493b431;
                Operation.State state3 = Operation.State.GONE;
                iArr6[2] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                int[] iArr7 = f64xe493b431;
                Operation.State state4 = Operation.State.INVISIBLE;
                iArr7[3] = 4;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class FragmentStateManagerOperation extends Operation {
        @NonNull
        public final FragmentStateManager mFragmentStateManager;

        public FragmentStateManagerOperation(@NonNull Operation.State state, @NonNull Operation.LifecycleImpact lifecycleImpact, @NonNull FragmentStateManager fragmentStateManager, @NonNull CancellationSignal cancellationSignal) {
            super(state, lifecycleImpact, fragmentStateManager.getFragment(), cancellationSignal);
            this.mFragmentStateManager = fragmentStateManager;
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Operation
        public void complete() {
            super.complete();
            this.mFragmentStateManager.moveToExpectedState();
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Operation
        public void onStart() {
            if (getLifecycleImpact() == Operation.LifecycleImpact.ADDING) {
                Fragment fragment = this.mFragmentStateManager.getFragment();
                View findFocus = fragment.mView.findFocus();
                if (findFocus != null) {
                    fragment.setFocusedView(findFocus);
                    if (FragmentManager.isLoggingEnabled(2)) {
                        String str = "requestFocus: Saved focused view " + findFocus + " for Fragment " + fragment;
                    }
                }
                View requireView = getFragment().requireView();
                if (requireView.getParent() == null) {
                    this.mFragmentStateManager.addViewToContainer();
                    requireView.setAlpha(0.0f);
                }
                if (requireView.getAlpha() == 0.0f && requireView.getVisibility() == 0) {
                    requireView.setVisibility(4);
                }
                requireView.setAlpha(fragment.getPostOnViewCreatedAlpha());
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class Operation {
        @NonNull
        public State mFinalState;
        @NonNull
        public final Fragment mFragment;
        @NonNull
        public LifecycleImpact mLifecycleImpact;
        @NonNull
        public final List<Runnable> mCompletionListeners = new ArrayList();
        @NonNull
        public final HashSet<CancellationSignal> mSpecialEffectsSignals = new HashSet<>();
        public boolean mIsCanceled = false;
        public boolean mIsComplete = false;

        /* loaded from: classes3.dex */
        public enum LifecycleImpact {
            NONE,
            ADDING,
            REMOVING
        }

        /* loaded from: classes3.dex */
        public enum State {
            REMOVED,
            VISIBLE,
            GONE,
            INVISIBLE;

            @NonNull
            public static State from(int i) {
                if (i != 0) {
                    if (i == 4) {
                        return INVISIBLE;
                    }
                    if (i != 8) {
                        throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unknown visibility ", i));
                    }
                    return GONE;
                }
                return VISIBLE;
            }

            @NonNull
            public static State from(@NonNull View view) {
                return (view.getAlpha() == 0.0f && view.getVisibility() == 0) ? INVISIBLE : from(view.getVisibility());
            }

            public void applyState(@NonNull View view) {
                int i;
                int ordinal = ordinal();
                if (ordinal == 0) {
                    ViewGroup viewGroup = (ViewGroup) view.getParent();
                    if (viewGroup == null) {
                        return;
                    }
                    if (FragmentManager.isLoggingEnabled(2)) {
                        String str = "SpecialEffectsController: Removing view " + view + " from container " + viewGroup;
                    }
                    viewGroup.removeView(view);
                    return;
                }
                if (ordinal == 1) {
                    if (FragmentManager.isLoggingEnabled(2)) {
                        String str2 = "SpecialEffectsController: Setting view " + view + " to VISIBLE";
                    }
                    i = 0;
                } else if (ordinal == 2) {
                    if (FragmentManager.isLoggingEnabled(2)) {
                        String str3 = "SpecialEffectsController: Setting view " + view + " to GONE";
                    }
                    i = 8;
                } else if (ordinal != 3) {
                    return;
                } else {
                    if (FragmentManager.isLoggingEnabled(2)) {
                        String str4 = "SpecialEffectsController: Setting view " + view + " to INVISIBLE";
                    }
                    i = 4;
                }
                view.setVisibility(i);
            }
        }

        public Operation(@NonNull State state, @NonNull LifecycleImpact lifecycleImpact, @NonNull Fragment fragment, @NonNull CancellationSignal cancellationSignal) {
            this.mFinalState = state;
            this.mLifecycleImpact = lifecycleImpact;
            this.mFragment = fragment;
            cancellationSignal.setOnCancelListener(new CancellationSignal.OnCancelListener() { // from class: androidx.fragment.app.SpecialEffectsController.Operation.1
                @Override // androidx.core.p003os.CancellationSignal.OnCancelListener
                public void onCancel() {
                    Operation.this.cancel();
                }
            });
        }

        public final void addCompletionListener(@NonNull Runnable runnable) {
            this.mCompletionListeners.add(runnable);
        }

        public final void cancel() {
            if (isCanceled()) {
                return;
            }
            this.mIsCanceled = true;
            if (this.mSpecialEffectsSignals.isEmpty()) {
                complete();
                return;
            }
            Iterator it = new ArrayList(this.mSpecialEffectsSignals).iterator();
            while (it.hasNext()) {
                ((CancellationSignal) it.next()).cancel();
            }
        }

        @CallSuper
        public void complete() {
            if (this.mIsComplete) {
                return;
            }
            if (FragmentManager.isLoggingEnabled(2)) {
                String str = "SpecialEffectsController: " + this + " has called complete.";
            }
            this.mIsComplete = true;
            for (Runnable runnable : this.mCompletionListeners) {
                runnable.run();
            }
        }

        public final void completeSpecialEffect(@NonNull CancellationSignal cancellationSignal) {
            if (!this.mSpecialEffectsSignals.remove(cancellationSignal) || !this.mSpecialEffectsSignals.isEmpty()) {
                return;
            }
            complete();
        }

        @NonNull
        public State getFinalState() {
            return this.mFinalState;
        }

        @NonNull
        public final Fragment getFragment() {
            return this.mFragment;
        }

        @NonNull
        public LifecycleImpact getLifecycleImpact() {
            return this.mLifecycleImpact;
        }

        public final boolean isCanceled() {
            return this.mIsCanceled;
        }

        public final boolean isComplete() {
            return this.mIsComplete;
        }

        public final void markStartedSpecialEffect(@NonNull CancellationSignal cancellationSignal) {
            onStart();
            this.mSpecialEffectsSignals.add(cancellationSignal);
        }

        public final void mergeWith(@NonNull State state, @NonNull LifecycleImpact lifecycleImpact) {
            LifecycleImpact lifecycleImpact2;
            int ordinal = lifecycleImpact.ordinal();
            if (ordinal == 0) {
                if (this.mFinalState == State.REMOVED) {
                    return;
                }
                if (FragmentManager.isLoggingEnabled(2)) {
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("SpecialEffectsController: For fragment ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mFragment);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" mFinalState = ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mFinalState);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" -> ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(state);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(". ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
                }
                this.mFinalState = state;
                return;
            }
            if (ordinal != 1) {
                if (ordinal != 2) {
                    return;
                }
                if (FragmentManager.isLoggingEnabled(2)) {
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("SpecialEffectsController: For fragment ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.mFragment);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(" mFinalState = ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.mFinalState);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(" -> REMOVED. mLifecycleImpact  = ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.mLifecycleImpact);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(" to REMOVING.");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
                }
                this.mFinalState = State.REMOVED;
                lifecycleImpact2 = LifecycleImpact.REMOVING;
            } else if (this.mFinalState != State.REMOVED) {
                return;
            } else {
                if (FragmentManager.isLoggingEnabled(2)) {
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("SpecialEffectsController: For fragment ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(this.mFragment);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(" mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(this.mLifecycleImpact);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(" to ADDING.");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString();
                }
                this.mFinalState = State.VISIBLE;
                lifecycleImpact2 = LifecycleImpact.ADDING;
            }
            this.mLifecycleImpact = lifecycleImpact2;
        }

        public void onStart() {
        }

        @NonNull
        public String toString() {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Operation ", "{");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Integer.toHexString(System.identityHashCode(this)));
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("} ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("{");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("mFinalState = ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mFinalState);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("} ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("{");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("mLifecycleImpact = ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mLifecycleImpact);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("} ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("{");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("mFragment = ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mFragment);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("}");
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
    }

    public SpecialEffectsController(@NonNull ViewGroup viewGroup) {
        this.mContainer = viewGroup;
    }

    private void enqueue(@NonNull Operation.State state, @NonNull Operation.LifecycleImpact lifecycleImpact, @NonNull FragmentStateManager fragmentStateManager) {
        synchronized (this.mPendingOperations) {
            CancellationSignal cancellationSignal = new CancellationSignal();
            Operation findPendingOperation = findPendingOperation(fragmentStateManager.getFragment());
            if (findPendingOperation != null) {
                findPendingOperation.mergeWith(state, lifecycleImpact);
                return;
            }
            final FragmentStateManagerOperation fragmentStateManagerOperation = new FragmentStateManagerOperation(state, lifecycleImpact, fragmentStateManager, cancellationSignal);
            this.mPendingOperations.add(fragmentStateManagerOperation);
            fragmentStateManagerOperation.addCompletionListener(new Runnable() { // from class: androidx.fragment.app.SpecialEffectsController.1
                @Override // java.lang.Runnable
                public void run() {
                    if (SpecialEffectsController.this.mPendingOperations.contains(fragmentStateManagerOperation)) {
                        fragmentStateManagerOperation.getFinalState().applyState(fragmentStateManagerOperation.getFragment().mView);
                    }
                }
            });
            fragmentStateManagerOperation.addCompletionListener(new Runnable() { // from class: androidx.fragment.app.SpecialEffectsController.2
                @Override // java.lang.Runnable
                public void run() {
                    SpecialEffectsController.this.mPendingOperations.remove(fragmentStateManagerOperation);
                    SpecialEffectsController.this.mRunningOperations.remove(fragmentStateManagerOperation);
                }
            });
        }
    }

    @Nullable
    private Operation findPendingOperation(@NonNull Fragment fragment) {
        Iterator<Operation> it = this.mPendingOperations.iterator();
        while (it.hasNext()) {
            Operation next = it.next();
            if (next.getFragment().equals(fragment) && !next.isCanceled()) {
                return next;
            }
        }
        return null;
    }

    @Nullable
    private Operation findRunningOperation(@NonNull Fragment fragment) {
        Iterator<Operation> it = this.mRunningOperations.iterator();
        while (it.hasNext()) {
            Operation next = it.next();
            if (next.getFragment().equals(fragment) && !next.isCanceled()) {
                return next;
            }
        }
        return null;
    }

    @NonNull
    public static SpecialEffectsController getOrCreateController(@NonNull ViewGroup viewGroup, @NonNull FragmentManager fragmentManager) {
        return getOrCreateController(viewGroup, fragmentManager.getSpecialEffectsControllerFactory());
    }

    @NonNull
    public static SpecialEffectsController getOrCreateController(@NonNull ViewGroup viewGroup, @NonNull SpecialEffectsControllerFactory specialEffectsControllerFactory) {
        Object tag = viewGroup.getTag(C0298R.C0301id.special_effects_controller_view_tag);
        if (tag instanceof SpecialEffectsController) {
            return (SpecialEffectsController) tag;
        }
        SpecialEffectsController createController = specialEffectsControllerFactory.createController(viewGroup);
        viewGroup.setTag(C0298R.C0301id.special_effects_controller_view_tag, createController);
        return createController;
    }

    private void updateFinalState() {
        Iterator<Operation> it = this.mPendingOperations.iterator();
        while (it.hasNext()) {
            Operation next = it.next();
            if (next.getLifecycleImpact() == Operation.LifecycleImpact.ADDING) {
                next.mergeWith(Operation.State.from(next.getFragment().requireView().getVisibility()), Operation.LifecycleImpact.NONE);
            }
        }
    }

    public void enqueueAdd(@NonNull Operation.State state, @NonNull FragmentStateManager fragmentStateManager) {
        if (FragmentManager.isLoggingEnabled(2)) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("SpecialEffectsController: Enqueuing add operation for fragment ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(fragmentStateManager.getFragment());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
        enqueue(state, Operation.LifecycleImpact.ADDING, fragmentStateManager);
    }

    public void enqueueHide(@NonNull FragmentStateManager fragmentStateManager) {
        if (FragmentManager.isLoggingEnabled(2)) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("SpecialEffectsController: Enqueuing hide operation for fragment ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(fragmentStateManager.getFragment());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
        enqueue(Operation.State.GONE, Operation.LifecycleImpact.NONE, fragmentStateManager);
    }

    public void enqueueRemove(@NonNull FragmentStateManager fragmentStateManager) {
        if (FragmentManager.isLoggingEnabled(2)) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("SpecialEffectsController: Enqueuing remove operation for fragment ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(fragmentStateManager.getFragment());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
        enqueue(Operation.State.REMOVED, Operation.LifecycleImpact.REMOVING, fragmentStateManager);
    }

    public void enqueueShow(@NonNull FragmentStateManager fragmentStateManager) {
        if (FragmentManager.isLoggingEnabled(2)) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("SpecialEffectsController: Enqueuing show operation for fragment ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(fragmentStateManager.getFragment());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
        enqueue(Operation.State.VISIBLE, Operation.LifecycleImpact.NONE, fragmentStateManager);
    }

    public abstract void executeOperations(@NonNull List<Operation> list, boolean z);

    public void executePendingOperations() {
        if (this.mIsContainerPostponed) {
            return;
        }
        if (!ViewCompat.isAttachedToWindow(this.mContainer)) {
            forceCompleteAllOperations();
            this.mOperationDirectionIsPop = false;
            return;
        }
        synchronized (this.mPendingOperations) {
            if (!this.mPendingOperations.isEmpty()) {
                ArrayList arrayList = new ArrayList(this.mRunningOperations);
                this.mRunningOperations.clear();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Operation operation = (Operation) it.next();
                    if (FragmentManager.isLoggingEnabled(2)) {
                        String str = "SpecialEffectsController: Cancelling operation " + operation;
                    }
                    operation.cancel();
                    if (!operation.isComplete()) {
                        this.mRunningOperations.add(operation);
                    }
                }
                updateFinalState();
                ArrayList arrayList2 = new ArrayList(this.mPendingOperations);
                this.mPendingOperations.clear();
                this.mRunningOperations.addAll(arrayList2);
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    ((Operation) it2.next()).onStart();
                }
                executeOperations(arrayList2, this.mOperationDirectionIsPop);
                this.mOperationDirectionIsPop = false;
            }
        }
    }

    public void forceCompleteAllOperations() {
        String str;
        String str2;
        boolean isAttachedToWindow = ViewCompat.isAttachedToWindow(this.mContainer);
        synchronized (this.mPendingOperations) {
            updateFinalState();
            Iterator<Operation> it = this.mPendingOperations.iterator();
            while (it.hasNext()) {
                it.next().onStart();
            }
            Iterator it2 = new ArrayList(this.mRunningOperations).iterator();
            while (it2.hasNext()) {
                Operation operation = (Operation) it2.next();
                if (FragmentManager.isLoggingEnabled(2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("SpecialEffectsController: ");
                    if (isAttachedToWindow) {
                        str2 = "";
                    } else {
                        str2 = "Container " + this.mContainer + " is not attached to window. ";
                    }
                    sb.append(str2);
                    sb.append("Cancelling running operation ");
                    sb.append(operation);
                    sb.toString();
                }
                operation.cancel();
            }
            Iterator it3 = new ArrayList(this.mPendingOperations).iterator();
            while (it3.hasNext()) {
                Operation operation2 = (Operation) it3.next();
                if (FragmentManager.isLoggingEnabled(2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("SpecialEffectsController: ");
                    if (isAttachedToWindow) {
                        str = "";
                    } else {
                        str = "Container " + this.mContainer + " is not attached to window. ";
                    }
                    sb2.append(str);
                    sb2.append("Cancelling pending operation ");
                    sb2.append(operation2);
                    sb2.toString();
                }
                operation2.cancel();
            }
        }
    }

    public void forcePostponedExecutePendingOperations() {
        if (this.mIsContainerPostponed) {
            this.mIsContainerPostponed = false;
            executePendingOperations();
        }
    }

    @Nullable
    public Operation.LifecycleImpact getAwaitingCompletionLifecycleImpact(@NonNull FragmentStateManager fragmentStateManager) {
        Operation findPendingOperation = findPendingOperation(fragmentStateManager.getFragment());
        if (findPendingOperation != null) {
            return findPendingOperation.getLifecycleImpact();
        }
        Operation findRunningOperation = findRunningOperation(fragmentStateManager.getFragment());
        if (findRunningOperation == null) {
            return null;
        }
        return findRunningOperation.getLifecycleImpact();
    }

    @NonNull
    public ViewGroup getContainer() {
        return this.mContainer;
    }

    public void markPostponedState() {
        synchronized (this.mPendingOperations) {
            updateFinalState();
            this.mIsContainerPostponed = false;
            int size = this.mPendingOperations.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                }
                Operation operation = this.mPendingOperations.get(size);
                Operation.State from = Operation.State.from(operation.getFragment().mView);
                if (operation.getFinalState() == Operation.State.VISIBLE && from != Operation.State.VISIBLE) {
                    this.mIsContainerPostponed = operation.getFragment().isPostponed();
                    break;
                }
                size--;
            }
        }
    }

    public void updateOperationDirection(boolean z) {
        this.mOperationDirectionIsPop = z;
    }
}
