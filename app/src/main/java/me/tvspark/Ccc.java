package me.tvspark;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class Ccc implements Illlllllllllllllllllllll<Bitmap, Bitmap> {

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements AbstractC1886O0<Bitmap> {
        public final Bitmap Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Bitmap bitmap) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = bitmap;
        }

        @Override // me.tvspark.AbstractC1886O0
        @NonNull
        public Class<Bitmap> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return Bitmap.class;
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
        }
    }

    @Override // me.tvspark.Illlllllllllllllllllllll
    public AbstractC1886O0<Bitmap> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Bitmap bitmap, int i, int i2, @NonNull Illllllllllllllllllllllll illllllllllllllllllllllll) throws IOException {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bitmap);
    }

    @Override // me.tvspark.Illlllllllllllllllllllll
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Bitmap bitmap, @NonNull Illllllllllllllllllllllll illllllllllllllllllllllll) throws IOException {
        return true;
    }
}
