package me.tvspark;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import com.google.android.material.shape.MaterialShapeDrawable;

/* renamed from: me.tvspark.vn */
/* loaded from: classes4.dex */
public final class C2719vn {
    public final C2416nq Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final ColorStateList Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final ColorStateList Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final ColorStateList Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @NonNull
    public final Rect Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2719vn(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i, C2416nq c2416nq, @NonNull Rect rect) {
        Preconditions.checkArgumentNonnegative(rect.left);
        Preconditions.checkArgumentNonnegative(rect.top);
        Preconditions.checkArgumentNonnegative(rect.right);
        Preconditions.checkArgumentNonnegative(rect.bottom);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = rect;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = colorStateList2;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = colorStateList;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = colorStateList3;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2416nq;
    }

    @NonNull
    public static C2719vn Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Context context, @StyleRes int i) {
        Preconditions.checkArgument(i != 0, "Cannot create a CalendarItemStyle with a styleResId of 0");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, com.google.android.material.R$styleable.MaterialCalendarItem);
        Rect rect = new Rect(obtainStyledAttributes.getDimensionPixelOffset(com.google.android.material.R$styleable.MaterialCalendarItem_android_insetLeft, 0), obtainStyledAttributes.getDimensionPixelOffset(com.google.android.material.R$styleable.MaterialCalendarItem_android_insetTop, 0), obtainStyledAttributes.getDimensionPixelOffset(com.google.android.material.R$styleable.MaterialCalendarItem_android_insetRight, 0), obtainStyledAttributes.getDimensionPixelOffset(com.google.android.material.R$styleable.MaterialCalendarItem_android_insetBottom, 0));
        ColorStateList Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, obtainStyledAttributes, com.google.android.material.R$styleable.MaterialCalendarItem_itemFillColor);
        ColorStateList Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, obtainStyledAttributes, com.google.android.material.R$styleable.MaterialCalendarItem_itemTextColor);
        ColorStateList Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, obtainStyledAttributes, com.google.android.material.R$styleable.MaterialCalendarItem_itemStrokeColor);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R$styleable.MaterialCalendarItem_itemStrokeWidth, 0);
        C2416nq Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = C2416nq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, obtainStyledAttributes.getResourceId(com.google.android.material.R$styleable.MaterialCalendarItem_itemShapeAppearance, 0), obtainStyledAttributes.getResourceId(com.google.android.material.R$styleable.MaterialCalendarItem_itemShapeAppearanceOverlay, 0)).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        obtainStyledAttributes.recycle();
        return new C2719vn(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, dimensionPixelSize, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4, rect);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull TextView textView) {
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable();
        materialShapeDrawable.setShapeAppearanceModel(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        materialShapeDrawable2.setShapeAppearanceModel(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        materialShapeDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        materialShapeDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        textView.setTextColor(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        RippleDrawable rippleDrawable = new RippleDrawable(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.withAlpha(30), materialShapeDrawable, materialShapeDrawable2);
        Rect rect = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        ViewCompat.setBackground(textView, new InsetDrawable((Drawable) rippleDrawable, rect.left, rect.top, rect.right, rect.bottom));
    }
}
