package com.tencent.bugly.crashreport.crash;

import com.tencent.bugly.proguard.AbstractC1192P;
import com.tencent.bugly.proguard.C1237qa;
import java.util.List;

/* renamed from: com.tencent.bugly.crashreport.crash.d */
/* loaded from: classes3.dex */
public class C1160d implements AbstractC1192P {

    /* renamed from: a */
    public final /* synthetic */ List f1214a;

    /* renamed from: b */
    public final /* synthetic */ C1161e f1215b;

    public C1160d(C1161e c1161e, List list) {
        this.f1215b = c1161e;
        this.f1214a = list;
    }

    @Override // com.tencent.bugly.proguard.AbstractC1192P
    /* renamed from: a */
    public void mo3121a(int i) {
    }

    @Override // com.tencent.bugly.proguard.AbstractC1192P
    /* renamed from: a */
    public void mo3120a(int i, C1237qa c1237qa, long j, long j2, boolean z, String str) {
        this.f1215b.m3289a(z, this.f1214a);
    }
}
