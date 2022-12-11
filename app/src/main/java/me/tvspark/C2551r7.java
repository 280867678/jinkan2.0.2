package me.tvspark;

import me.tvspark.AbstractC2625t7;

/* renamed from: me.tvspark.r7 */
/* loaded from: classes4.dex */
public final class C2551r7 implements AbstractC2625t7 {
    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final long[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final long[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2551r7(long[] jArr, long[] jArr2, long j) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(jArr.length == jArr2.length);
        int length = jArr2.length;
        boolean z = length > 0;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
        if (!z || jArr2[0] <= 0) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = jArr;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = jArr2;
        } else {
            int i = length + 1;
            long[] jArr3 = new long[i];
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = jArr3;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new long[i];
            System.arraycopy(jArr, 0, jArr3, 1, length);
            System.arraycopy(jArr2, 0, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 1, length);
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j;
    }

    @Override // me.tvspark.AbstractC2625t7
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.AbstractC2625t7
    public AbstractC2625t7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return new AbstractC2625t7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2662u7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, j, true, true);
        C2662u7 c2662u7 = new C2662u7(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww], this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww]);
        if (c2662u7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == j || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length - 1) {
            return new AbstractC2625t7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2662u7);
        }
        int i = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1;
        return new AbstractC2625t7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2662u7, new C2662u7(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i], this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i]));
    }

    @Override // me.tvspark.AbstractC2625t7
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }
}
