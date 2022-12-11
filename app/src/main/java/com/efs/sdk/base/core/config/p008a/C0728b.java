package com.efs.sdk.base.core.config.p008a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.just.agentweb.DefaultWebClient;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.efs.sdk.base.core.config.a.b */
/* loaded from: classes3.dex */
public final class C0728b {

    /* renamed from: a */
    public int f238a = -1;

    /* renamed from: b */
    public String f239b = DefaultWebClient.HTTPS_SCHEME;

    /* renamed from: c */
    public String f240c = "errlog.umeng.com";

    /* renamed from: d */
    public long f241d = 480;

    /* renamed from: g */
    public Boolean f244g = null;

    /* renamed from: e */
    public Map<String, Double> f242e = new HashMap();

    /* renamed from: f */
    public Map<String, String> f243f = new HashMap();

    /* renamed from: a */
    public static C0728b m4129a() {
        C0728b c0728b = new C0728b();
        c0728b.f240c = ControllerCenter.getGlobalEnvStruct().isIntl() ? "errlogos.umeng.com" : "errlog.umeng.com";
        return c0728b;
    }

    /* renamed from: a */
    public final void m4128a(@NonNull Map<String, String> map) {
        if (map.containsKey("gate_way")) {
            String str = map.get("gate_way");
            if (!TextUtils.isEmpty(str)) {
                this.f240c = str;
            }
        }
        if (map.containsKey("gate_way_https")) {
            String str2 = map.get("gate_way_https");
            if (!TextUtils.isEmpty(str2)) {
                this.f239b = Boolean.parseBoolean(str2) ? DefaultWebClient.HTTPS_SCHEME : DefaultWebClient.HTTP_SCHEME;
            }
        }
        try {
            if (map.containsKey("updateInteval")) {
                String str3 = map.get("updateInteval");
                if (!TextUtils.isEmpty(str3)) {
                    this.f241d = Long.parseLong(str3);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            if (key.startsWith("data_sampling_rate_") || key.startsWith("file_sampling_rate_")) {
                String replace = key.replace("data_sampling_rate_", "").replace("file_sampling_rate_", "");
                double d = 100.0d;
                try {
                    d = Double.parseDouble(entry.getValue());
                } catch (Throwable unused) {
                }
                hashMap.put(replace, Double.valueOf(d));
            }
        }
        this.f242e = hashMap;
        this.f243f = map;
    }
}
