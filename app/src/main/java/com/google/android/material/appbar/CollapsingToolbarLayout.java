package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.C0049R;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$id;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.appbar.AppBarLayout;
import java.util.List;
import me.tvspark.C1915an;
import me.tvspark.C1957bs;
import me.tvspark.C2156gp;
import me.tvspark.C2193hp;
import me.tvspark.C2227im;
import me.tvspark.C2415np;
import me.tvspark.C2755wm;

/* loaded from: classes3.dex */
public class CollapsingToolbarLayout extends FrameLayout {
    public static final int Kkkkkkkkkkkkkkkkkkkkkkkkk = R$style.Widget_Design_CollapsingToolbar;
    @Nullable
    public WindowInsetsCompat Kkkkkkkkkkkkkkkkkkkkkkkkkk;
    public int Www;
    public AppBarLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwww;
    public int Wwwww;
    public long Wwwwww;
    public ValueAnimator Wwwwwww;
    public boolean Wwwwwwww;
    public int Wwwwwwwww;
    @Nullable
    public Drawable Wwwwwwwwww;
    @Nullable
    public Drawable Wwwwwwwwwww;
    public boolean Wwwwwwwwwwww;
    public boolean Wwwwwwwwwwwww;
    @NonNull
    public final C2156gp Wwwwwwwwwwwwww;
    public final Rect Wwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwww;
    public View Wwwwwwwwwwwwwwwwwwww;
    @Nullable
    public View Wwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public ViewGroup Wwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements AppBarLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AppBarLayout appBarLayout, int i) {
            int clamp;
            CollapsingToolbarLayout collapsingToolbarLayout = CollapsingToolbarLayout.this;
            collapsingToolbarLayout.Www = i;
            WindowInsetsCompat windowInsetsCompat = collapsingToolbarLayout.Kkkkkkkkkkkkkkkkkkkkkkkkkk;
            int systemWindowInsetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
            int childCount = CollapsingToolbarLayout.this.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = CollapsingToolbarLayout.this.getChildAt(i2);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) childAt.getLayoutParams();
                C1915an Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = CollapsingToolbarLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(childAt);
                int i3 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (i3 == 1) {
                    clamp = MathUtils.clamp(-i, 0, CollapsingToolbarLayout.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(childAt));
                } else if (i3 == 2) {
                    clamp = Math.round((-i) * wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(clamp);
            }
            CollapsingToolbarLayout.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            CollapsingToolbarLayout collapsingToolbarLayout2 = CollapsingToolbarLayout.this;
            if (collapsingToolbarLayout2.Wwwwwwwwww != null && systemWindowInsetTop > 0) {
                ViewCompat.postInvalidateOnAnimation(collapsingToolbarLayout2);
            }
            CollapsingToolbarLayout.this.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Math.abs(i) / ((CollapsingToolbarLayout.this.getHeight() - ViewCompat.getMinimumHeight(CollapsingToolbarLayout.this)) - systemWindowInsetTop));
        }
    }

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends FrameLayout.LayoutParams {
        public float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
            super(i, i2);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0.5f;
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0.5f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CollapsingToolbarLayout_Layout);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = obtainStyledAttributes.getInt(R$styleable.CollapsingToolbarLayout_Layout_layout_collapseMode, 0);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = obtainStyledAttributes.getFloat(R$styleable.CollapsingToolbarLayout_Layout_layout_collapseParallaxMultiplier, 0.5f);
            obtainStyledAttributes.recycle();
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0.5f;
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements OnApplyWindowInsetsListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, @NonNull WindowInsetsCompat windowInsetsCompat) {
            CollapsingToolbarLayout collapsingToolbarLayout = CollapsingToolbarLayout.this;
            WindowInsetsCompat windowInsetsCompat2 = null;
            if (collapsingToolbarLayout != null) {
                if (ViewCompat.getFitsSystemWindows(collapsingToolbarLayout)) {
                    windowInsetsCompat2 = windowInsetsCompat;
                }
                if (!ObjectsCompat.equals(collapsingToolbarLayout.Kkkkkkkkkkkkkkkkkkkkkkkkkk, windowInsetsCompat2)) {
                    collapsingToolbarLayout.Kkkkkkkkkkkkkkkkkkkkkkkkkk = windowInsetsCompat2;
                    collapsingToolbarLayout.requestLayout();
                }
                return windowInsetsCompat.consumeSystemWindowInsets();
            }
            throw null;
        }
    }

    public CollapsingToolbarLayout(@NonNull Context context) {
        this(context, null);
    }

    public CollapsingToolbarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.collapsingToolbarLayoutStyle);
    }

    public CollapsingToolbarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(C1957bs.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, attributeSet, i, Kkkkkkkkkkkkkkkkkkkkkkkkk), attributeSet, i);
        this.Wwwwwwwwwwwwwwwwwwwwwwww = true;
        this.Wwwwwwwwwwwwwww = new Rect();
        this.Wwwww = -1;
        Context context2 = getContext();
        C2156gp c2156gp = new C2156gp(this);
        this.Wwwwwwwwwwwwww = c2156gp;
        c2156gp.Kkkkkkkkkkkkkkkkkkkkkk = C2227im.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        c2156gp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        TypedArray Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2415np.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context2, attributeSet, R$styleable.CollapsingToolbarLayout, i, Kkkkkkkkkkkkkkkkkkkkkkkkk, new int[0]);
        this.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getInt(R$styleable.CollapsingToolbarLayout_expandedTitleGravity, 8388691));
        this.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getInt(R$styleable.CollapsingToolbarLayout_collapsedTitleGravity, 8388627));
        int dimensionPixelSize = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getDimensionPixelSize(R$styleable.CollapsingToolbarLayout_expandedTitleMargin, 0);
        this.Wwwwwwwwwwwwwwww = dimensionPixelSize;
        this.Wwwwwwwwwwwwwwwww = dimensionPixelSize;
        this.Wwwwwwwwwwwwwwwwww = dimensionPixelSize;
        this.Wwwwwwwwwwwwwwwwwww = dimensionPixelSize;
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.hasValue(R$styleable.CollapsingToolbarLayout_expandedTitleMarginStart)) {
            this.Wwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getDimensionPixelSize(R$styleable.CollapsingToolbarLayout_expandedTitleMarginStart, 0);
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.hasValue(R$styleable.CollapsingToolbarLayout_expandedTitleMarginEnd)) {
            this.Wwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getDimensionPixelSize(R$styleable.CollapsingToolbarLayout_expandedTitleMarginEnd, 0);
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.hasValue(R$styleable.CollapsingToolbarLayout_expandedTitleMarginTop)) {
            this.Wwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getDimensionPixelSize(R$styleable.CollapsingToolbarLayout_expandedTitleMarginTop, 0);
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.hasValue(R$styleable.CollapsingToolbarLayout_expandedTitleMarginBottom)) {
            this.Wwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getDimensionPixelSize(R$styleable.CollapsingToolbarLayout_expandedTitleMarginBottom, 0);
        }
        this.Wwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getBoolean(R$styleable.CollapsingToolbarLayout_titleEnabled, true);
        setTitle(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getText(R$styleable.CollapsingToolbarLayout_title));
        this.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(R$style.TextAppearance_Design_CollapsingToolbar_Expanded);
        this.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C0049R.style.TextAppearance_AppCompat_Widget_ActionBar_Title);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.hasValue(R$styleable.CollapsingToolbarLayout_expandedTitleTextAppearance)) {
            this.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getResourceId(R$styleable.CollapsingToolbarLayout_expandedTitleTextAppearance, 0));
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.hasValue(R$styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance)) {
            this.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getResourceId(R$styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance, 0));
        }
        this.Wwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getDimensionPixelSize(R$styleable.CollapsingToolbarLayout_scrimVisibleHeightTrigger, -1);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.hasValue(R$styleable.CollapsingToolbarLayout_maxLines)) {
            C2156gp c2156gp2 = this.Wwwwwwwwwwwwww;
            int i2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getInt(R$styleable.CollapsingToolbarLayout_maxLines, 1);
            if (i2 != c2156gp2.Kkkkkk) {
                c2156gp2.Kkkkkk = i2;
                c2156gp2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                c2156gp2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        }
        this.Wwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getInt(R$styleable.CollapsingToolbarLayout_scrimAnimationDuration, 600);
        setContentScrim(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getDrawable(R$styleable.CollapsingToolbarLayout_contentScrim));
        setStatusBarScrim(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getDrawable(R$styleable.CollapsingToolbarLayout_statusBarScrim));
        this.Wwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getResourceId(R$styleable.CollapsingToolbarLayout_toolbarId, -1);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.recycle();
        setWillNotDraw(false);
        ViewCompat.setOnApplyWindowInsetsListener(this, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
    }

    @NonNull
    public static C1915an Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull View view) {
        C1915an c1915an = (C1915an) view.getTag(R$id.view_offset_helper);
        if (c1915an == null) {
            C1915an c1915an2 = new C1915an(view);
            view.setTag(R$id.view_offset_helper, c1915an2);
            return c1915an2;
        }
        return c1915an;
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            return view.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
        }
        return view.getMeasuredHeight();
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (this.Wwwwwwwwwww == null && this.Wwwwwwwwww == null) {
            return;
        }
        setScrimsShown(getHeight() + this.Www < getScrimVisibleHeightTrigger());
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        View view;
        if (!this.Wwwwwwwwwwwww && (view = this.Wwwwwwwwwwwwwwwwwwww) != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.Wwwwwwwwwwwwwwwwwwww);
            }
        }
        if (!this.Wwwwwwwwwwwww || this.Wwwwwwwwwwwwwwwwwwwwww == null) {
            return;
        }
        if (this.Wwwwwwwwwwwwwwwwwwww == null) {
            this.Wwwwwwwwwwwwwwwwwwww = new View(getContext());
        }
        if (this.Wwwwwwwwwwwwwwwwwwww.getParent() != null) {
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwwww.addView(this.Wwwwwwwwwwwwwwwwwwww, -1, -1);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwww) {
            return;
        }
        ViewGroup viewGroup = null;
        this.Wwwwwwwwwwwwwwwwwwwwww = null;
        this.Wwwwwwwwwwwwwwwwwwwww = null;
        int i = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (i != -1) {
            ViewGroup viewGroup2 = (ViewGroup) findViewById(i);
            this.Wwwwwwwwwwwwwwwwwwwwww = viewGroup2;
            if (viewGroup2 != null) {
                ViewParent parent = viewGroup2.getParent();
                View view = viewGroup2;
                while (parent != this && parent != null) {
                    if (parent instanceof View) {
                        view = (View) parent;
                    }
                    parent = parent.getParent();
                    view = view;
                }
                this.Wwwwwwwwwwwwwwwwwwwww = view;
            }
        }
        if (this.Wwwwwwwwwwwwwwwwwwwwww == null) {
            int childCount = getChildCount();
            int i2 = 0;
            while (true) {
                if (i2 >= childCount) {
                    break;
                }
                View childAt = getChildAt(i2);
                if ((childAt instanceof Toolbar) || (childAt instanceof android.widget.Toolbar)) {
                    viewGroup = (ViewGroup) childAt;
                    break;
                }
                i2++;
            }
            this.Wwwwwwwwwwwwwwwwwwwwww = viewGroup;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwwwwwwwwww = false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        Drawable drawable;
        super.draw(canvas);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (this.Wwwwwwwwwwwwwwwwwwwwww == null && (drawable = this.Wwwwwwwwwww) != null && this.Wwwwwwwww > 0) {
            drawable.mutate().setAlpha(this.Wwwwwwwww);
            this.Wwwwwwwwwww.draw(canvas);
        }
        if (this.Wwwwwwwwwwwww && this.Wwwwwwwwwwww) {
            this.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(canvas);
        }
        if (this.Wwwwwwwwww == null || this.Wwwwwwwww <= 0) {
            return;
        }
        WindowInsetsCompat windowInsetsCompat = this.Kkkkkkkkkkkkkkkkkkkkkkkkkk;
        int systemWindowInsetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
        if (systemWindowInsetTop <= 0) {
            return;
        }
        this.Wwwwwwwwww.setBounds(0, -this.Www, getWidth(), systemWindowInsetTop - this.Www);
        this.Wwwwwwwwww.mutate().setAlpha(this.Wwwwwwwww);
        this.Wwwwwwwwww.draw(canvas);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0018, code lost:
        r0 = true;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean drawChild(Canvas canvas, View view, long j) {
        boolean z;
        if (this.Wwwwwwwwwww != null && this.Wwwwwwwww > 0) {
            if ((r0 = this.Wwwwwwwwwwwwwwwwwwwww) != null) {
            }
            boolean z2 = false;
            if (z2) {
                this.Wwwwwwwwwww.mutate().setAlpha(this.Wwwwwwwww);
                this.Wwwwwwwwwww.draw(canvas);
                z = true;
                return super.drawChild(canvas, view, j) || z;
            }
        }
        z = false;
        if (super.drawChild(canvas, view, j)) {
            return true;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.Wwwwwwwwww;
        boolean z = false;
        if (drawable != null && drawable.isStateful()) {
            z = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.Wwwwwwwwwww;
        if (drawable2 != null && drawable2.isStateful()) {
            z |= drawable2.setState(drawableState);
        }
        C2156gp c2156gp = this.Wwwwwwwwwwwwww;
        if (c2156gp != null) {
            z |= c2156gp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(drawableState);
        }
        if (z) {
            invalidate();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(-1, -1);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(layoutParams);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getContext(), attributeSet);
    }

    public int getCollapsedTitleGravity() {
        return this.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @NonNull
    public Typeface getCollapsedTitleTypeface() {
        Typeface typeface = this.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwww;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    @Nullable
    public Drawable getContentScrim() {
        return this.Wwwwwwwwwww;
    }

    public int getExpandedTitleGravity() {
        return this.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public int getExpandedTitleMarginBottom() {
        return this.Wwwwwwwwwwwwwwww;
    }

    public int getExpandedTitleMarginEnd() {
        return this.Wwwwwwwwwwwwwwwww;
    }

    public int getExpandedTitleMarginStart() {
        return this.Wwwwwwwwwwwwwwwwwww;
    }

    public int getExpandedTitleMarginTop() {
        return this.Wwwwwwwwwwwwwwwwww;
    }

    @NonNull
    public Typeface getExpandedTitleTypeface() {
        Typeface typeface = this.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwww;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getMaxLines() {
        return this.Wwwwwwwwwwwwww.Kkkkkk;
    }

    public int getScrimAlpha() {
        return this.Wwwwwwwww;
    }

    public long getScrimAnimationDuration() {
        return this.Wwwwww;
    }

    public int getScrimVisibleHeightTrigger() {
        int i = this.Wwwww;
        if (i >= 0) {
            return i;
        }
        WindowInsetsCompat windowInsetsCompat = this.Kkkkkkkkkkkkkkkkkkkkkkkkkk;
        int systemWindowInsetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
        int minimumHeight = ViewCompat.getMinimumHeight(this);
        return minimumHeight > 0 ? Math.min((minimumHeight * 2) + systemWindowInsetTop, getHeight()) : getHeight() / 3;
    }

    @Nullable
    public Drawable getStatusBarScrim() {
        return this.Wwwwwwwwww;
    }

    @Nullable
    public CharSequence getTitle() {
        if (this.Wwwwwwwwwwwww) {
            return this.Wwwwwwwwwwwwww.Wwwwwwwwwww;
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            ViewCompat.setFitsSystemWindows(this, ViewCompat.getFitsSystemWindows((View) parent));
            if (this.Wwww == null) {
                this.Wwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
            ((AppBarLayout) parent).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwww);
            ViewCompat.requestApplyInsets(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        List<AppBarLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> list;
        ViewParent parent = getParent();
        AppBarLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null && (parent instanceof AppBarLayout) && (list = ((AppBarLayout) parent).Wwwwwwwwwwwwwwwww) != null && wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            list.remove(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View view;
        int i5;
        int i6;
        int i7;
        int i8;
        super.onLayout(z, i, i2, i3, i4);
        WindowInsetsCompat windowInsetsCompat = this.Kkkkkkkkkkkkkkkkkkkkkkkkkk;
        if (windowInsetsCompat != null) {
            int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
            int childCount = getChildCount();
            for (int i9 = 0; i9 < childCount; i9++) {
                View childAt = getChildAt(i9);
                if (!ViewCompat.getFitsSystemWindows(childAt) && childAt.getTop() < systemWindowInsetTop) {
                    ViewCompat.offsetTopAndBottom(childAt, systemWindowInsetTop);
                }
            }
        }
        int childCount2 = getChildCount();
        for (int i10 = 0; i10 < childCount2; i10++) {
            C1915an Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getChildAt(i10));
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getTop();
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getLeft();
        }
        if (this.Wwwwwwwwwwwww && (view = this.Wwwwwwwwwwwwwwwwwwww) != null) {
            boolean z2 = ViewCompat.isAttachedToWindow(view) && this.Wwwwwwwwwwwwwwwwwwww.getVisibility() == 0;
            this.Wwwwwwwwwwww = z2;
            if (z2) {
                boolean z3 = ViewCompat.getLayoutDirection(this) == 1;
                View view2 = this.Wwwwwwwwwwwwwwwwwwwww;
                if (view2 == null) {
                    view2 = this.Wwwwwwwwwwwwwwwwwwwwww;
                }
                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view2);
                C2193hp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, this.Wwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwww);
                ViewGroup viewGroup = this.Wwwwwwwwwwwwwwwwwwwwww;
                if (viewGroup instanceof Toolbar) {
                    Toolbar toolbar = (Toolbar) viewGroup;
                    i6 = toolbar.getTitleMarginStart();
                    i7 = toolbar.getTitleMarginEnd();
                    i8 = toolbar.getTitleMarginTop();
                    i5 = toolbar.getTitleMarginBottom();
                } else if (Build.VERSION.SDK_INT < 24 || !(viewGroup instanceof android.widget.Toolbar)) {
                    i5 = 0;
                    i6 = 0;
                    i7 = 0;
                    i8 = 0;
                } else {
                    android.widget.Toolbar toolbar2 = (android.widget.Toolbar) viewGroup;
                    i6 = toolbar2.getTitleMarginStart();
                    i7 = toolbar2.getTitleMarginEnd();
                    i8 = toolbar2.getTitleMarginTop();
                    i5 = toolbar2.getTitleMarginBottom();
                }
                C2156gp c2156gp = this.Wwwwwwwwwwwwww;
                int i11 = this.Wwwwwwwwwwwwwww.left + (z3 ? i7 : i6);
                Rect rect = this.Wwwwwwwwwwwwwww;
                int i12 = rect.top + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 + i8;
                int i13 = rect.right;
                if (!z3) {
                    i6 = i7;
                }
                int i14 = i13 - i6;
                int i15 = (this.Wwwwwwwwwwwwwww.bottom + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) - i5;
                if (!C2156gp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2156gp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i11, i12, i14, i15)) {
                    c2156gp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.set(i11, i12, i14, i15);
                    c2156gp.Kkkkkkkkkkkkkkkkkkkkkkkkkk = true;
                    c2156gp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                }
                C2156gp c2156gp2 = this.Wwwwwwwwwwwwww;
                int i16 = z3 ? this.Wwwwwwwwwwwwwwwww : this.Wwwwwwwwwwwwwwwwwww;
                int i17 = this.Wwwwwwwwwwwwwww.top + this.Wwwwwwwwwwwwwwwwww;
                int i18 = (i3 - i) - (z3 ? this.Wwwwwwwwwwwwwwwwwww : this.Wwwwwwwwwwwwwwwww);
                int i19 = (i4 - i2) - this.Wwwwwwwwwwwwwwww;
                if (!C2156gp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2156gp2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i16, i17, i18, i19)) {
                    c2156gp2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.set(i16, i17, i18, i19);
                    c2156gp2.Kkkkkkkkkkkkkkkkkkkkkkkkkk = true;
                    c2156gp2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                }
                this.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        }
        if (this.Wwwwwwwwwwwwwwwwwwwwww != null && this.Wwwwwwwwwwwww && TextUtils.isEmpty(this.Wwwwwwwwwwwwww.Wwwwwwwwwww)) {
            ViewGroup viewGroup2 = this.Wwwwwwwwwwwwwwwwwwwwww;
            setTitle(viewGroup2 instanceof Toolbar ? ((Toolbar) viewGroup2).getTitle() : viewGroup2 instanceof android.widget.Toolbar ? ((android.widget.Toolbar) viewGroup2).getTitle() : null);
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        int childCount3 = getChildCount();
        for (int i20 = 0; i20 < childCount3; i20++) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getChildAt(i20)).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i2);
        WindowInsetsCompat windowInsetsCompat = this.Kkkkkkkkkkkkkkkkkkkkkkkkkk;
        int systemWindowInsetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
        if (mode == 0 && systemWindowInsetTop > 0) {
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + systemWindowInsetTop, 1073741824));
        }
        if (this.Wwwwwwwwwwwwwwwwwwwwww != null) {
            View view = this.Wwwwwwwwwwwwwwwwwwwww;
            if (view == null || view == this) {
                view = this.Wwwwwwwwwwwwwwwwwwwwww;
            }
            setMinimumHeight(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view));
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Drawable drawable = this.Wwwwwwwwwww;
        if (drawable != null) {
            drawable.setBounds(0, 0, i, i2);
        }
    }

    public void setCollapsedTitleGravity(int i) {
        C2156gp c2156gp = this.Wwwwwwwwwwwwww;
        if (c2156gp.Wwwwwwwwwwwwwwwwwwwwwwwwwww != i) {
            c2156gp.Wwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            c2156gp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    public void setCollapsedTitleTextAppearance(@StyleRes int i) {
        this.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
    }

    public void setCollapsedTitleTextColor(@ColorInt int i) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(i));
    }

    public void setCollapsedTitleTextColor(@NonNull ColorStateList colorStateList) {
        C2156gp c2156gp = this.Wwwwwwwwwwwwww;
        if (c2156gp.Wwwwwwwwwwwwwwwwwwwwwww != colorStateList) {
            c2156gp.Wwwwwwwwwwwwwwwwwwwwwww = colorStateList;
            c2156gp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    public void setCollapsedTitleTypeface(@Nullable Typeface typeface) {
        this.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(typeface);
    }

    public void setContentScrim(@Nullable Drawable drawable) {
        Drawable drawable2 = this.Wwwwwwwwwww;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.Wwwwwwwwwww = drawable3;
            if (drawable3 != null) {
                drawable3.setBounds(0, 0, getWidth(), getHeight());
                this.Wwwwwwwwwww.setCallback(this);
                this.Wwwwwwwwwww.setAlpha(this.Wwwwwwwww);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setContentScrimColor(@ColorInt int i) {
        setContentScrim(new ColorDrawable(i));
    }

    public void setContentScrimResource(@DrawableRes int i) {
        setContentScrim(ContextCompat.getDrawable(getContext(), i));
    }

    public void setExpandedTitleColor(@ColorInt int i) {
        setExpandedTitleTextColor(ColorStateList.valueOf(i));
    }

    public void setExpandedTitleGravity(int i) {
        C2156gp c2156gp = this.Wwwwwwwwwwwwww;
        if (c2156gp.Wwwwwwwwwwwwwwwwwwwwwwwwwwww != i) {
            c2156gp.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            c2156gp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    public void setExpandedTitleMarginBottom(int i) {
        this.Wwwwwwwwwwwwwwww = i;
        requestLayout();
    }

    public void setExpandedTitleMarginEnd(int i) {
        this.Wwwwwwwwwwwwwwwww = i;
        requestLayout();
    }

    public void setExpandedTitleMarginStart(int i) {
        this.Wwwwwwwwwwwwwwwwwww = i;
        requestLayout();
    }

    public void setExpandedTitleMarginTop(int i) {
        this.Wwwwwwwwwwwwwwwwww = i;
        requestLayout();
    }

    public void setExpandedTitleTextAppearance(@StyleRes int i) {
        this.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
    }

    public void setExpandedTitleTextColor(@NonNull ColorStateList colorStateList) {
        C2156gp c2156gp = this.Wwwwwwwwwwwwww;
        if (c2156gp.Wwwwwwwwwwwwwwwwwwwwwwww != colorStateList) {
            c2156gp.Wwwwwwwwwwwwwwwwwwwwwwww = colorStateList;
            c2156gp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    public void setExpandedTitleTypeface(@Nullable Typeface typeface) {
        this.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(typeface);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setMaxLines(int i) {
        C2156gp c2156gp = this.Wwwwwwwwwwwwww;
        if (i != c2156gp.Kkkkkk) {
            c2156gp.Kkkkkk = i;
            c2156gp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            c2156gp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    public void setScrimAlpha(int i) {
        ViewGroup viewGroup;
        if (i != this.Wwwwwwwww) {
            if (this.Wwwwwwwwwww != null && (viewGroup = this.Wwwwwwwwwwwwwwwwwwwwww) != null) {
                ViewCompat.postInvalidateOnAnimation(viewGroup);
            }
            this.Wwwwwwwww = i;
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setScrimAnimationDuration(@IntRange(from = 0) long j) {
        this.Wwwwww = j;
    }

    public void setScrimVisibleHeightTrigger(@IntRange(from = 0) int i) {
        if (this.Wwwww != i) {
            this.Wwwww = i;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    public void setScrimsShown(boolean z) {
        int i = 0;
        boolean z2 = ViewCompat.isLaidOut(this) && !isInEditMode();
        if (this.Wwwwwwww != z) {
            int i2 = 255;
            if (z2) {
                if (!z) {
                    i2 = 0;
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                ValueAnimator valueAnimator = this.Wwwwwww;
                if (valueAnimator == null) {
                    ValueAnimator valueAnimator2 = new ValueAnimator();
                    this.Wwwwwww = valueAnimator2;
                    valueAnimator2.setDuration(this.Wwwwww);
                    this.Wwwwwww.setInterpolator(i2 > this.Wwwwwwwww ? C2227im.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : C2227im.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    this.Wwwwwww.addUpdateListener(new C2755wm(this));
                } else if (valueAnimator.isRunning()) {
                    this.Wwwwwww.cancel();
                }
                this.Wwwwwww.setIntValues(this.Wwwwwwwww, i2);
                this.Wwwwwww.start();
            } else {
                if (z) {
                    i = 255;
                }
                setScrimAlpha(i);
            }
            this.Wwwwwwww = z;
        }
    }

    public void setStatusBarScrim(@Nullable Drawable drawable) {
        Drawable drawable2 = this.Wwwwwwwwww;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.Wwwwwwwwww = drawable3;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.Wwwwwwwwww.setState(getDrawableState());
                }
                DrawableCompat.setLayoutDirection(this.Wwwwwwwwww, ViewCompat.getLayoutDirection(this));
                this.Wwwwwwwwww.setVisible(getVisibility() == 0, false);
                this.Wwwwwwwwww.setCallback(this);
                this.Wwwwwwwwww.setAlpha(this.Wwwwwwwww);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setStatusBarScrimColor(@ColorInt int i) {
        setStatusBarScrim(new ColorDrawable(i));
    }

    public void setStatusBarScrimResource(@DrawableRes int i) {
        setStatusBarScrim(ContextCompat.getDrawable(getContext(), i));
    }

    public void setTitle(@Nullable CharSequence charSequence) {
        this.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence);
        setContentDescription(getTitle());
    }

    public void setTitleEnabled(boolean z) {
        if (z != this.Wwwwwwwwwwwww) {
            this.Wwwwwwwwwwwww = z;
            setContentDescription(getTitle());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        Drawable drawable = this.Wwwwwwwwww;
        if (drawable != null && drawable.isVisible() != z) {
            this.Wwwwwwwwww.setVisible(z, false);
        }
        Drawable drawable2 = this.Wwwwwwwwwww;
        if (drawable2 == null || drawable2.isVisible() == z) {
            return;
        }
        this.Wwwwwwwwwww.setVisible(z, false);
    }

    @Override // android.view.View
    public boolean verifyDrawable(@NonNull Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.Wwwwwwwwwww || drawable == this.Wwwwwwwwww;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    /* renamed from: generateDefaultLayoutParams  reason: collision with other method in class */
    public FrameLayout.LayoutParams mo4455generateDefaultLayoutParams() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(-1, -1);
    }

    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull View view) {
        return ((getHeight() - Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) - view.getHeight()) - ((FrameLayout.LayoutParams) ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) view.getLayoutParams())).bottomMargin;
    }
}
