package com.androidkun.xtablayout;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.core.util.Pools;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.androidkun.xtablayoutlibrary.R$dimen;
import com.androidkun.xtablayoutlibrary.R$layout;
import com.androidkun.xtablayoutlibrary.R$style;
import com.androidkun.xtablayoutlibrary.R$styleable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.tvspark.Kkkkkkkkkkkkkkkkkk;
import me.tvspark.Kkkkkkkkkkkkkkkkkkk;
import me.tvspark.Kkkkkkkkkkkkkkkkkkkkk;
import me.tvspark.Kkkkkkkkkkkkkkkkkkkkkk;
import me.tvspark.Kkkkkkkkkkkkkkkkkkkkkkk;
import me.tvspark.Kkkkkkkkkkkkkkkkkkkkkkkk;
import me.tvspark.Kkkkkkkkkkkkkkkkkkkkkkkkk;
import me.tvspark.Kkkkkkkkkkkkkkkkkkkkkkkkkk;
import me.tvspark.Www;

/* loaded from: classes3.dex */
public class XTabLayout extends HorizontalScrollView {
    public static final Pools.Pool<Wwwwwwwwwwwwwwwwwwwwwwwwwwwww> Kkkkkkkkkk = new Pools.SynchronizedPool(16);
    public final Pools.Pool<Wwwwwwwwwwwwwwwwwwwwwwwwwwww> Kkkkkkkkkkk;
    public TabLayoutOnPageChangeListener Kkkkkkkkkkkk;
    public DataSetObserver Kkkkkkkkkkkkk;
    public PagerAdapter Kkkkkkkkkkkkkk;
    public ViewPager Kkkkkkkkkkkkkkk;
    public Kkkkkkkkkkkkkkkkkkkkk Kkkkkkkkkkkkkkkk;
    public List<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Kkkkkkkkkkkkkkkkk;
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Kkkkkkkkkkkkkkkkkk;
    public int Kkkkkkkkkkkkkkkkkkk;
    public int Kkkkkkkkkkkkkkkkkkkk;
    public int Kkkkkkkkkkkkkkkkkkkkk;
    public int Kkkkkkkkkkkkkkkkkkkkkk;
    public int Kkkkkkkkkkkkkkkkkkkkkkk;
    public int Kkkkkkkkkkkkkkkkkkkkkkkk;
    public int Kkkkkkkkkkkkkkkkkkkkkkkkk;
    public final int Kkkkkkkkkkkkkkkkkkkkkkkkkk;
    public int Www;
    public final int Wwww;
    public final int Wwwww;
    public int Wwwwww;
    public final int Wwwwwww;
    public final int Wwwwwwww;
    public float Wwwwwwwww;
    public boolean Wwwwwwwwww;
    public float Wwwwwwwwwww;
    public boolean Wwwwwwwwwwww;
    public float Wwwwwwwwwwwww;
    public ColorStateList Wwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwww;
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwww;
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwww;
    public final ArrayList<Wwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes3.dex */
    public static class TabLayoutOnPageChangeListener implements ViewPager.OnPageChangeListener {
        public int Wwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwww;
        public final WeakReference<XTabLayout> Wwwwwwwwwwwwwwwwwwwwwwww;

        public TabLayoutOnPageChangeListener(XTabLayout xTabLayout) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = new WeakReference<>(xTabLayout);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            this.Wwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwww = i;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            XTabLayout xTabLayout = this.Wwwwwwwwwwwwwwwwwwwwwwww.get();
            if (xTabLayout != null) {
                boolean z = false;
                boolean z2 = this.Wwwwwwwwwwwwwwwwwwwwww != 2 || this.Wwwwwwwwwwwwwwwwwwwwwww == 1;
                if (this.Wwwwwwwwwwwwwwwwwwwwww != 2 || this.Wwwwwwwwwwwwwwwwwwwwwww != 0) {
                    z = true;
                }
                xTabLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, f, z2, z);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            XTabLayout xTabLayout = this.Wwwwwwwwwwwwwwwwwwwwwwww.get();
            if (xTabLayout == null || xTabLayout.getSelectedTabPosition() == i) {
                return;
            }
            int i2 = this.Wwwwwwwwwwwwwwwwwwwwww;
            xTabLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(xTabLayout.Wwwwwwwwwwwwwwwwwwwwww.get(i), i2 == 0 || (i2 == 2 && this.Wwwwwwwwwwwwwwwwwwwwwww == 0));
        }
    }

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwww implements Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final ViewPager Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwww(ViewPager viewPager) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = viewPager;
        }

        @Override // com.androidkun.xtablayout.XTabLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        }

        @Override // com.androidkun.xtablayout.XTabLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        }

        @Override // com.androidkun.xtablayout.XTabLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setCurrentItem(wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    /* loaded from: classes3.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public XTabLayout Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -1;
        public CharSequence Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public CharSequence Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public Drawable Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        }

        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        }

        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (TextUtils.isEmpty(wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww.getText().toString())) {
                return 0;
            }
            Rect rect = new Rect();
            String charSequence = wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww.getText().toString();
            wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww.getPaint().getTextBounds(charSequence, 0, charSequence.length(), rect);
            return rect.width();
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends DataSetObserver {
        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            XTabLayout.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            XTabLayout.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    /* loaded from: classes3.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww);

        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww);

        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Kkkkkkkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.Kkkkkkkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Kkkkkkkkkkkkkkkkkkkkk kkkkkkkkkkkkkkkkkkkkk) {
            XTabLayout.this.scrollTo(kkkkkkkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), 0);
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // java.lang.Runnable
        public void run() {
            XTabLayout xTabLayout = XTabLayout.this;
            if (xTabLayout.Kkkkkkkkkkkkkkkkkkkkkk > 0) {
                LinearLayout linearLayout = (LinearLayout) xTabLayout.getChildAt(0);
                linearLayout.setShowDividers(2);
                Kkkkkkkkkkkkkkkkkkkkkkkkkk kkkkkkkkkkkkkkkkkkkkkkkkkk = new Kkkkkkkkkkkkkkkkkkkkkkkkkk(XTabLayout.this.getContext());
                XTabLayout xTabLayout2 = XTabLayout.this;
                int i = xTabLayout2.Kkkkkkkkkkkkkkkkkkkkkk;
                int i2 = xTabLayout2.Kkkkkkkkkkkkkkkkkkkkk;
                kkkkkkkkkkkkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
                kkkkkkkkkkkkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
                kkkkkkkkkkkkkkkkkkkkkkkkkk.invalidateSelf();
                kkkkkkkkkkkkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setColor(XTabLayout.this.Kkkkkkkkkkkkkkkkkkkk);
                int i3 = XTabLayout.this.Kkkkkkkkkkkkkkkkkkk;
                if (i3 != 0 && i3 != 1 && i3 != 2) {
                    throw new IllegalArgumentException("Gravity must be one of 0(DividerDrawable.TOP)、1(DividerDrawable.CENTER) and 2(DividerDrawable.BOTTOM)");
                }
                kkkkkkkkkkkkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = i3;
                linearLayout.setDividerDrawable(kkkkkkkkkkkkkkkkkkkkkkkkkk);
            }
        }
    }

    public XTabLayout(Context context) {
        this(context, null);
    }

    public XTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Finally extract failed */
    public XTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Wwwwwwwwwwwwwwwwwwwwwwww = false;
        this.Wwwwwwwwwwwwwwwwwwwwwww = false;
        this.Wwwwwwwwwwwwwwwwwwwwww = new ArrayList<>();
        this.Wwwwwwwwwwwww = 0.0f;
        this.Wwwwwwwwwww = 0.0f;
        this.Wwwwww = Integer.MAX_VALUE;
        this.Kkkkkkkkkkkkkkkkk = new ArrayList();
        this.Kkkkkkkkkkk = new Pools.SimplePool(12);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Kkkkkkkkkkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        boolean z = !obtainStyledAttributes.hasValue(0);
        obtainStyledAttributes.recycle();
        if (!z) {
            setHorizontalScrollBarEnabled(false);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context);
            this.Wwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            super.addView(wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, new FrameLayout.LayoutParams(-2, -1));
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R$styleable.XTabLayout, i, R$style.Widget_Design_TabLayout);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwww;
            int dimensionPixelSize = obtainStyledAttributes2.getDimensionPixelSize(R$styleable.XTabLayout_xTabIndicatorHeight, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2));
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwww != dimensionPixelSize) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwww = dimensionPixelSize;
                ViewCompat.postInvalidateOnAnimation(wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = this.Wwwwwwwwwwwwwwwwwwww;
            int dimensionPixelSize2 = obtainStyledAttributes2.getDimensionPixelSize(R$styleable.XTabLayout_xTabIndicatorWidth, 0);
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwww != dimensionPixelSize2) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwww = dimensionPixelSize2;
                ViewCompat.postInvalidateOnAnimation(wwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = this.Wwwwwwwwwwwwwwwwwwww;
            int dimensionPixelSize3 = obtainStyledAttributes2.getDimensionPixelSize(R$styleable.XTabLayout_xTabIndicatorRoundX, 0);
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwww != dimensionPixelSize3) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwww = dimensionPixelSize3;
                ViewCompat.postInvalidateOnAnimation(wwwwwwwwwwwwwwwwwwwwwwwwwwwwww4);
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = this.Wwwwwwwwwwwwwwwwwwww;
            int dimensionPixelSize4 = obtainStyledAttributes2.getDimensionPixelSize(R$styleable.XTabLayout_xTabIndicatorRoundY, 0);
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwww != dimensionPixelSize4) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwww = dimensionPixelSize4;
                ViewCompat.postInvalidateOnAnimation(wwwwwwwwwwwwwwwwwwwwwwwwwwwwww5);
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = this.Wwwwwwwwwwwwwwwwwwww;
            int color = obtainStyledAttributes2.getColor(R$styleable.XTabLayout_xTabIndicatorColor, 0);
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.Wwwwwwwwwwwwwwwwwwww.getColor() != color) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.Wwwwwwwwwwwwwwwwwwww.setColor(color);
                ViewCompat.postInvalidateOnAnimation(wwwwwwwwwwwwwwwwwwwwwwwwwwwwww6);
            }
            int dimensionPixelSize5 = obtainStyledAttributes2.getDimensionPixelSize(R$styleable.XTabLayout_xTabPadding, 0);
            this.Wwwwwwwwwwwwwwww = dimensionPixelSize5;
            this.Wwwwwwwwwwwwwwwww = dimensionPixelSize5;
            this.Wwwwwwwwwwwwwwwwww = dimensionPixelSize5;
            this.Wwwwwwwwwwwwwwwwwww = dimensionPixelSize5;
            this.Wwwwwwwwwwwwwwwwwww = obtainStyledAttributes2.getDimensionPixelSize(R$styleable.XTabLayout_xTabPaddingStart, dimensionPixelSize5);
            this.Wwwwwwwwwwwwwwwwww = obtainStyledAttributes2.getDimensionPixelSize(R$styleable.XTabLayout_xTabPaddingTop, this.Wwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwww = obtainStyledAttributes2.getDimensionPixelSize(R$styleable.XTabLayout_xTabPaddingEnd, this.Wwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwww = obtainStyledAttributes2.getDimensionPixelSize(R$styleable.XTabLayout_xTabPaddingBottom, this.Wwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwwww = obtainStyledAttributes2.getBoolean(R$styleable.XTabLayout_xTabTextAllCaps, false);
            this.Wwwwwwwwwwwwwww = obtainStyledAttributes2.getResourceId(R$styleable.XTabLayout_xTabTextAppearance, R$style.TextAppearance_Design_Tab);
            this.Wwwwwwwwwwwww = obtainStyledAttributes2.getDimensionPixelSize(R$styleable.XTabLayout_xTabTextSize, 0);
            this.Wwwwwwwwwwww = obtainStyledAttributes2.getBoolean(R$styleable.XTabLayout_xTabTextBold, false);
            this.Wwwwwwwwwww = obtainStyledAttributes2.getDimensionPixelSize(R$styleable.XTabLayout_xTabSelectedTextSize, 0);
            this.Wwwwwwwwww = obtainStyledAttributes2.getBoolean(R$styleable.XTabLayout_xTabTextSelectedBold, false);
            TypedArray obtainStyledAttributes3 = context.obtainStyledAttributes(this.Wwwwwwwwwwwwwww, R$styleable.TextAppearance);
            try {
                if (this.Wwwwwwwwwwwww == 0.0f) {
                    this.Wwwwwwwwwwwww = obtainStyledAttributes3.getDimensionPixelSize(R$styleable.TextAppearance_android_textSize, 0);
                }
                this.Wwwwwwwwwwwwww = obtainStyledAttributes3.getColorStateList(R$styleable.TextAppearance_android_textColor);
                obtainStyledAttributes3.recycle();
                if (obtainStyledAttributes2.hasValue(R$styleable.XTabLayout_xTabTextColor)) {
                    this.Wwwwwwwwwwwwww = obtainStyledAttributes2.getColorStateList(R$styleable.XTabLayout_xTabTextColor);
                }
                if (obtainStyledAttributes2.hasValue(R$styleable.XTabLayout_xTabSelectedTextColor)) {
                    this.Wwwwwwwwwwwwww = new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{obtainStyledAttributes2.getColor(R$styleable.XTabLayout_xTabSelectedTextColor, 0), this.Wwwwwwwwwwwwww.getDefaultColor()});
                }
                this.Www = obtainStyledAttributes2.getInt(R$styleable.XTabLayout_xTabDisplayNum, 0);
                this.Wwwww = obtainStyledAttributes2.getDimensionPixelSize(R$styleable.XTabLayout_xTabMinWidth, -1);
                this.Wwww = obtainStyledAttributes2.getDimensionPixelSize(R$styleable.XTabLayout_xTabMaxWidth, -1);
                this.Wwwwwwww = obtainStyledAttributes2.getColor(R$styleable.XTabLayout_xTabBackgroundColor, 0);
                this.Wwwwwww = obtainStyledAttributes2.getColor(R$styleable.XTabLayout_xTabSelectedBackgroundColor, 0);
                this.Kkkkkkkkkkkkkkkkkkkkkkkkk = obtainStyledAttributes2.getDimensionPixelSize(R$styleable.XTabLayout_xTabContentStart, 0);
                this.Kkkkkkkkkkkkkkkkkkkkkkk = obtainStyledAttributes2.getInt(R$styleable.XTabLayout_xTabMode, 1);
                this.Kkkkkkkkkkkkkkkkkkkkkkkk = obtainStyledAttributes2.getInt(R$styleable.XTabLayout_xTabGravity, 0);
                this.Kkkkkkkkkkkkkkkkkkkkkk = obtainStyledAttributes2.getDimensionPixelSize(R$styleable.XTabLayout_xTabDividerWidth, 0);
                this.Kkkkkkkkkkkkkkkkkkkkk = obtainStyledAttributes2.getDimensionPixelSize(R$styleable.XTabLayout_xTabDividerHeight, 0);
                this.Kkkkkkkkkkkkkkkkkkkk = obtainStyledAttributes2.getColor(R$styleable.XTabLayout_xTabDividerColor, -16777216);
                this.Kkkkkkkkkkkkkkkkkkk = obtainStyledAttributes2.getInteger(R$styleable.XTabLayout_xTabDividerGravity, 1);
                this.Wwwwwwwwwwwwwwwwwwwwwww = obtainStyledAttributes2.getBoolean(R$styleable.XTabLayout_xTabDividerWidthWidthText, false);
                obtainStyledAttributes2.recycle();
                Resources resources = getResources();
                this.Wwwwwwwww = resources.getDimensionPixelSize(R$dimen.design_tab_text_size_2line);
                this.Kkkkkkkkkkkkkkkkkkkkkkkkkk = resources.getDimensionPixelSize(R$dimen.design_tab_scrollable_min_width);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                return;
            } catch (Throwable th) {
                obtainStyledAttributes3.recycle();
                throw th;
            }
        }
        throw new IllegalArgumentException("You need to use a Theme.AppCompat theme (or descendant) with the design library.");
    }

    private int getDefaultHeight() {
        int size = this.Wwwwwwwwwwwwwwwwwwwwww.size();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i < size) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwww.get(i);
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwww != null && wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null && !TextUtils.isEmpty(wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                    z = true;
                    break;
                }
                i++;
            } else {
                break;
            }
        }
        return z ? 72 : 48;
    }

    private float getScrollPosition() {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwww;
        return wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww + wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getTabMaxWidth() {
        return this.Wwwwww;
    }

    private int getTabMinWidth() {
        if (this.Kkkkkkkkkkkkkk == null || this.Www == 0) {
            if (this.Www != 0) {
                return ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getWidth() / this.Www;
            }
            int i = this.Wwwww;
            if (i != -1) {
                return i;
            }
            if (this.Kkkkkkkkkkkkkkkkkkkkkkk != 0) {
                return 0;
            }
            return this.Kkkkkkkkkkkkkkkkkkkkkkkkkk;
        }
        WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
        if (this.Kkkkkkkkkkkkkk.getCount() == 1 || this.Www == 1) {
            return windowManager.getDefaultDisplay().getWidth();
        }
        int count = this.Kkkkkkkkkkkkkk.getCount();
        int i2 = this.Www;
        int width = windowManager.getDefaultDisplay().getWidth();
        return count < i2 ? width / this.Kkkkkkkkkkkkkk.getCount() : width / this.Www;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.Wwwwwwwwwwwwwwwwwwww.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void setSelectedTabView(int i) {
        int childCount = this.Wwwwwwwwwwwwwwwwwwww.getChildCount();
        if (i >= childCount || this.Wwwwwwwwwwwwwwwwwwww.getChildAt(i).isSelected()) {
            return;
        }
        int i2 = 0;
        while (i2 < childCount) {
            this.Wwwwwwwwwwwwwwwwwwww.getChildAt(i2).setSelected(i2 == i);
            i2++;
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int childCount = this.Wwwwwwwwwwwwwwwwwwww.getChildCount();
        while (true) {
            childCount--;
            if (childCount < 0) {
                break;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwwwwwwwwwwwwwww) this.Wwwwwwwwwwwwwwwwwwww.getChildAt(childCount);
            this.Wwwwwwwwwwwwwwwwwwww.removeViewAt(childCount);
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww != null) {
                    wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww = null;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                }
                wwwwwwwwwwwwwwwwwwwwwwwwwwww.setSelected(false);
                this.Kkkkkkkkkkk.release(wwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            requestLayout();
        }
        Iterator<Wwwwwwwwwwwwwwwwwwwwwwwwwwwww> it = this.Wwwwwwwwwwwwwwwwwwwwww.iterator();
        while (it.hasNext()) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwww next = it.next();
            it.remove();
            next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            next.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -1;
            next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            Kkkkkkkkkk.release(next);
        }
        this.Wwwwwwwwwwwwwwwwwwwww = null;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int currentItem;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        PagerAdapter pagerAdapter = this.Kkkkkkkkkkkkkk;
        if (pagerAdapter == null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            return;
        }
        int count = pagerAdapter.getCount();
        for (int i = 0; i < count; i++) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Kkkkkkkkkkkkkk.getPageTitle(i);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, false);
        }
        ViewPager viewPager = this.Kkkkkkkkkkkkkkk;
        if (viewPager == null || count <= 0 || (currentItem = viewPager.getCurrentItem()) == getSelectedTabPosition() || currentItem >= getTabCount()) {
            return;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwww.get(currentItem), true);
    }

    @NonNull
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww acquire = Kkkkkkkkkk.acquire();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        if (acquire == null) {
            acquire = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(null);
        }
        acquire.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = this;
        Pools.Pool<Wwwwwwwwwwwwwwwwwwwwwwwwwwww> pool = this.Kkkkkkkkkkk;
        if (pool != null) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwww = pool.acquire();
        }
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwww(getContext());
        }
        if (acquire != wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww = acquire;
            wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        wwwwwwwwwwwwwwwwwwwwwwwwwwww.setFocusable(true);
        wwwwwwwwwwwwwwwwwwwwwwwwwwww.setMinimumWidth(getTabMinWidth());
        acquire.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        return acquire;
    }

    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        return Math.round(getResources().getDisplayMetrics().density * i);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        ViewCompat.setPaddingRelative(this.Wwwwwwwwwwwwwwwwwwww, this.Kkkkkkkkkkkkkkkkkkkkkkk == 0 ? Math.max(0, this.Kkkkkkkkkkkkkkkkkkkkkkkkk - this.Wwwwwwwwwwwwwwwwwww) : 0, 0, 0, 0);
        int i = this.Kkkkkkkkkkkkkkkkkkkkkkk;
        if (i == 0) {
            this.Wwwwwwwwwwwwwwwwwwww.setGravity(GravityCompat.START);
        } else if (i == 1) {
            this.Wwwwwwwwwwwwwwwwwwww.setGravity(1);
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww, boolean z) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == null) {
                return;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = this.Kkkkkkkkkkkkkkkkkk;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 != null) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            }
            for (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 : this.Kkkkkkkkkkkkkkkkk) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwww);
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            return;
        }
        if (z) {
            int i = wwwwwwwwwwwwwwwwwwwwwwwwwwwww != null ? wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : -1;
            if (i != -1) {
                setSelectedTabView(i);
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = this.Wwwwwwwwwwwwwwwwwwwww;
            if ((wwwwwwwwwwwwwwwwwwwwwwwwwwwww3 == null || wwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -1) && i != -1) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, 0.0f, true, true);
            } else {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
            }
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = this.Wwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwww4 != null && (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Kkkkkkkkkkkkkkkkkk) != null) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwww4);
        }
        for (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 : this.Kkkkkkkkkkkkkkkkk) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwww);
        }
        this.Wwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwww != null && (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Kkkkkkkkkkkkkkkkkk) != null) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        for (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 : this.Kkkkkkkkkkkkkkkkk) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwww);
        }
    }

    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, float f) {
        int i2 = 0;
        if (this.Kkkkkkkkkkkkkkkkkkkkkkk == 0) {
            View childAt = this.Wwwwwwwwwwwwwwwwwwww.getChildAt(i);
            int i3 = i + 1;
            View childAt2 = i3 < this.Wwwwwwwwwwwwwwwwwwww.getChildCount() ? this.Wwwwwwwwwwwwwwwwwwww.getChildAt(i3) : null;
            int width = childAt != null ? childAt.getWidth() : 0;
            if (childAt2 != null) {
                i2 = childAt2.getWidth();
            }
            return ((childAt.getWidth() / 2) + (childAt.getLeft() + ((int) (((width + i2) * f) * 0.5f)))) - (getWidth() / 2);
        }
        return 0;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        post(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(LinearLayout.LayoutParams layoutParams) {
        float f;
        if (this.Kkkkkkkkkkkkkkkkkkkkkkk == 1 && this.Kkkkkkkkkkkkkkkkkkkkkkkk == 0) {
            layoutParams.width = 0;
            f = 1.0f;
        } else {
            layoutParams.width = -2;
            f = 0.0f;
        }
        layoutParams.weight = f;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable PagerAdapter pagerAdapter, boolean z) {
        DataSetObserver dataSetObserver;
        PagerAdapter pagerAdapter2 = this.Kkkkkkkkkkkkkk;
        if (pagerAdapter2 != null && (dataSetObserver = this.Kkkkkkkkkkkkk) != null) {
            pagerAdapter2.unregisterDataSetObserver(dataSetObserver);
        }
        this.Kkkkkkkkkkkkkk = pagerAdapter;
        if (z && pagerAdapter != null) {
            if (this.Kkkkkkkkkkkkk == null) {
                this.Kkkkkkkkkkkkk = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null);
            }
            pagerAdapter.registerDataSetObserver(this.Kkkkkkkkkkkkk);
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww.isEmpty());
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww, boolean z) {
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww == this) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (this.Wwwwwwwwwww != 0.0f) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwww.post(new Kkkkkkkkkkkkkkkkkk(this, wwwwwwwwwwwwwwwwwwwwwwwwwwww));
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwww;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(layoutParams);
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.addView(wwwwwwwwwwwwwwwwwwwwwwwwwwww, layoutParams);
            if (z) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwww.setSelected(true);
            }
            int size = this.Wwwwwwwwwwwwwwwwwwwwww.size();
            wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = size;
            this.Wwwwwwwwwwwwwwwwwwwwww.add(size, wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            int size2 = this.Wwwwwwwwwwwwwwwwwwwwww.size();
            while (true) {
                size++;
                if (size >= size2) {
                    break;
                }
                this.Wwwwwwwwwwwwwwwwwwwwww.get(size).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = size;
            }
            if (!z) {
                return;
            }
            XTabLayout xTabLayout = wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (xTabLayout != null) {
                xTabLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwww, true);
                return;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
        for (int i = 0; i < this.Wwwwwwwwwwwwwwwwwwww.getChildCount(); i++) {
            View childAt = this.Wwwwwwwwwwwwwwwwwwww.getChildAt(i);
            childAt.setMinimumWidth(getTabMinWidth());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((LinearLayout.LayoutParams) childAt.getLayoutParams());
            if (z) {
                childAt.requestLayout();
            }
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    /* renamed from: generateLayoutParams  reason: collision with other method in class */
    public FrameLayout.LayoutParams mo4404generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    public int getSelectedTabPosition() {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            return wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        return -1;
    }

    public int getTabCount() {
        return this.Wwwwwwwwwwwwwwwwwwwwww.size();
    }

    public int getTabGravity() {
        return this.Kkkkkkkkkkkkkkkkkkkkkkkk;
    }

    public int getTabMode() {
        return this.Kkkkkkkkkkkkkkkkkkkkkkk;
    }

    @Nullable
    public ColorStateList getTabTextColors() {
        return this.Wwwwwwwwwwwwww;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0052, code lost:
        if (r1 > 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0071, code lost:
        r1 = r0 - Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(56);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0077, code lost:
        r6.Wwwwww = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x006e, code lost:
        if (r1 > 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0096, code lost:
        if (r0.getMeasuredWidth() != getMeasuredWidth()) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a4, code lost:
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a5, code lost:
        r7 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00a1, code lost:
        if (r0.getMeasuredWidth() < getMeasuredWidth()) goto L30;
     */
    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMeasure(int i, int i2) {
        int i3;
        int paddingBottom = getPaddingBottom() + getPaddingTop() + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getDefaultHeight());
        int mode = View.MeasureSpec.getMode(i2);
        if (mode == Integer.MIN_VALUE) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.min(paddingBottom, View.MeasureSpec.getSize(i2)), 1073741824);
        } else if (mode == 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(paddingBottom, 1073741824);
        }
        int size = View.MeasureSpec.getSize(i);
        boolean z = true;
        if (View.MeasureSpec.getMode(i) != 0) {
            PagerAdapter pagerAdapter = this.Kkkkkkkkkkkkkk;
            if (pagerAdapter == null || this.Www == 0) {
                i3 = this.Wwww;
            } else if (pagerAdapter.getCount() == 1 || this.Www == 1) {
                this.Wwwwww = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getWidth();
            } else {
                i3 = this.Wwww;
            }
        }
        super.onMeasure(i, i2);
        if (getChildCount() == 1) {
            boolean z2 = false;
            View childAt = getChildAt(0);
            int i4 = this.Kkkkkkkkkkkkkkkkkkkkkkk;
            if (i4 != 0) {
                if (i4 == 1) {
                }
            }
            if (!z2) {
                return;
            }
            childAt.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), HorizontalScrollView.getChildMeasureSpec(i2, getPaddingBottom() + getPaddingTop(), childAt.getLayoutParams().height));
        }
    }

    public void setAllCaps(boolean z) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = z;
    }

    public void setDividerColor(int i) {
        this.Kkkkkkkkkkkkkkkkkkkk = i;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public void setDividerGravity(int i) {
        this.Kkkkkkkkkkkkkkkkkkk = i;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public void setOnTabSelectedListener(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Kkkkkkkkkkkkkkkkkk = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public void setSelectedTabIndicatorColor(@ColorInt int i) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww.getColor() != i) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww.setColor(i);
            ViewCompat.postInvalidateOnAnimation(wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    public void setSelectedTabIndicatorHeight(int i) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww != i) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww = i;
            ViewCompat.postInvalidateOnAnimation(wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    public void setTabGravity(int i) {
        if (this.Kkkkkkkkkkkkkkkkkkkkkkkk != i) {
            this.Kkkkkkkkkkkkkkkkkkkkkkkk = i;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    public void setTabMode(int i) {
        if (i != this.Kkkkkkkkkkkkkkkkkkkkkkk) {
            this.Kkkkkkkkkkkkkkkkkkkkkkk = i;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    public void setTabTextColors(@Nullable ColorStateList colorStateList) {
        if (this.Wwwwwwwwwwwwww != colorStateList) {
            this.Wwwwwwwwwwwwww = colorStateList;
            int size = this.Wwwwwwwwwwwwwwwwwwwwww.size();
            for (int i = 0; i < size; i++) {
                this.Wwwwwwwwwwwwwwwwwwwwww.get(i).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(@Nullable PagerAdapter pagerAdapter) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(pagerAdapter, false);
    }

    public void setupWithViewPager(@Nullable ViewPager viewPager) {
        TabLayoutOnPageChangeListener tabLayoutOnPageChangeListener;
        ViewPager viewPager2 = this.Kkkkkkkkkkkkkkk;
        if (viewPager2 != null && (tabLayoutOnPageChangeListener = this.Kkkkkkkkkkkk) != null) {
            viewPager2.removeOnPageChangeListener(tabLayoutOnPageChangeListener);
        }
        if (viewPager == null) {
            this.Kkkkkkkkkkkkkkk = null;
            setOnTabSelectedListener(null);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((PagerAdapter) null, true);
            return;
        }
        PagerAdapter adapter = viewPager.getAdapter();
        if (adapter == null) {
            throw new IllegalArgumentException("ViewPager does not have a PagerAdapter set");
        }
        this.Kkkkkkkkkkkkkkk = viewPager;
        if (this.Kkkkkkkkkkkk == null) {
            this.Kkkkkkkkkkkk = new TabLayoutOnPageChangeListener(this);
        }
        TabLayoutOnPageChangeListener tabLayoutOnPageChangeListener2 = this.Kkkkkkkkkkkk;
        tabLayoutOnPageChangeListener2.Wwwwwwwwwwwwwwwwwwwwww = 0;
        tabLayoutOnPageChangeListener2.Wwwwwwwwwwwwwwwwwwwwwww = 0;
        viewPager.addOnPageChangeListener(tabLayoutOnPageChangeListener2);
        setOnTabSelectedListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwww(viewPager));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(adapter, true);
    }

    public void setxTabDisplayNum(int i) {
        this.Www = i;
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwww extends LinearLayout implements View.OnLongClickListener {
        public int Wwwwwwwwwwwwwwwwww = 2;
        public ImageView Wwwwwwwwwwwwwwwwwww;
        public TextView Wwwwwwwwwwwwwwwwwwww;
        public View Wwwwwwwwwwwwwwwwwwwww;
        public ImageView Wwwwwwwwwwwwwwwwwwwwww;
        public TextView Wwwwwwwwwwwwwwwwwwwwwww;
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context) {
            super(context);
            ViewCompat.setPaddingRelative(this, XTabLayout.this.Wwwwwwwwwwwwwwwwwww, XTabLayout.this.Wwwwwwwwwwwwwwwwww, XTabLayout.this.Wwwwwwwwwwwwwwwww, XTabLayout.this.Wwwwwwwwwwwwwwww);
            setGravity(17);
            setOrientation(1);
            setClickable(true);
        }

        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            TextView textView;
            ImageView imageView;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            View view = wwwwwwwwwwwwwwwwwwwwwwwwwwwww != null ? wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww : null;
            if (view != null) {
                ViewParent parent = view.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(view);
                    }
                    addView(view);
                }
                this.Wwwwwwwwwwwwwwwwwwwww = view;
                TextView textView2 = this.Wwwwwwwwwwwwwwwwwwwwwww;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                }
                ImageView imageView2 = this.Wwwwwwwwwwwwwwwwwwwwww;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                    this.Wwwwwwwwwwwwwwwwwwwwww.setImageDrawable(null);
                }
                TextView textView3 = (TextView) view.findViewById(16908308);
                this.Wwwwwwwwwwwwwwwwwwww = textView3;
                if (textView3 != null) {
                    this.Wwwwwwwwwwwwwwwwww = TextViewCompat.getMaxLines(textView3);
                }
                this.Wwwwwwwwwwwwwwwwwww = (ImageView) view.findViewById(16908294);
            } else {
                View view2 = this.Wwwwwwwwwwwwwwwwwwwww;
                if (view2 != null) {
                    removeView(view2);
                    this.Wwwwwwwwwwwwwwwwwwwww = null;
                }
                this.Wwwwwwwwwwwwwwwwwwww = null;
                this.Wwwwwwwwwwwwwwwwwww = null;
            }
            if (this.Wwwwwwwwwwwwwwwwwwwww == null) {
                if (this.Wwwwwwwwwwwwwwwwwwwwww == null) {
                    ImageView imageView3 = (ImageView) LayoutInflater.from(getContext()).inflate(R$layout.design_layout_tab_icon, (ViewGroup) this, false);
                    addView(imageView3, 0);
                    this.Wwwwwwwwwwwwwwwwwwwwww = imageView3;
                }
                if (this.Wwwwwwwwwwwwwwwwwwwwwww == null) {
                    TextView textView4 = (TextView) LayoutInflater.from(getContext()).inflate(R$layout.design_layout_tab_text, (ViewGroup) this, false);
                    addView(textView4);
                    this.Wwwwwwwwwwwwwwwwwwwwwww = textView4;
                    this.Wwwwwwwwwwwwwwwwww = TextViewCompat.getMaxLines(textView4);
                }
                this.Wwwwwwwwwwwwwwwwwwwwwww.setTextAppearance(getContext(), XTabLayout.this.Wwwwwwwwwwwwwww);
                ColorStateList colorStateList = XTabLayout.this.Wwwwwwwwwwwwww;
                if (colorStateList != null) {
                    this.Wwwwwwwwwwwwwwwwwwwwwww.setTextColor(colorStateList);
                }
                textView = this.Wwwwwwwwwwwwwwwwwwwwwww;
                imageView = this.Wwwwwwwwwwwwwwwwwwwwww;
            } else if (this.Wwwwwwwwwwwwwwwwwwww == null && this.Wwwwwwwwwwwwwwwwwww == null) {
                return;
            } else {
                textView = this.Wwwwwwwwwwwwwwwwwwww;
                imageView = this.Wwwwwwwwwwwwwwwwwww;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(textView, imageView);
        }

        @Override // android.view.View
        @TargetApi(14)
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(ActionBar.Tab.class.getName());
        }

        @Override // android.view.View
        @TargetApi(14)
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(ActionBar.Tab.class.getName());
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            Context context = getContext();
            int width = getWidth();
            int height = getHeight();
            int i = context.getResources().getDisplayMetrics().widthPixels;
            Toast makeText = Toast.makeText(context, this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0);
            makeText.setGravity(49, ((width / 2) + iArr[0]) - (i / 2), height);
            makeText.show();
            return true;
        }

        /* JADX WARN: Code restructure failed: missing block: B:27:0x008c, code lost:
            if (((r0 / r2.getPaint().getTextSize()) * r2.getLineWidth(0)) > r2.getWidth()) goto L28;
         */
        @Override // android.widget.LinearLayout, android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMeasure(int i, int i2) {
            int size = View.MeasureSpec.getSize(i);
            int mode = View.MeasureSpec.getMode(i);
            int tabMaxWidth = XTabLayout.this.getTabMaxWidth();
            if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                i = View.MeasureSpec.makeMeasureSpec(XTabLayout.this.Wwwwww, Integer.MIN_VALUE);
            }
            super.onMeasure(i, i2);
            if (this.Wwwwwwwwwwwwwwwwwwwwwww != null) {
                getResources();
                float f = XTabLayout.this.Wwwwwwwwwwwww;
                int i3 = this.Wwwwwwwwwwwwwwwwww;
                ImageView imageView = this.Wwwwwwwwwwwwwwwwwwwwww;
                boolean z = true;
                if (imageView == null || imageView.getVisibility() != 0) {
                    TextView textView = this.Wwwwwwwwwwwwwwwwwwwwwww;
                    if (textView != null && textView.getLineCount() > 1) {
                        f = XTabLayout.this.Wwwwwwwww;
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
                if (XTabLayout.this.Kkkkkkkkkkkkkkkkkkkkkkk == 1 && i4 > 0 && lineCount == 1) {
                    Layout layout = this.Wwwwwwwwwwwwwwwwwwwwwww.getLayout();
                    if (layout != null) {
                    }
                    z = false;
                }
                if (!z) {
                    return;
                }
                if (this.Wwwwwwwwwwwwwwwwwwwwwww.isSelected()) {
                    float f2 = XTabLayout.this.Wwwwwwwwwww;
                    if (f2 != 0.0f) {
                        this.Wwwwwwwwwwwwwwwwwwwwwww.setTextSize(0, f2);
                        this.Wwwwwwwwwwwwwwwwwwwwwww.setMaxLines(i3);
                        super.onMeasure(i, i2);
                    }
                }
                this.Wwwwwwwwwwwwwwwwwwwwwww.setTextSize(0, XTabLayout.this.Wwwwwwwwwwwww);
                this.Wwwwwwwwwwwwwwwwwwwwwww.setMaxLines(i3);
                super.onMeasure(i, i2);
            }
        }

        @Override // android.view.View
        public boolean performClick() {
            boolean performClick = super.performClick();
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                XTabLayout xTabLayout = wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (xTabLayout != null) {
                    xTabLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwww, true);
                    return true;
                }
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            return performClick;
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            TextView textView;
            Typeface defaultFromStyle;
            TextView textView2;
            Typeface defaultFromStyle2;
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (!z) {
                int i = XTabLayout.this.Wwwwwwww;
                if (i != 0) {
                    setBackgroundColor(i);
                }
                this.Wwwwwwwwwwwwwwwwwwwwwww.setTextSize(0, XTabLayout.this.Wwwwwwwwwwwww);
                if (XTabLayout.this.Wwwwwwwwwwww) {
                    textView2 = this.Wwwwwwwwwwwwwwwwwwwwwww;
                    defaultFromStyle2 = Typeface.defaultFromStyle(1);
                } else {
                    textView2 = this.Wwwwwwwwwwwwwwwwwwwwwww;
                    defaultFromStyle2 = Typeface.defaultFromStyle(0);
                }
                textView2.setTypeface(defaultFromStyle2);
            }
            if (!z2 || !z) {
                return;
            }
            int i2 = XTabLayout.this.Wwwwwww;
            if (i2 != 0) {
                setBackgroundColor(i2);
            }
            sendAccessibilityEvent(4);
            TextView textView3 = this.Wwwwwwwwwwwwwwwwwwwwwww;
            if (textView3 != null) {
                textView3.setSelected(z);
                float f = XTabLayout.this.Wwwwwwwwwww;
                if (f != 0.0f) {
                    this.Wwwwwwwwwwwwwwwwwwwwwww.setTextSize(0, f);
                    if (XTabLayout.this.Wwwwwwwwww) {
                        textView = this.Wwwwwwwwwwwwwwwwwwwwwww;
                        defaultFromStyle = Typeface.defaultFromStyle(1);
                    } else {
                        textView = this.Wwwwwwwwwwwwwwwwwwwwwww;
                        defaultFromStyle = Typeface.defaultFromStyle(0);
                    }
                    textView.setTypeface(defaultFromStyle);
                }
            }
            ImageView imageView = this.Wwwwwwwwwwwwwwwwwwwwww;
            if (imageView == null) {
                return;
            }
            imageView.setSelected(z);
        }

        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable TextView textView, @Nullable ImageView imageView) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            Drawable drawable = wwwwwwwwwwwwwwwwwwwwwwwwwwwww != null ? wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : null;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            CharSequence charSequence = wwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null ? wwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : null;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            CharSequence charSequence2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwww3 != null ? wwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : null;
            if (imageView != null) {
                if (drawable != null) {
                    imageView.setImageDrawable(drawable);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable(null);
                }
                imageView.setContentDescription(charSequence2);
            }
            boolean z = !TextUtils.isEmpty(charSequence);
            if (textView != null) {
                if (z) {
                    textView.setAllCaps(XTabLayout.this.Wwwwwwwwwwwwwwwwwwwwwwww);
                    textView.setText(charSequence);
                    textView.setVisibility(0);
                    setVisibility(0);
                } else {
                    textView.setVisibility(8);
                    textView.setText((CharSequence) null);
                }
                textView.setContentDescription(charSequence2);
            }
            if (imageView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (!z || imageView.getVisibility() != 0) ? 0 : XTabLayout.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(8);
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    imageView.requestLayout();
                }
            }
            if (!z && !TextUtils.isEmpty(charSequence2)) {
                setOnLongClickListener(this);
                return;
            }
            setOnLongClickListener(null);
            setLongClickable(false);
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends LinearLayout {
        public Kkkkkkkkkkkkkkkkkkkkk Wwwwwwwwwwwwwww;
        public float Wwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwww = -1;
        public int Wwwwwwwwwwwwwwwww = -1;
        public int Wwwwwwwwwwwwwwww = -1;
        public final Paint Wwwwwwwwwwwwwwwwwwww = new Paint();

        /* loaded from: classes3.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends Kkkkkkkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
            public final /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            }

            @Override // me.tvspark.Kkkkkkkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
            public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Kkkkkkkkkkkkkkkkkkkkk kkkkkkkkkkkkkkkkkkkkk) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this;
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww = 0.0f;
            }
        }

        /* loaded from: classes3.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Kkkkkkkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
            public final /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            public final /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            public final /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            public final /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, int i3, int i4) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i3;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i4;
            }

            @Override // me.tvspark.Kkkkkkkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
            public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Kkkkkkkkkkkkkkkkkkkkk kkkkkkkkkkkkkkkkkkkkk) {
                float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = kkkkkkkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Www.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), Www.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context) {
            super(context);
            setWillNotDraw(false);
        }

        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
            XTabLayout xTabLayout = XTabLayout.this;
            int i3 = i + xTabLayout.Wwwwwwwwwwwwwwwwwww;
            int i4 = i2 - xTabLayout.Wwwwwwwwwwwwwwwww;
            if (i3 == this.Wwwwwwwwwwwwwwwww && i4 == this.Wwwwwwwwwwwwwwww) {
                return;
            }
            this.Wwwwwwwwwwwwwwwww = i3;
            this.Wwwwwwwwwwwwwwww = i4;
            ViewCompat.postInvalidateOnAnimation(this);
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
            int i3;
            int i4;
            Kkkkkkkkkkkkkkkkkkkkk kkkkkkkkkkkkkkkkkkkkk = this.Wwwwwwwwwwwwwww;
            if (kkkkkkkkkkkkkkkkkkkkk != null && kkkkkkkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                this.Wwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
            boolean z = ViewCompat.getLayoutDirection(this) == 1;
            View childAt = getChildAt(i);
            if (childAt == null) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                return;
            }
            int left = childAt.getLeft();
            int right = childAt.getRight();
            if (Math.abs(i - this.Wwwwwwwwwwwwwwwwwww) <= 1) {
                i3 = this.Wwwwwwwwwwwwwwwww;
                i4 = this.Wwwwwwwwwwwwwwww;
            } else {
                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = XTabLayout.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(24);
                i3 = (i >= this.Wwwwwwwwwwwwwwwwwww ? !z : z) ? left - Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 + right;
                i4 = i3;
            }
            if (i3 == left && i4 == right) {
                return;
            }
            Kkkkkkkkkkkkkkkkkkkkk Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Kkkkkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            this.Wwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Www.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0.0f, 1.0f);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Kkkkkkkkkkkkkkkkkkkkkkk(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3, left, i4, right)));
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Kkkkkkkkkkkkkkkkkkkkkk(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i)));
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x006e  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x007a  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0075  */
        @Override // android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void draw(Canvas canvas) {
            int i;
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            int i2;
            super.draw(canvas);
            int i3 = this.Wwwwwwwwwwwwwwwww;
            if (i3 < 0 || (i = this.Wwwwwwwwwwwwwwww) <= i3) {
                return;
            }
            int i4 = this.Wwwwwwwwwwwwwwwwwwwwwww;
            if (i4 == 0 || XTabLayout.this.Wwwwwwwwwwwwwwwwwwwwwww) {
                int i5 = this.Wwwwwwwwwwwwwwww - this.Wwwwwwwwwwwwwwwww;
                if (i5 > XTabLayout.this.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                    this.Wwwwwwwwwwwwwwwww = ((i5 - XTabLayout.this.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) / 2) + this.Wwwwwwwwwwwwwwwww;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwww - ((i5 - XTabLayout.this.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) / 2);
                    this.Wwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                }
                RectF rectF = new RectF(this.Wwwwwwwwwwwwwwwww, getHeight() - this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwww, getHeight());
                int i6 = this.Wwwwwwwwwwwwwwwwwwwwww;
                int i7 = 0;
                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = i6 <= 0 ? XTabLayout.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i6) : 0;
                i2 = this.Wwwwwwwwwwwwwwwwwwwww;
                if (i2 > 0) {
                    i7 = XTabLayout.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2);
                }
                canvas.drawRoundRect(rectF, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, i7, this.Wwwwwwwwwwwwwwwwwwww);
            }
            int i8 = i - i3;
            if (i8 > i4) {
                int i9 = (i8 - i4) / 2;
                this.Wwwwwwwwwwwwwwwww = i3 + i9;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = i - i9;
                this.Wwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            }
            RectF rectF2 = new RectF(this.Wwwwwwwwwwwwwwwww, getHeight() - this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwww, getHeight());
            int i62 = this.Wwwwwwwwwwwwwwwwwwwwww;
            int i72 = 0;
            if (i62 <= 0) {
            }
            i2 = this.Wwwwwwwwwwwwwwwwwwwww;
            if (i2 > 0) {
            }
            canvas.drawRoundRect(rectF2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, i72, this.Wwwwwwwwwwwwwwwwwwww);
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        public void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            Kkkkkkkkkkkkkkkkkkkkk kkkkkkkkkkkkkkkkkkkkk = this.Wwwwwwwwwwwwwww;
            if (kkkkkkkkkkkkkkkkkkkkk == null || !kkkkkkkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                return;
            }
            this.Wwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwww, Math.round((1.0f - this.Wwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) * ((float) this.Wwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww())));
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (View.MeasureSpec.getMode(i) != 1073741824) {
                return;
            }
            XTabLayout xTabLayout = XTabLayout.this;
            boolean z = true;
            if (xTabLayout.Kkkkkkkkkkkkkkkkkkkkkkk != 1 || xTabLayout.Kkkkkkkkkkkkkkkkkkkkkkkk != 1) {
                return;
            }
            int childCount = getChildCount();
            int i3 = 0;
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (childAt.getVisibility() == 0) {
                    i3 = Math.max(i3, childAt.getMeasuredWidth());
                }
            }
            if (i3 <= 0) {
                return;
            }
            if (i3 * childCount <= getMeasuredWidth() - (XTabLayout.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(16) * 2)) {
                boolean z2 = false;
                for (int i5 = 0; i5 < childCount; i5++) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i5).getLayoutParams();
                    if (layoutParams.width != i3 || layoutParams.weight != 0.0f) {
                        layoutParams.width = i3;
                        layoutParams.weight = 0.0f;
                        z2 = true;
                    }
                }
                z = z2;
            } else {
                XTabLayout xTabLayout2 = XTabLayout.this;
                xTabLayout2.Kkkkkkkkkkkkkkkkkkkkkkkk = 0;
                xTabLayout2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
            }
            if (!z) {
                return;
            }
            super.onMeasure(i, i2);
        }

        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            int i;
            int i2;
            View childAt = getChildAt(this.Wwwwwwwwwwwwwwwwwww);
            int i3 = -1;
            if (childAt == null || childAt.getWidth() <= 0) {
                i = -1;
            } else {
                int left = childAt.getLeft();
                i = childAt.getRight();
                int i4 = 0;
                if (this.Wwwwwwwwwwwwwwwwwwwwwww == 0 && !XTabLayout.this.Wwwwwwwwwwwwwwwwwwwwwww) {
                    this.Wwwwwwwwwwwwwwwwwwwwwww = 16843039;
                }
                int i5 = this.Wwwwwwwwwwwwwwwwwwwwwww;
                if (i5 != 0 && (i2 = this.Wwwwwwwwwwwwwwww - this.Wwwwwwwwwwwwwwwww) > i5) {
                    i4 = (i2 - i5) / 2;
                    left += i4;
                    i -= i4;
                }
                if (this.Wwwwwwwwwwwwwwwwww > 0.0f && this.Wwwwwwwwwwwwwwwwwww < getChildCount() - 1) {
                    View childAt2 = getChildAt(this.Wwwwwwwwwwwwwwwwwww + 1);
                    int left2 = childAt2.getLeft() + i4;
                    int right = childAt2.getRight() - i4;
                    float f = this.Wwwwwwwwwwwwwwwwww;
                    float f2 = 1.0f - f;
                    left = (int) ((left * f2) + (left2 * f));
                    i = (int) ((f2 * i) + (right * f));
                }
                i3 = left;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3, i);
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(View view) {
        if (view instanceof Kkkkkkkkkkkkkkkkkkkkkkkkk) {
            Kkkkkkkkkkkkkkkkkkkkkkkkk kkkkkkkkkkkkkkkkkkkkkkkkk = (Kkkkkkkkkkkkkkkkkkkkkkkkk) view;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            CharSequence charSequence = kkkkkkkkkkkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwww;
            if (charSequence != null) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = charSequence;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
            Drawable drawable = kkkkkkkkkkkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwww;
            if (drawable != null) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = drawable;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
            int i = kkkkkkkkkkkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwww;
            if (i != 0) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = LayoutInflater.from(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.getContext()).inflate(i, (ViewGroup) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwww, false);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            return;
        }
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        if (i == -1) {
            return;
        }
        if (getWindowToken() != null && ViewCompat.isLaidOut(this)) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwww;
            int childCount = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getChildCount();
            boolean z = false;
            int i2 = 0;
            while (true) {
                if (i2 >= childCount) {
                    break;
                } else if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getChildAt(i2).getWidth() <= 0) {
                    z = true;
                    break;
                } else {
                    i2++;
                }
            }
            if (!z) {
                int scrollX = getScrollX();
                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, 0.0f);
                if (scrollX != Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) {
                    if (this.Kkkkkkkkkkkkkkkk == null) {
                        Kkkkkkkkkkkkkkkkkkkkk Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Kkkkkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        this.Kkkkkkkkkkkkkkkk = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Www.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        this.Kkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(300);
                        Kkkkkkkkkkkkkkkkkkkkk kkkkkkkkkkkkkkkkkkkkk = this.Kkkkkkkkkkkkkkkk;
                        kkkkkkkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Kkkkkkkkkkkkkkkkkkkkkkk(kkkkkkkkkkkkkkkkkkkkk, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()));
                    }
                    this.Kkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(scrollX, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                    this.Kkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                }
                this.Wwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, 300);
                return;
            }
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, 0.0f, true, true);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, float f, boolean z, boolean z2) {
        int round = Math.round(i + f);
        if (round < 0 || round >= this.Wwwwwwwwwwwwwwwwwwww.getChildCount()) {
            return;
        }
        if (z2) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwww;
            Kkkkkkkkkkkkkkkkkkkkk kkkkkkkkkkkkkkkkkkkkk = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwww;
            if (kkkkkkkkkkkkkkkkkkkkk != null && kkkkkkkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww = i;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww = f;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        Kkkkkkkkkkkkkkkkkkkkk kkkkkkkkkkkkkkkkkkkkk2 = this.Kkkkkkkkkkkkkkkk;
        if (kkkkkkkkkkkkkkkkkkkkk2 != null && kkkkkkkkkkkkkkkkkkkkk2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            this.Kkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        scrollTo(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, f), 0);
        if (!z) {
            return;
        }
        setSelectedTabView(round);
    }
}
