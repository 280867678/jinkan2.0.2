package me.tvspark;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.datepicker.MaterialCalendar;
import com.google.android.material.datepicker.MonthsPagerAdapter;

/* renamed from: me.tvspark.co */
/* loaded from: classes4.dex */
public class C1990co extends RecyclerView.OnScrollListener {
    public final /* synthetic */ MaterialCalendar Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ MaterialButton Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ MonthsPagerAdapter Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C1990co(MaterialCalendar materialCalendar, MonthsPagerAdapter monthsPagerAdapter, MaterialButton materialButton) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = materialCalendar;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = monthsPagerAdapter;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = materialButton;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
        if (i == 0) {
            recyclerView.announceForAccessibility(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getText());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
        LinearLayoutManager Wwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww();
        int findFirstVisibleItemPosition = i < 0 ? Wwwwwwwwwwwwwwwwww.findFirstVisibleItemPosition() : Wwwwwwwwwwwwwwwwww.findLastVisibleItemPosition();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(findFirstVisibleItemPosition);
        MaterialButton materialButton = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        MonthsPagerAdapter monthsPagerAdapter = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        materialButton.setText(monthsPagerAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(findFirstVisibleItemPosition).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(monthsPagerAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
    }
}
