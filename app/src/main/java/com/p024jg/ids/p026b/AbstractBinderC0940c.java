package com.p024jg.ids.p026b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.umeng.analytics.pro.AbstractC1525a;

/* JADX WARN: Classes with same name are omitted:
  classes.dex
 */
/* renamed from: com.jg.ids.b.c */
/* loaded from: classes6.dex */
public abstract class AbstractBinderC0940c extends Binder implements AbstractC0939b {
    /* renamed from: a */
    public static AbstractC0939b m3782a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface(AbstractC1525a.AbstractBinderC1526a.f2908h);
        if (queryLocalInterface != null && (queryLocalInterface instanceof AbstractC0939b)) {
            return (AbstractC0939b) queryLocalInterface;
        }
        return new C0941d(iBinder);
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                parcel.enforceInterface(AbstractC1525a.AbstractBinderC1526a.f2908h);
                String a = a(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(a);
                return true;
            case 2:
                parcel.enforceInterface(AbstractC1525a.AbstractBinderC1526a.f2908h);
                String b = b(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(b);
                return true;
            case 3:
                parcel.enforceInterface(AbstractC1525a.AbstractBinderC1526a.f2908h);
                String c = c(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(c);
                return true;
            case 4:
                parcel.enforceInterface(AbstractC1525a.AbstractBinderC1526a.f2908h);
                String d = d(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(d);
                return true;
            case 5:
                parcel.enforceInterface(AbstractC1525a.AbstractBinderC1526a.f2908h);
                String e = e(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(e);
                return true;
            case 6:
                parcel.enforceInterface(AbstractC1525a.AbstractBinderC1526a.f2908h);
                boolean a2 = a();
                parcel2.writeNoException();
                parcel2.writeInt(a2 ? 1 : 0);
                return true;
            case 7:
                parcel.enforceInterface(AbstractC1525a.AbstractBinderC1526a.f2908h);
                String b2 = b();
                parcel2.writeNoException();
                parcel2.writeString(b2);
                return true;
            case 1598968902:
                parcel2.writeString(AbstractC1525a.AbstractBinderC1526a.f2908h);
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }

    /* renamed from: c */
    public static AbstractC0939b m3781c() {
        return null;
    }
}
