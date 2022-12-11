package me.tvspark;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* renamed from: me.tvspark.f */
/* loaded from: classes4.dex */
public class C2093f implements Illlllllllllllllllllllll<InputStream, GifDrawable> {
    public final OO000 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Illlllllllllllllllllllll<ByteBuffer, GifDrawable> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final List<ImageHeaderParser> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2093f(List<ImageHeaderParser> list, Illlllllllllllllllllllll<ByteBuffer, GifDrawable> illlllllllllllllllllllll, OO000 oo000) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = list;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = illlllllllllllllllllllll;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = oo000;
    }

    @Override // me.tvspark.Illlllllllllllllllllllll
    public AbstractC1886O0<GifDrawable> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull InputStream inputStream, int i, int i2, @NonNull Illllllllllllllllllllllll illllllllllllllllllllllll) throws IOException {
        byte[] bArr;
        InputStream inputStream2 = inputStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr2 = new byte[16384];
            while (true) {
                int read = inputStream2.read(bArr2);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr2, 0, read);
            }
            byteArrayOutputStream.flush();
            bArr = byteArrayOutputStream.toByteArray();
        } catch (IOException unused) {
            Log.isLoggable("StreamGifDecoder", 5);
            bArr = null;
        }
        if (bArr == null) {
            return null;
        }
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ByteBuffer.wrap(bArr), i, i2, illllllllllllllllllllllll);
    }

    @Override // me.tvspark.Illlllllllllllllllllllll
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull InputStream inputStream, @NonNull Illllllllllllllllllllllll illllllllllllllllllllllll) throws IOException {
        return !((Boolean) illllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2056e.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)).booleanValue() && Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, inputStream, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) == ImageHeaderParser.ImageType.GIF;
    }
}
