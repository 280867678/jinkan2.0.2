package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

@Deprecated
/* loaded from: classes3.dex */
public abstract class ExpandableTransformationBehavior extends ExpandableBehavior {
    @Nullable
    public AnimatorSet Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AnimatorListenerAdapter {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ExpandableTransformationBehavior.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        }
    }

    public ExpandableTransformationBehavior() {
    }

    public ExpandableTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @NonNull
    public abstract AnimatorSet Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(View view, View view2, boolean z, boolean z2);

    @Override // com.google.android.material.transformation.ExpandableBehavior
    @CallSuper
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(View view, View view2, boolean z, boolean z2) {
        boolean z3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null;
        if (z3) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.cancel();
        }
        AnimatorSet Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view, view2, z, z3);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.addListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.start();
        if (!z2) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.end();
        }
        return true;
    }
}
