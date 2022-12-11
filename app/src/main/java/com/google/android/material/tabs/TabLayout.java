package com.google.android.material.tabs;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.StateSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.BoolRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Pools;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.R$styleable;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.lang.ref.WeakReference;
import me.tvspark.C1955bq;
import me.tvspark.C1989cn;
import me.tvspark.C2043dn;
import me.tvspark.C2227im;
import me.tvspark.C2232ir;
import me.tvspark.C2415np;
import me.tvspark.Illllllllllllllllllllllllllll;
import me.tvspark.View$OnLayoutChangeListenerC2269jr;

@ViewPager.DecorView
/* loaded from: classes3.dex */
public class TabLayout extends HorizontalScrollView {
    public static final Pools.Pool<Wwwwwwwwwwwwwwwwwwwwwwwwwwwww> Kkkkkkkkkkkkkkkkkk = new Pools.SynchronizedPool(16);
    public boolean Kkkkkkkkkkkkkkkkkkk;
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Kkkkkkkkkkkkkkkkkkkk;
    public TabLayoutOnPageChangeListener Kkkkkkkkkkkkkkkkkkkkk;
    public DataSetObserver Kkkkkkkkkkkkkkkkkkkkkk;
    @Nullable
    public PagerAdapter Kkkkkkkkkkkkkkkkkkkkkkk;
    @Nullable
    public ViewPager Kkkkkkkkkkkkkkkkkkkkkkkk;
    public ValueAnimator Kkkkkkkkkkkkkkkkkkkkkkkkk;
    @Nullable
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Kkkkkkkkkkkkkkkkkkkkkkkkkk;
    @Nullable
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Www;
    public boolean Wwww;
    public int Wwwww;
    public boolean Wwwwww;
    public int Wwwwwww;
    public int Wwwwwwww;
    public int Wwwwwwwww;
    public int Wwwwwwwwww;
    public final int Wwwwwwwwwww;
    public float Wwwwwwwwwwww;
    public float Wwwwwwwwwwwww;
    public PorterDuff.Mode Wwwwwwwwwwwwww;
    @NonNull
    public Drawable Wwwwwwwwwwwwwww;
    public ColorStateList Wwwwwwwwwwwwwwww;
    public ColorStateList Wwwwwwwwwwwwwwwww;
    public ColorStateList Wwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes3.dex */
    public static class TabLayoutOnPageChangeListener implements ViewPager.OnPageChangeListener {
        public int Wwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwww;
        @NonNull
        public final WeakReference<TabLayout> Wwwwwwwwwwwwwwwwwwwwwwww;

        public TabLayoutOnPageChangeListener(TabLayout tabLayout) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = new WeakReference<>(tabLayout);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            this.Wwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwww = i;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwww.get() != null) {
                int i3 = this.Wwwwwwwwwwwwwwwwwwwwww;
                int i4 = this.Wwwwwwwwwwwwwwwwwwwwww;
                if (Math.round(i + f) >= 0) {
                    throw null;
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            TabLayout tabLayout = this.Wwwwwwwwwwwwwwwwwwwwwwww.get();
            if (tabLayout == null || tabLayout.getSelectedTabPosition() == i || i >= tabLayout.getTabCount()) {
                return;
            }
            int i2 = this.Wwwwwwwwwwwwwwwwwwwwww;
            boolean z = i2 == 0 || (i2 == 2 && this.Wwwwwwwwwwwwwwwwwwwwwww == 0);
            if (i >= 0 && i < tabLayout.getTabCount()) {
                throw null;
            }
            tabLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) null, z);
        }
    }

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwww implements Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final ViewPager Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwww(ViewPager viewPager) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = viewPager;
        }
    }

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        @NonNull
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        @Nullable
        public TabLayout Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        @Nullable
        public View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        @Nullable
        public CharSequence Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        @Nullable
        public CharSequence Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        @Nullable
        public Drawable Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -1;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = 1;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwww = -1;

        @NonNull
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable CharSequence charSequence) {
            if (TextUtils.isEmpty(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && !TextUtils.isEmpty(charSequence)) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.setContentDescription(charSequence);
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = charSequence;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            return this;
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends DataSetObserver {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (TabLayout.this != null) {
                throw null;
            }
            throw null;
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            if (TabLayout.this != null) {
                throw null;
            }
            throw null;
        }
    }

    /* loaded from: classes3.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Wwwwwwwwwwwwwwwwwwwwwwwwwwwww> {
    }

    @Deprecated
    /* loaded from: classes3.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T extends Wwwwwwwwwwwwwwwwwwwwwwwwwwwww> {
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements ViewPager.OnAdapterChangeListener {
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements ValueAnimator.AnimatorUpdateListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            TabLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
        }
    }

    @Dimension(unit = 0)
    private int getDefaultHeight() {
        throw null;
    }

    private int getTabMinWidth() {
        return 0;
    }

    private int getTabScrollRange() {
        throw null;
    }

    private void setSelectedTabView(int i) {
        throw null;
    }

    @NonNull
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        CharSequence charSequence;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww acquire = Kkkkkkkkkkkkkkkkkk.acquire();
        if (acquire == null) {
            acquire = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        acquire.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = this;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwww(getContext());
        wwwwwwwwwwwwwwwwwwwwwwwwwwww.setTab(acquire);
        wwwwwwwwwwwwwwwwwwwwwwwwwwww.setFocusable(true);
        wwwwwwwwwwwwwwwwwwwwwwwwwwww.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(acquire.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
            charSequence = acquire.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        } else {
            charSequence = acquire.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        wwwwwwwwwwwwwwwwwwwwwwwwwwww.setContentDescription(charSequence);
        acquire.Wwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i = acquire.Wwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i != -1) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwww.setId(i);
        }
        return acquire;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (this.Kkkkkkkkkkkkkkkkkkkkkkkkk == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.Kkkkkkkkkkkkkkkkkkkkkkkkk = valueAnimator;
            valueAnimator.setInterpolator(C2227im.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            this.Kkkkkkkkkkkkkkkkkkkkkkkkk.setDuration(0);
            this.Kkkkkkkkkkkkkkkkkkkkkkkkk.addUpdateListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        if (i == -1) {
            return;
        }
        if (getWindowToken() != null && ViewCompat.isLaidOut(this)) {
            throw null;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, 0.0f, true);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(View view) {
        if (view instanceof C2232ir) {
            C2232ir c2232ir = (C2232ir) view;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            CharSequence charSequence = c2232ir.Wwwwwwwwwwwwwwwwwwwwwwww;
            if (charSequence != null) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence);
            }
            Drawable drawable = c2232ir.Wwwwwwwwwwwwwwwwwwwwwww;
            if (drawable != null) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = drawable;
                TabLayout tabLayout = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (tabLayout.Wwwwwwwww == 1 || tabLayout.Wwwwwww == 2) {
                    throw null;
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
            int i = c2232ir.Wwwwwwwwwwwwwwwwwwwwww;
            if (i != 0) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = LayoutInflater.from(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwww.getContext()).inflate(i, (ViewGroup) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwww, false);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
            if (!TextUtils.isEmpty(c2232ir.getContentDescription())) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2232ir.getContentDescription();
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
            throw null;
        }
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view);
        throw null;
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view);
        throw null;
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view);
        throw null;
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view);
        throw null;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    /* renamed from: generateLayoutParams  reason: collision with other method in class */
    public FrameLayout.LayoutParams mo4459generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    public int getSelectedTabPosition() {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            return wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        return -1;
    }

    public int getTabCount() {
        throw null;
    }

    public int getTabGravity() {
        return this.Wwwwwwwww;
    }

    @Nullable
    public ColorStateList getTabIconTint() {
        return this.Wwwwwwwwwwwwwwwww;
    }

    public int getTabIndicatorAnimationMode() {
        return this.Wwwww;
    }

    public int getTabIndicatorGravity() {
        return this.Wwwwwwww;
    }

    public int getTabMaxWidth() {
        return this.Wwwwwwwwww;
    }

    public int getTabMode() {
        return this.Wwwwwww;
    }

    @Nullable
    public ColorStateList getTabRippleColor() {
        return this.Wwwwwwwwwwwwwwww;
    }

    @NonNull
    public Drawable getTabSelectedIndicator() {
        return this.Wwwwwwwwwwwwwww;
    }

    @Nullable
    public ColorStateList getTabTextColors() {
        return this.Wwwwwwwwwwwwwwwwww;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable background = getBackground();
        if (background instanceof MaterialShapeDrawable) {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((View) this, (MaterialShapeDrawable) background);
        }
        if (this.Kkkkkkkkkkkkkkkkkkkkkkkk == null) {
            ViewParent parent = getParent();
            if (!(parent instanceof ViewPager)) {
                return;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((ViewPager) parent, true, true);
            throw null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.Kkkkkkkkkkkkkkkkkkk) {
            setupWithViewPager(null);
            this.Kkkkkkkkkkkkkkkkkkk = false;
        }
    }

    @Override // android.view.View
    public void onDraw(@NonNull Canvas canvas) {
        throw null;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, getTabCount(), false, 1));
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x006e, code lost:
        if (r0 != 2) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0079, code lost:
        if (r7.getMeasuredWidth() != getMeasuredWidth()) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x007b, code lost:
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0085, code lost:
        if (r7.getMeasuredWidth() < getMeasuredWidth()) goto L22;
     */
    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMeasure(int i, int i2) {
        int round = Math.round(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getContext(), getDefaultHeight()));
        int mode = View.MeasureSpec.getMode(i2);
        boolean z = false;
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                i2 = View.MeasureSpec.makeMeasureSpec(getPaddingBottom() + getPaddingTop() + round, 1073741824);
            }
        } else if (getChildCount() == 1 && View.MeasureSpec.getSize(i2) >= round) {
            getChildAt(0).setMinimumHeight(round);
        }
        int size = View.MeasureSpec.getSize(i);
        if (View.MeasureSpec.getMode(i) != 0) {
            this.Wwwwwwwwww = (int) (size - Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getContext(), 56));
        }
        super.onMeasure(i, i2);
        if (getChildCount() == 1) {
            View childAt = getChildAt(0);
            int i3 = this.Wwwwwww;
            if (i3 != 0) {
                if (i3 != 1) {
                }
                if (!z) {
                    return;
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), HorizontalScrollView.getChildMeasureSpec(i2, getPaddingBottom() + getPaddingTop(), childAt.getLayoutParams().height));
            }
        }
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f) {
        super.setElevation(f);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, f);
    }

    public void setInlineLabel(boolean z) {
        if (this.Wwwwww == z) {
            return;
        }
        this.Wwwwww = z;
        throw null;
    }

    public void setInlineLabelResource(@BoolRes int i) {
        setInlineLabel(getResources().getBoolean(i));
    }

    @Deprecated
    public void setOnTabSelectedListener(@Nullable Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        setOnTabSelectedListener((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    @Deprecated
    public void setOnTabSelectedListener(@Nullable Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        if (this.Www == null) {
            this.Www = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                throw null;
            }
            return;
        }
        throw null;
    }

    public void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Kkkkkkkkkkkkkkkkkkkkkkkkk.addListener(animatorListener);
    }

    public void setSelectedTabIndicator(@DrawableRes int i) {
        setSelectedTabIndicator(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }

    public void setSelectedTabIndicator(@Nullable Drawable drawable) {
        if (this.Wwwwwwwwwwwwwww != drawable) {
            if (drawable == null) {
                drawable = new GradientDrawable();
            }
            this.Wwwwwwwwwwwwwww = drawable;
        }
    }

    public void setSelectedTabIndicatorColor(@ColorInt int i) {
    }

    public void setSelectedTabIndicatorGravity(int i) {
        if (this.Wwwwwwww != i) {
            this.Wwwwwwww = i;
            ViewCompat.postInvalidateOnAnimation(null);
        }
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i) {
        throw null;
    }

    public void setTabGravity(int i) {
        if (this.Wwwwwwwww == i) {
            return;
        }
        this.Wwwwwwwww = i;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        throw null;
    }

    public void setTabIconTint(@Nullable ColorStateList colorStateList) {
        if (this.Wwwwwwwwwwwwwwwww == colorStateList) {
            return;
        }
        this.Wwwwwwwwwwwwwwwww = colorStateList;
        throw null;
    }

    public void setTabIconTintResource(@ColorRes int i) {
        setTabIconTint(AppCompatResources.getColorStateList(getContext(), i));
    }

    public void setTabIndicatorAnimationMode(int i) {
        this.Wwwww = i;
        if (i == 0 || i == 1) {
            return;
        }
        throw new IllegalArgumentException(i + " is not a valid TabIndicatorAnimationMode");
    }

    public void setTabIndicatorFullWidth(boolean z) {
        ViewCompat.postInvalidateOnAnimation(null);
    }

    public void setTabMode(int i) {
        if (i == this.Wwwwwww) {
            return;
        }
        this.Wwwwwww = i;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        throw null;
    }

    public void setTabRippleColor(@Nullable ColorStateList colorStateList) {
        if (this.Wwwwwwwwwwwwwwww == colorStateList) {
            return;
        }
        this.Wwwwwwwwwwwwwwww = colorStateList;
        throw null;
    }

    public void setTabRippleColorResource(@ColorRes int i) {
        setTabRippleColor(AppCompatResources.getColorStateList(getContext(), i));
    }

    public void setTabTextColors(@Nullable ColorStateList colorStateList) {
        if (this.Wwwwwwwwwwwwwwwwww == colorStateList) {
            return;
        }
        this.Wwwwwwwwwwwwwwwwww = colorStateList;
        throw null;
    }

    @Deprecated
    public void setTabsFromPagerAdapter(@Nullable PagerAdapter pagerAdapter) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(pagerAdapter, false);
        throw null;
    }

    public void setUnboundedRipple(boolean z) {
        if (this.Wwww == z) {
            return;
        }
        this.Wwww = z;
        throw null;
    }

    public void setUnboundedRippleResource(@BoolRes int i) {
        setUnboundedRipple(getResources().getBoolean(i));
    }

    public void setupWithViewPager(@Nullable ViewPager viewPager) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(viewPager, true, false);
        throw null;
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    /* loaded from: classes3.dex */
    public final class Wwwwwwwwwwwwwwwwwwwwwwwwwwww extends LinearLayout {
        public int Wwwwwwwwwwwwwww = 2;
        @Nullable
        public Drawable Wwwwwwwwwwwwwwww;
        @Nullable
        public ImageView Wwwwwwwwwwwwwwwww;
        @Nullable
        public TextView Wwwwwwwwwwwwwwwwww;
        @Nullable
        public View Wwwwwwwwwwwwwwwwwww;
        @Nullable
        public C1989cn Wwwwwwwwwwwwwwwwwwww;
        @Nullable
        public View Wwwwwwwwwwwwwwwwwwwww;
        public ImageView Wwwwwwwwwwwwwwwwwwwwww;
        public TextView Wwwwwwwwwwwwwwwwwwwwwww;
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Context context) {
            super(context);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context);
            ViewCompat.setPaddingRelative(this, TabLayout.this.Wwwwwwwwwwwwwwwwwwwwwww, TabLayout.this.Wwwwwwwwwwwwwwwwwwwwww, TabLayout.this.Wwwwwwwwwwwwwwwwwwwww, TabLayout.this.Wwwwwwwwwwwwwwwwwwww);
            setGravity(17);
            setOrientation(!TabLayout.this.Wwwwww ? 1 : 0);
            setClickable(true);
            ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), 1002));
        }

        @Nullable
        private C1989cn getBadge() {
            return this.Wwwwwwwwwwwwwwwwwwww;
        }

        @NonNull
        private C1989cn getOrCreateBadge() {
            if (this.Wwwwwwwwwwwwwwwwwwww == null) {
                Context context = getContext();
                int i = C1989cn.Wwwwwww;
                int i2 = C1989cn.Wwwwwwww;
                C1989cn c1989cn = new C1989cn(context);
                TypedArray Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2415np.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, null, R$styleable.Badge, i, i2, new int[0]);
                c1989cn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getInt(R$styleable.Badge_maxCharacterCount, 4));
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.hasValue(R$styleable.Badge_number)) {
                    c1989cn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getInt(R$styleable.Badge_number, 0));
                }
                c1989cn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, R$styleable.Badge_backgroundColor).getDefaultColor());
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.hasValue(R$styleable.Badge_badgeTextColor)) {
                    c1989cn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, R$styleable.Badge_badgeTextColor).getDefaultColor());
                }
                c1989cn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getInt(R$styleable.Badge_badgeGravity, 8388661));
                c1989cn.Wwwwwwwwwwwwwwwww.Wwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getDimensionPixelOffset(R$styleable.Badge_horizontalOffset, 0);
                c1989cn.Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
                c1989cn.Wwwwwwwwwwwwwwwww.Wwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getDimensionPixelOffset(R$styleable.Badge_verticalOffset, 0);
                c1989cn.Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.recycle();
                this.Wwwwwwwwwwwwwwwwwwww = c1989cn;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            C1989cn c1989cn2 = this.Wwwwwwwwwwwwwwwwwwww;
            if (c1989cn2 != null) {
                return c1989cn2;
            }
            throw new IllegalStateException("Unable to create badge");
        }

        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            Drawable drawable;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            Drawable drawable2 = null;
            View view = wwwwwwwwwwwwwwwwwwwwwwwwwwwww != null ? wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww : null;
            if (view != null) {
                ViewParent parent = view.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(view);
                    }
                    addView(view);
                }
                this.Wwwwwwwwwwwwwwwwwww = view;
                TextView textView = this.Wwwwwwwwwwwwwwwwwwwwwww;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.Wwwwwwwwwwwwwwwwwwwwww;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.Wwwwwwwwwwwwwwwwwwwwww.setImageDrawable(null);
                }
                TextView textView2 = (TextView) view.findViewById(16908308);
                this.Wwwwwwwwwwwwwwwwww = textView2;
                if (textView2 != null) {
                    this.Wwwwwwwwwwwwwww = TextViewCompat.getMaxLines(textView2);
                }
                this.Wwwwwwwwwwwwwwwww = (ImageView) view.findViewById(16908294);
            } else {
                View view2 = this.Wwwwwwwwwwwwwwwwwww;
                if (view2 != null) {
                    removeView(view2);
                    this.Wwwwwwwwwwwwwwwwwww = null;
                }
                this.Wwwwwwwwwwwwwwwwww = null;
                this.Wwwwwwwwwwwwwwwww = null;
            }
            boolean z = false;
            if (this.Wwwwwwwwwwwwwwwwwww == null) {
                if (this.Wwwwwwwwwwwwwwwwwwwwww == null) {
                    ImageView imageView2 = (ImageView) LayoutInflater.from(getContext()).inflate(R$layout.design_layout_tab_icon, (ViewGroup) this, false);
                    this.Wwwwwwwwwwwwwwwwwwwwww = imageView2;
                    addView(imageView2, 0);
                }
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwww != null && (drawable = wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) != null) {
                    drawable2 = DrawableCompat.wrap(drawable).mutate();
                }
                if (drawable2 != null) {
                    DrawableCompat.setTintList(drawable2, TabLayout.this.Wwwwwwwwwwwwwwwww);
                    PorterDuff.Mode mode = TabLayout.this.Wwwwwwwwwwwwww;
                    if (mode != null) {
                        DrawableCompat.setTintMode(drawable2, mode);
                    }
                }
                if (this.Wwwwwwwwwwwwwwwwwwwwwww == null) {
                    TextView textView3 = (TextView) LayoutInflater.from(getContext()).inflate(R$layout.design_layout_tab_text, (ViewGroup) this, false);
                    this.Wwwwwwwwwwwwwwwwwwwwwww = textView3;
                    addView(textView3);
                    this.Wwwwwwwwwwwwwww = TextViewCompat.getMaxLines(this.Wwwwwwwwwwwwwwwwwwwwwww);
                }
                TextViewCompat.setTextAppearance(this.Wwwwwwwwwwwwwwwwwwwwwww, TabLayout.this.Wwwwwwwwwwwwwwwwwww);
                ColorStateList colorStateList = TabLayout.this.Wwwwwwwwwwwwwwwwww;
                if (colorStateList != null) {
                    this.Wwwwwwwwwwwwwwwwwwwwwww.setTextColor(colorStateList);
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                ImageView imageView3 = this.Wwwwwwwwwwwwwwwwwwwwww;
                if (imageView3 != null) {
                    imageView3.addOnLayoutChangeListener(new View$OnLayoutChangeListenerC2269jr(this, imageView3));
                }
                TextView textView4 = this.Wwwwwwwwwwwwwwwwwwwwwww;
                if (textView4 != null) {
                    textView4.addOnLayoutChangeListener(new View$OnLayoutChangeListenerC2269jr(this, textView4));
                }
            } else if (this.Wwwwwwwwwwwwwwwwww != null || this.Wwwwwwwwwwwwwwwww != null) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwww);
            }
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwww != null && !TextUtils.isEmpty(wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                setContentDescription(wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                TabLayout tabLayout = wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (tabLayout == null) {
                    throw new IllegalArgumentException("Tab not attached to a TabLayout");
                }
                if (tabLayout.getSelectedTabPosition() == wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    z = true;
                }
            }
            setSelected(z);
        }

        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            View view;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                return;
            }
            if (this.Wwwwwwwwwwwwwwwwwww == null) {
                View view2 = this.Wwwwwwwwwwwwwwwwwwwwww;
                if (view2 != null && (wwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwww) != null && wwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                    if (this.Wwwwwwwwwwwwwwwwwwwww != view2) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        view = this.Wwwwwwwwwwwwwwwwwwwwww;
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view);
                        return;
                    }
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view2);
                    return;
                }
                view2 = this.Wwwwwwwwwwwwwwwwwwwwwww;
                if (view2 != null && (wwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww) != null && wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww == 1) {
                    if (this.Wwwwwwwwwwwwwwwwwwwww != view2) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        view = this.Wwwwwwwwwwwwwwwwwwwwwww;
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view);
                        return;
                    }
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view2);
                    return;
                }
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }

        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                return;
            }
            setClipChildren(true);
            setClipToPadding(true);
            ViewGroup viewGroup = (ViewGroup) getParent();
            if (viewGroup != null) {
                viewGroup.setClipChildren(true);
                viewGroup.setClipToPadding(true);
            }
            View view = this.Wwwwwwwwwwwwwwwwwwwww;
            if (view == null) {
                return;
            }
            C2043dn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwww, view);
            this.Wwwwwwwwwwwwwwwwwwwww = null;
        }

        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable View view) {
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() && view != null) {
                setClipChildren(false);
                setClipToPadding(false);
                ViewGroup viewGroup = (ViewGroup) getParent();
                if (viewGroup != null) {
                    viewGroup.setClipChildren(false);
                    viewGroup.setClipToPadding(false);
                }
                C2043dn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwww, view, null);
                this.Wwwwwwwwwwwwwwwwwwwww = view;
            }
        }

        public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return this.Wwwwwwwwwwwwwwwwwwww != null;
        }

        @Override // android.view.ViewGroup, android.view.View
        public void drawableStateChanged() {
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            Drawable drawable = this.Wwwwwwwwwwwwwwww;
            boolean z = false;
            if (drawable != null && drawable.isStateful()) {
                z = false | this.Wwwwwwwwwwwwwwww.setState(drawableState);
            }
            if (z) {
                invalidate();
                TabLayout.this.invalidate();
            }
        }

        public int getContentHeight() {
            View[] viewArr = {this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwww};
            int i = 0;
            int i2 = 0;
            boolean z = false;
            for (int i3 = 0; i3 < 3; i3++) {
                View view = viewArr[i3];
                if (view != null && view.getVisibility() == 0) {
                    i2 = z ? Math.min(i2, view.getTop()) : view.getTop();
                    i = z ? Math.max(i, view.getBottom()) : view.getBottom();
                    z = true;
                }
            }
            return i - i2;
        }

        public int getContentWidth() {
            View[] viewArr = {this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwww};
            int i = 0;
            int i2 = 0;
            boolean z = false;
            for (int i3 = 0; i3 < 3; i3++) {
                View view = viewArr[i3];
                if (view != null && view.getVisibility() == 0) {
                    i2 = z ? Math.min(i2, view.getLeft()) : view.getLeft();
                    i = z ? Math.max(i, view.getRight()) : view.getRight();
                    z = true;
                }
            }
            return i - i2;
        }

        @Nullable
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwww getTab() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            C1989cn c1989cn = this.Wwwwwwwwwwwwwwwwwwww;
            if (c1989cn != null && c1989cn.isVisible()) {
                CharSequence contentDescription = getContentDescription();
                accessibilityNodeInfo.setContentDescription(((Object) contentDescription) + ", " + ((Object) this.Wwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()));
            }
            AccessibilityNodeInfoCompat wrap = AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo);
            wrap.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 1, false, isSelected()));
            if (isSelected()) {
                wrap.setClickable(false);
                wrap.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
            }
            wrap.setRoleDescription(getResources().getString(R$string.item_view_role_description));
        }

        /* JADX WARN: Code restructure failed: missing block: B:27:0x0094, code lost:
            if (((r0 / r2.getPaint().getTextSize()) * r2.getLineWidth(0)) > ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) goto L28;
         */
        @Override // android.widget.LinearLayout, android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMeasure(int i, int i2) {
            int size = View.MeasureSpec.getSize(i);
            int mode = View.MeasureSpec.getMode(i);
            int tabMaxWidth = TabLayout.this.getTabMaxWidth();
            if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                i = View.MeasureSpec.makeMeasureSpec(TabLayout.this.Wwwwwwwwww, Integer.MIN_VALUE);
            }
            super.onMeasure(i, i2);
            if (this.Wwwwwwwwwwwwwwwwwwwwwww != null) {
                float f = TabLayout.this.Wwwwwwwwwwwww;
                int i3 = this.Wwwwwwwwwwwwwww;
                ImageView imageView = this.Wwwwwwwwwwwwwwwwwwwwww;
                boolean z = true;
                if (imageView == null || imageView.getVisibility() != 0) {
                    TextView textView = this.Wwwwwwwwwwwwwwwwwwwwwww;
                    if (textView != null && textView.getLineCount() > 1) {
                        f = TabLayout.this.Wwwwwwwwwwww;
                    }
                } else {
                    i3 = 1;
                }
                float textSize = this.Wwwwwwwwwwwwwwwwwwwwwww.getTextSize();
                int lineCount = this.Wwwwwwwwwwwwwwwwwwwwwww.getLineCount();
                int maxLines = TextViewCompat.getMaxLines(this.Wwwwwwwwwwwwwwwwwwwwwww);
                int i4 = (f > textSize ? 1 : (f == textSize ? 0 : -1));
                if (i4 == 0 && (maxLines < 0 || i3 == maxLines)) {
                    return;
                }
                if (TabLayout.this.Wwwwwww == 1 && i4 > 0 && lineCount == 1) {
                    Layout layout = this.Wwwwwwwwwwwwwwwwwwwwwww.getLayout();
                    if (layout != null) {
                    }
                    z = false;
                }
                if (!z) {
                    return;
                }
                this.Wwwwwwwwwwwwwwwwwwwwwww.setTextSize(0, f);
                this.Wwwwwwwwwwwwwwwwwwwwwww.setMaxLines(i3);
                super.onMeasure(i, i2);
            }
        }

        @Override // android.view.View
        public boolean performClick() {
            boolean performClick = super.performClick();
            if (this.Wwwwwwwwwwwwwwwwwwwwwwww != null) {
                if (!performClick) {
                    playSoundEffect(0);
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                TabLayout tabLayout = wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (tabLayout != null) {
                    tabLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwww, true);
                    return true;
                }
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            return performClick;
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            if (isSelected() != z) {
            }
            super.setSelected(z);
            TextView textView = this.Wwwwwwwwwwwwwwwwwwwwwww;
            if (textView != null) {
                textView.setSelected(z);
            }
            ImageView imageView = this.Wwwwwwwwwwwwwwwwwwwwww;
            if (imageView != null) {
                imageView.setSelected(z);
            }
            View view = this.Wwwwwwwwwwwwwwwwwww;
            if (view != null) {
                view.setSelected(z);
            }
        }

        public void setTab(@Nullable Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwww != this.Wwwwwwwwwwwwwwwwwwwwwwww) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        }

        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull View view) {
            if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() || view != this.Wwwwwwwwwwwwwwwwwwwww) {
                return;
            }
            C2043dn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwww, view, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v5, types: [android.graphics.drawable.RippleDrawable] */
        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context) {
            int i = TabLayout.this.Wwwwwwwwwww;
            GradientDrawable gradientDrawable = null;
            if (i != 0) {
                Drawable drawable = AppCompatResources.getDrawable(context, i);
                this.Wwwwwwwwwwwwwwww = drawable;
                if (drawable != null && drawable.isStateful()) {
                    this.Wwwwwwwwwwwwwwww.setState(getDrawableState());
                }
            } else {
                this.Wwwwwwwwwwwwwwww = null;
            }
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setColor(0);
            if (TabLayout.this.Wwwwwwwwwwwwwwww != null) {
                GradientDrawable gradientDrawable3 = new GradientDrawable();
                gradientDrawable3.setCornerRadius(1.0E-5f);
                gradientDrawable3.setColor(-1);
                ColorStateList colorStateList = TabLayout.this.Wwwwwwwwwwwwwwww;
                ColorStateList colorStateList2 = new ColorStateList(new int[][]{C1955bq.Wwwwwwwwwwwwwwwwwwwwwwwww, StateSet.NOTHING}, new int[]{C1955bq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(colorStateList, C1955bq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww), C1955bq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(colorStateList, C1955bq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)});
                if (TabLayout.this.Wwww) {
                    gradientDrawable2 = null;
                }
                if (!TabLayout.this.Wwww) {
                    gradientDrawable = gradientDrawable3;
                }
                gradientDrawable2 = new RippleDrawable(colorStateList2, gradientDrawable2, gradientDrawable);
            }
            ViewCompat.setBackground(this, gradientDrawable2);
            TabLayout.this.invalidate();
        }

        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable TextView textView, @Nullable ImageView imageView) {
            Drawable drawable;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            CharSequence charSequence = null;
            Drawable mutate = (wwwwwwwwwwwwwwwwwwwwwwwwwwwww == null || (drawable = wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) == null) ? null : DrawableCompat.wrap(drawable).mutate();
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            CharSequence charSequence2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null ? wwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : null;
            if (imageView != null) {
                if (mutate != null) {
                    imageView.setImageDrawable(mutate);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable(null);
                }
            }
            boolean z = !TextUtils.isEmpty(charSequence2);
            if (textView != null) {
                if (z) {
                    textView.setText(charSequence2);
                    if (this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww == 1) {
                        textView.setVisibility(0);
                    } else {
                        textView.setVisibility(8);
                    }
                    setVisibility(0);
                } else {
                    textView.setVisibility(8);
                    textView.setText((CharSequence) null);
                }
            }
            if (imageView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (!z || imageView.getVisibility() != 0) ? 0 : (int) Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getContext(), 8);
                if (TabLayout.this.Wwwwww) {
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams)) {
                        MarginLayoutParamsCompat.setMarginEnd(marginLayoutParams, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        marginLayoutParams.bottomMargin = 0;
                        imageView.setLayoutParams(marginLayoutParams);
                        imageView.requestLayout();
                    }
                } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    MarginLayoutParamsCompat.setMarginEnd(marginLayoutParams, 0);
                    imageView.setLayoutParams(marginLayoutParams);
                    imageView.requestLayout();
                }
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwww3 != null) {
                charSequence = wwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            if (!z) {
                charSequence2 = charSequence;
            }
            TooltipCompat.setTooltipText(this, charSequence2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0023, code lost:
        if (r0 != 2) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int i = this.Wwwwwww;
        ViewCompat.setPaddingRelative(null, (i == 0 || i == 2) ? Math.max(0, 0) : 0, 0, 0, 0);
        int i2 = this.Wwwwwww;
        if (i2 == 0) {
            int i3 = this.Wwwwwwwww;
            if (i3 != 0) {
                if (i3 == 1) {
                    throw null;
                }
            }
            throw null;
        } else if (i2 == 1 || i2 == 2) {
            throw null;
        }
        throw null;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww, boolean z) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null) {
                throw null;
            }
            return;
        }
        int i = wwwwwwwwwwwwwwwwwwwwwwwwwwwww != null ? wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : -1;
        if (z) {
            if ((wwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == null || wwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -1) && i != -1) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, 0.0f, true);
            } else {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
            }
            if (i != -1) {
                setSelectedTabView(i);
            }
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null) {
            throw null;
        }
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            throw null;
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable PagerAdapter pagerAdapter, boolean z) {
        DataSetObserver dataSetObserver;
        PagerAdapter pagerAdapter2 = this.Kkkkkkkkkkkkkkkkkkkkkkk;
        if (pagerAdapter2 != null && (dataSetObserver = this.Kkkkkkkkkkkkkkkkkkkkkk) != null) {
            pagerAdapter2.unregisterDataSetObserver(dataSetObserver);
        }
        this.Kkkkkkkkkkkkkkkkkkkkkkk = pagerAdapter;
        if (z && pagerAdapter != null) {
            if (this.Kkkkkkkkkkkkkkkkkkkkkk == null) {
                this.Kkkkkkkkkkkkkkkkkkkkkk = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
            pagerAdapter.registerDataSetObserver(this.Kkkkkkkkkkkkkkkkkkkkkk);
        }
        throw null;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, float f, boolean z) {
        if (Math.round(i + f) < 0) {
            return;
        }
        throw null;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable ViewPager viewPager, boolean z, boolean z2) {
        ViewPager viewPager2 = this.Kkkkkkkkkkkkkkkkkkkkkkkk;
        if (viewPager2 != null) {
            TabLayoutOnPageChangeListener tabLayoutOnPageChangeListener = this.Kkkkkkkkkkkkkkkkkkkkk;
            if (tabLayoutOnPageChangeListener != null) {
                viewPager2.removeOnPageChangeListener(tabLayoutOnPageChangeListener);
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Kkkkkkkkkkkkkkkkkkkk;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                this.Kkkkkkkkkkkkkkkkkkkkkkkk.removeOnAdapterChangeListener(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
        }
        if (this.Kkkkkkkkkkkkkkkkkkkkkkkkkk == null) {
            if (viewPager != null) {
                this.Kkkkkkkkkkkkkkkkkkkkkkkk = viewPager;
                if (this.Kkkkkkkkkkkkkkkkkkkkk == null) {
                    this.Kkkkkkkkkkkkkkkkkkkkk = new TabLayoutOnPageChangeListener(this);
                }
                TabLayoutOnPageChangeListener tabLayoutOnPageChangeListener2 = this.Kkkkkkkkkkkkkkkkkkkkk;
                tabLayoutOnPageChangeListener2.Wwwwwwwwwwwwwwwwwwwwww = 0;
                tabLayoutOnPageChangeListener2.Wwwwwwwwwwwwwwwwwwwwwww = 0;
                viewPager.addOnPageChangeListener(tabLayoutOnPageChangeListener2);
                this.Kkkkkkkkkkkkkkkkkkkkkkkkkk = new Wwwwwwwwwwwwwwwwwwwwwwwwwww(viewPager);
                throw null;
            }
            this.Kkkkkkkkkkkkkkkkkkkkkkkk = null;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((PagerAdapter) null, false);
            throw null;
        }
        throw null;
    }
}
