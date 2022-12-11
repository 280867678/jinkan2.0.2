package me.tvspark;

/* renamed from: me.tvspark.x7 */
/* loaded from: classes4.dex */
public final class C2777x7 {
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2777x7(byte[] bArr) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = bArr;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = bArr.length;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        int i2;
        int i3 = i / 8;
        int i4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + i3;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i4;
        int i5 = (i - (i3 * 8)) + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i5;
        boolean z = true;
        if (i5 > 7) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i4 + 1;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i5 - 8;
        }
        int i6 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i6 < 0 || (i6 >= (i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && (i6 != i2 || this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != 0))) {
            z = false;
        }
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z);
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int min = Math.min(i, 8 - this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        int i3 = i2 + 1;
        int i4 = ((this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i2] & 255) >> this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) & (255 >> (8 - min));
        while (min < i) {
            i4 |= (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i3] & 255) << min;
            min += 8;
            i3++;
        }
        int i5 = i4 & ((-1) >>> (32 - i));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
        return i5;
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        boolean z = (((this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww] & 255) >> this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) & 1) == 1;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
        return z;
    }
}
