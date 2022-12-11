package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.upstream.Loader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import me.tvspark.AbstractC1944bf;
import me.tvspark.AbstractC1945bg;
import me.tvspark.AbstractC1981cf;
import me.tvspark.AbstractC1982cg;
import me.tvspark.AbstractC2256je;
import me.tvspark.AbstractC2299kk;
import me.tvspark.AbstractC2410nk;
import me.tvspark.AbstractC2470p6;
import me.tvspark.AbstractC2637tj;
import me.tvspark.AbstractC2671ug;
import me.tvspark.AbstractC2784xe;
import me.tvspark.AbstractC2858ze;
import me.tvspark.AbstractC2863zj;
import me.tvspark.C1907af;
import me.tvspark.C2147gg;
import me.tvspark.C2208i3;
import me.tvspark.C2221ig;
import me.tvspark.C2225ik;
import me.tvspark.C2336lk;
import me.tvspark.C2356m3;
import me.tvspark.C2374ml;
import me.tvspark.C2406ng;
import me.tvspark.C2441oe;
import me.tvspark.C2443og;
import me.tvspark.C2480pg;
import me.tvspark.C2632te;
import me.tvspark.C2820yd;
import me.tvspark.C2822yf;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public final class HlsMediaSource extends AbstractC2256je implements HlsPlaylistTracker.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    @Nullable
    public AbstractC2410nk Wwwwwwwwwwwwwwwww;
    public final HlsPlaylistTracker Wwwwwwwwwwwwwwwwww;
    public final boolean Wwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwww;
    public final boolean Wwwwwwwwwwwwwwwwwwwww;
    public final AbstractC2299kk Wwwwwwwwwwwwwwwwwwwwww;
    public final AbstractC2470p6 Wwwwwwwwwwwwwwwwwwwwwww;
    public final C2441oe Wwwwwwwwwwwwwwwwwwwwwwww;
    public final AbstractC1945bg Wwwwwwwwwwwwwwwwwwwwwwwww;
    public final C2356m3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwww;
    public final C2356m3 Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final AbstractC1982cg Wwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes3.dex */
    public static final class Factory implements AbstractC1981cf {
        public final AbstractC1945bg Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final C1907af Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C1907af();
        public AbstractC2671ug Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2406ng();
        public HlsPlaylistTracker.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2443og.Wwwwwwww;
        public AbstractC1982cg Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = AbstractC1982cg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public AbstractC2299kk Wwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2225ik();
        public C2441oe Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2441oe();
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwww = 1;
        public List<C2820yd> Wwwwwwwwwwwwwwwwwwwwwwwwww = Collections.emptyList();

        public Factory(AbstractC2863zj.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2822yf(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }

        @Deprecated
        public HlsMediaSource Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Uri uri) {
            C2356m3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2356m3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = uri;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = "application/x-mpegURL";
            C2356m3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            AbstractC2671ug abstractC2671ug = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            List<C2820yd> list = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isEmpty() ? this.Wwwwwwwwwwwwwwwwwwwwwwwwww : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (!list.isEmpty()) {
                abstractC2671ug = new C2480pg(abstractC2671ug, list);
            }
            C2356m3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            Object obj = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isEmpty() && !list.isEmpty()) {
                C2356m3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
            C2356m3 c2356m3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            AbstractC1945bg abstractC1945bg = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            AbstractC1982cg abstractC1982cg = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            C2441oe c2441oe = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            AbstractC2470p6 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2356m3);
            AbstractC2299kk abstractC2299kk = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
            return new HlsMediaSource(c2356m3, abstractC1945bg, abstractC1982cg, c2441oe, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, abstractC2299kk, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, abstractC2299kk, abstractC2671ug), false, this.Wwwwwwwwwwwwwwwwwwwwwwwwwww, false, null);
        }
    }

    static {
        C2208i3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("goog.exo.hls");
    }

    public /* synthetic */ HlsMediaSource(C2356m3 c2356m3, AbstractC1945bg abstractC1945bg, AbstractC1982cg abstractC1982cg, C2441oe c2441oe, AbstractC2470p6 abstractC2470p6, AbstractC2299kk abstractC2299kk, HlsPlaylistTracker hlsPlaylistTracker, boolean z, int i, boolean z2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        C2356m3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2356m3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = c2356m3;
        this.Wwwwwwwwwwwwwwwwwwwwwwwww = abstractC1945bg;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC1982cg;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = c2441oe;
        this.Wwwwwwwwwwwwwwwwwwwwwww = abstractC2470p6;
        this.Wwwwwwwwwwwwwwwwwwwwww = abstractC2299kk;
        this.Wwwwwwwwwwwwwwwwww = hlsPlaylistTracker;
        this.Wwwwwwwwwwwwwwwwwwwww = z;
        this.Wwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwww = z2;
    }

    @Override // me.tvspark.AbstractC2256je
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        C2443og c2443og = (C2443og) this.Wwwwwwwwwwwwwwwwww;
        c2443og.Wwwwwwwwwwww = null;
        c2443og.Wwwwwwwwwww = null;
        c2443og.Wwwwwwwwwwwww = null;
        c2443og.Wwwwwwwww = -9223372036854775807L;
        c2443og.Wwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Loader.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) null);
        c2443og.Wwwwwwwwwwwwwwww = null;
        for (C2443og.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : c2443og.Wwwwwwwwwwwwwwwwwwwww.values()) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Loader.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) null);
        }
        c2443og.Wwwwwwwwwwwwwww.removeCallbacksAndMessages(null);
        c2443og.Wwwwwwwwwwwwwww = null;
        c2443og.Wwwwwwwwwwwwwwwwwwwww.clear();
        this.Wwwwwwwwwwwwwwwwwwwwwww.release();
    }

    @Override // me.tvspark.AbstractC2858ze
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() throws IOException {
        C2443og c2443og = (C2443og) this.Wwwwwwwwwwwwwwwwww;
        Loader loader = c2443og.Wwwwwwwwwwwwwwww;
        if (loader != null) {
            loader.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Integer.MIN_VALUE);
        }
        Uri uri = c2443og.Wwwwwwwwwwww;
        if (uri != null) {
            c2443og.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uri);
        }
    }

    @Override // me.tvspark.AbstractC2858ze
    public C2356m3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.AbstractC2858ze
    /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    public AbstractC2784xe mo4966Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2858ze.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, AbstractC2637tj abstractC2637tj, long j) {
        AbstractC1944bf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0L);
        return new C2147gg(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), this.Wwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, abstractC2637tj, this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwww);
    }

    @Override // me.tvspark.AbstractC2256je
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable AbstractC2410nk abstractC2410nk) {
        this.Wwwwwwwwwwwwwwwww = abstractC2410nk;
        this.Wwwwwwwwwwwwwwwwwwwwwww.prepare();
        AbstractC1944bf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2858ze.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) null);
        HlsPlaylistTracker hlsPlaylistTracker = this.Wwwwwwwwwwwwwwwwww;
        Uri uri = this.Wwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        C2443og c2443og = (C2443og) hlsPlaylistTracker;
        if (c2443og != null) {
            c2443og.Wwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            c2443og.Wwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            c2443og.Wwwwwwwwwwwwww = this;
            C2336lk c2336lk = new C2336lk(c2443og.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4), uri, 4, c2443og.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2443og.Wwwwwwwwwwwwwwww == null);
            Loader loader = new Loader("DefaultHlsPlaylistTracker:MasterPlaylist");
            c2443og.Wwwwwwwwwwwwwwww = loader;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new C2632te(c2336lk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2336lk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, loader.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2336lk, c2443og, ((C2225ik) c2443og.Wwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2336lk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww))), c2336lk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            return;
        }
        throw null;
    }

    @Override // me.tvspark.AbstractC2858ze
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2784xe abstractC2784xe) {
        C2221ig[] c2221igArr;
        C2221ig.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[] wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr;
        C2147gg c2147gg = (C2147gg) abstractC2784xe;
        ((C2443og) c2147gg.Wwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwww.remove(c2147gg);
        for (C2221ig c2221ig : c2147gg.Wwwwww) {
            if (c2221ig.Kkkkkkkkkkkkkkkkkkkk) {
                for (C2221ig.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : c2221ig.Wwww) {
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    DrmSession drmSession = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (drmSession != null) {
                        drmSession.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                    }
                }
            }
            c2221ig.Wwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2221ig);
            c2221ig.Wwwwwwww.removeCallbacksAndMessages(null);
            c2221ig.Kkkkkkkkkkkkkkkk = true;
            c2221ig.Wwwwwww.clear();
        }
        c2147gg.Wwwwwwwww = null;
    }
}
