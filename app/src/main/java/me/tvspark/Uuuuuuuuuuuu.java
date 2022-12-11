package me.tvspark;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import java.io.InputStream;
import me.tvspark.Llllll;

/* loaded from: classes4.dex */
public class Uuuuuuuuuuuu<Data> implements Llllll<Integer, Data> {
    public final Resources Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Llllll<Uri, Data> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Lllll<Integer, Uri> {
        public final Resources Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Resources resources) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = resources;
        }

        @Override // me.tvspark.Lllll
        @NonNull
        public Llllll<Integer, Uri> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C1884Ll c1884Ll) {
            return new Uuuuuuuuuuuu(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Uuuuuuuuu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Lllll<Integer, InputStream> {
        public final Resources Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Resources resources) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = resources;
        }

        @Override // me.tvspark.Lllll
        @NonNull
        public Llllll<Integer, InputStream> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C1884Ll c1884Ll) {
            return new Uuuuuuuuuuuu(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c1884Ll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Uri.class, InputStream.class));
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Lllll<Integer, ParcelFileDescriptor> {
        public final Resources Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Resources resources) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = resources;
        }

        @Override // me.tvspark.Lllll
        @NonNull
        public Llllll<Integer, ParcelFileDescriptor> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C1884Ll c1884Ll) {
            return new Uuuuuuuuuuuu(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c1884Ll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Uri.class, ParcelFileDescriptor.class));
        }
    }

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Lllll<Integer, AssetFileDescriptor> {
        public final Resources Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Resources resources) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = resources;
        }

        @Override // me.tvspark.Lllll
        public Llllll<Integer, AssetFileDescriptor> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C1884Ll c1884Ll) {
            return new Uuuuuuuuuuuu(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c1884Ll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Uri.class, AssetFileDescriptor.class));
        }
    }

    public Uuuuuuuuuuuu(Resources resources, Llllll<Uri, Data> llllll) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = resources;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = llllll;
    }

    @Override // me.tvspark.Llllll
    public Llllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Integer num, int i, int i2, @NonNull Illllllllllllllllllllllll illllllllllllllllllllllll) {
        Uri uri;
        Integer num2 = num;
        try {
            uri = Uri.parse("android.resource://" + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getResourcePackageName(num2.intValue()) + '/' + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getResourceTypeName(num2.intValue()) + '/' + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getResourceEntryName(num2.intValue()));
        } catch (Resources.NotFoundException unused) {
            if (Log.isLoggable("ResourceLoader", 5)) {
                String str = "Received invalid resource id: " + num2;
            }
            uri = null;
        }
        if (uri == null) {
            return null;
        }
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uri, i, i2, illllllllllllllllllllllll);
    }

    @Override // me.tvspark.Llllll
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Integer num) {
        return true;
    }
}
