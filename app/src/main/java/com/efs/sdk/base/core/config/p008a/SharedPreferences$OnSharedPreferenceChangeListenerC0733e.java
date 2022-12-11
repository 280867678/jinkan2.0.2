package com.efs.sdk.base.core.config.p008a;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import com.efs.sdk.base.core.config.GlobalEnvStruct;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.p007c.C0722f;
import com.efs.sdk.base.core.p007c.HandlerC0714b;
import com.efs.sdk.base.core.util.C0763a;
import com.efs.sdk.base.core.util.C0769b;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.p016c.C0777b;
import com.efs.sdk.base.newsharedpreferences.SharedPreferencesUtils;
import java.io.File;
import java.util.Map;

/* renamed from: com.efs.sdk.base.core.config.a.e */
/* loaded from: classes3.dex */
public final class SharedPreferences$OnSharedPreferenceChangeListenerC0733e implements SharedPreferences.OnSharedPreferenceChangeListener {

    /* renamed from: a */
    public volatile SharedPreferences f256a;

    /* renamed from: a */
    public static boolean m4109a() {
        GlobalEnvStruct globalEnvStruct = ControllerCenter.getGlobalEnvStruct();
        File m4048b = C0763a.m4048b(globalEnvStruct.mAppContext, globalEnvStruct.getAppid());
        if (m4048b.exists()) {
            C0769b.m4031b(m4048b);
            return true;
        }
        return false;
    }

    /* renamed from: b */
    public static void m4107b() {
        File m4050a = C0763a.m4050a(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid());
        if (m4050a.exists()) {
            m4050a.delete();
        }
    }

    /* renamed from: d */
    private void m4105d() {
        if (this.f256a == null) {
            synchronized (HandlerC0714b.class) {
                if (this.f256a == null) {
                    String appid = ControllerCenter.getGlobalEnvStruct().getAppid();
                    this.f256a = SharedPreferencesUtils.getSharedPreferences(ControllerCenter.getGlobalEnvStruct().mAppContext, C0777b.m4008a(("config_" + appid.toLowerCase()).getBytes()));
                    this.f256a.registerOnSharedPreferenceChangeListener(this);
                }
            }
        }
    }

    /* renamed from: a */
    public final boolean m4108a(@NonNull C0728b c0728b) {
        m4106c();
        if (this.f256a == null) {
            return false;
        }
        SharedPreferences.Editor edit = this.f256a.edit();
        edit.clear();
        edit.putInt("cver", c0728b.f238a);
        edit.putLong("last_refresh_time", System.currentTimeMillis());
        for (Map.Entry<String, String> entry : c0728b.f243f.entrySet()) {
            edit.putString(entry.getKey(), entry.getValue());
        }
        edit.apply();
        return true;
    }

    /* renamed from: c */
    public final void m4106c() {
        try {
            m4105d();
        } catch (Throwable th) {
            Log.m4065e("efs.config", "init sharedpreferences error", th);
        }
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        C0722f c0722f;
        c0722f = C0722f.C0724a.f220a;
        if (c0722f.m4138a()) {
            return;
        }
        C0729c.m4127a().m4121b();
    }
}
