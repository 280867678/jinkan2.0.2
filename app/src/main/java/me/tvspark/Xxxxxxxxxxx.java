package me.tvspark;

import androidx.annotation.NonNull;
import java.io.InputStream;
import java.net.URL;
import me.tvspark.Llllll;

/* loaded from: classes4.dex */
public class Xxxxxxxxxxx implements Llllll<URL, InputStream> {
    public final Llllll<Ooo, InputStream> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Lllll<URL, InputStream> {
        @Override // me.tvspark.Lllll
        @NonNull
        public Llllll<URL, InputStream> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C1884Ll c1884Ll) {
            return new Xxxxxxxxxxx(c1884Ll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Ooo.class, InputStream.class));
        }
    }

    public Xxxxxxxxxxx(Llllll<Ooo, InputStream> llllll) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = llllll;
    }

    @Override // me.tvspark.Llllll
    public Llllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<InputStream> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull URL url, int i, int i2, @NonNull Illllllllllllllllllllllll illllllllllllllllllllllll) {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Ooo(url), i, i2, illllllllllllllllllllllll);
    }

    @Override // me.tvspark.Llllll
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull URL url) {
        return true;
    }
}
