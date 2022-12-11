package me.tvspark;

import java.io.IOException;
import me.tvspark.AbstractC1899a7;

/* renamed from: me.tvspark.ib */
/* loaded from: classes4.dex */
public final class C2216ib extends AbstractC1899a7 {

    /* renamed from: me.tvspark.ib$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements AbstractC1899a7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final C2078el Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2078el();
        public final C2337ll Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, C2337ll c2337ll, int i2) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2337ll;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
        }

        @Override // me.tvspark.AbstractC1899a7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public AbstractC1899a7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2212i7 abstractC2212i7, long j) throws IOException {
            long j2;
            long position = abstractC2212i7.getPosition();
            int min = (int) Math.min(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, abstractC2212i7.getLength() - position);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(min);
            abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, min);
            C2078el c2078el = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            long j3 = -1;
            long j4 = -1;
            long j5 = -9223372036854775807L;
            while (c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() >= 188) {
                byte[] bArr = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                int i2 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                while (i2 < i && bArr[i2] != 71) {
                    i2++;
                }
                int i3 = i2 + 188;
                if (i3 > i) {
                    break;
                }
                long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el, i2, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != -9223372036854775807L) {
                    long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww > j) {
                        if (j5 == -9223372036854775807L) {
                            return AbstractC1899a7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, position);
                        }
                        j2 = position + j4;
                    } else if (100000 + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww > j) {
                        j2 = position + i2;
                    } else {
                        j5 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        j4 = i2;
                    }
                    return AbstractC1899a7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j2);
                }
                c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3);
                j3 = i3;
            }
            return j5 != -9223372036854775807L ? AbstractC1899a7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j5, position + j3) : AbstractC1899a7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.AbstractC1899a7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    public C2216ib(C2337ll c2337ll, long j, long j2, int i, int i2) {
        super(new AbstractC1899a7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, c2337ll, i2), j, 0L, j + 1, 0L, j2, 188L, 940);
    }
}
