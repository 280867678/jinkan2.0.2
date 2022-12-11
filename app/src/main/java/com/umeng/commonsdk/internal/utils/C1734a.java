package com.umeng.commonsdk.internal.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Environment;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.widget.ActivityChooserModel;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.ULog;
import java.io.File;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import me.tvspark.outline;

/* renamed from: com.umeng.commonsdk.internal.utils.a */
/* loaded from: classes4.dex */
public class C1734a {

    /* renamed from: com.umeng.commonsdk.internal.utils.a$a */
    /* loaded from: classes4.dex */
    public static class C1735a {

        /* renamed from: a */
        public String f3947a;

        /* renamed from: b */
        public String f3948b;
    }

    /* renamed from: a */
    public static float m693a(Context context) {
        if (context == null) {
            return 0.0f;
        }
        Configuration configuration = new Configuration();
        try {
            configuration.updateFrom(context.getResources().getConfiguration());
            return configuration.fontScale;
        } catch (Exception e) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("getFontSize:");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(e.getMessage());
            ULog.m544e(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            return 0.0f;
        }
    }

    /* renamed from: a */
    public static long m692a(Context context, String str) {
        if (context == null) {
            return 0L;
        }
        try {
            return context.getPackageManager().getPackageInfo(str, 0).firstInstallTime;
        } catch (PackageManager.NameNotFoundException e) {
            UMCrashManager.reportCrash(context, e);
            ULog.m544e("getAppFirstInstallTime" + e.getMessage());
            return 0L;
        }
    }

    /* renamed from: a */
    public static boolean m694a() {
        return C1745g.m662a();
    }

    /* renamed from: b */
    public static long m689b(Context context, String str) {
        if (context == null) {
            return 0L;
        }
        try {
            return context.getPackageManager().getPackageInfo(str, 0).lastUpdateTime;
        } catch (PackageManager.NameNotFoundException e) {
            UMCrashManager.reportCrash(context, e);
            ULog.m544e("getAppLastUpdateTime:" + e.getMessage());
            return 0L;
        }
    }

    /* renamed from: b */
    public static String m691b() {
        return new SimpleDateFormat().format(new Date());
    }

    /* renamed from: b */
    public static void m690b(Context context) {
    }

    /* renamed from: c */
    public static int m687c(Context context) {
        if (context == null) {
            return 0;
        }
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", "android"));
    }

    /* renamed from: c */
    public static long m688c() {
        return System.currentTimeMillis() - SystemClock.elapsedRealtime();
    }

    /* renamed from: c */
    public static String m686c(Context context, String str) {
        try {
            return context.getPackageManager().getInstallerPackageName(str);
        } catch (Exception e) {
            UMCrashManager.reportCrash(context, e);
            ULog.m544e("getAppInstaller:" + e.getMessage());
            return null;
        }
    }

    /* renamed from: d */
    public static int m684d(Context context) {
        if (context == null) {
            return 0;
        }
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", "android"));
    }

    /* renamed from: d */
    public static int m683d(Context context, String str) {
        if (context == null) {
            return 0;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getPackageInfo(str, 0).applicationInfo;
            if (applicationInfo == null) {
                return 0;
            }
            return applicationInfo.uid;
        } catch (PackageManager.NameNotFoundException e) {
            UMCrashManager.reportCrash(context, e);
            ULog.m544e("getAppUid:" + e.getMessage());
            return 0;
        }
    }

    /* renamed from: d */
    public static String m685d() {
        try {
            Method declaredMethod = Build.class.getDeclaredMethod("getString", String.class);
            declaredMethod.setAccessible(true);
            String obj = declaredMethod.invoke(null, "net.hostname").toString();
            return (obj == null || obj.equalsIgnoreCase("")) ? obj : HelperUtils.getUmengMD5(obj);
        } catch (Exception e) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("getHostName:");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(e.getMessage());
            ULog.m544e(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            return null;
        }
    }

    /* renamed from: e */
    public static DisplayMetrics m682e(Context context) {
        if (context == null) {
            return null;
        }
        return context.getResources().getDisplayMetrics();
    }

    /* renamed from: e */
    public static String m681e(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 128);
            if (applicationInfo == null) {
                return null;
            }
            return (String) applicationInfo.loadLabel(context.getPackageManager());
        } catch (Exception e) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("getLabel:");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(e.getMessage());
            ULog.m544e(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            return null;
        }
    }

    /* renamed from: f */
    public static List<InputMethodInfo> m680f(Context context) {
        InputMethodManager inputMethodManager;
        if (context == null || (inputMethodManager = (InputMethodManager) context.getSystemService("input_method")) == null) {
            return null;
        }
        return inputMethodManager.getInputMethodList();
    }

    /* renamed from: g */
    public static List<C1735a> m679g(Context context) {
        String[] list;
        if (context == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            File file = new File(Environment.getExternalStorageDirectory() + "/Android/data/");
            if (file.isDirectory() && (list = file.list()) != null && list.length > 0) {
                for (String str : list) {
                    if (str != null && !str.startsWith(".")) {
                        C1735a c1735a = new C1735a();
                        c1735a.f3947a = str;
                        c1735a.f3948b = m681e(context, str);
                        arrayList.add(c1735a);
                    }
                }
            }
        } catch (Exception e) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("getAppList:");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(e.getMessage());
            ULog.m544e(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
        return arrayList;
    }

    /* renamed from: h */
    public static ActivityManager.MemoryInfo m678h(Context context) {
        ActivityManager activityManager;
        if (context == null || (activityManager = (ActivityManager) context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY)) == null) {
            return null;
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo;
    }

    /* renamed from: i */
    public static String m677i(Context context) {
        return null;
    }

    /* renamed from: j */
    public static String m676j(Context context) {
        return null;
    }
}
