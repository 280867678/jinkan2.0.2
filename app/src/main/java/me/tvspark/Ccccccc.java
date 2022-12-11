package me.tvspark;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;

/* loaded from: classes4.dex */
public class Ccccccc implements Illlllllllllllllllllllll<Uri, Bitmap> {
    public final OO0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Mmmmm Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public Ccccccc(Mmmmm mmmmm, OO0 oo0) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = mmmmm;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = oo0;
    }

    @Override // me.tvspark.Illlllllllllllllllllllll
    @Nullable
    public AbstractC1886O0<Bitmap> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Uri uri, int i, int i2, @NonNull Illllllllllllllllllllllll illllllllllllllllllllllll) throws IOException {
        AbstractC1886O0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uri);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            return null;
        }
        return Zzzzzz.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, (Drawable) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(), i, i2);
    }

    @Override // me.tvspark.Illlllllllllllllllllllll
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Uri uri, @NonNull Illllllllllllllllllllllll illllllllllllllllllllllll) throws IOException {
        return "android.resource".equals(uri.getScheme());
    }
}
