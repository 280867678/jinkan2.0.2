package me.tvspark;

import android.view.View;
import android.widget.AdapterView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.datepicker.MaterialCalendar;
import com.google.android.material.datepicker.MaterialCalendarGridView;
import com.google.android.material.datepicker.MonthsPagerAdapter;
import java.util.Iterator;

/* renamed from: me.tvspark.ko */
/* loaded from: classes4.dex */
public class C2303ko implements AdapterView.OnItemClickListener {
    public final /* synthetic */ MonthsPagerAdapter Wwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ MaterialCalendarGridView Wwwwwwwwwwwwwwwwwwwwwwww;

    public C2303ko(MonthsPagerAdapter monthsPagerAdapter, MaterialCalendarGridView materialCalendarGridView) {
        this.Wwwwwwwwwwwwwwwwwwwwwww = monthsPagerAdapter;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = materialCalendarGridView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        C2266jo adapter2 = this.Wwwwwwwwwwwwwwwwwwwwwwww.getAdapter2();
        if (i >= adapter2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() && i <= adapter2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            MaterialCalendar.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            long longValue = this.Wwwwwwwwwwwwwwwwwwwwwwww.getAdapter2().mo4936getItem(i).longValue();
            MaterialCalendar.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (MaterialCalendar.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (!MaterialCalendar.this.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(longValue)) {
                return;
            }
            MaterialCalendar.this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(longValue);
            Iterator it = MaterialCalendar.this.Wwwwwwwwwwwwwwwwwwwwwwww.iterator();
            while (it.hasNext()) {
                ((AbstractC2340lo) it.next()).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(MaterialCalendar.this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww());
            }
            MaterialCalendar.this.Wwwwwwwwwwwwwwww.getAdapter().notifyDataSetChanged();
            RecyclerView recyclerView = MaterialCalendar.this.Wwwwwwwwwwwwwwwww;
            if (recyclerView == null) {
                return;
            }
            recyclerView.getAdapter().notifyDataSetChanged();
        }
    }
}
