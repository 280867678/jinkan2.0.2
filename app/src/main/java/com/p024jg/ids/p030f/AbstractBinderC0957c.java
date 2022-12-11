package com.p024jg.ids.p030f;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.umeng.analytics.pro.C1532ad;

/* JADX WARN: Classes with same name are omitted:
  classes.dex
 */
/* renamed from: com.jg.ids.f.c */
/* loaded from: classes6.dex */
public abstract class AbstractBinderC0957c extends Binder implements AbstractC0956b {
    /* renamed from: a */
    public static AbstractC0956b m3759a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface(C1532ad.f2921a);
        if (queryLocalInterface != null && (queryLocalInterface instanceof AbstractC0956b)) {
            return (AbstractC0956b) queryLocalInterface;
        }
        return new C0958d(iBinder);
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                parcel.enforceInterface(C1532ad.f2921a);
                String a = a();
                parcel2.writeNoException();
                parcel2.writeString(a);
                return true;
            case 2:
                parcel.enforceInterface(C1532ad.f2921a);
                boolean b = b();
                parcel2.writeNoException();
                parcel2.writeInt(b ? 1 : 0);
                return true;
            case 1598968902:
                parcel2.writeString(C1532ad.f2921a);
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }

    /* renamed from: c */
    public static AbstractC0956b m3758c() {
        return null;
    }
}
