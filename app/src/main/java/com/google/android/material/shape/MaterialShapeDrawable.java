package com.google.android.material.shape;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.core.util.ObjectsCompat;
import com.google.android.material.R$attr;
import java.util.BitSet;
import me.tvspark.AbstractC2570rq;
import me.tvspark.C1992cq;
import me.tvspark.C2305kq;
import me.tvspark.C2416nq;
import me.tvspark.C2453oq;
import me.tvspark.C2533qq;
import me.tvspark.C2605so;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public class MaterialShapeDrawable extends Drawable implements TintAwareDrawable, AbstractC2570rq {
    public boolean Www;
    @NonNull
    public final RectF Wwww;
    @Nullable
    public PorterDuffColorFilter Wwwww;
    @Nullable
    public PorterDuffColorFilter Wwwwww;
    public final C2453oq Wwwwwww;
    @NonNull
    public final C2453oq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwww;
    public final C1992cq Wwwwwwwww;
    public final Paint Wwwwwwwwww;
    public final Paint Wwwwwwwwwww;
    public C2416nq Wwwwwwwwwwww;
    public final Region Wwwwwwwwwwwww;
    public final Region Wwwwwwwwwwwwww;
    public final RectF Wwwwwwwwwwwwwww;
    public final RectF Wwwwwwwwwwwwwwww;
    public final Path Wwwwwwwwwwwwwwwww;
    public final Path Wwwwwwwwwwwwwwwwww;
    public final Matrix Wwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwww;
    public final BitSet Wwwwwwwwwwwwwwwwwwwww;
    public final C2533qq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww[] Wwwwwwwwwwwwwwwwwwwwww;
    public final C2533qq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww[] Wwwwwwwwwwwwwwwwwwwwwww;
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwww;
    public static final String Kkkkkkkkkkkkkkkkkkkkkkkkkk = MaterialShapeDrawable.class.getSimpleName();
    public static final Paint Kkkkkkkkkkkkkkkkkkkkkkkkk = new Paint(1);

    /* loaded from: classes3.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends Drawable.ConstantState {
        public Paint.Style Wwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwww;
        public float Wwwwwwwwwwwwwwwwwww;
        public float Wwwwwwwwwwwwwwwwwwww;
        public float Wwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwww;
        public float Wwwwwwwwwwwwwwwwwwwwwww;
        public float Wwwwwwwwwwwwwwwwwwwwwwww;
        public float Wwwwwwwwwwwwwwwwwwwwwwwww;
        @Nullable
        public Rect Wwwwwwwwwwwwwwwwwwwwwwwwww;
        @Nullable
        public PorterDuff.Mode Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        @Nullable
        public ColorStateList Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        @Nullable
        public ColorStateList Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        @Nullable
        public ColorStateList Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        @Nullable
        public ColorStateList Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        @Nullable
        public ColorFilter Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        @Nullable
        public C2605so Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        @NonNull
        public C2416nq Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = PorterDuff.Mode.SRC_IN;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwww = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwwww = 1.0f;
            this.Wwwwwwwwwwwwwwwwwwwwwwww = 1.0f;
            this.Wwwwwwwwwwwwwwwwwwwwww = 255;
            this.Wwwwwwwwwwwwwwwwwwwww = 0.0f;
            this.Wwwwwwwwwwwwwwwwwwww = 0.0f;
            this.Wwwwwwwwwwwwwwwwwww = 0.0f;
            this.Wwwwwwwwwwwwwwwwww = 0;
            this.Wwwwwwwwwwwwwwwww = 0;
            this.Wwwwwwwwwwwwwwww = 0;
            this.Wwwwwwwwwwwwwww = 0;
            this.Wwwwwwwwwwwwww = false;
            this.Wwwwwwwwwwwww = Paint.Style.FILL_AND_STROKE;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwww = new Rect(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww);
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2416nq c2416nq, C2605so c2605so) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = PorterDuff.Mode.SRC_IN;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwww = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwwww = 1.0f;
            this.Wwwwwwwwwwwwwwwwwwwwwwww = 1.0f;
            this.Wwwwwwwwwwwwwwwwwwwwww = 255;
            this.Wwwwwwwwwwwwwwwwwwwww = 0.0f;
            this.Wwwwwwwwwwwwwwwwwwww = 0.0f;
            this.Wwwwwwwwwwwwwwwwwww = 0.0f;
            this.Wwwwwwwwwwwwwwwwww = 0;
            this.Wwwwwwwwwwwwwwwww = 0;
            this.Wwwwwwwwwwwwwwww = 0;
            this.Wwwwwwwwwwwwwww = 0;
            this.Wwwwwwwwwwwwww = false;
            this.Wwwwwwwwwwwww = Paint.Style.FILL_AND_STROKE;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2416nq;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2605so;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this);
            materialShapeDrawable.Wwwwwwwwwwwwwwwwwwww = true;
            return materialShapeDrawable;
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements C2453oq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }
    }

    public MaterialShapeDrawable() {
        this(new C2416nq());
    }

    public MaterialShapeDrawable(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i, @StyleRes int i2) {
        this(C2416nq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, attributeSet, i, i2).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
    }

    public MaterialShapeDrawable(@NonNull Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        C2453oq c2453oq;
        this.Wwwwwwwwwwwwwwwwwwwwwww = new C2533qq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww[4];
        this.Wwwwwwwwwwwwwwwwwwwwww = new C2533qq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww[4];
        this.Wwwwwwwwwwwwwwwwwwwww = new BitSet(8);
        this.Wwwwwwwwwwwwwwwwwww = new Matrix();
        this.Wwwwwwwwwwwwwwwwww = new Path();
        this.Wwwwwwwwwwwwwwwww = new Path();
        this.Wwwwwwwwwwwwwwww = new RectF();
        this.Wwwwwwwwwwwwwww = new RectF();
        this.Wwwwwwwwwwwwww = new Region();
        this.Wwwwwwwwwwwww = new Region();
        this.Wwwwwwwwwww = new Paint(1);
        this.Wwwwwwwwww = new Paint(1);
        this.Wwwwwwwww = new C1992cq();
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            c2453oq = C2453oq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        } else {
            c2453oq = new C2453oq();
        }
        this.Wwwwwww = c2453oq;
        this.Wwww = new RectF();
        this.Www = true;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwww.setStyle(Paint.Style.STROKE);
        this.Wwwwwwwwwww.setStyle(Paint.Style.FILL);
        Kkkkkkkkkkkkkkkkkkkkkkkkk.setColor(-1);
        Kkkkkkkkkkkkkkkkkkkkkkkkk.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        Wwwwwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getState());
        this.Wwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public MaterialShapeDrawable(@NonNull C2416nq c2416nq) {
        this(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2416nq, null));
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwww() {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        float f = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww + wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwww = (int) Math.ceil(0.75f * f);
        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwww = (int) Math.ceil(f * 0.25f);
        Wwwwwwwwwwwwwwwwwwwwwwwwwww();
        super.invalidateSelf();
    }

    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwww() {
        PorterDuffColorFilter porterDuffColorFilter = this.Wwwwww;
        PorterDuffColorFilter porterDuffColorFilter2 = this.Wwwww;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwww, true);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwww, false);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwww) {
            this.Wwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.getColorForState(getState(), 0));
        }
        return !ObjectsCompat.equals(porterDuffColorFilter, this.Wwwwww) || !ObjectsCompat.equals(porterDuffColorFilter2, this.Wwwww);
    }

    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Paint.Style style = this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwww;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.Wwwwwwwwww.getStrokeWidth() > 0.0f;
    }

    public float Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
    }

    public final float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            return this.Wwwwwwwwww.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        return (int) (Math.cos(Math.toRadians(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwww)) * wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwww);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwww != i) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwww = i;
            super.invalidateSelf();
        }
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        return (int) (Math.sin(Math.toRadians(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwww)) * wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwww);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww != i) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww = i;
            super.invalidateSelf();
        }
    }

    @NonNull
    public RectF Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwwww.set(getBounds());
        return this.Wwwwwwwwwwwwwwww;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww != f) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww = f;
            this.Wwwwwwwwwwwwwwwwwwww = true;
            invalidateSelf();
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        this.Wwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwww = false;
        super.invalidateSelf();
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable ColorStateList colorStateList) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww != colorStateList) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = colorStateList;
            onStateChange(getState());
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull RectF rectF, @NonNull Path path) {
        C2453oq c2453oq = this.Wwwwwww;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        c2453oq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww, rectF, this.Wwwwwwww, path);
    }

    @NonNull
    public final PorterDuffColorFilter Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable ColorStateList colorStateList, @Nullable PorterDuff.Mode mode, @NonNull Paint paint, boolean z) {
        int color;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        if (colorStateList == null || mode == null) {
            return (!z || (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((color = paint.getColor()))) == color) ? null : new PorterDuffColorFilter(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, PorterDuff.Mode.SRC_IN);
        }
        int colorForState = colorStateList.getColorForState(getState(), 0);
        if (z) {
            colorForState = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(colorForState);
        }
        return new PorterDuffColorFilter(colorForState, mode);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww != f) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww = f;
            Wwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2605so(context);
        Wwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable ColorStateList colorStateList) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != colorStateList) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = colorStateList;
            onStateChange(getState());
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull RectF rectF, @NonNull Path path) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(rectF, path);
        if (this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwww != 1.0f) {
            this.Wwwwwwwwwwwwwwwwwww.reset();
            Matrix matrix = this.Wwwwwwwwwwwwwwwwwww;
            float f = this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwww;
            matrix.setScale(f, f, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(this.Wwwwwwwwwwwwwwwwwww);
        }
        path.computeBounds(this.Wwww, true);
    }

    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int[] iArr) {
        boolean z;
        int color;
        int colorForState;
        int color2;
        int colorForState2;
        if (this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null || color2 == (colorForState2 = this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getColorForState(iArr, (color2 = this.Wwwwwwwwwww.getColor())))) {
            z = false;
        } else {
            this.Wwwwwwwwwww.setColor(colorForState2);
            z = true;
        }
        if (this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null || color == (colorForState = this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getColorForState(iArr, (color = this.Wwwwwwwwww.getColor())))) {
            return z;
        }
        this.Wwwwwwwwww.setColor(colorForState);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x00b1, code lost:
        if ((!r2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) && !r10.Wwwwwwwwwwwwwwwwww.isConvex() && android.os.Build.VERSION.SDK_INT < 29) != false) goto L18;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0173  */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void draw(@NonNull Canvas canvas) {
        boolean z;
        Paint.Style style;
        this.Wwwwwwwwwww.setColorFilter(this.Wwwwww);
        int alpha = this.Wwwwwwwwwww.getAlpha();
        Paint paint = this.Wwwwwwwwwww;
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww;
        paint.setAlpha(((i + (i >>> 7)) * alpha) >>> 8);
        this.Wwwwwwwwww.setColorFilter(this.Wwwww);
        this.Wwwwwwwwww.setStrokeWidth(this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww);
        int alpha2 = this.Wwwwwwwwww.getAlpha();
        Paint paint2 = this.Wwwwwwwwww;
        int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww;
        paint2.setAlpha(((i2 + (i2 >>> 7)) * alpha2) >>> 8);
        boolean z2 = false;
        if (this.Wwwwwwwwwwwwwwwwwwww) {
            C2416nq Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new C2305kq(this, -Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww()));
            this.Wwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            C2453oq c2453oq = this.Wwwwwww;
            float f = this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwww.set(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            this.Wwwwwwwwwwwwwww.inset(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            c2453oq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, f, this.Wwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwww);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), this.Wwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwww = false;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        int i3 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww;
        if (i3 != 1 && wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwww > 0) {
            if (i3 != 2) {
            }
            z = true;
            if (z) {
                canvas.save();
                canvas.translate(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                if (!this.Www) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(canvas);
                } else {
                    int width = (int) (this.Wwww.width() - getBounds().width());
                    int height = (int) (this.Wwww.height() - getBounds().height());
                    if (width < 0 || height < 0) {
                        throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
                    }
                    Bitmap createBitmap = Bitmap.createBitmap((this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwww * 2) + ((int) this.Wwww.width()) + width, (this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwww * 2) + ((int) this.Wwww.height()) + height, Bitmap.Config.ARGB_8888);
                    Canvas canvas2 = new Canvas(createBitmap);
                    float f2 = (getBounds().left - this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwww) - width;
                    float f3 = (getBounds().top - this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwww) - height;
                    canvas2.translate(-f2, -f3);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(canvas2);
                    canvas.drawBitmap(createBitmap, f2, f3, (Paint) null);
                    createBitmap.recycle();
                }
                canvas.restore();
            }
            style = this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwww;
            if (style != Paint.Style.FILL_AND_STROKE || style == Paint.Style.FILL) {
                z2 = true;
            }
            if (z2) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(canvas, this.Wwwwwwwwwww, this.Wwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            }
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                Paint paint3 = this.Wwwwwwwwww;
                Path path = this.Wwwwwwwwwwwwwwwww;
                C2416nq c2416nq = this.Wwwwwwwwwwww;
                this.Wwwwwwwwwwwwwww.set(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                this.Wwwwwwwwwwwwwww.inset(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(canvas, paint3, path, c2416nq, this.Wwwwwwwwwwwwwww);
            }
            this.Wwwwwwwwwww.setAlpha(alpha);
            this.Wwwwwwwwww.setAlpha(alpha2);
        }
        z = false;
        if (z) {
        }
        style = this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwww;
        if (style != Paint.Style.FILL_AND_STROKE) {
        }
        z2 = true;
        if (z2) {
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
        }
        this.Wwwwwwwwwww.setAlpha(alpha);
        this.Wwwwwwwwww.setAlpha(alpha2);
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Drawable.ConstantState getConstantState() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(@NonNull Outline outline) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww == 2) {
            return;
        }
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww())) {
            outline.setRoundRect(getBounds(), Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() * this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww);
            return;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), this.Wwwwwwwwwwwwwwwwww);
        if (!this.Wwwwwwwwwwwwwwwwww.isConvex() && Build.VERSION.SDK_INT < 29) {
            return;
        }
        try {
            outline.setConvexPath(this.Wwwwwwwwwwwwwwwwww);
        } catch (IllegalArgumentException unused) {
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@NonNull Rect rect) {
        Rect rect2 = this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww;
        if (rect2 != null) {
            rect.set(rect2);
            return true;
        }
        return super.getPadding(rect);
    }

    @Override // me.tvspark.AbstractC2570rq
    @NonNull
    public C2416nq getShapeAppearanceModel() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        this.Wwwwwwwwwwwwww.set(getBounds());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), this.Wwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwww.setPath(this.Wwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwww.op(this.Wwwwwwwwwwwww, Region.Op.DIFFERENCE);
        return this.Wwwwwwwwwwwwww;
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        this.Wwwwwwwwwwwwwwwwwwww = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        ColorStateList colorStateList4;
        return super.isStateful() || ((colorStateList = this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww) != null && colorStateList.isStateful()) || (((colorStateList2 = this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) != null && colorStateList2.isStateful()) || (((colorStateList3 = this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) != null && colorStateList3.isStateful()) || ((colorStateList4 = this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) != null && colorStateList4.isStateful())));
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public Drawable mutate() {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.Wwwwwwwwwwwwwwwwwwww = true;
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable, me.tvspark.C2341lp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public boolean onStateChange(int[] iArr) {
        boolean z = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iArr) || Wwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (z) {
            invalidateSelf();
        }
        return z;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, m4212to = 255) int i) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww != i) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww = i;
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = colorFilter;
        super.invalidateSelf();
    }

    @Override // me.tvspark.AbstractC2570rq
    public void setShapeAppearanceModel(@NonNull C2416nq c2416nq) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2416nq;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTint(@ColorInt int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(@Nullable ColorStateList colorStateList) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = colorStateList;
        Wwwwwwwwwwwwwwwwwwwwwwwwwww();
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(@Nullable PorterDuff.Mode mode) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww != mode) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww = mode;
            Wwwwwwwwwwwwwwwwwwwwwwwwwww();
            super.invalidateSelf();
        }
    }

    @ColorInt
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@ColorInt int i) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        float f = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww + wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww + wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww;
        C2605so c2605so = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        return c2605so != null ? c2605so.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, f) : i;
    }

    @NonNull
    public static MaterialShapeDrawable Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, float f) {
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, R$attr.colorSurface, MaterialShapeDrawable.class.getSimpleName());
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        materialShapeDrawable.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2605so(context);
        materialShapeDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwww();
        materialShapeDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ColorStateList.valueOf(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = materialShapeDrawable.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww != f) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww = f;
            materialShapeDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        return materialShapeDrawable;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Canvas canvas) {
        this.Wwwwwwwwwwwwwwwwwwwww.cardinality();
        if (this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwww != 0) {
            canvas.drawPath(this.Wwwwwwwwwwwwwwwwww, this.Wwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        for (int i = 0; i < 4; i++) {
            this.Wwwwwwwwwwwwwwwwwwwwwww[i].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2533qq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwww, canvas);
            this.Wwwwwwwwwwwwwwwwwwwwww[i].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2533qq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwww, canvas);
        }
        if (this.Www) {
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            canvas.translate(-Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, -Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            canvas.drawPath(this.Wwwwwwwwwwwwwwwwww, Kkkkkkkkkkkkkkkkkkkkkkkkk);
            canvas.translate(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull Path path, @NonNull C2416nq c2416nq, @NonNull RectF rectF) {
        if (!c2416nq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(rectF)) {
            canvas.drawPath(path, paint);
            return;
        }
        float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2416nq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(rectF) * this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww;
        canvas.drawRoundRect(rectF, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, paint);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f, @ColorInt int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww = f;
        invalidateSelf();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ColorStateList.valueOf(i));
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f, @Nullable ColorStateList colorStateList) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww = f;
        invalidateSelf();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(colorStateList);
    }
}
