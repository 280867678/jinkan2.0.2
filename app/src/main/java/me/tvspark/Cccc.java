package me.tvspark;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes4.dex */
public final class Cccc {
    public static final Lock Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static final Set<String> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static final Paint Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static final Paint Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Paint(6);
    public static final Paint Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Paint(7);

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Lock {
        @Override // java.util.concurrent.locks.Lock
        public void lock() {
        }

        @Override // java.util.concurrent.locks.Lock
        public void lockInterruptibly() throws InterruptedException {
        }

        @Override // java.util.concurrent.locks.Lock
        @NonNull
        public Condition newCondition() {
            throw new UnsupportedOperationException("Should not be called");
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock() {
            return true;
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock(long j, @NonNull TimeUnit timeUnit) throws InterruptedException {
            return true;
        }

        @Override // java.util.concurrent.locks.Lock
        public void unlock() {
        }
    }

    static {
        HashSet hashSet = new HashSet(Arrays.asList("XT1085", "XT1092", "XT1093", "XT1094", "XT1095", "XT1096", "XT1097", "XT1098", "XT1031", "XT1028", "XT937C", "XT1032", "XT1008", "XT1033", "XT1035", "XT1034", "XT939G", "XT1039", "XT1040", "XT1042", "XT1045", "XT1063", "XT1064", "XT1068", "XT1069", "XT1072", "XT1077", "XT1078", "XT1079"));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = hashSet;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = hashSet.contains(Build.MODEL) ? new ReentrantLock() : new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Paint paint = new Paint(7);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    public static Bitmap Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull OO0 oo0, @NonNull Bitmap bitmap, int i, int i2) {
        if (bitmap.getWidth() == i && bitmap.getHeight() == i2) {
            Log.isLoggable("TransformationUtils", 2);
            return bitmap;
        }
        float min = Math.min(i / bitmap.getWidth(), i2 / bitmap.getHeight());
        int round = Math.round(bitmap.getWidth() * min);
        int round2 = Math.round(bitmap.getHeight() * min);
        if (bitmap.getWidth() == round && bitmap.getHeight() == round2) {
            Log.isLoggable("TransformationUtils", 2);
            return bitmap;
        }
        Bitmap Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = oo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) (bitmap.getWidth() * min), (int) (bitmap.getHeight() * min), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bitmap));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.setHasAlpha(bitmap.hasAlpha());
        if (Log.isLoggable("TransformationUtils", 2)) {
            bitmap.getWidth();
            bitmap.getHeight();
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getWidth();
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getHeight();
        }
        Matrix matrix = new Matrix();
        matrix.setScale(min, min);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bitmap, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, matrix);
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
    }

    public static Bitmap Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull OO0 oo0, @NonNull Bitmap bitmap, int i, int i2) {
        int min = Math.min(i, i2);
        float f = min;
        float f2 = f / 2.0f;
        float width = bitmap.getWidth();
        float height = bitmap.getHeight();
        float max = Math.max(f / width, f / height);
        float f3 = width * max;
        float f4 = max * height;
        float f5 = (f - f3) / 2.0f;
        float f6 = (f - f4) / 2.0f;
        RectF rectF = new RectF(f5, f6, f3 + f5, f4 + f6);
        Bitmap Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(oo0, bitmap);
        Bitmap Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = oo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(min, min, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bitmap));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.setHasAlpha(true);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.lock();
        try {
            Canvas canvas = new Canvas(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
            canvas.drawCircle(f2, f2, f2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            canvas.drawBitmap(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, (Rect) null, rectF, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            canvas.setBitmap(null);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.unlock();
            if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.equals(bitmap)) {
                oo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            }
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
        } catch (Throwable th) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.unlock();
            throw th;
        }
    }

    @NonNull
    public static Bitmap.Config Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Bitmap bitmap) {
        return bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888;
    }

    public static Bitmap Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull OO0 oo0, @NonNull Bitmap bitmap, int i, int i2) {
        if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
            Log.isLoggable("TransformationUtils", 2);
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(oo0, bitmap, i, i2);
        }
        Log.isLoggable("TransformationUtils", 2);
        return bitmap;
    }

    @NonNull
    public static Bitmap.Config Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Bitmap bitmap) {
        return (Build.VERSION.SDK_INT < 26 || !Bitmap.Config.RGBA_F16.equals(bitmap.getConfig())) ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGBA_F16;
    }

    public static Bitmap Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull OO0 oo0, @NonNull Bitmap bitmap) {
        Bitmap.Config Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bitmap);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.equals(bitmap.getConfig())) {
            return bitmap;
        }
        Bitmap Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = oo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bitmap.getWidth(), bitmap.getHeight(), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        new Canvas(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3).drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Bitmap bitmap, @NonNull Bitmap bitmap2, Matrix matrix) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.lock();
        try {
            Canvas canvas = new Canvas(bitmap2);
            canvas.drawBitmap(bitmap, matrix, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            canvas.setBitmap(null);
        } finally {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.unlock();
        }
    }

    public static Bitmap Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull OO0 oo0, @NonNull Bitmap bitmap, int i, int i2) {
        float width;
        float height;
        if (bitmap.getWidth() == i && bitmap.getHeight() == i2) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        float f = 0.0f;
        if (bitmap.getWidth() * i2 > bitmap.getHeight() * i) {
            width = i2 / bitmap.getHeight();
            f = (i - (bitmap.getWidth() * width)) * 0.5f;
            height = 0.0f;
        } else {
            width = i / bitmap.getWidth();
            height = (i2 - (bitmap.getHeight() * width)) * 0.5f;
        }
        matrix.setScale(width, width);
        matrix.postTranslate((int) (f + 0.5f), (int) (height + 0.5f));
        Bitmap Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = oo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bitmap));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.setHasAlpha(bitmap.hasAlpha());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bitmap, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, matrix);
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
    }

    public static Bitmap Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull OO0 oo0, @NonNull Bitmap bitmap, int i) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i > 0, "roundingRadius must be greater than 0.");
        Bitmap.Config Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bitmap);
        Bitmap Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(oo0, bitmap);
        Bitmap Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = oo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.getWidth(), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.getHeight(), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.setHasAlpha(true);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, tileMode, tileMode);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(bitmapShader);
        RectF rectF = new RectF(0.0f, 0.0f, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.getWidth(), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.getHeight());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.lock();
        try {
            Canvas canvas = new Canvas(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4);
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            float f = i;
            canvas.drawRoundRect(rectF, f, f, paint);
            canvas.setBitmap(null);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.unlock();
            if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.equals(bitmap)) {
                oo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
            }
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4;
        } catch (Throwable th) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.unlock();
            throw th;
        }
    }
}
