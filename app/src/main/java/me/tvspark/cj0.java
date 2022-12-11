package me.tvspark;

import java.util.Iterator;

/* loaded from: classes4.dex */
public class cj0 implements Iterable<Long>, pi0 {
    public final long Wwwwwwwwwwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwwwwwwwwwwww;

    public cj0(long j, long j2, long j3) {
        int i = (j3 > 0L ? 1 : (j3 == 0L ? 0 : -1));
        if (i != 0) {
            if (j3 != Long.MIN_VALUE) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww = j;
                if (i > 0) {
                    if (j < j2) {
                        j2 -= r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j2, j3) - r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, j3), j3);
                    }
                } else if (i >= 0) {
                    throw new IllegalArgumentException("Step is zero.");
                } else {
                    if (j > j2) {
                        long j4 = -j3;
                        j2 += r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, j4) - r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j2, j4), j4);
                    }
                }
                this.Wwwwwwwwwwwwwwwwwwwwwww = j2;
                this.Wwwwwwwwwwwwwwwwwwwwww = j3;
                return;
            }
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
        throw new IllegalArgumentException("Step must be non-zero.");
    }

    @Override // java.lang.Iterable
    public Iterator<Long> iterator() {
        return new dj0(this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww);
    }
}
