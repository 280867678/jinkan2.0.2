package com.p024jg.ids.p031g;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX WARN: Classes with same name are omitted:
  classes.dex
 */
/* renamed from: com.jg.ids.g.b */
/* loaded from: classes6.dex */
public abstract class AbstractBinderC0961b extends Binder implements AbstractC0960a {
    /* renamed from: a */
    public static AbstractC0960a m3754a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        try {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.zui.deviceidservice.IDeviceidInterface");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof AbstractC0960a)) ? new C0962c(iBinder) : (AbstractC0960a) queryLocalInterface;
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
                    parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                    String a = a();
                    parcel2.writeNoException();
                    parcel2.writeString(a);
                    break;
                case 2:
                    parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                    String b = b();
                    parcel2.writeNoException();
                    parcel2.writeString(b);
                    break;
                case 3:
                    parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                    boolean c = c();
                    parcel2.writeNoException();
                    parcel2.writeInt(c ? 1 : 0);
                    break;
                case 4:
                    parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                    String a2 = a(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(a2);
                    break;
                case 5:
                    parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                    String b2 = b(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(b2);
                    break;
                case 1598968902:
                    parcel2.writeString("com.zui.deviceidservice.IDeviceidInterface");
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
