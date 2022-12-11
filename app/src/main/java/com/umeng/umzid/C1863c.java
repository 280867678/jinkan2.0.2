package com.umeng.umzid;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.idtracking.C1789g;
import com.umeng.commonsdk.statistics.idtracking.C1790h;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;

/* renamed from: com.umeng.umzid.c */
/* loaded from: classes4.dex */
public class C1863c {
    /* renamed from: a */
    public static String m201a(Context context) {
        SharedPreferences m205a;
        if (context == null || (m205a = C1859a.m205a(context)) == null) {
            return null;
        }
        return m205a.getString("aaid", null);
    }

    /* renamed from: a */
    public static String m199a(String str) {
        try {
            return new String(Base64.decode(str.getBytes("UTF-8"), 2));
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    /* renamed from: a */
    public static void m200a(Context context, String str) {
        SharedPreferences m205a;
        SharedPreferences.Editor edit;
        String m196b = m196b(str);
        if (context == null || m196b == null || TextUtils.isEmpty(m196b) || (m205a = C1859a.m205a(context)) == null || (edit = m205a.edit()) == null) {
            return;
        }
        edit.putString(C1789g.f4109a, m196b).commit();
    }

    /* renamed from: b */
    public static String m198b(Context context) {
        try {
            Class<?> cls = Class.forName(DeviceConfig.LOG_TAG);
            Method declaredMethod = cls.getDeclaredMethod("getMac", Context.class);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(cls, context);
                if (invoke != null && (invoke instanceof String)) {
                    return (String) invoke;
                }
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    /* renamed from: b */
    public static String m196b(String str) {
        try {
            return Base64.encodeToString(str.getBytes("UTF-8"), 2);
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    /* renamed from: b */
    public static void m197b(Context context, String str) {
        SharedPreferences m205a;
        SharedPreferences.Editor edit;
        String m196b = m196b(str);
        if (context == null || m196b == null || TextUtils.isEmpty(m196b) || (m205a = C1859a.m205a(context)) == null || (edit = m205a.edit()) == null) {
            return;
        }
        edit.putString(C1790h.f4114d, m196b).commit();
    }

    /* renamed from: c */
    public static String m195c(Context context) {
        try {
            Class<?> cls = Class.forName(DeviceConfig.LOG_TAG);
            Method declaredMethod = cls.getDeclaredMethod("getOaid", Context.class);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(cls, context);
                if (invoke != null && (invoke instanceof String)) {
                    return (String) invoke;
                }
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    /* renamed from: c */
    public static void m194c(Context context, String str) {
        SharedPreferences m205a;
        SharedPreferences.Editor edit;
        if (context == null || TextUtils.isEmpty(str) || (m205a = C1859a.m205a(context)) == null || (edit = m205a.edit()) == null) {
            return;
        }
        edit.putString("resetToken", str).commit();
    }

    /* renamed from: c */
    public static boolean m193c(String str) {
        return !TextUtils.isEmpty(str) && str.equals(m196b(m199a(str)));
    }

    /* renamed from: d */
    public static void m192d(Context context, String str) {
        SharedPreferences m205a;
        SharedPreferences.Editor edit;
        if (context == null || TextUtils.isEmpty(str) || (m205a = C1859a.m205a(context)) == null || (edit = m205a.edit()) == null) {
            return;
        }
        edit.putString("uabc", str).commit();
    }

    /* renamed from: e */
    public static void m191e(Context context, String str) {
        SharedPreferences m205a;
        SharedPreferences.Editor edit;
        if (context == null || str == null || TextUtils.isEmpty(str) || (m205a = C1859a.m205a(context)) == null || (edit = m205a.edit()) == null) {
            return;
        }
        edit.putString("aaid", str).commit();
    }

    /* renamed from: f */
    public static void m190f(Context context, String str) {
        SharedPreferences m205a;
        SharedPreferences.Editor edit;
        if (context == null || str == null || TextUtils.isEmpty(str) || (m205a = C1859a.m205a(context)) == null || (edit = m205a.edit()) == null) {
            return;
        }
        edit.putString("zdata", str).commit();
    }
}
