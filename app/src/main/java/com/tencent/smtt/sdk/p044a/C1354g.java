package com.tencent.smtt.sdk.p044a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.tencent.smtt.sdk.a.g */
/* loaded from: classes4.dex */
public class C1354g {

    /* renamed from: a */
    public static C1354g f2080a;

    /* renamed from: b */
    public static C1353f f2081b;

    /* renamed from: a */
    public static synchronized C1354g m2632a() {
        C1354g c1354g;
        synchronized (C1354g.class) {
            if (f2080a == null) {
                f2080a = new C1354g();
            }
            c1354g = f2080a;
        }
        return c1354g;
    }

    /* renamed from: a */
    public static String m2625a(String[] strArr) {
        StringBuilder sb = new StringBuilder();
        if (strArr != null && strArr.length > 0) {
            if (strArr.length > 1) {
                for (int i = 0; i < strArr.length - 1; i++) {
                    sb.append(strArr[i]);
                    sb.append(",");
                }
            }
            sb.append(strArr[strArr.length - 1]);
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static String[] m2626a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.split(",");
        }
        return null;
    }

    /* renamed from: b */
    private synchronized SharedPreferences m2623b(Context context) {
        return context.getSharedPreferences("tbs_emergence", 4);
    }

    /* renamed from: a */
    public List<String> m2630a(Context context, String str) {
        String string = m2623b(context).getString(str, "");
        ArrayList arrayList = new ArrayList();
        String[] split = string.split(";");
        if (split.length > 0) {
            arrayList.addAll(Arrays.asList(split));
        }
        return arrayList;
    }

    /* renamed from: a */
    public void m2631a(Context context) {
        f2081b = C1353f.m2634a(new File(context.getFilesDir(), "prefs.lock"));
    }

    /* renamed from: a */
    public void m2629a(Context context, String str, long j) {
        SharedPreferences.Editor edit = m2623b(context).edit();
        edit.putLong(str, j);
        edit.apply();
        edit.commit();
    }

    /* renamed from: a */
    public void m2628a(Context context, String str, String str2) {
        List<String> m2630a = m2630a(context, str);
        m2630a.add(str2);
        m2627a(context, str, m2630a);
    }

    /* renamed from: a */
    public void m2627a(Context context, String str, List<String> list) {
        SharedPreferences.Editor edit = m2623b(context).edit();
        StringBuilder sb = new StringBuilder();
        if (list != null && !list.isEmpty()) {
            if (list.size() > 1) {
                for (int i = 0; i < list.size() - 1; i++) {
                    sb.append(list.get(i));
                    sb.append(";");
                }
            }
            sb.append(list.get(list.size() - 1));
        }
        edit.putString(str, sb.toString());
        edit.apply();
        edit.commit();
    }

    /* renamed from: b */
    public long m2622b(Context context, String str) {
        return m2623b(context).getLong(str, -1L);
    }

    /* renamed from: b */
    public boolean m2624b() {
        return f2081b != null;
    }

    /* renamed from: c */
    public void m2621c() {
        C1353f c1353f = f2081b;
        if (c1353f != null) {
            c1353f.m2633b();
            f2081b = null;
        }
    }
}
