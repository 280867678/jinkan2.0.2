package com.p046uc.crashsdk;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.app.NotificationCompat;
import com.p046uc.crashsdk.p047a.C1491a;
import com.p046uc.crashsdk.p047a.C1496f;
import com.p046uc.crashsdk.p047a.C1497g;
import com.p046uc.crashsdk.p047a.C1498h;
import com.p046uc.crashsdk.p047a.RunnableC1495e;
import java.io.File;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;
import java.util.WeakHashMap;
import me.tvspark.outline;
import org.mozilla.javascript.v8dtoa.FastDtoa;

/* renamed from: com.uc.crashsdk.b */
/* loaded from: classes4.dex */
public class C1500b {

    /* renamed from: i */
    public static final /* synthetic */ boolean f2719i = !C1500b.class.desiredAssertionStatus();

    /* renamed from: j */
    public static String f2720j = null;

    /* renamed from: k */
    public static String f2721k = null;

    /* renamed from: l */
    public static String f2722l = null;

    /* renamed from: m */
    public static String f2723m = null;

    /* renamed from: n */
    public static String f2724n = null;

    /* renamed from: o */
    public static String f2725o = null;

    /* renamed from: p */
    public static String f2726p = null;

    /* renamed from: q */
    public static String f2727q = null;

    /* renamed from: r */
    public static String f2728r = null;

    /* renamed from: s */
    public static String f2729s = null;

    /* renamed from: t */
    public static String f2730t = null;

    /* renamed from: u */
    public static String f2731u = null;

    /* renamed from: v */
    public static String f2732v = null;

    /* renamed from: w */
    public static String f2733w = null;

    /* renamed from: a */
    public static boolean f2700a = false;

    /* renamed from: b */
    public static boolean f2712b = false;

    /* renamed from: c */
    public static boolean f2713c = false;

    /* renamed from: d */
    public static boolean f2714d = false;

    /* renamed from: e */
    public static final Object f2715e = new Object();

    /* renamed from: f */
    public static boolean f2716f = false;

    /* renamed from: g */
    public static boolean f2717g = true;

    /* renamed from: h */
    public static boolean f2718h = false;

    /* renamed from: x */
    public static boolean f2734x = false;

    /* renamed from: y */
    public static boolean f2735y = false;

    /* renamed from: z */
    public static volatile boolean f2736z = false;

    /* renamed from: A */
    public static boolean f2674A = false;

    /* renamed from: B */
    public static boolean f2675B = false;

    /* renamed from: C */
    public static boolean f2676C = false;

    /* renamed from: D */
    public static boolean f2677D = false;

    /* renamed from: E */
    public static boolean f2678E = false;

    /* renamed from: F */
    public static boolean f2679F = false;

    /* renamed from: G */
    public static final Object f2680G = new Object();

    /* renamed from: H */
    public static String f2681H = null;

    /* renamed from: I */
    public static int f2682I = 0;

    /* renamed from: J */
    public static boolean f2683J = false;

    /* renamed from: K */
    public static boolean f2684K = false;

    /* renamed from: L */
    public static boolean f2685L = true;

    /* renamed from: M */
    public static RandomAccessFile f2686M = null;

    /* renamed from: N */
    public static boolean f2687N = false;

    /* renamed from: O */
    public static final Object f2688O = new Object();

    /* renamed from: P */
    public static String f2689P = null;

    /* renamed from: Q */
    public static boolean f2690Q = false;

    /* renamed from: R */
    public static volatile Object[] f2691R = null;

    /* renamed from: S */
    public static Runnable f2692S = new RunnableC1495e(101);

    /* renamed from: T */
    public static boolean f2693T = false;

    /* renamed from: U */
    public static long f2694U = 0;

    /* renamed from: V */
    public static final Object f2695V = new Object();

    /* renamed from: W */
    public static long f2696W = 0;

    /* renamed from: X */
    public static boolean f2697X = false;

    /* renamed from: Y */
    public static boolean f2698Y = false;

    /* renamed from: Z */
    public static boolean f2699Z = false;

    /* renamed from: aa */
    public static long f2701aa = 0;

    /* renamed from: ab */
    public static final WeakHashMap<Activity, Integer> f2702ab = new WeakHashMap<>();

    /* renamed from: ac */
    public static boolean f2703ac = false;

    /* renamed from: ad */
    public static String f2704ad = null;

    /* renamed from: ae */
    public static boolean f2705ae = false;

    /* renamed from: af */
    public static boolean f2706af = false;

    /* renamed from: ag */
    public static boolean f2707ag = false;

    /* renamed from: ah */
    public static boolean f2708ah = false;

    /* renamed from: ai */
    public static boolean f2709ai = false;

    /* renamed from: aj */
    public static final Object f2710aj = new Object();

    /* renamed from: ak */
    public static PendingIntent f2711ak = null;

    /* renamed from: A */
    public static boolean m1796A() {
        return f2698Y || !m1759ad();
    }

    /* renamed from: B */
    public static boolean m1795B() {
        return f2698Y && !f2734x;
    }

    /* renamed from: C */
    public static void m1794C() {
        C1496f.m1889a(2, new RunnableC1495e(100));
    }

    /* renamed from: D */
    public static void m1793D() {
        String str;
        if (!f2714d || (str = f2704ad) == null) {
            return;
        }
        JNIBridge.set(129, str);
    }

    /* renamed from: E */
    public static String m1792E() {
        String str = f2704ad;
        return str == null ? "" : str;
    }

    /* renamed from: F */
    public static boolean m1791F() {
        if (!f2705ae) {
            if (!C1497g.m1872a(C1490a.f2594a) && C1490a.f2594a.equals(C1503e.m1610h())) {
                f2706af = true;
                if (f2714d) {
                    JNIBridge.set(2, true);
                }
            }
            f2705ae = true;
        }
        return f2706af;
    }

    /* renamed from: G */
    public static void m1790G() {
        f2707ag = true;
        if (f2714d) {
            JNIBridge.set(34, true);
        }
    }

    /* renamed from: H */
    public static boolean m1789H() {
        return f2707ag;
    }

    /* renamed from: I */
    public static int m1788I() {
        boolean m1776U = m1776U();
        return m1730t() ? m1776U ? 3 : 6 : m1731s() ? m1776U ? 2 : 5 : m1776U ? 4 : 1;
    }

    /* renamed from: J */
    public static int m1787J() {
        boolean m1775V = m1775V();
        boolean m1774W = m1774W();
        boolean m1773X = m1773X();
        if (m1730t()) {
            if (m1775V) {
                return 12;
            }
            if (m1774W) {
                return 14;
            }
            return m1773X ? 16 : 98;
        } else if (!m1731s()) {
            return 1;
        } else {
            if (m1775V) {
                return 11;
            }
            if (m1774W) {
                return 13;
            }
            return m1773X ? 15 : 97;
        }
    }

    /* renamed from: K */
    public static void m1786K() {
        if (f2714d) {
            JNIBridge.nativeSet(27, f2682I, "12", null);
            JNIBridge.set(30, f2685L);
        }
    }

    /* renamed from: L */
    public static boolean m1785L() {
        if (!f2709ai) {
            synchronized (f2710aj) {
                if (!f2709ai) {
                    f2708ah = m1758ae();
                    f2709ai = true;
                }
            }
        }
        return f2708ah;
    }

    /* renamed from: M */
    public static void m1784M() {
        if (C1503e.m1706F() || m1785L() || f2711ak != null || C1509g.m1491h() < 0) {
            return;
        }
        try {
            Context m1882a = C1497g.m1882a();
            Intent launchIntentForPackage = m1882a.getPackageManager().getLaunchIntentForPackage(m1882a.getPackageName());
            launchIntentForPackage.addFlags(335544320);
            f2711ak = PendingIntent.getActivity(m1882a, 0, launchIntentForPackage, 0);
        } catch (Throwable th) {
            C1497g.m1868a(th);
        }
    }

    /* renamed from: N */
    public static boolean m1783N() {
        if (f2711ak == null) {
            C1491a.m1923b("Restart intent is null!");
            return false;
        }
        try {
            C1491a.m1925a("crashsdk", "restarting ...");
            ((AlarmManager) C1497g.m1882a().getSystemService(NotificationCompat.CATEGORY_ALARM)).set(1, System.currentTimeMillis() + 200, f2711ak);
            return true;
        } catch (Throwable th) {
            C1497g.m1868a(th);
            return false;
        }
    }

    /* renamed from: Q */
    public static String m1780Q() {
        if (f2720j == null) {
            f2720j = m1748d("ss");
        }
        return f2720j;
    }

    /* renamed from: R */
    public static String m1779R() {
        if (f2722l == null) {
            f2722l = m1748d("ctn");
        }
        return f2722l;
    }

    /* renamed from: S */
    public static String m1778S() {
        if (f2723m == null) {
            f2723m = m1748d("cta");
        }
        return f2723m;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0071 A[Catch: all -> 0x0075, TRY_LEAVE, TryCatch #1 {, blocks: (B:8:0x000d, B:10:0x0011, B:13:0x0013, B:18:0x0057, B:20:0x005b, B:22:0x005f, B:24:0x0063, B:28:0x0079, B:29:0x007b, B:25:0x006b, B:27:0x0071), top: B:7:0x000d }] */
    /* renamed from: T */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void m1777T() {
        boolean z;
        if (f2736z || f2735y) {
            return;
        }
        synchronized (f2680G) {
            if (f2736z) {
                return;
            }
            m1744f(C1509g.m1516U());
            String m1734p = m1734p();
            File file = new File(m1757b());
            File file2 = new File(m1779R());
            f2674A = "f".equals(m1734p);
            f2675B = "b".equals(m1734p);
            f2677D = file.exists();
            boolean exists = file2.exists();
            f2678E = exists;
            if (!f2677D && !exists) {
                z = false;
                f2676C = z;
                if (!z && (f2674A || f2675B)) {
                    boolean m1732r = m1732r();
                    f2679F = m1732r;
                    f2676C = m1732r;
                }
                if (m1724z()) {
                    m1771Z();
                }
                f2736z = true;
            }
            z = true;
            f2676C = z;
            if (!z) {
                boolean m1732r2 = m1732r();
                f2679F = m1732r2;
                f2676C = m1732r2;
            }
            if (m1724z()) {
            }
            f2736z = true;
        }
    }

    /* renamed from: U */
    public static boolean m1776U() {
        m1777T();
        return f2676C;
    }

    /* renamed from: V */
    public static boolean m1775V() {
        m1777T();
        return f2677D;
    }

    /* renamed from: W */
    public static boolean m1774W() {
        m1777T();
        return f2678E;
    }

    /* renamed from: X */
    public static boolean m1773X() {
        m1777T();
        return f2679F;
    }

    /* renamed from: Y */
    public static void m1772Y() {
        if (f2714d) {
            JNIBridge.set(26, f2734x);
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0041 -> B:13:0x0044). Please submit an issue!!! */
    /* renamed from: Z */
    public static void m1771Z() {
        if (!f2693T) {
            f2693T = true;
            try {
                new File(m1757b()).delete();
            } catch (Throwable th) {
                C1497g.m1868a(th);
            }
            try {
                new File(m1779R()).delete();
            } catch (Throwable th2) {
                C1497g.m1868a(th2);
            }
            try {
                if (f2714d) {
                    JNIBridge.cmd(16);
                } else {
                    new File(m1778S()).delete();
                }
            } catch (Throwable th3) {
                C1497g.m1868a(th3);
            }
        }
        Object[] m1761ab = m1761ab();
        if (!m1761ab[0].equals(f2689P) && f2691R == null) {
            m1763a(m1761ab);
            return;
        }
        f2690Q = true;
        m1762aa();
    }

    /* renamed from: a */
    public static Object m1767a(Object obj, Class<?> cls, String str) {
        if (obj == null) {
            return null;
        }
        if (cls == null) {
            cls = obj.getClass();
        }
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (Throwable th) {
            C1497g.m1868a(th);
            return null;
        }
    }

    /* renamed from: a */
    public static String m1770a() {
        String sb;
        char c;
        String str = f2681H;
        if (str != null) {
            return str;
        }
        String m1610h = C1503e.m1610h();
        if (C1497g.m1872a(m1610h)) {
            sb = "LLUN";
        } else {
            int i = 0;
            if (m1610h.length() > 48) {
                m1610h = m1610h.substring(0, 48);
                i = m1610h.length() - 48;
            }
            StringBuilder sb2 = new StringBuilder();
            byte[] bytes = m1610h.getBytes();
            for (int length = bytes.length - 1; length >= 0; length--) {
                int i2 = bytes[length];
                if (i2 == 46) {
                    sb2.append('0');
                } else {
                    if (i2 == 58) {
                        c = '1';
                    } else {
                        if (i2 >= 97 && i2 <= 122) {
                            i2 = (i2 + 65) - 97;
                        } else if ((i2 < 65 || i2 > 90) && (i2 < 48 || i2 > 57)) {
                            c = '2';
                        }
                        c = (char) i2;
                    }
                    sb2.append(c);
                }
            }
            if (i > 0) {
                sb2.append(String.valueOf(i));
            }
            sb = sb2.toString();
        }
        f2681H = sb;
        return f2681H;
    }

    /* renamed from: a */
    public static String m1765a(String str) {
        if (str == null || str.length() <= 0 || !str.endsWith(".st")) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(".st");
        if (!f2719i && lastIndexOf < 0) {
            throw new AssertionError();
        }
        String substring = str.substring(0, lastIndexOf);
        if (substring.length() > 0) {
            return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(substring, ".stcb");
        }
        return null;
    }

    /* renamed from: a */
    public static void m1769a(int i) {
        Object m1767a;
        Activity activity;
        int i2;
        boolean z = false;
        boolean z2 = true;
        switch (i) {
            case 100:
                Object m1760ac = m1760ac();
                if (m1760ac == null || (m1767a = m1767a(m1760ac, (Class<?>) null, "mActivities")) == null) {
                    return;
                }
                try {
                    boolean z3 = false;
                    for (Map.Entry entry : ((Map) m1767a).entrySet()) {
                        Object value = entry.getValue();
                        if (value != null && (activity = (Activity) m1767a(value, (Class<?>) null, ActivityChooserModel.ATTRIBUTE_ACTIVITY)) != null) {
                            boolean booleanValue = ((Boolean) m1767a(value, (Class<?>) null, "paused")).booleanValue();
                            boolean booleanValue2 = ((Boolean) m1767a(value, (Class<?>) null, "stopped")).booleanValue();
                            synchronized (f2702ab) {
                                if (booleanValue || booleanValue2) {
                                    i2 = 2;
                                } else {
                                    i2 = 1;
                                    z3 = true;
                                }
                                f2702ab.put(activity, Integer.valueOf(i2));
                            }
                        }
                        z = true;
                    }
                    if (!z) {
                        return;
                    }
                    m1753b(z3);
                    return;
                } catch (Throwable th) {
                    C1497g.m1868a(th);
                    return;
                }
            case 101:
                try {
                    if (new File(m1780Q()).exists()) {
                        z2 = false;
                    }
                    f2687N = z2;
                    if (!z2 && !f2690Q) {
                        return;
                    }
                    m1763a(m1761ab());
                    f2690Q = false;
                    return;
                } catch (Throwable th2) {
                    C1497g.m1868a(th2);
                    return;
                }
            case 102:
                C1496f.m1889a(1, new RunnableC1495e(103));
                return;
            case 103:
                try {
                    C1497g.m1878a(new File(m1778S()));
                    return;
                } catch (Throwable th3) {
                    C1497g.m1868a(th3);
                    return;
                }
            case 104:
                C1498h.m1818d();
                C1508f.m1564a(102);
                if (!m1791F()) {
                    return;
                }
                C1503e.m1709C();
                return;
            default:
                if (!f2719i) {
                    throw new AssertionError();
                }
                return;
        }
    }

    /* renamed from: a */
    public static void m1764a(boolean z) {
        f2685L = z;
        if (f2714d) {
            JNIBridge.set(30, z);
        }
    }

    /* renamed from: a */
    public static void m1763a(Object[] objArr) {
        f2691R = objArr;
        synchronized (f2688O) {
            String str = (String) objArr[0];
            long longValue = ((Long) objArr[1]).longValue();
            if (longValue < f2694U) {
                C1491a.m1921c("crashsdk", String.format(Locale.US, "Update state generation %d, last is: %d", Long.valueOf(longValue), Long.valueOf(f2694U)));
                return;
            }
            f2694U = longValue;
            String m1780Q = m1780Q();
            if (f2714d) {
                if (f2686M != null) {
                    C1497g.m1879a(f2686M);
                    f2686M = null;
                }
                boolean nativeChangeState = JNIBridge.nativeChangeState(m1780Q, str, f2687N);
                f2687N = false;
                if (!nativeChangeState) {
                    C1491a.m1923b("write state failed: " + str);
                }
            } else {
                if (f2686M == null || f2687N) {
                    if (f2686M != null) {
                        C1497g.m1879a(f2686M);
                        f2686M = null;
                    }
                    try {
                        RandomAccessFile randomAccessFile = new RandomAccessFile(m1780Q, "rw");
                        f2686M = randomAccessFile;
                        randomAccessFile.seek(0L);
                        f2687N = false;
                    } catch (Exception e) {
                        C1497g.m1868a(e);
                    }
                }
                try {
                    f2686M.write(str.getBytes());
                    f2686M.seek(0L);
                } catch (Exception e2) {
                    C1497g.m1868a(e2);
                }
            }
            f2689P = str;
            f2691R = null;
        }
    }

    /* renamed from: a */
    public static boolean m1768a(Context context) {
        try {
            ((Application) context).registerActivityLifecycleCallbacks(new C1501c());
            if (!C1509g.m1527J()) {
                return true;
            }
            m1794C();
            return true;
        } catch (Throwable th) {
            C1497g.m1868a(th);
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m1766a(Object obj, String str, RunnableC1495e runnableC1495e) {
        FileChannel fileChannel;
        boolean z;
        synchronized (obj) {
            FileChannel fileChannel2 = null;
            r1 = null;
            FileLock lock = null;
            fileChannel2 = null;
            boolean z2 = false;
            if (f2714d) {
                int nativeOpenFile = JNIBridge.nativeOpenFile(str);
                if (nativeOpenFile < 0) {
                    C1491a.m1924a("crashsdk", "Can not open file: " + str, null);
                    return false;
                }
                boolean nativeLockFile = JNIBridge.nativeLockFile(nativeOpenFile, true);
                try {
                    z = runnableC1495e.m1892a();
                    JNIBridge.nativeCloseFile(nativeOpenFile);
                } finally {
                    if (nativeLockFile) {
                        JNIBridge.nativeLockFile(nativeOpenFile, false);
                    }
                }
            } else {
                File file = new File(str);
                if (!file.exists()) {
                    try {
                        file.createNewFile();
                    } catch (Exception e) {
                        C1497g.m1868a(e);
                    }
                }
                try {
                    try {
                        fileChannel = new RandomAccessFile(file, "rw").getChannel();
                    } catch (Exception e2) {
                        try {
                            C1497g.m1868a(e2);
                            fileChannel = null;
                        } catch (Exception e3) {
                            e = e3;
                            C1497g.m1868a(e);
                            C1497g.m1879a(fileChannel2);
                            z = z2;
                            return z;
                        }
                    }
                    if (fileChannel != null) {
                        try {
                            try {
                                lock = fileChannel.lock();
                            } catch (Exception e4) {
                                try {
                                    C1497g.m1868a(e4);
                                } catch (Exception e5) {
                                    e = e5;
                                    fileChannel2 = fileChannel;
                                    C1497g.m1868a(e);
                                    C1497g.m1879a(fileChannel2);
                                    z = z2;
                                    return z;
                                }
                            }
                        } catch (Throwable th) {
                            fileChannel2 = fileChannel;
                            th = th;
                            C1497g.m1879a(fileChannel2);
                            throw th;
                        }
                    }
                    try {
                        z2 = runnableC1495e.m1892a();
                        C1497g.m1879a(fileChannel);
                        z = z2;
                    } finally {
                        if (lock != null) {
                            try {
                                lock.release();
                            } catch (Exception e6) {
                                C1497g.m1868a(e6);
                            }
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    C1497g.m1879a(fileChannel2);
                    throw th;
                }
            }
            return z;
        }
    }

    /* renamed from: aa */
    public static void m1762aa() {
        if (!C1496f.m1884b(f2692S)) {
            C1496f.m1889a(1, f2692S);
            return;
        }
        Object[] objArr = f2691R;
        if (objArr != null && m1761ab()[0].equals(objArr[0])) {
            return;
        }
        C1496f.m1886a(f2692S);
        C1496f.m1889a(1, f2692S);
    }

    /* renamed from: ab */
    public static Object[] m1761ab() {
        synchronized (f2695V) {
            long j = f2696W + 1;
            f2696W = j;
            if (f2734x) {
                return new Object[]{"e", Long.valueOf(j)};
            } else if (m1795B()) {
                return new Object[]{"f", Long.valueOf(f2696W)};
            } else {
                return new Object[]{"b", Long.valueOf(f2696W)};
            }
        }
    }

    /* renamed from: ac */
    public static Object m1760ac() {
        Object m1767a;
        Object m1767a2 = m1767a((Application) C1497g.m1882a(), Application.class, "mLoadedApk");
        if (m1767a2 == null || (m1767a = m1767a(m1767a2, (Class<?>) null, "mActivityThread")) == null) {
            try {
                Method declaredMethod = Class.forName("android.app.ActivityThread").getDeclaredMethod("currentActivityThread", new Class[0]);
                if (declaredMethod != null) {
                    declaredMethod.setAccessible(true);
                    return declaredMethod.invoke(null, new Object[0]);
                }
            } catch (Throwable th) {
                C1497g.m1868a(th);
            }
            return null;
        }
        return m1767a;
    }

    /* renamed from: ad */
    public static boolean m1759ad() {
        String m1876a = C1497g.m1876a(new File("/proc/self/cgroup"), 512, false);
        if (C1497g.m1872a(m1876a)) {
            return false;
        }
        return m1876a.contains("/bg_non_interactive") || m1876a.contains("/background");
    }

    /* renamed from: ae */
    public static boolean m1758ae() {
        try {
            Method declaredMethod = Process.class.getDeclaredMethod("isIsolated", new Class[0]);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(null, new Object[0]);
                if (invoke != null && (invoke instanceof Boolean)) {
                    return ((Boolean) invoke).booleanValue();
                }
            }
        } catch (Throwable th) {
            C1497g.m1868a(th);
        }
        int myUid = Process.myUid() % FastDtoa.kTen5;
        return myUid >= 99000 && myUid <= 99999;
    }

    /* renamed from: b */
    public static String m1757b() {
        if (f2721k == null) {
            f2721k = m1748d("ctj");
        }
        return f2721k;
    }

    /* renamed from: b */
    public static String m1754b(String str) {
        return "debug.crs." + str;
    }

    /* renamed from: b */
    public static void m1756b(int i) {
        f2682I = i;
        m1786K();
    }

    /* renamed from: b */
    public static void m1755b(Context context) {
        C1491a.m1926a("Restart APP");
        if (context == null) {
            return;
        }
        if (f2726p == null) {
            f2726p = m1748d("rt");
        }
        File file = new File(f2726p);
        long j = -1;
        try {
            j = Long.parseLong(C1497g.m1857d(file));
        } catch (Throwable th) {
            C1497g.m1868a(th);
        }
        boolean z = false;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (C1509g.m1491h() >= 0 && (j <= 0 || currentTimeMillis - j > C1509g.m1491h())) {
            m1744f(C1509g.m1516U());
            C1497g.m1874a(file, String.valueOf(currentTimeMillis));
            z = true;
        }
        C1491a.m1926a("lastTime: " + j + ", currentTime: " + currentTimeMillis + ", needRestart: " + z);
        if (!z) {
            return;
        }
        try {
            C1502d.m1715a(true);
        } catch (Throwable th2) {
            C1497g.m1868a(th2);
        }
        m1783N();
    }

    /* renamed from: b */
    public static void m1753b(boolean z) {
        if (C1503e.m1583u()) {
            return;
        }
        if (z && f2734x) {
            C1509g.m1524M();
            f2734x = false;
            m1772Y();
        }
        boolean z2 = C1503e.m1706F() || m1785L();
        long currentTimeMillis = System.currentTimeMillis();
        if (f2697X && !f2698Y && z) {
            long j = f2701aa;
            if (j != 0 && !z2 && currentTimeMillis - j > 1800000) {
                C1496f.m1888a(1, new RunnableC1495e(104), 1000L);
            }
        }
        f2701aa = currentTimeMillis;
        f2698Y = z;
        if (z) {
            f2697X = true;
        }
        if (f2714d) {
            JNIBridge.nativeSetForeground(z);
        }
        if (f2734x || z2) {
            return;
        }
        m1777T();
        m1771Z();
        if (z) {
            C1490a.m1947a(false);
            if (!f2699Z) {
                C1503e.m1710B();
                f2699Z = true;
            }
        }
        if (!f2687N) {
            m1762aa();
        }
        C1503e.m1632c(z);
    }

    /* renamed from: c */
    public static String m1752c() {
        if (f2724n == null) {
            f2724n = m1748d("st");
        }
        return f2724n;
    }

    /* renamed from: c */
    public static boolean m1751c(int i) {
        return (i & f2682I) != 0;
    }

    /* renamed from: d */
    public static String m1748d(String str) {
        return C1509g.m1516U() + m1770a() + "." + str;
    }

    /* renamed from: d */
    public static File[] m1749d() {
        return m1746e(".st");
    }

    /* renamed from: e */
    public static String m1747e() {
        if (f2725o == null) {
            f2725o = m1748d("stcb");
        }
        return f2725o;
    }

    /* renamed from: e */
    public static File[] m1746e(String str) {
        if (f2719i || str.length() > 0) {
            File[] listFiles = new File(C1509g.m1516U()).listFiles();
            if (listFiles == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (File file : listFiles) {
                if (file.getPath().endsWith(str)) {
                    arrayList.add(file);
                }
            }
            return (File[]) arrayList.toArray(new File[arrayList.size()]);
        }
        throw new AssertionError();
    }

    /* renamed from: f */
    public static boolean m1744f(String str) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (file.isDirectory()) {
            return true;
        }
        C1491a.m1924a("crashsdk", "Crash log directory was placed by a file!", null);
        if (!file.delete()) {
            return false;
        }
        file.mkdirs();
        return true;
    }

    /* renamed from: f */
    public static File[] m1745f() {
        return m1746e(".stcb");
    }

    /* renamed from: g */
    public static String m1743g() {
        if (f2732v == null) {
            f2732v = m1748d("bati");
        }
        return f2732v;
    }

    /* renamed from: h */
    public static String m1742h() {
        if (f2733w == null) {
            f2733w = m1748d("hdr");
        }
        return f2733w;
    }

    /* renamed from: i */
    public static String m1741i() {
        if (f2727q == null) {
            f2727q = C1509g.m1516U() + "up";
        }
        return f2727q;
    }

    /* renamed from: j */
    public static String m1740j() {
        if (f2728r == null) {
            f2728r = C1509g.m1516U() + "authu";
        }
        return f2728r;
    }

    /* renamed from: k */
    public static String m1739k() {
        if (f2729s == null) {
            f2729s = C1509g.m1516U() + "statu";
        }
        return f2729s;
    }

    /* renamed from: l */
    public static String m1738l() {
        if (f2730t == null) {
            f2730t = C1509g.m1516U() + "poli";
        }
        return f2730t;
    }

    /* renamed from: m */
    public static String m1737m() {
        if (f2731u == null) {
            f2731u = C1509g.m1516U() + "ver";
        }
        return f2731u;
    }

    /* renamed from: n */
    public static String m1736n() {
        return C1509g.m1516U() + "bvu";
    }

    /* renamed from: o */
    public static String m1735o() {
        return C1509g.m1516U() + "fds";
    }

    /* renamed from: p */
    public static String m1734p() {
        return C1497g.m1876a(new File(m1780Q()), 8, false);
    }

    /* renamed from: q */
    public static boolean m1733q() {
        return f2735y;
    }

    /* renamed from: r */
    public static boolean m1732r() {
        if (!f2683J) {
            f2684K = f2714d ? JNIBridge.cmd(15) == 1 : new File(m1778S()).exists();
            f2683J = true;
        }
        return f2684K;
    }

    /* renamed from: s */
    public static boolean m1731s() {
        m1777T();
        return f2674A;
    }

    /* renamed from: t */
    public static boolean m1730t() {
        m1777T();
        return f2675B;
    }

    /* renamed from: u */
    public static boolean m1729u() {
        return f2734x;
    }

    /* renamed from: v */
    public static void m1728v() {
        boolean z;
        m1744f(C1509g.m1516U());
        f2735y = true;
        f2674A = false;
        f2675B = false;
        f2676C = false;
        f2677D = false;
        f2678E = false;
        f2679F = false;
        String[] strArr = {".st", ".wa", ".callback", ".ctn", ".ctj", ".cta", ".signal"};
        String[] strArr2 = {"up", "authu", "statu", "poli"};
        File[] listFiles = new File(C1509g.m1516U()).listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                String name = file.getName();
                int i = 0;
                while (true) {
                    if (i >= 7) {
                        z = false;
                        break;
                    } else if (name.endsWith(strArr[i])) {
                        z = true;
                        break;
                    } else {
                        i++;
                    }
                }
                if (!z) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= 4) {
                            break;
                        } else if (name.equals(strArr2[i2])) {
                            z = true;
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
                if (z) {
                    C1491a.m1925a("crashsdk", "delete file: " + file.getPath());
                    C1497g.m1878a(file);
                }
            }
        }
        m1771Z();
    }

    /* renamed from: w */
    public static void m1727w() {
        if (f2734x) {
            return;
        }
        f2734x = true;
        if (m1785L() || C1503e.m1583u()) {
            return;
        }
        m1744f(C1509g.m1516U());
        m1772Y();
        m1771Z();
    }

    /* renamed from: x */
    public static boolean m1726x() {
        return m1744f(C1509g.m1516U());
    }

    /* renamed from: y */
    public static boolean m1725y() {
        return m1744f(C1509g.m1515V());
    }

    /* renamed from: z */
    public static boolean m1724z() {
        return f2697X || !m1759ad();
    }
}
