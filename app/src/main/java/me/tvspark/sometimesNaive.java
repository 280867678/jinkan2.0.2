package me.tvspark;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import java.io.File;
import java.io.IOException;

/* loaded from: classes4.dex */
public class sometimesNaive implements Illllllllllllllllllllll<GifDrawable> {
    @Override // me.tvspark.Illllllllllllllllllllll
    @NonNull
    public EncodeStrategy Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Illllllllllllllllllllllll illllllllllllllllllllllll) {
        return EncodeStrategy.SOURCE;
    }

    @Override // me.tvspark.AbstractC1883Kk
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Object obj, @NonNull File file, @NonNull Illllllllllllllllllllllll illllllllllllllllllllllll) {
        try {
            C2280k1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((GifDrawable) ((AbstractC1886O0) obj).get()).Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().asReadOnlyBuffer(), file);
            return true;
        } catch (IOException unused) {
            Log.isLoggable("GifEncoder", 5);
            return false;
        }
    }
}
