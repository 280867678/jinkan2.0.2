package com.google.android.material.datepicker;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import java.util.Calendar;
import java.util.Locale;
import me.tvspark.C2488po;
import me.tvspark.C2719vn;
import me.tvspark.C2756wn;
import me.tvspark.View$OnClickListenerC2531qo;

/* loaded from: classes3.dex */
public class YearGridAdapter extends RecyclerView.Adapter<ViewHolder> {
    public final MaterialCalendar<?> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes3.dex */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public ViewHolder(TextView textView) {
            super(textView);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = textView;
        }
    }

    public YearGridAdapter(MaterialCalendar<?> materialCalendar) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = materialCalendar;
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        return i - this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        ViewHolder viewHolder2 = viewHolder;
        int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww + i;
        String string = viewHolder2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getContext().getString(R$string.mtrl_picker_navigate_to_year_description);
        viewHolder2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setText(String.format(Locale.getDefault(), "%d", Integer.valueOf(i2)));
        viewHolder2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setContentDescription(String.format(string, Integer.valueOf(i2)));
        C2756wn c2756wn = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww;
        Calendar Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2488po.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        C2719vn c2719vn = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(1) == i2 ? c2756wn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww : c2756wn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        for (Long l : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww()) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setTimeInMillis(l.longValue());
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(1) == i2) {
                c2719vn = c2756wn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
        }
        c2719vn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(viewHolder2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        viewHolder2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setOnClickListener(new View$OnClickListenerC2531qo(this, i2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.mtrl_calendar_year, viewGroup, false));
    }
}
