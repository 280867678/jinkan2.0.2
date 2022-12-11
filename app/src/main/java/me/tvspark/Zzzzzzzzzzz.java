package me.tvspark;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.IOException;
import java.nio.ByteBuffer;

@RequiresApi(api = 28)
/* loaded from: classes4.dex */
public final class Zzzzzzzzzzz implements Illlllllllllllllllllllll<ByteBuffer, Bitmap> {
    public final Xxxxx Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Xxxxx();

    @Override // me.tvspark.Illlllllllllllllllllllll
    @Nullable
    public AbstractC1886O0<Bitmap> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull ByteBuffer byteBuffer, int i, int i2, @NonNull Illllllllllllllllllllllll illllllllllllllllllllllll) throws IOException {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ImageDecoder.createSource(byteBuffer), i, i2, illllllllllllllllllllllll);
    }

    @Override // me.tvspark.Illlllllllllllllllllllll
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull ByteBuffer byteBuffer, @NonNull Illllllllllllllllllllllll illllllllllllllllllllllll) throws IOException {
        return true;
    }
}
