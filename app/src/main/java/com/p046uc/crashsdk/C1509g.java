package com.p046uc.crashsdk;

import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import com.p046uc.crashsdk.export.CustomInfo;
import com.p046uc.crashsdk.export.VersionInfo;
import com.p046uc.crashsdk.p047a.C1491a;
import com.p046uc.crashsdk.p047a.C1494d;
import com.p046uc.crashsdk.p047a.C1497g;
import com.p046uc.crashsdk.p047a.C1498h;
import java.io.File;
import java.lang.reflect.Field;
import java.util.zip.ZipFile;
import me.tvspark.outline;
import org.mozilla.javascript.Token;

/* renamed from: com.uc.crashsdk.g */
/* loaded from: classes4.dex */
public class C1509g {

    /* renamed from: c */
    public static final /* synthetic */ boolean f2828c = !C1509g.class.desiredAssertionStatus();

    /* renamed from: d */
    public static CustomInfo f2829d = null;

    /* renamed from: e */
    public static VersionInfo f2830e = null;

    /* renamed from: a */
    public static RuntimeException f2826a = null;

    /* renamed from: b */
    public static RuntimeException f2827b = null;

    /* renamed from: f */
    public static final Object f2831f = new Object();

    /* renamed from: g */
    public static String f2832g = null;

    /* renamed from: h */
    public static String f2833h = null;

    /* renamed from: i */
    public static String f2834i = null;

    /* renamed from: j */
    public static String f2835j = null;

    /* renamed from: k */
    public static final Object f2836k = new Object();

    /* renamed from: A */
    public static long m1536A() {
        return f2829d.mMaxUploadBytesPerDay;
    }

    /* renamed from: B */
    public static int m1535B() {
        return f2829d.mMaxUploadBuiltinLogCountPerDay;
    }

    /* renamed from: C */
    public static int m1534C() {
        return f2829d.mMaxUploadCustomLogCountPerDay;
    }

    /* renamed from: D */
    public static int m1533D() {
        return f2829d.mMaxCustomLogCountPerTypePerDay;
    }

    /* renamed from: E */
    public static int m1532E() {
        return f2829d.mInfoUpdateInterval;
    }

    /* renamed from: F */
    public static int m1531F() {
        return f2829d.mInfoSaveFrequency;
    }

    /* renamed from: G */
    public static int m1530G() {
        return f2829d.mReservedJavaFileHandleCount;
    }

    /* renamed from: H */
    public static int m1529H() {
        return f2829d.mFdDumpMinLimit;
    }

    /* renamed from: I */
    public static int m1528I() {
        return f2829d.mThreadsDumpMinLimit;
    }

    /* renamed from: J */
    public static boolean m1527J() {
        return f2829d.mAutoDetectLifeCycle;
    }

    /* renamed from: K */
    public static boolean m1526K() {
        return f2829d.mMonitorBattery;
    }

    /* renamed from: L */
    public static int m1525L() {
        return f2829d.mAnrTraceStrategy;
    }

    /* renamed from: M */
    public static boolean m1524M() {
        CustomInfo customInfo = f2829d;
        return customInfo == null || customInfo.mDebug;
    }

    /* renamed from: N */
    public static boolean m1523N() {
        CustomInfo customInfo = f2829d;
        return customInfo == null || customInfo.mPrintStackInfos;
    }

    /* renamed from: O */
    public static boolean m1522O() {
        return f2829d.mEnableStatReport;
    }

    /* renamed from: P */
    public static boolean m1521P() {
        return f2829d.mIsInternational;
    }

    /* renamed from: Q */
    public static boolean m1520Q() {
        return f2829d.mAddPvForNewDay;
    }

    /* renamed from: R */
    public static String m1519R() {
        return C1497g.m1872a(f2830e.mVersion) ? C1490a.m1962a() : m1504a(f2830e.mVersion);
    }

    /* renamed from: S */
    public static String m1518S() {
        return C1497g.m1872a(f2830e.mSubVersion) ? "release" : f2830e.mSubVersion;
    }

    /* renamed from: T */
    public static String m1517T() {
        return C1497g.m1872a(f2830e.mBuildId) ? m1501ab() : m1504a(f2830e.mBuildId);
    }

    /* renamed from: U */
    public static String m1516U() {
        if (f2833h == null) {
            f2833h = C1497g.m1865b() + File.separatorChar + f2829d.mTagFilesFolderName + File.separatorChar;
        }
        return f2833h;
    }

    /* renamed from: V */
    public static String m1515V() {
        if (f2834i == null) {
            f2834i = C1497g.m1865b() + File.separatorChar + f2829d.mCrashLogsFolderName + File.separatorChar;
        }
        return f2834i;
    }

    /* renamed from: W */
    public static String m1514W() {
        String path;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        String str;
        if (f2835j == null) {
            if (!C1497g.m1872a(f2829d.mLogsBackupPathName)) {
                str = f2829d.mLogsBackupPathName.trim();
                if (!str.endsWith(File.separator)) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(File.separator);
                }
                f2835j = str;
            } else {
                if (!C1500b.m1785L()) {
                    try {
                        path = Environment.getExternalStorageDirectory().getPath();
                    } catch (Throwable th) {
                        C1497g.m1868a(th);
                    }
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(path);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(File.separatorChar);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(f2829d.mCrashLogsFolderName);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(File.separatorChar);
                }
                path = "/sdcard";
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(path);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(File.separatorChar);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(f2829d.mCrashLogsFolderName);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(File.separatorChar);
            }
            str = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
            f2835j = str;
        }
        return f2835j;
    }

    /* renamed from: X */
    public static boolean m1513X() {
        return f2829d.mEnableCrpStat;
    }

    /* renamed from: Y */
    public static boolean m1512Y() {
        return f2829d.mEnableStatToWPKDirect;
    }

    /* renamed from: Z */
    public static String m1511Z() {
        return f2829d.mUserId;
    }

    /* renamed from: a */
    public static CustomInfo m1507a(CustomInfo customInfo, Bundle bundle) {
        if (customInfo == null) {
            CustomInfo customInfo2 = f2829d;
            customInfo = customInfo2 == null ? new CustomInfo() : new CustomInfo(customInfo2);
        }
        Field[] fields = CustomInfo.class.getFields();
        for (String str : bundle.keySet()) {
            for (Field field : fields) {
                if (field.getName().equals(str)) {
                    Object obj = bundle.get(str);
                    try {
                        field.set(customInfo, obj);
                    } catch (Exception e) {
                        C1497g.m1868a(e);
                        StringBuilder sb = new StringBuilder("Field ");
                        sb.append(str);
                        sb.append(" must be a ");
                        sb.append(field.getType().getName());
                        sb.append(", but give a ");
                        sb.append(obj != null ? obj.getClass().getName() : "(null)");
                        throw new IllegalArgumentException(sb.toString());
                    }
                }
            }
        }
        return customInfo;
    }

    /* renamed from: a */
    public static VersionInfo m1509a(Bundle bundle) {
        VersionInfo versionInfo = f2830e;
        VersionInfo versionInfo2 = versionInfo == null ? new VersionInfo() : new VersionInfo(versionInfo);
        String string = bundle.getString("mVersion");
        if (!C1497g.m1872a(string)) {
            versionInfo2.mVersion = string;
        }
        String string2 = bundle.getString("mSubVersion");
        if (!C1497g.m1872a(string2)) {
            versionInfo2.mSubVersion = string2;
        }
        String string3 = bundle.getString("mBuildId");
        if (!C1497g.m1872a(string3)) {
            versionInfo2.mBuildId = string3;
        }
        String string4 = bundle.getString("crver");
        if (!C1497g.m1872a(string4)) {
            C1490a.f2595b = string4;
            m1500ac();
        }
        return versionInfo2;
    }

    /* renamed from: a */
    public static String m1504a(String str) {
        return (str == null || !str.contains("_")) ? str : str.replaceAll("_", "-");
    }

    /* renamed from: a */
    public static void m1510a() {
        C1500b.m1725y();
        C1500b.m1726x();
        if (f2829d.mBackupLogs) {
            File file = new File(m1514W());
            if (file.exists()) {
                return;
            }
            file.mkdirs();
        }
    }

    /* renamed from: a */
    public static void m1508a(CustomInfo customInfo) {
        if (f2828c || customInfo.mTagFilesFolderName != null) {
            if (!f2828c && customInfo.mCrashLogsFolderName == null) {
                throw new AssertionError();
            }
            if (customInfo.mTagFilesFolderName.equals(customInfo.mCrashLogsFolderName)) {
                throw new IllegalArgumentException("mTagFilesFolderName and mCrashLogsFolderName can not be set to the same!");
            }
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public static void m1506a(CustomInfo customInfo, VersionInfo versionInfo) {
        CustomInfo customInfo2 = new CustomInfo(customInfo);
        f2829d = customInfo2;
        m1496c(customInfo2);
        if (!f2829d.mZipLog) {
            f2826a = new RuntimeException("initialize set mZipLog to false, info.mZipLog: " + customInfo.mZipLog);
        }
        if (f2829d.mEncryptLog) {
            f2827b = new RuntimeException("initialize set mEncryptLog to true, info.mEncryptLog: " + customInfo.mEncryptLog);
        }
        f2830e = new VersionInfo(versionInfo);
        if (!C1500b.m1785L()) {
            try {
                m1510a();
            } catch (Throwable th) {
                C1497g.m1868a(th);
            }
        }
    }

    /* renamed from: a */
    public static void m1505a(VersionInfo versionInfo) {
        synchronized (f2831f) {
            f2830e = new VersionInfo(versionInfo);
            C1503e.m1637c();
            if (C1500b.f2714d) {
                JNIBridge.set(109, m1519R());
                JNIBridge.set(110, m1518S());
                JNIBridge.set(111, m1517T());
                JNIBridge.set(112, "210916105822");
                JNIBridge.cmd(2);
            }
        }
    }

    /* renamed from: a */
    public static boolean m1503a(String str, String str2) {
        if (str == str2) {
            return true;
        }
        if (str != null && str2 != null) {
            return str.equals(str2);
        }
        return false;
    }

    /* renamed from: aa */
    public static String m1502aa() {
        return f2829d.mChannel;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0045, code lost:
        if (r1 == null) goto L14;
     */
    /* renamed from: ab */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String m1501ab() {
        ZipFile zipFile;
        Throwable th;
        String str = f2832g;
        if (str != null) {
            return str;
        }
        try {
            zipFile = new ZipFile(C1497g.m1861c());
            try {
                f2832g = Long.toHexString(zipFile.getEntry("classes.dex").getCrc());
                C1491a.m1925a("crashsdk", "version unique build id: " + f2832g);
            } catch (Throwable th2) {
                th = th2;
                try {
                    f2832g = "";
                    C1497g.m1868a(th);
                } catch (Throwable th3) {
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (Throwable unused) {
                        }
                    }
                    throw th3;
                }
            }
        } catch (Throwable th4) {
            zipFile = null;
            th = th4;
        }
        try {
            zipFile.close();
        } catch (Throwable unused2) {
            return f2832g;
        }
    }

    /* renamed from: ac */
    public static void m1500ac() {
        if (C1500b.f2714d) {
            JNIBridge.nativeSet(24, 1L, C1490a.f2595b, null);
        }
    }

    /* renamed from: b */
    public static int m1498b(CustomInfo customInfo) {
        int i;
        int i2;
        boolean z;
        boolean z2;
        synchronized (f2836k) {
            i = 0;
            if (customInfo != null) {
                m1496c(customInfo);
                if (f2829d == null) {
                    f2829d = new CustomInfo();
                }
                CustomInfo customInfo2 = f2829d;
                boolean z3 = true;
                if (!m1503a(customInfo.mAppId, customInfo2.mAppId)) {
                    String str = customInfo.mAppId;
                    customInfo2.mAppId = str;
                    if (C1500b.f2714d) {
                        JNIBridge.set(102, str);
                    }
                    i2 = 1;
                    z = true;
                } else {
                    i2 = 0;
                    z = false;
                }
                if (!m1503a(customInfo.mJavaCrashLogFileName, customInfo2.mJavaCrashLogFileName)) {
                    customInfo2.mJavaCrashLogFileName = customInfo.mJavaCrashLogFileName;
                    i2++;
                }
                if (!m1503a(customInfo.mNativeCrashLogFileName, customInfo2.mNativeCrashLogFileName)) {
                    String str2 = customInfo.mNativeCrashLogFileName;
                    customInfo2.mNativeCrashLogFileName = str2;
                    if (C1500b.f2714d) {
                        JNIBridge.set(100, str2);
                    }
                    i2++;
                    z = true;
                }
                if (!m1503a(customInfo.mUnexpCrashLogFileName, customInfo2.mUnexpCrashLogFileName)) {
                    String str3 = customInfo.mUnexpCrashLogFileName;
                    customInfo2.mUnexpCrashLogFileName = str3;
                    if (C1500b.f2714d) {
                        JNIBridge.set(101, str3);
                    }
                    i2++;
                    z = true;
                }
                if (z) {
                    C1503e.m1637c();
                    if (C1500b.f2714d) {
                        JNIBridge.cmd(2);
                    }
                }
                if (customInfo2.mPrintStackInfos != customInfo.mPrintStackInfos) {
                    boolean z4 = customInfo.mPrintStackInfos;
                    customInfo2.mPrintStackInfos = z4;
                    if (C1500b.f2714d) {
                        JNIBridge.set(11, z4);
                    }
                    i2++;
                }
                if (customInfo2.mDebug != customInfo.mDebug) {
                    boolean z5 = customInfo.mDebug;
                    customInfo2.mDebug = z5;
                    if (C1500b.f2714d) {
                        JNIBridge.set(18, z5);
                    }
                    i2++;
                }
                if (customInfo2.mBackupLogs != customInfo.mBackupLogs) {
                    boolean z6 = customInfo.mBackupLogs;
                    customInfo2.mBackupLogs = z6;
                    if (C1500b.f2714d) {
                        JNIBridge.set(12, z6);
                    }
                    i2++;
                }
                if (customInfo2.mOmitNativeCrash != customInfo.mOmitNativeCrash) {
                    boolean z7 = customInfo.mOmitNativeCrash;
                    customInfo2.mOmitNativeCrash = z7;
                    if (C1500b.f2714d) {
                        JNIBridge.set(21, z7);
                    }
                    i2++;
                }
                if (customInfo2.mCrashRestartInterval != customInfo.mCrashRestartInterval) {
                    int i3 = customInfo.mCrashRestartInterval;
                    customInfo2.mCrashRestartInterval = i3;
                    if (C1500b.f2714d) {
                        JNIBridge.set(13, i3);
                    }
                    if (customInfo2.mCrashRestartInterval >= 0) {
                        C1500b.m1784M();
                    }
                    i2++;
                }
                if (customInfo2.mMaxBuiltinLogFilesCount != customInfo.mMaxBuiltinLogFilesCount) {
                    int i4 = customInfo.mMaxBuiltinLogFilesCount;
                    customInfo2.mMaxBuiltinLogFilesCount = i4;
                    if (C1500b.f2714d) {
                        JNIBridge.set(14, i4);
                    }
                    i2++;
                }
                if (customInfo2.mMaxNativeLogcatLineCount != customInfo.mMaxNativeLogcatLineCount) {
                    int i5 = customInfo.mMaxNativeLogcatLineCount;
                    customInfo2.mMaxNativeLogcatLineCount = i5;
                    if (C1500b.f2714d) {
                        JNIBridge.set(15, i5);
                    }
                    i2++;
                }
                if (customInfo2.mMaxJavaLogcatLineCount != customInfo.mMaxJavaLogcatLineCount) {
                    customInfo2.mMaxJavaLogcatLineCount = customInfo.mMaxJavaLogcatLineCount;
                    i2++;
                }
                if (customInfo2.mMaxUnexpLogcatLineCount != customInfo.mMaxUnexpLogcatLineCount) {
                    int i6 = customInfo.mMaxUnexpLogcatLineCount;
                    customInfo2.mMaxUnexpLogcatLineCount = i6;
                    if (C1500b.f2714d) {
                        JNIBridge.set(16, i6);
                    }
                    i2++;
                }
                if (customInfo2.mMaxAnrLogcatLineCount != customInfo.mMaxAnrLogcatLineCount) {
                    int i7 = customInfo.mMaxAnrLogcatLineCount;
                    customInfo2.mMaxAnrLogcatLineCount = i7;
                    if (C1500b.f2714d) {
                        JNIBridge.set(31, i7);
                    }
                    i2++;
                }
                if (customInfo2.mZipLog != customInfo.mZipLog) {
                    boolean z8 = customInfo.mZipLog;
                    customInfo2.mZipLog = z8;
                    if (!z8) {
                        C1491a.m1920d("DEBUG", "updateCustomInfoImpl set mZipLog to false");
                        f2826a = new RuntimeException("updateCustomInfoImpl set mZipLog to false");
                    }
                    i2++;
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!m1503a(customInfo.mZippedLogExtension, customInfo2.mZippedLogExtension)) {
                    customInfo2.mZippedLogExtension = customInfo.mZippedLogExtension;
                    i2++;
                } else {
                    z3 = z2;
                }
                if (z3 && C1500b.f2714d) {
                    JNIBridge.nativeSet(3, customInfo2.mZipLog ? 1L : 0L, customInfo2.mZippedLogExtension, null);
                }
                if (customInfo2.mLogMaxBytesLimit != customInfo.mLogMaxBytesLimit) {
                    int i8 = customInfo.mLogMaxBytesLimit;
                    customInfo2.mLogMaxBytesLimit = i8;
                    if (C1500b.f2714d) {
                        JNIBridge.set(4, i8);
                    }
                    i2++;
                }
                if (customInfo2.mEncryptLog != customInfo.mEncryptLog) {
                    boolean z9 = customInfo.mEncryptLog;
                    customInfo2.mEncryptLog = z9;
                    if (z9) {
                        C1491a.m1920d("DEBUG", "updateCustomInfoImpl set mEncryptLog to true");
                        f2827b = new RuntimeException("updateCustomInfoImpl set mEncryptLog to true");
                    }
                    i2++;
                }
                if (customInfo2.mSyncUploadSetupCrashLogs != customInfo.mSyncUploadSetupCrashLogs) {
                    customInfo2.mSyncUploadSetupCrashLogs = customInfo.mSyncUploadSetupCrashLogs;
                    i2++;
                }
                if (customInfo2.mSyncUploadLogs != customInfo.mSyncUploadLogs) {
                    customInfo2.mSyncUploadLogs = customInfo.mSyncUploadLogs;
                    i2++;
                }
                if (customInfo2.mMaxCustomLogFilesCount != customInfo.mMaxCustomLogFilesCount) {
                    customInfo2.mMaxCustomLogFilesCount = customInfo.mMaxCustomLogFilesCount;
                    i2++;
                }
                if (customInfo2.mOmitJavaCrash != customInfo.mOmitJavaCrash) {
                    customInfo2.mOmitJavaCrash = customInfo.mOmitJavaCrash;
                    i2++;
                }
                if (customInfo2.mLogMaxUploadBytesLimit != customInfo.mLogMaxUploadBytesLimit) {
                    customInfo2.mLogMaxUploadBytesLimit = customInfo.mLogMaxUploadBytesLimit;
                    i2++;
                }
                if (customInfo2.mMaxUploadBytesPerDay != customInfo.mMaxUploadBytesPerDay) {
                    customInfo2.mMaxUploadBytesPerDay = customInfo.mMaxUploadBytesPerDay;
                    i2++;
                }
                if (customInfo2.mMaxUploadBuiltinLogCountPerDay != customInfo.mMaxUploadBuiltinLogCountPerDay) {
                    customInfo2.mMaxUploadBuiltinLogCountPerDay = customInfo.mMaxUploadBuiltinLogCountPerDay;
                    i2++;
                }
                if (customInfo2.mMaxUploadCustomLogCountPerDay != customInfo.mMaxUploadCustomLogCountPerDay) {
                    customInfo2.mMaxUploadCustomLogCountPerDay = customInfo.mMaxUploadCustomLogCountPerDay;
                    i2++;
                }
                if (customInfo2.mMaxCustomLogCountPerTypePerDay != customInfo.mMaxCustomLogCountPerTypePerDay) {
                    customInfo2.mMaxCustomLogCountPerTypePerDay = customInfo.mMaxCustomLogCountPerTypePerDay;
                    i2++;
                }
                if (customInfo2.mMaxAnrLogCountPerProcess != customInfo.mMaxAnrLogCountPerProcess) {
                    customInfo2.mMaxAnrLogCountPerProcess = customInfo.mMaxAnrLogCountPerProcess;
                    if (C1500b.f2714d) {
                        JNIBridge.set(32, f2829d.mMaxAnrLogCountPerProcess);
                    }
                    i2++;
                }
                if (customInfo2.mCallJavaDefaultHandler != customInfo.mCallJavaDefaultHandler) {
                    customInfo2.mCallJavaDefaultHandler = customInfo.mCallJavaDefaultHandler;
                    i2++;
                }
                if (customInfo2.mCallNativeDefaultHandler != customInfo.mCallNativeDefaultHandler) {
                    customInfo2.mCallNativeDefaultHandler = customInfo.mCallNativeDefaultHandler;
                    i2++;
                    if (C1500b.f2714d) {
                        JNIBridge.set(5, f2829d.mCallNativeDefaultHandler);
                    }
                }
                if (customInfo2.mDumpUserSolibBuildId != customInfo.mDumpUserSolibBuildId) {
                    customInfo2.mDumpUserSolibBuildId = customInfo.mDumpUserSolibBuildId;
                    i2++;
                    if (C1500b.f2714d) {
                        JNIBridge.set(6, f2829d.mDumpUserSolibBuildId);
                    }
                }
                if (customInfo2.mDumpHprofDataForJavaOOM != customInfo.mDumpHprofDataForJavaOOM) {
                    customInfo2.mDumpHprofDataForJavaOOM = customInfo.mDumpHprofDataForJavaOOM;
                    i2++;
                }
                if (customInfo2.mRenameFileToDefaultName != customInfo.mRenameFileToDefaultName) {
                    customInfo2.mRenameFileToDefaultName = customInfo.mRenameFileToDefaultName;
                    i2++;
                }
                if (customInfo2.mAutoDeleteOldVersionStats != customInfo.mAutoDeleteOldVersionStats) {
                    customInfo2.mAutoDeleteOldVersionStats = customInfo.mAutoDeleteOldVersionStats;
                    i2++;
                }
                if (customInfo2.mFdDumpMinLimit != customInfo.mFdDumpMinLimit) {
                    int i9 = customInfo.mFdDumpMinLimit;
                    customInfo2.mFdDumpMinLimit = i9;
                    if (C1500b.f2714d) {
                        JNIBridge.set(10, i9);
                    }
                    i2++;
                }
                if (customInfo2.mThreadsDumpMinLimit != customInfo.mThreadsDumpMinLimit) {
                    int i10 = customInfo.mThreadsDumpMinLimit;
                    customInfo2.mThreadsDumpMinLimit = i10;
                    if (C1500b.f2714d) {
                        JNIBridge.set(22, i10);
                    }
                    i2++;
                }
                if (customInfo2.mInfoUpdateInterval != customInfo.mInfoUpdateInterval) {
                    if (customInfo2.mInfoUpdateInterval <= 0 && customInfo.mInfoUpdateInterval > 0) {
                        C1490a.m1947a(false);
                    }
                    customInfo2.mInfoUpdateInterval = customInfo.mInfoUpdateInterval;
                    i2++;
                }
                if (customInfo2.mInfoSaveFrequency != customInfo.mInfoSaveFrequency) {
                    customInfo2.mInfoSaveFrequency = customInfo.mInfoSaveFrequency;
                    i2++;
                }
                if (customInfo2.mDisableBackgroundSignals != customInfo.mDisableBackgroundSignals) {
                    long j = customInfo.mDisableBackgroundSignals;
                    customInfo2.mDisableBackgroundSignals = j;
                    if (C1500b.f2714d) {
                        JNIBridge.set(9, j);
                    }
                    i2++;
                }
                if (customInfo2.mEnableStatReport != customInfo.mEnableStatReport) {
                    boolean z10 = customInfo.mEnableStatReport;
                    customInfo2.mEnableStatReport = z10;
                    if (z10) {
                        C1503e.m1710B();
                    }
                    i2++;
                }
                if (customInfo2.mEnableCrpStat != customInfo.mEnableCrpStat) {
                    customInfo2.mEnableCrpStat = customInfo.mEnableCrpStat;
                    i2++;
                }
                if (customInfo2.mEnableStatToWPKDirect != customInfo.mEnableStatToWPKDirect) {
                    customInfo2.mEnableStatToWPKDirect = customInfo.mEnableStatToWPKDirect;
                    i2++;
                }
                if (customInfo2.mIsInternational != customInfo.mIsInternational) {
                    boolean z11 = customInfo.mIsInternational;
                    customInfo2.mIsInternational = z11;
                    if (C1500b.f2714d) {
                        JNIBridge.set(23, z11);
                    }
                    C1503e.m1600l();
                    C1494d.m1897c();
                    C1498h.m1810k();
                    i2++;
                }
                if (customInfo2.mAutoDetectLifeCycle != customInfo.mAutoDetectLifeCycle) {
                    boolean z12 = customInfo.mAutoDetectLifeCycle;
                    customInfo2.mAutoDetectLifeCycle = z12;
                    if (z12) {
                        C1500b.m1794C();
                    }
                    i2++;
                }
                if (customInfo2.mMonitorBattery != customInfo.mMonitorBattery) {
                    customInfo2.mMonitorBattery = customInfo.mMonitorBattery;
                    C1503e.m1632c(C1500b.m1795B());
                    i2++;
                }
                if (customInfo2.mUnexpSubTypes != customInfo.mUnexpSubTypes) {
                    customInfo2.mUnexpSubTypes = customInfo.mUnexpSubTypes;
                    i2++;
                }
                if (customInfo2.mEnableMemoryGroup != customInfo.mEnableMemoryGroup) {
                    boolean z13 = customInfo.mEnableMemoryGroup;
                    customInfo2.mEnableMemoryGroup = z13;
                    if (C1500b.f2714d) {
                        JNIBridge.set(35, z13);
                    }
                    i2++;
                }
                if (customInfo2.mEnableLibcMallocDetail != customInfo.mEnableLibcMallocDetail) {
                    boolean z14 = customInfo.mEnableLibcMallocDetail;
                    customInfo2.mEnableLibcMallocDetail = z14;
                    if (C1500b.f2714d) {
                        JNIBridge.set(36, z14);
                    }
                    i2++;
                }
                if (customInfo2.mLibcMallocDetailConfig != customInfo.mLibcMallocDetailConfig) {
                    String str4 = customInfo.mLibcMallocDetailConfig;
                    customInfo2.mLibcMallocDetailConfig = str4;
                    if (C1500b.f2714d) {
                        JNIBridge.set((int) Token.LABEL, str4);
                    }
                    i2++;
                }
                if (!m1503a(customInfo.mUserId, customInfo2.mUserId)) {
                    customInfo2.mUserId = customInfo.mUserId;
                    i2++;
                }
                if (!m1503a(customInfo.mChannel, customInfo2.mChannel)) {
                    customInfo2.mChannel = customInfo.mChannel;
                    i2++;
                }
                i = i2;
            }
        }
        return i;
    }

    /* renamed from: b */
    public static void m1499b() {
        JNIBridge.set(103, C1497g.m1865b());
        JNIBridge.set(104, f2829d.mTagFilesFolderName);
        JNIBridge.set(105, f2829d.mCrashLogsFolderName);
        JNIBridge.set(106, m1514W());
        JNIBridge.set(107, C1503e.m1610h());
        JNIBridge.set(108, C1500b.m1770a());
        JNIBridge.set(109, m1519R());
        JNIBridge.set(110, m1518S());
        JNIBridge.set(111, m1517T());
        JNIBridge.set(112, "210916105822");
        JNIBridge.set(116, Build.MODEL);
        JNIBridge.set(117, Build.VERSION.RELEASE);
        JNIBridge.set(118, C1503e.m1590q());
        JNIBridge.set(5, f2829d.mCallNativeDefaultHandler);
        JNIBridge.set(6, f2829d.mDumpUserSolibBuildId);
        JNIBridge.set(7, f2829d.mReservedNativeMemoryBytes);
        JNIBridge.set(100, f2829d.mNativeCrashLogFileName);
        JNIBridge.set(101, f2829d.mUnexpCrashLogFileName);
        JNIBridge.set(35, f2829d.mEnableMemoryGroup);
        JNIBridge.set(36, f2829d.mEnableLibcMallocDetail);
        JNIBridge.set((int) Token.LABEL, f2829d.mLibcMallocDetailConfig);
        JNIBridge.set(102, f2829d.mAppId);
    }

    /* renamed from: c */
    public static void m1497c() {
        JNIBridge.set(11, m1523N());
        JNIBridge.set(12, f2829d.mBackupLogs);
        JNIBridge.set(13, f2829d.mCrashRestartInterval);
        JNIBridge.set(14, f2829d.mMaxBuiltinLogFilesCount);
        JNIBridge.set(15, f2829d.mMaxNativeLogcatLineCount);
        JNIBridge.set(16, f2829d.mMaxUnexpLogcatLineCount);
        JNIBridge.set(31, f2829d.mMaxAnrLogcatLineCount);
        JNIBridge.set(18, m1524M());
        JNIBridge.set(20, Build.VERSION.SDK_INT);
        JNIBridge.set(21, f2829d.mOmitNativeCrash);
        JNIBridge.set(32, f2829d.mMaxAnrLogCountPerProcess);
        JNIBridge.set(8, f2829d.mDisableSignals);
        JNIBridge.set(9, f2829d.mDisableBackgroundSignals);
        JNIBridge.nativeSet(3, f2829d.mZipLog ? 1L : 0L, f2829d.mZippedLogExtension, null);
        JNIBridge.set(4, f2829d.mLogMaxBytesLimit);
        JNIBridge.set(119, Build.FINGERPRINT);
    }

    /* renamed from: c */
    public static void m1496c(CustomInfo customInfo) {
        if (customInfo.mZippedLogExtension == null) {
            customInfo.mZippedLogExtension = "";
        }
        if (!customInfo.mZippedLogExtension.equals(".tmp")) {
            if (customInfo.mOmitJavaCrash) {
                customInfo.mCallJavaDefaultHandler = false;
            }
            if (customInfo.mOmitNativeCrash) {
                customInfo.mCallNativeDefaultHandler = false;
            }
            long m1651b = C1503e.m1651b();
            if (m1651b < 1) {
                return;
            }
            customInfo.mMaxBuiltinLogFilesCount = 200;
            customInfo.mMaxCustomLogFilesCount = 100;
            customInfo.mMaxUploadBytesPerDay = 268435456L;
            customInfo.mMaxUploadBuiltinLogCountPerDay = 2000;
            customInfo.mMaxUploadCustomLogCountPerDay = 2000;
            customInfo.mMaxCustomLogCountPerTypePerDay = 100;
            customInfo.mMaxAnrLogCountPerProcess = 100;
            customInfo.mAnrTraceStrategy = 2;
            if (m1651b < 2) {
                return;
            }
            customInfo.mSyncUploadSetupCrashLogs = true;
            customInfo.mSyncUploadLogs = true;
            if (m1651b < 3) {
                return;
            }
            customInfo.mBackupLogs = true;
            customInfo.mPrintStackInfos = true;
            customInfo.mDebug = true;
            return;
        }
        throw new IllegalArgumentException("mZippedLogExtension can not be '.tmp'!");
    }

    /* renamed from: d */
    public static void m1495d() {
        JNIBridge.set(23, f2829d.mIsInternational);
        if (C1500b.m1789H()) {
            JNIBridge.set(34, true);
        }
        if (C1503e.m1607i()) {
            JNIBridge.set(1, true);
        }
        JNIBridge.set(10, f2829d.mFdDumpMinLimit);
        JNIBridge.nativeCmd(3, f2829d.mReservedNativeFileHandleCount, null, null);
        JNIBridge.nativeSetForeground(C1500b.m1795B());
        JNIBridge.set(2, C1500b.m1791F());
        C1490a.m1938e();
        C1490a.m1936g();
        C1490a.m1934i();
        C1490a.m1932k();
        JNIBridge.set(113, C1490a.f2594a);
        JNIBridge.cmd(1);
        JNIBridge.set(22, f2829d.mThreadsDumpMinLimit);
        JNIBridge.set(122, C1490a.m1962a());
        JNIBridge.set(33, C1490a.m1941c());
        m1500ac();
        C1500b.m1786K();
        C1500b.m1793D();
        C1497g.m1849k();
    }

    /* renamed from: e */
    public static String m1494e() {
        return f2829d.mAppId;
    }

    /* renamed from: f */
    public static boolean m1493f() {
        if (!C1497g.m1863b(f2829d.mJavaCrashLogFileName) && !C1497g.m1863b(f2829d.mNativeCrashLogFileName)) {
            return C1497g.m1863b(f2829d.mUnexpCrashLogFileName);
        }
        return true;
    }

    /* renamed from: g */
    public static String m1492g() {
        return f2829d.mJavaCrashLogFileName;
    }

    /* renamed from: h */
    public static int m1491h() {
        return f2829d.mCrashRestartInterval;
    }

    /* renamed from: i */
    public static boolean m1490i() {
        return f2829d.mCallJavaDefaultHandler;
    }

    /* renamed from: j */
    public static boolean m1489j() {
        return f2829d.mDumpHprofDataForJavaOOM;
    }

    /* renamed from: k */
    public static boolean m1488k() {
        return f2829d.mRenameFileToDefaultName;
    }

    /* renamed from: l */
    public static int m1487l() {
        return f2829d.mMaxBuiltinLogFilesCount;
    }

    /* renamed from: m */
    public static int m1486m() {
        return f2829d.mMaxCustomLogFilesCount;
    }

    /* renamed from: n */
    public static int m1485n() {
        return f2829d.mMaxJavaLogcatLineCount;
    }

    /* renamed from: o */
    public static int m1484o() {
        return f2829d.mUnexpDelayMillSeconds;
    }

    /* renamed from: p */
    public static int m1483p() {
        return f2829d.mUnexpSubTypes;
    }

    /* renamed from: q */
    public static boolean m1482q() {
        return f2829d.mBackupLogs;
    }

    /* renamed from: r */
    public static boolean m1481r() {
        return f2829d.mSyncUploadSetupCrashLogs;
    }

    /* renamed from: s */
    public static boolean m1480s() {
        return f2829d.mSyncUploadLogs;
    }

    /* renamed from: t */
    public static boolean m1479t() {
        return f2829d.mOmitJavaCrash;
    }

    /* renamed from: u */
    public static boolean m1478u() {
        return f2829d.mAutoDeleteOldVersionStats;
    }

    /* renamed from: v */
    public static boolean m1477v() {
        return f2829d.mZipLog;
    }

    /* renamed from: w */
    public static String m1476w() {
        return f2829d.mZippedLogExtension;
    }

    /* renamed from: x */
    public static boolean m1475x() {
        return f2829d.mEncryptLog;
    }

    /* renamed from: y */
    public static int m1474y() {
        return f2829d.mLogMaxBytesLimit;
    }

    /* renamed from: z */
    public static int m1473z() {
        return f2829d.mLogMaxUploadBytesLimit;
    }
}
