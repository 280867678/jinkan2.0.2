package me.tvspark;

import java.io.IOException;

/* renamed from: me.tvspark.s8 */
/* loaded from: classes4.dex */
public final class C2589s8 {
    public static final long[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = {128, 64, 32, 16, 8, 4, 2, 1};
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new byte[8];

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        int i2;
        int i3 = 0;
        do {
            long[] jArr = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i3 >= jArr.length) {
                return -1;
            }
            i2 = ((jArr[i3] & i) > 0L ? 1 : ((jArr[i3] & i) == 0L ? 0 : -1));
            i3++;
        } while (i2 == 0);
        return i3;
    }

    public static long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, int i, boolean z) {
        long j = bArr[0] & 255;
        if (z) {
            j &= ~Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i - 1];
        }
        for (int i2 = 1; i2 < i; i2++) {
            j = (j << 8) | (bArr[i2] & 255);
        }
        return j;
    }

    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2212i7 abstractC2212i7, boolean z, boolean z2, int i) throws IOException {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 0) {
            if (!abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, 1, z)) {
                return -1L;
            }
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[0] & 255);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -1) {
                throw new IllegalStateException("No valid varint length mask found");
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 1;
        }
        int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i2 > i) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
            return -2L;
        }
        if (i2 != 1) {
            abstractC2212i7.readFully(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 1, i2 - 1);
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, z2);
    }
}
