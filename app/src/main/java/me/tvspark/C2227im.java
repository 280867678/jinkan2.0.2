package me.tvspark;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.RestrictTo;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: me.tvspark.im */
/* loaded from: classes4.dex */
public class C2227im {
    public static final TimeInterpolator Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new LinearInterpolator();
    public static final TimeInterpolator Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new FastOutSlowInInterpolator();
    public static final TimeInterpolator Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new FastOutLinearInInterpolator();
    public static final TimeInterpolator Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new LinearOutSlowInInterpolator();
    public static final TimeInterpolator Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new DecelerateInterpolator();

    public static float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f, float f2, float f3) {
        return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f2, f, f3, f);
    }
}
