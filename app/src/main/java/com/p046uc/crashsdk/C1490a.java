package com.p046uc.crashsdk;

import android.content.pm.PackageInfo;
import android.util.SparseArray;
import com.p046uc.crashsdk.export.LogType;
import com.p046uc.crashsdk.p047a.C1491a;
import com.p046uc.crashsdk.p047a.C1492b;
import com.p046uc.crashsdk.p047a.C1496f;
import com.p046uc.crashsdk.p047a.C1497g;
import com.p046uc.crashsdk.p047a.RunnableC1495e;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.io.File;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import org.mozilla.javascript.NativeJavaObject;

/* renamed from: com.uc.crashsdk.a */
/* loaded from: classes4.dex */
public class C1490a {

    /* renamed from: d */
    public static final /* synthetic */ boolean f2597d = !C1490a.class.desiredAssertionStatus();

    /* renamed from: a */
    public static String f2594a = "";

    /* renamed from: b */
    public static String f2595b = "";

    /* renamed from: e */
    public static final Map<String, String> f2598e = new HashMap();

    /* renamed from: f */
    public static final List<String> f2599f = new ArrayList();

    /* renamed from: g */
    public static String f2600g = "";

    /* renamed from: h */
    public static String f2601h = null;

    /* renamed from: i */
    public static int f2602i = -1;

    /* renamed from: j */
    public static long f2603j = 0;

    /* renamed from: k */
    public static final HashMap<String, Object[]> f2604k = new HashMap<>();

    /* renamed from: l */
    public static final List<String> f2605l = new ArrayList();

    /* renamed from: m */
    public static int f2606m = 0;

    /* renamed from: n */
    public static int f2607n = 0;

    /* renamed from: o */
    public static int f2608o = 0;

    /* renamed from: p */
    public static int f2609p = 0;

    /* renamed from: q */
    public static final HashMap<String, Object[]> f2610q = new HashMap<>();

    /* renamed from: r */
    public static final List<String> f2611r = new ArrayList();

    /* renamed from: s */
    public static int f2612s = 0;

    /* renamed from: t */
    public static int f2613t = 0;

    /* renamed from: u */
    public static int f2614u = 0;

    /* renamed from: v */
    public static int f2615v = 0;

    /* renamed from: w */
    public static int f2616w = 0;

    /* renamed from: x */
    public static int f2617x = 0;

    /* renamed from: y */
    public static final SparseArray<Object[]> f2618y = new SparseArray<>();

    /* renamed from: z */
    public static final List<Integer> f2619z = new ArrayList();

    /* renamed from: A */
    public static final HashMap<String, Object[]> f2585A = new HashMap<>();

    /* renamed from: B */
    public static final List<String> f2586B = new ArrayList();

    /* renamed from: C */
    public static int f2587C = 0;

    /* renamed from: D */
    public static int f2588D = 0;

    /* renamed from: E */
    public static int f2589E = 0;

    /* renamed from: c */
    public static boolean f2596c = false;

    /* renamed from: F */
    public static Runnable f2590F = new RunnableC1495e(201);

    /* renamed from: G */
    public static boolean f2591G = false;

    /* renamed from: H */
    public static boolean f2592H = false;

    /* renamed from: I */
    public static boolean f2593I = false;

    /* renamed from: a */
    public static int m1960a(int i, String str) {
        if (C1497g.m1872a(str)) {
            str = Thread.currentThread().getName();
        }
        boolean z = false;
        z = false;
        if (LogType.isForNative(i) || LogType.isForANR(i)) {
            if (C1500b.f2714d) {
                synchronized (f2618y) {
                    JNIBridge.nativeCmd(4, i, str, null);
                }
                z = LogType.isForNative(i);
                if (LogType.isForANR(i)) {
                    z = (z ? 1 : 0) | true;
                }
            } else {
                C1491a.m1924a("crashsdk", "crashsdk so has not loaded!", null);
            }
        }
        if (LogType.isForJava(i)) {
            m1950a(str, Thread.currentThread());
            int i2 = z ? 1 : 0;
            char c = z ? 1 : 0;
            char c2 = z ? 1 : 0;
            return i2 | 16;
        }
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = z ? 1 : 0;
        return i3;
    }

    /* renamed from: a */
    public static int m1954a(String str, int i, int i2) {
        int i3;
        int i4;
        boolean z;
        if (str == null || i <= 0) {
            return 0;
        }
        if (i > 1500) {
            C1491a.m1924a("crashsdk", "createCachedInfo: capacity is too large!", null);
            return 0;
        }
        synchronized (f2585A) {
            if (f2585A.containsKey(str)) {
                i4 = ((Integer) f2585A.get(str)[1]).intValue();
                i3 = LogType.addType(i4, i2);
            } else {
                i3 = i2;
                i4 = 0;
            }
            if (LogType.isForJava(i3) && !LogType.isForJava(i4)) {
                if (f2587C >= 8) {
                    i3 = LogType.removeType(i3, 16);
                } else {
                    f2587C++;
                }
            }
            if (LogType.isForNative(i3) && !LogType.isForNative(i4)) {
                if (f2588D >= 8) {
                    i3 = LogType.removeType(i3, 1);
                } else {
                    f2588D++;
                }
            }
            if (LogType.isForANR(i3) && !LogType.isForANR(i4)) {
                if (f2589E >= 8) {
                    i3 = LogType.removeType(i3, 1048576);
                } else {
                    f2589E++;
                }
            }
            if ((1048849 & i3) == 0) {
                z = false;
            } else {
                if (i4 == 0) {
                    f2586B.add(str);
                }
                z = true;
            }
            if (!z) {
                return i3;
            }
            if (C1500b.f2714d && (i2 & 1048577) != 0) {
                int nativeCreateCachedInfo = JNIBridge.nativeCreateCachedInfo(str, i, i3);
                if (!LogType.isForNative(nativeCreateCachedInfo)) {
                    i3 = LogType.removeType(i3, 1);
                }
                if (!LogType.isForANR(nativeCreateCachedInfo)) {
                    i3 = LogType.removeType(i3, 1048576);
                }
            }
            f2585A.put(str, new Object[]{Integer.valueOf(i), Integer.valueOf(i3), new ArrayList()});
            return i3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0066 A[Catch: all -> 0x0170, TryCatch #0 {, blocks: (B:8:0x000d, B:10:0x0015, B:12:0x002b, B:14:0x002f, B:16:0x0039, B:18:0x003f, B:22:0x0066, B:25:0x004b, B:28:0x0050, B:29:0x005e, B:30:0x0056, B:33:0x006c, B:35:0x0073, B:37:0x0079, B:42:0x00aa, B:43:0x00b1, B:45:0x00b9, B:47:0x00bf, B:49:0x00c3, B:50:0x00c8, B:51:0x00d0, B:53:0x00d8, B:55:0x00de, B:57:0x00e2, B:58:0x00e7, B:59:0x00ef, B:63:0x0101, B:65:0x0103, B:67:0x0107, B:69:0x010d, B:71:0x0119, B:73:0x011f, B:75:0x0126, B:76:0x012b, B:78:0x0131, B:80:0x0137, B:81:0x013c, B:83:0x0142, B:85:0x0148, B:86:0x0150, B:87:0x016e, B:91:0x00f9, B:97:0x0085, B:100:0x008a, B:101:0x0098, B:104:0x00a0), top: B:7:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00aa A[Catch: all -> 0x0170, TryCatch #0 {, blocks: (B:8:0x000d, B:10:0x0015, B:12:0x002b, B:14:0x002f, B:16:0x0039, B:18:0x003f, B:22:0x0066, B:25:0x004b, B:28:0x0050, B:29:0x005e, B:30:0x0056, B:33:0x006c, B:35:0x0073, B:37:0x0079, B:42:0x00aa, B:43:0x00b1, B:45:0x00b9, B:47:0x00bf, B:49:0x00c3, B:50:0x00c8, B:51:0x00d0, B:53:0x00d8, B:55:0x00de, B:57:0x00e2, B:58:0x00e7, B:59:0x00ef, B:63:0x0101, B:65:0x0103, B:67:0x0107, B:69:0x010d, B:71:0x0119, B:73:0x011f, B:75:0x0126, B:76:0x012b, B:78:0x0131, B:80:0x0137, B:81:0x013c, B:83:0x0142, B:85:0x0148, B:86:0x0150, B:87:0x016e, B:91:0x00f9, B:97:0x0085, B:100:0x008a, B:101:0x0098, B:104:0x00a0), top: B:7:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00e2 A[Catch: all -> 0x0170, TryCatch #0 {, blocks: (B:8:0x000d, B:10:0x0015, B:12:0x002b, B:14:0x002f, B:16:0x0039, B:18:0x003f, B:22:0x0066, B:25:0x004b, B:28:0x0050, B:29:0x005e, B:30:0x0056, B:33:0x006c, B:35:0x0073, B:37:0x0079, B:42:0x00aa, B:43:0x00b1, B:45:0x00b9, B:47:0x00bf, B:49:0x00c3, B:50:0x00c8, B:51:0x00d0, B:53:0x00d8, B:55:0x00de, B:57:0x00e2, B:58:0x00e7, B:59:0x00ef, B:63:0x0101, B:65:0x0103, B:67:0x0107, B:69:0x010d, B:71:0x0119, B:73:0x011f, B:75:0x0126, B:76:0x012b, B:78:0x0131, B:80:0x0137, B:81:0x013c, B:83:0x0142, B:85:0x0148, B:86:0x0150, B:87:0x016e, B:91:0x00f9, B:97:0x0085, B:100:0x008a, B:101:0x0098, B:104:0x00a0), top: B:7:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00e7 A[Catch: all -> 0x0170, TryCatch #0 {, blocks: (B:8:0x000d, B:10:0x0015, B:12:0x002b, B:14:0x002f, B:16:0x0039, B:18:0x003f, B:22:0x0066, B:25:0x004b, B:28:0x0050, B:29:0x005e, B:30:0x0056, B:33:0x006c, B:35:0x0073, B:37:0x0079, B:42:0x00aa, B:43:0x00b1, B:45:0x00b9, B:47:0x00bf, B:49:0x00c3, B:50:0x00c8, B:51:0x00d0, B:53:0x00d8, B:55:0x00de, B:57:0x00e2, B:58:0x00e7, B:59:0x00ef, B:63:0x0101, B:65:0x0103, B:67:0x0107, B:69:0x010d, B:71:0x0119, B:73:0x011f, B:75:0x0126, B:76:0x012b, B:78:0x0131, B:80:0x0137, B:81:0x013c, B:83:0x0142, B:85:0x0148, B:86:0x0150, B:87:0x016e, B:91:0x00f9, B:97:0x0085, B:100:0x008a, B:101:0x0098, B:104:0x00a0), top: B:7:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0101 A[Catch: all -> 0x0170, DONT_GENERATE, TryCatch #0 {, blocks: (B:8:0x000d, B:10:0x0015, B:12:0x002b, B:14:0x002f, B:16:0x0039, B:18:0x003f, B:22:0x0066, B:25:0x004b, B:28:0x0050, B:29:0x005e, B:30:0x0056, B:33:0x006c, B:35:0x0073, B:37:0x0079, B:42:0x00aa, B:43:0x00b1, B:45:0x00b9, B:47:0x00bf, B:49:0x00c3, B:50:0x00c8, B:51:0x00d0, B:53:0x00d8, B:55:0x00de, B:57:0x00e2, B:58:0x00e7, B:59:0x00ef, B:63:0x0101, B:65:0x0103, B:67:0x0107, B:69:0x010d, B:71:0x0119, B:73:0x011f, B:75:0x0126, B:76:0x012b, B:78:0x0131, B:80:0x0137, B:81:0x013c, B:83:0x0142, B:85:0x0148, B:86:0x0150, B:87:0x016e, B:91:0x00f9, B:97:0x0085, B:100:0x008a, B:101:0x0098, B:104:0x00a0), top: B:7:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0103 A[Catch: all -> 0x0170, TryCatch #0 {, blocks: (B:8:0x000d, B:10:0x0015, B:12:0x002b, B:14:0x002f, B:16:0x0039, B:18:0x003f, B:22:0x0066, B:25:0x004b, B:28:0x0050, B:29:0x005e, B:30:0x0056, B:33:0x006c, B:35:0x0073, B:37:0x0079, B:42:0x00aa, B:43:0x00b1, B:45:0x00b9, B:47:0x00bf, B:49:0x00c3, B:50:0x00c8, B:51:0x00d0, B:53:0x00d8, B:55:0x00de, B:57:0x00e2, B:58:0x00e7, B:59:0x00ef, B:63:0x0101, B:65:0x0103, B:67:0x0107, B:69:0x010d, B:71:0x0119, B:73:0x011f, B:75:0x0126, B:76:0x012b, B:78:0x0131, B:80:0x0137, B:81:0x013c, B:83:0x0142, B:85:0x0148, B:86:0x0150, B:87:0x016e, B:91:0x00f9, B:97:0x0085, B:100:0x008a, B:101:0x0098, B:104:0x00a0), top: B:7:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00f7  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int m1953a(String str, int i, Callable<String> callable, long j, int i2) {
        int i3;
        int i4;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        if (str == null) {
            return 0;
        }
        synchronized (f2610q) {
            if (f2610q.containsKey(str)) {
                i4 = ((Integer) f2610q.get(str)[0]).intValue();
                i3 = LogType.addType(i4, i);
                if (i4 == i3) {
                    return i4;
                }
            } else {
                i3 = i;
                i4 = 0;
            }
            if (LogType.isForJava(i3) && !LogType.isForJava(i4)) {
                if (f2612s < 8) {
                    if (j == 0) {
                        if (f2612s - f2616w >= 6) {
                        }
                        f2612s++;
                        z7 = false;
                    } else if (f2616w < 6) {
                        f2616w++;
                        f2612s++;
                        z7 = false;
                    }
                    if (z7) {
                        i3 = LogType.removeType(i3, 16);
                    }
                }
                z7 = true;
                if (z7) {
                }
            }
            if (!LogType.isForNative(i3) || LogType.isForNative(i4)) {
                z = false;
                z2 = false;
            } else {
                if (f2613t < 6) {
                    if (j != 0) {
                        if (f2617x < 4) {
                            f2617x++;
                            f2613t++;
                            z6 = false;
                            z = true;
                            z2 = true;
                            if (z6) {
                                i3 = LogType.removeType(i3, 1);
                            }
                        }
                    } else if (f2613t - f2617x < 4) {
                        f2613t++;
                        z6 = false;
                        z = true;
                        z2 = false;
                        if (z6) {
                        }
                    }
                }
                z6 = true;
                z = false;
                z2 = false;
                if (z6) {
                }
            }
            if (LogType.isForANR(i3) && !LogType.isForANR(i4)) {
                if (f2615v >= 6) {
                    i3 = LogType.removeType(i3, 1048576);
                } else {
                    f2615v++;
                    z3 = true;
                    if (LogType.isForUnexp(i3) && !LogType.isForUnexp(i4)) {
                        if (f2614u >= 6) {
                            f2614u++;
                            z4 = true;
                            if ((1048849 & i3) == 0) {
                                z5 = false;
                            } else {
                                if (i4 == 0) {
                                    f2611r.add(str);
                                }
                                z5 = true;
                            }
                            if (!z5) {
                                return i3;
                            }
                            if (C1500b.f2714d && (1048833 & i) != 0) {
                                int nativeAddCallbackInfo = JNIBridge.nativeAddCallbackInfo(str, i, j, i2);
                                if (!LogType.isForNative(nativeAddCallbackInfo)) {
                                    i3 = LogType.removeType(i3, 1);
                                    if (z) {
                                        f2613t--;
                                    }
                                    if (z2) {
                                        f2617x--;
                                    }
                                }
                                if (!LogType.isForANR(nativeAddCallbackInfo)) {
                                    i3 = LogType.removeType(i3, 1048576);
                                    if (z3) {
                                        f2615v--;
                                    }
                                }
                                if (!LogType.isForUnexp(nativeAddCallbackInfo)) {
                                    i3 = LogType.removeType(i3, 256);
                                    if (z4) {
                                        f2614u--;
                                    }
                                }
                            }
                            f2610q.put(str, new Object[]{Integer.valueOf(i3), callable, Long.valueOf(j), Integer.valueOf(i2)});
                            return i3;
                        }
                        i3 = LogType.removeType(i3, 256);
                    }
                    z4 = false;
                    if ((1048849 & i3) == 0) {
                    }
                    if (!z5) {
                    }
                }
            }
            z3 = false;
            if (LogType.isForUnexp(i3)) {
                if (f2614u >= 6) {
                }
            }
            z4 = false;
            if ((1048849 & i3) == 0) {
            }
            if (!z5) {
            }
        }
    }

    /* renamed from: a */
    public static int m1951a(String str, String str2, boolean z, boolean z2, int i, boolean z3) {
        int i2;
        int i3;
        boolean z4;
        if (str == null || str2 == null) {
            return 0;
        }
        if (str.length() > 256) {
            C1491a.m1924a("crashsdk", "addDumpFile: description is too long!", null);
            return 0;
        }
        synchronized (f2604k) {
            if (f2604k.containsKey(str)) {
                i3 = ((Integer) f2604k.get(str)[0]).intValue();
                i2 = LogType.addType(i3, i);
            } else {
                i2 = i;
                i3 = 0;
            }
            if (LogType.isForJava(i2) && !LogType.isForJava(i3)) {
                if (f2606m >= 10) {
                    i2 = LogType.removeType(i2, 16);
                } else {
                    f2606m++;
                }
            }
            if (LogType.isForNative(i2) && !LogType.isForNative(i3)) {
                if (f2607n >= 10) {
                    i2 = LogType.removeType(i2, 1);
                } else {
                    f2607n++;
                }
            }
            if (LogType.isForUnexp(i2) && !LogType.isForUnexp(i3)) {
                if (f2608o >= 10) {
                    i2 = LogType.removeType(i2, 256);
                } else {
                    f2608o++;
                }
            }
            if (LogType.isForANR(i2) && !LogType.isForANR(i3)) {
                if (f2609p >= 10) {
                    i2 = LogType.removeType(i2, 1048576);
                } else {
                    f2609p++;
                }
            }
            if ((1048849 & i2) == 0) {
                z4 = false;
            } else {
                if (i3 == 0) {
                    f2605l.add(str);
                }
                z4 = true;
            }
            if (!z4) {
                return i2;
            }
            if (C1500b.f2714d && (1048833 & i) != 0) {
                int nativeAddDumpFile = JNIBridge.nativeAddDumpFile(str, str2, z, z2, i, z3);
                if (!LogType.isForNative(nativeAddDumpFile)) {
                    i2 = LogType.removeType(i2, 1);
                }
                if (!LogType.isForUnexp(nativeAddDumpFile)) {
                    i2 = LogType.removeType(i2, 256);
                }
                if (!LogType.isForANR(nativeAddDumpFile)) {
                    i2 = LogType.removeType(i2, 1048576);
                }
            }
            f2604k.put(str, new Object[]{Integer.valueOf(i2), str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)});
            return i2;
        }
    }

    /* renamed from: a */
    public static String m1962a() {
        String str = f2601h;
        return str != null ? str : m1928o() ? f2601h : "";
    }

    /* renamed from: a */
    public static String m1955a(String str) {
        synchronized (f2604k) {
            Object[] objArr = f2604k.get(str);
            if (objArr == null) {
                return null;
            }
            int i = 1;
            boolean booleanValue = ((Boolean) objArr[2]).booleanValue();
            boolean booleanValue2 = ((Boolean) objArr[3]).booleanValue();
            Locale locale = Locale.US;
            Object[] objArr2 = new Object[4];
            objArr2[0] = (String) objArr[1];
            objArr2[1] = "`";
            objArr2[2] = Integer.valueOf(booleanValue ? 1 : 0);
            if (!booleanValue2) {
                i = 0;
            }
            objArr2[3] = Integer.valueOf(i);
            return String.format(locale, "%s%s%d%d", objArr2);
        }
    }

    /* renamed from: a */
    public static String m1949a(String str, boolean z) {
        String nativeGetCallbackInfo;
        synchronized (f2610q) {
            Object[] objArr = f2610q.get(str);
            long longValue = ((Long) objArr[2]).longValue();
            nativeGetCallbackInfo = longValue != 0 ? JNIBridge.nativeGetCallbackInfo(str, longValue, ((Integer) objArr[3]).intValue(), z) : m1942b(str, z).toString();
        }
        return nativeGetCallbackInfo;
    }

    /* renamed from: a */
    public static void m1961a(int i) {
        if (i == 201) {
            C1491a.m1925a("crashsdk", "Begin update info ...");
            long currentTimeMillis = System.currentTimeMillis();
            if (C1500b.f2714d && f2596c) {
                JNIBridge.nativeCmd(11, C1509g.m1532E(), String.valueOf(C1509g.m1531F()), null);
            }
            C1491a.m1925a("crashsdk", "Update info took " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
            m1947a(false);
        } else if (i != 202) {
            if (!f2597d) {
                throw new AssertionError();
            }
        } else {
            m1927p();
            String format = String.format(Locale.US, "%s/%s/%s", C1509g.m1519R(), C1509g.m1518S(), C1509g.m1517T());
            f2600g = m1930m();
            if (C1500b.f2714d) {
                JNIBridge.set(128, f2600g);
            }
            boolean z = !format.equals(f2600g);
            if (z) {
                C1492b.m1918a(C1500b.m1737m(), format);
            }
            if (!z || !C1509g.m1478u()) {
                return;
            }
            C1491a.m1925a("crashsdk", String.format(Locale.US, "Is new version ('%s' -> '%s'), deleting old stats data!", f2600g, format));
            C1500b.m1728v();
        }
    }

    /* renamed from: a */
    public static void m1959a(OutputStream outputStream, String str) {
        synchronized (f2598e) {
            for (String str2 : f2599f) {
                StringBuilder sb = new StringBuilder(11);
                sb.append(str2);
                sb.append(": ");
                String str3 = f2598e.get(str2);
                if (str3 != null) {
                    sb.append(str3);
                }
                sb.append("\n");
                outputStream.write(sb.toString().getBytes(str));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00cc A[Catch: all -> 0x0102, TryCatch #7 {, blocks: (B:4:0x0003, B:5:0x000d, B:7:0x0013, B:23:0x0068, B:56:0x011e, B:24:0x006b, B:27:0x0089, B:28:0x00c5, B:30:0x00cc, B:31:0x00d5, B:33:0x00da, B:35:0x00de, B:36:0x00e7, B:39:0x0106), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00da A[Catch: all -> 0x0102, TryCatch #7 {, blocks: (B:4:0x0003, B:5:0x000d, B:7:0x0013, B:23:0x0068, B:56:0x011e, B:24:0x006b, B:27:0x0089, B:28:0x00c5, B:30:0x00cc, B:31:0x00d5, B:33:0x00da, B:35:0x00de, B:36:0x00e7, B:39:0x0106), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0087  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void m1958a(OutputStream outputStream, String str, String str2) {
        Thread thread;
        Throwable th;
        String str3;
        StackTraceElement[] stackTrace;
        int length;
        int i;
        Object[] objArr;
        synchronized (f2618y) {
            Thread currentThread = Thread.currentThread();
            for (Integer num : f2619z) {
                int intValue = num.intValue();
                try {
                    objArr = f2618y.get(intValue);
                } catch (Throwable th2) {
                    thread = null;
                    th = th2;
                    str3 = null;
                }
                if (objArr != null) {
                    thread = (Thread) ((WeakReference) objArr[0]).get();
                    try {
                        str3 = (String) objArr[1];
                    } catch (Throwable th3) {
                        str3 = null;
                        th = th3;
                    }
                    if (thread == null) {
                        try {
                            C1491a.m1923b("Thread (" + str3 + ", " + intValue + ") has exited!");
                        } catch (Throwable th4) {
                            th = th4;
                            C1503e.m1660a(th, outputStream);
                            outputStream.write(String.format(Locale.US, "Thread Name: '%s'\n", str3).getBytes(str));
                            outputStream.write(String.format(Locale.US, "\"%s\"%s prio=%d tid=%d %s\n", thread.getName(), !thread.isDaemon() ? " daemon" : "", Integer.valueOf(thread.getPriority()), Integer.valueOf(intValue), thread.getState().toString()).getBytes(str));
                            stackTrace = thread.getStackTrace();
                            if (stackTrace.length == 0) {
                            }
                            length = stackTrace.length;
                            i = 0;
                            boolean z = true;
                            while (i < length) {
                            }
                            outputStream.write("\n".getBytes(str));
                            outputStream.write(str2.getBytes(str));
                        }
                    } else if (currentThread != thread) {
                        outputStream.write(String.format(Locale.US, "Thread Name: '%s'\n", str3).getBytes(str));
                        outputStream.write(String.format(Locale.US, "\"%s\"%s prio=%d tid=%d %s\n", thread.getName(), !thread.isDaemon() ? " daemon" : "", Integer.valueOf(thread.getPriority()), Integer.valueOf(intValue), thread.getState().toString()).getBytes(str));
                        stackTrace = thread.getStackTrace();
                        if (stackTrace.length == 0) {
                            outputStream.write("  (no stack frames)".getBytes(str));
                        }
                        length = stackTrace.length;
                        i = 0;
                        boolean z2 = true;
                        while (i < length) {
                            StackTraceElement stackTraceElement = stackTrace[i];
                            if (!z2) {
                                outputStream.write("\n".getBytes(str));
                            }
                            outputStream.write(String.format(Locale.US, "  at %s", stackTraceElement.toString()).getBytes(str));
                            i++;
                            z2 = false;
                        }
                        outputStream.write("\n".getBytes(str));
                        outputStream.write(str2.getBytes(str));
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x005d A[Catch: all -> 0x008d, TryCatch #2 {, blocks: (B:4:0x0003, B:5:0x0009, B:7:0x000f, B:38:0x00ab, B:40:0x00b1, B:41:0x00b5, B:43:0x00bb, B:46:0x00c9, B:51:0x00cf, B:25:0x0091, B:8:0x0015, B:30:0x0028, B:18:0x0036, B:20:0x005d, B:22:0x0075, B:24:0x007b, B:27:0x0083, B:28:0x006b, B:11:0x002f), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006b A[Catch: all -> 0x008d, TryCatch #2 {, blocks: (B:4:0x0003, B:5:0x0009, B:7:0x000f, B:38:0x00ab, B:40:0x00b1, B:41:0x00b5, B:43:0x00bb, B:46:0x00c9, B:51:0x00cf, B:25:0x0091, B:8:0x0015, B:30:0x0028, B:18:0x0036, B:20:0x005d, B:22:0x0075, B:24:0x007b, B:27:0x0083, B:28:0x006b, B:11:0x002f), top: B:3:0x0003 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void m1957a(OutputStream outputStream, String str, String str2, ArrayList<String> arrayList) {
        String nativeGetCallbackInfo;
        synchronized (f2610q) {
            for (String str3 : f2611r) {
                Object[] objArr = f2610q.get(str3);
                int intValue = ((Integer) objArr[0]).intValue();
                if (arrayList == null) {
                    if (LogType.isForJava(intValue)) {
                        outputStream.write((str3 + "\n").getBytes(str));
                        long longValue = ((Long) objArr[2]).longValue();
                        nativeGetCallbackInfo = longValue == 0 ? JNIBridge.nativeGetCallbackInfo(str3, longValue, ((Integer) objArr[3]).intValue(), false) : m1942b(str3, false).toString();
                        if (nativeGetCallbackInfo != null || nativeGetCallbackInfo.length() <= 0) {
                            outputStream.write("(data is null)\n".getBytes(str));
                        } else {
                            outputStream.write(nativeGetCallbackInfo.getBytes(str));
                        }
                        outputStream.write("\n".getBytes(str));
                        outputStream.write(str2.getBytes(str));
                    }
                } else if (m1948a(arrayList, str3)) {
                    outputStream.write((str3 + "\n").getBytes(str));
                    long longValue2 = ((Long) objArr[2]).longValue();
                    if (longValue2 == 0) {
                    }
                    if (nativeGetCallbackInfo != null) {
                    }
                    outputStream.write("(data is null)\n".getBytes(str));
                    outputStream.write("\n".getBytes(str));
                    outputStream.write(str2.getBytes(str));
                }
            }
            if (arrayList != null && C1503e.m1706F()) {
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (!m1948a(f2611r, next)) {
                        C1503e.m1673a(outputStream, "CUSTOMCALLBACKINFO", next);
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0050 A[Catch: all -> 0x00d7, TRY_LEAVE, TryCatch #2 {all -> 0x00d7, blocks: (B:12:0x0025, B:69:0x002f, B:22:0x0045, B:24:0x0050, B:15:0x003e), top: B:11:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ce A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0019 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b0 A[Catch: all -> 0x00d3, TryCatch #0 {all -> 0x00d3, blocks: (B:33:0x007f, B:37:0x009b, B:39:0x00a3, B:57:0x00b0, B:59:0x00b5), top: B:32:0x007f }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b5 A[Catch: all -> 0x00d3, TRY_LEAVE, TryCatch #0 {all -> 0x00d3, blocks: (B:33:0x007f, B:37:0x009b, B:39:0x00a3, B:57:0x00b0, B:59:0x00b5), top: B:32:0x007f }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x006e  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void m1956a(OutputStream outputStream, String str, ArrayList<String> arrayList) {
        int i;
        int min;
        boolean booleanValue;
        String str2;
        boolean booleanValue2;
        File file;
        boolean z = arrayList == null;
        boolean m1706F = C1503e.m1706F();
        synchronized (f2604k) {
            int i2 = 0;
            for (String str3 : f2605l) {
                try {
                    Object[] objArr = f2604k.get(str3);
                    if (arrayList == null) {
                        if (LogType.isForJava(((Integer) objArr[0]).intValue())) {
                            if (!((Boolean) objArr[3]).booleanValue()) {
                                try {
                                    outputStream.write((str3 + "\n").getBytes(str));
                                } catch (Throwable th) {
                                    th = th;
                                    C1503e.m1660a(th, outputStream);
                                }
                            }
                            i = i2 <= 153600 ? 153600 : i2;
                            try {
                                min = Math.min((int) UMModuleRegister.PUSH_EVENT_VALUE_HIGH, 153600 - i);
                                booleanValue = ((Boolean) objArr[2]).booleanValue();
                                str2 = (String) objArr[1];
                                booleanValue2 = ((Boolean) objArr[4]).booleanValue();
                                if (m1706F || str2.startsWith("/proc/")) {
                                    i += !booleanValue ? C1503e.m1674a(outputStream, str2, min) : C1503e.m1644b(outputStream, str2, min);
                                } else {
                                    C1503e.m1672a(outputStream, "FILE", str2, min, booleanValue, booleanValue2);
                                }
                                i2 = i;
                                if (booleanValue2 && z && !m1706F) {
                                    file = new File(str2);
                                    if (!file.exists()) {
                                        file.delete();
                                    }
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                i2 = i;
                                C1503e.m1660a(th, outputStream);
                            }
                        }
                    } else if (m1948a(arrayList, str3)) {
                        if (!((Boolean) objArr[3]).booleanValue()) {
                        }
                        if (i2 <= 153600) {
                        }
                        min = Math.min((int) UMModuleRegister.PUSH_EVENT_VALUE_HIGH, 153600 - i);
                        booleanValue = ((Boolean) objArr[2]).booleanValue();
                        str2 = (String) objArr[1];
                        booleanValue2 = ((Boolean) objArr[4]).booleanValue();
                        if (m1706F) {
                        }
                        i += !booleanValue ? C1503e.m1674a(outputStream, str2, min) : C1503e.m1644b(outputStream, str2, min);
                        i2 = i;
                        if (booleanValue2) {
                            file = new File(str2);
                            if (!file.exists()) {
                            }
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }
            if (arrayList != null && m1706F) {
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (!m1948a(f2605l, next)) {
                        C1503e.m1673a(outputStream, "CUSTOMDUMPFILE", next);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public static void m1952a(String str, String str2) {
        synchronized (f2598e) {
            if (!f2598e.containsKey(str)) {
                f2599f.add(str);
            }
            f2598e.put(str, str2);
            if (C1500b.f2714d) {
                JNIBridge.nativeAddHeaderInfo(str, str2);
            }
            C1503e.m1579y();
        }
    }

    /* renamed from: a */
    public static boolean m1950a(String str, Thread thread) {
        if (thread == null) {
            return false;
        }
        synchronized (f2618y) {
            int id = (int) thread.getId();
            if (f2618y.get(id) == null) {
                f2619z.add(Integer.valueOf(id));
            }
            f2618y.put(id, new Object[]{new WeakReference(thread), str});
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m1948a(List<String> list, String str) {
        if (C1497g.m1872a(str)) {
            return false;
        }
        for (String str2 : list) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m1947a(boolean z) {
        int m1532E;
        String str;
        if (C1500b.f2713c) {
            if (C1503e.m1706F() || C1500b.m1785L()) {
                return false;
            }
            if (z) {
                C1496f.m1886a(f2590F);
                m1532E = 0;
            } else if (!C1500b.m1795B()) {
                str = "Stop update unexp info in background!";
            } else if (C1509g.m1532E() <= 0) {
                return false;
            } else {
                if (C1496f.m1884b(f2590F)) {
                    return true;
                }
                m1532E = C1509g.m1532E() * 1000;
            }
            C1496f.m1888a(0, f2590F, m1532E);
            return true;
        }
        str = "Unexp log not enabled, skip update unexp info!";
        C1491a.m1925a("crashsdk", str);
        return false;
    }

    /* renamed from: b */
    public static int m1943b(String str, String str2) {
        int i;
        int i2 = 0;
        if (str == null || str2 == null) {
            return 0;
        }
        if (str2.length() > 2048) {
            str2 = str2.substring(0, 2048);
        }
        synchronized (f2585A) {
            Object[] objArr = f2585A.get(str);
            if (objArr != null) {
                int intValue = ((Integer) objArr[0]).intValue();
                int intValue2 = ((Integer) objArr[1]).intValue();
                List list = (List) objArr[2];
                if (list.size() >= intValue) {
                    list.remove(0);
                }
                list.add(str2);
                if (LogType.isForJava(intValue2)) {
                    i2 = LogType.addType(0, 16);
                }
                if (!C1500b.f2714d) {
                    if (LogType.isForNative(intValue2)) {
                        i2 = LogType.addType(i2, 1);
                    }
                    if (LogType.isForANR(intValue2)) {
                        i2 = LogType.addType(i2, 1048576);
                    }
                }
                i = i2;
                i2 = intValue2;
            } else {
                i = 0;
            }
            if (C1500b.f2714d && JNIBridge.nativeAddCachedInfo(str, str2)) {
                if (LogType.isForNative(i2)) {
                    i = LogType.addType(i, 1);
                }
                if (LogType.isForANR(i2)) {
                    i = LogType.addType(i, 1048576);
                }
            }
        }
        return i;
    }

    /* renamed from: b */
    public static long m1946b() {
        return f2603j;
    }

    /* renamed from: b */
    public static String m1944b(String str) {
        StringBuilder sb = new StringBuilder();
        synchronized (f2585A) {
            Object[] objArr = f2585A.get(str);
            int intValue = ((Integer) objArr[0]).intValue();
            List<String> list = (List) objArr[2];
            sb.append(String.format(Locale.US, "%s (%d/%d)\n", str, Integer.valueOf(list.size()), Integer.valueOf(intValue)));
            for (String str2 : list) {
                sb.append(str2);
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    /* renamed from: b */
    public static StringBuilder m1942b(String str, boolean z) {
        String m1716a;
        StringBuilder sb = new StringBuilder();
        try {
            Object[] objArr = f2610q.get(str);
            if (objArr == null) {
                m1716a = "Unknown callback: " + str;
            } else {
                Callable callable = (Callable) objArr[1];
                m1716a = callable != null ? (String) callable.call() : C1502d.m1716a(str, z);
            }
            if (m1716a != null) {
                sb.append(m1716a);
            }
        } catch (Throwable th) {
            C1497g.m1868a(th);
        }
        try {
            if (sb.length() == 0) {
                sb.append("(data is null)\n");
            }
        } catch (Throwable th2) {
            C1497g.m1868a(th2);
        }
        return sb;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0076 A[Catch: all -> 0x008d, LOOP:1: B:15:0x0070->B:17:0x0076, LOOP_END, TRY_LEAVE, TryCatch #2 {, blocks: (B:4:0x0003, B:5:0x0009, B:7:0x000f, B:24:0x0036, B:10:0x003d, B:32:0x00ab, B:34:0x00b1, B:35:0x00b5, B:37:0x00bb, B:40:0x00c9, B:45:0x00cf, B:19:0x0091, B:13:0x0043, B:14:0x006c, B:15:0x0070, B:17:0x0076), top: B:3:0x0003 }] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void m1945b(OutputStream outputStream, String str, String str2, ArrayList<String> arrayList) {
        synchronized (f2585A) {
            for (String str3 : f2586B) {
                Object[] objArr = f2585A.get(str3);
                int intValue = ((Integer) objArr[0]).intValue();
                int intValue2 = ((Integer) objArr[1]).intValue();
                List<String> list = (List) objArr[2];
                if (arrayList == null) {
                    if (LogType.isForJava(intValue2)) {
                        outputStream.write(String.format(Locale.US, "%s (%d/%d)\n", str3, Integer.valueOf(list.size()), Integer.valueOf(intValue)).getBytes(str));
                        for (String str4 : list) {
                            outputStream.write(str4.getBytes(str));
                            outputStream.write("\n".getBytes(str));
                        }
                        outputStream.write("\n".getBytes(str));
                        outputStream.write(str2.getBytes(str));
                    }
                } else if (m1948a(arrayList, str3)) {
                    outputStream.write(String.format(Locale.US, "%s (%d/%d)\n", str3, Integer.valueOf(list.size()), Integer.valueOf(intValue)).getBytes(str));
                    while (r2.hasNext()) {
                    }
                    outputStream.write("\n".getBytes(str));
                    outputStream.write(str2.getBytes(str));
                }
            }
            if (arrayList != null && C1503e.m1706F()) {
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (!m1948a(f2586B, next)) {
                        C1503e.m1673a(outputStream, "CUSTOMCACHEDINFO", next);
                    }
                }
            }
        }
    }

    /* renamed from: c */
    public static int m1941c() {
        if (f2602i == -1) {
            m1928o();
        }
        return f2602i;
    }

    /* renamed from: c */
    public static ArrayList<String> m1940c(String str) {
        if (C1497g.m1872a(str)) {
            return null;
        }
        String[] split = str.split(";", 20);
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str2 : split) {
            if (!C1497g.m1872a(str2)) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }

    /* renamed from: d */
    public static void m1939d() {
        StringBuilder sb = new StringBuilder();
        synchronized (f2598e) {
            for (String str : f2599f) {
                String str2 = f2598e.get(str);
                sb.append(str);
                sb.append(": ");
                if (str2 != null) {
                    sb.append(str2);
                }
                sb.append("\n");
            }
        }
        sb.append(String.format(Locale.US, "(saved at %s)\n", C1503e.m1596n()));
        C1492b.m1918a(C1500b.m1742h(), sb.toString());
    }

    /* renamed from: e */
    public static void m1938e() {
        if (f2597d || C1500b.f2714d) {
            synchronized (f2598e) {
                for (String str : f2599f) {
                    JNIBridge.nativeAddHeaderInfo(str, f2598e.get(str));
                }
            }
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: f */
    public static byte[] m1937f() {
        return new byte[]{24, NativeJavaObject.CONVERSION_NONE, 121, 60};
    }

    /* renamed from: g */
    public static void m1936g() {
        if (f2597d || C1500b.f2714d) {
            synchronized (f2604k) {
                for (String str : f2605l) {
                    Object[] objArr = f2604k.get(str);
                    int intValue = ((Integer) objArr[0]).intValue();
                    if ((1048833 & intValue) != 0) {
                        JNIBridge.nativeAddDumpFile(str, (String) objArr[1], ((Boolean) objArr[2]).booleanValue(), ((Boolean) objArr[3]).booleanValue(), intValue, ((Boolean) objArr[4]).booleanValue());
                    }
                }
            }
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: h */
    public static String m1935h() {
        StringBuilder sb = new StringBuilder();
        synchronized (f2604k) {
            boolean z = true;
            for (String str : f2605l) {
                if (LogType.isForJava(((Integer) f2604k.get(str)[0]).intValue())) {
                    if (!z) {
                        sb.append("`");
                    }
                    sb.append(str);
                    z = false;
                }
            }
        }
        return sb.toString();
    }

    /* renamed from: i */
    public static void m1934i() {
        if (f2597d || C1500b.f2714d) {
            synchronized (f2610q) {
                for (String str : f2611r) {
                    Object[] objArr = f2610q.get(str);
                    int intValue = ((Integer) objArr[0]).intValue();
                    if ((1048833 & intValue) != 0) {
                        JNIBridge.nativeAddCallbackInfo(str, intValue, ((Long) objArr[2]).longValue(), ((Integer) objArr[3]).intValue());
                    }
                }
            }
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: j */
    public static String m1933j() {
        String sb;
        synchronized (f2610q) {
            StringBuilder sb2 = new StringBuilder();
            synchronized (f2611r) {
                boolean z = true;
                for (String str : f2611r) {
                    if (LogType.isForJava(((Integer) f2610q.get(str)[0]).intValue())) {
                        if (!z) {
                            sb2.append("`");
                        }
                        sb2.append(str);
                        z = false;
                    }
                }
            }
            sb = sb2.toString();
        }
        return sb;
    }

    /* renamed from: k */
    public static void m1932k() {
        if (f2597d || C1500b.f2714d) {
            synchronized (f2585A) {
                for (String str : f2586B) {
                    Object[] objArr = f2585A.get(str);
                    int intValue = ((Integer) objArr[0]).intValue();
                    int intValue2 = ((Integer) objArr[1]).intValue();
                    List list = (List) objArr[2];
                    if ((1048577 & intValue2) != 0 && JNIBridge.nativeCreateCachedInfo(str, intValue, intValue2) != 0) {
                        Iterator it = list.iterator();
                        while (it.hasNext() && JNIBridge.nativeAddCachedInfo(str, (String) it.next())) {
                        }
                    }
                }
            }
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: l */
    public static String m1931l() {
        StringBuilder sb = new StringBuilder();
        synchronized (f2585A) {
            boolean z = true;
            for (String str : f2586B) {
                if (LogType.isForJava(((Integer) f2585A.get(str)[1]).intValue())) {
                    if (!z) {
                        sb.append("`");
                    }
                    sb.append(str);
                    z = false;
                }
            }
        }
        return sb.toString();
    }

    /* renamed from: m */
    public static String m1930m() {
        if (!f2591G) {
            String m1919a = C1492b.m1919a(C1500b.m1737m());
            f2600g = m1919a;
            f2591G = true;
            if (m1919a == null) {
                f2600g = "";
            }
        }
        return f2600g;
    }

    /* renamed from: n */
    public static void m1929n() {
        m1927p();
        if (!f2592H) {
            f2592H = true;
            C1496f.m1889a(0, new RunnableC1495e(202));
        } else if (!C1500b.f2714d) {
        } else {
            JNIBridge.set(128, f2600g);
        }
    }

    /* renamed from: o */
    public static boolean m1928o() {
        try {
            PackageInfo packageInfo = C1497g.m1882a().getPackageManager().getPackageInfo(f2594a, 0);
            f2601h = packageInfo.versionName;
            f2603j = packageInfo.lastUpdateTime;
            f2602i = packageInfo.versionCode;
            return true;
        } catch (Throwable th) {
            C1497g.m1862b(th);
            return false;
        }
    }

    /* renamed from: p */
    public static void m1927p() {
        if (!f2593I && C1503e.m1685a()) {
            if (!C1500b.f2714d && C1500b.f2717g) {
                return;
            }
            String format = String.format(Locale.US, "%s/%s/%s", C1509g.m1519R(), C1509g.m1518S(), C1509g.m1517T());
            C1491a.m1922b("crashsdk", "UUID: " + C1503e.m1590q());
            C1491a.m1922b("crashsdk", "Version: " + format);
            C1491a.m1922b("crashsdk", "Process Name: " + C1503e.m1610h());
            f2593I = true;
        }
    }
}
