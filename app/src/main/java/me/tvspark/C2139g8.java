package me.tvspark;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import me.tvspark.AbstractC2625t7;
import me.tvspark.C2360m7;
import org.apache.commons.lang3.time.StopWatch;

/* renamed from: me.tvspark.g8 */
/* loaded from: classes4.dex */
public final class C2139g8 implements AbstractC2175h7 {
    public long Wwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwww;
    public C2102f8 Wwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwww;
    public C2434o7 Wwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public C2254jc Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public AbstractC2740w7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public AbstractC2249j7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final C2360m7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new byte[42];
    public final C2078el Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2078el(new byte[32768], 0);

    static {
        C2011d8 c2011d8 = C2011d8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public C2139g8(int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (i & 1) == 0 ? false : true;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2360m7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
    }

    public static /* synthetic */ AbstractC2175h7[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return new AbstractC2175h7[]{new C2139g8(0)};
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v9, types: [int, boolean] */
    @Override // me.tvspark.AbstractC2175h7
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2212i7 abstractC2212i7, C2588s7 c2588s7) throws IOException {
        byte[] bArr;
        boolean z;
        C2434o7 c2434o7;
        AbstractC2625t7 wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        long j;
        boolean z2;
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        boolean z3 = true;
        ?? r4 = 0;
        if (i == 0) {
            abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            C2254jc Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7, !this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) (abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() - Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = 1;
            return 0;
        } else if (i == 1) {
            byte[] bArr2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr2, 0, bArr2.length);
            abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = 2;
            return 0;
        } else {
            int i2 = 24;
            int i3 = 4;
            int i4 = 3;
            if (i == 2) {
                abstractC2212i7.readFully(new byte[4], 0, 4);
                if ((((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) == 1716281667) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = 3;
                    return 0;
                }
                throw new ParserException("Failed to read FLAC stream marker.");
            }
            int i5 = 7;
            if (i == 3) {
                C2434o7 c2434o72 = this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
                boolean z4 = false;
                while (!z4) {
                    abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    C2041dl c2041dl = new C2041dl(new byte[i3]);
                    byte[] bArr3 = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    int i6 = r4 == true ? 1 : 0;
                    int i7 = r4 == true ? 1 : 0;
                    abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr3, i6, i3);
                    boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i5);
                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2) + i3;
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 == 0) {
                        byte[] bArr4 = new byte[38];
                        abstractC2212i7.readFully(bArr4, r4, 38);
                        c2434o72 = new C2434o7(bArr4, i3);
                    } else if (c2434o72 == null) {
                        throw new IllegalArgumentException();
                    } else {
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 == i4) {
                            C2078el c2078el = new C2078el(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4);
                            abstractC2212i7.readFully(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, r4, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4);
                            c2434o72 = c2434o72.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el));
                        } else {
                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 == i3) {
                                C2078el c2078el2 = new C2078el(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4);
                                abstractC2212i7.readFully(c2078el2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, r4, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4);
                                c2078el2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3);
                                c2434o7 = new C2434o7(c2434o72.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2434o72.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2434o72.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2434o72.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2434o72.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2434o72.Wwwwwwwwwwwwwwwwwwwwwwwwwwww, c2434o72.Wwwwwwwwwwwwwwwwwwwwwwwwwww, c2434o72.Wwwwwwwwwwwwwwwwwwwwwwwww, c2434o72.Wwwwwwwwwwwwwwwwwwwwwwww, c2434o72.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2434o7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Arrays.asList(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el2, (boolean) r4, (boolean) r4).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), Collections.emptyList())));
                                z = Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 == 6) {
                                C2078el c2078el3 = new C2078el(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4);
                                abstractC2212i7.readFully(c2078el3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, r4, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4);
                                c2078el3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
                                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2078el3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = c2078el3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), C2160gt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                                String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2078el3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2078el3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = c2078el3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = c2078el3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = c2078el3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = c2078el3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                byte[] bArr5 = new byte[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6];
                                System.arraycopy(c2078el3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2078el3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, bArr5, r4, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6);
                                c2078el3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6;
                                z = Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                c2434o7 = new C2434o7(c2434o72.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2434o72.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2434o72.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2434o72.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2434o72.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2434o72.Wwwwwwwwwwwwwwwwwwwwwwwwwwww, c2434o72.Wwwwwwwwwwwwwwwwwwwwwwwwwww, c2434o72.Wwwwwwwwwwwwwwwwwwwwwwwww, c2434o72.Wwwwwwwwwwwwwwwwwwwwwwww, c2434o72.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2434o7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Collections.emptyList(), Collections.singletonList(new C2745wc(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5, bArr5)))));
                            } else {
                                z = Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4);
                                C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2434o72);
                                this.Wwwwwwwwwwwwwwwwwwwwwwwwww = c2434o72;
                                z4 = z;
                                r4 = 0;
                                i2 = 24;
                                i3 = 4;
                                i4 = 3;
                                i5 = 7;
                            }
                            c2434o72 = c2434o7;
                            C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2434o72);
                            this.Wwwwwwwwwwwwwwwwwwwwwwwwww = c2434o72;
                            z4 = z;
                            r4 = 0;
                            i2 = 24;
                            i3 = 4;
                            i4 = 3;
                            i5 = 7;
                        }
                    }
                    z = Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2434o72);
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwww = c2434o72;
                    z4 = z;
                    r4 = 0;
                    i2 = 24;
                    i3 = 4;
                    i4 = 3;
                    i5 = 7;
                }
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwww);
                this.Wwwwwwwwwwwwwwwwwwwwwwwww = Math.max(this.Wwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 6);
                AbstractC2740w7 abstractC2740w7 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2740w7);
                abstractC2740w7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwww));
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = 4;
                return 0;
            }
            long j2 = 0;
            if (i == 4) {
                abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                byte[] bArr6 = new byte[2];
                abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr6, 0, 2);
                int i8 = (bArr6[1] & 255) | ((bArr6[0] & 255) << 8);
                int i9 = i8 >> 2;
                abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                if (i9 == 16382) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwww = i8;
                    AbstractC2249j7 abstractC2249j7 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2249j7);
                    long position = abstractC2212i7.getPosition();
                    long length = abstractC2212i7.getLength();
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwww);
                    C2434o7 c2434o73 = this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (c2434o73.Wwwwwwwwwwwwwwwwwwwwwwww != null) {
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2397n7(c2434o73, position);
                    } else if (length != -1 && c2434o73.Wwwwwwwwwwwwwwwwwwwwwwwww > 0) {
                        C2102f8 c2102f8 = new C2102f8(c2434o73, this.Wwwwwwwwwwwwwwwwwwwwwwww, position, length);
                        this.Wwwwwwwwwwwwwwwwwwwwwww = c2102f8;
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2102f8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    } else {
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new AbstractC2625t7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), 0L);
                    }
                    abstractC2249j7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = 5;
                    return 0;
                }
                throw new ParserException("First frame does not start with sync code.");
            } else if (i == 5) {
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwww);
                C2102f8 c2102f82 = this.Wwwwwwwwwwwwwwwwwwwwwww;
                if (c2102f82 != null && c2102f82.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                    return this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7, c2588s7);
                }
                if (this.Wwwwwwwwwwwwwwwwwwwww == -1) {
                    C2434o7 c2434o74 = this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
                    abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
                    byte[] bArr7 = new byte[1];
                    abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr7, 0, 1);
                    boolean z5 = (bArr7[0] & 1) == 1;
                    abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
                    if (!z5) {
                        i5 = 6;
                    }
                    C2078el c2078el4 = new C2078el(i5);
                    c2078el4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7, c2078el4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, i5));
                    abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    try {
                        long Wwwwwwwwwwwwwwww = c2078el4.Wwwwwwwwwwwwwwww();
                        if (!z5) {
                            Wwwwwwwwwwwwwwww *= c2434o74.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        }
                        j2 = Wwwwwwwwwwwwwwww;
                    } catch (NumberFormatException unused) {
                        z3 = false;
                    }
                    if (z3) {
                        this.Wwwwwwwwwwwwwwwwwwwww = j2;
                        return 0;
                    }
                    throw new ParserException();
                }
                C2078el c2078el5 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                int i10 = c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (i10 < 32768) {
                    int read = abstractC2212i7.read(c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i10, 32768 - i10);
                    if (read != -1) {
                        z3 = false;
                    }
                    if (!z3) {
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i10 + read);
                    } else if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == 0) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        return -1;
                    }
                } else {
                    z3 = false;
                }
                C2078el c2078el6 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                int i11 = c2078el6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                int i12 = this.Wwwwwwwwwwwwwwwwwwwwww;
                int i13 = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
                if (i12 < i13) {
                    c2078el6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(Math.min(i13 - i12, c2078el6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()));
                }
                C2078el c2078el7 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwww);
                int i14 = c2078el7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                while (true) {
                    if (i14 <= c2078el7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - 16) {
                        c2078el7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i14);
                        if (C2360m7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el7, this.Wwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                            break;
                        }
                        i14++;
                    } else {
                        if (z3) {
                            while (true) {
                                int i15 = c2078el7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                if (i14 > i15 - this.Wwwwwwwwwwwwwwwwwwwwwwwww) {
                                    c2078el7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i15);
                                    break;
                                }
                                c2078el7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i14);
                                try {
                                    z2 = C2360m7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el7, this.Wwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                                } catch (IndexOutOfBoundsException unused2) {
                                    z2 = false;
                                }
                                if (c2078el7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww > c2078el7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                                    z2 = false;
                                }
                                if (z2) {
                                    break;
                                }
                                i14++;
                            }
                        } else {
                            c2078el7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i14);
                        }
                        j = -1;
                    }
                }
                c2078el7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i14);
                j = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                C2078el c2078el8 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                int i16 = c2078el8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - i11;
                c2078el8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i11);
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i16);
                this.Wwwwwwwwwwwwwwwwwwwwww += i16;
                if (j != -1) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    this.Wwwwwwwwwwwwwwwwwwwwww = 0;
                    this.Wwwwwwwwwwwwwwwwwwwww = j;
                }
                if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() >= 16) {
                    return 0;
                }
                C2078el c2078el9 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                byte[] bArr8 = c2078el9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                System.arraycopy(bArr8, c2078el9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, bArr8, 0, c2078el9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                C2078el c2078el10 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                c2078el10.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el10.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                return 0;
            } else {
                throw new IllegalStateException();
            }
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        long j = this.Wwwwwwwwwwwwwwwwwwwww * StopWatch.NANO_2_MILLIS;
        C2434o7 c2434o7 = this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
        C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2434o7);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j / c2434o7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 1, this.Wwwwwwwwwwwwwwwwwwwwww, 0, null);
    }

    @Override // me.tvspark.AbstractC2175h7
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, long j2) {
        long j3 = 0;
        if (j == 0) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        } else {
            C2102f8 c2102f8 = this.Wwwwwwwwwwwwwwwwwwwwwww;
            if (c2102f8 != null) {
                c2102f8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j2);
            }
        }
        if (j2 != 0) {
            j3 = -1;
        }
        this.Wwwwwwwwwwwwwwwwwwwww = j3;
        this.Wwwwwwwwwwwwwwwwwwwwww = 0;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
    }

    @Override // me.tvspark.AbstractC2175h7
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2249j7 abstractC2249j7) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2249j7;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2249j7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, 1);
        abstractC2249j7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.AbstractC2175h7
    public void release() {
    }

    @Override // me.tvspark.AbstractC2175h7
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2212i7 abstractC2212i7) throws IOException {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7, false);
        byte[] bArr = new byte[4];
        abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, 0, 4);
        return (((((((long) bArr[0]) & 255) << 24) | ((((long) bArr[1]) & 255) << 16)) | ((((long) bArr[2]) & 255) << 8)) | (255 & ((long) bArr[3]))) == 1716281667;
    }
}
