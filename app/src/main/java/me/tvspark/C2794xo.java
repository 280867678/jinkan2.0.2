package me.tvspark;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

/* renamed from: me.tvspark.xo */
/* loaded from: classes4.dex */
public class C2794xo extends AnimatorListenerAdapter {
    public final /* synthetic */ ExtendedFloatingActionButton.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
    public final /* synthetic */ AbstractC2119fp Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2794xo(ExtendedFloatingActionButton extendedFloatingActionButton, AbstractC2119fp abstractC2119fp) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2119fp;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.onAnimationStart(animator);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
    }
}
