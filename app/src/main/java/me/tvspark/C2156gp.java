package me.tvspark;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.math.MathUtils;
import androidx.core.text.TextDirectionHeuristicsCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.internal.StaticLayoutBuilderCompat;
import me.tvspark.C2795xp;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: me.tvspark.gp */
/* loaded from: classes4.dex */
public final class C2156gp {
    @NonNull
    public static final Paint Kkkkk = null;
    public CharSequence Kkkkkkk;
    public float Kkkkkkkk;
    public float Kkkkkkkkk;
    public float Kkkkkkkkkk;
    public StaticLayout Kkkkkkkkkkk;
    public float Kkkkkkkkkkkk;
    public float Kkkkkkkkkkkkk;
    public ColorStateList Kkkkkkkkkkkkkk;
    public float Kkkkkkkkkkkkkkk;
    public float Kkkkkkkkkkkkkkkk;
    public float Kkkkkkkkkkkkkkkkk;
    public ColorStateList Kkkkkkkkkkkkkkkkkk;
    public float Kkkkkkkkkkkkkkkkkkk;
    public float Kkkkkkkkkkkkkkkkkkkk;
    public float Kkkkkkkkkkkkkkkkkkkkk;
    public TimeInterpolator Kkkkkkkkkkkkkkkkkkkkkk;
    public TimeInterpolator Kkkkkkkkkkkkkkkkkkkkkkk;
    public boolean Kkkkkkkkkkkkkkkkkkkkkkkkkk;
    public int[] Www;
    public float Wwww;
    public float Wwwww;
    public Paint Wwwwww;
    @Nullable
    public Bitmap Wwwwwww;
    public boolean Wwwwwwww;
    public boolean Wwwwwwwww;
    @Nullable
    public CharSequence Wwwwwwwwww;
    @Nullable
    public CharSequence Wwwwwwwwwww;
    public C2795xp Wwwwwwwwwwww;
    public C2795xp Wwwwwwwwwwwww;
    public Typeface Wwwwwwwwwwwwww;
    public Typeface Wwwwwwwwwwwwwww;
    public Typeface Wwwwwwwwwwwwwwww;
    public float Wwwwwwwwwwwwwwwww;
    public float Wwwwwwwwwwwwwwwwww;
    public float Wwwwwwwwwwwwwwwwwww;
    public float Wwwwwwwwwwwwwwwwwwww;
    public float Wwwwwwwwwwwwwwwwwwwww;
    public float Wwwwwwwwwwwwwwwwwwwwww;
    public ColorStateList Wwwwwwwwwwwwwwwwwwwwwww;
    public ColorStateList Wwwwwwwwwwwwwwwwwwwwwwww;
    public float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwww = 16;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwww = 16;
    public float Wwwwwwwwwwwwwwwwwwwwwwwwww = 15.0f;
    public float Wwwwwwwwwwwwwwwwwwwwwwwww = 15.0f;
    public int Kkkkkk = 1;
    @NonNull
    public final TextPaint Kkkkkkkkkkkkkkkkkkkkkkkkk = new TextPaint(129);
    @NonNull
    public final TextPaint Kkkkkkkkkkkkkkkkkkkkkkkk = new TextPaint(this.Kkkkkkkkkkkkkkkkkkkkkkkkk);
    @NonNull
    public final Rect Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Rect();
    @NonNull
    public final Rect Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Rect();
    @NonNull
    public final RectF Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = new RectF();

    /* renamed from: me.tvspark.gp$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements C2795xp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.C2795xp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Typeface typeface) {
            C2156gp.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(typeface);
        }
    }

    /* renamed from: me.tvspark.gp$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements C2795xp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.C2795xp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Typeface typeface) {
            C2156gp.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(typeface);
        }
    }

    static {
        Paint paint = null;
        if (0 != 0) {
            paint.setAntiAlias(true);
            Kkkkk.setColor(-65281);
        }
    }

    public C2156gp(View view) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = view;
    }

    public static float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f, float f2, float f3, @Nullable TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f3 = timeInterpolator.getInterpolation(f3);
        }
        return C2227im.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f, f2, f3);
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, float f) {
        float f2 = 1.0f - f;
        return Color.argb((int) ((Color.alpha(i2) * f) + (Color.alpha(i) * f2)), (int) ((Color.red(i2) * f) + (Color.red(i) * f2)), (int) ((Color.green(i2) * f) + (Color.green(i) * f2)), (int) ((Color.blue(i2) * f) + (Color.blue(i) * f2)));
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Rect rect, int i, int i2, int i3, int i4) {
        return rect.left == i && rect.top == i2 && rect.right == i3 && rect.bottom == i4;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00b3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        float centerX;
        StaticLayout staticLayout;
        float measureText;
        StaticLayout staticLayout2;
        StaticLayout staticLayout3;
        int i;
        float f;
        int i2;
        float centerX2;
        float f2;
        StaticLayout staticLayout4;
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getHeight() <= 0 || this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getWidth() <= 0) {
            return;
        }
        float f3 = this.Wwww;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwww);
        CharSequence charSequence = this.Wwwwwwwwww;
        if (charSequence != null && (staticLayout4 = this.Kkkkkkkkkkk) != null) {
            this.Kkkkkkk = TextUtils.ellipsize(charSequence, this.Kkkkkkkkkkkkkkkkkkkkkkkkk, staticLayout4.getWidth(), TextUtils.TruncateAt.END);
        }
        CharSequence charSequence2 = this.Kkkkkkk;
        float f4 = 0.0f;
        float measureText2 = charSequence2 != null ? this.Kkkkkkkkkkkkkkkkkkkkkkkkk.measureText(charSequence2, 0, charSequence2.length()) : 0.0f;
        int absoluteGravity = GravityCompat.getAbsoluteGravity(this.Wwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwww ? 1 : 0);
        int i3 = absoluteGravity & 112;
        if (i3 != 48) {
            this.Wwwwwwwwwwwwwwwwwwwww = i3 != 80 ? this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.centerY() - ((this.Kkkkkkkkkkkkkkkkkkkkkkkkk.descent() - this.Kkkkkkkkkkkkkkkkkkkkkkkkk.ascent()) / 2.0f) : this.Kkkkkkkkkkkkkkkkkkkkkkkkk.ascent() + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.bottom;
        } else {
            this.Wwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.top;
        }
        int i4 = absoluteGravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i4 == 1) {
            centerX = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.centerX();
            measureText2 /= 2.0f;
        } else if (i4 != 5) {
            this.Wwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.left;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwww);
            float height = this.Kkkkkkkkkkk == null ? staticLayout.getHeight() : 0.0f;
            CharSequence charSequence3 = this.Wwwwwwwwww;
            measureText = charSequence3 == null ? this.Kkkkkkkkkkkkkkkkkkkkkkkkk.measureText(charSequence3, 0, charSequence3.length()) : 0.0f;
            staticLayout2 = this.Kkkkkkkkkkk;
            if (staticLayout2 != null && this.Kkkkkk > 1 && !this.Wwwwwwwww) {
                measureText = staticLayout2.getWidth();
            }
            staticLayout3 = this.Kkkkkkkkkkk;
            if (staticLayout3 != null) {
                f4 = staticLayout3.getLineLeft(0);
            }
            this.Kkkkkkkk = f4;
            int absoluteGravity2 = GravityCompat.getAbsoluteGravity(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwww ? 1 : 0);
            i = absoluteGravity2 & 112;
            if (i != 48) {
                f = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.top;
            } else if (i != 80) {
                this.Wwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.centerY() - (height / 2.0f);
                i2 = absoluteGravity2 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
                if (i2 == 1) {
                    centerX2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.centerX();
                    measureText /= 2.0f;
                } else if (i2 != 5) {
                    f2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.left;
                    this.Wwwwwwwwwwwwwwwwwwww = f2;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f3);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                } else {
                    centerX2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.right;
                }
                f2 = centerX2 - measureText;
                this.Wwwwwwwwwwwwwwwwwwww = f2;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f3);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            } else {
                f = this.Kkkkkkkkkkkkkkkkkkkkkkkkk.descent() + (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.bottom - height);
            }
            this.Wwwwwwwwwwwwwwwwwwwwww = f;
            i2 = absoluteGravity2 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
            if (i2 == 1) {
            }
            f2 = centerX2 - measureText;
            this.Wwwwwwwwwwwwwwwwwwww = f2;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f3);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        } else {
            centerX = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.right;
        }
        this.Wwwwwwwwwwwwwwwwwww = centerX - measureText2;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwww);
        if (this.Kkkkkkkkkkk == null) {
        }
        CharSequence charSequence32 = this.Wwwwwwwwww;
        if (charSequence32 == null) {
        }
        staticLayout2 = this.Kkkkkkkkkkk;
        if (staticLayout2 != null) {
            measureText = staticLayout2.getWidth();
        }
        staticLayout3 = this.Kkkkkkkkkkk;
        if (staticLayout3 != null) {
        }
        this.Kkkkkkkk = f4;
        int absoluteGravity22 = GravityCompat.getAbsoluteGravity(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwww ? 1 : 0);
        i = absoluteGravity22 & 112;
        if (i != 48) {
        }
        this.Wwwwwwwwwwwwwwwwwwwwww = f;
        i2 = absoluteGravity22 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i2 == 1) {
        }
        f2 = centerX2 - measureText;
        this.Wwwwwwwwwwwwwwwwwwww = f2;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f3);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.width() > 0 && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.height() > 0 && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.width() > 0 && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.height() > 0;
    }

    @ColorInt
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f);
        this.Wwwwwwww = false;
        if (0 != 0 && this.Wwwwwww == null && !this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isEmpty() && !TextUtils.isEmpty(this.Wwwwwwwwww)) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0.0f);
            int width = this.Kkkkkkkkkkk.getWidth();
            int height = this.Kkkkkkkkkkk.getHeight();
            if (width > 0 && height > 0) {
                this.Wwwwwww = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                this.Kkkkkkkkkkk.draw(new Canvas(this.Wwwwwww));
                if (this.Wwwwww == null) {
                    this.Wwwwww = new Paint(3);
                }
            }
        }
        ViewCompat.postInvalidateOnAnimation(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww != i) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    public float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        TextPaint textPaint = this.Kkkkkkkkkkkkkkkkkkkkkkkk;
        textPaint.setTextSize(this.Wwwwwwwwwwwwwwwwwwwwwwwww);
        textPaint.setTypeface(this.Wwwwwwwwwwwwwwww);
        textPaint.setLetterSpacing(this.Kkkkkkkkkkkkk);
        return -this.Kkkkkkkkkkkkkkkkkkkkkkkk.ascent();
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ColorStateList colorStateList) {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwww != colorStateList) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = colorStateList;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Bitmap bitmap = this.Wwwwwww;
        if (bitmap != null) {
            bitmap.recycle();
            this.Wwwwwww = null;
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f) {
        boolean z;
        float f2;
        StaticLayout staticLayout;
        if (this.Wwwwwwwwwww == null) {
            return;
        }
        float width = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.width();
        float width2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.width();
        int i = 1;
        if (Math.abs(f - this.Wwwwwwwwwwwwwwwwwwwwwwwww) < 0.001f) {
            f2 = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwww = 1.0f;
            Typeface typeface = this.Wwwwwwwwwwwwww;
            Typeface typeface2 = this.Wwwwwwwwwwwwwwww;
            if (typeface != typeface2) {
                this.Wwwwwwwwwwwwww = typeface2;
                z = true;
            } else {
                z = false;
            }
        } else {
            float f3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
            Typeface typeface3 = this.Wwwwwwwwwwwwww;
            Typeface typeface4 = this.Wwwwwwwwwwwwwww;
            if (typeface3 != typeface4) {
                this.Wwwwwwwwwwwwww = typeface4;
                z = true;
            } else {
                z = false;
            }
            if (Math.abs(f - this.Wwwwwwwwwwwwwwwwwwwwwwwwww) < 0.001f) {
                this.Wwwww = 1.0f;
            } else {
                this.Wwwww = f / this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            float f4 = this.Wwwwwwwwwwwwwwwwwwwwwwwww / this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
            width = width2 * f4 > width ? Math.min(width / f4, width2) : width2;
            f2 = f3;
        }
        if (width > 0.0f) {
            z = this.Wwww != f2 || this.Kkkkkkkkkkkkkkkkkkkkkkkkkk || z;
            this.Wwww = f2;
            this.Kkkkkkkkkkkkkkkkkkkkkkkkkk = false;
        }
        if (this.Wwwwwwwwww != null && !z) {
            return;
        }
        this.Kkkkkkkkkkkkkkkkkkkkkkkkk.setTextSize(this.Wwww);
        this.Kkkkkkkkkkkkkkkkkkkkkkkkk.setTypeface(this.Wwwwwwwwwwwwww);
        this.Kkkkkkkkkkkkkkkkkkkkkkkkk.setLinearText(this.Wwwww != 1.0f);
        boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwww);
        this.Wwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        if (this.Kkkkkk > 1 && !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 && !this.Wwwwwwww) {
            i = this.Kkkkkk;
        }
        boolean z2 = this.Wwwwwwwww;
        try {
            StaticLayoutBuilderCompat staticLayoutBuilderCompat = new StaticLayoutBuilderCompat(this.Wwwwwwwwwww, this.Kkkkkkkkkkkkkkkkkkkkkkkkk, (int) width);
            staticLayoutBuilderCompat.Wwwwwwwwwwwwwwwwwwwwwwwww = TextUtils.TruncateAt.END;
            staticLayoutBuilderCompat.Wwwwwwwwwwwwwwwwwwwwwwwwww = z2;
            staticLayoutBuilderCompat.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = Layout.Alignment.ALIGN_NORMAL;
            staticLayoutBuilderCompat.Wwwwwwwwwwwwwwwwwwwwwwwwwww = false;
            staticLayoutBuilderCompat.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            staticLayout = staticLayoutBuilderCompat.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        } catch (StaticLayoutBuilderCompat.StaticLayoutBuilderCompatException e) {
            e.getCause().getMessage();
            staticLayout = null;
        }
        StaticLayout staticLayout2 = (StaticLayout) Preconditions.checkNotNull(staticLayout);
        this.Kkkkkkkkkkk = staticLayout2;
        this.Wwwwwwwwww = staticLayout2.getText();
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwww != i) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ColorStateList colorStateList) {
        if (this.Wwwwwwwwwwwwwwwwwwwwwww != colorStateList) {
            this.Wwwwwwwwwwwwwwwwwwwwwww = colorStateList;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable CharSequence charSequence) {
        if (charSequence == null || !TextUtils.equals(this.Wwwwwwwwwww, charSequence)) {
            this.Wwwwwwwwwww = charSequence;
            this.Wwwwwwwwww = null;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    public float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (this.Wwwwwwwwwww == null) {
            return 0.0f;
        }
        TextPaint textPaint = this.Kkkkkkkkkkkkkkkkkkkkkkkk;
        textPaint.setTextSize(this.Wwwwwwwwwwwwwwwwwwwwwwwww);
        textPaint.setTypeface(this.Wwwwwwwwwwwwwwww);
        textPaint.setLetterSpacing(this.Kkkkkkkkkkkkk);
        TextPaint textPaint2 = this.Kkkkkkkkkkkkkkkkkkkkkkkk;
        CharSequence charSequence = this.Wwwwwwwwwww;
        return textPaint2.measureText(charSequence, 0, charSequence.length());
    }

    @ColorInt
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.Www;
        return iArr != null ? colorStateList.getColorForState(iArr, 0) : colorStateList.getDefaultColor();
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        C2832yp c2832yp = new C2832yp(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getContext(), i);
        ColorStateList colorStateList = c2832yp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (colorStateList != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = colorStateList;
        }
        float f = c2832yp.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (f != 0.0f) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwww = f;
        }
        ColorStateList colorStateList2 = c2832yp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (colorStateList2 != null) {
            this.Kkkkkkkkkkkkkk = colorStateList2;
        }
        this.Kkkkkkkkkkkkkkkk = c2832yp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Kkkkkkkkkkkkkkk = c2832yp.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Kkkkkkkkkkkkkkkkk = c2832yp.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Kkkkkkkkkkkk = c2832yp.Wwwwwwwwwwwwwwwwwwwwwwwww;
        C2795xp c2795xp = this.Wwwwwwwwwwwww;
        if (c2795xp != null) {
            c2795xp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        c2832yp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwww = new C2795xp(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2832yp.Wwwwwwwwwwwwwwwwwwwww);
        c2832yp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getContext(), this.Wwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull CharSequence charSequence) {
        boolean z = true;
        if (ViewCompat.getLayoutDirection(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) != 1) {
            z = false;
        }
        return (z ? TextDirectionHeuristicsCompat.FIRSTSTRONG_RTL : TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR).isRtl(charSequence, 0, charSequence.length());
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f) {
        TextPaint textPaint;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.left = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.left, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.left, f, this.Kkkkkkkkkkkkkkkkkkkkkkk);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.top = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwww, f, this.Kkkkkkkkkkkkkkkkkkkkkkk);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.right = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.right, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.right, f, this.Kkkkkkkkkkkkkkkkkkkkkkk);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.bottom = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.bottom, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.bottom, f, this.Kkkkkkkkkkkkkkkkkkkkkkk);
        this.Wwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwww, f, this.Kkkkkkkkkkkkkkkkkkkkkkk);
        this.Wwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwww, f, this.Kkkkkkkkkkkkkkkkkkkkkkk);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwww, f, this.Kkkkkkkkkkkkkkkkkkkkkk));
        this.Kkkkkkkkkk = 1.0f - Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0.0f, 1.0f, 1.0f - f, C2227im.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        ViewCompat.postInvalidateOnAnimation(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        this.Kkkkkkkkk = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1.0f, 0.0f, f, C2227im.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        ViewCompat.postInvalidateOnAnimation(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        ColorStateList colorStateList = this.Wwwwwwwwwwwwwwwwwwwwwww;
        ColorStateList colorStateList2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (colorStateList != colorStateList2) {
            textPaint = this.Kkkkkkkkkkkkkkkkkkkkkkkkk;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(colorStateList2), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), f);
        } else {
            textPaint = this.Kkkkkkkkkkkkkkkkkkkkkkkkk;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        textPaint.setColor(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        float f2 = this.Kkkkkkkkkkkkk;
        float f3 = this.Kkkkkkkkkkkk;
        if (f2 != f3) {
            this.Kkkkkkkkkkkkkkkkkkkkkkkkk.setLetterSpacing(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f3, f2, f, C2227im.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
        } else {
            this.Kkkkkkkkkkkkkkkkkkkkkkkkk.setLetterSpacing(f2);
        }
        this.Kkkkkkkkkkkkkkkkkkkkkkkkk.setShadowLayer(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkkkkkkkkk, this.Kkkkkkkkkkkkkkkkkkkkk, f, null), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkkkkkkkk, this.Kkkkkkkkkkkkkkkkkkkk, f, null), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkkkkkkk, this.Kkkkkkkkkkkkkkkkkkk, f, null), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkkkkkk), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkkkkkkkkkk), f));
        ViewCompat.postInvalidateOnAnimation(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f) {
        float clamp = MathUtils.clamp(f, 0.0f, 1.0f);
        if (clamp != this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = clamp;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(clamp);
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Typeface typeface) {
        boolean z;
        C2795xp c2795xp = this.Wwwwwwwwwwww;
        boolean z2 = true;
        if (c2795xp != null) {
            c2795xp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
        }
        if (this.Wwwwwwwwwwwwwwww != typeface) {
            this.Wwwwwwwwwwwwwwww = typeface;
            z = true;
        } else {
            z = false;
        }
        C2795xp c2795xp2 = this.Wwwwwwwwwwwww;
        if (c2795xp2 != null) {
            c2795xp2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
        }
        if (this.Wwwwwwwwwwwwwww != typeface) {
            this.Wwwwwwwwwwwwwww = typeface;
        } else {
            z2 = false;
        }
        if (z || z2) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Canvas canvas) {
        int save = canvas.save();
        if (this.Wwwwwwwwww == null || !this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return;
        }
        float lineLeft = (this.Kkkkkkkkkkk.getLineLeft(0) + this.Wwwwwwwwwwwwwwwwww) - (this.Kkkkkkkk * 2.0f);
        this.Kkkkkkkkkkkkkkkkkkkkkkkkk.setTextSize(this.Wwww);
        float f = this.Wwwwwwwwwwwwwwwwww;
        float f2 = this.Wwwwwwwwwwwwwwwww;
        boolean z = true;
        boolean z2 = this.Wwwwwwww && this.Wwwwwww != null;
        float f3 = this.Wwwww;
        if (f3 != 1.0f) {
            canvas.scale(f3, f3, f, f2);
        }
        if (z2) {
            canvas.drawBitmap(this.Wwwwwww, f, f2, this.Wwwwww);
            canvas.restoreToCount(save);
            return;
        }
        if (this.Kkkkkk <= 1 || this.Wwwwwwwww || this.Wwwwwwww) {
            z = false;
        }
        if (z) {
            int alpha = this.Kkkkkkkkkkkkkkkkkkkkkkkkk.getAlpha();
            canvas.translate(lineLeft, f2);
            float f4 = alpha;
            this.Kkkkkkkkkkkkkkkkkkkkkkkkk.setAlpha((int) (this.Kkkkkkkkk * f4));
            this.Kkkkkkkkkkk.draw(canvas);
            this.Kkkkkkkkkkkkkkkkkkkkkkkkk.setAlpha((int) (this.Kkkkkkkkkk * f4));
            int lineBaseline = this.Kkkkkkkkkkk.getLineBaseline(0);
            CharSequence charSequence = this.Kkkkkkk;
            float f5 = lineBaseline;
            canvas.drawText(charSequence, 0, charSequence.length(), 0.0f, f5, this.Kkkkkkkkkkkkkkkkkkkkkkkkk);
            String trim = this.Kkkkkkk.toString().trim();
            if (trim.endsWith("…")) {
                trim = trim.substring(0, trim.length() - 1);
            }
            String str = trim;
            this.Kkkkkkkkkkkkkkkkkkkkkkkkk.setAlpha(alpha);
            canvas.drawText(str, 0, Math.min(this.Kkkkkkkkkkk.getLineEnd(0), str.length()), 0.0f, f5, (Paint) this.Kkkkkkkkkkkkkkkkkkkkkkkkk);
        } else {
            canvas.translate(f, f2);
            this.Kkkkkkkkkkk.draw(canvas);
        }
        canvas.restoreToCount(save);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        C2832yp c2832yp = new C2832yp(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getContext(), i);
        ColorStateList colorStateList = c2832yp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (colorStateList != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwww = colorStateList;
        }
        float f = c2832yp.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (f != 0.0f) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwww = f;
        }
        ColorStateList colorStateList2 = c2832yp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (colorStateList2 != null) {
            this.Kkkkkkkkkkkkkkkkkk = colorStateList2;
        }
        this.Kkkkkkkkkkkkkkkkkkkk = c2832yp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Kkkkkkkkkkkkkkkkkkk = c2832yp.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Kkkkkkkkkkkkkkkkkkkkk = c2832yp.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Kkkkkkkkkkkkk = c2832yp.Wwwwwwwwwwwwwwwwwwwwwwwww;
        C2795xp c2795xp = this.Wwwwwwwwwwww;
        if (c2795xp != null) {
            c2795xp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        c2832yp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwww = new C2795xp(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2832yp.Wwwwwwwwwwwwwwwwwwwww);
        c2832yp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getContext(), this.Wwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Typeface typeface) {
        C2795xp c2795xp = this.Wwwwwwwwwwwww;
        boolean z = true;
        if (c2795xp != null) {
            c2795xp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
        }
        if (this.Wwwwwwwwwwwwwww != typeface) {
            this.Wwwwwwwwwwwwwww = typeface;
        } else {
            z = false;
        }
        if (z) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Typeface typeface) {
        C2795xp c2795xp = this.Wwwwwwwwwwww;
        boolean z = true;
        if (c2795xp != null) {
            c2795xp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
        }
        if (this.Wwwwwwwwwwwwwwww != typeface) {
            this.Wwwwwwwwwwwwwwww = typeface;
        } else {
            z = false;
        }
        if (z) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int[] iArr) {
        ColorStateList colorStateList;
        this.Www = iArr;
        ColorStateList colorStateList2 = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if ((colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.Wwwwwwwwwwwwwwwwwwwwwwww) != null && colorStateList.isStateful())) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            return true;
        }
        return false;
    }
}
