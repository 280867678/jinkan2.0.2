package me.tvspark;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import androidx.annotation.NonNull;
import com.google.android.material.datepicker.MaterialCalendar;

/* renamed from: me.tvspark.wn */
/* loaded from: classes4.dex */
public final class C2756wn {
    @NonNull
    public final Paint Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    @NonNull
    public final C2719vn Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @NonNull
    public final C2719vn Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @NonNull
    public final C2719vn Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @NonNull
    public final C2719vn Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @NonNull
    public final C2719vn Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @NonNull
    public final C2719vn Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @NonNull
    public final C2719vn Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2756wn(@NonNull Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, com.google.android.material.R$attr.materialCalendarStyle, MaterialCalendar.class.getCanonicalName()), com.google.android.material.R$styleable.MaterialCalendar);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2719vn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, obtainStyledAttributes.getResourceId(com.google.android.material.R$styleable.MaterialCalendar_dayStyle, 0));
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = C2719vn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, obtainStyledAttributes.getResourceId(com.google.android.material.R$styleable.MaterialCalendar_dayInvalidStyle, 0));
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2719vn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, obtainStyledAttributes.getResourceId(com.google.android.material.R$styleable.MaterialCalendar_daySelectedStyle, 0));
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2719vn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, obtainStyledAttributes.getResourceId(com.google.android.material.R$styleable.MaterialCalendar_dayTodayStyle, 0));
        ColorStateList Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, obtainStyledAttributes, com.google.android.material.R$styleable.MaterialCalendar_rangeFillColor);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2719vn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, obtainStyledAttributes.getResourceId(com.google.android.material.R$styleable.MaterialCalendar_yearStyle, 0));
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2719vn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, obtainStyledAttributes.getResourceId(com.google.android.material.R$styleable.MaterialCalendar_yearSelectedStyle, 0));
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2719vn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, obtainStyledAttributes.getResourceId(com.google.android.material.R$styleable.MaterialCalendar_yearTodayStyle, 0));
        Paint paint = new Paint();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = paint;
        paint.setColor(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getDefaultColor());
        obtainStyledAttributes.recycle();
    }
}
