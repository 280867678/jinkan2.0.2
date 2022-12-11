package com.tencent.smtt.sdk.p044a;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.smtt.sdk.a.d */
/* loaded from: classes4.dex */
public class C1348d {

    /* renamed from: a */
    public int f2061a;

    /* renamed from: b */
    public long f2062b;

    /* renamed from: c */
    public List<C1346b> f2063c;

    /* renamed from: a */
    public static C1348d m2644a(String str) {
        JSONException e;
        C1348d c1348d;
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                c1348d = new C1348d();
                try {
                    c1348d.f2061a = jSONObject.optInt("ret_code", -1);
                    c1348d.f2062b = jSONObject.optLong("next_req_interval", 1000L);
                    JSONArray optJSONArray = jSONObject.optJSONArray("cmds");
                    if (optJSONArray != null) {
                        c1348d.f2063c = new ArrayList();
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            C1346b m2659a = C1346b.m2659a(optJSONArray.optJSONObject(i));
                            if (m2659a != null) {
                                c1348d.f2063c.add(m2659a);
                            }
                        }
                    }
                } catch (JSONException e2) {
                    e = e2;
                    e.printStackTrace();
                    return c1348d;
                }
            } catch (JSONException e3) {
                e = e3;
                c1348d = null;
            }
            return c1348d;
        }
        return null;
    }

    /* renamed from: a */
    public int m2645a() {
        return this.f2061a;
    }

    /* renamed from: b */
    public long m2643b() {
        return this.f2062b;
    }

    /* renamed from: c */
    public List<C1346b> m2642c() {
        return this.f2063c;
    }
}
