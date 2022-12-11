package com.tencent.bugly.proguard;

import java.util.concurrent.ThreadFactory;

/* renamed from: com.tencent.bugly.proguard.u */
/* loaded from: classes3.dex */
public class ThreadFactoryC1244u implements ThreadFactory {

    /* renamed from: a */
    public final /* synthetic */ C1246v f1647a;

    public ThreadFactoryC1244u(C1246v c1246v) {
        this.f1647a = c1246v;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setName("BETA_SDK_DOWNLOAD");
        return thread;
    }
}
