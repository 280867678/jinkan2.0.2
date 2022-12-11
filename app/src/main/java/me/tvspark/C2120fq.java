package me.tvspark;

import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.Arrays;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: me.tvspark.fq */
/* loaded from: classes4.dex */
public final class C2120fq implements AbstractC2157gq {
    public final float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final AbstractC2157gq Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2120fq(float f, @NonNull AbstractC2157gq abstractC2157gq) {
        while (abstractC2157gq instanceof C2120fq) {
            abstractC2157gq = ((C2120fq) abstractC2157gq).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            f += ((C2120fq) abstractC2157gq).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2157gq;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = f;
    }

    @Override // me.tvspark.AbstractC2157gq
    public float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull RectF rectF) {
        return Math.max(0.0f, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(rectF) + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2120fq)) {
            return false;
        }
        C2120fq c2120fq = (C2120fq) obj;
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(c2120fq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == c2120fq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Float.valueOf(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)});
    }
}
