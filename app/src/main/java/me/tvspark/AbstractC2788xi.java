package me.tvspark;

import android.os.SystemClock;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.List;

/* renamed from: me.tvspark.xi */
/* loaded from: classes4.dex */
public abstract class AbstractC2788xi implements AbstractC1985cj {
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final long[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final C2245j3[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final C2331lf Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public AbstractC2788xi(C2331lf c2331lf, int... iArr) {
        int i = 0;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iArr.length > 0);
        if (c2331lf != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2331lf;
            int length = iArr.length;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = length;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2245j3[length];
            for (int i2 = 0; i2 < iArr.length; i2++) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i2] = c2331lf.Wwwwwwwwwwwwwwwwwwwwwww[iArr[i2]];
            }
            Arrays.sort(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, C2636ti.Wwwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new int[this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww];
            while (true) {
                int i3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (i >= i3) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new long[i3];
                    return;
                } else {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i] = c2331lf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i]);
                    i++;
                }
            }
        } else {
            throw null;
        }
    }

    public static /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2245j3 c2245j3, C2245j3 c2245j32) {
        return c2245j32.Wwwwwwwwwwwwwwwww - c2245j3.Wwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.AbstractC1985cj
    public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        C1948bj.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
    }

    @Override // me.tvspark.AbstractC1985cj
    public final C2245j3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()];
    }

    @Override // me.tvspark.AbstractC1985cj
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()];
    }

    @Override // me.tvspark.AbstractC1985cj
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        for (int i2 = 0; i2 < this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww; i2++) {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    @Override // me.tvspark.AbstractC1985cj
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i];
    }

    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, long j) {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i] > j;
    }

    @Override // me.tvspark.AbstractC1985cj
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, List<? extends AbstractC2559rf> list) {
        return list.size();
    }

    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2245j3 c2245j3) {
        for (int i = 0; i < this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww; i++) {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i] == c2245j3) {
                return i;
            }
        }
        return -1;
    }

    @Override // me.tvspark.AbstractC1985cj
    public final C2245j3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i];
    }

    @Override // me.tvspark.AbstractC1985cj
    public final C2331lf Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.AbstractC1985cj
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f) {
    }

    @Override // me.tvspark.AbstractC1985cj
    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, long j) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, elapsedRealtime);
        int i2 = 0;
        while (i2 < this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2 != i && !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, elapsedRealtime);
            i2++;
        }
        if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return false;
        }
        long[] jArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        jArr[i] = Math.max(jArr[i], C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(elapsedRealtime, j, Long.MAX_VALUE));
        return true;
    }

    @Override // me.tvspark.AbstractC1985cj
    public /* synthetic */ boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, AbstractC2479pf abstractC2479pf, List<? extends AbstractC2559rf> list) {
        return C1948bj.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, j, abstractC2479pf, list);
    }

    @Override // me.tvspark.AbstractC1985cj
    public void disable() {
    }

    @Override // me.tvspark.AbstractC1985cj
    public void enable() {
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AbstractC2788xi abstractC2788xi = (AbstractC2788xi) obj;
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == abstractC2788xi.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && Arrays.equals(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, abstractC2788xi.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public int hashCode() {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww == 0) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = Arrays.hashCode(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) + (System.identityHashCode(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) * 31);
        }
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.AbstractC1985cj
    public final int length() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length;
    }
}
