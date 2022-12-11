package com.google.android.material.card;

import android.content.res.ColorStateList;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.cardview.widget.CardView;
import androidx.cardview.widget.RoundRectDrawableWithShadow;
import com.google.android.material.R$attr;
import com.google.common.collect.LinkedHashMultimap;
import me.tvspark.AbstractC2570rq;
import me.tvspark.C2416nq;

/* loaded from: classes3.dex */
public class MaterialCardView extends CardView implements Checkable, AbstractC2570rq {
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwww;
    public static final int[] Wwwwwwwwwwwwwwwwwwwww = {16842911};
    public static final int[] Wwwwwwwwwwwwwwwwwwww = {16842912};
    public static final int[] Wwwwwwwwwwwwwwwwwww = {R$attr.state_dragged};

    /* loaded from: classes3.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    @NonNull
    private RectF getBoundsAsRectF() {
        new RectF();
        throw null;
    }

    @Override // androidx.cardview.widget.CardView
    @NonNull
    public ColorStateList getCardBackgroundColor() {
        throw null;
    }

    @NonNull
    public ColorStateList getCardForegroundColor() {
        throw null;
    }

    public float getCardViewRadius() {
        return super.getRadius();
    }

    @Nullable
    public Drawable getCheckedIcon() {
        throw null;
    }

    @Dimension
    public int getCheckedIconMargin() {
        throw null;
    }

    @Dimension
    public int getCheckedIconSize() {
        throw null;
    }

    @Nullable
    public ColorStateList getCheckedIconTint() {
        throw null;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingBottom() {
        throw null;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingLeft() {
        throw null;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingRight() {
        throw null;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingTop() {
        throw null;
    }

    @FloatRange(from = RoundRectDrawableWithShadow.COS_45, m4213to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR)
    public float getProgress() {
        throw null;
    }

    @Override // androidx.cardview.widget.CardView
    public float getRadius() {
        throw null;
    }

    public ColorStateList getRippleColor() {
        throw null;
    }

    @Override // me.tvspark.AbstractC2570rq
    @NonNull
    public C2416nq getShapeAppearanceModel() {
        throw null;
    }

    @ColorInt
    @Deprecated
    public int getStrokeColor() {
        throw null;
    }

    @Nullable
    public ColorStateList getStrokeColorStateList() {
        throw null;
    }

    @Dimension
    public int getStrokeWidth() {
        throw null;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        throw null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 3);
        if (this.Wwwwwwwwwwwwwwwwwwwwwwww) {
            FrameLayout.mergeDrawableStates(onCreateDrawableState, Wwwwwwwwwwwwwwwwwwww);
        }
        if (this.Wwwwwwwwwwwwwwwwwwwwwww) {
            FrameLayout.mergeDrawableStates(onCreateDrawableState, Wwwwwwwwwwwwwwwwwww);
        }
        return onCreateDrawableState;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.cardview.widget.CardView");
        accessibilityEvent.setChecked(this.Wwwwwwwwwwwwwwwwwwwwwwww);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.cardview.widget.CardView");
        accessibilityNodeInfo.setCheckable(false);
        accessibilityNodeInfo.setClickable(isClickable());
        accessibilityNodeInfo.setChecked(this.Wwwwwwwwwwwwwwwwwwwwwwww);
    }

    @Override // androidx.cardview.widget.CardView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        getMeasuredWidth();
        getMeasuredHeight();
        throw null;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
    }

    public void setBackgroundInternal(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(@ColorInt int i) {
        ColorStateList.valueOf(i);
        throw null;
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(@Nullable ColorStateList colorStateList) {
        throw null;
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardElevation(float f) {
        super.setCardElevation(f);
        throw null;
    }

    public void setCardForegroundColor(@Nullable ColorStateList colorStateList) {
        throw null;
    }

    public void setCheckable(boolean z) {
        throw null;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        boolean z2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
    }

    public void setCheckedIcon(@Nullable Drawable drawable) {
        throw null;
    }

    public void setCheckedIconMargin(@Dimension int i) {
        throw null;
    }

    public void setCheckedIconMarginResource(@DimenRes int i) {
        if (i == -1) {
            return;
        }
        getResources().getDimensionPixelSize(i);
        throw null;
    }

    public void setCheckedIconResource(@DrawableRes int i) {
        AppCompatResources.getDrawable(getContext(), i);
        throw null;
    }

    public void setCheckedIconSize(@Dimension int i) {
        throw null;
    }

    public void setCheckedIconSizeResource(@DimenRes int i) {
        if (i == 0) {
            return;
        }
        getResources().getDimensionPixelSize(i);
        throw null;
    }

    public void setCheckedIconTint(@Nullable ColorStateList colorStateList) {
        throw null;
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        super.setClickable(z);
    }

    @Override // androidx.cardview.widget.CardView
    public void setContentPadding(int i, int i2, int i3, int i4) {
        throw null;
    }

    public void setDragged(boolean z) {
        if (this.Wwwwwwwwwwwwwwwwwwwwwww != z) {
            this.Wwwwwwwwwwwwwwwwwwwwwww = z;
            refreshDrawableState();
            if (Build.VERSION.SDK_INT <= 26) {
                invalidate();
                return;
            }
            throw null;
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setMaxCardElevation(float f) {
        super.setMaxCardElevation(f);
        throw null;
    }

    public void setOnCheckedChangeListener(@Nullable Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // androidx.cardview.widget.CardView
    public void setPreventCornerOverlap(boolean z) {
        super.setPreventCornerOverlap(z);
        throw null;
    }

    public void setProgress(@FloatRange(from = 0.0d, m4213to = 1.0d) float f) {
        throw null;
    }

    @Override // androidx.cardview.widget.CardView
    public void setRadius(float f) {
        super.setRadius(f);
        throw null;
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        throw null;
    }

    public void setRippleColorResource(@ColorRes int i) {
        AppCompatResources.getColorStateList(getContext(), i);
        throw null;
    }

    @Override // me.tvspark.AbstractC2570rq
    public void setShapeAppearanceModel(@NonNull C2416nq c2416nq) {
        setClipToOutline(c2416nq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getBoundsAsRectF()));
        throw null;
    }

    public void setStrokeColor(@ColorInt int i) {
        ColorStateList.valueOf(i);
        throw null;
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        throw null;
    }

    public void setStrokeWidth(@Dimension int i) {
        throw null;
    }

    @Override // androidx.cardview.widget.CardView
    public void setUseCompatPadding(boolean z) {
        super.setUseCompatPadding(z);
        throw null;
    }

    @Override // android.widget.Checkable
    public void toggle() {
    }
}
