package me.tvspark;

import android.media.MediaCodec;
import android.os.Looper;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.DrmSession;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import me.tvspark.AbstractC2396n6;
import me.tvspark.AbstractC2740w7;
import me.tvspark.C2109ff;
import me.tvspark.C2245j3;
import me.tvspark.C2623t5;

/* renamed from: me.tvspark.gf */
/* loaded from: classes4.dex */
public class C2146gf implements AbstractC2740w7 {
    public boolean Kkkkkkkkkkkkkkkkkkkkkkkk;
    public long Kkkkkkkkkkkkkkkkkkkkkkkkk;
    public boolean Kkkkkkkkkkkkkkkkkkkkkkkkkk;
    public boolean Www;
    public int Wwww;
    @Nullable
    public C2245j3 Wwwww;
    @Nullable
    public C2245j3 Wwwwww;
    @Nullable
    public C2245j3 Wwwwwww;
    public boolean Wwwwwwww;
    public boolean Wwwwwwwwwww;
    public int Wwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwww;
    @Nullable
    public DrmSession Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public C2245j3 Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final AbstractC2396n6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final AbstractC2470p6 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Looper Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final C2109ff Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public int Wwwwwwwwwwwwwwwwwwwwwwwwww = 1000;
    public int[] Wwwwwwwwwwwwwwwwwwwwwwwww = new int[1000];
    public long[] Wwwwwwwwwwwwwwwwwwwwwwww = new long[1000];
    public long[] Wwwwwwwwwwwwwwwwwwwww = new long[1000];
    public int[] Wwwwwwwwwwwwwwwwwwwwww = new int[1000];
    public int[] Wwwwwwwwwwwwwwwwwwwwwww = new int[1000];
    public AbstractC2740w7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[] Wwwwwwwwwwwwwwwwwwww = new AbstractC2740w7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[1000];
    public C2245j3[] Wwwwwwwwwwwwwwwwwww = new C2245j3[1000];
    public long Wwwwwwwwwwwwww = Long.MIN_VALUE;
    public long Wwwwwwwwwwwww = Long.MIN_VALUE;
    public long Wwwwwwwwwwww = Long.MIN_VALUE;
    public boolean Wwwwwwwww = true;
    public boolean Wwwwwwwwww = true;

    /* renamed from: me.tvspark.gf$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2245j3 c2245j3);
    }

    /* renamed from: me.tvspark.gf$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        @Nullable
        public AbstractC2740w7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public C2146gf(AbstractC2637tj abstractC2637tj, Looper looper, AbstractC2470p6 abstractC2470p6, AbstractC2396n6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = looper;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2470p6;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2109ff(abstractC2637tj);
    }

    public final synchronized void Wwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwww = 0;
        C2109ff c2109ff = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        c2109ff.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2109ff.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public final synchronized int Wwwwwwwwwwwwwwwwwwwwwwww() {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwww() ? this.Wwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwww)] : this.Wwww;
    }

    @CallSuper
    public void Wwwwwwwwwwwwwwwwwwwwwwwww() throws IOException {
        DrmSession drmSession = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (drmSession == null || drmSession.getState() != 1) {
            return;
        }
        DrmSession.DrmSessionException Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        throw Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public final synchronized boolean Wwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwww;
    }

    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwww != this.Wwwwwwwwwwwwwwwwww;
    }

    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwww + this.Wwwwwwwwwwwwwwwwww;
    }

    @Nullable
    public final synchronized C2245j3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwww ? null : this.Wwwwww;
    }

    public final synchronized void Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        boolean z;
        if (i >= 0) {
            try {
                if (this.Wwwwwwwwwwwwwww + i <= this.Wwwwwwwwwwwwwwwwww) {
                    z = true;
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z);
                    this.Wwwwwwwwwwwwwww += i;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        z = false;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z);
        this.Wwwwwwwwwwwwwww += i;
    }

    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwww + this.Wwwwwwwwwwwwwww;
    }

    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        DrmSession drmSession = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        return drmSession == null || drmSession.getState() == 4 || ((this.Wwwwwwwwwwwwwwwwwwwwww[i] & 1073741824) == 0 && this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
    }

    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        int i2 = this.Wwwwwwwwwwwwwwww + i;
        int i3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
        return i2 < i3 ? i2 : i2 - i3;
    }

    public final synchronized long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return Math.max(this.Wwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwww));
    }

    public final synchronized long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwww;
    }

    public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        long j = Long.MIN_VALUE;
        if (i == 0) {
            return Long.MIN_VALUE;
        }
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i - 1);
        for (int i2 = 0; i2 < i; i2++) {
            j = Math.max(j, this.Wwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww]);
            if ((this.Wwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww] & 1) != 0) {
                break;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww--;
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -1) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwww - 1;
            }
        }
        return j;
    }

    public final synchronized boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2245j3 c2245j3) {
        this.Wwwwwwwww = false;
        if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3, this.Wwwwww)) {
            return false;
        }
        if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3, this.Wwwww)) {
            c2245j3 = this.Wwwww;
        }
        this.Wwwwww = c2245j3;
        this.Www = C1950bl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwww.Wwwwwwwwwwwww, this.Wwwwww.Wwwwwwwwwwwwwwww);
        this.Kkkkkkkkkkkkkkkkkkkkkkkkkk = false;
        return true;
    }

    public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwww() - i;
        boolean z = false;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwww >= 0 && Wwwwwwwwwwwwwwwwwwwwwwwwwwww <= this.Wwwwwwwwwwwwwwwwww - this.Wwwwwwwwwwwwwww);
        int i2 = this.Wwwwwwwwwwwwwwwwww - Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwww = i2;
        this.Wwwwwwwwwwww = Math.max(this.Wwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2));
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwww == 0 && this.Wwwwwwwwwww) {
            z = true;
        }
        this.Wwwwwwwwwww = z;
        int i3 = this.Wwwwwwwwwwwwwwwwww;
        if (i3 != 0) {
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3 - 1);
            return this.Wwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww] + this.Wwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww];
        }
        return 0L;
    }

    @CallSuper
    public C2245j3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2245j3 c2245j3) {
        if (this.Kkkkkkkkkkkkkkkkkkkkkkkkk == 0 || c2245j3.Wwwwwwwww == Long.MAX_VALUE) {
            return c2245j3;
        }
        C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwww = c2245j3.Wwwwwwwww + this.Kkkkkkkkkkkkkkkkkkkkkkkkk;
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
    }

    public final synchronized boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, boolean z) {
        Wwwwwwwwwwwwwwwwwwwwwww();
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwww);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwww() && j >= this.Wwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww] && (j <= this.Wwwwwwwwwwww || z)) {
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwww - this.Wwwwwwwwwwwwwww, j, true);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == -1) {
                return false;
            }
            this.Wwwwwwwwwwwwww = j;
            this.Wwwwwwwwwwwwwww += Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            return true;
        }
        return false;
    }

    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, long j, boolean z) {
        int i3 = -1;
        for (int i4 = 0; i4 < i2 && this.Wwwwwwwwwwwwwwwwwwwww[i] <= j; i4++) {
            if (!z || (this.Wwwwwwwwwwwwwwwwwwwwww[i] & 1) != 0) {
                i3 = i4;
            }
            i++;
            if (i == this.Wwwwwwwwwwwwwwwwwwwwwwwwww) {
                i = 0;
            }
        }
        return i3;
    }

    public final synchronized int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, boolean z) {
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwww);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwww() && j >= this.Wwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww]) {
            if (j > this.Wwwwwwwwwwww && z) {
                return this.Wwwwwwwwwwwwwwwwww - this.Wwwwwwwwwwwwwww;
            }
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwww - this.Wwwwwwwwwwwwwww, j, true);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != -1) {
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            }
            return 0;
        }
        return 0;
    }

    @Override // me.tvspark.AbstractC2740w7
    public /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2752wj abstractC2752wj, int i, boolean z) throws IOException {
        return C2700v7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, abstractC2752wj, i, z);
    }

    public final synchronized long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (this.Wwwwwwwwwwwwwwwwww == 0) {
            return -1L;
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwww);
    }

    public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        int i2;
        this.Wwwwwwwwwwwww = Math.max(this.Wwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i));
        this.Wwwwwwwwwwwwwwwwww -= i;
        this.Wwwwwwwwwwwwwwwww += i;
        int i3 = this.Wwwwwwwwwwwwwwww + i;
        this.Wwwwwwwwwwwwwwww = i3;
        int i4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i3 >= i4) {
            this.Wwwwwwwwwwwwwwww = i3 - i4;
        }
        int i5 = this.Wwwwwwwwwwwwwww - i;
        this.Wwwwwwwwwwwwwww = i5;
        if (i5 < 0) {
            this.Wwwwwwwwwwwwwww = 0;
        }
        if (this.Wwwwwwwwwwwwwwwwww == 0) {
            int i6 = this.Wwwwwwwwwwwwwwww;
            if (i6 == 0) {
                i6 = this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            return this.Wwwwwwwwwwwwwwwwwwwwwwww[i6 - 1] + this.Wwwwwwwwwwwwwwwwwwwwwww[i2];
        }
        return this.Wwwwwwwwwwwwwwwwwwwwwwww[this.Wwwwwwwwwwwwwwww];
    }

    public final synchronized long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, boolean z, boolean z2) {
        if (this.Wwwwwwwwwwwwwwwwww != 0 && j >= this.Wwwwwwwwwwwwwwwwwwwww[this.Wwwwwwwwwwwwwwww]) {
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwww, (!z2 || this.Wwwwwwwwwwwwwww == this.Wwwwwwwwwwwwwwwwww) ? this.Wwwwwwwwwwwwwwwwww : this.Wwwwwwwwwwwwwww + 1, j, z);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == -1) {
                return -1L;
            }
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        }
        return -1L;
    }

    public final synchronized void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, int i, long j2, int i2, @Nullable AbstractC2740w7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        if (this.Wwwwwwwwwwwwwwwwww > 0) {
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwww - 1);
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww] + ((long) this.Wwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww]) <= j2);
        }
        this.Wwwwwwwwwww = (536870912 & i) != 0;
        this.Wwwwwwwwwwww = Math.max(this.Wwwwwwwwwwww, j);
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2] = j;
        this.Wwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2] = j2;
        this.Wwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2] = i2;
        this.Wwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2] = i;
        this.Wwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2] = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2] = this.Wwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2] = this.Wwww;
        this.Wwwww = this.Wwwwww;
        int i3 = this.Wwwwwwwwwwwwwwwwww + 1;
        this.Wwwwwwwwwwwwwwwwww = i3;
        if (i3 == this.Wwwwwwwwwwwwwwwwwwwwwwwwww) {
            int i4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwww + 1000;
            int[] iArr = new int[i4];
            long[] jArr = new long[i4];
            long[] jArr2 = new long[i4];
            int[] iArr2 = new int[i4];
            int[] iArr3 = new int[i4];
            AbstractC2740w7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[] wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr = new AbstractC2740w7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i4];
            C2245j3[] c2245j3Arr = new C2245j3[i4];
            int i5 = this.Wwwwwwwwwwwwwwwwwwwwwwwwww - this.Wwwwwwwwwwwwwwww;
            System.arraycopy(this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwww, jArr, 0, i5);
            System.arraycopy(this.Wwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwww, jArr2, 0, i5);
            System.arraycopy(this.Wwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwww, iArr2, 0, i5);
            System.arraycopy(this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwww, iArr3, 0, i5);
            System.arraycopy(this.Wwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr, 0, i5);
            System.arraycopy(this.Wwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwww, c2245j3Arr, 0, i5);
            System.arraycopy(this.Wwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwww, iArr, 0, i5);
            int i6 = this.Wwwwwwwwwwwwwwww;
            System.arraycopy(this.Wwwwwwwwwwwwwwwwwwwwwwww, 0, jArr, i5, i6);
            System.arraycopy(this.Wwwwwwwwwwwwwwwwwwwww, 0, jArr2, i5, i6);
            System.arraycopy(this.Wwwwwwwwwwwwwwwwwwwwww, 0, iArr2, i5, i6);
            System.arraycopy(this.Wwwwwwwwwwwwwwwwwwwwwww, 0, iArr3, i5, i6);
            System.arraycopy(this.Wwwwwwwwwwwwwwwwwwww, 0, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr, i5, i6);
            System.arraycopy(this.Wwwwwwwwwwwwwwwwwww, 0, c2245j3Arr, i5, i6);
            System.arraycopy(this.Wwwwwwwwwwwwwwwwwwwwwwwww, 0, iArr, i5, i6);
            this.Wwwwwwwwwwwwwwwwwwwwwwww = jArr;
            this.Wwwwwwwwwwwwwwwwwwwww = jArr2;
            this.Wwwwwwwwwwwwwwwwwwwwww = iArr2;
            this.Wwwwwwwwwwwwwwwwwwwwwww = iArr3;
            this.Wwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr;
            this.Wwwwwwwwwwwwwwwwwww = c2245j3Arr;
            this.Wwwwwwwwwwwwwwwwwwwwwwwww = iArr;
            this.Wwwwwwwwwwwwwwww = 0;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwww = i4;
        }
    }

    @Override // me.tvspark.AbstractC2740w7
    public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el, int i) {
        C2700v7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, c2078el, i);
    }

    @Override // me.tvspark.AbstractC2740w7
    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2245j3 c2245j3) {
        C2245j3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3);
        this.Wwwwwwww = false;
        this.Wwwwwww = c2245j3;
        boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null || !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return;
        }
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2245j3 c2245j3, C2282k3 c2282k3) {
        boolean z = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww == null;
        C2322l6 c2322l6 = z ? null : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = c2245j3;
        C2322l6 c2322l62 = c2245j3.Wwwwwwwwww;
        c2282k3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3));
        c2282k3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (z || !C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2322l6, c2322l62)) {
            DrmSession drmSession = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
            DrmSession Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2245j3);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            c2282k3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            if (drmSession == null) {
                return;
            }
            drmSession.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    public final synchronized boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        boolean z = true;
        if (this.Wwwwwwwwwwwwwwwwww == 0) {
            if (j <= this.Wwwwwwwwwwwww) {
                z = false;
            }
            return z;
        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() >= j) {
            return false;
        } else {
            int i = this.Wwwwwwwwwwwwwwwwww;
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i - 1);
            while (i > this.Wwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww] >= j) {
                i--;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww--;
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -1) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwww - 1;
                }
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwww + i);
            return true;
        }
    }

    @CallSuper
    public synchronized boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
        boolean z2 = true;
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwww);
            if (this.Wwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww] != this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                return true;
            }
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        if (!z && !this.Wwwwwwwwwww && (this.Wwwwww == null || this.Wwwwww == this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
            z2 = false;
        }
        return z2;
    }

    @CallSuper
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
        C2109ff c2109ff = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        c2109ff.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2109ff.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        C2109ff.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2109ff.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0L, c2109ff.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        c2109ff.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        c2109ff.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        c2109ff.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        c2109ff.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = 0L;
        ((C1986ck) c2109ff.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwwww = 0;
        this.Wwwwwwwwwwwwwwwww = 0;
        this.Wwwwwwwwwwwwwwww = 0;
        this.Wwwwwwwwwwwwwww = 0;
        this.Wwwwwwwwww = true;
        this.Wwwwwwwwwwwwww = Long.MIN_VALUE;
        this.Wwwwwwwwwwwww = Long.MIN_VALUE;
        this.Wwwwwwwwwwww = Long.MIN_VALUE;
        this.Wwwwwwwwwww = false;
        this.Wwwww = null;
        if (z) {
            this.Wwwwwww = null;
            this.Wwwwww = null;
            this.Wwwwwwwww = true;
        }
    }

    @CallSuper
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2282k3 c2282k3, C2738w5 c2738w5, boolean z, boolean z2) {
        long j;
        ByteBuffer byteBuffer;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2282k3, c2738w5, z, z2, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == -4 && !c2738w5.isEndOfStream()) {
            int i = 1;
            if (!(c2738w5.Wwwwwwwwwwwwwwwwwwwwwww == null && c2738w5.Wwwwwwwwwwwwwwwwwww == 0)) {
                C2109ff c2109ff = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (c2109ff == null) {
                    throw null;
                }
                if (c2738w5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                    long j2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    c2109ff.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
                    c2109ff.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j2, c2109ff.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 1);
                    long j3 = j2 + 1;
                    byte b = c2109ff.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[0];
                    boolean z3 = (b & 128) != 0;
                    int i2 = b & Byte.MAX_VALUE;
                    C2623t5 c2623t5 = c2738w5.Wwwwwwwwwwwwwwwwwwwwwwww;
                    byte[] bArr = c2623t5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (bArr == null) {
                        c2623t5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new byte[16];
                    } else {
                        Arrays.fill(bArr, (byte) 0);
                    }
                    c2109ff.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j3, c2623t5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i2);
                    long j4 = j3 + i2;
                    if (z3) {
                        c2109ff.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
                        c2109ff.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j4, c2109ff.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 2);
                        j4 += 2;
                        i = c2109ff.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwww();
                    }
                    int[] iArr = c2623t5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (iArr == null || iArr.length < i) {
                        iArr = new int[i];
                    }
                    int[] iArr2 = c2623t5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (iArr2 == null || iArr2.length < i) {
                        iArr2 = new int[i];
                    }
                    if (z3) {
                        int i3 = i * 6;
                        c2109ff.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3);
                        c2109ff.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j4, c2109ff.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i3);
                        j4 += i3;
                        c2109ff.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
                        for (int i4 = 0; i4 < i; i4++) {
                            iArr[i4] = c2109ff.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwww();
                            iArr2[i4] = c2109ff.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww();
                        }
                    } else {
                        iArr[0] = 0;
                        iArr2[0] = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - ((int) (j4 - wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
                    }
                    AbstractC2740w7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                    byte[] bArr2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    byte[] bArr3 = c2623t5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    int i5 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    int i6 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    int i7 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    c2623t5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
                    c2623t5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = iArr;
                    c2623t5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = iArr2;
                    c2623t5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = bArr2;
                    c2623t5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = bArr3;
                    c2623t5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i5;
                    c2623t5.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = i6;
                    c2623t5.Wwwwwwwwwwwwwwwwwwwwwwwwwww = i7;
                    MediaCodec.CryptoInfo cryptoInfo = c2623t5.Wwwwwwwwwwwwwwwwwwwwwwwwww;
                    cryptoInfo.numSubSamples = i;
                    cryptoInfo.numBytesOfClearData = iArr;
                    cryptoInfo.numBytesOfEncryptedData = iArr2;
                    cryptoInfo.key = bArr2;
                    cryptoInfo.iv = bArr3;
                    cryptoInfo.mode = i5;
                    if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 24) {
                        C2623t5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2623t5.Wwwwwwwwwwwwwwwwwwwwwwwww;
                        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.set(i6, i7);
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setPattern(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    }
                    long j5 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    int i8 = (int) (j4 - j5);
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j5 + i8;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww -= i8;
                }
                if (c2738w5.hasSupplementalData()) {
                    c2109ff.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
                    c2109ff.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2109ff.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 4);
                    int Wwwwwwwwwwwwwwwwwww = c2109ff.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww();
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += 4;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww -= 4;
                    c2738w5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwww);
                    c2109ff.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2738w5.Wwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwww);
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += Wwwwwwwwwwwwwwwwwww;
                    int i9 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - Wwwwwwwwwwwwwwwwwww;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i9;
                    ByteBuffer byteBuffer2 = c2738w5.Wwwwwwwwwwwwwwwwwwww;
                    if (byteBuffer2 == null || byteBuffer2.capacity() < i9) {
                        c2738w5.Wwwwwwwwwwwwwwwwwwww = ByteBuffer.allocate(i9);
                    } else {
                        c2738w5.Wwwwwwwwwwwwwwwwwwww.clear();
                    }
                    j = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    byteBuffer = c2738w5.Wwwwwwwwwwwwwwwwwwww;
                } else {
                    c2738w5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    j = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    byteBuffer = c2738w5.Wwwwwwwwwwwwwwwwwwwwwww;
                }
                c2109ff.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, byteBuffer, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
    }

    public final synchronized int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2282k3 c2282k3, C2738w5 c2738w5, boolean z, boolean z2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        boolean z3 = false;
        c2738w5.Wwwwwwwwwwwwwwwwwwwwww = false;
        if (!Wwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            if (!z2 && !this.Wwwwwwwwwww) {
                if (this.Wwwwww == null || (!z && this.Wwwwww == this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                    return -3;
                }
                C2245j3 c2245j3 = this.Wwwwww;
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3, c2282k3);
                return -5;
            }
            c2738w5.setFlags(4);
            return -4;
        }
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwww);
        if (!z && this.Wwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww] == this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                c2738w5.Wwwwwwwwwwwwwwwwwwwwww = true;
                return -3;
            }
            c2738w5.setFlags(this.Wwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww]);
            long j = this.Wwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww];
            c2738w5.Wwwwwwwwwwwwwwwwwwwww = j;
            if (j < this.Wwwwwwwwwwwwww) {
                c2738w5.addFlag(Integer.MIN_VALUE);
            }
            if (c2738w5.Wwwwwwwwwwwwwwwwwwwwwww == null && c2738w5.Wwwwwwwwwwwwwwwwwww == 0) {
                z3 = true;
            }
            if (z3) {
                return -4;
            }
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww];
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww];
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww];
            this.Wwwwwwwwwwwwwww++;
            return -4;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww], c2282k3);
        return -5;
    }

    @Override // me.tvspark.AbstractC2740w7
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2752wj abstractC2752wj, int i, boolean z, int i2) throws IOException {
        C2109ff c2109ff = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2109ff.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
        C2109ff.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2109ff.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int read = abstractC2752wj.read(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2109ff.Wwwwwwwwwwwwwwwwwwwwwwwwwwww), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        if (read != -1) {
            c2109ff.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(read);
            return read;
        } else if (!z) {
            throw new EOFException();
        } else {
            return -1;
        }
    }

    @Override // me.tvspark.AbstractC2740w7
    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el, int i, int i2) {
        C2109ff c2109ff = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (c2109ff != null) {
            while (i > 0) {
                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2109ff.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
                C2109ff.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2109ff.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2109ff.Wwwwwwwwwwwwwwwwwwwwwwwwwwww), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                i -= Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                c2109ff.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            }
            return;
        }
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0049  */
    @Override // me.tvspark.AbstractC2740w7
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, int i, int i2, int i3, @Nullable AbstractC2740w7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        int i4;
        if (this.Wwwwwwww) {
            C2245j3 c2245j3 = this.Wwwwwww;
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3);
        }
        int i5 = i & 1;
        boolean z = i5 != 0;
        if (this.Wwwwwwwwww) {
            if (!z) {
                return;
            }
            this.Wwwwwwwwww = false;
        }
        long j2 = this.Kkkkkkkkkkkkkkkkkkkkkkkkk + j;
        if (this.Www) {
            if (j2 < this.Wwwwwwwwwwwwww) {
                return;
            }
            if (i5 == 0) {
                if (!this.Kkkkkkkkkkkkkkkkkkkkkkkkkk) {
                    String.valueOf(this.Wwwwww).length();
                    this.Kkkkkkkkkkkkkkkkkkkkkkkkkk = true;
                }
                i4 = i | 1;
                if (this.Kkkkkkkkkkkkkkkkkkkkkkkk) {
                    if (!z || !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j2)) {
                        return;
                    }
                    this.Kkkkkkkkkkkkkkkkkkkkkkkk = false;
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j2, i4, (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww - i2) - i3, i2, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
        }
        i4 = i;
        if (this.Kkkkkkkkkkkkkkkkkkkkkkkk) {
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j2, i4, (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww - i2) - i3, i2, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }
}
