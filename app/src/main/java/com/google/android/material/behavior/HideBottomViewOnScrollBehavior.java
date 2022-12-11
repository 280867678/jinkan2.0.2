package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import me.tvspark.C2227im;

/* loaded from: classes3.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    @Nullable
    public ViewPropertyAnimator Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 2;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AnimatorListenerAdapter {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            HideBottomViewOnScrollBehavior.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        }
    }

    public HideBottomViewOnScrollBehavior() {
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull V v, int i, long j, TimeInterpolator timeInterpolator) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = v.animate().translationY(i).setInterpolator(timeInterpolator).setDuration(j).setListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = v.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) v.getLayoutParams()).bottomMargin;
        return super.onLayoutChild(coordinatorLayout, v, i);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, int i, int i2, int i3, int i4, int i5, @NonNull int[] iArr) {
        if (i2 > 0) {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 1) {
                return;
            }
            ViewPropertyAnimator viewPropertyAnimator = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (viewPropertyAnimator != null) {
                viewPropertyAnimator.cancel();
                v.clearAnimation();
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 1;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(v, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 175L, C2227im.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        } else if (i2 >= 0 || this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 2) {
        } else {
            ViewPropertyAnimator viewPropertyAnimator2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (viewPropertyAnimator2 != null) {
                viewPropertyAnimator2.cancel();
                v.clearAnimation();
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 2;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(v, 0, 225L, C2227im.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, @NonNull View view2, int i, int i2) {
        return i == 2;
    }
}
