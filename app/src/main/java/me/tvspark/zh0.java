package me.tvspark;

import java.util.NoSuchElementException;

/* loaded from: classes4.dex */
public final class zh0 extends cg0 {
    public final int[] Wwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwww;

    public zh0(int[] iArr) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iArr, "array");
        this.Wwwwwwwwwwwwwwwwwwwwwww = iArr;
    }

    @Override // me.tvspark.cg0
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        try {
            int[] iArr = this.Wwwwwwwwwwwwwwwwwwwwwww;
            int i = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwww = i + 1;
            return iArr[i];
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
