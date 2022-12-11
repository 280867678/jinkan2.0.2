package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R$attr;
import com.google.android.material.R$layout;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import me.tvspark.AbstractC2121fr;

/* loaded from: classes3.dex */
public class Snackbar extends BaseTransientBottomBar<Snackbar> {
    public static final int[] Wwwwwwwwwwwwwww = {R$attr.snackbarButtonStyle, R$attr.snackbarTextViewStyle};
    public boolean Wwwwwwwwwwwwwwww;
    @Nullable
    public final AccessibilityManager Wwwwwwwwwwwwwwwww;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes3.dex */
    public static final class SnackbarLayout extends BaseTransientBottomBar.Wwwwwwwwwwwwwwwwwwwwwwwwww {
        public SnackbarLayout(Context context) {
            super(context);
        }

        public SnackbarLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // android.widget.FrameLayout, android.view.View
        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            int childCount = getChildCount();
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getLayoutParams().width == -1) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(childAt.getMeasuredHeight(), 1073741824));
                }
            }
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.Wwwwwwwwwwwwwwwwwwwwwwwwww, android.view.View
        public /* bridge */ /* synthetic */ void setBackground(@Nullable Drawable drawable) {
            super.setBackground(drawable);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.Wwwwwwwwwwwwwwwwwwwwwwwwww, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundDrawable(@Nullable Drawable drawable) {
            super.setBackgroundDrawable(drawable);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.Wwwwwwwwwwwwwwwwwwwwwwwwww, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
            super.setBackgroundTintList(colorStateList);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.Wwwwwwwwwwwwwwwwwwwwwwwwww, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
            super.setBackgroundTintMode(mode);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.Wwwwwwwwwwwwwwwwwwwwwwwwww, android.view.View
        public /* bridge */ /* synthetic */ void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
            super.setOnClickListener(onClickListener);
        }
    }

    public Snackbar(@NonNull Context context, @NonNull ViewGroup viewGroup, @NonNull View view, @NonNull AbstractC2121fr abstractC2121fr) {
        super(context, viewGroup, view, abstractC2121fr);
        this.Wwwwwwwwwwwwwwwww = (AccessibilityManager) viewGroup.getContext().getSystemService("accessibility");
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i == -2) {
            return -2;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return this.Wwwwwwwwwwwwwwwww.getRecommendedTimeoutMillis(i, (this.Wwwwwwwwwwwwwwww ? 4 : 0) | 1 | 2);
        } else if (this.Wwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwww.isTouchExplorationEnabled()) {
            return -2;
        } else {
            return i;
        }
    }

    @NonNull
    public static Snackbar Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull View view, @NonNull CharSequence charSequence, int i) {
        ViewGroup viewGroup;
        ViewGroup viewGroup2 = null;
        while (!(view instanceof CoordinatorLayout)) {
            if (view instanceof FrameLayout) {
                if (view.getId() == 16908290) {
                    break;
                }
                viewGroup2 = (ViewGroup) view;
            }
            if (view != null) {
                ViewParent parent = view.getParent();
                if (parent instanceof View) {
                    view = (View) parent;
                    continue;
                } else {
                    view = null;
                    continue;
                }
            }
            if (view == null) {
                viewGroup = viewGroup2;
                break;
            }
        }
        viewGroup = (ViewGroup) view;
        if (viewGroup != null) {
            Context context = viewGroup.getContext();
            LayoutInflater from = LayoutInflater.from(context);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Wwwwwwwwwwwwwww);
            int resourceId = obtainStyledAttributes.getResourceId(0, -1);
            boolean z = true;
            int resourceId2 = obtainStyledAttributes.getResourceId(1, -1);
            obtainStyledAttributes.recycle();
            if (resourceId == -1 || resourceId2 == -1) {
                z = false;
            }
            SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) from.inflate(z ? R$layout.mtrl_layout_snackbar_include : R$layout.design_layout_snackbar_include, viewGroup, false);
            Snackbar snackbar = new Snackbar(context, viewGroup, snackbarContentLayout, snackbarContentLayout);
            ((SnackbarContentLayout) snackbar.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getChildAt(0)).getMessageView().setText(charSequence);
            snackbar.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            return snackbar;
        }
        throw new IllegalArgumentException("No suitable parent found from the given view. Please provide a valid view.");
    }
}
