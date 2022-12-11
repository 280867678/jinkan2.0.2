package me.tvspark;

import java.io.IOException;
import java.util.Arrays;

/* renamed from: me.tvspark.x9 */
/* loaded from: classes4.dex */
public final class C2779x9 {
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final C2816y9 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2816y9();
    public final C2078el Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2078el(new byte[65025], 0);
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -1;

    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        int i2;
        int i3 = 0;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        do {
            int i4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i5 = i + i4;
            C2816y9 c2816y9 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i5 >= c2816y9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                break;
            }
            int[] iArr = c2816y9.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i4 + 1;
            i2 = iArr[i4 + i];
            i3 += i2;
        } while (i2 == 255);
        return i3;
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2212i7 abstractC2212i7) throws IOException {
        int i;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7 != null);
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
        }
        while (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < 0) {
                if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7, -1L) || !this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7, true)) {
                    return false;
                }
                C2816y9 c2816y9 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                int i2 = c2816y9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if ((c2816y9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww & 1) == 1 && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 0) {
                    i2 += Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
                    i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 0;
                } else {
                    i = 0;
                }
                abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2);
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            }
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            int i3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww > 0) {
                C2078el c2078el = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                byte[] bArr = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                int length = bArr.length;
                int i4 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (length < i4 + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Arrays.copyOf(bArr, i4 + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                }
                C2078el c2078el2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                abstractC2212i7.readFully(c2078el2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2078el2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                C2078el c2078el3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                c2078el3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww[i3 + (-1)] != 255;
            }
            if (i3 == this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                i3 = -1;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i3;
        }
        return true;
    }
}
