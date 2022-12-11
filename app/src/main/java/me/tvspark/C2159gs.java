package me.tvspark;

import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.material.chip.Chip;
import com.google.android.material.timepicker.ClockHandView;
import com.google.android.material.timepicker.TimePickerView;
import java.util.Locale;

/* renamed from: me.tvspark.gs */
/* loaded from: classes4.dex */
public class C2159gs implements ClockHandView.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, TimePickerView.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, TimePickerView.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, ClockHandView.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, AbstractC2196hs {
    public boolean Wwwwwwwwwwwwwwwwwwww = false;
    public float Wwwwwwwwwwwwwwwwwwwww;
    public float Wwwwwwwwwwwwwwwwwwwwww;
    public C2122fs Wwwwwwwwwwwwwwwwwwwwwww;
    public TimePickerView Wwwwwwwwwwwwwwwwwwwwwwww;
    public static final String[] Wwwwwwwwwwwwwwwwwww = {"12", "1", ExifInterface.GPS_MEASUREMENT_2D, ExifInterface.GPS_MEASUREMENT_3D, "4", "5", "6", "7", "8", "9", "10", "11"};
    public static final String[] Wwwwwwwwwwwwwwwwww = {"00", ExifInterface.GPS_MEASUREMENT_2D, "4", "6", "8", "10", "12", "14", "16", "18", "20", "22"};
    public static final String[] Wwwwwwwwwwwwwwwww = {"00", "5", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"};

    public C2159gs(TimePickerView timePickerView, C2122fs c2122fs) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = timePickerView;
        this.Wwwwwwwwwwwwwwwwwwwwwww = c2122fs;
        if (c2122fs.Wwwwwwwwwwwwwwwwwwwwww == 0) {
            timePickerView.Wwwwwwwwwwwwwwwwwwww.setVisibility(0);
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww.add(this);
        TimePickerView timePickerView2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        timePickerView2.Wwwwwwwwwwwwwwwww = this;
        timePickerView2.Wwwwwwwwwwwwwwwwww = this;
        timePickerView2.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwww = this;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwww, "%d");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwww, "%d");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwww, "%02d");
        invalidate();
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        TimePickerView timePickerView = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        C2122fs c2122fs = this.Wwwwwwwwwwwwwwwwwwwwwww;
        int i = c2122fs.Wwwwwwwwwwwwwwwwww;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2122fs.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        int i2 = this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww;
        timePickerView.Wwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i == 1 ? com.google.android.material.R$id.material_clock_period_pm_button : com.google.android.material.R$id.material_clock_period_am_button);
        Locale locale = timePickerView.getResources().getConfiguration().locale;
        String format = String.format(locale, "%02d", Integer.valueOf(i2));
        String format2 = String.format(locale, "%02d", Integer.valueOf(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
        timePickerView.Wwwwwwwwwwwwwwwwwwwwwwww.setText(format);
        timePickerView.Wwwwwwwwwwwwwwwwwwwwwww.setText(format2);
    }

    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww == 1 ? 15 : 30;
    }

    @Override // com.google.android.material.timepicker.ClockHandView.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f, boolean z) {
        if (this.Wwwwwwwwwwwwwwwwwwww) {
            return;
        }
        C2122fs c2122fs = this.Wwwwwwwwwwwwwwwwwwwwwww;
        int i = c2122fs.Wwwwwwwwwwwwwwwwwwwww;
        int i2 = c2122fs.Wwwwwwwwwwwwwwwwwwww;
        int round = Math.round(f);
        C2122fs c2122fs2 = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (c2122fs2.Wwwwwwwwwwwwwwwwwww == 12) {
            int i3 = ((round + 3) / 6) % 60;
            c2122fs2.Wwwwwwwwwwwwwwwwwwww = i3;
            this.Wwwwwwwwwwwwwwwwwwwwww = (float) Math.floor(i3 * 6);
        } else {
            this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((round + (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() / 2)) / Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            this.Wwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() * this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        if (z) {
            return;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        C2122fs c2122fs3 = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (c2122fs3.Wwwwwwwwwwwwwwwwwwww == i2 && c2122fs3.Wwwwwwwwwwwwwwwwwwwww == i) {
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwww.performHapticFeedback(4);
    }

    @Override // com.google.android.material.timepicker.TimePickerView.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, true);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String[] strArr, String str) {
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = C2122fs.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww.getResources(), strArr[i], str);
        }
    }

    @Override // me.tvspark.AbstractC2196hs
    public void hide() {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.setVisibility(8);
    }

    @Override // me.tvspark.AbstractC2196hs
    public void invalidate() {
        this.Wwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() * this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        C2122fs c2122fs = this.Wwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwww = c2122fs.Wwwwwwwwwwwwwwwwwwww * 6;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2122fs.Wwwwwwwwwwwwwwwwwww, false);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.AbstractC2196hs
    public void show() {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.setVisibility(0);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, boolean z) {
        String[] strArr;
        boolean z2 = false;
        boolean z3 = i == 12;
        TimePickerView timePickerView = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        timePickerView.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww = z3;
        C2122fs c2122fs = this.Wwwwwwwwwwwwwwwwwwwwwww;
        c2122fs.Wwwwwwwwwwwwwwwwwww = i;
        if (z3) {
            strArr = Wwwwwwwwwwwwwwwww;
        } else {
            strArr = c2122fs.Wwwwwwwwwwwwwwwwwwwwww == 1 ? Wwwwwwwwwwwwwwwwww : Wwwwwwwwwwwwwwwwwww;
        }
        timePickerView.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(strArr, z3 ? com.google.android.material.R$string.material_minute_suffix : com.google.android.material.R$string.material_hour_suffix);
        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z3 ? this.Wwwwwwwwwwwwwwwwwwwwww : this.Wwwwwwwwwwwwwwwwwwwww, z);
        TimePickerView timePickerView2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        timePickerView2.Wwwwwwwwwwwwwwwwwwwwwwww.setChecked(i == 12);
        Chip chip = timePickerView2.Wwwwwwwwwwwwwwwwwwwwwww;
        if (i == 10) {
            z2 = true;
        }
        chip.setChecked(z2);
        ViewCompat.setAccessibilityDelegate(this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww, new C1994cs(this.Wwwwwwwwwwwwwwwwwwwwwwww.getContext(), com.google.android.material.R$string.material_hour_selection));
        ViewCompat.setAccessibilityDelegate(this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww, new C1994cs(this.Wwwwwwwwwwwwwwwwwwwwwwww.getContext(), com.google.android.material.R$string.material_minute_selection));
    }
}
