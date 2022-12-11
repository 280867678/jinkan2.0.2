package me.tvspark;

import java.util.Arrays;

/* renamed from: me.tvspark.lx */
/* loaded from: classes4.dex */
public class C2349lx<K> extends C2312kx<K> {
    public transient int Wwwwwwwwwwwwwwwwwwwwwwww;
    public transient int Wwwwwwwwwwwwwwwwwwwwwwwww;
    public transient long[] Wwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2349lx(int i) {
        super(i, 1.0f);
    }

    public final int Wwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        return (int) this.Wwwwwwwwwwwwwwwwwwwwwwwwww[i];
    }

    @Override // me.tvspark.C2312kx
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        super.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
        long[] jArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, i);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwww = copyOf;
        Arrays.fill(copyOf, length, i, -1L);
    }

    @Override // me.tvspark.C2312kx
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        int i2 = (int) this.Wwwwwwwwwwwwwwwwwwwwwwwwww[i];
        if (i2 == -2) {
            return -1;
        }
        return i2;
    }

    @Override // me.tvspark.C2312kx
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - 1;
        long[] jArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) (jArr[i] >>> 32), (int) jArr[i]);
        if (i < i2) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) (this.Wwwwwwwwwwwwwwwwwwwwwwwwww[i2] >>> 32), i);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, Wwwwwwwwwwwwwwwwwwwwwwwwww(i2));
        }
        super.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
        if (i == -2) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwww = i2;
        } else {
            long[] jArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
            jArr[i] = (jArr[i] & (-4294967296L)) | (i2 & 4294967295L);
        }
        if (i2 == -2) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = i;
            return;
        }
        long[] jArr2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
        jArr2[i2] = (4294967295L & jArr2[i2]) | (i << 32);
    }

    @Override // me.tvspark.C2312kx
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
        if (i == -2) {
            return -1;
        }
        return i;
    }

    @Override // me.tvspark.C2312kx
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
        return i == this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww ? i2 : i;
    }

    @Override // me.tvspark.C2312kx
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        super.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwwwwwwwwwww = -2;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = -2;
    }

    @Override // me.tvspark.C2312kx
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, float f) {
        super.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, f);
        this.Wwwwwwwwwwwwwwwwwwwwwwwww = -2;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = -2;
        long[] jArr = new long[i];
        this.Wwwwwwwwwwwwwwwwwwwwwwwwww = jArr;
        Arrays.fill(jArr, -1L);
    }

    @Override // me.tvspark.C2312kx
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, K k, int i2, int i3) {
        super.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, k, i2, i3);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, i);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, -2);
    }
}
