package me.tvspark;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.drawable.Drawable;
import com.google.android.material.transformation.FabTransformationBehavior;

/* renamed from: me.tvspark.os */
/* loaded from: classes4.dex */
public class C2455os extends AnimatorListenerAdapter {
    public final /* synthetic */ Drawable Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ AbstractC2641tn Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2455os(FabTransformationBehavior fabTransformationBehavior, AbstractC2641tn abstractC2641tn, Drawable drawable) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2641tn;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = drawable;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setCircularRevealOverlayDrawable(null);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setCircularRevealOverlayDrawable(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }
}
