package me.tvspark;

import java.io.IOException;

/* renamed from: me.tvspark.o9 */
/* loaded from: classes4.dex */
public final class C2436o9 {
    public static final int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1635148593, 1752589105, 1751479857, 1635135537, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, 1903435808, 1297305174, 1684175153, 1769172332, 1885955686};

    /* JADX WARN: Removed duplicated region for block: B:40:0x00d9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00db A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2212i7 abstractC2212i7, boolean z) throws IOException {
        boolean z2;
        boolean z3;
        long length = abstractC2212i7.getLength();
        long j = 4096;
        long j2 = -1;
        int i = (length > (-1L) ? 1 : (length == (-1L) ? 0 : -1));
        if (i != 0 && length <= 4096) {
            j = length;
        }
        int i2 = (int) j;
        C2078el c2078el = new C2078el(64);
        boolean z4 = false;
        int i3 = 0;
        boolean z5 = false;
        while (i3 < i2) {
            c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(8);
            byte[] bArr = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i4 = z4 ? 1 : 0;
            int i5 = z4 ? 1 : 0;
            int i6 = z4 ? 1 : 0;
            int i7 = z4 ? 1 : 0;
            if (!abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, i4, 8, true)) {
                break;
            }
            long Wwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwww();
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            int i8 = 16;
            if (Wwwwwwwwwwwwwwwwwwwww == 1) {
                abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 8, 8);
                c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(16);
                Wwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwww();
            } else {
                if (Wwwwwwwwwwwwwwwwwwwww == 0) {
                    long length2 = abstractC2212i7.getLength();
                    if (length2 != j2) {
                        Wwwwwwwwwwwwwwwwwwwww = (length2 - abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) + 8;
                    }
                }
                i8 = 8;
            }
            long j3 = i8;
            if (Wwwwwwwwwwwwwwwwwwwww < j3) {
                return z4;
            }
            i3 += i8;
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 1836019574) {
                i2 += (int) Wwwwwwwwwwwwwwwwwwwww;
                if (i != 0 && i2 > length) {
                    i2 = (int) length;
                }
                j2 = -1;
            } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 1836019558 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 1836475768) {
                z2 = true;
                break;
            } else {
                long j4 = length;
                if ((i3 + Wwwwwwwwwwwwwwwwwwwww) - j3 >= i2) {
                    break;
                }
                int i9 = (int) (Wwwwwwwwwwwwwwwwwwwww - j3);
                i3 += i9;
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 1718909296) {
                    if (i9 < 8) {
                        return false;
                    }
                    c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i9);
                    abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, i9);
                    int i10 = i9 / 4;
                    int i11 = 0;
                    while (true) {
                        if (i11 >= i10) {
                            break;
                        }
                        if (i11 == 1) {
                            c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
                        } else {
                            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                            if ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 >>> 8) != 3368816) {
                                for (int i12 : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                                    if (i12 != Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) {
                                    }
                                }
                                z3 = false;
                                if (!z3) {
                                    z5 = true;
                                    break;
                                }
                            }
                            z3 = true;
                            if (!z3) {
                            }
                        }
                        i11++;
                    }
                    if (!z5) {
                        return false;
                    }
                } else if (i9 != 0) {
                    abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i9);
                }
                length = j4;
                j2 = -1;
                z4 = false;
            }
        }
        z2 = false;
        return z5 && z == z2;
    }
}
