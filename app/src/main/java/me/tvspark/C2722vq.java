package me.tvspark;

import android.animation.ValueAnimator;
import androidx.annotation.NonNull;
import com.google.android.material.snackbar.BaseTransientBottomBar;

/* renamed from: me.tvspark.vq */
/* loaded from: classes4.dex */
public class C2722vq implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ BaseTransientBottomBar Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2722vq(BaseTransientBottomBar baseTransientBottomBar) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = baseTransientBottomBar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
