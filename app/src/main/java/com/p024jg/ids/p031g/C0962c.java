package com.p024jg.ids.p031g;

import android.os.IBinder;
import android.os.Parcel;

/* JADX WARN: Classes with same name are omitted:
  classes.dex
 */
/* renamed from: com.jg.ids.g.c */
/* loaded from: classes6.dex */
final class C0962c implements AbstractC0960a {

    /* renamed from: a */
    private IBinder f621a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0962c(IBinder iBinder) {
        this.f621a = iBinder;
    }

    @Override // com.p024jg.ids.p031g.AbstractC0960a
    /* renamed from: a */
    public final String mo3753a() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
            this.f621a.transact(1, obtain, obtain2, 0);
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

    @Override // com.p024jg.ids.p031g.AbstractC0960a
    /* renamed from: a */
    public final String mo3752a(String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
            obtain.writeString(str);
            this.f621a.transact(4, obtain, obtain2, 0);
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

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f621a;
    }

    @Override // com.p024jg.ids.p031g.AbstractC0960a
    /* renamed from: b */
    public final String mo3751b() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
            this.f621a.transact(2, obtain, obtain2, 0);
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

    @Override // com.p024jg.ids.p031g.AbstractC0960a
    /* renamed from: b */
    public final String mo3750b(String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
            obtain.writeString(str);
            this.f621a.transact(5, obtain, obtain2, 0);
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

    @Override // com.p024jg.ids.p031g.AbstractC0960a
    /* renamed from: c */
    public final boolean mo3749c() {
        boolean z = false;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
            this.f621a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                z = true;
            }
            obtain2.recycle();
            obtain.recycle();
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
        return z;
    }
}
