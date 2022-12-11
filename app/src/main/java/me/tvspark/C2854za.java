package me.tvspark;

import java.util.Arrays;

/* renamed from: me.tvspark.za */
/* loaded from: classes4.dex */
public final class C2854za {
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2854za(int i, int i2) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        byte[] bArr = new byte[i2 + 3];
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = bArr;
        bArr[2] = 1;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        boolean z = true;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        if (i != this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            z = false;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
        if (z) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 3;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, int i, int i2) {
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return;
        }
        int i3 = i2 - i;
        byte[] bArr2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int length = bArr2.length;
        int i4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (length < i4 + i3) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Arrays.copyOf(bArr2, (i4 + i3) * 2);
        }
        System.arraycopy(bArr, i, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i3);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww += i3;
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return false;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww -= i;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
        return true;
    }
}
