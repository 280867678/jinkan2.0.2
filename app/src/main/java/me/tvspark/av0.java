package me.tvspark;

/* loaded from: classes4.dex */
public abstract class av0 {
    public int Wwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public av0(int i, int i2, int i3, int i4) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (i3 <= 0 || i4 <= 0) ? 0 : (i3 / i2) * i2;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i4;
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, int i, int i2) {
        byte[] bArr2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i3 = 0;
        if (bArr2 == null) {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwww ? -1 : 0;
        }
        if (bArr2 != null) {
            i3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww - this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        int min = Math.min(i3, i2);
        System.arraycopy(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww, bArr, i, min);
        int i4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww + min;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = i4;
        if (i4 >= this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        }
        return min;
    }

    public abstract void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, int i, int i2);

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        byte[] bArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (bArr == null || bArr.length < this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww + i) {
            byte[] bArr2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (bArr2 == null) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new byte[8192];
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
                return;
            }
            byte[] bArr3 = new byte[bArr2.length * 2];
            System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = bArr3;
        }
    }

    public abstract void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, int i, int i2);
}
