package me.tvspark;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.snackbar.BaseTransientBottomBar;

/* renamed from: me.tvspark.tq */
/* loaded from: classes4.dex */
public class C2644tq extends AnimatorListenerAdapter {
    public final /* synthetic */ BaseTransientBottomBar Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2644tq(BaseTransientBottomBar baseTransientBottomBar) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = baseTransientBottomBar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }
}
