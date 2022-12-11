package com.tencent.bugly.beta.global;

import android.app.Activity;
import android.os.Process;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.beta.download.BetaReceiver;
import com.tencent.bugly.beta.download.DownloadTask;
import com.tencent.bugly.beta.p041ui.AbstractC1105d;
import com.tencent.bugly.beta.p041ui.C1112i;
import com.tencent.bugly.beta.p041ui.C1115l;
import com.tencent.bugly.proguard.C1177B;
import com.tencent.bugly.proguard.C1199X;
import com.tencent.bugly.proguard.C1234p;
import com.tencent.bugly.proguard.C1250z;

/* renamed from: com.tencent.bugly.beta.global.b */
/* loaded from: classes3.dex */
public class View$OnClickListenerC1090b implements View.OnClickListener {

    /* renamed from: a */
    public final int f730a;

    /* renamed from: b */
    public final Object[] f731b;

    public View$OnClickListenerC1090b(int i, Object... objArr) {
        this.f730a = i;
        this.f731b = objArr;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C1112i c1112i;
        try {
            switch (this.f730a) {
                case 1:
                    if (((ViewGroup) this.f731b[1]).getChildCount() > 0) {
                        return;
                    }
                    ((Activity) this.f731b[0]).finish();
                    C1199X.m3078c("BetaAct closed by empty view", new Object[0]);
                    return;
                case 2:
                    c1112i = (AbstractC1105d) this.f731b[0];
                    break;
                case 3:
                    if (this.f731b[1] != null) {
                        ((DownloadTask) this.f731b[1]).download();
                    }
                    c1112i = (AbstractC1105d) this.f731b[0];
                    break;
                case 4:
                    try {
                        C1115l c1115l = (C1115l) this.f731b[0];
                        DownloadTask downloadTask = c1115l.f850s;
                        C1177B c1177b = c1115l.f849r;
                        BetaReceiver.addTask(downloadTask);
                        if (c1115l.f851t != null) {
                            c1115l.f851t.run();
                        }
                        if (downloadTask.getStatus() != 1 || !C1089a.m3623a(C1093e.f737b.f789v, downloadTask.getSaveFile(), c1177b.f1333k.f1662b)) {
                            downloadTask.download();
                        } else {
                            C1234p.f1572a.m2877a(new C1250z("install", System.currentTimeMillis(), (byte) 0, 0L, c1177b.f1332j, c1177b.f1340r, c1177b.f1343u, null));
                        }
                        if (c1177b.f1334l != 2) {
                            c1115l.mo3595a();
                        }
                        c1115l.m3582a(downloadTask);
                        return;
                    } catch (Exception e) {
                        e = e;
                        if (C1199X.m3083a(e)) {
                            return;
                        }
                        e.printStackTrace();
                        return;
                    }
                case 5:
                    C1115l c1115l2 = (C1115l) this.f731b[0];
                    DownloadTask downloadTask2 = c1115l2.f850s;
                    BetaReceiver.netListeners.remove(downloadTask2.getDownloadUrl());
                    downloadTask2.stop();
                    c1115l2.m3582a(downloadTask2);
                    return;
                case 6:
                    C1115l c1115l3 = (C1115l) this.f731b[0];
                    Runnable runnable = c1115l3.f852u;
                    c1112i = c1115l3;
                    if (runnable != null) {
                        c1115l3.f852u.run();
                        c1112i = c1115l3;
                        break;
                    }
                    break;
                case 7:
                    C1112i c1112i2 = (C1112i) this.f731b[0];
                    Process.killProcess(Process.myPid());
                    System.exit(0);
                    return;
                case 8:
                    c1112i = (C1112i) this.f731b[0];
                    break;
                case 9:
                    Beta.installApk(Beta.getStrategyTask().getSaveFile());
                    Beta.saveInstallEvent(true);
                    return;
                default:
                    return;
            }
            c1112i.mo3595a();
        } catch (Exception e2) {
            e = e2;
        }
    }
}
