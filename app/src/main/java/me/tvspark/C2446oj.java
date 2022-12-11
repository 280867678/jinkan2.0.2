package me.tvspark;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.WebView;

/* renamed from: me.tvspark.oj */
/* loaded from: classes4.dex */
public class C2446oj extends WebView {
    public C2446oj(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return false;
    }

    @Override // android.view.View
    public boolean performClick() {
        super.performClick();
        return false;
    }
}
