package com.google.android.material.chip;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.core.graphics.ColorUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.graphics.drawable.TintAwareDrawable;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import me.tvspark.C1955bq;
import me.tvspark.C2341lp;
import me.tvspark.C2449om;
import me.tvspark.C2605so;
import me.tvspark.C2832yp;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public class ChipDrawable extends MaterialShapeDrawable implements TintAwareDrawable, Drawable.Callback, C2341lp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    public boolean IIl;
    public TextUtils.TruncateAt IIll;
    @Nullable
    public ColorStateList IIllll;
    public boolean IIlllll;
    public int[] IIllllll;
    @Nullable
    public ColorStateList IIllllllll;
    @Nullable
    public PorterDuffColorFilter IIlllllllll;
    @Nullable

    /* renamed from: Il */
    public ColorFilter f577Il;
    @ColorInt
    public int Illl;
    public boolean Illll;
    @ColorInt
    public int Illlll;
    @ColorInt
    public int Illllll;
    @ColorInt
    public int Illlllll;
    @ColorInt
    public int Illllllll;
    @ColorInt
    public int Illlllllll;
    @ColorInt
    public int Illllllllll;
    @NonNull
    public final C2341lp Illlllllllll;
    @NonNull
    public final Context Illllllllllllllllll;
    public float Illlllllllllllllllll;
    public float Illllllllllllllllllll;
    public float Illlllllllllllllllllll;
    public float Illllllllllllllllllllll;
    public float Illlllllllllllllllllllll;
    public float Illllllllllllllllllllllll;
    public float Illlllllllllllllllllllllll;
    public float Illllllllllllllllllllllllll;
    @Nullable
    public C2449om Illlllllllllllllllllllllllll;
    @Nullable
    public C2449om Illllllllllllllllllllllllllll;
    @Nullable

    /* renamed from: Kk */
    public ColorStateList f578Kk;
    @Nullable
    public Drawable Kkk;
    public boolean Kkkk;
    public boolean Kkkkk;
    @Nullable
    public CharSequence Kkkkkk;
    public float Kkkkkkk;
    @Nullable
    public ColorStateList Kkkkkkkk;
    @Nullable
    public Drawable Kkkkkkkkk;
    @Nullable
    public Drawable Kkkkkkkkkk;
    public boolean Kkkkkkkkkkk;
    public boolean Kkkkkkkkkkkk;
    public float Kkkkkkkkkkkkk;
    @Nullable
    public ColorStateList Kkkkkkkkkkkkkk;
    @Nullable
    public Drawable Kkkkkkkkkkkkkkk;
    public boolean Kkkkkkkkkkkkkkkk;
    @Nullable
    public ColorStateList Kkkkkkkkkkkkkkkkkk;
    public float Kkkkkkkkkkkkkkkkkkk;
    @Nullable
    public ColorStateList Kkkkkkkkkkkkkkkkkkkk;
    public float Kkkkkkkkkkkkkkkkkkkkkk;
    @Nullable
    public ColorStateList Kkkkkkkkkkkkkkkkkkkkkkk;
    @Nullable
    public ColorStateList Kkkkkkkkkkkkkkkkkkkkkkkk;
    public boolean O000000000;
    public int O0000000000;
    public static final int[] O00000000 = {16842910};
    public static final ShapeDrawable O0000000 = new ShapeDrawable(new OvalShape());
    public float Kkkkkkkkkkkkkkkkkkkkk = -1.0f;
    public final Paint Illlllllllllllllll = new Paint(1);
    public final Paint.FontMetrics Illlllllllllllll = new Paint.FontMetrics();
    public final RectF Illllllllllllll = new RectF();
    public final PointF Illlllllllllll = new PointF();
    public final Path Illllllllllll = new Path();
    public int Ill = 255;
    @Nullable
    public PorterDuff.Mode IIlllllll = PorterDuff.Mode.SRC_IN;
    @NonNull
    public WeakReference<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> IIlll = new WeakReference<>(null);
    @Nullable
    public CharSequence Kkkkkkkkkkkkkkkkk = "";
    @Nullable
    public final Paint Illllllllllllllll = null;

    /* loaded from: classes3.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public ChipDrawable(@NonNull Context context, AttributeSet attributeSet, @AttrRes int i, @StyleRes int i2) {
        super(context, attributeSet, i, i2);
        Paint paint = null;
        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2605so(context);
        Wwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Illllllllllllllllll = context;
        C2341lp c2341lp = new C2341lp(this);
        this.Illlllllllll = c2341lp;
        c2341lp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.density = context.getResources().getDisplayMetrics().density;
        if (0 != 0) {
            paint.setStyle(Paint.Style.STROKE);
        }
        setState(O00000000);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(O00000000);
        this.IIl = true;
        if (C1955bq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            O0000000.setTint(-1);
        }
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    public final boolean Wwwwwwwwwwwwwwwww() {
        return this.Kkkkkkkkkkk && this.Kkkkkkkkkk != null;
    }

    public final boolean Wwwwwwwwwwwwwwwwww() {
        return this.Kkkkkkkkkkkkkkkk && this.Kkkkkkkkkkkkkkk != null;
    }

    public final boolean Wwwwwwwwwwwwwwwwwww() {
        return this.Kkkk && this.Kkk != null && this.Illll;
    }

    public void Wwwwwwwwwwwwwwwwwwww() {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.IIlll.get();
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    public void Wwwwwwwwwwwwwwwwwwww(float f) {
        if (this.Illlllllllllllllllllllll != f) {
            this.Illlllllllllllllllllllll = f;
            invalidateSelf();
            Wwwwwwwwwwwwwwwwwwww();
        }
    }

    public final float Wwwwwwwwwwwwwwwwwwwww() {
        Drawable drawable = this.Illll ? this.Kkk : this.Kkkkkkkkkkkkkkk;
        return (this.Kkkkkkkkkkkkk > 0.0f || drawable == null) ? this.Kkkkkkkkkkkkk : drawable.getIntrinsicWidth();
    }

    public void Wwwwwwwwwwwwwwwwwwwww(float f) {
        if (this.Illllllllllllllllllllll != f) {
            this.Illllllllllllllllllllll = f;
            invalidateSelf();
            Wwwwwwwwwwwwwwwwwwww();
        }
    }

    @Nullable
    public Drawable Wwwwwwwwwwwwwwwwwwwwww() {
        Drawable drawable = this.Kkkkkkkkkk;
        if (drawable != null) {
            return DrawableCompat.unwrap(drawable);
        }
        return null;
    }

    public void Wwwwwwwwwwwwwwwwwwwwww(float f) {
        if (this.Illlllllllllllllllllllllll != f) {
            float Wwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwww();
            this.Illlllllllllllllllllllllll = f;
            float Wwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwww();
            invalidateSelf();
            if (Wwwwwwwwwwwwwwwwwwwwwwwww == Wwwwwwwwwwwwwwwwwwwwwwwww2) {
                return;
            }
            Wwwwwwwwwwwwwwwwwwww();
        }
    }

    public float Wwwwwwwwwwwwwwwwwwwwwww() {
        return this.O000000000 ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() : this.Kkkkkkkkkkkkkkkkkkkkk;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwww(float f) {
        if (this.Illllllllllllllllllllllll != f) {
            float Wwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwww();
            this.Illllllllllllllllllllllll = f;
            float Wwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwww();
            invalidateSelf();
            if (Wwwwwwwwwwwwwwwwwwwwwwwww == Wwwwwwwwwwwwwwwwwwwwwwwww2) {
                return;
            }
            Wwwwwwwwwwwwwwwwwwww();
        }
    }

    public float Wwwwwwwwwwwwwwwwwwwwwwww() {
        if (Wwwwwwwwwwwwwwwww()) {
            return this.Illlllllllllllllllllll + this.Kkkkkkk + this.Illllllllllllllllllll;
        }
        return 0.0f;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwww(float f) {
        if (this.Illlllllllllllllllllll != f) {
            this.Illlllllllllllllllllll = f;
            invalidateSelf();
            if (!Wwwwwwwwwwwwwwwww()) {
                return;
            }
            Wwwwwwwwwwwwwwwwwwww();
        }
    }

    public float Wwwwwwwwwwwwwwwwwwwwwwwww() {
        if (Wwwwwwwwwwwwwwwwww() || Wwwwwwwwwwwwwwwwwww()) {
            return Wwwwwwwwwwwwwwwwwwwww() + this.Illlllllllllllllllllllllll + this.Illllllllllllllllllllllll;
        }
        return 0.0f;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwww(float f) {
        if (this.Kkkkkkk != f) {
            this.Kkkkkkk = f;
            invalidateSelf();
            if (!Wwwwwwwwwwwwwwwww()) {
                return;
            }
            Wwwwwwwwwwwwwwwwwwww();
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwww(float f) {
        if (this.Illllllllllllllllllll != f) {
            this.Illllllllllllllllllll = f;
            invalidateSelf();
            if (!Wwwwwwwwwwwwwwwww()) {
                return;
            }
            Wwwwwwwwwwwwwwwwwwww();
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwww(float f) {
        if (this.Kkkkkkkkkkkkkkkkkkk != f) {
            this.Kkkkkkkkkkkkkkkkkkk = f;
            this.Illlllllllllllllll.setStrokeWidth(f);
            if (this.O000000000) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww = f;
                invalidateSelf();
            }
            invalidateSelf();
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwww(float f) {
        if (this.Illllllllllllllllllllllllll != f) {
            this.Illllllllllllllllllllllllll = f;
            invalidateSelf();
            Wwwwwwwwwwwwwwwwwwww();
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable ColorStateList colorStateList) {
        if (this.Kkkkkkkk != colorStateList) {
            this.Kkkkkkkk = colorStateList;
            if (Wwwwwwwwwwwwwwwww()) {
                DrawableCompat.setTintList(this.Kkkkkkkkkk, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f) {
        if (this.Kkkkkkkkkkkkkkkkkkkkkk != f) {
            this.Kkkkkkkkkkkkkkkkkkkkkk = f;
            invalidateSelf();
            Wwwwwwwwwwwwwwwwwwww();
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable ColorStateList colorStateList) {
        if (this.Kkkkkkkkkkkkkkkkkkkk != colorStateList) {
            this.Kkkkkkkkkkkkkkkkkkkk = colorStateList;
            if (this.O000000000) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f) {
        if (this.Kkkkkkkkkkkkk != f) {
            float Wwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwww();
            this.Kkkkkkkkkkkkk = f;
            float Wwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwww();
            invalidateSelf();
            if (Wwwwwwwwwwwwwwwwwwwwwwwww == Wwwwwwwwwwwwwwwwwwwwwwwww2) {
                return;
            }
            Wwwwwwwwwwwwwwwwwwww();
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable ColorStateList colorStateList) {
        this.Kkkkkkkkkkkk = true;
        if (this.Kkkkkkkkkkkkkk != colorStateList) {
            this.Kkkkkkkkkkkkkk = colorStateList;
            if (Wwwwwwwwwwwwwwwwww()) {
                DrawableCompat.setTintList(this.Kkkkkkkkkkkkkkk, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
        if (this.IIlllll != z) {
            this.IIlllll = z;
            this.IIllll = z ? C1955bq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkkkkkkkkkk) : null;
            onStateChange(getState());
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f) {
        if (this.Illlllllllllllllllll != f) {
            this.Illlllllllllllllllll = f;
            invalidateSelf();
            Wwwwwwwwwwwwwwwwwwww();
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable ColorStateList colorStateList) {
        if (this.Kkkkkkkkkkkkkkkkkkkkkkk != colorStateList) {
            this.Kkkkkkkkkkkkkkkkkkkkkkk = colorStateList;
            onStateChange(getState());
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable Drawable drawable) {
        Drawable Wwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwww();
        if (Wwwwwwwwwwwwwwwwwwwwww != drawable) {
            float Wwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwww();
            this.Kkkkkkkkkk = drawable != null ? DrawableCompat.wrap(drawable).mutate() : null;
            if (C1955bq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                this.Kkkkkkkkk = new RippleDrawable(C1955bq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkkkkkkkkkk), this.Kkkkkkkkkk, O0000000);
            }
            float Wwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwww();
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwww);
            if (Wwwwwwwwwwwwwwwww()) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkk);
            }
            invalidateSelf();
            if (Wwwwwwwwwwwwwwwwwwwwwwww == Wwwwwwwwwwwwwwwwwwwwwwww2) {
                return;
            }
            Wwwwwwwwwwwwwwwwwwww();
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
        if (this.Kkkkkkkkkkk != z) {
            boolean Wwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwww();
            this.Kkkkkkkkkkk = z;
            boolean Wwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwww();
            if (!(Wwwwwwwwwwwwwwwww != Wwwwwwwwwwwwwwwww2)) {
                return;
            }
            if (Wwwwwwwwwwwwwwwww2) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkk);
            } else {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkk);
            }
            invalidateSelf();
            Wwwwwwwwwwwwwwwwwwww();
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable ColorStateList colorStateList) {
        if (this.f578Kk != colorStateList) {
            this.f578Kk = colorStateList;
            if (this.Kkkk && this.Kkk != null && this.Kkkkk) {
                DrawableCompat.setTintList(this.Kkk, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Rect rect, @NonNull RectF rectF) {
        rectF.setEmpty();
        if (Wwwwwwwwwwwwwwwww()) {
            float f = this.Illlllllllllllllllll + this.Illllllllllllllllllll + this.Kkkkkkk + this.Illlllllllllllllllllll + this.Illllllllllllllllllllll;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                float f2 = rect.right;
                rectF.right = f2;
                rectF.left = f2 - f;
            } else {
                int i = rect.left;
                rectF.left = i;
                rectF.right = i + f;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
        if (this.Kkkkkkkkkkkkkkkk != z) {
            boolean Wwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwww();
            this.Kkkkkkkkkkkkkkkk = z;
            boolean Wwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwww();
            if (!(Wwwwwwwwwwwwwwwwww != Wwwwwwwwwwwwwwwwww2)) {
                return;
            }
            if (Wwwwwwwwwwwwwwwwww2) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkkkkkkk);
            } else {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkkkkkkk);
            }
            invalidateSelf();
            Wwwwwwwwwwwwwwwwwwww();
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Rect rect, @NonNull RectF rectF) {
        rectF.setEmpty();
        if (Wwwwwwwwwwwwwwwww()) {
            float f = this.Illlllllllllllllllll + this.Illllllllllllllllllll;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                float f2 = rect.right - f;
                rectF.right = f2;
                rectF.left = f2 - this.Kkkkkkk;
            } else {
                float f3 = rect.left + f;
                rectF.left = f3;
                rectF.right = f3 + this.Kkkkkkk;
            }
            float exactCenterY = rect.exactCenterY();
            float f4 = this.Kkkkkkk;
            float f5 = exactCenterY - (f4 / 2.0f);
            rectF.top = f5;
            rectF.bottom = f5 + f4;
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable Drawable drawable) {
        if (this.Kkk != drawable) {
            float Wwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwww();
            this.Kkk = drawable;
            float Wwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwww();
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkk);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkk);
            invalidateSelf();
            if (Wwwwwwwwwwwwwwwwwwwwwwwww == Wwwwwwwwwwwwwwwwwwwwwwwww2) {
                return;
            }
            Wwwwwwwwwwwwwwwwwwww();
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
        if (this.Kkkk != z) {
            boolean Wwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwww();
            this.Kkkk = z;
            boolean Wwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwww();
            if (!(Wwwwwwwwwwwwwwwwwww != Wwwwwwwwwwwwwwwwwww2)) {
                return;
            }
            if (Wwwwwwwwwwwwwwwwwww2) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkk);
            } else {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkk);
            }
            invalidateSelf();
            Wwwwwwwwwwwwwwwwwwww();
        }
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull int[] iArr) {
        if (!Arrays.equals(this.IIllllll, iArr)) {
            this.IIllllll = iArr;
            if (!Wwwwwwwwwwwwwwwww()) {
                return false;
            }
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getState(), iArr);
        }
        return false;
    }

    @Override // me.tvspark.C2341lp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Wwwwwwwwwwwwwwwwwwww();
        invalidateSelf();
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setCallback(this);
        DrawableCompat.setLayoutDirection(drawable, DrawableCompat.getLayoutDirection(this));
        drawable.setLevel(getLevel());
        drawable.setVisible(isVisible(), false);
        if (drawable == this.Kkkkkkkkkk) {
            if (drawable.isStateful()) {
                drawable.setState(this.IIllllll);
            }
            DrawableCompat.setTintList(drawable, this.Kkkkkkkk);
            return;
        }
        if (drawable.isStateful()) {
            drawable.setState(getState());
        }
        Drawable drawable2 = this.Kkkkkkkkkkkkkkk;
        if (drawable != drawable2 || !this.Kkkkkkkkkkkk) {
            return;
        }
        DrawableCompat.setTintList(drawable2, this.Kkkkkkkkkkkkkk);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
        if (this.Kkkkk != z) {
            this.Kkkkk = z;
            float Wwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwww();
            if (!z && this.Illll) {
                this.Illll = false;
            }
            float Wwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwww();
            invalidateSelf();
            if (Wwwwwwwwwwwwwwwwwwwwwwwww == Wwwwwwwwwwwwwwwwwwwwwwwww2) {
                return;
            }
            Wwwwwwwwwwwwwwwwwwww();
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Drawable drawable;
        int i8;
        float f;
        Rect bounds = getBounds();
        if (bounds.isEmpty() || (i = this.Ill) == 0) {
            return;
        }
        if (i < 255) {
            float f2 = bounds.left;
            float f3 = bounds.top;
            float f4 = bounds.right;
            float f5 = bounds.bottom;
            i2 = Build.VERSION.SDK_INT > 21 ? canvas.saveLayerAlpha(f2, f3, f4, f5, i) : canvas.saveLayerAlpha(f2, f3, f4, f5, i, 31);
        } else {
            i2 = 0;
        }
        if (!this.O000000000) {
            this.Illlllllllllllllll.setColor(this.Illllllllll);
            this.Illlllllllllllllll.setStyle(Paint.Style.FILL);
            this.Illllllllllllll.set(bounds);
            canvas.drawRoundRect(this.Illllllllllllll, Wwwwwwwwwwwwwwwwwwwwwww(), Wwwwwwwwwwwwwwwwwwwwwww(), this.Illlllllllllllllll);
        }
        if (!this.O000000000) {
            this.Illlllllllllllllll.setColor(this.Illlllllll);
            this.Illlllllllllllllll.setStyle(Paint.Style.FILL);
            Paint paint = this.Illlllllllllllllll;
            ColorFilter colorFilter = this.f577Il;
            if (colorFilter == null) {
                colorFilter = this.IIlllllllll;
            }
            paint.setColorFilter(colorFilter);
            this.Illllllllllllll.set(bounds);
            canvas.drawRoundRect(this.Illllllllllllll, Wwwwwwwwwwwwwwwwwwwwwww(), Wwwwwwwwwwwwwwwwwwwwwww(), this.Illlllllllllllllll);
        }
        if (this.O000000000) {
            super.draw(canvas);
        }
        if (this.Kkkkkkkkkkkkkkkkkkk > 0.0f && !this.O000000000) {
            this.Illlllllllllllllll.setColor(this.Illlllll);
            this.Illlllllllllllllll.setStyle(Paint.Style.STROKE);
            if (!this.O000000000) {
                Paint paint2 = this.Illlllllllllllllll;
                ColorFilter colorFilter2 = this.f577Il;
                if (colorFilter2 == null) {
                    colorFilter2 = this.IIlllllllll;
                }
                paint2.setColorFilter(colorFilter2);
            }
            RectF rectF = this.Illllllllllllll;
            float f6 = this.Kkkkkkkkkkkkkkkkkkk / 2.0f;
            rectF.set(bounds.left + f6, bounds.top + f6, bounds.right - f6, bounds.bottom - f6);
            float f7 = this.Kkkkkkkkkkkkkkkkkkkkk - (this.Kkkkkkkkkkkkkkkkkkk / 2.0f);
            canvas.drawRoundRect(this.Illllllllllllll, f7, f7, this.Illlllllllllllllll);
        }
        this.Illlllllllllllllll.setColor(this.Illllll);
        this.Illlllllllllllllll.setStyle(Paint.Style.FILL);
        this.Illllllllllllll.set(bounds);
        if (!this.O000000000) {
            canvas.drawRoundRect(this.Illllllllllllll, Wwwwwwwwwwwwwwwwwwwwwww(), Wwwwwwwwwwwwwwwwwwwwwww(), this.Illlllllllllllllll);
            i3 = 0;
        } else {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new RectF(bounds), this.Illllllllllll);
            i3 = 0;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(canvas, this.Illlllllllllllllll, this.Illllllllllll, this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        }
        if (Wwwwwwwwwwwwwwwwww()) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bounds, this.Illllllllllllll);
            RectF rectF2 = this.Illllllllllllll;
            float f8 = rectF2.left;
            float f9 = rectF2.top;
            canvas.translate(f8, f9);
            this.Kkkkkkkkkkkkkkk.setBounds(i3, i3, (int) this.Illllllllllllll.width(), (int) this.Illllllllllllll.height());
            this.Kkkkkkkkkkkkkkk.draw(canvas);
            canvas.translate(-f8, -f9);
        }
        if (Wwwwwwwwwwwwwwwwwww()) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bounds, this.Illllllllllllll);
            RectF rectF3 = this.Illllllllllllll;
            float f10 = rectF3.left;
            float f11 = rectF3.top;
            canvas.translate(f10, f11);
            this.Kkk.setBounds(i3, i3, (int) this.Illllllllllllll.width(), (int) this.Illllllllllllll.height());
            this.Kkk.draw(canvas);
            canvas.translate(-f10, -f11);
        }
        if (!this.IIl || this.Kkkkkkkkkkkkkkkkk == null) {
            i4 = i2;
            i5 = 0;
        } else {
            PointF pointF = this.Illlllllllllll;
            pointF.set(0.0f, 0.0f);
            Paint.Align align = Paint.Align.LEFT;
            if (this.Kkkkkkkkkkkkkkkkk != null) {
                float Wwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwww() + this.Illllllllllllllllllllllllll + this.Illlllllllllllllllllllll;
                if (DrawableCompat.getLayoutDirection(this) == 0) {
                    pointF.x = bounds.left + Wwwwwwwwwwwwwwwwwwwwwwwww;
                    align = Paint.Align.LEFT;
                } else {
                    pointF.x = bounds.right - Wwwwwwwwwwwwwwwwwwwwwwwww;
                    align = Paint.Align.RIGHT;
                }
                this.Illlllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getFontMetrics(this.Illlllllllllllll);
                Paint.FontMetrics fontMetrics = this.Illlllllllllllll;
                pointF.y = bounds.centerY() - ((fontMetrics.descent + fontMetrics.ascent) / 2.0f);
            }
            RectF rectF4 = this.Illllllllllllll;
            rectF4.setEmpty();
            if (this.Kkkkkkkkkkkkkkkkk != null) {
                float Wwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwww() + this.Illllllllllllllllllllllllll + this.Illlllllllllllllllllllll;
                float Wwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwww() + this.Illlllllllllllllllll + this.Illllllllllllllllllllll;
                if (DrawableCompat.getLayoutDirection(this) == 0) {
                    rectF4.left = bounds.left + Wwwwwwwwwwwwwwwwwwwwwwwww2;
                    f = bounds.right - Wwwwwwwwwwwwwwwwwwwwwwww;
                } else {
                    rectF4.left = bounds.left + Wwwwwwwwwwwwwwwwwwwwwwww;
                    f = bounds.right - Wwwwwwwwwwwwwwwwwwwwwwwww2;
                }
                rectF4.right = f;
                rectF4.top = bounds.top;
                rectF4.bottom = bounds.bottom;
            }
            C2341lp c2341lp = this.Illlllllllll;
            if (c2341lp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                c2341lp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.drawableState = getState();
                C2341lp c2341lp2 = this.Illlllllllll;
                c2341lp2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Illllllllllllllllll, c2341lp2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2341lp2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            this.Illlllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setTextAlign(align);
            boolean z = Math.round(this.Illlllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkkkkkkkkk.toString())) > Math.round(this.Illllllllllllll.width());
            if (z) {
                i8 = canvas.save();
                canvas.clipRect(this.Illllllllllllll);
            } else {
                i8 = 0;
            }
            CharSequence charSequence = this.Kkkkkkkkkkkkkkkkk;
            if (z && this.IIll != null) {
                charSequence = TextUtils.ellipsize(charSequence, this.Illlllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Illllllllllllll.width(), this.IIll);
            }
            CharSequence charSequence2 = charSequence;
            int length = charSequence2.length();
            PointF pointF2 = this.Illlllllllllll;
            i5 = 0;
            i4 = i2;
            canvas.drawText(charSequence2, 0, length, pointF2.x, pointF2.y, this.Illlllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            if (z) {
                canvas.restoreToCount(i8);
            }
        }
        if (Wwwwwwwwwwwwwwwww()) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bounds, this.Illllllllllllll);
            RectF rectF5 = this.Illllllllllllll;
            float f12 = rectF5.left;
            float f13 = rectF5.top;
            canvas.translate(f12, f13);
            this.Kkkkkkkkkk.setBounds(i5, i5, (int) this.Illllllllllllll.width(), (int) this.Illllllllllllll.height());
            if (C1955bq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                this.Kkkkkkkkk.setBounds(this.Kkkkkkkkkk.getBounds());
                this.Kkkkkkkkk.jumpToCurrentState();
                drawable = this.Kkkkkkkkk;
            } else {
                drawable = this.Kkkkkkkkkk;
            }
            drawable.draw(canvas);
            canvas.translate(-f12, -f13);
        }
        Paint paint3 = this.Illllllllllllllll;
        if (paint3 != null) {
            paint3.setColor(ColorUtils.setAlphaComponent(-16777216, 127));
            canvas.drawRect(bounds, this.Illllllllllllllll);
            if (Wwwwwwwwwwwwwwwwww() || Wwwwwwwwwwwwwwwwwww()) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bounds, this.Illllllllllllll);
                canvas.drawRect(this.Illllllllllllll, this.Illllllllllllllll);
            }
            if (this.Kkkkkkkkkkkkkkkkk != null) {
                i6 = i4;
                i7 = 255;
                canvas.drawLine(bounds.left, bounds.exactCenterY(), bounds.right, bounds.exactCenterY(), this.Illllllllllllllll);
            } else {
                i6 = i4;
                i7 = 255;
            }
            if (Wwwwwwwwwwwwwwwww()) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bounds, this.Illllllllllllll);
                canvas.drawRect(this.Illllllllllllll, this.Illllllllllllllll);
            }
            this.Illllllllllllllll.setColor(ColorUtils.setAlphaComponent(-65536, 127));
            RectF rectF6 = this.Illllllllllllll;
            rectF6.set(bounds);
            if (Wwwwwwwwwwwwwwwww()) {
                float f14 = this.Illlllllllllllllllll + this.Illllllllllllllllllll + this.Kkkkkkk + this.Illlllllllllllllllllll + this.Illllllllllllllllllllll;
                if (DrawableCompat.getLayoutDirection(this) == 0) {
                    rectF6.right = bounds.right - f14;
                } else {
                    rectF6.left = bounds.left + f14;
                }
            }
            canvas.drawRect(this.Illllllllllllll, this.Illllllllllllllll);
            this.Illllllllllllllll.setColor(ColorUtils.setAlphaComponent(-16711936, 127));
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bounds, this.Illllllllllllll);
            canvas.drawRect(this.Illllllllllllll, this.Illllllllllllllll);
        } else {
            i6 = i4;
            i7 = 255;
        }
        if (this.Ill >= i7) {
            return;
        }
        canvas.restoreToCount(i6);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.Ill;
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public ColorFilter getColorFilter() {
        return this.f577Il;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.Kkkkkkkkkkkkkkkkkkkkkk;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return Math.min(Math.round(Wwwwwwwwwwwwwwwwwwwwwwww() + this.Illlllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkkkkkkkkk.toString()) + Wwwwwwwwwwwwwwwwwwwwwwwww() + this.Illllllllllllllllllllllllll + this.Illlllllllllllllllllllll + this.Illllllllllllllllllllll + this.Illlllllllllllllllll), this.O0000000000);
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(@NonNull Outline outline) {
        if (this.O000000000) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (!bounds.isEmpty()) {
            outline.setRoundRect(bounds, this.Kkkkkkkkkkkkkkkkkkkkk);
        } else {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), (int) this.Kkkkkkkkkkkkkkkkkkkkkk, this.Kkkkkkkkkkkkkkkkkkkkk);
        }
        outline.setAlpha(this.Ill / 255.0f);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        if (Wwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkkkkkkkkkkkkkkkk) || Wwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkkkkkkkkkkkkkkk) || Wwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkkkkkkkkkkkk)) {
            return true;
        }
        if (this.IIlllll && Wwwwwwwwwwwwwwwwwwwwwwwwww(this.IIllll)) {
            return true;
        }
        C2832yp c2832yp = this.Illlllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if ((c2832yp == null || (colorStateList = c2832yp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) == null || !colorStateList.isStateful()) ? false : true) {
            return true;
        }
        return (this.Kkkk && this.Kkk != null && this.Kkkkk) || Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkkkkkkk) || Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkk) || Wwwwwwwwwwwwwwwwwwwwwwwwww(this.IIllllllll);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i) {
        boolean onLayoutDirectionChanged = super.onLayoutDirectionChanged(i);
        if (Wwwwwwwwwwwwwwwwww()) {
            onLayoutDirectionChanged |= DrawableCompat.setLayoutDirection(this.Kkkkkkkkkkkkkkk, i);
        }
        if (Wwwwwwwwwwwwwwwwwww()) {
            onLayoutDirectionChanged |= DrawableCompat.setLayoutDirection(this.Kkk, i);
        }
        if (Wwwwwwwwwwwwwwwww()) {
            onLayoutDirectionChanged |= DrawableCompat.setLayoutDirection(this.Kkkkkkkkkk, i);
        }
        if (onLayoutDirectionChanged) {
            invalidateSelf();
            return true;
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i) {
        boolean onLevelChange = super.onLevelChange(i);
        if (Wwwwwwwwwwwwwwwwww()) {
            onLevelChange |= this.Kkkkkkkkkkkkkkk.setLevel(i);
        }
        if (Wwwwwwwwwwwwwwwwwww()) {
            onLevelChange |= this.Kkk.setLevel(i);
        }
        if (Wwwwwwwwwwwwwwwww()) {
            onLevelChange |= this.Kkkkkkkkkk.setLevel(i);
        }
        if (onLevelChange) {
            invalidateSelf();
        }
        return onLevelChange;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable, me.tvspark.C2341lp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public boolean onStateChange(@NonNull int[] iArr) {
        if (this.O000000000) {
            super.onStateChange(iArr);
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iArr, this.IIllllll);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.Ill != i) {
            this.Ill = i;
            invalidateSelf();
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        if (this.f577Il != colorFilter) {
            this.f577Il = colorFilter;
            invalidateSelf();
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(@Nullable ColorStateList colorStateList) {
        if (this.IIllllllll != colorStateList) {
            this.IIllllllll = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(@NonNull PorterDuff.Mode mode) {
        if (this.IIlllllll != mode) {
            this.IIlllllll = mode;
            this.IIlllllllll = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, this.IIllllllll, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (Wwwwwwwwwwwwwwwwww()) {
            visible |= this.Kkkkkkkkkkkkkkk.setVisible(z, z2);
        }
        if (Wwwwwwwwwwwwwwwwwww()) {
            visible |= this.Kkk.setVisible(z, z2);
        }
        if (Wwwwwwwwwwwwwwwww()) {
            visible |= this.Kkkkkkkkkk.setVisible(z, z2);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable ColorStateList colorStateList) {
        if (this.Kkkkkkkkkkkkkkkkkk != colorStateList) {
            this.Kkkkkkkkkkkkkkkkkk = colorStateList;
            this.IIllll = this.IIlllll ? C1955bq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(colorStateList) : null;
            onStateChange(getState());
        }
    }

    @Deprecated
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f) {
        if (this.Kkkkkkkkkkkkkkkkkkkkk != f) {
            this.Kkkkkkkkkkkkkkkkkkkkk = f;
            setShapeAppearanceModel(this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f));
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Rect rect, @NonNull RectF rectF) {
        float f;
        rectF.setEmpty();
        if (Wwwwwwwwwwwwwwwwww() || Wwwwwwwwwwwwwwwwwww()) {
            float f2 = this.Illllllllllllllllllllllllll + this.Illlllllllllllllllllllllll;
            float Wwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwww();
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                float f3 = rect.left + f2;
                rectF.left = f3;
                rectF.right = f3 + Wwwwwwwwwwwwwwwwwwwww;
            } else {
                float f4 = rect.right - f2;
                rectF.right = f4;
                rectF.left = f4 - Wwwwwwwwwwwwwwwwwwwww;
            }
            Drawable drawable = this.Illll ? this.Kkk : this.Kkkkkkkkkkkkkkk;
            if (this.Kkkkkkkkkkkkk > 0.0f || drawable == null) {
                f = this.Kkkkkkkkkkkkk;
            } else {
                f = (float) Math.ceil(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Illllllllllllllllll, 24));
                if (drawable.getIntrinsicHeight() <= f) {
                    f = drawable.getIntrinsicHeight();
                }
            }
            float exactCenterY = rect.exactCenterY() - (f / 2.0f);
            rectF.top = exactCenterY;
            rectF.bottom = exactCenterY + f;
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable Drawable drawable) {
        Drawable drawable2 = this.Kkkkkkkkkkkkkkk;
        Drawable drawable3 = null;
        Drawable unwrap = drawable2 != null ? DrawableCompat.unwrap(drawable2) : null;
        if (unwrap != drawable) {
            float Wwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwww();
            if (drawable != null) {
                drawable3 = DrawableCompat.wrap(drawable).mutate();
            }
            this.Kkkkkkkkkkkkkkk = drawable3;
            float Wwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwww();
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(unwrap);
            if (Wwwwwwwwwwwwwwwwww()) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkkkkkkk);
            }
            invalidateSelf();
            if (Wwwwwwwwwwwwwwwwwwwwwwwww == Wwwwwwwwwwwwwwwwwwwwwwwww2) {
                return;
            }
            Wwwwwwwwwwwwwwwwwwww();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00e7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull int[] iArr, @NonNull int[] iArr2) {
        boolean z;
        boolean z2;
        int colorForState;
        ColorStateList colorStateList;
        boolean onStateChange = super.onStateChange(iArr);
        ColorStateList colorStateList2 = this.Kkkkkkkkkkkkkkkkkkkkkkkk;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(colorStateList2 != null ? colorStateList2.getColorForState(iArr, this.Illllllllll) : 0);
        boolean z3 = true;
        if (this.Illllllllll != Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) {
            this.Illllllllll = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            onStateChange = true;
        }
        ColorStateList colorStateList3 = this.Kkkkkkkkkkkkkkkkkkkkkkk;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(colorStateList3 != null ? colorStateList3.getColorForState(iArr, this.Illlllllll) : 0);
        if (this.Illlllllll != Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3) {
            this.Illlllllll = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
            onStateChange = true;
        }
        int compositeColors = ColorUtils.compositeColors(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        if ((this.Illllllll != compositeColors) | (this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null)) {
            this.Illllllll = compositeColors;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ColorStateList.valueOf(compositeColors));
            onStateChange = true;
        }
        ColorStateList colorStateList4 = this.Kkkkkkkkkkkkkkkkkkkk;
        int colorForState2 = colorStateList4 != null ? colorStateList4.getColorForState(iArr, this.Illlllll) : 0;
        if (this.Illlllll != colorForState2) {
            this.Illlllll = colorForState2;
            onStateChange = true;
        }
        int colorForState3 = (this.IIllll == null || !C1955bq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iArr)) ? 0 : this.IIllll.getColorForState(iArr, this.Illllll);
        if (this.Illllll != colorForState3) {
            this.Illllll = colorForState3;
            if (this.IIlllll) {
                onStateChange = true;
            }
        }
        C2832yp c2832yp = this.Illlllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int colorForState4 = (c2832yp == null || (colorStateList = c2832yp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) == null) ? 0 : colorStateList.getColorForState(iArr, this.Illlll);
        if (this.Illlll != colorForState4) {
            this.Illlll = colorForState4;
            onStateChange = true;
        }
        int[] state = getState();
        if (state != null) {
            for (int i : state) {
                if (i == 16842912) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        boolean z4 = z && this.Kkkkk;
        if (this.Illll != z4 && this.Kkk != null) {
            float Wwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwww();
            this.Illll = z4;
            if (Wwwwwwwwwwwwwwwwwwwwwwwww != Wwwwwwwwwwwwwwwwwwwwwwwww()) {
                onStateChange = true;
                z2 = true;
                ColorStateList colorStateList5 = this.IIllllllll;
                colorForState = colorStateList5 == null ? colorStateList5.getColorForState(iArr, this.Illl) : 0;
                if (this.Illl == colorForState) {
                    this.Illl = colorForState;
                    this.IIlllllllll = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, this.IIllllllll, this.IIlllllll);
                } else {
                    z3 = onStateChange;
                }
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkkkkkkk)) {
                    z3 |= this.Kkkkkkkkkkkkkkk.setState(iArr);
                }
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkk)) {
                    z3 |= this.Kkk.setState(iArr);
                }
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkk)) {
                    int[] iArr3 = new int[iArr.length + iArr2.length];
                    System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                    System.arraycopy(iArr2, 0, iArr3, iArr.length, iArr2.length);
                    z3 |= this.Kkkkkkkkkk.setState(iArr3);
                }
                if (C1955bq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkk)) {
                    z3 |= this.Kkkkkkkkk.setState(iArr2);
                }
                if (z3) {
                    invalidateSelf();
                }
                if (z2) {
                    Wwwwwwwwwwwwwwwwwwww();
                }
                return z3;
            }
            onStateChange = true;
        }
        z2 = false;
        ColorStateList colorStateList52 = this.IIllllllll;
        if (colorStateList52 == null) {
        }
        if (this.Illl == colorForState) {
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkkkkkkk)) {
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkk)) {
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkk)) {
        }
        if (C1955bq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            z3 |= this.Kkkkkkkkk.setState(iArr2);
        }
        if (z3) {
        }
        if (z2) {
        }
        return z3;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        if (!TextUtils.equals(this.Kkkkkkkkkkkkkkkkk, charSequence)) {
            this.Kkkkkkkkkkkkkkkkk = charSequence;
            this.Illlllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
            invalidateSelf();
            Wwwwwwwwwwwwwwwwwwww();
        }
    }
}
