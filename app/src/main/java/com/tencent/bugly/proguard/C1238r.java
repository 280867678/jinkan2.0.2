package com.tencent.bugly.proguard;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.bugly.beta.download.C1085a;
import com.tencent.bugly.beta.download.DownloadListener;
import com.tencent.bugly.beta.download.DownloadTask;
import com.tencent.bugly.beta.global.C1089a;
import com.tencent.bugly.beta.global.C1093e;
import com.tencent.bugly.beta.global.RunnableC1092d;
import com.tencent.bugly.beta.tinker.TinkerManager;
import com.tencent.bugly.beta.upgrade.BetaGrayStrategy;
import com.tencent.bugly.beta.upgrade.C1116a;
import com.tencent.bugly.beta.upgrade.C1117b;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.bugly.proguard.r */
/* loaded from: classes3.dex */
public class C1238r {

    /* renamed from: a */
    public static C1238r f1611a = new C1238r();

    /* renamed from: b */
    public BetaGrayStrategy f1612b;

    /* renamed from: c */
    public DownloadTask f1613c;

    /* renamed from: g */
    public RunnableC1092d f1617g;

    /* renamed from: h */
    public boolean f1618h;

    /* renamed from: d */
    public final Handler f1614d = new Handler(Looper.getMainLooper());

    /* renamed from: e */
    public DownloadListener f1615e = new C1085a(4, this, 0);

    /* renamed from: f */
    public C1116a f1616f = null;

    /* renamed from: i */
    public final Object f1619i = new Object();

    /* renamed from: a */
    private void m2870a() {
        BetaGrayStrategy betaGrayStrategy = this.f1612b;
        if (betaGrayStrategy == null) {
            return;
        }
        if (this.f1613c == null) {
            C1093e c1093e = C1093e.f737b;
            DownloadTask mo2863a = c1093e.f786s.mo2863a(betaGrayStrategy.f858a.f1333k.f1663c, c1093e.f748K.getAbsolutePath(), null, this.f1612b.f858a.f1333k.f1662b);
            this.f1613c = mo2863a;
            mo2863a.setDownloadType(3);
        }
        DownloadTask downloadTask = this.f1613c;
        if (downloadTask == null) {
            return;
        }
        downloadTask.addListener(this.f1615e);
        this.f1613c.setNeededNotify(false);
        this.f1613c.download();
    }

    /* renamed from: a */
    private void m2868a(BetaGrayStrategy betaGrayStrategy) {
        C1177B c1177b = betaGrayStrategy.f858a;
        if (c1177b == null || c1177b.f1343u != 3) {
            return;
        }
        C1089a.m3614a("hotfix.strategy.bch", betaGrayStrategy);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* renamed from: a */
    public BetaGrayStrategy m2867a(C1177B c1177b) {
        C1177B c1177b2;
        int i;
        Map<String, String> map;
        int i2;
        C1177B c1177b3 = c1177b;
        BetaGrayStrategy betaGrayStrategy = (BetaGrayStrategy) C1089a.m3615a("hotfix.strategy.bch", BetaGrayStrategy.CREATOR);
        if (betaGrayStrategy == null || betaGrayStrategy.f858a == null) {
            C1089a.m3616a("hotfix.strategy.bch");
            betaGrayStrategy = null;
        }
        if (c1177b3 != null) {
            if (c1177b3.f1341s != 1 && betaGrayStrategy != null && !TextUtils.isEmpty(betaGrayStrategy.f858a.f1340r) && TextUtils.equals(c1177b3.f1340r, betaGrayStrategy.f858a.f1340r)) {
                C1234p c1234p = C1234p.f1572a;
                long currentTimeMillis = System.currentTimeMillis();
                C1177B c1177b4 = betaGrayStrategy.f858a;
                c1234p.m2877a(new C1250z("recall", currentTimeMillis, (byte) 0, 0L, null, c1177b4.f1340r, c1177b4.f1343u, null));
                C1089a.m3616a("hotfix.strategy.bch");
                C1093e c1093e = C1093e.f737b;
                DownloadTask mo2863a = c1093e.f786s.mo2863a(betaGrayStrategy.f858a.f1333k.f1663c, c1093e.f748K.getAbsolutePath(), null, betaGrayStrategy.f858a.f1333k.f1662b);
                mo2863a.setDownloadType(3);
                mo2863a.delete(true);
                File file = C1093e.f737b.f747J;
                if (file != null && file.exists() && file.delete()) {
                    C1199X.m3078c("delete tmpPatchFile", new Object[0]);
                }
                File file2 = C1093e.f737b.f746I;
                if (file2 == null || !file2.exists() || !file2.delete()) {
                    i2 = 0;
                } else {
                    i2 = 0;
                    C1199X.m3078c("delete patchFile", new Object[0]);
                }
                C1089a.m3609b("IS_PATCH_ROLL_BACK", true);
                C1199X.m3078c("patch rollback", new Object[i2]);
                if (!C1208ca.m3016b(C1093e.f737b.f789v)) {
                    TinkerManager.getInstance().onPatchRollback(true);
                } else {
                    TinkerManager.getInstance().onPatchRollback(i2);
                }
                betaGrayStrategy = null;
            }
            if (c1177b3.f1341s != 1) {
                c1177b3 = null;
            }
        }
        if (c1177b3 == null) {
            if (betaGrayStrategy != null && (c1177b2 = betaGrayStrategy.f858a) != null && c1177b2.f1343u == 3) {
                return betaGrayStrategy;
            }
            return null;
        }
        BetaGrayStrategy betaGrayStrategy2 = new BetaGrayStrategy();
        betaGrayStrategy2.f858a = c1177b3;
        betaGrayStrategy2.f862e = System.currentTimeMillis();
        if (betaGrayStrategy != null && (!TextUtils.equals(betaGrayStrategy.f858a.f1333k.f1663c, c1177b3.f1333k.f1663c) || ((map = c1177b3.f1339q) != null && TextUtils.equals(map.get("H1"), "false")))) {
            C1093e.f737b.f752O = c1177b3.f1339q.get("H2");
            C1093e c1093e2 = C1093e.f737b;
            DownloadTask mo2863a2 = c1093e2.f786s.mo2863a(betaGrayStrategy.f858a.f1333k.f1663c, c1093e2.f748K.getAbsolutePath(), null, null);
            mo2863a2.setDownloadType(3);
            mo2863a2.delete(true);
            if (betaGrayStrategy.f858a.f1343u == 3) {
                File file3 = C1093e.f737b.f747J;
                if (file3 != null && file3.exists() && file3.delete()) {
                    C1199X.m3078c("delete tmpPatchFile", new Object[0]);
                }
                File file4 = C1093e.f737b.f746I;
                if (file4 == null || !file4.exists() || !file4.delete()) {
                    i = 0;
                } else {
                    C1093e.f737b.f751N = "";
                    i = 0;
                    C1199X.m3078c("delete patchFile", new Object[0]);
                }
                C1093e.f737b.f754Q = i;
                C1089a.m3610b("PATCH_MAX_TIMES", "0");
                m2868a(betaGrayStrategy2);
                Object[] objArr = new Object[2];
                objArr[i] = c1177b3;
                objArr[1] = Integer.valueOf(c1177b3.f1343u);
                C1199X.m3078c("onUpgradeReceived: %s [type: %d]", objArr);
                return betaGrayStrategy2;
            }
        }
        i = 0;
        m2868a(betaGrayStrategy2);
        Object[] objArr2 = new Object[2];
        objArr2[i] = c1177b3;
        objArr2[1] = Integer.valueOf(c1177b3.f1343u);
        C1199X.m3078c("onUpgradeReceived: %s [type: %d]", objArr2);
        return betaGrayStrategy2;
    }

    /* renamed from: a */
    public synchronized void m2869a(int i, C1177B c1177b, boolean z) {
        C1248x m3190a;
        File file;
        this.f1613c = null;
        BetaGrayStrategy m2867a = m2867a(c1177b);
        this.f1612b = m2867a;
        if (i == 0 && m2867a != null) {
            C1177B c1177b2 = m2867a.f858a;
            if (c1177b2 == null || c1177b2.f1333k == null || (file = C1093e.f737b.f746I) == null || !file.exists() || !C1089a.m3617a(file, this.f1612b.f858a.f1333k.f1662b, "SHA")) {
                if (c1177b != null) {
                    if (C1093e.f737b.f762Y != null && (m3190a = this.f1612b.f858a.m3190a()) != null) {
                        this.f1614d.post(new RunnableC1236q(this, m3190a));
                    }
                    if ((C1093e.f737b.f764aa || z) && C1093e.f737b.f765ba) {
                        m2870a();
                    }
                }
                return;
            }
            C1199X.m3078c("patch has downloaded!", new Object[0]);
            C1093e c1093e = C1093e.f737b;
            if (!c1093e.f753P && c1093e.f754Q <= 3) {
                C1199X.m3078c("patch has downloaded but not patched execute patch!", new Object[0]);
                C1093e c1093e2 = C1093e.f737b;
                int i2 = c1093e2.f754Q + 1;
                c1093e2.f754Q = i2;
                C1089a.m3610b("PATCH_MAX_TIMES", String.valueOf(i2));
                C1089a.m3618a(file, C1093e.f737b.f747J);
                TinkerManager.getInstance().onDownloadSuccess(C1093e.f737b.f747J.getAbsolutePath(), C1093e.f737b.f761X);
            }
        }
    }

    /* renamed from: a */
    public void m2866a(boolean z, boolean z2, int i) {
        String str;
        long j;
        synchronized (this.f1619i) {
            BetaGrayStrategy betaGrayStrategy = (i != 3 || z) ? null : (BetaGrayStrategy) C1089a.m3615a("hotfix.strategy.bch", BetaGrayStrategy.CREATOR);
            if (this.f1616f != null && !this.f1616f.f868d && this.f1618h == z) {
                synchronized (this.f1616f) {
                    this.f1616f.f867c[0] = Boolean.valueOf(z);
                    this.f1616f.f867c[1] = Boolean.valueOf(z2);
                }
                this.f1617g.f735b[0] = false;
            }
            this.f1618h = z;
            if (this.f1616f != null) {
                this.f1616f.f868d = true;
            }
            this.f1616f = new C1116a(1, 804, Boolean.valueOf(z), Boolean.valueOf(z2), betaGrayStrategy);
            this.f1617g = new RunnableC1092d(12, false, this.f1616f);
            if (betaGrayStrategy == null || betaGrayStrategy.f858a == null) {
                str = "";
                j = 0;
            } else {
                str = betaGrayStrategy.f858a.f1340r;
                j = betaGrayStrategy.f858a.f1342t;
            }
            String str2 = str;
            HashMap hashMap = new HashMap();
            hashMap.put("G16", C1093e.f737b.f751N);
            C1117b.f869a.m3579a(804, i, C1189M.m3134a((AbstractC1228m) new C1178C(z ? 1 : 0, str2, j, hashMap)), this.f1616f, z, C1093e.f737b.f745H.f863a.f1630h);
        }
    }
}
