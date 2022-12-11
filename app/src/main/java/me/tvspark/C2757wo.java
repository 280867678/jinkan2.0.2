package me.tvspark;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.ColorUtils;
import me.tvspark.C2453oq;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: me.tvspark.wo */
/* loaded from: classes4.dex */
public class C2757wo extends Drawable {
    @Nullable
    public ColorStateList Wwwwwwwwwwwwwwwwwww;
    public C2416nq Wwwwwwwwwwwwwwwwwwww;
    @ColorInt
    public int Wwwwwwwwwwwwwwwwwwwwww;
    @ColorInt
    public int Wwwwwwwwwwwwwwwwwwwwwww;
    @ColorInt
    public int Wwwwwwwwwwwwwwwwwwwwwwww;
    @ColorInt
    public int Wwwwwwwwwwwwwwwwwwwwwwwww;
    @ColorInt
    public int Wwwwwwwwwwwwwwwwwwwwwwwwww;
    @Dimension
    public float Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    @NonNull
    public final Paint Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final C2453oq Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2453oq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Path Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Path();
    public final Rect Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Rect();
    public final RectF Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new RectF();
    public final RectF Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = new RectF();
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null);
    public boolean Wwwwwwwwwwwwwwwwwwwww = true;

    /* renamed from: me.tvspark.wo$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends Drawable.ConstantState {
        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            return C2757wo.this;
        }
    }

    public C2757wo(C2416nq c2416nq) {
        this.Wwwwwwwwwwwwwwwwwwww = c2416nq;
        Paint paint = new Paint(1);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = paint;
        paint.setStyle(Paint.Style.STROKE);
    }

    @NonNull
    public RectF Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.set(getBounds());
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.Wwwwwwwwwwwwwwwwwwwwww = colorStateList.getColorForState(getState(), this.Wwwwwwwwwwwwwwwwwwwwww);
        }
        this.Wwwwwwwwwwwwwwwwwww = colorStateList;
        this.Wwwwwwwwwwwwwwwwwwwww = true;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.Wwwwwwwwwwwwwwwwwwwww) {
            Paint paint = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            Rect rect = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            copyBounds(rect);
            float height = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww / rect.height();
            paint.setShader(new LinearGradient(0.0f, rect.top, 0.0f, rect.bottom, new int[]{ColorUtils.compositeColors(this.Wwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww), ColorUtils.compositeColors(this.Wwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww), ColorUtils.compositeColors(ColorUtils.setAlphaComponent(this.Wwwwwwwwwwwwwwwwwwwwwwwww, 0), this.Wwwwwwwwwwwwwwwwwwwwww), ColorUtils.compositeColors(ColorUtils.setAlphaComponent(this.Wwwwwwwwwwwwwwwwwwwwwww, 0), this.Wwwwwwwwwwwwwwwwwwwwww), ColorUtils.compositeColors(this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww), ColorUtils.compositeColors(this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww)}, new float[]{0.0f, height, 0.5f, 0.5f, 1.0f - height, 1.0f}, Shader.TileMode.CLAMP));
            this.Wwwwwwwwwwwwwwwwwwwww = false;
        }
        float strokeWidth = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getStrokeWidth() / 2.0f;
        copyBounds(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.set(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        float min = Math.min(this.Wwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.width() / 2.0f);
        if (this.Wwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww())) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.inset(strokeWidth, strokeWidth);
            canvas.drawRoundRect(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, min, min, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Drawable.ConstantState getConstantState() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwww > 0.0f ? -3 : -2;
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(@NonNull Outline outline) {
        if (this.Wwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww())) {
            outline.setRoundRect(getBounds(), this.Wwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()));
            return;
        }
        copyBounds(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.set(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwww, 1.0f, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isConvex()) {
            return;
        }
        outline.setConvexPath(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@NonNull Rect rect) {
        if (this.Wwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww())) {
            int round = Math.round(this.Wwwwwwwwwwwwwwwwwwwwwwwwwww);
            rect.set(round, round, round, round);
            return true;
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList = this.Wwwwwwwwwwwwwwwwwww;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.Wwwwwwwwwwwwwwwwwwwww = true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        int colorForState;
        ColorStateList colorStateList = this.Wwwwwwwwwwwwwwwwwww;
        if (colorStateList != null && (colorForState = colorStateList.getColorForState(iArr, this.Wwwwwwwwwwwwwwwwwwwwww)) != this.Wwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwww = true;
            this.Wwwwwwwwwwwwwwwwwwwwww = colorForState;
        }
        if (this.Wwwwwwwwwwwwwwwwwwwww) {
            invalidateSelf();
        }
        return this.Wwwwwwwwwwwwwwwwwwwww;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, m4212to = 255) int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
