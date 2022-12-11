package me.tvspark;

import androidx.annotation.Nullable;
import me.tvspark.AbstractC2327lb;
import me.tvspark.C2245j3;
import me.tvspark.C2811y4;
import org.apache.commons.lang3.time.StopWatch;

/* renamed from: me.tvspark.la */
/* loaded from: classes4.dex */
public final class C2326la implements AbstractC2554ra {
    public long Wwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwww;
    public C2245j3 Wwwwwwwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwwwwwwwww;
    public AbstractC2740w7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final C2078el Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final C2041dl Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwww = false;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwww = false;

    public C2326la(@Nullable String str) {
        C2041dl c2041dl = new C2041dl(new byte[16]);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2041dl;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2078el(c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
    }

    @Override // me.tvspark.AbstractC2554ra
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
    }

    @Override // me.tvspark.AbstractC2554ra
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = false;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwww = false;
    }

    @Override // me.tvspark.AbstractC2554ra
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, int i) {
        this.Wwwwwwwwwwwwwwwwwwwwww = j;
    }

    @Override // me.tvspark.AbstractC2554ra
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el) {
        int i;
        boolean z;
        int Wwwwwwwwwwwwwwwwwwwwww;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        while (c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() > 0) {
            int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            boolean z2 = true;
            if (i2 == 0) {
                while (true) {
                    i = 65;
                    if (c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() <= 0) {
                        z = false;
                        break;
                    } else if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwww) {
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwwww() == 172;
                    } else {
                        Wwwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwwww();
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwww == 172;
                        if (Wwwwwwwwwwwwwwwwwwwwww == 64 || Wwwwwwwwwwwwwwwwwwwwww == 65) {
                            break;
                        }
                    }
                }
                this.Wwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwww == 65;
                z = true;
                if (z) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = 1;
                    byte[] bArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    bArr[0] = -84;
                    if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwww) {
                        i = 64;
                    }
                    bArr[1] = (byte) i;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = 2;
                }
            } else if (i2 == 1) {
                byte[] bArr2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                int min = Math.min(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), 16 - this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
                System.arraycopy(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, bArr2, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww, min);
                c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += min;
                int i3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww + min;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = i3;
                if (i3 != 16) {
                    z2 = false;
                }
                if (z2) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
                    C2811y4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2811y4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    C2245j3 c2245j3 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                    if (c2245j3 == null || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != c2245j3.Kkkkkkkkkkkkkkkkkkkkkkkk || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != c2245j3.Kkkkkkkkkkkkkkkkkkkkkkk || !"audio/ac4".equals(c2245j3.Wwwwwwwwwwwww)) {
                        C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww = "audio/ac4";
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        C2245j3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        this.Wwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                    }
                    this.Wwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww * StopWatch.NANO_2_MILLIS) / this.Wwwwwwwwwwwwwwwwwwwwwwww.Kkkkkkkkkkkkkkkkkkkkkkk;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 16);
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = 2;
                }
            } else if (i2 == 2) {
                int min2 = Math.min(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), this.Wwwwwwwwwwwwwwwwwwwwwww - this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el, min2);
                int i4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww + min2;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = i4;
                int i5 = this.Wwwwwwwwwwwwwwwwwwwwwww;
                if (i4 == i5) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwww, 1, i5, 0, null);
                    this.Wwwwwwwwwwwwwwwwwwwwww += this.Wwwwwwwwwwwwwwwwwwwwwwwww;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
                }
            }
        }
    }

    @Override // me.tvspark.AbstractC2554ra
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2249j7 abstractC2249j7, AbstractC2327lb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2249j7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), 1);
    }
}
