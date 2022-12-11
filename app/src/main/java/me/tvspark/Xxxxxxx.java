package me.tvspark;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.EncodeStrategy;
import java.io.File;

/* loaded from: classes4.dex */
public class Xxxxxxx implements Illllllllllllllllllllll<BitmapDrawable> {
    public final Illllllllllllllllllllll<Bitmap> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final OO0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public Xxxxxxx(OO0 oo0, Illllllllllllllllllllll<Bitmap> illllllllllllllllllllll) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = oo0;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = illllllllllllllllllllll;
    }

    @Override // me.tvspark.Illllllllllllllllllllll
    @NonNull
    public EncodeStrategy Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Illllllllllllllllllllllll illllllllllllllllllllllll) {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(illllllllllllllllllllllll);
    }

    @Override // me.tvspark.AbstractC1883Kk
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Object obj, @NonNull File file, @NonNull Illllllllllllllllllllllll illllllllllllllllllllllll) {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Xxxx(((BitmapDrawable) ((AbstractC1886O0) obj).get()).getBitmap(), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), file, illllllllllllllllllllllll);
    }
}
