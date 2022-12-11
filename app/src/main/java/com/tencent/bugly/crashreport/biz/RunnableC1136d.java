package com.tencent.bugly.crashreport.biz;

import android.content.Context;
import com.tencent.bugly.BuglyStrategy;

/* renamed from: com.tencent.bugly.crashreport.biz.d */
/* loaded from: classes3.dex */
public class RunnableC1136d implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ Context f982a;

    /* renamed from: b */
    public final /* synthetic */ BuglyStrategy f983b;

    public RunnableC1136d(Context context, BuglyStrategy buglyStrategy) {
        this.f982a = context;
        this.f983b = buglyStrategy;
    }

    @Override // java.lang.Runnable
    public void run() {
        C1138f.m3450c(this.f982a, this.f983b);
    }
}
