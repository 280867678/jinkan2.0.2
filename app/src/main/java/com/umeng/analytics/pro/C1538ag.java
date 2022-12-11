package com.umeng.analytics.pro;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.umeng.analytics.pro.AbstractC1567b;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* renamed from: com.umeng.analytics.pro.ag */
/* loaded from: classes4.dex */
public class C1538ag implements AbstractC1671z {

    /* renamed from: a */
    public static final String f2928a = "DeviceIdService";

    /* renamed from: b */
    public static final String f2929b = "com.samsung.android.deviceidservice";

    /* renamed from: c */
    public static final String f2930c = "com.samsung.android.deviceidservice.DeviceIdService";

    /* renamed from: e */
    public CountDownLatch f2932e;

    /* renamed from: d */
    public String f2931d = "";

    /* renamed from: f */
    public final ServiceConnection f2933f = new ServiceConnection() { // from class: com.umeng.analytics.pro.ag.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                AbstractC1567b m1221a = AbstractC1567b.AbstractBinderC1568a.m1221a(iBinder);
                C1538ag.this.f2931d = m1221a.mo1220a();
            } catch (RemoteException | NullPointerException e) {
                e.getMessage();
            }
            C1538ag.this.f2932e.countDown();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    /* renamed from: b */
    private void m1383b(Context context) {
        try {
            Intent intent = new Intent();
            intent.setClassName(f2929b, f2930c);
            if (context.bindService(intent, this.f2933f, 1)) {
                return;
            }
            throw new UnsupportedOperationException("not supported service");
        } catch (Error | Exception e) {
            e.getMessage();
            this.f2932e.countDown();
        }
    }

    /* renamed from: c */
    private void m1382c(Context context) {
        try {
            context.unbindService(this.f2933f);
        } catch (Error | Exception e) {
            e.getMessage();
        }
    }

    @Override // com.umeng.analytics.pro.AbstractC1671z
    /* renamed from: a */
    public String mo850a(Context context) {
        this.f2932e = new CountDownLatch(1);
        try {
            try {
                m1383b(context);
                this.f2932e.await(500L, TimeUnit.MILLISECONDS);
                return this.f2931d;
            } catch (InterruptedException e) {
                e.getMessage();
                m1382c(context);
                return null;
            }
        } finally {
            m1382c(context);
        }
    }
}
