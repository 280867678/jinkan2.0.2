package com.tencent.bugly.proguard;

import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.tencent.bugly.proguard.S */
/* loaded from: classes3.dex */
public class RunnableC1194S implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f1410a;

    /* renamed from: b */
    public final /* synthetic */ LinkedBlockingQueue f1411b;

    /* renamed from: c */
    public final /* synthetic */ C1195T f1412c;

    public RunnableC1194S(C1195T c1195t, int i, LinkedBlockingQueue linkedBlockingQueue) {
        this.f1412c = c1195t;
        this.f1410a = i;
        this.f1411b = linkedBlockingQueue;
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable runnable;
        for (int i = 0; i < this.f1410a && (runnable = (Runnable) this.f1411b.poll()) != null; i++) {
            runnable.run();
        }
    }
}
