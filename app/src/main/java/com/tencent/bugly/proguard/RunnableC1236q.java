package com.tencent.bugly.proguard;

import com.tencent.bugly.beta.global.C1093e;

/* renamed from: com.tencent.bugly.proguard.q */
/* loaded from: classes3.dex */
public class RunnableC1236q implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ C1248x f1599a;

    /* renamed from: b */
    public final /* synthetic */ C1238r f1600b;

    public RunnableC1236q(C1238r c1238r, C1248x c1248x) {
        this.f1600b = c1238r;
        this.f1599a = c1248x;
    }

    @Override // java.lang.Runnable
    public void run() {
        C1093e.f737b.f762Y.onPatchReceived(this.f1599a.m2858a());
    }
}
