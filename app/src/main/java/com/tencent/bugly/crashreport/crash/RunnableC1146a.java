package com.tencent.bugly.crashreport.crash;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.bugly.proguard.C1199X;

/* renamed from: com.tencent.bugly.crashreport.crash.a */
/* loaded from: classes3.dex */
public class RunnableC1146a implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ BuglyBroadcastReceiver f1171a;

    /* renamed from: b */
    public final /* synthetic */ BuglyBroadcastReceiver f1172b;

    public RunnableC1146a(BuglyBroadcastReceiver buglyBroadcastReceiver, BuglyBroadcastReceiver buglyBroadcastReceiver2) {
        this.f1172b = buglyBroadcastReceiver;
        this.f1171a = buglyBroadcastReceiver2;
    }

    @Override // java.lang.Runnable
    public void run() {
        BuglyBroadcastReceiver buglyBroadcastReceiver;
        Context context;
        BuglyBroadcastReceiver buglyBroadcastReceiver2;
        IntentFilter intentFilter;
        try {
            buglyBroadcastReceiver = BuglyBroadcastReceiver.f1116a;
            C1199X.m3079c(buglyBroadcastReceiver.getClass(), "Register broadcast receiver of Bugly.", new Object[0]);
            synchronized (this.f1171a) {
                context = this.f1172b.f1118c;
                buglyBroadcastReceiver2 = BuglyBroadcastReceiver.f1116a;
                intentFilter = this.f1172b.f1117b;
                context.registerReceiver(buglyBroadcastReceiver2, intentFilter, "com.tencent.bugly.BuglyBroadcastReceiver.permission", null);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
