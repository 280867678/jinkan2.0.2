package com.google.android.material.bottomnavigation;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuView;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import me.tvspark.C1989cn;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class BottomNavigationMenuView extends ViewGroup implements MenuView {
    public MenuBuilder Wwwwwwwwww;
    public BottomNavigationPresenter Wwwwwwwwwww;
    @NonNull
    public SparseArray<C1989cn> Wwwwwwwwwwww;
    public int Wwwwwwwwwwwww;
    public Drawable Wwwwwwwwwwwwww;
    @StyleRes
    public int Wwwwwwwwwwwwwww;
    @StyleRes
    public int Wwwwwwwwwwwwwwww;
    public ColorStateList Wwwwwwwwwwwwwwwww;
    @Dimension
    public int Wwwwwwwwwwwwwwwwww;
    public ColorStateList Wwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public BottomNavigationItemView[] Wwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwww;

    private BottomNavigationItemView getNewItem() {
        throw null;
    }

    private void setBadgeIfNeeded(@NonNull BottomNavigationItemView bottomNavigationItemView) {
        C1989cn c1989cn;
        int id = bottomNavigationItemView.getId();
        if ((id != -1) && (c1989cn = this.Wwwwwwwwwwww.get(id)) != null) {
            bottomNavigationItemView.setBadge(c1989cn);
        }
    }

    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
        if (i == -1) {
            if (i2 > 3) {
                return true;
            }
        } else if (i == 0) {
            return true;
        }
        return false;
    }

    public SparseArray<C1989cn> getBadgeDrawables() {
        return this.Wwwwwwwwwwww;
    }

    @Nullable
    public ColorStateList getIconTintList() {
        return this.Wwwwwwwwwwwwwwwwwww;
    }

    @Nullable
    public Drawable getItemBackground() {
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.Wwwwwwwwwwwwwwwwwwwwww;
        return (bottomNavigationItemViewArr == null || bottomNavigationItemViewArr.length <= 0) ? this.Wwwwwwwwwwwwww : bottomNavigationItemViewArr[0].getBackground();
    }

    @Deprecated
    public int getItemBackgroundRes() {
        return this.Wwwwwwwwwwwww;
    }

    @Dimension
    public int getItemIconSize() {
        return this.Wwwwwwwwwwwwwwwwww;
    }

    @StyleRes
    public int getItemTextAppearanceActive() {
        return this.Wwwwwwwwwwwwwww;
    }

    @StyleRes
    public int getItemTextAppearanceInactive() {
        return this.Wwwwwwwwwwwwwwww;
    }

    public ColorStateList getItemTextColor() {
        return this.Wwwwwwwwwwwwwwwww;
    }

    public int getLabelVisibilityMode() {
        return this.Wwwwwwwwwwwwwwwwwwwwwww;
    }

    public int getSelectedItemId() {
        return this.Wwwwwwwwwwwwwwwwwwwww;
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public int getWindowAnimations() {
        return 0;
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public void initialize(MenuBuilder menuBuilder) {
        this.Wwwwwwwwww = menuBuilder;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, this.Wwwwwwwwww.getVisibleItems().size(), false, 1));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                if (ViewCompat.getLayoutDirection(this) == 1) {
                    int i9 = i5 - i7;
                    childAt.layout(i9 - childAt.getMeasuredWidth(), 0, i9, i6);
                } else {
                    childAt.layout(i7, 0, childAt.getMeasuredWidth() + i7, i6);
                }
                i7 += childAt.getMeasuredWidth();
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int size = View.MeasureSpec.getSize(i);
        int size2 = this.Wwwwwwwwww.getVisibleItems().size();
        int childCount = getChildCount();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
        int i4 = 1;
        if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww, size2) || !this.Wwwwwwwwwwwwwwwwwwwwwwww) {
            if (size2 == 0) {
                size2 = 1;
            }
            Math.min(size / size2, 0);
            if (childCount > 0) {
                getChildAt(0).getVisibility();
                throw null;
            }
        } else {
            View childAt = getChildAt(this.Wwwwwwwwwwwwwwwwwwww);
            if (childAt.getVisibility() != 8) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(0, Integer.MIN_VALUE), makeMeasureSpec);
                i3 = Math.max(0, childAt.getMeasuredWidth());
            } else {
                i3 = 0;
            }
            int i5 = size2 - (childAt.getVisibility() != 8 ? 1 : 0);
            int min = size - Math.min(size - (i5 * 0), Math.min(i3, 0));
            if (i5 != 0) {
                i4 = i5;
            }
            Math.min(min / i4, 0);
            if (childCount > 0) {
                if (getChildAt(0).getVisibility() == 8) {
                    throw null;
                }
                int i6 = this.Wwwwwwwwwwwwwwwwwwww;
                throw null;
            }
        }
        for (int i7 = 0; i7 < childCount; i7++) {
            if (getChildAt(i7).getVisibility() != 8) {
                throw null;
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(0, View.MeasureSpec.makeMeasureSpec(0, 1073741824), 0), View.resolveSizeAndState(0, makeMeasureSpec, 0));
    }

    public void setBadgeDrawables(SparseArray<C1989cn> sparseArray) {
        this.Wwwwwwwwwwww = sparseArray;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.Wwwwwwwwwwwwwwwwwwwwww;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setBadge(sparseArray.get(bottomNavigationItemView.getId()));
            }
        }
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.Wwwwwwwwwwwwwwwwwww = colorStateList;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.Wwwwwwwwwwwwwwwwwwwwww;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setIconTintList(colorStateList);
            }
        }
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        this.Wwwwwwwwwwwwww = drawable;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.Wwwwwwwwwwwwwwwwwwwwww;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setItemBackground(drawable);
            }
        }
    }

    public void setItemBackgroundRes(int i) {
        this.Wwwwwwwwwwwww = i;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.Wwwwwwwwwwwwwwwwwwwwww;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setItemBackground(i);
            }
        }
    }

    public void setItemHorizontalTranslationEnabled(boolean z) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = z;
    }

    public void setItemIconSize(@Dimension int i) {
        this.Wwwwwwwwwwwwwwwwww = i;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.Wwwwwwwwwwwwwwwwwwwwww;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setIconSize(i);
            }
        }
    }

    public void setItemTextAppearanceActive(@StyleRes int i) {
        this.Wwwwwwwwwwwwwww = i;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.Wwwwwwwwwwwwwwwwwwwwww;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setTextAppearanceActive(i);
                ColorStateList colorStateList = this.Wwwwwwwwwwwwwwwww;
                if (colorStateList != null) {
                    bottomNavigationItemView.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextAppearanceInactive(@StyleRes int i) {
        this.Wwwwwwwwwwwwwwww = i;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.Wwwwwwwwwwwwwwwwwwwwww;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setTextAppearanceInactive(i);
                ColorStateList colorStateList = this.Wwwwwwwwwwwwwwwww;
                if (colorStateList != null) {
                    bottomNavigationItemView.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.Wwwwwwwwwwwwwwwww = colorStateList;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.Wwwwwwwwwwwwwwwwwwwwww;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setTextColor(colorStateList);
            }
        }
    }

    public void setLabelVisibilityMode(int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwww = i;
    }

    public void setPresenter(BottomNavigationPresenter bottomNavigationPresenter) {
        this.Wwwwwwwwwww = bottomNavigationPresenter;
    }
}
