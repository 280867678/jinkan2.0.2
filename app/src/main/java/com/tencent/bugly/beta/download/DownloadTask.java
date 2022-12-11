package com.tencent.bugly.beta.download;

import java.io.File;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public abstract class DownloadTask {
    public static final int COMPLETE = 1;
    public static final int DELETED = 4;
    public static final int DOWNLOADING = 2;
    public static final int FAILED = 5;
    public static final int INIT = 0;
    public static final int PAUSED = 3;
    public static final int TYPE_HOTFIX = 2;
    public static final int TYPE_UPGRADE = 1;

    /* renamed from: a */
    public String f708a;

    /* renamed from: b */
    public String f709b;

    /* renamed from: c */
    public String f710c;

    /* renamed from: e */
    public long f712e;

    /* renamed from: f */
    public long f713f;

    /* renamed from: h */
    public String f715h;

    /* renamed from: d */
    public List<DownloadListener> f711d = new CopyOnWriteArrayList();

    /* renamed from: g */
    public boolean f714g = true;

    /* renamed from: i */
    public int f716i = 0;

    /* renamed from: j */
    public int f717j = 1;

    public DownloadTask(String str, String str2, String str3, String str4) {
        this.f715h = "";
        this.f708a = str;
        this.f709b = str2;
        this.f710c = str3;
        this.f715h = str4;
    }

    public void addListener(DownloadListener downloadListener) {
        if (downloadListener == null || this.f711d.contains(downloadListener)) {
            return;
        }
        this.f711d.add(downloadListener);
    }

    public abstract void delete(boolean z);

    public abstract void download();

    public abstract long getCostTime();

    public int getDownloadType() {
        return this.f717j;
    }

    public String getDownloadUrl() {
        return this.f708a;
    }

    public String getMD5() {
        return this.f715h;
    }

    public abstract File getSaveFile();

    public long getSavedLength() {
        return this.f712e;
    }

    public abstract int getStatus();

    public long getTotalLength() {
        return this.f713f;
    }

    public boolean isNeededNotify() {
        return this.f714g;
    }

    public boolean removeListener(DownloadListener downloadListener) {
        return downloadListener != null && this.f711d.remove(downloadListener);
    }

    public void setDownloadType(int i) {
        this.f717j = i;
    }

    public void setNeededNotify(boolean z) {
        this.f714g = z;
    }

    public void setSavedLength(long j) {
        this.f712e = j;
    }

    public void setTotalLength(long j) {
        this.f713f = j;
    }

    public abstract void stop();
}
