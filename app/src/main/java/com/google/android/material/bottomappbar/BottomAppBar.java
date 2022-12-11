package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AbstractC0047Px;
import androidx.annotation.Dimension;
import androidx.annotation.MenuRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.motion.widget.Key;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R$dimen;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import me.tvspark.AbstractC2566rm;
import me.tvspark.C2117fn;
import me.tvspark.C2154gn;
import me.tvspark.C2191hn;
import me.tvspark.C2228in;
import me.tvspark.C2302kn;
import me.tvspark.C2339ln;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public class BottomAppBar extends Toolbar implements CoordinatorLayout.AttachedBehavior {
    @NonNull
    public AnimatorListenerAdapter Wwwwwwwwwwwww;
    public Behavior Wwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwww;
    @MenuRes
    public int Wwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public Animator Wwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public Animator Wwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes3.dex */
    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public WeakReference<BottomAppBar> Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final View.OnLayoutChangeListener Wwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        @NonNull
        public final Rect Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Rect();

        /* loaded from: classes3.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnLayoutChangeListener {
            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                BottomAppBar bottomAppBar = Behavior.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.get();
                if (bottomAppBar == null || !(view instanceof FloatingActionButton)) {
                    view.removeOnLayoutChangeListener(this);
                    return;
                }
                FloatingActionButton floatingActionButton = (FloatingActionButton) view;
                Rect rect = Behavior.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                rect.set(0, 0, floatingActionButton.getMeasuredWidth(), floatingActionButton.getMeasuredHeight());
                floatingActionButton.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(rect);
                int height = Behavior.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.height();
                bottomAppBar.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(height);
                CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) view.getLayoutParams();
                if (Behavior.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww != 0) {
                    return;
                }
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = bottomAppBar.getBottomInset() + (bottomAppBar.getResources().getDimensionPixelOffset(R$dimen.mtrl_bottomappbar_fab_bottom_margin) - ((floatingActionButton.getMeasuredHeight() - height) / 2));
                ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = bottomAppBar.getLeftInset();
                ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = bottomAppBar.getRightInset();
                if (Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((View) floatingActionButton)) {
                    ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin += bottomAppBar.Wwwwwwwwwwwwwwwwwwwwwwww;
                } else {
                    ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin += bottomAppBar.Wwwwwwwwwwwwwwwwwwwwwwww;
                }
            }
        }

        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i) {
            BottomAppBar bottomAppBar = (BottomAppBar) view;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = new WeakReference<>(bottomAppBar);
            View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = bottomAppBar.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null && !ViewCompat.isLaidOut(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getLayoutParams();
                layoutParams.anchorGravity = 49;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww instanceof FloatingActionButton) {
                    FloatingActionButton floatingActionButton = (FloatingActionButton) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    floatingActionButton.addOnLayoutChangeListener(this.Wwwwwwwwwwwwwwwwwwwwwwwwwww);
                    if (bottomAppBar == null) {
                        throw null;
                    }
                    floatingActionButton.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Animator.AnimatorListener) null);
                    floatingActionButton.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new C2302kn(bottomAppBar));
                    floatingActionButton.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2566rm<? extends FloatingActionButton>) null);
                }
                bottomAppBar.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                throw null;
            }
            coordinatorLayout.onLayoutChild(bottomAppBar, i);
            return super.onLayoutChild(coordinatorLayout, bottomAppBar, i);
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2, @NonNull View view3, int i, int i2) {
            if (((BottomAppBar) view).getHideOnScroll()) {
                return i == 2;
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbsSavedState {
        public static final Parcelable.Creator<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> CREATOR = new C3450Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        public boolean Wwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwww;

        /* renamed from: com.google.android.material.bottomappbar.BottomAppBar$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static class C3450Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Parcelable.ClassLoaderCreator<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> {
            @Override // android.os.Parcelable.Creator
            @Nullable
            public Object createFromParcel(@NonNull Parcel parcel) {
                return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            public Object[] newArray(int i) {
                return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i];
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            @NonNull
            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(parcel, classLoader);
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.Wwwwwwwwwwwwwwwwwwwwwwww = parcel.readInt();
            this.Wwwwwwwwwwwwwwwwwwwwwww = parcel.readInt() != 0;
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.Wwwwwwwwwwwwwwwwwwwwwwww);
            parcel.writeInt(this.Wwwwwwwwwwwwwwwwwwwwwww ? 1 : 0);
        }
    }

    public static /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(BottomAppBar bottomAppBar) {
        bottomAppBar.Wwwwwwwwwwwwwwwwww--;
    }

    @Nullable
    private ActionMenuView getActionMenuView() {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getBottomInset() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getFabTranslationX() {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwww);
    }

    private float getFabTranslationY() {
        return -getTopEdgeTreatment().Wwwwwwwwwwwwwwwwwwwww;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getLeftInset() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRightInset() {
        return 0;
    }

    @NonNull
    private C2339ln getTopEdgeTreatment() {
        throw null;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        getTopEdgeTreatment().Wwwwwwwwwwwwwwwwwwww = getFabTranslationX();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (this.Wwwwwwwwwwwwwww) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        throw null;
    }

    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        FloatingActionButton Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (!(getParent() instanceof CoordinatorLayout)) {
            return null;
        }
        for (View view : ((CoordinatorLayout) getParent()).getDependents(this)) {
            if ((view instanceof FloatingActionButton) || (view instanceof ExtendedFloatingActionButton)) {
                return view;
            }
            while (r0.hasNext()) {
            }
        }
        return null;
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@AbstractC0047Px int i) {
        float f = i;
        if (f == getTopEdgeTreatment().Wwwwwwwwwwwwwwwwwwwwww) {
            return false;
        }
        getTopEdgeTreatment().Wwwwwwwwwwwwwwwwwwwwww = f;
        throw null;
    }

    public final float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((View) this);
        int i2 = 1;
        if (i == 1) {
            int measuredWidth = (getMeasuredWidth() / 2) + 0;
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                i2 = -1;
            }
            return measuredWidth * i2;
        }
        return 0.0f;
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull ActionMenuView actionMenuView, int i, boolean z) {
        if (i != 1 || !z) {
            return 0;
        }
        boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((View) this);
        int measuredWidth = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww ? getMeasuredWidth() : 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if ((childAt.getLayoutParams() instanceof Toolbar.LayoutParams) && (((Toolbar.LayoutParams) childAt.getLayoutParams()).gravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK) == 8388611) {
                measuredWidth = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww ? Math.min(measuredWidth, childAt.getLeft()) : Math.max(measuredWidth, childAt.getRight());
            }
        }
        return measuredWidth - ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww ? actionMenuView.getRight() : actionMenuView.getLeft()) + 0);
    }

    @Nullable
    public final FloatingActionButton Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww instanceof FloatingActionButton) {
            return (FloatingActionButton) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        return null;
    }

    @Nullable
    public ColorStateList getBackgroundTint() {
        throw null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    /* renamed from: getBehavior  reason: collision with other method in class */
    public Behavior mo4457getBehavior() {
        if (this.Wwwwwwwwwwwwww == null) {
            this.Wwwwwwwwwwwwww = new Behavior();
        }
        return this.Wwwwwwwwwwwwww;
    }

    @Dimension
    public float getCradleVerticalOffset() {
        return getTopEdgeTreatment().Wwwwwwwwwwwwwwwwwwwww;
    }

    public int getFabAlignmentMode() {
        return this.Wwwwwwwwwwwwwwwwwwwww;
    }

    public int getFabAnimationMode() {
        return this.Wwwwwwwwwwwwwwwwwwww;
    }

    public float getFabCradleMargin() {
        return getTopEdgeTreatment().Wwwwwwwwwwwwwwwwwwwwwww;
    }

    @Dimension
    public float getFabCradleRoundedCornerRadius() {
        return getTopEdgeTreatment().Wwwwwwwwwwwwwwwwwwwwwwww;
    }

    public boolean getHideOnScroll() {
        return this.Wwwwwwwwwwwwwwwwwww;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        throw null;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            Animator animator = this.Wwwwwwwwwwwwwwwwwwwwww;
            if (animator != null) {
                animator.cancel();
            }
            Animator animator2 = this.Wwwwwwwwwwwwwwwwwwwwwww;
            if (animator2 != null) {
                animator2.cancel();
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        }
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView == null || this.Wwwwwwwwwwwwwwwwwwwwww != null) {
            return;
        }
        actionMenuView.setAlpha(1.0f);
        if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(actionMenuView, 0, false);
        } else {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(actionMenuView, this.Wwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwww);
        }
        actionMenuView.setTranslationX(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) parcelable;
        super.onRestoreInstanceState(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getSuperState());
        this.Wwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    @NonNull
    public Parcelable onSaveInstanceState() {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(super.onSaveInstanceState());
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwww;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwww;
        return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public void setBackgroundTint(@Nullable ColorStateList colorStateList) {
        DrawableCompat.setTintList(null, colorStateList);
    }

    public void setCradleVerticalOffset(@Dimension float f) {
        if (f != getCradleVerticalOffset()) {
            C2339ln topEdgeTreatment = getTopEdgeTreatment();
            if (topEdgeTreatment == null) {
                throw null;
            }
            if (f >= 0.0f) {
                topEdgeTreatment.Wwwwwwwwwwwwwwwwwwwww = f;
                throw null;
            }
            throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
        }
    }

    @Override // android.view.View
    public void setElevation(float f) {
        throw null;
    }

    public void setFabAlignmentMode(int i) {
        int i2;
        this.Wwwwwwwwwwwwwwwww = 0;
        boolean z = this.Wwwwwwwwwwwwwww;
        if (!ViewCompat.isLaidOut(this)) {
            int i3 = this.Wwwwwwwwwwwwwwwww;
            if (i3 != 0) {
                this.Wwwwwwwwwwwwwwwww = 0;
                getMenu().clear();
                inflateMenu(i3);
            }
        } else {
            Animator animator = this.Wwwwwwwwwwwwwwwwwwwwww;
            if (animator != null) {
                animator.cancel();
            }
            ArrayList arrayList = new ArrayList();
            if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                z = false;
                i2 = 0;
            } else {
                i2 = i;
            }
            ActionMenuView actionMenuView = getActionMenuView();
            if (actionMenuView != null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(actionMenuView, Key.ALPHA, 1.0f);
                if (Math.abs(actionMenuView.getTranslationX() - Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(actionMenuView, i2, z)) > 1.0f) {
                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(actionMenuView, Key.ALPHA, 0.0f);
                    ofFloat2.addListener(new C2228in(this, actionMenuView, i2, z));
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.setDuration(150L);
                    animatorSet.playSequentially(ofFloat2, ofFloat);
                    arrayList.add(animatorSet);
                } else if (actionMenuView.getAlpha() < 1.0f) {
                    arrayList.add(ofFloat);
                }
            }
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.playTogether(arrayList);
            this.Wwwwwwwwwwwwwwwwwwwwww = animatorSet2;
            animatorSet2.addListener(new C2191hn(this));
            this.Wwwwwwwwwwwwwwwwwwwwww.start();
        }
        if (this.Wwwwwwwwwwwwwwwwwwwww != i && ViewCompat.isLaidOut(this)) {
            Animator animator2 = this.Wwwwwwwwwwwwwwwwwwwwwww;
            if (animator2 != null) {
                animator2.cancel();
            }
            ArrayList arrayList2 = new ArrayList();
            if (this.Wwwwwwwwwwwwwwwwwwww == 1) {
                ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), Key.TRANSLATION_X, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i));
                ofFloat3.setDuration(300L);
                arrayList2.add(ofFloat3);
            } else {
                FloatingActionButton Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null && !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                    this.Wwwwwwwwwwwwwwwwww++;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((FloatingActionButton.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) new C2154gn(this, i), true);
                }
            }
            AnimatorSet animatorSet3 = new AnimatorSet();
            animatorSet3.playTogether(arrayList2);
            this.Wwwwwwwwwwwwwwwwwwwwwww = animatorSet3;
            animatorSet3.addListener(new C2117fn(this));
            this.Wwwwwwwwwwwwwwwwwwwwwww.start();
        }
        this.Wwwwwwwwwwwwwwwwwwwww = i;
    }

    public void setFabAnimationMode(int i) {
        this.Wwwwwwwwwwwwwwwwwwww = i;
    }

    public void setFabCradleMargin(@Dimension float f) {
        if (f == getFabCradleMargin()) {
            return;
        }
        getTopEdgeTreatment().Wwwwwwwwwwwwwwwwwwwwwww = f;
        throw null;
    }

    public void setFabCradleRoundedCornerRadius(@Dimension float f) {
        if (f == getFabCradleRoundedCornerRadius()) {
            return;
        }
        getTopEdgeTreatment().Wwwwwwwwwwwwwwwwwwwwwwww = f;
        throw null;
    }

    public void setHideOnScroll(boolean z) {
        this.Wwwwwwwwwwwwwwwwwww = z;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
    }
}
