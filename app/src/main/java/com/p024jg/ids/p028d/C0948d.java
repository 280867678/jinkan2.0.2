package com.p024jg.ids.p028d;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  classes.dex
 */
/* renamed from: com.jg.ids.d.d */
/* loaded from: classes6.dex */
public final class C0948d implements AbstractC0946b {

    /* renamed from: a */
    private IBinder f610a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0948d(IBinder iBinder) {
        this.f610a = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f610a;
    }

    @Override // com.p024jg.ids.p028d.AbstractC0946b
    /* renamed from: a */
    public final boolean mo3771a() {
        boolean z = true;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.android.creator.IdsSupplier");
            if (!this.f610a.transact(1, obtain, obtain2, 0) && AbstractBinderC0947c.m3772d() != null) {
                z = AbstractBinderC0947c.m3772d().mo3771a();
            } else {
                obtain2.readException();
                if (obtain2.readInt() == 0) {
                    z = false;
                }
            }
            return z;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.p024jg.ids.p028d.AbstractC0946b
    /* renamed from: a */
    public final String mo3770a(String str) {
        String readString;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.android.creator.IdsSupplier");
            obtain.writeString(str);
            if (!this.f610a.transact(2, obtain, obtain2, 0) && AbstractBinderC0947c.m3772d() != null) {
                readString = AbstractBinderC0947c.m3772d().mo3770a(str);
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

    @Override // com.p024jg.ids.p028d.AbstractC0946b
    /* renamed from: b */
    public final String mo3769b() {
        String readString;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.android.creator.IdsSupplier");
            if (!this.f610a.transact(3, obtain, obtain2, 0) && AbstractBinderC0947c.m3772d() != null) {
                readString = AbstractBinderC0947c.m3772d().mo3769b();
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

    @Override // com.p024jg.ids.p028d.AbstractC0946b
    /* renamed from: c */
    public final String mo3767c() {
        String readString;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.android.creator.IdsSupplier");
            if (!this.f610a.transact(4, obtain, obtain2, 0) && AbstractBinderC0947c.m3772d() != null) {
                readString = AbstractBinderC0947c.m3772d().mo3767c();
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

    @Override // com.p024jg.ids.p028d.AbstractC0946b
    /* renamed from: b */
    public final String mo3768b(String str) {
        String readString;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.android.creator.IdsSupplier");
            obtain.writeString(str);
            if (!this.f610a.transact(5, obtain, obtain2, 0) && AbstractBinderC0947c.m3772d() != null) {
                readString = AbstractBinderC0947c.m3772d().mo3768b(str);
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
