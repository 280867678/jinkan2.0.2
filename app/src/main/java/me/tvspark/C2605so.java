package me.tvspark;

import android.content.Context;
import android.graphics.Color;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.core.graphics.ColorUtils;

/* renamed from: me.tvspark.so */
/* loaded from: classes4.dex */
public class C2605so {
    public final float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2605so(@NonNull Context context) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, com.google.android.material.R$attr.elevationOverlayEnabled, false);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, com.google.android.material.R$attr.elevationOverlayColor, 0);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, com.google.android.material.R$attr.colorSurface, 0);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = context.getResources().getDisplayMetrics().density;
    }

    @ColorInt
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@ColorInt int i, float f) {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            if (!(ColorUtils.setAlphaComponent(i, 255) == this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                return i;
            }
            float f2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            float f3 = 0.0f;
            if (f2 > 0.0f && f > 0.0f) {
                f3 = Math.min(((((float) Math.log1p(f / f2)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
            }
            return ColorUtils.setAlphaComponent(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ColorUtils.setAlphaComponent(i, 255), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, f3), Color.alpha(i));
        }
        return i;
    }
}
