package me.tvspark;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: me.tvspark.bp */
/* loaded from: classes4.dex */
public class C1954bp {
    @Nullable
    public ViewTreeObserver.OnPreDrawListener Wwww;
    public final AbstractC2046dq Wwwwwwwww;
    public final FloatingActionButton Wwwwwwwwww;
    public ArrayList<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwww;
    public ArrayList<Animator.AnimatorListener> Wwwwwwwwwwww;
    public ArrayList<Animator.AnimatorListener> Wwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwww;
    public float Wwwwwwwwwwwwwwwww;
    @Nullable
    public C2449om Wwwwwwwwwwwwwwwwww;
    @Nullable
    public C2449om Wwwwwwwwwwwwwwwwwww;
    @Nullable
    public Animator Wwwwwwwwwwwwwwwwwwww;
    @Nullable
    public C2449om Wwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public C2449om Wwwwwwwwwwwwwwwwwwwwww;
    @NonNull
    public final C2304kp Wwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwww;
    public float Wwwwwwwwwwwwwwwwwwwwwwwww;
    public float Wwwwwwwwwwwwwwwwwwwwwwwwww;
    public float Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public Drawable Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public C2757wo Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public Drawable Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public MaterialShapeDrawable Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public C2416nq Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static final TimeInterpolator Www = C2227im.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static final int[] Kkkkkkkkkkkkkkkkkkkkkkkkkk = {16842919, 16842910};
    public static final int[] Kkkkkkkkkkkkkkkkkkkkkkkkk = {16843623, 16842908, 16842910};
    public static final int[] Kkkkkkkkkkkkkkkkkkkkkkkk = {16842908, 16842910};
    public static final int[] Kkkkkkkkkkkkkkkkkkkkkkk = {16843623, 16842910};
    public static final int[] Kkkkkkkkkkkkkkkkkkkkkk = {16842910};
    public static final int[] Kkkkkkkkkkkkkkkkkkkkk = new int[0];
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
    public float Wwwwwwwwwwwwwwww = 1.0f;
    public int Wwwwwwwwwwwwww = 0;
    public final Rect Wwwwwwww = new Rect();
    public final RectF Wwwwwww = new RectF();
    public final RectF Wwwwww = new RectF();
    public final Matrix Wwwww = new Matrix();

    /* renamed from: me.tvspark.bp$Wwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public abstract class Wwwwwwwwwwwwwwwwwwwwwwwwwww extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {
        public float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwww(C2868zo c2868zo) {
        }

        public abstract float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            C1954bp.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                MaterialShapeDrawable materialShapeDrawable = C1954bp.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = materialShapeDrawable == null ? 0.0f : materialShapeDrawable.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
            }
            C1954bp c1954bp = C1954bp.this;
            float f = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            c1954bp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) ((valueAnimator.getAnimatedFraction() * (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - f)) + f));
        }
    }

    /* renamed from: me.tvspark.bp$Wwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwww extends Wwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            super(null);
        }

        @Override // me.tvspark.C1954bp.Wwwwwwwwwwwwwwwwwwwwwwwwwww
        public float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return C1954bp.this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
    }

    /* renamed from: me.tvspark.bp$Wwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    /* renamed from: me.tvspark.bp$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    /* renamed from: me.tvspark.bp$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends Wwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            super(null);
        }

        @Override // me.tvspark.C1954bp.Wwwwwwwwwwwwwwwwwwwwwwwwwww
        public float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            C1954bp c1954bp = C1954bp.this;
            return c1954bp.Wwwwwwwwwwwwwwwwwwwwwwwwwww + c1954bp.Wwwwwwwwwwwwwwwwwwwwwwwww;
        }
    }

    /* renamed from: me.tvspark.bp$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends Wwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            super(null);
        }

        @Override // me.tvspark.C1954bp.Wwwwwwwwwwwwwwwwwwwwwwwwwww
        public float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            C1954bp c1954bp = C1954bp.this;
            return c1954bp.Wwwwwwwwwwwwwwwwwwwwwwwwwww + c1954bp.Wwwwwwwwwwwwwwwwwwwwwwwwww;
        }
    }

    /* renamed from: me.tvspark.bp$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends Wwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C1954bp c1954bp) {
            super(null);
        }

        @Override // me.tvspark.C1954bp.Wwwwwwwwwwwwwwwwwwwwwwwwwww
        public float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return 0.0f;
        }
    }

    /* renamed from: me.tvspark.bp$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends C2412nm {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.animation.TypeEvaluator
        public Matrix evaluate(float f, @NonNull Matrix matrix, @NonNull Matrix matrix2) {
            C1954bp.this.Wwwwwwwwwwwwwwww = f;
            matrix.getValues(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            matrix2.getValues(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            for (int i = 0; i < 9; i++) {
                float[] fArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                float f2 = fArr[i];
                float[] fArr2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                fArr[i] = ((f2 - fArr2[i]) * f) + fArr2[i];
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setValues(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
    }

    public C1954bp(FloatingActionButton floatingActionButton, AbstractC2046dq abstractC2046dq) {
        this.Wwwwwwwwww = floatingActionButton;
        this.Wwwwwwwww = abstractC2046dq;
        C2304kp c2304kp = new C2304kp();
        this.Wwwwwwwwwwwwwwwwwwwwwww = c2304kp;
        c2304kp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Kkkkkkkkkkkkkkkkkkkkkkkkkk, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()));
        this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Kkkkkkkkkkkkkkkkkkkkkkkkk, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()));
        this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Kkkkkkkkkkkkkkkkkkkkkkkk, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()));
        this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Kkkkkkkkkkkkkkkkkkkkkkk, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()));
        this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Kkkkkkkkkkkkkkkkkkkkkk, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Wwwwwwwwwwwwwwwwwwwwwwwwwwww()));
        this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Kkkkkkkkkkkkkkkkkkkkk, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this)));
        this.Wwwwwwwwwwwwwwwww = this.Wwwwwwwwww.getRotation();
    }

    public final void Wwwwwwwwwwwwwwwwwwwwww() {
        FloatingActionButton.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Drawable drawable;
        Rect rect = this.Wwwwwwww;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(rect);
        Preconditions.checkNotNull(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "Didn't initialize content background");
        if (!Wwwwwwwwwwwwwwwwwwwwwwwwww()) {
            AbstractC2046dq abstractC2046dq = this.Wwwwwwwww;
            Drawable drawable2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            FloatingActionButton.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = (FloatingActionButton.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) abstractC2046dq;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null) {
                if (drawable2 != null) {
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                    drawable = drawable2;
                }
                AbstractC2046dq abstractC2046dq2 = this.Wwwwwwwww;
                int i = rect.left;
                int i2 = rect.top;
                int i3 = rect.right;
                int i4 = rect.bottom;
                FloatingActionButton.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = (FloatingActionButton.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) abstractC2046dq2;
                FloatingActionButton.this.Wwwwwwwwwwww.set(i, i2, i3, i4);
                FloatingActionButton floatingActionButton = FloatingActionButton.this;
                int i5 = floatingActionButton.Wwwwwwwwwwwwwww;
                floatingActionButton.setPadding(i + i5, i2 + i5, i3 + i5, i4 + i5);
            }
            throw null;
        }
        drawable = new InsetDrawable(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, rect.left, rect.top, rect.right, rect.bottom);
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (FloatingActionButton.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) this.Wwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            throw null;
        }
        super/*android.widget.ImageButton*/.setBackgroundDrawable(drawable);
        AbstractC2046dq abstractC2046dq22 = this.Wwwwwwwww;
        int i6 = rect.left;
        int i22 = rect.top;
        int i32 = rect.right;
        int i42 = rect.bottom;
        FloatingActionButton.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww32 = (FloatingActionButton.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) abstractC2046dq22;
        FloatingActionButton.this.Wwwwwwwwwwww.set(i6, i22, i32, i42);
        FloatingActionButton floatingActionButton2 = FloatingActionButton.this;
        int i52 = floatingActionButton2.Wwwwwwwwwwwwwww;
        floatingActionButton2.setPadding(i6 + i52, i22 + i52, i32 + i52, i42 + i52);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwww() {
        throw null;
    }

    public final boolean Wwwwwwwwwwwwwwwwwwwwwwww() {
        return !this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww || this.Wwwwwwwwww.getSizeDimension() >= this.Wwwwwwwwwwwwwwwwwwwwwwww;
    }

    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwww() {
        return ViewCompat.isLaidOut(this.Wwwwwwwwww) && !this.Wwwwwwwwww.isInEditMode();
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwww() {
        throw null;
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwww() {
        throw null;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        ArrayList<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww> arrayList = this.Wwwwwwwwwww;
        if (arrayList != null) {
            Iterator<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        ArrayList<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww> arrayList = this.Wwwwwwwwwww;
        if (arrayList != null) {
            Iterator<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        throw null;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        throw null;
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwww.getVisibility() != 0 ? this.Wwwwwwwwwwwwww == 2 : this.Wwwwwwwwwwwwww != 1;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f) {
        MaterialShapeDrawable materialShapeDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (materialShapeDrawable != null) {
            MaterialShapeDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = materialShapeDrawable.Wwwwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww == f) {
                return;
            }
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww = f;
            materialShapeDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwww.getVisibility() == 0 ? this.Wwwwwwwwwwwwww == 1 : this.Wwwwwwwwwwwwww != 2;
    }

    public float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        throw null;
    }

    @NonNull
    public final AnimatorSet Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull C2449om c2449om, float f, float f2, float f3) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.Wwwwwwwwww, View.ALPHA, f);
        c2449om.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("opacity").Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ofFloat);
        arrayList.add(ofFloat);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.Wwwwwwwwww, View.SCALE_X, f2);
        c2449om.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("scale").Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ofFloat2);
        if (Build.VERSION.SDK_INT == 26) {
            ofFloat2.setEvaluator(new C1991cp(this));
        }
        arrayList.add(ofFloat2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.Wwwwwwwwww, View.SCALE_Y, f2);
        c2449om.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("scale").Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ofFloat3);
        if (Build.VERSION.SDK_INT == 26) {
            ofFloat3.setEvaluator(new C1991cp(this));
        }
        arrayList.add(ofFloat3);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f3, this.Wwwww);
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this.Wwwwwwwwww, new C2375mm(), new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), new Matrix(this.Wwwww));
        c2449om.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("iconScale").Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ofObject);
        arrayList.add(ofObject);
        AnimatorSet animatorSet = new AnimatorSet();
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(animatorSet, (List<Animator>) arrayList);
        return animatorSet;
    }

    @NonNull
    public final ValueAnimator Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Wwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwww) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(Www);
        valueAnimator.setDuration(100L);
        valueAnimator.addListener(wwwwwwwwwwwwwwwwwwwwwwwwwww);
        valueAnimator.addUpdateListener(wwwwwwwwwwwwwwwwwwwwwwwwwww);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        return valueAnimator;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f) {
        this.Wwwwwwwwwwwwwwww = f;
        Matrix matrix = this.Wwwww;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f, matrix);
        this.Wwwwwwwwww.setImageMatrix(matrix);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f, float f2, float f3) {
        throw null;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f, @NonNull Matrix matrix) {
        matrix.reset();
        Drawable drawable = this.Wwwwwwwwww.getDrawable();
        if (drawable == null || this.Wwwwwwwwwwwwwww == 0) {
            return;
        }
        RectF rectF = this.Wwwwwww;
        RectF rectF2 = this.Wwwwww;
        rectF.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        int i = this.Wwwwwwwwwwwwwww;
        rectF2.set(0.0f, 0.0f, i, i);
        matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
        int i2 = this.Wwwwwwwwwwwwwww;
        matrix.postScale(f, f, i2 / 2.0f, i2 / 2.0f);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable ColorStateList colorStateList) {
        throw null;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ColorStateList colorStateList, @Nullable PorterDuff.Mode mode, ColorStateList colorStateList2, int i) {
        throw null;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Rect rect) {
        int sizeDimension = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww ? (this.Wwwwwwwwwwwwwwwwwwwwwwww - this.Wwwwwwwwww.getSizeDimension()) / 2 : 0;
        float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() + this.Wwwwwwwwwwwwwwwwwwwwwwwww : 0.0f;
        int max = Math.max(sizeDimension, (int) Math.ceil(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2));
        int max2 = Math.max(sizeDimension, (int) Math.ceil(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 * 1.5f));
        rect.set(max, max2, max, max2);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int[] iArr) {
        throw null;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull C2416nq c2416nq) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2416nq;
        MaterialShapeDrawable materialShapeDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2416nq;
            materialShapeDrawable.invalidateSelf();
        }
        Drawable drawable = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (drawable instanceof AbstractC2570rq) {
            ((AbstractC2570rq) drawable).setShapeAppearanceModel(c2416nq);
        }
        C2757wo c2757wo = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (c2757wo != null) {
            c2757wo.Wwwwwwwwwwwwwwwwwwww = c2416nq;
            c2757wo.invalidateSelf();
        }
    }
}
