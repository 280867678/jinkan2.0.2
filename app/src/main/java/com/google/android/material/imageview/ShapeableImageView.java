package com.google.android.material.imageview;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import me.tvspark.AbstractC2570rq;
import me.tvspark.C2416nq;

/* loaded from: classes3.dex */
public class ShapeableImageView extends AppCompatImageView implements AbstractC2570rq {
    public boolean Wwwwwwwwwwwwwwwwwwwww;
    @Dimension
    public float Wwwwwwwwwwwwwwwwwwwwww;
    public C2416nq Wwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public ColorStateList Wwwwwwwwwwwwwwwwwwwwwwww;

    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return getLayoutDirection() == 1;
    }

    @Dimension
    public int getContentPaddingBottom() {
        return 0;
    }

    @Dimension
    public final int getContentPaddingEnd() {
        return 0;
    }

    @Dimension
    public int getContentPaddingLeft() {
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            return 0;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        return 0;
    }

    @Dimension
    public int getContentPaddingRight() {
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            return 0;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        return 0;
    }

    @Dimension
    public final int getContentPaddingStart() {
        return 0;
    }

    @Dimension
    public int getContentPaddingTop() {
        return 0;
    }

    @Override // android.view.View
    @Dimension
    public int getPaddingBottom() {
        return super.getPaddingBottom() - getContentPaddingBottom();
    }

    @Override // android.view.View
    @Dimension
    public int getPaddingEnd() {
        return super.getPaddingEnd() - getContentPaddingEnd();
    }

    @Override // android.view.View
    @Dimension
    public int getPaddingLeft() {
        return super.getPaddingLeft() - getContentPaddingLeft();
    }

    @Override // android.view.View
    @Dimension
    public int getPaddingRight() {
        return super.getPaddingRight() - getContentPaddingRight();
    }

    @Override // android.view.View
    @Dimension
    public int getPaddingStart() {
        return super.getPaddingStart() - getContentPaddingStart();
    }

    @Override // android.view.View
    @Dimension
    public int getPaddingTop() {
        return super.getPaddingTop() - getContentPaddingTop();
    }

    @Override // me.tvspark.AbstractC2570rq
    @NonNull
    public C2416nq getShapeAppearanceModel() {
        return this.Wwwwwwwwwwwwwwwwwwwwwww;
    }

    @Nullable
    public ColorStateList getStrokeColor() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Dimension
    public float getStrokeWidth() {
        return this.Wwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setLayerType(2, null);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        setLayerType(0, null);
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(null, null);
        if (this.Wwwwwwwwwwwwwwwwwwwwwwww == null) {
            return;
        }
        throw null;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (!this.Wwwwwwwwwwwwwwwwwwwww && isLayoutDirectionResolved()) {
            this.Wwwwwwwwwwwwwwwwwwwww = true;
            isPaddingRelative();
            setPaddingRelative(super.getPaddingStart(), super.getPaddingTop(), super.getPaddingEnd(), super.getPaddingBottom());
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        getPaddingLeft();
        getPaddingTop();
        getPaddingRight();
        getPaddingBottom();
        throw null;
    }

    @Override // android.view.View
    public void setPadding(@Dimension int i, @Dimension int i2, @Dimension int i3, @Dimension int i4) {
        super.setPadding(getContentPaddingLeft() + i, getContentPaddingTop() + i2, getContentPaddingRight() + i3, getContentPaddingBottom() + i4);
    }

    @Override // android.view.View
    public void setPaddingRelative(@Dimension int i, @Dimension int i2, @Dimension int i3, @Dimension int i4) {
        super.setPaddingRelative(getContentPaddingStart() + i, getContentPaddingTop() + i2, getContentPaddingEnd() + i3, getContentPaddingBottom() + i4);
    }

    @Override // me.tvspark.AbstractC2570rq
    public void setShapeAppearanceModel(@NonNull C2416nq c2416nq) {
        this.Wwwwwwwwwwwwwwwwwwwwwww = c2416nq;
        getWidth();
        getHeight();
        getPaddingLeft();
        getPaddingTop();
        getPaddingRight();
        getPaddingBottom();
        throw null;
    }

    public void setStrokeColor(@Nullable ColorStateList colorStateList) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = colorStateList;
        invalidate();
    }

    public void setStrokeColorResource(@ColorRes int i) {
        setStrokeColor(AppCompatResources.getColorStateList(getContext(), i));
    }

    public void setStrokeWidth(@Dimension float f) {
        if (this.Wwwwwwwwwwwwwwwwwwwwww != f) {
            this.Wwwwwwwwwwwwwwwwwwwwww = f;
            invalidate();
        }
    }

    public void setStrokeWidthResource(@DimenRes int i) {
        setStrokeWidth(getResources().getDimensionPixelSize(i));
    }
}
