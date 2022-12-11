package me.tvspark;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import me.tvspark.Zzzzzzz;

/* loaded from: classes4.dex */
public class Ccccc implements Illlllllllllllllllllllll<InputStream, Bitmap> {
    public final OO000 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Zzzzzzz Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Zzzzzzz.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final C2354m1 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final RecyclableBufferedInputStream Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(RecyclableBufferedInputStream recyclableBufferedInputStream, C2354m1 c2354m1) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = recyclableBufferedInputStream;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2354m1;
        }

        @Override // me.tvspark.Zzzzzzz.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }

        @Override // me.tvspark.Zzzzzzz.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(OO0 oo0, Bitmap bitmap) throws IOException {
            IOException iOException = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww;
            if (iOException != null) {
                if (bitmap != null) {
                    oo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bitmap);
                }
                throw iOException;
            }
        }
    }

    public Ccccc(Zzzzzzz zzzzzzz, OO000 oo000) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = zzzzzzz;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = oo000;
    }

    @Override // me.tvspark.Illlllllllllllllllllllll
    public AbstractC1886O0<Bitmap> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull InputStream inputStream, int i, int i2, @NonNull Illllllllllllllllllllllll illllllllllllllllllllllll) throws IOException {
        RecyclableBufferedInputStream recyclableBufferedInputStream;
        boolean z;
        InputStream inputStream2 = inputStream;
        if (inputStream2 instanceof RecyclableBufferedInputStream) {
            recyclableBufferedInputStream = (RecyclableBufferedInputStream) inputStream2;
            z = false;
        } else {
            recyclableBufferedInputStream = new RecyclableBufferedInputStream(inputStream2, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            z = true;
        }
        C2354m1 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2354m1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(recyclableBufferedInputStream);
        try {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new C2508q1(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2), i, i2, illllllllllllllllllllllll, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(recyclableBufferedInputStream, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2));
        } finally {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            if (z) {
                recyclableBufferedInputStream.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        }
    }

    @Override // me.tvspark.Illlllllllllllllllllllll
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull InputStream inputStream, @NonNull Illllllllllllllllllllllll illllllllllllllllllllllll) throws IOException {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            return true;
        }
        throw null;
    }
}
