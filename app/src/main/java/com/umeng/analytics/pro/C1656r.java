package com.umeng.analytics.pro;

import android.content.Context;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.service.UMGlobalContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.umeng.analytics.pro.r */
/* loaded from: classes4.dex */
public class C1656r {

    /* renamed from: a */
    public static final int f3623a = 0;

    /* renamed from: b */
    public static final int f3624b = 1;

    /* renamed from: c */
    public static final int f3625c = 2;

    /* renamed from: d */
    public static final int f3626d = 3;

    /* renamed from: e */
    public final long f3627e;

    /* renamed from: com.umeng.analytics.pro.r$a */
    /* loaded from: classes4.dex */
    public static class C1658a {

        /* renamed from: a */
        public static final C1656r f3628a = new C1656r();
    }

    public C1656r() {
        this.f3627e = 60000L;
    }

    /* renamed from: a */
    public static C1656r m923a() {
        return C1658a.f3628a;
    }

    /* renamed from: a */
    private void m920a(JSONObject jSONObject, boolean z) {
        if (!z && jSONObject.has(C1615d.f3348n)) {
            jSONObject.remove(C1615d.f3348n);
        }
        if (jSONObject.has(C1615d.f3286L)) {
            jSONObject.remove(C1615d.f3286L);
        }
        if (jSONObject.has("error")) {
            jSONObject.remove("error");
        }
        if (jSONObject.has("ekv")) {
            jSONObject.remove("ekv");
        }
        if (jSONObject.has(C1615d.f3294T)) {
            jSONObject.remove(C1615d.f3294T);
        }
        if (jSONObject.has(C1615d.f3286L)) {
            jSONObject.remove(C1615d.f3286L);
        }
        if (jSONObject.has("userlevel")) {
            jSONObject.remove("userlevel");
        }
    }

    /* renamed from: b */
    private JSONArray m919b() {
        JSONArray jSONArray = new JSONArray();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", C1669y.m870a().m867a(UMGlobalContext.getAppContext(null)));
            jSONObject.put(C1615d.f3350p, currentTimeMillis);
            jSONObject.put(C1615d.f3351q, currentTimeMillis + 60000);
            jSONObject.put("duration", 60000L);
            jSONArray.put(jSONObject);
        } catch (JSONException unused) {
        }
        return jSONArray;
    }

    /* renamed from: c */
    private JSONArray m917c() {
        JSONArray jSONArray = new JSONArray();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", C1669y.m870a().m859d(UMGlobalContext.getAppContext(null)));
            jSONObject.put(C1615d.f3350p, currentTimeMillis);
            jSONArray.put(jSONObject);
        } catch (JSONException unused) {
        }
        return jSONArray;
    }

    /* renamed from: a */
    public int m922a(Context context) {
        return Integer.valueOf(UMEnvelopeBuild.imprintProperty(context, "defcon", String.valueOf(0))).intValue();
    }

    /* renamed from: a */
    public void m921a(JSONObject jSONObject, Context context) {
        int m922a = m922a(context);
        if (m922a != 1) {
            if (m922a != 2) {
                if (m922a != 3) {
                    return;
                }
                m920a(jSONObject, false);
                C1636i.m1056a(context).m1036b(false, true);
            }
            jSONObject.remove(C1615d.f3348n);
            try {
                jSONObject.put(C1615d.f3348n, m919b());
            } catch (Exception unused) {
            }
        }
        m920a(jSONObject, true);
        C1636i.m1056a(context).m1036b(false, true);
    }

    /* renamed from: b */
    public void m918b(JSONObject jSONObject, Context context) {
        int m922a = m922a(context);
        if (m922a == 1) {
            if (jSONObject.has(C1615d.f3286L)) {
                jSONObject.remove(C1615d.f3286L);
            }
            if (jSONObject.has(C1615d.f3348n)) {
                try {
                    JSONArray jSONArray = jSONObject.getJSONArray(C1615d.f3348n);
                    int length = jSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        if (jSONObject2.has(C1615d.f3330au)) {
                            jSONObject2.remove(C1615d.f3330au);
                        }
                        if (jSONObject2.has(C1615d.f3331av)) {
                            jSONObject2.remove(C1615d.f3331av);
                        }
                    }
                } catch (JSONException | Exception unused) {
                }
            }
        } else if (m922a == 2) {
            if (jSONObject.has(C1615d.f3286L)) {
                jSONObject.remove(C1615d.f3286L);
            }
            if (jSONObject.has(C1615d.f3348n)) {
                jSONObject.remove(C1615d.f3348n);
            }
            jSONObject.put(C1615d.f3348n, m917c());
        } else if (m922a != 3) {
            return;
        } else {
            if (jSONObject.has(C1615d.f3286L)) {
                jSONObject.remove(C1615d.f3286L);
            }
            jSONObject.remove(C1615d.f3348n);
        }
        C1636i.m1056a(context).m1044a(false, true);
    }
}
