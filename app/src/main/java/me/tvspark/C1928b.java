package me.tvspark;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import java.security.MessageDigest;

/* renamed from: me.tvspark.b */
/* loaded from: classes4.dex */
public class C1928b implements Illlllllllllllllllllll<GifDrawable> {
    public final Illlllllllllllllllllll<Bitmap> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C1928b(Illlllllllllllllllllll<Bitmap> illlllllllllllllllllll) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(illlllllllllllllllllll, "Argument must not be null");
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = illlllllllllllllllllll;
    }

    @Override // me.tvspark.Illlllllllllllllllllll
    @NonNull
    public AbstractC1886O0<GifDrawable> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Context context, @NonNull AbstractC1886O0<GifDrawable> abstractC1886O0, int i, int i2) {
        GifDrawable gifDrawable = abstractC1886O0.get();
        AbstractC1886O0<Bitmap> xxxx = new Xxxx(gifDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), Kkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context).Wwwwwwwwwwwwwwwwwwwwwwww);
        AbstractC1886O0<Bitmap> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, xxxx, i, i2);
        if (!xxxx.equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
            xxxx.recycle();
        }
        Illlllllllllllllllllll<Bitmap> illlllllllllllllllllll = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        gifDrawable.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(illlllllllllllllllllll, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get());
        return abstractC1886O0;
    }

    @Override // me.tvspark.Illlllllllllllllllllllllllll
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull MessageDigest messageDigest) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(messageDigest);
    }

    @Override // me.tvspark.Illlllllllllllllllllllllllll
    public boolean equals(Object obj) {
        if (obj instanceof C1928b) {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(((C1928b) obj).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        return false;
    }

    @Override // me.tvspark.Illlllllllllllllllllllllllll
    public int hashCode() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.hashCode();
    }
}
