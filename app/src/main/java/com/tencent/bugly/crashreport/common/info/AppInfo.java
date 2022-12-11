package com.tencent.bugly.crashreport.common.info;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import androidx.appcompat.widget.ActivityChooserModel;
import com.tencent.bugly.proguard.C1199X;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class AppInfo {

    /* renamed from: a */
    public static final String[] f997a = "@buglyAllChannel@".split(",");

    /* renamed from: b */
    public static final String[] f998b = "@buglyAllChannelPriority@".split(",");

    /* renamed from: c */
    public static ActivityManager f999c;

    /* renamed from: a */
    public static String m3437a(Context context) {
        CharSequence applicationLabel;
        if (context == null) {
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (packageManager != null && applicationInfo != null && (applicationLabel = packageManager.getApplicationLabel(applicationInfo)) != null) {
                return applicationLabel.toString();
            }
        } catch (Throwable th) {
            if (!C1199X.m3080b(th)) {
                th.printStackTrace();
            }
        }
        return null;
    }

    /* renamed from: a */
    public static String m3436a(Context context, int i) {
        Throwable th;
        FileReader fileReader;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("/proc/");
            sb.append(i);
            sb.append("/cmdline");
            fileReader = new FileReader(sb.toString());
            try {
                char[] cArr = new char[512];
                fileReader.read(cArr);
                int i2 = 0;
                while (i2 < 512 && cArr[i2] != 0) {
                    i2++;
                }
                String substring = new String(cArr).substring(0, i2);
                try {
                    fileReader.close();
                } catch (Throwable unused) {
                }
                return substring;
            } catch (Throwable th2) {
                th = th2;
                try {
                    if (!C1199X.m3080b(th)) {
                        th.printStackTrace();
                    }
                    String valueOf = String.valueOf(i);
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Throwable unused2) {
                        }
                    }
                    return valueOf;
                } catch (Throwable th3) {
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Throwable unused3) {
                        }
                    }
                    throw th3;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            fileReader = null;
        }
    }

    /* renamed from: a */
    public static List<String> m3434a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        try {
            String str = map.get("BUGLY_DISABLE");
            if (str == null || str.length() == 0) {
                return null;
            }
            String[] split = str.split(",");
            for (int i = 0; i < split.length; i++) {
                split[i] = split[i].trim();
            }
            return Arrays.asList(split);
        } catch (Throwable th) {
            if (!C1199X.m3080b(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: a */
    public static boolean m3435a(Context context, String str) {
        if (context != null && str != null && str.trim().length() > 0) {
            try {
                String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
                if (strArr != null) {
                    for (String str2 : strArr) {
                        if (str.equals(str2)) {
                            return true;
                        }
                    }
                }
            } catch (Throwable th) {
                if (!C1199X.m3080b(th)) {
                    th.printStackTrace();
                }
            }
        }
        return false;
    }

    /* renamed from: b */
    public static Map<String, String> m3433b(Context context) {
        if (context == null) {
            return null;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo.metaData == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            Object obj = applicationInfo.metaData.get("BUGLY_DISABLE");
            if (obj != null) {
                hashMap.put("BUGLY_DISABLE", obj.toString());
            }
            Object obj2 = applicationInfo.metaData.get("BUGLY_APPID");
            if (obj2 != null) {
                hashMap.put("BUGLY_APPID", obj2.toString());
            }
            Object obj3 = applicationInfo.metaData.get("BUGLY_APP_CHANNEL");
            if (obj3 != null) {
                hashMap.put("BUGLY_APP_CHANNEL", obj3.toString());
            }
            Object obj4 = applicationInfo.metaData.get("BUGLY_APP_VERSION");
            if (obj4 != null) {
                hashMap.put("BUGLY_APP_VERSION", obj4.toString());
            }
            Object obj5 = applicationInfo.metaData.get("BUGLY_ENABLE_DEBUG");
            if (obj5 != null) {
                hashMap.put("BUGLY_ENABLE_DEBUG", obj5.toString());
            }
            Object obj6 = applicationInfo.metaData.get("com.tencent.rdm.uuid");
            if (obj6 != null) {
                hashMap.put("com.tencent.rdm.uuid", obj6.toString());
            }
            Object obj7 = applicationInfo.metaData.get("BUGLY_APP_BUILD_NO");
            if (obj7 != null) {
                hashMap.put("BUGLY_APP_BUILD_NO", obj7.toString());
            }
            Object obj8 = applicationInfo.metaData.get("BUGLY_AREA");
            if (obj8 != null) {
                hashMap.put("BUGLY_AREA", obj8.toString());
            }
            return hashMap;
        } catch (Throwable th) {
            if (!C1199X.m3080b(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: c */
    public static PackageInfo m3432c(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(m3431d(context), 0);
        } catch (Throwable th) {
            if (C1199X.m3080b(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: d */
    public static String m3431d(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return context.getPackageName();
        } catch (Throwable th) {
            if (C1199X.m3080b(th)) {
                return "fail";
            }
            th.printStackTrace();
            return "fail";
        }
    }

    /* renamed from: e */
    public static boolean m3430e(Context context) {
        if (context == null) {
            return false;
        }
        if (f999c == null) {
            f999c = (ActivityManager) context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        }
        try {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            f999c.getMemoryInfo(memoryInfo);
            if (!memoryInfo.lowMemory) {
                return false;
            }
            C1199X.m3084a("Memory is low.", new Object[0]);
            return true;
        } catch (Throwable th) {
            if (!C1199X.m3080b(th)) {
                th.printStackTrace();
            }
            return false;
        }
    }
}
