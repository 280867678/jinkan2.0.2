package me.tvspark;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import java.util.List;

/* renamed from: me.tvspark.up */
/* loaded from: classes4.dex */
public class C2680up extends AnimatorListenerAdapter {
    public final /* synthetic */ AbstractC2758wp Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2680up(AbstractC2758wp abstractC2758wp) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2758wp;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        super.onAnimationStart(animator);
        AbstractC2758wp abstractC2758wp = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        List<Animatable2Compat.AnimationCallback> list = abstractC2758wp.Wwwwwwwwwwwwwwwwwwwwww;
        if (list == null || abstractC2758wp.Wwwwwwwwwwwwwwwwwwwww) {
            return;
        }
        for (Animatable2Compat.AnimationCallback animationCallback : list) {
            animationCallback.onAnimationStart(abstractC2758wp);
        }
    }
}
