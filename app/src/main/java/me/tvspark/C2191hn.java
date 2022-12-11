package me.tvspark;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.bottomappbar.BottomAppBar;

/* renamed from: me.tvspark.hn */
/* loaded from: classes4.dex */
public class C2191hn extends AnimatorListenerAdapter {
    public final /* synthetic */ BottomAppBar Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2191hn(BottomAppBar bottomAppBar) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = bottomAppBar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        BottomAppBar.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        BottomAppBar bottomAppBar = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        bottomAppBar.Wwwwwwwwwwwwwwww = false;
        bottomAppBar.Wwwwwwwwwwwwwwwwwwwwww = null;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww++;
    }
}
