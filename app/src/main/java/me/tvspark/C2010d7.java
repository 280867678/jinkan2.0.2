package me.tvspark;

import me.tvspark.AbstractC2625t7;
import org.apache.commons.lang3.time.StopWatch;

/* renamed from: me.tvspark.d7 */
/* loaded from: classes4.dex */
public class C2010d7 implements AbstractC2625t7 {
    public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2010d7(long j, long j2, int i, int i2) {
        long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j2;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2 == -1 ? 1 : i2;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        if (j == -1) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -1L;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -9223372036854775807L;
        } else {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j - j2;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, j2, i);
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public static long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, long j2, int i) {
        return ((Math.max(0L, j - j2) * 8) * StopWatch.NANO_2_MILLIS) / i;
    }

    @Override // me.tvspark.AbstractC2625t7
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    @Override // me.tvspark.AbstractC2625t7
    public AbstractC2625t7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        long j2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (j2 == -1) {
            return new AbstractC2625t7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new C2662u7(0L, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
        }
        long j3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((((this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww * j) / 8000000) / j3) * j3, 0L, j2 - j3);
        long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        C2662u7 c2662u7 = new C2662u7(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < j) {
            int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                long j4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + i;
                return new AbstractC2625t7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2662u7, new C2662u7(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j4), j4));
            }
        }
        return new AbstractC2625t7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2662u7);
    }

    @Override // me.tvspark.AbstractC2625t7
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != -1;
    }
}
