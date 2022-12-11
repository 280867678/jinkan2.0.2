package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.annotation.AbstractC0047Px;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$integer;
import com.google.android.material.R$layout;
import com.google.android.material.button.MaterialButton;
import me.tvspark.AbstractC2340lo;
import me.tvspark.AbstractC2377mo;
import me.tvspark.AbstractC2793xn;
import me.tvspark.C1916ao;
import me.tvspark.C1953bo;
import me.tvspark.C1990co;
import me.tvspark.C2229io;
import me.tvspark.C2414no;
import me.tvspark.C2678un;
import me.tvspark.C2756wn;
import me.tvspark.C2867zn;
import me.tvspark.View$OnClickListenerC2044do;
import me.tvspark.View$OnClickListenerC2081eo;
import me.tvspark.View$OnClickListenerC2118fo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public final class MaterialCalendar<S> extends AbstractC2377mo<S> {
    public View Wwwwwwwwwwwwww;
    public View Wwwwwwwwwwwwwww;
    public RecyclerView Wwwwwwwwwwwwwwww;
    public RecyclerView Wwwwwwwwwwwwwwwww;
    public C2756wn Wwwwwwwwwwwwwwwwww;
    public CalendarSelector Wwwwwwwwwwwwwwwwwww;
    @Nullable
    public C2229io Wwwwwwwwwwwwwwwwwwww;
    @Nullable
    public C2678un Wwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public AbstractC2793xn<S> Wwwwwwwwwwwwwwwwwwwwww;
    @StyleRes
    public int Wwwwwwwwwwwwwwwwwwwwwww;
    @VisibleForTesting
    public static final Object Wwwwwwwwwwwww = "MONTHS_VIEW_GROUP_TAG";
    @VisibleForTesting
    public static final Object Wwwwwwwwwwww = "NAVIGATION_PREV_TAG";
    @VisibleForTesting
    public static final Object Wwwwwwwwwww = "NAVIGATION_NEXT_TAG";
    @VisibleForTesting
    public static final Object Wwwwwwwwww = "SELECTOR_TOGGLE_TAG";

    /* loaded from: classes3.dex */
    public enum CalendarSelector {
        DAY,
        YEAR
    }

    /* loaded from: classes3.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends C2414no {
        public final /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, int i, boolean z, int i2) {
            super(context, i, z);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        public void calculateExtraLayoutSpace(@NonNull RecyclerView.State state, @NonNull int[] iArr) {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 0) {
                iArr[0] = MaterialCalendar.this.Wwwwwwwwwwwwwwww.getWidth();
                iArr[1] = MaterialCalendar.this.Wwwwwwwwwwwwwwww.getWidth();
                return;
            }
            iArr[0] = MaterialCalendar.this.Wwwwwwwwwwwwwwww.getHeight();
            iArr[1] = MaterialCalendar.this.Wwwwwwwwwwwwwwww.getHeight();
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AccessibilityDelegateCompat {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(MaterialCalendar materialCalendar) {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setCollectionInfo(null);
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {
        public final /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            MaterialCalendar.this.Wwwwwwwwwwwwwwww.smoothScrollToPosition(this.Wwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    @AbstractC0047Px
    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Context context) {
        return context.getResources().getDimensionPixelSize(R$dimen.mtrl_calendar_day_height);
    }

    @NonNull
    public LinearLayoutManager Wwwwwwwwwwwwwwwwww() {
        return (LinearLayoutManager) this.Wwwwwwwwwwwwwwww.getLayoutManager();
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        this.Wwwwwwwwwwwwwwww.post(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i));
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CalendarSelector calendarSelector) {
        this.Wwwwwwwwwwwwwwwwwww = calendarSelector;
        if (calendarSelector == CalendarSelector.YEAR) {
            this.Wwwwwwwwwwwwwwwww.getLayoutManager().scrollToPosition(((YearGridAdapter) this.Wwwwwwwwwwwwwwwww.getAdapter()).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww));
            this.Wwwwwwwwwwwwwww.setVisibility(0);
            this.Wwwwwwwwwwwwww.setVisibility(8);
        } else if (calendarSelector != CalendarSelector.DAY) {
        } else {
            this.Wwwwwwwwwwwwwww.setVisibility(8);
            this.Wwwwwwwwwwwwww.setVisibility(0);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwww);
        }
    }

    @Override // me.tvspark.AbstractC2377mo
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull AbstractC2340lo<S> abstractC2340lo) {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.add(abstractC2340lo);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.Wwwwwwwwwwwwwwwwwwwwwww = bundle.getInt("THEME_RES_ID_KEY");
        this.Wwwwwwwwwwwwwwwwwwwwww = (AbstractC2793xn) bundle.getParcelable("GRID_SELECTOR_KEY");
        this.Wwwwwwwwwwwwwwwwwwwww = (C2678un) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.Wwwwwwwwwwwwwwwwwwww = (C2229io) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int i;
        int i2;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(mo4928getContext(), this.Wwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwww = new C2756wn(contextThemeWrapper);
        LayoutInflater cloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        C2229io c2229io = this.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (MaterialDatePicker.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(contextThemeWrapper)) {
            i = R$layout.mtrl_calendar_vertical;
            i2 = 1;
        } else {
            i = R$layout.mtrl_calendar_horizontal;
            i2 = 0;
        }
        View inflate = cloneInContext.inflate(i, viewGroup, false);
        GridView gridView = (GridView) inflate.findViewById(R$id.mtrl_calendar_days_of_week);
        ViewCompat.setAccessibilityDelegate(gridView, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this));
        gridView.setAdapter((ListAdapter) new C2867zn());
        gridView.setNumColumns(c2229io.Wwwwwwwwwwwwwwwwwwwww);
        gridView.setEnabled(false);
        this.Wwwwwwwwwwwwwwww = (RecyclerView) inflate.findViewById(R$id.mtrl_calendar_months);
        this.Wwwwwwwwwwwwwwww.setLayoutManager(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mo4928getContext(), i2, false, i2));
        this.Wwwwwwwwwwwwwwww.setTag(Wwwwwwwwwwwww);
        MonthsPagerAdapter monthsPagerAdapter = new MonthsPagerAdapter(contextThemeWrapper, this.Wwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwww, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        this.Wwwwwwwwwwwwwwww.setAdapter(monthsPagerAdapter);
        int integer = contextThemeWrapper.getResources().getInteger(R$integer.mtrl_calendar_year_selector_span);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R$id.mtrl_calendar_year_selector_frame);
        this.Wwwwwwwwwwwwwwwww = recyclerView;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            this.Wwwwwwwwwwwwwwwww.setLayoutManager(new GridLayoutManager((Context) contextThemeWrapper, integer, 1, false));
            this.Wwwwwwwwwwwwwwwww.setAdapter(new YearGridAdapter(this));
            this.Wwwwwwwwwwwwwwwww.addItemDecoration(new C1916ao(this));
        }
        if (inflate.findViewById(R$id.month_navigation_fragment_toggle) != null) {
            MaterialButton materialButton = (MaterialButton) inflate.findViewById(R$id.month_navigation_fragment_toggle);
            materialButton.setTag(Wwwwwwwwww);
            ViewCompat.setAccessibilityDelegate(materialButton, new C1953bo(this));
            MaterialButton materialButton2 = (MaterialButton) inflate.findViewById(R$id.month_navigation_previous);
            materialButton2.setTag(Wwwwwwwwwwww);
            MaterialButton materialButton3 = (MaterialButton) inflate.findViewById(R$id.month_navigation_next);
            materialButton3.setTag(Wwwwwwwwwww);
            this.Wwwwwwwwwwwwwww = inflate.findViewById(R$id.mtrl_calendar_year_selector_frame);
            this.Wwwwwwwwwwwwww = inflate.findViewById(R$id.mtrl_calendar_day_selector_frame);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CalendarSelector.DAY);
            materialButton.setText(this.Wwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(inflate.getContext()));
            this.Wwwwwwwwwwwwwwww.addOnScrollListener(new C1990co(this, monthsPagerAdapter, materialButton));
            materialButton.setOnClickListener(new View$OnClickListenerC2044do(this));
            materialButton3.setOnClickListener(new View$OnClickListenerC2081eo(this, monthsPagerAdapter));
            materialButton2.setOnClickListener(new View$OnClickListenerC2118fo(this, monthsPagerAdapter));
        }
        if (!MaterialDatePicker.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(contextThemeWrapper)) {
            new PagerSnapHelper().attachToRecyclerView(this.Wwwwwwwwwwwwwwww);
        }
        this.Wwwwwwwwwwwwwwww.scrollToPosition(monthsPagerAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwww));
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.Wwwwwwwwwwwwwwwwwwwwwww);
        bundle.putParcelable("GRID_SELECTOR_KEY", this.Wwwwwwwwwwwwwwwwwwwwww);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.Wwwwwwwwwwwwwwwwwwwww);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.Wwwwwwwwwwwwwwwwwwww);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2229io c2229io) {
        RecyclerView recyclerView;
        int i;
        MonthsPagerAdapter monthsPagerAdapter = (MonthsPagerAdapter) this.Wwwwwwwwwwwwwwww.getAdapter();
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = monthsPagerAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2229io);
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 - monthsPagerAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwww);
        boolean z = true;
        boolean z2 = Math.abs(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) > 3;
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 <= 0) {
            z = false;
        }
        this.Wwwwwwwwwwwwwwwwwwww = c2229io;
        if (!z2 || !z) {
            if (z2) {
                recyclerView = this.Wwwwwwwwwwwwwwww;
                i = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 + 3;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        }
        recyclerView = this.Wwwwwwwwwwwwwwww;
        i = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 - 3;
        recyclerView.scrollToPosition(i);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
    }
}
