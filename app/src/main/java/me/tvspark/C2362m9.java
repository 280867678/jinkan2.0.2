package me.tvspark;

import android.support.p000v4.media.session.PlaybackStateCompat;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import me.tvspark.AbstractC2140g9;
import me.tvspark.AbstractC2625t7;
import me.tvspark.C2245j3;
import me.tvspark.C2254jc;

/* renamed from: me.tvspark.m9 */
/* loaded from: classes4.dex */
public final class C2362m9 implements AbstractC2175h7, AbstractC2625t7 {
    public boolean Wwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwww;
    public long[][] Wwwwwwwwwwwwwwwww;
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[] Wwwwwwwwwwwwwwwwww;
    public AbstractC2249j7 Wwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public C2078el Wwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final C2078el Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2078el(16);
    public final ArrayDeque<AbstractC2140g9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayDeque<>();
    public final C2078el Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2078el(C1987cl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    public final C2078el Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2078el(4);
    public final C2078el Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2078el();
    public int Wwwwwwwwwwwwwwwwwwwwwww = -1;

    /* renamed from: me.tvspark.m9$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final AbstractC2740w7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final C2590s9 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final C2473p9 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2473p9 c2473p9, C2590s9 c2590s9, AbstractC2740w7 abstractC2740w7) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2473p9;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2590s9;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2740w7;
        }
    }

    static {
        C2066e9 c2066e9 = C2066e9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public C2362m9(int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
    }

    public static /* synthetic */ AbstractC2175h7[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return new AbstractC2175h7[]{new C2362m9(0)};
    }

    public static long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2590s9 c2590s9, long j, long j2) {
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2590s9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == -1) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2590s9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j);
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == -1 ? j2 : Math.min(c2590s9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2], j2);
    }

    public static /* synthetic */ C2473p9 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2473p9 c2473p9) {
        return c2473p9;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        this.Wwwwwwwwwwwwwwwwwwwwwwwww = 0;
    }

    @Override // me.tvspark.AbstractC2625t7
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwww;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) throws ParserException {
        C2254jc c2254jc;
        long j2;
        ArrayList arrayList;
        int i;
        int i2;
        C2362m9 c2362m9 = this;
        while (!c2362m9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.isEmpty() && c2362m9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.peek().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == j) {
            AbstractC2140g9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww pop = c2362m9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.pop();
            if (pop.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 1836019574) {
                ArrayList arrayList2 = new ArrayList();
                C2471p7 c2471p7 = new C2471p7();
                AbstractC2140g9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = pop.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1969517665);
                C2254jc c2254jc2 = null;
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                    C2254jc Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2177h9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2362m9.Wwwwwwwwwwwwww);
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null) {
                        c2471p7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                    }
                    c2254jc = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                } else {
                    c2254jc = null;
                }
                AbstractC2140g9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = pop.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1835365473);
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                    c2254jc2 = C2177h9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                }
                C2254jc c2254jc3 = c2254jc2;
                List<C2590s9> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = C2177h9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(pop, c2471p7, -9223372036854775807L, null, (c2362m9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww & 1) != 0, c2362m9.Wwwwwwwwwwwwww, C2012d9.Wwwwwwwwwwwwwwwwwwwwwwww);
                AbstractC2249j7 abstractC2249j7 = c2362m9.Wwwwwwwwwwwwwwwwwww;
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2249j7);
                ArrayList arrayList3 = (ArrayList) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
                int size = arrayList3.size();
                long j3 = -9223372036854775807L;
                long j4 = -9223372036854775807L;
                int i3 = 0;
                int i4 = -1;
                while (true) {
                    j2 = 0;
                    if (i3 >= size) {
                        break;
                    }
                    C2590s9 c2590s9 = (C2590s9) arrayList3.get(i3);
                    if (c2590s9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 0) {
                        arrayList = arrayList3;
                        i = size;
                    } else {
                        C2473p9 c2473p9 = c2590s9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        arrayList = arrayList3;
                        long j5 = c2473p9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        if (j5 == j3) {
                            j5 = c2590s9.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
                        }
                        long max = Math.max(j4, j5);
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2473p9, c2590s9, abstractC2249j7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3, c2473p9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
                        i = size;
                        C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2473p9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwww = c2590s9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 30;
                        if (c2473p9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 2 && j5 > 0 && (i2 = c2590s9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) > 1) {
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwww = i2 / (((float) j5) / 1000000.0f);
                        }
                        int i5 = c2473p9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        if (i5 == 1) {
                            if ((c2471p7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -1 || c2471p7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -1) ? false : true) {
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwww = c2471p7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwww = c2471p7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            }
                            if (c2254jc != null) {
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwww = c2254jc;
                            }
                        } else if (i5 == 2 && c2254jc3 != null) {
                            int i6 = 0;
                            while (true) {
                                C2254jc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[] wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr = c2254jc3.Wwwwwwwwwwwwwwwwwwwwwwww;
                                if (i6 >= wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr.length) {
                                    break;
                                }
                                C2254jc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr[i6];
                                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww instanceof C2288k9) {
                                    C2288k9 c2288k9 = (C2288k9) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                    if ("com.android.capture.fps".equals(c2288k9.Wwwwwwwwwwwwwwwwwwwwwwww)) {
                                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwww = new C2254jc(c2288k9);
                                    }
                                }
                                i6++;
                            }
                        }
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                        if (c2473p9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 2 && i4 == -1) {
                            i4 = arrayList2.size();
                        }
                        arrayList2.add(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        j4 = max;
                    }
                    i3++;
                    c2362m9 = this;
                    arrayList3 = arrayList;
                    size = i;
                    j3 = -9223372036854775807L;
                }
                c2362m9.Wwwwwwwwwwwwwwww = i4;
                c2362m9.Wwwwwwwwwwwwwww = j4;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[] wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[]) arrayList2.toArray(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[0]);
                c2362m9.Wwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr;
                long[][] jArr = new long[wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr.length];
                int[] iArr = new int[wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr.length];
                long[] jArr2 = new long[wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr.length];
                boolean[] zArr = new boolean[wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr.length];
                for (int i7 = 0; i7 < wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr.length; i7++) {
                    jArr[i7] = new long[wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr[i7].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww];
                    jArr2[i7] = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr[i7].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww[0];
                }
                int i8 = 0;
                while (i8 < wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr.length) {
                    long j6 = Long.MAX_VALUE;
                    int i9 = -1;
                    for (int i10 = 0; i10 < wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr.length; i10++) {
                        if (!zArr[i10] && jArr2[i10] <= j6) {
                            j6 = jArr2[i10];
                            i9 = i10;
                        }
                    }
                    int i11 = iArr[i9];
                    jArr[i9][i11] = j2;
                    j2 += wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr[i9].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i11];
                    int i12 = i11 + 1;
                    iArr[i9] = i12;
                    if (i12 < jArr[i9].length) {
                        jArr2[i9] = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr[i9].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww[i12];
                    } else {
                        zArr[i9] = true;
                        i8++;
                    }
                }
                c2362m9.Wwwwwwwwwwwwwwwww = jArr;
                abstractC2249j7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                abstractC2249j7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2362m9);
                c2362m9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
                c2362m9.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = 2;
            } else if (!c2362m9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.isEmpty()) {
                c2362m9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.peek().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(pop);
            }
        }
        if (c2362m9.Wwwwwwwwwwwwwwwwwwwwwwwwwwww != 2) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    @Override // me.tvspark.AbstractC2625t7
    public AbstractC2625t7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        long j2;
        long j3;
        long j4;
        long j5;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        long j6 = j;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[] wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr = this.Wwwwwwwwwwwwwwwwww;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr);
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr.length == 0) {
            return new AbstractC2625t7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2662u7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        long j7 = -1;
        int i = this.Wwwwwwwwwwwwwwww;
        if (i != -1) {
            C2590s9 c2590s9 = this.Wwwwwwwwwwwwwwwwww[i].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2590s9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j6);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == -1) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2590s9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j6);
            }
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == -1) {
                return new AbstractC2625t7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2662u7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            long j8 = c2590s9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2];
            j2 = c2590s9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2];
            if (j8 >= j6 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 >= c2590s9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - 1 || (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2590s9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j6)) == -1 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) {
                j5 = -9223372036854775807L;
            } else {
                long j9 = c2590s9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww];
                long j10 = c2590s9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww];
                j5 = j9;
                j7 = j10;
            }
            j3 = j7;
            j4 = j5;
            j6 = j8;
        } else {
            j2 = Long.MAX_VALUE;
            j3 = -1;
            j4 = -9223372036854775807L;
        }
        int i2 = 0;
        while (true) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[] wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr2 = this.Wwwwwwwwwwwwwwwwww;
            if (i2 >= wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr2.length) {
                break;
            }
            if (i2 != this.Wwwwwwwwwwwwwwww) {
                C2590s9 c2590s92 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr2[i2].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2590s92, j6, j2);
                if (j4 != -9223372036854775807L) {
                    j3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2590s92, j4, j3);
                }
                j2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
            }
            i2++;
        }
        C2662u7 c2662u7 = new C2662u7(j6, j2);
        return j4 == -9223372036854775807L ? new AbstractC2625t7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2662u7) : new AbstractC2625t7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2662u7, new C2662u7(j4, j3));
    }

    @Override // me.tvspark.AbstractC2625t7
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return true;
    }

    @Override // me.tvspark.AbstractC2175h7
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2249j7 abstractC2249j7) {
        this.Wwwwwwwwwwwwwwwwwww = abstractC2249j7;
    }

    @Override // me.tvspark.AbstractC2175h7
    public void release() {
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x03b2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:11:0x03b1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0226 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0006 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0006 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x029e  */
    @Override // me.tvspark.AbstractC2175h7
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2212i7 abstractC2212i7, C2588s7 c2588s7) throws IOException {
        boolean z;
        boolean z2;
        long position;
        AbstractC2140g9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww peek;
        C2078el c2078el;
        boolean z3;
        while (true) {
            int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i == 0) {
                if (this.Wwwwwwwwwwwwwwwwwwwwwwwww == 0) {
                    z3 = false;
                    if (abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, 8, true)) {
                        this.Wwwwwwwwwwwwwwwwwwwwwwwww = 8;
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww();
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    }
                    if (z3) {
                        return -1;
                    }
                }
                long j = this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
                if (j == 1) {
                    abstractC2212i7.readFully(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 8, 8);
                    this.Wwwwwwwwwwwwwwwwwwwwwwwww += 8;
                    position = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww();
                } else {
                    if (j == 0) {
                        long length = abstractC2212i7.getLength();
                        if (length == -1 && (peek = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.peek()) != null) {
                            length = peek.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        }
                        if (length != -1) {
                            position = (length - abstractC2212i7.getPosition()) + this.Wwwwwwwwwwwwwwwwwwwwwwwww;
                        }
                    }
                    if (this.Wwwwwwwwwwwwwwwwwwwwwwwwww >= this.Wwwwwwwwwwwwwwwwwwwwwwwww) {
                        throw new ParserException("Atom size less than header length (unsupported).");
                    }
                    int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (i2 == 1836019574 || i2 == 1953653099 || i2 == 1835297121 || i2 == 1835626086 || i2 == 1937007212 || i2 == 1701082227 || i2 == 1835365473) {
                        long position2 = abstractC2212i7.getPosition();
                        long j2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
                        long j3 = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
                        long j4 = (position2 + j2) - j3;
                        if (j2 != j3 && this.Wwwwwwwwwwwwwwwwwwwwwwwwwww == 1835365473) {
                            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(8);
                            abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, 8);
                            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
                            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == 1751411826) {
                                abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                            } else {
                                abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
                            }
                        }
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.push(new AbstractC2140g9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwww, j4));
                        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwww == this.Wwwwwwwwwwwwwwwwwwwwwwwww) {
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j4);
                        } else {
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        }
                    } else {
                        int i3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
                        if (i3 == 1835296868 || i3 == 1836476516 || i3 == 1751411826 || i3 == 1937011556 || i3 == 1937011827 || i3 == 1937011571 || i3 == 1668576371 || i3 == 1701606260 || i3 == 1937011555 || i3 == 1937011578 || i3 == 1937013298 || i3 == 1937007471 || i3 == 1668232756 || i3 == 1953196132 || i3 == 1718909296 || i3 == 1969517665 || i3 == 1801812339 || i3 == 1768715124) {
                            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwww == 8);
                            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwww <= 2147483647L);
                            c2078el = new C2078el((int) this.Wwwwwwwwwwwwwwwwwwwwwwwwww);
                            System.arraycopy(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, 8);
                        } else {
                            c2078el = null;
                        }
                        this.Wwwwwwwwwwwwwwwwwwwwwwww = c2078el;
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = 1;
                    }
                    z3 = true;
                    if (z3) {
                    }
                }
                this.Wwwwwwwwwwwwwwwwwwwwwwwwww = position;
                if (this.Wwwwwwwwwwwwwwwwwwwwwwwwww >= this.Wwwwwwwwwwwwwwwwwwwwwwwww) {
                }
            } else if (i != 1) {
                if (i == 2) {
                    long position3 = abstractC2212i7.getPosition();
                    if (this.Wwwwwwwwwwwwwwwwwwwwwww == -1) {
                        long j5 = Long.MAX_VALUE;
                        long j6 = Long.MAX_VALUE;
                        long j7 = Long.MAX_VALUE;
                        int i4 = 0;
                        boolean z4 = true;
                        boolean z5 = true;
                        int i5 = -1;
                        int i6 = -1;
                        while (true) {
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[] wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr = this.Wwwwwwwwwwwwwwwwww;
                            C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr);
                            if (i4 >= wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr.length) {
                                break;
                            }
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwww[i4];
                            int i7 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            C2590s9 c2590s9 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            if (i7 != c2590s9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                                long j8 = c2590s9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i7];
                                long j9 = this.Wwwwwwwwwwwwwwwww[i4][i7];
                                long j10 = j8 - position3;
                                boolean z6 = j10 < 0 || j10 >= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
                                if ((!z6 && z4) || (z6 == z4 && j10 < j7)) {
                                    i6 = i4;
                                    j6 = j9;
                                    z4 = z6;
                                    j7 = j10;
                                }
                                if (j9 < j5) {
                                    i5 = i4;
                                    j5 = j9;
                                    z5 = z6;
                                }
                            }
                            i4++;
                        }
                        int i8 = (j5 == Long.MAX_VALUE || !z5 || j6 < j5 + 10485760) ? i6 : i5;
                        this.Wwwwwwwwwwwwwwwwwwwwwww = i8;
                        if (i8 == -1) {
                            return -1;
                        }
                    }
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[] wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr2 = this.Wwwwwwwwwwwwwwwwww;
                    C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr2);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr2[this.Wwwwwwwwwwwwwwwwwwwwwww];
                    AbstractC2740w7 abstractC2740w7 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    int i9 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    C2590s9 c2590s92 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    long j11 = c2590s92.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i9];
                    int i10 = c2590s92.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i9];
                    long j12 = (j11 - position3) + this.Wwwwwwwwwwwwwwwwwwwwww;
                    if (j12 < 0 || j12 >= PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
                        c2588s7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j11;
                        return 1;
                    }
                    if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww == 1) {
                        j12 += 8;
                        i10 -= 8;
                    }
                    abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) j12);
                    C2473p9 c2473p9 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    int i11 = c2473p9.Wwwwwwwwwwwwwwwwwwwwwwwww;
                    if (i11 == 0) {
                        if ("audio/ac4".equals(c2473p9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwww)) {
                            if (this.Wwwwwwwwwwwwwwwwwwwww == 0) {
                                C2811y4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i10, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                                abstractC2740w7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 7);
                                this.Wwwwwwwwwwwwwwwwwwwww += 7;
                            }
                            i10 += 7;
                        }
                        while (true) {
                            int i12 = this.Wwwwwwwwwwwwwwwwwwwww;
                            if (i12 >= i10) {
                                break;
                            }
                            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = abstractC2740w7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2752wj) abstractC2212i7, i10 - i12, false);
                            this.Wwwwwwwwwwwwwwwwwwwwww += Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                            this.Wwwwwwwwwwwwwwwwwwwww += Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                            this.Wwwwwwwwwwwwwwwwwwww -= Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                        }
                    } else {
                        byte[] bArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        bArr[0] = 0;
                        bArr[1] = 0;
                        bArr[2] = 0;
                        int i13 = 4 - i11;
                        while (this.Wwwwwwwwwwwwwwwwwwwww < i10) {
                            int i14 = this.Wwwwwwwwwwwwwwwwwwww;
                            if (i14 == 0) {
                                abstractC2212i7.readFully(bArr, i13, i11);
                                this.Wwwwwwwwwwwwwwwwwwwwww += i11;
                                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
                                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < 0) {
                                    throw new ParserException("Invalid NAL length");
                                }
                                this.Wwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
                                abstractC2740w7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 4);
                                this.Wwwwwwwwwwwwwwwwwwwww += 4;
                                i10 += i13;
                            } else {
                                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = abstractC2740w7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2752wj) abstractC2212i7, i14, false);
                                this.Wwwwwwwwwwwwwwwwwwwwww += Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
                                this.Wwwwwwwwwwwwwwwwwwwww += Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
                                this.Wwwwwwwwwwwwwwwwwwww -= Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
                            }
                        }
                    }
                    C2590s9 c2590s93 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    abstractC2740w7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2590s93.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww[i9], c2590s93.Wwwwwwwwwwwwwwwwwwwwwwwwwwww[i9], i10, 0, null);
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww++;
                    this.Wwwwwwwwwwwwwwwwwwwwwww = -1;
                    this.Wwwwwwwwwwwwwwwwwwwwww = 0;
                    this.Wwwwwwwwwwwwwwwwwwwww = 0;
                    this.Wwwwwwwwwwwwwwwwwwww = 0;
                    return 0;
                }
                throw new IllegalStateException();
            } else {
                long j13 = this.Wwwwwwwwwwwwwwwwwwwwwwwwww - this.Wwwwwwwwwwwwwwwwwwwwwwwww;
                long position4 = abstractC2212i7.getPosition() + j13;
                C2078el c2078el2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                if (c2078el2 != null) {
                    abstractC2212i7.readFully(c2078el2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwww, (int) j13);
                    if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwww == 1718909296) {
                        c2078el2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(8);
                        if (c2078el2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == 1903435808) {
                            z2 = true;
                            break;
                        }
                        c2078el2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
                        while (c2078el2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() > 0) {
                            if (c2078el2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == 1903435808) {
                                z2 = true;
                                break;
                            }
                        }
                        z2 = false;
                        this.Wwwwwwwwwwwwww = z2;
                    } else if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.isEmpty()) {
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.peek().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(new AbstractC2140g9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwww, c2078el2));
                    }
                } else if (j13 < PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
                    abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) j13);
                } else {
                    c2588s7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2212i7.getPosition() + j13;
                    z = true;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(position4);
                    if (!(!z && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww != 2)) {
                        return 1;
                    }
                }
                z = false;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(position4);
                if (!(!z && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww != 2)) {
                }
            }
        }
    }

    @Override // me.tvspark.AbstractC2175h7
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, long j2) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
        this.Wwwwwwwwwwwwwwwwwwwwwwwww = 0;
        this.Wwwwwwwwwwwwwwwwwwwwwww = -1;
        this.Wwwwwwwwwwwwwwwwwwwwww = 0;
        this.Wwwwwwwwwwwwwwwwwwwww = 0;
        this.Wwwwwwwwwwwwwwwwwwww = 0;
        if (j == 0) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            return;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[] wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr = this.Wwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr == null) {
            return;
        }
        for (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr) {
            C2590s9 c2590s9 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2590s9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j2);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == -1) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2590s9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j2);
            }
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        }
    }

    @Override // me.tvspark.AbstractC2175h7
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2212i7 abstractC2212i7) throws IOException {
        return C2436o9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7, false);
    }
}
