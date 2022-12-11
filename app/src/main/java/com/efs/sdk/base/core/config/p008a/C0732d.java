package com.efs.sdk.base.core.config.p008a;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.efs.sdk.base.core.util.Log;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.efs.sdk.base.core.config.a.d */
/* loaded from: classes3.dex */
public final class C0732d {

    /* renamed from: a */
    public static final SimpleDateFormat f255a = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.CHINA);

    /* renamed from: a */
    public static void m4110a(Map<String, String> map, JSONArray jSONArray) {
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = (JSONObject) jSONArray.get(i);
                if (jSONObject != null && jSONObject.length() >= 2) {
                    String optString = jSONObject.optString("opt");
                    Object opt = jSONObject.opt("set");
                    if (optString != null && opt != null) {
                        String optString2 = jSONObject.optString("lt", null);
                        String optString3 = jSONObject.optString("net", null);
                        if (optString2 != null) {
                            optString = optString + "_" + optString2;
                        }
                        if (optString3 != null) {
                            optString = optString + "_" + optString3;
                        }
                        map.put(optString, String.valueOf(opt));
                    }
                }
            } catch (Throwable th) {
                Log.m4065e("efs.config", "updateConfigCond error", th);
                return;
            }
        }
    }

    /* renamed from: a */
    public static boolean m4111a(@NonNull String str, @NonNull C0728b c0728b) {
        try {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject("config");
            int i = jSONObject.getInt("cver");
            if (optJSONObject != null && optJSONObject.length() > 0) {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("common");
                if (optJSONObject2 != null && optJSONObject2.length() > 0) {
                    Iterator<String> keys = optJSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        hashMap.put(next, optJSONObject2.optString(next, ""));
                    }
                }
                JSONArray optJSONArray = optJSONObject.optJSONArray("app_configs");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject jSONObject2 = (JSONObject) optJSONArray.get(i2);
                        if (jSONObject2 != null && jSONObject2.length() == 2) {
                            JSONArray optJSONArray2 = jSONObject2.optJSONArray("conditions");
                            JSONArray optJSONArray3 = jSONObject2.optJSONArray(NotificationCompat.WearableExtender.KEY_ACTIONS);
                            if (optJSONArray2 != null && optJSONArray3 != null && optJSONArray3.length() > 0) {
                                m4110a(hashMap, optJSONArray3);
                            }
                        }
                    }
                }
            }
            c0728b.m4128a(hashMap);
            c0728b.f238a = i;
            return true;
        } catch (Throwable th) {
            Log.m4065e("efs.config", "parseConfig error, data is ".concat(String.valueOf(str)), th);
            return false;
        }
    }
}
