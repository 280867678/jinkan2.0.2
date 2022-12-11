package com.tencent.bugly.beta.global;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.bugly.beta.utils.C1121c;
import com.tencent.bugly.crashreport.common.info.C1140a;
import com.tencent.bugly.proguard.C1199X;
import com.tencent.bugly.proguard.C1208ca;
import com.tencent.bugly.proguard.C1234p;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import me.tvspark.outline;
import org.litepal.crud.LitePalSupport;

/* renamed from: com.tencent.bugly.beta.global.a */
/* loaded from: classes3.dex */
public class C1089a {
    /* renamed from: a */
    public static int m3626a(Context context) {
        NetworkInfo activeNetworkInfo;
        TelephonyManager telephonyManager;
        try {
            activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e) {
            if (!C1199X.m3080b(e)) {
                e.printStackTrace();
            }
        }
        if (activeNetworkInfo == null) {
            return 0;
        }
        if (activeNetworkInfo.getType() == 1) {
            return 1;
        }
        if (activeNetworkInfo.getType() == 0 && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
            switch (telephonyManager.getNetworkType()) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return 2;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    return 3;
                case 13:
                    return 4;
                default:
                    return 0;
            }
        }
        return 0;
    }

    /* renamed from: a */
    public static int m3625a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0050 A[Catch: Exception -> 0x00f0, TryCatch #0 {Exception -> 0x00f0, blocks: (B:11:0x0014, B:15:0x001f, B:17:0x002e, B:20:0x0048, B:22:0x0050, B:24:0x0059, B:25:0x006a, B:37:0x00c3, B:39:0x00cb, B:41:0x00db, B:45:0x00e7, B:48:0x00c6, B:52:0x00a0, B:53:0x0086, B:55:0x0063, B:59:0x003c), top: B:9:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00db A[Catch: Exception -> 0x00f0, TryCatch #0 {Exception -> 0x00f0, blocks: (B:11:0x0014, B:15:0x001f, B:17:0x002e, B:20:0x0048, B:22:0x0050, B:24:0x0059, B:25:0x006a, B:37:0x00c3, B:39:0x00cb, B:41:0x00db, B:45:0x00e7, B:48:0x00c6, B:52:0x00a0, B:53:0x0086, B:55:0x0063, B:59:0x003c), top: B:9:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00d6  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap m3624a(Context context, int i, Object... objArr) {
        File file;
        int intValue;
        int i2;
        File file2;
        BitmapFactory.Options options;
        int min;
        int i3;
        if (objArr == null || objArr.length <= 0 || !(i == 0 || i == 1)) {
            return null;
        }
        try {
            if (i == 0) {
                if (TextUtils.isEmpty((String) objArr[0])) {
                    return null;
                }
                file = new File((String) objArr[0]);
                if (!file.exists() || file.length() > 1048576) {
                    return null;
                }
            } else if (i == 1) {
                intValue = ((Integer) objArr[0]).intValue();
                file = null;
                i2 = C1093e.f737b.f742E.widthPixels;
                if (i2 <= 0) {
                    options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    if (i == 0) {
                        BitmapFactory.decodeFile(file.getPath(), options);
                    } else if (i == 1) {
                        BitmapFactory.decodeResource(context.getResources(), intValue, options);
                    }
                    int i4 = (int) (i2 * (options.outHeight / options.outWidth));
                    int min2 = Math.min(i2, i4);
                    double d = options.outWidth;
                    double d2 = options.outHeight;
                    int i5 = i2 * i4;
                    int ceil = i5 == -1 ? 1 : (int) Math.ceil(Math.sqrt(((d * d2) / i2) * i4));
                    if (min2 == -1) {
                        file2 = file;
                        min = 128;
                    } else {
                        file2 = file;
                        double d3 = min2;
                        min = (int) Math.min(Math.floor(d / d3), Math.floor(d2 / d3));
                    }
                    if (i5 == -1 && min2 == -1) {
                        ceil = 1;
                    } else if (min2 != -1) {
                        ceil = min;
                    }
                    if (ceil <= 8) {
                        i3 = 1;
                        while (i3 < ceil) {
                            i3 <<= 1;
                        }
                    } else {
                        i3 = ((ceil + 7) / 8) * 8;
                    }
                    options.inSampleSize = i3;
                    options.inJustDecodeBounds = false;
                    options.inInputShareable = true;
                    options.inPurgeable = true;
                } else {
                    file2 = file;
                    options = null;
                }
                if (i != 0) {
                    return BitmapFactory.decodeFile(file2.getPath(), options);
                }
                if (i != 1) {
                    return null;
                }
                return BitmapFactory.decodeResource(context.getResources(), intValue, options);
            } else {
                file = null;
            }
            intValue = 0;
            i2 = C1093e.f737b.f742E.widthPixels;
            if (i2 <= 0) {
            }
            if (i != 0) {
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static Bitmap m3620a(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() != null) {
                return bitmapDrawable.getBitmap();
            }
        }
        Bitmap createBitmap = (drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) ? Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888) : Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    /* renamed from: a */
    public static BitmapDrawable m3621a(Bitmap bitmap, int i, int i2, float f) {
        DisplayMetrics displayMetrics = C1093e.f737b.f742E;
        int i3 = (int) (displayMetrics.widthPixels * displayMetrics.heightPixels * 0.8f);
        if (bitmap == null || i * i2 > i3) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, i, i2);
        RectF rectF = new RectF(rect);
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-16777216);
        canvas.drawRoundRect(rectF, f, f, paint);
        canvas.drawRect(0.0f, f, i, i2, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), rect, paint);
        return new BitmapDrawable(createBitmap);
    }

    /* renamed from: a */
    public static synchronized <T extends Parcelable> T m3615a(String str, Parcelable.Creator<T> creator) {
        synchronized (C1089a.class) {
            Map<String, byte[]> m2872c = C1234p.f1572a.m2872c();
            if (m2872c == null) {
                return null;
            }
            byte[] bArr = m2872c.get(str);
            if (bArr != null && bArr.length > 0) {
                return (T) C1208ca.m3019a(bArr, creator);
            }
            return null;
        }
    }

    /* renamed from: a */
    public static String m3622a(Context context, String str) {
        Object obj;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null && applicationInfo.metaData != null && (obj = applicationInfo.metaData.get(str)) != null) {
                return String.valueOf(obj);
            }
            return null;
        } catch (Exception e) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("getManifestMetaDataValue exception:");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(e.getMessage());
            C1199X.m3082b(C1089a.class, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), new Object[0]);
            return null;
        }
    }

    /* renamed from: a */
    public static String m3613a(String str, String str2) {
        SharedPreferences sharedPreferences = C1093e.f737b.f741D;
        return sharedPreferences != null ? sharedPreferences.getString(str, str2) : str2;
    }

    /* renamed from: a */
    public static void m3619a(File file) {
        File[] listFiles;
        if (file == null || !file.exists() || !file.isDirectory() || (listFiles = file.listFiles()) == null || listFiles.length <= 0) {
            return;
        }
        for (File file2 : listFiles) {
            if (!file2.delete()) {
                C1199X.m3081b("cannot delete file:%s", file2.getAbsolutePath());
            }
        }
    }

    /* renamed from: a */
    public static boolean m3623a(Context context, File file, String str) {
        if (file != null) {
            try {
                if (file.exists() && file.getName().endsWith(".apk")) {
                    String m3032a = C1208ca.m3032a(file, LitePalSupport.MD5);
                    if (!TextUtils.isEmpty(str) && !TextUtils.equals(str.toUpperCase(), m3032a)) {
                        C1199X.m3078c("md5 error [file md5: %s] [target md5: %s]", m3032a, str);
                        return false;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("chmod 777 ");
                    sb.append(file.getAbsolutePath());
                    Runtime.getRuntime().exec(sb.toString());
                    Intent intent = new Intent("android.intent.action.VIEW");
                    if (Build.VERSION.SDK_INT >= 24) {
                        intent.addFlags(1);
                        Class.forName("androidx.core.content.FileProvider");
                        Class[] clsArr = {Context.class, String.class, File.class};
                        Object[] objArr = new Object[3];
                        objArr[0] = context;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(C1140a.m3421a(context).f1041g);
                        sb2.append(".fileProvider");
                        objArr[1] = sb2.toString();
                        objArr[2] = file;
                        Uri uri = (Uri) C1208ca.m3024a("androidx.core.content.FileProvider", "getUriForFile", null, clsArr, objArr);
                        if (uri == null) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("file location is ");
                            sb3.append(file.toString());
                            C1199X.m3081b(sb3.toString(), new Object[0]);
                            C1199X.m3081b("install failed, contentUri is null!", new Object[0]);
                            return false;
                        }
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("contentUri is ");
                        sb4.append(uri);
                        C1199X.m3084a(sb4.toString(), new Object[0]);
                        intent.setDataAndType(uri, "application/vnd.android.package-archive");
                    } else {
                        intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
                    }
                    intent.addFlags(268435456);
                    context.startActivity(intent);
                    return true;
                }
            } catch (Exception e) {
                if (!C1199X.m3083a(e)) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0066 A[Catch: IOException -> 0x0062, TRY_LEAVE, TryCatch #5 {IOException -> 0x0062, blocks: (B:48:0x005e, B:41:0x0066), top: B:47:0x005e }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x005e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean m3618a(File file, File file2) {
        ?? r4;
        Exception e;
        ?? r3;
        Throwable th;
        boolean z = false;
        if (file != null) {
            FileInputStream fileInputStream = null;
            try {
                try {
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            } catch (Exception e3) {
                e = e3;
                r3 = 0;
            } catch (Throwable th2) {
                th = th2;
                r4 = 0;
                if (fileInputStream != null) {
                }
                if (r4 != 0) {
                }
                throw th;
            }
            if (file.exists() && !file.isDirectory()) {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    r3 = new FileOutputStream(file2, false);
                } catch (Exception e4) {
                    e = e4;
                    r3 = 0;
                } catch (Throwable th3) {
                    th = th3;
                    r4 = fileInputStream;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                    }
                    if (r4 != 0) {
                    }
                    throw th;
                }
                try {
                    byte[] bArr = new byte[1048576];
                    while (true) {
                        int read = fileInputStream2.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        r3.write(bArr, 0, read);
                    }
                    z = true;
                    fileInputStream2.close();
                    r3.close();
                } catch (Exception e5) {
                    e = e5;
                    fileInputStream = fileInputStream2;
                    r3 = r3;
                    try {
                        e.printStackTrace();
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        if (r3 != 0) {
                            r3.close();
                        }
                        return z;
                    } catch (Throwable th4) {
                        th = th4;
                        fileInputStream2 = fileInputStream;
                        fileInputStream = r3;
                        th = th;
                        r4 = fileInputStream;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e6) {
                                e6.printStackTrace();
                                throw th;
                            }
                        }
                        if (r4 != 0) {
                            r4.close();
                        }
                        throw th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    fileInputStream = r3;
                    th = th;
                    r4 = fileInputStream;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                    }
                    if (r4 != 0) {
                    }
                    throw th;
                }
                return z;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m3617a(File file, String str, String str2) {
        if (file != null) {
            try {
                if (file.exists()) {
                    String m3032a = C1208ca.m3032a(file, str2);
                    if (!TextUtils.isEmpty(str) && TextUtils.equals(str.toUpperCase(), m3032a)) {
                        return true;
                    }
                    C1199X.m3078c("checkFileUniqueId failed [file  uniqueId %s] [target uniqueId %s]", m3032a, str);
                    return false;
                }
            } catch (Exception unused) {
                C1199X.m3081b("checkFileUniqueId exception", new Object[0]);
            }
        }
        return false;
    }

    /* renamed from: a */
    public static synchronized boolean m3616a(String str) {
        boolean m2876a;
        synchronized (C1089a.class) {
            m2876a = C1234p.f1572a.m2876a(str);
        }
        return m2876a;
    }

    /* renamed from: a */
    public static synchronized <T extends Parcelable> boolean m3614a(String str, T t) {
        synchronized (C1089a.class) {
            boolean z = false;
            if (t == null) {
                return false;
            }
            byte[] m3036a = C1208ca.m3036a(t);
            if (m3036a != null) {
                if (C1234p.f1572a.m2880a(1002, str, m3036a)) {
                    z = true;
                }
            }
            return z;
        }
    }

    /* renamed from: a */
    public static boolean m3612a(String str, boolean z) {
        SharedPreferences sharedPreferences = C1093e.f737b.f741D;
        return sharedPreferences != null ? sharedPreferences.getBoolean(str, z) : z;
    }

    /* renamed from: b */
    public static String m3611b(String str) {
        return new C1121c(str).m3536a();
    }

    /* renamed from: b */
    public static void m3610b(String str, String str2) {
        SharedPreferences sharedPreferences = C1093e.f737b.f741D;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(str, str2).apply();
        }
    }

    /* renamed from: b */
    public static void m3609b(String str, boolean z) {
        SharedPreferences sharedPreferences = C1093e.f737b.f741D;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(str, z).apply();
        }
    }
}
