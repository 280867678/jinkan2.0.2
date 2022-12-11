package com.p038qq.p039e.ads.nativ;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.p038qq.p039e.comm.util.GDTLogger;

/* renamed from: com.qq.e.ads.nativ.MediaView */
/* loaded from: classes3.dex */
public final class MediaView extends FrameLayout {
    public MediaView(Context context) {
        super(context);
    }

    public MediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MediaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.view.ViewGroup, android.view.View
    @SuppressLint({"NewApi"})
    public void onAttachedToWindow() {
        GDTLogger.m3647d("onAttachedToWindow");
        super.onAttachedToWindow();
        if (!isHardwareAccelerated()) {
            GDTLogger.m3643w("硬件加速未开启");
        }
    }
}
