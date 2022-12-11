package com.tencent.bugly.proguard;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

/* renamed from: com.tencent.bugly.proguard.da */
/* loaded from: classes3.dex */
public class RunnableC1210da implements Runnable {

    /* renamed from: a */
    public final Handler f1489a;

    /* renamed from: b */
    public final String f1490b;

    /* renamed from: c */
    public long f1491c;

    /* renamed from: d */
    public final long f1492d;

    /* renamed from: e */
    public boolean f1493e = true;

    /* renamed from: f */
    public long f1494f;

    public RunnableC1210da(Handler handler, String str, long j) {
        this.f1489a = handler;
        this.f1490b = str;
        this.f1491c = j;
        this.f1492d = j;
    }

    /* renamed from: a */
    public int m2998a() {
        if (this.f1493e) {
            return 0;
        }
        return SystemClock.uptimeMillis() - this.f1494f < this.f1491c ? 1 : 3;
    }

    /* renamed from: a */
    public void m2997a(long j) {
        this.f1491c = j;
    }

    /* renamed from: b */
    public Looper m2996b() {
        return this.f1489a.getLooper();
    }

    /* renamed from: c */
    public String m2995c() {
        return this.f1490b;
    }

    /* renamed from: d */
    public boolean m2994d() {
        return !this.f1493e && SystemClock.uptimeMillis() > this.f1494f + this.f1491c;
    }

    /* renamed from: e */
    public void m2993e() {
        this.f1491c = this.f1492d;
    }

    /* renamed from: f */
    public void m2992f() {
        if (!this.f1493e) {
            return;
        }
        this.f1493e = false;
        this.f1494f = SystemClock.uptimeMillis();
        this.f1489a.post(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1493e = true;
        m2993e();
    }
}
