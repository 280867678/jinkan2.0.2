package me.tvspark;

import android.graphics.RectF;

/* renamed from: me.tvspark.xs */
/* loaded from: classes4.dex */
public class C2798xs {
    public static final AbstractC2761ws Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public static final AbstractC2761ws Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    /* renamed from: me.tvspark.xs$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements AbstractC2761ws {
        @Override // me.tvspark.AbstractC2761ws
        public C2835ys Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f, float f2, float f3, float f4, float f5, float f6, float f7) {
            float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2049dt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f5, f7, f2, f3, f, true);
            float f8 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww / f5;
            float f9 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww / f7;
            return new C2835ys(f8, f9, f4 * f8, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, f6 * f9, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }

        @Override // me.tvspark.AbstractC2761ws
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(RectF rectF, float f, C2835ys c2835ys) {
            float abs = (Math.abs(c2835ys.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww - c2835ys.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) / 2.0f) * f;
            rectF.left += abs;
            rectF.right -= abs;
        }

        @Override // me.tvspark.AbstractC2761ws
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2835ys c2835ys) {
            return c2835ys.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww > c2835ys.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
    }

    /* renamed from: me.tvspark.xs$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements AbstractC2761ws {
        @Override // me.tvspark.AbstractC2761ws
        public C2835ys Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f, float f2, float f3, float f4, float f5, float f6, float f7) {
            float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2049dt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f4, f6, f2, f3, f, true);
            float f8 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww / f4;
            float f9 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww / f6;
            return new C2835ys(f8, f9, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, f5 * f8, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, f7 * f9);
        }

        @Override // me.tvspark.AbstractC2761ws
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(RectF rectF, float f, C2835ys c2835ys) {
            rectF.bottom -= Math.abs(c2835ys.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww - c2835ys.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) * f;
        }

        @Override // me.tvspark.AbstractC2761ws
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2835ys c2835ys) {
            return c2835ys.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww > c2835ys.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
    }

    public static AbstractC2761ws Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, boolean z, RectF rectF, RectF rectF2) {
        boolean z2 = true;
        if (i != 0) {
            if (i == 1) {
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            if (i != 2) {
                throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid fit mode: ", i));
            }
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        float width = rectF.width();
        float height = rectF.height();
        float width2 = rectF2.width();
        float height2 = rectF2.height();
        float f = (height2 * width) / width2;
        float f2 = (width2 * height) / width;
        if (!z ? f2 < height2 : f < height) {
            z2 = false;
        }
        return z2 ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }
}
