package com.efs.sdk.base.core.config;

import android.text.TextUtils;
import com.efs.sdk.base.core.p005a.C0694a;
import com.efs.sdk.base.protocol.file.section.AbsSection;
import com.efs.sdk.base.protocol.file.section.KVSection;
import com.p038qq.p039e.comm.p040pi.ACTD;
import com.umeng.umcrash.UMCrash;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.efs.sdk.base.core.config.a */
/* loaded from: classes3.dex */
public final class C0725a {

    /* renamed from: a */
    public Map<String, Object> f236a = new ConcurrentHashMap();

    /* renamed from: a */
    public final List<AbsSection> m4134a(String str) {
        ArrayList arrayList = new ArrayList();
        KVSection kVSection = new KVSection("global_head");
        KVSection put = kVSection.put("type", str).put(ACTD.APPID_KEY, this.f236a.get(ACTD.APPID_KEY)).put("wid", this.f236a.get("wid")).put("pid", this.f236a.get("pid")).put("pkg", this.f236a.get("pkg")).put("ver", this.f236a.get("ver")).put("vcode", this.f236a.get("vcode")).put("ps", this.f236a.get("ps")).put("stime", this.f236a.get("stime"));
        C0694a.m4184a();
        KVSection put2 = put.put("ctime", Long.valueOf(C0694a.m4180b() / 1000));
        C0694a.m4184a();
        put2.put("w_tm", Long.valueOf(C0694a.m4180b() / 1000)).put("sdk_ver", this.f236a.get("sdk_ver"));
        String valueOf = String.valueOf(m4132b("uid", ""));
        if (!TextUtils.isEmpty(valueOf)) {
            kVSection.put("uid", valueOf);
        }
        arrayList.add(kVSection);
        KVSection kVSection2 = new KVSection("device_info");
        kVSection2.put("lang", this.f236a.get("lang")).put("brand", this.f236a.get("brand")).put("model", this.f236a.get("model")).put("build_model", this.f236a.get("build_model")).put("rom", this.f236a.get("rom")).put("sdk", this.f236a.get("sdk")).put("dsp_h", this.f236a.get("dsp_h")).put("dsp_w", this.f236a.get("dsp_w")).put("tzone", this.f236a.get("tzone")).put("net", this.f236a.get("net")).put("fr", this.f236a.get("fr"));
        try {
            if (this.f236a.containsKey(UMCrash.KEY_HEADER_ACCESS)) {
                kVSection2.put(UMCrash.KEY_HEADER_ACCESS, this.f236a.get(UMCrash.KEY_HEADER_ACCESS));
            }
            if (this.f236a.containsKey(UMCrash.KEY_HEADER_ACCESS_SUBTYPE)) {
                kVSection2.put(UMCrash.KEY_HEADER_ACCESS_SUBTYPE, this.f236a.get(UMCrash.KEY_HEADER_ACCESS_SUBTYPE));
            }
            if (this.f236a.containsKey(UMCrash.KEY_HEADER_NETWORK_TYPE)) {
                kVSection2.put(UMCrash.KEY_HEADER_NETWORK_TYPE, this.f236a.get(UMCrash.KEY_HEADER_NETWORK_TYPE));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        arrayList.add(kVSection2);
        return arrayList;
    }

    /* renamed from: a */
    public final Map<String, Object> m4135a() {
        HashMap hashMap = new HashMap(this.f236a);
        C0694a.m4184a();
        hashMap.put("ctime", Long.valueOf(C0694a.m4180b() / 1000));
        C0694a.m4184a();
        hashMap.put("w_tm", Long.valueOf(C0694a.m4180b() / 1000));
        return hashMap;
    }

    /* renamed from: a */
    public final void m4133a(String str, Object obj) {
        this.f236a.put(str, obj);
    }

    /* renamed from: b */
    public final Object m4132b(String str, Object obj) {
        Object obj2 = this.f236a.get(str);
        return (obj2 != null || this.f236a.containsKey(str)) ? obj2 : obj;
    }
}
