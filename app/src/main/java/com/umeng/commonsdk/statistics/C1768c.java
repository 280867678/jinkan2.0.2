package com.umeng.commonsdk.statistics;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.pro.C1563aw;
import com.umeng.analytics.pro.C1586bl;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.C1724a;
import com.umeng.commonsdk.internal.C1725b;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.stateless.C1759d;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.idtracking.C1786e;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.internal.AbstractC1803d;
import com.umeng.commonsdk.statistics.internal.C1795a;
import com.umeng.commonsdk.statistics.internal.C1799c;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.statistics.internal.StatTracer;
import com.umeng.commonsdk.statistics.noise.ABTest;
import com.umeng.commonsdk.statistics.noise.Defcon;
import com.umeng.commonsdk.statistics.proto.Response;
import java.io.File;

/* renamed from: com.umeng.commonsdk.statistics.c */
/* loaded from: classes4.dex */
public class C1768c {

    /* renamed from: b */
    public static final int f4031b = 1;

    /* renamed from: c */
    public static final int f4032c = 2;

    /* renamed from: d */
    public static final int f4033d = 3;

    /* renamed from: o */
    public static final String f4034o = "thtstart";

    /* renamed from: p */
    public static final String f4035p = "gkvc";

    /* renamed from: q */
    public static final String f4036q = "ekvc";

    /* renamed from: a */
    public String f4037a;

    /* renamed from: f */
    public C1799c f4039f;

    /* renamed from: g */
    public ImprintHandler f4040g;

    /* renamed from: h */
    public C1786e f4041h;

    /* renamed from: i */
    public ImprintHandler.C1781a f4042i;

    /* renamed from: k */
    public Defcon f4044k;

    /* renamed from: l */
    public long f4045l;

    /* renamed from: m */
    public int f4046m;

    /* renamed from: n */
    public int f4047n;

    /* renamed from: r */
    public Context f4048r;

    /* renamed from: e */
    public final int f4038e = 1;

    /* renamed from: j */
    public ABTest f4043j = null;

    public C1768c(Context context) {
        this.f4041h = null;
        this.f4042i = null;
        this.f4044k = null;
        this.f4045l = 0L;
        this.f4046m = 0;
        this.f4047n = 0;
        this.f4037a = null;
        this.f4048r = context;
        this.f4042i = ImprintHandler.getImprintService(context).m475c();
        this.f4044k = Defcon.getService(this.f4048r);
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(this.f4048r);
        this.f4045l = sharedPreferences.getLong("thtstart", 0L);
        this.f4046m = sharedPreferences.getInt("gkvc", 0);
        this.f4047n = sharedPreferences.getInt("ekvc", 0);
        this.f4037a = UMEnvelopeBuild.imprintProperty(this.f4048r, "track_list", null);
        ImprintHandler imprintService = ImprintHandler.getImprintService(this.f4048r);
        this.f4040g = imprintService;
        imprintService.m486a(new AbstractC1803d() { // from class: com.umeng.commonsdk.statistics.c.1
            @Override // com.umeng.commonsdk.statistics.internal.AbstractC1803d
            public void onImprintChanged(ImprintHandler.C1781a c1781a) {
                C1768c.this.f4044k.onImprintChanged(c1781a);
                C1768c c1768c = C1768c.this;
                c1768c.f4037a = UMEnvelopeBuild.imprintProperty(c1768c.f4048r, "track_list", null);
            }
        });
        if (!UMConfigure.needSendZcfgEnv(this.f4048r)) {
            this.f4041h = C1786e.m453a(this.f4048r);
        }
        C1799c c1799c = new C1799c(this.f4048r);
        this.f4039f = c1799c;
        c1799c.m424a(StatTracer.getInstance(this.f4048r));
    }

    /* renamed from: a */
    private int m582a(byte[] bArr) {
        Response response = new Response();
        try {
            new C1563aw(new C1586bl.C1587a()).m1234a(response, bArr);
            if (response.resp_code == 1) {
                this.f4040g.m477b(response.getImprint());
                this.f4040g.m473d();
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(this.f4048r, th);
        }
        return response.resp_code == 1 ? 2 : 3;
    }

    /* renamed from: a */
    public boolean m583a(File file) {
        String str;
        if (file == null) {
            return false;
        }
        try {
            byte[] byteArray = UMFrUtils.toByteArray(file.getPath());
            if (byteArray == null) {
                return false;
            }
            String name = file.getName();
            if (TextUtils.isEmpty(name)) {
                return false;
            }
            C1795a m434a = C1795a.m434a(this.f4048r);
            m434a.m429d(name);
            boolean m433a = m434a.m433a(name);
            boolean m431b = m434a.m431b(name);
            boolean m430c = m434a.m430c(name);
            String m602d = C1759d.m602d(name);
            byte[] m421a = this.f4039f.m421a(byteArray, m433a, m430c, !TextUtils.isEmpty(m602d) ? C1759d.m604c(m602d) : m430c ? UMServerURL.ZCFG_PATH : UMServerURL.PATH_ANALYTICS);
            int m582a = m421a == null ? 1 : m582a(m421a);
            if (UMConfigure.isDebugLog()) {
                if (m430c && m582a == 2) {
                    str = "Zero req: succeed.";
                } else if (m431b && m582a == 2) {
                    MLog.m580d("本次启动数据: 发送成功!");
                    str = "Send instant data: succeed.";
                } else if (!m433a || m582a != 2) {
                    str = "Inner req: succeed.";
                } else {
                    MLog.m580d("普通统计数据: 发送成功!");
                    str = "Send analytics data: succeed.";
                }
                UMRTLog.m766i(UMRTLog.RTLOG_TAG, str);
            }
            if (m582a == 2) {
                if (this.f4041h != null) {
                    this.f4041h.m446e();
                }
                StatTracer.getInstance(this.f4048r).saveSate();
            } else if (m582a == 3) {
                StatTracer.getInstance(this.f4048r).saveSate();
                if (m430c) {
                    FieldManager.m794a().m793a(this.f4048r);
                    UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>> 零号报文应答内容报错!!! ，特殊处理!，继续正常流程。");
                    UMWorkDispatch.sendEvent(this.f4048r, C1724a.f3917s, C1725b.m729a(this.f4048r).m730a(), null);
                    return true;
                }
            }
            return m582a == 2;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(this.f4048r, th);
            return false;
        }
    }
}
