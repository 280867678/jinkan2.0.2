package me.tvspark;

import java.util.NoSuchElementException;

/* loaded from: classes4.dex */
public final class bi0 extends dg0 {
    public final long[] Wwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwww;

    public bi0(long[] jArr) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(jArr, "array");
        this.Wwwwwwwwwwwwwwwwwwwwwww = jArr;
    }

    @Override // me.tvspark.dg0
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        try {
            long[] jArr = this.Wwwwwwwwwwwwwwwwwwwwwww;
            int i = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwww = i + 1;
            return jArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww--;
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww < this.Wwwwwwwwwwwwwwwwwwwwwww.length;
    }
}
