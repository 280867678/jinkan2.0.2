package com.tencent.bugly.beta.global;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.stub.StubApp;
import com.tencent.bugly.beta.UpgradeInfo;
import com.tencent.bugly.beta.download.AbstractC1087c;
import com.tencent.bugly.beta.download.DownloadListener;
import com.tencent.bugly.beta.interfaces.BetaPatchListener;
import com.tencent.bugly.beta.p041ui.UILifecycleListener;
import com.tencent.bugly.beta.upgrade.BetaUploadStrategy;
import com.tencent.bugly.crashreport.common.info.C1140a;
import com.tencent.bugly.proguard.C1199X;
import com.tencent.bugly.proguard.C1208ca;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.bugly.beta.global.e */
/* loaded from: classes3.dex */
public class C1093e {

    /* renamed from: a */
    public static int f736a;

    /* renamed from: b */
    public static C1093e f737b = new C1093e();

    /* renamed from: C */
    public PackageInfo f740C;

    /* renamed from: D */
    public SharedPreferences f741D;

    /* renamed from: E */
    public DisplayMetrics f742E;

    /* renamed from: H */
    public BetaUploadStrategy f745H;

    /* renamed from: I */
    public File f746I;

    /* renamed from: J */
    public File f747J;

    /* renamed from: K */
    public File f748K;

    /* renamed from: Y */
    public BetaPatchListener f762Y;

    /* renamed from: fa */
    public boolean f773fa;

    /* renamed from: i */
    public int f776i;

    /* renamed from: j */
    public int f777j;

    /* renamed from: k */
    public int f778k;

    /* renamed from: l */
    public int f779l;

    /* renamed from: m */
    public int f780m;

    /* renamed from: n */
    public UILifecycleListener<UpgradeInfo> f781n;

    /* renamed from: o */
    public File f782o;

    /* renamed from: r */
    public int f785r;

    /* renamed from: s */
    public AbstractC1087c f786s;

    /* renamed from: t */
    public DownloadListener f787t;

    /* renamed from: u */
    public File f788u;

    /* renamed from: v */
    public Context f789v;

    /* renamed from: w */
    public File f790w;

    /* renamed from: x */
    public String f791x;

    /* renamed from: y */
    public String f792y;

    /* renamed from: c */
    public long f766c = 3000;

    /* renamed from: d */
    public long f768d = 0;

    /* renamed from: e */
    public boolean f770e = true;

    /* renamed from: f */
    public boolean f772f = false;

    /* renamed from: g */
    public boolean f774g = false;

    /* renamed from: h */
    public boolean f775h = true;

    /* renamed from: p */
    public final List<Class<? extends Activity>> f783p = new ArrayList();

    /* renamed from: q */
    public final List<Class<? extends Activity>> f784q = new ArrayList();

    /* renamed from: z */
    public int f793z = Integer.MIN_VALUE;

    /* renamed from: A */
    public String f738A = "";

    /* renamed from: B */
    public String f739B = "";

    /* renamed from: F */
    public boolean f743F = true;

    /* renamed from: G */
    public boolean f744G = false;

    /* renamed from: L */
    public String f749L = "";

    /* renamed from: M */
    public String f750M = "";

    /* renamed from: N */
    public String f751N = "";

    /* renamed from: O */
    public String f752O = "";

    /* renamed from: P */
    public boolean f753P = false;

    /* renamed from: Q */
    public int f754Q = 0;

    /* renamed from: R */
    public String f755R = "";

    /* renamed from: S */
    public boolean f756S = false;

    /* renamed from: T */
    public boolean f757T = true;

    /* renamed from: U */
    public boolean f758U = false;

    /* renamed from: V */
    public boolean f759V = false;

    /* renamed from: W */
    public boolean f760W = true;

    /* renamed from: X */
    public boolean f761X = true;

    /* renamed from: Z */
    public boolean f763Z = false;

    /* renamed from: aa */
    public boolean f764aa = true;

    /* renamed from: ba */
    public boolean f765ba = false;

    /* renamed from: ca */
    public final List<String> f767ca = new ArrayList();

    /* renamed from: da */
    public boolean f769da = false;

    /* renamed from: ea */
    public boolean f771ea = false;

    /* JADX WARN: Code restructure failed: missing block: B:45:0x0142, code lost:
        if (r8.f790w.mkdirs() != false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0152, code lost:
        if (r8.f788u.mkdirs() != false) goto L50;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01dd A[Catch: all -> 0x0207, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0013, B:7:0x0027, B:8:0x002b, B:10:0x0033, B:11:0x0039, B:13:0x004d, B:15:0x0051, B:16:0x0057, B:18:0x005b, B:20:0x0065, B:22:0x0076, B:24:0x0087, B:26:0x008d, B:27:0x0096, B:29:0x00b1, B:32:0x00b8, B:33:0x0114, B:40:0x012a, B:42:0x0134, B:44:0x013c, B:46:0x0144, B:48:0x014c, B:50:0x019f, B:52:0x01dd, B:53:0x01e2, B:55:0x01e8, B:56:0x01f0, B:58:0x01fe, B:64:0x0196, B:66:0x019c, B:67:0x0154, B:69:0x0158, B:71:0x0162, B:73:0x016c, B:75:0x0174, B:77:0x0178, B:79:0x0180, B:81:0x0184, B:83:0x018e, B:86:0x00f1, B:88:0x006d, B:90:0x0073), top: B:2:0x0001, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01e8 A[Catch: all -> 0x0207, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0013, B:7:0x0027, B:8:0x002b, B:10:0x0033, B:11:0x0039, B:13:0x004d, B:15:0x0051, B:16:0x0057, B:18:0x005b, B:20:0x0065, B:22:0x0076, B:24:0x0087, B:26:0x008d, B:27:0x0096, B:29:0x00b1, B:32:0x00b8, B:33:0x0114, B:40:0x012a, B:42:0x0134, B:44:0x013c, B:46:0x0144, B:48:0x014c, B:50:0x019f, B:52:0x01dd, B:53:0x01e2, B:55:0x01e8, B:56:0x01f0, B:58:0x01fe, B:64:0x0196, B:66:0x019c, B:67:0x0154, B:69:0x0158, B:71:0x0162, B:73:0x016c, B:75:0x0174, B:77:0x0178, B:79:0x0180, B:81:0x0184, B:83:0x018e, B:86:0x00f1, B:88:0x006d, B:90:0x0073), top: B:2:0x0001, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01fe A[Catch: all -> 0x0207, TRY_LEAVE, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0013, B:7:0x0027, B:8:0x002b, B:10:0x0033, B:11:0x0039, B:13:0x004d, B:15:0x0051, B:16:0x0057, B:18:0x005b, B:20:0x0065, B:22:0x0076, B:24:0x0087, B:26:0x008d, B:27:0x0096, B:29:0x00b1, B:32:0x00b8, B:33:0x0114, B:40:0x012a, B:42:0x0134, B:44:0x013c, B:46:0x0144, B:48:0x014c, B:50:0x019f, B:52:0x01dd, B:53:0x01e2, B:55:0x01e8, B:56:0x01f0, B:58:0x01fe, B:64:0x0196, B:66:0x019c, B:67:0x0154, B:69:0x0158, B:71:0x0162, B:73:0x016c, B:75:0x0174, B:77:0x0178, B:79:0x0180, B:81:0x0184, B:83:0x018e, B:86:0x00f1, B:88:0x006d, B:90:0x0073), top: B:2:0x0001, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0124  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void m3608a(Context context) {
        boolean m3612a;
        BetaUploadStrategy betaUploadStrategy;
        f737b.f789v = StubApp.getOrigApplicationContext(context.getApplicationContext());
        PackageManager packageManager = this.f789v.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(this.f789v.getPackageName(), 16384);
            this.f740C = packageInfo;
            if (this.f793z == Integer.MIN_VALUE) {
                this.f793z = packageInfo.versionCode;
            }
            if (TextUtils.isEmpty(this.f738A)) {
                this.f738A = this.f740C.versionName;
            }
            this.f739B = (String) this.f740C.applicationInfo.loadLabel(packageManager);
            if (TextUtils.isEmpty(this.f755R)) {
                this.f755R = C1089a.m3622a(this.f789v, "BUGLY_CHANNEL");
            }
            String m3622a = C1089a.m3622a(this.f789v, "BUGLY_APP_BUILD_NO");
            if (!TextUtils.isEmpty(m3622a)) {
                this.f785r = Integer.parseInt(m3622a);
            }
        } catch (Exception e) {
            if (!C1199X.m3083a(e)) {
                e.printStackTrace();
            }
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        this.f742E = new DisplayMetrics();
        if (windowManager != null && windowManager.getDefaultDisplay() != null) {
            windowManager.getDefaultDisplay().getMetrics(this.f742E);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f789v.getPackageName());
        sb.append("/.beta/");
        File file = this.f782o;
        if (file != null && file.exists()) {
            File file2 = this.f782o;
            this.f790w = new File(file2, sb.toString() + "/apk/");
            File file3 = this.f782o;
            this.f788u = new File(file3, sb.toString() + "/res/");
            if (packageManager.checkPermission(UMUtils.SD_PERMISSION, this.f740C.packageName) != 0) {
                try {
                } catch (Exception e2) {
                    if (!C1199X.m3083a(e2)) {
                        e2.printStackTrace();
                    }
                }
                if ("mounted".equals(Environment.getExternalStorageState())) {
                    if (!this.f790w.exists()) {
                    }
                    if (!this.f788u.exists()) {
                    }
                    C1199X.m3078c("apkSaveDir: %s, resSaveDir: %s", this.f790w.getAbsolutePath(), this.f788u.getAbsolutePath());
                    this.f741D = C1208ca.m3026a(context.getPackageName() + ".BETA_VALUES", this.f789v);
                    m3612a = C1089a.m3612a("isFirstRun", true);
                    this.f743F = m3612a;
                    if (m3612a) {
                        C1089a.m3609b("isFirstRun", false);
                    }
                    if (C1140a.m3394m() != null) {
                        this.f756S = C1140a.m3394m().f1058oa;
                    }
                    betaUploadStrategy = (BetaUploadStrategy) C1089a.m3615a("us.bch", BetaUploadStrategy.CREATOR);
                    this.f745H = betaUploadStrategy;
                    if (betaUploadStrategy == null) {
                        this.f745H = new BetaUploadStrategy();
                    }
                }
            }
            this.f790w = this.f789v.getExternalFilesDir("apk");
            this.f788u = this.f789v.getExternalFilesDir("res");
            if (this.f790w != null || !this.f790w.exists() || this.f788u == null || !this.f788u.exists()) {
                this.f790w = this.f789v.getDir("apk", 2);
                this.f788u = this.f789v.getDir("res", 0);
            }
            C1199X.m3078c("apkSaveDir: %s, resSaveDir: %s", this.f790w.getAbsolutePath(), this.f788u.getAbsolutePath());
            this.f741D = C1208ca.m3026a(context.getPackageName() + ".BETA_VALUES", this.f789v);
            m3612a = C1089a.m3612a("isFirstRun", true);
            this.f743F = m3612a;
            if (m3612a) {
            }
            if (C1140a.m3394m() != null) {
            }
            betaUploadStrategy = (BetaUploadStrategy) C1089a.m3615a("us.bch", BetaUploadStrategy.CREATOR);
            this.f745H = betaUploadStrategy;
            if (betaUploadStrategy == null) {
            }
        }
        this.f782o = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), sb.toString());
        this.f790w = new File(this.f782o, "/apk/");
        this.f788u = new File(this.f782o, "/res/");
        if (packageManager.checkPermission(UMUtils.SD_PERMISSION, this.f740C.packageName) != 0) {
        }
        this.f790w = this.f789v.getExternalFilesDir("apk");
        this.f788u = this.f789v.getExternalFilesDir("res");
        if (this.f790w != null) {
        }
        this.f790w = this.f789v.getDir("apk", 2);
        this.f788u = this.f789v.getDir("res", 0);
        C1199X.m3078c("apkSaveDir: %s, resSaveDir: %s", this.f790w.getAbsolutePath(), this.f788u.getAbsolutePath());
        this.f741D = C1208ca.m3026a(context.getPackageName() + ".BETA_VALUES", this.f789v);
        m3612a = C1089a.m3612a("isFirstRun", true);
        this.f743F = m3612a;
        if (m3612a) {
        }
        if (C1140a.m3394m() != null) {
        }
        betaUploadStrategy = (BetaUploadStrategy) C1089a.m3615a("us.bch", BetaUploadStrategy.CREATOR);
        this.f745H = betaUploadStrategy;
        if (betaUploadStrategy == null) {
        }
    }
}
