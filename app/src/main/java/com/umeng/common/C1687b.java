package com.umeng.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.stub.StubApp;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import me.tvspark.outline;

/* renamed from: com.umeng.common.b */
/* loaded from: classes4.dex */
public final class C1687b {

    /* renamed from: a */
    public static C1687b f3717a = null;

    /* renamed from: b */
    public static Context f3718b = null;

    /* renamed from: c */
    public static String f3719c = null;

    /* renamed from: d */
    public static final String f3720d = "mobclick_agent_user_";

    /* renamed from: com.umeng.common.b$a */
    /* loaded from: classes4.dex */
    public static final class C1688a {

        /* renamed from: a */
        public static final C1687b f3721a = new C1687b();
    }

    /* renamed from: a */
    public static synchronized C1687b m818a(Context context) {
        C1687b c1687b;
        synchronized (C1687b.class) {
            if (f3718b == null && context != null) {
                f3718b = StubApp.getOrigApplicationContext(context.getApplicationContext());
            }
            if (f3718b != null) {
                f3719c = context.getPackageName();
            }
            c1687b = C1688a.f3721a;
        }
        return c1687b;
    }

    /* renamed from: a */
    public static String m816a(Context context, String str, String str2) {
        SharedPreferences sharedPreferences;
        return (context == null || (sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(str, 0)) == null) ? "" : sharedPreferences.getString(str2, "");
    }

    /* renamed from: a */
    public static void m817a(Context context, String str) {
        SharedPreferences.Editor edit = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(str, 0).edit();
        edit.remove("debugkey");
        edit.remove(AnalyticsConfig.RTD_PERIOD);
        edit.remove(AnalyticsConfig.RTD_START_TIME);
        edit.clear();
        edit.commit();
    }

    /* renamed from: a */
    public static void m815a(Context context, String str, String str2, String str3) {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor edit;
        if (context == null || (sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(str, 0)) == null || (edit = sharedPreferences.edit()) == null) {
            return;
        }
        edit.putString(str2, str3);
        edit.commit();
    }

    /* renamed from: e */
    private SharedPreferences m809e() {
        Context context = f3718b;
        if (context == null) {
            return null;
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("mobclick_agent_user_");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(f3719c);
        return context.getSharedPreferences(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), 0);
    }

    /* renamed from: a */
    public void m819a(int i) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f3718b);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("vt", i).commit();
        }
    }

    /* renamed from: a */
    public void m814a(String str) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f3718b);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("st", str).commit();
        }
    }

    /* renamed from: a */
    public void m813a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        SharedPreferences.Editor edit = m809e().edit();
        edit.putString("au_p", str);
        edit.putString("au_u", str2);
        edit.commit();
    }

    /* renamed from: a */
    public String[] m820a() {
        SharedPreferences m809e = m809e();
        if (m809e != null) {
            String string = m809e.getString("au_p", null);
            String string2 = m809e.getString("au_u", null);
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                return new String[]{string, string2};
            }
            return null;
        }
        return null;
    }

    /* renamed from: b */
    public void m812b() {
        SharedPreferences m809e = m809e();
        if (m809e != null) {
            m809e.edit().remove("au_p").remove("au_u").commit();
        }
    }

    /* renamed from: c */
    public String m811c() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f3718b);
        if (sharedPreferences != null) {
            return sharedPreferences.getString("st", null);
        }
        return null;
    }

    /* renamed from: d */
    public int m810d() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f3718b);
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("vt", 0);
        }
        return 0;
    }
}
