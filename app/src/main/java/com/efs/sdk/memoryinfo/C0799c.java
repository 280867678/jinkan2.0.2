package com.efs.sdk.memoryinfo;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug;
import android.os.Process;
import androidx.appcompat.widget.ActivityChooserModel;

/* renamed from: com.efs.sdk.memoryinfo.c */
/* loaded from: classes3.dex */
public final class C0799c {
    public final String activity;

    /* renamed from: bg */
    public final String f388bg;

    /* renamed from: n */
    public final long f389n;

    /* renamed from: o */
    public final long f390o;

    /* renamed from: p */
    public final long f391p;

    /* renamed from: q */
    public final long f392q;

    /* renamed from: r */
    public final float f393r;

    /* renamed from: s */
    public final long f394s;

    /* renamed from: t */
    public final long f395t;

    public C0799c(Context context) {
        Debug.MemoryInfo[] processMemoryInfo;
        Debug.MemoryInfo memoryInfo = null;
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            if (activityManager != null && (processMemoryInfo = activityManager.getProcessMemoryInfo(new int[]{Process.myPid()})) != null && processMemoryInfo.length > 0) {
                memoryInfo = processMemoryInfo[0];
            }
        } catch (Throwable unused) {
        }
        if (memoryInfo == null) {
            memoryInfo = new Debug.MemoryInfo();
            Debug.getMemoryInfo(memoryInfo);
        }
        this.f388bg = UMMemoryMonitor.get().isForeground() ? "fg" : "bg";
        this.f389n = memoryInfo.getTotalPss() * 1024;
        this.f390o = memoryInfo.dalvikPss * 1024;
        this.f391p = memoryInfo.nativePss * 1024;
        this.f394s = C0803f.m3974a(memoryInfo) * 1024;
        this.f392q = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long maxMemory = Runtime.getRuntime().maxMemory();
        if (maxMemory != 0) {
            this.f393r = (((float) this.f392q) * 1.0f) / ((float) maxMemory);
        } else {
            this.f393r = 1.0f;
        }
        this.f395t = C0803f.m3975a() * 1024;
        this.activity = UMMemoryMonitor.get().getCurrentActivity();
    }
}
