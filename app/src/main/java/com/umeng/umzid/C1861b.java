package com.umeng.umzid;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import me.tvspark.outline;

/* renamed from: com.umeng.umzid.b */
/* loaded from: classes4.dex */
public class C1861b {

    /* renamed from: a */
    public static volatile ScheduledThreadPoolExecutor f4341a;

    /* renamed from: b */
    public static ThreadFactory f4342b = new ThreadFactoryC1862a();

    /* renamed from: com.umeng.umzid.b$a */
    /* loaded from: classes4.dex */
    public static class ThreadFactoryC1862a implements ThreadFactory {

        /* renamed from: a */
        public AtomicInteger f4343a = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("ZIDThreadPoolExecutor");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.f4343a.addAndGet(1));
            thread.setName(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            return thread;
        }
    }

    /* renamed from: a */
    public static ScheduledThreadPoolExecutor m203a() {
        if (f4341a == null) {
            synchronized (C1861b.class) {
                if (f4341a == null) {
                    f4341a = new ScheduledThreadPoolExecutor(Runtime.getRuntime().availableProcessors() * 4, f4342b);
                }
            }
        }
        return f4341a;
    }

    /* renamed from: a */
    public static void m202a(Runnable runnable) {
        try {
            m203a().execute(runnable);
        } catch (Throwable unused) {
        }
    }
}
