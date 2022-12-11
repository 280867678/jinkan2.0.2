package com.google.android.material.snackbar;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$layout;
import com.google.android.material.R$styleable;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import java.util.List;
import me.tvspark.AbstractC2121fr;
import me.tvspark.C1919ar;
import me.tvspark.C1957bs;
import me.tvspark.C1993cr;
import me.tvspark.C2047dr;
import me.tvspark.C2084er;
import me.tvspark.C2195hr;
import me.tvspark.C2227im;
import me.tvspark.C2415np;
import me.tvspark.C2681uq;
import me.tvspark.C2722vq;
import me.tvspark.C2870zq;
import me.tvspark.Illllllllllllllllllllllllllll;
import me.tvspark.RunnableC1956br;
import me.tvspark.RunnableC2607sq;

/* loaded from: classes3.dex */
public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {
    public static final int[] Wwwwwwwwwwwwwwwwww = {R$attr.snackbarStyle};
    @NonNull
    public static final Handler Wwwwwwwwwwwwwwwwwww = new Handler(Looper.getMainLooper(), new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
    @Nullable
    public final AccessibilityManager Wwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public Rect Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @NonNull
    public final AbstractC2121fr Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @NonNull
    public final Wwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Context Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @NonNull
    public final ViewGroup Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
    @RequiresApi(29)
    public final Runnable Wwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    @NonNull
    public C2195hr.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    /* loaded from: classes3.dex */
    public static class Behavior extends SwipeDismissBehavior<View> {
        @NonNull
        public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);

        @Override // com.google.android.material.behavior.SwipeDismissBehavior
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(View view) {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwww != null) {
                return view instanceof Wwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            throw null;
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull MotionEvent motionEvent) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                int actionMasked = motionEvent.getActionMasked();
                if (actionMasked != 0) {
                    if (actionMasked == 1 || actionMasked == 3) {
                        C2195hr.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    }
                } else if (coordinatorLayout.isPointInChildBounds(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                    C2195hr.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                }
                return super.onInterceptTouchEvent(coordinatorLayout, view, motionEvent);
            }
            throw null;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwww extends FrameLayout {
        public static final View.OnTouchListener Wwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        public PorterDuff.Mode Wwwwwwwwwwwwwwwwww;
        public ColorStateList Wwwwwwwwwwwwwwwwwww;
        public final float Wwwwwwwwwwwwwwwwwwww;
        public final float Wwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwww;
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwww;
        public Wwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwww;

        /* loaded from: classes3.dex */
        public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnTouchListener {
            @Override // android.view.View.OnTouchListener
            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Context context) {
            this(context, null);
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Context context, AttributeSet attributeSet) {
            super(C1957bs.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, attributeSet, 0, 0), attributeSet);
            Drawable wrap;
            Context context2 = getContext();
            TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R$styleable.SnackbarLayout);
            if (obtainStyledAttributes.hasValue(R$styleable.SnackbarLayout_elevation)) {
                ViewCompat.setElevation(this, obtainStyledAttributes.getDimensionPixelSize(R$styleable.SnackbarLayout_elevation, 0));
            }
            this.Wwwwwwwwwwwwwwwwwwwwww = obtainStyledAttributes.getInt(R$styleable.SnackbarLayout_animationMode, 0);
            this.Wwwwwwwwwwwwwwwwwwwww = obtainStyledAttributes.getFloat(R$styleable.SnackbarLayout_backgroundOverlayColorAlpha, 1.0f);
            setBackgroundTintList(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context2, obtainStyledAttributes, R$styleable.SnackbarLayout_backgroundTint));
            setBackgroundTintMode(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obtainStyledAttributes.getInt(R$styleable.SnackbarLayout_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN));
            this.Wwwwwwwwwwwwwwwwwwww = obtainStyledAttributes.getFloat(R$styleable.SnackbarLayout_actionTextColorAlpha, 1.0f);
            obtainStyledAttributes.recycle();
            setOnTouchListener(Wwwwwwwwwwwwwwwww);
            setFocusable(true);
            if (getBackground() == null) {
                float dimension = getResources().getDimension(R$dimen.mtrl_snackbar_background_corner_radius);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setCornerRadius(dimension);
                int i = R$attr.colorSurface;
                int i2 = R$attr.colorOnSurface;
                gradientDrawable.setColor(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((View) this, i), Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((View) this, i2), getBackgroundOverlayColorAlpha()));
                if (this.Wwwwwwwwwwwwwwwwwww != null) {
                    wrap = DrawableCompat.wrap(gradientDrawable);
                    DrawableCompat.setTintList(wrap, this.Wwwwwwwwwwwwwwwwwww);
                } else {
                    wrap = DrawableCompat.wrap(gradientDrawable);
                }
                ViewCompat.setBackground(this, wrap);
            }
        }

        public float getActionTextColorAlpha() {
            return this.Wwwwwwwwwwwwwwwwwwww;
        }

        public int getAnimationMode() {
            return this.Wwwwwwwwwwwwwwwwwwwwww;
        }

        public float getBackgroundOverlayColorAlpha() {
            return this.Wwwwwwwwwwwwwwwwwwwww;
        }

        @Override // android.view.ViewGroup, android.view.View
        public void onAttachedToWindow() {
            super.onAttachedToWindow();
            Wwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                ((C1993cr) wwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
            }
            ViewCompat.requestApplyInsets(this);
        }

        @Override // android.view.ViewGroup, android.view.View
        public void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            Wwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                C1993cr c1993cr = (C1993cr) wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                BaseTransientBottomBar baseTransientBottomBar = c1993cr.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (baseTransientBottomBar != null) {
                    if (!C2195hr.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseTransientBottomBar.Wwwwwwwwwwwwwwwwwwww)) {
                        return;
                    }
                    BaseTransientBottomBar.Wwwwwwwwwwwwwwwwwww.post(new RunnableC1956br(c1993cr));
                    return;
                }
                throw null;
            }
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        public void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            Wwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                C2047dr c2047dr = (C2047dr) wwwwwwwwwwwwwwwwwwwwwwwwwww;
                c2047dr.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setOnLayoutChangeListener(null);
                c2047dr.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        }

        public void setAnimationMode(int i) {
            this.Wwwwwwwwwwwwwwwwwwwwww = i;
        }

        @Override // android.view.View
        public void setBackground(@Nullable Drawable drawable) {
            setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundDrawable(@Nullable Drawable drawable) {
            if (drawable != null && this.Wwwwwwwwwwwwwwwwwww != null) {
                drawable = DrawableCompat.wrap(drawable.mutate());
                DrawableCompat.setTintList(drawable, this.Wwwwwwwwwwwwwwwwwww);
                DrawableCompat.setTintMode(drawable, this.Wwwwwwwwwwwwwwwwww);
            }
            super.setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
            this.Wwwwwwwwwwwwwwwwwww = colorStateList;
            if (getBackground() != null) {
                Drawable wrap = DrawableCompat.wrap(getBackground().mutate());
                DrawableCompat.setTintList(wrap, colorStateList);
                DrawableCompat.setTintMode(wrap, this.Wwwwwwwwwwwwwwwwww);
                if (wrap == getBackground()) {
                    return;
                }
                super.setBackgroundDrawable(wrap);
            }
        }

        @Override // android.view.View
        public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
            this.Wwwwwwwwwwwwwwwwww = mode;
            if (getBackground() != null) {
                Drawable wrap = DrawableCompat.wrap(getBackground().mutate());
                DrawableCompat.setTintMode(wrap, mode);
                if (wrap == getBackground()) {
                    return;
                }
                super.setBackgroundDrawable(wrap);
            }
        }

        public void setOnAttachStateChangeListener(Wwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // android.view.View
        public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
            setOnTouchListener(onClickListener != null ? null : Wwwwwwwwwwwwwwwww);
            super.setOnClickListener(onClickListener);
        }

        public void setOnLayoutChangeListener(Wwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes3.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes3.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public C2195hr.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull SwipeDismissBehavior<?> swipeDismissBehavior) {
            if (swipeDismissBehavior != null) {
                swipeDismissBehavior.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = SwipeDismissBehavior.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0.0f, 0.1f, 1.0f);
                swipeDismissBehavior.Wwwwwwwwwwwwwwwwwwwwwwwwwww = SwipeDismissBehavior.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0.0f, 0.6f, 1.0f);
                swipeDismissBehavior.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
                return;
            }
            throw null;
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements C2195hr.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.C2195hr.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            Handler handler = BaseTransientBottomBar.Wwwwwwwwwwwwwwwwwww;
            handler.sendMessage(handler.obtainMessage(1, i, 0, BaseTransientBottomBar.this));
        }

        @Override // me.tvspark.C2195hr.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void show() {
            Handler handler = BaseTransientBottomBar.Wwwwwwwwwwwwwwwwwww;
            handler.sendMessage(handler.obtainMessage(0, BaseTransientBottomBar.this));
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AccessibilityDelegateCompat {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.addAction(1048576);
            accessibilityNodeInfoCompat.setDismissable(true);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (i == 1048576) {
                ((Snackbar) BaseTransientBottomBar.this).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3);
                return true;
            }
            return super.performAccessibilityAction(view, i, bundle);
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements OnApplyWindowInsetsListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        @NonNull
        public WindowInsetsCompat onApplyWindowInsets(View view, @NonNull WindowInsetsCompat windowInsetsCompat) {
            BaseTransientBottomBar.this.Wwwwwwwwwwwwwwwwwwwwwwwwww = windowInsetsCompat.getSystemWindowInsetBottom();
            BaseTransientBottomBar.this.Wwwwwwwwwwwwwwwwwwwwwwwww = windowInsetsCompat.getSystemWindowInsetLeft();
            BaseTransientBottomBar.this.Wwwwwwwwwwwwwwwwwwwwwwww = windowInsetsCompat.getSystemWindowInsetRight();
            BaseTransientBottomBar.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            return windowInsetsCompat;
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Context context;
            BaseTransientBottomBar baseTransientBottomBar = BaseTransientBottomBar.this;
            if (baseTransientBottomBar.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null || (context = baseTransientBottomBar.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) == null) {
                return;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
            int i = displayMetrics.heightPixels;
            BaseTransientBottomBar baseTransientBottomBar2 = BaseTransientBottomBar.this;
            int[] iArr = new int[2];
            baseTransientBottomBar2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getLocationOnScreen(iArr);
            int height = (i - (baseTransientBottomBar2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getHeight() + iArr[1])) + ((int) BaseTransientBottomBar.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getTranslationY());
            BaseTransientBottomBar baseTransientBottomBar3 = BaseTransientBottomBar.this;
            if (height >= baseTransientBottomBar3.Wwwwwwwwwwwwwwwwwwwwwww) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = baseTransientBottomBar3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getLayoutParams();
            if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                return;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            int i2 = marginLayoutParams.bottomMargin;
            BaseTransientBottomBar baseTransientBottomBar4 = BaseTransientBottomBar.this;
            marginLayoutParams.bottomMargin = (baseTransientBottomBar4.Wwwwwwwwwwwwwwwwwwwwwww - height) + i2;
            baseTransientBottomBar4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.requestLayout();
        }
    }

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Handler.Callback {
        @Override // android.os.Handler.Callback
        public boolean handleMessage(@NonNull Message message) {
            int i = message.what;
            if (i != 0) {
                if (i != 1) {
                    return false;
                }
                BaseTransientBottomBar baseTransientBottomBar = (BaseTransientBottomBar) message.obj;
                int i2 = message.arg1;
                if (baseTransientBottomBar.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() && baseTransientBottomBar.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getVisibility() == 0) {
                    if (baseTransientBottomBar.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getAnimationMode() == 1) {
                        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
                        ofFloat.setInterpolator(C2227im.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        ofFloat.addUpdateListener(new C2722vq(baseTransientBottomBar));
                        ofFloat.setDuration(75L);
                        ofFloat.addListener(new C2681uq(baseTransientBottomBar, i2));
                        ofFloat.start();
                    } else {
                        ValueAnimator valueAnimator = new ValueAnimator();
                        valueAnimator.setIntValues(0, baseTransientBottomBar.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                        valueAnimator.setInterpolator(C2227im.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        valueAnimator.setDuration(250L);
                        valueAnimator.addListener(new C2870zq(baseTransientBottomBar, i2));
                        valueAnimator.addUpdateListener(new C1919ar(baseTransientBottomBar));
                        valueAnimator.start();
                    }
                } else {
                    baseTransientBottomBar.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2);
                }
                return true;
            }
            BaseTransientBottomBar baseTransientBottomBar2 = (BaseTransientBottomBar) message.obj;
            baseTransientBottomBar2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setOnAttachStateChangeListener(new C1993cr(baseTransientBottomBar2));
            if (baseTransientBottomBar2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getParent() == null) {
                ViewGroup.LayoutParams layoutParams = baseTransientBottomBar2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getLayoutParams();
                if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                    CoordinatorLayout.LayoutParams layoutParams2 = (CoordinatorLayout.LayoutParams) layoutParams;
                    Behavior behavior = new Behavior();
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww = behavior.Wwwwwwwwwwwwwwwwwwwwwwwww;
                    if (wwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = baseTransientBottomBar2.Wwwwwwwwwwwwwwwwwwww;
                        behavior.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2084er(baseTransientBottomBar2);
                        layoutParams2.setBehavior(behavior);
                        layoutParams2.insetEdge = 80;
                    } else {
                        throw null;
                    }
                }
                baseTransientBottomBar2.Wwwwwwwwwwwwwwwwwwwwww = 0;
                baseTransientBottomBar2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                baseTransientBottomBar2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setVisibility(4);
                baseTransientBottomBar2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.addView(baseTransientBottomBar2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            if (ViewCompat.isLaidOut(baseTransientBottomBar2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                baseTransientBottomBar2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            } else {
                baseTransientBottomBar2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setOnLayoutChangeListener(new C2047dr(baseTransientBottomBar2));
            }
            return true;
        }
    }

    public BaseTransientBottomBar(@NonNull Context context, @NonNull ViewGroup viewGroup, @NonNull View view, @NonNull AbstractC2121fr abstractC2121fr) {
        if (viewGroup != null) {
            if (view == null) {
                throw new IllegalArgumentException("Transient bottom bar must have non-null content");
            }
            if (abstractC2121fr == null) {
                throw new IllegalArgumentException("Transient bottom bar must have non-null callback");
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = viewGroup;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2121fr;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = context;
            C2415np.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, C2415np.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "Theme.AppCompat");
            LayoutInflater from = LayoutInflater.from(context);
            TypedArray obtainStyledAttributes = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.obtainStyledAttributes(Wwwwwwwwwwwwwwwwww);
            int resourceId = obtainStyledAttributes.getResourceId(0, -1);
            obtainStyledAttributes.recycle();
            Wwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwwwwwwwwwwwww) from.inflate(resourceId != -1 ? R$layout.mtrl_layout_snackbar : R$layout.design_layout_snackbar, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, false);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwww;
            if (view instanceof SnackbarContentLayout) {
                SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) view;
                float actionTextColorAlpha = wwwwwwwwwwwwwwwwwwwwwwwwww.getActionTextColorAlpha();
                if (actionTextColorAlpha != 1.0f) {
                    snackbarContentLayout.Wwwwwwwwwwwwwwwwwwwwwww.setTextColor(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((View) snackbarContentLayout, R$attr.colorSurface), snackbarContentLayout.Wwwwwwwwwwwwwwwwwwwwwww.getCurrentTextColor(), actionTextColorAlpha));
                }
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.addView(view);
            ViewGroup.LayoutParams layoutParams = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
            }
            ViewCompat.setAccessibilityLiveRegion(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 1);
            ViewCompat.setImportantForAccessibility(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 1);
            ViewCompat.setFitsSystemWindows(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, true);
            ViewCompat.setOnApplyWindowInsetsListener(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            ViewCompat.setAccessibilityDelegate(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            this.Wwwwwwwwwwwwwwwwwwwww = (AccessibilityManager) context.getSystemService("accessibility");
            return;
        }
        throw new IllegalArgumentException("Transient bottom bar must have non-null parent");
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Rect rect;
        ViewGroup.LayoutParams layoutParams = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams) || (rect = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww) == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.bottomMargin = rect.bottom + this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
        marginLayoutParams.leftMargin = rect.left + this.Wwwwwwwwwwwwwwwwwwwwwwwww;
        marginLayoutParams.rightMargin = rect.right + this.Wwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.requestLayout();
        if (Build.VERSION.SDK_INT < 29) {
            return;
        }
        boolean z = false;
        if (this.Wwwwwwwwwwwwwwwwwwwwwww > 0) {
            ViewGroup.LayoutParams layoutParams2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getLayoutParams();
            if ((layoutParams2 instanceof CoordinatorLayout.LayoutParams) && (((CoordinatorLayout.LayoutParams) layoutParams2).getBehavior() instanceof SwipeDismissBehavior)) {
                z = true;
            }
        }
        if (!z) {
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.removeCallbacks(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.post(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.post(new RunnableC2607sq(this));
            return;
        }
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getParent() != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setVisibility(0);
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        AccessibilityManager accessibilityManager = this.Wwwwwwwwwwwwwwwwwwwww;
        if (accessibilityManager == null) {
            return true;
        }
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(1);
        return enabledAccessibilityServiceList != null && enabledAccessibilityServiceList.isEmpty();
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        C2195hr.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwww);
    }

    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int height = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getHeight();
        ViewGroup.LayoutParams layoutParams = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getLayoutParams();
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? height + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : height;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        C2195hr.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwww);
        ViewParent parent = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        C2195hr.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwww, i);
    }
}
