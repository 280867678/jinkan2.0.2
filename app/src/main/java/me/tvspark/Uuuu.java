package me.tvspark;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.stub.StubApp;
import java.io.InputStream;
import me.tvspark.Illll;
import me.tvspark.Llllll;

/* loaded from: classes4.dex */
public class Uuuu implements Llllll<Uri, InputStream> {
    public final Context Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Lllll<Uri, InputStream> {
        public final Context Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = context;
        }

        @Override // me.tvspark.Lllll
        @NonNull
        public Llllll<Uri, InputStream> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C1884Ll c1884Ll) {
            return new Uuuu(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    public Uuuu(Context context) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    @Override // me.tvspark.Llllll
    public Llllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<InputStream> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Uri uri, int i, int i2, @NonNull Illllllllllllllllllllllll illllllllllllllllllllllll) {
        Uri uri2 = uri;
        if (Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i2)) {
            C2243j1 c2243j1 = new C2243j1(uri2);
            Context context = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            return new Llllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<>(c2243j1, Illll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, uri2, new Illll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context.getContentResolver())));
        }
        return null;
    }

    @Override // me.tvspark.Llllll
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Uri uri) {
        Uri uri2 = uri;
        return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uri2) && !uri2.getPathSegments().contains("video");
    }
}
