package me.tvspark;

import androidx.exifinterface.media.ExifInterface;
import java.io.IOException;
import me.tvspark.AbstractC2327lb;
import me.tvspark.AbstractC2625t7;

/* renamed from: me.tvspark.ia */
/* loaded from: classes4.dex */
public final class C2215ia implements AbstractC2175h7 {
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final C2252ja Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2252ja(null);
    public final C2078el Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2078el(2786);

    static {
        C2013da c2013da = C2013da.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public static /* synthetic */ AbstractC2175h7[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return new AbstractC2175h7[]{new C2215ia()};
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
        int read = abstractC2212i7.read(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, 2786);
        if (read == -1) {
            return -1;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(read);
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww = 0L;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0034, code lost:
        r14.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        r5 = r5 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x003d, code lost:
        if ((r5 - r3) < 8192) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x003f, code lost:
        return false;
     */
    @Override // me.tvspark.AbstractC2175h7
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2212i7 abstractC2212i7) throws IOException {
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        C2078el c2078el = new C2078el(10);
        int i = 0;
        while (true) {
            abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, 10);
            c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
            if (c2078el.Wwwwwwwwwwwwwwwwwwww() != 4801587) {
                break;
            }
            c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(3);
            int Wwwwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwwwww();
            i += Wwwwwwwwwwwwwwwwwwwwwww + 10;
            abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwww);
        }
        abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
        int i2 = i;
        while (true) {
            int i3 = 0;
            while (true) {
                abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, 6);
                c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
                if (c2078el.Wwwwwwwwwwwwwwwww() != 2935) {
                    break;
                }
                i3++;
                if (i3 >= 4) {
                    return true;
                }
                byte[] bArr = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (bArr.length < 6) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -1;
                } else {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ((bArr[5] & 248) >> 3) > 10 ? ((((bArr[2] & 7) << 8) | (bArr[3] & 255)) + 1) * 2 : C2774x4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((bArr[4] & ExifInterface.MARKER_SOF0) >> 6, bArr[4] & 63);
                }
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -1) {
                    return false;
                }
                abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - 6);
            }
            abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2);
        }
    }
}
