package me.tvspark;

import androidx.annotation.Nullable;
import java.util.Arrays;
import me.tvspark.AbstractC1939ba;
import me.tvspark.C2434o7;

/* renamed from: me.tvspark.v9 */
/* loaded from: classes4.dex */
public final class C2702v9 extends AbstractC1939ba {
    @Nullable
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwww;
    @Nullable
    public C2434o7 Wwwwwwwwwwwwwwwwwwwww;

    /* renamed from: me.tvspark.v9$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements AbstractC2853z9 {
        public C2434o7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public C2434o7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -1;
        public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -1;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2434o7 c2434o7, C2434o7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2434o7;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.AbstractC2853z9
        public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2212i7 abstractC2212i7) {
            long j = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (j >= 0) {
                long j2 = -(j + 2);
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -1L;
                return j2;
            }
            return -1L;
        }

        @Override // me.tvspark.AbstractC2853z9
        public AbstractC2625t7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != -1);
            return new C2397n7(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }

        @Override // me.tvspark.AbstractC2853z9
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
            long[] jArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = jArr[C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(jArr, j, true, true)];
        }
    }

    @Override // me.tvspark.AbstractC1939ba
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el) {
        if (!(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[0] == -1)) {
            return -1L;
        }
        int i = (c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[2] & 255) >> 4;
        if (i == 6 || i == 7) {
            c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
            c2078el.Wwwwwwwwwwwwwwww();
        }
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2360m7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el, i);
        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
    }

    @Override // me.tvspark.AbstractC1939ba
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
        super.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z);
        if (z) {
            this.Wwwwwwwwwwwwwwwwwwwww = null;
            this.Wwwwwwwwwwwwwwwwwwww = null;
        }
    }

    @Override // me.tvspark.AbstractC1939ba
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el, long j, AbstractC1939ba.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        byte[] bArr = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        C2434o7 c2434o7 = this.Wwwwwwwwwwwwwwwwwwwww;
        if (c2434o7 == null) {
            C2434o7 c2434o72 = new C2434o7(bArr, 17);
            this.Wwwwwwwwwwwwwwwwwwwww = c2434o72;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2434o72.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Arrays.copyOfRange(bArr, 9, c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), (C2254jc) null);
        } else if ((bArr[0] & Byte.MAX_VALUE) == 3) {
            C2434o7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el);
            C2434o7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2434o7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            this.Wwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        } else {
            if (bArr[0] == -1) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwww;
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                }
                return false;
            }
        }
        return true;
    }
}
