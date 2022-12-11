package com.tencent.smtt.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import androidx.exifinterface.media.ExifInterface;
import com.stub.StubApp;
import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.smtt.sdk.WebView;
import me.tvspark.outline;
import org.apache.commons.lang3.StringUtils;

/* renamed from: com.tencent.smtt.utils.k */
/* loaded from: classes4.dex */
public class C1463k {

    /* renamed from: a */
    public static String f2505a = null;

    /* renamed from: b */
    public static String f2506b = "GA";

    /* renamed from: c */
    public static String f2507c = "GE";

    /* renamed from: d */
    public static String f2508d = "9422";

    /* renamed from: e */
    public static String f2509e = "0";

    /* renamed from: f */
    public static String f2510f = "";

    /* renamed from: g */
    public static boolean f2511g;

    /* renamed from: h */
    public static boolean f2512h;

    /* renamed from: i */
    public static boolean f2513i;

    /* renamed from: a */
    public static String m2039a(Context context) {
        return m2038a(context, "0");
    }

    /* renamed from: a */
    public static String m2038a(Context context, String str) {
        if (!TextUtils.isEmpty(f2505a)) {
            return f2505a;
        }
        String m2037a = m2037a(context, String.valueOf(WebView.getTbsSDKVersion(context)), str, f2506b, f2507c, f2508d, f2509e, f2510f, f2511g);
        f2505a = m2037a;
        return m2037a;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(28:1|(2:2|3)|(3:5|6|(1:8)(1:50))|9|(1:12)|13|(1:15)|16|(1:20)|21|(1:23)|24|(1:26)|27|28|29|30|31|(1:33)|34|35|36|37|38|(1:40)|41|42|(1:(0))) */
    /* JADX WARN: Can't wrap try/catch for region: R(29:1|2|3|(3:5|6|(1:8)(1:50))|9|(1:12)|13|(1:15)|16|(1:20)|21|(1:23)|24|(1:26)|27|28|29|30|31|(1:33)|34|35|36|37|38|(1:40)|41|42|(1:(0))) */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x011b  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String m2037a(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z) {
        String str8;
        String str9;
        String m2032d;
        String str10;
        PackageInfo packageInfo;
        StringBuilder sb = new StringBuilder();
        String str11 = m2034b(context) + "*" + m2033c(context);
        try {
            ApplicationInfo applicationInfo = StubApp.getOrigApplicationContext(context.getApplicationContext()).getApplicationInfo();
            packageInfo = context.getPackageManager().getPackageInfo(applicationInfo.packageName, 0);
            str8 = applicationInfo.packageName;
        } catch (PackageManager.NameNotFoundException e) {
            e = e;
            str8 = "";
        }
        try {
            str9 = !TextUtils.isEmpty(str7) ? str7 : packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            e = e2;
            e.printStackTrace();
            str9 = "";
            String m2036a = m2036a(str8);
            String str12 = "PAD";
            str12 = "QB".equals(m2036a) ? "PHONE" : "PHONE";
            outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, "QV", "=", ExifInterface.GPS_MEASUREMENT_3D);
            m2035a(sb, "PL", "ADR");
            m2035a(sb, "PR", m2036a);
            m2035a(sb, "PP", str8);
            m2035a(sb, "PPVN", str9);
            if (!TextUtils.isEmpty(str)) {
            }
            m2035a(sb, "CO", "SYS");
            String str13 = "0";
            if (!TextUtils.isEmpty(str2)) {
                m2035a(sb, "CO", "BK");
            }
            if (!TextUtils.isEmpty(str2)) {
            }
            m2035a(sb, "PB", str4);
            m2035a(sb, "VE", str3);
            m2035a(sb, "DE", str12);
            if (!TextUtils.isEmpty(str6)) {
            }
            m2035a(sb, "CHID", str13);
            m2035a(sb, "LCID", str5);
            m2032d = m2032d(context);
            m2032d = new String(m2032d.getBytes("UTF-8"), "ISO8859-1");
            if (!TextUtils.isEmpty(m2032d)) {
            }
            m2035a(sb, "RL", str11);
            str10 = Build.VERSION.RELEASE;
            str10 = new String(str10.getBytes("UTF-8"), "ISO8859-1");
            if (!TextUtils.isEmpty(str10)) {
            }
            m2035a(sb, "API", Build.VERSION.SDK_INT + "");
            return sb.toString();
        }
        String m2036a2 = m2036a(str8);
        String str122 = "PAD";
        if ("QB".equals(m2036a2) ? !m2031e(context) : !z) {
        }
        outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, "QV", "=", ExifInterface.GPS_MEASUREMENT_3D);
        m2035a(sb, "PL", "ADR");
        m2035a(sb, "PR", m2036a2);
        m2035a(sb, "PP", str8);
        m2035a(sb, "PPVN", str9);
        if (!TextUtils.isEmpty(str)) {
            m2035a(sb, "TBSVC", str);
        }
        m2035a(sb, "CO", "SYS");
        String str132 = "0";
        if (!TextUtils.isEmpty(str2) && !str2.equals(str132)) {
            m2035a(sb, "CO", "BK");
        }
        if (!TextUtils.isEmpty(str2)) {
            m2035a(sb, "COVC", str2);
        }
        m2035a(sb, "PB", str4);
        m2035a(sb, "VE", str3);
        m2035a(sb, "DE", str122);
        if (!TextUtils.isEmpty(str6)) {
            str132 = str6;
        }
        m2035a(sb, "CHID", str132);
        m2035a(sb, "LCID", str5);
        m2032d = m2032d(context);
        m2032d = new String(m2032d.getBytes("UTF-8"), "ISO8859-1");
        if (!TextUtils.isEmpty(m2032d)) {
            m2035a(sb, "MO", m2032d);
        }
        m2035a(sb, "RL", str11);
        str10 = Build.VERSION.RELEASE;
        str10 = new String(str10.getBytes("UTF-8"), "ISO8859-1");
        if (!TextUtils.isEmpty(str10)) {
            m2035a(sb, "OS", str10);
        }
        m2035a(sb, "API", Build.VERSION.SDK_INT + "");
        return sb.toString();
    }

    /* renamed from: a */
    public static String m2036a(String str) {
        return TbsConfig.APP_WX.equals(str) ? "WX" : TbsConfig.APP_QQ.equals(str) ? "QQ" : TbsConfig.APP_QZONE.equals(str) ? "QZ" : TbsConfig.APP_QB.equals(str) ? "QB" : "TRD";
    }

    /* renamed from: a */
    public static void m2035a(StringBuilder sb, String str, String str2) {
        outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, "&", str, "=", str2);
    }

    /* renamed from: b */
    public static int m2034b(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (defaultDisplay != null) {
            return defaultDisplay.getWidth();
        }
        return -1;
    }

    /* renamed from: c */
    public static int m2033c(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (defaultDisplay != null) {
            return defaultDisplay.getHeight();
        }
        return -1;
    }

    /* renamed from: d */
    public static String m2032d(Context context) {
        String m1976d = C1472q.m1976d(context);
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(StringUtils.SPACE);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(m1976d.replaceAll("[ |\\/|\\_|\\&|\\|]", ""));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(StringUtils.SPACE);
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    /* renamed from: e */
    public static boolean m2031e(Context context) {
        if (f2512h) {
            return f2513i;
        }
        try {
            boolean z = (Math.min(m2034b(context), m2033c(context)) * 160) / m2030f(context) >= 700;
            f2513i = z;
            f2512h = true;
            return z;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: f */
    public static int m2030f(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (defaultDisplay != null) {
            defaultDisplay.getMetrics(displayMetrics);
            return displayMetrics.densityDpi;
        }
        return 160;
    }
}
