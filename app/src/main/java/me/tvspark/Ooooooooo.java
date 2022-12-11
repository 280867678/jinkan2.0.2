package me.tvspark;

import android.content.res.AssetManager;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import java.io.InputStream;
import me.tvspark.Llllll;

/* loaded from: classes4.dex */
public class Ooooooooo<Data> implements Llllll<Uri, Data> {
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Data> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final AssetManager Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Lllll<Uri, InputStream>, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<InputStream> {
        public final AssetManager Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AssetManager assetManager) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = assetManager;
        }

        @Override // me.tvspark.Ooooooooo.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public Illlllllllllllllll<InputStream> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AssetManager assetManager, String str) {
            return new Illlllll(assetManager, str);
        }

        @Override // me.tvspark.Lllll
        @NonNull
        public Llllll<Uri, InputStream> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C1884Ll c1884Ll) {
            return new Ooooooooo(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this);
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Lllll<Uri, ParcelFileDescriptor>, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<ParcelFileDescriptor> {
        public final AssetManager Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AssetManager assetManager) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = assetManager;
        }

        @Override // me.tvspark.Ooooooooo.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public Illlllllllllllllll<ParcelFileDescriptor> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AssetManager assetManager, String str) {
            return new Illlllllllllll(assetManager, str);
        }

        @Override // me.tvspark.Lllll
        @NonNull
        public Llllll<Uri, ParcelFileDescriptor> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C1884Ll c1884Ll) {
            return new Ooooooooo(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this);
        }
    }

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Data> {
        Illlllllllllllllll<Data> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AssetManager assetManager, String str);
    }

    public Ooooooooo(AssetManager assetManager, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Data> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = assetManager;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.Llllll
    public Llllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Uri uri, int i, int i2, @NonNull Illllllllllllllllllllllll illllllllllllllllllllllll) {
        Uri uri2 = uri;
        return new Llllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new C2243j1(uri2), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, uri2.toString().substring(22)));
    }

    @Override // me.tvspark.Llllll
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Uri uri) {
        Uri uri2 = uri;
        return "file".equals(uri2.getScheme()) && !uri2.getPathSegments().isEmpty() && "android_asset".equals(uri2.getPathSegments().get(0));
    }
}
