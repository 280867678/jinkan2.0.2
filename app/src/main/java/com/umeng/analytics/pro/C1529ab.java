package com.umeng.analytics.pro;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.stub.StubApp;
import com.umeng.analytics.pro.AbstractC1525a;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* renamed from: com.umeng.analytics.pro.ab */
/* loaded from: classes4.dex */
public class C1529ab implements AbstractC1671z {

    /* renamed from: a */
    public static final String f2912a = "Coolpad";

    /* renamed from: b */
    public static final String f2913b = "com.coolpad.deviceidsupport";

    /* renamed from: c */
    public static final String f2914c = "com.coolpad.deviceidsupport.DeviceIdService";

    /* renamed from: d */
    public static AbstractC1525a f2915d;

    /* renamed from: f */
    public CountDownLatch f2917f;

    /* renamed from: g */
    public Context f2918g;

    /* renamed from: e */
    public String f2916e = "";

    /* renamed from: h */
    public final ServiceConnection f2919h = new ServiceConnection() { // from class: com.umeng.analytics.pro.ab.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                AbstractC1525a unused = C1529ab.f2915d = AbstractC1525a.AbstractBinderC1526a.m1408a(iBinder);
                C1529ab.this.f2916e = C1529ab.f2915d.mo1404b(C1529ab.this.f2918g.getPackageName());
                String unused2 = C1529ab.this.f2916e;
            } catch (RemoteException | NullPointerException e) {
                e.getMessage();
            }
            C1529ab.this.f2917f.countDown();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            AbstractC1525a unused = C1529ab.f2915d = null;
        }
    };

    /* renamed from: b */
    private void m1393b(Context context) {
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(f2913b, f2914c));
            context.bindService(intent, this.f2919h, 1);
        } catch (Throwable th) {
            th.getMessage();
            this.f2917f.countDown();
        }
    }

    /* renamed from: c */
    private void m1391c(Context context) {
        try {
            context.unbindService(this.f2919h);
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.umeng.analytics.pro.AbstractC1671z
    /* renamed from: a */
    public String mo850a(Context context) {
        if (context == null) {
            return null;
        }
        this.f2918g = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f2917f = new CountDownLatch(1);
        try {
            m1393b(context);
            this.f2917f.await(500L, TimeUnit.MILLISECONDS);
            return this.f2916e;
        } catch (InterruptedException e) {
            e.getMessage();
            return null;
        } finally {
            m1391c(context);
        }
    }
}
