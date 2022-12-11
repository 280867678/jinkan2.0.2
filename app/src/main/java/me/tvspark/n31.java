package me.tvspark;

/* loaded from: classes4.dex */
public abstract class n31 {
    public float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public n31() {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww > 1024;
    }

    public float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int i;
        int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i2 <= 0 || (i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) <= 4) {
            return 0.01f;
        }
        if (i2 != i) {
            float f = (i / (i2 - i)) * this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (f < 0.99f) {
                return f;
            }
        }
        return 0.99f;
    }

    public abstract int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, int i);

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, int i, int i2) {
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2 == 2 ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, i) : -1;
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 0) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww++;
            int[] iArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= iArr.length || 512 <= iArr[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww]) {
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww++;
        }
    }
}
