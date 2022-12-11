package me.tvspark;

import com.p038qq.p039e.comm.constants.ErrorCode;

/* renamed from: me.tvspark.y4 */
/* loaded from: classes4.dex */
public final class C2811y4 {
    public static final int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = {ErrorCode.INNER_ERROR, 2000, 1920, 1601, 1600, 1001, 1000, 960, 800, 800, 480, 400, 400, 2048};

    /* renamed from: me.tvspark.y4$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, int i3, int i4, int i5, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i3;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i4;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i5;
        }
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, C2078el c2078el) {
        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(7);
        byte[] bArr = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        bArr[0] = -84;
        bArr[1] = 64;
        bArr[2] = -1;
        bArr[3] = -1;
        bArr[4] = (byte) ((i >> 16) & 255);
        bArr[5] = (byte) ((i >> 8) & 255);
        bArr[6] = (byte) (i & 255);
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0093, code lost:
        if (r10 != 11) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0098, code lost:
        if (r10 != 11) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x009d, code lost:
        if (r10 != 8) goto L44;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2041dl c2041dl) {
        int i;
        int i2;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(16);
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(16);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 == 65535) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(24);
            i = 7;
        } else {
            i = 4;
        }
        int i3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 + i;
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 == 44097) {
            i3 += 2;
        }
        int i4 = i3;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 == 3) {
            int i5 = 0;
            while (true) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2) + i5;
                if (!c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                    break;
                }
                i5 = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 + 1) << 2;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 += Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        }
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(10);
        if (c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() && c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3) > 0) {
            c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
        }
        int i6 = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() ? 48000 : 44100;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
        if (i6 == 44100 && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 == 13) {
            i2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7];
        } else {
            if (i6 == 48000) {
                int[] iArr = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 < iArr.length) {
                    int i7 = iArr[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7];
                    int i8 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 % 5;
                    if (i8 != 1) {
                        if (i8 == 2) {
                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 != 8) {
                            }
                            i7++;
                            i2 = i7;
                        } else if (i8 != 3) {
                            if (i8 == 4) {
                                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 != 3) {
                                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 != 8) {
                                    }
                                }
                                i7++;
                            }
                            i2 = i7;
                        }
                    }
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 != 3) {
                    }
                    i7++;
                    i2 = i7;
                }
            }
            i2 = 0;
        }
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5, 2, i6, i4, i2, null);
    }
}
