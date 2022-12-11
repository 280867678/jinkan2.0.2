package com.tencent.bugly.crashreport.biz;

import com.tencent.bugly.proguard.C1199X;

/* renamed from: com.tencent.bugly.crashreport.biz.b */
/* loaded from: classes3.dex */
public class RunnableC1131b implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ C1132c f971a;

    public RunnableC1131b(C1132c c1132c) {
        this.f971a = c1132c;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f971a.m3466c();
        } catch (Throwable th) {
            C1199X.m3080b(th);
        }
    }
}
