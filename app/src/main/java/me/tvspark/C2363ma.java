package me.tvspark;

import java.io.EOFException;
import java.io.IOException;
import me.tvspark.AbstractC2327lb;
import me.tvspark.AbstractC2625t7;
import org.apache.commons.lang3.time.StopWatch;

/* renamed from: me.tvspark.ma */
/* loaded from: classes4.dex */
public final class C2363ma implements AbstractC2175h7 {
    public boolean Wwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public AbstractC2249j7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final C2041dl Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final C2078el Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final C2400na Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2400na(true, null);
    public final C2078el Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2078el(2048);
    public int Wwwwwwwwwwwwwwwwwwwwwwwwww = -1;
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwww = -1;

    static {
        C2104fa c2104fa = C2104fa.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public C2363ma(int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        C2078el c2078el = new C2078el(10);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2078el;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2041dl(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2212i7 abstractC2212i7) throws IOException {
        int i = 0;
        while (true) {
            abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, 10);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww() != 4801587) {
                break;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(3);
            int Wwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww();
            i += Wwwwwwwwwwwwwwwwwwwwwww + 10;
            abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwww);
        }
        abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwww == -1) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        }
        return i;
    }

    @Override // me.tvspark.AbstractC2175h7
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, long j2) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = false;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = j2;
    }

    @Override // me.tvspark.AbstractC2175h7
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2249j7 abstractC2249j7) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2249j7;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2249j7, new AbstractC2327lb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Integer.MIN_VALUE, 0, 1));
        abstractC2249j7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.AbstractC2175h7
    public void release() {
    }

    public static /* synthetic */ AbstractC2175h7[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return new AbstractC2175h7[]{new C2363ma(0)};
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x008a, code lost:
        r17.Wwwwwwwwwwwwwwwwwwwwwwwww = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0093, code lost:
        throw new com.google.android.exoplayer2.ParserException("Malformed ADTS stream");
     */
    @Override // me.tvspark.AbstractC2175h7
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2212i7 abstractC2212i7, C2588s7 c2588s7) throws IOException {
        int i;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        long length = abstractC2212i7.getLength();
        boolean z = ((this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww & 1) == 0 || length == -1) ? false : true;
        if (z && !this.Wwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwww = -1;
            abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            if (abstractC2212i7.getPosition() == 0) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7);
            }
            long j = 0;
            int i2 = 0;
            while (true) {
                try {
                    if (!abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, 2, true)) {
                        break;
                    }
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
                    if (C2400na.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwww())) {
                        if (abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, 4, true)) {
                            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(14);
                            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(13);
                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww <= 6) {
                                break;
                            }
                            j += Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            i2++;
                            if (i2 == 1000) {
                                break;
                            } else if (!abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - 6, true)) {
                                break;
                            }
                        } else {
                            break;
                        }
                    } else {
                        i2 = 0;
                        break;
                    }
                } catch (EOFException unused) {
                }
            }
            abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            if (i2 > 0) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwww = (int) (j / i2);
            } else {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwww = -1;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwww = true;
        }
        int read = abstractC2212i7.read(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, 2048);
        boolean z2 = read == -1;
        if (!this.Wwwwwwwwwwwwwwwwwwwwwww) {
            boolean z3 = z && this.Wwwwwwwwwwwwwwwwwwwwwwwwww > 0;
            if (!z3 || this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww != -9223372036854775807L || z2) {
                if (z3) {
                    long j2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww;
                    if (j2 != -9223372036854775807L) {
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new C2010d7(length, this.Wwwwwwwwwwwwwwwwwwwwwwwwwww, (int) (((i * 8) * StopWatch.NANO_2_MILLIS) / j2), this.Wwwwwwwwwwwwwwwwwwwwwwwwww));
                        this.Wwwwwwwwwwwwwwwwwwwwwww = true;
                    }
                }
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new AbstractC2625t7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(-9223372036854775807L, 0L));
                this.Wwwwwwwwwwwwwwwwwwwwwww = true;
            }
        }
        if (z2) {
            return -1;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(read);
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwww = true;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0021, code lost:
        r9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002a, code lost:
        if ((r3 - r0) < 8192) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x002c, code lost:
        return false;
     */
    @Override // me.tvspark.AbstractC2175h7
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2212i7 abstractC2212i7) throws IOException {
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7);
        int i = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        while (true) {
            int i2 = 0;
            int i3 = 0;
            while (true) {
                abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, 2);
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
                if (!C2400na.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwww())) {
                    break;
                }
                i2++;
                if (i2 >= 4 && i3 > 188) {
                    return true;
                }
                abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, 4);
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(14);
                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(13);
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww <= 6) {
                    return false;
                }
                abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - 6);
                i3 += Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
        }
    }
}
