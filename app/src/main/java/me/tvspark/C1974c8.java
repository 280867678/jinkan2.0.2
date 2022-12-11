package me.tvspark;

import com.google.android.exoplayer2.ParserException;
import com.just.agentweb.WebIndicator;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import me.tvspark.AbstractC2625t7;
import me.tvspark.C2245j3;
import org.apache.commons.lang3.time.StopWatch;
import org.fourthline.cling.support.model.dlna.DLNAProfiles;

/* renamed from: me.tvspark.c8 */
/* loaded from: classes4.dex */
public final class C1974c8 implements AbstractC2175h7 {
    public boolean Wwwwwwwwwwwwwwwwwwww;
    public AbstractC2625t7 Wwwwwwwwwwwwwwwwwwwww;
    public AbstractC2740w7 Wwwwwwwwwwwwwwwwwwwwww;
    public AbstractC2249j7 Wwwwwwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static final int[] Wwwwwwwwwwwwwwwwwww = {13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};
    public static final int[] Wwwwwwwwwwwwwwwwww = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};
    public static final byte[] Wwwwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("#!AMR\n");
    public static final byte[] Wwwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("#!AMR-WB\n");
    public static final int Wwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwww[8];

    static {
        C1937b8 c1937b8 = C1937b8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public C1974c8() {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new byte[1];
        this.Wwwwwwwwwwwwwwwwwwwwwwwwww = -1;
    }

    public C1974c8(int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new byte[1];
        this.Wwwwwwwwwwwwwwwwwwwwwwwwww = -1;
    }

    public static /* synthetic */ AbstractC2175h7[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return new AbstractC2175h7[]{new C1974c8()};
    }

    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2212i7 abstractC2212i7) throws IOException {
        int length;
        byte[] bArr = Wwwwwwwwwwwwwwwww;
        abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        byte[] bArr2 = new byte[bArr.length];
        abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr2, 0, bArr.length);
        if (Arrays.equals(bArr2, bArr)) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
            length = Wwwwwwwwwwwwwwwww.length;
        } else {
            byte[] bArr3 = Wwwwwwwwwwwwwwww;
            abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            byte[] bArr4 = new byte[bArr3.length];
            abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr4, 0, bArr3.length);
            if (!Arrays.equals(bArr4, bArr3)) {
                return false;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
            length = Wwwwwwwwwwwwwwww.length;
        }
        abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(length);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x003b, code lost:
        if ((!r4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && (r5 < 12 || r5 > 14)) != false) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2212i7 abstractC2212i7) throws IOException {
        abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        boolean z = true;
        abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, 1);
        byte b = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[0];
        if ((b & 131) <= 0) {
            int i = (b >> 3) & 15;
            if (i >= 0 && i <= 15) {
                if (!(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && (i < 10 || i > 13))) {
                }
                if (!z) {
                    return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww ? Wwwwwwwwwwwwwwwwww[i] : Wwwwwwwwwwwwwwwwwww[i];
                }
                String str = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww ? "WB" : "NB";
                StringBuilder sb = new StringBuilder(str.length() + 35);
                sb.append("Illegal AMR ");
                sb.append(str);
                sb.append(" frame type ");
                sb.append(i);
                throw new ParserException(sb.toString());
            }
            z = false;
            if (!z) {
            }
        } else {
            throw new ParserException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(42, "Invalid padding bits for frame header ", b));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00b7  */
    @Override // me.tvspark.AbstractC2175h7
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2212i7 abstractC2212i7, C2588s7 c2588s7) throws IOException {
        int i;
        int i2;
        int i3;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwww);
        C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww);
        if (abstractC2212i7.getPosition() != 0 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7)) {
            if (!this.Wwwwwwwwwwwwwwwwwwww) {
                this.Wwwwwwwwwwwwwwwwwwww = true;
                String str = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww ? "audio/amr-wb" : DLNAProfiles.DLNAMimeTypes.MIME_AUDIO_3GP;
                int i4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww ? 16000 : WebIndicator.MAX_UNIFORM_SPEED_DURATION;
                AbstractC2740w7 abstractC2740w7 = this.Wwwwwwwwwwwwwwwwwwwwww;
                C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww = str;
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwww;
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwww = 1;
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwww = i4;
                abstractC2740w7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            }
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww == 0) {
                try {
                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7);
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (this.Wwwwwwwwwwwwwwwwwwwwwwwwww == -1) {
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2212i7.getPosition();
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    }
                    if (this.Wwwwwwwwwwwwwwwwwwwwwwwwww == this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                        this.Wwwwwwwwwwwwwwwwwwwwwwwww++;
                    }
                } catch (EOFException unused) {
                }
            }
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2752wj) abstractC2212i7, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, true);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != -1) {
                int i5 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww - Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = i5;
                i = 0;
                if (i5 <= 0) {
                    this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 1, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, null);
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += 20000;
                }
                long length = abstractC2212i7.getLength();
                if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    if ((this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww & 1) == 0 || length == -1 || !((i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwww) == -1 || i2 == this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                        AbstractC2625t7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = new AbstractC2625t7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(-9223372036854775807L, 0L);
                        this.Wwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                        this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                    } else if (this.Wwwwwwwwwwwwwwwwwwwwwwwww >= 20 || i == -1) {
                        C2010d7 c2010d7 = new C2010d7(length, this.Wwwwwwwwwwwwwwwwwwwwwwwwwww, (int) (((i3 * 8) * StopWatch.NANO_2_MILLIS) / 20000), this.Wwwwwwwwwwwwwwwwwwwwwwwwww);
                        this.Wwwwwwwwwwwwwwwwwwwww = c2010d7;
                        this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2010d7);
                    }
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
                }
                return i;
            }
            i = -1;
            long length2 = abstractC2212i7.getLength();
            if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            }
            return i;
        }
        throw new ParserException("Could not find AMR header.");
    }

    @Override // me.tvspark.AbstractC2175h7
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2249j7 abstractC2249j7) {
        this.Wwwwwwwwwwwwwwwwwwwwwww = abstractC2249j7;
        this.Wwwwwwwwwwwwwwwwwwwwww = abstractC2249j7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, 1);
        abstractC2249j7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.AbstractC2175h7
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2212i7 abstractC2212i7) throws IOException {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7);
    }

    @Override // me.tvspark.AbstractC2175h7
    public void release() {
    }

    @Override // me.tvspark.AbstractC2175h7
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, long j2) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0L;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        if (j != 0) {
            AbstractC2625t7 abstractC2625t7 = this.Wwwwwwwwwwwwwwwwwwwww;
            if (abstractC2625t7 instanceof C2010d7) {
                C2010d7 c2010d7 = (C2010d7) abstractC2625t7;
                this.Wwwwwwwwwwwwwwwwwwwwwwww = C2010d7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, c2010d7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2010d7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                return;
            }
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwww = 0L;
    }
}
