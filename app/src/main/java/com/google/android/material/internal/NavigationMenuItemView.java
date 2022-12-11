package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.C0049R;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R$dimen;
import com.google.android.material.R$drawable;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class NavigationMenuItemView extends ForegroundLinearLayout implements MenuView.ItemView {
    public static final int[] Wwwwwwww = {16842912};
    public final AccessibilityDelegateCompat Wwwwwwwww;
    public Drawable Wwwwwwwwww;
    public boolean Wwwwwwwwwww;
    public ColorStateList Wwwwwwwwwwww;
    public MenuItemImpl Wwwwwwwwwwwww;
    public FrameLayout Wwwwwwwwwwwwww;
    public final CheckedTextView Wwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwww;

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AccessibilityDelegateCompat {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setCheckable(NavigationMenuItemView.this.Wwwwwwwwwwwwwwww);
        }
    }

    public NavigationMenuItemView(@NonNull Context context) {
        this(context, null);
    }

    public NavigationMenuItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuItemView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Wwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        setOrientation(0);
        LayoutInflater.from(context).inflate(R$layout.design_navigation_menu_item, (ViewGroup) this, true);
        setIconSize(context.getResources().getDimensionPixelSize(R$dimen.design_navigation_icon_size));
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(R$id.design_menu_item_text);
        this.Wwwwwwwwwwwwwww = checkedTextView;
        checkedTextView.setDuplicateParentStateEnabled(true);
        ViewCompat.setAccessibilityDelegate(this.Wwwwwwwwwwwwwww, this.Wwwwwwwww);
    }

    private void setActionView(@Nullable View view) {
        if (view != null) {
            if (this.Wwwwwwwwwwwwww == null) {
                this.Wwwwwwwwwwwwww = (FrameLayout) ((ViewStub) findViewById(R$id.design_menu_item_action_area_stub)).inflate();
            }
            this.Wwwwwwwwwwwwww.removeAllViews();
            this.Wwwwwwwwwwwwww.addView(view);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public MenuItemImpl getItemData() {
        return this.Wwwwwwwwwwwww;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void initialize(@NonNull MenuItemImpl menuItemImpl, int i) {
        LinearLayoutCompat.LayoutParams layoutParams;
        int i2;
        StateListDrawable stateListDrawable;
        this.Wwwwwwwwwwwww = menuItemImpl;
        if (menuItemImpl.getItemId() > 0) {
            setId(menuItemImpl.getItemId());
        }
        setVisibility(menuItemImpl.isVisible() ? 0 : 8);
        boolean z = true;
        if (getBackground() == null) {
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(C0049R.attr.colorControlHighlight, typedValue, true)) {
                stateListDrawable = new StateListDrawable();
                stateListDrawable.addState(Wwwwwwww, new ColorDrawable(typedValue.data));
                stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
            } else {
                stateListDrawable = null;
            }
            ViewCompat.setBackground(this, stateListDrawable);
        }
        setCheckable(menuItemImpl.isCheckable());
        setChecked(menuItemImpl.isChecked());
        setEnabled(menuItemImpl.isEnabled());
        setTitle(menuItemImpl.getTitle());
        setIcon(menuItemImpl.getIcon());
        setActionView(menuItemImpl.getActionView());
        setContentDescription(menuItemImpl.getContentDescription());
        TooltipCompat.setTooltipText(this, menuItemImpl.getTooltipText());
        if (this.Wwwwwwwwwwwww.getTitle() != null || this.Wwwwwwwwwwwww.getIcon() != null || this.Wwwwwwwwwwwww.getActionView() == null) {
            z = false;
        }
        if (z) {
            this.Wwwwwwwwwwwwwww.setVisibility(8);
            FrameLayout frameLayout = this.Wwwwwwwwwwwwww;
            if (frameLayout == null) {
                return;
            }
            layoutParams = (LinearLayoutCompat.LayoutParams) frameLayout.getLayoutParams();
            i2 = -1;
        } else {
            this.Wwwwwwwwwwwwwww.setVisibility(0);
            FrameLayout frameLayout2 = this.Wwwwwwwwwwwwww;
            if (frameLayout2 == null) {
                return;
            }
            layoutParams = (LinearLayoutCompat.LayoutParams) frameLayout2.getLayoutParams();
            i2 = -2;
        }
        ((LinearLayout.LayoutParams) layoutParams).width = i2;
        this.Wwwwwwwwwwwwww.setLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        MenuItemImpl menuItemImpl = this.Wwwwwwwwwwwww;
        if (menuItemImpl != null && menuItemImpl.isCheckable() && this.Wwwwwwwwwwwww.isChecked()) {
            ViewGroup.mergeDrawableStates(onCreateDrawableState, Wwwwwwww);
        }
        return onCreateDrawableState;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean prefersCondensedTitle() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setCheckable(boolean z) {
        refreshDrawableState();
        if (this.Wwwwwwwwwwwwwwww != z) {
            this.Wwwwwwwwwwwwwwww = z;
            this.Wwwwwwwww.sendAccessibilityEvent(this.Wwwwwwwwwwwwwww, 2048);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setChecked(boolean z) {
        refreshDrawableState();
        this.Wwwwwwwwwwwwwww.setChecked(z);
    }

    public void setHorizontalPadding(int i) {
        setPadding(i, 0, i, 0);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setIcon(@Nullable Drawable drawable) {
        if (drawable != null) {
            if (this.Wwwwwwwwwww) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = DrawableCompat.wrap(drawable).mutate();
                DrawableCompat.setTintList(drawable, this.Wwwwwwwwwwww);
            }
            int i = this.Wwwwwwwwwwwwwwwwww;
            drawable.setBounds(0, 0, i, i);
        } else if (this.Wwwwwwwwwwwwwwwww) {
            if (this.Wwwwwwwwww == null) {
                Drawable drawable2 = ResourcesCompat.getDrawable(getResources(), R$drawable.navigation_empty_icon, getContext().getTheme());
                this.Wwwwwwwwww = drawable2;
                if (drawable2 != null) {
                    int i2 = this.Wwwwwwwwwwwwwwwwww;
                    drawable2.setBounds(0, 0, i2, i2);
                }
            }
            drawable = this.Wwwwwwwwww;
        }
        TextViewCompat.setCompoundDrawablesRelative(this.Wwwwwwwwwwwwwww, drawable, null, null, null);
    }

    public void setIconPadding(int i) {
        this.Wwwwwwwwwwwwwww.setCompoundDrawablePadding(i);
    }

    public void setIconSize(@Dimension int i) {
        this.Wwwwwwwwwwwwwwwwww = i;
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.Wwwwwwwwwwww = colorStateList;
        this.Wwwwwwwwwww = colorStateList != null;
        MenuItemImpl menuItemImpl = this.Wwwwwwwwwwwww;
        if (menuItemImpl != null) {
            setIcon(menuItemImpl.getIcon());
        }
    }

    public void setMaxLines(int i) {
        this.Wwwwwwwwwwwwwww.setMaxLines(i);
    }

    public void setNeedsEmptyIcon(boolean z) {
        this.Wwwwwwwwwwwwwwwww = z;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setShortcut(boolean z, char c) {
    }

    public void setTextAppearance(int i) {
        TextViewCompat.setTextAppearance(this.Wwwwwwwwwwwwwww, i);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.Wwwwwwwwwwwwwww.setTextColor(colorStateList);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setTitle(CharSequence charSequence) {
        this.Wwwwwwwwwwwwwww.setText(charSequence);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean showsIcon() {
        return true;
    }
}
