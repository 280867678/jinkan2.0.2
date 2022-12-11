package me.tvspark;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.appbar.AppBarLayout;

/* renamed from: me.tvspark.ym */
/* loaded from: classes4.dex */
public abstract class AbstractC2829ym extends C2866zm<View> {
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Rect Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Rect();
    public final Rect Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Rect();
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;

    public AbstractC2829ym() {
    }

    public AbstractC2829ym(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(View view) {
        int i;
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww == 0) {
            return 0;
        }
        float f = 0.0f;
        if (view instanceof AppBarLayout) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            int totalScrollRange = appBarLayout.getTotalScrollRange();
            int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams()).getBehavior();
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = behavior instanceof AppBarLayout.BaseBehavior ? ((AppBarLayout.BaseBehavior) behavior).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() : 0;
            if ((downNestedPreScrollRange == 0 || totalScrollRange + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww > downNestedPreScrollRange) && (i = totalScrollRange - downNestedPreScrollRange) != 0) {
                f = 1.0f + (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww / i);
            }
        }
        int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        return MathUtils.clamp((int) (f * i2), 0, i2);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onMeasureChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i, int i2, int i3, int i4) {
        WindowInsetsCompat lastWindowInsets;
        int i5 = view.getLayoutParams().height;
        if (i5 == -1 || i5 == -2) {
            AppBarLayout Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ((AppBarLayout.ScrollingViewBehavior) this).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(coordinatorLayout.getDependencies(view));
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                return false;
            }
            int size = View.MeasureSpec.getSize(i3);
            if (size <= 0) {
                size = coordinatorLayout.getHeight();
            } else if (ViewCompat.getFitsSystemWindows(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && (lastWindowInsets = coordinatorLayout.getLastWindowInsets()) != null) {
                size += lastWindowInsets.getSystemWindowInsetBottom() + lastWindowInsets.getSystemWindowInsetTop();
            }
            coordinatorLayout.onMeasureChild(view, i, i2, View.MeasureSpec.makeMeasureSpec((size + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getTotalScrollRange()) - Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getMeasuredHeight(), i5 == -1 ? 1073741824 : Integer.MIN_VALUE), i4);
            return true;
        }
        return false;
    }

    @Override // me.tvspark.C2866zm
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i) {
        int i2;
        AppBarLayout Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ((AppBarLayout.ScrollingViewBehavior) this).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(coordinatorLayout.getDependencies(view));
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) view.getLayoutParams();
            Rect rect = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            rect.set(coordinatorLayout.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getBottom() + coordinatorLayout.getHeight()) - coordinatorLayout.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
            WindowInsetsCompat lastWindowInsets = coordinatorLayout.getLastWindowInsets();
            if (lastWindowInsets != null && ViewCompat.getFitsSystemWindows(coordinatorLayout) && !ViewCompat.getFitsSystemWindows(view)) {
                rect.left = lastWindowInsets.getSystemWindowInsetLeft() + rect.left;
                rect.right -= lastWindowInsets.getSystemWindowInsetRight();
            }
            Rect rect2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i3 = layoutParams.gravity;
            GravityCompat.apply(i3 == 0 ? 8388659 : i3, view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i);
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            view.layout(rect2.left, rect2.top - Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, rect2.right, rect2.bottom - Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            i2 = rect2.top - Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getBottom();
        } else {
            coordinatorLayout.onLayoutChild(view, i);
            i2 = 0;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
    }
}
