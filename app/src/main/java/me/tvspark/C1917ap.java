package me.tvspark;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import me.tvspark.C1954bp;

/* renamed from: me.tvspark.ap */
/* loaded from: classes4.dex */
public class C1917ap extends AnimatorListenerAdapter {
    public final /* synthetic */ C1954bp Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ C1954bp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C1917ap(C1954bp c1954bp, boolean z, C1954bp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c1954bp;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        C1954bp c1954bp = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        c1954bp.Wwwwwwwwwwwwww = 0;
        c1954bp.Wwwwwwwwwwwwwwwwwwww = null;
        C1954bp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            C2831yo c2831yo = (C2831yo) wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            c2831yo.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2831yo.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        C1954bp c1954bp = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        c1954bp.Wwwwwwwwwwwwww = 2;
        c1954bp.Wwwwwwwwwwwwwwwwwwww = animator;
    }
}
