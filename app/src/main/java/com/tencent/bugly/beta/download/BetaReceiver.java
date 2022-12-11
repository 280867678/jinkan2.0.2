package com.tencent.bugly.beta.download;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.bugly.beta.global.C1089a;
import com.tencent.bugly.beta.global.C1093e;
import com.tencent.bugly.beta.p041ui.C1113j;
import com.tencent.bugly.proguard.C1198W;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public class BetaReceiver extends BroadcastReceiver {
    public static ConcurrentHashMap<String, C1088d> netListeners = new ConcurrentHashMap<>(3);
    public static int netStatus = 0;
    public static String CONNECTIVITY_CHANGE = "android.net.conn.CONNECTIVITY_CHANGE";

    public static synchronized void addTask(DownloadTask downloadTask) {
        synchronized (BetaReceiver.class) {
            netStatus = C1089a.m3626a(C1093e.f737b.f789v);
            C1113j c1113j = new C1113j();
            c1113j.f836n = downloadTask;
            netListeners.put(downloadTask.getDownloadUrl(), new C1088d(2, downloadTask, false, c1113j));
        }
    }

    @Override // android.content.BroadcastReceiver
    public synchronized void onReceive(Context context, Intent intent) {
        C1198W.m3089c().m3092a(new RunnableC1086b(this, intent, context));
    }
}
