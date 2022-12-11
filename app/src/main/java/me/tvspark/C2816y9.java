package me.tvspark;

import com.google.android.exoplayer2.ParserException;
import java.io.EOFException;
import java.io.IOException;

/* renamed from: me.tvspark.y9 */
/* loaded from: classes4.dex */
public final class C2816y9 {
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwww = new int[255];
    public final C2078el Wwwwwwwwwwwwwwwwwwwwwwwwwww = new C2078el(255);

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0L;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2212i7 abstractC2212i7, boolean z) throws IOException {
        boolean z2;
        int i;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(27);
        try {
            z2 = abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, 27, z);
        } catch (EOFException e) {
            if (!z) {
                throw e;
            }
            z2 = false;
        }
        if (!z2 || this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww() != 1332176723) {
            return false;
        }
        int Wwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwww;
        if (Wwwwwwwwwwwwwwwwwwwwww != 0) {
            if (!z) {
                throw new ParserException("unsupported bit stream revision");
            }
            return false;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww();
        C2078el c2078el = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        byte[] bArr = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i2 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1;
        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
        int i3 = i2 + 1;
        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i3;
        int i4 = i3 + 1;
        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i4;
        int i5 = i4 + 1;
        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i5;
        int i6 = i5 + 1;
        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i6;
        int i7 = i6 + 1;
        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i7;
        int i8 = i7 + 1;
        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i8;
        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i8 + 1;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ((bArr[i8] & 255) << 56) | (bArr[i] & 255) | ((bArr[i2] & 255) << 8) | ((bArr[i3] & 255) << 16) | ((bArr[i4] & 255) << 24) | ((bArr[i5] & 255) << 32) | ((bArr[i6] & 255) << 40) | ((bArr[i7] & 255) << 48);
        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
        int Wwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwww2;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwww2 + 27;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwww2);
        abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        for (int i9 = 0; i9 < this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww; i9++) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww[i9] = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww += this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww[i9];
        }
        return true;
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2212i7 abstractC2212i7, long j) throws IOException {
        int i;
        boolean z;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7.getPosition() == abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        while (true) {
            i = (j > (-1L) ? 1 : (j == (-1L) ? 0 : -1));
            if (i != 0 && abstractC2212i7.getPosition() + 4 >= j) {
                break;
            }
            try {
                z = abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, 4, true);
            } catch (EOFException unused) {
                z = false;
            }
            if (!z) {
                break;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww() == 1332176723) {
                abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                return true;
            }
            abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
        }
        do {
            if (i != 0 && abstractC2212i7.getPosition() >= j) {
                break;
            }
        } while (abstractC2212i7.skip(1) != -1);
        return false;
    }
}
