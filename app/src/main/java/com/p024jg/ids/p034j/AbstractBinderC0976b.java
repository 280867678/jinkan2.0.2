package com.p024jg.ids.p034j;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.umeng.analytics.pro.AbstractC1567b;

/* JADX WARN: Classes with same name are omitted:
  classes.dex
 */
/* renamed from: com.jg.ids.j.b */
/* loaded from: classes6.dex */
public abstract class AbstractBinderC0976b extends Binder implements AbstractC0975a {
    /* renamed from: a */
    public static AbstractC0975a m3740a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        try {
            IInterface queryLocalInterface = iBinder.queryLocalInterface(AbstractC1567b.AbstractBinderC1568a.f3147d);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof AbstractC0975a)) ? new C0977c(iBinder) : (AbstractC0975a) queryLocalInterface;
        } catch (Throwable th) {
            return null;
        }
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        boolean z = true;
        try {
            switch (i) {
                case 1:
                    parcel.enforceInterface(AbstractC1567b.AbstractBinderC1568a.f3147d);
                    String a = a();
                    parcel2.writeNoException();
                    parcel2.writeString(a);
                    break;
                case 2:
                    parcel.enforceInterface(AbstractC1567b.AbstractBinderC1568a.f3147d);
                    String a2 = a(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(a2);
                    break;
                case 3:
                    parcel.enforceInterface(AbstractC1567b.AbstractBinderC1568a.f3147d);
                    String b = b(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(b);
                    break;
                case 1598968902:
                    parcel2.writeString(AbstractC1567b.AbstractBinderC1568a.f3147d);
                    break;
                default:
                    z = super.onTransact(i, parcel, parcel2, i2);
                    break;
            }
        } catch (Throwable th) {
        }
        return z;
    }
}
