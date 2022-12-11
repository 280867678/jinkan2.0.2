package com.p046uc.crashsdk.p047a;

import android.os.Process;
import androidx.exifinterface.media.ExifInterface;
import com.p046uc.crashsdk.C1490a;
import com.p046uc.crashsdk.C1500b;
import com.p046uc.crashsdk.C1503e;
import com.p046uc.crashsdk.C1509g;
import com.tencent.bugly.beta.tinker.TinkerUtils;
import com.umeng.analytics.pro.C1543ak;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.util.Locale;
import me.tvspark.outline;
import org.apache.commons.lang3.StringUtils;
import org.litepal.parser.LitePalParser;

/* renamed from: com.uc.crashsdk.a.d */
/* loaded from: classes4.dex */
public class C1494d {

    /* renamed from: a */
    public static final /* synthetic */ boolean f2625a = !C1494d.class.desiredAssertionStatus();

    /* renamed from: b */
    public static boolean f2626b = true;

    /* renamed from: c */
    public static final Object f2627c = new Object();

    /* renamed from: d */
    public static boolean f2628d = false;

    /* renamed from: e */
    public static String f2629e = "hsdk";

    /* renamed from: f */
    public static String f2630f = "alid ";

    /* renamed from: g */
    public static String f2631g = null;

    /* renamed from: h */
    public static final Object f2632h = new Object();

    /* renamed from: i */
    public static String f2633i = null;

    /* renamed from: a */
    public static StringBuilder m1900a(StringBuilder sb, String str, String str2) {
        if (sb.length() > 0) {
            sb.append("`");
        }
        outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, str, "=", str2);
        return sb;
    }

    /* renamed from: a */
    public static void m1902a() {
        C1496f.m1888a(0, new RunnableC1495e(500), C1500b.m1789H() ? 900000L : 90000L);
    }

    /* renamed from: a */
    public static void m1901a(int i) {
        if (i != 500) {
            if (!f2625a) {
                throw new AssertionError();
            }
            return;
        }
        synchronized (f2627c) {
            f2631g = null;
            m1899a(!C1500b.m1791F());
            if (C1497g.m1863b(f2631g)) {
                C1498h.m1838a(f2631g);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0083 A[ADDED_TO_REGION] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean m1899a(boolean z) {
        int i;
        boolean z2;
        String str;
        if (f2628d) {
            return false;
        }
        f2628d = !z;
        if ((C1490a.f2595b.equals("2.0") && C1500b.m1751c(536870912)) || !C1500b.m1796A()) {
            return false;
        }
        String m1736n = C1500b.m1736n();
        String m1919a = C1492b.m1919a(m1736n);
        String str2 = null;
        long j = 0;
        if (C1497g.m1863b(m1919a)) {
            String[] split = m1919a.split(StringUtils.SPACE, 4);
            if (split.length == 3) {
                str2 = split[0];
                j = C1497g.m1870a(split[1], false);
                i = (int) C1497g.m1870a(split[2], false);
                f2626b = true;
                if (System.currentTimeMillis() - j < 259200000) {
                    if (!"o".equals(str2)) {
                        if (ExifInterface.GPS_MEASUREMENT_2D.equals(str2)) {
                            f2626b = false;
                        } else if ("1".equals(str2)) {
                            f2626b = false;
                        }
                    }
                    z2 = false;
                    if (z2 || z) {
                        return true;
                    }
                    if (i == Process.myPid()) {
                        return false;
                    }
                    f2631g = "per";
                    String m1893g = m1893g();
                    if (m1893g == null || !m1893g.contains("retcode=")) {
                        f2631g = m1893g == null ? "ner" : "ser";
                        return false;
                    }
                    if (m1893g.contains("retcode=0")) {
                        f2626b = true;
                        f2631g = "aus";
                        str = "o";
                    } else {
                        f2626b = false;
                        if ("1".equals(str2)) {
                            f2631g = "auf2";
                            str = ExifInterface.GPS_MEASUREMENT_2D;
                        } else {
                            f2631g = "auf1";
                            str = "1";
                        }
                    }
                    C1492b.m1918a(m1736n, String.format(Locale.US, "%s %d %d", str, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(Process.myPid())));
                    if (C1497g.m1863b(m1893g)) {
                        for (String str3 : m1893g.split("`", 30)) {
                            String[] split2 = str3.split("=", 2);
                            if (split2.length == 2) {
                                String trim = split2[0].trim();
                                String trim2 = split2[1].trim();
                                boolean z3 = C1497g.m1863b(trim2) && trim2.startsWith("http");
                                if ("logurl".equals(trim)) {
                                    if (z3) {
                                        C1503e.m1642b(trim2);
                                    }
                                } else if ("staturl".equals(trim)) {
                                    if (z3) {
                                        C1498h.m1826b(trim2);
                                    }
                                } else if ("policyurl".equals(trim)) {
                                    if (z3) {
                                        synchronized (f2632h) {
                                            f2633i = trim2;
                                            C1492b.m1918a(C1500b.m1740j(), trim2 + "\n");
                                        }
                                    } else {
                                        continue;
                                    }
                                } else if ("logpolicy".equals(trim)) {
                                    C1503e.m1633c(trim2);
                                }
                            }
                        }
                    }
                    return true;
                }
                z2 = true;
                if (z2) {
                }
                return true;
            }
        }
        i = 0;
        f2626b = true;
        if (System.currentTimeMillis() - j < 259200000) {
        }
        z2 = true;
        if (z2) {
        }
        return true;
    }

    /* renamed from: b */
    public static String m1898b() {
        try {
            return "inv" + f2630f + "cras" + f2629e;
        } catch (Throwable th) {
            C1497g.m1862b(th);
            return "";
        }
    }

    /* renamed from: c */
    public static void m1897c() {
        synchronized (f2632h) {
            f2633i = null;
        }
    }

    /* renamed from: d */
    public static byte[] m1896d() {
        return new byte[]{6, 0, 23, 8};
    }

    /* renamed from: e */
    public static boolean m1895e() {
        if (!C1503e.m1706F() && !C1500b.m1785L()) {
            m1899a(true);
            return f2626b;
        }
        return true;
    }

    /* renamed from: f */
    public static String m1894f() {
        String str = f2633i;
        if (C1497g.m1872a(str)) {
            synchronized (f2632h) {
                String str2 = "https://errlog.umeng.com";
                if (C1509g.m1521P()) {
                    str2 = "https://errlogos.umeng.com";
                }
                str = C1497g.m1871a(C1500b.m1740j(), str2 + "/api/crashsdk/validate", true);
                f2633i = str;
            }
        }
        return str;
    }

    /* renamed from: g */
    public static String m1893g() {
        byte[] bArr;
        String m1894f;
        byte[] m1911a;
        byte[] bArr2;
        StringBuilder sb = new StringBuilder();
        m1900a(sb, TinkerUtils.PLATFORM, C1509g.m1494e());
        m1900a(sb, "pkgname", C1490a.f2594a);
        m1900a(sb, UMModuleRegister.PROCESS, C1503e.m1610h());
        m1900a(sb, LitePalParser.NODE_VERSION, C1490a.m1962a());
        m1900a(sb, "cver", "3.3.1.1");
        m1900a(sb, "ctag", "release");
        m1900a(sb, "inter", C1509g.m1521P() ? "true" : "false");
        m1900a(sb, C1543ak.f3053x, "android");
        String sb2 = sb.toString();
        byte[] bArr3 = new byte[16];
        C1493c.m1909a(bArr3, 0, C1498h.m1811j());
        C1493c.m1909a(bArr3, 4, C1493c.m1914a());
        C1493c.m1909a(bArr3, 8, m1896d());
        C1493c.m1909a(bArr3, 12, C1490a.m1937f());
        try {
            bArr = C1493c.m1906a(sb2.getBytes(), bArr3, true);
        } catch (Throwable th) {
            C1497g.m1868a(th);
            bArr = null;
        }
        if (bArr == null || (m1894f = m1894f()) == null || (m1911a = C1493c.m1911a(m1894f, bArr, false)) == null) {
            return null;
        }
        try {
            bArr2 = C1493c.m1906a(m1911a, bArr3, false);
        } catch (Throwable th2) {
            C1497g.m1868a(th2);
            bArr2 = null;
        }
        if (bArr2 == null) {
            return null;
        }
        return new String(bArr2);
    }
}
