package me.tvspark;

import android.animation.ValueAnimator;
import androidx.annotation.NonNull;
import com.google.android.material.snackbar.BaseTransientBottomBar;

/* renamed from: me.tvspark.wq */
/* loaded from: classes4.dex */
public class C2759wq implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ BaseTransientBottomBar Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2759wq(BaseTransientBottomBar baseTransientBottomBar) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = baseTransientBottomBar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setScaleX(floatValue);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setScaleY(floatValue);
    }
}
