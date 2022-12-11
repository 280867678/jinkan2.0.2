package me.tvspark;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.graphics.ColorUtils;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: me.tvspark.bq */
/* loaded from: classes4.dex */
public class C1955bq {
    public static final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
    public static final int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = {16842919};
    public static final int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = {16843623, 16842908};
    public static final int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = {16842908};
    public static final int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = {16843623};
    public static final int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = {16842913, 16842919};
    public static final int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwww = {16842913, 16843623, 16842908};
    public static final int[] Wwwwwwwwwwwwwwwwwwwwwwwwwww = {16842913, 16842908};
    public static final int[] Wwwwwwwwwwwwwwwwwwwwwwwwww = {16842913, 16843623};
    public static final int[] Wwwwwwwwwwwwwwwwwwwwwwwww = {16842913};
    public static final int[] Wwwwwwwwwwwwwwwwwwwwwwww = {16842910, 16842919};
    @VisibleForTesting
    public static final String Wwwwwwwwwwwwwwwwwwwwwww = C1955bq.class.getSimpleName();

    @ColorInt
    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable ColorStateList colorStateList, int[] iArr) {
        int colorForState = colorStateList != null ? colorStateList.getColorForState(iArr, colorStateList.getDefaultColor()) : 0;
        return ColorUtils.setAlphaComponent(colorForState, Math.min(Color.alpha(colorForState) * 2, 255));
    }

    @NonNull
    public static ColorStateList Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable ColorStateList colorStateList) {
        if (colorStateList != null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 22 && i <= 27 && Color.alpha(colorStateList.getDefaultColor()) == 0) {
                Color.alpha(colorStateList.getColorForState(Wwwwwwwwwwwwwwwwwwwwwwww, 0));
            }
            return colorStateList;
        }
        return ColorStateList.valueOf(0);
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull int[] iArr) {
        boolean z = false;
        boolean z2 = false;
        for (int i : iArr) {
            if (i == 16842910) {
                z = true;
            } else if (i == 16842908 || i == 16842919 || i == 16843623) {
                z2 = true;
            }
        }
        return z && z2;
    }
}
