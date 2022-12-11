package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.core.app.SharedElementCallback;
import androidx.core.p003os.CancellationSignal;
import androidx.core.util.Preconditions;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentAnim;
import androidx.fragment.app.SpecialEffectsController;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public class DefaultSpecialEffectsController extends SpecialEffectsController {

    /* renamed from: androidx.fragment.app.DefaultSpecialEffectsController$10 */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class C030410 {

        /* renamed from: $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State */
        public static final /* synthetic */ int[] f62xe493b431;

        static {
            int[] iArr = new int[SpecialEffectsController.Operation.State.values().length];
            f62xe493b431 = iArr;
            try {
                SpecialEffectsController.Operation.State state = SpecialEffectsController.Operation.State.GONE;
                iArr[2] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = f62xe493b431;
                SpecialEffectsController.Operation.State state2 = SpecialEffectsController.Operation.State.INVISIBLE;
                iArr2[3] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = f62xe493b431;
                SpecialEffectsController.Operation.State state3 = SpecialEffectsController.Operation.State.REMOVED;
                iArr3[0] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                int[] iArr4 = f62xe493b431;
                SpecialEffectsController.Operation.State state4 = SpecialEffectsController.Operation.State.VISIBLE;
                iArr4[1] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class AnimationInfo extends SpecialEffectsInfo {
        @Nullable
        public FragmentAnim.AnimationOrAnimator mAnimation;
        public boolean mIsPop;
        public boolean mLoadedAnim = false;

        public AnimationInfo(@NonNull SpecialEffectsController.Operation operation, @NonNull CancellationSignal cancellationSignal, boolean z) {
            super(operation, cancellationSignal);
            this.mIsPop = z;
        }

        @Nullable
        public FragmentAnim.AnimationOrAnimator getAnimation(@NonNull Context context) {
            if (this.mLoadedAnim) {
                return this.mAnimation;
            }
            FragmentAnim.AnimationOrAnimator loadAnimation = FragmentAnim.loadAnimation(context, getOperation().getFragment(), getOperation().getFinalState() == SpecialEffectsController.Operation.State.VISIBLE, this.mIsPop);
            this.mAnimation = loadAnimation;
            this.mLoadedAnim = true;
            return loadAnimation;
        }
    }

    /* loaded from: classes3.dex */
    public static class SpecialEffectsInfo {
        @NonNull
        public final SpecialEffectsController.Operation mOperation;
        @NonNull
        public final CancellationSignal mSignal;

        public SpecialEffectsInfo(@NonNull SpecialEffectsController.Operation operation, @NonNull CancellationSignal cancellationSignal) {
            this.mOperation = operation;
            this.mSignal = cancellationSignal;
        }

        public void completeSpecialEffect() {
            this.mOperation.completeSpecialEffect(this.mSignal);
        }

        @NonNull
        public SpecialEffectsController.Operation getOperation() {
            return this.mOperation;
        }

        @NonNull
        public CancellationSignal getSignal() {
            return this.mSignal;
        }

        public boolean isVisibilityUnchanged() {
            SpecialEffectsController.Operation.State state;
            SpecialEffectsController.Operation.State from = SpecialEffectsController.Operation.State.from(this.mOperation.getFragment().mView);
            SpecialEffectsController.Operation.State finalState = this.mOperation.getFinalState();
            return from == finalState || !(from == (state = SpecialEffectsController.Operation.State.VISIBLE) || finalState == state);
        }
    }

    /* loaded from: classes3.dex */
    public static class TransitionInfo extends SpecialEffectsInfo {
        public final boolean mOverlapAllowed;
        @Nullable
        public final Object mSharedElementTransition;
        @Nullable
        public final Object mTransition;

        public TransitionInfo(@NonNull SpecialEffectsController.Operation operation, @NonNull CancellationSignal cancellationSignal, boolean z, boolean z2) {
            super(operation, cancellationSignal);
            boolean z3;
            Object obj;
            if (operation.getFinalState() == SpecialEffectsController.Operation.State.VISIBLE) {
                Fragment fragment = operation.getFragment();
                this.mTransition = z ? fragment.getReenterTransition() : fragment.getEnterTransition();
                Fragment fragment2 = operation.getFragment();
                z3 = z ? fragment2.getAllowReturnTransitionOverlap() : fragment2.getAllowEnterTransitionOverlap();
            } else {
                Fragment fragment3 = operation.getFragment();
                this.mTransition = z ? fragment3.getReturnTransition() : fragment3.getExitTransition();
                z3 = true;
            }
            this.mOverlapAllowed = z3;
            if (z2) {
                Fragment fragment4 = operation.getFragment();
                obj = z ? fragment4.getSharedElementReturnTransition() : fragment4.getSharedElementEnterTransition();
            } else {
                obj = null;
            }
            this.mSharedElementTransition = obj;
        }

        @Nullable
        private FragmentTransitionImpl getHandlingImpl(Object obj) {
            if (obj == null) {
                return null;
            }
            FragmentTransitionImpl fragmentTransitionImpl = FragmentTransition.PLATFORM_IMPL;
            if (fragmentTransitionImpl != null && fragmentTransitionImpl.canHandle(obj)) {
                return FragmentTransition.PLATFORM_IMPL;
            }
            FragmentTransitionImpl fragmentTransitionImpl2 = FragmentTransition.SUPPORT_IMPL;
            if (fragmentTransitionImpl2 != null && fragmentTransitionImpl2.canHandle(obj)) {
                return FragmentTransition.SUPPORT_IMPL;
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + getOperation().getFragment() + " is not a valid framework Transition or AndroidX Transition");
        }

        @Nullable
        public FragmentTransitionImpl getHandlingImpl() {
            FragmentTransitionImpl handlingImpl = getHandlingImpl(this.mTransition);
            FragmentTransitionImpl handlingImpl2 = getHandlingImpl(this.mSharedElementTransition);
            if (handlingImpl == null || handlingImpl2 == null || handlingImpl == handlingImpl2) {
                return handlingImpl != null ? handlingImpl : handlingImpl2;
            }
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Mixing framework transitions and AndroidX transitions is not allowed. Fragment ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getOperation().getFragment());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" returned Transition ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mTransition);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" which uses a different Transition  type than its shared element transition ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mSharedElementTransition);
            throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }

        @Nullable
        public Object getSharedElementTransition() {
            return this.mSharedElementTransition;
        }

        @Nullable
        public Object getTransition() {
            return this.mTransition;
        }

        public boolean hasSharedElementTransition() {
            return this.mSharedElementTransition != null;
        }

        public boolean isOverlapAllowed() {
            return this.mOverlapAllowed;
        }
    }

    public DefaultSpecialEffectsController(@NonNull ViewGroup viewGroup) {
        super(viewGroup);
    }

    private void startAnimations(@NonNull List<AnimationInfo> list, @NonNull List<SpecialEffectsController.Operation> list2, boolean z, @NonNull Map<SpecialEffectsController.Operation, Boolean> map) {
        StringBuilder sb;
        String str;
        FragmentAnim.AnimationOrAnimator animation;
        final ViewGroup container = getContainer();
        Context context = container.getContext();
        ArrayList arrayList = new ArrayList();
        boolean z2 = false;
        for (final AnimationInfo animationInfo : list) {
            if (!animationInfo.isVisibilityUnchanged() && (animation = animationInfo.getAnimation(context)) != null) {
                final Animator animator = animation.animator;
                if (animator == null) {
                    arrayList.add(animationInfo);
                } else {
                    final SpecialEffectsController.Operation operation = animationInfo.getOperation();
                    Fragment fragment = operation.getFragment();
                    if (Boolean.TRUE.equals(map.get(operation))) {
                        if (FragmentManager.isLoggingEnabled(2)) {
                            String str2 = "Ignoring Animator set on " + fragment + " as this Fragment was involved in a Transition.";
                        }
                        animationInfo.completeSpecialEffect();
                    } else {
                        final boolean z3 = operation.getFinalState() == SpecialEffectsController.Operation.State.GONE;
                        if (z3) {
                            list2.remove(operation);
                        }
                        final View view = fragment.mView;
                        container.startViewTransition(view);
                        animator.addListener(new AnimatorListenerAdapter() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.2
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator2) {
                                container.endViewTransition(view);
                                if (z3) {
                                    operation.getFinalState().applyState(view);
                                }
                                animationInfo.completeSpecialEffect();
                            }
                        });
                        animator.setTarget(view);
                        animator.start();
                        animationInfo.getSignal().setOnCancelListener(new CancellationSignal.OnCancelListener() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.3
                            @Override // androidx.core.p003os.CancellationSignal.OnCancelListener
                            public void onCancel() {
                                animator.end();
                            }
                        });
                        z2 = true;
                    }
                }
            } else {
                animationInfo.completeSpecialEffect();
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            final AnimationInfo animationInfo2 = (AnimationInfo) it.next();
            SpecialEffectsController.Operation operation2 = animationInfo2.getOperation();
            Fragment fragment2 = operation2.getFragment();
            if (z) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    sb = new StringBuilder();
                    sb.append("Ignoring Animation set on ");
                    sb.append(fragment2);
                    str = " as Animations cannot run alongside Transitions.";
                    sb.append(str);
                    sb.toString();
                }
                animationInfo2.completeSpecialEffect();
            } else if (z2) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    sb = new StringBuilder();
                    sb.append("Ignoring Animation set on ");
                    sb.append(fragment2);
                    str = " as Animations cannot run alongside Animators.";
                    sb.append(str);
                    sb.toString();
                }
                animationInfo2.completeSpecialEffect();
            } else {
                final View view2 = fragment2.mView;
                Animation animation2 = (Animation) Preconditions.checkNotNull(((FragmentAnim.AnimationOrAnimator) Preconditions.checkNotNull(animationInfo2.getAnimation(context))).animation);
                if (operation2.getFinalState() != SpecialEffectsController.Operation.State.REMOVED) {
                    view2.startAnimation(animation2);
                    animationInfo2.completeSpecialEffect();
                } else {
                    container.startViewTransition(view2);
                    FragmentAnim.EndViewTransitionAnimation endViewTransitionAnimation = new FragmentAnim.EndViewTransitionAnimation(animation2, container, view2);
                    endViewTransitionAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.4
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation3) {
                            container.post(new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    animationAnimation$AnimationListenerC03074 animationanimation_animationlistenerc03074 = animationAnimation$AnimationListenerC03074.this;
                                    container.endViewTransition(view2);
                                    animationInfo2.completeSpecialEffect();
                                }
                            });
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation3) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation3) {
                        }
                    });
                    view2.startAnimation(endViewTransitionAnimation);
                }
                animationInfo2.getSignal().setOnCancelListener(new CancellationSignal.OnCancelListener() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.5
                    @Override // androidx.core.p003os.CancellationSignal.OnCancelListener
                    public void onCancel() {
                        view2.clearAnimation();
                        container.endViewTransition(view2);
                        animationInfo2.completeSpecialEffect();
                    }
                });
            }
        }
    }

    @NonNull
    private Map<SpecialEffectsController.Operation, Boolean> startTransitions(@NonNull List<TransitionInfo> list, @NonNull List<SpecialEffectsController.Operation> list2, final boolean z, @Nullable final SpecialEffectsController.Operation operation, @Nullable final SpecialEffectsController.Operation operation2) {
        Object obj;
        Object obj2;
        View view;
        ArrayList arrayList;
        Rect rect;
        HashMap hashMap;
        Object obj3;
        final ArrayList<View> arrayList2;
        View view2;
        ArrayList arrayList3;
        Rect rect2;
        View view3;
        HashMap hashMap2;
        Object obj4;
        View view4;
        ArrayMap arrayMap;
        ArrayList<View> arrayList4;
        ArrayList<View> arrayList5;
        FragmentTransitionImpl fragmentTransitionImpl;
        HashMap hashMap3;
        Rect rect3;
        View view5;
        SharedElementCallback enterTransitionCallback;
        SharedElementCallback exitTransitionCallback;
        ArrayList<String> arrayList6;
        final View view6;
        String findKeyForValue;
        ArrayList<String> arrayList7;
        boolean z2 = z;
        HashMap hashMap4 = new HashMap();
        final FragmentTransitionImpl fragmentTransitionImpl2 = null;
        for (TransitionInfo transitionInfo : list) {
            if (!transitionInfo.isVisibilityUnchanged()) {
                FragmentTransitionImpl handlingImpl = transitionInfo.getHandlingImpl();
                if (fragmentTransitionImpl2 == null) {
                    fragmentTransitionImpl2 = handlingImpl;
                } else if (handlingImpl != null && fragmentTransitionImpl2 != handlingImpl) {
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Mixing framework transitions and AndroidX transitions is not allowed. Fragment ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(transitionInfo.getOperation().getFragment());
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" returned Transition ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(transitionInfo.getTransition());
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" which uses a different Transition  type than other Fragments.");
                    throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                }
            }
        }
        if (fragmentTransitionImpl2 == null) {
            for (TransitionInfo transitionInfo2 : list) {
                hashMap4.put(transitionInfo2.getOperation(), false);
                transitionInfo2.completeSpecialEffect();
            }
            return hashMap4;
        }
        View view7 = new View(getContainer().getContext());
        final Rect rect4 = new Rect();
        ArrayList<View> arrayList8 = new ArrayList<>();
        ArrayList<View> arrayList9 = new ArrayList<>();
        ArrayMap arrayMap2 = new ArrayMap();
        Object obj5 = null;
        SpecialEffectsController.Operation operation3 = operation;
        View view8 = null;
        boolean z3 = false;
        SpecialEffectsController.Operation operation4 = operation2;
        for (TransitionInfo transitionInfo3 : list) {
            if (!transitionInfo3.hasSharedElementTransition() || operation3 == null || operation4 == null) {
                view4 = view8;
                arrayMap = arrayMap2;
                arrayList4 = arrayList9;
                arrayList5 = arrayList8;
                fragmentTransitionImpl = fragmentTransitionImpl2;
            } else {
                Object wrapTransitionInSet = fragmentTransitionImpl2.wrapTransitionInSet(fragmentTransitionImpl2.cloneTransition(transitionInfo3.getSharedElementTransition()));
                ArrayList<String> sharedElementSourceNames = operation2.getFragment().getSharedElementSourceNames();
                ArrayList<String> sharedElementSourceNames2 = operation.getFragment().getSharedElementSourceNames();
                ArrayList<String> sharedElementTargetNames = operation.getFragment().getSharedElementTargetNames();
                int i = 0;
                while (i < sharedElementTargetNames.size()) {
                    int indexOf = sharedElementSourceNames.indexOf(sharedElementTargetNames.get(i));
                    ArrayList<String> arrayList10 = sharedElementTargetNames;
                    if (indexOf != -1) {
                        sharedElementSourceNames.set(indexOf, sharedElementSourceNames2.get(i));
                    }
                    i++;
                    sharedElementTargetNames = arrayList10;
                }
                ArrayList<String> sharedElementTargetNames2 = operation2.getFragment().getSharedElementTargetNames();
                Fragment fragment = operation.getFragment();
                if (!z2) {
                    enterTransitionCallback = fragment.getExitTransitionCallback();
                    exitTransitionCallback = operation2.getFragment().getEnterTransitionCallback();
                } else {
                    enterTransitionCallback = fragment.getEnterTransitionCallback();
                    exitTransitionCallback = operation2.getFragment().getExitTransitionCallback();
                }
                int size = sharedElementSourceNames.size();
                int i2 = 0;
                while (i2 < size) {
                    arrayMap2.put(sharedElementSourceNames.get(i2), sharedElementTargetNames2.get(i2));
                    i2++;
                    size = size;
                    view8 = view8;
                }
                view4 = view8;
                ArrayMap<String, View> arrayMap3 = new ArrayMap<>();
                findNamedViews(arrayMap3, operation.getFragment().mView);
                arrayMap3.retainAll(sharedElementSourceNames);
                if (enterTransitionCallback != null) {
                    enterTransitionCallback.onMapSharedElements(sharedElementSourceNames, arrayMap3);
                    int size2 = sharedElementSourceNames.size() - 1;
                    while (size2 >= 0) {
                        String str = sharedElementSourceNames.get(size2);
                        View view9 = arrayMap3.get(str);
                        if (view9 == null) {
                            arrayMap2.remove(str);
                            arrayList7 = sharedElementSourceNames;
                        } else {
                            arrayList7 = sharedElementSourceNames;
                            if (!str.equals(ViewCompat.getTransitionName(view9))) {
                                arrayMap2.put(ViewCompat.getTransitionName(view9), (String) arrayMap2.remove(str));
                            }
                        }
                        size2--;
                        sharedElementSourceNames = arrayList7;
                    }
                    arrayList6 = sharedElementSourceNames;
                } else {
                    arrayList6 = sharedElementSourceNames;
                    arrayMap2.retainAll(arrayMap3.keySet());
                }
                final ArrayMap<String, View> arrayMap4 = new ArrayMap<>();
                findNamedViews(arrayMap4, operation2.getFragment().mView);
                arrayMap4.retainAll(sharedElementTargetNames2);
                arrayMap4.retainAll(arrayMap2.values());
                if (exitTransitionCallback != null) {
                    exitTransitionCallback.onMapSharedElements(sharedElementTargetNames2, arrayMap4);
                    for (int size3 = sharedElementTargetNames2.size() - 1; size3 >= 0; size3--) {
                        String str2 = sharedElementTargetNames2.get(size3);
                        View view10 = arrayMap4.get(str2);
                        if (view10 == null) {
                            String findKeyForValue2 = FragmentTransition.findKeyForValue(arrayMap2, str2);
                            if (findKeyForValue2 != null) {
                                arrayMap2.remove(findKeyForValue2);
                            }
                        } else if (!str2.equals(ViewCompat.getTransitionName(view10)) && (findKeyForValue = FragmentTransition.findKeyForValue(arrayMap2, str2)) != null) {
                            arrayMap2.put(findKeyForValue, ViewCompat.getTransitionName(view10));
                        }
                    }
                } else {
                    FragmentTransition.retainValues(arrayMap2, arrayMap4);
                }
                retainMatchingViews(arrayMap3, arrayMap2.keySet());
                retainMatchingViews(arrayMap4, arrayMap2.values());
                if (arrayMap2.isEmpty()) {
                    arrayList8.clear();
                    arrayList9.clear();
                    obj5 = null;
                    operation3 = operation;
                    operation4 = operation2;
                    arrayMap = arrayMap2;
                    arrayList4 = arrayList9;
                    arrayList5 = arrayList8;
                    fragmentTransitionImpl = fragmentTransitionImpl2;
                } else {
                    FragmentTransition.callSharedElementStartEnd(operation2.getFragment(), operation.getFragment(), z2, arrayMap3, true);
                    ArrayList<String> arrayList11 = arrayList6;
                    ArrayMap arrayMap5 = arrayMap2;
                    HashMap hashMap5 = hashMap4;
                    OneShotPreDrawListener.add(getContainer(), new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.6
                        @Override // java.lang.Runnable
                        public void run() {
                            FragmentTransition.callSharedElementStartEnd(operation2.getFragment(), operation.getFragment(), z, arrayMap4, false);
                        }
                    });
                    for (View view11 : arrayMap3.values()) {
                        captureTransitioningViews(arrayList8, view11);
                    }
                    if (!arrayList11.isEmpty()) {
                        View view12 = arrayMap3.get(arrayList11.get(0));
                        fragmentTransitionImpl2.setEpicenter(wrapTransitionInSet, view12);
                        view4 = view12;
                    }
                    for (View view13 : arrayMap4.values()) {
                        captureTransitioningViews(arrayList9, view13);
                    }
                    if (!sharedElementTargetNames2.isEmpty() && (view6 = arrayMap4.get(sharedElementTargetNames2.get(0))) != null) {
                        OneShotPreDrawListener.add(getContainer(), new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.7
                            @Override // java.lang.Runnable
                            public void run() {
                                fragmentTransitionImpl2.getBoundsOnScreen(view6, rect4);
                            }
                        });
                        z3 = true;
                    }
                    fragmentTransitionImpl2.setSharedElementTargets(wrapTransitionInSet, view7, arrayList8);
                    arrayMap = arrayMap5;
                    arrayList4 = arrayList9;
                    arrayList5 = arrayList8;
                    View view14 = view7;
                    fragmentTransitionImpl = fragmentTransitionImpl2;
                    fragmentTransitionImpl2.scheduleRemoveTargets(wrapTransitionInSet, null, null, null, null, wrapTransitionInSet, arrayList4);
                    hashMap3 = hashMap5;
                    hashMap3.put(operation, true);
                    hashMap3.put(operation2, true);
                    rect3 = rect4;
                    obj5 = wrapTransitionInSet;
                    operation3 = operation;
                    view5 = view14;
                    operation4 = operation2;
                    arrayMap2 = arrayMap;
                    arrayList9 = arrayList4;
                    arrayList8 = arrayList5;
                    rect4 = rect3;
                    view8 = view4;
                    z2 = z;
                    view7 = view5;
                    hashMap4 = hashMap3;
                    fragmentTransitionImpl2 = fragmentTransitionImpl;
                }
            }
            hashMap3 = hashMap4;
            view5 = view7;
            rect3 = rect4;
            arrayMap2 = arrayMap;
            arrayList9 = arrayList4;
            arrayList8 = arrayList5;
            rect4 = rect3;
            view8 = view4;
            z2 = z;
            view7 = view5;
            hashMap4 = hashMap3;
            fragmentTransitionImpl2 = fragmentTransitionImpl;
        }
        View view15 = view8;
        ArrayMap arrayMap6 = arrayMap2;
        ArrayList<View> arrayList12 = arrayList9;
        ArrayList<View> arrayList13 = arrayList8;
        FragmentTransitionImpl fragmentTransitionImpl3 = fragmentTransitionImpl2;
        HashMap hashMap6 = hashMap4;
        View view16 = view7;
        Rect rect5 = rect4;
        boolean z4 = false;
        ArrayList arrayList14 = new ArrayList();
        Object obj6 = null;
        Object obj7 = null;
        for (TransitionInfo transitionInfo4 : list) {
            if (transitionInfo4.isVisibilityUnchanged()) {
                hashMap6.put(transitionInfo4.getOperation(), Boolean.valueOf(z4));
                transitionInfo4.completeSpecialEffect();
                obj6 = obj6;
            } else {
                Object obj8 = obj6;
                Object cloneTransition = fragmentTransitionImpl3.cloneTransition(transitionInfo4.getTransition());
                SpecialEffectsController.Operation operation5 = transitionInfo4.getOperation();
                boolean z5 = obj5 != null && (operation5 == operation3 || operation5 == operation4);
                if (cloneTransition == null) {
                    if (!z5) {
                        hashMap6.put(operation5, Boolean.valueOf(z4));
                        transitionInfo4.completeSpecialEffect();
                    }
                    obj4 = obj8;
                    view3 = view16;
                    rect2 = rect5;
                    hashMap2 = hashMap6;
                    arrayList3 = arrayList14;
                    view2 = view15;
                } else {
                    ArrayList<View> arrayList15 = new ArrayList<>();
                    Object obj9 = obj7;
                    captureTransitioningViews(arrayList15, operation5.getFragment().mView);
                    if (z5) {
                        if (operation5 == operation3) {
                            arrayList15.removeAll(arrayList13);
                        } else {
                            arrayList15.removeAll(arrayList12);
                        }
                    }
                    if (arrayList15.isEmpty()) {
                        fragmentTransitionImpl3.addTarget(cloneTransition, view16);
                        obj = obj8;
                        obj2 = obj9;
                        obj3 = cloneTransition;
                        arrayList = arrayList14;
                        rect = rect5;
                        hashMap = hashMap6;
                        view = view15;
                        arrayList2 = arrayList15;
                    } else {
                        fragmentTransitionImpl3.addTargets(cloneTransition, arrayList15);
                        obj = obj8;
                        obj2 = obj9;
                        view = view15;
                        arrayList = arrayList14;
                        rect = rect5;
                        hashMap = hashMap6;
                        fragmentTransitionImpl3.scheduleRemoveTargets(cloneTransition, cloneTransition, arrayList15, null, null, null, null);
                        if (operation5.getFinalState() == SpecialEffectsController.Operation.State.GONE) {
                            operation5 = operation5;
                            list2.remove(operation5);
                            obj3 = cloneTransition;
                            arrayList2 = arrayList15;
                            fragmentTransitionImpl3.scheduleHideFragmentView(obj3, operation5.getFragment().mView, arrayList2);
                            OneShotPreDrawListener.add(getContainer(), new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.8
                                @Override // java.lang.Runnable
                                public void run() {
                                    FragmentTransition.setViewVisibility(arrayList2, 4);
                                }
                            });
                        } else {
                            obj3 = cloneTransition;
                            arrayList2 = arrayList15;
                            operation5 = operation5;
                        }
                    }
                    if (operation5.getFinalState() == SpecialEffectsController.Operation.State.VISIBLE) {
                        arrayList3 = arrayList;
                        arrayList3.addAll(arrayList2);
                        rect2 = rect;
                        if (z3) {
                            fragmentTransitionImpl3.setEpicenter(obj3, rect2);
                        }
                        view2 = view;
                    } else {
                        view2 = view;
                        arrayList3 = arrayList;
                        rect2 = rect;
                        fragmentTransitionImpl3.setEpicenter(obj3, view2);
                    }
                    view3 = view16;
                    hashMap2 = hashMap;
                    hashMap2.put(operation5, true);
                    if (transitionInfo4.isOverlapAllowed()) {
                        obj4 = fragmentTransitionImpl3.mergeTransitionsTogether(obj, obj3, null);
                        obj7 = obj2;
                    } else {
                        obj7 = fragmentTransitionImpl3.mergeTransitionsTogether(obj2, obj3, null);
                        obj4 = obj;
                    }
                }
                z4 = false;
                rect5 = rect2;
                view15 = view2;
                arrayList14 = arrayList3;
                hashMap6 = hashMap2;
                obj6 = obj4;
                view16 = view3;
            }
        }
        HashMap hashMap7 = hashMap6;
        ArrayList arrayList16 = arrayList14;
        Object mergeTransitionsInSequence = fragmentTransitionImpl3.mergeTransitionsInSequence(obj6, obj7, obj5);
        for (final TransitionInfo transitionInfo5 : list) {
            if (!transitionInfo5.isVisibilityUnchanged()) {
                Object transition = transitionInfo5.getTransition();
                SpecialEffectsController.Operation operation6 = transitionInfo5.getOperation();
                boolean z6 = obj5 != null && (operation6 == operation3 || operation6 == operation4);
                if (transition != null || z6) {
                    if (!ViewCompat.isLaidOut(getContainer())) {
                        if (FragmentManager.isLoggingEnabled(2)) {
                            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("SpecialEffectsController: Container ");
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(getContainer());
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(" has not been laid out. Completing operation ");
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(operation6);
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
                        }
                        transitionInfo5.completeSpecialEffect();
                    } else {
                        fragmentTransitionImpl3.setListenerForTransitionEnd(transitionInfo5.getOperation().getFragment(), mergeTransitionsInSequence, transitionInfo5.getSignal(), new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.9
                            @Override // java.lang.Runnable
                            public void run() {
                                transitionInfo5.completeSpecialEffect();
                            }
                        });
                    }
                }
            }
        }
        if (!ViewCompat.isLaidOut(getContainer())) {
            return hashMap7;
        }
        FragmentTransition.setViewVisibility(arrayList16, 4);
        ArrayList<String> prepareSetNameOverridesReordered = fragmentTransitionImpl3.prepareSetNameOverridesReordered(arrayList12);
        fragmentTransitionImpl3.beginDelayedTransition(getContainer(), mergeTransitionsInSequence);
        fragmentTransitionImpl3.setNameOverridesReordered(getContainer(), arrayList13, arrayList12, prepareSetNameOverridesReordered, arrayMap6);
        FragmentTransition.setViewVisibility(arrayList16, 0);
        fragmentTransitionImpl3.swapSharedElementTargets(obj5, arrayList13, arrayList12);
        return hashMap7;
    }

    public void applyContainerChanges(@NonNull SpecialEffectsController.Operation operation) {
        operation.getFinalState().applyState(operation.getFragment().mView);
    }

    public void captureTransitioningViews(ArrayList<View> arrayList, View view) {
        if (!(view instanceof ViewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(view);
            return;
        }
        if (!arrayList.contains(view) && ViewCompat.getTransitionName(view) != null) {
            arrayList.add(view);
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt.getVisibility() == 0) {
                captureTransitioningViews(arrayList, childAt);
            }
        }
    }

    @Override // androidx.fragment.app.SpecialEffectsController
    public void executeOperations(@NonNull List<SpecialEffectsController.Operation> list, boolean z) {
        SpecialEffectsController.Operation operation = null;
        SpecialEffectsController.Operation operation2 = null;
        for (SpecialEffectsController.Operation operation3 : list) {
            SpecialEffectsController.Operation.State from = SpecialEffectsController.Operation.State.from(operation3.getFragment().mView);
            int ordinal = operation3.getFinalState().ordinal();
            if (ordinal != 0) {
                if (ordinal != 1) {
                    if (ordinal != 2 && ordinal != 3) {
                    }
                } else if (from != SpecialEffectsController.Operation.State.VISIBLE) {
                    operation2 = operation3;
                }
            }
            if (from == SpecialEffectsController.Operation.State.VISIBLE && operation == null) {
                operation = operation3;
            }
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        final ArrayList arrayList3 = new ArrayList(list);
        for (final SpecialEffectsController.Operation operation4 : list) {
            CancellationSignal cancellationSignal = new CancellationSignal();
            operation4.markStartedSpecialEffect(cancellationSignal);
            arrayList.add(new AnimationInfo(operation4, cancellationSignal, z));
            CancellationSignal cancellationSignal2 = new CancellationSignal();
            operation4.markStartedSpecialEffect(cancellationSignal2);
            boolean z2 = false;
            if (z) {
                if (operation4 != operation) {
                    arrayList2.add(new TransitionInfo(operation4, cancellationSignal2, z, z2));
                    operation4.addCompletionListener(new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (arrayList3.contains(operation4)) {
                                arrayList3.remove(operation4);
                                DefaultSpecialEffectsController.this.applyContainerChanges(operation4);
                            }
                        }
                    });
                }
                z2 = true;
                arrayList2.add(new TransitionInfo(operation4, cancellationSignal2, z, z2));
                operation4.addCompletionListener(new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (arrayList3.contains(operation4)) {
                            arrayList3.remove(operation4);
                            DefaultSpecialEffectsController.this.applyContainerChanges(operation4);
                        }
                    }
                });
            } else {
                if (operation4 != operation2) {
                    arrayList2.add(new TransitionInfo(operation4, cancellationSignal2, z, z2));
                    operation4.addCompletionListener(new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (arrayList3.contains(operation4)) {
                                arrayList3.remove(operation4);
                                DefaultSpecialEffectsController.this.applyContainerChanges(operation4);
                            }
                        }
                    });
                }
                z2 = true;
                arrayList2.add(new TransitionInfo(operation4, cancellationSignal2, z, z2));
                operation4.addCompletionListener(new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (arrayList3.contains(operation4)) {
                            arrayList3.remove(operation4);
                            DefaultSpecialEffectsController.this.applyContainerChanges(operation4);
                        }
                    }
                });
            }
        }
        Map<SpecialEffectsController.Operation, Boolean> startTransitions = startTransitions(arrayList2, arrayList3, z, operation, operation2);
        startAnimations(arrayList, arrayList3, startTransitions.containsValue(true), startTransitions);
        Iterator it = arrayList3.iterator();
        while (it.hasNext()) {
            applyContainerChanges((SpecialEffectsController.Operation) it.next());
        }
        arrayList3.clear();
    }

    public void findNamedViews(Map<String, View> map, @NonNull View view) {
        String transitionName = ViewCompat.getTransitionName(view);
        if (transitionName != null) {
            map.put(transitionName, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    findNamedViews(map, childAt);
                }
            }
        }
    }

    public void retainMatchingViews(@NonNull ArrayMap<String, View> arrayMap, @NonNull Collection<String> collection) {
        Iterator<Map.Entry<String, View>> it = arrayMap.entrySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(ViewCompat.getTransitionName(it.next().getValue()))) {
                it.remove();
            }
        }
    }
}
