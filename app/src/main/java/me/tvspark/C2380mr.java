package me.tvspark;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* renamed from: me.tvspark.mr */
/* loaded from: classes4.dex */
public class C2380mr extends AnimatorListenerAdapter {
    public final /* synthetic */ C2306kr Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2380mr(C2306kr c2306kr) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2306kr;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setEndIconVisible(false);
    }
}
