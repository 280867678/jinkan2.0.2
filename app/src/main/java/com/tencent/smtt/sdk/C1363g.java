package com.tencent.smtt.sdk;

import android.content.Context;
import com.stub.StubApp;
import com.tencent.smtt.utils.TbsLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/* renamed from: com.tencent.smtt.sdk.g */
/* loaded from: classes4.dex */
public class C1363g {

    /* renamed from: a */
    public static int f2113a = 0;

    /* renamed from: b */
    public static boolean f2114b = false;

    /* renamed from: e */
    public static C1363g f2115e = null;

    /* renamed from: h */
    public static int f2116h = 0;

    /* renamed from: i */
    public static int f2117i = 3;

    /* renamed from: k */
    public static String f2118k;

    /* renamed from: c */
    public C1414v f2119c = null;

    /* renamed from: d */
    public C1414v f2120d = null;

    /* renamed from: f */
    public boolean f2121f = false;

    /* renamed from: g */
    public boolean f2122g = false;

    /* renamed from: j */
    public File f2123j = null;

    /* renamed from: a */
    public static C1363g m2597a(boolean z) {
        if (f2115e == null && z) {
            synchronized (C1363g.class) {
                if (f2115e == null) {
                    f2115e = new C1363g();
                }
            }
        }
        return f2115e;
    }

    /* renamed from: a */
    public static void m2600a(int i) {
        f2116h = i;
    }

    /* renamed from: b */
    private void m2595b(int i) {
        String valueOf = String.valueOf(i);
        Properties properties = new Properties();
        properties.setProperty(f2118k, valueOf);
        try {
            properties.store(new FileOutputStream(new File(this.f2123j, "count.prop")), (String) null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: d */
    public static int m2592d() {
        return f2116h;
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0054: MOVE  (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:28:0x0054 */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0057 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int m2587i() {
        BufferedInputStream bufferedInputStream;
        Exception e;
        BufferedInputStream bufferedInputStream2;
        BufferedInputStream bufferedInputStream3 = null;
        try {
            try {
                File file = new File(this.f2123j, "count.prop");
                if (!file.exists()) {
                    return 0;
                }
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                try {
                    Properties properties = new Properties();
                    properties.load(bufferedInputStream);
                    int intValue = Integer.valueOf(properties.getProperty(f2118k, "1")).intValue();
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    return intValue;
                } catch (Exception e3) {
                    e = e3;
                    e.printStackTrace();
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    return 0;
                }
            } catch (Throwable th) {
                th = th;
                bufferedInputStream3 = bufferedInputStream2;
                if (bufferedInputStream3 != null) {
                    try {
                        bufferedInputStream3.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e6) {
            bufferedInputStream = null;
            e = e6;
        } catch (Throwable th2) {
            th = th2;
            if (bufferedInputStream3 != null) {
            }
            throw th;
        }
    }

    /* renamed from: a */
    public C1414v m2601a() {
        if (this.f2121f) {
            return this.f2119c;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x010f A[Catch: all -> 0x0182, TryCatch #1 {, blocks: (B:3:0x0001, B:6:0x0038, B:11:0x0068, B:13:0x009d, B:18:0x00a3, B:41:0x0203, B:64:0x01b9, B:66:0x01ec, B:69:0x01f1, B:19:0x00aa, B:21:0x00b0, B:23:0x00cc, B:25:0x00e3, B:29:0x0127, B:30:0x0130, B:32:0x0133, B:34:0x0136, B:36:0x013c, B:37:0x0145, B:39:0x0160, B:40:0x017e, B:44:0x016f, B:45:0x0141, B:46:0x00ec, B:49:0x00f5, B:51:0x0103, B:56:0x010f, B:58:0x011c), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x011c A[Catch: all -> 0x0182, TRY_LEAVE, TryCatch #1 {, blocks: (B:3:0x0001, B:6:0x0038, B:11:0x0068, B:13:0x009d, B:18:0x00a3, B:41:0x0203, B:64:0x01b9, B:66:0x01ec, B:69:0x01f1, B:19:0x00aa, B:21:0x00b0, B:23:0x00cc, B:25:0x00e3, B:29:0x0127, B:30:0x0130, B:32:0x0133, B:34:0x0136, B:36:0x013c, B:37:0x0145, B:39:0x0160, B:40:0x017e, B:44:0x016f, B:45:0x0141, B:46:0x00ec, B:49:0x00f5, B:51:0x0103, B:56:0x010f, B:58:0x011c), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0119  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void m2599a(Context context, boolean z, boolean z2) {
        File m2437r;
        boolean z3;
        Context origApplicationContext;
        File file;
        TbsLog.initIfNeed(context);
        f2113a++;
        TbsLog.m2154i("SDKEngine", "init", "#1# context: " + context + ", mInitCount: " + f2113a);
        C1381p.m2503a().m2473b(context, f2113a == 1);
        C1381p.m2503a().m2443l(context);
        TbsShareManager.forceToLoadX5ForThirdApp(context, true);
        boolean m2829a = QbSdk.m2829a(context, z, z2);
        TbsLog.m2154i("SDKEngine", "init", "#2# canLoadX5 is " + m2829a);
        boolean z4 = m2829a && 1 != 0;
        if (z4) {
            long currentTimeMillis = System.currentTimeMillis();
            z4 = C1381p.m2503a().m2452g(context, m2592d());
            TbsLog.m2154i("SDKEngine", "init", "isTbsCoreLegal: " + z4 + "; cost: " + (System.currentTimeMillis() - currentTimeMillis));
        }
        if (!z4) {
            TbsLog.m2157e("SDKEngine", "init", "canLoadTbs = false; failure: " + ("QbSdk.canLoadX5 = " + m2829a + "; is_compatible = true"));
            if (!QbSdk.f1740a || !this.f2121f) {
                this.f2121f = false;
                TbsCoreLoadStat.getInstance().m2815a(context, 405);
                TbsLog.m2157e("SDKEngine", "init", "[LoadError] check log upon for details");
            }
        } else if (this.f2121f) {
            return;
        } else {
            TbsLog.m2154i("SDKEngine", "init", "#3# start to load tbs");
            if (TbsShareManager.isThirdPartyApp(context)) {
                boolean m2721j = TbsShareManager.m2721j(context);
                TbsLog.m2154i("SDKEngine", "init", "#3-1# isShareTbsCoreAvailable: " + m2721j);
                if (!m2721j) {
                    this.f2121f = false;
                    QbSdk.m2833a(context, "SDKEngine::useSystemWebView by error_host_unavailable");
                    return;
                }
                m2437r = new File(TbsShareManager.m2730c(context));
                file = C1381p.m2503a().m2437r(context);
                origApplicationContext = TbsShareManager.m2726e(context);
                if (file == null) {
                    this.f2121f = false;
                    QbSdk.m2833a(context, "SDKEngine::useSystemWebView by error_tbs_core_dexopt_dir null!");
                    return;
                }
            } else {
                m2437r = C1381p.m2503a().m2437r(context);
                if (f2116h != 25436 && f2116h != 25437) {
                    z3 = false;
                    origApplicationContext = !z3 ? StubApp.getOrigApplicationContext(context.getApplicationContext()) : context;
                    if (m2437r != null) {
                        this.f2121f = false;
                        QbSdk.m2833a(context, "SDKEngine::useSystemWebView by tbs_core_share_dir null!");
                        return;
                    }
                    file = m2437r;
                }
                z3 = true;
                if (!z3) {
                }
                if (m2437r != null) {
                }
            }
            Context context2 = origApplicationContext;
            String[] dexLoaderFileList = QbSdk.getDexLoaderFileList(context, context2, m2437r.getAbsolutePath());
            for (int i = 0; i < dexLoaderFileList.length; i++) {
            }
            String hostCorePathAppDefined = TbsShareManager.getHostCorePathAppDefined() != null ? TbsShareManager.getHostCorePathAppDefined() : file.getAbsolutePath();
            TbsLog.m2154i("SDKEngine", "init", "#4# optDir is " + hostCorePathAppDefined);
            if (this.f2120d != null) {
                C1414v c1414v = this.f2120d;
                this.f2119c = c1414v;
                c1414v.m2304a(context, context2, m2437r.getAbsolutePath(), hostCorePathAppDefined, dexLoaderFileList, QbSdk.f1743d);
            } else {
                this.f2119c = new C1414v(context, context2, m2437r.getAbsolutePath(), hostCorePathAppDefined, dexLoaderFileList, QbSdk.f1743d);
            }
            this.f2121f = true;
        }
        C1359d.m2614a().m2613a(context);
        this.f2123j = C1381p.m2435t(context);
        this.f2122g = true;
    }

    /* renamed from: a */
    public void m2598a(String str) {
        f2118k = str;
    }

    /* renamed from: b */
    public boolean m2596b() {
        return this.f2121f;
    }

    /* renamed from: b */
    public boolean m2594b(boolean z) {
        f2114b = z;
        return z;
    }

    /* renamed from: c */
    public C1414v m2593c() {
        return this.f2119c;
    }

    /* renamed from: e */
    public String m2591e() {
        C1414v c1414v = this.f2119c;
        return (c1414v == null || QbSdk.f1740a) ? "system webview get nothing..." : c1414v.m2306a();
    }

    /* renamed from: f */
    public boolean m2590f() {
        if (f2114b) {
            if (f2118k == null) {
                return false;
            }
            int m2587i = m2587i();
            if (m2587i == 0) {
                m2595b(1);
            } else {
                int i = m2587i + 1;
                if (i > f2117i) {
                    return false;
                }
                m2595b(i);
            }
        }
        return f2114b;
    }

    /* renamed from: g */
    public boolean m2589g() {
        return this.f2122g;
    }

    /* renamed from: h */
    public boolean m2588h() {
        return QbSdk.useSoftWare();
    }
}
