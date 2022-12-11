package com.p046uc.crashsdk;

import android.os.Looper;
import android.os.Process;
import com.p046uc.crashsdk.export.LogType;
import com.p046uc.crashsdk.p047a.C1491a;
import com.p046uc.crashsdk.p047a.C1496f;
import com.p046uc.crashsdk.p047a.C1497g;
import com.p046uc.crashsdk.p047a.RunnableC1495e;
import java.io.File;
import java.util.Locale;

/* renamed from: com.uc.crashsdk.JNIBridge */
/* loaded from: classes4.dex */
public class JNIBridge {
    public static int addCachedInfo(String str, String str2) {
        return C1490a.m1943b(str, str2);
    }

    public static int addDumpFile(String str, String str2, boolean z, boolean z2, int i, boolean z3) {
        return C1490a.m1951a(str, str2, z, z2, i, z3);
    }

    public static void addHeaderInfo(String str, String str2) {
        C1490a.m1952a(str, str2);
    }

    public static long cmd(int i) {
        return nativeCmd(i, 0L, null, null);
    }

    public static long cmd(int i, String str) {
        return nativeCmd(i, 0L, str, null);
    }

    public static int createCachedInfo(String str, int i, int i2) {
        return C1490a.m1954a(str, i, i2);
    }

    public static boolean generateCustomLog(String str, String str2, long j, String str3, String str4, String str5, String str6) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        return C1503e.m1663a(stringBuffer, str2, j, C1490a.m1940c(str3), C1490a.m1940c(str4), C1490a.m1940c(str5), str6);
    }

    public static String getCallbackInfo(String str, boolean z) {
        return C1490a.m1949a(str, z);
    }

    public static String getDatasForClientJavaLog(int i, String str) {
        boolean equals = "$all$".equals(str);
        if (i == 1) {
            return equals ? C1490a.m1935h() : C1490a.m1955a(str);
        } else if (i == 2) {
            return equals ? C1490a.m1933j() : C1490a.m1949a(str, true);
        } else if (i == 3) {
            return equals ? C1490a.m1931l() : C1490a.m1944b(str);
        } else if (i != 4) {
            return null;
        } else {
            return C1503e.m1627d(str) ? "1" : "0";
        }
    }

    public static String getJavaStackTrace(Thread thread, int i) {
        if (i != 0 && i == Process.myPid()) {
            thread = Looper.getMainLooper().getThread();
        }
        if (thread != null) {
            return C1503e.m1654a(thread.getStackTrace(), "getJavaStackTrace").toString();
        }
        return null;
    }

    public static native boolean nativeAddCachedInfo(String str, String str2);

    public static native int nativeAddCallbackInfo(String str, int i, long j, int i2);

    public static native int nativeAddDumpFile(String str, String str2, boolean z, boolean z2, int i, boolean z3);

    public static native void nativeAddHeaderInfo(String str, String str2);

    public static native boolean nativeChangeState(String str, String str2, boolean z);

    public static native void nativeClientCloseConnection(long j);

    public static native long nativeClientCreateConnection(String str, String str2, String str3, int i);

    public static native int nativeClientWriteData(long j, String str);

    public static native void nativeCloseFile(int i);

    public static native long nativeCmd(int i, long j, String str, Object[] objArr);

    public static native void nativeCrash(int i, int i2);

    public static native int nativeCreateCachedInfo(String str, int i, int i2);

    public static native String nativeDumpThreads(String str, long j);

    public static native int nativeGenerateUnexpLog(long j, int i);

    public static native String nativeGet(int i, long j, String str);

    public static native String nativeGetCallbackInfo(String str, long j, int i, boolean z);

    public static native boolean nativeIsCrashing();

    public static native boolean nativeLockFile(int i, boolean z);

    public static native int nativeLog(int i, String str, String str2);

    public static native int nativeOpenFile(String str);

    public static native long nativeSet(int i, long j, String str, Object[] objArr);

    public static native void nativeSetForeground(boolean z);

    public static void onCrashLogGenerated(String str, String str2, String str3, boolean z) {
        boolean equals = C1503e.m1610h().equals(str2);
        boolean equals2 = LogType.NATIVE_TYPE.equals(str3);
        if (!C1503e.m1706F()) {
            if (equals && equals2) {
                try {
                    C1508f.m1543c(true);
                } catch (Throwable th) {
                    C1497g.m1868a(th);
                }
            }
            str = C1503e.m1670a(str);
        }
        C1502d.m1717a(str, str2, str3);
        if (C1503e.m1706F()) {
            return;
        }
        if (z || (!equals && C1509g.m1480s())) {
            C1503e.m1655a(false, false);
        } else if (!equals) {
        } else {
            C1503e.m1638b(equals2);
        }
    }

    public static void onCrashRestarting() {
        C1502d.m1715a(false);
        C1500b.m1783N();
    }

    public static void onKillProcess(String str, int i, int i2) {
        String str2 = "onKillProcess. SIG: " + i2;
        if (C1503e.m1685a()) {
            C1491a.m1922b("crashsdk", str2);
        } else {
            C1491a.m1925a("crashsdk", str2);
        }
        StringBuilder m1617f = C1503e.m1617f("onKillProcess");
        m1617f.insert(0, String.format(Locale.US, "State in disk: '%s'\n", C1500b.m1734p()));
        m1617f.insert(0, String.format(Locale.US, "SIG: %d, fg: %s, exiting: %s, main process: %s, time: %s\n", Integer.valueOf(i2), Boolean.valueOf(C1500b.m1795B()), Boolean.valueOf(C1500b.m1729u()), Boolean.valueOf(C1500b.m1791F()), C1503e.m1596n()));
        m1617f.insert(0, String.format(Locale.US, "Kill PID: %d (%s) by pid: %d (%s) tid: %d (%s)\n", Integer.valueOf(i), C1503e.m1684a(i), Integer.valueOf(Process.myPid()), C1503e.m1684a(Process.myPid()), Integer.valueOf(Process.myTid()), Thread.currentThread().getName()));
        String sb = m1617f.toString();
        if (C1503e.m1685a()) {
            C1491a.m1922b("crashsdk", sb);
        } else {
            C1491a.m1925a("crashsdk", sb);
        }
        if (!C1500b.m1785L()) {
            C1497g.m1873a(new File(str), sb.getBytes());
        }
    }

    public static String onNativeEvent(int i, long j, Object[] objArr) {
        switch (i) {
            case 1:
                return String.valueOf(Runtime.getRuntime().maxMemory());
            case 2:
                return C1503e.m1631d();
            case 3:
                if (objArr != null && objArr.length == 2 && (objArr[0] instanceof String) && (objArr[1] instanceof String)) {
                    return C1503e.m1666a((String) objArr[0], (String) objArr[1]);
                }
                return null;
            case 4:
                return C1503e.m1615g();
            case 5:
                C1490a.m1947a(true);
                break;
            case 6:
                return C1497g.m1858d();
            case 7:
                C1496f.m1888a(2, new RunnableC1495e(102), 8000L);
                C1503e.m1588r();
                break;
        }
        return null;
    }

    public static int onPreClientCustomLog(String str, String str2, boolean z) {
        C1509g.m1510a();
        C1503e.m1656a(false);
        if (C1503e.m1665a(str, str2, z)) {
            return 0;
        }
        C1503e.m1640b(str, str2, z);
        return 1;
    }

    public static int registerCurrentThread(String str, int i) {
        return C1490a.m1960a(i, str);
    }

    public static int registerInfoCallback(String str, int i, long j, int i2) {
        return C1490a.m1953a(str, i, null, j, i2);
    }

    public static long set(int i, long j) {
        return nativeSet(i, j, null, null);
    }

    public static long set(int i, String str) {
        return nativeSet(i, 0L, str, null);
    }

    public static long set(int i, boolean z) {
        return nativeSet(i, z ? 1L : 0L, null, null);
    }
}
