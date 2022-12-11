package com.tencent.bugly.beta.global;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.beta.UpgradeInfo;
import com.tencent.bugly.beta.download.BetaReceiver;
import com.tencent.bugly.beta.download.DownloadListener;
import com.tencent.bugly.beta.download.DownloadTask;
import com.tencent.bugly.beta.p041ui.AbstractC1106e;
import com.tencent.bugly.beta.p041ui.BetaActiveAlertActivity;
import com.tencent.bugly.beta.p041ui.BetaActivity;
import com.tencent.bugly.beta.p041ui.C1114k;
import com.tencent.bugly.beta.p041ui.C1115l;
import com.tencent.bugly.beta.upgrade.BetaGrayStrategy;
import com.tencent.bugly.beta.upgrade.C1116a;
import com.tencent.bugly.beta.upgrade.C1117b;
import com.tencent.bugly.beta.upgrade.UpgradeListener;
import com.tencent.bugly.beta.upgrade.UpgradeStateListener;
import com.tencent.bugly.beta.utils.C1125e;
import com.tencent.bugly.beta.utils.C1126f;
import com.tencent.bugly.proguard.C1176A;
import com.tencent.bugly.proguard.C1199X;
import com.tencent.bugly.proguard.C1208ca;
import com.tencent.bugly.proguard.C1234p;
import com.tencent.bugly.proguard.C1250z;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.litepal.crud.LitePalSupport;

/* renamed from: com.tencent.bugly.beta.global.d */
/* loaded from: classes3.dex */
public class RunnableC1092d implements Runnable {

    /* renamed from: a */
    public int f734a;

    /* renamed from: b */
    public final Object[] f735b;

    public RunnableC1092d(int i, Object... objArr) {
        this.f734a = i;
        this.f735b = objArr;
    }

    @Override // java.lang.Runnable
    public void run() {
        Exception exc;
        ArrayList arrayList;
        C1234p c1234p;
        C1250z c1250z;
        C1234p c1234p2;
        C1250z c1250z2;
        C1234p c1234p3;
        C1250z c1250z3;
        try {
            UpgradeInfo upgradeInfo = null;
            switch (this.f734a) {
                case 1:
                    try {
                        C1199X.m3078c("Beta async init start...", new Object[0]);
                        C1093e c1093e = C1093e.f737b;
                        synchronized (C1093e.f737b) {
                            try {
                                c1093e.f792y = C1208ca.m3032a(new File(c1093e.f740C.applicationInfo.publicSourceDir), LitePalSupport.MD5);
                            } catch (Exception unused) {
                                c1093e.f792y = null;
                            }
                            if (TextUtils.isEmpty(c1093e.f792y)) {
                                c1093e.f792y = "null";
                                C1199X.m3081b("无法获取md5值", new Object[0]);
                            }
                            if (c1093e.f743F) {
                                C1089a.m3619a(c1093e.f790w);
                            }
                            BetaGrayStrategy betaGrayStrategy = (BetaGrayStrategy) C1089a.m3615a("app.upgrade.strategy.bch", BetaGrayStrategy.CREATOR);
                            if (betaGrayStrategy != null && betaGrayStrategy.f858a != null) {
                                if (TextUtils.equals(betaGrayStrategy.f858a.f1332j.f1676j.toUpperCase(), c1093e.f792y)) {
                                    String str = betaGrayStrategy.f858a.m3188c().get("h5");
                                    if (!TextUtils.isEmpty(str)) {
                                        if (Beta.enableActiveH5Alert) {
                                            Intent intent = new Intent(C1093e.f737b.f789v, BetaActiveAlertActivity.class);
                                            intent.putExtra("h5", betaGrayStrategy.f858a.m3188c().get("h5"));
                                            intent.addFlags(268435456);
                                            C1093e.f737b.f789v.startActivity(intent);
                                        }
                                        if (Beta.activeListener != null) {
                                            Beta.activeListener.onActive(str);
                                        }
                                    }
                                    if (C1089a.m3616a("app.upgrade.strategy.bch")) {
                                        C1234p.f1572a.m2877a(new C1250z("active", System.currentTimeMillis(), (byte) 0, 0L, null, betaGrayStrategy.f858a.f1340r, betaGrayStrategy.f858a.f1343u, null));
                                        DownloadTask mo2863a = c1093e.f786s.mo2863a(betaGrayStrategy.f858a.f1333k.f1663c, c1093e.f790w.getAbsolutePath(), null, null);
                                        mo2863a.setDownloadType(1);
                                        mo2863a.delete(true);
                                        C1089a.m3619a(c1093e.f790w);
                                        C1094f.f794a.m3607a();
                                        C1199X.m3078c("upgrade success", new Object[0]);
                                    } else {
                                        C1199X.m3076e("delete strategy failed", new Object[0]);
                                    }
                                }
                                C1199X.m3078c("[this md5:%s] [strategy md5:%s]", c1093e.f792y, betaGrayStrategy.f858a.f1332j.f1676j);
                            }
                            C1093e.f737b.notifyAll();
                        }
                        c1093e.f789v.registerReceiver(new BetaReceiver(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                        if (c1093e.f770e) {
                            Beta.checkUpgrade(false, false);
                        } else {
                            if (c1093e.f774g) {
                                Beta.checkHotFix();
                            }
                            if (c1093e.f772f) {
                                Beta.checkAppUpgrade(false, false);
                            }
                        }
                        if (C1093e.f737b.f745H.f863a.f1627e && (arrayList = (ArrayList) C1234p.f1572a.m2875b()) != null && !arrayList.isEmpty()) {
                            C1117b.f869a.m3578a(new C1176A(arrayList), true);
                        }
                        C1199X.m3078c("Beta async init end...", new Object[0]);
                        return;
                    } catch (Exception e) {
                        exc = e;
                        if (C1199X.m3083a(exc)) {
                            return;
                        }
                        exc.printStackTrace();
                        return;
                    }
                case 2:
                    C1114k.m3586a((AbstractC1106e) this.f735b[0], ((Boolean) this.f735b[1]).booleanValue());
                    return;
                case 3:
                    BetaGrayStrategy betaGrayStrategy2 = (BetaGrayStrategy) this.f735b[0];
                    DownloadTask downloadTask = (DownloadTask) this.f735b[1];
                    if (!betaGrayStrategy2.f861d) {
                        betaGrayStrategy2.f861d = true;
                        betaGrayStrategy2.f860c = System.currentTimeMillis();
                        if (betaGrayStrategy2.f858a != null && betaGrayStrategy2.f858a.f1343u == 1) {
                            C1089a.m3614a("app.upgrade.strategy.bch", betaGrayStrategy2);
                        }
                    }
                    if (downloadTask.getStatus() == 2) {
                        return;
                    }
                    if (downloadTask.getStatus() == 1) {
                        c1234p = C1234p.f1572a;
                        c1250z = new C1250z("pop", System.currentTimeMillis(), (byte) 4, 0L, betaGrayStrategy2.f858a.f1332j, betaGrayStrategy2.f858a.f1340r, betaGrayStrategy2.f858a.f1343u, null);
                    } else {
                        c1234p = C1234p.f1572a;
                        c1250z = new C1250z("pop", System.currentTimeMillis(), (byte) 3, 0L, betaGrayStrategy2.f858a.f1332j, betaGrayStrategy2.f858a.f1340r, betaGrayStrategy2.f858a.f1343u, null);
                    }
                    c1234p.m2877a(c1250z);
                    return;
                case 4:
                    BetaGrayStrategy betaGrayStrategy3 = (BetaGrayStrategy) this.f735b[0];
                    boolean booleanValue = ((Boolean) this.f735b[2]).booleanValue();
                    if (((DownloadTask) this.f735b[1]).getStatus() == 2) {
                        return;
                    }
                    betaGrayStrategy3.f861d = false;
                    betaGrayStrategy3.f860c = System.currentTimeMillis();
                    if (!booleanValue && betaGrayStrategy3.f858a.f1334l != 2) {
                        betaGrayStrategy3.f859b++;
                    }
                    if (betaGrayStrategy3.f858a != null && betaGrayStrategy3.f858a.f1343u == 1) {
                        C1089a.m3614a("app.upgrade.strategy.bch", betaGrayStrategy3);
                    }
                    c1234p = C1234p.f1572a;
                    c1250z = new C1250z("pop", System.currentTimeMillis(), (byte) 2, 0L, betaGrayStrategy3.f858a.f1332j, betaGrayStrategy3.f858a.f1340r, betaGrayStrategy3.f858a.f1343u, null);
                    c1234p.m2877a(c1250z);
                    return;
                case 5:
                    C1126f.m3487a(C1093e.f737b.f789v, (String) this.f735b[0]);
                    return;
                case 6:
                    synchronized (this) {
                        if (!((Boolean) this.f735b[0]).booleanValue()) {
                            this.f735b[0] = true;
                            ((Runnable) this.f735b[1]).run();
                        }
                    }
                    return;
                case 7:
                    ((C1115l) this.f735b[0]).m3580c();
                    return;
                case 8:
                    List<DownloadListener> list = (List) this.f735b[0];
                    if (list == null) {
                        return;
                    }
                    for (DownloadListener downloadListener : list) {
                        if (downloadListener != null) {
                            downloadListener.onCompleted((DownloadTask) this.f735b[1]);
                        }
                    }
                    return;
                case 9:
                    List<DownloadListener> list2 = (List) this.f735b[0];
                    if (list2 != null) {
                        for (DownloadListener downloadListener2 : list2) {
                            if (downloadListener2 != null) {
                                downloadListener2.onReceive((DownloadTask) this.f735b[1]);
                            }
                        }
                    }
                    DownloadTask downloadTask2 = (DownloadTask) this.f735b[1];
                    if (C1093e.f737b.f762Y == null || downloadTask2.getDownloadType() != 3) {
                        return;
                    }
                    C1093e.f737b.f762Y.onDownloadReceived(downloadTask2.getSavedLength(), downloadTask2.getTotalLength());
                    return;
                case 10:
                    List<DownloadListener> list3 = (List) this.f735b[0];
                    if (list3 == null) {
                        return;
                    }
                    for (DownloadListener downloadListener3 : list3) {
                        if (downloadListener3 != null) {
                            downloadListener3.onFailed((DownloadTask) this.f735b[1], ((Integer) this.f735b[2]).intValue(), (String) this.f735b[3]);
                        }
                    }
                    return;
                case 11:
                    C1114k.m3585a((AbstractC1106e) this.f735b[0], ((Boolean) this.f735b[1]).booleanValue(), ((Boolean) this.f735b[2]).booleanValue(), ((Long) this.f735b[3]).longValue());
                    StringBuilder sb = new StringBuilder();
                    sb.append("BetaAct TYPE_actCanShow checking : ");
                    sb.append(this.f735b[0].hashCode());
                    C1199X.m3078c(sb.toString(), new Object[0]);
                    return;
                case 12:
                    boolean booleanValue2 = ((Boolean) this.f735b[0]).booleanValue();
                    C1116a c1116a = (C1116a) this.f735b[1];
                    synchronized (this.f735b[1]) {
                        if (!booleanValue2 && !c1116a.f868d) {
                            this.f735b[0] = true;
                            c1116a.mo3120a(c1116a.f866b, null, 0L, 0L, false, "request is not finished");
                            c1116a.f867c[1] = true;
                            c1116a.f868d = false;
                            C1199X.m3078c("request is not finished", new Object[0]);
                        }
                    }
                    return;
                case 13:
                    DownloadTask downloadTask3 = (DownloadTask) this.f735b[0];
                    BetaGrayStrategy betaGrayStrategy4 = (BetaGrayStrategy) this.f735b[1];
                    if (downloadTask3 != null && betaGrayStrategy4 != null) {
                        int status = downloadTask3.getStatus();
                        if (status != 0 && status != 1) {
                            if (status == 2) {
                                downloadTask3.stop();
                                return;
                            } else if (status != 3 && status != 4 && status != 5) {
                                return;
                            }
                        }
                        if (!betaGrayStrategy4.f861d) {
                            betaGrayStrategy4.f861d = true;
                            betaGrayStrategy4.f860c = System.currentTimeMillis();
                            if (betaGrayStrategy4.f858a != null && betaGrayStrategy4.f858a.f1343u == 1) {
                                C1089a.m3614a("app.upgrade.strategy.bch", betaGrayStrategy4);
                            }
                        }
                        if (downloadTask3.getStatus() != 2) {
                            if (downloadTask3.getStatus() == 1) {
                                c1234p3 = C1234p.f1572a;
                                c1250z3 = new C1250z("pop", System.currentTimeMillis(), (byte) 4, 0L, betaGrayStrategy4.f858a.f1332j, betaGrayStrategy4.f858a.f1340r, betaGrayStrategy4.f858a.f1343u, null);
                            } else {
                                c1234p3 = C1234p.f1572a;
                                c1250z3 = new C1250z("pop", System.currentTimeMillis(), (byte) 3, 0L, betaGrayStrategy4.f858a.f1332j, betaGrayStrategy4.f858a.f1340r, betaGrayStrategy4.f858a.f1343u, null);
                            }
                            c1234p3.m2877a(c1250z3);
                        }
                        if (downloadTask3.getStatus() != 1 || !C1089a.m3623a(C1093e.f737b.f789v, downloadTask3.getSaveFile(), betaGrayStrategy4.f858a.f1333k.f1662b)) {
                            downloadTask3.download();
                            return;
                        }
                        c1234p2 = C1234p.f1572a;
                        c1250z2 = new C1250z("install", System.currentTimeMillis(), (byte) 0, 0L, betaGrayStrategy4.f858a.f1332j, betaGrayStrategy4.f858a.f1340r, betaGrayStrategy4.f858a.f1343u, null);
                        c1234p2.m2877a(c1250z2);
                        return;
                    }
                    C1199X.m3078c("strategyTask or betaStrategy is null", new Object[0]);
                    return;
                case 14:
                    DownloadTask downloadTask4 = (DownloadTask) this.f735b[0];
                    BetaGrayStrategy betaGrayStrategy5 = (BetaGrayStrategy) this.f735b[1];
                    boolean booleanValue3 = ((Boolean) this.f735b[2]).booleanValue();
                    if (downloadTask4 != null && betaGrayStrategy5 != null) {
                        if (downloadTask4.getStatus() == 2) {
                            return;
                        }
                        betaGrayStrategy5.f861d = false;
                        betaGrayStrategy5.f860c = System.currentTimeMillis();
                        if (!booleanValue3 && betaGrayStrategy5.f858a.f1334l != 2) {
                            betaGrayStrategy5.f859b++;
                        }
                        if (betaGrayStrategy5.f858a != null && betaGrayStrategy5.f858a.f1343u == 1) {
                            C1089a.m3614a("app.upgrade.strategy.bch", betaGrayStrategy5);
                        }
                        c1234p2 = C1234p.f1572a;
                        c1250z2 = new C1250z("pop", System.currentTimeMillis(), (byte) 2, 0L, betaGrayStrategy5.f858a.f1332j, betaGrayStrategy5.f858a.f1340r, betaGrayStrategy5.f858a.f1343u, null);
                        c1234p2.m2877a(c1250z2);
                        return;
                    }
                    C1199X.m3078c("strategyTask or betaStrategy is null", new Object[0]);
                    return;
                case 15:
                    if (!((AbstractC1106e) this.f735b[0]).m3594b() && !TextUtils.equals(C1114k.m3584b(), BetaActivity.class.getCanonicalName())) {
                        C1114k.m3585a((AbstractC1106e) this.f735b[0], ((Boolean) this.f735b[1]).booleanValue(), ((Boolean) this.f735b[2]).booleanValue(), ((Long) this.f735b[3]).longValue());
                        return;
                    }
                    C1125e.m3489a(this, 3000L);
                    return;
                case 16:
                    UpgradeListener upgradeListener = (UpgradeListener) this.f735b[0];
                    int intValue = ((Integer) this.f735b[1]).intValue();
                    BetaGrayStrategy betaGrayStrategy6 = (BetaGrayStrategy) this.f735b[2];
                    boolean booleanValue4 = ((Boolean) this.f735b[3]).booleanValue();
                    boolean booleanValue5 = ((Boolean) this.f735b[4]).booleanValue();
                    if (betaGrayStrategy6 != null) {
                        upgradeInfo = new UpgradeInfo(betaGrayStrategy6.f858a);
                    }
                    upgradeListener.onUpgrade(intValue, upgradeInfo, booleanValue4, booleanValue5);
                    return;
                case 17:
                    try {
                        PackageManager packageManager = C1093e.f737b.f789v.getPackageManager();
                        if (packageManager != null) {
                            ComponentName componentName = new ComponentName(C1093e.f737b.f789v, BetaActivity.class.getName());
                            if (packageManager.getComponentEnabledSetting(componentName) == 2) {
                                packageManager.setComponentEnabledSetting(componentName, 1, 1);
                            }
                        }
                        ((Map) this.f735b[0]).put((Integer) this.f735b[1], (AbstractC1106e) this.f735b[2]);
                        Intent intent2 = new Intent(C1093e.f737b.f789v, BetaActivity.class);
                        intent2.putExtra("frag", (Integer) this.f735b[1]);
                        intent2.setFlags(268435456);
                        C1093e.f737b.f789v.startActivity(intent2);
                        return;
                    } catch (Exception e2) {
                        exc = e2;
                        C1199X.m3081b("无法正常弹窗，请在AndroidManifest.xml中添加BetaActivity声明：\n<activity\n    android:name=\"com.tencent.bugly.beta.ui.BetaActivity\"\n    android:theme=\"@android:style/Theme.Translucent\" />", new Object[0]);
                        if (C1199X.m3083a(exc)) {
                            return;
                        }
                        exc.printStackTrace();
                        return;
                    }
                case 18:
                    UpgradeStateListener upgradeStateListener = (UpgradeStateListener) this.f735b[0];
                    int intValue2 = ((Integer) this.f735b[1]).intValue();
                    boolean booleanValue6 = ((Boolean) this.f735b[2]).booleanValue();
                    if (intValue2 == -1) {
                        upgradeStateListener.onUpgradeFailed(booleanValue6);
                        return;
                    } else if (intValue2 == 0) {
                        upgradeStateListener.onUpgradeSuccess(booleanValue6);
                        return;
                    } else if (intValue2 == 1) {
                        upgradeStateListener.onUpgradeNoVersion(booleanValue6);
                        return;
                    } else if (intValue2 == 2) {
                        upgradeStateListener.onUpgrading(booleanValue6);
                        return;
                    } else if (intValue2 != 3) {
                        return;
                    } else {
                        upgradeStateListener.onDownloadCompleted(booleanValue6);
                        return;
                    }
                default:
                    return;
            }
        } catch (Exception e3) {
            if (C1199X.m3083a(e3)) {
                return;
            }
            e3.printStackTrace();
        }
    }
}
