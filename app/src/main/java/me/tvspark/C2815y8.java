package me.tvspark;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import java.io.EOFException;
import java.io.IOException;
import me.tvspark.AbstractC2852z8;
import me.tvspark.C2218id;
import me.tvspark.C2245j3;
import me.tvspark.C2254jc;
import me.tvspark.C2358m5;
import org.apache.commons.lang3.time.StopWatch;

/* renamed from: me.tvspark.y8 */
/* loaded from: classes4.dex */
public final class C2815y8 implements AbstractC2175h7 {
    public static final C2218id.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwww = C2663u8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwww;
    public AbstractC2852z8 Wwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public C2254jc Wwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwww;
    public AbstractC2740w7 Wwwwwwwwwwwwwwwwwwwwwwwww;
    public AbstractC2740w7 Wwwwwwwwwwwwwwwwwwwwwwwwww;
    public AbstractC2249j7 Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final AbstractC2740w7 Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final C2514q7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final C2471p7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final C2358m5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final C2078el Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    static {
        C2626t8 c2626t8 = C2626t8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public C2815y8() {
        this(0, -9223372036854775807L);
    }

    public C2815y8(int i, long j) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2078el(10);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2358m5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2471p7();
        this.Wwwwwwwwwwwwwwwwwwwwww = -9223372036854775807L;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2514q7();
        C2138g7 c2138g7 = new C2138g7();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = c2138g7;
        this.Wwwwwwwwwwwwwwwwwwwwwwwww = c2138g7;
    }

    public static long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable C2254jc c2254jc) {
        if (c2254jc != null) {
            int length = c2254jc.Wwwwwwwwwwwwwwwwwwwwwwww.length;
            for (int i = 0; i < length; i++) {
                C2254jc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2254jc.Wwwwwwwwwwwwwwwwwwwwwwww[i];
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww instanceof C2403nd) {
                    C2403nd c2403nd = (C2403nd) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (c2403nd.Wwwwwwwwwwwwwwwwwwwwwwww.equals("TLEN")) {
                        return C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Long.parseLong(c2403nd.Wwwwwwwwwwwwwwwwwwwwww));
                    }
                }
            }
            return -9223372036854775807L;
        }
        return -9223372036854775807L;
    }

    public static /* synthetic */ boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, int i3, int i4, int i5) {
        return (i2 == 67 && i3 == 79 && i4 == 77 && (i5 == 77 || i == 2)) || (i2 == 77 && i3 == 76 && i4 == 76 && (i5 == 84 || i == 2));
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, long j) {
        return ((long) (i & (-128000))) == (j & (-128000));
    }

    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2212i7 abstractC2212i7) throws IOException {
        AbstractC2852z8 abstractC2852z8 = this.Wwwwwwwwwwwwwwwwww;
        if (abstractC2852z8 != null) {
            long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2852z8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != -1 && abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() > Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - 4) {
                return true;
            }
        }
        try {
            return !abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, 4, true);
        } catch (EOFException unused) {
            return true;
        }
    }

    public final AbstractC2852z8 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2212i7 abstractC2212i7) throws IOException {
        abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, 4);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        return new C2701v8(abstractC2212i7.getLength(), abstractC2212i7.getPosition(), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        return ((j * StopWatch.NANO_2_MILLIS) / this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) + this.Wwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.AbstractC2175h7
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, long j2) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = 0;
        this.Wwwwwwwwwwwwwwwwwwwwww = -9223372036854775807L;
        this.Wwwwwwwwwwwwwwwwwwwww = 0L;
        this.Wwwwwwwwwwwwwwwwwww = 0;
        this.Wwwwwwwwwwwwwww = j2;
        AbstractC2852z8 abstractC2852z8 = this.Wwwwwwwwwwwwwwwwww;
        if (!(abstractC2852z8 instanceof C2741w8) || ((C2741w8) abstractC2852z8).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j2)) {
            return;
        }
        this.Wwwwwwwwwwwwwwww = true;
        this.Wwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.AbstractC2175h7
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2249j7 abstractC2249j7) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2249j7;
        AbstractC2740w7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2249j7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, 1);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.AbstractC2175h7
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2212i7 abstractC2212i7) throws IOException {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x009d, code lost:
        if (r13 == false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x009f, code lost:
        r12.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r2 + r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00a7, code lost:
        r11.Wwwwwwwwwwwwwwwwwwwwwwww = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00a9, code lost:
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00a4, code lost:
        r12.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2212i7 abstractC2212i7, boolean z) throws IOException {
        int i;
        int i2;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i3 = z ? 32768 : 131072;
        abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (abstractC2212i7.getPosition() == 0) {
            C2254jc Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7, (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww & 4) == 0 ? null : Wwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            }
            i2 = (int) abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            if (!z) {
                abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2);
            }
            i = 0;
        } else {
            i = 0;
            i2 = 0;
        }
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7)) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                if ((i == 0 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i)) && (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2358m5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) != -1) {
                    i4++;
                    if (i4 != 1) {
                        if (i4 == 4) {
                            break;
                        }
                    } else {
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        i = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    }
                    abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - 4);
                } else {
                    int i6 = i5 + 1;
                    if (i5 == i3) {
                        if (!z) {
                            throw new ParserException("Searched too many bytes.");
                        }
                        return false;
                    }
                    if (z) {
                        abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2 + i6);
                    } else {
                        abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
                    }
                    i5 = i6;
                    i = 0;
                    i4 = 0;
                }
            } else if (i4 <= 0) {
                throw new EOFException();
            }
        }
    }

    @Override // me.tvspark.AbstractC2175h7
    public void release() {
    }

    public static /* synthetic */ AbstractC2175h7[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return new AbstractC2175h7[]{new C2815y8(0, -9223372036854775807L)};
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0060, code lost:
        if (r8 != 1231971951) goto L171;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x03ea  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x007e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x03d4  */
    @Override // me.tvspark.AbstractC2175h7
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2212i7 abstractC2212i7, C2588s7 c2588s7) throws IOException {
        int i;
        long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i2;
        C2358m5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i3;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        AbstractC2852z8 abstractC2852z8;
        int Wwwwwwwwwwwwwwwwwww;
        C2254jc c2254jc;
        C2778x8 c2778x8;
        long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
        C2329ld c2329ld;
        int Wwwwwwwwwwwwwwwwwwwwww;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwww);
        C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwww);
        if (this.Wwwwwwwwwwwwwwwwwwwwwwww == 0) {
            try {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7, false);
            } catch (EOFException unused) {
                i = -1;
            }
        }
        if (this.Wwwwwwwwwwwwwwwwww == null) {
            C2078el c2078el = new C2078el(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            C2358m5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i4 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww & 1;
            int i5 = 21;
            int i6 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i4 != 0) {
                if (i6 != 1) {
                    i5 = 36;
                }
            } else if (i6 == 1) {
                i5 = 13;
            }
            if (c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= i5 + 4) {
                c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i5);
                i3 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                if (i3 != 1483304551) {
                }
                if (i3 != 1483304551 || i3 == 1231971951) {
                    abstractC2212i7.getLength();
                    long position = abstractC2212i7.getPosition();
                    C2358m5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    int i7 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    int i8 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    if ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww & 1) == 1 || (Wwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwww()) == 0) {
                        abstractC2852z8 = null;
                    } else {
                        long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwww, i7 * StopWatch.NANO_2_MILLIS, i8);
                        if ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww & 6) != 6) {
                            abstractC2852z8 = new C1938b9(position, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, -1L, null);
                        } else {
                            long Wwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwww();
                            long[] jArr = new long[100];
                            for (int i9 = 0; i9 < 100; i9++) {
                                jArr[i9] = c2078el.Wwwwwwwwwwwwwwwwwwwwww();
                            }
                            abstractC2852z8 = new C1938b9(position, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, Wwwwwwwwwwwwwwwwwwwww, jArr);
                        }
                    }
                    if (abstractC2852z8 != null) {
                        C2471p7 c2471p7 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        if (!((c2471p7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -1 || c2471p7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -1) ? false : true)) {
                            abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                            abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i5 + 141);
                            abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, 3);
                            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
                            C2471p7 c2471p72 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            int Wwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww();
                            if (c2471p72 == null) {
                                throw null;
                            }
                            int i10 = Wwwwwwwwwwwwwwwwwwww >> 12;
                            int i11 = Wwwwwwwwwwwwwwwwwwww & 4095;
                            if (i10 > 0 || i11 > 0) {
                                c2471p72.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i10;
                                c2471p72.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i11;
                            }
                        }
                    }
                    abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    if (abstractC2852z8 != null && !abstractC2852z8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() && i3 == 1231971951) {
                        abstractC2852z8 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7);
                    }
                } else if (i3 == 1447187017) {
                    abstractC2212i7.getLength();
                    long position2 = abstractC2212i7.getPosition();
                    C2358m5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(10);
                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 > 0) {
                        int i12 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4, (i12 >= 32000 ? 1152 : 576) * StopWatch.NANO_2_MILLIS, i12);
                        int Wwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwww();
                        int Wwwwwwwwwwwwwwwww2 = c2078el.Wwwwwwwwwwwwwwwww();
                        int Wwwwwwwwwwwwwwwww3 = c2078el.Wwwwwwwwwwwwwwwww();
                        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
                        long j = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + position2;
                        long[] jArr2 = new long[Wwwwwwwwwwwwwwwww];
                        long[] jArr3 = new long[Wwwwwwwwwwwwwwwww];
                        int i13 = 0;
                        while (true) {
                            long[] jArr4 = jArr3;
                            if (i13 >= Wwwwwwwwwwwwwwwww) {
                                abstractC2852z8 = new C1901a9(jArr2, jArr4, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5, position2);
                                break;
                            }
                            long j2 = position2;
                            jArr2[i13] = (i13 * Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5) / Wwwwwwwwwwwwwwwww;
                            jArr4[i13] = Math.max(j2, j);
                            if (Wwwwwwwwwwwwwwwww3 == 1) {
                                Wwwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwwww();
                            } else if (Wwwwwwwwwwwwwwwww3 == 2) {
                                Wwwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwww();
                            } else if (Wwwwwwwwwwwwwwwww3 == 3) {
                                Wwwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwww();
                            } else if (Wwwwwwwwwwwwwwwww3 != 4) {
                                break;
                            } else {
                                Wwwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwww();
                            }
                            position2 = j2 + (Wwwwwwwwwwwwwwwwwwwwww * Wwwwwwwwwwwwwwwww2);
                            i13++;
                            jArr3 = jArr4;
                        }
                        abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    }
                    abstractC2852z8 = null;
                    abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                } else {
                    abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    abstractC2852z8 = null;
                }
                c2254jc = this.Wwwwwwwwwwwwwwwwwwwwwww;
                long position3 = abstractC2212i7.getPosition();
                if (c2254jc != null) {
                    int length = c2254jc.Wwwwwwwwwwwwwwwwwwwwwwww.length;
                    for (int i14 = 0; i14 < length; i14++) {
                        C2254jc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2254jc.Wwwwwwwwwwwwwwwwwwwwwwww[i14];
                        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww instanceof C2329ld) {
                            long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2254jc);
                            int length2 = ((C2329ld) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwww.length;
                            int i15 = length2 + 1;
                            long[] jArr5 = new long[i15];
                            long[] jArr6 = new long[i15];
                            jArr5[0] = position3;
                            jArr6[0] = 0;
                            long j3 = 0;
                            int i16 = 1;
                            while (i16 <= length2) {
                                int i17 = i16 - 1;
                                position3 += c2329ld.Wwwwwwwwwwwwwwwwwwwwww + c2329ld.Wwwwwwwwwwwwwwwwwwww[i17];
                                j3 += c2329ld.Wwwwwwwwwwwwwwwwwwwww + c2329ld.Wwwwwwwwwwwwwwwwwww[i17];
                                jArr5[i16] = position3;
                                jArr6[i16] = j3;
                                i16++;
                                length2 = length2;
                            }
                            c2778x8 = new C2778x8(jArr5, jArr6, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4);
                            if (!this.Wwwwwwwwwwwwwwwww) {
                                abstractC2852z8 = new AbstractC2852z8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                            } else {
                                if ((this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww & 2) != 0) {
                                    if (c2778x8 != null) {
                                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2778x8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                    } else if (abstractC2852z8 != null) {
                                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = abstractC2852z8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = abstractC2852z8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                        abstractC2852z8 = new C2741w8(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, abstractC2212i7.getPosition(), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
                                    } else {
                                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww);
                                    }
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = -1;
                                    abstractC2852z8 = new C2741w8(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, abstractC2212i7.getPosition(), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
                                } else if (c2778x8 != null) {
                                    abstractC2852z8 = c2778x8;
                                } else if (abstractC2852z8 == null) {
                                    abstractC2852z8 = null;
                                }
                                if (abstractC2852z8 == null || (!abstractC2852z8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() && (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww & 1) != 0)) {
                                    abstractC2852z8 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7);
                                }
                            }
                            this.Wwwwwwwwwwwwwwwwww = abstractC2852z8;
                            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2852z8);
                            AbstractC2740w7 abstractC2740w7 = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
                            C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = new C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                            C2358m5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwww = 4096;
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            C2471p7 c2471p73 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwww = c2471p73.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwww = c2471p73.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwww = (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww & 4) == 0 ? null : this.Wwwwwwwwwwwwwwwwwwwwwww;
                            abstractC2740w7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                            this.Wwwwwwwwwwwwwwwwwwww = abstractC2212i7.getPosition();
                        }
                    }
                }
                c2778x8 = null;
                if (!this.Wwwwwwwwwwwwwwwww) {
                }
                this.Wwwwwwwwwwwwwwwwww = abstractC2852z8;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2852z8);
                AbstractC2740w7 abstractC2740w72 = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
                C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22 = new C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                C2358m5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww52 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22.Wwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww52.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22.Wwwwwwwwwwwwwwwwwwwwwww = 4096;
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22.Wwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww52.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22.Wwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww52.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                C2471p7 c2471p732 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22.Wwwwwwww = c2471p732.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22.Wwwwwww = c2471p732.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22.Wwwwwwwwwwwwwwwwwwwwwwwwww = (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww & 4) == 0 ? null : this.Wwwwwwwwwwwwwwwwwwwwwww;
                abstractC2740w72.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                this.Wwwwwwwwwwwwwwwwwwww = abstractC2212i7.getPosition();
            }
            if (c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 40) {
                c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(36);
                if (c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == 1447187017) {
                    i3 = 1447187017;
                    if (i3 != 1483304551) {
                    }
                    abstractC2212i7.getLength();
                    long position4 = abstractC2212i7.getPosition();
                    C2358m5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww32 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    int i72 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww32.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    int i82 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww32.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    if ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww & 1) == 1) {
                    }
                    abstractC2852z8 = null;
                    if (abstractC2852z8 != null) {
                    }
                    abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    if (abstractC2852z8 != null) {
                        abstractC2852z8 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7);
                    }
                    c2254jc = this.Wwwwwwwwwwwwwwwwwwwwwww;
                    long position32 = abstractC2212i7.getPosition();
                    if (c2254jc != null) {
                    }
                    c2778x8 = null;
                    if (!this.Wwwwwwwwwwwwwwwww) {
                    }
                    this.Wwwwwwwwwwwwwwwwww = abstractC2852z8;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2852z8);
                    AbstractC2740w7 abstractC2740w722 = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
                    C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222 = new C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    C2358m5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww522 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222.Wwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww522.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222.Wwwwwwwwwwwwwwwwwwwwwww = 4096;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222.Wwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww522.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222.Wwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww522.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    C2471p7 c2471p7322 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222.Wwwwwwww = c2471p7322.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222.Wwwwwww = c2471p7322.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222.Wwwwwwwwwwwwwwwwwwwwwwwwww = (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww & 4) == 0 ? null : this.Wwwwwwwwwwwwwwwwwwwwwww;
                    abstractC2740w722.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                    this.Wwwwwwwwwwwwwwwwwwww = abstractC2212i7.getPosition();
                }
            }
            i3 = 0;
            if (i3 != 1483304551) {
            }
            abstractC2212i7.getLength();
            long position42 = abstractC2212i7.getPosition();
            C2358m5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww322 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i722 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww322.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i822 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww322.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            if ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww & 1) == 1) {
            }
            abstractC2852z8 = null;
            if (abstractC2852z8 != null) {
            }
            abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            if (abstractC2852z8 != null) {
            }
            c2254jc = this.Wwwwwwwwwwwwwwwwwwwwwww;
            long position322 = abstractC2212i7.getPosition();
            if (c2254jc != null) {
            }
            c2778x8 = null;
            if (!this.Wwwwwwwwwwwwwwwww) {
            }
            this.Wwwwwwwwwwwwwwwwww = abstractC2852z8;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2852z8);
            AbstractC2740w7 abstractC2740w7222 = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
            C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222 = new C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            C2358m5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5222 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222.Wwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222.Wwwwwwwwwwwwwwwwwwwwwww = 4096;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222.Wwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222.Wwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            C2471p7 c2471p73222 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222.Wwwwwwww = c2471p73222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222.Wwwwwww = c2471p73222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222.Wwwwwwwwwwwwwwwwwwwwwwwwww = (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww & 4) == 0 ? null : this.Wwwwwwwwwwwwwwwwwwwwwww;
            abstractC2740w7222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            this.Wwwwwwwwwwwwwwwwwwww = abstractC2212i7.getPosition();
        } else if (this.Wwwwwwwwwwwwwwwwwwww != 0) {
            long position5 = abstractC2212i7.getPosition();
            long j4 = this.Wwwwwwwwwwwwwwwwwwww;
            if (position5 < j4) {
                abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) (j4 - position5));
            }
        }
        if (this.Wwwwwwwwwwwwwwwwwww == 0) {
            abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7)) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6, this.Wwwwwwwwwwwwwwwwwwwwwwww) || C2358m5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6) == -1) {
                    abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
                    this.Wwwwwwwwwwwwwwwwwwwwwwww = 0;
                    i2 = 0;
                    i = i2;
                    if (i == -1 && (this.Wwwwwwwwwwwwwwwwww instanceof C2741w8)) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwww);
                        if (this.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() != Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                            AbstractC2852z8 abstractC2852z82 = this.Wwwwwwwwwwwwwwwwww;
                            ((C2741w8) abstractC2852z82).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2852z82);
                        }
                    }
                    return i;
                }
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6);
                if (this.Wwwwwwwwwwwwwwwwwwwwww == -9223372036854775807L) {
                    this.Wwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7.getPosition());
                    if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != -9223372036854775807L) {
                        this.Wwwwwwwwwwwwwwwwwwwwww = (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - this.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0L)) + this.Wwwwwwwwwwwwwwwwwwwwww;
                    }
                }
                this.Wwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                AbstractC2852z8 abstractC2852z83 = this.Wwwwwwwwwwwwwwwwww;
                if (abstractC2852z83 instanceof C2741w8) {
                    C2741w8 c2741w8 = (C2741w8) abstractC2852z83;
                    long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwww + wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    long position6 = abstractC2212i7.getPosition() + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (!c2741w8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5)) {
                        c2741w8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5);
                        c2741w8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(position6);
                    }
                    if (this.Wwwwwwwwwwwwwwww && c2741w8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwww)) {
                        this.Wwwwwwwwwwwwwwww = false;
                        this.Wwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
                    }
                }
            }
            i2 = -1;
            i = i2;
            if (i == -1) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwww);
                if (this.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() != Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                }
            }
            return i;
        }
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = this.Wwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2752wj) abstractC2212i7, this.Wwwwwwwwwwwwwwwwwww, true);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 != -1) {
            int i18 = this.Wwwwwwwwwwwwwwwwwww - Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6;
            this.Wwwwwwwwwwwwwwwwwww = i18;
            if (i18 <= 0) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwww), 1, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, null);
                this.Wwwwwwwwwwwwwwwwwwwww += this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                this.Wwwwwwwwwwwwwwwwwww = 0;
                i2 = 0;
                i = i2;
                if (i == -1) {
                }
                return i;
            }
            i2 = 0;
            i = i2;
            if (i == -1) {
            }
            return i;
        }
        i2 = -1;
        i = i2;
        if (i == -1) {
        }
        return i;
    }
}
