package me.tvspark;

import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import java.nio.charset.Charset;

/* renamed from: me.tvspark.el */
/* loaded from: classes4.dex */
public final class C2078el {
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2078el() {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public C2078el(int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new byte[i];
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
    }

    public C2078el(byte[] bArr) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = bArr;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = bArr.length;
    }

    public C2078el(byte[] bArr, int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = bArr;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
    }

    public long Wwwwwwwwwwwwwwww() {
        int i;
        int i2;
        byte b;
        int i3;
        long j = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww];
        int i4 = 7;
        while (true) {
            if (i4 < 0) {
                break;
            }
            if (((1 << i4) & j) != 0) {
                i4--;
            } else if (i4 < 6) {
                j &= i3 - 1;
                i2 = 7 - i4;
            } else if (i4 == 7) {
                i2 = 1;
            }
        }
        i2 = 0;
        if (i2 == 0) {
            StringBuilder sb = new StringBuilder(55);
            sb.append("Invalid UTF-8 sequence first byte: ");
            sb.append(j);
            throw new NumberFormatException(sb.toString());
        }
        for (i = 1; i < i2; i++) {
            if ((this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + i] & ExifInterface.MARKER_SOF0) != 128) {
                StringBuilder sb2 = new StringBuilder(62);
                sb2.append("Invalid UTF-8 sequence continuation byte: ");
                sb2.append(j);
                throw new NumberFormatException(sb2.toString());
            }
            j = (j << 6) | (b & 63);
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += i2;
        return j;
    }

    public int Wwwwwwwwwwwwwwwww() {
        byte[] bArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i2 = i + 1;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2 + 1;
        return (bArr[i2] & 255) | ((bArr[i] & 255) << 8);
    }

    public long Wwwwwwwwwwwwwwwwww() {
        long Wwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwww();
        if (Wwwwwwwwwwwwwwwwwwwwwwwww >= 0) {
            return Wwwwwwwwwwwwwwwwwwwwwwwww;
        }
        StringBuilder sb = new StringBuilder(38);
        sb.append("Top bit not zero: ");
        sb.append(Wwwwwwwwwwwwwwwwwwwwwwwww);
        throw new IllegalStateException(sb.toString());
    }

    public int Wwwwwwwwwwwwwwwwwww() {
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 0) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        throw new IllegalStateException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(29, "Top bit not zero: ", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
    }

    public int Wwwwwwwwwwwwwwwwwwww() {
        byte[] bArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i2 = i + 1;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
        int i3 = i2 + 1;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i3;
        int i4 = ((bArr[i] & 255) << 16) | ((bArr[i2] & 255) << 8);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i3 + 1;
        return (bArr[i3] & 255) | i4;
    }

    public long Wwwwwwwwwwwwwwwwwwwww() {
        byte[] bArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i2 = i + 1;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
        int i3 = i2 + 1;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i3;
        int i4 = i3 + 1;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i4;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i4 + 1;
        return ((bArr[i] & 255) << 24) | ((bArr[i2] & 255) << 16) | ((bArr[i3] & 255) << 8) | (bArr[i4] & 255);
    }

    public int Wwwwwwwwwwwwwwwwwwwwww() {
        byte[] bArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i + 1;
        return bArr[i] & 255;
    }

    public int Wwwwwwwwwwwwwwwwwwwwwww() {
        return (Wwwwwwwwwwwwwwwwwwwwww() << 21) | (Wwwwwwwwwwwwwwwwwwwwww() << 14) | (Wwwwwwwwwwwwwwwwwwwwww() << 7) | Wwwwwwwwwwwwwwwwwwwwww();
    }

    @Nullable
    public String Wwwwwwwwwwwwwwwwwwwwwwww() {
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == 0) {
            return null;
        }
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        while (i < this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i] != 0) {
            i++;
        }
        byte[] bArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, i2, i - i2);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        if (i < this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i + 1;
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public long Wwwwwwwwwwwwwwwwwwwwwwwww() {
        byte[] bArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i2 = i + 1;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
        int i3 = i2 + 1;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i3;
        int i4 = i3 + 1;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i4;
        int i5 = i4 + 1;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i5;
        int i6 = i5 + 1;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i6;
        int i7 = i6 + 1;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i7;
        int i8 = i7 + 1;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i8;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i8 + 1;
        return ((bArr[i] & 255) << 56) | ((bArr[i2] & 255) << 48) | ((bArr[i3] & 255) << 40) | ((bArr[i4] & 255) << 32) | ((bArr[i5] & 255) << 24) | ((bArr[i6] & 255) << 16) | ((bArr[i7] & 255) << 8) | (bArr[i8] & 255);
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwww() {
        byte[] bArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i2 = i + 1;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2 + 1;
        return ((bArr[i2] & 255) << 8) | (bArr[i] & 255);
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 0) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        throw new IllegalStateException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(29, "Top bit not zero: ", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
    }

    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        byte[] bArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i2 = i + 1;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
        int i3 = i2 + 1;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i3;
        int i4 = i3 + 1;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i4;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i4 + 1;
        return (bArr[i] & 255) | ((bArr[i2] & 255) << 8) | ((bArr[i3] & 255) << 16) | ((bArr[i4] & 255) << 24);
    }

    public short Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        byte[] bArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i2 = i + 1;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2 + 1;
        return (short) (((bArr[i2] & 255) << 8) | (bArr[i] & 255));
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + i);
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        byte[] bArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i2 = i + 1;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
        int i3 = i2 + 1;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i3;
        int i4 = (bArr[i] & 255) | ((bArr[i2] & 255) << 8);
        int i5 = i3 + 1;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i5;
        int i6 = i4 | ((bArr[i3] & 255) << 16);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i5 + 1;
        return ((bArr[i5] & 255) << 24) | i6;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i >= 0 && i <= this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
    }

    @Nullable
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == 0) {
            return null;
        }
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        while (i < this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && !C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i])) {
            i++;
        }
        int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i - i2 >= 3) {
            byte[] bArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (bArr[i2] == -17 && bArr[i2 + 1] == -69 && bArr[i2 + 2] == -65) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2 + 3;
            }
        }
        byte[] bArr2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr2, i3, i - i3);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        int i4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i == i4) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i] == 13) {
            int i5 = i + 1;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i5;
            if (i5 == i4) {
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
        }
        byte[] bArr3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i6 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (bArr3[i6] == 10) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i6 + 1;
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i >= 0 && i <= this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        byte[] bArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i2 = i + 1;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
        int i3 = i2 + 1;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i3;
        int i4 = ((bArr[i] & 255) << 24) | ((bArr[i2] & 255) << 16);
        int i5 = i3 + 1;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i5;
        int i6 = i4 | ((bArr[i3] & 255) << 8);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i5 + 1;
        return (bArr[i5] & 255) | i6;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        byte[] bArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (bArr.length < i) {
            bArr = new byte[i];
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, i);
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww] & 255;
    }

    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, C2160gt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        if (i == 0) {
            return "";
        }
        int i2 = (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + i) - 1;
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, (i2 >= this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww || this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i2] != 0) ? i : i - 1);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += i;
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, Charset charset) {
        String str = new String(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i, charset);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += i;
        return str;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2041dl c2041dl, int i) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, i);
        c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr) {
        int length = bArr.length;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = bArr;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = length;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = bArr;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, int i, int i2) {
        System.arraycopy(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, bArr, i, i2);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += i2;
    }
}
