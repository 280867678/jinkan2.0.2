package me.tvspark;

import android.view.View;
import com.google.android.material.datepicker.MaterialCalendar;
import com.google.android.material.datepicker.YearGridAdapter;

/* renamed from: me.tvspark.qo */
/* loaded from: classes4.dex */
public class View$OnClickListenerC2531qo implements View.OnClickListener {
    public final /* synthetic */ YearGridAdapter Wwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwwww;

    public View$OnClickListenerC2531qo(YearGridAdapter yearGridAdapter, int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwww = yearGridAdapter;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C2229io Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2229io.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww);
        C2678un c2678un = this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww;
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.compareTo(c2678un.Wwwwwwwwwwwwwwwwwwwwwwww) < 0) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2678un.Wwwwwwwwwwwwwwwwwwwwwwww;
        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.compareTo(c2678un.Wwwwwwwwwwwwwwwwwwwwwww) > 0) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2678un.Wwwwwwwwwwwwwwwwwwwwwww;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(MaterialCalendar.CalendarSelector.DAY);
    }
}
