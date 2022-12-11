package me.tvspark;

import java.io.IOException;
import java.util.Objects;
import me.tvspark.AbstractC1899a7;
import me.tvspark.C2360m7;

/* renamed from: me.tvspark.f8 */
/* loaded from: classes4.dex */
public final class C2102f8 extends AbstractC1899a7 {

    /* renamed from: me.tvspark.f8$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements AbstractC1899a7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final C2360m7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2360m7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final C2434o7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2434o7 c2434o7, int i, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2434o7;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        }

        public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2212i7 abstractC2212i7) throws IOException {
            while (abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() < abstractC2212i7.getLength() - 6) {
                C2434o7 c2434o7 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                C2360m7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                byte[] bArr = new byte[2];
                boolean z = false;
                abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, 0, 2);
                if ((((bArr[0] & 255) << 8) | (bArr[1] & 255)) != i) {
                    abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - abstractC2212i7.getPosition()));
                } else {
                    C2078el c2078el = new C2078el(16);
                    System.arraycopy(bArr, 0, c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, 2);
                    c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7, c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 2, 14));
                    abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - abstractC2212i7.getPosition()));
                    z = C2360m7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el, c2434o7, i, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                }
                if (z) {
                    break;
                }
                abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
            }
            if (abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() >= abstractC2212i7.getLength() - 6) {
                abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) (abstractC2212i7.getLength() - abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()));
                return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwww;
            }
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.AbstractC1899a7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public AbstractC1899a7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2212i7 abstractC2212i7, long j) throws IOException {
            long position = abstractC2212i7.getPosition();
            long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7);
            long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Math.max(6, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
            long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7);
            return (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww > j || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 <= j) ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 <= j ? AbstractC1899a7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) : AbstractC1899a7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, position) : AbstractC1899a7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        }

        @Override // me.tvspark.AbstractC1899a7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            C1936b7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C2102f8(final C2434o7 c2434o7, int i, long j, long j2) {
        super(r1, r2, r3, 0L, r7, j, j2, r5 + r9, Math.max(6, c2434o7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
        long j3;
        long j4;
        Objects.requireNonNull(c2434o7);
        AbstractC1899a7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new AbstractC1899a7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() { // from class: me.tvspark.e8
            @Override // me.tvspark.AbstractC1899a7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
            public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j5) {
                return C2434o7.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j5);
            }
        };
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2434o7, i, null);
        long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2434o7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        long j5 = c2434o7.Wwwwwwwwwwwwwwwwwwwwwwwww;
        int i2 = c2434o7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i2 > 0) {
            j3 = (i2 + c2434o7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) / 2;
            j4 = 1;
        } else {
            int i3 = c2434o7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            j3 = ((((i3 != c2434o7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww || i3 <= 0) ? 4096L : i3) * c2434o7.Wwwwwwwwwwwwwwwwwwwwwwwwwwww) * c2434o7.Wwwwwwwwwwwwwwwwwwwwwwwwwww) / 8;
            j4 = 64;
        }
    }
}
