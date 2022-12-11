package com.lzf.easyfloat.interfaces;

import android.view.MotionEvent;
import android.view.View;
import me.tvspark.ef0;

@ef0
/* loaded from: classes3.dex */
public interface OnFloatCallbacks {
    void createdResult(boolean z, String str, View view);

    void dismiss();

    void drag(View view, MotionEvent motionEvent);

    void dragEnd(View view);

    void hide(View view);

    void show(View view);

    void touchEvent(View view, MotionEvent motionEvent);
}
