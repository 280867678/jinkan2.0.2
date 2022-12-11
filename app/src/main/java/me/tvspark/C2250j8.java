package me.tvspark;

import com.google.android.exoplayer2.extractor.flv.TagPayloadReader;
import java.io.IOException;
import me.tvspark.AbstractC2625t7;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* renamed from: me.tvspark.j8 */
/* loaded from: classes4.dex */
public final class C2250j8 implements AbstractC2175h7 {
    public C2324l8 Wwwwwwwwwwwwwwwwwww;
    public C2213i8 Wwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public AbstractC2249j7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final C2078el Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2078el(4);
    public final C2078el Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2078el(9);
    public final C2078el Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2078el(11);
    public final C2078el Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2078el();
    public final C2287k8 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2287k8();
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwww = 1;

    static {
        C2176h8 c2176h8 = C2176h8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public static /* synthetic */ AbstractC2175h7[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return new AbstractC2175h7[]{new C2250j8()};
    }

    public final C2078el Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2212i7 abstractC2212i7) throws IOException {
        int i = this.Wwwwwwwwwwwwwwwwwwwwwww;
        C2078el c2078el = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        byte[] bArr = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i > bArr.length) {
            c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new byte[Math.max(bArr.length * 2, i)];
            c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
            c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        } else {
            c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww);
        abstractC2212i7.readFully(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, this.Wwwwwwwwwwwwwwwwwwwwwww);
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @RequiresNonNull({"extractorOutput"})
    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (!this.Wwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new AbstractC2625t7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(-9223372036854775807L, 0L));
            this.Wwwwwwwwwwwwwwwwwwwww = true;
        }
    }

    @Override // me.tvspark.AbstractC2175h7
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, long j2) {
        if (j == 0) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = 1;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = false;
        } else {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = 3;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwww = 0;
    }

    @Override // me.tvspark.AbstractC2175h7
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2249j7 abstractC2249j7) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2249j7;
    }

    @Override // me.tvspark.AbstractC2175h7
    public void release() {
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x0096 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0009 A[SYNTHETIC] */
    @Override // me.tvspark.AbstractC2175h7
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2212i7 abstractC2212i7, C2588s7 c2588s7) throws IOException {
        long j;
        boolean z;
        boolean z2;
        TagPayloadReader tagPayloadReader;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        while (true) {
            int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
            boolean z3 = false;
            if (i == 1) {
                if (abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, 9, true)) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
                    int Wwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww();
                    boolean z4 = (Wwwwwwwwwwwwwwwwwwwwww & 4) != 0;
                    if ((Wwwwwwwwwwwwwwwwwwwwww & 1) != 0) {
                        z3 = true;
                    }
                    if (z4 && this.Wwwwwwwwwwwwwwwwwwww == null) {
                        this.Wwwwwwwwwwwwwwwwwwww = new C2213i8(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(8, 1));
                    }
                    if (z3 && this.Wwwwwwwwwwwwwwwwwww == null) {
                        this.Wwwwwwwwwwwwwwwwwww = new C2324l8(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(9, 2));
                    }
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    this.Wwwwwwwwwwwwwwwwwwwwwwwww = (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() - 9) + 4;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = 2;
                    z3 = true;
                }
                if (!z3) {
                    return -1;
                }
            } else if (i == 2) {
                abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwww);
                this.Wwwwwwwwwwwwwwwwwwwwwwwww = 0;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = 3;
            } else if (i == 3) {
                if (abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, 11, true)) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
                    this.Wwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww();
                    this.Wwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww();
                    this.Wwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww();
                    this.Wwwwwwwwwwwwwwwwwwwwww = ((this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww() << 24) | this.Wwwwwwwwwwwwwwwwwwwwww) * 1000;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(3);
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = 4;
                    z3 = true;
                }
                if (!z3) {
                    return -1;
                }
            } else if (i == 4) {
                if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    j = this.Wwwwwwwwwwwwwwwwwwwwwwwwww + this.Wwwwwwwwwwwwwwwwwwwwww;
                } else {
                    j = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -9223372036854775807L ? 0L : this.Wwwwwwwwwwwwwwwwwwwwww;
                }
                if (this.Wwwwwwwwwwwwwwwwwwwwwwww == 8 && this.Wwwwwwwwwwwwwwwwwwww != null) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    tagPayloadReader = this.Wwwwwwwwwwwwwwwwwwww;
                } else if (this.Wwwwwwwwwwwwwwwwwwwwwwww == 9 && this.Wwwwwwwwwwwwwwwwwww != null) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    tagPayloadReader = this.Wwwwwwwwwwwwwwwwwww;
                } else if (this.Wwwwwwwwwwwwwwwwwwwwwwww != 18 || this.Wwwwwwwwwwwwwwwwwwwww) {
                    abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww);
                    z = false;
                    z2 = false;
                    if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwww && z) {
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = true;
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != -9223372036854775807L ? -this.Wwwwwwwwwwwwwwwwwwwwww : 0L;
                    }
                    this.Wwwwwwwwwwwwwwwwwwwwwwwww = 4;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = 2;
                    if (z2) {
                        return 0;
                    }
                } else {
                    z = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7), j);
                    C2287k8 c2287k8 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    long j2 = c2287k8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (j2 != -9223372036854775807L) {
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new C2551r7(c2287k8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2287k8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, j2));
                        this.Wwwwwwwwwwwwwwwwwwwww = true;
                    }
                    z2 = true;
                    if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwww) {
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = true;
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != -9223372036854775807L ? -this.Wwwwwwwwwwwwwwwwwwwwww : 0L;
                    }
                    this.Wwwwwwwwwwwwwwwwwwwwwwwww = 4;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = 2;
                    if (z2) {
                    }
                }
                z = tagPayloadReader.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7), j);
                z2 = true;
                if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwww) {
                }
                this.Wwwwwwwwwwwwwwwwwwwwwwwww = 4;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = 2;
                if (z2) {
                }
            } else {
                throw new IllegalStateException();
            }
        }
    }

    @Override // me.tvspark.AbstractC2175h7
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2212i7 abstractC2212i7) throws IOException {
        abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, 3);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww() != 4607062) {
            return false;
        }
        abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, 2);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
        if ((this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwww() & 250) != 0) {
            return false;
        }
        abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, 4);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, 4);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == 0;
    }
}
