package com.umeng.commonsdk.statistics.common;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.umeng.commonsdk.statistics.common.a */
/* loaded from: classes4.dex */
public class C1770a {

    /* renamed from: com.umeng.commonsdk.statistics.common.a$a */
    /* loaded from: classes4.dex */
    public static final class C1772a {

        /* renamed from: a */
        public final String f4050a;

        /* renamed from: b */
        public final boolean f4051b;

        public C1772a(String str, boolean z) {
            this.f4050a = str;
            this.f4051b = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public String m515b() {
            return this.f4050a;
        }

        /* renamed from: a */
        public boolean m517a() {
            return this.f4051b;
        }
    }

    /* renamed from: com.umeng.commonsdk.statistics.common.a$b */
    /* loaded from: classes4.dex */
    public static final class ServiceConnectionC1773b implements ServiceConnection {

        /* renamed from: a */
        public boolean f4052a;

        /* renamed from: b */
        public final LinkedBlockingQueue<IBinder> f4053b;

        public ServiceConnectionC1773b() {
            this.f4052a = false;
            this.f4053b = new LinkedBlockingQueue<>(1);
        }

        /* renamed from: a */
        public IBinder m514a() throws InterruptedException {
            if (!this.f4052a) {
                this.f4052a = true;
                return this.f4053b.take();
            }
            throw new IllegalStateException();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f4053b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* renamed from: com.umeng.commonsdk.statistics.common.a$c */
    /* loaded from: classes4.dex */
    public static final class C1774c implements IInterface {

        /* renamed from: a */
        public IBinder f4054a;

        public C1774c(IBinder iBinder) {
            this.f4054a = iBinder;
        }

        /* renamed from: a */
        public String m513a() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f4054a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        /* renamed from: a */
        public boolean m512a(boolean z) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                boolean z2 = true;
                obtain.writeInt(z ? 1 : 0);
                this.f4054a.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() == 0) {
                    z2 = false;
                }
                return z2;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f4054a;
        }
    }

    /* renamed from: a */
    public static String m520a(Context context) {
        try {
            C1772a m518c = m518c(context);
            if (m518c != null && !m518c.m517a()) {
                return m518c.m515b();
            }
        } catch (Exception unused) {
        }
        return null;
    }

    /* renamed from: b */
    public static String m519b(Context context) {
        try {
            C1772a m518c = m518c(context);
            if (m518c != null) {
                return m518c.m515b();
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: c */
    public static C1772a m518c(Context context) throws Exception {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return null;
        }
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            ServiceConnectionC1773b serviceConnectionC1773b = new ServiceConnectionC1773b();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            if (!context.bindService(intent, serviceConnectionC1773b, 1)) {
                throw new IOException("Google Play connection failed");
            }
            try {
                try {
                    C1774c c1774c = new C1774c(serviceConnectionC1773b.m514a());
                    boolean m512a = c1774c.m512a(true);
                    String str = "";
                    if (!m512a) {
                        str = c1774c.m513a();
                    }
                    return new C1772a(str, m512a);
                } catch (Exception e) {
                    throw e;
                }
            } finally {
                context.unbindService(serviceConnectionC1773b);
            }
        } catch (Exception e2) {
            throw e2;
        }
    }
}
