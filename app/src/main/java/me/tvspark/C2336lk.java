package me.tvspark;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.Loader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

/* renamed from: me.tvspark.lk */
/* loaded from: classes4.dex */
public final class C2336lk<T> implements Loader.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    @Nullable
    public volatile T Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<? extends T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final C2373mk Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final C1949bk Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2632te.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    /* renamed from: me.tvspark.lk$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> {
        T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Uri uri, InputStream inputStream) throws IOException;
    }

    public C2336lk(AbstractC2863zj abstractC2863zj, Uri uri, int i, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<? extends T> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        Map emptyMap = Collections.emptyMap();
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uri, "The uri must be set.");
        C1949bk c1949bk = new C1949bk(uri, 0L, 1, null, emptyMap, 0L, -1L, null, 1, null);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2373mk(abstractC2863zj);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c1949bk;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() throws IOException {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0L;
        C1912ak c1912ak = new C1912ak(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        try {
            if (!c1912ak.Wwwwwwwwwwwwwwwwwwwww) {
                c1912ak.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c1912ak.Wwwwwwwwwwwwwwwwwwwwwww);
                c1912ak.Wwwwwwwwwwwwwwwwwwwww = true;
            }
            Uri uri = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getUri();
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uri);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uri, c1912ak);
        } finally {
            C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Closeable) c1912ak);
        }
    }
}
