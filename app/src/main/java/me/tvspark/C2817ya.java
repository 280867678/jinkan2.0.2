package me.tvspark;

import androidx.annotation.Nullable;
import com.umeng.analytics.pro.C1588bm;
import me.tvspark.AbstractC2327lb;
import me.tvspark.C2245j3;
import me.tvspark.C2358m5;
import org.apache.commons.lang3.time.StopWatch;

/* renamed from: me.tvspark.ya */
/* loaded from: classes4.dex */
public final class C2817ya implements AbstractC2554ra {
    public long Wwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public AbstractC2740w7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final C2078el Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
    public final C2358m5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2358m5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    public C2817ya(@Nullable String str) {
        C2078el c2078el = new C2078el(4);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2078el;
        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[0] = -1;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
    }

    @Override // me.tvspark.AbstractC2554ra
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
    }

    @Override // me.tvspark.AbstractC2554ra
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwww = false;
    }

    @Override // me.tvspark.AbstractC2554ra
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwww = j;
    }

    @Override // me.tvspark.AbstractC2554ra
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el) {
        C2358m5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        while (c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() > 0) {
            int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i == 0) {
                byte[] bArr = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                int i2 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                int i3 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                while (true) {
                    if (i2 >= i3) {
                        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3);
                        break;
                    }
                    boolean z = (bArr[i2] & 255) == 255;
                    boolean z2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwww && (bArr[i2] & C1588bm.f3196k) == 224;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwww = z;
                    if (z2) {
                        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2 + 1);
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwww = false;
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[1] = bArr[i2];
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = 2;
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = 1;
                        break;
                    }
                    i2++;
                }
            } else if (i == 1) {
                int min = Math.min(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), 4 - this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
                c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww, min);
                int i4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww + min;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = i4;
                if (i4 >= 4) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
                    if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww())) {
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = 1;
                    } else {
                        this.Wwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwww) {
                            this.Wwwwwwwwwwwwwwwwwwwwwwwww = (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww * StopWatch.NANO_2_MILLIS) / wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            C2358m5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww = 4096;
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = true;
                        }
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 4);
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = 2;
                    }
                }
            } else if (i == 2) {
                int min2 = Math.min(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), this.Wwwwwwwwwwwwwwwwwwwwwwww - this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el, min2);
                int i5 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww + min2;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = i5;
                int i6 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                if (i5 >= i6) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww, 1, i6, 0, null);
                    this.Wwwwwwwwwwwwwwwwwwwwwww += this.Wwwwwwwwwwwwwwwwwwwwwwwww;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
                }
            } else {
                throw new IllegalStateException();
            }
        }
    }

    @Override // me.tvspark.AbstractC2554ra
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2249j7 abstractC2249j7, AbstractC2327lb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2249j7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), 1);
    }
}
