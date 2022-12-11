package com.tencent.bugly.crashreport.crash.p042h5;

import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: com.tencent.bugly.crashreport.crash.h5.a */
/* loaded from: classes3.dex */
public class C1165a {

    /* renamed from: a */
    public String f1264a = null;

    /* renamed from: b */
    public String f1265b = null;

    /* renamed from: c */
    public String f1266c = null;

    /* renamed from: d */
    public String f1267d = null;

    /* renamed from: e */
    public String f1268e = null;

    /* renamed from: f */
    public String f1269f = null;

    /* renamed from: g */
    public String f1270g = null;

    /* renamed from: h */
    public String f1271h = null;

    /* renamed from: i */
    public String f1272i = null;

    /* renamed from: j */
    public long f1273j = 0;

    /* renamed from: k */
    public long f1274k = 0;

    /* renamed from: a */
    public Map<String, String> m3243a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String str = this.f1264a;
        if (str != null) {
            linkedHashMap.put("[JS] projectRoot", str);
        }
        String str2 = this.f1265b;
        if (str2 != null) {
            linkedHashMap.put("[JS] context", str2);
        }
        String str3 = this.f1266c;
        if (str3 != null) {
            linkedHashMap.put("[JS] url", str3);
        }
        String str4 = this.f1267d;
        if (str4 != null) {
            linkedHashMap.put("[JS] userAgent", str4);
        }
        String str5 = this.f1272i;
        if (str5 != null) {
            linkedHashMap.put("[JS] file", str5);
        }
        long j = this.f1273j;
        if (j != 0) {
            linkedHashMap.put("[JS] lineNumber", Long.toString(j));
        }
        return linkedHashMap;
    }
}
