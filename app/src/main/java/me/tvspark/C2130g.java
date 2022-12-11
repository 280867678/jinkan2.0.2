package me.tvspark;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.ByteArrayOutputStream;

/* renamed from: me.tvspark.g */
/* loaded from: classes4.dex */
public class C2130g implements AbstractC2278k<Bitmap, byte[]> {
    public final Bitmap.CompressFormat Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Bitmap.CompressFormat.JPEG;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 100;

    @Override // me.tvspark.AbstractC2278k
    @Nullable
    public AbstractC1886O0<byte[]> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull AbstractC1886O0<Bitmap> abstractC1886O0, @NonNull Illllllllllllllllllllllll illllllllllllllllllllllll) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        abstractC1886O0.get().compress(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, byteArrayOutputStream);
        abstractC1886O0.recycle();
        return new Mmmmmmmmm(byteArrayOutputStream.toByteArray());
    }
}
