package com.p024jg.ids.p030f;

import android.os.IBinder;
import android.os.Parcel;
import com.umeng.analytics.pro.C1532ad;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  classes.dex
 */
/* renamed from: com.jg.ids.f.d */
/* loaded from: classes6.dex */
public final class C0958d implements AbstractC0956b {

    /* renamed from: a */
    private IBinder f619a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0958d(IBinder iBinder) {
        this.f619a = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f619a;
    }

    @Override // com.p024jg.ids.p030f.AbstractC0956b
    /* renamed from: a */
    public final String mo3757a() {
        String readString;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(C1532ad.f2921a);
            if (!this.f619a.transact(1, obtain, obtain2, 0) && AbstractBinderC0957c.m3758c() != null) {
                readString = AbstractBinderC0957c.m3758c().mo3757a();
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

    @Override // com.p024jg.ids.p030f.AbstractC0956b
    /* renamed from: b */
    public final boolean mo3756b() {
        boolean z = false;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(C1532ad.f2921a);
            if (!this.f619a.transact(2, obtain, obtain2, 0) && AbstractBinderC0957c.m3758c() != null) {
                z = AbstractBinderC0957c.m3758c().mo3756b();
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
}
