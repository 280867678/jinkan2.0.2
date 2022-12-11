package me.tvspark;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.datepicker.MaterialCalendarGridView;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;

/* renamed from: me.tvspark.jo */
/* loaded from: classes4.dex */
public class C2266jo extends BaseAdapter {
    public static final int Wwwwwwwwwwwwwwwwwww = C2488po.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().getMaximum(4);
    public final C2678un Wwwwwwwwwwwwwwwwwwww;
    public C2756wn Wwwwwwwwwwwwwwwwwwwww;
    public Collection<Long> Wwwwwwwwwwwwwwwwwwwwww;
    public final AbstractC2793xn<?> Wwwwwwwwwwwwwwwwwwwwwww;
    public final C2229io Wwwwwwwwwwwwwwwwwwwwwwww;

    public C2266jo(C2229io c2229io, AbstractC2793xn<?> abstractC2793xn, C2678un c2678un) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = c2229io;
        this.Wwwwwwwwwwwwwwwwwwwwwww = abstractC2793xn;
        this.Wwwwwwwwwwwwwwwwwwww = c2678un;
        this.Wwwwwwwwwwwwwwwwwwwwww = abstractC2793xn.Wwwwwwwwwwwwwwwwwwwwwwww();
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return (this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() + this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww) - 1;
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() + (i - 1);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable TextView textView, long j) {
        C2719vn c2719vn;
        if (textView == null) {
            return;
        }
        boolean z = false;
        if (this.Wwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j)) {
            textView.setEnabled(true);
            Iterator<Long> it = this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (C2488po.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j) == C2488po.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(it.next().longValue())) {
                    z = true;
                    break;
                }
            }
            if (z) {
                c2719vn = this.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            } else {
                int i = (C2488po.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().getTimeInMillis() > j ? 1 : (C2488po.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().getTimeInMillis() == j ? 0 : -1));
                C2756wn c2756wn = this.Wwwwwwwwwwwwwwwwwwwww;
                c2719vn = i == 0 ? c2756wn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : c2756wn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
        } else {
            textView.setEnabled(false);
            c2719vn = this.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        c2719vn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(textView);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() + this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww;
    }

    @Override // android.widget.Adapter
    @Nullable
    /* renamed from: getItem */
    public Long mo4936getItem(int i) {
        if (i < this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() || i > Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            return null;
        }
        C2229io c2229io = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        Calendar Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2488po.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2229io.Wwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.set(5, (i - c2229io.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) + 1);
        return Long.valueOf(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getTimeInMillis());
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i / this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00d9  */
    @Override // android.widget.Adapter
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View getView(int i, @Nullable View view, @NonNull ViewGroup viewGroup) {
        Long mo4936getItem;
        CharSequence format;
        Context context = viewGroup.getContext();
        if (this.Wwwwwwwwwwwwwwwwwwwww == null) {
            this.Wwwwwwwwwwwwwwwwwwwww = new C2756wn(context);
        }
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(com.google.android.material.R$layout.mtrl_calendar_day, viewGroup, false);
        }
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i - Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 0) {
            C2229io c2229io = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < c2229io.Wwwwwwwwwwwwwwwwwwww) {
                int i2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1;
                textView.setTag(c2229io);
                textView.setText(String.format(textView.getResources().getConfiguration().locale, "%d", Integer.valueOf(i2)));
                Calendar Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2488po.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.set(5, i2);
                long timeInMillis = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getTimeInMillis();
                if (this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww == new C2229io(C2488po.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()).Wwwwwwwwwwwwwwwwwwwwww) {
                    Locale locale = Locale.getDefault();
                    format = Build.VERSION.SDK_INT >= 24 ? C2488po.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(locale).format(new Date(timeInMillis)) : C2488po.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(locale).format(new Date(timeInMillis));
                } else {
                    Locale locale2 = Locale.getDefault();
                    format = Build.VERSION.SDK_INT >= 24 ? C2488po.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(locale2).format(new Date(timeInMillis)) : C2488po.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(locale2).format(new Date(timeInMillis));
                }
                textView.setContentDescription(format);
                textView.setVisibility(0);
                textView.setEnabled(true);
                mo4936getItem = mo4936getItem(i);
                if (mo4936getItem != null) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(textView, mo4936getItem.longValue());
                }
                return textView;
            }
        }
        textView.setVisibility(8);
        textView.setEnabled(false);
        mo4936getItem = mo4936getItem(i);
        if (mo4936getItem != null) {
        }
        return textView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(MaterialCalendarGridView materialCalendarGridView, long j) {
        if (C2229io.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j).equals(this.Wwwwwwwwwwwwwwwwwwwwwwww)) {
            Calendar Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2488po.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setTimeInMillis(j);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((TextView) materialCalendarGridView.getChildAt(materialCalendarGridView.getAdapter2().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(5)) - materialCalendarGridView.getFirstVisiblePosition()), j);
        }
    }
}
