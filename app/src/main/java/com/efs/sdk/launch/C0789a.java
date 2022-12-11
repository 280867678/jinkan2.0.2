package com.efs.sdk.launch;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.efs.sdk.launch.a */
/* loaded from: classes3.dex */
public class C0789a {

    /* renamed from: a */
    public static final String f353a = "com.efs.sdk.launch.a";

    /* renamed from: b */
    public static volatile ScheduledThreadPoolExecutor f354b;

    /* renamed from: c */
    public static ThreadFactory f355c = new ThreadFactory() { // from class: com.efs.sdk.launch.a.1

        /* renamed from: a */
        public AtomicInteger f356a = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("LaunchThreadPoolExecutor" + this.f356a.addAndGet(1));
            return thread;
        }
    };

    /* renamed from: a */
    public static ScheduledThreadPoolExecutor m3997a() {
        if (f354b == null) {
            synchronized (C0789a.class) {
                if (f354b == null) {
                    f354b = new ScheduledThreadPoolExecutor(4, f355c);
                }
            }
        }
        return f354b;
    }

    /* renamed from: a */
    public static void m3996a(Runnable runnable) {
        try {
            m3997a().execute(runnable);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
