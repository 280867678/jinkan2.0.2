package com.p024jg.ids.p033i;

import android.os.IBinder;
import android.os.Parcel;

/* JADX WARN: Classes with same name are omitted:
  classes.dex
 */
/* renamed from: com.jg.ids.i.c */
/* loaded from: classes6.dex */
public final class C0972c implements AbstractC0970a {

    /* renamed from: a */
    private IBinder f630a;

    public C0972c(IBinder iBinder) {
        this.f630a = iBinder;
    }

    @Override // com.p024jg.ids.p033i.AbstractC0970a
    /* renamed from: a */
    public final String mo3744a(String str, String str2, String str3) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
            obtain.writeString(str);
            obtain.writeString(str2);
            obtain.writeString(str3);
            this.f630a.transact(1, obtain, obtain2, 0);
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
        return this.f630a;
    }
}
