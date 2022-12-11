package com.tencent.bugly.beta.p041ui;

import android.view.View;
import android.view.animation.Animation;

/* renamed from: com.tencent.bugly.beta.ui.c  reason: invalid class name */
/* loaded from: classes3.dex */
public class animationAnimation$AnimationListenerC1104c implements Animation.AnimationListener {

    /* renamed from: a */
    public final /* synthetic */ AbstractC1105d f805a;

    public animationAnimation$AnimationListenerC1104c(AbstractC1105d abstractC1105d) {
        this.f805a = abstractC1105d;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        View view = this.f805a.f807c;
        if (view != null) {
            view.setVisibility(8);
        }
        super/*com.tencent.bugly.beta.ui.e*/.mo3595a();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
