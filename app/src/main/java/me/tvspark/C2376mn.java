package me.tvspark;

import android.animation.ValueAnimator;
import androidx.annotation.NonNull;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.shape.MaterialShapeDrawable;

/* renamed from: me.tvspark.mn */
/* loaded from: classes4.dex */
public class C2376mn implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ BottomSheetBehavior Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2376mn(BottomSheetBehavior bottomSheetBehavior) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = bottomSheetBehavior;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        MaterialShapeDrawable materialShapeDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwww;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(floatValue);
        }
    }
}
