package me.tvspark;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import me.tvspark.Llllll;

/* loaded from: classes4.dex */
public class Uuuuuuuu<Data> implements Llllll<Uri, Data> {
    public static final Set<String> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Collections.unmodifiableSet(new HashSet(Arrays.asList("file", "android.resource", "content")));
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Data> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Lllll<Uri, InputStream>, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<InputStream> {
        public final ContentResolver Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ContentResolver contentResolver) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = contentResolver;
        }

        @Override // me.tvspark.Uuuuuuuu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public Illlllllllllllllll<InputStream> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Uri uri) {
            return new Illllll(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, uri);
        }

        @Override // me.tvspark.Lllll
        @NonNull
        public Llllll<Uri, InputStream> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C1884Ll c1884Ll) {
            return new Uuuuuuuu(this);
        }
    }

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Data> {
        Illlllllllllllllll<Data> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Uri uri);
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Lllll<Uri, ParcelFileDescriptor>, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<ParcelFileDescriptor> {
        public final ContentResolver Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ContentResolver contentResolver) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = contentResolver;
        }

        @Override // me.tvspark.Uuuuuuuu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public Illlllllllllllllll<ParcelFileDescriptor> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Uri uri) {
            return new Illllllllllll(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, uri);
        }

        @Override // me.tvspark.Lllll
        @NonNull
        public Llllll<Uri, ParcelFileDescriptor> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C1884Ll c1884Ll) {
            return new Uuuuuuuu(this);
        }
    }

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Lllll<Uri, AssetFileDescriptor>, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<AssetFileDescriptor> {
        public final ContentResolver Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ContentResolver contentResolver) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = contentResolver;
        }

        @Override // me.tvspark.Uuuuuuuu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public Illlllllllllllllll<AssetFileDescriptor> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Uri uri) {
            return new Illllllllllllllllllll(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, uri);
        }

        @Override // me.tvspark.Lllll
        public Llllll<Uri, AssetFileDescriptor> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C1884Ll c1884Ll) {
            return new Uuuuuuuu(this);
        }
    }

    public Uuuuuuuu(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Data> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.Llllll
    public Llllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Uri uri, int i, int i2, @NonNull Illllllllllllllllllllllll illllllllllllllllllllllll) {
        Uri uri2 = uri;
        return new Llllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new C2243j1(uri2), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uri2));
    }

    @Override // me.tvspark.Llllll
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Uri uri) {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.contains(uri.getScheme());
    }
}
