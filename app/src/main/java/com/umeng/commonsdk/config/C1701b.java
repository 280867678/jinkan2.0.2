package com.umeng.commonsdk.config;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.umeng.commonsdk.config.b */
/* loaded from: classes4.dex */
public class C1701b implements AbstractC1711f {

    /* renamed from: a */
    public static Map<String, Boolean> f3746a = new HashMap();

    /* renamed from: b */
    public static Object f3747b = new Object();

    /* renamed from: com.umeng.commonsdk.config.b$a */
    /* loaded from: classes4.dex */
    public static class C1703a {

        /* renamed from: a */
        public static final C1701b f3748a = new C1701b();
    }

    public C1701b() {
    }

    /* renamed from: a */
    public static boolean m781a(String str) {
        if (!C1705d.m778a(str)) {
            return false;
        }
        synchronized (f3747b) {
            if (!f3746a.containsKey(str)) {
                return true;
            }
            return f3746a.get(str).booleanValue();
        }
    }

    /* renamed from: b */
    public static C1701b m780b() {
        return C1703a.f3748a;
    }

    /* renamed from: a */
    public void m782a() {
        synchronized (f3747b) {
            f3746a.clear();
        }
    }

    @Override // com.umeng.commonsdk.config.AbstractC1711f
    /* renamed from: a */
    public void mo776a(String str, Boolean bool) {
        if (!C1705d.m778a(str)) {
            return;
        }
        synchronized (f3747b) {
            if (f3746a != null) {
                f3746a.put(str, bool);
            }
        }
    }
}
