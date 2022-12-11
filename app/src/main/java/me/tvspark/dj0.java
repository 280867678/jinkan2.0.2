package me.tvspark;

import java.util.NoSuchElementException;

/* loaded from: classes4.dex */
public final class dj0 extends dg0 {
    public final long Wwwwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwwwwwwwwwwww;

    public dj0(long j, long j2, long j3) {
        this.Wwwwwwwwwwwwwwwwwwwww = j3;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = j2;
        int i = (j3 > 0L ? 1 : (j3 == 0L ? 0 : -1));
        int i2 = (j > j2 ? 1 : (j == j2 ? 0 : -1));
        boolean z = i <= 0 ? i2 >= 0 : i2 <= 0;
        this.Wwwwwwwwwwwwwwwwwwwwwww = z;
        this.Wwwwwwwwwwwwwwwwwwwwww = !z ? this.Wwwwwwwwwwwwwwwwwwwwwwww : j;
    }

    @Override // me.tvspark.dg0
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        long j = this.Wwwwwwwwwwwwwwwwwwwwww;
        if (j != this.Wwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwww + j;
        } else if (!this.Wwwwwwwwwwwwwwwwwwwwwww) {
            throw new NoSuchElementException();
        } else {
            this.Wwwwwwwwwwwwwwwwwwwwwww = false;
        }
        return j;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.Wwwwwwwwwwwwwwwwwwwwwww;
    }
}
