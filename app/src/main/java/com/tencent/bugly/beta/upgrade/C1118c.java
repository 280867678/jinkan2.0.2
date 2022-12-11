package com.tencent.bugly.beta.upgrade;

import android.text.TextUtils;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.beta.download.BetaReceiver;
import com.tencent.bugly.beta.download.C1085a;
import com.tencent.bugly.beta.download.DownloadListener;
import com.tencent.bugly.beta.download.DownloadTask;
import com.tencent.bugly.beta.global.C1089a;
import com.tencent.bugly.beta.global.C1093e;
import com.tencent.bugly.beta.global.C1094f;
import com.tencent.bugly.beta.global.RunnableC1092d;
import com.tencent.bugly.beta.p041ui.C1115l;
import com.tencent.bugly.beta.utils.C1125e;
import com.tencent.bugly.proguard.AbstractC1228m;
import com.tencent.bugly.proguard.C1177B;
import com.tencent.bugly.proguard.C1178C;
import com.tencent.bugly.proguard.C1189M;
import com.tencent.bugly.proguard.C1199X;
import com.tencent.bugly.proguard.C1208ca;
import com.tencent.bugly.proguard.C1234p;
import com.tencent.bugly.proguard.C1239ra;
import com.tencent.bugly.proguard.C1241sa;
import com.tencent.bugly.proguard.C1250z;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.bugly.beta.upgrade.c */
/* loaded from: classes3.dex */
public class C1118c {

    /* renamed from: a */
    public static C1118c f870a = new C1118c();

    /* renamed from: b */
    public BetaGrayStrategy f871b;

    /* renamed from: c */
    public DownloadTask f872c;

    /* renamed from: d */
    public DownloadListener f873d;

    /* renamed from: e */
    public UpgradeListener f874e;

    /* renamed from: f */
    public UpgradeStateListener f875f;

    /* renamed from: g */
    public boolean f876g;

    /* renamed from: h */
    public boolean f877h;

    /* renamed from: i */
    public RunnableC1092d f878i;

    /* renamed from: j */
    public RunnableC1092d f879j;

    /* renamed from: k */
    public int f880k;

    /* renamed from: l */
    public final Object f881l = new Object();

    /* renamed from: m */
    public final Object f882m = new Object();

    /* renamed from: n */
    public DownloadListener f883n = new C1085a(3, this, 0);

    /* renamed from: o */
    public C1116a f884o = null;

    /* renamed from: p */
    public RunnableC1092d f885p;

    /* renamed from: q */
    public boolean f886q;

    /* renamed from: r */
    public int f887r;

    /* renamed from: a */
    private void m3576a() {
        C1177B m3569b = m3569b();
        if (m3569b == null) {
            return;
        }
        if (this.f872c == null) {
            this.f872c = m3568c();
        }
        if (this.f872c == null) {
            return;
        }
        m3575a(this.f871b);
        BetaReceiver.addTask(this.f872c);
        if (this.f872c.getStatus() != 1 || this.f877h) {
            this.f872c.download();
        } else if (!this.f876g || !C1089a.m3623a(C1093e.f737b.f789v, this.f872c.getSaveFile(), m3569b.f1333k.f1662b)) {
            m3572a(this.f876g);
        } else {
            C1234p.f1572a.m2877a(new C1250z("install", System.currentTimeMillis(), (byte) 0, 0L, m3569b.f1332j, m3569b.f1340r, m3569b.f1343u, null));
        }
    }

    /* renamed from: a */
    private void m3575a(BetaGrayStrategy betaGrayStrategy) {
        C1177B c1177b = betaGrayStrategy.f858a;
        if (c1177b == null || c1177b.f1343u != 1) {
            return;
        }
        C1089a.m3614a("app.upgrade.strategy.bch", betaGrayStrategy);
    }

    /* renamed from: a */
    private void m3572a(boolean z) {
        C1177B m3569b = m3569b();
        if (m3569b == null) {
            return;
        }
        boolean z2 = false;
        if (System.currentTimeMillis() <= m3569b.m3189b() - 86400000) {
            C1199X.m3081b(System.currentTimeMillis() + "ms", new Object[0]);
            return;
        }
        C1094f.f794a.m3606a(C1093e.f737b.f786s, m3569b.f1339q);
        if (this.f872c == null) {
            this.f872c = m3568c();
        }
        DownloadTask downloadTask = this.f872c;
        if (downloadTask == null) {
            return;
        }
        if (!z && downloadTask.getStatus() == 2) {
            C1199X.m3078c("Task is downloading %s %s", m3569b.f1340r, this.f872c.getDownloadUrl());
            return;
        }
        this.f872c.addListener(this.f883n);
        DownloadListener downloadListener = this.f873d;
        if (downloadListener != null) {
            this.f872c.addListener(downloadListener);
        }
        C1115l c1115l = C1115l.f842n;
        c1115l.m3581a(m3569b, this.f872c);
        c1115l.f851t = new RunnableC1092d(3, this.f871b, this.f872c);
        c1115l.f852u = new RunnableC1092d(4, this.f871b, this.f872c, Boolean.valueOf(z));
        this.f871b.f860c = System.currentTimeMillis();
        m3575a(this.f871b);
        if (z) {
            C1094f.f794a.m3604a(new RunnableC1092d(2, c1115l, Boolean.valueOf(z)), 3000);
            return;
        }
        C1094f c1094f = C1094f.f794a;
        Object[] objArr = new Object[2];
        objArr[0] = c1115l;
        if (z || m3569b.f1334l == 2) {
            z2 = true;
        }
        objArr[1] = Boolean.valueOf(z2);
        c1094f.m3605a(new RunnableC1092d(2, objArr));
    }

    /* renamed from: b */
    private C1177B m3569b() {
        BetaGrayStrategy betaGrayStrategy = this.f871b;
        if (betaGrayStrategy == null) {
            return null;
        }
        return betaGrayStrategy.f858a;
    }

    /* renamed from: c */
    private DownloadTask m3568c() {
        C1177B m3569b = m3569b();
        if (m3569b == null) {
            return null;
        }
        if (this.f872c == null) {
            C1093e c1093e = C1093e.f737b;
            DownloadTask mo2863a = c1093e.f786s.mo2863a(m3569b.f1333k.f1663c, c1093e.f790w.getAbsolutePath(), null, this.f871b.f858a.f1333k.f1662b);
            this.f872c = mo2863a;
            mo2863a.setDownloadType(1);
        }
        return this.f872c;
    }

    /* renamed from: a */
    public BetaGrayStrategy m3574a(C1177B c1177b) {
        BetaGrayStrategy betaGrayStrategy;
        BetaGrayStrategy betaGrayStrategy2;
        File[] listFiles;
        C1177B c1177b2 = c1177b;
        synchronized (this.f881l) {
            BetaGrayStrategy betaGrayStrategy3 = (BetaGrayStrategy) C1089a.m3615a("app.upgrade.strategy.bch", BetaGrayStrategy.CREATOR);
            betaGrayStrategy = null;
            if (betaGrayStrategy3 != null && betaGrayStrategy3.f858a == null) {
                C1089a.m3616a("app.upgrade.strategy.bch");
                betaGrayStrategy3 = null;
            }
            if (betaGrayStrategy3 != null && betaGrayStrategy3.f858a != null && (betaGrayStrategy3.f858a.f1332j.f1670d < C1093e.f737b.f793z || ((betaGrayStrategy3.f858a.f1332j.f1670d == C1093e.f737b.f793z && betaGrayStrategy3.f858a.f1332j.f1672f <= C1093e.f737b.f785r) || betaGrayStrategy3.f858a.f1341s != 1 || (betaGrayStrategy3.f858a.f1333k != null && TextUtils.equals(C1093e.f737b.f792y, betaGrayStrategy3.f858a.f1333k.f1662b))))) {
                C1089a.m3616a("app.upgrade.strategy.bch");
                this.f872c = null;
                betaGrayStrategy3 = null;
            }
            if (c1177b2 != null && (c1177b2.f1332j.f1670d < C1093e.f737b.f793z || (c1177b2.f1332j.f1670d == C1093e.f737b.f793z && c1177b2.f1332j.f1672f <= C1093e.f737b.f785r))) {
                C1199X.m3078c("versionCode is too small, discard remote strategy: [new: %d buildno: %d] [current: %d buildno: %d]", Integer.valueOf(c1177b2.f1332j.f1670d), Integer.valueOf(c1177b2.f1332j.f1672f), Integer.valueOf(C1093e.f737b.f793z), Integer.valueOf(C1093e.f737b.f785r));
                c1177b2 = null;
            }
            if (c1177b2 != null) {
                if (c1177b2.f1341s == 2 && betaGrayStrategy3 != null && betaGrayStrategy3.f858a != null && !TextUtils.isEmpty(c1177b2.f1340r) && !TextUtils.isEmpty(betaGrayStrategy3.f858a.f1340r) && TextUtils.equals(c1177b2.f1340r, betaGrayStrategy3.f858a.f1340r)) {
                    C1199X.m3078c("撤回 strategy: %s", c1177b2.f1340r);
                    betaGrayStrategy3 = null;
                }
                if (c1177b2.f1341s != 1) {
                    C1199X.m3078c("invalid strategy: %s", c1177b2.f1340r);
                    c1177b2 = null;
                }
            }
            if (c1177b2 != null) {
                if (betaGrayStrategy3 == null || betaGrayStrategy3.f858a == null || TextUtils.isEmpty(c1177b2.f1340r) || TextUtils.isEmpty(betaGrayStrategy3.f858a.f1340r) || !TextUtils.equals(c1177b2.f1340r, betaGrayStrategy3.f858a.f1340r)) {
                    betaGrayStrategy2 = new BetaGrayStrategy();
                } else {
                    betaGrayStrategy2 = new BetaGrayStrategy(C1208ca.m3003d(C1208ca.m3036a(betaGrayStrategy3)));
                    C1199X.m3078c("same strategyId:[new: %s] [current: %s] keep has popup times: %d, interval: %d", c1177b2.f1340r, betaGrayStrategy3.f858a.f1340r, Integer.valueOf(betaGrayStrategy2.f859b), Long.valueOf(c1177b2.f1336n));
                }
                betaGrayStrategy2.f858a = c1177b2;
                betaGrayStrategy2.f862e = System.currentTimeMillis();
                if (betaGrayStrategy3 != null && !betaGrayStrategy3.f858a.f1333k.f1663c.equals(c1177b2.f1333k.f1663c)) {
                    if (this.f872c == null) {
                        DownloadTask mo2863a = C1093e.f737b.f786s.mo2863a(betaGrayStrategy3.f858a.f1333k.f1663c, C1093e.f737b.f790w.getAbsolutePath(), null, null);
                        this.f872c = mo2863a;
                        mo2863a.setDownloadType(1);
                        this.f872c.delete(true);
                        for (File file : C1093e.f737b.f790w.listFiles()) {
                            if (!file.delete()) {
                                C1199X.m3081b("cannot deleteCache file:%s", file.getAbsolutePath());
                            }
                        }
                    } else {
                        BetaReceiver.netListeners.remove(this.f872c.getDownloadUrl());
                        this.f872c.delete(true);
                    }
                    this.f872c = null;
                }
                m3575a(betaGrayStrategy2);
                C1199X.m3078c("onUpgradeReceived: %s [type: %d]", c1177b2, Integer.valueOf(c1177b2.f1334l));
                C1234p.f1572a.m2877a(new C1250z("rcv", System.currentTimeMillis(), (byte) 0, 0L, c1177b2.f1332j, c1177b2.f1340r, c1177b2.f1343u, null));
                betaGrayStrategy = betaGrayStrategy2;
            }
        }
        return betaGrayStrategy;
    }

    /* renamed from: a */
    public void m3573a(C1241sa c1241sa) {
        C1093e c1093e = C1093e.f737b;
        if (c1093e.f745H == null) {
            c1093e.f745H = new BetaUploadStrategy();
        }
        if (c1241sa != null) {
            BetaUploadStrategy betaUploadStrategy = C1093e.f737b.f745H;
            long j = betaUploadStrategy.f864b;
            long j2 = c1241sa.f1633k;
            if (j == j2) {
                return;
            }
            betaUploadStrategy.f864b = j2;
            C1241sa c1241sa2 = betaUploadStrategy.f863a;
            c1241sa2.f1627e = c1241sa.f1627e;
            c1241sa2.f1628f = c1241sa.f1628f;
            c1241sa2.f1633k = j2;
            if (C1208ca.m3006c(c1241sa.f1629g)) {
                C1093e.f737b.f745H.f863a.f1629g = c1241sa.f1629g;
            }
            if (C1208ca.m3006c(c1241sa.f1630h)) {
                C1093e.f737b.f745H.f863a.f1630h = c1241sa.f1630h;
            }
            C1239ra c1239ra = c1241sa.f1631i;
            if (c1239ra != null && !TextUtils.isEmpty(c1239ra.f1620a)) {
                C1093e.f737b.f745H.f863a.f1631i.f1620a = c1241sa.f1631i.f1620a;
            }
            Map<String, String> map = c1241sa.f1632j;
            if (map != null && map.size() > 0) {
                C1093e.f737b.f745H.f863a.f1632j = c1241sa.f1632j;
            }
            if (C1208ca.m3006c(c1241sa.f1634l)) {
                C1093e.f737b.f745H.f863a.f1634l = c1241sa.f1634l;
            }
            if (C1208ca.m3006c(c1241sa.f1635m)) {
                C1093e.f737b.f745H.f863a.f1635m = c1241sa.f1635m;
            }
            C1089a.m3614a("us.bch", C1093e.f737b.f745H);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:72:0x0076, code lost:
        if (r5 == null) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x007a, code lost:
        if (r5.f858a == null) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0080, code lost:
        if (r5.f858a.f1343u != 3) goto L78;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x008b A[Catch: all -> 0x0189, TryCatch #2 {, blocks: (B:5:0x001e, B:9:0x002f, B:11:0x0086, B:13:0x008b, B:15:0x0091, B:17:0x0095, B:20:0x009a, B:21:0x009c, B:24:0x00b2, B:27:0x017b, B:28:0x0187, B:33:0x0171, B:35:0x0175, B:37:0x00bd, B:39:0x00c5, B:40:0x00c9, B:59:0x003c, B:61:0x0046, B:63:0x0050, B:66:0x0056, B:68:0x005a, B:73:0x0078, B:75:0x007c, B:81:0x0065, B:85:0x006c, B:43:0x00f7, B:45:0x00fb, B:47:0x010c, B:49:0x0113, B:51:0x011a, B:53:0x0129, B:55:0x0140, B:22:0x009d, B:23:0x00b1), top: B:4:0x001e }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x009d A[Catch: all -> 0x00ba, TRY_ENTER, TryCatch #2 {, blocks: (B:5:0x001e, B:9:0x002f, B:11:0x0086, B:13:0x008b, B:15:0x0091, B:17:0x0095, B:20:0x009a, B:21:0x009c, B:24:0x00b2, B:27:0x017b, B:28:0x0187, B:33:0x0171, B:35:0x0175, B:37:0x00bd, B:39:0x00c5, B:40:0x00c9, B:59:0x003c, B:61:0x0046, B:63:0x0050, B:66:0x0056, B:68:0x005a, B:73:0x0078, B:75:0x007c, B:81:0x0065, B:85:0x006c, B:43:0x00f7, B:45:0x00fb, B:47:0x010c, B:49:0x0113, B:51:0x011a, B:53:0x0129, B:55:0x0140, B:22:0x009d, B:23:0x00b1), top: B:4:0x001e }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x016d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c5 A[Catch: all -> 0x0189, TryCatch #2 {, blocks: (B:5:0x001e, B:9:0x002f, B:11:0x0086, B:13:0x008b, B:15:0x0091, B:17:0x0095, B:20:0x009a, B:21:0x009c, B:24:0x00b2, B:27:0x017b, B:28:0x0187, B:33:0x0171, B:35:0x0175, B:37:0x00bd, B:39:0x00c5, B:40:0x00c9, B:59:0x003c, B:61:0x0046, B:63:0x0050, B:66:0x0056, B:68:0x005a, B:73:0x0078, B:75:0x007c, B:81:0x0065, B:85:0x006c, B:43:0x00f7, B:45:0x00fb, B:47:0x010c, B:49:0x0113, B:51:0x011a, B:53:0x0129, B:55:0x0140, B:22:0x009d, B:23:0x00b1), top: B:4:0x001e }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f7 A[Catch: all -> 0x0161, TRY_ENTER, TryCatch #2 {, blocks: (B:5:0x001e, B:9:0x002f, B:11:0x0086, B:13:0x008b, B:15:0x0091, B:17:0x0095, B:20:0x009a, B:21:0x009c, B:24:0x00b2, B:27:0x017b, B:28:0x0187, B:33:0x0171, B:35:0x0175, B:37:0x00bd, B:39:0x00c5, B:40:0x00c9, B:59:0x003c, B:61:0x0046, B:63:0x0050, B:66:0x0056, B:68:0x005a, B:73:0x0078, B:75:0x007c, B:81:0x0065, B:85:0x006c, B:43:0x00f7, B:45:0x00fb, B:47:0x010c, B:49:0x0113, B:51:0x011a, B:53:0x0129, B:55:0x0140, B:22:0x009d, B:23:0x00b1), top: B:4:0x001e }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m3571a(boolean z, boolean z2, int i) {
        BetaGrayStrategy betaGrayStrategy;
        String str;
        long j;
        int i2;
        C1199X.m3084a("requestGrayTactics strategyType:[%s]", Integer.valueOf(i));
        synchronized (this.f882m) {
            C1199X.m3084a("requestGrayTactics1 strategyType:[%s]", Integer.valueOf(i));
            BetaGrayStrategy betaGrayStrategy2 = null;
            if (i == 1) {
                betaGrayStrategy2 = (BetaGrayStrategy) C1089a.m3615a("app.upgrade.strategy.bch", BetaGrayStrategy.CREATOR);
            } else if (i == 0) {
                BetaGrayStrategy betaGrayStrategy3 = (BetaGrayStrategy) C1089a.m3615a("hotfix.strategy.bch", BetaGrayStrategy.CREATOR);
                BetaGrayStrategy betaGrayStrategy4 = (BetaGrayStrategy) C1089a.m3615a("app.upgrade.strategy.bch", BetaGrayStrategy.CREATOR);
                if (betaGrayStrategy3 == null || betaGrayStrategy3.f858a == null || betaGrayStrategy4 == null || betaGrayStrategy4.f858a == null) {
                    if (betaGrayStrategy3 != null && betaGrayStrategy3.f858a != null) {
                        if (betaGrayStrategy4 != null && betaGrayStrategy4.f858a != null) {
                            betaGrayStrategy3 = null;
                        }
                        betaGrayStrategy = betaGrayStrategy3;
                        if (this.f884o != null && !this.f884o.f868d && this.f886q == z && this.f887r == i) {
                            synchronized (this.f884o) {
                                this.f884o.f867c[0] = Boolean.valueOf(z);
                                this.f884o.f867c[1] = Boolean.valueOf(z2);
                            }
                            this.f885p.f735b[0] = false;
                            if ((z && !z2) || (betaGrayStrategy != null && betaGrayStrategy.f858a != null && betaGrayStrategy.f858a.f1343u == 2)) {
                                C1125e.m3488b(this.f885p);
                                C1125e.m3489a(this.f885p, 6000L);
                            }
                        }
                        this.f886q = z;
                        this.f887r = i;
                        if (this.f884o != null) {
                            this.f884o.f868d = true;
                        }
                        this.f884o = new C1116a(1, 804, Boolean.valueOf(z), Boolean.valueOf(z2), betaGrayStrategy);
                        this.f885p = new RunnableC1092d(12, false, this.f884o);
                        if (betaGrayStrategy != null || betaGrayStrategy.f858a == null) {
                            str = "";
                            j = 0;
                            i2 = 0;
                        } else {
                            String str2 = betaGrayStrategy.f858a.f1340r;
                            long j2 = betaGrayStrategy.f858a.f1342t;
                            i2 = betaGrayStrategy.f859b;
                            j = j2;
                            str = str2;
                        }
                        HashMap hashMap = new HashMap();
                        StringBuilder sb = new StringBuilder();
                        sb.append("");
                        sb.append(i2);
                        hashMap.put("hasPopTimes", sb.toString());
                        hashMap.put("G16", C1093e.f737b.f751N);
                        byte[] m3134a = C1189M.m3134a((AbstractC1228m) new C1178C(z ? 1 : 0, str, j, hashMap));
                        C1199X.m3084a("requestGrayTactics2 strategyType:[%s]", Integer.valueOf(i));
                        C1117b.f869a.m3579a(804, i, m3134a, this.f884o, z, C1093e.f737b.f745H.f863a.f1630h);
                        if (z) {
                            C1125e.m3488b(this.f885p);
                            C1125e.m3489a(this.f885p, 6000L);
                        }
                        C1125e.m3488b(this.f885p);
                        C1125e.m3489a(this.f885p, 6000L);
                    }
                    betaGrayStrategy3 = betaGrayStrategy4;
                    betaGrayStrategy = betaGrayStrategy3;
                    if (this.f884o != null) {
                        synchronized (this.f884o) {
                        }
                    }
                    this.f886q = z;
                    this.f887r = i;
                    if (this.f884o != null) {
                    }
                    this.f884o = new C1116a(1, 804, Boolean.valueOf(z), Boolean.valueOf(z2), betaGrayStrategy);
                    this.f885p = new RunnableC1092d(12, false, this.f884o);
                    if (betaGrayStrategy != null) {
                    }
                    str = "";
                    j = 0;
                    i2 = 0;
                    HashMap hashMap2 = new HashMap();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("");
                    sb2.append(i2);
                    hashMap2.put("hasPopTimes", sb2.toString());
                    hashMap2.put("G16", C1093e.f737b.f751N);
                    byte[] m3134a2 = C1189M.m3134a((AbstractC1228m) new C1178C(z ? 1 : 0, str, j, hashMap2));
                    C1199X.m3084a("requestGrayTactics2 strategyType:[%s]", Integer.valueOf(i));
                    C1117b.f869a.m3579a(804, i, m3134a2, this.f884o, z, C1093e.f737b.f745H.f863a.f1630h);
                    if (z) {
                    }
                    C1125e.m3488b(this.f885p);
                    C1125e.m3489a(this.f885p, 6000L);
                } else {
                    if (betaGrayStrategy3.f862e > betaGrayStrategy4.f862e) {
                        betaGrayStrategy = betaGrayStrategy3;
                        if (this.f884o != null) {
                        }
                        this.f886q = z;
                        this.f887r = i;
                        if (this.f884o != null) {
                        }
                        this.f884o = new C1116a(1, 804, Boolean.valueOf(z), Boolean.valueOf(z2), betaGrayStrategy);
                        this.f885p = new RunnableC1092d(12, false, this.f884o);
                        if (betaGrayStrategy != null) {
                        }
                        str = "";
                        j = 0;
                        i2 = 0;
                        HashMap hashMap22 = new HashMap();
                        StringBuilder sb22 = new StringBuilder();
                        sb22.append("");
                        sb22.append(i2);
                        hashMap22.put("hasPopTimes", sb22.toString());
                        hashMap22.put("G16", C1093e.f737b.f751N);
                        byte[] m3134a22 = C1189M.m3134a((AbstractC1228m) new C1178C(z ? 1 : 0, str, j, hashMap22));
                        C1199X.m3084a("requestGrayTactics2 strategyType:[%s]", Integer.valueOf(i));
                        C1117b.f869a.m3579a(804, i, m3134a22, this.f884o, z, C1093e.f737b.f745H.f863a.f1630h);
                        if (z) {
                        }
                        C1125e.m3488b(this.f885p);
                        C1125e.m3489a(this.f885p, 6000L);
                    }
                    betaGrayStrategy3 = betaGrayStrategy4;
                    betaGrayStrategy = betaGrayStrategy3;
                    if (this.f884o != null) {
                    }
                    this.f886q = z;
                    this.f887r = i;
                    if (this.f884o != null) {
                    }
                    this.f884o = new C1116a(1, 804, Boolean.valueOf(z), Boolean.valueOf(z2), betaGrayStrategy);
                    this.f885p = new RunnableC1092d(12, false, this.f884o);
                    if (betaGrayStrategy != null) {
                    }
                    str = "";
                    j = 0;
                    i2 = 0;
                    HashMap hashMap222 = new HashMap();
                    StringBuilder sb222 = new StringBuilder();
                    sb222.append("");
                    sb222.append(i2);
                    hashMap222.put("hasPopTimes", sb222.toString());
                    hashMap222.put("G16", C1093e.f737b.f751N);
                    byte[] m3134a222 = C1189M.m3134a((AbstractC1228m) new C1178C(z ? 1 : 0, str, j, hashMap222));
                    C1199X.m3084a("requestGrayTactics2 strategyType:[%s]", Integer.valueOf(i));
                    C1117b.f869a.m3579a(804, i, m3134a222, this.f884o, z, C1093e.f737b.f745H.f863a.f1630h);
                    if (z) {
                    }
                    C1125e.m3488b(this.f885p);
                    C1125e.m3489a(this.f885p, 6000L);
                }
            }
            betaGrayStrategy = betaGrayStrategy2;
            if (this.f884o != null) {
            }
            this.f886q = z;
            this.f887r = i;
            if (this.f884o != null) {
            }
            this.f884o = new C1116a(1, 804, Boolean.valueOf(z), Boolean.valueOf(z2), betaGrayStrategy);
            this.f885p = new RunnableC1092d(12, false, this.f884o);
            if (betaGrayStrategy != null) {
            }
            str = "";
            j = 0;
            i2 = 0;
            HashMap hashMap2222 = new HashMap();
            StringBuilder sb2222 = new StringBuilder();
            sb2222.append("");
            sb2222.append(i2);
            hashMap2222.put("hasPopTimes", sb2222.toString());
            hashMap2222.put("G16", C1093e.f737b.f751N);
            byte[] m3134a2222 = C1189M.m3134a((AbstractC1228m) new C1178C(z ? 1 : 0, str, j, hashMap2222));
            C1199X.m3084a("requestGrayTactics2 strategyType:[%s]", Integer.valueOf(i));
            C1117b.f869a.m3579a(804, i, m3134a2222, this.f884o, z, C1093e.f737b.f745H.f863a.f1630h);
            if (z) {
            }
            C1125e.m3488b(this.f885p);
            C1125e.m3489a(this.f885p, 6000L);
        }
    }

    /* renamed from: a */
    public void m3570a(boolean z, boolean z2, int i, C1177B c1177b, String str) {
        synchronized (this.f881l) {
            this.f872c = null;
            this.f871b = m3574a(c1177b);
            this.f876g = z;
            this.f877h = z2;
            if (this.f874e != null) {
                C1199X.m3078c("你已放弃让SDK来处理策略", new Object[0]);
                this.f880k = 3;
                if (this.f871b == null) {
                    C1199X.m3078c("betaStrategy is null", new Object[0]);
                    C1125e.m3490a(new RunnableC1092d(5, Beta.strToastYourAreTheLatestVersion));
                    return;
                } else if (this.f871b.f858a != null && !z && (this.f871b.f860c + this.f871b.f858a.f1336n > System.currentTimeMillis() || this.f871b.f858a.f1335m - this.f871b.f859b <= 0)) {
                    return;
                } else {
                    if (this.f871b != null && this.f872c == null) {
                        DownloadTask mo2863a = C1093e.f737b.f786s.mo2863a(this.f871b.f858a.f1333k.f1663c, C1093e.f737b.f790w.getAbsolutePath(), null, this.f871b.f858a.f1333k.f1662b);
                        this.f872c = mo2863a;
                        mo2863a.setDownloadType(1);
                    }
                    if (this.f872c == null) {
                        C1199X.m3078c("用户自定义activity，创建task失败 [strategy:%s]", this.f871b);
                        this.f871b = null;
                        C1089a.m3616a("app.upgrade.strategy.bch");
                    } else {
                        this.f872c.addListener(this.f883n);
                    }
                    C1125e.m3490a(new RunnableC1092d(16, this.f874e, Integer.valueOf(i), this.f871b, Boolean.valueOf(z), Boolean.valueOf(z2)));
                }
            }
            if (i != 0 && z && !z2 && this.f871b == null) {
                if (this.f875f != null) {
                    C1125e.m3490a(new RunnableC1092d(18, this.f875f, -1, Boolean.valueOf(z)));
                } else {
                    C1125e.m3490a(new RunnableC1092d(5, Beta.strToastCheckUpgradeError));
                }
                return;
            }
            if (this.f871b != null && this.f871b.f858a != null) {
                if (this.f872c == null) {
                    this.f872c = m3568c();
                }
                this.f872c.addListener(this.f883n);
                if (this.f875f != null) {
                    C1125e.m3490a(new RunnableC1092d(18, this.f875f, 0, Boolean.valueOf(z)));
                }
                if (this.f874e != null) {
                    return;
                }
                if (!z && this.f871b.f858a.f1334l != 2) {
                    if (this.f871b.f861d && C1093e.f737b.f775h) {
                        if ((C1089a.m3626a(C1093e.f737b.f789v) == 1 && C1093e.f737b.f758U) || (C1089a.m3626a(C1093e.f737b.f789v) == 4 && C1093e.f737b.f759V)) {
                            m3576a();
                            return;
                        }
                        if (!z2) {
                            m3572a(z);
                        }
                        return;
                    } else if (this.f871b.f860c + this.f871b.f858a.f1336n > System.currentTimeMillis() || this.f871b.f858a.f1335m - this.f871b.f859b <= 0 || this.f871b.f858a.f1334l == 3) {
                        return;
                    }
                }
                if (((C1089a.m3626a(C1093e.f737b.f789v) == 1 && C1093e.f737b.f758U) || (C1089a.m3626a(C1093e.f737b.f789v) == 4 && C1093e.f737b.f759V)) && !z) {
                    m3576a();
                } else if (!z2) {
                    m3572a(z);
                }
            } else if (this.f875f != null) {
                C1125e.m3490a(new RunnableC1092d(18, this.f875f, 1, Boolean.valueOf(z)));
            } else if (z && !z2) {
                C1125e.m3490a(new RunnableC1092d(5, Beta.strToastYourAreTheLatestVersion));
            }
        }
    }
}
