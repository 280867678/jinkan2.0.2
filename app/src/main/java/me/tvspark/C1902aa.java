package me.tvspark;

import java.util.Arrays;
import java.util.List;
import me.tvspark.AbstractC1939ba;
import me.tvspark.C2245j3;

/* renamed from: me.tvspark.aa */
/* loaded from: classes4.dex */
public final class C1902aa extends AbstractC1939ba {
    public static final byte[] Wwwwwwwwwwwwwwwwwwww = {79, 112, 117, 115, 72, 101, 97, 100};
    public boolean Wwwwwwwwwwwwwwwwwwwww;

    @Override // me.tvspark.AbstractC1939ba
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el) {
        byte[] bArr = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i = bArr[0] & 255;
        int i2 = i & 3;
        int i3 = 2;
        if (i2 == 0) {
            i3 = 1;
        } else if (i2 != 1 && i2 != 2) {
            i3 = bArr[1] & 63;
        }
        int i4 = i >> 3;
        int i5 = i4 & 3;
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3 * (i4 >= 16 ? 2500 << i5 : i4 >= 12 ? 10000 << (i5 & 1) : i5 == 3 ? 60000 : 10000 << i5));
    }

    @Override // me.tvspark.AbstractC1939ba
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
        super.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z);
        if (z) {
            this.Wwwwwwwwwwwwwwwwwwwww = false;
        }
    }

    @Override // me.tvspark.AbstractC1939ba
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el, long j, AbstractC1939ba.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        boolean z = true;
        if (this.Wwwwwwwwwwwwwwwwwwwww) {
            if (c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() != 1332770163) {
                z = false;
            }
            c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
            return z;
        }
        byte[] copyOf = Arrays.copyOf(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        List<byte[]> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(copyOf);
        C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = new C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwww = "audio/opus";
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwww = copyOf[9] & 255;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwww = 48000;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwwwwwww = true;
        return true;
    }
}
