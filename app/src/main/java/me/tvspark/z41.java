package me.tvspark;

import com.tencent.smtt.sdk.TbsListener;

/* loaded from: classes4.dex */
public class z41 {
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public z41() {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new byte[64];
    }

    public z41(int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new byte[i];
    }

    public z41 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i2 + 2 > this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
        }
        byte[] bArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i3 = i2 + 1;
        bArr[i2] = (byte) (i >>> 8);
        bArr[i3] = (byte) i;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i3 + 1;
        return this;
    }

    public z41 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i2 + 4 > this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
        }
        byte[] bArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i3 = i2 + 1;
        bArr[i2] = (byte) (i >>> 24);
        int i4 = i3 + 1;
        bArr[i3] = (byte) (i >>> 16);
        int i5 = i4 + 1;
        bArr[i4] = (byte) (i >>> 8);
        bArr[i5] = (byte) i;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i5 + 1;
        return this;
    }

    public z41 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i3 = i2 + 1;
        if (i3 > this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i2] = (byte) i;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i3;
        return this;
    }

    public z41 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
        int i3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i3 + 3 > this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3);
        }
        byte[] bArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i4 = i3 + 1;
        bArr[i3] = (byte) i;
        int i5 = i4 + 1;
        bArr[i4] = (byte) (i2 >>> 8);
        bArr[i5] = (byte) i2;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i5 + 1;
        return this;
    }

    public z41 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
        int i3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i3 + 2 > this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
        }
        byte[] bArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i4 = i3 + 1;
        bArr[i3] = (byte) i;
        bArr[i4] = (byte) i2;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i4 + 1;
        return this;
    }

    public z41 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i + 8 > this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(8);
        }
        byte[] bArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i2 = (int) (j >>> 32);
        int i3 = i + 1;
        bArr[i] = (byte) (i2 >>> 24);
        int i4 = i3 + 1;
        bArr[i3] = (byte) (i2 >>> 16);
        int i5 = i4 + 1;
        bArr[i4] = (byte) (i2 >>> 8);
        int i6 = i5 + 1;
        bArr[i5] = (byte) i2;
        int i7 = (int) j;
        int i8 = i6 + 1;
        bArr[i6] = (byte) (i7 >>> 24);
        int i9 = i8 + 1;
        bArr[i8] = (byte) (i7 >>> 16);
        int i10 = i9 + 1;
        bArr[i9] = (byte) (i7 >>> 8);
        bArr[i10] = (byte) i7;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i10 + 1;
        return this;
    }

    public z41 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, int i, int i2) {
        int i3;
        int length = str.length();
        int i4 = i;
        int i5 = i4;
        while (i4 < length) {
            char charAt = str.charAt(i4);
            i5 = (charAt < 1 || charAt > 127) ? charAt > 2047 ? i5 + 3 : i5 + 2 : i5 + 1;
            i4++;
        }
        if (i5 <= i2) {
            int i6 = (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - i) - 2;
            if (i6 >= 0) {
                byte[] bArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                bArr[i6] = (byte) (i5 >>> 8);
                bArr[i6 + 1] = (byte) i5;
            }
            if ((this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + i5) - i > this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i5 - i);
            }
            int i7 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            while (i < length) {
                char charAt2 = str.charAt(i);
                if (charAt2 < 1 || charAt2 > 127) {
                    byte[] bArr2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    int i8 = i7 + 1;
                    if (charAt2 > 2047) {
                        bArr2[i7] = (byte) (((charAt2 >> '\f') & 15) | TbsListener.ErrorCode.EXCEED_INCR_UPDATE);
                        int i9 = i8 + 1;
                        bArr2[i8] = (byte) (((charAt2 >> 6) & 63) | 128);
                        i3 = i9 + 1;
                        bArr2[i9] = (byte) ((charAt2 & '?') | 128);
                    } else {
                        bArr2[i7] = (byte) (((charAt2 >> 6) & 31) | 192);
                        i7 = i8 + 1;
                        bArr2[i8] = (byte) ((charAt2 & '?') | 128);
                        i++;
                    }
                } else {
                    i3 = i7 + 1;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i7] = (byte) charAt2;
                }
                i7 = i3;
                i++;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i7;
            return this;
        }
        throw new IllegalArgumentException();
    }

    public z41 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, int i, int i2) {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + i2 > this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2);
        }
        if (bArr != null) {
            System.arraycopy(bArr, i, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i2);
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += i2;
        return this;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        int length = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length * 2;
        int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + i;
        if (length <= i2) {
            length = i2;
        }
        byte[] bArr = new byte[length];
        System.arraycopy(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, bArr, 0, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = bArr;
    }
}
