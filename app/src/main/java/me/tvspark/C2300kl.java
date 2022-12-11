package me.tvspark;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* renamed from: me.tvspark.kl */
/* loaded from: classes4.dex */
public final class C2300kl<V> {
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public long[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new long[10];
    public V[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (V[]) new Object[10];

    public synchronized int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Nullable
    public final V Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww > 0);
        V[] vArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        V v = vArr[i];
        vArr[i] = null;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (i + 1) % vArr.length;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww--;
        return v;
    }

    @Nullable
    public synchronized V Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 0 ? null : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int length = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length;
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < length) {
            return;
        }
        int i = length * 2;
        long[] jArr = new long[i];
        V[] vArr = (V[]) new Object[i];
        int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i3 = length - i2;
        System.arraycopy(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i2, jArr, 0, i3);
        System.arraycopy(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, vArr, 0, i3);
        int i4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i4 > 0) {
            System.arraycopy(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, jArr, i3, i4);
            System.arraycopy(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, vArr, i3, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = jArr;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = vArr;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
    }

    public synchronized void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        Arrays.fill(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, (Object) null);
    }

    public synchronized void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, V v) {
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i > 0) {
            if (j <= this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[((this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + i) - 1) % this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length]) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        V[] vArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int length = (i2 + i3) % vArr.length;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[length] = j;
        vArr[length] = v;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i3 + 1;
    }

    @Nullable
    public synchronized V Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        V v;
        v = null;
        while (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww > 0 && j - this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww] >= 0) {
            v = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        return v;
    }
}
