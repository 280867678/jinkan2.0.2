package me.tvspark;

import android.net.Uri;
import androidx.annotation.NonNull;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import me.tvspark.Llllll;

/* loaded from: classes4.dex */
public class Uuuuu implements Llllll<Uri, InputStream> {
    public static final Set<String> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Collections.unmodifiableSet(new HashSet(Arrays.asList("http", "https")));
    public final Llllll<Ooo, InputStream> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Lllll<Uri, InputStream> {
        @Override // me.tvspark.Lllll
        @NonNull
        public Llllll<Uri, InputStream> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C1884Ll c1884Ll) {
            return new Uuuuu(c1884Ll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Ooo.class, InputStream.class));
        }
    }

    public Uuuuu(Llllll<Ooo, InputStream> llllll) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = llllll;
    }

    @Override // me.tvspark.Llllll
    public Llllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<InputStream> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Uri uri, int i, int i2, @NonNull Illllllllllllllllllllllll illllllllllllllllllllllll) {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Ooo(uri.toString(), Llllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), i, i2, illllllllllllllllllllllll);
    }

    @Override // me.tvspark.Llllll
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Uri uri) {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.contains(uri.getScheme());
    }
}
