package me.tvspark;

import android.animation.ValueAnimator;
import androidx.annotation.NonNull;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.shape.MaterialShapeDrawable;

/* renamed from: me.tvspark.sm */
/* loaded from: classes4.dex */
public class C2603sm implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ MaterialShapeDrawable Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2603sm(AppBarLayout appBarLayout, MaterialShapeDrawable materialShapeDrawable) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = materialShapeDrawable;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
