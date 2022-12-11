package me.tvspark;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import me.tvspark.AbstractC1944bf;
import me.tvspark.AbstractC2396n6;
import me.tvspark.AbstractC2784xe;
import me.tvspark.C2221ig;
import me.tvspark.C2245j3;
import me.tvspark.C2322l6;
import me.tvspark.C2523qg;

/* renamed from: me.tvspark.gg */
/* loaded from: classes4.dex */
public final class C2147gg implements AbstractC2784xe, C2221ig.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, HlsPlaylistTracker.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    public AbstractC2220if Wwww;
    public C2221ig[] Wwwww;
    public C2221ig[] Wwwwww;
    public C2368mf Wwwwwww;
    public int Wwwwwwww;
    @Nullable
    public AbstractC2784xe.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwww;
    public final boolean Wwwwwwwwww;
    public final int Wwwwwwwwwww;
    public final boolean Wwwwwwwwwwww;
    public final C2441oe Wwwwwwwwwwwww;
    public final C2295kg Wwwwwwwwwwwwww;
    public final IdentityHashMap<AbstractC2183hf, Integer> Wwwwwwwwwwwwwww;
    public final AbstractC2637tj Wwwwwwwwwwwwwwww;
    public final AbstractC1944bf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwww;
    public final AbstractC2299kk Wwwwwwwwwwwwwwwwww;
    public final AbstractC2396n6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwww;
    public final AbstractC2470p6 Wwwwwwwwwwwwwwwwwwww;
    @Nullable
    public final AbstractC2410nk Wwwwwwwwwwwwwwwwwwwww;
    public final AbstractC1945bg Wwwwwwwwwwwwwwwwwwwwww;
    public final HlsPlaylistTracker Wwwwwwwwwwwwwwwwwwwwwww;
    public final AbstractC1982cg Wwwwwwwwwwwwwwwwwwwwwwww;

    public C2147gg(AbstractC1982cg abstractC1982cg, HlsPlaylistTracker hlsPlaylistTracker, AbstractC1945bg abstractC1945bg, @Nullable AbstractC2410nk abstractC2410nk, AbstractC2470p6 abstractC2470p6, AbstractC2396n6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, AbstractC2299kk abstractC2299kk, AbstractC1944bf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, AbstractC2637tj abstractC2637tj, C2441oe c2441oe, boolean z, int i, boolean z2) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = abstractC1982cg;
        this.Wwwwwwwwwwwwwwwwwwwwwww = hlsPlaylistTracker;
        this.Wwwwwwwwwwwwwwwwwwwwww = abstractC1945bg;
        this.Wwwwwwwwwwwwwwwwwwwww = abstractC2410nk;
        this.Wwwwwwwwwwwwwwwwwwww = abstractC2470p6;
        this.Wwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwww = abstractC2299kk;
        this.Wwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        this.Wwwwwwwwwwwwwwww = abstractC2637tj;
        this.Wwwwwwwwwwwww = c2441oe;
        this.Wwwwwwwwwwww = z;
        this.Wwwwwwwwwww = i;
        this.Wwwwwwwwww = z2;
        AbstractC2220if[] abstractC2220ifArr = new AbstractC2220if[0];
        if (c2441oe != null) {
            this.Wwww = new C2404ne(abstractC2220ifArr);
            this.Wwwwwwwwwwwwwww = new IdentityHashMap<>();
            this.Wwwwwwwwwwwwww = new C2295kg();
            this.Wwwwww = new C2221ig[0];
            this.Wwwww = new C2221ig[0];
            return;
        }
        throw null;
    }

    @Override // me.tvspark.AbstractC2784xe
    public C2368mf Wwwwwwwwwwwwwwwwwwwwwwwwwww() {
        C2368mf c2368mf = this.Wwwwwww;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2368mf);
        return c2368mf;
    }

    @Override // me.tvspark.AbstractC2784xe
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return -9223372036854775807L;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        C2221ig[] c2221igArr;
        C2221ig[] c2221igArr2;
        int i = this.Wwwwwwww - 1;
        this.Wwwwwwww = i;
        if (i > 0) {
            return;
        }
        int i2 = 0;
        for (C2221ig c2221ig : this.Wwwwww) {
            c2221ig.Wwwwwwwwwwwwwwwwwwwwwwwwww();
            i2 += c2221ig.Kkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwww;
        }
        C2331lf[] c2331lfArr = new C2331lf[i2];
        int i3 = 0;
        for (C2221ig c2221ig2 : this.Wwwwww) {
            c2221ig2.Wwwwwwwwwwwwwwwwwwwwwwwwww();
            int i4 = c2221ig2.Kkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwww;
            int i5 = 0;
            while (i5 < i4) {
                c2221ig2.Wwwwwwwwwwwwwwwwwwwwwwwwww();
                c2331lfArr[i3] = c2221ig2.Kkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwww[i5];
                i5++;
                i3++;
            }
        }
        this.Wwwwwww = new C2368mf(c2331lfArr);
        this.Wwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2784xe) this);
    }

    @Override // me.tvspark.AbstractC2784xe
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() throws IOException {
        C2221ig[] c2221igArr;
        for (C2221ig c2221ig : this.Wwwwww) {
            c2221ig.Wwwwwwwwwwwwwwwwwwwwww();
            if (c2221ig.Kkkk && !c2221ig.Kkkkkkkkkkkkkkkkkkkk) {
                throw new ParserException("Loading finished before preparation is complete.");
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2784xe.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) this);
    }

    @Override // me.tvspark.AbstractC2784xe, me.tvspark.AbstractC2220if
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.AbstractC2784xe
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        C2221ig[] c2221igArr = this.Wwwww;
        if (c2221igArr.length > 0) {
            boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2221igArr[0].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, false);
            int i = 1;
            while (true) {
                C2221ig[] c2221igArr2 = this.Wwwww;
                if (i >= c2221igArr2.length) {
                    break;
                }
                c2221igArr2[i].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                i++;
            }
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                this.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
            }
        }
        return j;
    }

    @Override // me.tvspark.AbstractC2784xe, me.tvspark.AbstractC2220if
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.AbstractC2784xe, me.tvspark.AbstractC2220if
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        this.Wwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j);
    }

    @Override // me.tvspark.AbstractC2784xe
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, C2098f4 c2098f4) {
        return j;
    }

    public final C2221ig Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, Uri[] uriArr, C2245j3[] c2245j3Arr, @Nullable C2245j3 c2245j3, @Nullable List<C2245j3> list, Map<String, C2322l6> map, long j) {
        return new C2221ig(i, this, new C1908ag(this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwww, uriArr, c2245j3Arr, this.Wwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwww, list), map, this.Wwwwwwwwwwwwwwww, j, c2245j3, this.Wwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwww, this.Wwwwwwwwwww);
    }

    @Override // me.tvspark.AbstractC2784xe, me.tvspark.AbstractC2220if
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.AbstractC2784xe, me.tvspark.AbstractC2220if
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        C2221ig[] c2221igArr;
        if (this.Wwwwwww == null) {
            for (C2221ig c2221ig : this.Wwwwww) {
                if (!c2221ig.Kkkkkkkkkkkkkkkkkkkk) {
                    c2221ig.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2221ig.Kkkkkkkk);
                }
            }
            return false;
        }
        return this.Wwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j);
    }

    public static C2245j3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2245j3 c2245j3, @Nullable C2245j3 c2245j32, boolean z) {
        String str;
        C2254jc c2254jc;
        int i;
        int i2;
        int i3;
        String str2;
        String str3;
        int i4 = -1;
        if (c2245j32 != null) {
            str2 = c2245j32.Wwwwwwwwwwwwwwww;
            c2254jc = c2245j32.Wwwwwwwwwwwwwww;
            int i5 = c2245j32.Kkkkkkkkkkkkkkkkkkkkkkkk;
            i2 = c2245j32.Wwwwwwwwwwwwwwwwwwwww;
            int i6 = c2245j32.Wwwwwwwwwwwwwwwwwwww;
            String str4 = c2245j32.Wwwwwwwwwwwwwwwwwwwwww;
            str3 = c2245j32.Wwwwwwwwwwwwwwwwwwwwwww;
            i3 = i5;
            i = i6;
            str = str4;
        } else {
            String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3.Wwwwwwwwwwwwwwww, 1);
            C2254jc c2254jc2 = c2245j3.Wwwwwwwwwwwwwww;
            if (z) {
                int i7 = c2245j3.Kkkkkkkkkkkkkkkkkkkkkkkk;
                int i8 = c2245j3.Wwwwwwwwwwwwwwwwwwwww;
                int i9 = c2245j3.Wwwwwwwwwwwwwwwwwwww;
                str = c2245j3.Wwwwwwwwwwwwwwwwwwwwww;
                str2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                str3 = c2245j3.Wwwwwwwwwwwwwwwwwwwwwww;
                i3 = i7;
                i2 = i8;
                c2254jc = c2254jc2;
                i = i9;
            } else {
                str = null;
                c2254jc = c2254jc2;
                i = 0;
                i2 = 0;
                i3 = -1;
                str2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                str3 = null;
            }
        }
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C1950bl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2);
        int i10 = z ? c2245j3.Wwwwwwwwwwwwwwwwwww : -1;
        if (z) {
            i4 = c2245j3.Wwwwwwwwwwwwwwwwww;
        }
        C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2245j3.Wwwwwwwwwwwwwwwwwwwwwwww;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str3;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwww = c2245j3.Wwwwwwwwwwwwww;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww = str2;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww = c2254jc;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = i10;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = i4;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwww = i3;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
        return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.AbstractC2784xe
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, boolean z) {
        C2221ig[] c2221igArr;
        for (C2221ig c2221ig : this.Wwwww) {
            if (c2221ig.Kkkkkkkkkkkkkkkkkkkkk && !c2221ig.Wwwwwwwwwwwwwwwwwwwwwwww()) {
                int length = c2221ig.Wwww.length;
                for (int i = 0; i < length; i++) {
                    C2221ig.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2221ig.Wwww[i];
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, z, c2221ig.Kkkkkkkkkk[i]));
                }
            }
        }
    }

    @Override // me.tvspark.AbstractC2220if.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2221ig c2221ig) {
        this.Wwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2784xe.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) this);
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Uri uri, long j) {
        boolean z;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        boolean z2 = true;
        for (C2221ig c2221ig : this.Wwwwww) {
            C1908ag c1908ag = c2221ig.Wwwwwwwwwwwwwwwwwwwwww;
            int i = 0;
            while (true) {
                Uri[] uriArr = c1908ag.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (i >= uriArr.length) {
                    i = -1;
                    break;
                } else if (uriArr[i].equals(uri)) {
                    break;
                } else {
                    i++;
                }
            }
            if (i != -1 && (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c1908ag.Wwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i)) != -1) {
                c1908ag.Wwwwwwwwwwwwwwwww |= uri.equals(c1908ag.Wwwwwwwwwwwwwwwwwwwww);
                if (j != -9223372036854775807L && !c1908ag.Wwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, j)) {
                    z = false;
                    z2 &= z;
                }
            }
            z = true;
            z2 &= z;
        }
        this.Wwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2784xe.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) this);
        return z2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0188  */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v53, types: [java.util.HashMap] */
    @Override // me.tvspark.AbstractC2784xe
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2784xe.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, long j) {
        ?? emptyMap;
        Map<String, C2322l6> map;
        List<C2523qg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> list;
        List<C2523qg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> list2;
        ArrayList arrayList;
        ArrayList arrayList2;
        int i;
        List<C2523qg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> list3;
        boolean z;
        int i2;
        boolean z2;
        int i3;
        String str;
        C2221ig Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        boolean z3;
        int i4;
        ArrayList arrayList3;
        String str2;
        this.Wwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        ((C2443og) this.Wwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwww.add(this);
        C2523qg c2523qg = ((C2443og) this.Wwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwww;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2523qg);
        if (this.Wwwwwwwwww) {
            List<C2322l6> list4 = c2523qg.Wwwwwwwwwwwwwwwwwwwwwwww;
            ArrayList arrayList4 = new ArrayList(list4);
            emptyMap = new HashMap();
            int i5 = 0;
            while (i5 < arrayList4.size()) {
                C2322l6 c2322l6 = list4.get(i5);
                String str3 = c2322l6.Wwwwwwwwwwwwwwwwwwwwww;
                i5++;
                int i6 = i5;
                while (i6 < arrayList4.size()) {
                    C2322l6 c2322l62 = (C2322l6) arrayList4.get(i6);
                    if (TextUtils.equals(c2322l62.Wwwwwwwwwwwwwwwwwwwwww, str3)) {
                        String str4 = c2322l6.Wwwwwwwwwwwwwwwwwwwwww;
                        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str4 == null || (str2 = c2322l62.Wwwwwwwwwwwwwwwwwwwwww) == null || TextUtils.equals(str4, str2));
                        String str5 = c2322l6.Wwwwwwwwwwwwwwwwwwwwww;
                        if (str5 == null) {
                            str5 = c2322l62.Wwwwwwwwwwwwwwwwwwwwww;
                        }
                        C2322l6 c2322l63 = new C2322l6(str5, true, (C2322l6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[]) C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object[]) c2322l6.Wwwwwwwwwwwwwwwwwwwwwwww, (Object[]) c2322l62.Wwwwwwwwwwwwwwwwwwwwwwww));
                        arrayList4.remove(i6);
                        c2322l6 = c2322l63;
                    } else {
                        i6++;
                    }
                }
                emptyMap.put(str3, c2322l6);
            }
        } else {
            emptyMap = Collections.emptyMap();
        }
        Map<String, C2322l6> map2 = emptyMap;
        boolean z4 = !c2523qg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isEmpty();
        List<C2523qg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> list5 = c2523qg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        List<C2523qg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> list6 = c2523qg.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwww = 0;
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        if (z4) {
            int size = c2523qg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size();
            int[] iArr = new int[size];
            int i7 = 0;
            int i8 = 0;
            for (int i9 = 0; i9 < c2523qg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size(); i9++) {
                C2245j3 c2245j3 = c2523qg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i9).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (c2245j3.Wwwwwww > 0 || C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3.Wwwwwwwwwwwwwwww, 2) != null) {
                    iArr[i9] = 2;
                    i7++;
                } else if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3.Wwwwwwwwwwwwwwww, 1) != null) {
                    iArr[i9] = 1;
                    i8++;
                } else {
                    iArr[i9] = -1;
                }
            }
            if (i7 > 0) {
                z = true;
            } else if (i8 < size) {
                i2 = size - i8;
                z = false;
                z2 = true;
                Uri[] uriArr = new Uri[i2];
                C2245j3[] c2245j3Arr = new C2245j3[i2];
                int[] iArr2 = new int[i2];
                i3 = 0;
                int i10 = 0;
                while (i3 < c2523qg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size()) {
                    if (z) {
                        arrayList3 = arrayList5;
                        if (iArr[i3] != 2) {
                            i3++;
                            arrayList5 = arrayList3;
                        }
                    } else {
                        arrayList3 = arrayList5;
                    }
                    if (!z2 || iArr[i3] != 1) {
                        C2523qg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2523qg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i3);
                        uriArr[i10] = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        c2245j3Arr[i10] = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        iArr2[i10] = i3;
                        i10++;
                    }
                    i3++;
                    arrayList5 = arrayList3;
                }
                str = c2245j3Arr[0].Wwwwwwwwwwwwwwww;
                list = list5;
                list2 = list6;
                arrayList = arrayList5;
                map = map2;
                arrayList2 = arrayList6;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, uriArr, c2245j3Arr, c2523qg.Wwwwwwwwwwwwwwwwwwwwwwwwwww, c2523qg.Wwwwwwwwwwwwwwwwwwwwwwwwww, map2, j);
                arrayList.add(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                arrayList2.add(iArr2);
                if (this.Wwwwwwwwwwww && str != null) {
                    z3 = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, 2) == null;
                    boolean z5 = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, 1) == null;
                    ArrayList arrayList7 = new ArrayList();
                    if (!z3) {
                        C2245j3[] c2245j3Arr2 = new C2245j3[i2];
                        for (int i11 = 0; i11 < i2; i11++) {
                            C2245j3 c2245j32 = c2245j3Arr[i11];
                            String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j32.Wwwwwwwwwwwwwwww, 2);
                            String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C1950bl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                            C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = new C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2245j32.Wwwwwwwwwwwwwwwwwwwwwwww;
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2245j32.Wwwwwwwwwwwwwwwwwwwwwww;
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwww = c2245j32.Wwwwwwwwwwwwww;
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwww = c2245j32.Wwwwwwwwwwwwwww;
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2245j32.Wwwwwwwwwwwwwwwwwww;
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = c2245j32.Wwwwwwwwwwwwwwwwww;
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwww = c2245j32.Wwwwwwww;
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwww = c2245j32.Wwwwwww;
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwww = c2245j32.Wwwwww;
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2245j32.Wwwwwwwwwwwwwwwwwwwww;
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2245j32.Wwwwwwwwwwwwwwwwwwww;
                            c2245j3Arr2[i11] = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        }
                        arrayList7.add(new C2331lf(c2245j3Arr2));
                        if (z5 && (c2523qg.Wwwwwwwwwwwwwwwwwwwwwwwwwww != null || c2523qg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.isEmpty())) {
                            arrayList7.add(new C2331lf(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3Arr[0], c2523qg.Wwwwwwwwwwwwwwwwwwwwwwwwwww, false)));
                        }
                        List<C2245j3> list7 = c2523qg.Wwwwwwwwwwwwwwwwwwwwwwwwww;
                        if (list7 != null) {
                            for (int i12 = 0; i12 < list7.size(); i12++) {
                                arrayList7.add(new C2331lf(list7.get(i12)));
                            }
                        }
                        i4 = 1;
                    } else if (!z5) {
                        throw new IllegalArgumentException(str.length() != 0 ? "Unexpected codecs attribute: ".concat(str) : new String("Unexpected codecs attribute: "));
                    } else {
                        C2245j3[] c2245j3Arr3 = new C2245j3[i2];
                        for (int i13 = 0; i13 < i2; i13++) {
                            c2245j3Arr3[i13] = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3Arr[i13], c2523qg.Wwwwwwwwwwwwwwwwwwwwwwwwwww, true);
                        }
                        i4 = 1;
                        arrayList7.add(new C2331lf(c2245j3Arr3));
                    }
                    C2245j3[] c2245j3Arr4 = new C2245j3[i4];
                    C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = new C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = "ID3";
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwww = "application/id3";
                    c2245j3Arr4[0] = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    C2331lf c2331lf = new C2331lf(c2245j3Arr4);
                    arrayList7.add(c2331lf);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((C2331lf[]) arrayList7.toArray(new C2331lf[0]), 0, arrayList7.indexOf(c2331lf));
                }
            } else {
                i7 = size;
                z = false;
            }
            i2 = i7;
            z2 = false;
            Uri[] uriArr2 = new Uri[i2];
            C2245j3[] c2245j3Arr5 = new C2245j3[i2];
            int[] iArr22 = new int[i2];
            i3 = 0;
            int i102 = 0;
            while (i3 < c2523qg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size()) {
            }
            str = c2245j3Arr5[0].Wwwwwwwwwwwwwwww;
            list = list5;
            list2 = list6;
            arrayList = arrayList5;
            map = map2;
            arrayList2 = arrayList6;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, uriArr2, c2245j3Arr5, c2523qg.Wwwwwwwwwwwwwwwwwwwwwwwwwww, c2523qg.Wwwwwwwwwwwwwwwwwwwwwwwwww, map2, j);
            arrayList.add(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            arrayList2.add(iArr22);
            if (this.Wwwwwwwwwwww) {
                if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, 2) == null) {
                }
                if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, 1) == null) {
                }
                ArrayList arrayList72 = new ArrayList();
                if (!z3) {
                }
                C2245j3[] c2245j3Arr42 = new C2245j3[i4];
                C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww32 = new C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww32.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = "ID3";
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww32.Wwwwwwwwwwwwwwwwwwwwwwww = "application/id3";
                c2245j3Arr42[0] = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww32.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                C2331lf c2331lf2 = new C2331lf(c2245j3Arr42);
                arrayList72.add(c2331lf2);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((C2331lf[]) arrayList72.toArray(new C2331lf[0]), 0, arrayList72.indexOf(c2331lf2));
            }
        } else {
            map = map2;
            list = list5;
            list2 = list6;
            arrayList = arrayList5;
            arrayList2 = arrayList6;
        }
        ArrayList arrayList8 = new ArrayList(list.size());
        ArrayList arrayList9 = new ArrayList(list.size());
        ArrayList arrayList10 = new ArrayList(list.size());
        HashSet hashSet = new HashSet();
        int i14 = 0;
        while (i14 < list.size()) {
            List<C2523qg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> list8 = list;
            String str6 = list8.get(i14).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (!hashSet.add(str6)) {
                i = i14;
                list3 = list8;
            } else {
                arrayList8.clear();
                arrayList9.clear();
                arrayList10.clear();
                boolean z6 = true;
                for (int i15 = 0; i15 < list8.size(); i15++) {
                    if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) str6, (Object) list8.get(i15).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                        C2523qg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = list8.get(i15);
                        arrayList10.add(Integer.valueOf(i15));
                        arrayList8.add(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        arrayList9.add(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        z6 &= wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwww != null;
                    }
                }
                Uri[] uriArr3 = new Uri[0];
                C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object[]) uriArr3);
                i = i14;
                list3 = list8;
                C2221ig Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1, (Uri[]) arrayList8.toArray(uriArr3), (C2245j3[]) arrayList9.toArray(new C2245j3[0]), null, Collections.emptyList(), map, j);
                arrayList2.add(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Collection<? extends Number>) arrayList10));
                arrayList.add(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
                if (this.Wwwwwwwwwwww && z6) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new C2331lf[]{new C2331lf((C2245j3[]) arrayList9.toArray(new C2245j3[0]))}, 0, new int[0]);
                }
            }
            i14 = i + 1;
            list = list3;
        }
        for (int i16 = 0; i16 < list2.size(); i16++) {
            C2523qg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = list2.get(i16);
            C2221ig Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3, new Uri[]{wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww}, new C2245j3[]{wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww}, null, Collections.emptyList(), map, j);
            arrayList2.add(new int[]{i16});
            arrayList.add(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new C2331lf[]{new C2331lf(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)}, 0, new int[0]);
        }
        this.Wwwwww = (C2221ig[]) arrayList.toArray(new C2221ig[0]);
        int[][] iArr3 = (int[][]) arrayList2.toArray(new int[0]);
        C2221ig[] c2221igArr = this.Wwwwww;
        this.Wwwwwwww = c2221igArr.length;
        c2221igArr[0].Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww = true;
        for (C2221ig c2221ig : c2221igArr) {
            if (!c2221ig.Kkkkkkkkkkkkkkkkkkkk) {
                c2221ig.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2221ig.Kkkkkkkk);
            }
        }
        this.Wwwww = this.Wwwwww;
    }

    /* JADX WARN: Removed duplicated region for block: B:163:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x025d  */
    @Override // me.tvspark.AbstractC2784xe
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC1985cj[] abstractC1985cjArr, boolean[] zArr, AbstractC2183hf[] abstractC2183hfArr, boolean[] zArr2, long j) {
        int i;
        AbstractC1985cj[] abstractC1985cjArr2;
        C2221ig c2221ig;
        int[] iArr;
        int i2;
        C2221ig[] c2221igArr;
        int i3;
        int i4;
        AbstractC2183hf[] abstractC2183hfArr2;
        AbstractC2183hf[] abstractC2183hfArr3;
        boolean z;
        boolean z2;
        boolean z3;
        AbstractC2183hf[] abstractC2183hfArr4;
        int i5;
        AbstractC2183hf[] abstractC2183hfArr5;
        C2147gg c2147gg = this;
        AbstractC2183hf[] abstractC2183hfArr6 = abstractC2183hfArr;
        int[] iArr2 = new int[abstractC1985cjArr.length];
        int[] iArr3 = new int[abstractC1985cjArr.length];
        for (int i6 = 0; i6 < abstractC1985cjArr.length; i6++) {
            iArr2[i6] = abstractC2183hfArr6[i6] == null ? -1 : c2147gg.Wwwwwwwwwwwwwww.get(abstractC2183hfArr6[i6]).intValue();
            iArr3[i6] = -1;
            if (abstractC1985cjArr[i6] != null) {
                C2331lf Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC1985cjArr[i6].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                int i7 = 0;
                while (true) {
                    C2221ig[] c2221igArr2 = c2147gg.Wwwwww;
                    if (i7 < c2221igArr2.length) {
                        C2221ig c2221ig2 = c2221igArr2[i7];
                        c2221ig2.Wwwwwwwwwwwwwwwwwwwwwwwwww();
                        if (c2221ig2.Kkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) != -1) {
                            iArr3[i6] = i7;
                            break;
                        }
                        i7++;
                    }
                }
            }
        }
        c2147gg.Wwwwwwwwwwwwwww.clear();
        int length = abstractC1985cjArr.length;
        AbstractC2183hf[] abstractC2183hfArr7 = new AbstractC2183hf[length];
        int length2 = abstractC1985cjArr.length;
        AbstractC2183hf[] abstractC2183hfArr8 = new AbstractC2183hf[length2];
        int length3 = abstractC1985cjArr.length;
        AbstractC1985cj[] abstractC1985cjArr3 = new AbstractC1985cj[length3];
        C2221ig[] c2221igArr3 = new C2221ig[c2147gg.Wwwwww.length];
        int i8 = length;
        int i9 = 0;
        int i10 = 0;
        boolean z4 = false;
        while (i9 < c2147gg.Wwwwww.length) {
            for (int i11 = 0; i11 < abstractC1985cjArr.length; i11++) {
                abstractC2183hfArr8[i11] = iArr2[i11] == i9 ? abstractC2183hfArr6[i11] : null;
                abstractC1985cjArr3[i11] = iArr3[i11] == i9 ? abstractC1985cjArr[i11] : null;
            }
            C2221ig c2221ig3 = c2147gg.Wwwwww[i9];
            c2221ig3.Wwwwwwwwwwwwwwwwwwwwwwwwww();
            int i12 = c2221ig3.Kkkkkkkkkkkkkkkkkkk;
            C2221ig[] c2221igArr4 = c2221igArr3;
            int i13 = 0;
            while (i13 < length3) {
                int i14 = length2;
                C2184hg c2184hg = (C2184hg) abstractC2183hfArr8[i13];
                if (c2184hg == null || (abstractC1985cjArr3[i13] != null && zArr[i13])) {
                    i5 = i9;
                    abstractC2183hfArr5 = abstractC2183hfArr7;
                } else {
                    i5 = i9;
                    abstractC2183hfArr5 = abstractC2183hfArr7;
                    c2221ig3.Kkkkkkkkkkkkkkkkkkk--;
                    if (c2184hg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != -1) {
                        C2221ig c2221ig4 = c2184hg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        int i15 = c2184hg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        c2221ig4.Wwwwwwwwwwwwwwwwwwwwwwwwww();
                        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2221ig4.Kkkkkkkkkkkkk);
                        int i16 = c2221ig4.Kkkkkkkkkkkkk[i15];
                        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2221ig4.Kkkkkkkkkk[i16]);
                        c2221ig4.Kkkkkkkkkk[i16] = false;
                        c2184hg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -1;
                    }
                    abstractC2183hfArr8[i13] = null;
                }
                i13++;
                i9 = i5;
                length2 = i14;
                abstractC2183hfArr7 = abstractC2183hfArr5;
            }
            int i17 = length2;
            int i18 = i9;
            AbstractC2183hf[] abstractC2183hfArr9 = abstractC2183hfArr7;
            boolean z5 = z4 || (!c2221ig3.Kkkkk ? j != c2221ig3.Kkkkkkkk : i12 == 0);
            AbstractC1985cj abstractC1985cj = c2221ig3.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww;
            boolean z6 = z5;
            AbstractC1985cj abstractC1985cj2 = abstractC1985cj;
            for (int i19 = 0; i19 < length3; i19++) {
                AbstractC1985cj abstractC1985cj3 = abstractC1985cjArr3[i19];
                if (abstractC1985cj3 != null) {
                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2221ig3.Kkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC1985cj3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == c2221ig3.Kkkkkkkkkkkk) {
                        c2221ig3.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww = abstractC1985cj3;
                        abstractC1985cj2 = abstractC1985cj3;
                    }
                    if (abstractC2183hfArr8[i19] == null) {
                        c2221ig3.Kkkkkkkkkkkkkkkkkkk++;
                        abstractC2183hfArr8[i19] = new C2184hg(c2221ig3, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                        zArr2[i19] = true;
                        if (c2221ig3.Kkkkkkkkkkkkk != null) {
                            ((C2184hg) abstractC2183hfArr8[i19]).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                            if (!z6) {
                                C2221ig.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2221ig3.Wwww[c2221ig3.Kkkkkkkkkkkkk[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2]];
                                z6 = !wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, true) && wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() != 0;
                            }
                        }
                    }
                }
            }
            if (c2221ig3.Kkkkkkkkkkkkkkkkkkk == 0) {
                c2221ig3.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww = null;
                c2221ig3.Kkkkkkkkkkkkkkkkk = null;
                c2221ig3.Kkkkkk = true;
                c2221ig3.Wwwwwwwwwwww.clear();
                if (c2221ig3.Wwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                    if (c2221ig3.Kkkkkkkkkkkkkkkkkkkkk) {
                        for (C2221ig.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 : c2221ig3.Wwww) {
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        }
                    }
                    c2221ig3.Wwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                } else {
                    c2221ig3.Wwwwwwwwwwwwwwwwwwww();
                }
                i = length3;
                abstractC1985cjArr2 = abstractC1985cjArr3;
                c2221ig = c2221ig3;
                iArr = iArr2;
                i2 = i8;
                c2221igArr = c2221igArr4;
                i3 = i18;
                i4 = i17;
                abstractC2183hfArr2 = abstractC2183hfArr9;
                abstractC2183hfArr3 = abstractC2183hfArr8;
            } else {
                if (c2221ig3.Wwwwwwwwwwww.isEmpty() || C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC1985cj2, abstractC1985cj)) {
                    i = length3;
                    abstractC1985cjArr2 = abstractC1985cjArr3;
                    c2221ig = c2221ig3;
                    iArr = iArr2;
                    i2 = i8;
                    c2221igArr = c2221igArr4;
                    i3 = i18;
                    i4 = i17;
                    abstractC2183hfArr2 = abstractC2183hfArr9;
                    abstractC2183hfArr3 = abstractC2183hfArr8;
                } else {
                    if (!c2221ig3.Kkkkk) {
                        long j2 = 0;
                        if (j < 0) {
                            j2 = -j;
                        }
                        C2073eg Wwwwwwwwwwwwwwwwwwwwwwwww = c2221ig3.Wwwwwwwwwwwwwwwwwwwwwwwww();
                        i = length3;
                        abstractC1985cjArr2 = abstractC1985cjArr3;
                        c2221igArr = c2221igArr4;
                        iArr = iArr2;
                        i4 = i17;
                        abstractC2183hfArr3 = abstractC2183hfArr8;
                        i2 = i8;
                        i3 = i18;
                        abstractC2183hfArr2 = abstractC2183hfArr9;
                        c2221ig = c2221ig3;
                        abstractC1985cj2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, j2, -9223372036854775807L, c2221ig3.Wwwwwwwwwww, c2221ig3.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwww, j));
                        if (abstractC1985cj2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == c2221ig.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                            z3 = false;
                            if (z3) {
                                c2221ig.Kkkkkk = true;
                                z = true;
                                z2 = true;
                                if (z2) {
                                    c2221ig.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, z);
                                    for (int i20 = 0; i20 < i4; i20++) {
                                        if (abstractC2183hfArr3[i20] != null) {
                                            zArr2[i20] = true;
                                        }
                                    }
                                }
                                z6 = z2;
                            }
                        }
                    } else {
                        i = length3;
                        abstractC1985cjArr2 = abstractC1985cjArr3;
                        c2221ig = c2221ig3;
                        iArr = iArr2;
                        i2 = i8;
                        c2221igArr = c2221igArr4;
                        i3 = i18;
                        i4 = i17;
                        abstractC2183hfArr2 = abstractC2183hfArr9;
                        abstractC2183hfArr3 = abstractC2183hfArr8;
                    }
                    z3 = true;
                    if (z3) {
                    }
                }
                z = z4;
                z2 = z6;
                if (z2) {
                }
                z6 = z2;
            }
            c2221ig.Wwwwwww.clear();
            for (int i21 = 0; i21 < i4; i21++) {
                AbstractC2183hf abstractC2183hf = abstractC2183hfArr3[i21];
                if (abstractC2183hf != null) {
                    c2221ig.Wwwwwww.add((C2184hg) abstractC2183hf);
                }
            }
            c2221ig.Kkkkk = true;
            boolean z7 = false;
            int i22 = 0;
            while (i22 < abstractC1985cjArr.length) {
                AbstractC2183hf abstractC2183hf2 = abstractC2183hfArr3[i22];
                int i23 = i3;
                if (iArr3[i22] == i23) {
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2183hf2);
                    abstractC2183hfArr4 = abstractC2183hfArr2;
                    abstractC2183hfArr4[i22] = abstractC2183hf2;
                    this.Wwwwwwwwwwwwwww.put(abstractC2183hf2, Integer.valueOf(i23));
                    z7 = true;
                } else {
                    abstractC2183hfArr4 = abstractC2183hfArr2;
                    if (iArr[i22] == i23) {
                        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2183hf2 == null);
                    }
                }
                i22++;
                abstractC2183hfArr2 = abstractC2183hfArr4;
                i3 = i23;
            }
            AbstractC2183hf[] abstractC2183hfArr10 = abstractC2183hfArr2;
            int i24 = i3;
            if (z7) {
                int i25 = i10;
                c2221igArr[i25] = c2221ig;
                i10 = i25 + 1;
                if (i25 == 0) {
                    c2221ig.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww = true;
                    if (!z6) {
                        C2221ig[] c2221igArr5 = this.Wwwww;
                        if (c2221igArr5.length != 0) {
                            if (c2221ig == c2221igArr5[0]) {
                            }
                            this.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
                            z4 = true;
                        }
                    }
                    this.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
                    z4 = true;
                } else {
                    c2221ig.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww = false;
                }
            }
            i9 = i24 + 1;
            c2147gg = this;
            abstractC2183hfArr7 = abstractC2183hfArr10;
            abstractC2183hfArr8 = abstractC2183hfArr3;
            length3 = i;
            abstractC1985cjArr3 = abstractC1985cjArr2;
            c2221igArr3 = c2221igArr;
            iArr2 = iArr;
            i8 = i2;
            length2 = i4;
            abstractC2183hfArr6 = abstractC2183hfArr;
        }
        C2147gg c2147gg2 = c2147gg;
        System.arraycopy(abstractC2183hfArr7, 0, abstractC2183hfArr6, 0, i8);
        C2221ig[] c2221igArr6 = (C2221ig[]) C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2221igArr3, i10);
        c2147gg2.Wwwww = c2221igArr6;
        if (c2147gg2.Wwwwwwwwwwwww != null) {
            c2147gg2.Wwww = new C2404ne(c2221igArr6);
            return j;
        }
        throw null;
    }
}
