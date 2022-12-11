package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.commonsdk.statistics.idtracking.Envelope;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;

/* renamed from: com.umeng.analytics.pro.x */
/* loaded from: classes4.dex */
public class C1668x implements AbstractC1667w {

    /* renamed from: a */
    public long f3658a = AnalyticsConfig.kContinueSessionMillis;

    @Override // com.umeng.analytics.pro.AbstractC1667w
    /* renamed from: a */
    public long mo875a() {
        return this.f3658a;
    }

    @Override // com.umeng.analytics.pro.AbstractC1667w
    /* renamed from: a */
    public String mo872a(Context context) {
        String appkey = UMUtils.getAppkey(context);
        long currentTimeMillis = System.currentTimeMillis();
        if (appkey != null) {
            return UMUtils.MD5(currentTimeMillis + appkey + Envelope.dummyID2);
        }
        throw new RuntimeException("Appkey is null or empty, Please check!");
    }

    @Override // com.umeng.analytics.pro.AbstractC1667w
    /* renamed from: a */
    public void mo874a(long j) {
        this.f3658a = j;
    }

    @Override // com.umeng.analytics.pro.AbstractC1667w
    /* renamed from: a */
    public void mo871a(Context context, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            SharedPreferences.Editor edit = PreferenceWrapper.getDefault(context).edit();
            edit.putString("session_id", str);
            edit.putLong(C1663u.f3639b, 0L);
            edit.putLong(C1663u.f3642e, currentTimeMillis);
            edit.putLong(C1663u.f3643f, 0L);
            edit.commit();
        } catch (Exception unused) {
        }
    }

    @Override // com.umeng.analytics.pro.AbstractC1667w
    /* renamed from: a */
    public boolean mo873a(long j, long j2) {
        long currentTimeMillis = System.currentTimeMillis();
        return (j == 0 || currentTimeMillis - j >= this.f3658a) && j2 > 0 && currentTimeMillis - j2 > this.f3658a;
    }
}
