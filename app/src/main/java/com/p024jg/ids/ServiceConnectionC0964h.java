package com.p024jg.ids;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* JADX WARN: Classes with same name are omitted:
  classes.dex
 */
/* renamed from: com.jg.ids.h */
/* loaded from: classes6.dex */
final class ServiceConnectionC0964h implements ServiceConnection {

    /* renamed from: a */
    private /* synthetic */ AbstractC0959g f622a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ServiceConnectionC0964h(AbstractC0959g abstractC0959g) {
        this.f622a = abstractC0959g;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            this.f622a.mo3735a(iBinder);
        } catch (Throwable th) {
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
