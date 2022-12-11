package me.tvspark;

import android.animation.ValueAnimator;
import androidx.annotation.NonNull;
import com.google.android.material.appbar.CollapsingToolbarLayout;

/* renamed from: me.tvspark.wm */
/* loaded from: classes4.dex */
public class C2755wm implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ CollapsingToolbarLayout Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2755wm(CollapsingToolbarLayout collapsingToolbarLayout) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = collapsingToolbarLayout;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setScrimAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
    }
}
