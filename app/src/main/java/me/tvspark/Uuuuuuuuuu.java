package me.tvspark;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.io.File;
import java.io.InputStream;
import me.tvspark.Llllll;

/* loaded from: classes4.dex */
public class Uuuuuuuuuu<Data> implements Llllll<String, Data> {
    public final Llllll<Uri, Data> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Lllll<String, InputStream> {
        @Override // me.tvspark.Lllll
        @NonNull
        public Llllll<String, InputStream> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull C1884Ll c1884Ll) {
            return new Uuuuuuuuuu(c1884Ll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Uri.class, InputStream.class));
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Lllll<String, ParcelFileDescriptor> {
        @Override // me.tvspark.Lllll
        @NonNull
        public Llllll<String, ParcelFileDescriptor> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull C1884Ll c1884Ll) {
            return new Uuuuuuuuuu(c1884Ll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Uri.class, ParcelFileDescriptor.class));
        }
    }

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Lllll<String, AssetFileDescriptor> {
        @Override // me.tvspark.Lllll
        public Llllll<String, AssetFileDescriptor> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull C1884Ll c1884Ll) {
            return new Uuuuuuuuuu(c1884Ll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Uri.class, AssetFileDescriptor.class));
        }
    }

    public Uuuuuuuuuu(Llllll<Uri, Data> llllll) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = llllll;
    }

    @Override // me.tvspark.Llllll
    public Llllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull String str, int i, int i2, @NonNull Illllllllllllllllllllllll illllllllllllllllllllllll) {
        Uri parse;
        File file;
        String str2 = str;
        if (TextUtils.isEmpty(str2)) {
            parse = null;
        } else {
            if (str2.charAt(0) == '/') {
                file = new File(str2);
            } else {
                parse = Uri.parse(str2);
                if (parse.getScheme() == null) {
                    file = new File(str2);
                }
            }
            parse = Uri.fromFile(file);
        }
        if (parse == null || !this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(parse)) {
            return null;
        }
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(parse, i, i2, illllllllllllllllllllllll);
    }

    @Override // me.tvspark.Llllll
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull String str) {
        return true;
    }
}
