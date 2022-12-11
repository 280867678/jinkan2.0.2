package com.p024jg.ids.p026b;

import android.os.IBinder;
import android.os.Parcel;
import com.umeng.analytics.pro.AbstractC1525a;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  classes.dex
 */
/* renamed from: com.jg.ids.b.d */
/* loaded from: classes6.dex */
public final class C0941d implements AbstractC0939b {

    /* renamed from: a */
    private IBinder f604a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0941d(IBinder iBinder) {
        this.f604a = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f604a;
    }

    @Override // com.p024jg.ids.p026b.AbstractC0939b
    /* renamed from: a */
    public final String mo3779a(String str) {
        String readString;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(AbstractC1525a.AbstractBinderC1526a.f2908h);
            obtain.writeString(str);
            if (!this.f604a.transact(1, obtain, obtain2, 0) && AbstractBinderC0940c.m3781c() != null) {
                readString = AbstractBinderC0940c.m3781c().mo3779a(str);
            } else {
                obtain2.readException();
                readString = obtain2.readString();
            }
            return readString;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.p024jg.ids.p026b.AbstractC0939b
    /* renamed from: b */
    public final String mo3777b(String str) {
        String readString;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(AbstractC1525a.AbstractBinderC1526a.f2908h);
            obtain.writeString(str);
            if (!this.f604a.transact(2, obtain, obtain2, 0) && AbstractBinderC0940c.m3781c() != null) {
                readString = AbstractBinderC0940c.m3781c().mo3777b(str);
            } else {
                obtain2.readException();
                readString = obtain2.readString();
            }
            return readString;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.p024jg.ids.p026b.AbstractC0939b
    /* renamed from: c */
    public final String mo3776c(String str) {
        String readString;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(AbstractC1525a.AbstractBinderC1526a.f2908h);
            obtain.writeString(str);
            if (!this.f604a.transact(3, obtain, obtain2, 0) && AbstractBinderC0940c.m3781c() != null) {
                readString = AbstractBinderC0940c.m3781c().mo3776c(str);
            } else {
                obtain2.readException();
                readString = obtain2.readString();
            }
            return readString;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.p024jg.ids.p026b.AbstractC0939b
    /* renamed from: d */
    public final String mo3775d(String str) {
        String readString;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(AbstractC1525a.AbstractBinderC1526a.f2908h);
            obtain.writeString(str);
            if (!this.f604a.transact(4, obtain, obtain2, 0) && AbstractBinderC0940c.m3781c() != null) {
                readString = AbstractBinderC0940c.m3781c().mo3775d(str);
            } else {
                obtain2.readException();
                readString = obtain2.readString();
            }
            return readString;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.p024jg.ids.p026b.AbstractC0939b
    /* renamed from: e */
    public final String mo3774e(String str) {
        String readString;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(AbstractC1525a.AbstractBinderC1526a.f2908h);
            obtain.writeString(str);
            if (!this.f604a.transact(5, obtain, obtain2, 0) && AbstractBinderC0940c.m3781c() != null) {
                readString = AbstractBinderC0940c.m3781c().mo3774e(str);
            } else {
                obtain2.readException();
                readString = obtain2.readString();
            }
            return readString;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.p024jg.ids.p026b.AbstractC0939b
    /* renamed from: a */
    public final boolean mo3780a() {
        boolean z = false;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(AbstractC1525a.AbstractBinderC1526a.f2908h);
            if (!this.f604a.transact(6, obtain, obtain2, 0) && AbstractBinderC0940c.m3781c() != null) {
                z = AbstractBinderC0940c.m3781c().mo3780a();
            } else {
                obtain2.readException();
                if (obtain2.readInt() != 0) {
                    z = true;
                }
            }
            return z;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.p024jg.ids.p026b.AbstractC0939b
    /* renamed from: b */
    public final String mo3778b() {
        String readString;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(AbstractC1525a.AbstractBinderC1526a.f2908h);
            if (!this.f604a.transact(7, obtain, obtain2, 0) && AbstractBinderC0940c.m3781c() != null) {
                readString = AbstractBinderC0940c.m3781c().mo3778b();
            } else {
                obtain2.readException();
                readString = obtain2.readString();
            }
            return readString;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
