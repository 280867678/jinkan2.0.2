package me.tvspark;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.datepicker.MaterialCalendar;

/* renamed from: me.tvspark.bo */
/* loaded from: classes4.dex */
public class C1953bo extends AccessibilityDelegateCompat {
    public final /* synthetic */ MaterialCalendar Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C1953bo(MaterialCalendar materialCalendar) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = materialCalendar;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        MaterialCalendar materialCalendar;
        int i;
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwww.getVisibility() == 0) {
            materialCalendar = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            i = com.google.android.material.R$string.mtrl_picker_toggle_to_year_selection;
        } else {
            materialCalendar = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            i = com.google.android.material.R$string.mtrl_picker_toggle_to_day_selection;
        }
        accessibilityNodeInfoCompat.setHintText(materialCalendar.getString(i));
    }
}
