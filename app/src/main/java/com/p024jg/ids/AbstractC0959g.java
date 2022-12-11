package com.p024jg.ids;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

/* JADX WARN: Classes with same name are omitted:
  classes.dex
 */
/* renamed from: com.jg.ids.g */
/* loaded from: classes6.dex */
public abstract class AbstractC0959g extends AbstractC0954f {

    /* renamed from: b */
    private ServiceConnection f620b = new ServiceConnectionC0964h(this);

    /* renamed from: a */
    protected abstract Intent mo3736a();

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo3735a(IBinder iBinder);

    public AbstractC0959g(Context context) {
        super(context);
        if (c() && d()) {
            try {
                this.f617a.bindService(mo3736a(), this.f620b, 1);
            } catch (Throwable th) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public final void m3755b() {
        try {
            this.f617a.unbindService(this.f620b);
        } catch (Throwable th) {
        }
    }
}
