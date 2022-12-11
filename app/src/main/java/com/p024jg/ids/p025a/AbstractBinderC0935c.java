package com.p024jg.ids.p025a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX WARN: Classes with same name are omitted:
  classes.dex
 */
/* renamed from: com.jg.ids.a.c */
/* loaded from: classes6.dex */
public abstract class AbstractBinderC0935c extends Binder implements AbstractC0934b {
    /* renamed from: a */
    public static AbstractC0934b m3788a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        try {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof AbstractC0934b)) ? new C0936d(iBinder) : (AbstractC0934b) queryLocalInterface;
        } catch (Throwable th) {
            return null;
        }
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        boolean z = true;
        if (i != 1598968902) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    boolean a = a();
                    parcel2.writeNoException();
                    parcel2.writeInt(a ? 1 : 0);
                    break;
                case 2:
                    parcel.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    String b = b();
                    parcel2.writeNoException();
                    parcel2.writeString(b);
                    break;
                case 3:
                    parcel.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    String c = c();
                    parcel2.writeNoException();
                    parcel2.writeString(c);
                    break;
                case 4:
                    parcel.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    String d = d();
                    parcel2.writeNoException();
                    parcel2.writeString(d);
                    break;
                case 5:
                    parcel.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    String e = e();
                    parcel2.writeNoException();
                    parcel2.writeString(e);
                    break;
                default:
                    try {
                        z = super.onTransact(i, parcel, parcel2, i2);
                        break;
                    } catch (RemoteException e2) {
                        break;
                    }
            }
            return z;
        }
        parcel2.writeString("com.asus.msa.SupplementaryDID.IDidAidlInterface");
        return z;
    }
}
