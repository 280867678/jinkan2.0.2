package me.tvspark;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.upstream.Loader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import me.tvspark.AbstractC1944bf;
import me.tvspark.AbstractC2299kk;
import me.tvspark.C2336lk;
import me.tvspark.C2523qg;
import me.tvspark.C2560rg;
import org.eclipse.jetty.server.AsyncContinuation;

/* renamed from: me.tvspark.og */
/* loaded from: classes4.dex */
public final class C2443og implements HlsPlaylistTracker, Loader.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<C2336lk<AbstractC2597sg>> {
    public static final HlsPlaylistTracker.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwww = C2369mg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwww;
    @Nullable
    public C2560rg Wwwwwwwwwww;
    @Nullable
    public Uri Wwwwwwwwwwww;
    @Nullable
    public C2523qg Wwwwwwwwwwwww;
    @Nullable
    public HlsPlaylistTracker.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwww;
    @Nullable
    public Handler Wwwwwwwwwwwwwww;
    @Nullable
    public Loader Wwwwwwwwwwwwwwww;
    @Nullable
    public AbstractC1944bf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwww;
    @Nullable
    public C2336lk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<AbstractC2597sg> Wwwwwwwwwwwwwwwwww;
    public final AbstractC2299kk Wwwwwwwwwwwwwwwwwwwwww;
    public final AbstractC2671ug Wwwwwwwwwwwwwwwwwwwwwww;
    public final AbstractC1945bg Wwwwwwwwwwwwwwwwwwwwwwww;
    public final double Wwwwwwwwwwwwwwwwwww = 3.5d;
    public final List<HlsPlaylistTracker.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwww = new ArrayList();
    public final HashMap<Uri, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwww = new HashMap<>();
    public long Wwwwwwwww = -9223372036854775807L;

    public C2443og(AbstractC1945bg abstractC1945bg, AbstractC2299kk abstractC2299kk, AbstractC2671ug abstractC2671ug) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = abstractC1945bg;
        this.Wwwwwwwwwwwwwwwwwwwwwww = abstractC2671ug;
        this.Wwwwwwwwwwwwwwwwwwwwww = abstractC2299kk;
    }

    public static C2560rg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2560rg c2560rg, C2560rg c2560rg2) {
        int i = (int) (c2560rg2.Wwwwwwwwwwwwwwwwwwwwwwwwww - c2560rg.Wwwwwwwwwwwwwwwwwwwwwwwwww);
        List<C2560rg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> list = c2560rg.Wwwwwwwwwwwwwwwwwwww;
        if (i < list.size()) {
            return list.get(i);
        }
        return null;
    }

    public static /* synthetic */ boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2443og c2443og, Uri uri, long j) {
        int size = c2443og.Wwwwwwwwwwwwwwwwwwww.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            z |= !c2443og.Wwwwwwwwwwwwwwwwwwww.get(i).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uri, j);
        }
        return z;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Uri uri) throws IOException {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwww.get(uri);
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Integer.MIN_VALUE);
        IOException iOException = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwww;
        if (iOException == null) {
            return;
        }
        throw iOException;
    }

    public static /* synthetic */ C2560rg Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2443og c2443og, C2560rg c2560rg, C2560rg c2560rg2) {
        long j;
        long j2;
        long j3;
        int i;
        C2560rg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        int i2;
        int size;
        int size2;
        if (c2443og != null) {
            if (c2560rg2 == null) {
                throw null;
            }
            boolean z = true;
            if (c2560rg != null && c2560rg2.Wwwwwwwwwwwwwwwwwwwwwwwwww <= c2560rg.Wwwwwwwwwwwwwwwwwwwwwwwwww && (i2 < 0 || ((size = c2560rg2.Wwwwwwwwwwwwwwwwwwww.size()) <= (size2 = c2560rg.Wwwwwwwwwwwwwwwwwwww.size()) && (size != size2 || !c2560rg2.Wwwwwwwwwwwwwwwwwwwwwww || c2560rg.Wwwwwwwwwwwwwwwwwwwwwww)))) {
                z = false;
            }
            if (!z) {
                return (!c2560rg2.Wwwwwwwwwwwwwwwwwwwwwww || c2560rg.Wwwwwwwwwwwwwwwwwwwwwww) ? c2560rg : new C2560rg(c2560rg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2560rg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2560rg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2560rg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2560rg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2560rg.Wwwwwwwwwwwwwwwwwwwwwwwwwwww, c2560rg.Wwwwwwwwwwwwwwwwwwwwwwwwwww, c2560rg.Wwwwwwwwwwwwwwwwwwwwwwwwww, c2560rg.Wwwwwwwwwwwwwwwwwwwwwwwww, c2560rg.Wwwwwwwwwwwwwwwwwwwwwwww, c2560rg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, true, c2560rg.Wwwwwwwwwwwwwwwwwwwwww, c2560rg.Wwwwwwwwwwwwwwwwwwwww, c2560rg.Wwwwwwwwwwwwwwwwwwww);
            }
            if (c2560rg2.Wwwwwwwwwwwwwwwwwwwwww) {
                j = c2560rg2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            } else {
                C2560rg c2560rg3 = c2443og.Wwwwwwwwwww;
                j = c2560rg3 != null ? c2560rg3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww : 0L;
                if (c2560rg != null) {
                    int size3 = c2560rg.Wwwwwwwwwwwwwwwwwwww.size();
                    C2560rg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2560rg, c2560rg2);
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 != null) {
                        j2 = c2560rg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        j3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwww;
                    } else if (size3 == c2560rg2.Wwwwwwwwwwwwwwwwwwwwwwwwww - c2560rg.Wwwwwwwwwwwwwwwwwwwwwwwwww) {
                        j2 = c2560rg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        j3 = c2560rg.Wwwwwwwwwwwwwwwwwww;
                    }
                    j = j2 + j3;
                }
            }
            long j4 = j;
            if (c2560rg2.Wwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                i = c2560rg2.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
            } else {
                C2560rg c2560rg4 = c2443og.Wwwwwwwwwww;
                i = c2560rg4 != null ? c2560rg4.Wwwwwwwwwwwwwwwwwwwwwwwwwww : 0;
                if (c2560rg != null && (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2560rg, c2560rg2)) != null) {
                    i = (c2560rg.Wwwwwwwwwwwwwwwwwwwwwwwwwww + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwww) - c2560rg2.Wwwwwwwwwwwwwwwwwwww.get(0).Wwwwwwwwwwwwwwwwwwwww;
                }
            }
            return new C2560rg(c2560rg2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2560rg2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2560rg2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2560rg2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, j4, true, i, c2560rg2.Wwwwwwwwwwwwwwwwwwwwwwwwww, c2560rg2.Wwwwwwwwwwwwwwwwwwwwwwwww, c2560rg2.Wwwwwwwwwwwwwwwwwwwwwwww, c2560rg2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2560rg2.Wwwwwwwwwwwwwwwwwwwwwww, c2560rg2.Wwwwwwwwwwwwwwwwwwwwww, c2560rg2.Wwwwwwwwwwwwwwwwwwwww, c2560rg2.Wwwwwwwwwwwwwwwwwwww);
        }
        throw null;
    }

    /* renamed from: me.tvspark.og$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Loader.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<C2336lk<AbstractC2597sg>>, Runnable {
        public IOException Wwwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwwww;
        public long Wwwwwwwwwwwwwwwww;
        public long Wwwwwwwwwwwwwwwwww;
        public long Wwwwwwwwwwwwwwwwwww;
        public long Wwwwwwwwwwwwwwwwwwww;
        @Nullable
        public C2560rg Wwwwwwwwwwwwwwwwwwwww;
        public final C2336lk<AbstractC2597sg> Wwwwwwwwwwwwwwwwwwwwww;
        public final Loader Wwwwwwwwwwwwwwwwwwwwwww = new Loader("DefaultHlsPlaylistTracker:MediaPlaylist");
        public final Uri Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Uri uri) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = uri;
            this.Wwwwwwwwwwwwwwwwwwwwww = new C2336lk<>(C2443og.this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4), uri, 4, C2443og.this.Wwwwwwwwwwwwwwwwww);
        }

        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            Loader loader = this.Wwwwwwwwwwwwwwwwwwwwwww;
            C2336lk<AbstractC2597sg> c2336lk = this.Wwwwwwwwwwwwwwwwwwwwww;
            long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = loader.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2336lk, this, ((C2225ik) C2443og.this.Wwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2336lk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
            AbstractC1944bf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2443og.this.Wwwwwwwwwwwwwwwww;
            C2336lk<AbstractC2597sg> c2336lk2 = this.Wwwwwwwwwwwwwwwwwwwwww;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new C2632te(c2336lk2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2336lk2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }

        public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
            boolean z;
            this.Wwwwwwwwwwwwwwwww = SystemClock.elapsedRealtime() + j;
            if (this.Wwwwwwwwwwwwwwwwwwwwwwww.equals(C2443og.this.Wwwwwwwwwwww)) {
                C2443og c2443og = C2443og.this;
                List<C2523qg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> list = c2443og.Wwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                int size = list.size();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        z = false;
                        break;
                    }
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2443og.Wwwwwwwwwwwwwwwwwwwww.get(list.get(i).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    if (elapsedRealtime > wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwww) {
                        c2443og.Wwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww;
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        z = true;
                        break;
                    }
                    i++;
                }
                return !z;
            }
            return false;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.Wwwwwwwwwwwwwwww = false;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            this.Wwwwwwwwwwwwwwwww = 0L;
            if (this.Wwwwwwwwwwwwwwww || this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() || this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                return;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j = this.Wwwwwwwwwwwwwwwwww;
            if (elapsedRealtime >= j) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                return;
            }
            this.Wwwwwwwwwwwwwwww = true;
            C2443og.this.Wwwwwwwwwwwwwww.postDelayed(this, j - elapsedRealtime);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2336lk<AbstractC2597sg> c2336lk, long j, long j2, boolean z) {
            C2336lk<AbstractC2597sg> c2336lk2 = c2336lk;
            long j3 = c2336lk2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            C1949bk c1949bk = c2336lk2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            C2373mk c2373mk = c2336lk2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            C2632te c2632te = new C2632te(j3, c1949bk, c2373mk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2373mk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, j, j2, c2373mk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            C2443og.this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2336lk2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            C2443og.this.Wwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2632te, 4);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2336lk<AbstractC2597sg> c2336lk, long j, long j2) {
            C2336lk<AbstractC2597sg> c2336lk2 = c2336lk;
            AbstractC2597sg abstractC2597sg = c2336lk2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            long j3 = c2336lk2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            C1949bk c1949bk = c2336lk2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            C2373mk c2373mk = c2336lk2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            C2632te c2632te = new C2632te(j3, c1949bk, c2373mk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2373mk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, j, j2, c2373mk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            if (abstractC2597sg instanceof C2560rg) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((C2560rg) abstractC2597sg, c2632te);
                C2443og.this.Wwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2632te, 4);
            } else {
                ParserException parserException = new ParserException("Loaded playlist has unexpected type.");
                this.Wwwwwwwwwwwwwww = parserException;
                C2443og.this.Wwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2632te, 4, (IOException) parserException, true);
            }
            C2443og.this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2336lk2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public Loader.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2336lk<AbstractC2597sg> c2336lk, long j, long j2, IOException iOException, int i) {
            Loader.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            C2336lk<AbstractC2597sg> c2336lk2 = c2336lk;
            long j3 = c2336lk2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            C1949bk c1949bk = c2336lk2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            C2373mk c2373mk = c2336lk2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            C2632te c2632te = new C2632te(j3, c1949bk, c2373mk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2373mk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, j, j2, c2373mk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            AbstractC2299kk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new AbstractC2299kk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2632te, new C2747we(c2336lk2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), iOException, i);
            long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ((C2225ik) C2443og.this.Wwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            boolean z = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != -9223372036854775807L;
            boolean z2 = C2443og.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2443og.this, this.Wwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) || !z;
            if (z) {
                z2 |= Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            if (z2) {
                long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ((C2225ik) C2443og.this.Wwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != -9223372036854775807L ? Loader.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) : Loader.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            } else {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Loader.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            boolean z3 = !wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            C2443og.this.Wwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2632te, c2336lk2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, iOException, z3);
            if (z3) {
                C2443og.this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2336lk2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2560rg c2560rg, C2632te c2632te) {
            C2560rg c2560rg2;
            long j;
            C2560rg c2560rg3;
            C2294kf c2294kf;
            long j2;
            C2560rg c2560rg4 = this.Wwwwwwwwwwwwwwwwwwwww;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.Wwwwwwwwwwwwwwwwwwww = elapsedRealtime;
            C2560rg Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2443og.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2443og.this, c2560rg4, c2560rg);
            this.Wwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != c2560rg4) {
                this.Wwwwwwwwwwwwwww = null;
                this.Wwwwwwwwwwwwwwwwwww = elapsedRealtime;
                C2443og c2443og = C2443og.this;
                if (this.Wwwwwwwwwwwwwwwwwwwwwwww.equals(c2443og.Wwwwwwwwwwww)) {
                    if (c2443og.Wwwwwwwwwww == null) {
                        c2443og.Wwwwwwwwww = !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww;
                        c2443og.Wwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    }
                    c2443og.Wwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    HlsMediaSource hlsMediaSource = (HlsMediaSource) c2443og.Wwwwwwwwwwwwww;
                    if (hlsMediaSource == null) {
                        throw null;
                    }
                    long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww ? C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) : -9223372036854775807L;
                    int i = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    long j3 = (i == 2 || i == 1) ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : -9223372036854775807L;
                    long j4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    C2523qg c2523qg = ((C2443og) hlsMediaSource.Wwwwwwwwwwwwwwwwww).Wwwwwwwwwwwww;
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2523qg);
                    C2036dg c2036dg = new C2036dg(c2523qg, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    C2443og c2443og2 = (C2443og) hlsMediaSource.Wwwwwwwwwwwwwwwwww;
                    if (c2443og2.Wwwwwwwwww) {
                        long j5 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww - c2443og2.Wwwwwwwww;
                        long j6 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww + j5 : -9223372036854775807L;
                        List<C2560rg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> list = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww;
                        if (j4 != -9223372036854775807L) {
                            c2560rg2 = c2560rg4;
                            j = elapsedRealtime;
                            j2 = j4;
                        } else if (!list.isEmpty()) {
                            int max = Math.max(0, list.size() - 3);
                            long j7 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww - (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww * 2);
                            int i2 = max;
                            while (true) {
                                if (i2 <= 0) {
                                    c2560rg2 = c2560rg4;
                                    j = elapsedRealtime;
                                    break;
                                }
                                c2560rg2 = c2560rg4;
                                j = elapsedRealtime;
                                if (list.get(i2).Wwwwwwwwwwwwwwwwwwww <= j7) {
                                    break;
                                }
                                i2--;
                                c2560rg4 = c2560rg2;
                                elapsedRealtime = j;
                            }
                            j2 = list.get(i2).Wwwwwwwwwwwwwwwwwwww;
                        } else {
                            c2560rg2 = c2560rg4;
                            j = elapsedRealtime;
                            j2 = 0;
                        }
                        c2294kf = new C2294kf(j3, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, -9223372036854775807L, j6, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww, j5, j2, true, !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww, true, c2036dg, hlsMediaSource.Wwwwwwwwwwwwwwwwwwwwwwwwwww);
                    } else {
                        c2560rg2 = c2560rg4;
                        j = elapsedRealtime;
                        long j8 = j4 == -9223372036854775807L ? 0L : j4;
                        long j9 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww;
                        c2294kf = new C2294kf(j3, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, -9223372036854775807L, j9, j9, 0L, j8, true, false, false, c2036dg, hlsMediaSource.Wwwwwwwwwwwwwwwwwwwwwwwwwww);
                    }
                    hlsMediaSource.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2294kf);
                } else {
                    c2560rg2 = c2560rg4;
                    j = elapsedRealtime;
                }
                int size = c2443og.Wwwwwwwwwwwwwwwwwwww.size();
                for (int i3 = 0; i3 < size; i3++) {
                    c2443og.Wwwwwwwwwwwwwwwwwwww.get(i3).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                }
            } else {
                c2560rg2 = c2560rg4;
                j = elapsedRealtime;
                if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww) {
                    if (c2560rg.Wwwwwwwwwwwwwwwwwwwwwwwwww + c2560rg.Wwwwwwwwwwwwwwwwwwww.size() < this.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww) {
                        this.Wwwwwwwwwwwwwww = new HlsPlaylistTracker.PlaylistResetException(this.Wwwwwwwwwwwwwwwwwwwwwwww);
                        C2443og.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2443og.this, this.Wwwwwwwwwwwwwwwwwwwwwwww, -9223372036854775807L);
                    } else if (j - this.Wwwwwwwwwwwwwwwwwww > C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2560rg3.Wwwwwwwwwwwwwwwwwwwwwwww) * C2443og.this.Wwwwwwwwwwwwwwwwwww) {
                        this.Wwwwwwwwwwwwwww = new HlsPlaylistTracker.PlaylistStuckException(this.Wwwwwwwwwwwwwwwwwwwwwwww);
                        long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = ((C2225ik) C2443og.this.Wwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new AbstractC2299kk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2632te, new C2747we(4), this.Wwwwwwwwwwwwwww, 1));
                        C2443og.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2443og.this, this.Wwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != -9223372036854775807L) {
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                        }
                    }
                }
            }
            C2560rg c2560rg5 = this.Wwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwww = C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2560rg5 != c2560rg2 ? c2560rg5.Wwwwwwwwwwwwwwwwwwwwwwww : c2560rg5.Wwwwwwwwwwwwwwwwwwwwwwww / 2) + j;
            if (!this.Wwwwwwwwwwwwwwwwwwwwwwww.equals(C2443og.this.Wwwwwwwwwwww) || this.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww) {
                return;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    @Nullable
    public C2560rg Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Uri uri, boolean z) {
        C2560rg c2560rg;
        C2560rg c2560rg2 = this.Wwwwwwwwwwwwwwwwwwwww.get(uri).Wwwwwwwwwwwwwwwwwwwww;
        if (c2560rg2 != null && z && !uri.equals(this.Wwwwwwwwwwww)) {
            List<C2523qg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> list = this.Wwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            boolean z2 = false;
            int i = 0;
            while (true) {
                if (i >= list.size()) {
                    break;
                } else if (uri.equals(list.get(i).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                    z2 = true;
                    break;
                } else {
                    i++;
                }
            }
            if (z2 && ((c2560rg = this.Wwwwwwwwwww) == null || !c2560rg.Wwwwwwwwwwwwwwwwwwwwwww)) {
                this.Wwwwwwwwwwww = uri;
                this.Wwwwwwwwwwwwwwwwwwwww.get(uri).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        }
        return c2560rg2;
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Uri uri) {
        int i;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwww.get(uri);
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww == null) {
            return false;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long max = Math.max((long) AsyncContinuation.DEFAULT_TIMEOUT, C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww));
        C2560rg c2560rg = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww;
        return c2560rg.Wwwwwwwwwwwwwwwwwwwwwww || (i = c2560rg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) == 2 || i == 1 || wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww + max > elapsedRealtime;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2336lk<AbstractC2597sg> c2336lk, long j, long j2, boolean z) {
        C2336lk<AbstractC2597sg> c2336lk2 = c2336lk;
        long j3 = c2336lk2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        C1949bk c1949bk = c2336lk2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        C2373mk c2373mk = c2336lk2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        C2632te c2632te = new C2632te(j3, c1949bk, c2373mk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2373mk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, j, j2, c2373mk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2336lk2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2632te, 4);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2336lk<AbstractC2597sg> c2336lk, long j, long j2) {
        C2336lk<AbstractC2597sg> c2336lk2 = c2336lk;
        AbstractC2597sg abstractC2597sg = c2336lk2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        boolean z = abstractC2597sg instanceof C2560rg;
        C2523qg Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = z ? C2523qg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2597sg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) : (C2523qg) abstractC2597sg;
        this.Wwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        this.Wwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        this.Wwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(0).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        List<Uri> list = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Uri uri = list.get(i);
            this.Wwwwwwwwwwwwwwwwwwwww.put(uri, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uri));
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwww.get(this.Wwwwwwwwwwww);
        long j3 = c2336lk2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        C1949bk c1949bk = c2336lk2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        C2373mk c2373mk = c2336lk2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        C2632te c2632te = new C2632te(j3, c1949bk, c2373mk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2373mk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, j, j2, c2373mk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        if (z) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((C2560rg) abstractC2597sg, c2632te);
        } else {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2336lk2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2632te, 4);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public Loader.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2336lk<AbstractC2597sg> c2336lk, long j, long j2, IOException iOException, int i) {
        C2336lk<AbstractC2597sg> c2336lk2 = c2336lk;
        long j3 = c2336lk2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        C1949bk c1949bk = c2336lk2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        C2373mk c2373mk = c2336lk2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        C2632te c2632te = new C2632te(j3, c1949bk, c2373mk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2373mk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, j, j2, c2373mk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ((C2225ik) this.Wwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new AbstractC2299kk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2632te, new C2747we(c2336lk2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), iOException, i));
        boolean z = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -9223372036854775807L;
        this.Wwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2632te, c2336lk2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, iOException, z);
        if (z) {
            this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2336lk2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        return z ? Loader.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww : Loader.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }
}
