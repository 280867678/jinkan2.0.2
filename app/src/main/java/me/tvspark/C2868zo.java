package me.tvspark;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import me.tvspark.C1954bp;

/* renamed from: me.tvspark.zo */
/* loaded from: classes4.dex */
public class C2868zo extends AnimatorListenerAdapter {
    public final /* synthetic */ C1954bp Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ C1954bp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2868zo(C1954bp c1954bp, boolean z, C1954bp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c1954bp;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        C1954bp c1954bp = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        c1954bp.Wwwwwwwwwwwwww = 0;
        c1954bp.Wwwwwwwwwwwwwwwwwwww = null;
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            c1954bp.Wwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww ? 8 : 4, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            C1954bp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                return;
            }
            C2831yo c2831yo = (C2831yo) wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            c2831yo.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2831yo.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        C1954bp c1954bp = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        c1954bp.Wwwwwwwwwwwwww = 1;
        c1954bp.Wwwwwwwwwwwwwwwwwwww = animator;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
    }
}
