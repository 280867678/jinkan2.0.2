package me.tvspark;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* renamed from: me.tvspark.vr */
/* loaded from: classes4.dex */
public class C2723vr extends AnimatorListenerAdapter {
    public final /* synthetic */ C2571rr Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2723vr(C2571rr c2571rr) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2571rr;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        C2571rr c2571rr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        c2571rr.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setChecked(c2571rr.Wwwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww.start();
    }
}
