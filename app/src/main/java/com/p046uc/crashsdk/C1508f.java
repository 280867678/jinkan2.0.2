package com.p046uc.crashsdk;

import android.util.SparseArray;
import com.p046uc.crashsdk.p047a.C1491a;
import com.p046uc.crashsdk.p047a.C1496f;
import com.p046uc.crashsdk.p047a.C1497g;
import com.p046uc.crashsdk.p047a.C1498h;
import com.p046uc.crashsdk.p047a.RunnableC1495e;
import com.tencent.smtt.sdk.TbsMediaPlayer;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import me.tvspark.outline;

/* renamed from: com.uc.crashsdk.f */
/* loaded from: classes4.dex */
public class C1508f {

    /* renamed from: a */
    public static final /* synthetic */ boolean f2821a = !C1508f.class.desiredAssertionStatus();

    /* renamed from: b */
    public static final Object f2822b = new Object();

    /* renamed from: c */
    public static final SparseArray<String> f2823c = new SparseArray<>();

    /* renamed from: d */
    public static final Object f2824d = new Object();

    /* renamed from: e */
    public static boolean f2825e = false;

    /* renamed from: a */
    public static int m1565a() {
        File[] m1749d = C1500b.m1749d();
        if (m1749d != null) {
            int i = 0;
            for (File file : m1749d) {
                if (m1556a(file.getAbsolutePath(), false)) {
                    i++;
                }
            }
            return i;
        }
        return 0;
    }

    /* renamed from: a */
    public static int m1554a(StringBuffer stringBuffer, String str) {
        int indexOf = stringBuffer.indexOf(str);
        if (indexOf < 0) {
            return 0;
        }
        int indexOf2 = stringBuffer.indexOf("=", str.length() + indexOf);
        if (indexOf2 < 0) {
            C1491a.m1923b(str + " line not contain '='!");
            return 0;
        }
        int i = indexOf2 + 1;
        int indexOf3 = stringBuffer.indexOf("\n", i);
        if (indexOf3 < 0) {
            indexOf3 = stringBuffer.length();
        }
        try {
            int parseInt = Integer.parseInt(stringBuffer.substring(i, indexOf3));
            if (parseInt >= 0) {
                return parseInt;
            }
            return 0;
        } catch (NumberFormatException e) {
            C1497g.m1868a(e);
            return 0;
        }
    }

    /* renamed from: a */
    public static int m1552a(boolean z) {
        if (z) {
            return m1544c(C1500b.m1747e()) ? 1 : 0;
        }
        File[] m1745f = C1500b.m1745f();
        if (m1745f == null) {
            return 0;
        }
        int i = 0;
        for (File file : m1745f) {
            if (m1544c(file.getAbsolutePath())) {
                i++;
            }
        }
        return i;
    }

    /* renamed from: a */
    public static String m1555a(StringBuffer stringBuffer) {
        String str;
        if (stringBuffer == null) {
            return null;
        }
        int indexOf = stringBuffer.indexOf("[");
        if (indexOf < 0) {
            str = "getProcessName: Can not found process name start!";
        } else {
            int i = indexOf + 1;
            int indexOf2 = stringBuffer.indexOf("]", i);
            if (indexOf2 < 0) {
                str = "getProcessName: Can not found process name end!";
            } else {
                String substring = stringBuffer.substring(i, indexOf2);
                if (substring.length() > 0) {
                    return substring;
                }
                str = "getProcessName: process name is empty";
            }
        }
        C1491a.m1924a("crashsdk", str, null);
        return null;
    }

    /* renamed from: a */
    public static StringBuffer m1561a(File file) {
        FileReader fileReader;
        FileReader fileReader2 = null;
        if (!file.exists()) {
            return null;
        }
        char[] m1542d = m1542d();
        if (m1542d == null) {
            C1491a.m1924a("crashsdk", "readCrashStatData alloc buffer failed!", null);
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                fileReader = new FileReader(file);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            int read = fileReader.read(m1542d);
            if (read > 0) {
                fileReader2 = null;
                stringBuffer.append(m1542d, 0, read);
            }
            C1497g.m1879a(fileReader);
        } catch (Exception e2) {
            e = e2;
            fileReader2 = fileReader;
            C1497g.m1868a(e);
            C1497g.m1879a(fileReader2);
            return stringBuffer;
        } catch (Throwable th2) {
            th = th2;
            fileReader2 = fileReader;
            C1497g.m1879a(fileReader2);
            throw th;
        }
        return stringBuffer;
    }

    /* renamed from: a */
    public static void m1564a(int i) {
        m1563a(i, 1);
    }

    /* renamed from: a */
    public static void m1563a(int i, int i2) {
        if (i2 != 0) {
            m1558a(C1500b.m1752c(), new RunnableC1495e(TbsMediaPlayer.TbsMediaPlayerListener.MEDIA_INFO_NO_VIDEO_DATA, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
            return;
        }
        C1491a.m1923b("Add stat for type " + i + " with count 0!");
    }

    /* renamed from: a */
    public static void m1557a(String str, HashMap<String, Integer> hashMap, String str2) {
        try {
            C1500b.m1726x();
        } catch (Throwable th) {
            C1497g.m1868a(th);
        }
        try {
            File file = new File(str2);
            if (!file.exists()) {
                file.createNewFile();
            }
            StringBuffer m1561a = m1561a(file);
            if (C1497g.m1869a(m1561a)) {
                if (m1561a == null) {
                    m1561a = new StringBuffer();
                }
                m1561a.append("[");
                m1561a.append(str);
                m1561a.append("]\n");
            }
            boolean z = false;
            for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                int intValue = entry.getValue().intValue();
                if (intValue > 0) {
                    String key = entry.getKey();
                    m1553a(m1561a, key, intValue + m1554a(m1561a, key));
                    z = true;
                }
            }
            if (!z) {
                return;
            }
            m1560a(file, m1561a);
        } catch (Throwable th2) {
            C1497g.m1868a(th2);
        }
    }

    /* renamed from: a */
    public static void m1553a(StringBuffer stringBuffer, String str, int i) {
        int indexOf = stringBuffer.indexOf(str);
        if (indexOf < 0) {
            if (i <= 0) {
                return;
            }
            stringBuffer.append(str);
            stringBuffer.append("=");
            stringBuffer.append(i);
            stringBuffer.append("\n");
            return;
        }
        int indexOf2 = stringBuffer.indexOf("\n", indexOf);
        if (indexOf2 < 0) {
            indexOf2 = stringBuffer.length();
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(String.valueOf(i));
        stringBuffer.replace(indexOf, indexOf2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
    }

    /* renamed from: a */
    public static boolean m1562a(int i, Object[] objArr) {
        switch (i) {
            case TbsMediaPlayer.TbsMediaPlayerListener.MEDIA_INFO_NO_VIDEO_DATA /* 751 */:
                if (!f2821a && objArr == null) {
                    throw new AssertionError();
                }
                return m1549b(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue());
            case TbsMediaPlayer.TbsMediaPlayerListener.MEDIA_INFO_HAVE_VIDEO_DATA /* 752 */:
                if (!f2821a && objArr == null) {
                    throw new AssertionError();
                }
                return m1548b((String) objArr[0]);
            case 753:
                if (!f2821a && objArr == null) {
                    throw new AssertionError();
                }
                File file = new File((String) objArr[0]);
                if (!file.exists()) {
                    return false;
                }
                file.delete();
                return true;
            case 754:
                if (!f2821a && objArr == null) {
                    throw new AssertionError();
                }
                m1557a((String) objArr[0], (HashMap) objArr[1], (String) objArr[2]);
                return true;
            case 755:
                if (!f2821a && objArr == null) {
                    throw new AssertionError();
                }
                return m1541d((String) objArr[0]);
            case 756:
                if (!f2821a && objArr == null) {
                    throw new AssertionError();
                }
                File file2 = new File((String) objArr[0]);
                if (!file2.exists()) {
                    return false;
                }
                file2.delete();
                return true;
            default:
                return false;
        }
    }

    /* renamed from: a */
    public static boolean m1560a(File file, StringBuffer stringBuffer) {
        FileWriter fileWriter;
        FileWriter fileWriter2 = null;
        try {
            try {
                fileWriter = new FileWriter(file);
            } catch (Exception e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            String stringBuffer2 = stringBuffer.toString();
            fileWriter.write(stringBuffer2, 0, stringBuffer2.length());
            C1497g.m1879a(fileWriter);
            return true;
        } catch (Exception e2) {
            e = e2;
            fileWriter2 = fileWriter;
            C1497g.m1868a(e);
            C1497g.m1879a(fileWriter2);
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileWriter2 = fileWriter;
            C1497g.m1879a(fileWriter2);
            throw th;
        }
    }

    /* renamed from: a */
    public static boolean m1559a(String str) {
        return m1558a(str, new RunnableC1495e(753, new Object[]{str}));
    }

    /* renamed from: a */
    public static boolean m1558a(String str, RunnableC1495e runnableC1495e) {
        return C1500b.m1766a(f2822b, str, runnableC1495e);
    }

    /* renamed from: a */
    public static boolean m1556a(String str, boolean z) {
        if (C1498h.m1830a(z, "crash detail report")) {
            return false;
        }
        return m1558a(str, new RunnableC1495e(TbsMediaPlayer.TbsMediaPlayerListener.MEDIA_INFO_HAVE_VIDEO_DATA, new Object[]{str}));
    }

    /* renamed from: b */
    public static int m1551b() {
        File[] m1749d = C1500b.m1749d();
        if (m1749d != null) {
            int i = 0;
            for (File file : m1749d) {
                if (m1559a(file.getAbsolutePath())) {
                    i++;
                }
            }
            return i;
        }
        return 0;
    }

    /* renamed from: b */
    public static int m1547b(boolean z) {
        if (z) {
            return m1538e(C1500b.m1747e()) ? 1 : 0;
        }
        File[] m1745f = C1500b.m1745f();
        if (m1745f == null) {
            return 0;
        }
        int i = 0;
        for (File file : m1745f) {
            if (m1538e(file.getAbsolutePath())) {
                i++;
            }
        }
        return i;
    }

    /* renamed from: b */
    public static void m1550b(int i) {
        if (i != 700) {
            return;
        }
        m1540d(false);
    }

    /* renamed from: b */
    public static boolean m1549b(int i, int i2) {
        try {
            C1500b.m1726x();
        } catch (Throwable th) {
            C1497g.m1868a(th);
        }
        try {
            String m1545c = m1545c(i);
            if (m1545c == null) {
                C1491a.m1924a("crashsdk", "Stat type not exists: " + i, null);
                return false;
            }
            File file = new File(C1500b.m1752c());
            if (!file.exists()) {
                file.createNewFile();
            }
            StringBuffer m1561a = m1561a(file);
            if (C1497g.m1869a(m1561a)) {
                if (m1561a == null) {
                    m1561a = new StringBuffer();
                }
                m1561a.append("[");
                m1561a.append(C1503e.m1610h());
                m1561a.append("]\n");
            }
            m1553a(m1561a, m1545c, m1554a(m1561a, m1545c) + i2);
            return m1560a(file, m1561a);
        } catch (Throwable th2) {
            C1497g.m1868a(th2);
            return false;
        }
    }

    /* renamed from: b */
    public static boolean m1548b(String str) {
        StringBuffer stringBuffer;
        File file = new File(str);
        StringBuffer m1561a = m1561a(file);
        if (C1497g.m1869a(m1561a)) {
            return false;
        }
        String m1555a = m1555a(m1561a);
        if (m1555a == null || m1555a.length() <= 0) {
            C1491a.m1924a("crashsdk", "reportCrashStatImpl: process name is invalid", null);
            return false;
        }
        SparseArray<String> m1539e = m1539e();
        HashMap hashMap = new HashMap();
        boolean m1524M = C1509g.m1524M();
        if (m1524M) {
            stringBuffer = new StringBuffer();
            stringBuffer.append("reportCrashStatImpl: processName: ");
            stringBuffer.append(m1555a + "\n");
        } else {
            stringBuffer = null;
        }
        int i = 0;
        boolean z = false;
        while (i < m1539e.size()) {
            try {
                int keyAt = m1539e.keyAt(i);
                String str2 = m1539e.get(keyAt);
                SparseArray<String> sparseArray = m1539e;
                int m1554a = m1554a(m1561a, str2);
                if (m1554a > 0) {
                    if (m1524M) {
                        stringBuffer.append("name: ");
                        stringBuffer.append(str2);
                        stringBuffer.append(", key: ");
                        stringBuffer.append(keyAt);
                        stringBuffer.append(", count: ");
                        stringBuffer.append(m1554a);
                        stringBuffer.append("\n");
                    }
                    C1498h.m1837a(m1555a, keyAt, m1554a);
                    hashMap.put(str2, Integer.valueOf(m1554a));
                    m1553a(m1561a, str2, 0);
                    z = true;
                }
                i++;
                m1539e = sparseArray;
            } catch (Throwable th) {
                if (z) {
                    m1560a(file, m1561a);
                    if (hashMap.size() > 0) {
                        String m1765a = C1500b.m1765a(str);
                        if (hashMap.size() > 0) {
                            if (C1497g.m1872a(m1555a)) {
                                C1491a.m1924a("crashsdk", "cacheReportedStatsForCallback: processName is null", null);
                            } else if (C1497g.m1872a(m1765a)) {
                                C1491a.m1924a("crashsdk", "cacheReportedStatsForCallback: callbackCacheFilePathName is null", null);
                            } else {
                                m1558a(m1765a, new RunnableC1495e(754, new Object[]{m1555a, hashMap, m1765a}));
                            }
                        }
                    }
                }
                throw th;
            }
        }
        if (m1524M) {
            C1491a.m1926a(stringBuffer.toString());
        }
        if (z) {
            m1560a(file, m1561a);
            if (hashMap.size() > 0) {
                String m1765a2 = C1500b.m1765a(str);
                if (hashMap.size() > 0) {
                    if (C1497g.m1872a(m1555a)) {
                        C1491a.m1924a("crashsdk", "cacheReportedStatsForCallback: processName is null", null);
                    } else if (C1497g.m1872a(m1765a2)) {
                        C1491a.m1924a("crashsdk", "cacheReportedStatsForCallback: callbackCacheFilePathName is null", null);
                    } else {
                        m1558a(m1765a2, new RunnableC1495e(754, new Object[]{m1555a, hashMap, m1765a2}));
                    }
                }
            }
        }
        return true;
    }

    /* renamed from: c */
    public static String m1545c(int i) {
        String str;
        m1537f();
        synchronized (f2823c) {
            str = f2823c.get(i);
        }
        return str;
    }

    /* renamed from: c */
    public static void m1546c() {
        C1496f.m1888a(1, new RunnableC1495e(700), 3000L);
    }

    /* renamed from: c */
    public static void m1543c(boolean z) {
        if (C1509g.m1522O() && !C1500b.m1785L()) {
            C1503e.m1604j();
            if (!C1498h.m1816e()) {
                C1498h.m1831a(z);
            }
            if (!C1500b.m1791F()) {
                return;
            }
            m1540d(z);
            m1556a(C1500b.m1752c(), z);
            C1498h.m1822b(z);
        }
    }

    /* renamed from: c */
    public static boolean m1544c(String str) {
        if (!C1497g.m1872a(str) && new File(str).exists()) {
            return m1558a(str, new RunnableC1495e(755, new Object[]{str}));
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004a A[Catch: all -> 0x0056, TryCatch #0 {, blocks: (B:8:0x0008, B:10:0x000c, B:12:0x000e, B:14:0x0016, B:16:0x0018, B:18:0x0020, B:20:0x002a, B:23:0x004a, B:24:0x004d, B:25:0x0054, B:27:0x0031, B:29:0x0037, B:31:0x0042), top: B:7:0x0008 }] */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void m1540d(boolean z) {
        if (f2825e) {
            return;
        }
        synchronized (f2824d) {
            if (f2825e) {
                return;
            }
            if (C1498h.m1830a(z, "crash detail")) {
                return;
            }
            boolean z2 = false;
            if (!C1500b.m1731s()) {
                if (C1500b.m1730t()) {
                    m1563a(101, 1);
                    if (C1500b.m1732r()) {
                        m1563a(43, 1);
                    }
                }
                if (z2) {
                    m1563a(1, 1);
                }
                m1563a(100, 1);
                f2825e = true;
            }
            m1563a(2, 1);
            if (C1500b.m1732r()) {
                m1563a(42, 1);
            }
            z2 = true;
            if (z2) {
            }
            m1563a(100, 1);
            f2825e = true;
        }
    }

    /* renamed from: d */
    public static boolean m1541d(String str) {
        if (f2821a || str != null) {
            File file = new File(str);
            StringBuffer m1561a = m1561a(file);
            if (C1497g.m1869a(m1561a)) {
                return false;
            }
            String m1555a = m1555a(m1561a);
            StringBuffer stringBuffer = null;
            if (m1555a == null || m1555a.length() <= 0) {
                C1491a.m1924a("crashsdk", "notifyStatsDetailImpl: process name is invalid", null);
                return false;
            }
            SparseArray<String> m1539e = m1539e();
            boolean m1524M = C1509g.m1524M();
            if (m1524M) {
                stringBuffer = new StringBuffer();
                stringBuffer.append("notifyStatsDetailImpl: processName: ");
                stringBuffer.append(m1555a + "\n");
            }
            boolean z = false;
            for (int i = 0; i < m1539e.size(); i++) {
                try {
                    int keyAt = m1539e.keyAt(i);
                    String str2 = m1539e.get(keyAt);
                    int m1554a = m1554a(m1561a, str2);
                    if (m1554a > 0) {
                        if (m1524M) {
                            stringBuffer.append("name: ");
                            stringBuffer.append(str2);
                            stringBuffer.append(", key: ");
                            stringBuffer.append(keyAt);
                            stringBuffer.append(", count: ");
                            stringBuffer.append(m1554a);
                            stringBuffer.append("\n");
                        }
                        C1502d.m1718a(m1555a, keyAt, m1554a);
                        m1553a(m1561a, str2, 0);
                        z = true;
                    }
                } finally {
                    if (z) {
                        m1560a(file, m1561a);
                    }
                }
            }
            if (m1524M) {
                C1491a.m1926a(stringBuffer.toString());
            }
            if (z) {
                C1502d.m1718a(m1555a, 1000000, 0);
            }
            return z;
        }
        throw new AssertionError();
    }

    /* renamed from: d */
    public static char[] m1542d() {
        char[] cArr = null;
        int i = 1024;
        while (cArr == null && i > 0) {
            try {
                cArr = new char[i];
            } catch (Throwable unused) {
                i /= 2;
                if (i < 512) {
                    break;
                }
            }
        }
        return cArr;
    }

    /* renamed from: e */
    public static SparseArray<String> m1539e() {
        SparseArray<String> clone;
        m1537f();
        synchronized (f2823c) {
            clone = f2823c.clone();
        }
        return clone;
    }

    /* renamed from: e */
    public static boolean m1538e(String str) {
        if (!C1497g.m1872a(str) && new File(str).exists()) {
            return m1558a(str, new RunnableC1495e(756, new Object[]{str}));
        }
        return false;
    }

    /* renamed from: f */
    public static void m1537f() {
        synchronized (f2823c) {
            if (f2823c.size() != 0) {
                return;
            }
            f2823c.put(100, "start_pv");
            f2823c.put(102, "start_hpv");
            f2823c.put(1, "all_all");
            f2823c.put(2, "all_fg");
            f2823c.put(101, "all_bg");
            f2823c.put(3, "java_fg");
            f2823c.put(4, "java_bg");
            f2823c.put(7, "native_fg");
            f2823c.put(8, "native_bg");
            f2823c.put(27, "native_anr_fg");
            f2823c.put(28, "native_anr_bg");
            f2823c.put(9, "native_ok");
            f2823c.put(10, "unexp_anr");
            f2823c.put(29, "unexp_lowmem");
            f2823c.put(30, "unexp_killed");
            f2823c.put(31, "unexp_exit");
            f2823c.put(32, "unexp_restart");
            f2823c.put(11, "unexp_fg");
            f2823c.put(12, "unexp_bg");
            f2823c.put(40, "anr_fg");
            f2823c.put(41, "anr_bg");
            f2823c.put(42, "anr_cr_fg");
            f2823c.put(43, "anr_cr_bg");
            f2823c.put(13, "log_up_succ");
            f2823c.put(14, "log_up_fail");
            f2823c.put(15, "log_empty");
            f2823c.put(200, "log_tmp");
            f2823c.put(16, "log_abd_all");
            f2823c.put(22, "log_abd_builtin");
            f2823c.put(23, "log_abd_custom");
            f2823c.put(17, "log_large");
            f2823c.put(18, "log_up_all");
            f2823c.put(19, "log_up_bytes");
            f2823c.put(20, "log_up_crash");
            f2823c.put(21, "log_up_custom");
            f2823c.put(24, "log_zipped");
            f2823c.put(201, "log_enced");
            f2823c.put(25, "log_renamed");
            f2823c.put(26, "log_safe_skip");
        }
    }
}
