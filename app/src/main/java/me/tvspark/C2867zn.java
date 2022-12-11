package me.tvspark;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Calendar;
import java.util.Locale;

/* renamed from: me.tvspark.zn */
/* loaded from: classes4.dex */
public class C2867zn extends BaseAdapter {
    public static final int Wwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwww;
    @NonNull
    public final Calendar Wwwwwwwwwwwwwwwwwwwwwwww;

    static {
        Wwwwwwwwwwwwwwwwwwwww = Build.VERSION.SDK_INT >= 26 ? 4 : 1;
    }

    public C2867zn() {
        Calendar Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2488po.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getMaximum(7);
        this.Wwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww.getFirstDayOfWeek();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.Wwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // android.widget.Adapter
    @Nullable
    public Object getItem(int i) {
        int i2 = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (i >= i2) {
            return null;
        }
        int i3 = i + this.Wwwwwwwwwwwwwwwwwwwwww;
        if (i3 > i2) {
            i3 -= i2;
        }
        return Integer.valueOf(i3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    @Nullable
    @SuppressLint({"WrongConstant"})
    public View getView(int i, @Nullable View view, @NonNull ViewGroup viewGroup) {
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(com.google.android.material.R$layout.mtrl_calendar_day_of_week, viewGroup, false);
        }
        Calendar calendar = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        int i2 = i + this.Wwwwwwwwwwwwwwwwwwwwww;
        int i3 = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (i2 > i3) {
            i2 -= i3;
        }
        calendar.set(7, i2);
        textView.setText(this.Wwwwwwwwwwwwwwwwwwwwwwww.getDisplayName(7, Wwwwwwwwwwwwwwwwwwwww, textView.getResources().getConfiguration().locale));
        textView.setContentDescription(String.format(viewGroup.getContext().getString(com.google.android.material.R$string.mtrl_picker_day_of_week_column_header), this.Wwwwwwwwwwwwwwwwwwwwwwww.getDisplayName(7, 2, Locale.getDefault())));
        return textView;
    }
}
