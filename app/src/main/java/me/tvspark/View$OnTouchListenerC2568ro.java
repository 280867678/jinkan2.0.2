package me.tvspark;

import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: me.tvspark.ro */
/* loaded from: classes4.dex */
public class View$OnTouchListenerC2568ro implements View.OnTouchListener {
    public final int Wwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwww;
    @NonNull
    public final Dialog Wwwwwwwwwwwwwwwwwwwwwwww;

    public View$OnTouchListenerC2568ro(@NonNull Dialog dialog, @NonNull Rect rect) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = dialog;
        this.Wwwwwwwwwwwwwwwwwwwwwww = rect.left;
        this.Wwwwwwwwwwwwwwwwwwwwww = rect.top;
        this.Wwwwwwwwwwwwwwwwwwwww = ViewConfiguration.get(dialog.getContext()).getScaledWindowTouchSlop();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(@NonNull View view, @NonNull MotionEvent motionEvent) {
        View findViewById = view.findViewById(16908290);
        int left = findViewById.getLeft() + this.Wwwwwwwwwwwwwwwwwwwwwww;
        int width = findViewById.getWidth() + left;
        int top = findViewById.getTop() + this.Wwwwwwwwwwwwwwwwwwwwww;
        if (new RectF(left, top, width, findViewById.getHeight() + top).contains(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        if (motionEvent.getAction() == 1) {
            obtain.setAction(4);
        }
        if (Build.VERSION.SDK_INT < 28) {
            obtain.setAction(0);
            int i = this.Wwwwwwwwwwwwwwwwwwwww;
            obtain.setLocation((-i) - 1, (-i) - 1);
        }
        view.performClick();
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.onTouchEvent(obtain);
    }
}
