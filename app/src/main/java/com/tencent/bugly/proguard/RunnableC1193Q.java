package com.tencent.bugly.proguard;

/* renamed from: com.tencent.bugly.proguard.Q */
/* loaded from: classes3.dex */
public class RunnableC1193Q implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ Runnable f1408a;

    /* renamed from: b */
    public final /* synthetic */ C1195T f1409b;

    public RunnableC1193Q(C1195T c1195t, Runnable runnable) {
        this.f1409b = c1195t;
        this.f1408a = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        Object obj;
        this.f1408a.run();
        obj = this.f1409b.f1422j;
        synchronized (obj) {
            C1195T.m3103b(this.f1409b);
        }
    }
}
