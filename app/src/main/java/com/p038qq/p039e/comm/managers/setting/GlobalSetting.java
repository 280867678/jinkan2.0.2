package com.p038qq.p039e.comm.managers.setting;

import android.text.TextUtils;
import com.p038qq.p039e.comm.util.GDTLogger;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.qq.e.comm.managers.setting.GlobalSetting */
/* loaded from: classes3.dex */
public final class GlobalSetting {
    public static final String BD_SDK_WRAPPER = "BD";
    public static final String KS_SDK_WRAPPER = "KS";
    public static final String TT_SDK_WRAPPER = "TT";
    public static volatile Boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
    public static volatile Boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
    public static volatile Boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
    public static volatile Integer Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
    public static volatile boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
    public static volatile boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static volatile Integer Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static volatile Map<String, String> Wwwwwwwwwwwwwwwwwwwwwwwwwww = new HashMap();
    public static volatile Map<String, String> Wwwwwwwwwwwwwwwwwwwwwwwwww = new HashMap();
    public static final Map<String, String> Wwwwwwwwwwwwwwwwwwwwwwwww = new HashMap();
    public static final JSONObject Wwwwwwwwwwwwwwwwwwwwwwww = new JSONObject();
    public static volatile String Wwwwwwwwwwwwwwwwwwwwwww = null;
    public static volatile String Wwwwwwwwwwwwwwwwwwwwww = null;
    public static volatile String Wwwwwwwwwwwwwwwwwwwww = null;
    public static volatile String Wwwwwwwwwwwwwwwwwwww = null;
    public static volatile String Wwwwwwwwwwwwwwwwwww = null;

    public static Boolean getAgreeReadAndroidId() {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public static Boolean getAgreeReadDeviceId() {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public static Integer getChannel() {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public static String getCustomADActivityClassName() {
        return Wwwwwwwwwwwwwwwwwwwwwww;
    }

    public static String getCustomLandscapeActivityClassName() {
        return Wwwwwwwwwwwwwwwwwwww;
    }

    public static String getCustomPortraitActivityClassName() {
        return Wwwwwwwwwwwwwwwwwwwwww;
    }

    public static String getCustomRewardvideoLandscapeActivityClassName() {
        return Wwwwwwwwwwwwwwwwwww;
    }

    public static String getCustomRewardvideoPortraitActivityClassName() {
        return Wwwwwwwwwwwwwwwwwwwww;
    }

    public static Map<String, String> getExtraUserData() {
        return Collections.unmodifiableMap(Wwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public static Integer getPersonalizedState() {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public static Map<String, String> getPreloadAdapterMaps() {
        return Wwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public static JSONObject getSettings() {
        return Wwwwwwwwwwwwwwwwwwwwwwww;
    }

    public static boolean isAgreePrivacyStrategy() {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.booleanValue();
    }

    public static boolean isAgreeReadAndroidId() {
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            return true;
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwww.booleanValue();
    }

    public static boolean isAgreeReadDeviceId() {
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            return true;
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.booleanValue();
    }

    public static boolean isEnableMediationTool() {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public static boolean isEnableVideoDownloadingCache() {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public static void setAgreePrivacyStrategy(boolean z) {
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Boolean.valueOf(z);
        }
    }

    public static void setAgreeReadAndroidId(boolean z) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwww = Boolean.valueOf(z);
    }

    public static void setAgreeReadDeviceId(boolean z) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = Boolean.valueOf(z);
    }

    public static void setChannel(int i) {
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Integer.valueOf(i);
        }
    }

    public static void setCustomADActivityClassName(String str) {
        Wwwwwwwwwwwwwwwwwwwwwww = str;
    }

    public static void setCustomLandscapeActivityClassName(String str) {
        Wwwwwwwwwwwwwwwwwwww = str;
    }

    public static void setCustomPortraitActivityClassName(String str) {
        Wwwwwwwwwwwwwwwwwwwwww = str;
    }

    public static void setCustomRewardvideoLandscapeActivityClassName(String str) {
        Wwwwwwwwwwwwwwwwwww = str;
    }

    public static void setCustomRewardvideoPortraitActivityClassName(String str) {
        Wwwwwwwwwwwwwwwwwwwww = str;
    }

    public static void setEnableCollectAppInstallStatus(boolean z) {
        try {
            Wwwwwwwwwwwwwwwwwwwwwwww.putOpt("ecais", Boolean.valueOf(z));
        } catch (JSONException unused) {
        }
    }

    public static void setEnableMediationTool(boolean z) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
    }

    public static void setEnableVideoDownloadingCache(boolean z) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void setExtraUserData(Map<String, String> map) {
        if (map == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (TextUtils.isEmpty(entry.getKey()) || TextUtils.isEmpty(entry.getValue())) {
                GDTLogger.m3646e("参数key和value不能为空！");
                return;
            }
            while (r0.hasNext()) {
            }
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwww = map;
    }

    public static void setMediaExtData(Map<String, String> map, boolean z) {
        if (map == null) {
            return;
        }
        if (z) {
            Wwwwwwwwwwwwwwwwwwwwwwwwww = new HashMap();
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue())) {
                Wwwwwwwwwwwwwwwwwwwwwwwwww.put(entry.getKey(), entry.getValue());
            }
        }
        try {
            Wwwwwwwwwwwwwwwwwwwwwwww.putOpt("media_ext", new JSONObject(Wwwwwwwwwwwwwwwwwwwwwwwwww));
        } catch (JSONException unused) {
            GDTLogger.m3646e("setMediaExtData失败，请检查");
        }
    }

    public static void setPersonalizedState(int i) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Integer.valueOf(i);
    }

    public static void setPreloadAdapters(Map<String, String> map) {
        if (map == null) {
            return;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwww.putAll(map);
    }
}
