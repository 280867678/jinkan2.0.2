package com.umeng.analytics.pro;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.umeng.analytics.pro.b */
/* loaded from: classes4.dex */
public interface AbstractC1567b extends IInterface {

    /* renamed from: com.umeng.analytics.pro.b$a */
    /* loaded from: classes4.dex */
    public static abstract class AbstractBinderC1568a extends Binder implements AbstractC1567b {

        /* renamed from: a */
        public static final int f3144a = 1;

        /* renamed from: b */
        public static final int f3145b = 2;

        /* renamed from: c */
        public static final int f3146c = 3;

        /* renamed from: d */
        public static final String f3147d = "com.samsung.android.deviceidservice.IDeviceIdService";

        /* renamed from: com.umeng.analytics.pro.b$a$a */
        /* loaded from: classes4.dex */
        public static class C1569a implements AbstractC1567b {

            /* renamed from: a */
            public IBinder f3148a;

            public C1569a(IBinder iBinder) {
                this.f3148a = iBinder;
            }

            @Override // com.umeng.analytics.pro.AbstractC1567b
            /* renamed from: a */
            public String mo1220a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC1568a.f3147d);
                    this.f3148a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.umeng.analytics.pro.AbstractC1567b
            /* renamed from: a */
            public String mo1219a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC1568a.f3147d);
                    obtain.writeString(str);
                    this.f3148a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f3148a;
            }

            /* renamed from: b */
            public String m1218b() {
                return AbstractBinderC1568a.f3147d;
            }

            @Override // com.umeng.analytics.pro.AbstractC1567b
            /* renamed from: b */
            public String mo1217b(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC1568a.f3147d);
                    obtain.writeString(str);
                    this.f3148a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public AbstractBinderC1568a() {
            attachInterface(this, f3147d);
        }

        /* renamed from: a */
        public static AbstractC1567b m1221a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f3147d);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof AbstractC1567b)) ? new C1569a(iBinder) : (AbstractC1567b) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            String mo1220a;
            if (i == 1) {
                parcel.enforceInterface(f3147d);
                mo1220a = mo1220a();
            } else if (i == 2) {
                parcel.enforceInterface(f3147d);
                mo1220a = mo1219a(parcel.readString());
            } else if (i != 3) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(f3147d);
                return true;
            } else {
                parcel.enforceInterface(f3147d);
                mo1220a = mo1217b(parcel.readString());
            }
            parcel2.writeNoException();
            parcel2.writeString(mo1220a);
            return true;
        }
    }

    /* renamed from: a */
    String mo1220a() throws RemoteException;

    /* renamed from: a */
    String mo1219a(String str) throws RemoteException;

    /* renamed from: b */
    String mo1217b(String str) throws RemoteException;
}
