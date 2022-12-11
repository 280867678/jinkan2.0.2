package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import java.io.IOException;
import me.tvspark.AbstractC1945bg;
import me.tvspark.AbstractC2299kk;
import me.tvspark.AbstractC2671ug;

/* loaded from: classes3.dex */
public interface HlsPlaylistTracker {

    /* loaded from: classes3.dex */
    public static final class PlaylistResetException extends IOException {
        public final Uri url;

        public PlaylistResetException(Uri uri) {
            this.url = uri;
        }
    }

    /* loaded from: classes3.dex */
    public static final class PlaylistStuckException extends IOException {
        public final Uri url;

        public PlaylistStuckException(Uri uri) {
            this.url = uri;
        }
    }

    /* loaded from: classes3.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    /* loaded from: classes3.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

        boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Uri uri, long j);
    }

    /* loaded from: classes3.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        HlsPlaylistTracker Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC1945bg abstractC1945bg, AbstractC2299kk abstractC2299kk, AbstractC2671ug abstractC2671ug);
    }
}
