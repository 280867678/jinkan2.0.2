package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.smtt.export.external.TbsCoreSettings;
import com.tencent.smtt.utils.TbsLog;
import com.umeng.commonsdk.statistics.idtracking.C1783b;
import com.umeng.commonsdk.statistics.idtracking.C1789g;
import java.util.HashMap;
import org.mozilla.javascript.ES6Iterator;

/* loaded from: classes4.dex */
public enum TbsPrivacyAccess {
    DeviceId(false),
    Imsi(false),
    AndroidId(false),
    MacAddress(false),
    AndroidVersion(true),
    DeviceModel(true),
    AppList(true);
    
    @Deprecated

    /* renamed from: a */
    public static boolean f1922a = true;

    /* renamed from: b */
    public boolean f1924b;

    /* loaded from: classes4.dex */
    public enum ConfigurablePrivacy {
        IMSI("imsi"),
        ANDROID_ID(C1783b.f4089a),
        MAC(C1789g.f4109a),
        ANDROID_VERSION("android_version"),
        DEVICE_MODEL("device_model"),
        APP_LIST("app_list"),
        QIMEI36("qimei36");
        

        /* renamed from: a */
        public String f1926a;

        ConfigurablePrivacy(String str) {
            this.f1926a = str;
        }
    }

    TbsPrivacyAccess(boolean z) {
        this.f1924b = z;
    }

    /* renamed from: a */
    public static void m2748a(SharedPreferences.Editor editor, ConfigurablePrivacy configurablePrivacy, String str) {
        if (!TextUtils.isEmpty(str)) {
            editor.putString(configurablePrivacy.f1926a, str);
            TbsLog.m2155i("TbsPrivacy", "configurePrivacy " + configurablePrivacy.f1926a + " is " + str);
        }
    }

    public static void configureAllPrivacy(Context context, Bundle bundle) {
        ConfigurablePrivacy[] values;
        if (bundle == null) {
            return;
        }
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("uifa", 0).edit();
            for (ConfigurablePrivacy configurablePrivacy : ConfigurablePrivacy.values()) {
                if (bundle.containsKey(configurablePrivacy.f1926a)) {
                    m2748a(edit, configurablePrivacy, bundle.getString(configurablePrivacy.f1926a));
                }
            }
            edit.putString("app_call", ES6Iterator.DONE_PROPERTY);
            edit.commit();
        } catch (Throwable unused) {
        }
    }

    public static void configureAllPrivacy(Context context, String str) {
        if (str == null) {
            return;
        }
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("uifa", 0).edit();
            edit.putString("app_list", str);
            edit.putString("app_call", ES6Iterator.DONE_PROPERTY);
            edit.commit();
        } catch (Throwable unused) {
        }
    }

    public static void configurePrivacy(Context context, ConfigurablePrivacy configurablePrivacy, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("uifa", 0).edit();
        m2748a(edit, configurablePrivacy, str);
        edit.commit();
    }

    @Deprecated
    public static void disableSensitiveApi() {
        f1922a = false;
        HashMap hashMap = new HashMap();
        hashMap.put(TbsCoreSettings.NO_SENSITIVE_API, true);
        QbSdk.initTbsSettings(hashMap);
    }

    public static String getConfigurePrivacy(Context context, ConfigurablePrivacy configurablePrivacy, String str) {
        return context.getSharedPreferences("uifa", 0).getString(configurablePrivacy.f1926a, str);
    }

    @Deprecated
    public static boolean isEnableSensitiveApi() {
        return f1922a;
    }

    public boolean isDisabled() {
        return !this.f1924b;
    }

    public boolean isEnabled() {
        return this.f1924b;
    }

    public void setEnabled(boolean z) {
        this.f1924b = z;
        TbsLog.m2155i("TbsPrivacy", name() + " is " + z);
    }
}
