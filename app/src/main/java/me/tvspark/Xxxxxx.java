package me.tvspark;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.EncodeStrategy;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes4.dex */
public class Xxxxxx implements Illllllllllllllllllllll<Bitmap> {
    @Nullable
    public final OO000 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static final Illlllllllllllllllllllllll<Integer> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Illlllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);
    public static final Illlllllllllllllllllllllll<Bitmap.CompressFormat> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Illlllllllllllllllllllllll<>("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat", null, Illlllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);

    public Xxxxxx(@NonNull OO000 oo000) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = oo000;
    }

    @Override // me.tvspark.Illllllllllllllllllllll
    @NonNull
    public EncodeStrategy Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Illllllllllllllllllllllll illllllllllllllllllllllll) {
        return EncodeStrategy.TRANSFORMED;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x005d, code lost:
        if (r6 == null) goto L22;
     */
    @Override // me.tvspark.AbstractC1883Kk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Object obj, @NonNull File file, @NonNull Illllllllllllllllllllllll illllllllllllllllllllllll) {
        OutputStream outputStream;
        Bitmap bitmap = (Bitmap) ((AbstractC1886O0) obj).get();
        Bitmap.CompressFormat compressFormat = (Bitmap.CompressFormat) illllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        if (compressFormat == null) {
            compressFormat = bitmap.hasAlpha() ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG;
        }
        bitmap.getWidth();
        bitmap.getHeight();
        long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2428o1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        int intValue = ((Integer) illllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)).intValue();
        boolean z = false;
        Illllllllllllllllll illllllllllllllllll = null;
        try {
            try {
                outputStream = new FileOutputStream(file);
            } catch (IOException unused) {
            }
        } catch (Throwable th) {
            th = th;
            outputStream = illllllllllllllllll;
        }
        try {
            illllllllllllllllll = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null ? new Illllllllllllllllll(outputStream, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) : outputStream;
            bitmap.compress(compressFormat, intValue, illllllllllllllllll);
            illllllllllllllllll.close();
            z = true;
        } catch (IOException unused2) {
            illllllllllllllllll = outputStream;
            Log.isLoggable("BitmapEncoder", 3);
        } catch (Throwable th2) {
            th = th2;
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException unused3) {
                }
            }
            throw th;
        }
        try {
            illllllllllllllllll.close();
        } catch (IOException unused4) {
        }
        if (Log.isLoggable("BitmapEncoder", 2)) {
            String str = "Compressed with type: " + compressFormat + " of size " + C2582s1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bitmap) + " in " + C2428o1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) + ", options format: " + illllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) + ", hasAlpha: " + bitmap.hasAlpha();
        }
        return z;
    }
}
