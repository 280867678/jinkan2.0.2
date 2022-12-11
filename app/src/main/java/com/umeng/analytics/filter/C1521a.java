package com.umeng.analytics.filter;

import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;

/* renamed from: com.umeng.analytics.filter.a */
/* loaded from: classes4.dex */
public class C1521a extends EventList {

    /* renamed from: a */
    public C1524d f2892a;

    /* renamed from: b */
    public Object f2893b = new Object();

    public C1521a(String str, String str2) {
        super(str, str2);
    }

    @Override // com.umeng.analytics.filter.EventList
    public void eventListChange() {
        if (!TextUtils.isEmpty(this.mEventList)) {
            synchronized (this.f2893b) {
                this.f2892a = null;
                this.f2892a = new C1524d(false, this.mEventList);
            }
        }
    }

    @Override // com.umeng.analytics.filter.EventList
    public boolean matchHit(String str) {
        boolean m1411a;
        if (!TextUtils.isEmpty(this.mEventList)) {
            synchronized (this.f2893b) {
                if (this.f2892a == null) {
                    this.f2892a = new C1524d(false, this.mEventList);
                }
                m1411a = this.f2892a.m1411a(str);
            }
            return m1411a;
        }
        return false;
    }

    @Override // com.umeng.analytics.filter.EventList
    public void setMD5ClearFlag(boolean z) {
        AnalyticsConfig.CLEAR_EKV_BL = z;
    }
}
