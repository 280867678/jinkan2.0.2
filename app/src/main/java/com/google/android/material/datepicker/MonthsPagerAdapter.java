package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.datepicker.MaterialCalendar;
import me.tvspark.AbstractC2793xn;
import me.tvspark.C2229io;
import me.tvspark.C2266jo;
import me.tvspark.C2303ko;
import me.tvspark.C2678un;

/* loaded from: classes3.dex */
public class MonthsPagerAdapter extends RecyclerView.Adapter<ViewHolder> {
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final MaterialCalendar.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final AbstractC2793xn<?> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @NonNull
    public final C2678un Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Context Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes3.dex */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final MaterialCalendarGridView Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final TextView Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public ViewHolder(@NonNull LinearLayout linearLayout, boolean z) {
            super(linearLayout);
            TextView textView = (TextView) linearLayout.findViewById(R$id.month_title);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = textView;
            ViewCompat.setAccessibilityHeading(textView, true);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (MaterialCalendarGridView) linearLayout.findViewById(R$id.month_grid);
            if (!z) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setVisibility(8);
            }
        }
    }

    public MonthsPagerAdapter(@NonNull Context context, AbstractC2793xn<?> abstractC2793xn, @NonNull C2678un c2678un, MaterialCalendar.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        C2229io c2229io = c2678un.Wwwwwwwwwwwwwwwwwwwwwwww;
        C2229io c2229io2 = c2678un.Wwwwwwwwwwwwwwwwwwwwwww;
        C2229io c2229io3 = c2678un.Wwwwwwwwwwwwwwwwwwwww;
        if (c2229io.compareTo(c2229io3) <= 0) {
            if (c2229io3.compareTo(c2229io2) > 0) {
                throw new IllegalArgumentException("currentPage cannot be after lastPage");
            }
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = MaterialCalendar.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context) * C2266jo.Wwwwwwwwwwwwwwwwwww;
            int dimensionPixelSize = MaterialDatePicker.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context) ? context.getResources().getDimensionPixelSize(R$dimen.mtrl_calendar_day_height) : 0;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = context;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + dimensionPixelSize;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2678un;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2793xn;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            setHasStableIds(true);
            return;
        }
        throw new IllegalArgumentException("firstPage cannot be after currentPage");
    }

    @NonNull
    public C2229io Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i).Wwwwwwwwwwwwwwwwwwwwwwww.getTimeInMillis();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        ViewHolder viewHolder2 = viewHolder;
        C2229io Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
        viewHolder2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setText(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(viewHolder2.itemView.getContext()));
        MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) viewHolder2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.findViewById(R$id.month_grid);
        if (materialCalendarGridView.getAdapter2() != null && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(materialCalendarGridView.getAdapter2().Wwwwwwwwwwwwwwwwwwwwwwww)) {
            materialCalendarGridView.invalidate();
            C2266jo adapter2 = materialCalendarGridView.getAdapter2();
            for (Long l : adapter2.Wwwwwwwwwwwwwwwwwwwwww) {
                adapter2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(materialCalendarGridView, l.longValue());
            }
            AbstractC2793xn<?> abstractC2793xn = adapter2.Wwwwwwwwwwwwwwwwwwwwwww;
            if (abstractC2793xn != null) {
                for (Long l2 : abstractC2793xn.Wwwwwwwwwwwwwwwwwwwwwwww()) {
                    adapter2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(materialCalendarGridView, l2.longValue());
                }
                adapter2.Wwwwwwwwwwwwwwwwwwwwww = adapter2.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww();
            }
        } else {
            C2266jo c2266jo = new C2266jo(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            materialCalendarGridView.setNumColumns(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww);
            materialCalendarGridView.setAdapter((ListAdapter) c2266jo);
        }
        materialCalendarGridView.setOnItemClickListener(new C2303ko(this, materialCalendarGridView));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.mtrl_calendar_month_labeled, viewGroup, false);
        if (MaterialDatePicker.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(viewGroup.getContext())) {
            linearLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
            return new ViewHolder(linearLayout, true);
        }
        return new ViewHolder(linearLayout, false);
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull C2229io c2229io) {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2229io);
    }
}
