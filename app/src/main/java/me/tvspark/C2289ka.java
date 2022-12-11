package me.tvspark;

import java.io.IOException;
import me.tvspark.AbstractC2327lb;
import me.tvspark.AbstractC2625t7;

/* renamed from: me.tvspark.ka */
/* loaded from: classes4.dex */
public final class C2289ka implements AbstractC2175h7 {
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final C2326la Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2326la(null);
    public final C2078el Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2078el(16384);

    static {
        C2067ea c2067ea = C2067ea.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public static /* synthetic */ AbstractC2175h7[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return new AbstractC2175h7[]{new C2289ka()};
    }

    @Override // me.tvspark.AbstractC2175h7
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, long j2) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.AbstractC2175h7
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2249j7 abstractC2249j7) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2249j7, new AbstractC2327lb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Integer.MIN_VALUE, 0, 1));
        abstractC2249j7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        abstractC2249j7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new AbstractC2625t7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(-9223372036854775807L, 0L));
    }

    @Override // me.tvspark.AbstractC2175h7
    public void release() {
    }

    @Override // me.tvspark.AbstractC2175h7
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2212i7 abstractC2212i7, C2588s7 c2588s7) throws IOException {
        int read = abstractC2212i7.read(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, 16384);
        if (read == -1) {
            return -1;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(read);
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww = 0L;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x003a, code lost:
        r15.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0043, code lost:
        if ((r4 - r3) < 8192) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0045, code lost:
        return false;
     */
    @Override // me.tvspark.AbstractC2175h7
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2212i7 abstractC2212i7) throws IOException {
        int i;
        C2078el c2078el = new C2078el(10);
        int i2 = 0;
        while (true) {
            abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, 10);
            c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
            if (c2078el.Wwwwwwwwwwwwwwwwwwww() != 4801587) {
                break;
            }
            c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(3);
            int Wwwwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwwwww();
            i2 += Wwwwwwwwwwwwwwwwwwwwwww + 10;
            abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwww);
        }
        abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2);
        int i3 = i2;
        while (true) {
            int i4 = 0;
            while (true) {
                int i5 = 7;
                abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, 7);
                c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
                int Wwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwww();
                if (Wwwwwwwwwwwwwwwww != 44096 && Wwwwwwwwwwwwwwwww != 44097) {
                    break;
                }
                i4++;
                if (i4 >= 4) {
                    return true;
                }
                byte[] bArr = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (bArr.length < 7) {
                    i = -1;
                } else {
                    int i6 = ((bArr[2] & 255) << 8) | (bArr[3] & 255);
                    if (i6 == 65535) {
                        i6 = ((bArr[4] & 255) << 16) | ((bArr[5] & 255) << 8) | (bArr[6] & 255);
                    } else {
                        i5 = 4;
                    }
                    if (Wwwwwwwwwwwwwwwww == 44097) {
                        i5 += 2;
                    }
                    i = i6 + i5;
                }
                if (i == -1) {
                    return false;
                }
                abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i - 7);
            }
            abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3);
        }
    }
}
