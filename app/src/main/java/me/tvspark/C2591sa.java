package me.tvspark;

import android.util.Pair;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Collections;
import me.tvspark.AbstractC2327lb;
import me.tvspark.C2245j3;

/* renamed from: me.tvspark.sa */
/* loaded from: classes4.dex */
public final class C2591sa implements AbstractC2554ra {
    public static final double[] Wwwwwwwwwwwwwwwwww = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};
    public boolean Wwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public final C2854za Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public final C2078el Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public final C2364mb Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public AbstractC2740w7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final boolean[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = new boolean[4];
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(128);

    /* renamed from: me.tvspark.sa$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public static final byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = {0, 0, 1};
        public byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new byte[i];
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, int i, int i2) {
            if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                return;
            }
            int i3 = i2 - i;
            byte[] bArr2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int length = bArr2.length;
            int i4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (length < i4 + i3) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Arrays.copyOf(bArr2, (i4 + i3) * 2);
            }
            System.arraycopy(bArr, i, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i3);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += i3;
        }
    }

    public C2591sa(@Nullable C2364mb c2364mb) {
        C2078el c2078el;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2364mb;
        if (c2364mb != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2854za(178, 128);
            c2078el = new C2078el();
        } else {
            c2078el = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2078el;
    }

    @Override // me.tvspark.AbstractC2554ra
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
    }

    @Override // me.tvspark.AbstractC2554ra
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwww = j;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0198  */
    @Override // me.tvspark.AbstractC2554ra
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el) {
        int i;
        int i2;
        C2854za c2854za;
        int i3;
        int i4;
        long j;
        int i5;
        boolean z;
        float f;
        int i6;
        float f2;
        int i7;
        long j2;
        int i8;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        int i9 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i10 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        byte[] bArr = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww += c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el, c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        while (true) {
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C1987cl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, i9, i10, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == i10) {
                break;
            }
            int i11 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 + 3;
            int i12 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i11] & 255;
            int i13 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 - i9;
            if (!this.Wwwwwwwwwwwwwwwwwwwwwwwww) {
                if (i13 > 0) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, i9, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                }
                int i14 = i13 < 0 ? -i13 : 0;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    int i15 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - i14;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i15;
                    if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 0 && i12 == 181) {
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i15;
                    } else {
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
                        z = true;
                        if (z) {
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            String str = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
                            String str2 = str;
                            byte[] copyOf = Arrays.copyOf(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                            int i16 = copyOf[5] & 255;
                            int i17 = ((copyOf[4] & 255) << 4) | (i16 >> 4);
                            int i18 = ((i16 & 15) << 8) | (copyOf[6] & 255);
                            int i19 = (copyOf[7] & 240) >> 4;
                            if (i19 == 2) {
                                f = i18 * 4;
                                i6 = i17 * 3;
                            } else if (i19 == 3) {
                                f = i18 * 16;
                                i6 = i17 * 9;
                            } else if (i19 != 4) {
                                f2 = 1.0f;
                                C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str2;
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww = "video/mpeg2";
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww = i17;
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww = i18;
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwww = f2;
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww = Collections.singletonList(copyOf);
                                C2245j3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                i7 = (copyOf[7] & 15) - 1;
                                if (i7 >= 0) {
                                    double[] dArr = Wwwwwwwwwwwwwwwwww;
                                    if (i7 < dArr.length) {
                                        double d = dArr[i7];
                                        int i20 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 9;
                                        int i21 = (copyOf[i20] & 96) >> 5;
                                        if (i21 != (copyOf[i20] & 31)) {
                                            i = i12;
                                            i2 = i11;
                                            d *= (i21 + 1.0d) / (i8 + 1);
                                        } else {
                                            i = i12;
                                            i2 = i11;
                                        }
                                        j2 = (long) (1000000.0d / d);
                                        Pair create = Pair.create(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, Long.valueOf(j2));
                                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((C2245j3) create.first);
                                        this.Wwwwwwwwwwwwwwwwwwwwwwww = ((Long) create.second).longValue();
                                        this.Wwwwwwwwwwwwwwwwwwwwwwwww = true;
                                        c2854za = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                        if (c2854za == null) {
                                            if (i13 > 0) {
                                                c2854za.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, i9, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                                                i5 = 0;
                                            } else {
                                                i5 = -i13;
                                            }
                                            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i5)) {
                                                C2854za c2854za2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = C1987cl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2854za2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2854za2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                                                C2078el c2078el2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                                C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el2);
                                                c2078el2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4);
                                                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                                            }
                                            i3 = i;
                                            if (i3 == 178 && c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 + 2] == 1) {
                                                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3);
                                            }
                                        } else {
                                            i3 = i;
                                        }
                                        if (i3 != 0 || i3 == 179) {
                                            i4 = i10 - Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                                            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwwwwwwwwww) {
                                                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwww ? 1 : 0, ((int) (this.Wwwwwwwwwwwwwwwwwwwwwwwwwww - this.Wwwwwwwwwwwwwwwwwwwwww)) - i4, i4, null);
                                            }
                                            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwww || this.Wwwwwwwwwwwwwwwwwww) {
                                                this.Wwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww - i4;
                                                j = this.Wwwwwwwwwwwwwwwwwwwwwww;
                                                if (j == -9223372036854775807L) {
                                                    j = this.Wwwwwwwwwwwwwwwwwwwwwwwwww ? this.Wwwwwwwwwwwwwwwwwwwww + this.Wwwwwwwwwwwwwwwwwwwwwwww : 0L;
                                                }
                                                this.Wwwwwwwwwwwwwwwwwwwww = j;
                                                this.Wwwwwwwwwwwwwwwwwwww = false;
                                                this.Wwwwwwwwwwwwwwwwwwwwwww = -9223372036854775807L;
                                                this.Wwwwwwwwwwwwwwwwwwwwwwwwww = true;
                                            }
                                            this.Wwwwwwwwwwwwwwwwwww = i3 != 0;
                                        } else if (i3 == 184) {
                                            this.Wwwwwwwwwwwwwwwwwwww = true;
                                        }
                                        i9 = i2;
                                    }
                                }
                                i = i12;
                                i2 = i11;
                                j2 = 0;
                                Pair create2 = Pair.create(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, Long.valueOf(j2));
                                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((C2245j3) create2.first);
                                this.Wwwwwwwwwwwwwwwwwwwwwwww = ((Long) create2.second).longValue();
                                this.Wwwwwwwwwwwwwwwwwwwwwwwww = true;
                                c2854za = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                if (c2854za == null) {
                                }
                                if (i3 != 0) {
                                }
                                i4 = i10 - Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                                if (this.Wwwwwwwwwwwwwwwwwwwwwwwwww) {
                                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwww ? 1 : 0, ((int) (this.Wwwwwwwwwwwwwwwwwwwwwwwwwww - this.Wwwwwwwwwwwwwwwwwwwwww)) - i4, i4, null);
                                }
                                if (this.Wwwwwwwwwwwwwwwwwwwwwwwwww) {
                                }
                                this.Wwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww - i4;
                                j = this.Wwwwwwwwwwwwwwwwwwwwwww;
                                if (j == -9223372036854775807L) {
                                }
                                this.Wwwwwwwwwwwwwwwwwwwww = j;
                                this.Wwwwwwwwwwwwwwwwwwww = false;
                                this.Wwwwwwwwwwwwwwwwwwwwwww = -9223372036854775807L;
                                this.Wwwwwwwwwwwwwwwwwwwwwwwwww = true;
                                this.Wwwwwwwwwwwwwwwwwww = i3 != 0;
                                i9 = i2;
                            } else {
                                f = i18 * 121;
                                i6 = i17 * 100;
                            }
                            f2 = f / i6;
                            C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = new C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str2;
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwww = "video/mpeg2";
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwww = i17;
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwww = i18;
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwww = f2;
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwww = Collections.singletonList(copyOf);
                            C2245j3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww32 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                            i7 = (copyOf[7] & 15) - 1;
                            if (i7 >= 0) {
                            }
                            i = i12;
                            i2 = i11;
                            j2 = 0;
                            Pair create22 = Pair.create(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww32, Long.valueOf(j2));
                            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((C2245j3) create22.first);
                            this.Wwwwwwwwwwwwwwwwwwwwwwww = ((Long) create22.second).longValue();
                            this.Wwwwwwwwwwwwwwwwwwwwwwwww = true;
                            c2854za = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            if (c2854za == null) {
                            }
                            if (i3 != 0) {
                            }
                            i4 = i10 - Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwww) {
                            }
                            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwww) {
                            }
                            this.Wwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww - i4;
                            j = this.Wwwwwwwwwwwwwwwwwwwwwww;
                            if (j == -9223372036854775807L) {
                            }
                            this.Wwwwwwwwwwwwwwwwwwwww = j;
                            this.Wwwwwwwwwwwwwwwwwwww = false;
                            this.Wwwwwwwwwwwwwwwwwwwwwww = -9223372036854775807L;
                            this.Wwwwwwwwwwwwwwwwwwwwwwwwww = true;
                            this.Wwwwwwwwwwwwwwwwwww = i3 != 0;
                            i9 = i2;
                        }
                    }
                } else if (i12 == 179) {
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
                }
                byte[] bArr2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr2, 0, bArr2.length);
                z = false;
                if (z) {
                }
            }
            i = i12;
            i2 = i11;
            c2854za = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (c2854za == null) {
            }
            if (i3 != 0) {
            }
            i4 = i10 - Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwww) {
            }
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwww) {
            }
            this.Wwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww - i4;
            j = this.Wwwwwwwwwwwwwwwwwwwwwww;
            if (j == -9223372036854775807L) {
            }
            this.Wwwwwwwwwwwwwwwwwwwww = j;
            this.Wwwwwwwwwwwwwwwwwwww = false;
            this.Wwwwwwwwwwwwwwwwwwwwwww = -9223372036854775807L;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwww = true;
            this.Wwwwwwwwwwwwwwwwwww = i3 != 0;
            i9 = i2;
        }
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, i9, i10);
        }
        C2854za c2854za3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (c2854za3 != null) {
            c2854za3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, i9, i10);
        }
    }

    @Override // me.tvspark.AbstractC2554ra
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2249j7 abstractC2249j7, AbstractC2327lb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2249j7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), 2);
        C2364mb c2364mb = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (c2364mb != null) {
            c2364mb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2249j7, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    @Override // me.tvspark.AbstractC2554ra
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        C1987cl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        C2854za c2854za = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (c2854za != null) {
            c2854za.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = 0L;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwww = false;
    }
}
