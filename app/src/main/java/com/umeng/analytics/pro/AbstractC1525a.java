package com.umeng.analytics.pro;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.umeng.analytics.pro.a */
/* loaded from: classes4.dex */
public interface AbstractC1525a extends IInterface {

    /* renamed from: com.umeng.analytics.pro.a$a */
    /* loaded from: classes4.dex */
    public static abstract class AbstractBinderC1526a extends Binder implements AbstractC1525a {

        /* renamed from: a */
        public static final int f2901a = 1;

        /* renamed from: b */
        public static final int f2902b = 2;

        /* renamed from: c */
        public static final int f2903c = 3;

        /* renamed from: d */
        public static final int f2904d = 4;

        /* renamed from: e */
        public static final int f2905e = 5;

        /* renamed from: f */
        public static final int f2906f = 6;

        /* renamed from: g */
        public static final int f2907g = 7;

        /* renamed from: h */
        public static final String f2908h = "com.coolpad.deviceidsupport.IDeviceIdManager";

        /* renamed from: com.umeng.analytics.pro.a$a$a */
        /* loaded from: classes4.dex */
        public static class C1527a implements AbstractC1525a {

            /* renamed from: a */
            public IBinder f2909a;

            public C1527a(IBinder iBinder) {
                this.f2909a = iBinder;
            }

            @Override // com.umeng.analytics.pro.AbstractC1525a
            /* renamed from: a */
            public String mo1406a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC1526a.f2908h);
                    obtain.writeString(str);
                    this.f2909a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.umeng.analytics.pro.AbstractC1525a
            /* renamed from: a */
            public boolean mo1407a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC1526a.f2908h);
                    boolean z = false;
                    this.f2909a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f2909a;
            }

            @Override // com.umeng.analytics.pro.AbstractC1525a
            /* renamed from: b */
            public String mo1405b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC1526a.f2908h);
                    this.f2909a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.umeng.analytics.pro.AbstractC1525a
            /* renamed from: b */
            public String mo1404b(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC1526a.f2908h);
                    obtain.writeString(str);
                    this.f2909a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public String m1403c() {
                return AbstractBinderC1526a.f2908h;
            }

            @Override // com.umeng.analytics.pro.AbstractC1525a
            /* renamed from: c */
            public String mo1402c(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC1526a.f2908h);
                    obtain.writeString(str);
                    this.f2909a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.umeng.analytics.pro.AbstractC1525a
            /* renamed from: d */
            public String mo1401d(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC1526a.f2908h);
                    obtain.writeString(str);
                    this.f2909a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.umeng.analytics.pro.AbstractC1525a
            /* renamed from: e */
            public String mo1400e(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC1526a.f2908h);
                    obtain.writeString(str);
                    this.f2909a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public AbstractBinderC1526a() {
            attachInterface(this, f2908h);
        }

        /* renamed from: a */
        public static AbstractC1525a m1408a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f2908h);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof AbstractC1525a)) ? new C1527a(iBinder) : (AbstractC1525a) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            String mo1406a;
            if (i == 1598968902) {
                parcel2.writeString(f2908h);
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface(f2908h);
                    mo1406a = mo1406a(parcel.readString());
                    break;
                case 2:
                    parcel.enforceInterface(f2908h);
                    mo1406a = mo1404b(parcel.readString());
                    break;
                case 3:
                    parcel.enforceInterface(f2908h);
                    mo1406a = mo1402c(parcel.readString());
                    break;
                case 4:
                    parcel.enforceInterface(f2908h);
                    mo1406a = mo1401d(parcel.readString());
                    break;
                case 5:
                    parcel.enforceInterface(f2908h);
                    mo1406a = mo1400e(parcel.readString());
                    break;
                case 6:
                    parcel.enforceInterface(f2908h);
                    boolean mo1407a = mo1407a();
                    parcel2.writeNoException();
                    parcel2.writeInt(mo1407a ? 1 : 0);
                    return true;
                case 7:
                    parcel.enforceInterface(f2908h);
                    mo1406a = mo1405b();
                    break;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel2.writeNoException();
            parcel2.writeString(mo1406a);
            return true;
        }
    }

    /* renamed from: a */
    String mo1406a(String str) throws RemoteException;

    /* renamed from: a */
    boolean mo1407a() throws RemoteException;

    /* renamed from: b */
    String mo1405b() throws RemoteException;

    /* renamed from: b */
    String mo1404b(String str) throws RemoteException;

    /* renamed from: c */
    String mo1402c(String str) throws RemoteException;

    /* renamed from: d */
    String mo1401d(String str) throws RemoteException;

    /* renamed from: e */
    String mo1400e(String str) throws RemoteException;
}
