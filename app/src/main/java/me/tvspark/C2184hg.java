package me.tvspark;

import com.google.android.exoplayer2.source.hls.SampleQueueMappingException;
import java.io.IOException;
import me.tvspark.C2221ig;

/* renamed from: me.tvspark.hg */
/* loaded from: classes4.dex */
public final class C2184hg implements AbstractC2183hf {
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -1;
    public final C2221ig Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2184hg(C2221ig c2221ig, int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2221ig;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
    }

    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        return (i == -1 || i == -3 || i == -2) ? false : true;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -1);
        C2221ig c2221ig = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        c2221ig.Wwwwwwwwwwwwwwwwwwwwwwwwww();
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2221ig.Kkkkkkkkkkkkk);
        int i2 = c2221ig.Kkkkkkkkkkkkk[i];
        if (i2 == -1) {
            if (c2221ig.Kkkkkkkkkkkkkk.contains(c2221ig.Kkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwww[i])) {
                i2 = -3;
            }
            i2 = -2;
        } else {
            boolean[] zArr = c2221ig.Kkkkkkkkkk;
            if (!zArr[i2]) {
                zArr[i2] = true;
            }
            i2 = -2;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
    }

    @Override // me.tvspark.AbstractC2183hf
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != -3) {
            if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                return false;
            }
            C2221ig c2221ig = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (!(!c2221ig.Wwwwwwwwwwwwwwwwwwwwwwww() && c2221ig.Wwww[this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2221ig.Kkkk))) {
                return false;
            }
        }
        return true;
    }

    @Override // me.tvspark.AbstractC2183hf
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() throws IOException {
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i == -2) {
            C2221ig c2221ig = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            c2221ig.Wwwwwwwwwwwwwwwwwwwwwwwwww();
            C2368mf c2368mf = c2221ig.Kkkkkkkkkkkkkkk;
            throw new SampleQueueMappingException(c2368mf.Wwwwwwwwwwwwwwwwwwwwwww[this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww].Wwwwwwwwwwwwwwwwwwwwwww[0].Wwwwwwwwwwwww);
        } else if (i == -1) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww();
        } else if (i == -3) {
        } else {
            C2221ig c2221ig2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            c2221ig2.Wwwwwwwwwwwwwwwwwwwwww();
            c2221ig2.Wwww[i].Wwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    @Override // me.tvspark.AbstractC2183hf
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2282k3 c2282k3, C2738w5 c2738w5, boolean z) {
        C2245j3 c2245j3;
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -3) {
            c2738w5.addFlag(4);
            return -4;
        } else if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            return -3;
        } else {
            C2221ig c2221ig = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (c2221ig.Wwwwwwwwwwwwwwwwwwwwwwww()) {
                return -3;
            }
            int i2 = 0;
            if (!c2221ig.Wwwwwwwwwwww.isEmpty()) {
                int i3 = 0;
                while (true) {
                    boolean z2 = true;
                    if (i3 >= c2221ig.Wwwwwwwwwwww.size() - 1) {
                        break;
                    }
                    int i4 = c2221ig.Wwwwwwwwwwww.get(i3).Wwwwwwwwwwwwwwwwwwwwwwww;
                    int length = c2221ig.Wwww.length;
                    int i5 = 0;
                    while (true) {
                        if (i5 < length) {
                            if (c2221ig.Kkkkkkkkkk[i5] && c2221ig.Wwww[i5].Wwwwwwwwwwwwwwwwwwwwwwww() == i4) {
                                z2 = false;
                                break;
                            }
                            i5++;
                        } else {
                            break;
                        }
                    }
                    if (!z2) {
                        break;
                    }
                    i3++;
                }
                C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2221ig.Wwwwwwwwwwww, 0, i3);
                C2073eg c2073eg = c2221ig.Wwwwwwwwwwww.get(0);
                C2245j3 c2245j32 = c2073eg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (!c2245j32.equals(c2221ig.Kkkkkkkkkkkkkkkkk)) {
                    c2221ig.Wwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2221ig.Wwwwwwwwwwwwwwwwwwwwwwww, c2245j32, c2073eg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2073eg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2073eg.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
                }
                c2221ig.Kkkkkkkkkkkkkkkkk = c2245j32;
            }
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2221ig.Wwww[i].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2282k3, c2738w5, z, c2221ig.Kkkk);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -5) {
                C2245j3 c2245j33 = c2282k3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j33);
                if (i == c2221ig.Kkkkkkkkkkkkkkkkkkkkkk) {
                    int Wwwwwwwwwwwwwwwwwwwwwwww = c2221ig.Wwww[i].Wwwwwwwwwwwwwwwwwwwwwwww();
                    while (i2 < c2221ig.Wwwwwwwwwwww.size() && c2221ig.Wwwwwwwwwwww.get(i2).Wwwwwwwwwwwwwwwwwwwwwwww != Wwwwwwwwwwwwwwwwwwwwwwww) {
                        i2++;
                    }
                    if (i2 < c2221ig.Wwwwwwwwwwww.size()) {
                        c2245j3 = c2221ig.Wwwwwwwwwwww.get(i2).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    } else {
                        c2245j3 = c2221ig.Kkkkkkkkkkkkkkkkkk;
                        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3);
                    }
                    c2245j33 = c2245j33.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3);
                }
                c2282k3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2245j33;
            }
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
    }

    @Override // me.tvspark.AbstractC2183hf
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            C2221ig c2221ig = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (c2221ig.Wwwwwwwwwwwwwwwwwwwwwwww()) {
                return 0;
            }
            C2221ig.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2221ig.Wwww[i];
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, c2221ig.Kkkk);
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        return 0;
    }
}
