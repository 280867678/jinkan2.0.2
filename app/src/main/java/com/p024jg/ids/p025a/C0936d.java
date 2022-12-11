package com.p024jg.ids.p025a;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX WARN: Classes with same name are omitted:
  classes.dex
 */
/* renamed from: com.jg.ids.a.d */
/* loaded from: classes6.dex */
public final class C0936d implements AbstractC0934b {

    /* renamed from: a */
    private IBinder f602a;

    public C0936d(IBinder iBinder) {
        this.f602a = iBinder;
    }

    @Override // com.p024jg.ids.p025a.AbstractC0934b
    /* renamed from: a */
    public final boolean mo3787a() {
        boolean z = false;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            this.f602a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                z = true;
            }
            try {
                obtain2.recycle();
                obtain.recycle();
            } catch (Throwable th) {
            }
        } catch (Throwable th2) {
            try {
                obtain2.recycle();
                obtain.recycle();
            } catch (Throwable th3) {
            }
        }
        return z;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f602a;
    }

    @Override // com.p024jg.ids.p025a.AbstractC0934b
    /* renamed from: b */
    public final String mo3786b() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            this.f602a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            String readString = obtain2.readString();
            try {
                obtain2.recycle();
                obtain.recycle();
                return readString;
            } catch (Throwable th) {
                return readString;
            }
        } catch (Throwable th2) {
            try {
                obtain2.recycle();
                obtain.recycle();
            } catch (Throwable th3) {
            }
            return "";
        }
    }

    @Override // com.p024jg.ids.p025a.AbstractC0934b
    /* renamed from: c */
    public final String mo3785c() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            this.f602a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            String readString = obtain2.readString();
            try {
                obtain2.recycle();
                obtain.recycle();
                return readString;
            } catch (Throwable th) {
                return readString;
            }
        } catch (Throwable th2) {
            try {
                obtain2.recycle();
                obtain.recycle();
            } catch (Throwable th3) {
            }
            return "";
        }
    }

    @Override // com.p024jg.ids.p025a.AbstractC0934b
    /* renamed from: d */
    public final String mo3784d() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            this.f602a.transact(4, obtain, obtain2, 0);
            obtain2.readException();
            String readString = obtain2.readString();
            try {
                obtain2.recycle();
                obtain.recycle();
                return readString;
            } catch (Throwable th) {
                return readString;
            }
        } catch (Throwable th2) {
            try {
                obtain2.recycle();
                obtain.recycle();
            } catch (Throwable th3) {
            }
            return "";
        }
    }

    @Override // com.p024jg.ids.p025a.AbstractC0934b
    /* renamed from: e */
    public final String mo3783e() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            this.f602a.transact(5, obtain, obtain2, 0);
            obtain2.readException();
            String readString = obtain2.readString();
            obtain2.recycle();
            obtain.recycle();
            return readString;
        } catch (RemoteException e) {
            obtain2.recycle();
            obtain.recycle();
            return "";
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
            throw th;
        }
    }
}
