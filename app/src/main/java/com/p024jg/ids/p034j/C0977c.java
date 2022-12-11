package com.p024jg.ids.p034j;

import android.os.IBinder;
import android.os.Parcel;
import com.umeng.analytics.pro.AbstractC1567b;

/* JADX WARN: Classes with same name are omitted:
  classes.dex
 */
/* renamed from: com.jg.ids.j.c */
/* loaded from: classes6.dex */
final class C0977c implements AbstractC0975a {

    /* renamed from: a */
    private IBinder f632a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0977c(IBinder iBinder) {
        this.f632a = iBinder;
    }

    @Override // com.p024jg.ids.p034j.AbstractC0975a
    /* renamed from: a */
    public final String mo3739a() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(AbstractC1567b.AbstractBinderC1568a.f3147d);
            this.f632a.transact(1, obtain, obtain2, 0);
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

    @Override // com.p024jg.ids.p034j.AbstractC0975a
    /* renamed from: a */
    public final String mo3738a(String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(AbstractC1567b.AbstractBinderC1568a.f3147d);
            obtain.writeString(str);
            this.f632a.transact(2, obtain, obtain2, 0);
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
        return this.f632a;
    }

    @Override // com.p024jg.ids.p034j.AbstractC0975a
    /* renamed from: b */
    public final String mo3737b(String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(AbstractC1567b.AbstractBinderC1568a.f3147d);
            obtain.writeString(str);
            this.f632a.transact(3, obtain, obtain2, 0);
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
}
