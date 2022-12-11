package me.tvspark;

import android.view.View;
import com.google.android.material.datepicker.MaterialCalendar;
import com.google.android.material.datepicker.MonthsPagerAdapter;

/* renamed from: me.tvspark.fo */
/* loaded from: classes4.dex */
public class View$OnClickListenerC2118fo implements View.OnClickListener {
    public final /* synthetic */ MaterialCalendar Wwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ MonthsPagerAdapter Wwwwwwwwwwwwwwwwwwwwwwww;

    public View$OnClickListenerC2118fo(MaterialCalendar materialCalendar, MonthsPagerAdapter monthsPagerAdapter) {
        this.Wwwwwwwwwwwwwwwwwwwwwww = materialCalendar;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = monthsPagerAdapter;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int findLastVisibleItemPosition = this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww().findLastVisibleItemPosition() - 1;
        if (findLastVisibleItemPosition >= 0) {
            this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(findLastVisibleItemPosition));
        }
    }
}
