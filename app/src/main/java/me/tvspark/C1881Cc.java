package me.tvspark;

import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import me.tvspark.Illlllllllllllllllllllllll;

/* renamed from: me.tvspark.Cc */
/* loaded from: classes4.dex */
public class C1881Cc<T> implements Illlllllllllllllllllllll<T, Bitmap> {
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final OO0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static final Illlllllllllllllllllllllll<Long> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Illlllllllllllllllllllllll<>("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
    public static final Illlllllllllllllllllllllll<Integer> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Illlllllllllllllllllllllll<>("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
    public static final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    /* renamed from: me.tvspark.Cc$Wwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwww implements Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<ParcelFileDescriptor> {
        @Override // me.tvspark.C1881Cc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(MediaMetadataRetriever mediaMetadataRetriever, ParcelFileDescriptor parcelFileDescriptor) {
            mediaMetadataRetriever.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }
    }

    @VisibleForTesting
    /* renamed from: me.tvspark.Cc$Wwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> {
        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(MediaMetadataRetriever mediaMetadataRetriever, T t);
    }

    @VisibleForTesting
    /* renamed from: me.tvspark.Cc$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    @RequiresApi(23)
    /* renamed from: me.tvspark.Cc$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<ByteBuffer> {
        @Override // me.tvspark.C1881Cc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(MediaMetadataRetriever mediaMetadataRetriever, ByteBuffer byteBuffer) {
            mediaMetadataRetriever.setDataSource(new Mmmmmmmmmmm(this, byteBuffer));
        }
    }

    /* renamed from: me.tvspark.Cc$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<AssetFileDescriptor> {
        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        }

        @Override // me.tvspark.C1881Cc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(MediaMetadataRetriever mediaMetadataRetriever, AssetFileDescriptor assetFileDescriptor) {
            AssetFileDescriptor assetFileDescriptor2 = assetFileDescriptor;
            mediaMetadataRetriever.setDataSource(assetFileDescriptor2.getFileDescriptor(), assetFileDescriptor2.getStartOffset(), assetFileDescriptor2.getLength());
        }
    }

    /* renamed from: me.tvspark.Cc$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Illlllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Integer> {
        public final ByteBuffer Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ByteBuffer.allocate(4);

        @Override // me.tvspark.Illlllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull byte[] bArr, @NonNull Integer num, @NonNull MessageDigest messageDigest) {
            if (num == null) {
                return;
            }
            messageDigest.update(bArr);
            synchronized (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.position(0);
                messageDigest.update(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.putInt(num.intValue()).array());
            }
        }
    }

    /* renamed from: me.tvspark.Cc$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Illlllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Long> {
        public final ByteBuffer Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ByteBuffer.allocate(8);

        @Override // me.tvspark.Illlllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull byte[] bArr, @NonNull Long l, @NonNull MessageDigest messageDigest) {
            messageDigest.update(bArr);
            synchronized (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.position(0);
                messageDigest.update(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.putLong(l.longValue()).array());
            }
        }
    }

    public C1881Cc(OO0 oo0, Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = oo0;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.Illlllllllllllllllllllll
    public AbstractC1886O0<Bitmap> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull T t, int i, int i2, @NonNull Illllllllllllllllllllllll illllllllllllllllllllllll) throws IOException {
        long longValue = ((Long) illllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)).longValue();
        if (longValue >= 0 || longValue == -1) {
            Integer num = (Integer) illllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            if (num == null) {
                num = 2;
            }
            DownsampleStrategy downsampleStrategy = (DownsampleStrategy) illllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DownsampleStrategy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            if (downsampleStrategy == null) {
                downsampleStrategy = DownsampleStrategy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            DownsampleStrategy downsampleStrategy2 = downsampleStrategy;
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                try {
                    try {
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mediaMetadataRetriever, t);
                        Bitmap Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mediaMetadataRetriever, longValue, num.intValue(), i, i2, downsampleStrategy2);
                        mediaMetadataRetriever.release();
                        return Xxxx.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    } catch (RuntimeException e) {
                        throw new IOException(e);
                    }
                } catch (Throwable th) {
                    mediaMetadataRetriever.release();
                    throw th;
                }
            }
            throw null;
        }
        throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Requested frame must be non-negative, or DEFAULT_FRAME, given: ", longValue));
    }

    @Override // me.tvspark.Illlllllllllllllllllllll
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull T t, @NonNull Illllllllllllllllllllllll illllllllllllllllllllllll) {
        return true;
    }

    @Nullable
    public static Bitmap Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(MediaMetadataRetriever mediaMetadataRetriever, long j, int i, int i2, int i3, DownsampleStrategy downsampleStrategy) {
        Bitmap bitmap = null;
        if (Build.VERSION.SDK_INT >= 27 && i2 != Integer.MIN_VALUE && i3 != Integer.MIN_VALUE && downsampleStrategy != DownsampleStrategy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            try {
                int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
                int parseInt2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
                int parseInt3 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
                if (parseInt3 == 90 || parseInt3 == 270) {
                    parseInt2 = parseInt;
                    parseInt = parseInt2;
                }
                float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = downsampleStrategy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(parseInt, parseInt2, i2, i3);
                bitmap = mediaMetadataRetriever.getScaledFrameAtTime(j, i, Math.round(parseInt * Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2), Math.round(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 * parseInt2));
            } catch (Throwable unused) {
                Log.isLoggable("VideoDecoder", 3);
            }
        }
        return bitmap == null ? mediaMetadataRetriever.getFrameAtTime(j, i) : bitmap;
    }
}
