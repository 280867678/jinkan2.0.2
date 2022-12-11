package me.tvspark;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import com.google.android.material.snackbar.BaseTransientBottomBar;

/* renamed from: me.tvspark.sq */
/* loaded from: classes4.dex */
public class RunnableC2607sq implements Runnable {
    public final /* synthetic */ BaseTransientBottomBar Wwwwwwwwwwwwwwwwwwwwwwww;

    public RunnableC2607sq(BaseTransientBottomBar baseTransientBottomBar) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = baseTransientBottomBar;
    }

    @Override // java.lang.Runnable
    public void run() {
        BaseTransientBottomBar.Wwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            return;
        }
        if (wwwwwwwwwwwwwwwwwwwwwwwwww.getParent() != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setVisibility(0);
        }
        if (this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getAnimationMode() != 1) {
            BaseTransientBottomBar baseTransientBottomBar = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = baseTransientBottomBar.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            baseTransientBottomBar.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setTranslationY(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            ValueAnimator valueAnimator = new ValueAnimator();
            valueAnimator.setIntValues(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0);
            valueAnimator.setInterpolator(C2227im.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            valueAnimator.setDuration(250L);
            valueAnimator.addListener(new C2796xq(baseTransientBottomBar));
            valueAnimator.addUpdateListener(new C2833yq(baseTransientBottomBar, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
            valueAnimator.start();
            return;
        }
        BaseTransientBottomBar baseTransientBottomBar2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (baseTransientBottomBar2 == null) {
            throw null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setInterpolator(C2227im.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        ofFloat.addUpdateListener(new C2722vq(baseTransientBottomBar2));
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.8f, 1.0f);
        ofFloat2.setInterpolator(C2227im.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        ofFloat2.addUpdateListener(new C2759wq(baseTransientBottomBar2));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.setDuration(150L);
        animatorSet.addListener(new C2644tq(baseTransientBottomBar2));
        animatorSet.start();
    }
}
