package com.umeng.commonsdk.internal.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.stub.StubApp;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.ULog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.json.JSONObject;

/* renamed from: com.umeng.commonsdk.internal.utils.j */
/* loaded from: classes4.dex */
public class C1748j {

    /* renamed from: a */
    public static final String f3975a = "UM_PROBE_DATA";

    /* renamed from: b */
    public static final String f3976b = "_dsk_s";

    /* renamed from: c */
    public static final String f3977c = "_thm_z";

    /* renamed from: d */
    public static final String f3978d = "_gdf_r";

    /* renamed from: e */
    public static Object f3979e = new Object();

    /* renamed from: a */
    public static int m652a(String str, String str2) throws IOException {
        int i;
        if (Build.VERSION.SDK_INT > 28) {
            return -1;
        }
        Process exec = Runtime.getRuntime().exec(str);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                i = -1;
                break;
            } else if (readLine.contains(str2)) {
                i = 1;
                break;
            }
        }
        try {
            if (exec.waitFor() == 0) {
                return i;
            }
            return -1;
        } catch (InterruptedException unused) {
            return -1;
        }
    }

    /* renamed from: a */
    public static String m655a() {
        int i;
        try {
            i = m652a("ls /sys/class/thermal", "thermal_zone");
        } catch (Throwable unused) {
            i = -1;
        }
        return i > 0 ? "thermal_zone" : i < 0 ? "noper" : "unknown";
    }

    /* renamed from: a */
    public static String m654a(Context context) {
        try {
            SharedPreferences sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(f3975a, 0);
            if (sharedPreferences == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            synchronized (f3979e) {
                jSONObject.put(f3976b, sharedPreferences.getString(f3976b, ""));
                jSONObject.put(f3977c, sharedPreferences.getString(f3977c, ""));
                jSONObject.put(f3978d, sharedPreferences.getString(f3978d, ""));
            }
            return jSONObject.toString();
        } catch (Exception e) {
            UMCrashManager.reportCrash(context, e);
            return null;
        }
    }

    /* renamed from: b */
    public static String m651b() {
        int i;
        try {
            i = m652a("ls /", "goldfish");
        } catch (Throwable unused) {
            i = -1;
        }
        return i > 0 ? "goldfish" : i < 0 ? "noper" : "unknown";
    }

    /* renamed from: b */
    public static void m650b(final Context context) {
        if (!m647c(context)) {
            final String[] strArr = {"unknown", "unknown", "unknown"};
            new Thread() { // from class: com.umeng.commonsdk.internal.utils.j.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    super.run();
                    try {
                        strArr[0] = C1748j.m648c();
                        strArr[1] = C1748j.m655a();
                        strArr[2] = C1748j.m651b();
                        ULog.m538i("diskType = " + strArr[0] + "; ThremalZone = " + strArr[1] + "; GoldFishRc = " + strArr[2]);
                        C1748j.m649b(context, strArr);
                    } catch (Throwable th) {
                        UMCrashManager.reportCrash(context, th);
                    }
                }
            }.start();
        }
    }

    /* renamed from: b */
    public static void m649b(Context context, String[] strArr) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(f3975a, 0)) == null) {
            return;
        }
        synchronized (f3979e) {
            sharedPreferences.edit().putString(f3976b, strArr[0]).putString(f3977c, strArr[1]).putString(f3978d, strArr[2]).commit();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0039 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String m648c() {
        String str;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/diskstats"));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    str = "mtd";
                    if (readLine == null) {
                        str = "unknown";
                        break;
                    } else if (!readLine.contains("mmcblk")) {
                        if (!readLine.contains("sda")) {
                            if (readLine.contains(str)) {
                                break;
                            }
                        } else {
                            str = "sda";
                            break;
                        }
                    } else {
                        str = "mmcblk";
                        break;
                    }
                } catch (Throwable unused) {
                    bufferedReader2 = bufferedReader;
                    str = "noper";
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                    }
                    return str;
                }
            }
        } catch (Throwable unused2) {
        }
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (Throwable unused3) {
            }
        }
        return str;
    }

    /* renamed from: c */
    public static boolean m647c(Context context) {
        SharedPreferences sharedPreferences;
        return (context == null || (sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(f3975a, 0)) == null || TextUtils.isEmpty(sharedPreferences.getString(f3976b, ""))) ? false : true;
    }
}
