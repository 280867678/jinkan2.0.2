package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.RoundRectDrawableWithShadow;
import androidx.core.util.Preconditions;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.transition.ArcMotion;
import androidx.transition.PathMotion;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;
import com.google.android.material.R$attr;
import com.google.android.material.R$id;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.common.collect.LinkedHashMultimap;
import java.util.Map;
import me.tvspark.AbstractC1995ct;
import me.tvspark.AbstractC2570rq;
import me.tvspark.AbstractC2572rs;
import me.tvspark.AbstractC2761ws;
import me.tvspark.C2049dt;
import me.tvspark.C2227im;
import me.tvspark.C2416nq;
import me.tvspark.C2452op;
import me.tvspark.C2609ss;
import me.tvspark.C2646ts;
import me.tvspark.C2798xs;
import me.tvspark.C2835ys;
import me.tvspark.C2872zs;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public final class MaterialContainerTransform extends Transition {
    public float Wwwwwwwwww;
    public float Wwwwwwwwwww;
    public boolean Wwwwwwwwwwww;
    public static final String Wwwwwwwww = MaterialContainerTransform.class.getSimpleName();
    public static final String[] Wwwwwwww = {"materialContainerTransition:bounds", "materialContainerTransition:shapeAppearance"};
    public static final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0.0f, 0.25f), new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0.0f, 1.0f), new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0.0f, 1.0f), new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0.0f, 0.75f), null);
    public static final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0.6f, 0.9f), new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0.0f, 1.0f), new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0.0f, 0.9f), new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0.3f, 0.9f), null);
    public static final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0.1f, 0.4f), new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0.1f, 1.0f), new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0.1f, 1.0f), new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0.1f, 0.9f), null);
    public static final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0.6f, 0.9f), new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0.0f, 0.9f), new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0.0f, 0.9f), new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0.2f, 0.9f), null);
    public boolean Wwwwwwwwwwwwwwwwwwwwwwww = false;
    public boolean Wwwwwwwwwwwwwwwwwwwwwww = false;
    @IdRes
    public int Wwwwwwwwwwwwwwwwwwwwww = 16908290;
    @IdRes
    public int Wwwwwwwwwwwwwwwwwwwww = -1;
    @IdRes
    public int Wwwwwwwwwwwwwwwwwwww = -1;
    @ColorInt
    public int Wwwwwwwwwwwwwwwwwww = 0;
    @ColorInt
    public int Wwwwwwwwwwwwwwwwww = 0;
    @ColorInt
    public int Wwwwwwwwwwwwwwwww = 0;
    @ColorInt
    public int Wwwwwwwwwwwwwwww = 1375731712;
    public int Wwwwwwwwwwwwwww = 0;
    public int Wwwwwwwwwwwwww = 0;
    public int Wwwwwwwwwwwww = 0;

    /* loaded from: classes3.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends Drawable {
        public float Kkkkkkkkkkkkkkkkkkkkk;
        public float Kkkkkkkkkkkkkkkkkkkkkk;
        public float Kkkkkkkkkkkkkkkkkkkkkkk;
        public RectF Kkkkkkkkkkkkkkkkkkkkkkkk;
        public C2835ys Kkkkkkkkkkkkkkkkkkkkkkkkk;
        public C2646ts Kkkkkkkkkkkkkkkkkkkkkkkkkk;
        public final boolean Wwwww;
        public final AbstractC2761ws Wwwwww;
        public final AbstractC2572rs Wwwwwww;
        public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwww;
        public final RectF Wwwwwwwww;
        public final RectF Wwwwwwwwww;
        public final RectF Wwwwwwwwwww;
        public final RectF Wwwwwwwwwwww;
        public final boolean Wwwwwwwwwwwwww;
        public final float Wwwwwwwwwwwwwww;
        public final float Wwwwwwwwwwwwwwww;
        public final boolean Wwwwwwwwwwwwwwwww;
        public final float Wwwwwwwwwwwwwwwwwww;
        public final PathMeasure Wwwwwwwwwwwwwwwwwwww;
        public final float Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final C2416nq Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final RectF Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final C2416nq Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final RectF Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final Paint Wwwwwwwwwwwwwwwwwwwwwwwwww = new Paint();
        public final Paint Wwwwwwwwwwwwwwwwwwwwwwwww = new Paint();
        public final Paint Wwwwwwwwwwwwwwwwwwwwwwww = new Paint();
        public final Paint Wwwwwwwwwwwwwwwwwwwwwww = new Paint();
        public final Paint Wwwwwwwwwwwwwwwwwwwwww = new Paint();
        public final C2872zs Wwwwwwwwwwwwwwwwwwwww = new C2872zs();
        public final float[] Wwwwwwwwwwwwwwwwww = new float[2];
        public final MaterialShapeDrawable Wwwwwwwwwwwww = new MaterialShapeDrawable();
        public final Paint Wwww = new Paint();
        public final Path Www = new Path();

        /* loaded from: classes3.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements C2049dt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            }

            @Override // me.tvspark.C2049dt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
            public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Canvas canvas) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.draw(canvas);
            }
        }

        /* loaded from: classes3.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements C2049dt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            }

            @Override // me.tvspark.C2049dt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
            public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Canvas canvas) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.draw(canvas);
            }
        }

        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(PathMotion pathMotion, View view, RectF rectF, C2416nq c2416nq, float f, View view2, RectF rectF2, C2416nq c2416nq2, float f2, int i, int i2, int i3, int i4, boolean z, boolean z2, AbstractC2572rs abstractC2572rs, AbstractC2761ws abstractC2761ws, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, boolean z3, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = view;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = rectF;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2416nq;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = f;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = view2;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = rectF2;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = c2416nq2;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = f2;
            this.Wwwwwwwwwwwwwwwww = z;
            this.Wwwwwwwwwwwwww = z2;
            this.Wwwwwww = abstractC2572rs;
            this.Wwwwww = abstractC2761ws;
            this.Wwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwww = z3;
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            this.Wwwwwwwwwwwwwwww = displayMetrics.widthPixels;
            this.Wwwwwwwwwwwwwww = displayMetrics.heightPixels;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwww.setColor(i);
            this.Wwwwwwwwwwwwwwwwwwwwwwwww.setColor(i2);
            this.Wwwwwwwwwwwwwwwwwwwwwwww.setColor(i3);
            this.Wwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ColorStateList.valueOf(0));
            this.Wwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
            MaterialShapeDrawable materialShapeDrawable = this.Wwwwwwwwwwwww;
            materialShapeDrawable.Www = false;
            materialShapeDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(-7829368);
            this.Wwwwwwwwwwww = new RectF(rectF);
            this.Wwwwwwwwwww = new RectF(this.Wwwwwwwwwwww);
            this.Wwwwwwwwww = new RectF(this.Wwwwwwwwwwww);
            this.Wwwwwwwww = new RectF(this.Wwwwwwwwww);
            PointF Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(rectF);
            PointF Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(rectF2);
            PathMeasure pathMeasure = new PathMeasure(pathMotion.getPath(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.x, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.y, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.x, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.y), false);
            this.Wwwwwwwwwwwwwwwwwwww = pathMeasure;
            this.Wwwwwwwwwwwwwwwwwww = pathMeasure.getLength();
            this.Wwwwwwwwwwwwwwwwww[0] = rectF.centerX();
            this.Wwwwwwwwwwwwwwwwww[1] = rectF.top;
            this.Wwwwwwwwwwwwwwwwwwwwww.setStyle(Paint.Style.FILL);
            this.Wwwwwwwwwwwwwwwwwwwwww.setShader(C2049dt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i4));
            this.Wwww.setStyle(Paint.Style.STROKE);
            this.Wwww.setStrokeWidth(10.0f);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0.0f);
        }

        public static PointF Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(RectF rectF) {
            return new PointF(rectF.centerX(), rectF.top);
        }

        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Canvas canvas) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(canvas, this.Wwwwwwwwwwwwwwwwwwwwwwwww);
            Rect bounds = getBounds();
            RectF rectF = this.Wwwwwwwwwwww;
            C2049dt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(canvas, bounds, rectF.left, rectF.top, this.Kkkkkkkkkkkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Kkkkkkkkkkkkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        }

        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f) {
            float f2;
            float f3;
            this.Kkkkkkkkkkkkkkkkkkkkk = f;
            this.Wwwwwwwwwwwwwwwwwwwwww.setAlpha((int) (this.Wwwwwwwwwwwwwwwww ? C2049dt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0.0f, 255.0f, f) : C2049dt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(255.0f, 0.0f, f)));
            this.Wwwwwwwwwwwwwwwwwwww.getPosTan(this.Wwwwwwwwwwwwwwwwwww * f, this.Wwwwwwwwwwwwwwwwww, null);
            float[] fArr = this.Wwwwwwwwwwwwwwwwww;
            float f4 = fArr[0];
            float f5 = fArr[1];
            int i = (f > 1.0f ? 1 : (f == 1.0f ? 0 : -1));
            if (i > 0 || f < 0.0f) {
                if (i > 0) {
                    f2 = 0.99f;
                    f3 = (f - 1.0f) / 0.00999999f;
                } else {
                    f2 = 0.01f;
                    f3 = (f / 0.01f) * (-1.0f);
                }
                this.Wwwwwwwwwwwwwwwwwwww.getPosTan(this.Wwwwwwwwwwwwwwwwwww * f2, this.Wwwwwwwwwwwwwwwwww, null);
                float[] fArr2 = this.Wwwwwwwwwwwwwwwwww;
                float f6 = fArr2[0];
                float f7 = fArr2[1];
                f4 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f4, f6, f3, f4);
                f5 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f5, f7, f3, f5);
            }
            float f8 = f5;
            float f9 = f4;
            C2835ys Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f, ((Float) Preconditions.checkNotNull(Float.valueOf(this.Wwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww))).floatValue(), ((Float) Preconditions.checkNotNull(Float.valueOf(this.Wwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww))).floatValue(), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.width(), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.height(), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.width(), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.height());
            this.Kkkkkkkkkkkkkkkkkkkkkkkkk = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            RectF rectF = this.Wwwwwwwwwwww;
            float f10 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww / 2.0f;
            rectF.set(f9 - f10, f8, f10 + f9, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + f8);
            RectF rectF2 = this.Wwwwwwwwww;
            C2835ys c2835ys = this.Kkkkkkkkkkkkkkkkkkkkkkkkk;
            float f11 = c2835ys.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww / 2.0f;
            rectF2.set(f9 - f11, f8, f11 + f9, c2835ys.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww + f8);
            this.Wwwwwwwwwww.set(this.Wwwwwwwwwwww);
            this.Wwwwwwwww.set(this.Wwwwwwwwww);
            float floatValue = ((Float) Preconditions.checkNotNull(Float.valueOf(this.Wwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww))).floatValue();
            float floatValue2 = ((Float) Preconditions.checkNotNull(Float.valueOf(this.Wwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww))).floatValue();
            boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = this.Wwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkkkkkkkkkkkkkkkkk);
            RectF rectF3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 ? this.Wwwwwwwwwww : this.Wwwwwwwww;
            float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = C2049dt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0.0f, 1.0f, floatValue, floatValue2, f);
            if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = 1.0f - Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4;
            }
            this.Wwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(rectF3, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4, this.Kkkkkkkkkkkkkkkkkkkkkkkkk);
            this.Kkkkkkkkkkkkkkkkkkkkkkkk = new RectF(Math.min(this.Wwwwwwwwwww.left, this.Wwwwwwwww.left), Math.min(this.Wwwwwwwwwww.top, this.Wwwwwwwww.top), Math.max(this.Wwwwwwwwwww.right, this.Wwwwwwwww.right), Math.max(this.Wwwwwwwwwww.bottom, this.Wwwwwwwww.bottom));
            C2872zs c2872zs = this.Wwwwwwwwwwwwwwwwwwwww;
            C2416nq c2416nq = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            C2416nq c2416nq2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
            RectF rectF4 = this.Wwwwwwwwwwww;
            RectF rectF5 = this.Wwwwwwwwwww;
            RectF rectF6 = this.Wwwwwwwww;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (c2872zs != null) {
                C2416nq Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = C2049dt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2416nq, c2416nq2, rectF4, rectF6, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, f);
                c2872zs.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5;
                c2872zs.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5, 1.0f, rectF5, c2872zs.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                c2872zs.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2872zs.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 1.0f, rectF6, c2872zs.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                if (Build.VERSION.SDK_INT >= 23) {
                    c2872zs.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.op(c2872zs.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2872zs.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Path.Op.UNION);
                }
                this.Kkkkkkkkkkkkkkkkkkkkkkk = C2049dt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwww, f);
                RectF rectF7 = this.Kkkkkkkkkkkkkkkkkkkkkkkk;
                float f12 = this.Wwwwwwwwwwwwwwww;
                RectF rectF8 = this.Kkkkkkkkkkkkkkkkkkkkkkkk;
                float f13 = this.Wwwwwwwwwwwwwww;
                float f14 = this.Kkkkkkkkkkkkkkkkkkkkkkk;
                float centerY = (int) ((rectF8.centerY() / f13) * 1.5f * f14);
                this.Kkkkkkkkkkkkkkkkkkkkkk = centerY;
                this.Wwwwwwwwwwwwwwwwwwwwwww.setShadowLayer(f14, (int) (((rectF7.centerX() / (f12 / 2.0f)) - 1.0f) * 0.3f * f14), centerY, 754974720);
                this.Kkkkkkkkkkkkkkkkkkkkkkkkkk = this.Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f, ((Float) Preconditions.checkNotNull(Float.valueOf(this.Wwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww))).floatValue(), ((Float) Preconditions.checkNotNull(Float.valueOf(this.Wwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww))).floatValue());
                if (this.Wwwwwwwwwwwwwwwwwwwwwwwww.getColor() != 0) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwww.setAlpha(this.Kkkkkkkkkkkkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                }
                if (this.Wwwwwwwwwwwwwwwwwwwwwwww.getColor() != 0) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwww.setAlpha(this.Kkkkkkkkkkkkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                }
                invalidateSelf();
                return;
            }
            throw null;
        }

        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Canvas canvas) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(canvas, this.Wwwwwwwwwwwwwwwwwwwwwwww);
            Rect bounds = getBounds();
            RectF rectF = this.Wwwwwwwwww;
            C2049dt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(canvas, bounds, rectF.left, rectF.top, this.Kkkkkkkkkkkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Kkkkkkkkkkkkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        }

        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Canvas canvas, Paint paint) {
            if (paint.getColor() == 0 || paint.getAlpha() <= 0) {
                return;
            }
            canvas.drawRect(getBounds(), paint);
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(@NonNull Canvas canvas) {
            if (this.Wwwwwwwwwwwwwwwwwwwwww.getAlpha() > 0) {
                canvas.drawRect(getBounds(), this.Wwwwwwwwwwwwwwwwwwwwww);
            }
            int save = this.Wwwww ? canvas.save() : -1;
            if (this.Wwwwwwwwwwwwww && this.Kkkkkkkkkkkkkkkkkkkkkkk > 0.0f) {
                canvas.save();
                canvas.clipPath(this.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Region.Op.DIFFERENCE);
                if (Build.VERSION.SDK_INT > 28) {
                    C2416nq c2416nq = this.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (c2416nq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkkkkkkkkkkkkkkkk)) {
                        float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2416nq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkkkkkkkkkkkkkkkk);
                        canvas.drawRoundRect(this.Kkkkkkkkkkkkkkkkkkkkkkkk, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, this.Wwwwwwwwwwwwwwwwwwwwwww);
                    } else {
                        canvas.drawPath(this.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwww);
                    }
                } else {
                    MaterialShapeDrawable materialShapeDrawable = this.Wwwwwwwwwwwww;
                    RectF rectF = this.Kkkkkkkkkkkkkkkkkkkkkkkk;
                    materialShapeDrawable.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
                    this.Wwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkkkkkkkkkkkkkkk);
                    this.Wwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.Kkkkkkkkkkkkkkkkkkkkkk);
                    this.Wwwwwwwwwwwww.setShapeAppearanceModel(this.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    this.Wwwwwwwwwwwww.draw(canvas);
                }
                canvas.restore();
            }
            C2872zs c2872zs = this.Wwwwwwwwwwwwwwwwwwwww;
            if (Build.VERSION.SDK_INT >= 23) {
                canvas.clipPath(c2872zs.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            } else {
                canvas.clipPath(c2872zs.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                canvas.clipPath(c2872zs.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Region.Op.UNION);
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(canvas, this.Wwwwwwwwwwwwwwwwwwwwwwwwww);
            if (this.Kkkkkkkkkkkkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(canvas);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(canvas);
            } else {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(canvas);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(canvas);
            }
            if (this.Wwwww) {
                canvas.restoreToCount(save);
                RectF rectF2 = this.Wwwwwwwwwwww;
                Path path = this.Www;
                PointF Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(rectF2);
                if (this.Kkkkkkkkkkkkkkkkkkkkk == 0.0f) {
                    path.reset();
                    path.moveTo(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.x, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.y);
                } else {
                    path.lineTo(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.x, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.y);
                    this.Wwww.setColor(-65281);
                    canvas.drawPath(path, this.Wwww);
                }
                RectF rectF3 = this.Wwwwwwwwwww;
                this.Wwww.setColor(InputDeviceCompat.SOURCE_ANY);
                canvas.drawRect(rectF3, this.Wwww);
                RectF rectF4 = this.Wwwwwwwwwwww;
                this.Wwww.setColor(-16711936);
                canvas.drawRect(rectF4, this.Wwww);
                RectF rectF5 = this.Wwwwwwwww;
                this.Wwww.setColor(-16711681);
                canvas.drawRect(rectF5, this.Wwww);
                RectF rectF6 = this.Wwwwwwwwww;
                this.Wwww.setColor(-16776961);
                canvas.drawRect(rectF6, this.Wwww);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
            throw new UnsupportedOperationException("Setting alpha on is not supported");
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(@Nullable ColorFilter colorFilter) {
            throw new UnsupportedOperationException("Setting a color filter is not supported");
        }
    }

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        @NonNull
        public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        @NonNull
        public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        @NonNull
        public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        @NonNull
        public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4;
        }
    }

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        @FloatRange(from = RoundRectDrawableWithShadow.COS_45, m4213to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR)
        public final float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        @FloatRange(from = RoundRectDrawableWithShadow.COS_45, m4213to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR)
        public final float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@FloatRange(from = 0.0d, m4213to = 1.0d) float f, @FloatRange(from = 0.0d, m4213to = 1.0d) float f2) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = f;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = f2;
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC1995ct {
        public final /* synthetic */ View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(View view, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, View view2, View view3) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = view;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = view2;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = view3;
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(@NonNull Transition transition) {
            MaterialContainerTransform.this.mo4381removeListener(this);
            if (MaterialContainerTransform.this.Wwwwwwwwwwwwwwwwwwwwwww) {
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setAlpha(1.0f);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setAlpha(1.0f);
            View view = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            (view == null ? null : new C2452op(view)).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.remove(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionStart(@NonNull Transition transition) {
            View view = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            (view == null ? null : new C2452op(view)).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setAlpha(0.0f);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setAlpha(0.0f);
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(MaterialContainerTransform materialContainerTransform, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            float animatedFraction = valueAnimator.getAnimatedFraction();
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Kkkkkkkkkkkkkkkkkkkkk != animatedFraction) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(animatedFraction);
            }
        }
    }

    public MaterialContainerTransform() {
        boolean z = false;
        this.Wwwwwwwwwwww = Build.VERSION.SDK_INT >= 28 ? true : z;
        this.Wwwwwwwwwww = -1.0f;
        this.Wwwwwwwwww = -1.0f;
        mo4387setInterpolator(C2227im.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull TransitionValues transitionValues, @Nullable View view, @IdRes int i, @Nullable C2416nq c2416nq) {
        View view2;
        C2416nq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        if (i != -1) {
            view = C2049dt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(transitionValues.view, i);
        } else if (view == null) {
            if (transitionValues.view.getTag(R$id.mtrl_motion_snapshot_view) instanceof View) {
                view = (View) transitionValues.view.getTag(R$id.mtrl_motion_snapshot_view);
                transitionValues.view.setTag(R$id.mtrl_motion_snapshot_view, null);
            }
            view2 = transitionValues.view;
            if (ViewCompat.isLaidOut(view2) && view2.getWidth() == 0 && view2.getHeight() == 0) {
                return;
            }
            RectF Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = view2.getParent() != null ? C2049dt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view2) : C2049dt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view2);
            transitionValues.values.put("materialContainerTransition:bounds", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            Map<String, Object> map = transitionValues.values;
            if (c2416nq == null) {
                if (view2.getTag(R$id.mtrl_motion_snapshot_view) instanceof C2416nq) {
                    c2416nq = (C2416nq) view2.getTag(R$id.mtrl_motion_snapshot_view);
                } else {
                    Context context = view2.getContext();
                    TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new int[]{R$attr.transitionShapeAppearance});
                    int resourceId = obtainStyledAttributes.getResourceId(0, -1);
                    obtainStyledAttributes.recycle();
                    if (resourceId != -1) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2416nq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, resourceId, 0);
                    } else if (view2 instanceof AbstractC2570rq) {
                        c2416nq = ((AbstractC2570rq) view2).getShapeAppearanceModel();
                    } else {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2416nq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    }
                    c2416nq = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                }
            }
            map.put("materialContainerTransition:shapeAppearance", C2049dt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2416nq, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2));
        }
        transitionValues.view = view;
        view2 = transitionValues.view;
        if (ViewCompat.isLaidOut(view2)) {
        }
        if (view2.getParent() != null) {
        }
        transitionValues.values.put("materialContainerTransition:bounds", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        Map<String, Object> map2 = transitionValues.values;
        if (c2416nq == null) {
        }
        map2.put("materialContainerTransition:shapeAppearance", C2049dt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2416nq, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2));
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(transitionValues, null, this.Wwwwwwwwwwwwwwwwwwww, null);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(transitionValues, null, this.Wwwwwwwwwwwwwwwwwwwww, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x00ca, code lost:
        if ((r14.height() * r14.width()) > (r10.height() * r10.width())) goto L41;
     */
    @Override // androidx.transition.Transition
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Animator createAnimator(@NonNull ViewGroup viewGroup, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        RectF rectF;
        boolean z;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        if (transitionValues != null && transitionValues2 != null) {
            RectF rectF2 = (RectF) transitionValues.values.get("materialContainerTransition:bounds");
            C2416nq c2416nq = (C2416nq) transitionValues.values.get("materialContainerTransition:shapeAppearance");
            if (rectF2 != null && c2416nq != null) {
                RectF rectF3 = (RectF) transitionValues2.values.get("materialContainerTransition:bounds");
                C2416nq c2416nq2 = (C2416nq) transitionValues2.values.get("materialContainerTransition:shapeAppearance");
                if (rectF3 != null && c2416nq2 != null) {
                    View view = transitionValues.view;
                    View view2 = transitionValues2.view;
                    View view3 = view2.getParent() != null ? view2 : view;
                    if (this.Wwwwwwwwwwwwwwwwwwwwww == view3.getId()) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = (View) view3.getParent();
                    } else {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2049dt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view3, this.Wwwwwwwwwwwwwwwwwwwwww);
                        view3 = null;
                    }
                    RectF Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = C2049dt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                    float f = -Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.left;
                    float f2 = -Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.top;
                    if (view3 != null) {
                        rectF = C2049dt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view3);
                        rectF.offset(f, f2);
                    } else {
                        rectF = new RectF(0.0f, 0.0f, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getWidth(), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getHeight());
                    }
                    rectF2.offset(f, f2);
                    rectF3.offset(f, f2);
                    int i = this.Wwwwwwwwwwwwwww;
                    if (i != 0) {
                        if (i != 1) {
                            if (i != 2) {
                                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid transition direction: ");
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.append(this.Wwwwwwwwwwwwwww);
                                throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.toString());
                            }
                            z = false;
                        }
                        z = true;
                    }
                    PathMotion pathMotion = getPathMotion();
                    float f3 = this.Wwwwwwwwwww;
                    if (f3 == -1.0f) {
                        f3 = ViewCompat.getElevation(view);
                    }
                    float f4 = f3;
                    float f5 = this.Wwwwwwwwww;
                    if (f5 == -1.0f) {
                        f5 = ViewCompat.getElevation(view2);
                    }
                    float f6 = f5;
                    int i2 = this.Wwwwwwwwwwwwwwwwwww;
                    int i3 = this.Wwwwwwwwwwwwwwwwww;
                    int i4 = this.Wwwwwwwwwwwwwwwww;
                    View view4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                    int i5 = this.Wwwwwwwwwwwwwwww;
                    RectF rectF4 = rectF;
                    boolean z2 = this.Wwwwwwwwwwww;
                    AbstractC2572rs Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = C2609ss.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwww, z);
                    AbstractC2761ws Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = C2798xs.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwww, z, rectF2, rectF3);
                    PathMotion pathMotion2 = getPathMotion();
                    if ((pathMotion2 instanceof ArcMotion) || (pathMotion2 instanceof MaterialArcMotion)) {
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwww;
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwww;
                    } else {
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwww;
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwww;
                    }
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(pathMotion, view, rectF2, c2416nq, f4, view2, rectF3, c2416nq2, f6, i2, i3, i4, i5, z, z2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2), this.Wwwwwwwwwwwwwwwwwwwwwwww, null);
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setBounds(Math.round(rectF4.left), Math.round(rectF4.top), Math.round(rectF4.right), Math.round(rectF4.bottom));
                    ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                    ofFloat.addUpdateListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, wwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
                    mo4375addListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view4, wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, view, view2));
                    return ofFloat;
                }
            }
        }
        return null;
    }

    @Override // androidx.transition.Transition
    @Nullable
    public String[] getTransitionProperties() {
        return Wwwwwwww;
    }

    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) {
        if (!z) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        }
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) C2049dt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) null, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) C2049dt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) null, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) C2049dt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) null, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) C2049dt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) null, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), null);
    }
}
