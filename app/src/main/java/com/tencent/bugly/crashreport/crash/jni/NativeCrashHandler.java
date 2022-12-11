package com.tencent.bugly.crashreport.crash.jni;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import com.tencent.bugly.crashreport.AbstractC1129b;
import com.tencent.bugly.crashreport.common.info.C1140a;
import com.tencent.bugly.crashreport.common.info.C1141b;
import com.tencent.bugly.crashreport.common.strategy.C1145c;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.C1161e;
import com.tencent.bugly.crashreport.crash.C1164h;
import com.tencent.bugly.proguard.C1198W;
import com.tencent.bugly.proguard.C1199X;
import com.tencent.bugly.proguard.C1208ca;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public class NativeCrashHandler implements AbstractC1129b {
    public static int JNI_CALL_TYPE = 1;

    /* renamed from: a */
    public static NativeCrashHandler f1284a = null;

    /* renamed from: b */
    public static boolean f1285b = false;

    /* renamed from: c */
    public static boolean f1286c = false;

    /* renamed from: d */
    public static boolean f1287d = true;

    /* renamed from: e */
    public final Context f1288e;

    /* renamed from: f */
    public final C1140a f1289f;

    /* renamed from: g */
    public final C1198W f1290g;

    /* renamed from: h */
    public NativeExceptionHandler f1291h;

    /* renamed from: i */
    public String f1292i;

    /* renamed from: j */
    public final boolean f1293j;

    /* renamed from: k */
    public boolean f1294k = false;

    /* renamed from: l */
    public boolean f1295l = false;

    /* renamed from: m */
    public boolean f1296m = false;

    /* renamed from: n */
    public boolean f1297n = false;

    /* renamed from: o */
    public C1161e f1298o;

    @SuppressLint({"SdCardPath"})
    public NativeCrashHandler(Context context, C1140a c1140a, C1161e c1161e, C1145c c1145c, C1198W c1198w, boolean z, String str) {
        this.f1288e = C1208ca.m3044a(context);
        try {
            if (C1208ca.m3012b(str)) {
                str = context.getDir("bugly", 0).getAbsolutePath();
            }
        } catch (Throwable unused) {
            str = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("/data/data/", C1140a.m3421a(context).f1041g, "/app_bugly");
        }
        this.f1298o = c1161e;
        this.f1292i = str;
        this.f1289f = c1140a;
        this.f1290g = c1198w;
        this.f1293j = z;
        this.f1291h = new C1170b(context, c1140a, c1161e, C1145c.m3344b());
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:1|(1:3)(11:25|(1:27)|5|6|(1:8)|9|(1:11)|13|(1:15)(1:23)|16|(2:18|19)(2:21|22))|4|5|6|(0)|9|(0)|13|(0)(0)|16|(0)(0)) */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0056 A[Catch: all -> 0x0059, TRY_LEAVE, TryCatch #0 {all -> 0x0059, blocks: (B:6:0x0040, B:8:0x004a, B:9:0x004c, B:11:0x0056), top: B:5:0x0040 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x004a A[Catch: all -> 0x0059, TryCatch #0 {all -> 0x0059, blocks: (B:6:0x0040, B:8:0x004a, B:9:0x004c, B:11:0x0056), top: B:5:0x0040 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void m3236a(String str) {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        String str2;
        C1199X.m3084a("[Native] Check extra jni for Bugly NDK v%s", str);
        String replace = "2.1.1".replace(".", "");
        String replace2 = "2.3.0".replace(".", "");
        String replace3 = str.replace(".", "");
        if (replace3.length() != 2) {
            if (replace3.length() == 1) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(replace3);
                str2 = "00";
            }
            if (Integer.parseInt(replace3) >= Integer.parseInt(replace)) {
                f1285b = true;
            }
            if (Integer.parseInt(replace3) >= Integer.parseInt(replace2)) {
                f1286c = true;
            }
            if (!f1286c) {
                C1199X.m3078c("[Native] Info setting jni can be accessed.", new Object[0]);
            } else {
                C1199X.m3076e("[Native] Info setting jni can not be accessed.", new Object[0]);
            }
            if (!f1285b) {
                C1199X.m3078c("[Native] Extra jni can be accessed.", new Object[0]);
                return;
            } else {
                C1199X.m3076e("[Native] Extra jni can not be accessed.", new Object[0]);
                return;
            }
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(replace3);
        str2 = "0";
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(str2);
        replace3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        if (Integer.parseInt(replace3) >= Integer.parseInt(replace)) {
        }
        if (Integer.parseInt(replace3) >= Integer.parseInt(replace2)) {
        }
        if (!f1286c) {
        }
        if (!f1285b) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m3239a(int i, String str) {
        if (this.f1295l && f1286c) {
            try {
                setNativeInfo(i, str);
                return true;
            } catch (UnsatisfiedLinkError unused) {
                f1286c = false;
            } catch (Throwable th) {
                if (!C1199X.m3080b(th)) {
                    th.printStackTrace();
                }
                return false;
            }
        }
        return false;
    }

    /* renamed from: a */
    private boolean m3235a(String str, boolean z) {
        boolean z2;
        try {
            C1199X.m3078c("[Native] Trying to load so: %s", str);
            if (z) {
                System.load(str);
            } else {
                System.loadLibrary(str);
            }
        } catch (Throwable th) {
            th = th;
            z2 = false;
        }
        try {
            C1199X.m3078c("[Native] Successfully loaded SO: %s", str);
            return true;
        } catch (Throwable th2) {
            th = th2;
            z2 = true;
            C1199X.m3076e(th.getMessage(), new Object[0]);
            C1199X.m3076e("[Native] Failed to load so: %s", str);
            return z2;
        }
    }

    /* renamed from: c */
    private synchronized void m3228c(boolean z) {
        if (this.f1297n != z) {
            C1199X.m3078c("user change native %b", Boolean.valueOf(z));
            this.f1297n = z;
        }
    }

    public static synchronized NativeCrashHandler getInstance() {
        NativeCrashHandler nativeCrashHandler;
        synchronized (NativeCrashHandler.class) {
            nativeCrashHandler = f1284a;
        }
        return nativeCrashHandler;
    }

    public static synchronized NativeCrashHandler getInstance(Context context, C1140a c1140a, C1161e c1161e, C1145c c1145c, C1198W c1198w, boolean z, String str) {
        NativeCrashHandler nativeCrashHandler;
        synchronized (NativeCrashHandler.class) {
            if (f1284a == null) {
                f1284a = new NativeCrashHandler(context, c1140a, c1161e, c1145c, c1198w, z, str);
            }
            nativeCrashHandler = f1284a;
        }
        return nativeCrashHandler;
    }

    public static boolean isShouldHandleInJava() {
        return f1287d;
    }

    public static void setShouldHandleInJava(boolean z) {
        f1287d = z;
        NativeCrashHandler nativeCrashHandler = f1284a;
        if (nativeCrashHandler != null) {
            nativeCrashHandler.m3239a(TbsLog.TBSLOG_CODE_SDK_INIT, "" + z);
        }
    }

    /* renamed from: a */
    public synchronized void m3234a(boolean z) {
        if (this.f1296m) {
            C1199X.m3076e("[Native] Native crash report has already registered.", new Object[0]);
            return;
        }
        if (this.f1295l) {
            String regist = regist(this.f1292i, z, JNI_CALL_TYPE);
            if (regist != null) {
                C1199X.m3078c("[Native] Native Crash Report enable.", new Object[0]);
                m3236a(regist);
                this.f1289f.f1016M = regist;
                String concat = "-".concat(this.f1289f.f1016M);
                if (!C1164h.f1232b && !this.f1289f.f1051l.contains(concat)) {
                    this.f1289f.f1051l = this.f1289f.f1051l.concat("-").concat(this.f1289f.f1016M);
                }
                C1199X.m3078c("comInfo.sdkVersion %s", this.f1289f.f1051l);
                this.f1296m = true;
                return;
            }
        } else if (this.f1294k) {
            try {
                Class[] clsArr = {String.class, String.class, Integer.TYPE, Integer.TYPE};
                Object[] objArr = new Object[4];
                objArr[0] = this.f1292i;
                objArr[1] = C1141b.m3378a(this.f1288e, false);
                int i = 5;
                objArr[2] = Integer.valueOf(z ? 1 : 5);
                objArr[3] = 1;
                String str = (String) C1208ca.m3024a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "registNativeExceptionHandler2", null, clsArr, objArr);
                if (str == null) {
                    str = (String) C1208ca.m3024a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "registNativeExceptionHandler", null, new Class[]{String.class, String.class, Integer.TYPE}, new Object[]{this.f1292i, C1141b.m3378a(this.f1288e, false), Integer.valueOf(C1140a.m3394m().m3407d())});
                }
                if (str != null) {
                    this.f1296m = true;
                    this.f1289f.f1016M = str;
                    Boolean bool = (Boolean) C1208ca.m3024a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "checkExtraJni", null, new Class[]{String.class}, new Object[]{str});
                    if (bool != null) {
                        f1285b = bool.booleanValue();
                    }
                    C1208ca.m3024a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "enableHandler", null, new Class[]{Boolean.TYPE}, new Object[]{true});
                    if (z) {
                        i = 1;
                    }
                    C1208ca.m3024a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "setLogMode", null, new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(i)});
                    return;
                }
            } catch (Throwable unused) {
            }
        }
        this.f1295l = false;
        this.f1294k = false;
    }

    @Override // com.tencent.bugly.crashreport.AbstractC1129b
    public boolean appendLogToNative(String str, String str2, String str3) {
        if ((this.f1294k || this.f1295l) && f1285b && str != null && str2 != null && str3 != null) {
            try {
                if (this.f1295l) {
                    return appendNativeLog(str, str2, str3);
                }
                Boolean bool = (Boolean) C1208ca.m3024a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "appendNativeLog", null, new Class[]{String.class, String.class, String.class}, new Object[]{str, str2, str3});
                if (bool == null) {
                    return false;
                }
                return bool.booleanValue();
            } catch (UnsatisfiedLinkError unused) {
                f1285b = false;
            } catch (Throwable th) {
                if (!C1199X.m3080b(th)) {
                    th.printStackTrace();
                }
                return false;
            }
        }
        return false;
    }

    public native boolean appendNativeLog(String str, String str2, String str3);

    public native boolean appendWholeNativeLog(String str);

    /* renamed from: b */
    public void m3233b() {
        long m3018b = C1208ca.m3018b() - C1164h.f1237g;
        long m3018b2 = C1208ca.m3018b() + 86400000;
        File file = new File(this.f1292i);
        if (!file.exists() || !file.isDirectory()) {
            return;
        }
        try {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length != 0) {
                int i = 0;
                int i2 = 0;
                for (File file2 : listFiles) {
                    long lastModified = file2.lastModified();
                    if (lastModified < m3018b || lastModified >= m3018b2) {
                        C1199X.m3078c("[Native] Delete record file: %s", file2.getAbsolutePath());
                        i++;
                        if (file2.delete()) {
                            i2++;
                        }
                    }
                }
                C1199X.m3084a("[Native] Number of record files overdue: %d, has deleted: %d", Integer.valueOf(i), Integer.valueOf(i2));
            }
        } catch (Throwable th) {
            C1199X.m3080b(th);
        }
    }

    /* renamed from: b */
    public synchronized void m3231b(boolean z) {
        if (z) {
            startNativeMonitor();
        } else {
            m3230c();
        }
    }

    /* renamed from: c */
    public synchronized void m3230c() {
        if (!this.f1296m) {
            C1199X.m3076e("[Native] Native crash report has already unregistered.", new Object[0]);
        } else if (unregist() != null) {
            C1199X.m3078c("[Native] Successfully closed native crash report.", new Object[0]);
            this.f1296m = false;
        } else {
            C1208ca.m3024a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "enableHandler", null, new Class[]{Boolean.TYPE}, new Object[]{false});
            this.f1296m = false;
            C1199X.m3078c("[Native] Successfully closed native crash report.", new Object[0]);
        }
    }

    public void checkUploadRecordCrash() {
        this.f1290g.m3092a(new RunnableC1169a(this));
    }

    public void enableCatchAnrTrace() {
        int i = Build.VERSION.SDK_INT;
        if (i > 29 || i < 26 || !C1141b.m3372d(this.f1288e).contains("Oppo")) {
            return;
        }
        JNI_CALL_TYPE |= 2;
    }

    public boolean filterSigabrtSysLog() {
        return m3239a(TbsLog.TBSLOG_CODE_SDK_LOAD_ERROR, "true");
    }

    public synchronized String getDumpFilePath() {
        return this.f1292i;
    }

    @Override // com.tencent.bugly.crashreport.AbstractC1129b
    public String getLogFromNative() {
        if ((this.f1294k || this.f1295l) && f1285b) {
            try {
                return this.f1295l ? getNativeLog() : (String) C1208ca.m3024a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "getNativeLog", null, null, null);
            } catch (UnsatisfiedLinkError unused) {
                f1285b = false;
                return null;
            } catch (Throwable th) {
                if (!C1199X.m3080b(th)) {
                    th.printStackTrace();
                }
                return null;
            }
        }
        return null;
    }

    public NativeExceptionHandler getNativeExceptionHandler() {
        return this.f1291h;
    }

    public native String getNativeKeyValueList();

    public native String getNativeLog();

    public boolean isEnableCatchAnrTrace() {
        return (JNI_CALL_TYPE & 2) == 2;
    }

    public synchronized boolean isUserOpened() {
        return this.f1297n;
    }

    public synchronized void onStrategyChanged(StrategyBean strategyBean) {
        if (strategyBean != null) {
            boolean z = strategyBean.f1089f;
            if (z != this.f1296m) {
                C1199X.m3076e("server native changed to %b", Boolean.valueOf(z));
            }
        }
        boolean z2 = C1145c.m3344b().m3342c().f1089f && this.f1297n;
        if (z2 != this.f1296m) {
            C1199X.m3078c("native changed to %b", Boolean.valueOf(z2));
            m3231b(z2);
        }
    }

    public boolean putKeyValueToNative(String str, String str2) {
        if ((this.f1294k || this.f1295l) && f1285b && str != null && str2 != null) {
            try {
                if (this.f1295l) {
                    return putNativeKeyValue(str, str2);
                }
                Boolean bool = (Boolean) C1208ca.m3024a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "putNativeKeyValue", null, new Class[]{String.class, String.class}, new Object[]{str, str2});
                if (bool == null) {
                    return false;
                }
                return bool.booleanValue();
            } catch (UnsatisfiedLinkError unused) {
                f1285b = false;
            } catch (Throwable th) {
                if (!C1199X.m3080b(th)) {
                    th.printStackTrace();
                }
                return false;
            }
        }
        return false;
    }

    public native boolean putNativeKeyValue(String str, String str2);

    public native String regist(String str, boolean z, int i);

    public void removeEmptyNativeRecordFiles() {
        C1171c.m3219b(this.f1292i);
    }

    public native String removeNativeKeyValue(String str);

    public synchronized void setDumpFilePath(String str) {
        this.f1292i = str;
    }

    public boolean setNativeAppChannel(String str) {
        return m3239a(12, str);
    }

    public boolean setNativeAppPackage(String str) {
        return m3239a(13, str);
    }

    public boolean setNativeAppVersion(String str) {
        return m3239a(10, str);
    }

    public native void setNativeInfo(int i, String str);

    @Override // com.tencent.bugly.crashreport.AbstractC1129b
    public boolean setNativeIsAppForeground(boolean z) {
        return m3239a(14, z ? "true" : "false");
    }

    public boolean setNativeLaunchTime(long j) {
        try {
            return m3239a(15, String.valueOf(j));
        } catch (NumberFormatException e) {
            if (C1199X.m3080b(e)) {
                return false;
            }
            e.printStackTrace();
            return false;
        }
    }

    public boolean setNativeUserId(String str) {
        return m3239a(11, str);
    }

    public synchronized void setUserOpened(boolean z) {
        m3228c(z);
        boolean isUserOpened = isUserOpened();
        C1145c m3344b = C1145c.m3344b();
        if (m3344b != null) {
            isUserOpened = isUserOpened && m3344b.m3342c().f1089f;
        }
        if (isUserOpened != this.f1296m) {
            C1199X.m3078c("native changed to %b", Boolean.valueOf(isUserOpened));
            m3231b(isUserOpened);
        }
    }

    public synchronized void startNativeMonitor() {
        if (!this.f1295l && !this.f1294k) {
            String str = "Bugly";
            boolean z = !C1208ca.m3012b(this.f1289f.f1015L);
            if (C1164h.f1232b) {
                boolean m3235a = m3235a(z ? this.f1289f.f1015L : "Bugly-rqd", z);
                this.f1295l = m3235a;
                if (!m3235a && !z) {
                    this.f1294k = m3235a("NativeRQD", false);
                }
            } else {
                C1140a c1140a = this.f1289f;
                String str2 = c1140a.f1015L;
                if (!z) {
                    c1140a.getClass();
                } else {
                    str = str2;
                }
                this.f1295l = m3235a(str, z);
            }
            if (!this.f1295l && !this.f1294k) {
                return;
            }
            m3234a(this.f1293j);
            if (f1285b) {
                setNativeAppVersion(this.f1289f.f1008E);
                setNativeAppChannel(this.f1289f.f1012I);
                setNativeAppPackage(this.f1289f.f1041g);
                setNativeUserId(this.f1289f.m3382y());
                setNativeIsAppForeground(this.f1289f.m3427C());
                setNativeLaunchTime(this.f1289f.f1035d);
            }
            return;
        }
        m3234a(this.f1293j);
    }

    public native void testCrash();

    public void testNativeCrash() {
        if (!this.f1295l) {
            C1199X.m3076e("[Native] Bugly SO file has not been load.", new Object[0]);
        } else {
            testCrash();
        }
    }

    public void testNativeCrash(boolean z, boolean z2, boolean z3) {
        m3239a(16, "" + z);
        m3239a(17, "" + z2);
        m3239a(18, "" + z3);
        testNativeCrash();
    }

    public native String unregist();
}
