package com.umeng.analytics.pro;

import com.umeng.analytics.AnalyticsConfig;
import java.lang.Thread;

/* renamed from: com.umeng.analytics.pro.p */
/* loaded from: classes4.dex */
public class C1654p implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    public Thread.UncaughtExceptionHandler f3621a;

    /* renamed from: b */
    public AbstractC1662t f3622b;

    public C1654p() {
        if (Thread.getDefaultUncaughtExceptionHandler() == this) {
            return;
        }
        this.f3621a = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    /* renamed from: a */
    private void m927a(Throwable th) {
        if (AnalyticsConfig.CATCH_EXCEPTION) {
            this.f3622b.mo900a(th);
        } else {
            this.f3622b.mo900a(null);
        }
    }

    /* renamed from: a */
    public void m928a(AbstractC1662t abstractC1662t) {
        this.f3622b = abstractC1662t;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        m927a(th);
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f3621a;
        if (uncaughtExceptionHandler == null || uncaughtExceptionHandler == Thread.getDefaultUncaughtExceptionHandler()) {
            return;
        }
        this.f3621a.uncaughtException(thread, th);
    }
}
