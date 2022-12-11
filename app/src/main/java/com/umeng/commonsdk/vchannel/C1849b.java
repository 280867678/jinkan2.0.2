package com.umeng.commonsdk.vchannel;

import android.content.Context;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.Map;
import me.tvspark.outline;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.umeng.commonsdk.vchannel.b */
/* loaded from: classes4.dex */
public class C1849b {

    /* renamed from: b */
    public String f4326b;

    /* renamed from: a */
    public String f4325a = "_$unknown";

    /* renamed from: c */
    public long f4327c = 0;

    /* renamed from: d */
    public long f4328d = 0;

    /* renamed from: e */
    public String f4329e = C1848a.f4324j;

    /* renamed from: f */
    public Map<String, Object> f4330f = null;

    public C1849b(Context context) {
        this.f4326b = UMGlobalContext.getInstance(context).getProcessName(context);
    }

    /* renamed from: a */
    public String m214a() {
        return this.f4325a;
    }

    /* renamed from: a */
    public void m213a(long j) {
        this.f4327c = j;
    }

    /* renamed from: a */
    public void m212a(String str) {
        this.f4325a = str;
    }

    /* renamed from: a */
    public void m211a(Map<String, Object> map) {
        this.f4330f = map;
    }

    /* renamed from: b */
    public long m210b() {
        return this.f4327c;
    }

    /* renamed from: c */
    public Map<String, Object> m209c() {
        return this.f4330f;
    }

    /* renamed from: d */
    public JSONObject m208d() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", this.f4325a);
            jSONObject.put("pn", this.f4326b);
            jSONObject.put("ds", this.f4328d);
            jSONObject.put("ts", this.f4327c);
            if (this.f4330f != null && this.f4330f.size() > 0) {
                for (String str : this.f4330f.keySet()) {
                    jSONObject.put(str, this.f4330f.get(str));
                }
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(this.f4329e, jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("ekv", jSONArray2);
            return jSONObject3;
        } catch (Throwable unused) {
            return null;
        }
    }

    public String toString() {
        String sb;
        StringBuilder sb2 = new StringBuilder("[");
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("id:");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.f4325a);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(",");
        sb2.append(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        sb2.append("pn:" + this.f4326b + ",");
        sb2.append("ts:" + this.f4327c + ",");
        Map<String, Object> map = this.f4330f;
        if (map != null && map.size() > 0) {
            for (String str : this.f4330f.keySet()) {
                Object obj = this.f4330f.get(str);
                if (obj == null) {
                    sb = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, ": null", ",");
                } else {
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, ": ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(obj.toString());
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(",");
                    sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
                }
                sb2.append(sb);
            }
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("ds:");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.f4328d);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append("]");
        sb2.append(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
        return sb2.toString();
    }
}
