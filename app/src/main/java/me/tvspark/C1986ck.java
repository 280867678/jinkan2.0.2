package me.tvspark;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* renamed from: me.tvspark.ck */
/* loaded from: classes4.dex */
public final class C1986ck implements AbstractC2637tj {
    public C2600sj[] Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final C2600sj[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public final byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C1986ck(boolean z, int i) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i > 0);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = new C2600sj[100];
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2600sj[1];
    }

    public synchronized void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int i = 0;
        int max = Math.max(0, C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) - this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        if (max >= this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return;
        }
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww - 1;
            while (i <= i2) {
                C2600sj c2600sj = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww[i];
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2600sj);
                C2600sj c2600sj2 = c2600sj;
                if (c2600sj2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    i++;
                } else {
                    C2600sj c2600sj3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww[i2];
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2600sj3);
                    C2600sj c2600sj4 = c2600sj3;
                    if (c2600sj4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                        i2--;
                    } else {
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww[i] = c2600sj4;
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww[i2] = c2600sj2;
                        i2--;
                        i++;
                    }
                }
            }
            max = Math.max(max, i);
            if (max >= this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                return;
            }
        }
        Arrays.fill(this.Wwwwwwwwwwwwwwwwwwwwwwwwwww, max, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww, (Object) null);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = max;
    }

    public synchronized void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
        }
    }

    public synchronized int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww * this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public synchronized C2600sj Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        C2600sj c2600sj;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww++;
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww > 0) {
            C2600sj[] c2600sjArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww - 1;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            c2600sj = c2600sjArr[i];
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2600sj);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww[this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww] = null;
        } else {
            c2600sj = new C2600sj(new byte[this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww], 0);
        }
        return c2600sj;
    }

    public synchronized void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        boolean z = i < this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        if (z) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    public synchronized void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2600sj c2600sj) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[0] = c2600sj;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public synchronized void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2600sj[] c2600sjArr) {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww + c2600sjArr.length >= this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.length) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = (C2600sj[]) Arrays.copyOf(this.Wwwwwwwwwwwwwwwwwwwwwwwwwww, Math.max(this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.length * 2, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww + c2600sjArr.length));
        }
        for (C2600sj c2600sj : c2600sjArr) {
            C2600sj[] c2600sjArr2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = i + 1;
            c2600sjArr2[i] = c2600sj;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww -= c2600sjArr.length;
        notifyAll();
    }
}
