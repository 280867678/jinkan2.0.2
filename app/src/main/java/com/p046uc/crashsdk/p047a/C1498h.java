package com.p046uc.crashsdk.p047a;

import android.os.Build;
import android.os.Process;
import android.support.p000v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.SparseArray;
import com.p046uc.crashsdk.C1490a;
import com.p046uc.crashsdk.C1500b;
import com.p046uc.crashsdk.C1503e;
import com.p046uc.crashsdk.C1509g;
import com.p046uc.crashsdk.JNIBridge;
import com.tencent.bugly.beta.tinker.TinkerReport;
import com.umeng.analytics.pro.C1543ak;
import com.umeng.commonsdk.statistics.noise.Defcon;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import me.tvspark.outline;

/* renamed from: com.uc.crashsdk.a.h */
/* loaded from: classes4.dex */
public class C1498h {

    /* renamed from: a */
    public static final /* synthetic */ boolean f2656a = !C1498h.class.desiredAssertionStatus();

    /* renamed from: b */
    public static final Object f2657b = new Object();

    /* renamed from: c */
    public static final Map<String, String> f2658c = new HashMap();

    /* renamed from: d */
    public static int f2659d = 0;

    /* renamed from: e */
    public static final Map<String, C1499a> f2660e = new HashMap();

    /* renamed from: f */
    public static final Object f2661f = new Object();

    /* renamed from: g */
    public static final Object f2662g = new Object();

    /* renamed from: h */
    public static final SparseArray<String> f2663h = new SparseArray<>();

    /* renamed from: i */
    public static boolean f2664i = false;

    /* renamed from: j */
    public static boolean f2665j = false;

    /* renamed from: k */
    public static final Object f2666k = new Object();

    /* renamed from: l */
    public static String f2667l = null;

    /* renamed from: com.uc.crashsdk.a.h$a */
    /* loaded from: classes4.dex */
    public static class C1499a {

        /* renamed from: a */
        public long f2668a = 0;

        /* renamed from: b */
        public int f2669b = 0;

        /* renamed from: c */
        public Map<String, String> f2670c = new HashMap();

        /* renamed from: d */
        public String f2671d;

        /* renamed from: e */
        public boolean f2672e;

        /* renamed from: f */
        public boolean f2673f;

        public C1499a(String str, boolean z, boolean z2) {
            this.f2672e = false;
            this.f2673f = false;
            this.f2671d = str;
            this.f2672e = z;
            this.f2673f = z2;
        }

        /* renamed from: d */
        private long m1797d(String str) {
            return C1497g.m1870a(m1803a(str), true);
        }

        /* renamed from: a */
        public final String m1803a(String str) {
            return this.f2670c.get(str);
        }

        /* renamed from: a */
        public final String m1800a(boolean z, boolean z2, boolean z3) {
            String format;
            if (this.f2671d == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            if (z) {
                C1498h.m1823b(sb, "lt", "uc");
                C1498h.m1823b(sb, "pre", C1509g.m1494e());
                C1498h.m1823b(sb, "pkg", C1490a.f2594a);
                C1498h.m1823b(sb, "rom", Build.VERSION.RELEASE);
                C1498h.m1823b(sb, "brd", Build.BRAND);
                C1498h.m1823b(sb, "model", Build.MODEL);
                C1498h.m1834a(sb, "sdk", Build.VERSION.SDK_INT);
                C1498h.m1823b(sb, C1543ak.f3052w, C1503e.m1625e());
                C1498h.m1823b(sb, "hdw", C1503e.m1620f());
                long m1806o = C1498h.m1806o();
                C1498h.m1834a(sb, "ram", m1806o);
                C1498h.m1823b(sb, "aram", C1498h.m1842a(m1806o));
                C1498h.m1823b(sb, "cver", "3.3.1.1");
                C1498h.m1823b(sb, "cseq", "210916105822");
                C1498h.m1823b(sb, "ctag", "release");
                C1498h.m1823b(sb, "aver", C1490a.m1962a());
                C1498h.m1823b(sb, "ver", C1509g.m1519R());
                C1498h.m1823b(sb, "sver", C1509g.m1518S());
                C1498h.m1823b(sb, "seq", C1509g.m1517T());
                C1498h.m1823b(sb, "grd", C1500b.m1796A() ? "fg" : "bg");
                C1498h.m1823b(sb, C1543ak.f3053x, "android");
                C1498h.m1823b(sb, "dn", C1503e.m1590q());
                String m1511Z = C1509g.m1511Z();
                if (TextUtils.isEmpty(m1511Z)) {
                    m1511Z = C1503e.m1590q();
                }
                C1498h.m1823b(sb, "k_uid", m1511Z);
                String m1502aa = C1509g.m1502aa();
                if (!TextUtils.isEmpty(m1502aa)) {
                    C1498h.m1823b(sb, "k_channel", m1502aa);
                }
                sb.append("\n");
            }
            C1498h.m1823b(sb, "lt", this.f2671d);
            C1498h.m1832a(sb, this.f2670c);
            if (this.f2672e && !z2) {
                long j = this.f2668a;
                if (j != 0) {
                    C1498h.m1823b(sb, "up", String.valueOf(j));
                }
                if (z3) {
                    format = String.format(Locale.US, "%d", Integer.valueOf(Process.myPid()));
                } else {
                    int i = this.f2669b;
                    if (i != 0) {
                        format = String.format(Locale.US, "%d", Integer.valueOf(i));
                    }
                }
                C1498h.m1823b(sb, "pid", format);
            }
            sb.append("\n");
            return sb.toString();
        }

        /* renamed from: a */
        public final void m1802a(String str, long j) {
            long m1797d = m1797d(str) + j;
            if (m1797d <= 100) {
                j = m1797d < 0 ? 0L : m1797d;
            }
            m1801a(str, String.valueOf(j));
        }

        /* renamed from: a */
        public final void m1801a(String str, String str2) {
            this.f2670c.put(str, str2);
        }

        /* renamed from: a */
        public final boolean m1804a(C1499a c1499a) {
            if (!this.f2673f) {
                C1491a.m1924a("crashsdk", String.format(Locale.US, "WaItem '%s' is not mergable!", this.f2671d), null);
                return false;
            }
            for (String str : c1499a.f2670c.keySet()) {
                if (!str.startsWith("c_")) {
                    long m1797d = c1499a.m1797d(str);
                    if (m1797d != 0) {
                        if (m1797d < 100) {
                            m1802a(str, m1797d);
                        }
                    }
                }
                m1801a(str, c1499a.m1803a(str));
            }
            return true;
        }

        /* renamed from: b */
        public final String m1799b(String str) {
            String m1803a = m1803a(str);
            return m1803a == null ? "" : m1803a;
        }

        /* renamed from: c */
        public final boolean m1798c(String str) {
            if (C1497g.m1872a(str)) {
                return false;
            }
            String str2 = null;
            long j = 0;
            HashMap hashMap = new HashMap();
            Map m1820c = C1498h.m1820c(str);
            int i = 0;
            for (String str3 : m1820c.keySet()) {
                String str4 = (String) m1820c.get(str3);
                if (str3.equals("lt")) {
                    str2 = str4;
                } else if (this.f2672e && str3.equals("up")) {
                    j = C1497g.m1870a(str4, true);
                } else if (!this.f2672e || !str3.equals("pid")) {
                    hashMap.put(str3, str4);
                } else {
                    i = (int) C1497g.m1870a(str4, true);
                }
            }
            String str5 = this.f2671d;
            if (str5 != null && !str5.equals(str2)) {
                return false;
            }
            this.f2668a = j;
            this.f2669b = i;
            this.f2671d = str2;
            this.f2670c = hashMap;
            return true;
        }
    }

    /* renamed from: a */
    public static /* synthetic */ String m1842a(long j) {
        return j < PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED ? "512M" : String.format(Locale.US, "%dG", Long.valueOf(((j / 1024) + 512) / 1024));
    }

    /* renamed from: a */
    public static StringBuilder m1839a(Iterable<C1499a> iterable, boolean z, boolean z2) {
        StringBuilder sb = new StringBuilder();
        boolean z3 = true;
        for (C1499a c1499a : iterable) {
            if (z3) {
                sb.append(c1499a.m1800a(z, z, z2));
                z3 = false;
            } else {
                sb.append(c1499a.m1800a(false, z, z2));
            }
        }
        return sb;
    }

    /* renamed from: a */
    public static ArrayList<C1499a> m1840a(File file, String str, int i) {
        ArrayList<String> m1877a = C1497g.m1877a(file, i);
        ArrayList<C1499a> arrayList = new ArrayList<>();
        Iterator<String> it = m1877a.iterator();
        while (it.hasNext()) {
            C1499a c1499a = new C1499a(str, false, false);
            if (c1499a.m1798c(it.next())) {
                arrayList.add(c1499a);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static void m1847a() {
        m1846a(0, C1500b.m1789H() ? 700000L : 70000L);
    }

    /* renamed from: a */
    public static void m1846a(int i, long j) {
        if (!C1500b.m1791F()) {
            return;
        }
        C1496f.m1888a(0, new RunnableC1495e(302, new Object[]{Integer.valueOf(i)}), j);
    }

    /* renamed from: a */
    public static void m1845a(int i, String str) {
        f2663h.put(i, str);
    }

    /* renamed from: a */
    public static void m1844a(int i, boolean z) {
        if (m1830a(z, "crash rate")) {
            return;
        }
        String str = C1509g.m1516U() + "cr.wa";
        C1500b.m1766a(f2657b, str, new RunnableC1495e(TinkerReport.KEY_LOADED_PACKAGE_CHECK_DEX_META, new Object[]{str, Integer.valueOf(i)}));
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x009d, code lost:
        if (r3 == false) goto L41;
     */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ca A[Catch: all -> 0x0132, TryCatch #0 {, blocks: (B:19:0x001d, B:21:0x0028, B:23:0x002c, B:24:0x0130, B:27:0x002e, B:29:0x0038, B:31:0x0040, B:32:0x0049, B:34:0x0076, B:36:0x007b, B:43:0x00a4, B:44:0x00ab, B:45:0x00be, B:47:0x00ca, B:51:0x0103, B:52:0x0116, B:53:0x00f9, B:57:0x00b6), top: B:18:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0103 A[Catch: all -> 0x0132, TryCatch #0 {, blocks: (B:19:0x001d, B:21:0x0028, B:23:0x002c, B:24:0x0130, B:27:0x002e, B:29:0x0038, B:31:0x0040, B:32:0x0049, B:34:0x0076, B:36:0x007b, B:43:0x00a4, B:44:0x00ab, B:45:0x00be, B:47:0x00ca, B:51:0x0103, B:52:0x0116, B:53:0x00f9, B:57:0x00b6), top: B:18:0x001d }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void m1843a(int i, Object[] objArr) {
        String str;
        long j;
        boolean m1819c;
        boolean z;
        switch (i) {
            case 301:
                if (!f2656a && objArr == null) {
                    throw new AssertionError();
                }
                m1844a(((Integer) objArr[0]).intValue(), false);
                return;
            case 302:
                if (!f2656a && objArr == null) {
                    throw new AssertionError();
                }
                synchronized (f2657b) {
                    int intValue = ((Integer) objArr[0]).intValue();
                    if (intValue == 0) {
                        if (!f2664i) {
                            f2664i = true;
                        }
                    }
                    if (!C1490a.f2595b.equals("2.0") || !C1500b.m1751c(268435456)) {
                        File file = new File(m1808m());
                        String m1860c = C1497g.m1860c(file);
                        C1499a c1499a = new C1499a("pv", true, true);
                        C1491a.m1925a("wa", "addPvStatImpl, read data: " + m1860c);
                        if (!C1497g.m1872a(m1860c)) {
                            c1499a.m1798c(m1860c);
                        }
                        if (intValue == 0) {
                            C1491a.m1925a("wa", String.format(Locale.US, "Last upload pid is %d", Integer.valueOf(c1499a.f2669b)));
                            if (c1499a.f2669b != Process.myPid()) {
                                z = false;
                                break;
                            } else {
                                z = true;
                                break;
                            }
                        }
                        if (intValue == 0) {
                            c1499a.m1802a("pv", 1L);
                            str = "fjv";
                        } else if (intValue == 1) {
                            str = "hpv";
                        } else {
                            if (intValue == 2) {
                                c1499a.m1802a("pv", 1L);
                                str = "npv";
                            }
                            String m1590q = C1503e.m1590q();
                            j = c1499a.f2668a;
                            if (j != 0) {
                                long currentTimeMillis = System.currentTimeMillis() - j;
                                C1491a.m1925a("wa", String.format(Locale.US, "Upload delta %d s, min interval: %d s", Long.valueOf(currentTimeMillis / 1000), 28800L));
                                if (currentTimeMillis < Defcon.MILLIS_8_HOURS) {
                                    m1819c = false;
                                    if (m1819c) {
                                        c1499a.f2670c = new HashMap();
                                        c1499a.f2668a = System.currentTimeMillis();
                                        c1499a.f2669b = Process.myPid();
                                    }
                                    String m1800a = c1499a.m1800a(false, false, true);
                                    C1491a.m1925a("wa", "addPvStatImpl, save data: " + m1800a);
                                    C1497g.m1874a(file, m1800a);
                                }
                            }
                            m1819c = m1819c(m1590q, c1499a.m1800a(true, true, false));
                            if (m1819c) {
                            }
                            String m1800a2 = c1499a.m1800a(false, false, true);
                            C1491a.m1925a("wa", "addPvStatImpl, save data: " + m1800a2);
                            C1497g.m1874a(file, m1800a2);
                        }
                        c1499a.m1802a(str, 1L);
                        String m1590q2 = C1503e.m1590q();
                        j = c1499a.f2668a;
                        if (j != 0) {
                        }
                        m1819c = m1819c(m1590q2, c1499a.m1800a(true, true, false));
                        if (m1819c) {
                        }
                        String m1800a22 = c1499a.m1800a(false, false, true);
                        C1491a.m1925a("wa", "addPvStatImpl, save data: " + m1800a22);
                        C1497g.m1874a(file, m1800a22);
                    } else {
                        C1491a.m1925a("wa", "pv stat is disabled");
                    }
                }
                return;
            case 303:
                m1822b(false);
                return;
            default:
                if (!f2656a) {
                    throw new AssertionError();
                }
                return;
        }
    }

    /* renamed from: a */
    public static void m1841a(C1499a c1499a) {
        synchronized (f2658c) {
            for (String str : f2658c.keySet()) {
                c1499a.m1801a(str, f2658c.get(str));
            }
        }
    }

    /* renamed from: a */
    public static void m1838a(String str) {
        synchronized (f2657b) {
            File file = new File(m1808m());
            C1499a c1499a = new C1499a("pv", true, true);
            String m1860c = C1497g.m1860c(file);
            C1491a.m1925a("wa", "addAuthStat, read data: " + m1860c);
            if (!C1497g.m1872a(m1860c)) {
                c1499a.m1798c(m1860c);
            }
            c1499a.m1802a(str, 1L);
            c1499a.m1802a("aujv", 1L);
            String m1800a = c1499a.m1800a(false, false, false);
            C1491a.m1925a("wa", "addAuthStat, save data: " + m1800a);
            C1497g.m1874a(file, m1800a);
        }
    }

    /* renamed from: a */
    public static void m1837a(String str, int i, int i2) {
        if (!C1509g.m1522O()) {
            return;
        }
        synchronized (f2661f) {
            C1499a c1499a = f2660e.get(str);
            if (c1499a == null) {
                c1499a = new C1499a("cst", false, true);
                f2660e.put(str, c1499a);
                m1841a(c1499a);
            }
            synchronized (f2663h) {
                if (f2663h.size() == 0) {
                    m1845a(100, "pv");
                    m1845a(102, "hpv");
                    m1845a(1, "all");
                    m1845a(2, "afg");
                    m1845a(101, "abg");
                    m1845a(3, "jfg");
                    m1845a(4, "jbg");
                    m1845a(7, "nfg");
                    m1845a(8, "nbg");
                    m1845a(27, "nafg");
                    m1845a(28, "nabg");
                    m1845a(9, "nho");
                    m1845a(10, "uar");
                    m1845a(29, "ulm");
                    m1845a(30, "ukt");
                    m1845a(31, "uet");
                    m1845a(32, "urs");
                    m1845a(11, "ufg");
                    m1845a(12, "ubg");
                    m1845a(40, "anf");
                    m1845a(41, "anb");
                    m1845a(42, "ancf");
                    m1845a(43, "ancb");
                    m1845a(13, "lup");
                    m1845a(14, "luf");
                    m1845a(15, "lef");
                    m1845a(200, "ltf");
                    m1845a(16, "laf");
                    m1845a(22, "lac");
                    m1845a(23, "lau");
                    m1845a(17, "llf");
                    m1845a(18, "lul");
                    m1845a(19, "lub");
                    m1845a(20, "luc");
                    m1845a(21, "luu");
                    m1845a(24, "lzc");
                    m1845a(201, "lec");
                    m1845a(25, "lrc");
                    m1845a(26, "lss");
                }
            }
            String str2 = f2663h.get(i);
            if (str2 == null) {
                C1491a.m1924a("crashsdk", "map key is not set with: " + i, null);
            }
            c1499a.m1801a("prc", str);
            if (str2 != null) {
                c1499a.m1801a(str2, String.valueOf(i2));
            }
        }
    }

    /* renamed from: a */
    public static /* synthetic */ void m1834a(StringBuilder sb, String str, long j) {
        m1823b(sb, str, String.valueOf(j));
    }

    /* renamed from: a */
    public static /* synthetic */ void m1832a(StringBuilder sb, Map map) {
        for (String str : map.keySet()) {
            m1823b(sb, str, (String) map.get(str));
        }
    }

    /* renamed from: a */
    public static void m1831a(boolean z) {
        m1844a(1, z);
    }

    /* renamed from: a */
    public static boolean m1836a(String str, String str2) {
        try {
            String str3 = "c_" + str.replaceAll("[^0-9a-zA-Z-_]", "-");
            String replaceAll = C1497g.m1872a(str2) ? "" : str2.replaceAll("[`=]", "-");
            synchronized (f2658c) {
                if (f2658c.get(str3) == null) {
                    if (f2659d >= 20) {
                        return false;
                    }
                    f2659d++;
                }
                f2658c.put(str3, replaceAll);
                return true;
            }
        } catch (Throwable th) {
            C1497g.m1868a(th);
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m1835a(String str, String str2, boolean z, boolean z2) {
        if (!C1509g.m1522O()) {
            return false;
        }
        return C1500b.m1766a(f2662g, m1807n(), new RunnableC1495e(TinkerReport.KEY_LOADED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND, new Object[]{str, str2, Boolean.valueOf(z), Boolean.valueOf(z2)}));
    }

    /* renamed from: a */
    public static boolean m1830a(boolean z, String str) {
        if (!C1500b.f2714d || z || !JNIBridge.nativeIsCrashing()) {
            return false;
        }
        C1491a.m1922b("crashsdk", "Native is crashing, skip stat for " + str);
        return true;
    }

    /* renamed from: b */
    public static void m1829b() {
        m1846a(2, 0L);
    }

    /* renamed from: b */
    public static void m1828b(int i, long j) {
        if (!C1509g.m1522O()) {
            return;
        }
        C1496f.m1888a(1, new RunnableC1495e(301, new Object[]{Integer.valueOf(i)}), j);
    }

    /* renamed from: b */
    public static void m1826b(String str) {
        synchronized (f2666k) {
            f2667l = str;
            String m1739k = C1500b.m1739k();
            C1492b.m1918a(m1739k, str + "\n");
        }
    }

    /* renamed from: b */
    public static void m1823b(StringBuilder sb, String str, String str2) {
        outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, str, "=", str2, "`");
    }

    /* renamed from: b */
    public static void m1822b(boolean z) {
        if (m1830a(z, "crash detail upload")) {
            return;
        }
        String str = C1509g.m1516U() + "dt.wa";
        C1500b.m1766a(f2661f, str, new RunnableC1495e(TinkerReport.KEY_LOADED_PACKAGE_CHECK_LIB_META, new Object[]{str}));
        String m1807n = m1807n();
        C1500b.m1766a(f2662g, m1807n, new RunnableC1495e(TinkerReport.KEY_LOADED_PACKAGE_CHECK_PATCH_TINKER_ID_NOT_FOUND, new Object[]{m1807n}));
    }

    /* renamed from: b */
    public static boolean m1827b(int i, Object[] objArr) {
        switch (i) {
            case TinkerReport.KEY_LOADED_PACKAGE_CHECK_DEX_META /* 351 */:
                if (!f2656a && objArr == null) {
                    throw new AssertionError();
                }
                String str = (String) objArr[0];
                int intValue = ((Integer) objArr[1]).intValue();
                if (intValue == 1) {
                    if (f2665j) {
                        return false;
                    }
                    f2665j = true;
                }
                if (!C1509g.m1513X()) {
                    C1491a.m1925a("wa", "disable crp stat log");
                    return false;
                }
                File file = new File(str);
                ArrayList<C1499a> m1840a = m1840a(file, "crp", 100);
                if (intValue != 4) {
                    C1499a c1499a = new C1499a("crp", false, false);
                    String str2 = "1";
                    if (intValue == 1) {
                        c1499a.m1801a("et", String.valueOf(C1500b.m1788I()));
                        c1499a.m1801a("ete", String.valueOf(C1500b.m1787J()));
                    } else if (intValue == 3) {
                        c1499a.m1801a("et", str2);
                        c1499a.m1801a("ete", str2);
                    } else if (intValue == 2) {
                        c1499a.m1801a("hpv", str2);
                    }
                    c1499a.m1801a("prc", C1503e.m1610h());
                    if (!C1500b.m1791F()) {
                        str2 = "0";
                    }
                    c1499a.m1801a("imp", str2);
                    m1841a(c1499a);
                    m1840a.add(0, c1499a);
                }
                if (!m1840a.isEmpty()) {
                    boolean m1819c = m1819c(C1503e.m1590q(), m1839a((Iterable<C1499a>) m1840a, true, false).toString());
                    C1497g.m1864b(file);
                    if (!m1819c) {
                        C1497g.m1874a(file, m1839a((Iterable<C1499a>) m1840a, false, true).toString());
                    }
                }
                return true;
            case TinkerReport.KEY_LOADED_PACKAGE_CHECK_LIB_META /* 352 */:
                if (!f2656a && objArr == null) {
                    throw new AssertionError();
                }
                return m1817d((String) objArr[0]);
            case TinkerReport.KEY_LOADED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND /* 353 */:
                if (!f2656a && objArr == null) {
                    throw new AssertionError();
                }
                return m1824b((String) objArr[0], (String) objArr[1], ((Boolean) objArr[2]).booleanValue(), ((Boolean) objArr[3]).booleanValue());
            case TinkerReport.KEY_LOADED_PACKAGE_CHECK_PATCH_TINKER_ID_NOT_FOUND /* 354 */:
                if (!f2656a && objArr == null) {
                    throw new AssertionError();
                }
                File file2 = new File((String) objArr[0]);
                boolean m1819c2 = m1819c(C1503e.m1590q(), m1839a((Iterable<C1499a>) m1840a(file2, "cst", 30), true, false).toString());
                if (m1819c2) {
                    C1497g.m1864b(file2);
                }
                return m1819c2;
            default:
                return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00be A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0080  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean m1825b(String str, String str2) {
        byte[] bArr;
        boolean z;
        String sb;
        if (C1497g.m1872a(str2)) {
            return true;
        }
        C1491a.m1925a("wa", "Reporting datas: " + str2);
        byte[] bytes = str2.getBytes();
        long currentTimeMillis = System.currentTimeMillis();
        String m1859c = C1497g.m1859c(C1509g.m1494e() + str + currentTimeMillis + "AppChk#2014");
        try {
            bArr = C1493c.m1907a(bytes, m1859c.substring(m1859c.length() - 16, m1859c.length()).getBytes());
        } catch (Throwable th) {
            C1497g.m1868a(th);
        }
        if (bArr != null) {
            z = true;
            String substring = m1859c.substring(m1859c.length() - 8, m1859c.length());
            StringBuilder sb2 = new StringBuilder();
            outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb2, !C1509g.m1521P() ? "https://px-intl.ucweb.com" : "https://px.ucweb.com", "/api/v1/crashtrack/upload?chk=", substring, "&vno=");
            sb2.append(currentTimeMillis);
            sb2.append("&uuid=");
            sb2.append(str);
            sb2.append("&app=");
            sb2.append(C1509g.m1494e());
            if (z) {
                sb2.append("&enc=aes");
            }
            sb = sb2.toString();
            C1491a.m1925a("wa", "url: " + sb);
            if (sb != null) {
                return false;
            }
            byte[] m1911a = C1493c.m1911a(sb, bArr, true);
            if (m1911a == null) {
                C1491a.m1925a("wa", "px response is empty!");
                return false;
            }
            String str3 = new String(m1911a);
            C1491a.m1925a("wa", "px response: " + str3);
            return str3.contains("retcode=0");
        }
        bArr = bytes;
        z = false;
        String substring2 = m1859c.substring(m1859c.length() - 8, m1859c.length());
        StringBuilder sb22 = new StringBuilder();
        outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb22, !C1509g.m1521P() ? "https://px-intl.ucweb.com" : "https://px.ucweb.com", "/api/v1/crashtrack/upload?chk=", substring2, "&vno=");
        sb22.append(currentTimeMillis);
        sb22.append("&uuid=");
        sb22.append(str);
        sb22.append("&app=");
        sb22.append(C1509g.m1494e());
        if (z) {
        }
        sb = sb22.toString();
        C1491a.m1925a("wa", "url: " + sb);
        if (sb != null) {
        }
    }

    /* renamed from: b */
    public static boolean m1824b(String str, String str2, boolean z, boolean z2) {
        C1499a c1499a;
        File file = new File(m1807n());
        ArrayList<C1499a> m1840a = m1840a(file, "cst", 30);
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, str2);
        Iterator<C1499a> it = m1840a.iterator();
        while (true) {
            if (!it.hasNext()) {
                c1499a = null;
                break;
            }
            c1499a = it.next();
            String m1799b = c1499a.m1799b("prc");
            String m1799b2 = c1499a.m1799b("typ");
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(m1799b + m1799b2)) {
                break;
            }
        }
        if (c1499a == null) {
            c1499a = new C1499a("cst", false, true);
            c1499a.m1801a("prc", str);
            c1499a.m1801a("typ", str2);
            m1841a(c1499a);
            m1840a.add(c1499a);
        }
        c1499a.m1802a("cnt", 1L);
        if (z) {
            c1499a.m1802a("lim", 1L);
        }
        if (z2) {
            c1499a.m1802a("syu", 1L);
        }
        return C1497g.m1874a(file, m1839a((Iterable<C1499a>) m1840a, false, false).toString());
    }

    /* renamed from: c */
    public static /* synthetic */ Map m1820c(String str) {
        String[] split;
        HashMap hashMap = new HashMap();
        for (String str2 : str.split("`")) {
            if (str2.length() > 1) {
                String[] split2 = str2.split("=", 3);
                if (split2.length == 2) {
                    hashMap.put(split2[0], split2[1]);
                }
            }
        }
        return hashMap;
    }

    /* renamed from: c */
    public static void m1821c() {
        m1846a(3, 0L);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00fe A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ff A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0061  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean m1819c(String str, String str2) {
        byte[] bArr;
        boolean z;
        String m1859c;
        String sb;
        byte[] m1911a;
        if (C1497g.m1872a(str2)) {
            return true;
        }
        C1491a.m1925a("wa", "Reporting datas: " + str2);
        byte[] bytes = str2.getBytes();
        try {
            byte[] bArr2 = new byte[16];
            C1493c.m1909a(bArr2, 0, C1493c.m1914a());
            C1493c.m1909a(bArr2, 4, m1811j());
            C1493c.m1909a(bArr2, 8, C1490a.m1937f());
            C1493c.m1909a(bArr2, 12, C1494d.m1896d());
            bArr = C1493c.m1907a(bytes, bArr2);
        } catch (Throwable th) {
            C1497g.m1868a(th);
        }
        if (bArr != null) {
            z = true;
            if (str == null) {
                str = "unknown";
            }
            String str3 = !C1509g.m1521P() ? "4ea4e41a3993" : "28ef1713347d";
            String valueOf = String.valueOf(System.currentTimeMillis());
            m1859c = C1497g.m1859c(str3 + str + valueOf + "AppChk#2014");
            if (m1859c != null) {
                sb = null;
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(m1805p());
                sb2.append("?chk=");
                sb2.append(m1859c.substring(m1859c.length() - 8, m1859c.length()));
                sb2.append("&vno=");
                sb2.append(valueOf);
                outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb2, "&uuid=", str, "&app=", str3);
                if (z) {
                    sb2.append("&enc=aes");
                }
                sb = sb2.toString();
            }
            C1491a.m1925a("wa", "url: " + sb);
            if (sb != null || (m1911a = C1493c.m1911a(sb, bArr, true)) == null) {
                return false;
            }
            String str4 = new String(m1911a);
            C1491a.m1925a("wa", "wa response: " + str4);
            return !str4.contains("retcode=0");
        }
        bArr = bytes;
        z = false;
        if (str == null) {
        }
        if (!C1509g.m1521P()) {
        }
        String valueOf2 = String.valueOf(System.currentTimeMillis());
        m1859c = C1497g.m1859c(str3 + str + valueOf2 + "AppChk#2014");
        if (m1859c != null) {
        }
        C1491a.m1925a("wa", "url: " + sb);
        if (sb != null) {
            return false;
        }
        String str42 = new String(m1911a);
        C1491a.m1925a("wa", "wa response: " + str42);
        if (!str42.contains("retcode=0")) {
        }
    }

    /* renamed from: d */
    public static void m1818d() {
        m1828b(2, 2000L);
        m1846a(1, 70000L);
    }

    /* renamed from: d */
    public static boolean m1817d(String str) {
        File file = new File(str);
        Iterator<C1499a> it = m1840a(file, "cst", 30).iterator();
        while (it.hasNext()) {
            C1499a next = it.next();
            String m1803a = next.m1803a("prc");
            if (!C1497g.m1872a(m1803a)) {
                C1499a c1499a = f2660e.get(m1803a);
                if (c1499a != null) {
                    c1499a.m1804a(next);
                } else {
                    f2660e.put(m1803a, next);
                }
            }
        }
        StringBuilder m1839a = m1839a((Iterable<C1499a>) f2660e.values(), true, false);
        boolean m1825b = C1509g.m1512Y() ? m1825b(C1503e.m1590q(), m1839a.toString()) : m1819c(C1503e.m1590q(), m1839a.toString());
        C1497g.m1864b(file);
        if (m1825b || C1497g.m1874a(file, m1839a((Iterable<C1499a>) f2660e.values(), false, true).toString())) {
            f2660e.clear();
        }
        return true;
    }

    /* renamed from: e */
    public static boolean m1816e() {
        return f2665j;
    }

    /* renamed from: f */
    public static void m1815f() {
        m1828b(1, 2000L);
    }

    /* renamed from: g */
    public static void m1814g() {
        m1828b(3, 0L);
    }

    /* renamed from: h */
    public static void m1813h() {
        m1828b(4, 0L);
    }

    /* renamed from: i */
    public static void m1812i() {
        if (!C1509g.m1522O()) {
            return;
        }
        C1496f.m1889a(1, new RunnableC1495e(303));
    }

    /* renamed from: j */
    public static byte[] m1811j() {
        return new byte[]{Byte.MAX_VALUE, 100, 110, 31};
    }

    /* renamed from: k */
    public static void m1810k() {
        synchronized (f2666k) {
            f2667l = null;
        }
    }

    /* renamed from: m */
    public static String m1808m() {
        return C1509g.m1516U() + "pv.wa";
    }

    /* renamed from: n */
    public static String m1807n() {
        return C1509g.m1516U() + "cdt.wa";
    }

    /* renamed from: o */
    public static long m1806o() {
        Iterator<String> it = C1497g.m1877a(new File("/proc/meminfo"), 2).iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            if (next.contains("MemTotal:")) {
                try {
                    return Long.parseLong(next.replaceAll("\\D+", ""));
                } catch (NumberFormatException e) {
                    C1497g.m1868a(e);
                }
            }
        }
        return 0L;
    }

    /* renamed from: p */
    public static String m1805p() {
        String str = f2667l;
        if (C1497g.m1872a(str)) {
            synchronized (f2666k) {
                String str2 = "https://errlog.umeng.com/api/crashsdk/logcollect";
                if (C1509g.m1521P()) {
                    str2 = "https://errlogos.umeng.com/api/crashsdk/logcollect";
                }
                str = C1497g.m1871a(C1500b.m1739k(), str2, true);
                f2667l = str;
            }
        }
        return str;
    }
}
