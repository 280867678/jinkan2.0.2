package com.tencent.bugly.crashreport.biz;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.tencent.bugly.crashreport.common.info.C1140a;
import com.tencent.bugly.proguard.C1199X;
import com.umeng.umcrash.UMCrash;
import java.util.List;

/* renamed from: com.tencent.bugly.crashreport.biz.e */
/* loaded from: classes3.dex */
public class C1137e implements Application.ActivityLifecycleCallbacks {
    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Class cls;
        String m3454b;
        Class cls2;
        String name = activity != null ? activity.getClass().getName() : "unknown";
        cls = C1138f.f995l;
        if (cls != null) {
            cls2 = C1138f.f995l;
            if (!cls2.getName().equals(name)) {
                return;
            }
        }
        C1199X.m3084a(">>> %s onCreated <<<", name);
        C1140a m3394m = C1140a.m3394m();
        if (m3394m != null) {
            List<String> list = m3394m.f1056na;
            m3454b = C1138f.m3454b(name, UMCrash.KEY_ACTIITY_ON_CREATED);
            list.add(m3454b);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Class cls;
        String m3454b;
        Class cls2;
        String name = activity != null ? activity.getClass().getName() : "unknown";
        cls = C1138f.f995l;
        if (cls != null) {
            cls2 = C1138f.f995l;
            if (!cls2.getName().equals(name)) {
                return;
            }
        }
        C1199X.m3084a(">>> %s onDestroyed <<<", name);
        C1140a m3394m = C1140a.m3394m();
        if (m3394m != null) {
            List<String> list = m3394m.f1056na;
            m3454b = C1138f.m3454b(name, UMCrash.KEY_ACTIITY_ON_DESTROYED);
            list.add(m3454b);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Class cls;
        String m3454b;
        Class cls2;
        String name = activity != null ? activity.getClass().getName() : "unknown";
        cls = C1138f.f995l;
        if (cls != null) {
            cls2 = C1138f.f995l;
            if (!cls2.getName().equals(name)) {
                return;
            }
        }
        C1199X.m3084a(">>> %s onPaused <<<", name);
        C1140a m3394m = C1140a.m3394m();
        if (m3394m == null) {
            return;
        }
        List<String> list = m3394m.f1056na;
        m3454b = C1138f.m3454b(name, UMCrash.KEY_ACTIITY_ON_PAUSED);
        list.add(m3454b);
        m3394m.m3418a(false);
        long currentTimeMillis = System.currentTimeMillis();
        m3394m.f1028Y = currentTimeMillis;
        m3394m.f1029Z = currentTimeMillis - m3394m.f1027X;
        long unused = C1138f.f990g = currentTimeMillis;
        if (m3394m.f1029Z < 0) {
            m3394m.f1029Z = 0L;
        }
        if (activity != null) {
            m3394m.f1026W = NotificationCompat.WearableExtender.KEY_BACKGROUND;
        } else {
            m3394m.f1026W = "unknown";
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Class cls;
        String m3454b;
        long j;
        long j2;
        long j3;
        long j4;
        int i;
        int i2;
        long j5;
        long j6;
        boolean z;
        long j7;
        boolean z2;
        Class cls2;
        String name = activity != null ? activity.getClass().getName() : "unknown";
        cls = C1138f.f995l;
        if (cls != null) {
            cls2 = C1138f.f995l;
            if (!cls2.getName().equals(name)) {
                return;
            }
        }
        C1199X.m3084a(">>> %s onResumed <<<", name);
        C1140a m3394m = C1140a.m3394m();
        if (m3394m == null) {
            return;
        }
        List<String> list = m3394m.f1056na;
        m3454b = C1138f.m3454b(name, UMCrash.KEY_ACTIITY_ON_RESUMED);
        list.add(m3454b);
        m3394m.m3418a(true);
        m3394m.f1026W = name;
        long currentTimeMillis = System.currentTimeMillis();
        m3394m.f1027X = currentTimeMillis;
        j = C1138f.f991h;
        m3394m.f1030aa = currentTimeMillis - j;
        long j8 = m3394m.f1027X;
        j2 = C1138f.f990g;
        long j9 = j8 - j2;
        j3 = C1138f.f988e;
        if (j9 <= (j3 > 0 ? C1138f.f988e : C1138f.f987d)) {
            return;
        }
        m3394m.m3424F();
        C1138f.m3443i();
        j4 = C1138f.f987d;
        C1199X.m3078c("[session] launch app one times (app in background %d seconds and over %d seconds)", Long.valueOf(j9 / 1000), Long.valueOf(j4 / 1000));
        i = C1138f.f989f;
        i2 = C1138f.f985b;
        if (i % i2 == 0) {
            C1132c c1132c = C1138f.f992i;
            z2 = C1138f.f996m;
            c1132c.m3479a(4, z2, 0L);
            return;
        }
        C1138f.f992i.m3479a(4, false, 0L);
        long currentTimeMillis2 = System.currentTimeMillis();
        j5 = C1138f.f993j;
        j6 = C1138f.f986c;
        if (currentTimeMillis2 - j5 <= j6) {
            return;
        }
        long unused = C1138f.f993j = currentTimeMillis2;
        C1199X.m3078c("add a timer to upload hot start user info", new Object[0]);
        z = C1138f.f996m;
        if (!z) {
            return;
        }
        C1132c c1132c2 = C1138f.f992i;
        j7 = C1138f.f986c;
        c1132c2.m3478a(j7);
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
