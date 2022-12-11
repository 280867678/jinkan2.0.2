package me.tvspark;

import me.tvspark.AbstractC2625t7;

/* renamed from: me.tvspark.a9 */
/* loaded from: classes4.dex */
public final class C1901a9 implements AbstractC2852z8 {
    public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final long[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final long[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C1901a9(long[] jArr, long[] jArr2, long j, long j2) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = jArr;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = jArr2;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j2;
    }

    @Override // me.tvspark.AbstractC2625t7
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.AbstractC2625t7
    public AbstractC2625t7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, j, true, true);
        C2662u7 c2662u7 = new C2662u7(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww], this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww]);
        if (c2662u7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= j || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length - 1) {
            return new AbstractC2625t7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2662u7);
        }
        int i = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1;
        return new AbstractC2625t7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2662u7, new C2662u7(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i], this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i]));
    }

    @Override // me.tvspark.AbstractC2625t7
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return true;
    }

    @Override // me.tvspark.AbstractC2852z8
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.AbstractC2852z8
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, j, true, true)];
    }
}
