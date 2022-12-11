package com.p046uc.crashsdk.export;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.webkit.ValueCallback;
import com.p046uc.crashsdk.C1490a;
import com.p046uc.crashsdk.C1500b;
import com.p046uc.crashsdk.C1502d;
import com.p046uc.crashsdk.C1503e;
import com.p046uc.crashsdk.C1509g;
import com.p046uc.crashsdk.JNIBridge;
import com.p046uc.crashsdk.p047a.C1491a;
import com.p046uc.crashsdk.p047a.C1494d;
import com.p046uc.crashsdk.p047a.C1497g;
import com.p046uc.crashsdk.p047a.C1498h;
import com.stub.StubApp;
import com.umeng.umcrash.UMCrash;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Callable;
import org.apache.commons.lang3.StringUtils;

/* renamed from: com.uc.crashsdk.export.CrashApi */
/* loaded from: classes4.dex */
public class CrashApi {

    /* renamed from: a */
    public static CrashApi f2817a = null;

    /* renamed from: c */
    public static boolean f2818c = true;

    /* renamed from: d */
    public static boolean f2819d;

    /* renamed from: b */
    public boolean f2820b;

    public CrashApi(Context context, CustomInfo customInfo, VersionInfo versionInfo, ICrashClient iCrashClient, boolean z, boolean z2, boolean z3) {
        this.f2820b = false;
        Context m1572a = m1572a(context);
        m1567b(m1572a);
        C1500b.f2717g = z2;
        C1500b.f2718h = z3;
        if (C1500b.m1785L()) {
            m1567b(m1572a);
            m1571a(m1572a, customInfo, versionInfo, iCrashClient);
            if (z) {
                m1573a();
            }
            if (!C1500b.f2717g || !C1503e.m1622e("libcrashsdk.so")) {
                return;
            }
            C1500b.f2716f = true;
            m1568b();
        } else if (customInfo == null || versionInfo == null) {
            C1491a.m1920d("crashsdk", "VersionInfo and CustomInfo can not be null!");
            throw null;
        } else {
            C1509g.m1508a(customInfo);
            try {
                m1571a(m1572a, customInfo, versionInfo, iCrashClient);
            } catch (Throwable th) {
                m1569a(th);
            }
            if (z) {
                try {
                    m1573a();
                } catch (Throwable th2) {
                    m1569a(th2);
                }
            }
            try {
                C1500b.m1784M();
                C1498h.m1847a();
                C1494d.m1902a();
                C1497g.m1850j();
            } catch (Throwable th3) {
                C1497g.m1868a(th3);
            }
            try {
                if (!C1500b.m1768a(m1572a)) {
                    C1491a.m1920d("crashsdk", "registerLifecycleCallbacks failed!");
                }
            } catch (Throwable th4) {
                C1497g.m1868a(th4);
            }
            try {
                C1490a.m1929n();
                C1503e.m1711A();
                C1503e.m1710B();
            } catch (Throwable th5) {
                C1497g.m1868a(th5);
            }
            try {
                if (!C1509g.m1481r() || !C1500b.m1791F() || this.f2820b) {
                    return;
                }
                C1503e.m1705G();
                this.f2820b = true;
            } catch (Throwable th6) {
                C1497g.m1862b(th6);
            }
        }
    }

    /* renamed from: a */
    public static Context m1572a(Context context) {
        if (context == null) {
            C1491a.m1920d("crashsdk", "context can not be null!");
            throw null;
        } else if (!f2818c || (context instanceof Application) || ((context = StubApp.getOrigApplicationContext(context.getApplicationContext())) != null && (context instanceof Application))) {
            return context;
        } else {
            C1491a.m1920d("crashsdk", "Can not get Application context from given context!");
            throw new IllegalArgumentException("Can not get Application context from given context!");
        }
    }

    /* renamed from: a */
    public static void m1573a() {
        if (C1500b.f2700a) {
            C1491a.m1923b("Has enabled java log!");
            return;
        }
        C1503e.m1586s();
        C1503e.m1594o();
        C1500b.f2700a = true;
    }

    /* renamed from: a */
    public static void m1571a(Context context, CustomInfo customInfo, VersionInfo versionInfo, ICrashClient iCrashClient) {
        C1502d.m1720a(iCrashClient);
        C1509g.m1506a(customInfo, versionInfo);
        if (!C1500b.m1785L()) {
            C1503e.m1592p();
            C1503e.m1682a(context);
            C1503e.m1648b(context);
        }
    }

    /* renamed from: a */
    public static void m1569a(Throwable th) {
        new C1503e().m1662a(Thread.currentThread(), th, true);
    }

    /* renamed from: a */
    public static boolean m1570a(String str) {
        if (C1500b.m1785L()) {
            C1491a.m1920d("crashsdk", "Can not call '" + str + "' in isolated process!");
            return true;
        }
        return false;
    }

    /* renamed from: b */
    public static void m1568b() {
        synchronized (C1500b.f2715e) {
            if (C1500b.f2717g && C1500b.f2716f) {
                if (C1500b.f2712b) {
                    C1491a.m1923b("Has enabled native log!");
                    return;
                }
                m1566c();
                C1503e.m1708D();
                C1500b.f2712b = true;
                JNIBridge.cmd(6);
                C1509g.m1495d();
            }
        }
    }

    /* renamed from: b */
    public static void m1567b(Context context) {
        try {
            if (f2819d) {
                return;
            }
            C1497g.m1880a(context);
            C1490a.f2594a = context.getPackageName();
            f2819d = true;
        } catch (Throwable th) {
            m1569a(th);
        }
    }

    /* renamed from: c */
    public static void m1566c() {
        if (C1500b.f2714d) {
            return;
        }
        C1509g.m1499b();
        JNIBridge.cmd(5);
        C1509g.m1497c();
        C1500b.f2714d = true;
    }

    public static synchronized CrashApi createInstance(Context context, CustomInfo customInfo, VersionInfo versionInfo, ICrashClient iCrashClient, boolean z, boolean z2, boolean z3) {
        CrashApi crashApi;
        synchronized (CrashApi.class) {
            if (f2817a == null) {
                f2817a = new CrashApi(context, customInfo, versionInfo, iCrashClient, z, z2, z3);
            }
            crashApi = f2817a;
        }
        return crashApi;
    }

    public static CrashApi createInstanceEx(Context context, String str, boolean z) {
        return createInstanceEx(context, str, z, null);
    }

    public static CrashApi createInstanceEx(Context context, String str, boolean z, Bundle bundle) {
        return createInstanceEx(context, str, z, bundle, null);
    }

    public static CrashApi createInstanceEx(Context context, String str, boolean z, Bundle bundle, ICrashClient iCrashClient) {
        CrashApi crashApi = f2817a;
        if (crashApi != null) {
            return crashApi;
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        f2818c = bundle.getBoolean("useApplicationContext", true);
        Context m1572a = m1572a(context);
        m1567b(m1572a);
        CustomInfo customInfo = new CustomInfo(str);
        customInfo.mEnableStatReport = false;
        customInfo.mZipLog = true;
        customInfo.mPrintStackInfos = z;
        bundle.putString("crver", "2.0");
        CustomInfo m1507a = C1509g.m1507a(customInfo, bundle);
        VersionInfo m1509a = C1509g.m1509a(bundle);
        boolean z2 = bundle.getBoolean(UMCrash.KEY_ENABLE_CRASH_JAVA, true);
        boolean z3 = bundle.getBoolean(UMCrash.KEY_ENABLE_CRASH_NATIVE, true);
        boolean z4 = bundle.getBoolean(UMCrash.KEY_ENABLE_CRASH_UNEXP, C1500b.m1791F());
        boolean z5 = bundle.getBoolean(UMCrash.KEY_ENABLE_ANR, true);
        CrashApi createInstance = createInstance(m1572a, m1507a, m1509a, iCrashClient, z2, z3, z4);
        C1500b.m1764a(z5);
        if (z3 || z4) {
            if (C1503e.m1622e("libcrashsdk.so")) {
                createInstance.crashSoLoaded();
            } else {
                C1491a.m1920d("crashsdk", "load libcrashsdk.so failed!");
            }
        }
        int i = bundle.getInt("uploadLogDelaySeconds", 15);
        if (i >= 0 && C1500b.m1791F()) {
            C1503e.m1650b(i);
        }
        createInstance.disableLog(268435456);
        return createInstance;
    }

    public static CrashApi getInstance() {
        return f2817a;
    }

    public int addCachedInfo(String str, String str2) {
        if (str == null || str2 == null) {
            throw null;
        }
        return C1490a.m1943b(str, str2);
    }

    public int addDumpFile(DumpFileInfo dumpFileInfo) {
        String str;
        if (dumpFileInfo != null) {
            String str2 = dumpFileInfo.mCategory;
            if (str2 == null || (str = dumpFileInfo.mFileTobeDump) == null) {
                throw null;
            }
            int i = dumpFileInfo.mLogType;
            if ((1048849 & i) != 0) {
                return C1490a.m1951a(str2, str, dumpFileInfo.mIsEncrypted, dumpFileInfo.mWriteCategory, i, dumpFileInfo.mDeleteAfterDump);
            }
            return 0;
        }
        throw null;
    }

    public int addDumpFile(String str, String str2, int i, Bundle bundle) {
        DumpFileInfo dumpFileInfo = new DumpFileInfo(str, str2, i);
        if (bundle != null) {
            dumpFileInfo.mIsEncrypted = bundle.getBoolean("mIsEncrypted", dumpFileInfo.mIsEncrypted);
            dumpFileInfo.mWriteCategory = bundle.getBoolean("mWriteCategory", dumpFileInfo.mWriteCategory);
            dumpFileInfo.mDeleteAfterDump = bundle.getBoolean("mDeleteAfterDump", dumpFileInfo.mDeleteAfterDump);
        }
        return addDumpFile(dumpFileInfo);
    }

    public void addHeaderInfo(String str, String str2) {
        if (str != null) {
            C1490a.m1952a(str, str2);
            return;
        }
        throw null;
    }

    public boolean addStatInfo(String str, String str2) {
        if (m1570a("addStatInfo")) {
            return false;
        }
        if (C1497g.m1872a(str)) {
            throw null;
        }
        if (str.length() > 24) {
            throw new IllegalArgumentException("key is too long!");
        }
        if (str2 != null && str2.length() > 512) {
            str2 = str2.substring(0, 512);
        }
        return C1498h.m1836a(str, str2);
    }

    public void crashSoLoaded() {
        if (m1570a("crashSoLoaded")) {
            return;
        }
        C1500b.f2716f = true;
        m1568b();
        synchronized (C1500b.f2715e) {
            if (C1500b.f2718h && C1500b.f2716f && !C1500b.f2713c) {
                if (!C1500b.f2714d) {
                    m1566c();
                    C1509g.m1495d();
                }
                C1503e.m1580x();
                C1500b.f2713c = true;
            }
        }
        C1490a.m1929n();
        C1503e.m1598m();
    }

    public int createCachedInfo(String str, int i, int i2) {
        if (str != null) {
            if (i <= 0) {
                throw new IllegalArgumentException("capacity must > 0!");
            }
            if ((1048849 & i2) != 0) {
                return C1490a.m1954a(str, i, i2);
            }
            return 0;
        }
        throw null;
    }

    public void disableLog(int i) {
        synchronized (C1500b.f2715e) {
            C1500b.m1756b(i);
            if (LogType.isForJava(i) && C1500b.f2700a) {
                C1503e.m1584t();
                C1500b.f2700a = false;
            }
            if (LogType.isForNative(i)) {
                if (C1500b.f2712b) {
                    JNIBridge.cmd(9);
                    C1500b.f2712b = false;
                } else {
                    C1500b.f2717g = false;
                }
            }
            if (LogType.isForANR(i)) {
                C1500b.m1764a(false);
            }
            if (LogType.isForUnexp(i)) {
                if (!C1500b.f2713c) {
                    C1500b.f2718h = false;
                } else if (C1503e.m1578z()) {
                    C1500b.f2713c = false;
                }
            }
        }
    }

    public boolean generateCustomLog(CustomLogInfo customLogInfo) {
        String str;
        StringBuilder sb;
        String str2 = null;
        if (customLogInfo != null) {
            if (customLogInfo.mData == null || (str = customLogInfo.mLogType) == null) {
                throw new NullPointerException("mData or mLogType is null!");
            }
            if (str.contains("_") || customLogInfo.mLogType.contains(StringUtils.SPACE)) {
                throw new IllegalArgumentException("mLogType can not contain char '_' and ' '");
            }
            ArrayList<Integer> arrayList = customLogInfo.mDumpTids;
            if (arrayList == null || arrayList.size() <= 0) {
                sb = null;
            } else {
                sb = new StringBuilder();
                Iterator<Integer> it = customLogInfo.mDumpTids.iterator();
                while (it.hasNext()) {
                    sb.append(it.next().intValue());
                    sb.append(StringUtils.SPACE);
                }
            }
            long j = 0;
            if (customLogInfo.mAddHeader) {
                j = 1;
            }
            if (customLogInfo.mAddFooter) {
                j |= 2;
            }
            if (customLogInfo.mAddLogcat) {
                j |= 4;
            }
            if (customLogInfo.mAddThreadsDump) {
                j |= 8;
            }
            if (customLogInfo.mAddBuildId) {
                j |= 16;
            }
            if (customLogInfo.mUploadNow) {
                j |= 32;
            }
            long j2 = j;
            StringBuffer stringBuffer = customLogInfo.mData;
            String str3 = customLogInfo.mLogType;
            ArrayList<String> arrayList2 = customLogInfo.mDumpFiles;
            ArrayList<String> arrayList3 = customLogInfo.mCallbacks;
            ArrayList<String> arrayList4 = customLogInfo.mCachedInfos;
            if (sb != null) {
                str2 = sb.toString();
            }
            return C1503e.m1663a(stringBuffer, str3, j2, arrayList2, arrayList3, arrayList4, str2);
        }
        throw null;
    }

    public boolean generateCustomLog(StringBuffer stringBuffer, String str, Bundle bundle) {
        CustomLogInfo customLogInfo = new CustomLogInfo(stringBuffer, str);
        if (bundle != null) {
            customLogInfo.mAddHeader = bundle.getBoolean("mAddHeader", customLogInfo.mAddHeader);
            customLogInfo.mAddFooter = bundle.getBoolean("mAddFooter", customLogInfo.mAddFooter);
            customLogInfo.mAddLogcat = bundle.getBoolean("mAddLogcat", customLogInfo.mAddLogcat);
            customLogInfo.mUploadNow = bundle.getBoolean("mUploadNow", customLogInfo.mUploadNow);
            customLogInfo.mAddThreadsDump = bundle.getBoolean("mAddThreadsDump", customLogInfo.mAddThreadsDump);
            customLogInfo.mAddBuildId = bundle.getBoolean("mAddBuildId", customLogInfo.mAddBuildId);
            customLogInfo.mDumpFiles = bundle.getStringArrayList("mDumpFiles");
            customLogInfo.mCallbacks = bundle.getStringArrayList("mCallbacks");
            customLogInfo.mCachedInfos = bundle.getStringArrayList("mCachedInfos");
            customLogInfo.mDumpTids = bundle.getIntegerArrayList("mDumpTids");
        }
        return generateCustomLog(customLogInfo);
    }

    public boolean generateTraces(String str, long j) {
        if (m1570a("generateTraces")) {
            return false;
        }
        if (C1500b.f2714d) {
            return JNIBridge.nativeCmd(12, j, str, null) == 1;
        }
        C1491a.m1920d("crashsdk", "Crash so is not loaded!");
        return false;
    }

    public String getCrashLogUploadUrl() {
        if (m1570a("getCrashLogUploadUrl")) {
            return null;
        }
        return C1503e.m1602k();
    }

    public ParcelFileDescriptor getHostFd() {
        return C1503e.m1707E();
    }

    public ParcelFileDescriptor getIsolatedHostFd() {
        return C1503e.m1707E();
    }

    public int getLastExitType() {
        if (m1570a("getLastExitType")) {
            return 1;
        }
        return C1500b.m1788I();
    }

    public int getLastExitTypeEx() {
        if (m1570a("getLastExitTypeEx")) {
            return 1;
        }
        return C1500b.m1787J();
    }

    public Throwable getUncaughtException() {
        return C1503e.m1582v();
    }

    public int getUnexpReason() {
        if (m1570a("getUnexpReason")) {
            return 100;
        }
        return C1503e.m1581w();
    }

    public void onExit() {
        C1500b.m1727w();
    }

    public boolean registerCallback(int i, ValueCallback<Bundle> valueCallback) {
        if (valueCallback != null) {
            if (i == 1) {
                return C1502d.m1721a(valueCallback);
            }
            if (i == 2) {
                return C1502d.m1713c(valueCallback);
            }
            if (i == 3) {
                return C1502d.m1712d(valueCallback);
            }
            if (i == 4) {
                return C1502d.m1714b(valueCallback);
            }
            throw new IllegalArgumentException("Unknown event type: " + i);
        }
        throw null;
    }

    public int registerInfoCallback(String str, int i) {
        if (str != null) {
            if ((1048849 & i) != 0) {
                return C1490a.m1953a(str, i, null, 0L, 0);
            }
            return 0;
        }
        throw null;
    }

    public int registerInfoCallback(String str, int i, Callable<String> callable) {
        if (str == null || callable == null) {
            throw null;
        }
        if ((1048849 & i) != 0) {
            return C1490a.m1953a(str, i, callable, 0L, 0);
        }
        return 0;
    }

    public int registerThread(int i, String str) {
        return C1490a.m1960a(i, str);
    }

    public int reportCrashStats(boolean z) {
        if (m1570a("reportCrashStats")) {
            return 0;
        }
        if (C1509g.m1524M()) {
            C1491a.m1926a("CrashApi::reportCrashStats. currentProcessOnly: " + z);
        }
        C1503e.m1626d(z);
        return C1503e.m1621e(z);
    }

    public int resetCrashStats(boolean z) {
        if (m1570a("resetCrashStats")) {
            return 0;
        }
        if (C1509g.m1524M()) {
            C1491a.m1926a("CrashApi::resetCrashStats. currentProcessOnly: " + z);
        }
        return C1503e.m1616f(z);
    }

    public void setForeground(boolean z) {
        C1500b.m1753b(z);
    }

    public boolean setHostFd(ParcelFileDescriptor parcelFileDescriptor) {
        return C1503e.m1681a(parcelFileDescriptor);
    }

    public boolean setIsolatedHostFd(ParcelFileDescriptor parcelFileDescriptor) {
        return C1503e.m1681a(parcelFileDescriptor);
    }

    public void setNewInstall() {
        if (m1570a("setNewInstall")) {
            return;
        }
        C1500b.m1728v();
    }

    public int updateCustomInfo(Bundle bundle) {
        if (bundle != null) {
            return updateCustomInfo(C1509g.m1507a((CustomInfo) null, bundle));
        }
        throw null;
    }

    public int updateCustomInfo(CustomInfo customInfo) {
        if (customInfo != null) {
            return C1509g.m1498b(customInfo);
        }
        throw null;
    }

    public boolean updateUnexpInfo() {
        if (m1570a("updateUnexpInfo")) {
            return false;
        }
        return C1490a.m1947a(true);
    }

    public void updateVersionInfo(Bundle bundle) {
        if (bundle != null) {
            updateVersionInfo(C1509g.m1509a(bundle));
            return;
        }
        throw null;
    }

    public void updateVersionInfo(VersionInfo versionInfo) {
        if (versionInfo != null) {
            C1509g.m1505a(versionInfo);
            return;
        }
        throw null;
    }

    public void uploadCrashLogs() {
        if (m1570a("uploadCrashLogs")) {
            return;
        }
        C1503e.m1655a(false, true);
    }
}
