package com.tencent.bugly.crashreport.crash;

import com.tencent.bugly.proguard.C1199X;
import java.util.Map;

/* renamed from: com.tencent.bugly.crashreport.crash.j */
/* loaded from: classes3.dex */
public class RunnableC1168j implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ Thread f1278a;

    /* renamed from: b */
    public final /* synthetic */ int f1279b;

    /* renamed from: c */
    public final /* synthetic */ String f1280c;

    /* renamed from: d */
    public final /* synthetic */ String f1281d;

    /* renamed from: e */
    public final /* synthetic */ String f1282e;

    /* renamed from: f */
    public final /* synthetic */ Map f1283f;

    public RunnableC1168j(Thread thread, int i, String str, String str2, String str3, Map map) {
        this.f1278a = thread;
        this.f1279b = i;
        this.f1280c = str;
        this.f1281d = str2;
        this.f1282e = str3;
        this.f1283f = map;
    }

    @Override // java.lang.Runnable
    public void run() {
        C1172k c1172k;
        C1172k c1172k2;
        try {
            c1172k = C1172k.f1305a;
            if (c1172k == null) {
                C1199X.m3081b("[ExtraCrashManager] Extra crash manager has not been initialized.", new Object[0]);
                return;
            }
            c1172k2 = C1172k.f1305a;
            c1172k2.m3208b(this.f1278a, this.f1279b, this.f1280c, this.f1281d, this.f1282e, this.f1283f);
        } catch (Throwable th) {
            if (!C1199X.m3083a(th)) {
                th.printStackTrace();
            }
            C1199X.m3081b("[ExtraCrashManager] Crash error %s %s %s", this.f1280c, this.f1281d, this.f1282e);
        }
    }
}
