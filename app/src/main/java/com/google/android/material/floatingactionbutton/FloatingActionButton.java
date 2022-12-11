package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import androidx.annotation.AbstractC0047Px;
import androidx.annotation.AnimatorRes;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatImageHelper;
import androidx.collection.SimpleArrayMap;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.TintableBackgroundView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TintableImageSourceView;
import com.google.android.material.R$animator;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.stateful.ExtendableSavedState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.tvspark.AbstractC2046dq;
import me.tvspark.AbstractC2566rm;
import me.tvspark.AbstractC2570rq;
import me.tvspark.AbstractC2642to;
import me.tvspark.C1917ap;
import me.tvspark.C1954bp;
import me.tvspark.C1957bs;
import me.tvspark.C2082ep;
import me.tvspark.C2193hp;
import me.tvspark.C2415np;
import me.tvspark.C2416nq;
import me.tvspark.C2449om;
import me.tvspark.C2643tp;
import me.tvspark.C2720vo;
import me.tvspark.C2757wo;
import me.tvspark.C2831yo;
import me.tvspark.C2868zo;
import me.tvspark.Illllllllllllllllllllllllllll;
import me.tvspark.ViewTreeObserver$OnPreDrawListenerC2045dp;

/* loaded from: classes3.dex */
public class FloatingActionButton extends C2643tp implements TintableBackgroundView, TintableImageSourceView, AbstractC2642to, AbstractC2570rq, CoordinatorLayout.AttachedBehavior {
    public static final int Wwwwwww = R$style.Widget_Design_FloatingActionButton;
    public C1954bp Wwwwwwww;
    @NonNull
    public final C2720vo Wwwwwwwww;
    @NonNull
    public final AppCompatImageHelper Wwwwwwwwww;
    public final Rect Wwwwwwwwwww;
    public final Rect Wwwwwwwwwwww;
    public boolean Wwwwwwwwwwwww;
    public int Wwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwww;
    @Nullable
    public ColorStateList Wwwwwwwwwwwwwwwwwww;
    @Nullable
    public PorterDuff.Mode Wwwwwwwwwwwwwwwwwwww;
    @Nullable
    public ColorStateList Wwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public PorterDuff.Mode Wwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public ColorStateList Wwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes3.dex */
    public static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.Behavior<T> {
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public Rect Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public BaseBehavior() {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FloatingActionButton_Behavior_Layout);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = obtainStyledAttributes.getBoolean(R$styleable.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
            obtainStyledAttributes.recycle();
        }

        public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                return ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior() instanceof BottomSheetBehavior;
            }
            return false;
        }

        public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull View view, @NonNull FloatingActionButton floatingActionButton) {
            if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view, floatingActionButton)) {
                return false;
            }
            if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) floatingActionButton.getLayoutParams())).topMargin) {
                floatingActionButton.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) null, false);
                return true;
            }
            floatingActionButton.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null, false);
            return true;
        }

        public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull View view, @NonNull FloatingActionButton floatingActionButton) {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && ((CoordinatorLayout.LayoutParams) floatingActionButton.getLayoutParams()).getAnchorId() == view.getId() && floatingActionButton.getUserSetVisibility() == 0;
        }

        public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull FloatingActionButton floatingActionButton) {
            if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(appBarLayout, floatingActionButton)) {
                return false;
            }
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Rect();
            }
            Rect rect = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            C2193hp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) null, false);
                return true;
            }
            floatingActionButton.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null, false);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean getInsetDodgeRect(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull Rect rect) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            Rect rect2 = floatingActionButton.Wwwwwwwwwwww;
            rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
            if (layoutParams.dodgeInsetEdges == 0) {
                layoutParams.dodgeInsetEdges = 80;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, @NonNull View view, View view2) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            if (view2 instanceof AppBarLayout) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(coordinatorLayout, (AppBarLayout) view2, floatingActionButton);
                return false;
            } else if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view2)) {
                return false;
            } else {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view2, floatingActionButton);
                return false;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            List<View> dependencies = coordinatorLayout.getDependencies(floatingActionButton);
            int size = dependencies.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                View view2 = dependencies.get(i3);
                if (!(view2 instanceof AppBarLayout)) {
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view2) && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view2, floatingActionButton)) {
                        break;
                    }
                } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(coordinatorLayout, (AppBarLayout) view2, floatingActionButton)) {
                    break;
                }
            }
            coordinatorLayout.onLayoutChild(floatingActionButton, i);
            Rect rect = floatingActionButton.Wwwwwwwwwwww;
            if (rect == null || rect.centerX() <= 0 || rect.centerY() <= 0) {
                return true;
            }
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) floatingActionButton.getLayoutParams();
            int i4 = floatingActionButton.getRight() >= coordinatorLayout.getWidth() - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin ? rect.right : floatingActionButton.getLeft() <= ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin ? -rect.left : 0;
            if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) {
                i2 = rect.bottom;
            } else if (floatingActionButton.getTop() <= ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) {
                i2 = -rect.top;
            }
            if (i2 != 0) {
                ViewCompat.offsetTopAndBottom(floatingActionButton, i2);
            }
            if (i4 == 0) {
                return true;
            }
            ViewCompat.offsetLeftAndRight(floatingActionButton, i4);
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T extends FloatingActionButton> implements C1954bp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        @NonNull
        public final AbstractC2566rm<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull AbstractC2566rm<T> abstractC2566rm) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2566rm;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // me.tvspark.C1954bp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(FloatingActionButton.this);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // me.tvspark.C1954bp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(FloatingActionButton.this);
        }

        public boolean equals(@Nullable Object obj) {
            return (obj instanceof Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) obj).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }

        public int hashCode() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.hashCode();
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements AbstractC2046dq {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(FloatingActionButton floatingActionButton) {
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(FloatingActionButton floatingActionButton) {
        }
    }

    public FloatingActionButton(@NonNull Context context) {
        this(context, null);
    }

    public FloatingActionButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.floatingActionButtonStyle);
    }

    public FloatingActionButton(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(C1957bs.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, attributeSet, i, Wwwwwww), attributeSet, i);
        this.Wwwwwwwwwwww = new Rect();
        this.Wwwwwwwwwww = new Rect();
        Context context2 = getContext();
        TypedArray Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2415np.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context2, attributeSet, R$styleable.FloatingActionButton, i, Wwwwwww, new int[0]);
        this.Wwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, R$styleable.FloatingActionButton_backgroundTint);
        this.Wwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getInt(R$styleable.FloatingActionButton_backgroundTintMode, -1), (PorterDuff.Mode) null);
        this.Wwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, R$styleable.FloatingActionButton_rippleColor);
        this.Wwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getInt(R$styleable.FloatingActionButton_fabSize, -1);
        this.Wwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getDimensionPixelSize(R$styleable.FloatingActionButton_fabCustomSize, 0);
        this.Wwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getDimensionPixelSize(R$styleable.FloatingActionButton_borderWidth, 0);
        float dimension = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getDimension(R$styleable.FloatingActionButton_elevation, 0.0f);
        float dimension2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getDimension(R$styleable.FloatingActionButton_hoveredFocusedTranslationZ, 0.0f);
        float dimension3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getDimension(R$styleable.FloatingActionButton_pressedTranslationZ, 0.0f);
        this.Wwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getBoolean(R$styleable.FloatingActionButton_useCompatPadding, false);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.mtrl_fab_min_touch_target);
        this.Wwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getDimensionPixelSize(R$styleable.FloatingActionButton_maxImageSize, 0);
        C2449om Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2449om.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, R$styleable.FloatingActionButton_showMotionSpec);
        C2449om Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = C2449om.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, R$styleable.FloatingActionButton_hideMotionSpec);
        C2416nq Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = C2416nq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context2, attributeSet, i, Wwwwwww, C2416nq.Wwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        boolean z = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getBoolean(R$styleable.FloatingActionButton_ensureMinTouchTargetSize, false);
        setEnabled(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getBoolean(R$styleable.FloatingActionButton_android_enabled, true));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.recycle();
        AppCompatImageHelper appCompatImageHelper = new AppCompatImageHelper(this);
        this.Wwwwwwwwww = appCompatImageHelper;
        appCompatImageHelper.loadFromAttributes(attributeSet, i);
        this.Wwwwwwwww = new C2720vo(this);
        getImpl().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4);
        getImpl().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwww);
        getImpl().Wwwwwwwwwwwwwwwwwwwwwwww = dimensionPixelSize;
        C1954bp impl = getImpl();
        if (impl.Wwwwwwwwwwwwwwwwwwwwwwwwwww != dimension) {
            impl.Wwwwwwwwwwwwwwwwwwwwwwwwwww = dimension;
            impl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(dimension, impl.Wwwwwwwwwwwwwwwwwwwwwwwwww, impl.Wwwwwwwwwwwwwwwwwwwwwwwww);
        }
        C1954bp impl2 = getImpl();
        if (impl2.Wwwwwwwwwwwwwwwwwwwwwwwwww != dimension2) {
            impl2.Wwwwwwwwwwwwwwwwwwwwwwwwww = dimension2;
            impl2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(impl2.Wwwwwwwwwwwwwwwwwwwwwwwwwww, dimension2, impl2.Wwwwwwwwwwwwwwwwwwwwwwwww);
        }
        C1954bp impl3 = getImpl();
        if (impl3.Wwwwwwwwwwwwwwwwwwwwwwwww != dimension3) {
            impl3.Wwwwwwwwwwwwwwwwwwwwwwwww = dimension3;
            impl3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(impl3.Wwwwwwwwwwwwwwwwwwwwwwwwwww, impl3.Wwwwwwwwwwwwwwwwwwwwwwwwww, dimension3);
        }
        C1954bp impl4 = getImpl();
        int i2 = this.Wwwwwwwwwwwwww;
        if (impl4.Wwwwwwwwwwwwwww != i2) {
            impl4.Wwwwwwwwwwwwwww = i2;
            impl4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(impl4.Wwwwwwwwwwwwwwww);
        }
        getImpl().Wwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        getImpl().Wwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
        getImpl().Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                return i;
            }
            if (mode != 1073741824) {
                throw new IllegalArgumentException();
            }
            return size;
        }
        return Math.min(i, size);
    }

    private C1954bp getImpl() {
        if (this.Wwwwwwww == null) {
            this.Wwwwwwww = new C2082ep(this, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        }
        return this.Wwwwwwww;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        ColorStateList colorStateList = this.Wwwwwwwwwwwwwwwwwwwww;
        if (colorStateList == null) {
            DrawableCompat.clearColorFilter(drawable);
            return;
        }
        int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
        PorterDuff.Mode mode = this.Wwwwwwwwwwwwwwwwwwww;
        if (mode == null) {
            mode = PorterDuff.Mode.SRC_IN;
        }
        drawable.mutate().setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(colorForState, mode));
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return getImpl().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Animator.AnimatorListener animatorListener) {
        C1954bp impl = getImpl();
        if (impl.Wwwwwwwwwwwww == null) {
            impl.Wwwwwwwwwwwww = new ArrayList<>();
        }
        impl.Wwwwwwwwwwwww.add(animatorListener);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Rect rect) {
        int i = rect.left;
        Rect rect2 = this.Wwwwwwwwwwww;
        rect.left = i + rect2.left;
        rect.top += rect2.top;
        rect.right -= rect2.right;
        rect.bottom -= rect2.bottom;
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return getImpl().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        int i2 = this.Wwwwwwwwwwwwwwww;
        if (i2 != 0) {
            return i2;
        }
        Resources resources = getResources();
        if (i != -1) {
            return resources.getDimensionPixelSize(i != 1 ? R$dimen.design_fab_size_normal : R$dimen.design_fab_size_mini);
        }
        return Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470 ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1) : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Animator.AnimatorListener animatorListener) {
        C1954bp impl = getImpl();
        if (impl.Wwwwwwwwwwww == null) {
            impl.Wwwwwwwwwwww = new ArrayList<>();
        }
        impl.Wwwwwwwwwwww.add(animatorListener);
    }

    @Deprecated
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Rect rect) {
        if (ViewCompat.isLaidOut(this)) {
            rect.set(0, 0, getWidth(), getHeight());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(rect);
            return true;
        }
        return false;
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getDrawableState());
    }

    @Override // android.view.View
    @Nullable
    public ColorStateList getBackgroundTintList() {
        return this.Wwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // android.view.View
    @Nullable
    public PorterDuff.Mode getBackgroundTintMode() {
        return this.Wwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    /* renamed from: getBehavior */
    public CoordinatorLayout.Behavior<FloatingActionButton> mo4457getBehavior() {
        return new Behavior();
    }

    public float getCompatElevation() {
        return getImpl().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().Wwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().Wwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Nullable
    public Drawable getContentBackground() {
        return getImpl().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @AbstractC0047Px
    public int getCustomSize() {
        return this.Wwwwwwwwwwwwwwww;
    }

    public int getExpandedComponentIdHint() {
        return this.Wwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Nullable
    public C2449om getHideMotionSpec() {
        return getImpl().Wwwwwwwwwwwwwwwwww;
    }

    @ColorInt
    @Deprecated
    public int getRippleColor() {
        ColorStateList colorStateList = this.Wwwwwwwwwwwwwwwwwww;
        if (colorStateList != null) {
            return colorStateList.getDefaultColor();
        }
        return 0;
    }

    @Nullable
    public ColorStateList getRippleColorStateList() {
        return this.Wwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.AbstractC2570rq
    @NonNull
    public C2416nq getShapeAppearanceModel() {
        return (C2416nq) Preconditions.checkNotNull(getImpl().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    @Nullable
    public C2449om getShowMotionSpec() {
        return getImpl().Wwwwwwwwwwwwwwwwwww;
    }

    public int getSize() {
        return this.Wwwwwwwwwwwwwwwww;
    }

    public int getSizeDimension() {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwww);
    }

    @Override // androidx.core.view.TintableBackgroundView
    @Nullable
    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    @Override // androidx.core.view.TintableBackgroundView
    @Nullable
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    @Override // androidx.core.widget.TintableImageSourceView
    @Nullable
    public ColorStateList getSupportImageTintList() {
        return this.Wwwwwwwwwwwwwwwwwwwww;
    }

    @Override // androidx.core.widget.TintableImageSourceView
    @Nullable
    public PorterDuff.Mode getSupportImageTintMode() {
        return this.Wwwwwwwwwwwwwwwwwwww;
    }

    public boolean getUseCompatPadding() {
        return this.Wwwwwwwwwwwww;
    }

    @Override // android.widget.ImageView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        C1954bp impl = getImpl();
        MaterialShapeDrawable materialShapeDrawable = impl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (materialShapeDrawable != null) {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((View) impl.Wwwwwwwwww, materialShapeDrawable);
        }
        if (impl.Wwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            ViewTreeObserver viewTreeObserver = impl.Wwwwwwwwww.getViewTreeObserver();
            if (impl.Wwww == null) {
                impl.Wwww = new ViewTreeObserver$OnPreDrawListenerC2045dp(impl);
            }
            viewTreeObserver.addOnPreDrawListener(impl.Wwww);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C1954bp impl = getImpl();
        ViewTreeObserver viewTreeObserver = impl.Wwwwwwwwww.getViewTreeObserver();
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = impl.Wwww;
        if (onPreDrawListener != null) {
            viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
            impl.Wwww = null;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        int sizeDimension = getSizeDimension();
        this.Wwwwwwwwwwwwwww = (sizeDimension - this.Wwwwwwwwwwwwww) / 2;
        getImpl().Wwwwwwwwwwwwwwwwwwwwww();
        int min = Math.min(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sizeDimension, i), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sizeDimension, i2));
        Rect rect = this.Wwwwwwwwwwww;
        setMeasuredDimension(rect.left + min + rect.right, min + rect.top + rect.bottom);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof ExtendableSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ExtendableSavedState extendableSavedState = (ExtendableSavedState) parcelable;
        super.onRestoreInstanceState(extendableSavedState.getSuperState());
        C2720vo c2720vo = this.Wwwwwwwww;
        Bundle bundle = (Bundle) Preconditions.checkNotNull(extendableSavedState.Wwwwwwwwwwwwwwwwwwwwwwww.get("expandableWidgetHelper"));
        if (c2720vo != null) {
            c2720vo.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = bundle.getBoolean("expanded", false);
            c2720vo.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = bundle.getInt("expandedComponentIdHint", 0);
            if (!c2720vo.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                return;
            }
            ViewParent parent = c2720vo.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getParent();
            if (!(parent instanceof CoordinatorLayout)) {
                return;
            }
            ((CoordinatorLayout) parent).dispatchDependentViewsChanged(c2720vo.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            return;
        }
        throw null;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        if (onSaveInstanceState == null) {
            onSaveInstanceState = new Bundle();
        }
        ExtendableSavedState extendableSavedState = new ExtendableSavedState(onSaveInstanceState);
        SimpleArrayMap<String, Bundle> simpleArrayMap = extendableSavedState.Wwwwwwwwwwwwwwwwwwwwwwww;
        C2720vo c2720vo = this.Wwwwwwwww;
        if (c2720vo != null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("expanded", c2720vo.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            bundle.putInt("expandedComponentIdHint", c2720vo.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            simpleArrayMap.put("expandableWidgetHelper", bundle);
            return extendableSavedState;
        }
        throw null;
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0 || !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwww) || this.Wwwwwwwwwww.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
    }

    @Override // android.view.View
    public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        if (this.Wwwwwwwwwwwwwwwwwwwwwww != colorStateList) {
            this.Wwwwwwwwwwwwwwwwwwwwwww = colorStateList;
            C1954bp impl = getImpl();
            MaterialShapeDrawable materialShapeDrawable = impl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (materialShapeDrawable != null) {
                materialShapeDrawable.setTintList(colorStateList);
            }
            C2757wo c2757wo = impl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (c2757wo == null) {
                return;
            }
            c2757wo.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(colorStateList);
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.Wwwwwwwwwwwwwwwwwwwwww != mode) {
            this.Wwwwwwwwwwwwwwwwwwwwww = mode;
            MaterialShapeDrawable materialShapeDrawable = getImpl().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (materialShapeDrawable == null) {
                return;
            }
            materialShapeDrawable.setTintMode(mode);
        }
    }

    public void setCompatElevation(float f) {
        C1954bp impl = getImpl();
        if (impl.Wwwwwwwwwwwwwwwwwwwwwwwwwww != f) {
            impl.Wwwwwwwwwwwwwwwwwwwwwwwwwww = f;
            impl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f, impl.Wwwwwwwwwwwwwwwwwwwwwwwwww, impl.Wwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    public void setCompatElevationResource(@DimenRes int i) {
        setCompatElevation(getResources().getDimension(i));
    }

    public void setCompatHoveredFocusedTranslationZ(float f) {
        C1954bp impl = getImpl();
        if (impl.Wwwwwwwwwwwwwwwwwwwwwwwwww != f) {
            impl.Wwwwwwwwwwwwwwwwwwwwwwwwww = f;
            impl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(impl.Wwwwwwwwwwwwwwwwwwwwwwwwwww, f, impl.Wwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    public void setCompatHoveredFocusedTranslationZResource(@DimenRes int i) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i));
    }

    public void setCompatPressedTranslationZ(float f) {
        C1954bp impl = getImpl();
        if (impl.Wwwwwwwwwwwwwwwwwwwwwwwww != f) {
            impl.Wwwwwwwwwwwwwwwwwwwwwwwww = f;
            impl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(impl.Wwwwwwwwwwwwwwwwwwwwwwwwwww, impl.Wwwwwwwwwwwwwwwwwwwwwwwwww, f);
        }
    }

    public void setCompatPressedTranslationZResource(@DimenRes int i) {
        setCompatPressedTranslationZ(getResources().getDimension(i));
    }

    public void setCustomSize(@AbstractC0047Px int i) {
        if (i >= 0) {
            if (i == this.Wwwwwwwwwwwwwwww) {
                return;
            }
            this.Wwwwwwwwwwwwwwww = i;
            requestLayout();
            return;
        }
        throw new IllegalArgumentException("Custom size must be non-negative");
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f) {
        super.setElevation(f);
        getImpl().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f);
    }

    public void setEnsureMinTouchTargetSize(boolean z) {
        if (z != getImpl().Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            getImpl().Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
            requestLayout();
        }
    }

    public void setExpandedComponentIdHint(@IdRes int i) {
        this.Wwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
    }

    public void setHideMotionSpec(@Nullable C2449om c2449om) {
        getImpl().Wwwwwwwwwwwwwwwwww = c2449om;
    }

    public void setHideMotionSpecResource(@AnimatorRes int i) {
        setHideMotionSpec(C2449om.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getContext(), i));
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(@Nullable Drawable drawable) {
        if (getDrawable() != drawable) {
            super.setImageDrawable(drawable);
            C1954bp impl = getImpl();
            impl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(impl.Wwwwwwwwwwwwwwww);
            if (this.Wwwwwwwwwwwwwwwwwwwww == null) {
                return;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(@DrawableRes int i) {
        this.Wwwwwwwwww.setImageResource(i);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public void setRippleColor(@ColorInt int i) {
        setRippleColor(ColorStateList.valueOf(i));
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        if (this.Wwwwwwwwwwwwwwwwwww != colorStateList) {
            this.Wwwwwwwwwwwwwwwwwww = colorStateList;
            getImpl().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwww);
        }
    }

    @Override // android.view.View
    public void setScaleX(float f) {
        super.setScaleX(f);
        getImpl().Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // android.view.View
    public void setScaleY(float f) {
        super.setScaleY(f);
        getImpl().Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @VisibleForTesting
    public void setShadowPaddingEnabled(boolean z) {
        C1954bp impl = getImpl();
        impl.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
        impl.Wwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.AbstractC2570rq
    public void setShapeAppearanceModel(@NonNull C2416nq c2416nq) {
        getImpl().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2416nq);
    }

    public void setShowMotionSpec(@Nullable C2449om c2449om) {
        getImpl().Wwwwwwwwwwwwwwwwwww = c2449om;
    }

    public void setShowMotionSpecResource(@AnimatorRes int i) {
        setShowMotionSpec(C2449om.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getContext(), i));
    }

    public void setSize(int i) {
        this.Wwwwwwwwwwwwwwww = 0;
        if (i != this.Wwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwww = i;
            requestLayout();
        }
    }

    @Override // androidx.core.view.TintableBackgroundView
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        setBackgroundTintList(colorStateList);
    }

    @Override // androidx.core.view.TintableBackgroundView
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        setBackgroundTintMode(mode);
    }

    @Override // androidx.core.widget.TintableImageSourceView
    public void setSupportImageTintList(@Nullable ColorStateList colorStateList) {
        if (this.Wwwwwwwwwwwwwwwwwwwww != colorStateList) {
            this.Wwwwwwwwwwwwwwwwwwwww = colorStateList;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    @Override // androidx.core.widget.TintableImageSourceView
    public void setSupportImageTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.Wwwwwwwwwwwwwwwwwwww != mode) {
            this.Wwwwwwwwwwwwwwwwwwww = mode;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    @Override // android.view.View
    public void setTranslationX(float f) {
        super.setTranslationX(f);
        getImpl().Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // android.view.View
    public void setTranslationY(float f) {
        super.setTranslationY(f);
        getImpl().Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // android.view.View
    public void setTranslationZ(float f) {
        super.setTranslationZ(f);
        getImpl().Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public void setUseCompatPadding(boolean z) {
        if (this.Wwwwwwwwwwwww != z) {
            this.Wwwwwwwwwwwww = z;
            getImpl().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    @Override // me.tvspark.C2643tp, android.widget.ImageView, android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, boolean z) {
        C1954bp impl = getImpl();
        C2831yo c2831yo = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null ? null : new C2831yo(this, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        if (impl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            return;
        }
        Animator animator = impl.Wwwwwwwwwwwwwwwwwwww;
        if (animator != null) {
            animator.cancel();
        }
        if (!impl.Wwwwwwwwwwwwwwwwwwwwwwwww()) {
            impl.Wwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, z);
            impl.Wwwwwwwwww.setAlpha(1.0f);
            impl.Wwwwwwwwww.setScaleY(1.0f);
            impl.Wwwwwwwwww.setScaleX(1.0f);
            impl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1.0f);
            if (c2831yo == null) {
                return;
            }
            c2831yo.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2831yo.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            return;
        }
        if (impl.Wwwwwwwwww.getVisibility() != 0) {
            impl.Wwwwwwwwww.setAlpha(0.0f);
            impl.Wwwwwwwwww.setScaleY(0.0f);
            impl.Wwwwwwwwww.setScaleX(0.0f);
            impl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0.0f);
        }
        C2449om c2449om = impl.Wwwwwwwwwwwwwwwwwww;
        if (c2449om == null) {
            if (impl.Wwwwwwwwwwwwwwwwwwwwww == null) {
                impl.Wwwwwwwwwwwwwwwwwwwwww = C2449om.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(impl.Wwwwwwwwww.getContext(), R$animator.design_fab_show_motion_spec);
            }
            c2449om = (C2449om) Preconditions.checkNotNull(impl.Wwwwwwwwwwwwwwwwwwwwww);
        }
        AnimatorSet Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = impl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2449om, 1.0f, 1.0f, 1.0f);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.addListener(new C1917ap(impl, z, c2831yo));
        ArrayList<Animator.AnimatorListener> arrayList = impl.Wwwwwwwwwwwww;
        if (arrayList != null) {
            Iterator<Animator.AnimatorListener> it = arrayList.iterator();
            while (it.hasNext()) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.addListener(it.next());
            }
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.start();
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull AbstractC2566rm<? extends FloatingActionButton> abstractC2566rm) {
        C1954bp impl = getImpl();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2566rm);
        if (impl.Wwwwwwwwwww == null) {
            impl.Wwwwwwwwwww = new ArrayList<>();
        }
        impl.Wwwwwwwwwww.add(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, boolean z) {
        C1954bp impl = getImpl();
        C2831yo c2831yo = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null ? null : new C2831yo(this, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        if (impl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            return;
        }
        Animator animator = impl.Wwwwwwwwwwwwwwwwwwww;
        if (animator != null) {
            animator.cancel();
        }
        if (!impl.Wwwwwwwwwwwwwwwwwwwwwwwww()) {
            impl.Wwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z ? 8 : 4, z);
            if (c2831yo == null) {
                return;
            }
            c2831yo.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2831yo.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            return;
        }
        C2449om c2449om = impl.Wwwwwwwwwwwwwwwwww;
        if (c2449om == null) {
            if (impl.Wwwwwwwwwwwwwwwwwwwww == null) {
                impl.Wwwwwwwwwwwwwwwwwwwww = C2449om.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(impl.Wwwwwwwwww.getContext(), R$animator.design_fab_hide_motion_spec);
            }
            c2449om = (C2449om) Preconditions.checkNotNull(impl.Wwwwwwwwwwwwwwwwwwwww);
        }
        AnimatorSet Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = impl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2449om, 0.0f, 0.0f, 0.0f);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.addListener(new C2868zo(impl, z, c2831yo));
        ArrayList<Animator.AnimatorListener> arrayList = impl.Wwwwwwwwwwww;
        if (arrayList != null) {
            Iterator<Animator.AnimatorListener> it = arrayList.iterator();
            while (it.hasNext()) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.addListener(it.next());
            }
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.start();
    }

    @Override // me.tvspark.AbstractC2679uo
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }
}
