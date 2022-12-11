package com.tencent.bugly.beta.download;

import android.os.Build;
import com.arialyy.aria.core.inf.ReceiverType;
import com.tencent.bugly.beta.global.C1089a;
import com.tencent.bugly.beta.global.C1093e;
import com.tencent.bugly.beta.global.C1094f;
import com.tencent.bugly.beta.global.ResBean;
import com.tencent.bugly.beta.global.RunnableC1092d;
import com.tencent.bugly.beta.p041ui.C1115l;
import com.tencent.bugly.beta.tinker.TinkerManager;
import com.tencent.bugly.beta.upgrade.BetaGrayStrategy;
import com.tencent.bugly.beta.upgrade.C1117b;
import com.tencent.bugly.beta.upgrade.C1118c;
import com.tencent.bugly.beta.utils.C1125e;
import com.tencent.bugly.proguard.C1199X;
import com.tencent.bugly.proguard.C1234p;
import com.tencent.bugly.proguard.C1238r;
import com.tencent.bugly.proguard.C1250z;
import java.io.File;
import java.util.Map;

/* renamed from: com.tencent.bugly.beta.download.a */
/* loaded from: classes3.dex */
public class C1085a implements DownloadListener {

    /* renamed from: a */
    public final int f718a;

    /* renamed from: b */
    public final Object[] f719b;

    public C1085a(int i, Object... objArr) {
        this.f718a = i;
        this.f719b = objArr;
    }

    @Override // com.tencent.bugly.beta.download.DownloadListener
    public void onCompleted(DownloadTask downloadTask) {
        DownloadTask downloadTask2;
        TinkerManager tinkerManager;
        String str;
        try {
            int i = this.f718a;
            if (i == 1) {
                synchronized (this.f719b[0]) {
                    Map map = (Map) this.f719b[1];
                    if (map.size() == 0) {
                        return;
                    }
                    int i2 = 0;
                    for (DownloadTask downloadTask3 : map.values()) {
                        if (downloadTask3.getStatus() == 1) {
                            i2++;
                        }
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(i2);
                    sb.append(" has completed");
                    C1199X.m3084a(sb.toString(), new Object[0]);
                    if (i2 < map.size()) {
                        return;
                    }
                    for (String str2 : map.keySet()) {
                        if (((DownloadTask) map.get(str2)).getSaveFile() != null && ((DownloadTask) map.get(str2)).getSaveFile().exists()) {
                            ResBean.f725a.m3627a(str2, ((DownloadTask) map.get(str2)).getSaveFile().getAbsolutePath());
                        }
                    }
                    C1089a.m3614a("rb.bch", ResBean.f725a);
                    C1094f c1094f = (C1094f) this.f719b[0];
                    c1094f.m3607a();
                    c1094f.m3603b();
                }
            } else if (i == 2) {
                ((C1115l) this.f719b[0]).m3582a(downloadTask);
            } else {
                if (i == 3) {
                    C1118c c1118c = (C1118c) this.f719b[0];
                    BetaGrayStrategy betaGrayStrategy = c1118c.f871b;
                    if (betaGrayStrategy != null && betaGrayStrategy.f858a != null) {
                        if (c1118c.f875f != null) {
                            C1125e.m3490a(new RunnableC1092d(18, c1118c.f875f, 3, Boolean.valueOf(c1118c.f876g)));
                        }
                        C1199X.m3078c("apk download completed", new Object[0]);
                        C1250z c1250z = new C1250z(ReceiverType.DOWNLOAD, System.currentTimeMillis(), (byte) 0, downloadTask.getCostTime(), betaGrayStrategy.f858a.f1332j, betaGrayStrategy.f858a.f1340r, betaGrayStrategy.f858a.f1343u, null);
                        if (C1234p.f1572a.m2877a(c1250z)) {
                            C1117b.f869a.m3577a(c1250z, true);
                        }
                        if (!C1093e.f737b.f773fa) {
                            return;
                        }
                        File saveFile = downloadTask.getSaveFile();
                        Integer num = (Integer) this.f719b[1];
                        if (C1089a.m3623a(C1093e.f737b.f789v, saveFile, betaGrayStrategy.f858a.f1333k.f1662b)) {
                            this.f719b[1] = 0;
                            C1234p.f1572a.m2877a(new C1250z("install", System.currentTimeMillis(), (byte) 0, 0L, betaGrayStrategy.f858a.f1332j, betaGrayStrategy.f858a.f1340r, betaGrayStrategy.f858a.f1343u, null));
                            return;
                        } else if (num.intValue() >= 2) {
                            this.f719b[1] = 0;
                            onFailed(downloadTask, 2080, "file md5 verify fail");
                            downloadTask.delete(true);
                            return;
                        } else if (Build.VERSION.SDK_INT >= 24) {
                            this.f719b[1] = 0;
                            onFailed(downloadTask, 2080, "安装失败，请检查您的App是否兼容7.0设备");
                            downloadTask.delete(true);
                            return;
                        } else {
                            this.f719b[1] = Integer.valueOf(num.intValue() + 1);
                            downloadTask.delete(true);
                            DownloadTask mo2863a = C1093e.f737b.f786s.mo2863a(betaGrayStrategy.f858a.f1333k.f1663c, C1093e.f737b.f790w.getAbsolutePath(), null, betaGrayStrategy.f858a.f1333k.f1663c);
                            c1118c.f872c = mo2863a;
                            mo2863a.setDownloadType(1);
                            C1115l.f842n.m3581a(betaGrayStrategy.f858a, c1118c.f872c);
                            c1118c.f872c.addListener(this);
                            BetaReceiver.addTask(c1118c.f872c);
                            downloadTask2 = c1118c.f872c;
                        }
                    }
                    return;
                } else if (i != 4) {
                    return;
                } else {
                    C1238r c1238r = (C1238r) this.f719b[0];
                    Integer num2 = (Integer) this.f719b[1];
                    BetaGrayStrategy betaGrayStrategy2 = c1238r.f1612b;
                    if (betaGrayStrategy2 == null || betaGrayStrategy2.f858a == null) {
                        return;
                    }
                    C1199X.m3078c("patch download success !!!", new Object[0]);
                    File saveFile2 = downloadTask.getSaveFile();
                    if (C1089a.m3617a(saveFile2, betaGrayStrategy2.f858a.f1333k.f1662b, "SHA")) {
                        this.f719b[1] = 0;
                        if (C1089a.m3618a(saveFile2, C1093e.f737b.f747J)) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("copy ");
                            sb2.append(saveFile2.getAbsolutePath());
                            sb2.append(" to ");
                            sb2.append(C1093e.f737b.f747J.getAbsolutePath());
                            sb2.append(" success!");
                            C1199X.m3084a(sb2.toString(), new Object[0]);
                            if (c1238r.f1613c != null) {
                                C1199X.m3084a("delete temp file", new Object[0]);
                                c1238r.f1613c.delete(true);
                            }
                            C1089a.m3609b("UPLOAD_PATCH_RESULT", false);
                            TinkerManager.getInstance().onDownloadSuccess(C1093e.f737b.f747J.getAbsolutePath(), C1093e.f737b.f761X);
                            return;
                        }
                        C1199X.m3078c("copy file failed", new Object[0]);
                        tinkerManager = TinkerManager.getInstance();
                        str = "copy file failure.";
                    } else if (num2.intValue() < 2) {
                        this.f719b[1] = Integer.valueOf(num2.intValue() + 1);
                        downloadTask.delete(true);
                        DownloadTask mo2863a2 = C1093e.f737b.f786s.mo2863a(betaGrayStrategy2.f858a.f1333k.f1663c, C1093e.f737b.f790w.getAbsolutePath(), null, betaGrayStrategy2.f858a.f1333k.f1663c);
                        c1238r.f1613c = mo2863a2;
                        mo2863a2.setDownloadType(3);
                        c1238r.f1613c.setNeededNotify(false);
                        c1238r.f1613c.addListener(this);
                        BetaReceiver.addTask(c1238r.f1613c);
                        downloadTask2 = c1238r.f1613c;
                    } else {
                        this.f719b[1] = 0;
                        onFailed(downloadTask, 2080, "file sha1 verify fail");
                        downloadTask.delete(true);
                        tinkerManager = TinkerManager.getInstance();
                        str = "retry download patch too many times.";
                    }
                    tinkerManager.onDownloadFailure(str);
                    return;
                }
                downloadTask2.download();
            }
        } catch (Exception e) {
            if (C1199X.m3083a(e)) {
                return;
            }
            e.printStackTrace();
        }
    }

    @Override // com.tencent.bugly.beta.download.DownloadListener
    public void onFailed(DownloadTask downloadTask, int i, String str) {
        try {
            int i2 = this.f718a;
            if (i2 == 1) {
                synchronized (this.f719b[0]) {
                    C1094f c1094f = (C1094f) this.f719b[0];
                    c1094f.m3607a();
                    c1094f.m3603b();
                }
            } else if (i2 == 2) {
                ((C1115l) this.f719b[0]).m3582a(downloadTask);
            } else if (i2 == 3) {
                C1118c c1118c = (C1118c) this.f719b[0];
                if (downloadTask != null) {
                    C1234p.f1572a.m2877a(new C1250z(ReceiverType.DOWNLOAD, System.currentTimeMillis(), (byte) 1, downloadTask.getCostTime(), c1118c.f871b.f858a.f1332j, c1118c.f871b.f858a.f1340r, c1118c.f871b.f858a.f1343u, null));
                }
                C1199X.m3081b("upgrade failed：(%d)%s", Integer.valueOf(i), str);
            } else if (i2 != 4) {
            } else {
                C1238r c1238r = (C1238r) this.f719b[0];
                if (downloadTask != null) {
                    C1234p.f1572a.m2877a(new C1250z(ReceiverType.DOWNLOAD, System.currentTimeMillis(), (byte) 1, downloadTask.getCostTime(), c1238r.f1612b.f858a.f1332j, c1238r.f1612b.f858a.f1340r, c1238r.f1612b.f858a.f1343u, null));
                }
                C1199X.m3081b("hotfix download failed：(%d)%s", Integer.valueOf(i), str);
                TinkerManager.getInstance().onDownloadFailure(str);
            }
        } catch (Exception e) {
            if (C1199X.m3083a(e)) {
                return;
            }
            e.printStackTrace();
        }
    }

    @Override // com.tencent.bugly.beta.download.DownloadListener
    public void onReceive(DownloadTask downloadTask) {
        if (this.f718a != 2) {
            return;
        }
        ((C1115l) this.f719b[0]).m3582a(downloadTask);
    }
}
