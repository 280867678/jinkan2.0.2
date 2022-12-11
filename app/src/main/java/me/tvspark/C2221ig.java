package me.tvspark;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseIntArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.hls.FullSegmentEncryptionKeyCache;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.common.collect.ImmutableList;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import me.tvspark.AbstractC1944bf;
import me.tvspark.AbstractC2220if;
import me.tvspark.AbstractC2299kk;
import me.tvspark.AbstractC2396n6;
import me.tvspark.AbstractC2740w7;
import me.tvspark.C1908ag;
import me.tvspark.C2109ff;
import me.tvspark.C2146gf;
import me.tvspark.C2221ig;
import me.tvspark.C2245j3;
import me.tvspark.C2254jc;
import me.tvspark.C2560rg;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* renamed from: me.tvspark.ig */
/* loaded from: classes4.dex */
public final class C2221ig implements Loader.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<AbstractC2479pf>, Loader.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, AbstractC2220if, AbstractC2249j7, C2146gf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    public static final Set<Integer> Illllllllllllllllllllllllll = Collections.unmodifiableSet(new HashSet(Arrays.asList(1, 2, 4)));
    @Nullable
    public C2073eg Illlllllllllllllllllllllllll;
    @Nullable
    public C2322l6 Illllllllllllllllllllllllllll;

    /* renamed from: Kk */
    public long f4519Kk;
    public boolean Kkk;
    public boolean Kkkk;
    public boolean Kkkkk;
    public boolean Kkkkkk;
    public long Kkkkkkk;
    public long Kkkkkkkk;
    public boolean Kkkkkkkkkkk;
    public int Kkkkkkkkkkkk;
    public int[] Kkkkkkkkkkkkk;
    public Set<C2331lf> Kkkkkkkkkkkkkk;
    public C2368mf Kkkkkkkkkkkkkkk;
    public boolean Kkkkkkkkkkkkkkkk;
    @Nullable
    public C2245j3 Kkkkkkkkkkkkkkkkk;
    public C2245j3 Kkkkkkkkkkkkkkkkkk;
    public int Kkkkkkkkkkkkkkkkkkk;
    public boolean Kkkkkkkkkkkkkkkkkkkk;
    public boolean Kkkkkkkkkkkkkkkkkkkkk;
    public int Kkkkkkkkkkkkkkkkkkkkkk;
    public int Kkkkkkkkkkkkkkkkkkkkkkk;
    public AbstractC2740w7 Kkkkkkkkkkkkkkkkkkkkkkkk;
    @Nullable
    public AbstractC2479pf Wwwww;
    public final Map<String, C2322l6> Wwwwww;
    public final List<C2073eg> Wwwwwwwwwww;
    public final ArrayList<C2073eg> Wwwwwwwwwwww;
    public final int Wwwwwwwwwwwwww;
    public final AbstractC1944bf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwww;
    public final AbstractC2299kk Wwwwwwwwwwwwwwwww;
    public final AbstractC2396n6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwww;
    public final AbstractC2470p6 Wwwwwwwwwwwwwwwwwww;
    @Nullable
    public final C2245j3 Wwwwwwwwwwwwwwwwwwww;
    public final AbstractC2637tj Wwwwwwwwwwwwwwwwwwwww;
    public final C1908ag Wwwwwwwwwwwwwwwwwwwwww;
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwww;
    public final Loader Wwwwwwwwwwwwwwww = new Loader("Loader:HlsSampleStreamWrapper");
    public final C1908ag.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwww = new C1908ag.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public int[] Www = new int[0];
    public Set<Integer> Kkkkkkkkkkkkkkkkkkkkkkkkkk = new HashSet(Illllllllllllllllllllllllll.size());
    public SparseIntArray Kkkkkkkkkkkkkkkkkkkkkkkkk = new SparseIntArray(Illllllllllllllllllllllllll.size());
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[] Wwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[0];
    public boolean[] Kkkkkkkkk = new boolean[0];
    public boolean[] Kkkkkkkkkk = new boolean[0];
    public final ArrayList<C2184hg> Wwwwwww = new ArrayList<>();
    public final Runnable Wwwwwwwwww = new Runnable() { // from class: me.tvspark.vf
        @Override // java.lang.Runnable
        public final void run() {
            C2221ig.this.Wwwwwwwwwwwwwwwwwwwwwww();
        }
    };
    public final Runnable Wwwwwwwww = new Runnable() { // from class: me.tvspark.uf
        @Override // java.lang.Runnable
        public final void run() {
            C2221ig.this.Wwwwwwwwwwwwwwwwwwwww();
        }
    };
    public final Handler Wwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    /* renamed from: me.tvspark.ig$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends C2146gf {
        @Nullable
        public C2322l6 Kkkkkkkkkkkkkkkkkkkkkk;
        public final Map<String, C2322l6> Kkkkkkkkkkkkkkkkkkkkkkk;

        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2637tj abstractC2637tj, Looper looper, AbstractC2470p6 abstractC2470p6, AbstractC2396n6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Map map, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) {
            super(abstractC2637tj, looper, abstractC2470p6, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            this.Kkkkkkkkkkkkkkkkkkkkkkk = map;
        }

        @Override // me.tvspark.C2146gf
        public C2245j3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2245j3 c2245j3) {
            C2322l6 c2322l6;
            C2322l6 c2322l62 = this.Kkkkkkkkkkkkkkkkkkkkkk;
            if (c2322l62 == null) {
                c2322l62 = c2245j3.Wwwwwwwwww;
            }
            if (c2322l62 != null && (c2322l6 = this.Kkkkkkkkkkkkkkkkkkkkkkk.get(c2322l62.Wwwwwwwwwwwwwwwwwwwwww)) != null) {
                c2322l62 = c2322l6;
            }
            C2254jc c2254jc = c2245j3.Wwwwwwwwwwwwwww;
            if (c2254jc != null) {
                int length = c2254jc.Wwwwwwwwwwwwwwwwwwwwwwww.length;
                int i = 0;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        i2 = -1;
                        break;
                    }
                    C2254jc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2254jc.Wwwwwwwwwwwwwwwwwwwwwwww[i2];
                    if ((wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww instanceof C2366md) && "com.apple.streaming.transportStreamTimestamp".equals(((C2366md) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwww)) {
                        break;
                    }
                    i2++;
                }
                if (i2 != -1) {
                    if (length != 1) {
                        C2254jc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[] wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr = new C2254jc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[length - 1];
                        while (i < length) {
                            if (i != i2) {
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr[i < i2 ? i : i - 1] = c2254jc.Wwwwwwwwwwwwwwwwwwwwwwww[i];
                            }
                            i++;
                        }
                        c2254jc = new C2254jc(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr);
                    }
                }
                if (c2322l62 == c2245j3.Wwwwwwwwww || c2254jc != c2245j3.Wwwwwwwwwwwwwww) {
                    C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww = c2322l62;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww = c2254jc;
                    c2245j3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                }
                return super.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3);
            }
            c2254jc = null;
            if (c2322l62 == c2245j3.Wwwwwwwwww) {
            }
            C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwww = c2322l62;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwww = c2254jc;
            c2245j3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            return super.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3);
        }

        @Override // me.tvspark.C2146gf, me.tvspark.AbstractC2740w7
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, int i, int i2, int i3, @Nullable AbstractC2740w7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            super.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, i, i2, i3, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    /* renamed from: me.tvspark.ig$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2220if.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<C2221ig> {
    }

    public C2221ig(int i, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, C1908ag c1908ag, Map<String, C2322l6> map, AbstractC2637tj abstractC2637tj, long j, @Nullable C2245j3 c2245j3, AbstractC2470p6 abstractC2470p6, AbstractC2396n6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, AbstractC2299kk abstractC2299kk, AbstractC1944bf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, int i2) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwww = c1908ag;
        this.Wwwwww = map;
        this.Wwwwwwwwwwwwwwwwwwwww = abstractC2637tj;
        this.Wwwwwwwwwwwwwwwwwwww = c2245j3;
        this.Wwwwwwwwwwwwwwwwwww = abstractC2470p6;
        this.Wwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwww = abstractC2299kk;
        this.Wwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        this.Wwwwwwwwwwwwww = i2;
        ArrayList<C2073eg> arrayList = new ArrayList<>();
        this.Wwwwwwwwwwww = arrayList;
        this.Wwwwwwwwwww = Collections.unmodifiableList(arrayList);
        this.Kkkkkkkk = j;
        this.Kkkkkkk = j;
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        if (i != 1) {
            if (i == 2) {
                return 3;
            }
            return i != 3 ? 0 : 1;
        }
        return 2;
    }

    public final void Wwwwwwwwwwwwwwwwwwww() {
        for (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : this.Wwww) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkk);
        }
        this.Kkkkkk = false;
    }

    public final void Wwwwwwwwwwwwwwwwwwwww() {
        C2221ig[] c2221igArr;
        C2221ig[] c2221igArr2;
        this.Kkkkkkkkkkkkkkkkkkkkk = true;
        if (this.Kkkkkkkkkkkkkkkk || this.Kkkkkkkkkkkkk != null || 1 == 0) {
            return;
        }
        for (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : this.Wwww) {
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() == null) {
                return;
            }
        }
        C2368mf c2368mf = this.Kkkkkkkkkkkkkkk;
        if (c2368mf != null) {
            int i = c2368mf.Wwwwwwwwwwwwwwwwwwwwwwww;
            int[] iArr = new int[i];
            this.Kkkkkkkkkkkkk = iArr;
            Arrays.fill(iArr, -1);
            for (int i2 = 0; i2 < i; i2++) {
                int i3 = 0;
                while (true) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[] wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr = this.Wwww;
                    if (i3 < wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr.length) {
                        C2245j3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr[i3].Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        C2245j3 c2245j3 = this.Kkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwww[i2].Wwwwwwwwwwwwwwwwwwwwwww[0];
                        String str = Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwww;
                        String str2 = c2245j3.Wwwwwwwwwwwww;
                        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C1950bl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 3 ? C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) str, (Object) str2) && ((!"application/cea-608".equals(str) && !"application/cea-708".equals(str)) || Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Kkkkkkkkkkkkkkkkkkk == c2245j3.Kkkkkkkkkkkkkkkkkkk) : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww == C1950bl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2)) {
                            this.Kkkkkkkkkkkkk[i2] = i3;
                            break;
                        }
                        i3++;
                    }
                }
            }
            Iterator<C2184hg> it = this.Wwwwwww.iterator();
            while (it.hasNext()) {
                it.next().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
            return;
        }
        int length = this.Wwww.length;
        int i4 = 0;
        int i5 = 6;
        int i6 = -1;
        while (true) {
            int i7 = 2;
            if (i4 >= length) {
                break;
            }
            C2245j3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwww[i4].Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            String str3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwww;
            if (!C1950bl.Wwwwwwwwwwwwwwwwwwwwwwwwww(str3)) {
                i7 = C1950bl.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(str3) ? 1 : C1950bl.Wwwwwwwwwwwwwwwwwwwwwwwwwww(str3) ? 3 : 6;
            }
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i7) > Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i5)) {
                i6 = i4;
                i5 = i7;
            } else if (i7 == i5 && i6 != -1) {
                i6 = -1;
            }
            i4++;
        }
        C2331lf c2331lf = this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i8 = c2331lf.Wwwwwwwwwwwwwwwwwwwwwwww;
        this.Kkkkkkkkkkkk = -1;
        this.Kkkkkkkkkkkkk = new int[length];
        for (int i9 = 0; i9 < length; i9++) {
            this.Kkkkkkkkkkkkk[i9] = i9;
        }
        C2331lf[] c2331lfArr = new C2331lf[length];
        for (int i10 = 0; i10 < length; i10++) {
            C2245j3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = this.Wwww[i10].Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
            if (i10 == i6) {
                C2245j3[] c2245j3Arr = new C2245j3[i8];
                if (i8 == 1) {
                    c2245j3Arr[0] = Wwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2331lf.Wwwwwwwwwwwwwwwwwwwwwww[0]);
                } else {
                    for (int i11 = 0; i11 < i8; i11++) {
                        c2245j3Arr[i11] = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2331lf.Wwwwwwwwwwwwwwwwwwwwwww[i11], Wwwwwwwwwwwwwwwwwwwwwwwwwwwww3, true);
                    }
                }
                c2331lfArr[i10] = new C2331lf(c2245j3Arr);
                this.Kkkkkkkkkkkk = i10;
            } else {
                c2331lfArr[i10] = new C2331lf(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((i5 != 2 || !C1950bl.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwww)) ? null : this.Wwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwww3, false));
            }
        }
        this.Kkkkkkkkkkkkkkk = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2331lfArr);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkkkkkk == null);
        this.Kkkkkkkkkkkkkk = Collections.emptySet();
        this.Kkkkkkkkkkkkkkkkkkkk = true;
        C2147gg c2147gg = (C2147gg) this.Wwwwwwwwwwwwwwwwwwwwwww;
        int i12 = c2147gg.Wwwwwwww - 1;
        c2147gg.Wwwwwwww = i12;
        if (i12 > 0) {
            return;
        }
        int i13 = 0;
        for (C2221ig c2221ig : c2147gg.Wwwwww) {
            c2221ig.Wwwwwwwwwwwwwwwwwwwwwwwwww();
            i13 += c2221ig.Kkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwww;
        }
        C2331lf[] c2331lfArr2 = new C2331lf[i13];
        int i14 = 0;
        for (C2221ig c2221ig2 : c2147gg.Wwwwww) {
            c2221ig2.Wwwwwwwwwwwwwwwwwwwwwwwwww();
            int i15 = c2221ig2.Kkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwww;
            int i16 = 0;
            while (i16 < i15) {
                c2221ig2.Wwwwwwwwwwwwwwwwwwwwwwwwww();
                c2331lfArr2[i14] = c2221ig2.Kkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwww[i16];
                i16++;
                i14++;
            }
        }
        c2147gg.Wwwwwww = new C2368mf(c2331lfArr2);
        c2147gg.Wwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2784xe) c2147gg);
    }

    public void Wwwwwwwwwwwwwwwwwwwwww() throws IOException {
        this.Wwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Integer.MIN_VALUE);
        C1908ag c1908ag = this.Wwwwwwwwwwwwwwwwwwwwww;
        IOException iOException = c1908ag.Wwwwwwwwwwwwwwwwwwwwww;
        if (iOException == null) {
            Uri uri = c1908ag.Wwwwwwwwwwwwwwwwwwwww;
            if (uri == null || !c1908ag.Wwwwwwwwwwwwwwwww) {
                return;
            }
            ((C2443og) c1908ag.Wwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uri);
            return;
        }
        throw iOException;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwww() {
        C2221ig[] c2221igArr;
        C2221ig[] c2221igArr2;
        if (this.Kkkkkkkkkkkkkkkk || this.Kkkkkkkkkkkkk != null || !this.Kkkkkkkkkkkkkkkkkkkkk) {
            return;
        }
        for (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : this.Wwww) {
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() == null) {
                return;
            }
        }
        C2368mf c2368mf = this.Kkkkkkkkkkkkkkk;
        if (c2368mf != null) {
            int i = c2368mf.Wwwwwwwwwwwwwwwwwwwwwwww;
            int[] iArr = new int[i];
            this.Kkkkkkkkkkkkk = iArr;
            Arrays.fill(iArr, -1);
            for (int i2 = 0; i2 < i; i2++) {
                int i3 = 0;
                while (true) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[] wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr = this.Wwww;
                    if (i3 < wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr.length) {
                        C2245j3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr[i3].Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        C2245j3 c2245j3 = this.Kkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwww[i2].Wwwwwwwwwwwwwwwwwwwwwww[0];
                        String str = Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwww;
                        String str2 = c2245j3.Wwwwwwwwwwwww;
                        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C1950bl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 3 ? C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) str, (Object) str2) && ((!"application/cea-608".equals(str) && !"application/cea-708".equals(str)) || Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Kkkkkkkkkkkkkkkkkkk == c2245j3.Kkkkkkkkkkkkkkkkkkk) : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww == C1950bl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2)) {
                            this.Kkkkkkkkkkkkk[i2] = i3;
                            break;
                        }
                        i3++;
                    }
                }
            }
            Iterator<C2184hg> it = this.Wwwwwww.iterator();
            while (it.hasNext()) {
                it.next().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
            return;
        }
        int length = this.Wwww.length;
        int i4 = 0;
        int i5 = 6;
        int i6 = -1;
        while (true) {
            int i7 = 2;
            if (i4 >= length) {
                break;
            }
            C2245j3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwww[i4].Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            String str3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwww;
            if (!C1950bl.Wwwwwwwwwwwwwwwwwwwwwwwwww(str3)) {
                i7 = C1950bl.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(str3) ? 1 : C1950bl.Wwwwwwwwwwwwwwwwwwwwwwwwwww(str3) ? 3 : 6;
            }
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i7) > Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i5)) {
                i6 = i4;
                i5 = i7;
            } else if (i7 == i5 && i6 != -1) {
                i6 = -1;
            }
            i4++;
        }
        C2331lf c2331lf = this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i8 = c2331lf.Wwwwwwwwwwwwwwwwwwwwwwww;
        this.Kkkkkkkkkkkk = -1;
        this.Kkkkkkkkkkkkk = new int[length];
        for (int i9 = 0; i9 < length; i9++) {
            this.Kkkkkkkkkkkkk[i9] = i9;
        }
        C2331lf[] c2331lfArr = new C2331lf[length];
        for (int i10 = 0; i10 < length; i10++) {
            C2245j3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = this.Wwww[i10].Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
            if (i10 == i6) {
                C2245j3[] c2245j3Arr = new C2245j3[i8];
                if (i8 == 1) {
                    c2245j3Arr[0] = Wwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2331lf.Wwwwwwwwwwwwwwwwwwwwwww[0]);
                } else {
                    for (int i11 = 0; i11 < i8; i11++) {
                        c2245j3Arr[i11] = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2331lf.Wwwwwwwwwwwwwwwwwwwwwww[i11], Wwwwwwwwwwwwwwwwwwwwwwwwwwwww3, true);
                    }
                }
                c2331lfArr[i10] = new C2331lf(c2245j3Arr);
                this.Kkkkkkkkkkkk = i10;
            } else {
                c2331lfArr[i10] = new C2331lf(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((i5 != 2 || !C1950bl.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwww)) ? null : this.Wwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwww3, false));
            }
        }
        this.Kkkkkkkkkkkkkkk = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2331lfArr);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkkkkkk == null);
        this.Kkkkkkkkkkkkkk = Collections.emptySet();
        this.Kkkkkkkkkkkkkkkkkkkk = true;
        C2147gg c2147gg = (C2147gg) this.Wwwwwwwwwwwwwwwwwwwwwww;
        int i12 = c2147gg.Wwwwwwww - 1;
        c2147gg.Wwwwwwww = i12;
        if (i12 > 0) {
            return;
        }
        int i13 = 0;
        for (C2221ig c2221ig : c2147gg.Wwwwww) {
            c2221ig.Wwwwwwwwwwwwwwwwwwwwwwwwww();
            i13 += c2221ig.Kkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwww;
        }
        C2331lf[] c2331lfArr2 = new C2331lf[i13];
        int i14 = 0;
        for (C2221ig c2221ig2 : c2147gg.Wwwwww) {
            c2221ig2.Wwwwwwwwwwwwwwwwwwwwwwwwww();
            int i15 = c2221ig2.Kkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwww;
            int i16 = 0;
            while (i16 < i15) {
                c2221ig2.Wwwwwwwwwwwwwwwwwwwwwwwwww();
                c2331lfArr2[i14] = c2221ig2.Kkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwww[i16];
                i16++;
                i14++;
            }
        }
        c2147gg.Wwwwwww = new C2368mf(c2331lfArr2);
        c2147gg.Wwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2784xe) c2147gg);
    }

    public final boolean Wwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Kkkkkkk != -9223372036854775807L;
    }

    public final C2073eg Wwwwwwwwwwwwwwwwwwwwwwwww() {
        ArrayList<C2073eg> arrayList = this.Wwwwwwwwwwww;
        return arrayList.get(arrayList.size() - 1);
    }

    @EnsuresNonNull({"trackGroups", "optionalTrackGroups"})
    public final void Wwwwwwwwwwwwwwwwwwwwwwwwww() {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkkkkkkkkkkkk);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkkkkkkk);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkkkkkk);
    }

    @Override // me.tvspark.AbstractC2249j7
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Kkk = true;
        this.Wwwwwwww.post(this.Wwwwwwwww);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[] wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr;
        for (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : this.Wwww) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true);
            DrmSession drmSession = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (drmSession != null) {
                drmSession.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            }
        }
    }

    @Override // me.tvspark.AbstractC2220if
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        ArrayList<C2073eg> arrayList;
        if (this.Kkkk) {
            return Long.MIN_VALUE;
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwww()) {
            return this.Kkkkkkk;
        }
        long j = this.Kkkkkkkk;
        C2073eg Wwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwww();
        if (!Wwwwwwwwwwwwwwwwwwwwwwwww.Kkkkkkkkkkkkkkkkkkkkkkkkkk) {
            Wwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwww.size() > 1 ? this.Wwwwwwwwwwww.get(arrayList.size() - 2) : null;
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwww != null) {
            j = Math.max(j, Wwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        if (this.Kkkkkkkkkkkkkkkkkkkkk) {
            for (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : this.Wwww) {
                j = Math.max(j, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            }
        }
        return j;
    }

    @Override // me.tvspark.AbstractC2220if
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (Wwwwwwwwwwwwwwwwwwwwwwww()) {
            return this.Kkkkkkk;
        }
        if (!this.Kkkk) {
            return Wwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        return Long.MIN_VALUE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a9, code lost:
        r2 = false;
     */
    @Override // me.tvspark.AbstractC2220if
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        boolean z;
        if (this.Wwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() || Wwwwwwwwwwwwwwwwwwwwwwww()) {
            return;
        }
        boolean z2 = false;
        if (this.Wwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwww);
            C1908ag c1908ag = this.Wwwwwwwwwwwwwwwwwwwwww;
            AbstractC2479pf abstractC2479pf = this.Wwwww;
            List<C2073eg> list = this.Wwwwwwwwwww;
            if (c1908ag.Wwwwwwwwwwwwwwwwwwwwww == null) {
                z2 = c1908ag.Wwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, abstractC2479pf, list);
            }
            if (!z2) {
                return;
            }
            this.Wwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            return;
        }
        C1908ag c1908ag2 = this.Wwwwwwwwwwwwwwwwwwwwww;
        List<C2073eg> list2 = this.Wwwwwwwwwww;
        int size = (c1908ag2.Wwwwwwwwwwwwwwwwwwwwww != null || c1908ag2.Wwwwwwwwwwwwwwwwwww.length() < 2) ? list2.size() : c1908ag2.Wwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, list2);
        if (size >= this.Wwwwwwwwwwww.size()) {
            return;
        }
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(!this.Wwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        while (true) {
            if (size >= this.Wwwwwwwwwwww.size()) {
                size = -1;
                break;
            }
            int i = size;
            while (true) {
                if (i >= this.Wwwwwwwwwwww.size()) {
                    C2073eg c2073eg = this.Wwwwwwwwwwww.get(size);
                    for (int i2 = 0; i2 < this.Wwww.length; i2++) {
                        if (this.Wwww[i2].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() <= c2073eg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2)) {
                        }
                    }
                    z = true;
                } else if (this.Wwwwwwwwwwww.get(i).Wwwwwwwwwwwwwwwwwwwww) {
                    break;
                } else {
                    i++;
                }
            }
            if (z) {
                break;
            }
            size++;
        }
        if (size == -1) {
            return;
        }
        long j2 = Wwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        C2073eg c2073eg2 = this.Wwwwwwwwwwww.get(size);
        ArrayList<C2073eg> arrayList = this.Wwwwwwwwwwww;
        C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(arrayList, size, arrayList.size());
        for (int i3 = 0; i3 < this.Wwww.length; i3++) {
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2073eg2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwww[i3];
            C2109ff c2109ff = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            c2109ff.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != 0) {
                C2109ff.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2109ff.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    while (c2109ff.Wwwwwwwwwwwwwwwwwwwwwwwwwwww > wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    }
                    C2109ff.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    c2109ff.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                    C2109ff.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = new C2109ff.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2109ff.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
                    if (c2109ff.Wwwwwwwwwwwwwwwwwwwwwwwwwwww != wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    }
                    c2109ff.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
                    if (c2109ff.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww == wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) {
                        c2109ff.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    }
                }
            }
            c2109ff.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2109ff.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            C2109ff.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = new C2109ff.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2109ff.Wwwwwwwwwwwwwwwwwwwwwwwwwwww, c2109ff.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            c2109ff.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4;
            c2109ff.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4;
            c2109ff.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4;
        }
        if (this.Wwwwwwwwwwww.isEmpty()) {
            this.Kkkkkkk = this.Kkkkkkkk;
        } else {
            ((C2073eg) Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Iterable<Object>) this.Wwwwwwwwwwww)).Kkkkkkkkkkkkkkkkkkkkkkkk = true;
        }
        this.Kkkk = false;
        AbstractC1944bf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = this.Wwwwwwwwwwwwwww;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new C2747we(1, this.Kkkkkkkkkkkkkkkkkkkkkkk, null, 3, null, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2073eg2.Wwwwwwwwwwwwwwwwwwwwwwwwwwww), wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j2)));
    }

    @Override // me.tvspark.C2146gf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2245j3 c2245j3) {
        this.Wwwwwwww.post(this.Wwwwwwwwww);
    }

    @Override // me.tvspark.AbstractC2249j7
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2625t7 abstractC2625t7) {
    }

    @Override // me.tvspark.AbstractC2220if
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.AbstractC2220if
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        List<C2073eg> list;
        long max;
        boolean z;
        C1908ag.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        long j2;
        int i;
        Uri uri;
        long j3;
        int i2;
        byte[] bArr;
        C2073eg c2073eg;
        String str;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[] wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr;
        if (this.Kkkk || this.Wwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() || this.Wwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            return false;
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwww()) {
            list = Collections.emptyList();
            max = this.Kkkkkkk;
            for (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : this.Wwww) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwww = this.Kkkkkkk;
            }
        } else {
            list = this.Wwwwwwwwwww;
            C2073eg Wwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwww();
            max = Wwwwwwwwwwwwwwwwwwwwwwwww.Kkkkkkkkkkkkkkkkkkkkkkkkkk ? Wwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww : Math.max(this.Kkkkkkkk, Wwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        List<C2073eg> list2 = list;
        long j4 = max;
        C1908ag c1908ag = this.Wwwwwwwwwwwwwwwwwwwwww;
        boolean z2 = this.Kkkkkkkkkkkkkkkkkkkk || !list2.isEmpty();
        C1908ag.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwww;
        if (c1908ag != null) {
            C2073eg c2073eg2 = list2.isEmpty() ? null : list2.get(list2.size() - 1);
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2073eg2 == null ? -1 : c1908ag.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2073eg2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            long j5 = j4 - j;
            long j6 = (c1908ag.Wwwwwwwwwwwwwwwwww > (-9223372036854775807L) ? 1 : (c1908ag.Wwwwwwwwwwwwwwwwww == (-9223372036854775807L) ? 0 : -1)) != 0 ? c1908ag.Wwwwwwwwwwwwwwwwww - j : -9223372036854775807L;
            if (c2073eg2 == null || c1908ag.Wwwwwwwwwwwwwwwwwwww) {
                z = z2;
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                j2 = -9223372036854775807L;
            } else {
                z = z2;
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                long j7 = c2073eg2.Wwwwwwwwwwwwwwwwwwwwwwwwwww - c2073eg2.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                j5 = Math.max(0L, j5 - j7);
                j2 = -9223372036854775807L;
                if (j6 != -9223372036854775807L) {
                    j6 = Math.max(0L, j6 - j7);
                }
            }
            int i3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            c1908ag.Wwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, j5, j6, list2, c1908ag.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2073eg2, j4));
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c1908ag.Wwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            boolean z3 = i3 != Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            Uri uri2 = c1908ag.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2];
            C1908ag.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (!((C2443og) c1908ag.Wwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uri2)) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = uri2;
                c1908ag.Wwwwwwwwwwwwwwwww &= uri2.equals(c1908ag.Wwwwwwwwwwwwwwwwwwwww);
                c1908ag.Wwwwwwwwwwwwwwwwwwwww = uri2;
            } else {
                C2560rg Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = ((C2443og) c1908ag.Wwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uri2, true);
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
                c1908ag.Wwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwww) {
                    j2 = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwww) - ((C2443og) c1908ag.Wwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwww;
                }
                c1908ag.Wwwwwwwwwwwwwwwwww = j2;
                long j8 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww - ((C2443og) c1908ag.Wwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwww;
                C2560rg c2560rg = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
                long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = c1908ag.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2073eg2, z3, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, j8, j4);
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 >= c2560rg.Wwwwwwwwwwwwwwwwwwwwwwwwww || c2073eg2 == null || !z3) {
                    i = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                    uri = uri2;
                    j3 = j8;
                } else {
                    Uri uri3 = c1908ag.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i3];
                    C2560rg Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = ((C2443og) c1908ag.Wwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uri3, true);
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5);
                    long j9 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww - ((C2443og) c1908ag.Wwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwww;
                    long j10 = c2073eg2.Wwwwwwwwwwwwwwwwwwwwwwwww;
                    j3 = j9;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = j10 != -1 ? j10 + 1 : -1L;
                    i = i3;
                    uri = uri3;
                    c2560rg = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5;
                }
                long j11 = c2560rg.Wwwwwwwwwwwwwwwwwwwwwwwwww;
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 < j11) {
                    c1908ag.Wwwwwwwwwwwwwwwwwwwwww = new BehindLiveWindowException();
                } else {
                    int i4 = (int) (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 - j11);
                    int size = c2560rg.Wwwwwwwwwwwwwwwwwwww.size();
                    if (i4 < size) {
                        i2 = i4;
                    } else if (!c2560rg.Wwwwwwwwwwwwwwwwwwwwwww) {
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = uri;
                        c1908ag.Wwwwwwwwwwwwwwwww &= uri.equals(c1908ag.Wwwwwwwwwwwwwwwwwwwww);
                        c1908ag.Wwwwwwwwwwwwwwwwwwwww = uri;
                    } else if (z || size == 0) {
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
                    } else {
                        i2 = size - 1;
                    }
                    c1908ag.Wwwwwwwwwwwwwwwww = false;
                    c1908ag.Wwwwwwwwwwwwwwwwwwwww = null;
                    C2560rg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2560rg.Wwwwwwwwwwwwwwwwwwww.get(i2);
                    C2560rg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww;
                    Uri Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == null || (str = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwww) == null) ? null : Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2560rg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, str);
                    AbstractC2479pf Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 = c1908ag.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6, i);
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7;
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 == null) {
                        String str2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww;
                        Uri Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8 = str2 == null ? null : Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2560rg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, str2);
                        AbstractC2479pf Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9 = c1908ag.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8, i);
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9;
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9 == null) {
                            AbstractC1982cg abstractC1982cg = c1908ag.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            AbstractC2863zj abstractC2863zj = c1908ag.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            C2245j3 c2245j3 = c1908ag.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww[i];
                            List<C2245j3> list3 = c1908ag.Wwwwwwwwwwwwwwwwwwwwwwwwww;
                            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c1908ag.Wwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                            Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = c1908ag.Wwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                            boolean z4 = c1908ag.Wwwwwwwwwwwwwwwwwwwwwwww;
                            C2295kg c2295kg = c1908ag.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            FullSegmentEncryptionKeyCache fullSegmentEncryptionKeyCache = c1908ag.Wwwwwwwwwwwwwwwwwwwwwwwww;
                            if (fullSegmentEncryptionKeyCache == null) {
                                throw null;
                            }
                            byte[] bArr2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8 == null ? null : fullSegmentEncryptionKeyCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8);
                            FullSegmentEncryptionKeyCache fullSegmentEncryptionKeyCache2 = c1908ag.Wwwwwwwwwwwwwwwwwwwwwwwww;
                            if (fullSegmentEncryptionKeyCache2 != null) {
                                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 == null) {
                                    c2073eg = c2073eg2;
                                    bArr = null;
                                } else {
                                    bArr = fullSegmentEncryptionKeyCache2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6);
                                    c2073eg = c2073eg2;
                                }
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2073eg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC1982cg, abstractC2863zj, c2245j3, j3, c2560rg, i2, uri, list3, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, z4, c2295kg, c2073eg, bArr2, bArr);
                            } else {
                                throw null;
                            }
                        }
                    }
                }
            }
            C1908ag.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = this.Wwwwwwwwwwwww;
            boolean z5 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            AbstractC2479pf abstractC2479pf = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            Uri uri4 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            if (z5) {
                this.Kkkkkkk = -9223372036854775807L;
                this.Kkkk = true;
                return true;
            } else if (abstractC2479pf == null) {
                if (uri4 == null) {
                    return false;
                }
                ((C2443og) ((C2147gg) this.Wwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwww.get(uri4).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                return false;
            } else {
                if (abstractC2479pf instanceof C2073eg) {
                    C2073eg c2073eg3 = (C2073eg) abstractC2479pf;
                    this.Illlllllllllllllllllllllllll = c2073eg3;
                    this.Kkkkkkkkkkkkkkkkkk = c2073eg3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    this.Kkkkkkk = -9223372036854775807L;
                    this.Wwwwwwwwwwww.add(c2073eg3);
                    ImmutableList.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww builder = ImmutableList.builder();
                    for (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 : this.Wwww) {
                        builder.mo4629Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((ImmutableList.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) Integer.valueOf(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwww()));
                    }
                    ImmutableList<Integer> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww10 = builder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    c2073eg3.Wwwwww = this;
                    c2073eg3.Kkkkkkkkkkkkkkkkkkkkkkkkk = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww10;
                    for (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 : this.Wwww) {
                        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 != null) {
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwww = c2073eg3.Wwwwwwwwwwwwwwwwwwwwwwww;
                            if (c2073eg3.Wwwwwwwwwwwwwwwwwwwww) {
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Kkkkkkkkkkkkkkkkkkkkkkkk = true;
                            }
                        } else {
                            throw null;
                        }
                    }
                }
                this.Wwwww = abstractC2479pf;
                this.Wwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new C2632te(abstractC2479pf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, abstractC2479pf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2479pf, this, ((C2225ik) this.Wwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2479pf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww))), abstractC2479pf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwww, abstractC2479pf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, abstractC2479pf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, abstractC2479pf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, abstractC2479pf.Wwwwwwwwwwwwwwwwwwwwwwwwwwww, abstractC2479pf.Wwwwwwwwwwwwwwwwwwwwwwwwwww);
                return true;
            }
        }
        throw null;
    }

    /* renamed from: me.tvspark.ig$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements AbstractC2740w7 {
        public static final C2245j3 Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        public static final C2245j3 Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public C2245j3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final C2245j3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final AbstractC2740w7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final C2667uc Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2667uc();

        static {
            C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww = "application/id3";
            Wwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = new C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwww = "application/x-emsg";
            Wwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2740w7 abstractC2740w7, int i) {
            C2245j3 c2245j3;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2740w7;
            if (i == 1) {
                c2245j3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
            } else if (i != 3) {
                throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(33, "Unknown metadataType: ", i));
            } else {
                c2245j3 = Wwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2245j3;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new byte[0];
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        }

        @Override // me.tvspark.AbstractC2740w7
        public /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2752wj abstractC2752wj, int i, boolean z) throws IOException {
            return C2700v7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, abstractC2752wj, i, z);
        }

        @Override // me.tvspark.AbstractC2740w7
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2752wj abstractC2752wj, int i, boolean z, int i2) throws IOException {
            int i3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww + i;
            byte[] bArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (bArr.length < i3) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Arrays.copyOf(bArr, (i3 / 2) + i3);
            }
            int read = abstractC2752wj.read(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, i);
            if (read != -1) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww += read;
                return read;
            } else if (!z) {
                throw new EOFException();
            } else {
                return -1;
            }
        }

        @Override // me.tvspark.AbstractC2740w7
        public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el, int i) {
            C2700v7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, c2078el, i);
        }

        @Override // me.tvspark.AbstractC2740w7
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2245j3 c2245j3) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2245j3;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }

        @Override // me.tvspark.AbstractC2740w7
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el, int i, int i2) {
            int i3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww + i;
            byte[] bArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (bArr.length < i3) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Arrays.copyOf(bArr, (i3 / 2) + i3);
            }
            c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, i);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww += i;
        }

        @Override // me.tvspark.AbstractC2740w7
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, int i, int i2, int i3, @Nullable AbstractC2740w7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            int i4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww - i3;
            C2078el c2078el = new C2078el(Arrays.copyOfRange(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i4 - i2, i4));
            byte[] bArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            System.arraycopy(bArr, i4, bArr, 0, i3);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = i3;
            if (!C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwww, (Object) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwww)) {
                if (!"application/x-emsg".equals(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwww)) {
                    String valueOf = String.valueOf(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwww);
                    if (valueOf.length() != 0) {
                        "Ignoring sample for unsupported format: ".concat(valueOf);
                        return;
                    } else {
                        new String("Ignoring sample for unsupported format: ");
                        return;
                    }
                }
                C2630tc Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el);
                C2245j3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                if (!(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null && C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwww, (Object) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwww))) {
                    String.format("Ignoring EMSG. Expected it to contain wrapped %s but actual wrapped format: %s", this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                    return;
                }
                byte[] bArr2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() != null ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww : null;
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr2);
                c2078el = new C2078el(bArr2);
            }
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, i, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, i3, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[] wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr;
        if (this.f4519Kk != j) {
            this.f4519Kk = j;
            for (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : this.Wwww) {
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Kkkkkkkkkkkkkkkkkkkkkkkkk != j) {
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Kkkkkkkkkkkkkkkkkkkkkkkkk = j;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwww = true;
                }
            }
        }
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, boolean z) {
        boolean z2;
        this.Kkkkkkkk = j;
        if (Wwwwwwwwwwwwwwwwwwwwwwww()) {
            this.Kkkkkkk = j;
            return true;
        }
        if (this.Kkkkkkkkkkkkkkkkkkkkk && !z) {
            int length = this.Wwww.length;
            for (int i = 0; i < length; i++) {
                if (!this.Wwww[i].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, false) && (this.Kkkkkkkkk[i] || !this.Kkkkkkkkkkk)) {
                    z2 = false;
                    break;
                }
            }
            z2 = true;
            if (z2) {
                return false;
            }
        }
        this.Kkkkkkk = j;
        this.Kkkk = false;
        this.Wwwwwwwwwwww.clear();
        if (this.Wwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            this.Wwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        } else {
            this.Wwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            Wwwwwwwwwwwwwwwwwwww();
        }
        return true;
    }

    public final C2368mf Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2331lf[] c2331lfArr) {
        for (int i = 0; i < c2331lfArr.length; i++) {
            C2331lf c2331lf = c2331lfArr[i];
            C2245j3[] c2245j3Arr = new C2245j3[c2331lf.Wwwwwwwwwwwwwwwwwwwwwwww];
            for (int i2 = 0; i2 < c2331lf.Wwwwwwwwwwwwwwwwwwwwwwww; i2++) {
                C2245j3 c2245j3 = c2331lf.Wwwwwwwwwwwwwwwwwwwwwww[i2];
                c2245j3Arr[i2] = c2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3));
            }
            c2331lfArr[i] = new C2331lf(c2245j3Arr);
        }
        return new C2368mf(c2331lfArr);
    }

    public static C2245j3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable C2245j3 c2245j3, C2245j3 c2245j32, boolean z) {
        if (c2245j3 == null) {
            return c2245j32;
        }
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3.Wwwwwwwwwwwwwwww, C1950bl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j32.Wwwwwwwwwwwww));
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C1950bl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = c2245j32.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2245j3.Wwwwwwwwwwwwwwwwwwwwwwww;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2245j3.Wwwwwwwwwwwwwwwwwwwwwww;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2245j3.Wwwwwwwwwwwwwwwwwwwwww;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2245j3.Wwwwwwwwwwwwwwwwwwwww;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2245j3.Wwwwwwwwwwwwwwwwwwww;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = z ? c2245j3.Wwwwwwwwwwwwwwwwwww : -1;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = z ? c2245j3.Wwwwwwwwwwwwwwwwww : -1;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwww = c2245j3.Wwwwwwww;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwww = c2245j3.Wwwwwww;
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        }
        int i = c2245j3.Kkkkkkkkkkkkkkkkkkkkkkkk;
        if (i != -1) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwww = i;
        }
        C2254jc c2254jc = c2245j3.Wwwwwwwwwwwwwww;
        if (c2254jc != null) {
            C2254jc c2254jc2 = c2245j32.Wwwwwwwwwwwwwww;
            if (c2254jc2 != null) {
                c2254jc = c2254jc2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2254jc);
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwww = c2254jc;
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2479pf abstractC2479pf, long j, long j2, boolean z) {
        AbstractC2479pf abstractC2479pf2 = abstractC2479pf;
        this.Wwwww = null;
        long j3 = abstractC2479pf2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        C1949bk c1949bk = abstractC2479pf2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        C2373mk c2373mk = abstractC2479pf2.Wwwwwwwwwwwwwwwwwwwwwwwwww;
        C2632te c2632te = new C2632te(j3, c1949bk, c2373mk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2373mk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, j, j2, c2373mk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2479pf2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2632te, abstractC2479pf2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwww, abstractC2479pf2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, abstractC2479pf2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, abstractC2479pf2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, abstractC2479pf2.Wwwwwwwwwwwwwwwwwwwwwwwwwwww, abstractC2479pf2.Wwwwwwwwwwwwwwwwwwwwwwwwwww);
        if (!z) {
            if (Wwwwwwwwwwwwwwwwwwwwwwww() || this.Kkkkkkkkkkkkkkkkkkk == 0) {
                Wwwwwwwwwwwwwwwwwwww();
            }
            if (this.Kkkkkkkkkkkkkkkkkkk <= 0) {
                return;
            }
            ((C2147gg) this.Wwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2479pf abstractC2479pf, long j, long j2) {
        AbstractC2479pf abstractC2479pf2 = abstractC2479pf;
        this.Wwwww = null;
        C1908ag c1908ag = this.Wwwwwwwwwwwwwwwwwwwwww;
        if (c1908ag != null) {
            if (abstractC2479pf2 instanceof C1908ag.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                C1908ag.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (C1908ag.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) abstractC2479pf2;
                c1908ag.Wwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwww;
                FullSegmentEncryptionKeyCache fullSegmentEncryptionKeyCache = c1908ag.Wwwwwwwwwwwwwwwwwwwwwwwww;
                Uri uri = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                byte[] bArr = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww;
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr);
                LinkedHashMap<Uri, byte[]> linkedHashMap = fullSegmentEncryptionKeyCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (uri == null) {
                    throw null;
                }
                linkedHashMap.put(uri, bArr);
            }
            long j3 = abstractC2479pf2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            C1949bk c1949bk = abstractC2479pf2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            C2373mk c2373mk = abstractC2479pf2.Wwwwwwwwwwwwwwwwwwwwwwwwww;
            C2632te c2632te = new C2632te(j3, c1949bk, c2373mk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2373mk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, j, j2, c2373mk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2479pf2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2632te, abstractC2479pf2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwww, abstractC2479pf2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, abstractC2479pf2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, abstractC2479pf2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, abstractC2479pf2.Wwwwwwwwwwwwwwwwwwwwwwwwwwww, abstractC2479pf2.Wwwwwwwwwwwwwwwwwwwwwwwwwww);
            if (!this.Kkkkkkkkkkkkkkkkkkkk) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkk);
                return;
            } else {
                ((C2147gg) this.Wwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
                return;
            }
        }
        throw null;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public Loader.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2479pf abstractC2479pf, long j, long j2, IOException iOException, int i) {
        boolean z;
        Loader.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        AbstractC2479pf abstractC2479pf2 = abstractC2479pf;
        long j3 = abstractC2479pf2.Wwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        boolean z2 = abstractC2479pf2 instanceof C2073eg;
        long j4 = abstractC2479pf2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        C1949bk c1949bk = abstractC2479pf2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        C2373mk c2373mk = abstractC2479pf2.Wwwwwwwwwwwwwwwwwwwwwwwwww;
        C2632te c2632te = new C2632te(j4, c1949bk, c2373mk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2373mk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, j, j2, j3);
        AbstractC2299kk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new AbstractC2299kk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2632te, new C2747we(abstractC2479pf2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwww, abstractC2479pf2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, abstractC2479pf2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, abstractC2479pf2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2479pf2.Wwwwwwwwwwwwwwwwwwwwwwwwwwww), C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2479pf2.Wwwwwwwwwwwwwwwwwwwwwwwwwww)), iOException, i);
        long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = ((C2225ik) this.Wwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        boolean z3 = false;
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 != -9223372036854775807L) {
            C1908ag c1908ag = this.Wwwwwwwwwwwwwwwwwwwwww;
            AbstractC1985cj abstractC1985cj = c1908ag.Wwwwwwwwwwwwwwwwwww;
            z = abstractC1985cj.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC1985cj.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c1908ag.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2479pf2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
        } else {
            z = false;
        }
        if (z) {
            if (z2 && j3 == 0) {
                ArrayList<C2073eg> arrayList = this.Wwwwwwwwwwww;
                if (arrayList.remove(arrayList.size() - 1) == abstractC2479pf2) {
                    z3 = true;
                }
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z3);
                if (this.Wwwwwwwwwwww.isEmpty()) {
                    this.Kkkkkkk = this.Kkkkkkkk;
                } else {
                    ((C2073eg) Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Iterable<Object>) this.Wwwwwwwwwwww)).Kkkkkkkkkkkkkkkkkkkkkkkk = true;
                }
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Loader.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        } else {
            long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = ((C2225ik) this.Wwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != -9223372036854775807L ? Loader.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) : Loader.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        boolean z4 = !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        boolean z5 = z;
        this.Wwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2632te, abstractC2479pf2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwww, abstractC2479pf2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, abstractC2479pf2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, abstractC2479pf2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, abstractC2479pf2.Wwwwwwwwwwwwwwwwwwwwwwwwwwww, abstractC2479pf2.Wwwwwwwwwwwwwwwwwwwwwwwwwww, iOException, z4);
        if (z4) {
            this.Wwwww = null;
            this.Wwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2479pf2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        if (z5) {
            if (!this.Kkkkkkkkkkkkkkkkkkkk) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkk);
            } else {
                ((C2147gg) this.Wwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
            }
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2331lf[] c2331lfArr, int i, int... iArr) {
        this.Kkkkkkkkkkkkkkk = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2331lfArr);
        this.Kkkkkkkkkkkkkk = new HashSet();
        for (int i2 : iArr) {
            this.Kkkkkkkkkkkkkk.add(this.Kkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwww[i2]);
        }
        this.Kkkkkkkkkkkk = i;
        Handler handler = this.Wwwwwwww;
        final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwww;
        Objects.requireNonNull(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        handler.post(new Runnable() { // from class: me.tvspark.tf
            @Override // java.lang.Runnable
            public final void run() {
                ((C2147gg) C2221ig.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this).Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        });
        this.Kkkkkkkkkkkkkkkkkkkk = true;
    }

    @Override // me.tvspark.AbstractC2249j7
    public AbstractC2740w7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        boolean z = false;
        if (!Illllllllllllllllllllllllll.contains(Integer.valueOf(i2))) {
            int i3 = 0;
            while (true) {
                AbstractC2740w7[] abstractC2740w7Arr = this.Wwww;
                if (i3 >= abstractC2740w7Arr.length) {
                    break;
                } else if (this.Www[i3] == i) {
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2740w7Arr[i3];
                    break;
                } else {
                    i3++;
                }
            }
        } else {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Illllllllllllllllllllllllll.contains(Integer.valueOf(i2)));
            int i4 = this.Kkkkkkkkkkkkkkkkkkkkkkkkk.get(i2, -1);
            if (i4 != -1) {
                if (this.Kkkkkkkkkkkkkkkkkkkkkkkkkk.add(Integer.valueOf(i2))) {
                    this.Www[i4] = i;
                }
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Www[i4] == i ? this.Wwww[i4] : new C2138g7();
            }
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        }
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            if (this.Kkk) {
                return new C2138g7();
            }
            int length = this.Wwww.length;
            if (i2 == 1 || i2 == 2) {
                z = true;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwww, this.Wwwwwwww.getLooper(), this.Wwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwww, this.Wwwwww, null);
            if (z) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Kkkkkkkkkkkkkkkkkkkkkk = this.Illllllllllllllllllllllllllll;
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwww = true;
            }
            long j = this.f4519Kk;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Kkkkkkkkkkkkkkkkkkkkkkkkk != j) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Kkkkkkkkkkkkkkkkkkkkkkkkk = j;
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwww = true;
            }
            C2073eg c2073eg = this.Illlllllllllllllllllllllllll;
            if (c2073eg != null) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwww = c2073eg.Wwwwwwwwwwwwwwwwwwwwwwww;
            }
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = this;
            int i5 = length + 1;
            int[] copyOf = Arrays.copyOf(this.Www, i5);
            this.Www = copyOf;
            copyOf[length] = i;
            this.Wwww = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[]) C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            boolean[] copyOf2 = Arrays.copyOf(this.Kkkkkkkkk, i5);
            this.Kkkkkkkkk = copyOf2;
            copyOf2[length] = z;
            this.Kkkkkkkkkkk = copyOf2[length] | this.Kkkkkkkkkkk;
            this.Kkkkkkkkkkkkkkkkkkkkkkkkkk.add(Integer.valueOf(i2));
            this.Kkkkkkkkkkkkkkkkkkkkkkkkk.append(i2, length);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2) > Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkkkkkkkkkkkkkkk)) {
                this.Kkkkkkkkkkkkkkkkkkkkkk = length;
                this.Kkkkkkkkkkkkkkkkkkkkkkk = i2;
            }
            this.Kkkkkkkkkk = Arrays.copyOf(this.Kkkkkkkkkk, i5);
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        }
        if (i2 == 4) {
            if (this.Kkkkkkkkkkkkkkkkkkkkkkkk == null) {
                this.Kkkkkkkkkkkkkkkkkkkkkkkk = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwww);
            }
            return this.Kkkkkkkkkkkkkkkkkkkkkkkk;
        }
        return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }
}
