package com.efs.sdk.base.core.p013f;

import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.p013f.C0759f;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.efs.sdk.base.core.f.g */
/* loaded from: classes3.dex */
public final class HandlerC0761g extends AbstractHandlerC0754a {

    /* renamed from: b */
    public ConcurrentHashMap<String, C0762a> f310b = new ConcurrentHashMap<>(10);

    /* renamed from: com.efs.sdk.base.core.f.g$a */
    /* loaded from: classes3.dex */
    public static class C0762a {

        /* renamed from: a */
        public String f311a;

        /* renamed from: b */
        public String f312b;

        /* renamed from: c */
        public String f313c;

        /* renamed from: d */
        public AtomicInteger f314d = new AtomicInteger(0);

        public C0762a(String str, String str2, String str3) {
            this.f311a = str;
            this.f312b = str2;
            this.f313c = str3;
        }
    }

    @Override // com.efs.sdk.base.core.p013f.AbstractHandlerC0754a
    /* renamed from: a */
    public final void mo4073a() {
        C0759f c0759f;
        try {
            if (this.f292a != null && ControllerCenter.getGlobalEnvStruct().isEnableWaStat()) {
                for (Map.Entry<String, C0762a> entry : this.f310b.entrySet()) {
                    C0762a value = entry.getValue();
                    int i = value.f314d.get();
                    if (i > 0) {
                        ControllerCenter controllerCenter = this.f292a;
                        String str = value.f311a;
                        String str2 = value.f312b;
                        String str3 = value.f313c;
                        c0759f = C0759f.C0760a.f309a;
                        C0755b c0755b = new C0755b("efs_core", "req_succ_rate", c0759f.f305a.f299c);
                        c0755b.put("rep_code", str);
                        c0755b.put("px_code", str2);
                        c0755b.put("path", str3);
                        c0755b.put("cnt", Integer.valueOf(i));
                        controllerCenter.send(c0755b);
                        value.f314d.addAndGet(i * (-1));
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public final void m4072a(String str, String str2, String str3) {
        String str4 = str + "_" + str2 + "_" + str3.trim();
        if (!this.f310b.containsKey(str4) || this.f310b.get(str4) == null) {
            this.f310b.putIfAbsent(str4, new C0762a(str, str2, str3));
        }
        this.f310b.get(str4).f314d.incrementAndGet();
    }
}
