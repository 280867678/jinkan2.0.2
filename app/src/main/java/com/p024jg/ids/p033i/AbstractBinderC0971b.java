package com.p024jg.ids.p033i;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* JADX WARN: Classes with same name are omitted:
  classes.dex
 */
/* renamed from: com.jg.ids.i.b */
/* loaded from: classes6.dex */
public abstract class AbstractBinderC0971b extends Binder implements AbstractC0970a {
    /* renamed from: a */
    public static AbstractC0970a m3745a(IBinder iBinder) {
        AbstractC0970a c0972c;
        if (iBinder == null) {
            return null;
        }
        try {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof AbstractC0970a)) {
                c0972c = new C0972c(iBinder);
            } else {
                c0972c = (AbstractC0970a) queryLocalInterface;
            }
            return c0972c;
        } catch (Throwable th) {
            return null;
        }
    }
}
