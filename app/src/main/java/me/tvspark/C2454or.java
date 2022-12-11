package me.tvspark;

import android.animation.ValueAnimator;
import androidx.annotation.NonNull;

/* renamed from: me.tvspark.or */
/* loaded from: classes4.dex */
public class C2454or implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ C2306kr Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2454or(C2306kr c2306kr) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2306kr;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setScaleX(floatValue);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setScaleY(floatValue);
    }
}
