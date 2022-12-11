package me.tvspark;

import android.view.View;
import com.google.android.material.datepicker.MaterialCalendar;

/* renamed from: me.tvspark.do */
/* loaded from: classes4.dex */
public class View$OnClickListenerC2044do implements View.OnClickListener {
    public final /* synthetic */ MaterialCalendar Wwwwwwwwwwwwwwwwwwwwwwww;

    public View$OnClickListenerC2044do(MaterialCalendar materialCalendar) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = materialCalendar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MaterialCalendar.CalendarSelector calendarSelector;
        MaterialCalendar materialCalendar = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        MaterialCalendar.CalendarSelector calendarSelector2 = materialCalendar.Wwwwwwwwwwwwwwwwwww;
        if (calendarSelector2 == MaterialCalendar.CalendarSelector.YEAR) {
            calendarSelector = MaterialCalendar.CalendarSelector.DAY;
        } else if (calendarSelector2 != MaterialCalendar.CalendarSelector.DAY) {
            return;
        } else {
            calendarSelector = MaterialCalendar.CalendarSelector.YEAR;
        }
        materialCalendar.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(calendarSelector);
    }
}
