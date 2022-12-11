package me.tvspark;

import android.view.View;
import com.google.android.material.datepicker.MaterialCalendar;
import com.google.android.material.datepicker.MonthsPagerAdapter;

/* renamed from: me.tvspark.eo */
/* loaded from: classes4.dex */
public class View$OnClickListenerC2081eo implements View.OnClickListener {
    public final /* synthetic */ MaterialCalendar Wwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ MonthsPagerAdapter Wwwwwwwwwwwwwwwwwwwwwwww;

    public View$OnClickListenerC2081eo(MaterialCalendar materialCalendar, MonthsPagerAdapter monthsPagerAdapter) {
        this.Wwwwwwwwwwwwwwwwwwwwwww = materialCalendar;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = monthsPagerAdapter;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int findFirstVisibleItemPosition = this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww().findFirstVisibleItemPosition() + 1;
        if (findFirstVisibleItemPosition < this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwww.getAdapter().getItemCount()) {
            this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(findFirstVisibleItemPosition));
        }
    }
}
