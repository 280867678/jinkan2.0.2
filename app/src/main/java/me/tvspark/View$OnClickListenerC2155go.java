package me.tvspark;

import android.view.View;
import com.google.android.material.datepicker.MaterialDatePicker;

/* renamed from: me.tvspark.go */
/* loaded from: classes4.dex */
public class View$OnClickListenerC2155go implements View.OnClickListener {
    public final /* synthetic */ MaterialDatePicker Wwwwwwwwwwwwwwwwwwwwwwww;

    public View$OnClickListenerC2155go(MaterialDatePicker materialDatePicker) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = materialDatePicker;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MaterialDatePicker materialDatePicker = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        materialDatePicker.Wwwwwwww.setEnabled(materialDatePicker.Wwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww());
        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwww.toggle();
        MaterialDatePicker materialDatePicker2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        materialDatePicker2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(materialDatePicker2.Wwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww();
    }
}
