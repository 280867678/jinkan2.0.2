package com.tencent.smtt.sdk;

import android.content.Context;
import android.util.Log;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.utils.C1472q;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import java.nio.channels.FileLock;

/* renamed from: com.tencent.smtt.sdk.x */
/* loaded from: classes4.dex */
public class C1416x {

    /* renamed from: a */
    public static C1416x f2337a;

    /* renamed from: e */
    public static FileLock f2338e;

    /* renamed from: b */
    public C1417y f2339b;

    /* renamed from: c */
    public boolean f2340c;

    /* renamed from: d */
    public boolean f2341d;

    /* renamed from: a */
    public static C1416x m2294a() {
        if (f2337a == null) {
            synchronized (C1416x.class) {
                if (f2337a == null) {
                    f2337a = new C1416x();
                }
            }
        }
        return f2337a;
    }

    /* renamed from: a */
    public C1417y m2292a(boolean z) {
        return z ? this.f2339b : m2289c();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00be A[Catch: all -> 0x0284, TRY_LEAVE, TryCatch #3 {, blocks: (B:3:0x0001, B:6:0x002c, B:8:0x0030, B:15:0x006f, B:17:0x0073, B:18:0x008c, B:20:0x00be, B:33:0x0137, B:35:0x0143, B:36:0x0218, B:38:0x023b, B:39:0x0280, B:44:0x0183, B:45:0x01c2, B:47:0x01c8, B:48:0x0207, B:49:0x0241, B:51:0x025d, B:52:0x0260, B:54:0x0266, B:57:0x0051, B:55:0x006c, B:59:0x0082, B:24:0x00cf, B:26:0x00d5, B:27:0x00e1, B:29:0x00e5, B:30:0x0114, B:32:0x0118, B:10:0x0042, B:12:0x004a), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0241 A[Catch: all -> 0x0284, TryCatch #3 {, blocks: (B:3:0x0001, B:6:0x002c, B:8:0x0030, B:15:0x006f, B:17:0x0073, B:18:0x008c, B:20:0x00be, B:33:0x0137, B:35:0x0143, B:36:0x0218, B:38:0x023b, B:39:0x0280, B:44:0x0183, B:45:0x01c2, B:47:0x01c8, B:48:0x0207, B:49:0x0241, B:51:0x025d, B:52:0x0260, B:54:0x0266, B:57:0x0051, B:55:0x006c, B:59:0x0082, B:24:0x00cf, B:26:0x00d5, B:27:0x00e1, B:29:0x00e5, B:30:0x0114, B:32:0x0118, B:10:0x0042, B:12:0x004a), top: B:2:0x0001 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void m2293a(Context context) {
        Throwable th;
        int i;
        Throwable th2;
        TbsLog.m2154i("X5CoreEngine", "init", "#1# Start init");
        C1363g m2597a = C1363g.m2597a(true);
        m2597a.m2599a(context, false, false);
        TbsLog.m2154i("X5CoreEngine", "init", "#2# SDKEngine init finish");
        StringBuilder sb = new StringBuilder();
        C1414v m2601a = m2597a.m2601a();
        Object obj = null;
        if (!m2597a.m2596b() || m2601a == null) {
            this.f2340c = false;
            TbsLog.m2157e("X5CoreEngine", "init", "SDKEngine tbs not available!");
        } else if (!this.f2341d) {
            TbsLog.m2154i("X5CoreEngine", "init", "#3-1# X5CoreWizard start to load dex and so");
            C1417y c1417y = new C1417y(m2601a.m2302b());
            this.f2339b = c1417y;
            try {
                boolean m2287a = c1417y.m2287a();
                this.f2340c = m2287a;
                if (!m2287a) {
                    sb.append("can not use X5 by x5corewizard return false");
                }
            } catch (NoSuchMethodException unused) {
                this.f2340c = true;
            } catch (Throwable th3) {
                th = th3;
                this.f2340c = false;
                sb.append("can not use x5 by x5corewizard throwable " + Log.getStackTraceString(th));
            }
            th = null;
            if (this.f2340c) {
                CookieManager.getInstance().m2853a(context, true, true);
                CookieManager.getInstance().m2854a();
            }
            TbsLog.m2155i("X5CoreEngine", "init  mCanUseX5 is " + this.f2340c);
            C1472q.m1985a("19is" + this.f2340c);
            if (this.f2340c) {
                TbsLog.m2158e("X5CoreEngine", "mCanUseX5 is false --> report");
                if (m2597a.m2596b() && m2601a != null && th == null) {
                    DexLoader m2302b = m2601a.m2302b();
                    if (m2302b != null) {
                        obj = m2302b.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "getLoadFailureDetails", new Class[0], new Object[0]);
                    }
                    if (obj instanceof Throwable) {
                        sb.append("#" + th2.getMessage() + "; cause: " + th2.getCause() + "; th: " + ((Throwable) obj));
                    }
                    if (obj instanceof String) {
                        sb.append("failure detail: " + obj);
                    }
                    if (sb.toString().contains("isPreloadX5Disabled:-10000")) {
                        TbsCoreLoadStat.getInstance().m2814a(context, 408, new Throwable("Core Crash, details: " + sb.toString()));
                        TbsLog.m2157e("X5CoreEngine", "init", "[LoadError] Core Crash, details: " + sb.toString());
                        i = 1;
                    } else {
                        TbsCoreLoadStat.getInstance().m2814a(context, 407, new Throwable("Failed in Core, details: " + sb.toString()));
                        TbsLog.m2157e("X5CoreEngine", "init", "[LoadError] Failed in Core, details: " + sb.toString());
                        i = 2;
                    }
                } else if (m2597a.m2596b()) {
                    TbsCoreLoadStat.getInstance().m2814a(context, 409, new Throwable("mCanUseX5=false, available true, reason: " + sb.toString()));
                    TbsLog.m2157e("X5CoreEngine", "init", "[LoadError] details: " + sb.toString());
                    i = 3;
                } else {
                    TbsCoreLoadStat.getInstance().m2815a(context, 410);
                    TbsLog.m2157e("X5CoreEngine", "init", "[LoadError] mCanUseX5=false, available=false");
                    i = 4;
                }
                String str = "step=is=" + i + "failreason=is=" + sb.toString();
                if (TbsShareManager.isThirdPartyApp(context)) {
                    C1472q.m1986a(context, "x5coreengine_fail", str);
                }
            } else {
                TbsLog.m2154i("X5CoreEngine", "init", "#5# sTbsCoreLoadFileLock is " + f2338e);
                if (f2338e == null) {
                    m2290b(context);
                }
                if (TbsShareManager.isThirdPartyApp(context)) {
                    C1472q.m1986a(context, "x5coreengine_ok", "" + QbSdk.getTbsVersion(context));
                }
            }
            this.f2341d = true;
        }
        th = null;
        TbsLog.m2155i("X5CoreEngine", "init  mCanUseX5 is " + this.f2340c);
        C1472q.m1985a("19is" + this.f2340c);
        if (this.f2340c) {
        }
        this.f2341d = true;
    }

    /* renamed from: b */
    public FileLock m2290b(Context context) {
        String str;
        String str2;
        TbsLog.m2155i("X5CoreEngine", "tryTbsCoreLoadFileLock ##");
        FileLock fileLock = f2338e;
        if (fileLock != null) {
            return fileLock;
        }
        synchronized (C1416x.class) {
            if (f2338e == null) {
                FileLock m2167e = FileUtil.m2167e(context);
                f2338e = m2167e;
                if (m2167e == null) {
                    str = "X5CoreEngine";
                    str2 = "init -- sTbsCoreLoadFileLock failed!";
                } else {
                    str = "X5CoreEngine";
                    str2 = "init -- sTbsCoreLoadFileLock succeeded: " + f2338e;
                }
                TbsLog.m2155i(str, str2);
            }
        }
        return f2338e;
    }

    /* renamed from: b */
    public boolean m2291b() {
        if (QbSdk.f1740a) {
            return false;
        }
        return this.f2340c;
    }

    /* renamed from: c */
    public C1417y m2289c() {
        if (QbSdk.f1740a) {
            return null;
        }
        return this.f2339b;
    }

    /* renamed from: d */
    public boolean m2288d() {
        return this.f2341d;
    }
}
