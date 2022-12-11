package me.tvspark;

import android.net.Uri;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.source.hls.FullSegmentEncryptionKeyCache;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* renamed from: me.tvspark.ag */
/* loaded from: classes4.dex */
public class C1908ag {
    public boolean Wwwwwwwwwwwwwwwww;
    public AbstractC1985cj Wwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwww;
    @Nullable
    public Uri Wwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public IOException Wwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public final List<C2245j3> Wwwwwwwwwwwwwwwwwwwwwwwwww;
    public final C2331lf Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final HlsPlaylistTracker Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final C2245j3[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Uri[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final C2295kg Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final AbstractC2863zj Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final AbstractC2863zj Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final AbstractC1982cg Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final FullSegmentEncryptionKeyCache Wwwwwwwwwwwwwwwwwwwwwwwww = new FullSegmentEncryptionKeyCache(4);
    public byte[] Wwwwwwwwwwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwww = -9223372036854775807L;

    /* renamed from: me.tvspark.ag$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2788xi {
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2331lf c2331lf, int[] iArr) {
            super(c2331lf, iArr);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2331lf.Wwwwwwwwwwwwwwwwwwwwwww[iArr[0]]);
        }

        @Override // me.tvspark.AbstractC1985cj
        @Nullable
        public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return null;
        }

        @Override // me.tvspark.AbstractC1985cj
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return 0;
        }

        @Override // me.tvspark.AbstractC1985cj
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.AbstractC1985cj
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, long j2, long j3, List<? extends AbstractC2559rf> list, AbstractC2596sf[] abstractC2596sfArr) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww, elapsedRealtime)) {
                return;
            }
            for (int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - 1; i >= 0; i--) {
                if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, elapsedRealtime)) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
                    return;
                }
            }
            throw new IllegalStateException();
        }
    }

    /* renamed from: me.tvspark.ag$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2442of {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2560rg c2560rg, long j, int i) {
            super(i, c2560rg.Wwwwwwwwwwwwwwwwwwww.size() - 1);
        }
    }

    /* renamed from: me.tvspark.ag$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        @Nullable
        public AbstractC2479pf Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
        @Nullable
        public Uri Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
    }

    /* renamed from: me.tvspark.ag$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2522qf {
        public byte[] Wwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2863zj abstractC2863zj, C1949bk c1949bk, C2245j3 c2245j3, int i, @Nullable Object obj, byte[] bArr) {
            super(abstractC2863zj, c1949bk, 3, c2245j3, i, obj, bArr);
        }
    }

    public C1908ag(AbstractC1982cg abstractC1982cg, HlsPlaylistTracker hlsPlaylistTracker, Uri[] uriArr, C2245j3[] c2245j3Arr, AbstractC1945bg abstractC1945bg, @Nullable AbstractC2410nk abstractC2410nk, C2295kg c2295kg, @Nullable List<C2245j3> list) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC1982cg;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = hlsPlaylistTracker;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = uriArr;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2245j3Arr;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2295kg;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwww = list;
        AbstractC2863zj Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = abstractC1945bg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        if (abstractC2410nk != null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2410nk);
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC1945bg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = new C2331lf(c2245j3Arr);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < uriArr.length; i++) {
            if ((c2245j3Arr[i].Wwwwwwwwwwwwwwwwwwww & 16384) == 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        this.Wwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwww, Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Collection<? extends Number>) arrayList));
    }

    public AbstractC2596sf[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable C2073eg c2073eg, long j) {
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2073eg == null ? -1 : this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2073eg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        int length = this.Wwwwwwwwwwwwwwwwwww.length();
        AbstractC2596sf[] abstractC2596sfArr = new AbstractC2596sf[length];
        for (int i = 0; i < length; i++) {
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
            Uri uri = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2];
            if (!((C2443og) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uri)) {
                abstractC2596sfArr[i] = AbstractC2596sf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            } else {
                C2560rg Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = ((C2443og) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uri, false);
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
                long j2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww - ((C2443og) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwww;
                long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2073eg, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, j2, j);
                long j3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwww;
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 < j3) {
                    abstractC2596sfArr[i] = AbstractC2596sf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                } else {
                    abstractC2596sfArr[i] = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, j2, (int) (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 - j3));
                }
            }
        }
        return abstractC2596sfArr;
    }

    public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable C2073eg c2073eg, boolean z, C2560rg c2560rg, long j, long j2) {
        long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        long j3;
        if (c2073eg != null && !z) {
            if (c2073eg.Kkkkkkkkkkkkkkkkkkkkkkkkkk) {
                long j4 = c2073eg.Wwwwwwwwwwwwwwwwwwwwwwwww;
                if (j4 == -1) {
                    return -1L;
                }
                return 1 + j4;
            }
            return c2073eg.Wwwwwwwwwwwwwwwwwwwwwwwww;
        }
        long j5 = c2560rg.Wwwwwwwwwwwwwwwwwww + j;
        if (c2073eg != null && !this.Wwwwwwwwwwwwwwwwwwww) {
            j2 = c2073eg.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        if (c2560rg.Wwwwwwwwwwwwwwwwwwwwwww || j2 < j5) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((List<? extends Comparable<? super Long>>) c2560rg.Wwwwwwwwwwwwwwwwwwww, Long.valueOf(j2 - j), true, !((C2443og) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwww || c2073eg == null);
            j3 = c2560rg.Wwwwwwwwwwwwwwwwwwwwwwwwww;
        } else {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2560rg.Wwwwwwwwwwwwwwwwwwwwwwwwww;
            j3 = c2560rg.Wwwwwwwwwwwwwwwwwwww.size();
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 + j3;
    }

    @Nullable
    public final AbstractC2479pf Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable Uri uri, int i) {
        if (uri == null) {
            return null;
        }
        byte[] remove = this.Wwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.remove(uri);
        if (remove != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(uri, remove);
            return null;
        }
        Map emptyMap = Collections.emptyMap();
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uri, "The uri must be set.");
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, new C1949bk(uri, 0L, 1, null, emptyMap, 0L, -1L, null, 1, null), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww[i], this.Wwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), this.Wwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(), this.Wwwwwwwwwwwwwwwwwwwwwww);
    }
}
