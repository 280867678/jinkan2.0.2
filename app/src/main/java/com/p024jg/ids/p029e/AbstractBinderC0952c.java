package com.p024jg.ids.p029e;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX WARN: Classes with same name are omitted:
  classes.dex
 */
/* renamed from: com.jg.ids.e.c */
/* loaded from: classes6.dex */
public abstract class AbstractBinderC0952c extends Binder implements AbstractC0951b {
    /* renamed from: a */
    public static AbstractC0951b m3766a(IBinder iBinder) {
        AbstractC0951b c0953d;
        if (iBinder == null) {
            return null;
        }
        try {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof AbstractC0951b)) {
                c0953d = new C0953d(iBinder);
            } else {
                c0953d = (AbstractC0951b) queryLocalInterface;
            }
            return c0953d;
        } catch (Throwable th) {
            return null;
        }
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        int i3 = 0;
        boolean z = true;
        try {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    parcel2.writeNoException();
                    parcel2.writeString(a());
                    break;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    boolean a = a(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    if (a) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    break;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
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
