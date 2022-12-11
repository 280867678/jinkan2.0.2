package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.C1847b;
import java.util.ArrayList;
import java.util.List;
import me.tvspark.outline;

/* renamed from: com.umeng.analytics.pro.y */
/* loaded from: classes4.dex */
public class C1669y {

    /* renamed from: c */
    public static volatile C1669y f3659c;

    /* renamed from: a */
    public AbstractC1667w f3660a = new C1668x();

    /* renamed from: b */
    public String f3661b;

    /* renamed from: d */
    public List<AbstractC1670a> f3662d;

    /* renamed from: e */
    public String f3663e;

    /* renamed from: com.umeng.analytics.pro.y$a */
    /* loaded from: classes4.dex */
    public interface AbstractC1670a {
        /* renamed from: a */
        void mo852a(String str, long j, long j2, long j3);

        /* renamed from: a */
        void mo851a(String str, String str2, long j, long j2, long j3);
    }

    /* renamed from: a */
    private long m865a(Context context, String str) {
        long j;
        try {
            j = PreferenceWrapper.getDefault(context).getLong(str, 0L);
        } catch (Exception unused) {
            j = 0;
        }
        return j <= 0 ? System.currentTimeMillis() : j;
    }

    /* renamed from: a */
    public static C1669y m870a() {
        if (f3659c == null) {
            synchronized (C1669y.class) {
                if (f3659c == null) {
                    f3659c = new C1669y();
                }
            }
        }
        return f3659c;
    }

    /* renamed from: a */
    private void m868a(long j, long j2, long j3, String str, boolean z) {
        List<AbstractC1670a> list = this.f3662d;
        if (list != null) {
            for (AbstractC1670a abstractC1670a : list) {
                if (z) {
                    try {
                        abstractC1670a.mo851a(str, this.f3661b, j, j2, j3);
                    } catch (Exception unused) {
                    }
                } else {
                    abstractC1670a.mo852a(this.f3661b, j, j2, j3);
                }
            }
        }
    }

    /* renamed from: f */
    private String m857f(Context context) {
        String str;
        try {
            SharedPreferences.Editor edit = PreferenceWrapper.getDefault(context).edit();
            edit.putString(C1663u.f3641d, m859d(context));
            edit.commit();
        } catch (Exception unused) {
        }
        long m855h = m855h(context);
        long m854i = m854i(context);
        String str2 = this.f3661b;
        long m898a = C1663u.m898a(context);
        long j = m898a * 5000;
        UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>>*** 读取 foreground count 值完成，count次数：" + m898a);
        if (!FieldManager.allow(C1847b.f4254E)) {
            str = "--->>>*** foreground count druation云控参数关闭。";
        } else if (UMWorkDispatch.eventHasExist()) {
            UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>>*** 读取 foreground count druation值完成，终止checker timer.");
            UMWorkDispatch.removeEvent();
            m868a(m854i, m855h, j, str2, false);
            this.f3661b = this.f3660a.mo872a(context);
            m868a(m854i, m855h, j, str2, true);
            this.f3660a.mo871a(context, this.f3661b);
            return this.f3661b;
        } else {
            str = "--->>>*** 读取 foreground count druation值完成，无未处理check timer事件。";
        }
        UMRTLog.m767e(UMRTLog.RTLOG_TAG, str);
        m868a(m854i, m855h, j, str2, false);
        this.f3661b = this.f3660a.mo872a(context);
        m868a(m854i, m855h, j, str2, true);
        this.f3660a.mo871a(context, this.f3661b);
        return this.f3661b;
    }

    /* renamed from: g */
    private boolean m856g(Context context) {
        return !TextUtils.isEmpty(this.f3661b) && C1636i.m1056a(context).m1055a(this.f3661b) > 0;
    }

    /* renamed from: h */
    private long m855h(Context context) {
        return m865a(context, C1663u.f3643f);
    }

    /* renamed from: i */
    private long m854i(Context context) {
        return m865a(context, C1663u.f3638a);
    }

    /* renamed from: j */
    private boolean m853j(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        try {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(appContext);
            long j = sharedPreferences.getLong(C1663u.f3642e, 0L);
            long j2 = sharedPreferences.getLong(C1663u.f3643f, 0L);
            if (FieldManager.allow(C1847b.f4254E) && j > 0 && j2 == 0) {
                long m898a = C1663u.m898a(appContext);
                if (m898a > 0) {
                    UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>> last session end time stamp = 0, reconstruct it by foreground count value.");
                    j2 = j + (m898a * 5000);
                }
            }
            UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> interval of last session is: " + (j2 - j));
            return this.f3660a.mo873a(j, j2);
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: a */
    public String m867a(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        if (appContext == null) {
            return "";
        }
        String str = "";
        try {
            synchronized (C1669y.class) {
                str = PreferenceWrapper.getDefault(appContext).getString(C1663u.f3641d, "");
            }
        } catch (Exception unused) {
        }
        return str;
    }

    /* renamed from: a */
    public String m866a(Context context, long j) {
        if (TextUtils.isEmpty(this.f3663e)) {
            String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("SUB", j);
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("%0");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(32 - Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append("d");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(String.format(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString(), 0));
            this.f3663e = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
        }
        return this.f3663e;
    }

    /* renamed from: a */
    public void m869a(long j) {
        this.f3660a.mo874a(j);
    }

    /* renamed from: a */
    public void m864a(AbstractC1670a abstractC1670a) {
        if (abstractC1670a == null) {
            return;
        }
        if (this.f3662d == null) {
            this.f3662d = new ArrayList();
        }
        if (this.f3662d.contains(abstractC1670a)) {
            return;
        }
        this.f3662d.add(abstractC1670a);
    }

    /* renamed from: b */
    public long m863b() {
        return this.f3660a.mo875a();
    }

    /* renamed from: b */
    public synchronized String m862b(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        if (appContext == null) {
            return "";
        }
        this.f3661b = m859d(appContext);
        if (m858e(appContext)) {
            try {
                this.f3661b = m857f(appContext);
            } catch (Exception unused) {
            }
        }
        return this.f3661b;
    }

    /* renamed from: b */
    public void m861b(AbstractC1670a abstractC1670a) {
        List<AbstractC1670a> list;
        if (abstractC1670a == null || (list = this.f3662d) == null || list.size() == 0) {
            return;
        }
        this.f3662d.remove(abstractC1670a);
    }

    /* renamed from: c */
    public String m860c(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        if (appContext == null) {
            return "";
        }
        try {
            this.f3661b = m857f(appContext);
        } catch (Exception unused) {
        }
        return this.f3661b;
    }

    /* renamed from: d */
    public String m859d(Context context) {
        if (TextUtils.isEmpty(this.f3661b)) {
            try {
                this.f3661b = PreferenceWrapper.getDefault(context).getString("session_id", null);
            } catch (Exception unused) {
            }
        }
        return this.f3661b;
    }

    /* renamed from: e */
    public boolean m858e(Context context) {
        if (TextUtils.isEmpty(this.f3661b)) {
            this.f3661b = m859d(context);
        }
        return TextUtils.isEmpty(this.f3661b) || m853j(context) || m856g(context);
    }
}
