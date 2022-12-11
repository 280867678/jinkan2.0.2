package me.tvspark;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.snackbar.BaseTransientBottomBar;

/* renamed from: me.tvspark.xq */
/* loaded from: classes4.dex */
public class C2796xq extends AnimatorListenerAdapter {
    public final /* synthetic */ BaseTransientBottomBar Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2796xq(BaseTransientBottomBar baseTransientBottomBar) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = baseTransientBottomBar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(70, 180);
    }
}
