package me.tvspark;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.os.Build;
import android.util.Log;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import java.io.IOException;

@RequiresApi(api = 28)
/* loaded from: classes4.dex */
public abstract class Xxxxxxxxxx<T> implements Illlllllllllllllllllllll<ImageDecoder.Source, T> {
    public final C1890Zz Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C1890Zz.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements ImageDecoder.OnHeaderDecodedListener {
        public final /* synthetic */ PreferredColorSpace Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ DownsampleStrategy Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ DecodeFormat Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        /* renamed from: me.tvspark.Xxxxxxxxxx$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C3464Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements ImageDecoder.OnPartialImageListener {
            public C3464Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            }

            @Override // android.graphics.ImageDecoder.OnPartialImageListener
            public boolean onPartialImage(@NonNull ImageDecoder.DecodeException decodeException) {
                return false;
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, boolean z, DecodeFormat decodeFormat, DownsampleStrategy downsampleStrategy, PreferredColorSpace preferredColorSpace) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = decodeFormat;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = downsampleStrategy;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = preferredColorSpace;
        }

        @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
        @SuppressLint({"Override"})
        public void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
            ColorSpace.Named named;
            boolean z = false;
            if (Xxxxxxxxxx.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, false)) {
                imageDecoder.setAllocator(3);
            } else {
                imageDecoder.setAllocator(1);
            }
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == DecodeFormat.PREFER_RGB_565) {
                imageDecoder.setMemorySizePolicy(0);
            }
            imageDecoder.setOnPartialImageListener(new C3464Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this));
            Size size = imageInfo.getSize();
            int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i == Integer.MIN_VALUE) {
                i = size.getWidth();
            }
            int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i2 == Integer.MIN_VALUE) {
                i2 = size.getHeight();
            }
            float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(size.getWidth(), size.getHeight(), i, i2);
            int round = Math.round(size.getWidth() * Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            int round2 = Math.round(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww * size.getHeight());
            if (Log.isLoggable("ImageDecoder", 2)) {
                size.getWidth();
                size.getHeight();
            }
            imageDecoder.setTargetSize(round, round2);
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 28) {
                if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww == PreferredColorSpace.DISPLAY_P3 && imageInfo.getColorSpace() != null && imageInfo.getColorSpace().isWideGamut()) {
                    z = true;
                }
                if (z) {
                    named = ColorSpace.Named.DISPLAY_P3;
                    imageDecoder.setTargetColorSpace(ColorSpace.get(named));
                }
            } else if (i3 < 26) {
                return;
            }
            named = ColorSpace.Named.SRGB;
            imageDecoder.setTargetColorSpace(ColorSpace.get(named));
        }
    }

    @Override // me.tvspark.Illlllllllllllllllllllll
    @Nullable
    public final AbstractC1886O0<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull ImageDecoder.Source source, int i, int i2, @NonNull Illllllllllllllllllllllll illllllllllllllllllllllll) throws IOException {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i2, illllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Zzzzzzz.Wwwwwwwwwwwwwwwwwwwwwwwwww) != null && ((Boolean) illllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Zzzzzzz.Wwwwwwwwwwwwwwwwwwwwwwwwww)).booleanValue(), (DecodeFormat) illllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Zzzzzzz.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww), (DownsampleStrategy) illllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DownsampleStrategy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww), (PreferredColorSpace) illllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Zzzzzzz.Wwwwwwwwwwwwwwwwwwwwwwwwwwww));
        Xxxxx xxxxx = (Xxxxx) this;
        Bitmap decodeBitmap = ImageDecoder.decodeBitmap(source, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        if (Log.isLoggable("BitmapImageDecoder", 2)) {
            decodeBitmap.getWidth();
            decodeBitmap.getHeight();
        }
        return new Xxxx(decodeBitmap, xxxxx.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    @Override // me.tvspark.Illlllllllllllllllllllll
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull ImageDecoder.Source source, @NonNull Illllllllllllllllllllllll illllllllllllllllllllllll) throws IOException {
        return true;
    }
}
