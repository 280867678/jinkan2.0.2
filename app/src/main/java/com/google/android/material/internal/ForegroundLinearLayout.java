package com.google.android.material.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.GravityCompat;
import com.google.android.material.R$styleable;
import me.tvspark.C2415np;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class ForegroundLinearLayout extends LinearLayoutCompat {
    public boolean Wwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwww;
    public final Rect Wwwwwwwwwwwwwwwwwwwwww;
    public final Rect Wwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public Drawable Wwwwwwwwwwwwwwwwwwwwwwww;

    public ForegroundLinearLayout(@NonNull Context context) {
        this(context, null);
    }

    public ForegroundLinearLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ForegroundLinearLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Wwwwwwwwwwwwwwwwwwwwwww = new Rect();
        this.Wwwwwwwwwwwwwwwwwwwwww = new Rect();
        this.Wwwwwwwwwwwwwwwwwwwww = 119;
        this.Wwwwwwwwwwwwwwwwwwww = true;
        this.Wwwwwwwwwwwwwwwwwww = false;
        TypedArray Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2415np.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, attributeSet, R$styleable.ForegroundLinearLayout, i, 0, new int[0]);
        this.Wwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getInt(R$styleable.ForegroundLinearLayout_android_foregroundGravity, this.Wwwwwwwwwwwwwwwwwwwww);
        Drawable drawable = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getDrawable(R$styleable.ForegroundLinearLayout_android_foreground);
        if (drawable != null) {
            setForeground(drawable);
        }
        this.Wwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getBoolean(R$styleable.ForegroundLinearLayout_foregroundInsidePadding, true);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.recycle();
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        Drawable drawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (drawable != null) {
            if (this.Wwwwwwwwwwwwwwwwwww) {
                this.Wwwwwwwwwwwwwwwwwww = false;
                Rect rect = this.Wwwwwwwwwwwwwwwwwwwwwww;
                Rect rect2 = this.Wwwwwwwwwwwwwwwwwwwwww;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                if (this.Wwwwwwwwwwwwwwwwwwww) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                Gravity.apply(this.Wwwwwwwwwwwwwwwwwwwww, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    @Override // android.view.View
    @RequiresApi(21)
    @TargetApi(21)
    public void drawableHotspotChanged(float f, float f2) {
        super.drawableHotspotChanged(f, f2);
        Drawable drawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (drawable != null) {
            drawable.setHotspot(f, f2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwww.setState(getDrawableState());
    }

    @Override // android.view.View
    @Nullable
    public Drawable getForeground() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // android.view.View
    public int getForegroundGravity() {
        return this.Wwwwwwwwwwwwwwwwwwwww;
    }

    @Override // android.view.ViewGroup, android.view.View
    @RequiresApi(11)
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.Wwwwwwwwwwwwwwwwwww = z | this.Wwwwwwwwwwwwwwwwwww;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.Wwwwwwwwwwwwwwwwwww = true;
    }

    @Override // android.view.View
    public void setForeground(@Nullable Drawable drawable) {
        Drawable drawable2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
                unscheduleDrawable(this.Wwwwwwwwwwwwwwwwwwwwwwww);
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwww = drawable;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.Wwwwwwwwwwwwwwwwwwwww == 119) {
                    drawable.getPadding(new Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    @Override // android.view.View
    public void setForegroundGravity(int i) {
        if (this.Wwwwwwwwwwwwwwwwwwwww != i) {
            if ((8388615 & i) == 0) {
                i |= GravityCompat.START;
            }
            if ((i & 112) == 0) {
                i |= 48;
            }
            this.Wwwwwwwwwwwwwwwwwwwww = i;
            if (i == 119 && this.Wwwwwwwwwwwwwwwwwwwwwwww != null) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.Wwwwwwwwwwwwwwwwwwwwwwww;
    }
}
