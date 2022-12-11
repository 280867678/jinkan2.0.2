package me.tvspark;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* renamed from: me.tvspark.rn */
/* loaded from: classes4.dex */
public final class C2567rn extends AnimatorListenerAdapter {
    public final /* synthetic */ AbstractC2641tn Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2567rn(AbstractC2641tn abstractC2641tn) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2641tn;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }
}
