package androidx.transition;

import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.TypedArrayUtils;
import androidx.transition.Transition;
import java.util.ArrayList;
import java.util.Iterator;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public class TransitionSet extends Transition {
    public static final int FLAG_CHANGE_EPICENTER = 8;
    public static final int FLAG_CHANGE_INTERPOLATOR = 1;
    public static final int FLAG_CHANGE_PATH_MOTION = 4;
    public static final int FLAG_CHANGE_PROPAGATION = 2;
    public static final int ORDERING_SEQUENTIAL = 1;
    public static final int ORDERING_TOGETHER = 0;
    public int mCurrentListeners;
    public ArrayList<Transition> mTransitions = new ArrayList<>();
    public boolean mPlayTogether = true;
    public boolean mStarted = false;
    public int mChangeFlags = 0;

    /* loaded from: classes3.dex */
    public static class TransitionSetListener extends TransitionListenerAdapter {
        public TransitionSet mTransitionSet;

        public TransitionSetListener(TransitionSet transitionSet) {
            this.mTransitionSet = transitionSet;
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(@NonNull Transition transition) {
            TransitionSet transitionSet = this.mTransitionSet;
            int i = transitionSet.mCurrentListeners - 1;
            transitionSet.mCurrentListeners = i;
            if (i == 0) {
                transitionSet.mStarted = false;
                transitionSet.end();
            }
            transition.mo4381removeListener(this);
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionStart(@NonNull Transition transition) {
            TransitionSet transitionSet = this.mTransitionSet;
            if (!transitionSet.mStarted) {
                transitionSet.start();
                this.mTransitionSet.mStarted = true;
            }
        }
    }

    public TransitionSet() {
    }

    @SuppressLint({"RestrictedApi"})
    public TransitionSet(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.TRANSITION_SET);
        setOrdering(TypedArrayUtils.getNamedInt(obtainStyledAttributes, (XmlResourceParser) attributeSet, "transitionOrdering", 0, 0));
        obtainStyledAttributes.recycle();
    }

    private void addTransitionInternal(@NonNull Transition transition) {
        this.mTransitions.add(transition);
        transition.mParent = this;
    }

    private void setupStartEndListeners() {
        TransitionSetListener transitionSetListener = new TransitionSetListener(this);
        Iterator<Transition> it = this.mTransitions.iterator();
        while (it.hasNext()) {
            it.next().mo4375addListener(transitionSetListener);
        }
        this.mCurrentListeners = this.mTransitions.size();
    }

    @Override // androidx.transition.Transition
    @NonNull
    /* renamed from: addListener  reason: collision with other method in class */
    public TransitionSet mo4375addListener(@NonNull Transition.TransitionListener transitionListener) {
        return (TransitionSet) super.mo4375addListener(transitionListener);
    }

    @Override // androidx.transition.Transition
    @NonNull
    /* renamed from: addTarget */
    public /* bridge */ /* synthetic */ Transition mo4378addTarget(@NonNull Class cls) {
        return mo4378addTarget((Class<?>) cls);
    }

    @Override // androidx.transition.Transition
    @NonNull
    /* renamed from: addTarget  reason: collision with other method in class */
    public TransitionSet mo4376addTarget(@IdRes int i) {
        for (int i2 = 0; i2 < this.mTransitions.size(); i2++) {
            this.mTransitions.get(i2).mo4376addTarget(i);
        }
        return (TransitionSet) super.mo4376addTarget(i);
    }

    @Override // androidx.transition.Transition
    @NonNull
    /* renamed from: addTarget  reason: collision with other method in class */
    public TransitionSet mo4377addTarget(@NonNull View view) {
        for (int i = 0; i < this.mTransitions.size(); i++) {
            this.mTransitions.get(i).mo4377addTarget(view);
        }
        return (TransitionSet) super.mo4377addTarget(view);
    }

    @Override // androidx.transition.Transition
    @NonNull
    /* renamed from: addTarget  reason: collision with other method in class */
    public TransitionSet mo4378addTarget(@NonNull Class<?> cls) {
        for (int i = 0; i < this.mTransitions.size(); i++) {
            this.mTransitions.get(i).mo4378addTarget(cls);
        }
        return (TransitionSet) super.mo4378addTarget(cls);
    }

    @Override // androidx.transition.Transition
    @NonNull
    /* renamed from: addTarget  reason: collision with other method in class */
    public TransitionSet mo4379addTarget(@NonNull String str) {
        for (int i = 0; i < this.mTransitions.size(); i++) {
            this.mTransitions.get(i).mo4379addTarget(str);
        }
        return (TransitionSet) super.mo4379addTarget(str);
    }

    @NonNull
    public TransitionSet addTransition(@NonNull Transition transition) {
        addTransitionInternal(transition);
        long j = this.mDuration;
        if (j >= 0) {
            transition.mo4386setDuration(j);
        }
        if ((this.mChangeFlags & 1) != 0) {
            transition.mo4387setInterpolator(getInterpolator());
        }
        if ((this.mChangeFlags & 2) != 0) {
            transition.setPropagation(getPropagation());
        }
        if ((this.mChangeFlags & 4) != 0) {
            transition.setPathMotion(getPathMotion());
        }
        if ((this.mChangeFlags & 8) != 0) {
            transition.setEpicenterCallback(getEpicenterCallback());
        }
        return this;
    }

    @Override // androidx.transition.Transition
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void cancel() {
        super.cancel();
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i++) {
            this.mTransitions.get(i).cancel();
        }
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        if (isValidTarget(transitionValues.view)) {
            Iterator<Transition> it = this.mTransitions.iterator();
            while (it.hasNext()) {
                Transition next = it.next();
                if (next.isValidTarget(transitionValues.view)) {
                    next.captureEndValues(transitionValues);
                    transitionValues.mTargetedTransitions.add(next);
                }
            }
        }
    }

    @Override // androidx.transition.Transition
    public void capturePropagationValues(TransitionValues transitionValues) {
        super.capturePropagationValues(transitionValues);
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i++) {
            this.mTransitions.get(i).capturePropagationValues(transitionValues);
        }
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        if (isValidTarget(transitionValues.view)) {
            Iterator<Transition> it = this.mTransitions.iterator();
            while (it.hasNext()) {
                Transition next = it.next();
                if (next.isValidTarget(transitionValues.view)) {
                    next.captureStartValues(transitionValues);
                    transitionValues.mTargetedTransitions.add(next);
                }
            }
        }
    }

    @Override // androidx.transition.Transition
    /* renamed from: clone */
    public Transition mo4380clone() {
        TransitionSet transitionSet = (TransitionSet) super.m4374clone();
        transitionSet.mTransitions = new ArrayList<>();
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i++) {
            transitionSet.addTransitionInternal(this.mTransitions.get(i).m4374clone());
        }
        return transitionSet;
    }

    @Override // androidx.transition.Transition
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void createAnimators(ViewGroup viewGroup, TransitionValuesMaps transitionValuesMaps, TransitionValuesMaps transitionValuesMaps2, ArrayList<TransitionValues> arrayList, ArrayList<TransitionValues> arrayList2) {
        long startDelay = getStartDelay();
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i++) {
            Transition transition = this.mTransitions.get(i);
            if (startDelay > 0 && (this.mPlayTogether || i == 0)) {
                long startDelay2 = transition.getStartDelay();
                if (startDelay2 > 0) {
                    transition.mo4389setStartDelay(startDelay2 + startDelay);
                } else {
                    transition.mo4389setStartDelay(startDelay);
                }
            }
            transition.createAnimators(viewGroup, transitionValuesMaps, transitionValuesMaps2, arrayList, arrayList2);
        }
    }

    @Override // androidx.transition.Transition
    @NonNull
    public Transition excludeTarget(int i, boolean z) {
        for (int i2 = 0; i2 < this.mTransitions.size(); i2++) {
            this.mTransitions.get(i2).excludeTarget(i, z);
        }
        return super.excludeTarget(i, z);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public Transition excludeTarget(@NonNull View view, boolean z) {
        for (int i = 0; i < this.mTransitions.size(); i++) {
            this.mTransitions.get(i).excludeTarget(view, z);
        }
        return super.excludeTarget(view, z);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public Transition excludeTarget(@NonNull Class<?> cls, boolean z) {
        for (int i = 0; i < this.mTransitions.size(); i++) {
            this.mTransitions.get(i).excludeTarget(cls, z);
        }
        return super.excludeTarget(cls, z);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public Transition excludeTarget(@NonNull String str, boolean z) {
        for (int i = 0; i < this.mTransitions.size(); i++) {
            this.mTransitions.get(i).excludeTarget(str, z);
        }
        return super.excludeTarget(str, z);
    }

    @Override // androidx.transition.Transition
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void forceToEnd(ViewGroup viewGroup) {
        super.forceToEnd(viewGroup);
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i++) {
            this.mTransitions.get(i).forceToEnd(viewGroup);
        }
    }

    public int getOrdering() {
        return !this.mPlayTogether ? 1 : 0;
    }

    @Nullable
    public Transition getTransitionAt(int i) {
        if (i < 0 || i >= this.mTransitions.size()) {
            return null;
        }
        return this.mTransitions.get(i);
    }

    public int getTransitionCount() {
        return this.mTransitions.size();
    }

    @Override // androidx.transition.Transition
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void pause(View view) {
        super.pause(view);
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i++) {
            this.mTransitions.get(i).pause(view);
        }
    }

    @Override // androidx.transition.Transition
    @NonNull
    /* renamed from: removeListener  reason: collision with other method in class */
    public TransitionSet mo4381removeListener(@NonNull Transition.TransitionListener transitionListener) {
        return (TransitionSet) super.mo4381removeListener(transitionListener);
    }

    @Override // androidx.transition.Transition
    @NonNull
    /* renamed from: removeTarget */
    public /* bridge */ /* synthetic */ Transition mo4384removeTarget(@NonNull Class cls) {
        return mo4384removeTarget((Class<?>) cls);
    }

    @Override // androidx.transition.Transition
    @NonNull
    /* renamed from: removeTarget  reason: collision with other method in class */
    public TransitionSet mo4382removeTarget(@IdRes int i) {
        for (int i2 = 0; i2 < this.mTransitions.size(); i2++) {
            this.mTransitions.get(i2).mo4382removeTarget(i);
        }
        return (TransitionSet) super.mo4382removeTarget(i);
    }

    @Override // androidx.transition.Transition
    @NonNull
    /* renamed from: removeTarget  reason: collision with other method in class */
    public TransitionSet mo4383removeTarget(@NonNull View view) {
        for (int i = 0; i < this.mTransitions.size(); i++) {
            this.mTransitions.get(i).mo4383removeTarget(view);
        }
        return (TransitionSet) super.mo4383removeTarget(view);
    }

    @Override // androidx.transition.Transition
    @NonNull
    /* renamed from: removeTarget  reason: collision with other method in class */
    public TransitionSet mo4384removeTarget(@NonNull Class<?> cls) {
        for (int i = 0; i < this.mTransitions.size(); i++) {
            this.mTransitions.get(i).mo4384removeTarget(cls);
        }
        return (TransitionSet) super.mo4384removeTarget(cls);
    }

    @Override // androidx.transition.Transition
    @NonNull
    /* renamed from: removeTarget  reason: collision with other method in class */
    public TransitionSet mo4385removeTarget(@NonNull String str) {
        for (int i = 0; i < this.mTransitions.size(); i++) {
            this.mTransitions.get(i).mo4385removeTarget(str);
        }
        return (TransitionSet) super.mo4385removeTarget(str);
    }

    @NonNull
    public TransitionSet removeTransition(@NonNull Transition transition) {
        this.mTransitions.remove(transition);
        transition.mParent = null;
        return this;
    }

    @Override // androidx.transition.Transition
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void resume(View view) {
        super.resume(view);
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i++) {
            this.mTransitions.get(i).resume(view);
        }
    }

    @Override // androidx.transition.Transition
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void runAnimators() {
        if (this.mTransitions.isEmpty()) {
            start();
            end();
            return;
        }
        setupStartEndListeners();
        if (this.mPlayTogether) {
            Iterator<Transition> it = this.mTransitions.iterator();
            while (it.hasNext()) {
                it.next().runAnimators();
            }
            return;
        }
        for (int i = 1; i < this.mTransitions.size(); i++) {
            final Transition transition = this.mTransitions.get(i);
            this.mTransitions.get(i - 1).mo4375addListener(new TransitionListenerAdapter() { // from class: androidx.transition.TransitionSet.1
                @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                public void onTransitionEnd(@NonNull Transition transition2) {
                    transition.runAnimators();
                    transition2.mo4381removeListener(this);
                }
            });
        }
        Transition transition2 = this.mTransitions.get(0);
        if (transition2 == null) {
            return;
        }
        transition2.runAnimators();
    }

    @Override // androidx.transition.Transition
    public void setCanRemoveViews(boolean z) {
        super.setCanRemoveViews(z);
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i++) {
            this.mTransitions.get(i).setCanRemoveViews(z);
        }
    }

    @Override // androidx.transition.Transition
    @NonNull
    /* renamed from: setDuration  reason: collision with other method in class */
    public TransitionSet mo4386setDuration(long j) {
        ArrayList<Transition> arrayList;
        super.mo4386setDuration(j);
        if (this.mDuration >= 0 && (arrayList = this.mTransitions) != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.mTransitions.get(i).mo4386setDuration(j);
            }
        }
        return this;
    }

    @Override // androidx.transition.Transition
    public void setEpicenterCallback(Transition.EpicenterCallback epicenterCallback) {
        super.setEpicenterCallback(epicenterCallback);
        this.mChangeFlags |= 8;
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i++) {
            this.mTransitions.get(i).setEpicenterCallback(epicenterCallback);
        }
    }

    @Override // androidx.transition.Transition
    @NonNull
    /* renamed from: setInterpolator  reason: collision with other method in class */
    public TransitionSet mo4387setInterpolator(@Nullable TimeInterpolator timeInterpolator) {
        this.mChangeFlags |= 1;
        ArrayList<Transition> arrayList = this.mTransitions;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.mTransitions.get(i).mo4387setInterpolator(timeInterpolator);
            }
        }
        return (TransitionSet) super.mo4387setInterpolator(timeInterpolator);
    }

    @NonNull
    public TransitionSet setOrdering(int i) {
        if (i == 0) {
            this.mPlayTogether = true;
        } else if (i != 1) {
            throw new AndroidRuntimeException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid parameter for TransitionSet ordering: ", i));
        } else {
            this.mPlayTogether = false;
        }
        return this;
    }

    @Override // androidx.transition.Transition
    public void setPathMotion(PathMotion pathMotion) {
        super.setPathMotion(pathMotion);
        this.mChangeFlags |= 4;
        if (this.mTransitions != null) {
            for (int i = 0; i < this.mTransitions.size(); i++) {
                this.mTransitions.get(i).setPathMotion(pathMotion);
            }
        }
    }

    @Override // androidx.transition.Transition
    public void setPropagation(TransitionPropagation transitionPropagation) {
        super.setPropagation(transitionPropagation);
        this.mChangeFlags |= 2;
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i++) {
            this.mTransitions.get(i).setPropagation(transitionPropagation);
        }
    }

    @Override // androidx.transition.Transition
    /* renamed from: setSceneRoot  reason: collision with other method in class */
    public TransitionSet mo4388setSceneRoot(ViewGroup viewGroup) {
        super.mo4388setSceneRoot(viewGroup);
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i++) {
            this.mTransitions.get(i).mo4388setSceneRoot(viewGroup);
        }
        return this;
    }

    @Override // androidx.transition.Transition
    @NonNull
    /* renamed from: setStartDelay  reason: collision with other method in class */
    public TransitionSet mo4389setStartDelay(long j) {
        return (TransitionSet) super.mo4389setStartDelay(j);
    }

    @Override // androidx.transition.Transition
    public String toString(String str) {
        String transition = super.toString(str);
        for (int i = 0; i < this.mTransitions.size(); i++) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(transition, "\n");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mTransitions.get(i).toString(str + "  "));
            transition = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
        return transition;
    }
}
