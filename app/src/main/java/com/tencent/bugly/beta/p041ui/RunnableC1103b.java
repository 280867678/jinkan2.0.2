package com.tencent.bugly.beta.p041ui;

import android.view.View;
import android.view.animation.Animation;

/* renamed from: com.tencent.bugly.beta.ui.b */
/* loaded from: classes3.dex */
public class RunnableC1103b implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ Animation f803a;

    /* renamed from: b */
    public final /* synthetic */ AbstractC1105d f804b;

    public RunnableC1103b(AbstractC1105d abstractC1105d, Animation animation) {
        this.f804b = abstractC1105d;
        this.f803a = animation;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view = this.f804b.f807c;
        if (view != null) {
            view.startAnimation(this.f803a);
        }
    }
}
