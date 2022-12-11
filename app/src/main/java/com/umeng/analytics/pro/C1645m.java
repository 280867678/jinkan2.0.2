package com.umeng.analytics.pro;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.umeng.commonsdk.debug.UMRTLog;
import java.util.ArrayList;

/* renamed from: com.umeng.analytics.pro.m */
/* loaded from: classes4.dex */
public class C1645m implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a */
    public static C1645m f3545a = new C1645m();

    /* renamed from: b */
    public final int f3546b = 3000;

    /* renamed from: c */
    public boolean f3547c = false;

    /* renamed from: d */
    public boolean f3548d = true;

    /* renamed from: e */
    public Handler f3549e = new Handler(Looper.getMainLooper());

    /* renamed from: f */
    public ArrayList<AbstractC1647n> f3550f = new ArrayList<>();

    /* renamed from: g */
    public RunnableC1646a f3551g = new RunnableC1646a();

    /* renamed from: com.umeng.analytics.pro.m$a */
    /* loaded from: classes4.dex */
    public class RunnableC1646a implements Runnable {
        public RunnableC1646a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!C1645m.this.f3547c || !C1645m.this.f3548d) {
                UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> still foreground.");
                return;
            }
            C1645m.this.f3547c = false;
            UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> went background.");
            for (int i = 0; i < C1645m.this.f3550f.size(); i++) {
                ((AbstractC1647n) C1645m.this.f3550f.get(i)).mo989n();
            }
        }
    }

    /* renamed from: a */
    public static C1645m m997a() {
        return f3545a;
    }

    /* renamed from: a */
    public static void m996a(Context context) {
        if (context instanceof Application) {
            ((Application) context).registerActivityLifecycleCallbacks(f3545a);
        }
    }

    /* renamed from: a */
    public synchronized void m993a(AbstractC1647n abstractC1647n) {
        if (abstractC1647n != null) {
            this.f3550f.add(abstractC1647n);
        }
    }

    /* renamed from: b */
    public synchronized void m991b(AbstractC1647n abstractC1647n) {
        if (abstractC1647n != null) {
            for (int i = 0; i < this.f3550f.size(); i++) {
                if (this.f3550f.get(i) == abstractC1647n) {
                    this.f3550f.remove(i);
                }
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        this.f3548d = true;
        RunnableC1646a runnableC1646a = this.f3551g;
        if (runnableC1646a != null) {
            this.f3549e.removeCallbacks(runnableC1646a);
            this.f3549e.postDelayed(this.f3551g, 3000L);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        this.f3548d = false;
        this.f3547c = true;
        RunnableC1646a runnableC1646a = this.f3551g;
        if (runnableC1646a != null) {
            this.f3549e.removeCallbacks(runnableC1646a);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }
}
