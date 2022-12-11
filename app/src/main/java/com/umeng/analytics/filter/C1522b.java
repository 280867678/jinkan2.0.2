package com.umeng.analytics.filter;

import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;

/* renamed from: com.umeng.analytics.filter.b */
/* loaded from: classes4.dex */
public class C1522b extends EventList {

    /* renamed from: a */
    public C1524d f2894a;

    /* renamed from: b */
    public Object f2895b = new Object();

    public C1522b(String str, String str2) {
        super(str, str2);
    }

    @Override // com.umeng.analytics.filter.EventList
    public void eventListChange() {
        if (!TextUtils.isEmpty(this.mEventList)) {
            synchronized (this.f2895b) {
                this.f2894a = null;
                this.f2894a = new C1524d(true, this.mEventList);
            }
        }
    }

    @Override // com.umeng.analytics.filter.EventList
    public boolean matchHit(String str) {
        boolean m1411a;
        if (!TextUtils.isEmpty(this.mEventList)) {
            synchronized (this.f2895b) {
                if (this.f2894a == null) {
                    this.f2894a = new C1524d(true, this.mEventList);
                }
                m1411a = this.f2894a.m1411a(str);
            }
            return m1411a;
        }
        return true;
    }

    @Override // com.umeng.analytics.filter.EventList
    public void setMD5ClearFlag(boolean z) {
        AnalyticsConfig.CLEAR_EKV_WL = z;
    }
}
