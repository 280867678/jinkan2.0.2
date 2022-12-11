package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.multidex.MultiDexExtractor;
import com.stub.StubApp;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.smtt.utils.C1428a;
import com.tencent.smtt.utils.C1429b;
import com.tencent.smtt.utils.C1472q;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import me.tvspark.outline;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes4.dex */
public class TbsShareManager {

    /* renamed from: a */
    public static Context f1946a = null;

    /* renamed from: b */
    public static boolean f1947b = false;

    /* renamed from: c */
    public static String f1948c = null;

    /* renamed from: d */
    public static String f1949d = "";

    /* renamed from: e */
    public static String f1950e;

    /* renamed from: f */
    public static int f1951f;

    /* renamed from: g */
    public static String f1952g;

    /* renamed from: h */
    public static boolean f1953h;

    /* renamed from: i */
    public static boolean f1954i;

    /* renamed from: j */
    public static boolean f1955j;

    /* renamed from: k */
    public static String f1956k;

    /* renamed from: l */
    public static boolean f1957l;

    /* renamed from: m */
    public static boolean f1958m;
    public static boolean mHasQueryed;

    /* renamed from: a */
    public static int m2734a(Context context, String str, int i) {
        File file;
        try {
            file = new File(new File(FileUtil.m2198a(getPackageContext(context, str, false), i)), TbsDownloader.getBackupFileName(false));
        } catch (Throwable unused) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("getSDCoreVersion exception,pkg=", str, ", SDCardStatus: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(C1429b.m2109l(context));
            TbsLog.m2155i("TbsShareManager", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
        if (!file.exists() || !file.canRead()) {
            TbsLog.m2155i("TbsShareManager", "getSDCoreVersion,file not exist" + file);
            return 0;
        }
        return C1428a.m2131b(file);
    }

    /* renamed from: a */
    public static int m2733a(Context context, boolean z) {
        m2731b(context, z);
        return f1951f;
    }

    /* renamed from: a */
    public static String m2738a() {
        return f1950e;
    }

    /* renamed from: a */
    public static void m2737a(Context context) {
        TbsLog.m2155i("TbsShareManager", "shareTbsCore #1");
        try {
            TbsLinuxToolsJni tbsLinuxToolsJni = new TbsLinuxToolsJni(context);
            m2735a(context, tbsLinuxToolsJni, C1381p.m2503a().m2437r(context));
            File m2436s = C1381p.m2503a().m2436s(context);
            TbsLog.m2155i("TbsShareManager", "shareTbsCore tbsShareDir is " + m2436s.getAbsolutePath());
            tbsLinuxToolsJni.m2781a(m2436s.getAbsolutePath(), "755");
        } catch (Throwable th) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("shareTbsCore tbsShareDir error is ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(th.getMessage());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" ## ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(th.getCause());
            TbsLog.m2155i("TbsShareManager", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
    }

    /* renamed from: a */
    public static void m2736a(Context context, int i) {
        String str;
        String str2;
        File stableCoreFile;
        StringBuilder sb;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (TbsPVConfig.getInstance(f1946a).isDisableHostBackupCore()) {
            str = "installCoreWithUnzip do nothing #1";
        } else if (C1381p.m2503a().m2434u(context)) {
            int i2 = 5;
            String[] strArr = {TbsConfig.APP_DEMO, TbsConfig.APP_WX, TbsConfig.APP_QQ, TbsConfig.APP_QZONE, context.getPackageName()};
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("find host backup core to unzip #1");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Log.getStackTraceString(new Throwable()));
            TbsLog.m2155i("TbsShareManager", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            int i3 = 0;
            while (i3 < i2) {
                String str3 = strArr[i3];
                int backupCoreVersion = getBackupCoreVersion(context, str3);
                String str4 = "";
                String[] strArr2 = strArr;
                int i4 = i3;
                if (i != backupCoreVersion) {
                    TbsLog.m2155i("TbsShareManager", "installCoreWithUnzip getBackupCoreVersion fail, packageName is " + str3 + " result version is " + backupCoreVersion);
                    int backupDecoupleCoreVersion = getBackupDecoupleCoreVersion(context, str3);
                    if (i == backupDecoupleCoreVersion) {
                        TbsLog.m2155i("TbsShareManager", "installCoreWithUnzip getBackupDecoupleCoreVersion ok, packageName is " + str3 + " result version is " + backupDecoupleCoreVersion);
                        if (!C1381p.m2503a().m2453g(getPackageContext(context, str3, false))) {
                            continue;
                        } else {
                            stableCoreFile = getBackupDecoupleCoreFile(context, str3);
                            if (C1428a.m2137a(context, stableCoreFile, 0L, i)) {
                                TbsLog.m2155i("TbsShareManager", "find host backup core to unzip decouple coreVersion is " + i + " packageName is " + str3);
                                try {
                                    str4 = str3.substring(str3.length() - 2);
                                } catch (Throwable th) {
                                    outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("throwable is "), TbsDownloader.LOGTAG);
                                }
                                C1472q.m1985a("7is" + i + str4);
                                sb = new StringBuilder();
                            }
                        }
                        i3 = i4 + 1;
                        i2 = 5;
                        strArr = strArr2;
                    } else {
                        TbsLog.m2155i("TbsShareManager", "installCoreWithUnzip getBackupDecoupleCoreVersion fail, packageName is " + str3 + " result version is " + backupDecoupleCoreVersion);
                        int stableCoreVersion = getStableCoreVersion(context, str3);
                        if (i == stableCoreVersion) {
                            TbsLog.m2155i("TbsShareManager", "installCoreWithUnzip getStableCoreVersion ok, packageName is " + str3 + " result version is " + stableCoreVersion);
                            if (C1381p.m2503a().m2453g(getPackageContext(context, str3, false))) {
                                stableCoreFile = getStableCoreFile(context, str3);
                                if (C1428a.m2137a(context, stableCoreFile, 0L, i)) {
                                    TbsLog.m2155i("TbsShareManager", "find host backup core to unzip normal coreVersion is " + i + " packageName is " + str3);
                                    try {
                                        str4 = str3.substring(str3.length() - 2);
                                    } catch (Throwable th2) {
                                        outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th2, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("throwable is "), TbsDownloader.LOGTAG);
                                    }
                                    C1472q.m1985a("7is" + i + str4);
                                    sb = new StringBuilder();
                                }
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("find host backup core to unzip,verify apk failed,pkgName=", str3, ";apk=");
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(stableCoreFile.getAbsolutePath());
                                str2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
                            }
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("find host backup core to unzip,verify app failed,pkgName=", str3);
                            str2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
                        } else {
                            str2 = "installCoreWithUnzip getBackupCoreVersion fail, packageName is " + str3 + " result version is " + stableCoreVersion;
                        }
                    }
                    sb.append("coreVersionIs");
                    sb.append(i);
                    C1472q.m1986a(f1946a, "copy_host_core_v2", sb.toString());
                    C1381p.m2503a().m2476b(context, stableCoreFile, i);
                    break;
                }
                TbsLog.m2155i("TbsShareManager", "installCoreWithUnzip getBackupCoreVersion ok, packageName is " + str3 + " result version is " + backupCoreVersion);
                if (C1381p.m2503a().m2453g(getPackageContext(context, str3, false))) {
                    stableCoreFile = getBackupCoreFile(context, str3);
                    if (C1428a.m2137a(context, stableCoreFile, 0L, i)) {
                        TbsLog.m2155i("TbsShareManager", "find host backup core to unzip normal coreVersion is " + i + " packageName is " + str3);
                        try {
                            str4 = str3.substring(str3.length() - 2);
                        } catch (Throwable th3) {
                            outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th3, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("throwable is "), TbsDownloader.LOGTAG);
                        }
                        C1472q.m1985a("7is" + i + str4);
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("coreVersionIs");
                        sb2.append(i);
                        C1472q.m1986a(f1946a, "copy_host_core_v2", sb2.toString());
                        C1381p.m2503a().m2476b(context, stableCoreFile, i);
                        break;
                    }
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("find host backup core to unzip,verify apk failed,pkgName=", str3, ";apk=");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(stableCoreFile.getAbsolutePath());
                    str2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("find host backup core to unzip,verify app failed,pkgName=", str3);
                str2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
                TbsLog.m2155i("TbsShareManager", str2);
                i3 = i4 + 1;
                i2 = 5;
                strArr = strArr2;
            }
            C1381p.m2503a().m2482b();
            return;
        } else {
            str = "installCoreWithUnzip do nothing #2";
        }
        TbsLog.m2155i("TbsShareManager", str);
    }

    /* renamed from: a */
    public static void m2735a(Context context, TbsLinuxToolsJni tbsLinuxToolsJni, File file) {
        File[] listFiles;
        TbsLog.m2155i("TbsShareManager", "shareAllDirsAndFiles #1");
        if (file == null || !file.exists() || !file.isDirectory()) {
            return;
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("shareAllDirsAndFiles dir is ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(file.getAbsolutePath());
        TbsLog.m2155i("TbsShareManager", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        tbsLinuxToolsJni.m2781a(file.getAbsolutePath(), "755");
        for (File file2 : file.listFiles()) {
            if (file2.isFile()) {
                int indexOf = file2.getAbsolutePath().indexOf(".so");
                String absolutePath = file2.getAbsolutePath();
                if (indexOf > 0) {
                    tbsLinuxToolsJni.m2781a(absolutePath, "755");
                } else {
                    tbsLinuxToolsJni.m2781a(absolutePath, "644");
                }
            } else if (file2.isDirectory()) {
                m2735a(context, tbsLinuxToolsJni, file2);
            } else {
                TbsLog.m2156e("TbsShareManager", "unknown file type.", true);
            }
        }
    }

    /* renamed from: b */
    public static void m2732b(Context context) {
        try {
            m2735a(context, new TbsLinuxToolsJni(context), C1381p.m2503a().m2438q(context));
        } catch (Throwable th) {
            TbsLog.m2152i(th);
        }
    }

    /* renamed from: b */
    public static boolean m2731b(Context context, boolean z) {
        if (m2722i(context)) {
            return true;
        }
        if (!z) {
            return false;
        }
        QbSdk.m2833a(context, "TbsShareManager::isShareTbsCoreAvailable forceSysWebViewInner!");
        return false;
    }

    /* renamed from: c */
    public static String m2730c(Context context) {
        m2721j(context);
        return f1950e;
    }

    /* renamed from: c */
    public static void m2729c(Context context, boolean z) {
        BufferedOutputStream bufferedOutputStream;
        File tbsShareFile;
        BufferedInputStream bufferedInputStream = null;
        try {
            tbsShareFile = getTbsShareFile(context, "core_info");
        } catch (Throwable th) {
            th = th;
            bufferedOutputStream = null;
        }
        if (tbsShareFile == null) {
            return;
        }
        BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(tbsShareFile));
        try {
            Properties properties = new Properties();
            properties.load(bufferedInputStream2);
            properties.setProperty("core_disabled", String.valueOf(false));
            if (z) {
                String absolutePath = C1381p.m2503a().m2437r(context).getAbsolutePath();
                String packageName = StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageName();
                int m2116e = C1429b.m2116e(context);
                properties.setProperty("core_packagename", packageName);
                properties.setProperty("core_path", absolutePath);
                properties.setProperty("app_version", String.valueOf(m2116e));
            }
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(tbsShareFile));
            try {
                properties.store(bufferedOutputStream, (String) null);
                try {
                    bufferedInputStream2.close();
                } catch (Exception unused) {
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedInputStream = bufferedInputStream2;
                try {
                    th.printStackTrace();
                    if (bufferedOutputStream == null) {
                        return;
                    }
                    bufferedOutputStream.close();
                } finally {
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (Exception unused2) {
                        }
                    }
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (Exception unused3) {
                        }
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedOutputStream = null;
        }
        try {
            bufferedOutputStream.close();
        } catch (Exception unused4) {
        }
    }

    /* renamed from: d */
    public static int m2728d(Context context) {
        return m2733a(context, true);
    }

    /* renamed from: d */
    public static String[] m2727d(Context context, boolean z) {
        if (QbSdk.getOnlyDownload()) {
            return new String[]{StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageName()};
        }
        return z ? new String[]{StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageName()} : getCoreProviderAppList();
    }

    /* renamed from: e */
    public static Context m2726e(Context context) {
        m2721j(context);
        String str = f1952g;
        Context context2 = null;
        if (str != null) {
            Context packageContext = getPackageContext(context, str, true);
            if (C1381p.m2503a().m2453g(packageContext)) {
                context2 = packageContext;
            }
        }
        return f1948c != null ? f1946a : context2;
    }

    /* renamed from: f */
    public static synchronized String m2725f(Context context) {
        BufferedInputStream bufferedInputStream;
        synchronized (TbsShareManager.class) {
            try {
                File tbsShareFile = getTbsShareFile(context, "core_info");
                if (tbsShareFile == null) {
                    return null;
                }
                bufferedInputStream = new BufferedInputStream(new FileInputStream(tbsShareFile));
                try {
                    Properties properties = new Properties();
                    properties.load(bufferedInputStream);
                    String property = properties.getProperty("core_packagename", "");
                    if (!"".equals(property)) {
                        try {
                            bufferedInputStream.close();
                        } catch (Exception unused) {
                        }
                        return property;
                    }
                    try {
                        bufferedInputStream.close();
                    } catch (Exception unused2) {
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    th.printStackTrace();
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (Exception unused3) {
                        }
                    }
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedInputStream = null;
            }
        }
    }

    public static int findCoreForThirdPartyApp(Context context) {
        String str;
        m2717n(context);
        TbsLog.m2154i("TbsShareManager", "findCoreForThirdPartyApp", "core_info mAvailableCoreVersion is " + f1951f + " mAvailableCorePath is " + f1950e + " mSrcPackageName is " + f1952g);
        String str2 = f1952g;
        if (str2 == null || !str2.equals("AppDefined")) {
            if (!m2720k(context) && !m2719l(context)) {
                f1951f = 0;
                f1950e = null;
                f1952g = null;
                str = "checkCoreInfo is false and checkCoreInOthers is false ";
                TbsLog.m2147w("TbsShareManager", "findCoreForThirdPartyApp", str);
            }
        } else if (f1951f != C1381p.m2503a().m2484a(f1948c)) {
            f1951f = 0;
            f1950e = null;
            f1952g = null;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("check AppDefined core is error src is ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(f1951f);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" dest is ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(C1381p.m2503a().m2484a(f1948c));
            str = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
            TbsLog.m2147w("TbsShareManager", "findCoreForThirdPartyApp", str);
        }
        if (f1951f > 0 && f1953h) {
            f1951f = 0;
            f1950e = null;
            f1952g = null;
            TbsLog.m2154i("TbsShareManager", "findCoreForThirdPartyApp", "mCoreDisabled");
        }
        return f1951f;
    }

    public static boolean forceLoadX5FromTBSDemo(Context context) {
        int sharedTbsCoreVersion;
        if (context == null || C1381p.m2503a().m2489a(context, (File[]) null) || (sharedTbsCoreVersion = getSharedTbsCoreVersion(context, TbsConfig.APP_DEMO)) <= 0) {
            return false;
        }
        writeProperties(context, Integer.toString(sharedTbsCoreVersion), TbsConfig.APP_DEMO, C1381p.m2503a().m2437r(getPackageContext(context, TbsConfig.APP_DEMO, true)).getAbsolutePath(), "1");
        return true;
    }

    public static void forceToLoadX5ForThirdApp(Context context, boolean z) {
        File m2436s;
        int m2484a;
        try {
            if (!QbSdk.isNeedInitX5FirstTime() || !isThirdPartyApp(context) || QbSdk.getOnlyDownload() || (m2436s = C1381p.m2503a().m2436s(context)) == null) {
                return;
            }
            if (z && new File(m2436s, "core_info").exists()) {
                return;
            }
            if (f1948c != null && (m2484a = C1381p.m2503a().m2484a(f1948c)) > 0) {
                f1950e = f1948c;
                f1952g = "AppDefined";
                f1951f = m2484a;
                TbsLog.m2155i("TbsShareManager", "forceToLoadX5ForThirdApp #1 -- mAvailableCoreVersion: " + f1951f + StringUtils.SPACE + Log.getStackTraceString(new Throwable("#")));
                writeProperties(context, Integer.toString(f1951f), f1952g, f1950e, Integer.toString(1));
                return;
            }
            TbsLog.m2155i("TbsShareManager", "forceToLoadX5ForThirdApp #1");
            int m2723h = m2723h(context);
            int m2446j = C1381p.m2503a().m2446j(context);
            TbsLog.m2155i("TbsShareManager", "forceToLoadX5ForThirdApp coreVersionFromConfig is " + m2723h);
            TbsLog.m2155i("TbsShareManager", "forceToLoadX5ForThirdApp coreVersionFromCoreShare is " + m2446j);
            String[] coreProviderAppList = getCoreProviderAppList();
            for (String str : coreProviderAppList) {
                int coreShareDecoupleCoreVersion = getCoreShareDecoupleCoreVersion(context, str);
                if (coreShareDecoupleCoreVersion >= m2723h && coreShareDecoupleCoreVersion >= m2446j && coreShareDecoupleCoreVersion > 0) {
                    f1950e = C1381p.m2503a().m2470c(context, getPackageContext(context, str, true)).getAbsolutePath();
                    f1952g = str;
                    f1951f = coreShareDecoupleCoreVersion;
                    TbsLog.m2155i("TbsShareManager", "forceToLoadX5ForThirdApp #2 -- mAvailableCoreVersion: " + f1951f + StringUtils.SPACE + Log.getStackTraceString(new Throwable("#")));
                    if (QbSdk.canLoadX5FirstTimeThirdApp(context)) {
                        int m2116e = C1429b.m2116e(context);
                        TbsLog.m2155i("TbsShareManager", "forceToLoadX5ForThirdApp #2");
                        writeProperties(context, Integer.toString(f1951f), f1952g, f1950e, Integer.toString(m2116e));
                        return;
                    }
                    f1951f = 0;
                    f1950e = null;
                    f1952g = null;
                }
            }
            for (String str2 : coreProviderAppList) {
                int sharedTbsCoreVersion = getSharedTbsCoreVersion(context, str2);
                if (sharedTbsCoreVersion >= m2723h && sharedTbsCoreVersion >= m2446j && sharedTbsCoreVersion > 0) {
                    f1950e = C1381p.m2503a().m2479b(context, getPackageContext(context, str2, true)).getAbsolutePath();
                    f1952g = str2;
                    f1951f = sharedTbsCoreVersion;
                    TbsLog.m2155i("TbsShareManager", "forceToLoadX5ForThirdApp #3 -- mAvailableCoreVersion: " + f1951f + StringUtils.SPACE + Log.getStackTraceString(new Throwable("#")));
                    if (QbSdk.canLoadX5FirstTimeThirdApp(context)) {
                        writeProperties(context, Integer.toString(f1951f), f1952g, f1950e, Integer.toString(C1429b.m2116e(context)));
                        return;
                    }
                    f1951f = 0;
                    f1950e = null;
                    f1952g = null;
                }
            }
            if (TbsPVConfig.getInstance(f1946a).isDisableHostBackupCore()) {
                return;
            }
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                TbsLog.m2155i("TbsShareManager", "in mainthread so do not find host backup core to install ");
                return;
            }
            for (String str3 : coreProviderAppList) {
                int backupCoreVersion = getBackupCoreVersion(context, str3);
                if (backupCoreVersion >= m2723h && backupCoreVersion >= m2446j && backupCoreVersion > 0) {
                    TbsLog.m2155i("TbsShareManager", "find host backup core to unzip forceload coreVersion is " + backupCoreVersion + " packageName is " + str3);
                    C1381p.m2503a().m2494a(context, getBackupCoreFile(context, str3), backupCoreVersion);
                    TbsLog.m2155i("TbsShareManager", "find host backup core to unzip forceload after unzip ");
                    return;
                }
                int backupDecoupleCoreVersion = getBackupDecoupleCoreVersion(context, str3);
                if (backupDecoupleCoreVersion >= m2723h && backupDecoupleCoreVersion >= m2446j && backupDecoupleCoreVersion > 0) {
                    TbsLog.m2155i("TbsShareManager", "find host backup core to unzip forceload decouple coreVersion is " + backupDecoupleCoreVersion + " packageName is " + str3);
                    C1381p.m2503a().m2494a(context, getBackupCoreFile(context, str3), backupDecoupleCoreVersion);
                    TbsLog.m2155i("TbsShareManager", "find host backup decouple core to unzip forceload after unzip ");
                    return;
                }
                int stableCoreVersion = getStableCoreVersion(context, str3);
                if (stableCoreVersion >= m2723h && stableCoreVersion >= m2446j && stableCoreVersion > 0) {
                    TbsLog.m2155i("TbsShareManager", "find host stable core to unzip forceload coreVersion is " + stableCoreVersion + " packageName is " + str3);
                    C1381p.m2503a().m2494a(context, getStableCoreFile(context, str3), stableCoreVersion);
                    TbsLog.m2155i("TbsShareManager", "find host stable core to unzip forceload after unzip ");
                    return;
                }
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: g */
    public static String m2724g(Context context) {
        try {
            m2717n(context);
            if (f1950e != null && !TextUtils.isEmpty(f1950e)) {
                return f1950e + File.separator + "res.apk";
            }
            return null;
        } catch (Throwable th) {
            Log.getStackTraceString(th);
            return null;
        }
    }

    public static File getBackupCoreFile(Context context, String str) {
        return getSDCoreFile(context, str, 3);
    }

    public static int getBackupCoreVersion(Context context, String str) {
        return m2734a(context, str, 3);
    }

    public static File getBackupDecoupleCoreFile(Context context, String str) {
        try {
            File file = new File(new File(FileUtil.m2198a(getPackageContext(context, str, false), 4)), TbsDownloader.getBackupFileName(true));
            if (!file.exists()) {
                return null;
            }
            return file;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int getBackupDecoupleCoreVersion(Context context, String str) {
        try {
            File file = new File(new File(FileUtil.m2198a(getPackageContext(context, str, false), 4)), TbsDownloader.getBackupFileName(true));
            if (file.exists() && file.canRead()) {
                return C1428a.m2131b(file);
            }
        } catch (Throwable unused) {
            TbsLog.m2155i("TbsShareManager", "getBackupDecoupleCoreVersion exception,pkg=" + str + ",package not found.");
        }
        return 0;
    }

    public static boolean getCoreDisabled() {
        return f1953h;
    }

    public static boolean getCoreFormOwn() {
        return f1957l;
    }

    public static String[] getCoreProviderAppList() {
        return new String[]{TbsConfig.APP_DEMO, TbsConfig.APP_WX, TbsConfig.APP_QQ, TbsConfig.APP_QZONE, "com.tencent.qqlite"};
    }

    public static int getCoreShareDecoupleCoreVersion(Context context, String str) {
        Context packageContext = getPackageContext(context, str, true);
        if (packageContext != null) {
            return C1381p.m2503a().m2448i(packageContext);
        }
        return 0;
    }

    public static String getHostCorePathAppDefined() {
        return f1948c;
    }

    public static long getHostCoreVersions(Context context) {
        String[] coreProviderAppList;
        long sharedTbsCoreVersion;
        long j;
        long j2 = 0;
        for (String str : getCoreProviderAppList()) {
            if (str.equalsIgnoreCase(TbsConfig.APP_WX)) {
                sharedTbsCoreVersion = getSharedTbsCoreVersion(context, str);
                j = 10000000000L;
            } else if (str.equalsIgnoreCase(TbsConfig.APP_QQ)) {
                sharedTbsCoreVersion = getSharedTbsCoreVersion(context, str);
                j = 100000;
            } else {
                if (str.equalsIgnoreCase(TbsConfig.APP_QZONE)) {
                    j2 += getSharedTbsCoreVersion(context, str);
                }
            }
            j2 = (sharedTbsCoreVersion * j) + j2;
        }
        return j2;
    }

    public static Context getPackageContext(Context context, String str, boolean z) {
        if (z) {
            try {
                if (!context.getPackageName().equals(str) && !TbsConfig.APP_DEMO.equals(str) && (TbsPVConfig.getInstance(context).isEnableNoCoreGray() || Build.VERSION.SDK_INT >= 29)) {
                    return null;
                }
            } catch (Throwable unused) {
                return null;
            }
        }
        return context.createPackageContext(str, 2);
    }

    public static File getSDCoreFile(Context context, String str, int i) {
        try {
            File file = new File(new File(FileUtil.m2198a(getPackageContext(context, str, false), i)), TbsDownloader.getBackupFileName(false));
            if (!file.exists()) {
                return null;
            }
            if (!file.canRead()) {
                return null;
            }
            return file;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int getSharedTbsCoreVersion(Context context, String str) {
        Context packageContext = getPackageContext(context, str, true);
        if (packageContext != null) {
            return C1381p.m2503a().m2446j(packageContext);
        }
        return 0;
    }

    public static File getStableCoreFile(Context context, String str) {
        return getSDCoreFile(context, str, 4);
    }

    public static int getStableCoreVersion(Context context, String str) {
        return m2734a(context, str, 4);
    }

    public static String getStableCoreZeroReason() {
        return f1949d;
    }

    public static File getTbsShareFile(Context context, String str) {
        File m2436s = C1381p.m2503a().m2436s(context);
        if (m2436s == null) {
            return null;
        }
        File file = new File(m2436s, str);
        if (file.exists()) {
            return file;
        }
        try {
            file.createNewFile();
            return file;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int getTbsStableCoreVersion(Context context, int i) {
        return 0;
    }

    /* renamed from: h */
    public static synchronized int m2723h(Context context) {
        synchronized (TbsShareManager.class) {
            TbsLog.m2155i("TbsShareManager", "readCoreVersionFromConfig #1");
            BufferedInputStream bufferedInputStream = null;
            try {
                File tbsShareFile = getTbsShareFile(context, "core_info");
                if (tbsShareFile == null) {
                    TbsLog.m2155i("TbsShareManager", "readCoreVersionFromConfig #2");
                    return 0;
                }
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(tbsShareFile));
                try {
                    Properties properties = new Properties();
                    properties.load(bufferedInputStream2);
                    String property = properties.getProperty("core_version", "");
                    if ("".equals(property)) {
                        TbsLog.m2155i("TbsShareManager", "readCoreVersionFromConfig #4");
                        try {
                            bufferedInputStream2.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return 0;
                    }
                    TbsLog.m2155i("TbsShareManager", "readCoreVersionFromConfig #3");
                    int max = Math.max(Integer.parseInt(property), 0);
                    try {
                        bufferedInputStream2.close();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    return max;
                } catch (Throwable th) {
                    bufferedInputStream = bufferedInputStream2;
                    th = th;
                    th.printStackTrace();
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                    TbsLog.m2155i("TbsShareManager", "readCoreVersionFromConfig #5");
                    return -2;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    /* renamed from: i */
    public static boolean m2722i(Context context) {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("#1# mAvailableCoreVersion: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(f1951f);
        TbsLog.m2154i("TbsShareManager", "isShareTbsCoreAvailableInner", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        try {
            if (f1951f == 0) {
                findCoreForThirdPartyApp(context);
            }
            if (f1951f == 0) {
                TbsLog.m2147w("TbsShareManager", "isShareTbsCoreAvailableInner", "can not findCoreForThirdPartyApp");
                return false;
            }
            if (f1948c == null) {
                TbsLog.m2154i("TbsShareManager", "isShareTbsCoreAvailableInner", "#2# check if the installed version is online version");
                if (f1951f != 0 && getSharedTbsCoreVersion(context, f1952g) == f1951f) {
                    return true;
                }
            } else if (f1951f != 0 && C1381p.m2503a().m2484a(f1948c) == f1951f) {
                return true;
            }
            TbsLog.m2154i("TbsShareManager", "isShareTbsCoreAvailableInner", "#3# Core Resource path has been changed!");
            if (m2719l(context)) {
                return true;
            }
            TbsLog.m2154i("TbsShareManager", "isShareTbsCoreAvailableInner", "#4# Can not find core in others, mAvailableCoreVersion is " + f1951f);
            TbsCoreLoadStat tbsCoreLoadStat = TbsCoreLoadStat.getInstance();
            tbsCoreLoadStat.m2814a(context, TbsListener.ErrorCode.INFO_CORE_EXIST_NOT_LOAD, new Throwable("mAvailableCoreVersion=" + f1951f + "; mSrcPackageName=" + f1952g + "; getSharedTbsCoreVersion(ctx, mSrcPackageName) is " + getSharedTbsCoreVersion(context, f1952g) + "; getHostCoreVersions is " + getHostCoreVersions(context)));
            f1950e = null;
            f1951f = 0;
            TbsLog.m2147w("TbsShareManager", "isShareTbsCoreAvailableInner", "[share] conflict x5core cannot share");
            QbSdk.m2833a(context, "TbsShareManager::isShareTbsCoreAvailableInner forceSysWebViewInner!");
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            TbsLog.m2147w("TbsShareManager", "isShareTbsCoreAvailableInner", "final available core inner false.");
            return false;
        }
    }

    public static boolean isThirdPartyApp(Context context) {
        try {
        } catch (Throwable th) {
            TbsLog.m2152i(th);
        }
        if (f1946a == null || !f1946a.equals(StubApp.getOrigApplicationContext(context.getApplicationContext()))) {
            Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            f1946a = origApplicationContext;
            String packageName = origApplicationContext.getPackageName();
            for (String str : getCoreProviderAppList()) {
                if (packageName.equals(str)) {
                    f1947b = false;
                    return false;
                }
            }
            f1947b = true;
            return true;
        }
        return f1947b;
    }

    /* renamed from: j */
    public static boolean m2721j(Context context) {
        return m2731b(context, true);
    }

    /* renamed from: k */
    public static boolean m2720k(Context context) {
        String str;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        String str2;
        String str3 = f1952g;
        if (str3 != null) {
            if (f1951f == getSharedTbsCoreVersion(context, str3)) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("checkCoreInfo mAvailableCoreVersion is ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(f1951f);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" mSrcPackageName is ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(f1952g);
                str2 = " and return true #01";
            } else {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("checkCoreInfo mAvailableCoreVersion is ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(f1951f);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(" mSrcPackageName is ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(f1952g);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(" getSharedTbsCoreVersion(ctx, mSrcPackageName) is ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(getSharedTbsCoreVersion(context, f1952g));
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(" and return false #01");
                TbsLog.m2155i("TbsShareManager", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
                if (f1951f == getCoreShareDecoupleCoreVersion(context, f1952g)) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("checkCoreInfo mAvailableCoreVersion is ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(f1951f);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" mSrcPackageName is ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(f1952g);
                    str2 = " and return true #02";
                } else {
                    str = "checkCoreInfo return false end";
                }
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(str2);
            TbsLog.m2155i("TbsShareManager", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            return true;
        }
        str = "checkCoreInfo mSrcPackageName is null";
        TbsLog.m2155i("TbsShareManager", str);
        return false;
    }

    /* renamed from: l */
    public static boolean m2719l(Context context) {
        String str;
        File m2470c;
        if (QbSdk.getOnlyDownload()) {
            return false;
        }
        String[] coreProviderAppList = getCoreProviderAppList();
        int length = coreProviderAppList.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                int length2 = coreProviderAppList.length;
                for (int i2 = 0; i2 < length2; i2++) {
                    str = coreProviderAppList[i2];
                    int i3 = f1951f;
                    if (i3 > 0 && i3 == getCoreShareDecoupleCoreVersion(context, str)) {
                        Context packageContext = getPackageContext(context, str, true);
                        if (C1381p.m2503a().m2453g(context)) {
                            m2470c = C1381p.m2503a().m2470c(context, packageContext);
                        }
                    }
                }
                return false;
            }
            str = coreProviderAppList[i];
            int i4 = f1951f;
            if (i4 > 0 && i4 == getSharedTbsCoreVersion(context, str)) {
                Context packageContext2 = getPackageContext(context, str, true);
                if (C1381p.m2503a().m2453g(context)) {
                    m2470c = C1381p.m2503a().m2479b(context, packageContext2);
                    break;
                }
            }
            i++;
        }
        f1950e = m2470c.getAbsolutePath();
        f1952g = str;
        return true;
    }

    /* renamed from: m */
    public static boolean m2718m(Context context) {
        if (context == null) {
            return false;
        }
        writeProperties(context, Integer.toString(0), "", "", Integer.toString(0));
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x010f, code lost:
        if (r7 == null) goto L44;
     */
    /* renamed from: n */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void m2717n(Context context) {
        Throwable th;
        BufferedInputStream bufferedInputStream;
        File tbsShareFile;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("loadProperties -- core_info_already_read ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(f1958m);
        TbsLog.m2155i("TbsShareManager", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        if (f1958m) {
            return;
        }
        synchronized (TbsShareManager.class) {
            if (f1958m) {
                return;
            }
            try {
                tbsShareFile = getTbsShareFile(context, "core_info");
                TbsLog.m2155i("TbsShareManager", "loadProperties -- propFile: " + tbsShareFile);
            } catch (Throwable th2) {
                th = th2;
                bufferedInputStream = null;
            }
            if (tbsShareFile == null) {
                return;
            }
            bufferedInputStream = new BufferedInputStream(new FileInputStream(tbsShareFile));
            try {
                Properties properties = new Properties();
                properties.load(bufferedInputStream);
                String property = properties.getProperty("core_version", "");
                TbsLog.m2155i("TbsShareManager", "loadProperties -- tmp core version : " + property);
                if (!"".equals(property)) {
                    f1951f = Math.max(Integer.parseInt(property), 0);
                    TbsLog.m2155i("TbsShareManager", "loadProperties -- mAvailableCoreVersion: " + f1951f);
                }
                String property2 = properties.getProperty("core_packagename", "");
                if (!"".equals(property2)) {
                    f1952g = property2;
                }
                if (f1952g != null && f1946a != null) {
                    if (f1952g.equals(f1946a.getPackageName())) {
                        f1957l = true;
                    } else {
                        f1957l = false;
                    }
                }
                String property3 = properties.getProperty("core_path", "");
                if (!"".equals(property3)) {
                    f1950e = property3;
                }
                String property4 = properties.getProperty("app_version", "");
                if (!"".equals(property4)) {
                    f1956k = property4;
                }
                f1953h = Boolean.parseBoolean(properties.getProperty("core_disabled", "false"));
                f1958m = true;
            } catch (Throwable th3) {
                th = th3;
                th.printStackTrace();
            }
            try {
                bufferedInputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void setHostCorePathAppDefined(String str) {
        f1948c = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x052a A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized void writeCoreInfoForThirdPartyApp(Context context, int i, boolean z) {
        int sharedTbsCoreVersion;
        String substring;
        String substring2;
        synchronized (TbsShareManager.class) {
            TbsLog.m2155i("TbsShareManager", "writeCoreInfoForThirdPartyApp coreVersion is " + i);
            if (i == 0) {
                m2718m(context);
                TbsDownloadConfig.getInstance(f1946a).setDownloadInterruptCode(-401);
                return;
            }
            int m2723h = m2723h(context);
            TbsLog.m2155i("TbsShareManager", "writeCoreInfoForThirdPartyApp coreVersionFromConfig is " + m2723h);
            if (m2723h < 0) {
                C1472q.m1986a(f1946a, "error_coreinfo_core", "coreVersionFromConfigIs" + m2723h);
                TbsDownloadConfig.getInstance(f1946a).setDownloadInterruptCode(-402);
                return;
            }
            boolean z2 = false;
            if (i == m2723h) {
                if (m2728d(context) == 0) {
                    z2 = true;
                }
                C1472q.m1986a(f1946a, "core_same_write", (("coreVersionIs" + i) + "_shareCoreCanNotUse=is=" + z2) + "_isInstallCore=is=" + z);
                if (z2 && !z) {
                    C1472q.m1986a(f1946a, "copy_host_core", "coreVersionIs" + i);
                    m2736a(context, i);
                }
                m2729c(context, z);
                TbsDownloadConfig.getInstance(f1946a).setDownloadInterruptCode(-403);
            } else if (i < m2723h) {
                m2718m(context);
                TbsDownloadConfig.getInstance(f1946a).setDownloadInterruptCode(-404);
                C1472q.m1986a(f1946a, "error_coreinfo_core", ("coreVersionFromConfigIs" + m2723h) + "_coreVersion=is=" + i);
            } else {
                int m2446j = C1381p.m2503a().m2446j(context);
                TbsLog.m2155i("TbsShareManager", "writeCoreInfoForThirdPartyApp coreVersionFromCoreShare is " + m2446j);
                if (i < m2446j) {
                    m2718m(context);
                    TbsDownloadConfig.getInstance(f1946a).setDownloadInterruptCode(-404);
                    C1472q.m1986a(f1946a, "error_coreinfo_core", ("coreVersionFromCoreShareIs" + m2446j) + "_coreVersion=is=" + i);
                    return;
                }
                String[] m2727d = m2727d(context, z);
                if (f1948c != null) {
                    if (i == C1381p.m2503a().m2484a(f1948c)) {
                        writeProperties(context, Integer.toString(i), "AppDefined", f1948c, Integer.toString(1));
                        File tbsShareFile = getTbsShareFile(context, "core_info");
                        if (!f1955j && tbsShareFile != null) {
                            TbsLinuxToolsJni tbsLinuxToolsJni = new TbsLinuxToolsJni(f1946a);
                            tbsLinuxToolsJni.m2781a(tbsShareFile.getAbsolutePath(), "644");
                            tbsLinuxToolsJni.m2781a(C1381p.m2503a().m2436s(context).getAbsolutePath(), "755");
                            f1955j = true;
                        }
                        return;
                    } else if (i > C1381p.m2503a().m2484a(f1948c)) {
                        for (String str : m2727d) {
                            if (i == getSharedTbsCoreVersion(context, str)) {
                                Context packageContext = getPackageContext(context, str, true);
                                String absolutePath = C1381p.m2503a().m2437r(packageContext).getAbsolutePath();
                                C1429b.m2116e(context);
                                if (C1381p.m2503a().m2453g(packageContext)) {
                                    FileUtil.m2190a(new File(absolutePath), new File(f1948c), new FileFilter() { // from class: com.tencent.smtt.sdk.TbsShareManager.1
                                        @Override // java.io.FileFilter
                                        public boolean accept(File file) {
                                            return !file.getName().endsWith(MultiDexExtractor.DEX_SUFFIX);
                                        }
                                    });
                                    writeProperties(context, Integer.toString(i), "AppDefined", f1948c, Integer.toString(1));
                                    File tbsShareFile2 = getTbsShareFile(context, "core_info");
                                    if (!f1955j && tbsShareFile2 != null) {
                                        TbsLinuxToolsJni tbsLinuxToolsJni2 = new TbsLinuxToolsJni(f1946a);
                                        tbsLinuxToolsJni2.m2781a(tbsShareFile2.getAbsolutePath(), "644");
                                        tbsLinuxToolsJni2.m2781a(C1381p.m2503a().m2436s(context).getAbsolutePath(), "755");
                                        f1955j = true;
                                    }
                                    return;
                                }
                            }
                        }
                    }
                }
                for (String str2 : m2727d) {
                    try {
                        sharedTbsCoreVersion = getSharedTbsCoreVersion(context, str2);
                    } catch (Exception e) {
                        TbsLog.m2152i(e);
                    }
                    if (i == sharedTbsCoreVersion) {
                        TbsLog.m2155i("TbsShareManager", "writeCoreInfoForThirdPartyApp getSharedTbsCoreVersion ok,  packageName is " + str2 + " result version is " + i);
                        Context packageContext2 = getPackageContext(context, str2, true);
                        if (packageContext2 != null) {
                            String absolutePath2 = C1381p.m2503a().m2437r(packageContext2).getAbsolutePath();
                            int m2116e = C1429b.m2116e(context);
                            if (C1381p.m2503a().m2453g(packageContext2)) {
                                if (!str2.equals(StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageName())) {
                                    TbsLog.m2155i("TbsShareManager", "thirdAPP pre--> delete old core_share Directory:" + i);
                                    C1379n.m2526a(f1946a).m2524a("remove_old_core", 1);
                                }
                                C1472q.m1986a(f1946a, "write_core_info", ("packageName=is=" + str2) + "_coreVersion=is=" + i);
                                writeProperties(context, Integer.toString(i), str2, absolutePath2, Integer.toString(m2116e));
                                try {
                                    substring2 = str2.substring(str2.length() - 2);
                                } catch (Throwable th) {
                                    TbsLog.m2155i(TbsDownloader.LOGTAG, "throwable is " + Log.getStackTraceString(th));
                                }
                                C1472q.m1985a("9is" + i + substring2);
                                try {
                                    File tbsShareFile3 = getTbsShareFile(context, "core_info");
                                    if (!f1955j && tbsShareFile3 != null) {
                                        TbsLinuxToolsJni tbsLinuxToolsJni3 = new TbsLinuxToolsJni(f1946a);
                                        tbsLinuxToolsJni3.m2781a(tbsShareFile3.getAbsolutePath(), "644");
                                        tbsLinuxToolsJni3.m2781a(C1381p.m2503a().m2436s(context).getAbsolutePath(), "755");
                                        f1955j = true;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    th.printStackTrace();
                                    z2 = true;
                                    if (!z2) {
                                    }
                                }
                            }
                        }
                    } else {
                        TbsLog.m2155i("TbsShareManager", "writeCoreInfoForThirdPartyApp getSharedTbsCoreVersion fail,  packageName is " + str2 + " result version is " + sharedTbsCoreVersion);
                        int coreShareDecoupleCoreVersion = getCoreShareDecoupleCoreVersion(context, str2);
                        if (i == coreShareDecoupleCoreVersion) {
                            TbsLog.m2155i("TbsShareManager", "writeCoreInfoForThirdPartyApp getCoreShareDecoupleCoreVersion ok,  packageName is " + str2 + " result version is " + coreShareDecoupleCoreVersion);
                            Context packageContext3 = getPackageContext(context, str2, true);
                            String absolutePath3 = C1381p.m2503a().m2438q(packageContext3).getAbsolutePath();
                            int m2116e2 = C1429b.m2116e(context);
                            if (C1381p.m2503a().m2453g(packageContext3)) {
                                if (!str2.equals(StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageName())) {
                                    TbsLog.m2155i("TbsShareManager", "thirdAPP pre--> delete old core_share Directory:" + i);
                                    try {
                                        FileUtil.m2175b(C1381p.m2503a().m2437r(context));
                                        TbsLog.m2155i("TbsShareManager", "thirdAPP success--> delete old core_share Directory");
                                    } catch (Throwable th3) {
                                        th3.printStackTrace();
                                    }
                                }
                                C1472q.m1986a(f1946a, "write_core_info", ("packageName=is=" + str2) + "_coreVersion=is=" + i);
                                writeProperties(context, Integer.toString(i), str2, absolutePath3, Integer.toString(m2116e2));
                                try {
                                    substring = str2.substring(str2.length() - 2);
                                } catch (Throwable th4) {
                                    TbsLog.m2155i(TbsDownloader.LOGTAG, "throwable is " + Log.getStackTraceString(th4));
                                }
                                C1472q.m1985a("9is" + i + substring);
                                try {
                                    File tbsShareFile4 = getTbsShareFile(context, "core_info");
                                    if (!f1955j && tbsShareFile4 != null) {
                                        TbsLinuxToolsJni tbsLinuxToolsJni4 = new TbsLinuxToolsJni(f1946a);
                                        tbsLinuxToolsJni4.m2781a(tbsShareFile4.getAbsolutePath(), "644");
                                        tbsLinuxToolsJni4.m2781a(C1381p.m2503a().m2436s(context).getAbsolutePath(), "755");
                                        f1955j = true;
                                    }
                                } catch (Throwable th5) {
                                    th = th5;
                                    th.printStackTrace();
                                    z2 = true;
                                    if (!z2) {
                                    }
                                }
                            }
                        } else {
                            TbsLog.m2155i("TbsShareManager", "writeCoreInfoForThirdPartyApp getCoreShareDecoupleCoreVersion fail,  packageName is " + str2 + " result version is " + coreShareDecoupleCoreVersion);
                        }
                    }
                    z2 = true;
                    if (!z2 && !z) {
                        TbsLog.m2155i("TbsShareManager", "writeCoreInfoForThirdPartyApp ready to installCoreWithUnzip ");
                        C1472q.m1986a(f1946a, "copy_host_core", "coreVersionIs" + i);
                        m2736a(context, i);
                    }
                }
                if (!z2) {
                    TbsLog.m2155i("TbsShareManager", "writeCoreInfoForThirdPartyApp ready to installCoreWithUnzip ");
                    C1472q.m1986a(f1946a, "copy_host_core", "coreVersionIs" + i);
                    m2736a(context, i);
                }
            }
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:64:0x00e1 -> B:24:0x00e4). Please submit an issue!!! */
    public static void writeProperties(Context context, String str, String str2, String str3, String str4) {
        BufferedOutputStream bufferedOutputStream;
        File tbsShareFile;
        int i;
        TbsLog.m2155i("TbsShareManager", "writeProperties coreVersion is " + str + " corePackageName is " + str2 + " corePath is " + str3);
        StringBuilder sb = new StringBuilder();
        sb.append("writeProperties -- stack: ");
        sb.append(Log.getStackTraceString(new Throwable("#")));
        TbsLog.m2155i("TbsShareManager", sb.toString());
        BufferedInputStream bufferedInputStream = null;
        try {
            try {
                tbsShareFile = getTbsShareFile(context, "core_info");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Throwable th) {
            th = th;
            bufferedOutputStream = null;
        }
        if (tbsShareFile == null) {
            TbsDownloadConfig.getInstance(f1946a).setDownloadInterruptCode(-405);
            return;
        }
        BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(tbsShareFile));
        try {
            Properties properties = new Properties();
            properties.load(bufferedInputStream2);
            try {
                i = Integer.parseInt(str);
            } catch (Exception unused) {
                i = 0;
            }
            if (i != 0) {
                properties.setProperty("core_version", str);
                properties.setProperty("core_disabled", String.valueOf(false));
                properties.setProperty("core_packagename", str2);
                properties.setProperty("core_path", str3);
                properties.setProperty("app_version", str4);
            } else {
                properties.setProperty("core_disabled", String.valueOf(true));
            }
            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(tbsShareFile));
            try {
                properties.store(bufferedOutputStream2, (String) null);
                f1958m = false;
                TbsDownloadConfig.getInstance(f1946a).setDownloadInterruptCode(-406);
                try {
                    bufferedInputStream2.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                bufferedOutputStream2.close();
            } catch (Throwable th2) {
                bufferedInputStream = bufferedInputStream2;
                bufferedOutputStream = bufferedOutputStream2;
                th = th2;
                try {
                    th.printStackTrace();
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                    if (bufferedOutputStream == null) {
                        return;
                    }
                    bufferedOutputStream.close();
                } catch (Throwable th3) {
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (Exception e5) {
                            e5.printStackTrace();
                        }
                    }
                    throw th3;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedOutputStream = null;
            bufferedInputStream = bufferedInputStream2;
        }
    }
}
