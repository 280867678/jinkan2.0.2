package me.tvspark;

import java.util.NoSuchElementException;

/* loaded from: classes4.dex */
public final class wh0 extends wf0 {
    public final char[] Wwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwww;

    public wh0(char[] cArr) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cArr, "array");
        this.Wwwwwwwwwwwwwwwwwwwwwww = cArr;
    }

    @Override // me.tvspark.wf0
    public char Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        try {
            char[] cArr = this.Wwwwwwwwwwwwwwwwwwwwwww;
            int i = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwww = i + 1;
            return cArr[i];
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
