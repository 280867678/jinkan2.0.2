package me.tvspark;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.tencent.smtt.sdk.TbsListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import me.tvspark.AbstractC1939ba;
import me.tvspark.C2245j3;

/* renamed from: me.tvspark.ca */
/* loaded from: classes4.dex */
public final class C1976ca extends AbstractC1939ba {
    @Nullable
    public C2814y7 Wwwwwwwwwwwwwwwww;
    @Nullable
    public C1900a8 Wwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwww;
    @Nullable
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwww;

    /* renamed from: me.tvspark.ca$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final C2851z7[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final C1900a8 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C1900a8 c1900a8, C2814y7 c2814y7, byte[] bArr, C2851z7[] c2851z7Arr, int i) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c1900a8;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = bArr;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2851z7Arr;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        }
    }

    @Override // me.tvspark.AbstractC1939ba
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = j;
        int i = 0;
        this.Wwwwwwwwwwwwwwwwwww = j != 0;
        C1900a8 c1900a8 = this.Wwwwwwwwwwwwwwwwww;
        if (c1900a8 != null) {
            i = c1900a8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        this.Wwwwwwwwwwwwwwwwwwww = i;
    }

    @Override // me.tvspark.AbstractC1939ba
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el) {
        byte[] bArr = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i = 0;
        if ((bArr[0] & 1) == 1) {
            return -1L;
        }
        byte b = bArr[0];
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwww;
        int i2 = !wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[(b >> 1) & (255 >>> (8 - wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww))].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww ? wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww : wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (this.Wwwwwwwwwwwwwwwwwww) {
            i = (this.Wwwwwwwwwwwwwwwwwwww + i2) / 4;
        }
        long j = i;
        byte[] bArr2 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int length = bArr2.length;
        int i3 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 4;
        if (length < i3) {
            c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Arrays.copyOf(bArr2, i3));
        } else {
            c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3);
        }
        byte[] bArr3 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i4 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        bArr3[i4 - 4] = (byte) (j & 255);
        bArr3[i4 - 3] = (byte) ((j >>> 8) & 255);
        bArr3[i4 - 2] = (byte) ((j >>> 16) & 255);
        bArr3[i4 - 1] = (byte) ((j >>> 24) & 255);
        this.Wwwwwwwwwwwwwwwwwww = true;
        this.Wwwwwwwwwwwwwwwwwwww = i2;
        return j;
    }

    @Override // me.tvspark.AbstractC1939ba
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
        super.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z);
        if (z) {
            this.Wwwwwwwwwwwwwwwwwwwww = null;
            this.Wwwwwwwwwwwwwwwwww = null;
            this.Wwwwwwwwwwwwwwwww = null;
        }
        this.Wwwwwwwwwwwwwwwwwwww = 0;
        this.Wwwwwwwwwwwwwwwwwww = false;
    }

    @Override // me.tvspark.AbstractC1939ba
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el, long j, AbstractC1939ba.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) throws IOException {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i;
        long j2;
        int i2;
        int i3 = 0;
        if (this.Wwwwwwwwwwwwwwwwwwwww != null) {
            return false;
        }
        if (this.Wwwwwwwwwwwwwwwwww == null) {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1, c2078el, false);
            int Wwwwwwwwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwww();
            int Wwwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwwww();
            int Wwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwww();
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            int i4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww <= 0 ? -1 : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            int i5 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 <= 0 ? -1 : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            int i6 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 <= 0 ? -1 : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
            int Wwwwwwwwwwwwwwwwwwwwww2 = c2078el.Wwwwwwwwwwwwwwwwwwwwww();
            this.Wwwwwwwwwwwwwwwwww = new C1900a8(Wwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwww2, i4, i5, i6, (int) Math.pow(2.0d, Wwwwwwwwwwwwwwwwwwwwww2 & 15), (int) Math.pow(2.0d, (Wwwwwwwwwwwwwwwwwwwwww2 & TbsListener.ErrorCode.TPATCH_VERSION_FAILED) >> 4), (c2078el.Wwwwwwwwwwwwwwwwwwwwww() & 1) > 0, Arrays.copyOf(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
        } else if (this.Wwwwwwwwwwwwwwwww == null) {
            this.Wwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el, true, true);
        } else {
            int i7 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            byte[] bArr = new byte[i7];
            System.arraycopy(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, bArr, 0, i7);
            int i8 = this.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i9 = 5;
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(5, c2078el, false);
            int Wwwwwwwwwwwwwwwwwwwwww3 = c2078el.Wwwwwwwwwwwwwwwwwwwwww() + 1;
            C2777x7 c2777x7 = new C2777x7(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            c2777x7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww * 8);
            int i10 = 0;
            while (true) {
                int i11 = 16;
                if (i10 < Wwwwwwwwwwwwwwwwwwwwww3) {
                    if (c2777x7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(24) != 5653314) {
                        throw new ParserException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(66, "expected code book to start with [0x56, 0x43, 0x42] at ", (c2777x7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww * 8) + c2777x7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
                    }
                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2777x7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(16);
                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = c2777x7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(24);
                    long[] jArr = new long[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3];
                    long j3 = 0;
                    if (!c2777x7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                        boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = c2777x7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        while (i3 < Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3) {
                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4) {
                                if (c2777x7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                                    i2 = Wwwwwwwwwwwwwwwwwwwwww3;
                                    jArr[i3] = c2777x7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i9) + 1;
                                } else {
                                    i2 = Wwwwwwwwwwwwwwwwwwwwww3;
                                    jArr[i3] = j3;
                                }
                                i9 = 5;
                            } else {
                                i2 = Wwwwwwwwwwwwwwwwwwwwww3;
                                jArr[i3] = c2777x7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i9) + 1;
                            }
                            i3++;
                            Wwwwwwwwwwwwwwwwwwwwww3 = i2;
                            j3 = 0;
                        }
                        i = Wwwwwwwwwwwwwwwwwwwwww3;
                    } else {
                        i = Wwwwwwwwwwwwwwwwwwwwww3;
                        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = c2777x7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i9) + 1;
                        int i12 = 0;
                        while (i12 < Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3) {
                            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = c2777x7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 - i12));
                            for (int i13 = 0; i13 < Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 && i12 < Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3; i13++) {
                                jArr[i12] = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5;
                                i12++;
                            }
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5++;
                        }
                    }
                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 = c2777x7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 > 2) {
                        throw new ParserException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(53, "lookup type greater than 2 not decodable: ", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7));
                    }
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 == 1 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 == 2) {
                        c2777x7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(32);
                        c2777x7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(32);
                        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8 = c2777x7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4) + 1;
                        c2777x7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 == 1) {
                            j2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != 0 ? (long) Math.floor(Math.pow(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, 1.0d / Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2)) : 0L;
                        } else {
                            j2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 * Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                        }
                        c2777x7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8 * j2));
                    }
                    i10++;
                    i3 = 0;
                    Wwwwwwwwwwwwwwwwwwwwww3 = i;
                } else {
                    int i14 = 6;
                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9 = c2777x7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(6) + 1;
                    for (int i15 = 0; i15 < Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9; i15++) {
                        if (c2777x7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(16) != 0) {
                            throw new ParserException("placeholder of time domain transforms not zeroed out");
                        }
                    }
                    int i16 = 1;
                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww10 = c2777x7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(6) + 1;
                    int i17 = 0;
                    while (true) {
                        int i18 = 3;
                        if (i17 < Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww10) {
                            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww11 = c2777x7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i11);
                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww11 == 0) {
                                int i19 = 8;
                                c2777x7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(8);
                                c2777x7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(16);
                                c2777x7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(16);
                                c2777x7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(6);
                                c2777x7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(8);
                                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww12 = c2777x7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4) + 1;
                                int i20 = 0;
                                while (i20 < Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww12) {
                                    c2777x7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i19);
                                    i20++;
                                    i19 = 8;
                                }
                            } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww11 != i16) {
                                throw new ParserException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(52, "floor type greater than 1 not decodable: ", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww11));
                            } else {
                                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww13 = c2777x7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i9);
                                int[] iArr = new int[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww13];
                                int i21 = -1;
                                for (int i22 = 0; i22 < Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww13; i22++) {
                                    iArr[i22] = c2777x7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
                                    if (iArr[i22] > i21) {
                                        i21 = iArr[i22];
                                    }
                                }
                                int i23 = i21 + 1;
                                int[] iArr2 = new int[i23];
                                int i24 = 0;
                                while (i24 < i23) {
                                    iArr2[i24] = c2777x7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i18) + 1;
                                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww14 = c2777x7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
                                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww14 > 0) {
                                        c2777x7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(8);
                                    }
                                    int i25 = 8;
                                    int i26 = 0;
                                    while (i26 < (1 << Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww14)) {
                                        c2777x7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i25);
                                        i26++;
                                        i25 = 8;
                                    }
                                    i24++;
                                    i18 = 3;
                                }
                                c2777x7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
                                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww15 = c2777x7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
                                int i27 = 0;
                                int i28 = 0;
                                for (int i29 = 0; i29 < Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww13; i29++) {
                                    i27 += iArr2[iArr[i29]];
                                    while (i28 < i27) {
                                        c2777x7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww15);
                                        i28++;
                                    }
                                }
                            }
                            i17++;
                            i9 = 5;
                            i16 = 1;
                            i14 = 6;
                            i11 = 16;
                        } else {
                            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww16 = c2777x7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i14);
                            int i30 = 1;
                            int i31 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww16 + 1;
                            int i32 = 0;
                            while (i32 < i31) {
                                if (c2777x7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(16) > 2) {
                                    throw new ParserException("residueType greater than 2 is not decodable");
                                }
                                c2777x7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(24);
                                c2777x7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(24);
                                c2777x7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(24);
                                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww17 = c2777x7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(6) + i30;
                                int i33 = 8;
                                c2777x7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(8);
                                int[] iArr3 = new int[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww17];
                                for (int i34 = 0; i34 < Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww17; i34++) {
                                    iArr3[i34] = ((c2777x7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() ? c2777x7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(5) : 0) * 8) + c2777x7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3);
                                }
                                int i35 = 0;
                                while (i35 < Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww17) {
                                    int i36 = 0;
                                    while (i36 < i33) {
                                        if ((iArr3[i35] & (1 << i36)) != 0) {
                                            c2777x7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i33);
                                        }
                                        i36++;
                                        i33 = 8;
                                    }
                                    i35++;
                                    i33 = 8;
                                }
                                i32++;
                                i30 = 1;
                            }
                            int i37 = 1;
                            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 = c2777x7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(6) + 1;
                            int i38 = 0;
                            while (i38 < Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18) {
                                if (c2777x7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(16) == 0) {
                                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww19 = c2777x7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() ? c2777x7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4) + 1 : 1;
                                    if (c2777x7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                                        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww20 = c2777x7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(8) + i37;
                                        for (int i39 = 0; i39 < Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww20; i39++) {
                                            int i40 = i8 - 1;
                                            c2777x7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i40));
                                            c2777x7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i40));
                                        }
                                    }
                                    if (c2777x7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2) != 0) {
                                        throw new ParserException("to reserved bits must be zero after mapping coupling steps");
                                    }
                                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww19 > 1) {
                                        for (int i41 = 0; i41 < i8; i41++) {
                                            c2777x7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
                                        }
                                    }
                                    for (int i42 = 0; i42 < Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww19; i42++) {
                                        c2777x7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(8);
                                        c2777x7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(8);
                                        c2777x7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(8);
                                    }
                                }
                                i38++;
                                i37 = 1;
                            }
                            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww21 = c2777x7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(6) + 1;
                            C2851z7[] c2851z7Arr = new C2851z7[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww21];
                            for (int i43 = 0; i43 < Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww21; i43++) {
                                c2851z7Arr[i43] = new C2851z7(c2777x7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), c2777x7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(16), c2777x7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(16), c2777x7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(8));
                            }
                            if (c2777x7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwww, bArr, c2851z7Arr, Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww21 - 1));
                            } else {
                                throw new ParserException("framing bit after modes not set as expected");
                            }
                        }
                    }
                }
            }
        }
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        this.Wwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            return true;
        }
        C1900a8 c1900a8 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        ArrayList arrayList = new ArrayList();
        arrayList.add(c1900a8.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
        arrayList.add(this.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = new C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwww = "audio/vorbis";
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = c1900a8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = c1900a8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwww = c1900a8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwww = c1900a8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwww = arrayList;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        return true;
    }
}
