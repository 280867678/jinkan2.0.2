package com.tencent.bugly.proguard;

import android.text.TextUtils;
import com.tencent.bugly.crashreport.common.info.C1140a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.bugly.proguard.F */
/* loaded from: classes3.dex */
public class RunnableC1181F implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f1362a;

    /* renamed from: b */
    public final /* synthetic */ int f1363b;

    /* renamed from: c */
    public final /* synthetic */ C1183H f1364c;

    public RunnableC1181F(C1183H c1183h, int i, int i2) {
        this.f1364c = c1183h;
        this.f1362a = i;
        this.f1363b = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        List<C1180E> m3175c;
        Map map;
        Map map2;
        String str2;
        Map map3;
        String str3;
        C1180E c1180e;
        String str4;
        Map map4;
        String str5;
        Map map5;
        try {
            str = this.f1364c.f1370d;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            m3175c = this.f1364c.m3175c(this.f1362a);
            if (m3175c == null) {
                m3175c = new ArrayList();
            }
            map = this.f1364c.f1371e;
            if (map.get(Integer.valueOf(this.f1362a)) == null) {
                HashMap hashMap = new HashMap();
                map5 = this.f1364c.f1371e;
                map5.put(Integer.valueOf(this.f1362a), hashMap);
            }
            map2 = this.f1364c.f1371e;
            str2 = this.f1364c.f1370d;
            if (((Map) map2.get(Integer.valueOf(this.f1362a))).get(str2) == null) {
                c1180e = new C1180E();
                c1180e.f1355a = this.f1362a;
                c1180e.f1361g = C1183H.f1368b;
                str4 = this.f1364c.f1370d;
                c1180e.f1356b = str4;
                c1180e.f1360f = C1140a.m3394m().f1008E;
                c1180e.f1359e = C1140a.m3394m().f1051l;
                c1180e.f1357c = System.currentTimeMillis();
                c1180e.f1358d = this.f1363b;
                map4 = this.f1364c.f1371e;
                str5 = this.f1364c.f1370d;
                ((Map) map4.get(Integer.valueOf(this.f1362a))).put(str5, c1180e);
            } else {
                map3 = this.f1364c.f1371e;
                str3 = this.f1364c.f1370d;
                c1180e = (C1180E) ((Map) map3.get(Integer.valueOf(this.f1362a))).get(str3);
                c1180e.f1358d = this.f1363b;
            }
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            for (C1180E c1180e2 : m3175c) {
                if (c1180e2.f1361g == c1180e.f1361g && c1180e2.f1356b != null && c1180e2.f1356b.equalsIgnoreCase(c1180e.f1356b)) {
                    z = true;
                    c1180e2.f1358d = c1180e.f1358d;
                }
                if ((c1180e2.f1359e != null && !c1180e2.f1359e.equalsIgnoreCase(c1180e.f1359e)) || ((c1180e2.f1360f != null && !c1180e2.f1360f.equalsIgnoreCase(c1180e.f1360f)) || c1180e2.f1358d <= 0)) {
                    arrayList.add(c1180e2);
                }
            }
            m3175c.removeAll(arrayList);
            if (!z) {
                m3175c.add(c1180e);
            }
            this.f1364c.m3183a(this.f1362a, (int) m3175c);
        } catch (Exception unused) {
            C1199X.m3081b("saveCrashRecord failed", new Object[0]);
        }
    }
}
