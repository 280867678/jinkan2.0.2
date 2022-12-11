package me.tvspark;

import android.animation.ValueAnimator;
import androidx.annotation.NonNull;
import com.google.android.material.snackbar.BaseTransientBottomBar;

/* renamed from: me.tvspark.yq */
/* loaded from: classes4.dex */
public class C2833yq implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ BaseTransientBottomBar Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2833yq(BaseTransientBottomBar baseTransientBottomBar, int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = baseTransientBottomBar;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setTranslationY(intValue);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = intValue;
    }
}
