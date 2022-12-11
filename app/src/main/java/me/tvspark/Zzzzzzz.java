package me.tvspark;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import me.tvspark.Ccccccccccc;

/* loaded from: classes4.dex */
public final class Zzzzzzz {
    public final C1890Zz Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C1890Zz.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public final List<ImageHeaderParser> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final OO000 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final DisplayMetrics Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final OO0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static final Illlllllllllllllllllllllll<DecodeFormat> Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = Illlllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", DecodeFormat.DEFAULT);
    public static final Illlllllllllllllllllllllll<PreferredColorSpace> Wwwwwwwwwwwwwwwwwwwwwwwwwwww = Illlllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace", PreferredColorSpace.SRGB);
    public static final Illlllllllllllllllllllllll<Boolean> Wwwwwwwwwwwwwwwwwwwwwwwwwww = Illlllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", false);
    public static final Illlllllllllllllllllllllll<Boolean> Wwwwwwwwwwwwwwwwwwwwwwwwww = Illlllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", false);
    public static final Set<String> Wwwwwwwwwwwwwwwwwwwwwwwww = Collections.unmodifiableSet(new HashSet(Arrays.asList("image/vnd.wap.wbmp", "image/x-ico")));
    public static final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public static final Set<ImageHeaderParser.ImageType> Wwwwwwwwwwwwwwwwwwwwwww = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));
    public static final Queue<BitmapFactory.Options> Wwwwwwwwwwwwwwwwwwwwww = C2582s1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(OO0 oo0, Bitmap bitmap) throws IOException;
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        @Override // me.tvspark.Zzzzzzz.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.Zzzzzzz.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(OO0 oo0, Bitmap bitmap) {
        }
    }

    static {
        Illlllllllllllllllllllllll<DownsampleStrategy> illlllllllllllllllllllllll = DownsampleStrategy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public Zzzzzzz(List<ImageHeaderParser> list, DisplayMetrics displayMetrics, OO0 oo0, OO000 oo000) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = list;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(displayMetrics, "Argument must not be null");
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = displayMetrics;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(oo0, "Argument must not be null");
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = oo0;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(oo000, "Argument must not be null");
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = oo000;
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(double d) {
        return (int) (d + 0.5d);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        if (Build.VERSION.SDK_INT >= 26) {
            options.inPreferredColorSpace = null;
            options.outColorSpace = null;
            options.outConfig = null;
        }
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    public static int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Ccccccccccc ccccccccccc, BitmapFactory.Options options, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, OO0 oo0) throws IOException {
        options.inJustDecodeBounds = true;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ccccccccccc, options, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, oo0);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(double d) {
        if (d > 1.0d) {
            d = 1.0d / d;
        }
        return (int) Math.round(d * 2.147483647E9d);
    }

    public static synchronized BitmapFactory.Options Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        BitmapFactory.Options poll;
        synchronized (Zzzzzzz.class) {
            synchronized (Wwwwwwwwwwwwwwwwwwwwww) {
                poll = Wwwwwwwwwwwwwwwwwwwwww.poll();
            }
            if (poll == null) {
                poll = new BitmapFactory.Options();
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(poll);
            }
        }
        return poll;
    }

    @Nullable
    @TargetApi(19)
    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(" (");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(bitmap.getAllocationByteCount());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(")");
        String sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("[");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(bitmap.getWidth());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append("x");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(bitmap.getHeight());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append("] ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(bitmap.getConfig());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(sb);
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString();
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(BitmapFactory.Options options) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(options);
        synchronized (Wwwwwwwwwwwwwwwwwwwwww) {
            Wwwwwwwwwwwwwwwwwwwwww.offer(options);
        }
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        return i == 90 || i == 270;
    }

    /* JADX WARN: Code restructure failed: missing block: B:113:0x02f6, code lost:
        if (r3 >= 26) goto L111;
     */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0326  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Bitmap Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Ccccccccccc ccccccccccc, BitmapFactory.Options options, DownsampleStrategy downsampleStrategy, DecodeFormat decodeFormat, PreferredColorSpace preferredColorSpace, boolean z, int i, int i2, boolean z2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) throws IOException {
        int i3;
        boolean z3;
        int i4;
        int i5;
        int i6;
        String str;
        Zzzzzzz zzzzzzz;
        boolean z4;
        int i7;
        int i8;
        ColorSpace.Named named;
        Bitmap Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        boolean z5;
        ColorSpace colorSpace;
        Bitmap.Config config;
        int i9;
        int i10;
        int max;
        int floor;
        int floor2;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = C2428o1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ccccccccccc, options, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        int i11 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3[0];
        int i12 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3[1];
        boolean z6 = (i11 == -1 || i12 == -1) ? false : z;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = ccccccccccc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        switch (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5) {
            case 3:
            case 4:
                i3 = 180;
                break;
            case 5:
            case 6:
                i3 = 90;
                break;
            case 7:
            case 8:
                i3 = 270;
                break;
            default:
                i3 = 0;
                break;
        }
        switch (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                z3 = true;
                break;
            default:
                z3 = false;
                break;
        }
        int i13 = i;
        if (i13 == Integer.MIN_VALUE) {
            i13 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3) ? i12 : i11;
        }
        int i14 = i2;
        if (i14 == Integer.MIN_VALUE) {
            i14 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3) ? i11 : i12;
        }
        ImageHeaderParser.ImageType Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ccccccccccc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        OO0 oo0 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        boolean z7 = z6;
        boolean z8 = z3;
        if (i11 <= 0 || i12 <= 0) {
            i4 = i12;
            i5 = i11;
            i6 = i13;
            str = "Downsampler";
            if (Log.isLoggable(str, 3)) {
                String str2 = "Unable to determine dimensions for: " + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + " with target [" + i6 + "x" + i14 + "]";
            }
            zzzzzzz = this;
        } else {
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3)) {
                i10 = i12;
                i9 = i11;
            } else {
                i9 = i12;
                i10 = i11;
            }
            float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = downsampleStrategy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i10, i9, i13, i14);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 <= 0.0f) {
                throw new IllegalArgumentException("Cannot scale with factor: " + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 + " from: " + downsampleStrategy + ", source: [" + i11 + "x" + i12 + "], target: [" + i13 + "x" + i14 + "]");
            }
            DownsampleStrategy.SampleSizeRounding Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = downsampleStrategy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i10, i9, i13, i14);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 == null) {
                throw new IllegalArgumentException("Cannot round with null rounding");
            }
            float f = i10;
            int i15 = i13;
            float f2 = i9;
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = i10 / Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 * f);
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = i9 / Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 * f2);
            int max2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 == DownsampleStrategy.SampleSizeRounding.MEMORY ? Math.max(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6) : Math.min(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6);
            if (Build.VERSION.SDK_INT > 23 || !Wwwwwwwwwwwwwwwwwwwwwwwww.contains(options.outMimeType)) {
                max = Math.max(1, Integer.highestOneBit(max2));
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 == DownsampleStrategy.SampleSizeRounding.MEMORY && max < 1.0f / Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4) {
                    max <<= 1;
                }
            } else {
                max = 1;
            }
            options.inSampleSize = max;
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == ImageHeaderParser.ImageType.JPEG) {
                float min = Math.min(max, 8);
                floor = (int) Math.ceil(f / min);
                floor2 = (int) Math.ceil(f2 / min);
                int i16 = max / 8;
                if (i16 > 0) {
                    floor /= i16;
                    floor2 /= i16;
                }
            } else {
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != ImageHeaderParser.ImageType.PNG && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != ImageHeaderParser.ImageType.PNG_A) {
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == ImageHeaderParser.ImageType.WEBP || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == ImageHeaderParser.ImageType.WEBP_A) {
                        if (Build.VERSION.SDK_INT >= 24) {
                            float f3 = max;
                            floor = Math.round(f / f3);
                            floor2 = Math.round(f2 / f3);
                        }
                    } else if (i10 % max == 0 && i9 % max == 0) {
                        floor = i10 / max;
                        floor2 = i9 / max;
                    } else {
                        int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ccccccccccc, options, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, oo0);
                        floor = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7[0];
                        floor2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7[1];
                    }
                }
                float f4 = max;
                floor = (int) Math.floor(f / f4);
                floor2 = (int) Math.floor(f2 / f4);
            }
            i6 = i15;
            double Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8 = downsampleStrategy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(floor, floor2, i6, i14);
            options.inTargetDensity = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8 / (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 / Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3)) * Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8) * Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8));
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8);
            options.inDensity = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7;
            int i17 = options.inTargetDensity;
            if (i17 > 0 && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 > 0 && i17 != Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7) {
                options.inScaled = true;
            } else {
                options.inTargetDensity = 0;
                options.inDensity = 0;
            }
            str = "Downsampler";
            Log.isLoggable(str, 2);
            zzzzzzz = this;
            i4 = i12;
            i5 = i11;
        }
        boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8 = zzzzzzz.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i6, i14, z7, z8);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8) {
            options.inPreferredConfig = Bitmap.Config.HARDWARE;
            options.inMutable = false;
        }
        if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8) {
            if (decodeFormat != DecodeFormat.PREFER_ARGB_8888) {
                try {
                    z4 = ccccccccccc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().hasAlpha();
                } catch (IOException unused) {
                    if (Log.isLoggable(str, 3)) {
                        String str3 = "Cannot determine whether the image has alpha or not from header, format " + decodeFormat;
                    }
                    z4 = false;
                }
                Bitmap.Config config2 = z4 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
                options.inPreferredConfig = config2;
                if (config2 == Bitmap.Config.RGB_565) {
                    options.inDither = true;
                }
            } else {
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            }
            int i18 = options.inSampleSize;
            Bitmap bitmap = null;
            if (i5 >= 0 || i4 < 0 || !z2) {
                int i19 = options.inTargetDensity;
                float f5 = !(i19 <= 0 && (i7 = options.inDensity) > 0 && i19 != i7) ? options.inTargetDensity / options.inDensity : 1.0f;
                float f6 = options.inSampleSize;
                int round = Math.round(((int) Math.ceil(i5 / f6)) * f5);
                i14 = Math.round(((int) Math.ceil(i4 / f6)) * f5);
                Log.isLoggable(str, 2);
                i6 = round;
            }
            if (i6 > 0 && i14 > 0) {
                OO0 oo02 = zzzzzzz.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (Build.VERSION.SDK_INT >= 26) {
                    config = null;
                } else if (options.inPreferredConfig != Bitmap.Config.HARDWARE) {
                    config = options.outConfig;
                }
                if (config == null) {
                    config = options.inPreferredConfig;
                }
                options.inBitmap = oo02.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i6, i14, config);
            }
            i8 = Build.VERSION.SDK_INT;
            if (i8 < 28) {
                if (preferredColorSpace == PreferredColorSpace.DISPLAY_P3 && (colorSpace = options.outColorSpace) != null && colorSpace.isWideGamut()) {
                    named = ColorSpace.Named.DISPLAY_P3;
                    options.inPreferredColorSpace = ColorSpace.get(named);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ccccccccccc, options, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, zzzzzzz.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(zzzzzzz.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                    if (Log.isLoggable(str, 2)) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(options.inBitmap);
                        Thread.currentThread().getName();
                        C2428o1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4);
                    }
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.setDensity(zzzzzzz.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.densityDpi);
                        OO0 oo03 = zzzzzzz.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        switch (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5) {
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                                z5 = true;
                                break;
                            default:
                                z5 = false;
                                break;
                        }
                        if (!z5) {
                            bitmap = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                        } else {
                            Matrix matrix = new Matrix();
                            switch (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5) {
                                case 2:
                                    matrix.setScale(-1.0f, 1.0f);
                                    break;
                                case 3:
                                    matrix.setRotate(180.0f);
                                    break;
                                case 4:
                                    matrix.setRotate(180.0f);
                                    matrix.postScale(-1.0f, 1.0f);
                                    break;
                                case 5:
                                    matrix.setRotate(90.0f);
                                    matrix.postScale(-1.0f, 1.0f);
                                    break;
                                case 6:
                                    matrix.setRotate(90.0f);
                                    break;
                                case 7:
                                    matrix.setRotate(-90.0f);
                                    matrix.postScale(-1.0f, 1.0f);
                                    break;
                                case 8:
                                    matrix.setRotate(-90.0f);
                                    break;
                            }
                            RectF rectF = new RectF(0.0f, 0.0f, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getWidth(), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getHeight());
                            matrix.mapRect(rectF);
                            Bitmap Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9 = oo03.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Math.round(rectF.width()), Math.round(rectF.height()), Cccc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2));
                            matrix.postTranslate(-rectF.left, -rectF.top);
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9.setHasAlpha(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.hasAlpha());
                            Cccc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9, matrix);
                            bitmap = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9;
                        }
                        if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.equals(bitmap)) {
                            zzzzzzz.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                        }
                    }
                    return bitmap;
                }
            }
            named = ColorSpace.Named.SRGB;
            options.inPreferredColorSpace = ColorSpace.get(named);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ccccccccccc, options, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, zzzzzzz.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(zzzzzzz.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            if (Log.isLoggable(str, 2)) {
            }
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null) {
            }
            return bitmap;
        }
        int i182 = options.inSampleSize;
        Bitmap bitmap2 = null;
        if (i5 >= 0) {
        }
        int i192 = options.inTargetDensity;
        if (!(i192 <= 0 && (i7 = options.inDensity) > 0 && i192 != i7)) {
        }
        float f62 = options.inSampleSize;
        int round2 = Math.round(((int) Math.ceil(i5 / f62)) * f5);
        i14 = Math.round(((int) Math.ceil(i4 / f62)) * f5);
        Log.isLoggable(str, 2);
        i6 = round2;
        if (i6 > 0) {
            OO0 oo022 = zzzzzzz.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (Build.VERSION.SDK_INT >= 26) {
            }
            if (config == null) {
            }
            options.inBitmap = oo022.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i6, i14, config);
        }
        i8 = Build.VERSION.SDK_INT;
        if (i8 < 28) {
        }
        named = ColorSpace.Named.SRGB;
        options.inPreferredColorSpace = ColorSpace.get(named);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ccccccccccc, options, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, zzzzzzz.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(zzzzzzz.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        if (Log.isLoggable(str, 2)) {
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null) {
        }
        return bitmap2;
    }

    public AbstractC1886O0<Bitmap> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(InputStream inputStream, int i, int i2, Illllllllllllllllllllllll illllllllllllllllllllllll, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) throws IOException {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Ccccccccccc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(inputStream, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), i, i2, illllllllllllllllllllllll, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public final AbstractC1886O0<Bitmap> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Ccccccccccc ccccccccccc, int i, int i2, Illllllllllllllllllllllll illllllllllllllllllllllll, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) throws IOException {
        byte[] bArr = (byte[]) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(65536, byte[].class);
        BitmapFactory.Options Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.inTempStorage = bArr;
        DecodeFormat decodeFormat = (DecodeFormat) illllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        PreferredColorSpace preferredColorSpace = (PreferredColorSpace) illllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
        try {
            return Xxxx.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ccccccccccc, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, (DownsampleStrategy) illllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DownsampleStrategy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww), decodeFormat, preferredColorSpace, illllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwww) != null && ((Boolean) illllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwww)).booleanValue(), i, i2, ((Boolean) illllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwww)).booleanValue(), wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        } finally {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(bArr);
        }
    }

    public static Bitmap Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Ccccccccccc ccccccccccc, BitmapFactory.Options options, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, OO0 oo0) throws IOException {
        if (!options.inJustDecodeBounds) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            ccccccccccc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        int i = options.outWidth;
        int i2 = options.outHeight;
        String str = options.outMimeType;
        Cccc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.lock();
        try {
            try {
                Bitmap Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = ccccccccccc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(options);
                Cccc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.unlock();
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            } catch (IllegalArgumentException e) {
                IOException Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(e, i, i2, str, options);
                Log.isLoggable("Downsampler", 3);
                if (options.inBitmap == null) {
                    throw Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
                }
                try {
                    oo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(options.inBitmap);
                    options.inBitmap = null;
                    Bitmap Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ccccccccccc, options, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, oo0);
                    Cccc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.unlock();
                    return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4;
                } catch (IOException unused) {
                    throw Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
                }
            }
        } catch (Throwable th) {
            Cccc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.unlock();
            throw th;
        }
    }

    public static IOException Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(IllegalArgumentException illegalArgumentException, int i, int i2, String str, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + i + ", outHeight: " + i2 + ", outMimeType: " + str + ", inBitmap: " + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(options.inBitmap), illegalArgumentException);
    }
}
