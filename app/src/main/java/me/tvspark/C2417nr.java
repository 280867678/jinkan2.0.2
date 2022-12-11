package me.tvspark;

import android.animation.ValueAnimator;
import androidx.annotation.NonNull;

/* renamed from: me.tvspark.nr */
/* loaded from: classes4.dex */
public class C2417nr implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ C2306kr Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2417nr(C2306kr c2306kr) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2306kr;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
