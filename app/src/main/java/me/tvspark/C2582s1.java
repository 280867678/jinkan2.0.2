package me.tvspark;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;

/* renamed from: me.tvspark.s1 */
/* loaded from: classes4.dex */
public final class C2582s1 {
    public static final char[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = "0123456789abcdef".toCharArray();
    public static final char[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new char[64];

    /* renamed from: me.tvspark.s1$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public static final /* synthetic */ int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = iArr;
            try {
                iArr[Bitmap.Config.ALPHA_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[Bitmap.Config.RGBA_F16.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[Bitmap.Config.ARGB_8888.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        return 527 + i;
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable Object obj, @Nullable Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, @Nullable Bitmap.Config config) {
        int i3 = i * i2;
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        int i4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[config.ordinal()];
        int i5 = 4;
        if (i4 == 1) {
            i5 = 1;
        } else if (i4 == 2 || i4 == 3) {
            i5 = 2;
        } else if (i4 == 4) {
            i5 = 8;
        }
        return i3 * i5;
    }

    @TargetApi(19)
    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Bitmap bitmap) {
        if (!bitmap.isRecycled()) {
            try {
                return bitmap.getAllocationByteCount();
            } catch (NullPointerException unused) {
                return bitmap.getRowBytes() * bitmap.getHeight();
            }
        }
        throw new IllegalStateException("Cannot obtain size for recycled Bitmap: " + bitmap + "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig());
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable Object obj, int i) {
        return (i * 31) + (obj == null ? 0 : obj.hashCode());
    }

    @NonNull
    public static <T> List<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Collection<T> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (T t : collection) {
            if (t != null) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    @NonNull
    public static <T> Queue<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        return new ArrayDeque(i);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            return;
        }
        throw new IllegalArgumentException("You must call this method on the main thread");
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
        if (i > 0 || i == Integer.MIN_VALUE) {
            if (i2 > 0 || i2 == Integer.MIN_VALUE) {
                return true;
            }
        }
        return false;
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable Object obj, @Nullable Object obj2) {
        return obj == null ? obj2 == null : obj instanceof Llllllll ? ((Llllllll) obj).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj2) : obj.equals(obj2);
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f) {
        return Float.floatToIntBits(f) + 527;
    }

    @NonNull
    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull byte[] bArr) {
        String str;
        synchronized (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            char[] cArr = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            for (int i = 0; i < bArr.length; i++) {
                int i2 = bArr[i] & 255;
                int i3 = i * 2;
                char[] cArr2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                cArr[i3] = cArr2[i2 >>> 4];
                cArr[i3 + 1] = cArr2[i2 & 15];
            }
            str = new String(cArr);
        }
        return str;
    }
}
