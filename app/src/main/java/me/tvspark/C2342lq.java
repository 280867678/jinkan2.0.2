package me.tvspark;

import android.graphics.RectF;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import java.util.Arrays;

/* renamed from: me.tvspark.lq */
/* loaded from: classes4.dex */
public final class C2342lq implements AbstractC2157gq {
    public final float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2342lq(@FloatRange(from = 0.0d, m4213to = 1.0d) float f) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = f;
    }

    @Override // me.tvspark.AbstractC2157gq
    public float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull RectF rectF) {
        return rectF.height() * this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C2342lq) && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == ((C2342lq) obj).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)});
    }
}
