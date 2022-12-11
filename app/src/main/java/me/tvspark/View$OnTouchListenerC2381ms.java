package me.tvspark;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import com.google.android.material.timepicker.TimePickerView;

/* renamed from: me.tvspark.ms */
/* loaded from: classes4.dex */
public class View$OnTouchListenerC2381ms implements View.OnTouchListener {
    public final /* synthetic */ GestureDetector Wwwwwwwwwwwwwwwwwwwwwwww;

    public View$OnTouchListenerC2381ms(TimePickerView timePickerView, GestureDetector gestureDetector) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = gestureDetector;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (((Checkable) view).isChecked()) {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww.onTouchEvent(motionEvent);
        }
        return false;
    }
}
