package me.tvspark;

import android.animation.ValueAnimator;
import androidx.annotation.NonNull;
import com.google.android.material.snackbar.BaseTransientBottomBar;

/* renamed from: me.tvspark.ar */
/* loaded from: classes4.dex */
public class C1919ar implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ BaseTransientBottomBar Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;

    public C1919ar(BaseTransientBottomBar baseTransientBottomBar) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = baseTransientBottomBar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setTranslationY(intValue);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = intValue;
    }
}
