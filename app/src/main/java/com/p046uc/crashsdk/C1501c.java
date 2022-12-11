package com.p046uc.crashsdk;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.p046uc.crashsdk.p047a.C1491a;
import java.util.Map;
import java.util.WeakHashMap;

/* renamed from: com.uc.crashsdk.c */
/* loaded from: classes4.dex */
public final class C1501c implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a */
    public boolean f2737a = false;

    /* renamed from: b */
    public boolean f2738b = false;

    /* renamed from: a */
    private void m1723a(int i) {
        WeakHashMap weakHashMap;
        WeakHashMap weakHashMap2;
        if (C1503e.m1583u()) {
            C1491a.m1925a("crashsdk", "[LifeCycle] ignore state change while crashing");
            return;
        }
        boolean z = true;
        boolean z2 = 1 == i;
        if (!z2) {
            weakHashMap2 = C1500b.f2702ab;
            for (Map.Entry entry : weakHashMap2.entrySet()) {
                Object value = entry.getValue();
                if (value != null && ((Integer) value).intValue() == 1) {
                    break;
                }
            }
        }
        z = z2;
        if (this.f2737a != z) {
            C1500b.m1753b(z);
            this.f2737a = z;
        }
        weakHashMap = C1500b.f2702ab;
        boolean isEmpty = weakHashMap.isEmpty();
        if (this.f2738b == isEmpty) {
            return;
        }
        if (isEmpty) {
            C1500b.m1727w();
        }
        this.f2738b = isEmpty;
    }

    /* renamed from: a */
    private void m1722a(Activity activity, int i) {
        WeakHashMap weakHashMap;
        WeakHashMap weakHashMap2;
        String unused = C1500b.f2704ad = 1 == i ? activity.getComponentName().flattenToShortString() : "";
        C1500b.m1793D();
        if (C1509g.m1527J()) {
            boolean unused2 = C1500b.f2703ac = true;
            weakHashMap = C1500b.f2702ab;
            synchronized (weakHashMap) {
                weakHashMap2 = C1500b.f2702ab;
                weakHashMap2.put(activity, Integer.valueOf(i));
                m1723a(i);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        m1722a(activity, 2);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        WeakHashMap weakHashMap;
        WeakHashMap weakHashMap2;
        if (C1509g.m1527J()) {
            boolean unused = C1500b.f2703ac = true;
            weakHashMap = C1500b.f2702ab;
            synchronized (weakHashMap) {
                weakHashMap2 = C1500b.f2702ab;
                weakHashMap2.remove(activity);
                m1723a(2);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        m1722a(activity, 2);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        m1722a(activity, 1);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        m1722a(activity, 1);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        m1722a(activity, 2);
    }
}
