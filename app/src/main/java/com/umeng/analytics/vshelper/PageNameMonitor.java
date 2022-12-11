package com.umeng.analytics.vshelper;

/* loaded from: classes4.dex */
public class PageNameMonitor implements AbstractC1684a {
    public static String currentActivity;
    public static String currentCustomPage;
    public static Object lock = new Object();

    /* renamed from: com.umeng.analytics.vshelper.PageNameMonitor$a */
    /* loaded from: classes4.dex */
    public static class C1683a {

        /* renamed from: a */
        public static final PageNameMonitor f3706a = new PageNameMonitor();
    }

    public PageNameMonitor() {
    }

    public static PageNameMonitor getInstance() {
        return C1683a.f3706a;
    }

    @Override // com.umeng.analytics.vshelper.AbstractC1684a
    public void activityPause(String str) {
        synchronized (lock) {
            currentActivity = null;
        }
    }

    @Override // com.umeng.analytics.vshelper.AbstractC1684a
    public void activityResume(String str) {
        synchronized (lock) {
            currentActivity = str;
        }
    }

    @Override // com.umeng.analytics.vshelper.AbstractC1684a
    public void customPageBegin(String str) {
        synchronized (lock) {
            currentCustomPage = str;
        }
    }

    @Override // com.umeng.analytics.vshelper.AbstractC1684a
    public void customPageEnd(String str) {
        synchronized (lock) {
            currentCustomPage = null;
        }
    }

    public String getCurrenPageName() {
        synchronized (lock) {
            if (currentCustomPage != null) {
                return currentCustomPage;
            } else if (currentActivity == null) {
                return null;
            } else {
                return currentActivity;
            }
        }
    }
}
