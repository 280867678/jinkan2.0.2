package me.tvspark;

import android.graphics.RectF;
import androidx.annotation.NonNull;
import java.util.Arrays;

/* renamed from: me.tvspark.eq */
/* loaded from: classes4.dex */
public final class C2083eq implements AbstractC2157gq {
    public final float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2083eq(float f) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = f;
    }

    @Override // me.tvspark.AbstractC2157gq
    public float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull RectF rectF) {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C2083eq) && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == ((C2083eq) obj).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)});
    }
}
