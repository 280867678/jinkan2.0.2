package me.tvspark;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class q50 extends ViewGroup {
    public List<View> Wwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwww;
    public List<Integer> Wwwwwwwwwwwwwwwwwwwwww;
    public List<Integer> Wwwwwwwwwwwwwwwwwwwwwww;
    public List<List<View>> Wwwwwwwwwwwwwwwwwwwwwwww;

    public q50(Context context) {
        this(context, null);
    }

    public q50(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public q50(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Wwwwwwwwwwwwwwwwwwwwwwww = new ArrayList();
        this.Wwwwwwwwwwwwwwwwwwwwwww = new ArrayList();
        this.Wwwwwwwwwwwwwwwwwwwwww = new ArrayList();
        this.Wwwwwwwwwwwwwwwwwwww = new ArrayList();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.zhy.view.flowlayout.R$styleable.TagFlowLayout);
        this.Wwwwwwwwwwwwwwwwwwwww = obtainStyledAttributes.getInt(com.zhy.view.flowlayout.R$styleable.TagFlowLayout_gravityy, -1);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ViewGroup.MarginLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        this.Wwwwwwwwwwwwwwwwwwwwwwww.clear();
        this.Wwwwwwwwwwwwwwwwwwwwwww.clear();
        this.Wwwwwwwwwwwwwwwwwwwwww.clear();
        this.Wwwwwwwwwwwwwwwwwwww.clear();
        int width = getWidth();
        int childCount = getChildCount();
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (measuredWidth + i7 + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin > (width - getPaddingLeft()) - getPaddingRight()) {
                    this.Wwwwwwwwwwwwwwwwwwwwwww.add(Integer.valueOf(i6));
                    this.Wwwwwwwwwwwwwwwwwwwwwwww.add(this.Wwwwwwwwwwwwwwwwwwww);
                    this.Wwwwwwwwwwwwwwwwwwwwww.add(Integer.valueOf(i7));
                    i6 = marginLayoutParams.topMargin + measuredHeight + marginLayoutParams.bottomMargin;
                    this.Wwwwwwwwwwwwwwwwwwww = new ArrayList();
                    i7 = 0;
                }
                i7 += measuredWidth + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                i6 = Math.max(i6, measuredHeight + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin);
                this.Wwwwwwwwwwwwwwwwwwww.add(childAt);
            }
        }
        this.Wwwwwwwwwwwwwwwwwwwwwww.add(Integer.valueOf(i6));
        this.Wwwwwwwwwwwwwwwwwwwwww.add(Integer.valueOf(i7));
        this.Wwwwwwwwwwwwwwwwwwwwwwww.add(this.Wwwwwwwwwwwwwwwwwwww);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int size = this.Wwwwwwwwwwwwwwwwwwwwwwww.size();
        for (int i9 = 0; i9 < size; i9++) {
            this.Wwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww.get(i9);
            int intValue = this.Wwwwwwwwwwwwwwwwwwwwwww.get(i9).intValue();
            int intValue2 = this.Wwwwwwwwwwwwwwwwwwwwww.get(i9).intValue();
            int i10 = this.Wwwwwwwwwwwwwwwwwwwww;
            if (i10 != -1) {
                if (i10 == 0) {
                    i5 = (width - intValue2) / 2;
                } else if (i10 == 1) {
                    i5 = width - intValue2;
                }
                paddingLeft = i5 + getPaddingLeft();
            } else {
                paddingLeft = getPaddingLeft();
            }
            for (int i11 = 0; i11 < this.Wwwwwwwwwwwwwwwwwwww.size(); i11++) {
                View view = this.Wwwwwwwwwwwwwwwwwwww.get(i11);
                if (view.getVisibility() != 8) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                    int i12 = marginLayoutParams2.leftMargin + paddingLeft;
                    int i13 = marginLayoutParams2.topMargin + paddingTop;
                    view.layout(i12, i13, view.getMeasuredWidth() + i12, view.getMeasuredHeight() + i13);
                    paddingLeft += view.getMeasuredWidth() + marginLayoutParams2.leftMargin + marginLayoutParams2.rightMargin;
                }
            }
            paddingTop += intValue;
        }
    }
}
