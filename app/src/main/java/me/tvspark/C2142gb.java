package me.tvspark;

import me.tvspark.AbstractC2327lb;

/* renamed from: me.tvspark.gb */
/* loaded from: classes4.dex */
public final class C2142gb implements AbstractC2327lb {
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final C2078el Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2078el(32);
    public final AbstractC2105fb Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2142gb(AbstractC2105fb abstractC2105fb) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2105fb;
    }

    @Override // me.tvspark.AbstractC2327lb
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
    }

    @Override // me.tvspark.AbstractC2327lb
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el, int i) {
        boolean z = (i & 1) != 0;
        int Wwwwwwwwwwwwwwwwwwwwww = z ? c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + c2078el.Wwwwwwwwwwwwwwwwwwwwww() : -1;
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            if (!z) {
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
            c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        }
        while (c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() > 0) {
            int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i2 < 3) {
                if (i2 == 0) {
                    int Wwwwwwwwwwwwwwwwwwwwww2 = c2078el.Wwwwwwwwwwwwwwwwwwwwww();
                    c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - 1);
                    if (Wwwwwwwwwwwwwwwwwwwwww2 == 255) {
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
                        return;
                    }
                }
                int min = Math.min(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), 3 - this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, min);
                int i3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + min;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i3;
                if (i3 == 3) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3);
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
                    int Wwwwwwwwwwwwwwwwwwwwww3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww();
                    int Wwwwwwwwwwwwwwwwwwwwww4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww();
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwwwwwwwww3 & 128) != 0;
                    int i4 = (((Wwwwwwwwwwwwwwwwwwwwww3 & 15) << 8) | Wwwwwwwwwwwwwwwwwwwwww4) + 3;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i4;
                    C2078el c2078el2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    byte[] bArr = c2078el2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (bArr.length < i4) {
                        c2078el2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Math.min(4098, Math.max(i4, bArr.length * 2)));
                        System.arraycopy(bArr, 0, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, 3);
                    }
                }
            } else {
                int min2 = Math.min(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, min2);
                int i5 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + min2;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i5;
                int i6 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (i5 != i6) {
                    continue;
                } else {
                    if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i6);
                    } else if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, i6, -1) != 0) {
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
                        return;
                    } else {
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - 4);
                    }
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
                }
            }
        }
    }

    @Override // me.tvspark.AbstractC2327lb
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2337ll c2337ll, AbstractC2249j7 abstractC2249j7, AbstractC2327lb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2337ll, abstractC2249j7, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
    }
}
