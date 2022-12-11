package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Bundle;
import com.tencent.smtt.export.external.DexLoader;

/* loaded from: classes4.dex */
public class TbsVideoCacheTask {
    public static final String KEY_VIDEO_CACHE_PARAM_FILENAME = "filename";
    public static final String KEY_VIDEO_CACHE_PARAM_FOLDERPATH = "folderPath";
    public static final String KEY_VIDEO_CACHE_PARAM_HEADER = "header";
    public static final String KEY_VIDEO_CACHE_PARAM_URL = "url";

    /* renamed from: a */
    public Context f1959a;

    /* renamed from: b */
    public TbsVideoCacheListener f1960b;

    /* renamed from: e */
    public String f1963e;

    /* renamed from: f */
    public String f1964f;

    /* renamed from: c */
    public boolean f1961c = false;

    /* renamed from: d */
    public C1391r f1962d = null;

    /* renamed from: g */
    public Object f1965g = null;

    public TbsVideoCacheTask(Context context, Bundle bundle, TbsVideoCacheListener tbsVideoCacheListener) {
        this.f1959a = null;
        this.f1960b = null;
        this.f1959a = context;
        this.f1960b = tbsVideoCacheListener;
        if (bundle != null) {
            this.f1963e = bundle.getString("taskId");
            this.f1964f = bundle.getString("url");
        }
        m2716a(bundle);
    }

    /* renamed from: a */
    private void m2716a(Bundle bundle) {
        TbsVideoCacheListener tbsVideoCacheListener;
        String str;
        DexLoader dexLoader;
        if (this.f1962d == null) {
            C1363g.m2597a(true).m2599a(this.f1959a, false, false);
            C1414v m2601a = C1363g.m2597a(true).m2601a();
            if (m2601a != null) {
                dexLoader = m2601a.m2302b();
            } else {
                this.f1960b.onVideoDownloadError(this, -1, "init engine error!", null);
                dexLoader = null;
            }
            if (dexLoader != null) {
                this.f1962d = new C1391r(dexLoader);
            } else {
                this.f1960b.onVideoDownloadError(this, -1, "Java dexloader invalid!", null);
            }
        }
        C1391r c1391r = this.f1962d;
        if (c1391r != null) {
            Object m2414a = c1391r.m2414a(this.f1959a, this, bundle);
            this.f1965g = m2414a;
            if (m2414a != null) {
                return;
            }
            tbsVideoCacheListener = this.f1960b;
            str = "init task error!";
        } else {
            tbsVideoCacheListener = this.f1960b;
            if (tbsVideoCacheListener == null) {
                return;
            }
            str = "init error!";
        }
        tbsVideoCacheListener.onVideoDownloadError(this, -1, str, null);
    }

    public long getContentLength() {
        C1391r c1391r = this.f1962d;
        if (c1391r == null || this.f1965g == null) {
            TbsVideoCacheListener tbsVideoCacheListener = this.f1960b;
            if (tbsVideoCacheListener == null) {
                return 0L;
            }
            tbsVideoCacheListener.onVideoDownloadError(this, -1, "getContentLength failed, init uncompleted!", null);
            return 0L;
        }
        return c1391r.m2410d();
    }

    public int getDownloadedSize() {
        C1391r c1391r = this.f1962d;
        if (c1391r == null || this.f1965g == null) {
            TbsVideoCacheListener tbsVideoCacheListener = this.f1960b;
            if (tbsVideoCacheListener == null) {
                return 0;
            }
            tbsVideoCacheListener.onVideoDownloadError(this, -1, "getDownloadedSize failed, init uncompleted!", null);
            return 0;
        }
        return c1391r.m2409e();
    }

    public int getProgress() {
        C1391r c1391r = this.f1962d;
        if (c1391r == null || this.f1965g == null) {
            TbsVideoCacheListener tbsVideoCacheListener = this.f1960b;
            if (tbsVideoCacheListener == null) {
                return 0;
            }
            tbsVideoCacheListener.onVideoDownloadError(this, -1, "getProgress failed, init uncompleted!", null);
            return 0;
        }
        return c1391r.m2408f();
    }

    public String getTaskID() {
        return this.f1963e;
    }

    public String getTaskUrl() {
        return this.f1964f;
    }

    public void pauseTask() {
        C1391r c1391r = this.f1962d;
        if (c1391r != null && this.f1965g != null) {
            c1391r.m2415a();
            return;
        }
        TbsVideoCacheListener tbsVideoCacheListener = this.f1960b;
        if (tbsVideoCacheListener == null) {
            return;
        }
        tbsVideoCacheListener.onVideoDownloadError(this, -1, "pauseTask failed, init uncompleted!", null);
    }

    public void removeTask(boolean z) {
        C1391r c1391r = this.f1962d;
        if (c1391r != null && this.f1965g != null) {
            c1391r.m2413a(z);
            return;
        }
        TbsVideoCacheListener tbsVideoCacheListener = this.f1960b;
        if (tbsVideoCacheListener == null) {
            return;
        }
        tbsVideoCacheListener.onVideoDownloadError(this, -1, "removeTask failed, init uncompleted!", null);
    }

    public void resumeTask() {
        C1391r c1391r = this.f1962d;
        if (c1391r != null && this.f1965g != null) {
            c1391r.m2412b();
            return;
        }
        TbsVideoCacheListener tbsVideoCacheListener = this.f1960b;
        if (tbsVideoCacheListener == null) {
            return;
        }
        tbsVideoCacheListener.onVideoDownloadError(this, -1, "resumeTask failed, init uncompleted!", null);
    }

    public void stopTask() {
        C1391r c1391r = this.f1962d;
        if (c1391r != null && this.f1965g != null) {
            c1391r.m2411c();
            return;
        }
        TbsVideoCacheListener tbsVideoCacheListener = this.f1960b;
        if (tbsVideoCacheListener == null) {
            return;
        }
        tbsVideoCacheListener.onVideoDownloadError(this, -1, "stopTask failed, init uncompleted!", null);
    }
}
