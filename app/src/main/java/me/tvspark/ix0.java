package me.tvspark;

/* loaded from: classes4.dex */
public final class ix0 {
    public ix0 Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public ix0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public ix0() {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new byte[8192];
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
    }

    public ix0(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, "data");
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = bArr;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z2;
    }

    public final ix0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
        return new ix0(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, true, false);
    }

    public final ix0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        ix0 ix0Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (ix0Var == this) {
            ix0Var = null;
        }
        ix0 ix0Var2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (ix0Var2 == null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        }
        ix0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        ix0 ix0Var3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (ix0Var3 == null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        }
        ix0Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = ix0Var2;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        return ix0Var;
    }

    public final ix0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ix0 ix0Var) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ix0Var, "segment");
        ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = this;
        ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        ix0 ix0Var2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (ix0Var2 == null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        }
        ix0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = ix0Var;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = ix0Var;
        return ix0Var;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ix0 ix0Var, int i) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ix0Var, "sink");
        if (ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            int i2 = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i2 + i > 8192) {
                if (ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    throw new IllegalArgumentException();
                }
                int i3 = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if ((i2 + i) - i3 > 8192) {
                    throw new IllegalArgumentException();
                }
                byte[] bArr = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, i3, bArr, 0, i2 - i3);
                ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww -= ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
            }
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i);
            ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += i;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += i;
            return;
        }
        throw new IllegalStateException("only owner can write".toString());
    }
}
