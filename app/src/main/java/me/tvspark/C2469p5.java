package me.tvspark;

import java.util.Arrays;
import okhttp3.internal.platform.AndroidPlatform;

/* renamed from: me.tvspark.p5 */
/* loaded from: classes4.dex */
public final class C2469p5 {
    public int Wwwwwwwwwwwww;
    public int Wwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwww;
    public short[] Wwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwww;
    public short[] Wwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwww;
    public short[] Wwwwwwwwwwwwwwwwwwwwwwwww;
    public final short[] Wwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2469p5(int i, int i2, float f, float f2, int i3) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = f;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = f2;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i / i3;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = i / 400;
        int i4 = i / 65;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = i4;
        int i5 = i4 * 2;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = i5;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwww = new short[i5];
        this.Wwwwwwwwwwwwwwwwwwwwwwwww = new short[i5 * i2];
        this.Wwwwwwwwwwwwwwwwwwwwwww = new short[i5 * i2];
        this.Wwwwwwwwwwwwwwwwwwwww = new short[i5 * i2];
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, short[] sArr, int i3, short[] sArr2, int i4, short[] sArr3, int i5) {
        for (int i6 = 0; i6 < i2; i6++) {
            int i7 = (i3 * i2) + i6;
            int i8 = (i5 * i2) + i6;
            int i9 = (i4 * i2) + i6;
            for (int i10 = 0; i10 < i; i10++) {
                sArr[i7] = (short) (((sArr3[i8] * i10) + ((i - i10) * sArr2[i9])) / i);
                i7 += i2;
                i9 += i2;
                i8 += i2;
            }
        }
    }

    public final short[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(short[] sArr, int i, int i2) {
        int length = sArr.length;
        int i3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i4 = length / i3;
        return i + i2 <= i4 ? sArr : Arrays.copyOf(sArr, (((i4 * 3) / 2) + i2) * i3);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(short[] sArr, int i, int i2) {
        int i3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww / i2;
        int i4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i5 = i2 * i4;
        int i6 = i * i4;
        for (int i7 = 0; i7 < i3; i7++) {
            int i8 = 0;
            for (int i9 = 0; i9 < i5; i9++) {
                i8 += sArr[(i7 * i5) + i6 + i9];
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwww[i7] = (short) (i8 / i5);
        }
    }

    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(short[] sArr, int i, int i2, int i3) {
        int i4 = i * this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i5 = 1;
        int i6 = 255;
        int i7 = 0;
        int i8 = 0;
        while (i2 <= i3) {
            int i9 = 0;
            for (int i10 = 0; i10 < i2; i10++) {
                i9 += Math.abs(sArr[i4 + i10] - sArr[(i4 + i2) + i10]);
            }
            if (i9 * i7 < i5 * i2) {
                i7 = i2;
                i5 = i9;
            }
            if (i9 * i6 > i8 * i2) {
                i6 = i2;
                i8 = i9;
            }
            i2++;
        }
        this.Wwwwwwwwwwwwww = i5 / i7;
        this.Wwwwwwwwwwwww = i8 / i6;
        return i7;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8 = this.Wwwwwwwwwwwwwwwwwwwwww;
        float f = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        float f2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        float f3 = f / f2;
        float f4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww * f2;
        double d = f3;
        float f5 = 1.0f;
        int i9 = 1;
        if (d > 1.00001d || d < 0.99999d) {
            int i10 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            if (i10 >= this.Wwwwwwwwwwwwwwwwwwwwwwwwwww) {
                int i11 = 0;
                while (true) {
                    int i12 = this.Wwwwwwwwwwwwwwwww;
                    if (i12 > 0) {
                        int min = Math.min(this.Wwwwwwwwwwwwwwwwwwwwwwwwwww, i12);
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwww, i11, min);
                        this.Wwwwwwwwwwwwwwwww -= min;
                        i11 += min;
                    } else {
                        short[] sArr = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
                        int i13 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        int i14 = i13 > 4000 ? i13 / AndroidPlatform.MAX_LOG_LENGTH : 1;
                        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == i9 && i14 == i9) {
                            i = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sArr, i11, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        } else {
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sArr, i11, i14);
                            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwww, 0, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww / i14, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww / i14);
                            if (i14 != i9) {
                                int i15 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww * i14;
                                int i16 = i14 * 4;
                                int i17 = i15 - i16;
                                int i18 = i15 + i16;
                                int i19 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                if (i17 < i19) {
                                    i17 = i19;
                                }
                                int i20 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                if (i18 > i20) {
                                    i18 = i20;
                                }
                                if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == i9) {
                                    i = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sArr, i11, i17, i18);
                                } else {
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sArr, i11, i9);
                                    i = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwww, 0, i17, i18);
                                }
                            } else {
                                i = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            }
                        }
                        int i21 = this.Wwwwwwwwwwwwww;
                        int i22 = i21 != 0 && this.Wwwwwwwwwwwwwwww != 0 && this.Wwwwwwwwwwwww <= i21 * 3 && i21 * 2 > this.Wwwwwwwwwwwwwww * 3 ? this.Wwwwwwwwwwwwwwww : i;
                        this.Wwwwwwwwwwwwwww = this.Wwwwwwwwwwwwww;
                        this.Wwwwwwwwwwwwwwww = i;
                        if (d > 1.0d) {
                            short[] sArr2 = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
                            if (f3 >= 2.0f) {
                                i3 = (int) (i22 / (f3 - f5));
                            } else {
                                this.Wwwwwwwwwwwwwwwww = (int) (((2.0f - f3) * i22) / (f3 - f5));
                                i3 = i22;
                            }
                            short[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww, i3);
                            this.Wwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            int i23 = i3;
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww, sArr2, i11, sArr2, i11 + i22);
                            this.Wwwwwwwwwwwwwwwwwwwwww += i23;
                            i11 = i22 + i23 + i11;
                        } else {
                            int i24 = i22;
                            short[] sArr3 = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
                            if (f3 < 0.5f) {
                                i2 = (int) ((i24 * f3) / (f5 - f3));
                            } else {
                                this.Wwwwwwwwwwwwwwwww = (int) ((((2.0f * f3) - f5) * i24) / (f5 - f3));
                                i2 = i24;
                            }
                            int i25 = i24 + i2;
                            short[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww, i25);
                            this.Wwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                            int i26 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            System.arraycopy(sArr3, i11 * i26, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, this.Wwwwwwwwwwwwwwwwwwwwww * i26, i26 * i24);
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww + i24, sArr3, i11 + i24, sArr3, i11);
                            this.Wwwwwwwwwwwwwwwwwwwwww += i25;
                            i11 += i2;
                        }
                    }
                    if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwww + i11 > i10) {
                        break;
                    }
                    f5 = 1.0f;
                    i9 = 1;
                }
                int i27 = this.Wwwwwwwwwwwwwwwwwwwwwwww - i11;
                short[] sArr4 = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
                int i28 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                System.arraycopy(sArr4, i11 * i28, sArr4, 0, i28 * i27);
                this.Wwwwwwwwwwwwwwwwwwwwwwww = i27;
            }
            f5 = 1.0f;
        } else {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwww, 0, this.Wwwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwwww = 0;
        }
        if (f4 == f5 || this.Wwwwwwwwwwwwwwwwwwwwww == i8) {
            return;
        }
        int i29 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i30 = (int) (i29 / f4);
        while (true) {
            if (i30 <= 16384 && i29 <= 16384) {
                break;
            }
            i30 /= 2;
            i29 /= 2;
        }
        int i31 = this.Wwwwwwwwwwwwwwwwwwwwww - i8;
        short[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwww, i31);
        this.Wwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
        short[] sArr5 = this.Wwwwwwwwwwwwwwwwwwwwwww;
        int i32 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        System.arraycopy(sArr5, i8 * i32, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, this.Wwwwwwwwwwwwwwwwwwww * i32, i32 * i31);
        this.Wwwwwwwwwwwwwwwwwwwwww = i8;
        this.Wwwwwwwwwwwwwwwwwwww += i31;
        int i33 = 0;
        while (true) {
            i4 = this.Wwwwwwwwwwwwwwwwwwww;
            i5 = i4 - 1;
            if (i33 >= i5) {
                break;
            }
            while (true) {
                i6 = this.Wwwwwwwwwwwwwwwwwww + 1;
                int i34 = i6 * i30;
                i7 = this.Wwwwwwwwwwwwwwwwww;
                if (i34 <= i7 * i29) {
                    break;
                }
                this.Wwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww, 1);
                int i35 = 0;
                while (true) {
                    int i36 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (i35 < i36) {
                        short[] sArr6 = this.Wwwwwwwwwwwwwwwwwwwww;
                        int i37 = (i33 * i36) + i35;
                        short s = sArr6[i37];
                        short s2 = sArr6[i37 + i36];
                        int i38 = this.Wwwwwwwwwwwwwwwwwww;
                        int i39 = i38 * i30;
                        int i40 = (i38 + 1) * i30;
                        int i41 = i40 - (this.Wwwwwwwwwwwwwwwwww * i29);
                        int i42 = i40 - i39;
                        this.Wwwwwwwwwwwwwwwwwwwwwww[(this.Wwwwwwwwwwwwwwwwwwwwww * i36) + i35] = (short) ((((i42 - i41) * s2) + (s * i41)) / i42);
                        i35++;
                    }
                }
                this.Wwwwwwwwwwwwwwwwww++;
                this.Wwwwwwwwwwwwwwwwwwwwww++;
            }
            this.Wwwwwwwwwwwwwwwwwww = i6;
            if (i6 == i29) {
                this.Wwwwwwwwwwwwwwwwwww = 0;
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i7 == i30);
                this.Wwwwwwwwwwwwwwwwww = 0;
            }
            i33++;
        }
        if (i5 == 0) {
            return;
        }
        short[] sArr7 = this.Wwwwwwwwwwwwwwwwwwwww;
        int i43 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        System.arraycopy(sArr7, i5 * i43, sArr7, 0, (i4 - i5) * i43);
        this.Wwwwwwwwwwwwwwwwwwww -= i5;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(short[] sArr, int i, int i2) {
        short[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww, i2);
        this.Wwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        System.arraycopy(sArr, i * i3, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww * i3, i3 * i2);
        this.Wwwwwwwwwwwwwwwwwwwwww += i2;
    }
}
