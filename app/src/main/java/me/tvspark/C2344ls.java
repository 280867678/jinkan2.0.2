package me.tvspark;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.google.android.material.timepicker.ChipTextInputComboView;
import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimePickerView;

/* renamed from: me.tvspark.ls */
/* loaded from: classes4.dex */
public class C2344ls extends GestureDetector.SimpleOnGestureListener {
    public final /* synthetic */ TimePickerView Wwwwwwwwwwwwwwwwwwwwwwww;

    public C2344ls(TimePickerView timePickerView) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = timePickerView;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        boolean onDoubleTap = super.onDoubleTap(motionEvent);
        TimePickerView.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            MaterialTimePicker.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (MaterialTimePicker.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            MaterialTimePicker materialTimePicker = MaterialTimePicker.this;
            boolean z = true;
            materialTimePicker.Wwwwwwwww = 1;
            materialTimePicker.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(materialTimePicker.Wwwwwwwwww);
            C2270js c2270js = MaterialTimePicker.this.Wwwwwwwwwwwwwwww;
            c2270js.Wwwwwwwwwwwwwwwwwwww.setChecked(c2270js.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww == 12);
            ChipTextInputComboView chipTextInputComboView = c2270js.Wwwwwwwwwwwwwwwwwww;
            if (c2270js.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww != 10) {
                z = false;
            }
            chipTextInputComboView.setChecked(z);
        }
        return onDoubleTap;
    }
}
