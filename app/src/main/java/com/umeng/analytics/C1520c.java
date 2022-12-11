package com.umeng.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.common.C1687b;

/* renamed from: com.umeng.analytics.c */
/* loaded from: classes4.dex */
public class C1520c {

    /* renamed from: a */
    public static String[] f2891a = new String[2];

    /* renamed from: a */
    public static void m1414a(Context context, String str, String str2) {
        String[] strArr = f2891a;
        strArr[0] = str;
        strArr[1] = str2;
        if (context != null) {
            C1687b.m818a(context).m813a(str, str2);
        }
    }

    /* renamed from: a */
    public static String[] m1415a(Context context) {
        String[] m820a;
        if (TextUtils.isEmpty(f2891a[0]) || TextUtils.isEmpty(f2891a[1])) {
            if (context == null || (m820a = C1687b.m818a(context).m820a()) == null) {
                return null;
            }
            String[] strArr = f2891a;
            strArr[0] = m820a[0];
            strArr[1] = m820a[1];
            return strArr;
        }
        return f2891a;
    }

    /* renamed from: b */
    public static void m1413b(Context context) {
        String[] strArr = f2891a;
        strArr[0] = null;
        strArr[1] = null;
        if (context != null) {
            C1687b.m818a(context).m812b();
        }
    }
}
