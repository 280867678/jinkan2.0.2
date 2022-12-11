package me.tvspark;

import android.net.Uri;
import android.os.Handler;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.upstream.Loader;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import me.tvspark.AbstractC1944bf;
import me.tvspark.AbstractC2299kk;
import me.tvspark.AbstractC2396n6;
import me.tvspark.AbstractC2625t7;
import me.tvspark.AbstractC2784xe;
import me.tvspark.C2146gf;
import me.tvspark.C2245j3;
import me.tvspark.C2254jc;
import me.tvspark.C2595se;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* renamed from: me.tvspark.df */
/* loaded from: classes4.dex */
public final class C2035df implements AbstractC2784xe, AbstractC2249j7, Loader.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww>, Loader.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, C2146gf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    public static final C2245j3 Kkkkkkkkk;
    public static final Map<String, String> Kkkkkkkkkk;
    public boolean Kkkkkkkkkkk;
    public boolean Kkkkkkkkkkkk;
    public int Kkkkkkkkkkkkk;
    public boolean Kkkkkkkkkkkkkk;
    public long Kkkkkkkkkkkkkkkk;
    public int Kkkkkkkkkkkkkkkkkk;
    public boolean Kkkkkkkkkkkkkkkkkkk;
    public boolean Kkkkkkkkkkkkkkkkkkkk;
    public boolean Kkkkkkkkkkkkkkkkkkkkkk;
    public AbstractC2625t7 Kkkkkkkkkkkkkkkkkkkkkkkk;
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww Kkkkkkkkkkkkkkkkkkkkkkkkk;
    public boolean Kkkkkkkkkkkkkkkkkkkkkkkkkk;
    public boolean Www;
    public boolean Wwww;
    @Nullable
    public C2856zc Wwwwwww;
    @Nullable
    public AbstractC2784xe.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwww;
    public final C2293ke Wwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwww;
    @Nullable
    public final String Wwwwwwwwwwwwwwww;
    public final AbstractC2637tj Wwwwwwwwwwwwwwwww;
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwww;
    public final AbstractC2396n6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwww;
    public final AbstractC1944bf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwww;
    public final AbstractC2299kk Wwwwwwwwwwwwwwwwwwwww;
    public final AbstractC2470p6 Wwwwwwwwwwwwwwwwwwwwww;
    public final AbstractC2863zj Wwwwwwwwwwwwwwwwwwwwwww;
    public final Uri Wwwwwwwwwwwwwwwwwwwwwwww;
    public final Loader Wwwwwwwwwwwwww = new Loader("Loader:ProgressiveMediaPeriod");
    public final C2675uk Wwwwwwwwwwww = new C2675uk();
    public final Runnable Wwwwwwwwwww = new Runnable() { // from class: me.tvspark.ae
        @Override // java.lang.Runnable
        public final void run() {
            C2035df.this.Wwwwwwwwwwwwwwwwwwwww();
        }
    };
    public final Runnable Wwwwwwwwww = new Runnable() { // from class: me.tvspark.he
        @Override // java.lang.Runnable
        public final void run() {
            C2035df.this.Wwwwwwwwwwwwwwwwwwwwww();
        }
    };
    public final Handler Wwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[] Wwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[0];
    public C2146gf[] Wwwwww = new C2146gf[0];
    public long Kkkkkkkkkkkkkkk = -9223372036854775807L;
    public long Kkkkkkkkkkkkkkkkk = -1;
    public long Kkkkkkkkkkkkkkkkkkkkkkk = -9223372036854775807L;
    public int Kkkkkkkkkkkkkkkkkkkkk = 1;

    /* renamed from: me.tvspark.df$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final boolean[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final boolean[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final boolean[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final C2368mf Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2368mf c2368mf, boolean[] zArr) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2368mf;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = zArr;
            int i = c2368mf.Wwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new boolean[i];
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new boolean[i];
        }
    }

    /* renamed from: me.tvspark.df$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, boolean z) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.class != obj.getClass()) {
                return false;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) obj;
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        public int hashCode() {
            return (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww * 31) + (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww ? 1 : 0);
        }
    }

    /* renamed from: me.tvspark.df$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("Icy-MetaData", "1");
        Kkkkkkkkkk = Collections.unmodifiableMap(hashMap);
        C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = "icy";
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww = "application/x-icy";
        Kkkkkkkkk = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public C2035df(Uri uri, AbstractC2863zj abstractC2863zj, AbstractC2323l7 abstractC2323l7, AbstractC2470p6 abstractC2470p6, AbstractC2396n6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, AbstractC2299kk abstractC2299kk, AbstractC1944bf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, AbstractC2637tj abstractC2637tj, @Nullable String str, int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = uri;
        this.Wwwwwwwwwwwwwwwwwwwwwww = abstractC2863zj;
        this.Wwwwwwwwwwwwwwwwwwwwww = abstractC2470p6;
        this.Wwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwww = abstractC2299kk;
        this.Wwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        this.Wwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwww = abstractC2637tj;
        this.Wwwwwwwwwwwwwwww = str;
        this.Wwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwww = new C2293ke(abstractC2323l7);
    }

    public final boolean Wwwwwwwwwwwwwwwwwww() {
        return this.Kkkkkkkkkkkkkkkkkkk || Wwwwwwwwwwwwwwwwwwwwwww();
    }

    public final void Wwwwwwwwwwwwwwwwwwww() {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwww, this, this.Wwwwwwwwwwww);
        if (this.Www) {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwww());
            long j = this.Kkkkkkkkkkkkkkkkkkkkkkk;
            if (j != -9223372036854775807L && this.Kkkkkkkkkkkkkkk > j) {
                this.Kkkkkkkkkkkk = true;
                this.Kkkkkkkkkkkkkkk = -9223372036854775807L;
                return;
            }
            AbstractC2625t7 abstractC2625t7 = this.Kkkkkkkkkkkkkkkkkkkkkkkk;
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2625t7);
            long j2 = abstractC2625t7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkkkkkkk).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            long j3 = this.Kkkkkkkkkkkkkkk;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j2;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwww = j3;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww = true;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww = false;
            for (C2146gf c2146gf : this.Wwwwww) {
                c2146gf.Wwwwwwwwwwwwww = this.Kkkkkkkkkkkkkkk;
            }
            this.Kkkkkkkkkkkkkkk = -9223372036854775807L;
        }
        this.Kkkkkkkkkkkkk = Wwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new C2632te(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this, ((C2225ik) this.Wwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkkkkkkkkkkkkk))), 1, -1, null, 0, null, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwww, this.Kkkkkkkkkkkkkkkkkkkkkkk);
    }

    public final void Wwwwwwwwwwwwwwwwwwwww() {
        if (this.Kkkkkkkkkkk || this.Www || !this.Wwww || this.Kkkkkkkkkkkkkkkkkkkkkkkk == null) {
            return;
        }
        for (C2146gf c2146gf : this.Wwwwww) {
            if (c2146gf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() == null) {
                return;
            }
        }
        this.Wwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        int length = this.Wwwwww.length;
        C2331lf[] c2331lfArr = new C2331lf[length];
        boolean[] zArr = new boolean[length];
        for (int i = 0; i < length; i++) {
            C2245j3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwww[i].Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            String str = Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwww;
            boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwww = C1950bl.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
            boolean z = Wwwwwwwwwwwwwwwwwwwwwwwwwwww || C1950bl.Wwwwwwwwwwwwwwwwwwwwwwwwww(str);
            zArr[i] = z;
            this.Kkkkkkkkkkkkkkkkkkkkkkkkkk = z | this.Kkkkkkkkkkkkkkkkkkkkkkkkkk;
            C2856zc c2856zc = this.Wwwwwww;
            if (c2856zc != null) {
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwww || this.Wwwww[i].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    C2254jc c2254jc = Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwww;
                    C2254jc c2254jc2 = c2254jc == null ? new C2254jc(c2856zc) : new C2254jc((C2254jc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[]) C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object[]) c2254jc.Wwwwwwwwwwwwwwwwwwwwwwww, (Object[]) new C2254jc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[]{c2856zc}));
                    C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwww = c2254jc2;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                }
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwww && Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww == -1 && Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww == -1 && c2856zc.Wwwwwwwwwwwwwwwwwwwwwwww != -1) {
                    C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2856zc.Wwwwwwwwwwwwwwwwwwwwwwww;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                }
            }
            c2331lfArr[i] = new C2331lf(Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwww)));
        }
        this.Kkkkkkkkkkkkkkkkkkkkkkkkk = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new C2368mf(c2331lfArr), zArr);
        this.Www = true;
        AbstractC2784xe.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwww;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2784xe) this);
    }

    public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwww() {
        if (!this.Kkkkkkkkkkk) {
            AbstractC2784xe.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwww;
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2784xe.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) this);
        }
    }

    public final boolean Wwwwwwwwwwwwwwwwwwwwwww() {
        return this.Kkkkkkkkkkkkkkk != -9223372036854775807L;
    }

    public final long Wwwwwwwwwwwwwwwwwwwwwwww() {
        long j = Long.MIN_VALUE;
        for (C2146gf c2146gf : this.Wwwwww) {
            j = Math.max(j, c2146gf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        }
        return j;
    }

    public final int Wwwwwwwwwwwwwwwwwwwwwwwww() {
        int i = 0;
        for (C2146gf c2146gf : this.Wwwwww) {
            i += c2146gf.Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        return i;
    }

    @EnsuresNonNull({"trackState", "seekMap"})
    public final void Wwwwwwwwwwwwwwwwwwwwwwwwww() {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Www);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkkkkkkkkkkkkkkkkk);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkkkkkkkkkkkkkkkk);
    }

    @Override // me.tvspark.AbstractC2784xe
    public C2368mf Wwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Wwwwwwwwwwwwwwwwwwwwwwwwww();
        return this.Kkkkkkkkkkkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.AbstractC2784xe
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (this.Kkkkkkkkkkkkkkkkkkk) {
            if (!this.Kkkkkkkkkkkk && Wwwwwwwwwwwwwwwwwwwwwwwww() <= this.Kkkkkkkkkkkkk) {
                return -9223372036854775807L;
            }
            this.Kkkkkkkkkkkkkkkkkkk = false;
            return this.Kkkkkkkkkkkkkkkk;
        }
        return -9223372036854775807L;
    }

    @Override // me.tvspark.AbstractC2249j7
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwww = true;
        this.Wwwwwwwww.post(this.Wwwwwwwwwww);
    }

    @Override // me.tvspark.AbstractC2784xe
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() throws IOException {
        this.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((C2225ik) this.Wwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkkkkkkkkkkkkk));
        if (!this.Kkkkkkkkkkkk || this.Www) {
            return;
        }
        throw new ParserException("Loading finished before preparation is complete.");
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        C2146gf[] c2146gfArr;
        for (C2146gf c2146gf : this.Wwwwww) {
            c2146gf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true);
            DrmSession drmSession = c2146gf.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (drmSession != null) {
                drmSession.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2146gf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                c2146gf.Wwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                c2146gf.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            }
        }
        C2293ke c2293ke = this.Wwwwwwwwwwwww;
        AbstractC2175h7 abstractC2175h7 = c2293ke.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (abstractC2175h7 != null) {
            abstractC2175h7.release();
            c2293ke.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        }
        c2293ke.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
    }

    @Override // me.tvspark.AbstractC2784xe, me.tvspark.AbstractC2220if
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        long j;
        Wwwwwwwwwwwwwwwwwwwwwwwwww();
        boolean[] zArr = this.Kkkkkkkkkkkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (this.Kkkkkkkkkkkk) {
            return Long.MIN_VALUE;
        }
        if (Wwwwwwwwwwwwwwwwwwwwwww()) {
            return this.Kkkkkkkkkkkkkkk;
        }
        if (this.Kkkkkkkkkkkkkkkkkkkkkkkkkk) {
            int length = this.Wwwwww.length;
            j = Long.MAX_VALUE;
            for (int i = 0; i < length; i++) {
                if (zArr[i] && !this.Wwwwww[i].Wwwwwwwwwwwwwwwwwwwwwwwwww()) {
                    j = Math.min(j, this.Wwwwww[i].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                }
            }
        } else {
            j = Long.MAX_VALUE;
        }
        if (j == Long.MAX_VALUE) {
            j = Wwwwwwwwwwwwwwwwwwwwwwww();
        }
        return j == Long.MIN_VALUE ? this.Kkkkkkkkkkkkkkkk : j;
    }

    @Override // me.tvspark.AbstractC2784xe
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        boolean z;
        Wwwwwwwwwwwwwwwwwwwwwwwwww();
        boolean[] zArr = this.Kkkkkkkkkkkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (!this.Kkkkkkkkkkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            j = 0;
        }
        this.Kkkkkkkkkkkkkkkkkkk = false;
        this.Kkkkkkkkkkkkkkkk = j;
        if (Wwwwwwwwwwwwwwwwwwwwwww()) {
            this.Kkkkkkkkkkkkkkk = j;
            return j;
        }
        if (this.Kkkkkkkkkkkkkkkkkkkkk != 7) {
            int length = this.Wwwwww.length;
            for (int i = 0; i < length; i++) {
                if (!this.Wwwwww[i].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, false) && (zArr[i] || !this.Kkkkkkkkkkkkkkkkkkkkkkkkkk)) {
                    z = false;
                    break;
                }
            }
            z = true;
            if (z) {
                return j;
            }
        }
        this.Kkkkkkkkkkkkkk = false;
        this.Kkkkkkkkkkkkkkk = j;
        this.Kkkkkkkkkkkk = false;
        if (this.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            this.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        } else {
            this.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            for (C2146gf c2146gf : this.Wwwwww) {
                c2146gf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
            }
        }
        return j;
    }

    @Override // me.tvspark.AbstractC2784xe, me.tvspark.AbstractC2220if
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (this.Kkkkkkkkkkkkkkkkkk == 0) {
            return Long.MIN_VALUE;
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.AbstractC2784xe, me.tvspark.AbstractC2220if
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
    }

    public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2625t7 abstractC2625t7) {
        this.Kkkkkkkkkkkkkkkkkkkkkkkk = this.Wwwwwww == null ? abstractC2625t7 : new AbstractC2625t7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(-9223372036854775807L, 0L);
        this.Kkkkkkkkkkkkkkkkkkkkkkk = abstractC2625t7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        boolean z = this.Kkkkkkkkkkkkkkkkk == -1 && abstractC2625t7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == -9223372036854775807L;
        this.Kkkkkkkkkkkkkkkkkkkkkk = z;
        this.Kkkkkkkkkkkkkkkkkkkkk = z ? 7 : 1;
        ((C2072ef) this.Wwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkkkkkkkkkkkkkkk, abstractC2625t7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), this.Kkkkkkkkkkkkkkkkkkkkkk);
        boolean z2 = this.Www;
        if (z2 || this.Kkkkkkkkkkk || z2 || !this.Wwww || this.Kkkkkkkkkkkkkkkkkkkkkkkk == null) {
            return;
        }
        for (C2146gf c2146gf : this.Wwwwww) {
            if (c2146gf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() == null) {
                return;
            }
        }
        this.Wwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        int length = this.Wwwwww.length;
        C2331lf[] c2331lfArr = new C2331lf[length];
        boolean[] zArr = new boolean[length];
        for (int i = 0; i < length; i++) {
            C2245j3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwww[i].Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            String str = Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwww;
            boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwww = C1950bl.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
            boolean z3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwww || C1950bl.Wwwwwwwwwwwwwwwwwwwwwwwwww(str);
            zArr[i] = z3;
            this.Kkkkkkkkkkkkkkkkkkkkkkkkkk = z3 | this.Kkkkkkkkkkkkkkkkkkkkkkkkkk;
            C2856zc c2856zc = this.Wwwwwww;
            if (c2856zc != null) {
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwww || this.Wwwww[i].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    C2254jc c2254jc = Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwww;
                    C2254jc c2254jc2 = c2254jc == null ? new C2254jc(c2856zc) : new C2254jc((C2254jc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[]) C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object[]) c2254jc.Wwwwwwwwwwwwwwwwwwwwwwww, (Object[]) new C2254jc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[]{c2856zc}));
                    C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwww = c2254jc2;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                }
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwww && Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww == -1 && Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww == -1 && c2856zc.Wwwwwwwwwwwwwwwwwwwwwwww != -1) {
                    C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2856zc.Wwwwwwwwwwwwwwwwwwwwwwww;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                }
            }
            c2331lfArr[i] = new C2331lf(Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwww)));
        }
        this.Kkkkkkkkkkkkkkkkkkkkkkkkk = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new C2368mf(c2331lfArr), zArr);
        this.Www = true;
        AbstractC2784xe.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwww;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2784xe) this);
    }

    @Override // me.tvspark.AbstractC2249j7
    public AbstractC2740w7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, false));
    }

    @Override // me.tvspark.AbstractC2784xe
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, boolean z) {
        Wwwwwwwwwwwwwwwwwwwwwwwwww();
        if (Wwwwwwwwwwwwwwwwwwwwwww()) {
            return;
        }
        boolean[] zArr = this.Kkkkkkkkkkkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int length = this.Wwwwww.length;
        for (int i = 0; i < length; i++) {
            C2146gf c2146gf = this.Wwwwww[i];
            c2146gf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2146gf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, z, zArr[i]));
        }
    }

    @Override // me.tvspark.C2146gf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2245j3 c2245j3) {
        this.Wwwwwwwww.post(this.Wwwwwwwwwww);
    }

    @Override // me.tvspark.AbstractC2249j7
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(final AbstractC2625t7 abstractC2625t7) {
        this.Wwwwwwwww.post(new Runnable() { // from class: me.tvspark.ie
            @Override // java.lang.Runnable
            public final void run() {
                C2035df.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2625t7);
            }
        });
    }

    @Override // me.tvspark.AbstractC2784xe
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2784xe.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, long j) {
        this.Wwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.AbstractC2784xe, me.tvspark.AbstractC2220if
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() && this.Wwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.AbstractC2784xe, me.tvspark.AbstractC2220if
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        if (this.Kkkkkkkkkkkk || this.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() || this.Kkkkkkkkkkkkkk) {
            return false;
        }
        if (this.Www && this.Kkkkkkkkkkkkkkkkkk == 0) {
            return false;
        }
        boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (this.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        }
        Wwwwwwwwwwwwwwwwwwww();
        return true;
    }

    /* renamed from: me.tvspark.df$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements AbstractC2183hf {
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        }

        @Override // me.tvspark.AbstractC2183hf
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            C2035df c2035df = C2035df.this;
            return !c2035df.Wwwwwwwwwwwwwwwwwww() && c2035df.Wwwwww[this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2035df.Kkkkkkkkkkkk);
        }

        @Override // me.tvspark.AbstractC2183hf
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() throws IOException {
            C2035df c2035df = C2035df.this;
            c2035df.Wwwwww[this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww].Wwwwwwwwwwwwwwwwwwwwwwwww();
            c2035df.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((C2225ik) c2035df.Wwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2035df.Kkkkkkkkkkkkkkkkkkkkk));
        }

        @Override // me.tvspark.AbstractC2183hf
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2282k3 c2282k3, C2738w5 c2738w5, boolean z) {
            C2035df c2035df = C2035df.this;
            int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (c2035df.Wwwwwwwwwwwwwwwwwww()) {
                return -3;
            }
            c2035df.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2035df.Wwwwww[i].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2282k3, c2738w5, z, c2035df.Kkkkkkkkkkkk);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -3) {
                c2035df.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
            }
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.AbstractC2183hf
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
            C2035df c2035df = C2035df.this;
            int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (c2035df.Wwwwwwwwwwwwwwwwwww()) {
                return 0;
            }
            c2035df.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
            C2146gf c2146gf = c2035df.Wwwwww[i];
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2146gf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, c2035df.Kkkkkkkkkkkk);
            c2146gf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != 0) {
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            c2035df.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
    }

    @Override // me.tvspark.AbstractC2784xe
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, C2098f4 c2098f4) {
        Wwwwwwwwwwwwwwwwwwwwwwwwww();
        if (!this.Kkkkkkkkkkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            return 0L;
        }
        AbstractC2625t7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Kkkkkkkkkkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j);
        long j2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        long j3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (c2098f4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 0 && c2098f4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 0) {
            return j;
        }
        long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, c2098f4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Long.MIN_VALUE);
        long j4 = c2098f4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        long j5 = Long.MAX_VALUE;
        long j6 = j + j4;
        if (((j4 ^ j6) & (j ^ j6)) >= 0) {
            j5 = j6;
        }
        boolean z = false;
        boolean z2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 <= j2 && j2 <= j5;
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 <= j3 && j3 <= j5) {
            z = true;
        }
        if (!z2 || !z) {
            if (z2) {
                return j2;
            }
            if (!z) {
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            }
        } else if (Math.abs(j2 - j) <= Math.abs(j3 - j)) {
            return j2;
        }
        return j3;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        Wwwwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Kkkkkkkkkkkkkkkkkkkkkkkkk;
        boolean[] zArr = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (!zArr[i]) {
            C2245j3 c2245j3 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww[i].Wwwwwwwwwwwwwwwwwwwwwww[0];
            this.Wwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C1950bl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3.Wwwwwwwwwwwww), c2245j3, 0, (Object) null, this.Kkkkkkkkkkkkkkkk);
            zArr[i] = true;
        }
    }

    /* renamed from: me.tvspark.df$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Loader.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, C2595se.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public boolean Wwwwwwwwwwwwwwwwwwwww;
        @Nullable
        public AbstractC2740w7 Wwwwwwwwwwwwwwwwwwwwww;
        public long Wwwwwwwwwwwwwwwwwwwwwwwww;
        public volatile boolean Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final C2675uk Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final AbstractC2249j7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final C2293ke Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final C2373mk Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final Uri Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final C2588s7 Wwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2588s7();
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwww = true;
        public long Wwwwwwwwwwwwwwwwwwwwwww = -1;
        public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2632te.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        public C1949bk Wwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Uri uri, AbstractC2863zj abstractC2863zj, C2293ke c2293ke, AbstractC2249j7 abstractC2249j7, C2675uk c2675uk) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = uri;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2373mk(abstractC2863zj);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2293ke;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2249j7;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2675uk;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = true;
        }

        public final C1949bk Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
            Collections.emptyMap();
            Uri uri = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            String str = C2035df.this.Wwwwwwwwwwwwwwww;
            Map<String, String> map = C2035df.Kkkkkkkkkk;
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uri, "The uri must be set.");
            return new C1949bk(uri, 0L, 1, null, map, j, -1L, str, 6, null);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() throws IOException {
            int i = 0;
            while (i == 0 && !this.Wwwwwwwwwwwwwwwwwwwwwwwwwww) {
                try {
                    long j = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    C1949bk Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j);
                    this.Wwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    this.Wwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != -1) {
                        this.Wwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 + j;
                    }
                    C2035df.this.Wwwwwww = C2856zc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                    AbstractC2752wj abstractC2752wj = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (C2035df.this.Wwwwwww != null && C2035df.this.Wwwwwww.Wwwwwwwwwwwwwwwwwww != -1) {
                        abstractC2752wj = new C2595se(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, C2035df.this.Wwwwwww.Wwwwwwwwwwwwwwwwwww, this);
                        C2035df c2035df = C2035df.this;
                        if (c2035df != null) {
                            AbstractC2740w7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = c2035df.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, true));
                            this.Wwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2035df.Kkkkkkkkk);
                        } else {
                            throw null;
                        }
                    }
                    long j2 = j;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2752wj, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), j, this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    if (C2035df.this.Wwwwwww != null) {
                        AbstractC2175h7 abstractC2175h7 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        if (abstractC2175h7 instanceof C2815y8) {
                            ((C2815y8) abstractC2175h7).Wwwwwwwwwwwwwwwww = true;
                        }
                    }
                    if (this.Wwwwwwwwwwwwwwwwwwwwwwwwww) {
                        C2293ke c2293ke = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        long j3 = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
                        AbstractC2175h7 abstractC2175h72 = c2293ke.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2175h72);
                        abstractC2175h72.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j2, j3);
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwww = false;
                    }
                    while (true) {
                        long j4 = j2;
                        while (i == 0 && !this.Wwwwwwwwwwwwwwwwwwwwwwwwwww) {
                            try {
                                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                C2293ke c2293ke2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                C2588s7 c2588s7 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                AbstractC2175h7 abstractC2175h73 = c2293ke2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2175h73);
                                AbstractC2212i7 abstractC2212i7 = c2293ke2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7);
                                i = abstractC2175h73.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7, c2588s7);
                                j2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                if (j2 > C2035df.this.Wwwwwwwwwwwwwww + j4) {
                                    break;
                                }
                            } catch (InterruptedException unused) {
                                throw new InterruptedIOException();
                            }
                        }
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        C2035df.this.Wwwwwwwww.post(C2035df.this.Wwwwwwwwww);
                    }
                    if (i == 1) {
                        i = 0;
                    } else if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() != -1) {
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    }
                    C2373mk c2373mk = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (c2373mk != null) {
                        try {
                            c2373mk.close();
                        } catch (IOException unused2) {
                        }
                    }
                } catch (Throwable th) {
                    if (i != 1 && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() != -1) {
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    }
                    C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2863zj) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    throw th;
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, long j, long j2, boolean z) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        C2373mk c2373mk = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        C2632te c2632te = new C2632te(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwww, c2373mk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2373mk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, j, j2, c2373mk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2632te, 1, -1, null, 0, null, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwww, this.Kkkkkkkkkkkkkkkkkkkkkkk);
        if (!z) {
            if (this.Kkkkkkkkkkkkkkkkk == -1) {
                this.Kkkkkkkkkkkkkkkkk = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwww;
            }
            for (C2146gf c2146gf : this.Wwwwww) {
                c2146gf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
            }
            if (this.Kkkkkkkkkkkkkkkkkk <= 0) {
                return;
            }
            AbstractC2784xe.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = this.Wwwwwwww;
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2784xe.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) this);
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        Wwwwwwwwwwwwwwwwwwwwwwwwww();
        boolean[] zArr = this.Kkkkkkkkkkkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (!this.Kkkkkkkkkkkkkk || !zArr[i] || this.Wwwwww[i].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false)) {
            return;
        }
        this.Kkkkkkkkkkkkkkk = 0L;
        this.Kkkkkkkkkkkkkk = false;
        this.Kkkkkkkkkkkkkkkkkkk = true;
        this.Kkkkkkkkkkkkkkkk = 0L;
        this.Kkkkkkkkkkkkk = 0;
        for (C2146gf c2146gf : this.Wwwwww) {
            c2146gf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
        }
        AbstractC2784xe.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwww;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2784xe.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) this);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, long j, long j2) {
        AbstractC2625t7 abstractC2625t7;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (this.Kkkkkkkkkkkkkkkkkkkkkkk == -9223372036854775807L && (abstractC2625t7 = this.Kkkkkkkkkkkkkkkkkkkkkkkk) != null) {
            boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = abstractC2625t7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            long Wwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwww();
            long j3 = Wwwwwwwwwwwwwwwwwwwwwwww == Long.MIN_VALUE ? 0L : Wwwwwwwwwwwwwwwwwwwwwwww + 10000;
            this.Kkkkkkkkkkkkkkkkkkkkkkk = j3;
            ((C2072ef) this.Wwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j3, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, this.Kkkkkkkkkkkkkkkkkkkkkk);
        }
        C2373mk c2373mk = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        C2632te c2632te = new C2632te(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwww, c2373mk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2373mk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, j, j2, c2373mk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2632te, 1, -1, null, 0, null, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwww, this.Kkkkkkkkkkkkkkkkkkkkkkk);
        if (this.Kkkkkkkkkkkkkkkkk == -1) {
            this.Kkkkkkkkkkkkkkkkk = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwww;
        }
        this.Kkkkkkkkkkkk = true;
        AbstractC2784xe.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = this.Wwwwwwww;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2784xe.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) this);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00be  */
    @Override // com.google.android.exoplayer2.upstream.Loader.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Loader.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, long j, long j2, IOException iOException, int i) {
        Loader.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        AbstractC2625t7 abstractC2625t7;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (this.Kkkkkkkkkkkkkkkkk == -1) {
            this.Kkkkkkkkkkkkkkkkk = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwww;
        }
        C2373mk c2373mk = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        C2632te c2632te = new C2632te(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwww, c2373mk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2373mk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, j, j2, c2373mk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = ((C2225ik) this.Wwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new AbstractC2299kk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2632te, new C2747we(1, -1, null, 0, null, C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwww), C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkkkkkkkkkkkkkkk)), iOException, i));
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == -9223372036854775807L) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Loader.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        } else {
            int Wwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwww();
            boolean z = false;
            boolean z2 = Wwwwwwwwwwwwwwwwwwwwwwwww > this.Kkkkkkkkkkkkk;
            if (this.Kkkkkkkkkkkkkkkkk != -1 || ((abstractC2625t7 = this.Kkkkkkkkkkkkkkkkkkkkkkkk) != null && abstractC2625t7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() != -9223372036854775807L)) {
                this.Kkkkkkkkkkkkk = Wwwwwwwwwwwwwwwwwwwwwwwww;
            } else if (!this.Www || Wwwwwwwwwwwwwwwwwww()) {
                this.Kkkkkkkkkkkkkkkkkkk = this.Www;
                this.Kkkkkkkkkkkkkkkk = 0L;
                this.Kkkkkkkkkkkkk = 0;
                for (C2146gf c2146gf : this.Wwwwww) {
                    c2146gf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
                }
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0L;
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwww = 0L;
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwww = true;
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwww = false;
            } else {
                this.Kkkkkkkkkkkkkk = true;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = !z ? Loader.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) : Loader.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            z = true;
            if (!z) {
            }
        }
        boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = true ^ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2632te, 1, -1, null, 0, null, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwww, this.Kkkkkkkkkkkkkkkkkkkkkkk, iOException, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3) {
            this.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
    }

    public final AbstractC2740w7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        int length = this.Wwwwww.length;
        for (int i = 0; i < length; i++) {
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(this.Wwwww[i])) {
                return this.Wwwwww[i];
            }
        }
        C2146gf c2146gf = new C2146gf(this.Wwwwwwwwwwwwwwwww, this.Wwwwwwwww.getLooper(), this.Wwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwww);
        c2146gf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = this;
        int i2 = length + 1;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[] wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[]) Arrays.copyOf(this.Wwwww, i2);
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr[length] = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr;
        C2146gf[] c2146gfArr = (C2146gf[]) Arrays.copyOf(this.Wwwwww, i2);
        c2146gfArr[length] = c2146gf;
        this.Wwwwww = c2146gfArr;
        return c2146gf;
    }

    @Override // me.tvspark.AbstractC2784xe
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC1985cj[] abstractC1985cjArr, boolean[] zArr, AbstractC2183hf[] abstractC2183hfArr, boolean[] zArr2, long j) {
        Wwwwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Kkkkkkkkkkkkkkkkkkkkkkkkk;
        C2368mf c2368mf = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        boolean[] zArr3 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i = this.Kkkkkkkkkkkkkkkkkk;
        int i2 = 0;
        for (int i3 = 0; i3 < abstractC1985cjArr.length; i3++) {
            if (abstractC2183hfArr[i3] != null && (abstractC1985cjArr[i3] == null || !zArr[i3])) {
                int i4 = ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) abstractC2183hfArr[i3]).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(zArr3[i4]);
                this.Kkkkkkkkkkkkkkkkkk--;
                zArr3[i4] = false;
                abstractC2183hfArr[i3] = null;
            }
        }
        boolean z = !this.Kkkkkkkkkkkkkkkkkkkk ? j != 0 : i == 0;
        for (int i5 = 0; i5 < abstractC1985cjArr.length; i5++) {
            if (abstractC2183hfArr[i5] == null && abstractC1985cjArr[i5] != null) {
                AbstractC1985cj abstractC1985cj = abstractC1985cjArr[i5];
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC1985cj.length() == 1);
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC1985cj.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0) == 0);
                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2368mf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC1985cj.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(!zArr3[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2]);
                this.Kkkkkkkkkkkkkkkkkk++;
                zArr3[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2] = true;
                abstractC2183hfArr[i5] = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                zArr2[i5] = true;
                if (!z) {
                    C2146gf c2146gf = this.Wwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2];
                    z = !c2146gf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, true) && c2146gf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() != 0;
                }
            }
        }
        if (this.Kkkkkkkkkkkkkkkkkk == 0) {
            this.Kkkkkkkkkkkkkk = false;
            this.Kkkkkkkkkkkkkkkkkkk = false;
            if (this.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                C2146gf[] c2146gfArr = this.Wwwwww;
                int length = c2146gfArr.length;
                while (i2 < length) {
                    c2146gfArr[i2].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    i2++;
                }
                this.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            } else {
                for (C2146gf c2146gf2 : this.Wwwwww) {
                    c2146gf2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
                }
            }
        } else if (z) {
            j = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j);
            while (i2 < abstractC2183hfArr.length) {
                if (abstractC2183hfArr[i2] != null) {
                    zArr2[i2] = true;
                }
                i2++;
            }
        }
        this.Kkkkkkkkkkkkkkkkkkkk = true;
        return j;
    }
}
