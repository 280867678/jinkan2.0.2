package me.tvspark;

import androidx.annotation.Nullable;
import androidx.cardview.widget.RoundRectDrawableWithShadow;
import me.tvspark.AbstractC2625t7;

/* renamed from: me.tvspark.b9 */
/* loaded from: classes4.dex */
public final class C1938b9 implements AbstractC2852z8 {
    @Nullable
    public final long[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C1938b9(long j, int i, long j2, long j3, @Nullable long[] jArr) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j2;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = jArr;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j3;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j3 != -1 ? j + j3 : -1L;
    }

    @Override // me.tvspark.AbstractC2625t7
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.AbstractC2625t7
    public AbstractC2625t7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        long[] jArr;
        if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            return new AbstractC2625t7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new C2662u7(0L, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
        }
        long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, 0L, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        double d = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww * 100.0d) / this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        double d2 = RoundRectDrawableWithShadow.COS_45;
        if (d > RoundRectDrawableWithShadow.COS_45) {
            if (d >= 100.0d) {
                d2 = 256.0d;
            } else {
                int i = (int) d;
                long[] jArr2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(jArr2);
                double d3 = jArr2[i];
                d2 = d3 + (((i == 99 ? 256.0d : jArr[i + 1]) - d3) * (d - i));
            }
        }
        return new AbstractC2625t7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new C2662u7(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Math.round((d2 / 256.0d) * this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - 1)));
    }

    @Override // me.tvspark.AbstractC2625t7
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww != null;
    }

    @Override // me.tvspark.AbstractC2852z8
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.AbstractC2852z8
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        long j2 = j - this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() || j2 <= this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return 0L;
        }
        long[] jArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(jArr);
        double d = (j2 * 256.0d) / this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(jArr, (long) d, true, true);
        long j3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        long j4 = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww * j3) / 100;
        long j5 = jArr[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww];
        int i = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1;
        long j6 = (j3 * i) / 100;
        long j7 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 99 ? 256L : jArr[i];
        return Math.round((j5 == j7 ? RoundRectDrawableWithShadow.COS_45 : (d - j5) / (j7 - j5)) * (j6 - j4)) + j4;
    }
}
