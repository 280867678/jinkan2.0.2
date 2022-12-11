package me.tvspark;

import android.view.MotionEvent;
import android.view.View;
import android.widget.AutoCompleteTextView;
import androidx.annotation.NonNull;

/* renamed from: me.tvspark.tr */
/* loaded from: classes4.dex */
public class View$OnTouchListenerC2645tr implements View.OnTouchListener {
    public final /* synthetic */ C2571rr Wwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ AutoCompleteTextView Wwwwwwwwwwwwwwwwwwwwwwww;

    public View$OnTouchListenerC2645tr(C2571rr c2571rr, AutoCompleteTextView autoCompleteTextView) {
        this.Wwwwwwwwwwwwwwwwwwwwwww = c2571rr;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = autoCompleteTextView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(@NonNull View view, @NonNull MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            if (this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww = false;
            }
            C2571rr.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwww);
        }
        return false;
    }
}
