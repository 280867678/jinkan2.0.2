package com.p024jg.ids;

import android.content.Context;
import com.umeng.analytics.pro.C1529ab;

/* JADX WARN: Classes with same name are omitted:
  classes.dex
 */
/* renamed from: com.jg.ids.j */
/* loaded from: classes6.dex */
public final class C0974j {
    /* renamed from: a */
    public static String m3741a(String str, String str2) {
        String str3;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            str3 = (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, str2);
        } catch (Exception e) {
            str3 = null;
        }
        if (str3 == null) {
            return "";
        }
        return str3;
    }

    /* renamed from: a */
    public static boolean m3742a(Context context) {
        try {
            context.getPackageManager().getPackageInfo(C1529ab.f2913b, 0);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
