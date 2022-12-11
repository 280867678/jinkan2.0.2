package com.efs.sdk.launch;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import android.text.TextUtils;
import androidx.appcompat.widget.ActivityChooserModel;
import com.stub.StubApp;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.efs.sdk.launch.c */
/* loaded from: classes3.dex */
public final class C0792c {

    /* renamed from: a */
    public static String f370a = "";

    /* renamed from: a */
    public static String m3988a(Context context) {
        Class<?> cls;
        Method method;
        if (context == null) {
            return null;
        }
        try {
            cls = Class.forName("com.umeng.commonsdk.UMConfigure");
        } catch (ClassNotFoundException unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            method = cls.getMethod("getUMIDString", Context.class);
        } catch (NoSuchMethodException unused2) {
            method = null;
        }
        if (method == null) {
            return null;
        }
        try {
            Object invoke = method.invoke(null, context);
            if (invoke == null) {
                return null;
            }
            return invoke.toString();
        } catch (IllegalAccessException | InvocationTargetException unused3) {
            return null;
        }
    }

    /* renamed from: a */
    public static void m3987a(Context context, String str) {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor edit;
        if (context == null || str == null || TextUtils.isEmpty(str) || (sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences("efs_launch", 0)) == null || (edit = sharedPreferences.edit()) == null) {
            return;
        }
        edit.putString("first_launch_cache", str);
        edit.commit();
    }

    /* renamed from: b */
    public static String m3986b(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences("efs_launch", 0)) == null) {
            return null;
        }
        return sharedPreferences.getString("first_launch_cache", null);
    }

    /* renamed from: c */
    public static void m3985c(Context context) {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor edit;
        if (context == null || (sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences("efs_launch", 0)) == null || (edit = sharedPreferences.edit()) == null) {
            return;
        }
        edit.putString("first_launch_cache", null);
        edit.commit();
    }

    /* renamed from: d */
    public static boolean m3984d(Context context) {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor edit;
        SharedPreferences sharedPreferences2;
        if ((context == null || (sharedPreferences2 = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences("efs_launch", 0)) == null) ? false : sharedPreferences2.getBoolean("is_install", false)) {
            return false;
        }
        if (context != null && (sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences("efs_launch", 0)) != null && (edit = sharedPreferences.edit()) != null) {
            edit.putBoolean("is_install", true);
            edit.commit();
        }
        return true;
    }

    /* renamed from: e */
    public static boolean m3983e(Context context) {
        try {
            String m3982f = m3982f(context);
            String packageName = StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageName();
            if (TextUtils.isEmpty(m3982f) || TextUtils.isEmpty(packageName)) {
                return false;
            }
            return m3982f.equals(packageName);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0036, code lost:
        com.efs.sdk.launch.C0792c.f370a = r1.processName;
     */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String m3982f(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (TextUtils.isEmpty(f370a)) {
            try {
                int myPid = Process.myPid();
                ActivityManager activityManager = (ActivityManager) context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY);
                if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null && runningAppProcesses.size() > 0) {
                    Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ActivityManager.RunningAppProcessInfo next = it.next();
                        if (next.pid == myPid) {
                            break;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return f370a;
    }
}
