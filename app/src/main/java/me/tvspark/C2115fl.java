package me.tvspark;

/* renamed from: me.tvspark.fl */
/* loaded from: classes4.dex */
public final class C2115fl {
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2115fl(byte[] bArr, int i, int i2) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = bArr;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int i = 1;
        int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
        if (i2 == 8) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
            int i3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3 + 1)) {
                i = 2;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i3 + i;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        return ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1) / 2) * (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww % 2 == 0 ? -1 : 1);
    }

    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int i = 0;
        int i2 = 0;
        while (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            i2++;
        }
        int i3 = (1 << i2) - 1;
        if (i2 > 0) {
            i = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2);
        }
        return i3 + i;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i3 = i / 8;
        int i4 = i2 + i3;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i4;
        int i5 = (i - (i3 * 8)) + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i5;
        if (i5 > 7) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i4 + 1;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i5 - 8;
        }
        while (true) {
            i2++;
            if (i2 > this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                return;
            } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2)) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww++;
                i2 += 2;
            }
        }
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        boolean z = (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww] & (128 >> this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) != 0;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        return z;
    }

    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        if (2 <= i && i < this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            byte[] bArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (bArr[i] == 3 && bArr[i - 2] == 0 && bArr[i - 1] == 0) {
                return true;
            }
        }
        return false;
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        int i2;
        int i3;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += i;
        int i4 = 0;
        while (true) {
            i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            i3 = 2;
            if (i2 <= 8) {
                break;
            }
            int i5 = i2 - 8;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i5;
            byte[] bArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i6 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            i4 |= (bArr[i6] & 255) << i5;
            if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i6 + 1)) {
                i3 = 1;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i6 + i3;
        }
        byte[] bArr2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i7 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i8 = ((-1) >>> (32 - i)) & (i4 | ((bArr2[i7] & 255) >> (8 - i2)));
        if (i2 == 8) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
            if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i7 + 1)) {
                i3 = 1;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i7 + i3;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        return i8;
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i3 = 0;
        while (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            i3++;
        }
        boolean z = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
        return !z && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((i3 * 2) + 1);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int i;
        int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2 >= 0 && (i2 < (i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) || (i2 == i && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 0)));
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i3 = i / 8;
        int i4 = i2 + i3;
        int i5 = (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + i) - (i3 * 8);
        if (i5 > 7) {
            i4++;
            i5 -= 8;
        }
        while (true) {
            i2++;
            if (i2 > i4 || i4 >= this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                break;
            } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2)) {
                i4++;
                i2 += 2;
            }
        }
        int i6 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i4 >= i6) {
            return i4 == i6 && i5 == 0;
        }
        return true;
    }
}
