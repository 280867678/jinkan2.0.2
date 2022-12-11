package me.tvspark;

import android.animation.ValueAnimator;
import androidx.annotation.NonNull;

/* renamed from: me.tvspark.sr */
/* loaded from: classes4.dex */
public class C2608sr implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ C2571rr Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2608sr(C2571rr c2571rr) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2571rr;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
