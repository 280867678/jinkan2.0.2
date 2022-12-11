package me.tvspark;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.zip.Inflater;

/* renamed from: me.tvspark.qh */
/* loaded from: classes4.dex */
public final class C2524qh extends AbstractC2823yg {
    @Nullable
    public Inflater Wwwwwwwwwwwwwwwwww;
    public final C2078el Wwwwwwwwwwwwwwwwwwwww = new C2078el();
    public final C2078el Wwwwwwwwwwwwwwwwwwww = new C2078el();
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    /* renamed from: me.tvspark.qh$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public int Wwwwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final C2078el Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2078el();
        public final int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new int[256];

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwww = 0;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
        }
    }

    public C2524qh() {
        super("PgsDecoder");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // me.tvspark.AbstractC2823yg
    public AbstractC1909ah Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, int i, boolean z) throws SubtitleDecoderException {
        C2078el c2078el;
        C2078el c2078el2;
        int i2;
        int i3;
        C2786xg c2786xg;
        int Wwwwwwwwwwwwwwwwwwww;
        C2524qh c2524qh = this;
        C2078el c2078el3 = c2524qh.Wwwwwwwwwwwwwwwwwwwww;
        c2078el3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = bArr;
        c2078el3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        int i4 = 0;
        c2078el3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        if (c2078el3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() > 0 && c2078el3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == 120) {
            if (c2524qh.Wwwwwwwwwwwwwwwwww == null) {
                c2524qh.Wwwwwwwwwwwwwwwwww = new Inflater();
            }
            if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el3, c2524qh.Wwwwwwwwwwwwwwwwwwww, c2524qh.Wwwwwwwwwwwwwwwwww)) {
                C2078el c2078el4 = c2524qh.Wwwwwwwwwwwwwwwwwwww;
                c2078el3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2078el4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
        }
        c2524qh.Wwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        ArrayList arrayList = new ArrayList();
        while (c2524qh.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() >= 3) {
            C2078el c2078el5 = c2524qh.Wwwwwwwwwwwwwwwwwwwww;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2524qh.Wwwwwwwwwwwwwwwwwww;
            int i5 = c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int Wwwwwwwwwwwwwwwwwwwwww = c2078el5.Wwwwwwwwwwwwwwwwwwwwww();
            int Wwwwwwwwwwwwwwwww = c2078el5.Wwwwwwwwwwwwwwwww();
            int i6 = c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + Wwwwwwwwwwwwwwwww;
            C2786xg c2786xg2 = null;
            if (i6 > i5) {
                c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i5);
            } else {
                if (Wwwwwwwwwwwwwwwwwwwwww != 128) {
                    switch (Wwwwwwwwwwwwwwwwwwwwww) {
                        case 20:
                            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                                throw null;
                            }
                            if (Wwwwwwwwwwwwwwwww % 5 == 2) {
                                c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
                                Arrays.fill(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i4);
                                int i7 = Wwwwwwwwwwwwwwwww / 5;
                                int i8 = 0;
                                while (i8 < i7) {
                                    int Wwwwwwwwwwwwwwwwwwwwww2 = c2078el5.Wwwwwwwwwwwwwwwwwwwwww();
                                    int Wwwwwwwwwwwwwwwwwwwwww3 = c2078el5.Wwwwwwwwwwwwwwwwwwwwww();
                                    double d = Wwwwwwwwwwwwwwwwwwwwww3;
                                    double Wwwwwwwwwwwwwwwwwwwwww4 = c2078el5.Wwwwwwwwwwwwwwwwwwwwww() - 128;
                                    arrayList = arrayList;
                                    double Wwwwwwwwwwwwwwwwwwwwww5 = c2078el5.Wwwwwwwwwwwwwwwwwwwwww() - 128;
                                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwww2] = (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) ((1.402d * Wwwwwwwwwwwwwwwwwwwwww4) + d), 0, 255) << 16) | (c2078el5.Wwwwwwwwwwwwwwwwwwwwww() << 24) | (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) ((d - (0.34414d * Wwwwwwwwwwwwwwwwwwwwww5)) - (Wwwwwwwwwwwwwwwwwwwwww4 * 0.71414d)), 0, 255) << 8) | C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) ((Wwwwwwwwwwwwwwwwwwwwww5 * 1.772d) + d), 0, 255);
                                    i8++;
                                    c2078el5 = c2078el5;
                                }
                                c2078el = c2078el5;
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
                                c2786xg = null;
                                break;
                            }
                            c2078el = c2078el5;
                            c2786xg = null;
                            break;
                        case 21:
                            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                                throw null;
                            }
                            if (Wwwwwwwwwwwwwwwww >= 4) {
                                c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(3);
                                int i9 = Wwwwwwwwwwwwwwwww - 4;
                                if ((c2078el5.Wwwwwwwwwwwwwwwwwwwwww() & 128) != 0) {
                                    if (i9 >= 7 && (Wwwwwwwwwwwwwwwwwwww = c2078el5.Wwwwwwwwwwwwwwwwwwww()) >= 4) {
                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww = c2078el5.Wwwwwwwwwwwwwwwww();
                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww = c2078el5.Wwwwwwwwwwwwwwwww();
                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwww - 4);
                                        i9 -= 7;
                                    }
                                }
                                C2078el c2078el6 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                int i10 = c2078el6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                int i11 = c2078el6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                if (i10 < i11 && i9 > 0) {
                                    int min = Math.min(i9, i11 - i10);
                                    c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i10, min);
                                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i10 + min);
                                }
                            }
                            c2078el = c2078el5;
                            c2786xg = null;
                            break;
                        case 22:
                            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                                throw null;
                            }
                            if (Wwwwwwwwwwwwwwwww >= 19) {
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2078el5.Wwwwwwwwwwwwwwwww();
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2078el5.Wwwwwwwwwwwwwwwww();
                                c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(11);
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2078el5.Wwwwwwwwwwwwwwwww();
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = c2078el5.Wwwwwwwwwwwwwwwww();
                            }
                            c2078el = c2078el5;
                            c2786xg = null;
                            break;
                        default:
                            c2078el = c2078el5;
                            c2786xg = null;
                            break;
                    }
                    c2786xg2 = c2786xg;
                } else {
                    c2078el = c2078el5;
                    if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 0 || wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 0 || wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww == 0 || wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww == 0 || (i2 = (c2078el2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) == 0 || c2078el2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != i2 || !wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                        c2786xg2 = null;
                    } else {
                        c2078el2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
                        int i12 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww * wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww;
                        int[] iArr = new int[i12];
                        int i13 = 0;
                        while (i13 < i12) {
                            int Wwwwwwwwwwwwwwwwwwwwww6 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww();
                            if (Wwwwwwwwwwwwwwwwwwwwww6 != 0) {
                                i3 = i13 + 1;
                                iArr[i13] = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwww6];
                            } else {
                                int Wwwwwwwwwwwwwwwwwwwwww7 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww();
                                if (Wwwwwwwwwwwwwwwwwwwwww7 != 0) {
                                    i3 = ((Wwwwwwwwwwwwwwwwwwwwww7 & 64) == 0 ? Wwwwwwwwwwwwwwwwwwwwww7 & 63 : ((Wwwwwwwwwwwwwwwwwwwwww7 & 63) << 8) | wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww()) + i13;
                                    Arrays.fill(iArr, i13, i3, (Wwwwwwwwwwwwwwwwwwwwww7 & 128) == 0 ? 0 : wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww()]);
                                }
                            }
                            i13 = i3;
                        }
                        Bitmap createBitmap = Bitmap.createBitmap(iArr, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww, Bitmap.Config.ARGB_8888);
                        float f = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        float f2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        c2786xg2 = new C2786xg(null, null, createBitmap, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww / f2, 0, 0, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww / f, 0, Integer.MIN_VALUE, -3.4028235E38f, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww / f, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww / f2, false, -16777216, Integer.MIN_VALUE, null);
                    }
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                }
                c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i6);
            }
            ArrayList arrayList2 = arrayList;
            if (c2786xg2 != null) {
                arrayList2.add(c2786xg2);
            }
            i4 = 0;
            arrayList = arrayList2;
            c2524qh = this;
        }
        return new C2561rh(Collections.unmodifiableList(arrayList));
    }
}
