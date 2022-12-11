package com.google.android.material.timepicker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;
import me.tvspark.C2159gs;
import me.tvspark.C2344ls;
import me.tvspark.View$OnTouchListenerC2381ms;

/* loaded from: classes3.dex */
public class TimePickerView extends ConstraintLayout {
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwww;
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwww;
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwww;
    public final View.OnClickListener Wwwwwwwwwwwwwwwwwww;
    public final MaterialButtonToggleGroup Wwwwwwwwwwwwwwwwwwww;
    public final ClockFaceView Wwwwwwwwwwwwwwwwwwwww;
    public final ClockHandView Wwwwwwwwwwwwwwwwwwwwww;
    public final Chip Wwwwwwwwwwwwwwwwwwwwwww;
    public final Chip Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes3.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i);
    }

    /* loaded from: classes3.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    /* loaded from: classes3.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements MaterialButtonToggleGroup.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // com.google.android.material.button.MaterialButtonToggleGroup.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(MaterialButtonToggleGroup materialButtonToggleGroup, int i, boolean z) {
            int i2 = i == R$id.material_clock_period_pm_button ? 1 : 0;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = TimePickerView.this.Wwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null || !z) {
                return;
            }
            ((C2159gs) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2);
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnClickListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = TimePickerView.this.Wwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((Integer) view.getTag(R$id.selection_type)).intValue());
            }
        }
    }

    public TimePickerView(Context context) {
        this(context, null);
    }

    public TimePickerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TimePickerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Wwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        LayoutInflater.from(context).inflate(R$layout.material_timepicker, this);
        this.Wwwwwwwwwwwwwwwwwwwww = (ClockFaceView) findViewById(R$id.material_clock_face);
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) findViewById(R$id.material_clock_period_toggle);
        this.Wwwwwwwwwwwwwwwwwwww = materialButtonToggleGroup;
        materialButtonToggleGroup.Wwwwwwwwwwwwwwwwwwwww.add(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        this.Wwwwwwwwwwwwwwwwwwwwwwww = (Chip) findViewById(R$id.material_minute_tv);
        this.Wwwwwwwwwwwwwwwwwwwwwww = (Chip) findViewById(R$id.material_hour_tv);
        this.Wwwwwwwwwwwwwwwwwwwwww = (ClockHandView) findViewById(R$id.material_clock_hand);
        View$OnTouchListenerC2381ms view$OnTouchListenerC2381ms = new View$OnTouchListenerC2381ms(this, new GestureDetector(getContext(), new C2344ls(this)));
        this.Wwwwwwwwwwwwwwwwwwwwwwww.setOnTouchListener(view$OnTouchListenerC2381ms);
        this.Wwwwwwwwwwwwwwwwwwwwwww.setOnTouchListener(view$OnTouchListenerC2381ms);
        this.Wwwwwwwwwwwwwwwwwwwwwwww.setTag(R$id.selection_type, 12);
        this.Wwwwwwwwwwwwwwwwwwwwwww.setTag(R$id.selection_type, 10);
        this.Wwwwwwwwwwwwwwwwwwwwwwww.setOnClickListener(this.Wwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwww.setOnClickListener(this.Wwwwwwwwwwwwwwwwwww);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (this.Wwwwwwwwwwwwwwwwwwww.getVisibility() == 0) {
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone(this);
            int i = 1;
            if (ViewCompat.getLayoutDirection(this) == 0) {
                i = 2;
            }
            constraintSet.clear(R$id.material_clock_display, i);
            constraintSet.applyTo(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view, int i) {
        super.onVisibilityChanged(view, i);
        if (view == this && i == 0) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }
}
