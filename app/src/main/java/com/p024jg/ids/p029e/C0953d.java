package com.p024jg.ids.p029e;

import android.os.IBinder;
import android.os.Parcel;

/* JADX WARN: Classes with same name are omitted:
  classes.dex
 */
/* renamed from: com.jg.ids.e.d */
/* loaded from: classes6.dex */
final class C0953d implements AbstractC0951b {

    /* renamed from: a */
    private IBinder f613a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0953d(IBinder iBinder) {
        this.f613a = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f613a;
    }

    @Override // com.p024jg.ids.p029e.AbstractC0951b
    /* renamed from: a */
    public final String mo3765a() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            if (!this.f613a.transact(1, obtain, obtain2, 0)) {
            }
            obtain2.readException();
            String readString = obtain2.readString();
            obtain2.recycle();
            obtain.recycle();
            return readString;
        } catch (Exception e) {
            obtain2.recycle();
            obtain.recycle();
            return "";
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
            throw th;
        }
    }

    @Override // com.p024jg.ids.p029e.AbstractC0951b
    /* renamed from: a */
    public final boolean mo3764a(boolean z) {
        boolean z2 = true;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            obtain.writeInt(z ? 1 : 0);
            if (!this.f613a.transact(2, obtain, obtain2, 0)) {
            }
            obtain2.readException();
            if (obtain2.readInt() == 0) {
                z2 = false;
            }
            return z2;
        } catch (Exception e) {
            return false;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
