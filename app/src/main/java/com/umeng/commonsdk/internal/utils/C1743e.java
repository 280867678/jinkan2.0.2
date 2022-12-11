package com.umeng.commonsdk.internal.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.stub.StubApp;

/* renamed from: com.umeng.commonsdk.internal.utils.e */
/* loaded from: classes4.dex */
public class C1743e {

    /* renamed from: a */
    public static final String f3970a = "info";

    /* renamed from: b */
    public static final String f3971b = "ua";

    /* renamed from: a */
    public static String m664a(Context context) {
        SharedPreferences sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences("info", 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getString(f3971b, null);
        }
        return null;
    }

    /* renamed from: a */
    public static void m663a(Context context, String str) {
        SharedPreferences sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences("info", 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(f3971b, str).commit();
        }
    }
}
