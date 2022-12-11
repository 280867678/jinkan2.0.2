package me.tvspark;

import androidx.annotation.Nullable;
import java.io.EOFException;
import java.io.IOException;
import me.tvspark.AbstractC2625t7;
import org.apache.commons.lang3.time.StopWatch;
import org.eclipse.jetty.server.AsyncContinuation;

/* renamed from: me.tvspark.u9 */
/* loaded from: classes4.dex */
public final class C2664u9 implements AbstractC2853z9 {
    public long Wwwwwwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final AbstractC1939ba Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final C2816y9 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: me.tvspark.u9$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements AbstractC2625t7 {
        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        }

        @Override // me.tvspark.AbstractC2625t7
        public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            C2664u9 c2664u9 = C2664u9.this;
            return (c2664u9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww * StopWatch.NANO_2_MILLIS) / c2664u9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.AbstractC2625t7
        public AbstractC2625t7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
            C2664u9 c2664u9 = C2664u9.this;
            long j2 = (c2664u9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww * j) / StopWatch.NANO_2_MILLIS;
            long j3 = c2664u9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            long j4 = c2664u9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            return new AbstractC2625t7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new C2662u7(j, C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((((j4 - j3) * j2) / c2664u9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) + j3) - AsyncContinuation.DEFAULT_TIMEOUT, j3, j4 - 1)));
        }

        @Override // me.tvspark.AbstractC2625t7
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return true;
        }
    }

    public C2664u9(AbstractC1939ba abstractC1939ba, long j, long j2, long j3, long j4, boolean z) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j >= 0 && j2 > j);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC1939ba;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j2;
        if (j3 == j2 - j || z) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = j4;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 4;
        } else {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2816y9();
    }

    @Override // me.tvspark.AbstractC2853z9
    @Nullable
    public AbstractC2625t7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww != 0) {
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null);
        }
        return null;
    }

    @Override // me.tvspark.AbstractC2853z9
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, 0L, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww - 1);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 2;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = 0L;
        this.Wwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00c6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c7  */
    @Override // me.tvspark.AbstractC2853z9
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2212i7 abstractC2212i7) throws IOException {
        long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        long j;
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i == 0) {
            long position = abstractC2212i7.getPosition();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = position;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 1;
            long j2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - 65307;
            if (j2 > position) {
                return j2;
            }
        } else if (i != 1) {
            if (i == 2) {
                if (this.Wwwwwwwwwwwwwwwwwwwwwwwwww != this.Wwwwwwwwwwwwwwwwwwwwwwwww) {
                    long position2 = abstractC2212i7.getPosition();
                    if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7, this.Wwwwwwwwwwwwwwwwwwwwwwwww)) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == position2) {
                            throw new IOException("No ogg page can be found.");
                        }
                    } else {
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7, false);
                        abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        long j3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
                        C2816y9 c2816y9 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        long j4 = j3 - c2816y9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        int i2 = c2816y9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww + c2816y9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        if (0 > j4 || j4 >= 72000) {
                            int i3 = (j4 > 0L ? 1 : (j4 == 0L ? 0 : -1));
                            if (i3 < 0) {
                                this.Wwwwwwwwwwwwwwwwwwwwwwwww = position2;
                                this.Wwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            } else {
                                this.Wwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2212i7.getPosition() + i2;
                                this.Wwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            }
                            long j5 = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
                            long j6 = this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
                            if (j5 - j6 < 100000) {
                                this.Wwwwwwwwwwwwwwwwwwwwwwwww = j6;
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = j6;
                            } else {
                                long position3 = abstractC2212i7.getPosition() - (i2 * (i3 <= 0 ? 2L : 1L));
                                long j7 = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
                                long j8 = this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((((j7 - j8) * j4) / (this.Wwwwwwwwwwwwwwwwwwwwwww - this.Wwwwwwwwwwwwwwwwwwwwwwww)) + position3, j8, j7 - 1);
                            }
                        }
                    }
                    j = -1;
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == -1) {
                        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                    }
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 3;
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = -1;
                j = -1;
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == -1) {
                }
            } else if (i != 3) {
                if (i != 4) {
                    throw new IllegalStateException();
                }
                return -1L;
            } else {
                j = -1;
            }
            while (true) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7, j);
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7, false);
                C2816y9 c2816y92 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (c2816y92.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww > this.Wwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 4;
                    return -(this.Wwwwwwwwwwwwwwwwwwwwwwww + 2);
                }
                abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2816y92.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww + c2816y92.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                this.Wwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2212i7.getPosition();
                this.Wwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                j = -1;
            }
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7, -1L)) {
            do {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7, false);
                C2816y9 c2816y93 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2816y93.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww + c2816y93.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                C2816y9 c2816y94 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if ((c2816y94.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww & 4) == 4 || !c2816y94.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7, -1L)) {
                    break;
                }
            } while (abstractC2212i7.getPosition() < this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 4;
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        throw new EOFException();
    }
}
