package com.umeng.commonsdk.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* renamed from: com.umeng.commonsdk.utils.a */
/* loaded from: classes4.dex */
public abstract class AbstractC1845a {

    /* renamed from: e */
    public static final int f4241e = 1;

    /* renamed from: a */
    public final long f4242a;

    /* renamed from: b */
    public final long f4243b;

    /* renamed from: c */
    public long f4244c;

    /* renamed from: f */
    public HandlerThread f4246f;

    /* renamed from: g */
    public Handler f4247g;

    /* renamed from: d */
    public boolean f4245d = false;

    /* renamed from: h */
    public Handler.Callback f4248h = new Handler.Callback() { // from class: com.umeng.commonsdk.utils.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            synchronized (AbstractC1845a.this) {
                if (AbstractC1845a.this.f4245d) {
                    return true;
                }
                long elapsedRealtime = AbstractC1845a.this.f4244c - SystemClock.elapsedRealtime();
                if (elapsedRealtime <= 0) {
                    AbstractC1845a.this.m219c();
                    if (AbstractC1845a.this.f4246f != null) {
                        AbstractC1845a.this.f4246f.quit();
                    }
                } else if (elapsedRealtime < AbstractC1845a.this.f4243b) {
                    AbstractC1845a.this.f4247g.sendMessageDelayed(AbstractC1845a.this.f4247g.obtainMessage(1), elapsedRealtime);
                } else {
                    long elapsedRealtime2 = SystemClock.elapsedRealtime();
                    AbstractC1845a.this.m223a(elapsedRealtime);
                    long elapsedRealtime3 = (elapsedRealtime2 + AbstractC1845a.this.f4243b) - SystemClock.elapsedRealtime();
                    while (elapsedRealtime3 < 0) {
                        elapsedRealtime3 += AbstractC1845a.this.f4243b;
                    }
                    AbstractC1845a.this.f4247g.sendMessageDelayed(AbstractC1845a.this.f4247g.obtainMessage(1), elapsedRealtime3);
                }
                return false;
            }
        }
    };

    public AbstractC1845a(long j, long j2) {
        Handler handler;
        this.f4242a = j;
        this.f4243b = j2;
        if (!m217d()) {
            HandlerThread handlerThread = new HandlerThread("CountDownTimerThread");
            this.f4246f = handlerThread;
            handlerThread.start();
            handler = new Handler(this.f4246f.getLooper(), this.f4248h);
        } else {
            handler = new Handler(this.f4248h);
        }
        this.f4247g = handler;
    }

    /* renamed from: d */
    private boolean m217d() {
        return Looper.getMainLooper().getThread().equals(Thread.currentThread());
    }

    /* renamed from: a */
    public final synchronized void m224a() {
        this.f4245d = true;
        this.f4247g.removeMessages(1);
    }

    /* renamed from: a */
    public abstract void m223a(long j);

    /* renamed from: b */
    public final synchronized AbstractC1845a m221b() {
        this.f4245d = false;
        if (this.f4242a <= 0) {
            m219c();
            return this;
        }
        this.f4244c = SystemClock.elapsedRealtime() + this.f4242a;
        this.f4247g.sendMessage(this.f4247g.obtainMessage(1));
        return this;
    }

    /* renamed from: c */
    public abstract void m219c();
}
