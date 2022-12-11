package com.umeng.analytics.pro;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* renamed from: com.umeng.analytics.pro.ad */
/* loaded from: classes4.dex */
public class C1532ad implements AbstractC1671z {

    /* renamed from: a */
    public static final String f2921a = "com.uodis.opendevice.aidl.OpenDeviceIdentifierService";

    /* renamed from: b */
    public static final int f2922b = 1;

    /* renamed from: c */
    public static final int f2923c = 2;

    /* renamed from: com.umeng.analytics.pro.ad$a */
    /* loaded from: classes4.dex */
    public static final class ServiceConnectionC1534a implements ServiceConnection {

        /* renamed from: a */
        public boolean f2924a;

        /* renamed from: b */
        public final LinkedBlockingQueue<IBinder> f2925b;

        public ServiceConnectionC1534a() {
            this.f2924a = false;
            this.f2925b = new LinkedBlockingQueue<>();
        }

        /* renamed from: a */
        public IBinder m1388a() throws InterruptedException {
            if (!this.f2924a) {
                this.f2924a = true;
                return this.f2925b.poll(5L, TimeUnit.SECONDS);
            }
            throw new IllegalStateException();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f2925b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* renamed from: com.umeng.analytics.pro.ad$b */
    /* loaded from: classes4.dex */
    public static final class C1535b implements IInterface {

        /* renamed from: a */
        public IBinder f2926a;

        public C1535b(IBinder iBinder) {
            this.f2926a = iBinder;
        }

        /* renamed from: a */
        public String m1387a() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(C1532ad.f2921a);
                this.f2926a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f2926a;
        }

        /* renamed from: b */
        public boolean m1386b() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(C1532ad.f2921a);
                boolean z = false;
                this.f2926a.transact(2, obtain, obtain2, 0);
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
    }

    @Override // com.umeng.analytics.pro.AbstractC1671z
    /* renamed from: a */
    public String mo850a(Context context) {
        ServiceConnectionC1534a serviceConnectionC1534a = new ServiceConnectionC1534a();
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        if (context.bindService(intent, serviceConnectionC1534a, 1)) {
            try {
                return new C1535b(serviceConnectionC1534a.m1388a()).m1387a();
            } catch (Exception unused) {
            } finally {
                context.unbindService(serviceConnectionC1534a);
            }
        }
        return null;
    }
}
