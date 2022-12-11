package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.C0298R;
import java.util.ArrayList;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public final class FragmentContainerView extends FrameLayout {
    public View.OnApplyWindowInsetsListener mApplyWindowInsetsListener;
    public ArrayList<View> mDisappearingFragmentChildren;
    public boolean mDrawDisappearingViewsFirst;
    public ArrayList<View> mTransitioningFragmentViews;

    public FragmentContainerView(@NonNull Context context) {
        super(context);
        this.mDrawDisappearingViewsFirst = true;
    }

    public FragmentContainerView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FragmentContainerView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        String str;
        this.mDrawDisappearingViewsFirst = true;
        if (attributeSet != null) {
            String classAttribute = attributeSet.getClassAttribute();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0298R.styleable.FragmentContainerView);
            if (classAttribute == null) {
                classAttribute = obtainStyledAttributes.getString(C0298R.styleable.FragmentContainerView_android_name);
                str = "android:name";
            } else {
                str = "class";
            }
            obtainStyledAttributes.recycle();
            if (classAttribute == null || isInEditMode()) {
                return;
            }
            throw new UnsupportedOperationException("FragmentContainerView must be within a FragmentActivity to use " + str + "=\"" + classAttribute + "\"");
        }
    }

    public FragmentContainerView(@NonNull Context context, @NonNull AttributeSet attributeSet, @NonNull FragmentManager fragmentManager) {
        super(context, attributeSet);
        this.mDrawDisappearingViewsFirst = true;
        String classAttribute = attributeSet.getClassAttribute();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0298R.styleable.FragmentContainerView);
        classAttribute = classAttribute == null ? obtainStyledAttributes.getString(C0298R.styleable.FragmentContainerView_android_name) : classAttribute;
        String string = obtainStyledAttributes.getString(C0298R.styleable.FragmentContainerView_android_tag);
        obtainStyledAttributes.recycle();
        int id = getId();
        Fragment findFragmentById = fragmentManager.findFragmentById(id);
        if (classAttribute != null && findFragmentById == null) {
            if (id <= 0) {
                throw new IllegalStateException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("FragmentContainerView must have an android:id to add Fragment ", classAttribute, string != null ? outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(" with tag ", string) : ""));
            }
            Fragment instantiate = fragmentManager.getFragmentFactory().instantiate(context.getClassLoader(), classAttribute);
            instantiate.onInflate(context, attributeSet, (Bundle) null);
            fragmentManager.beginTransaction().setReorderingAllowed(true).add(this, instantiate, string).commitNowAllowingStateLoss();
        }
        fragmentManager.onContainerAvailable(this);
    }

    private void addDisappearingFragmentView(@NonNull View view) {
        ArrayList<View> arrayList = this.mTransitioningFragmentViews;
        if (arrayList == null || !arrayList.contains(view)) {
            return;
        }
        if (this.mDisappearingFragmentChildren == null) {
            this.mDisappearingFragmentChildren = new ArrayList<>();
        }
        this.mDisappearingFragmentChildren.add(view);
    }

    @Override // android.view.ViewGroup
    public void addView(@NonNull View view, int i, @Nullable ViewGroup.LayoutParams layoutParams) {
        if (FragmentManager.getViewFragment(view) != null) {
            super.addView(view, i, layoutParams);
            return;
        }
        throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.");
    }

    @Override // android.view.ViewGroup
    public boolean addViewInLayout(@NonNull View view, int i, @Nullable ViewGroup.LayoutParams layoutParams, boolean z) {
        if (FragmentManager.getViewFragment(view) != null) {
            return super.addViewInLayout(view, i, layoutParams, z);
        }
        throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.");
    }

    @Override // android.view.ViewGroup, android.view.View
    @NonNull
    @RequiresApi(20)
    public WindowInsets dispatchApplyWindowInsets(@NonNull WindowInsets windowInsets) {
        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(windowInsets);
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.mApplyWindowInsetsListener;
        WindowInsetsCompat windowInsetsCompat2 = onApplyWindowInsetsListener != null ? WindowInsetsCompat.toWindowInsetsCompat(onApplyWindowInsetsListener.onApplyWindowInsets(this, windowInsets)) : ViewCompat.onApplyWindowInsets(this, windowInsetsCompat);
        if (!windowInsetsCompat2.isConsumed()) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                ViewCompat.dispatchApplyWindowInsets(getChildAt(i), windowInsetsCompat2);
            }
        }
        return windowInsets;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(@NonNull Canvas canvas) {
        if (this.mDrawDisappearingViewsFirst && this.mDisappearingFragmentChildren != null) {
            for (int i = 0; i < this.mDisappearingFragmentChildren.size(); i++) {
                super.drawChild(canvas, this.mDisappearingFragmentChildren.get(i), getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(@NonNull Canvas canvas, @NonNull View view, long j) {
        ArrayList<View> arrayList;
        if (!this.mDrawDisappearingViewsFirst || (arrayList = this.mDisappearingFragmentChildren) == null || arrayList.size() <= 0 || !this.mDisappearingFragmentChildren.contains(view)) {
            return super.drawChild(canvas, view, j);
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public void endViewTransition(@NonNull View view) {
        ArrayList<View> arrayList = this.mTransitioningFragmentViews;
        if (arrayList != null) {
            arrayList.remove(view);
            ArrayList<View> arrayList2 = this.mDisappearingFragmentChildren;
            if (arrayList2 != null && arrayList2.remove(view)) {
                this.mDrawDisappearingViewsFirst = true;
            }
        }
        super.endViewTransition(view);
    }

    @Override // android.view.View
    @NonNull
    @RequiresApi(20)
    public WindowInsets onApplyWindowInsets(@NonNull WindowInsets windowInsets) {
        return windowInsets;
    }

    @Override // android.view.ViewGroup
    public void removeAllViewsInLayout() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            addDisappearingFragmentView(getChildAt(childCount));
        }
        super.removeAllViewsInLayout();
    }

    @Override // android.view.ViewGroup
    public void removeDetachedView(@NonNull View view, boolean z) {
        if (z) {
            addDisappearingFragmentView(view);
        }
        super.removeDetachedView(view, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(@NonNull View view) {
        addDisappearingFragmentView(view);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i) {
        addDisappearingFragmentView(getChildAt(i));
        super.removeViewAt(i);
    }

    @Override // android.view.ViewGroup
    public void removeViewInLayout(@NonNull View view) {
        addDisappearingFragmentView(view);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public void removeViews(int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            addDisappearingFragmentView(getChildAt(i3));
        }
        super.removeViews(i, i2);
    }

    @Override // android.view.ViewGroup
    public void removeViewsInLayout(int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            addDisappearingFragmentView(getChildAt(i3));
        }
        super.removeViewsInLayout(i, i2);
    }

    public void setDrawDisappearingViewsLast(boolean z) {
        this.mDrawDisappearingViewsFirst = z;
    }

    @Override // android.view.ViewGroup
    public void setLayoutTransition(@Nullable LayoutTransition layoutTransition) {
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    @Override // android.view.View
    public void setOnApplyWindowInsetsListener(@NonNull View.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        this.mApplyWindowInsetsListener = onApplyWindowInsetsListener;
    }

    @Override // android.view.ViewGroup
    public void startViewTransition(@NonNull View view) {
        if (view.getParent() == this) {
            if (this.mTransitioningFragmentViews == null) {
                this.mTransitioningFragmentViews = new ArrayList<>();
            }
            this.mTransitioningFragmentViews.add(view);
        }
        super.startViewTransition(view);
    }
}
