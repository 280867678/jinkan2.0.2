package me.tvspark;

import me.tvspark.AbstractC2625t7;
import org.apache.commons.lang3.time.StopWatch;

/* renamed from: me.tvspark.rb */
/* loaded from: classes4.dex */
public final class C2555rb implements AbstractC2625t7 {
    public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final C2475pb Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2555rb(C2475pb c2475pb, int i, long j, long j2) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2475pb;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j;
        long j3 = (j2 - j) / c2475pb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j3;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j3);
    }

    @Override // me.tvspark.AbstractC2625t7
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        return C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j * this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, StopWatch.NANO_2_MILLIS, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    @Override // me.tvspark.AbstractC2625t7
    public AbstractC2625t7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww * j) / (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww * StopWatch.NANO_2_MILLIS), 0L, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - 1);
        long j2 = (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww * Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        C2662u7 c2662u7 = new C2662u7(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, j2);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= j || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - 1) {
            return new AbstractC2625t7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2662u7);
        }
        long j3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1;
        return new AbstractC2625t7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2662u7, new C2662u7(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j3), (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww * j3) + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
    }

    @Override // me.tvspark.AbstractC2625t7
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return true;
    }
}
