package com.tencent.smtt.sdk.p044a;

import android.text.TextUtils;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.smtt.sdk.a.c */
/* loaded from: classes4.dex */
public class C1347c {

    /* renamed from: a */
    public String f2053a;

    /* renamed from: b */
    public String f2054b;

    /* renamed from: c */
    public Integer f2055c;

    /* renamed from: d */
    public String f2056d;

    /* renamed from: e */
    public String f2057e;

    /* renamed from: f */
    public Integer f2058f;

    /* renamed from: g */
    public Integer f2059g;

    /* renamed from: h */
    public List<Integer> f2060h;

    /* renamed from: a */
    public String m2654a() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.f2053a)) {
                jSONObject2.put("PP", this.f2053a);
            }
            if (!TextUtils.isEmpty(this.f2054b)) {
                jSONObject2.put("PPVN", this.f2054b);
            }
            if (this.f2055c != null) {
                jSONObject2.put("ADRV", this.f2055c);
            }
            if (!TextUtils.isEmpty(this.f2056d)) {
                jSONObject2.put("MODEL", this.f2056d);
            }
            if (!TextUtils.isEmpty(this.f2057e)) {
                jSONObject2.put("NAME", this.f2057e);
            }
            if (this.f2058f != null) {
                jSONObject2.put("SDKVC", this.f2058f);
            }
            if (this.f2059g != null) {
                jSONObject2.put("COMPVC", this.f2059g);
            }
            jSONObject.put("terminal_params", jSONObject2);
            if (this.f2060h != null) {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < this.f2060h.size(); i++) {
                    jSONArray.put(this.f2060h.get(i));
                }
                jSONObject.put("ids", jSONArray);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    /* renamed from: a */
    public void m2653a(Integer num) {
        this.f2055c = num;
    }

    /* renamed from: a */
    public void m2652a(String str) {
        this.f2053a = str;
    }

    /* renamed from: a */
    public void m2651a(List<Integer> list) {
        this.f2060h = list;
    }

    /* renamed from: b */
    public void m2650b(Integer num) {
        this.f2058f = num;
    }

    /* renamed from: b */
    public void m2649b(String str) {
        this.f2054b = str;
    }

    /* renamed from: c */
    public void m2648c(Integer num) {
        this.f2059g = num;
    }

    /* renamed from: c */
    public void m2647c(String str) {
        this.f2056d = str;
    }

    /* renamed from: d */
    public void m2646d(String str) {
        this.f2057e = str;
    }
}
