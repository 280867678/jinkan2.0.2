package me.tvspark;

import com.google.android.exoplayer2.ParserException;
import java.io.IOException;
import java.util.Arrays;
import me.tvspark.AbstractC1939ba;
import org.apache.commons.lang3.time.StopWatch;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* renamed from: me.tvspark.w9 */
/* loaded from: classes4.dex */
public class C2742w9 implements AbstractC2175h7 {
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public AbstractC1939ba Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public AbstractC2249j7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    static {
        C2627t9 c2627t9 = C2627t9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public static /* synthetic */ AbstractC2175h7[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return new AbstractC2175h7[]{new C2742w9()};
    }

    @EnsuresNonNullIf(expression = {"streamReader"}, result = true)
    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2212i7 abstractC2212i7) throws IOException {
        boolean z;
        boolean equals;
        AbstractC1939ba c1902aa;
        C2816y9 c2816y9 = new C2816y9();
        if (c2816y9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7, true) && (c2816y9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww & 2) == 2) {
            int min = Math.min(c2816y9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, 8);
            C2078el c2078el = new C2078el(min);
            abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, min);
            c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
            if (c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() >= 5 && c2078el.Wwwwwwwwwwwwwwwwwwwwww() == 127 && c2078el.Wwwwwwwwwwwwwwwwwwwww() == 1179402563) {
                c1902aa = new C2702v9();
            } else {
                c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
                try {
                    z = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1, c2078el, true);
                } catch (ParserException unused) {
                    z = false;
                }
                if (z) {
                    c1902aa = new C1976ca();
                } else {
                    c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    byte[] bArr = C1902aa.Wwwwwwwwwwwwwwwwwwww;
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < bArr.length) {
                        equals = false;
                    } else {
                        byte[] bArr2 = new byte[bArr.length];
                        int length = bArr.length;
                        System.arraycopy(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, bArr2, 0, length);
                        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += length;
                        equals = Arrays.equals(bArr2, C1902aa.Wwwwwwwwwwwwwwwwwwww);
                    }
                    if (equals) {
                        c1902aa = new C1902aa();
                    }
                }
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c1902aa;
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x0177  */
    @Override // me.tvspark.AbstractC2175h7
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2212i7 abstractC2212i7, C2588s7 c2588s7) throws IOException {
        AbstractC1939ba.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i;
        byte[] bArr;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7)) {
                throw new ParserException("Failed to determine bitstream type");
            }
            abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            AbstractC2740w7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, 1);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            AbstractC1939ba abstractC1939ba = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            abstractC1939ba.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            abstractC1939ba.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            abstractC1939ba.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
        }
        AbstractC1939ba abstractC1939ba2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i2 = abstractC1939ba2.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i2 == 0) {
            boolean z = true;
            while (z) {
                if (!abstractC1939ba2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7)) {
                    abstractC1939ba2.Wwwwwwwwwwwwwwwwwwwwwwwwwww = 3;
                } else {
                    long position = abstractC2212i7.getPosition();
                    long j = abstractC1939ba2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    abstractC1939ba2.Wwwwwwwwwwwwwwwwwwwwwwww = position - j;
                    z = abstractC1939ba2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC1939ba2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, j, abstractC1939ba2.Wwwwwwwwwwwwwwwwwwwwwwwww);
                    if (z) {
                        abstractC1939ba2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2212i7.getPosition();
                    }
                }
            }
            C2245j3 c2245j3 = abstractC1939ba2.Wwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            abstractC1939ba2.Wwwwwwwwwwwwwwwwwwwwwwwwww = c2245j3.Kkkkkkkkkkkkkkkkkkkkkkk;
            if (!abstractC1939ba2.Wwwwwwwwwwwwwwwwwwwwww) {
                abstractC1939ba2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3);
                abstractC1939ba2.Wwwwwwwwwwwwwwwwwwwwww = true;
            }
            AbstractC2853z9 abstractC2853z9 = abstractC1939ba2.Wwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (abstractC2853z9 != null) {
                abstractC1939ba2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2853z9;
            } else if (abstractC2212i7.getLength() != -1) {
                C2816y9 c2816y9 = abstractC1939ba2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                boolean z2 = (c2816y9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww & 4) != 0;
                long j2 = c2816y9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                i = 2;
                abstractC1939ba2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2664u9(abstractC1939ba2, abstractC1939ba2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, abstractC2212i7.getLength(), c2816y9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww + c2816y9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, j2, z2);
                abstractC1939ba2.Wwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                abstractC1939ba2.Wwwwwwwwwwwwwwwwwwwwwwwwwww = i;
                C2779x9 c2779x9 = abstractC1939ba2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                C2078el c2078el = c2779x9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                bArr = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (bArr.length != 65025) {
                    c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Arrays.copyOf(bArr, Math.max(65025, c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)), c2779x9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                }
                return 0;
            } else {
                abstractC1939ba2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new AbstractC1939ba.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null);
            }
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            i = 2;
            abstractC1939ba2.Wwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            abstractC1939ba2.Wwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            C2779x9 c2779x92 = abstractC1939ba2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            C2078el c2078el2 = c2779x92.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            bArr = c2078el2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (bArr.length != 65025) {
            }
            return 0;
        } else if (i2 == 1) {
            abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) abstractC1939ba2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            abstractC1939ba2.Wwwwwwwwwwwwwwwwwwwwwwwwwww = 2;
            return 0;
        } else if (i2 == 2) {
            long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = abstractC1939ba2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 >= 0) {
                c2588s7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                return 1;
            }
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 < -1) {
                abstractC1939ba2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(-(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 + 2));
            }
            if (!abstractC1939ba2.Wwwwwwwwwwwwwwwwwwwwwww) {
                AbstractC2625t7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = abstractC1939ba2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
                abstractC1939ba2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
                abstractC1939ba2.Wwwwwwwwwwwwwwwwwwwwwww = true;
            }
            if (abstractC1939ba2.Wwwwwwwwwwwwwwwwwwwwwwww > 0 || abstractC1939ba2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7)) {
                abstractC1939ba2.Wwwwwwwwwwwwwwwwwwwwwwww = 0L;
                C2078el c2078el3 = abstractC1939ba2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = abstractC1939ba2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el3);
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 >= 0) {
                    long j3 = abstractC1939ba2.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (j3 + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 >= abstractC1939ba2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                        long j4 = (j3 * StopWatch.NANO_2_MILLIS) / abstractC1939ba2.Wwwwwwwwwwwwwwwwwwwwwwwwww;
                        abstractC1939ba2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el3, c2078el3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        abstractC1939ba2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j4, 1, c2078el3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, null);
                        abstractC1939ba2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -1L;
                    }
                }
                abstractC1939ba2.Wwwwwwwwwwwwwwwwwwwwwwwwwwww += Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4;
                return 0;
            }
            abstractC1939ba2.Wwwwwwwwwwwwwwwwwwwwwwwwwww = 3;
        } else {
            throw new IllegalStateException();
        }
        return -1;
    }

    @Override // me.tvspark.AbstractC2175h7
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2249j7 abstractC2249j7) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2249j7;
    }

    @Override // me.tvspark.AbstractC2175h7
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2212i7 abstractC2212i7) throws IOException {
        try {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7);
        } catch (ParserException unused) {
            return false;
        }
    }

    @Override // me.tvspark.AbstractC2175h7
    public void release() {
    }

    @Override // me.tvspark.AbstractC2175h7
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, long j2) {
        AbstractC1939ba abstractC1939ba = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (abstractC1939ba != null) {
            C2779x9 c2779x9 = abstractC1939ba.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            c2779x9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            c2779x9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
            c2779x9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -1;
            c2779x9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
            if (j == 0) {
                abstractC1939ba.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(!abstractC1939ba.Wwwwwwwwwwwwwwwwwwwwwww);
            } else if (abstractC1939ba.Wwwwwwwwwwwwwwwwwwwwwwwwwww == 0) {
            } else {
                long j3 = (abstractC1939ba.Wwwwwwwwwwwwwwwwwwwwwwwwww * j2) / StopWatch.NANO_2_MILLIS;
                abstractC1939ba.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j3;
                abstractC1939ba.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j3);
                abstractC1939ba.Wwwwwwwwwwwwwwwwwwwwwwwwwww = 2;
            }
        }
    }
}
