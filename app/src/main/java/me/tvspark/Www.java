package me.tvspark;

import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;

/* loaded from: classes4.dex */
public class Www {
    public static final Interpolator Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new FastOutSlowInInterpolator();

    static {
        new LinearInterpolator();
        new FastOutLinearInInterpolator();
        new LinearOutSlowInInterpolator();
        new DecelerateInterpolator();
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, float f) {
        return Math.round(f * (i2 - i)) + i;
    }
}
