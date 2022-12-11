package me.tvspark;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* renamed from: me.tvspark.kn */
/* loaded from: classes4.dex */
public class C2302kn extends AnimatorListenerAdapter {
    public final /* synthetic */ BottomAppBar Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2302kn(BottomAppBar bottomAppBar) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = bottomAppBar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        float fabTranslationX;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwww.onAnimationStart(animator);
        FloatingActionButton Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            fabTranslationX = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getFabTranslationX();
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setTranslationX(fabTranslationX);
        }
    }
}
