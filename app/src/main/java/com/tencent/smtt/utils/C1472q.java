package com.tencent.smtt.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import androidx.core.view.PointerIconCompat;
import com.stub.StubApp;
import com.tencent.smtt.sdk.C1356c;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.smtt.sdk.TbsDownloader;
import com.tencent.smtt.sdk.TbsShareManager;
import com.tencent.smtt.sdk.stat.C1397b;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import me.tvspark.outline;

/* renamed from: com.tencent.smtt.utils.q */
/* loaded from: classes4.dex */
public class C1472q {

    /* renamed from: a */
    public static File f2551a = null;

    /* renamed from: b */
    public static String f2552b = "";

    /* renamed from: c */
    public static String f2553c = "";

    /* renamed from: d */
    public static int f2554d = -1;

    /* renamed from: e */
    public static String f2555e = "";

    /* renamed from: f */
    public static String f2556f = null;

    /* renamed from: g */
    public static int f2557g = 0;

    /* renamed from: h */
    public static String f2558h = null;

    /* renamed from: i */
    public static boolean f2559i = false;

    /* renamed from: j */
    public static boolean f2560j = false;

    /* renamed from: k */
    public static String f2561k = "unknown";

    /* renamed from: l */
    public static int f2562l = -1;

    /* renamed from: m */
    public static int f2563m = -1;

    /* renamed from: n */
    public static int f2564n = -1;

    /* renamed from: o */
    public static int f2565o = -1;

    /* renamed from: p */
    public static int f2566p = -1;

    /* renamed from: q */
    public static String f2567q = "";

    /* renamed from: r */
    public static String f2568r = "";

    /* renamed from: a */
    public static int m1987a(Context context, String str, int i, int i2) {
        File file = new File(FileUtil.m2195a(context, str, i, true), TbsDownloader.getBackupFileName(false, i2));
        if (!file.exists() || !file.canRead()) {
            return -1;
        }
        int m2131b = C1428a.m2131b(file);
        return m2131b <= 0 ? C1428a.m2139a(context, file) : m2131b;
    }

    /* renamed from: a */
    public static long m1991a() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return statFs.getBlockSize() * statFs.getAvailableBlocks();
    }

    /* renamed from: a */
    public static void m1990a(int i) {
        f2554d = i;
    }

    /* renamed from: a */
    public static void m1988a(Context context, Bundle bundle) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("sai", 0).edit();
            if (bundle.containsKey(QbSdk.KEY_THIRD_PARTY_TURING)) {
                boolean z = bundle.getBoolean(QbSdk.KEY_THIRD_PARTY_TURING);
                edit.putBoolean("itge", z);
                TbsLog.m2158e("TbsUtils", "setEnableForThirdParty key is itge value is " + z);
            }
            edit.commit();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public static void m1986a(Context context, String str, String str2) {
        String str3;
        try {
            if (!TbsShareManager.isThirdPartyApp(context) || !m1968l(context)) {
                return;
            }
            String str4 = "thirdapp_" + str;
            if (TextUtils.isEmpty(str2)) {
                str3 = "";
            } else {
                str3 = str2 + "_";
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str3);
            sb.append("mycpuis");
            sb.append(C1429b.m2121b() ? 64 : 32);
            String str5 = (sb.toString() + "_64scoreis" + TbsShareManager.getTbsStableCoreVersion(context, 64)) + "_32scoreis" + TbsShareManager.getTbsStableCoreVersion(context, 32);
            C1397b.m2383a(context, str4, str5);
            TbsLog.m2155i("uploadThirdAppCoreUpdate", "action is " + str4 + " p1 is " + str5);
        } catch (Throwable th) {
            outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("stack is  "), "uploadThirdAppCoreUpdate");
        }
    }

    /* renamed from: a */
    public static void m1985a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!TextUtils.isEmpty(f2552b)) {
            str = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new StringBuilder(), f2552b, "&", str);
        }
        f2552b = str;
    }

    /* renamed from: a */
    public static void m1984a(String str, String str2) {
        f2567q = str;
        f2568r = str2;
    }

    @TargetApi(9)
    /* renamed from: a */
    public static boolean m1989a(Context context) {
        File tbsFolderDir;
        if (context == null) {
            return false;
        }
        if (f2551a != null) {
            return true;
        }
        try {
            if (context.getApplicationInfo().processName.contains(TbsConfig.APP_WX) && (tbsFolderDir = QbSdk.getTbsFolderDir(context)) != null && tbsFolderDir.isDirectory()) {
                File file = new File(tbsFolderDir, "share");
                if (!file.isDirectory() && !file.mkdir()) {
                    return false;
                }
                f2551a = file;
                file.setExecutable(true, false);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: b */
    public static String m1983b() {
        if (QbSdk.getIsSysWebViewForcedByOuter()) {
            return "SysWebViewForcedByOuter";
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(QbSdk.getIsInitX5Environment() ? "pre" : "nopre", "&");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(f2552b);
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    /* renamed from: b */
    public static void m1981b(Context context, String str, String str2) {
        String str3;
        try {
            if (TbsShareManager.isThirdPartyApp(context) || !m1969k(context)) {
                return;
            }
            if (TextUtils.isEmpty(str2)) {
                str3 = "";
            } else {
                str3 = str2 + "_";
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str3);
            sb.append("mycpuis");
            sb.append(C1429b.m2121b() ? 64 : 32);
            String str4 = (sb.toString() + "_64scoreis" + TbsShareManager.getTbsStableCoreVersion(context, 64)) + "_32scoreis" + TbsShareManager.getTbsStableCoreVersion(context, 32);
            C1397b.m2383a(context, str, str4);
            TbsLog.m2155i("recordStableUpdate", "action is " + str + " p1 is " + str4);
            if (TextUtils.isEmpty(f2567q) || TextUtils.isEmpty(f2568r)) {
                return;
            }
            C1397b.m2383a(context, f2567q, f2568r);
            TbsLog.m2155i("recordStableUpdate", "action is " + f2567q + " p1 is " + f2568r);
            f2567q = "";
            f2568r = "";
        } catch (Throwable th) {
            outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("stack is  "), "recordStableUpdate");
        }
    }

    /* renamed from: b */
    public static void m1980b(String str) {
        f2555e = str;
    }

    /* renamed from: b */
    public static boolean m1982b(Context context) {
        try {
            if (TbsShareManager.isThirdPartyApp(context)) {
                TbsLog.m2155i("TbsUtils", "isStableCoreForHostEnable app is thirdapp return is false ");
                return false;
            }
        } catch (Throwable th) {
            outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("stack is "), "TbsUtils");
        }
        boolean z = true;
        try {
            final Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            z = origApplicationContext.getSharedPreferences("sai", 0).getBoolean("scfh", true);
            TbsLog.m2155i("TbsUtils", "isStableCoreForHostEnable is " + z);
            C1356c m2620a = C1356c.m2620a();
            m2620a.m2617a(context, (Integer) 1003, new C1356c.AbstractC1357a() { // from class: com.tencent.smtt.utils.q.1
                @Override // com.tencent.smtt.sdk.C1356c.AbstractC1357a
                /* renamed from: a */
                public void mo1965a(String str) {
                    SharedPreferences.Editor edit = origApplicationContext.getSharedPreferences("sai", 0).edit();
                    edit.putBoolean("scfh", true);
                    edit.commit();
                    TbsLog.m2158e("TbsUtils", "Execute command [1003](" + str + ")");
                }
            });
            m2620a.m2617a(context, Integer.valueOf((int) PointerIconCompat.TYPE_VERTICAL_TEXT), new C1356c.AbstractC1357a() { // from class: com.tencent.smtt.utils.q.9
                @Override // com.tencent.smtt.sdk.C1356c.AbstractC1357a
                /* renamed from: a */
                public void mo1965a(String str) {
                    SharedPreferences.Editor edit = origApplicationContext.getSharedPreferences("sai", 0).edit();
                    edit.putBoolean("scfh", false);
                    edit.commit();
                    TbsLog.m2158e("TbsUtils", "Execute command [1009](" + str + ")");
                }
            });
            return z;
        } catch (Throwable th2) {
            outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th2, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("stack is "), "TbsUtils");
            return z;
        }
    }

    /* renamed from: c */
    public static void m1979c() {
        f2552b = "";
    }

    /* renamed from: c */
    public static boolean m1978c(Context context) {
        boolean z = true;
        try {
            final Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            z = origApplicationContext.getSharedPreferences("sai", 0).getBoolean("ucup", true);
            TbsLog.m2155i("TbsUtils", "isUploadCoreUpdateEnable is " + z);
            C1356c.m2620a().m2617a(context, (Integer) 1005, new C1356c.AbstractC1357a() { // from class: com.tencent.smtt.utils.q.10
                @Override // com.tencent.smtt.sdk.C1356c.AbstractC1357a
                /* renamed from: a */
                public void mo1965a(String str) {
                    SharedPreferences.Editor edit = origApplicationContext.getSharedPreferences("sai", 0).edit();
                    edit.putBoolean("ucup", false);
                    edit.commit();
                    TbsLog.m2158e("TbsUtils", "Execute command [1005](" + str + ")");
                }
            });
            return z;
        } catch (Throwable th) {
            outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("stack is "), "TbsUtils");
            return z;
        }
    }

    /* renamed from: d */
    public static String m1977d() {
        return f2555e;
    }

    /* renamed from: d */
    public static String m1976d(Context context) {
        SharedPreferences sharedPreferences;
        String string;
        if (!TextUtils.isEmpty(f2553c)) {
            return f2553c;
        }
        try {
            sharedPreferences = context.getSharedPreferences("sai", 0);
            string = sharedPreferences.getString("bmo", "");
            f2553c = string;
        } catch (Throwable th) {
            outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("stack is "), "TbsUtils");
        }
        if (!TextUtils.isEmpty(string)) {
            return f2553c;
        }
        f2553c = Build.MODEL;
        TbsLog.m2155i("TbsUtils", "getBuildModel is " + f2553c);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("bmo", f2553c);
        edit.commit();
        return f2553c;
    }

    /* renamed from: e */
    public static boolean m1975e(Context context) {
        boolean z = false;
        try {
            final Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            z = origApplicationContext.getSharedPreferences("sai", 0).getBoolean("rrff", false);
            TbsLog.m2155i("TbsUtils", "isReadResponseFromFileEnable is " + z);
            C1356c.m2620a().m2617a(context, Integer.valueOf((int) PointerIconCompat.TYPE_CELL), new C1356c.AbstractC1357a() { // from class: com.tencent.smtt.utils.q.11
                @Override // com.tencent.smtt.sdk.C1356c.AbstractC1357a
                /* renamed from: a */
                public void mo1965a(String str) {
                    SharedPreferences.Editor edit = origApplicationContext.getSharedPreferences("sai", 0).edit();
                    edit.putBoolean("rrff", true);
                    edit.commit();
                    TbsLog.m2158e("TbsUtils", "Execute command [1006](" + str + ")");
                }
            });
            return z;
        } catch (Throwable th) {
            outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("stack is "), "TbsUtils");
            return z;
        }
    }

    /* renamed from: f */
    public static boolean m1974f(Context context) {
        boolean z = false;
        try {
            final Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            z = origApplicationContext.getSharedPreferences("sai", 0).getBoolean("fwdn", false);
            TbsLog.m2155i("TbsUtils", "isReadResponseFromFileEnable is " + z);
            C1356c m2620a = C1356c.m2620a();
            m2620a.m2617a(context, Integer.valueOf((int) PointerIconCompat.TYPE_CROSSHAIR), new C1356c.AbstractC1357a() { // from class: com.tencent.smtt.utils.q.12
                @Override // com.tencent.smtt.sdk.C1356c.AbstractC1357a
                /* renamed from: a */
                public void mo1965a(String str) {
                    SharedPreferences.Editor edit = origApplicationContext.getSharedPreferences("sai", 0).edit();
                    edit.putBoolean("fwdn", true);
                    edit.commit();
                    TbsLog.m2158e("TbsUtils", "Execute command 1007(" + str + ")");
                }
            });
            m2620a.m2617a(context, Integer.valueOf((int) PointerIconCompat.TYPE_TEXT), new C1356c.AbstractC1357a() { // from class: com.tencent.smtt.utils.q.13
                @Override // com.tencent.smtt.sdk.C1356c.AbstractC1357a
                /* renamed from: a */
                public void mo1965a(String str) {
                    SharedPreferences.Editor edit = origApplicationContext.getSharedPreferences("sai", 0).edit();
                    edit.putBoolean("fwdn", false);
                    edit.commit();
                    TbsLog.m2158e("TbsUtils", "Execute command 1008(" + str + ")");
                }
            });
            return z;
        } catch (Throwable th) {
            outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("stack is "), "TbsUtils");
            return z;
        }
    }

    /* renamed from: g */
    public static boolean m1973g(Context context) {
        boolean z = false;
        try {
            final Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            z = origApplicationContext.getSharedPreferences("sai", 0).getBoolean("cbau", false);
            TbsLog.m2155i("TbsUtils", "isClearBackupEnable is " + z);
            C1356c m2620a = C1356c.m2620a();
            m2620a.m2617a(context, Integer.valueOf((int) PointerIconCompat.TYPE_ALL_SCROLL), new C1356c.AbstractC1357a() { // from class: com.tencent.smtt.utils.q.14
                @Override // com.tencent.smtt.sdk.C1356c.AbstractC1357a
                /* renamed from: a */
                public void mo1965a(String str) {
                    SharedPreferences.Editor edit = origApplicationContext.getSharedPreferences("sai", 0).edit();
                    edit.putBoolean("cbau", true);
                    edit.commit();
                    TbsLog.m2158e("TbsUtils", "Execute command [1013](" + str + ")");
                }
            });
            m2620a.m2617a(context, Integer.valueOf((int) PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW), new C1356c.AbstractC1357a() { // from class: com.tencent.smtt.utils.q.15
                @Override // com.tencent.smtt.sdk.C1356c.AbstractC1357a
                /* renamed from: a */
                public void mo1965a(String str) {
                    SharedPreferences.Editor edit = origApplicationContext.getSharedPreferences("sai", 0).edit();
                    edit.putBoolean("cbau", false);
                    edit.commit();
                    TbsLog.m2158e("TbsUtils", "Execute command [1014](" + str + ")");
                }
            });
            return z;
        } catch (Throwable th) {
            outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("stack is "), "TbsUtils");
            return z;
        }
    }

    /* renamed from: h */
    public static boolean m1972h(Context context) {
        if (QbSdk.getTbsVersion(context) == f2554d) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("isUploadCoreSourceEnable core source version ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(f2554d);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" already uploaded and return ");
            TbsLog.m2155i("TbsUtils", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            return false;
        }
        boolean z = true;
        try {
            final Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            z = origApplicationContext.getSharedPreferences("sai", 0).getBoolean("ucst", true);
            TbsLog.m2155i("TbsUtils", "isUploadCoreSourceEnable is " + z);
            C1356c m2620a = C1356c.m2620a();
            m2620a.m2617a(context, Integer.valueOf((int) PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW), new C1356c.AbstractC1357a() { // from class: com.tencent.smtt.utils.q.16
                @Override // com.tencent.smtt.sdk.C1356c.AbstractC1357a
                /* renamed from: a */
                public void mo1965a(String str) {
                    SharedPreferences.Editor edit = origApplicationContext.getSharedPreferences("sai", 0).edit();
                    edit.putBoolean("ucst", false);
                    edit.commit();
                    TbsLog.m2158e("TbsUtils", "Execute command [1016](" + str + ")");
                }
            });
            m2620a.m2617a(context, Integer.valueOf((int) PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW), new C1356c.AbstractC1357a() { // from class: com.tencent.smtt.utils.q.2
                @Override // com.tencent.smtt.sdk.C1356c.AbstractC1357a
                /* renamed from: a */
                public void mo1965a(String str) {
                    SharedPreferences.Editor edit = origApplicationContext.getSharedPreferences("sai", 0).edit();
                    edit.putBoolean("ucst", true);
                    edit.commit();
                    TbsLog.m2158e("TbsUtils", "Execute command [1015](" + str + ")");
                }
            });
            return z;
        } catch (Throwable th) {
            outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("stack is "), "TbsUtils");
            return z;
        }
    }

    /* renamed from: i */
    public static boolean m1971i(Context context) {
        boolean z;
        try {
            z = context.getApplicationInfo().packageName.contains("com.tencent.qqmusic");
        } catch (Throwable unused) {
            z = false;
        }
        outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("shouldUploadDestroyCode is ", z, "TbsUtils");
        return z;
    }

    /* renamed from: j */
    public static String m1970j(Context context) {
        f2562l = m1987a(context, TbsConfig.APP_WX, 3, 32);
        f2563m = m1987a(context, TbsConfig.APP_WX, 3, 64);
        f2564n = m1987a(context, TbsConfig.APP_QQ, 3, 32);
        f2565o = m1987a(context, TbsConfig.APP_WX, 4, 32);
        f2566p = m1987a(context, TbsConfig.APP_WX, 4, 64);
        m1966n(context);
        String str = "coretype=ctis=" + f2561k;
        int sharedTbsCoreVersion = TbsShareManager.getSharedTbsCoreVersion(context, TbsConfig.APP_WX);
        int sharedTbsCoreVersion2 = TbsShareManager.getSharedTbsCoreVersion(context, TbsConfig.APP_QQ);
        return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "=split=", "wx=ceis=" + sharedTbsCoreVersion + "_wxd=ceis=" + TbsShareManager.getCoreShareDecoupleCoreVersion(context, TbsConfig.APP_WX) + "_qq=ceis=" + sharedTbsCoreVersion2 + "_qqd=ceis=" + TbsShareManager.getCoreShareDecoupleCoreVersion(context, TbsConfig.APP_QQ) + "_wxb32=ceis=" + f2562l + "_wxb64=ceis=" + f2563m + "_qqb=ceis=" + f2564n + "_s32=ceis=" + f2565o + "_s64=ceis=" + f2566p);
    }

    /* renamed from: k */
    public static boolean m1969k(Context context) {
        boolean z = false;
        try {
            final Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            z = origApplicationContext.getSharedPreferences("sai", 0).getBoolean("rscu", false);
            TbsLog.m2155i("TbsUtils", "isRecordStableUpdateEnable is " + z);
            C1356c m2620a = C1356c.m2620a();
            m2620a.m2617a(context, Integer.valueOf((int) PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW), new C1356c.AbstractC1357a() { // from class: com.tencent.smtt.utils.q.3
                @Override // com.tencent.smtt.sdk.C1356c.AbstractC1357a
                /* renamed from: a */
                public void mo1965a(String str) {
                    SharedPreferences.Editor edit = origApplicationContext.getSharedPreferences("sai", 0).edit();
                    edit.putBoolean("rscu", true);
                    edit.commit();
                    TbsLog.m2158e("TbsUtils", "Execute command [1017](" + str + ")");
                }
            });
            m2620a.m2617a(context, Integer.valueOf((int) PointerIconCompat.TYPE_ZOOM_IN), new C1356c.AbstractC1357a() { // from class: com.tencent.smtt.utils.q.4
                @Override // com.tencent.smtt.sdk.C1356c.AbstractC1357a
                /* renamed from: a */
                public void mo1965a(String str) {
                    SharedPreferences.Editor edit = origApplicationContext.getSharedPreferences("sai", 0).edit();
                    edit.putBoolean("rscu", false);
                    edit.commit();
                    TbsLog.m2158e("TbsUtils", "Execute command [1018](" + str + ")");
                }
            });
            return z;
        } catch (Throwable th) {
            outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("stack is "), "TbsUtils");
            return z;
        }
    }

    /* renamed from: l */
    public static boolean m1968l(Context context) {
        boolean z = false;
        try {
            final Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            z = origApplicationContext.getSharedPreferences("sai", 0).getBoolean("utcu", false);
            TbsLog.m2155i("TbsUtils", "isUploadThirdAppCoreUpdateEnable is " + z);
            C1356c m2620a = C1356c.m2620a();
            m2620a.m2617a(context, Integer.valueOf((int) PointerIconCompat.TYPE_ZOOM_OUT), new C1356c.AbstractC1357a() { // from class: com.tencent.smtt.utils.q.5
                @Override // com.tencent.smtt.sdk.C1356c.AbstractC1357a
                /* renamed from: a */
                public void mo1965a(String str) {
                    SharedPreferences.Editor edit = origApplicationContext.getSharedPreferences("sai", 0).edit();
                    edit.putBoolean("utcu", true);
                    edit.commit();
                    TbsLog.m2158e("TbsUtils", "Execute command [1019](" + str + ")");
                }
            });
            m2620a.m2617a(context, Integer.valueOf((int) PointerIconCompat.TYPE_GRAB), new C1356c.AbstractC1357a() { // from class: com.tencent.smtt.utils.q.6
                @Override // com.tencent.smtt.sdk.C1356c.AbstractC1357a
                /* renamed from: a */
                public void mo1965a(String str) {
                    SharedPreferences.Editor edit = origApplicationContext.getSharedPreferences("sai", 0).edit();
                    edit.putBoolean("utcu", false);
                    edit.commit();
                    TbsLog.m2158e("TbsUtils", "Execute command [1020](" + str + ")");
                }
            });
            return z;
        } catch (Throwable th) {
            outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("stack is "), "TbsUtils");
            return z;
        }
    }

    /* renamed from: m */
    public static boolean m1967m(Context context) {
        boolean z = true;
        try {
            final Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            z = origApplicationContext.getSharedPreferences("sai", 0).getBoolean("itge", true);
            TbsLog.m2155i("TbsUtils", "isTuringEnable is " + z);
            C1356c m2620a = C1356c.m2620a();
            m2620a.m2617a(context, Integer.valueOf((int) PointerIconCompat.TYPE_GRABBING), new C1356c.AbstractC1357a() { // from class: com.tencent.smtt.utils.q.7
                @Override // com.tencent.smtt.sdk.C1356c.AbstractC1357a
                /* renamed from: a */
                public void mo1965a(String str) {
                    SharedPreferences.Editor edit = origApplicationContext.getSharedPreferences("sai", 0).edit();
                    edit.putBoolean("itge", true);
                    edit.commit();
                    TbsLog.m2158e("TbsUtils", "Execute command [1021](" + str + ")");
                }
            });
            m2620a.m2617a(context, (Integer) 1022, new C1356c.AbstractC1357a() { // from class: com.tencent.smtt.utils.q.8
                @Override // com.tencent.smtt.sdk.C1356c.AbstractC1357a
                /* renamed from: a */
                public void mo1965a(String str) {
                    SharedPreferences.Editor edit = origApplicationContext.getSharedPreferences("sai", 0).edit();
                    edit.putBoolean("itge", false);
                    edit.commit();
                    TbsLog.m2158e("TbsUtils", "Execute command [1022](" + str + ")");
                }
            });
            return z;
        } catch (Throwable th) {
            outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("stack is "), "TbsUtils");
            return z;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0078 A[Catch: all -> 0x00b5, TryCatch #0 {all -> 0x00b5, blocks: (B:3:0x0002, B:7:0x000b, B:9:0x0029, B:10:0x0034, B:12:0x0040, B:13:0x0042, B:15:0x004e, B:18:0x005a, B:19:0x006a, B:21:0x0078, B:23:0x0082, B:26:0x0089, B:28:0x008f, B:31:0x0096, B:34:0x009e, B:37:0x005d, B:40:0x00a7), top: B:2:0x0002 }] */
    /* renamed from: n */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void m1966n(Context context) {
        String str;
        String str2;
        try {
            File tbsShareFile = TbsShareManager.getTbsShareFile(context, "core_info");
            if (tbsShareFile == null) {
                return;
            }
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(tbsShareFile));
            Properties properties = new Properties();
            properties.load(bufferedInputStream);
            String property = properties.getProperty("core_version", "");
            if (!"".equals(property)) {
                f2557g = Math.max(Integer.parseInt(property), 0);
            }
            String property2 = properties.getProperty("core_packagename", "");
            if (!"".equals(property2)) {
                f2558h = property2;
            }
            String property3 = properties.getProperty("core_path", "");
            if (!"".equals(property3)) {
                f2556f = property3;
                if (property3.contains(TbsConfig.APP_WX)) {
                    str = "shareFromWX";
                } else {
                    if (f2556f.contains(TbsConfig.APP_QQ)) {
                        str = "shareFromQQ";
                    }
                    if (f2556f.contains(context.getApplicationInfo().packageName)) {
                        f2561k = "downloadOWN";
                        if (f2557g != f2565o && f2557g != f2566p) {
                            if (f2557g != f2562l && f2557g != f2563m) {
                                if (f2557g == f2564n) {
                                    str2 = "copyBackupFromQQ";
                                    f2561k = str2;
                                }
                            }
                            str2 = "copyBackupFromWX";
                            f2561k = str2;
                        }
                        str2 = "copyFromStable";
                        f2561k = str2;
                    }
                }
                f2561k = str;
                if (f2556f.contains(context.getApplicationInfo().packageName)) {
                }
            }
            f2559i = Boolean.parseBoolean(properties.getProperty("core_disabled", "false"));
        } catch (Throwable unused) {
        }
    }
}
