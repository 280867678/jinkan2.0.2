package org.mozilla.javascript.v8dtoa;

import me.tvspark.outline;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: classes5.dex */
public class DiyFp {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int kSignificandSize = 64;
    public static final long kUint64MSB = Long.MIN_VALUE;

    /* renamed from: e */
    public int f4754e;

    /* renamed from: f */
    public long f4755f;

    public DiyFp() {
        this.f4755f = 0L;
        this.f4754e = 0;
    }

    public DiyFp(long j, int i) {
        this.f4755f = j;
        this.f4754e = i;
    }

    public static DiyFp minus(DiyFp diyFp, DiyFp diyFp2) {
        DiyFp diyFp3 = new DiyFp(diyFp.f4755f, diyFp.f4754e);
        diyFp3.subtract(diyFp2);
        return diyFp3;
    }

    public static DiyFp normalize(DiyFp diyFp) {
        DiyFp diyFp2 = new DiyFp(diyFp.f4755f, diyFp.f4754e);
        diyFp2.normalize();
        return diyFp2;
    }

    public static DiyFp times(DiyFp diyFp, DiyFp diyFp2) {
        DiyFp diyFp3 = new DiyFp(diyFp.f4755f, diyFp.f4754e);
        diyFp3.multiply(diyFp2);
        return diyFp3;
    }

    public static boolean uint64_gte(long j, long j2) {
        int i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
        if (i != 0) {
            if (!(((j < 0) ^ (i > 0)) ^ (j2 < 0))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: e */
    public int m14e() {
        return this.f4754e;
    }

    /* renamed from: f */
    public long m13f() {
        return this.f4755f;
    }

    public void multiply(DiyFp diyFp) {
        long j = this.f4755f;
        long j2 = j >>> 32;
        long j3 = j & 4294967295L;
        long j4 = diyFp.f4755f;
        long j5 = j4 >>> 32;
        long j6 = j4 & 4294967295L;
        long j7 = j2 * j5;
        long j8 = j5 * j3;
        long j9 = j2 * j6;
        long j10 = j7 + (j9 >>> 32) + (j8 >>> 32) + ((((((j3 * j6) >>> 32) + (j9 & 4294967295L)) + (4294967295L & j8)) + IjkMediaMeta.AV_CH_WIDE_LEFT) >>> 32);
        this.f4754e = diyFp.f4754e + 64 + this.f4754e;
        this.f4755f = j10;
    }

    public void normalize() {
        long j = this.f4755f;
        int i = this.f4754e;
        while (((-18014398509481984L) & j) == 0) {
            j <<= 10;
            i -= 10;
        }
        while ((Long.MIN_VALUE & j) == 0) {
            j <<= 1;
            i--;
        }
        this.f4755f = j;
        this.f4754e = i;
    }

    public void setE(int i) {
        this.f4754e = i;
    }

    public void setF(long j) {
        this.f4755f = j;
    }

    public void subtract(DiyFp diyFp) {
        this.f4755f -= diyFp.f4755f;
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("[DiyFp f:");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.f4755f);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", e:");
        return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.f4754e, "]");
    }
}
