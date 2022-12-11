package me.tvspark;

import me.tvspark.AbstractC2625t7;
import me.tvspark.C2434o7;
import org.apache.commons.lang3.time.StopWatch;

/* renamed from: me.tvspark.n7 */
/* loaded from: classes4.dex */
public final class C2397n7 implements AbstractC2625t7 {
    public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final C2434o7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2397n7(C2434o7 c2434o7, long j) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2434o7;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j;
    }

    @Override // me.tvspark.AbstractC2625t7
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.AbstractC2625t7
    public AbstractC2625t7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww);
        C2434o7 c2434o7 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        C2434o7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2434o7.Wwwwwwwwwwwwwwwwwwwwwwww;
        long[] jArr = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        long[] jArr2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(jArr, C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((c2434o7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww * j) / StopWatch.NANO_2_MILLIS, 0L, c2434o7.Wwwwwwwwwwwwwwwwwwwwwwwww - 1), true, false);
        long j2 = 0;
        long j3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -1 ? 0L : jArr[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww];
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != -1) {
            j2 = jArr2[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww];
        }
        C2662u7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j3, j2);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == j || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == jArr.length - 1) {
            return new AbstractC2625t7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        int i = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1;
        return new AbstractC2625t7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(jArr[i], jArr2[i]));
    }

    @Override // me.tvspark.AbstractC2625t7
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return true;
    }

    public final C2662u7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, long j2) {
        return new C2662u7((j * StopWatch.NANO_2_MILLIS) / this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + j2);
    }
}
