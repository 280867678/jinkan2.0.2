package me.tvspark;

/* renamed from: me.tvspark.dl */
/* loaded from: classes4.dex */
public final class C2041dl {
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2041dl() {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public C2041dl(byte[] bArr) {
        int length = bArr.length;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = bArr;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = length;
    }

    public C2041dl(byte[] bArr, int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = bArr;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        if (i == 8) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww++;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        boolean z = (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww] & (128 >> this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) != 0;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
        return z;
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww * 8) + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 0);
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 0);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += i;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 0) {
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww++;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        int i2 = i / 8;
        int i3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + i2;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i3;
        int i4 = (i - (i2 * 8)) + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i4;
        if (i4 > 7) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i3 + 1;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i4 - 8;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return ((this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) * 8) - this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        int i2 = i / 8;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i - (i2 * 8);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, int i, int i2) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 0);
        System.arraycopy(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, bArr, i, i2);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += i2;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        int i2;
        if (i == 0) {
            return 0;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += i;
        int i3 = 0;
        while (true) {
            i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i2 <= 8) {
                break;
            }
            int i4 = i2 - 8;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i4;
            byte[] bArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i5 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i5 + 1;
            i3 |= (bArr[i5] & 255) << i4;
        }
        byte[] bArr2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i6 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i7 = ((-1) >>> (32 - i)) & (i3 | ((bArr2[i6] & 255) >> (8 - i2)));
        if (i2 == 8) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i6 + 1;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        return i7;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int i;
        int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2 >= 0 && (i2 < (i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) || (i2 == i && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 0)));
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = bArr;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, int i, int i2) {
        int i3 = (i2 >> 3) + i;
        while (i < i3) {
            byte[] bArr2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i5 = i4 + 1;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i5;
            byte b = bArr2[i4];
            int i6 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            bArr[i] = (byte) (b << i6);
            bArr[i] = (byte) (((255 & bArr2[i5]) >> (8 - i6)) | bArr[i]);
            i++;
        }
        int i7 = i2 & 7;
        if (i7 == 0) {
            return;
        }
        bArr[i3] = (byte) (bArr[i3] & (255 >> i7));
        int i8 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i8 + i7 > 8) {
            int i9 = bArr[i3];
            byte[] bArr3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i10 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i10 + 1;
            bArr[i3] = (byte) (i9 | ((bArr3[i10] & 255) << i8));
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i8 - 8;
        }
        int i11 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + i7;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i11;
        byte[] bArr4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i12 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        bArr[i3] = (byte) (((byte) (((255 & bArr4[i12]) >> (8 - i11)) << (8 - i7))) | bArr[i3]);
        if (i11 == 8) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i12 + 1;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }
}
