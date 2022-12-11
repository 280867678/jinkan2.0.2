package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.text.TextUtils;
import com.tencent.bugly.beta.download.AbstractC1087c;
import com.tencent.bugly.beta.download.DownloadTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* renamed from: com.tencent.bugly.proguard.v */
/* loaded from: classes3.dex */
public class C1246v implements AbstractC1087c {

    /* renamed from: a */
    public static C1246v f1655a = new C1246v();

    /* renamed from: b */
    public ConcurrentHashMap<String, DownloadTask> f1656b = new ConcurrentHashMap<>(3);

    /* renamed from: c */
    public ScheduledExecutorService f1657c;

    public C1246v() {
        this.f1657c = null;
        try {
            ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(3, new ThreadFactoryC1244u(this));
            this.f1657c = newScheduledThreadPool;
            if (!newScheduledThreadPool.isShutdown()) {
                return;
            }
            throw new IllegalArgumentException("ScheduledExecutorService is not available!");
        } catch (Exception e) {
            C1199X.m3080b(e);
        }
    }

    @Override // com.tencent.bugly.beta.download.AbstractC1087c
    /* renamed from: a */
    public DownloadTask mo2863a(String str, String str2, String str3, String str4) {
        RunnableC1247w runnableC1247w = null;
        if (TextUtils.isEmpty(str)) {
            C1199X.m3081b("downloadUrl is null!", new Object[0]);
            return null;
        } else if (TextUtils.isEmpty(str2)) {
            C1199X.m3081b("saveDir is null!", new Object[0]);
            return null;
        } else if (this.f1656b.get(str) != null) {
            return this.f1656b.get(str);
        } else {
            ContentValues m2871c = C1234p.f1572a.m2871c(str);
            if (m2871c != null && m2871c.get("_dUrl") != null && m2871c.getAsString("_sFile") != null && m2871c.getAsLong("_sLen") != null && m2871c.getAsLong("_tLen") != null && m2871c.getAsString("_MD5") != null) {
                runnableC1247w = new RunnableC1247w((String) m2871c.get("_dUrl"), m2871c.getAsString("_sFile"), m2871c.getAsLong("_sLen").longValue(), m2871c.getAsLong("_tLen").longValue(), m2871c.getAsString("_MD5"));
                if (m2871c.getAsLong("_DLTIME") != null) {
                    runnableC1247w.f1659l = m2871c.getAsLong("_DLTIME").longValue();
                }
            }
            return runnableC1247w == null ? new RunnableC1247w(str, str2, str3, str4) : runnableC1247w;
        }
    }

    /* renamed from: a */
    public synchronized boolean m2864a(Runnable runnable) {
        ScheduledExecutorService scheduledExecutorService = this.f1657c;
        if (scheduledExecutorService != null && !scheduledExecutorService.isShutdown()) {
            if (runnable == null) {
                C1199X.m3076e("async task = null", new Object[0]);
                return false;
            }
            C1199X.m3076e("task start %s", runnable.getClass().getName());
            this.f1657c.execute(runnable);
            return true;
        }
        C1199X.m3076e("async handler was closed , should not post task!", new Object[0]);
        return false;
    }
}
