package me.tvspark;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.transformation.FabTransformationBehavior;
import me.tvspark.AbstractC2641tn;

/* renamed from: me.tvspark.ps */
/* loaded from: classes4.dex */
public class C2498ps extends AnimatorListenerAdapter {
    public final /* synthetic */ AbstractC2641tn Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2498ps(FabTransformationBehavior fabTransformationBehavior, AbstractC2641tn abstractC2641tn) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2641tn;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        AbstractC2641tn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww revealInfo = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getRevealInfo();
        revealInfo.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Float.MAX_VALUE;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setRevealInfo(revealInfo);
    }
}
