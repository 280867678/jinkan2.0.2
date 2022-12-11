package com.umeng.commonsdk.internal.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.stub.StubApp;

/* renamed from: com.umeng.commonsdk.internal.utils.i */
/* loaded from: classes4.dex */
public class C1747i {

    /* renamed from: a */
    public static final String f3972a = "um_pri";

    /* renamed from: b */
    public static final String f3973b = "um_common_strength";

    /* renamed from: c */
    public static final String f3974c = "um_common_battery";

    /* renamed from: a */
    public static String m657a(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(f3972a, 0)) == null) {
            return null;
        }
        return sharedPreferences.getString(f3974c, null);
    }

    /* renamed from: a */
    public static void m656a(Context context, String str) {
        SharedPreferences sharedPreferences;
        if (context == null || TextUtils.isEmpty(str) || (sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(f3972a, 0)) == null) {
            return;
        }
        sharedPreferences.edit().putString(f3974c, str).commit();
    }
}
