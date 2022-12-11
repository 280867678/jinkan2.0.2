package com.tencent.bugly.crashreport.biz;

import com.tencent.bugly.proguard.AbstractC1192P;
import com.tencent.bugly.proguard.C1199X;
import com.tencent.bugly.proguard.C1237qa;
import java.util.List;

/* renamed from: com.tencent.bugly.crashreport.biz.a */
/* loaded from: classes3.dex */
public class C1130a implements AbstractC1192P {

    /* renamed from: a */
    public final /* synthetic */ List f969a;

    /* renamed from: b */
    public final /* synthetic */ C1132c f970b;

    public C1130a(C1132c c1132c, List list) {
        this.f970b = c1132c;
        this.f969a = list;
    }

    @Override // com.tencent.bugly.proguard.AbstractC1192P
    /* renamed from: a */
    public void mo3121a(int i) {
    }

    @Override // com.tencent.bugly.proguard.AbstractC1192P
    /* renamed from: a */
    public void mo3120a(int i, C1237qa c1237qa, long j, long j2, boolean z, String str) {
        if (z) {
            C1199X.m3084a("[UserInfo] Successfully uploaded user info.", new Object[0]);
            long currentTimeMillis = System.currentTimeMillis();
            for (UserInfoBean userInfoBean : this.f969a) {
                userInfoBean.f955f = currentTimeMillis;
                this.f970b.m3474a(userInfoBean, true);
            }
        }
    }
}
