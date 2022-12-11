package me.tvspark;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: me.tvspark.ip */
/* loaded from: classes4.dex */
public class C2230ip extends ViewGroup {
    public int Wwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwww;

    public C2230ip(@NonNull Context context) {
        this(context, null);
    }

    public C2230ip(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C2230ip(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Wwwwwwwwwwwwwwwwwwwwww = false;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, attributeSet);
    }

    @TargetApi(21)
    public C2230ip(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.Wwwwwwwwwwwwwwwwwwwwww = false;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, attributeSet);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, com.google.android.material.R$styleable.FlowLayout, 0, 0);
        this.Wwwwwwwwwwwwwwwwwwwwwwww = obtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R$styleable.FlowLayout_lineSpacing, 0);
        this.Wwwwwwwwwwwwwwwwwwwwwww = obtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R$styleable.FlowLayout_itemSpacing, 0);
        obtainStyledAttributes.recycle();
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwww;
    }

    public int getItemSpacing() {
        return this.Wwwwwwwwwwwwwwwwwwwwwww;
    }

    public int getLineSpacing() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww;
    }

    public int getRowCount() {
        return this.Wwwwwwwwwwwwwwwwwwwww;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        if (getChildCount() == 0) {
            this.Wwwwwwwwwwwwwwwwwwwww = 0;
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwww = 1;
        boolean z2 = ViewCompat.getLayoutDirection(this) == 1;
        int paddingRight = z2 ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = z2 ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int i7 = (i3 - i) - paddingLeft;
        int i8 = paddingRight;
        int i9 = paddingTop;
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() == 8) {
                childAt.setTag(com.google.android.material.R$id.row_index_key, -1);
            } else {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i6 = MarginLayoutParamsCompat.getMarginStart(marginLayoutParams);
                    i5 = MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams);
                } else {
                    i5 = 0;
                    i6 = 0;
                }
                int measuredWidth = childAt.getMeasuredWidth() + i8 + i6;
                if (!this.Wwwwwwwwwwwwwwwwwwwwww && measuredWidth > i7) {
                    i9 = this.Wwwwwwwwwwwwwwwwwwwwwwww + paddingTop;
                    this.Wwwwwwwwwwwwwwwwwwwww++;
                    i8 = paddingRight;
                }
                childAt.setTag(com.google.android.material.R$id.row_index_key, Integer.valueOf(this.Wwwwwwwwwwwwwwwwwwwww - 1));
                int i11 = i8 + i6;
                int measuredWidth2 = childAt.getMeasuredWidth() + i11;
                int measuredHeight = childAt.getMeasuredHeight() + i9;
                if (z2) {
                    i11 = i7 - measuredWidth2;
                    measuredWidth2 = (i7 - i8) - i6;
                }
                childAt.layout(i11, i9, measuredWidth2, measuredHeight);
                i8 += childAt.getMeasuredWidth() + i6 + i5 + this.Wwwwwwwwwwwwwwwwwwwwwww;
                paddingTop = measuredHeight;
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        int i6 = (mode == Integer.MIN_VALUE || mode == 1073741824) ? size : Integer.MAX_VALUE;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = i6 - getPaddingRight();
        int i7 = paddingTop;
        int i8 = 0;
        for (int i9 = 0; i9 < getChildCount(); i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i, i2);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i5 = marginLayoutParams.leftMargin + 0;
                    i4 = marginLayoutParams.rightMargin + 0;
                } else {
                    i4 = 0;
                    i5 = 0;
                }
                if (childAt.getMeasuredWidth() + paddingLeft + i5 > paddingRight && !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                    paddingLeft = getPaddingLeft();
                    i7 = paddingTop + this.Wwwwwwwwwwwwwwwwwwwwwwww;
                }
                int measuredWidth = childAt.getMeasuredWidth() + paddingLeft + i5;
                int measuredHeight = childAt.getMeasuredHeight() + i7;
                if (measuredWidth > i8) {
                    i8 = measuredWidth;
                }
                int measuredWidth2 = childAt.getMeasuredWidth() + i5 + i4 + this.Wwwwwwwwwwwwwwwwwwwwwww + paddingLeft;
                if (i9 == getChildCount() - 1) {
                    i8 += i4;
                }
                paddingLeft = measuredWidth2;
                paddingTop = measuredHeight;
            }
        }
        int paddingRight2 = getPaddingRight() + i8;
        int paddingBottom = getPaddingBottom() + paddingTop;
        if (mode != Integer.MIN_VALUE) {
            i3 = 1073741824;
            if (mode != 1073741824) {
                size = paddingRight2;
            }
        } else {
            i3 = 1073741824;
            size = Math.min(paddingRight2, size);
        }
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(paddingBottom, size2);
        } else if (mode2 != i3) {
            size2 = paddingBottom;
        }
        setMeasuredDimension(size, size2);
    }

    public void setItemSpacing(int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwww = i;
    }

    public void setLineSpacing(int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = i;
    }

    public void setSingleLine(boolean z) {
        this.Wwwwwwwwwwwwwwwwwwwwww = z;
    }
}
