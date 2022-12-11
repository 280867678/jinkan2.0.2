package com.tencent.smtt.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.TextUtils;
import com.stub.StubApp;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Properties;

/* renamed from: com.tencent.smtt.utils.n */
/* loaded from: classes4.dex */
public class C1467n {

    /* renamed from: c */
    public static C1467n f2523c;

    /* renamed from: a */
    public Context f2524a;

    /* renamed from: b */
    public File f2525b = null;

    /* renamed from: d */
    public String f2526d = "https://log.tbs.qq.com/ajax?c=pu&v=2&k=";

    /* renamed from: e */
    public String f2527e = "https://log.tbs.qq.com/ajax?c=pu&tk=";

    /* renamed from: f */
    public String f2528f = "https://log.tbs.qq.com/ajax?c=dl&k=";

    /* renamed from: g */
    public String f2529g = "https://cfg.imtt.qq.com/tbs?v=2&mk=";

    /* renamed from: h */
    public String f2530h = "https://log.tbs.qq.com/ajax?c=ul&v=2&k=";

    /* renamed from: i */
    public String f2531i = "https://mqqad.html5.qq.com/adjs";

    /* renamed from: j */
    public String f2532j = "https://log.tbs.qq.com/ajax?c=ucfu&k=";

    /* renamed from: k */
    public String f2533k = "";

    /* renamed from: l */
    public String f2534l = "";

    /* renamed from: m */
    public String f2535m = "";

    /* renamed from: n */
    public String f2536n = "https://tbsrecovery.imtt.qq.com/getconfig";

    @TargetApi(11)
    public C1467n(Context context) {
        this.f2524a = null;
        TbsLog.m2148w("TbsCommonConfig", "TbsCommonConfig constructing...");
        this.f2524a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        m2008k();
    }

    /* renamed from: a */
    public static synchronized C1467n m2019a() {
        C1467n c1467n;
        synchronized (C1467n.class) {
            c1467n = f2523c;
        }
        return c1467n;
    }

    /* renamed from: a */
    public static synchronized C1467n m2018a(Context context) {
        C1467n c1467n;
        synchronized (C1467n.class) {
            if (f2523c == null) {
                f2523c = new C1467n(context);
            }
            c1467n = f2523c;
        }
        return c1467n;
    }

    /* renamed from: k */
    private synchronized void m2008k() {
        File m2007l;
        BufferedInputStream bufferedInputStream = null;
        try {
            m2007l = m2007l();
        } catch (Throwable th) {
            th = th;
        }
        if (m2007l == null) {
            TbsLog.m2158e("TbsCommonConfig", "Config file is null, default values will be applied");
            return;
        }
        BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(m2007l));
        try {
            Properties properties = new Properties();
            properties.load(bufferedInputStream2);
            String property = properties.getProperty("pv_post_url", "");
            if (!"".equals(property)) {
                this.f2526d = property;
            }
            String property2 = properties.getProperty("tbs_download_stat_post_url", "");
            if (!"".equals(property2)) {
                this.f2528f = property2;
            }
            String property3 = properties.getProperty("tbs_downloader_post_url", "");
            TbsLog.m2155i("TbsCommonConfig", "KEY_TBS_DOWNLOADER_POST_URL is " + property3);
            if (!"".equals(property3)) {
                this.f2529g = property3;
            }
            String property4 = properties.getProperty("tbs_downloader_response_query", "");
            TbsLog.m2155i("TbsCommonConfig", "KEY_TBS_DOWNLOADER_RESPONSE_QUERY is " + property4);
            if (!"".equals(property4)) {
                this.f2533k = property4;
            }
            String property5 = properties.getProperty("tbs_downloader_response_update", "");
            TbsLog.m2155i("TbsCommonConfig", "KEY_TBS_DOWNLOADER_RESPONSE_UPDATE is " + property5);
            if (!"".equals(property5)) {
                this.f2534l = property5;
            }
            String property6 = properties.getProperty("tbs_downloader_response_download", "");
            TbsLog.m2155i("TbsCommonConfig", "KEY_TBS_DOWNLOADER_RESPONSE_DOWNLOAD is " + property6);
            if (!"".equals(property6)) {
                this.f2535m = property6;
            }
            String property7 = properties.getProperty("tbs_log_post_url", "");
            if (!"".equals(property7)) {
                this.f2530h = property7;
            }
            String property8 = properties.getProperty("tips_url", "");
            if (!"".equals(property8)) {
                this.f2531i = property8;
            }
            String property9 = properties.getProperty("tbs_cmd_post_url", "");
            if (!"".equals(property9)) {
                this.f2532j = property9;
            }
            String property10 = properties.getProperty("tbs_emergency_post_url", "");
            if (!"".equals(property10)) {
                this.f2536n = property10;
            }
            String property11 = properties.getProperty("pv_post_url_tk", "");
            if (!"".equals(property11)) {
                this.f2527e = property11;
            }
            try {
                bufferedInputStream2.close();
            } catch (IOException e) {
                e = e;
                e.printStackTrace();
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream = bufferedInputStream2;
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            TbsLog.m2158e("TbsCommonConfig", "exceptions occurred1:" + stringWriter.toString());
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e2) {
                    e = e2;
                    e.printStackTrace();
                }
            }
        }
    }

    /* renamed from: l */
    private File m2007l() {
        File file;
        File file2 = null;
        try {
            if (this.f2525b == null) {
                String str = StubApp.getOrigApplicationContext(this.f2524a.getApplicationContext()).getApplicationInfo().packageName;
                if (!TextUtils.isEmpty(str)) {
                    boolean z = true;
                    boolean z2 = this.f2524a.getPackageManager().checkPermission("android.permission.READ_EXTERNAL_STORAGE", str) == 0;
                    if (this.f2524a.getPackageManager().checkPermission(UMUtils.SD_PERMISSION, str) != 0) {
                        z = false;
                    }
                    if (!z2 && !z) {
                        file = new File(FileUtil.m2198a(this.f2524a, 8));
                    }
                    TbsLog.m2155i("TbsCommonConfig", "no permission,use sdcard default folder");
                    file = new File(FileUtil.m2198a(this.f2524a, 5));
                } else {
                    file = new File(FileUtil.m2198a(this.f2524a, 8));
                }
                this.f2525b = file;
                if (this.f2525b == null || !this.f2525b.isDirectory()) {
                    return null;
                }
            }
            TbsLog.m2155i("TbsCommonConfig", "mTbsConfigDir is " + this.f2525b.getAbsolutePath());
            File file3 = new File(this.f2525b, "tbsnet.conf");
            if (!file3.exists()) {
                TbsLog.m2158e("TbsCommonConfig", "Get file(" + file3.getCanonicalPath() + ") failed!");
                return null;
            }
            try {
                TbsLog.m2148w("TbsCommonConfig", "pathc:" + file3.getCanonicalPath());
                return file3;
            } catch (Throwable th) {
                th = th;
                file2 = file3;
                StringWriter stringWriter = new StringWriter();
                th.printStackTrace(new PrintWriter(stringWriter));
                TbsLog.m2158e("TbsCommonConfig", "exceptions occurred2:" + stringWriter.toString());
                return file2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: b */
    public String m2017b() {
        return this.f2526d;
    }

    /* renamed from: c */
    public String m2016c() {
        return this.f2528f;
    }

    /* renamed from: d */
    public String m2015d() {
        return this.f2533k;
    }

    /* renamed from: e */
    public String m2014e() {
        return this.f2534l;
    }

    /* renamed from: f */
    public String m2013f() {
        return this.f2535m;
    }

    /* renamed from: g */
    public String m2012g() {
        return this.f2529g;
    }

    /* renamed from: h */
    public String m2011h() {
        return this.f2530h;
    }

    /* renamed from: i */
    public String m2010i() {
        return this.f2527e;
    }

    /* renamed from: j */
    public String m2009j() {
        return this.f2536n;
    }
}
