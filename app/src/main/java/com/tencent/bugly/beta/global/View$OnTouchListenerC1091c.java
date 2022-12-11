package com.tencent.bugly.beta.global;

import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.bugly.proguard.C1199X;

/* renamed from: com.tencent.bugly.beta.global.c */
/* loaded from: classes3.dex */
public class View$OnTouchListenerC1091c implements View.OnTouchListener {

    /* renamed from: a */
    public final int f732a;

    /* renamed from: b */
    public final Object[] f733b;

    public View$OnTouchListenerC1091c(int i, Object... objArr) {
        this.f732a = i;
        this.f733b = objArr;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        try {
        } catch (Exception e) {
            if (!C1199X.m3083a(e)) {
                e.printStackTrace();
            }
        }
        if (this.f732a != 1) {
            return false;
        }
        int action = motionEvent.getAction();
        view.setBackgroundDrawable((action == 0 || action == 2) ? (Drawable) this.f733b[0] : (Drawable) this.f733b[1]);
        return false;
    }
}
