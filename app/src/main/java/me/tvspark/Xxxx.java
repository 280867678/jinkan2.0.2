package me.tvspark;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes4.dex */
public class Xxxx implements AbstractC1886O0<Bitmap>, O00000 {
    public final OO0 Wwwwwwwwwwwwwwwwwwwwwww;
    public final Bitmap Wwwwwwwwwwwwwwwwwwwwwwww;

    public Xxxx(@NonNull Bitmap bitmap, @NonNull OO0 oo0) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bitmap, "Bitmap must not be null");
        this.Wwwwwwwwwwwwwwwwwwwwwwww = bitmap;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(oo0, "BitmapPool must not be null");
        this.Wwwwwwwwwwwwwwwwwwwwwww = oo0;
    }

    @Nullable
    public static Xxxx Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable Bitmap bitmap, @NonNull OO0 oo0) {
        if (bitmap == null) {
            return null;
        }
        return new Xxxx(bitmap, oo0);
    }

    @Override // me.tvspark.AbstractC1886O0
    @NonNull
    public Class<Bitmap> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return Bitmap.class;
    }

    @Override // me.tvspark.O00000
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.prepareToDraw();
    }

    @Override // me.tvspark.AbstractC1886O0
    @NonNull
    public Bitmap get() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.AbstractC1886O0
    public int getSize() {
        return C2582s1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww);
    }

    @Override // me.tvspark.AbstractC1886O0
    public void recycle() {
        this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww);
    }
}
