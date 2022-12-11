package com.p038qq.p039e.ads.nativ.widget;

import android.view.MotionEvent;

/* renamed from: com.qq.e.ads.nativ.widget.ViewStatusListener */
/* loaded from: classes3.dex */
public interface ViewStatusListener {
    void onAttachToWindow();

    void onDetachFromWindow();

    void onDispatchTouchEvent(MotionEvent motionEvent);

    void onWindowFocusChanged(boolean z);

    void onWindowVisibilityChanged(int i);
}
