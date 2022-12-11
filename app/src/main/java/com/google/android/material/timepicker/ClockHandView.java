package com.google.android.material.timepicker;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import androidx.annotation.AbstractC0047Px;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import java.util.ArrayList;
import java.util.List;
import me.tvspark.C2122fs;
import me.tvspark.C2159gs;

/* loaded from: classes3.dex */
public class ClockHandView extends View {
    public int Wwwwwwww;
    public double Wwwwwwwww;
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwww;
    public boolean Wwwwwwwwwww;
    public float Wwwwwwwwwwww;
    @AbstractC0047Px
    public final int Wwwwwwwwwwwww;
    public final RectF Wwwwwwwwwwwwww;
    public final Paint Wwwwwwwwwwwwwww;
    public final float Wwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwww;
    public final List<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwww;
    public float Wwwwwwwwwwwwwwwwwwwww;
    public float Wwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwww;
    public ValueAnimator Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes3.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@FloatRange(from = 0.0d, m4213to = 360.0d) float f, boolean z);
    }

    /* loaded from: classes3.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AnimatorListenerAdapter {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ClockHandView clockHandView) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            animator.end();
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements ValueAnimator.AnimatorUpdateListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ClockHandView.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((Float) valueAnimator.getAnimatedValue()).floatValue(), true);
        }
    }

    public ClockHandView(Context context) {
        this(context, null);
    }

    public ClockHandView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.materialClockStyle);
    }

    public ClockHandView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Wwwwwwwwwwwwwwwwww = new ArrayList();
        this.Wwwwwwwwwwwwwww = new Paint();
        this.Wwwwwwwwwwwwww = new RectF();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ClockHandView, i, R$style.Widget_MaterialComponents_TimePicker_Clock);
        this.Wwwwwwww = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ClockHandView_materialCircleRadius, 0);
        this.Wwwwwwwwwwwwwwwww = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ClockHandView_selectorSize, 0);
        Resources resources = getResources();
        this.Wwwwwwwwwwwww = resources.getDimensionPixelSize(R$dimen.material_clock_hand_stroke_width);
        this.Wwwwwwwwwwwwwwww = resources.getDimensionPixelSize(R$dimen.material_clock_hand_center_dot_radius);
        int color = obtainStyledAttributes.getColor(R$styleable.ClockHandView_clockHandColor, 0);
        this.Wwwwwwwwwwwwwww.setAntiAlias(true);
        this.Wwwwwwwwwwwwwww.setColor(color);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0.0f, false);
        this.Wwwwwwwwwwwwwwwwwww = ViewConfiguration.get(context).getScaledTouchSlop();
        ViewCompat.setImportantForAccessibility(this, 2);
        obtainStyledAttributes.recycle();
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@FloatRange(from = 0.0d, m4213to = 360.0d) float f, boolean z) {
        float f2 = f % 360.0f;
        this.Wwwwwwwwwwww = f2;
        this.Wwwwwwwww = Math.toRadians(f2 - 90.0f);
        float cos = (this.Wwwwwwww * ((float) Math.cos(this.Wwwwwwwww))) + (getWidth() / 2);
        float sin = (this.Wwwwwwww * ((float) Math.sin(this.Wwwwwwwww))) + (getHeight() / 2);
        RectF rectF = this.Wwwwwwwwwwwwww;
        int i = this.Wwwwwwwwwwwwwwwww;
        rectF.set(cos - i, sin - i, cos + i, sin + i);
        for (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : this.Wwwwwwwwwwwwwwwwww) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f2, z);
        }
        invalidate();
    }

    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f, float f2) {
        int degrees = ((int) Math.toDegrees(Math.atan2(f2 - (getHeight() / 2), f - (getWidth() / 2)))) + 90;
        return degrees < 0 ? degrees + 360 : degrees;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@FloatRange(from = 0.0d, m4213to = 360.0d) float f, boolean z) {
        ValueAnimator valueAnimator = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (!z) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f, false);
            return;
        }
        float f2 = this.Wwwwwwwwwwww;
        if (Math.abs(f2 - f) > 180.0f) {
            if (f2 > 180.0f && f < 180.0f) {
                f += 360.0f;
            }
            if (f2 < 180.0f && f > 180.0f) {
                f2 += 360.0f;
            }
        }
        Pair pair = new Pair(Float.valueOf(f2), Float.valueOf(f));
        ValueAnimator ofFloat = ValueAnimator.ofFloat(((Float) pair.first).floatValue(), ((Float) pair.second).floatValue());
        this.Wwwwwwwwwwwwwwwwwwwwwwww = ofFloat;
        ofFloat.setDuration(200L);
        this.Wwwwwwwwwwwwwwwwwwwwwwww.addUpdateListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        this.Wwwwwwwwwwwwwwwwwwwwwwww.addListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this));
        this.Wwwwwwwwwwwwwwwwwwwwwwww.start();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int width;
        super.onDraw(canvas);
        int height = getHeight() / 2;
        float width2 = getWidth() / 2;
        float f = height;
        this.Wwwwwwwwwwwwwww.setStrokeWidth(0.0f);
        canvas.drawCircle((this.Wwwwwwww * ((float) Math.cos(this.Wwwwwwwww))) + width2, (this.Wwwwwwww * ((float) Math.sin(this.Wwwwwwwww))) + f, this.Wwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwww);
        double sin = Math.sin(this.Wwwwwwwww);
        double cos = Math.cos(this.Wwwwwwwww);
        this.Wwwwwwwwwwwwwww.setStrokeWidth(this.Wwwwwwwwwwwww);
        canvas.drawLine(width2, f, width + ((int) (cos * r6)), height + ((int) (r6 * sin)), this.Wwwwwwwwwwwwwww);
        canvas.drawCircle(width2, f, this.Wwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwww);
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwww, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b3  */
    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        C2159gs c2159gs;
        C2122fs c2122fs;
        int i;
        int i2;
        C2122fs c2122fs2;
        int actionMasked = motionEvent.getActionMasked();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (actionMasked != 0) {
            if (actionMasked == 1 || actionMasked == 2) {
                int i3 = (int) (x - this.Wwwwwwwwwwwwwwwwwwwwww);
                int i4 = (int) (y - this.Wwwwwwwwwwwwwwwwwwwww);
                this.Wwwwwwwwwwwwwwwwwwww = (i4 * i4) + (i3 * i3) > this.Wwwwwwwwwwwwwwwwwww;
                z2 = this.Wwwwwwwwwww;
                z = actionMasked == 1;
            } else {
                z = false;
                z2 = false;
            }
            z3 = false;
        } else {
            this.Wwwwwwwwwwwwwwwwwwwwww = x;
            this.Wwwwwwwwwwwwwwwwwwwww = y;
            this.Wwwwwwwwwwwwwwwwwwww = true;
            this.Wwwwwwwwwww = false;
            z = false;
            z2 = false;
            z3 = true;
        }
        boolean z6 = this.Wwwwwwwwwww;
        float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(x, y);
        boolean z7 = this.Wwwwwwwwwwww != Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        if (!z3 || !z7) {
            if (z7 || z2) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, z && this.Wwwwwwwwwwwwwwwwwwwwwww);
            } else {
                z4 = false;
                z5 = z4 | z6;
                this.Wwwwwwwwwww = z5;
                if (z5 && z && (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwww) != null) {
                    float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(x, y);
                    boolean z8 = this.Wwwwwwwwwwwwwwwwwwww;
                    c2159gs = (C2159gs) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    c2159gs.Wwwwwwwwwwwwwwwwwwww = true;
                    c2122fs = c2159gs.Wwwwwwwwwwwwwwwwwwwwwww;
                    i = c2122fs.Wwwwwwwwwwwwwwwwwwww;
                    int i5 = c2122fs.Wwwwwwwwwwwwwwwwwwwww;
                    if (c2122fs.Wwwwwwwwwwwwwwwwwww != 10) {
                        c2159gs.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2159gs.Wwwwwwwwwwwwwwwwwwwww, false);
                        if (!((AccessibilityManager) ContextCompat.getSystemService(c2159gs.Wwwwwwwwwwwwwwwwwwwwwwww.getContext(), AccessibilityManager.class)).isTouchExplorationEnabled()) {
                            c2159gs.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(12, true);
                        }
                    } else {
                        int round = Math.round(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
                        if (!z8) {
                            C2122fs c2122fs3 = c2159gs.Wwwwwwwwwwwwwwwwwwwwwww;
                            int i6 = ((round + 15) / 30) * 5;
                            if (c2122fs3 != null) {
                                c2122fs3.Wwwwwwwwwwwwwwwwwwww = i6 % 60;
                                c2159gs.Wwwwwwwwwwwwwwwwwwwwww = i2 * 6;
                            } else {
                                throw null;
                            }
                        }
                        c2159gs.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2159gs.Wwwwwwwwwwwwwwwwwwwwww, z8);
                    }
                    c2159gs.Wwwwwwwwwwwwwwwwwwww = false;
                    c2159gs.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    c2122fs2 = c2159gs.Wwwwwwwwwwwwwwwwwwwwwww;
                    if (c2122fs2.Wwwwwwwwwwwwwwwwwwww == i || c2122fs2.Wwwwwwwwwwwwwwwwwwwww != i5) {
                        c2159gs.Wwwwwwwwwwwwwwwwwwwwwwww.performHapticFeedback(4);
                    }
                }
                return true;
            }
        }
        z4 = true;
        z5 = z4 | z6;
        this.Wwwwwwwwwww = z5;
        if (z5) {
            float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww32 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(x, y);
            boolean z82 = this.Wwwwwwwwwwwwwwwwwwww;
            c2159gs = (C2159gs) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            c2159gs.Wwwwwwwwwwwwwwwwwwww = true;
            c2122fs = c2159gs.Wwwwwwwwwwwwwwwwwwwwwww;
            i = c2122fs.Wwwwwwwwwwwwwwwwwwww;
            int i52 = c2122fs.Wwwwwwwwwwwwwwwwwwwww;
            if (c2122fs.Wwwwwwwwwwwwwwwwwww != 10) {
            }
            c2159gs.Wwwwwwwwwwwwwwwwwwww = false;
            c2159gs.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            c2122fs2 = c2159gs.Wwwwwwwwwwwwwwwwwwwwwww;
            if (c2122fs2.Wwwwwwwwwwwwwwwwwwww == i) {
            }
            c2159gs.Wwwwwwwwwwwwwwwwwwwwwwww.performHapticFeedback(4);
        }
        return true;
    }
}
