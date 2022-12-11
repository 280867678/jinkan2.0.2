package me.tvspark;

/* renamed from: me.tvspark.s9 */
/* loaded from: classes4.dex */
public final class C2590s9 {
    public final long Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final long[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final long[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final C2473p9 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2590s9(C2473p9 c2473p9, long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2, long j) {
        boolean z = false;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iArr.length == jArr2.length);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(jArr.length == jArr2.length);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iArr2.length == jArr2.length ? true : z);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2473p9;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = jArr;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = iArr;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = jArr2;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = iArr2;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = j;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = jArr.length;
        if (iArr2.length > 0) {
            int length = iArr2.length - 1;
            iArr2[length] = iArr2[length] | 536870912;
        }
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        for (int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, j, true, false); Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.length; Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww++) {
            if ((this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww] & 1) != 0) {
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
        }
        return -1;
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        for (int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, j, true, false); Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 0; Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww--) {
            if ((this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww] & 1) != 0) {
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
        }
        return -1;
    }
}
