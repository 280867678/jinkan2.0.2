package com.tencent.bugly.proguard;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.tencent.bugly.proguard.W */
/* loaded from: classes3.dex */
public class C1198W {

    /* renamed from: a */
    public static final AtomicInteger f1445a = new AtomicInteger(1);

    /* renamed from: b */
    public static C1198W f1446b;

    /* renamed from: c */
    public ScheduledExecutorService f1447c;

    public C1198W() {
        this.f1447c = null;
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(3, new ThreadFactoryC1197V(this));
        this.f1447c = newScheduledThreadPool;
        if (newScheduledThreadPool == null || newScheduledThreadPool.isShutdown()) {
            C1199X.m3076e("[AsyncTaskHandler] ScheduledExecutorService is not valiable!", new Object[0]);
        }
    }

    /* renamed from: c */
    public static synchronized C1198W m3089c() {
        C1198W c1198w;
        synchronized (C1198W.class) {
            if (f1446b == null) {
                f1446b = new C1198W();
            }
            c1198w = f1446b;
        }
        return c1198w;
    }

    /* renamed from: a */
    public synchronized boolean m3092a(Runnable runnable) {
        if (!m3088d()) {
            C1199X.m3076e("[AsyncTaskHandler] Async handler was closed, should not post task.", new Object[0]);
            return false;
        } else if (runnable == null) {
            C1199X.m3076e("[AsyncTaskHandler] Task input is null.", new Object[0]);
            return false;
        } else {
            C1199X.m3084a("[AsyncTaskHandler] Post a normal task: %s", runnable.getClass().getName());
            this.f1447c.execute(runnable);
            return true;
        }
    }

    /* renamed from: a */
    public synchronized boolean m3091a(Runnable runnable, long j) {
        if (!m3088d()) {
            C1199X.m3076e("[AsyncTaskHandler] Async handler was closed, should not post task.", new Object[0]);
            return false;
        } else if (runnable == null) {
            C1199X.m3076e("[AsyncTaskHandler] Task input is null.", new Object[0]);
            return false;
        } else {
            if (j <= 0) {
                j = 0;
            }
            C1199X.m3084a("[AsyncTaskHandler] Post a delay(time: %dms) task: %s", Long.valueOf(j), runnable.getClass().getName());
            this.f1447c.schedule(runnable, j, TimeUnit.MILLISECONDS);
            return true;
        }
    }

    /* renamed from: b */
    public synchronized void m3090b() {
        ScheduledExecutorService scheduledExecutorService = this.f1447c;
        if (scheduledExecutorService != null && !scheduledExecutorService.isShutdown()) {
            C1199X.m3084a("[AsyncTaskHandler] Close async handler.", new Object[0]);
            this.f1447c.shutdownNow();
        }
    }

    /* renamed from: d */
    public synchronized boolean m3088d() {
        boolean z;
        ScheduledExecutorService scheduledExecutorService = this.f1447c;
        if (scheduledExecutorService != null) {
            if (!scheduledExecutorService.isShutdown()) {
                z = true;
            }
        }
        z = false;
        return z;
    }
}
