package me.tvspark;

import java.util.NoSuchElementException;

/* renamed from: me.tvspark.xk */
/* loaded from: classes4.dex */
public final class C2790xk {
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -1;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;

    public C2790xk() {
        int[] iArr = new int[16];
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = iArr;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = iArr.length - 1;
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i != 0) {
            int[] iArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i3 = iArr[i2];
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (i2 + 1) & this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i - 1;
            return i3;
        }
        throw new NoSuchElementException();
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int[] iArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i2 == iArr.length) {
            int length = iArr.length << 1;
            if (length < 0) {
                throw new IllegalStateException();
            }
            int[] iArr2 = new int[length];
            int length2 = iArr.length;
            int i3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i4 = length2 - i3;
            System.arraycopy(iArr, i3, iArr2, 0, i4);
            System.arraycopy(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, iArr2, i4, i3);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - 1;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = iArr2;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = length - 1;
        }
        int i5 = (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1) & this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i5;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i5] = i;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww++;
    }
}
