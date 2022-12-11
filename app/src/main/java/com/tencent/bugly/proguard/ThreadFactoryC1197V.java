package com.tencent.bugly.proguard;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import me.tvspark.outline;

/* renamed from: com.tencent.bugly.proguard.V */
/* loaded from: classes3.dex */
public class ThreadFactoryC1197V implements ThreadFactory {

    /* renamed from: a */
    public final /* synthetic */ C1198W f1444a;

    public ThreadFactoryC1197V(C1198W c1198w) {
        this.f1444a = c1198w;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        AtomicInteger atomicInteger;
        Thread thread = new Thread(runnable);
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("BuglyThread-");
        atomicInteger = C1198W.f1445a;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(atomicInteger.getAndIncrement());
        thread.setName(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        return thread;
    }
}
