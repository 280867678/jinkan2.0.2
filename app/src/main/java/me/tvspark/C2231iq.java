package me.tvspark;

import androidx.annotation.NonNull;

/* renamed from: me.tvspark.iq */
/* loaded from: classes4.dex */
public class C2231iq extends C2194hq {
    public float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -1.0f;

    @Override // me.tvspark.C2194hq
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull C2533qq c2533qq, float f, float f2, float f3) {
        c2533qq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0.0f, f3 * f2, 180.0f, 180.0f - f);
        double d = f3;
        double d2 = f2;
        c2533qq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((float) (Math.sin(Math.toRadians(f)) * d * d2), (float) (Math.sin(Math.toRadians(90.0f - f)) * d * d2));
    }
}
