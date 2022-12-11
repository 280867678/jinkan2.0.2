package com.p024jg.ids.p028d;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX WARN: Classes with same name are omitted:
  classes.dex
 */
/* renamed from: com.jg.ids.d.c */
/* loaded from: classes6.dex */
public abstract class AbstractBinderC0947c extends Binder implements AbstractC0946b {
    /* renamed from: a */
    public static AbstractC0946b m3773a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.android.creator.IdsSupplier");
        if (queryLocalInterface != null && (queryLocalInterface instanceof AbstractC0946b)) {
            return (AbstractC0946b) queryLocalInterface;
        }
        return new C0948d(iBinder);
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                parcel.enforceInterface("com.android.creator.IdsSupplier");
                boolean a = a();
                parcel2.writeNoException();
                parcel2.writeInt(a ? 1 : 0);
                return true;
            case 2:
                parcel.enforceInterface("com.android.creator.IdsSupplier");
                String a2 = a(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(a2);
                return true;
            case 3:
                parcel.enforceInterface("com.android.creator.IdsSupplier");
                String b = b();
                parcel2.writeNoException();
                parcel2.writeString(b);
                return true;
            case 4:
                parcel.enforceInterface("com.android.creator.IdsSupplier");
                String c = c();
                parcel2.writeNoException();
                parcel2.writeString(c);
                return true;
            case 5:
                parcel.enforceInterface("com.android.creator.IdsSupplier");
                String b2 = b(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(b2);
                return true;
            case 1598968902:
                parcel2.writeString("com.android.creator.IdsSupplier");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }

    /* renamed from: d */
    public static AbstractC0946b m3772d() {
        return null;
    }
}
