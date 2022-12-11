package me.tvspark;

import java.io.IOException;
import me.tvspark.AbstractC1899a7;

/* renamed from: me.tvspark.cb */
/* loaded from: classes4.dex */
public final class C1977cb extends AbstractC1899a7 {

    /* renamed from: me.tvspark.cb$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements AbstractC1899a7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final C2078el Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2078el();
        public final C2337ll Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2337ll c2337ll, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2337ll;
        }

        @Override // me.tvspark.AbstractC1899a7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public AbstractC1899a7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2212i7 abstractC2212i7, long j) throws IOException {
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            long j2;
            long position = abstractC2212i7.getPosition();
            int min = (int) Math.min(20000L, abstractC2212i7.getLength() - position);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(min);
            abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, min);
            C2078el c2078el = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i = -1;
            long j3 = -9223372036854775807L;
            int i2 = -1;
            while (c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() >= 4) {
                if (C1977cb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) != 442) {
                    c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
                } else {
                    c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
                    long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2031db.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el);
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != -9223372036854775807L) {
                        long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww > j) {
                            if (j3 == -9223372036854775807L) {
                                return AbstractC1899a7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, position);
                            }
                            j2 = i2;
                        } else if (100000 + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww > j) {
                            j2 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        } else {
                            i2 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            j3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        }
                        return AbstractC1899a7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(position + j2);
                    }
                    int i3 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() >= 10) {
                        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(9);
                        int Wwwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwwww() & 7;
                        if (c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() >= Wwwwwwwwwwwwwwwwwwwwww) {
                            c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwww);
                            if (c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() >= 4) {
                                if (C1977cb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) == 443) {
                                    c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
                                    int Wwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwww();
                                    if (c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() >= Wwwwwwwwwwwwwwwww) {
                                        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwww);
                                    }
                                }
                                while (c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() >= 4 && (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C1977cb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) != 442 && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != 441 && (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >>> 8) == 1) {
                                    c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
                                    if (c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() >= 2) {
                                        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Math.min(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + c2078el.Wwwwwwwwwwwwwwwww()));
                                    }
                                }
                                i = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            }
                        }
                    }
                    c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3);
                    i = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                }
            }
            return j3 != -9223372036854775807L ? AbstractC1899a7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j3, position + i) : AbstractC1899a7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.AbstractC1899a7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    public C1977cb(C2337ll c2337ll, long j, long j2) {
        super(new AbstractC1899a7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2337ll, null), j, 0L, j + 1, 0L, j2, 188L, 1000);
    }

    public static /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }
}
