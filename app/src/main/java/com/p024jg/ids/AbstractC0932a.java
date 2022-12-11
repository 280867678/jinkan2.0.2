package com.p024jg.ids;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

/* JADX WARN: Classes with same name are omitted:
  classes.dex
 */
/* renamed from: com.jg.ids.a */
/* loaded from: classes6.dex */
public abstract class AbstractC0932a extends AbstractC0954f {

    /* renamed from: b */
    private static Handler f599b = new Handler(Looper.getMainLooper());

    /* renamed from: c */
    private Handler f600c;

    /* renamed from: d */
    private HandlerThread f601d;

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo3709a(Message message);

    /* renamed from: b */
    protected abstract void mo3708b();

    public AbstractC0932a(Context context, String str) {
        super(context);
        this.f600c = null;
        this.f601d = null;
        try {
            this.f601d = new HandlerThread(str);
            this.f601d.start();
            this.f600c = new HandlerC0937b(this, this.f601d.getLooper());
            if (c() && d()) {
                mo3708b();
            }
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public final void m3789b(Message message) {
        this.f600c.sendMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final Message m3791a() {
        return this.f600c.obtainMessage();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public static void m3790a(Runnable runnable) {
        f599b.post(runnable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3747a(int i, String str) {
        switch (i) {
            case 0:
                m3790a(new RunnableC0942c(this, str));
                return;
            case 1:
                m3790a(new RunnableC0944d(this, str));
                return;
            case 2:
                m3790a(new RunnableC0949e(this, str));
                return;
            default:
                return;
        }
    }
}
