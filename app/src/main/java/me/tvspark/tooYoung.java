package me.tvspark;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.stub.StubApp;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/* loaded from: classes4.dex */
public class tooYoung implements Illlllllllllllllllllllll<ByteBuffer, GifDrawable> {
    public final tooSimple Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final List<ImageHeaderParser> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Context Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public static final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    @VisibleForTesting
    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    public tooYoung(Context context, List<ImageHeaderParser> list, OO0 oo0, OO000 oo000) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = list;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new tooSimple(oo0, oo000);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.Illlllllllllllllllllllll
    public AbstractC1886O0<GifDrawable> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull ByteBuffer byteBuffer, int i, int i2, @NonNull Illllllllllllllllllllllll illllllllllllllllllllllll) throws IOException {
        ByteBuffer byteBuffer2 = byteBuffer;
        Kkkk Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteBuffer2);
        try {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteBuffer2, i, i2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, illllllllllllllllllllllll);
        } finally {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        }
    }

    @Nullable
    public final C1891a Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ByteBuffer byteBuffer, int i, int i2, Kkkk kkkk, Illllllllllllllllllllllll illllllllllllllllllllllll) {
        long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2428o1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        try {
            Kkkkk Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = kkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww > 0 && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 0) {
                Bitmap.Config config = illllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2056e.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) == DecodeFormat.PREFER_RGB_565 ? Bitmap.Config.RGB_565 : Bitmap.Config.ARGB_8888;
                int min = Math.min(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwww / i2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww / i);
                int max = Math.max(1, min == 0 ? 0 : Integer.highestOneBit(min));
                Log.isLoggable("BufferGifDecoder", 2);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                tooSimple toosimple = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                    Kkk kkk = new Kkk(toosimple, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, byteBuffer, max);
                    kkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(config);
                    kkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    Bitmap Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = kkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 == null) {
                        return null;
                    }
                    C1891a c1891a = new C1891a(new GifDrawable(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, kkk, (Xxxxxxxxx) Xxxxxxxxx.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i, i2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3));
                    if (Log.isLoggable("BufferGifDecoder", 2)) {
                        C2428o1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                    }
                    return c1891a;
                }
                throw null;
            }
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                C2428o1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            }
            return null;
        } finally {
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                C2428o1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            }
        }
    }

    @VisibleForTesting
    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final Queue<Kkkk> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2582s1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);

        public synchronized Kkkk Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ByteBuffer byteBuffer) {
            Kkkk poll;
            poll = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.poll();
            if (poll == null) {
                poll = new Kkkk();
            }
            poll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            Arrays.fill(poll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, (byte) 0);
            poll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Kkkkk();
            poll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
            ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
            poll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = asReadOnlyBuffer;
            asReadOnlyBuffer.position(0);
            poll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.order(ByteOrder.LITTLE_ENDIAN);
            return poll;
        }

        public synchronized void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Kkkk kkkk) {
            kkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            kkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.offer(kkkk);
        }
    }

    @Override // me.tvspark.Illlllllllllllllllllllll
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull ByteBuffer byteBuffer, @NonNull Illllllllllllllllllllllll illllllllllllllllllllllll) throws IOException {
        ImageHeaderParser.ImageType imageType;
        ByteBuffer byteBuffer2 = byteBuffer;
        if (!((Boolean) illllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2056e.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)).booleanValue()) {
            List<ImageHeaderParser> list = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (byteBuffer2 == null) {
                imageType = ImageHeaderParser.ImageType.UNKNOWN;
            } else {
                int size = list.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        imageType = ImageHeaderParser.ImageType.UNKNOWN;
                        break;
                    }
                    ImageHeaderParser.ImageType Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = list.get(i).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteBuffer2);
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != ImageHeaderParser.ImageType.UNKNOWN) {
                        imageType = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                        break;
                    }
                    i++;
                }
            }
            return imageType == ImageHeaderParser.ImageType.GIF;
        }
        return false;
    }
}
