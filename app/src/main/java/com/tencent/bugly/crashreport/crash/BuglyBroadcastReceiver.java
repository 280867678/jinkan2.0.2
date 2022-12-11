package com.tencent.bugly.crashreport.crash;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.bugly.crashreport.biz.C1138f;
import com.tencent.bugly.crashreport.common.info.C1140a;
import com.tencent.bugly.crashreport.common.info.C1141b;
import com.tencent.bugly.crashreport.common.strategy.C1145c;
import com.tencent.bugly.proguard.C1195T;
import com.tencent.bugly.proguard.C1199X;
import com.tencent.bugly.proguard.C1208ca;
import org.eclipse.jetty.server.AsyncContinuation;

/* loaded from: classes3.dex */
public class BuglyBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: a */
    public static BuglyBroadcastReceiver f1116a;

    /* renamed from: c */
    public Context f1118c;

    /* renamed from: d */
    public String f1119d;

    /* renamed from: e */
    public boolean f1120e = true;

    /* renamed from: b */
    public IntentFilter f1117b = new IntentFilter();

    public static synchronized BuglyBroadcastReceiver getInstance() {
        BuglyBroadcastReceiver buglyBroadcastReceiver;
        synchronized (BuglyBroadcastReceiver.class) {
            if (f1116a == null) {
                f1116a = new BuglyBroadcastReceiver();
            }
            buglyBroadcastReceiver = f1116a;
        }
        return buglyBroadcastReceiver;
    }

    /* renamed from: a */
    public final synchronized boolean m3338a(Context context, Intent intent) {
        if (context != null && intent != null) {
            if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                if (this.f1120e) {
                    this.f1120e = false;
                    return true;
                }
                String m3374c = C1141b.m3374c(this.f1118c);
                C1199X.m3084a("is Connect BC " + m3374c, new Object[0]);
                C1199X.m3078c("network %s changed to %s", "" + this.f1119d, "" + m3374c);
                if (m3374c == null) {
                    this.f1119d = null;
                    return true;
                }
                String str = this.f1119d;
                this.f1119d = m3374c;
                long currentTimeMillis = System.currentTimeMillis();
                C1145c m3344b = C1145c.m3344b();
                C1195T m3119a = C1195T.m3119a();
                C1140a m3421a = C1140a.m3421a(context);
                if (m3344b != null && m3119a != null && m3421a != null) {
                    if (!m3374c.equals(str)) {
                        if (currentTimeMillis - m3119a.m3104b(C1164h.f1231a) > AsyncContinuation.DEFAULT_TIMEOUT) {
                            C1199X.m3078c("try to upload crash on network changed.", new Object[0]);
                            C1164h m3262g = C1164h.m3262g();
                            if (m3262g != null) {
                                m3262g.m3275a(0L);
                            }
                        }
                        if (currentTimeMillis - m3119a.m3104b(1001) > AsyncContinuation.DEFAULT_TIMEOUT) {
                            C1199X.m3078c("try to upload userinfo on network changed.", new Object[0]);
                            C1138f.f992i.m3469b();
                        }
                    }
                    return true;
                }
                C1199X.m3076e("not inited BC not work", new Object[0]);
                return true;
            }
        }
        return false;
    }

    public synchronized void addFilter(String str) {
        if (!this.f1117b.hasAction(str)) {
            this.f1117b.addAction(str);
        }
        C1199X.m3084a("add action %s", str);
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        try {
            m3338a(context, intent);
        } catch (Throwable th) {
            if (C1199X.m3080b(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public synchronized void register(Context context) {
        this.f1118c = context;
        C1208ca.m3029a(new RunnableC1146a(this, this));
    }

    public synchronized void unregister(Context context) {
        try {
            C1199X.m3079c(getClass(), "Unregister broadcast receiver of Bugly.", new Object[0]);
            context.unregisterReceiver(this);
            this.f1118c = context;
        } catch (Throwable th) {
            if (!C1199X.m3080b(th)) {
                th.printStackTrace();
            }
        }
    }
}
