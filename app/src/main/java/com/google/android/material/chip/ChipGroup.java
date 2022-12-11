package com.google.android.material.chip;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import androidx.annotation.BoolRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import java.util.ArrayList;
import java.util.List;
import me.tvspark.C1957bs;
import me.tvspark.C2230ip;
import me.tvspark.C2415np;

/* loaded from: classes3.dex */
public class ChipGroup extends C2230ip {
    public static final int Wwwwwwwwwww = R$style.Widget_MaterialComponents_ChipGroup;
    public boolean Wwwwwwwwwwww;
    @IdRes
    public int Wwwwwwwwwwwww;
    @NonNull
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwww;
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwww;
    @Nullable
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwww;
    @Dimension
    public int Wwwwwwwwwwwwwwwwwww;
    @Dimension
    public int Wwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements ViewGroup.OnHierarchyChangeListener {
        public ViewGroup.OnHierarchyChangeListener Wwwwwwwwwwwwwwwwwwwwwwww;

        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            if (view == ChipGroup.this && (view2 instanceof Chip)) {
                if (view2.getId() == -1) {
                    view2.setId(ViewCompat.generateViewId());
                }
                Chip chip = (Chip) view2;
                if (chip.isChecked()) {
                    ((ChipGroup) view).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(chip.getId());
                }
                chip.setOnCheckedChangeListenerInternal(ChipGroup.this.Wwwwwwwwwwwwwww);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            if (view == ChipGroup.this && (view2 instanceof Chip)) {
                ((Chip) view2).setOnCheckedChangeListenerInternal(null);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ChipGroup chipGroup, @IdRes int i);
    }

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends ViewGroup.MarginLayoutParams {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
            super(i, i2);
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements CompoundButton.OnCheckedChangeListener {
        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(@NonNull CompoundButton compoundButton, boolean z) {
            ChipGroup chipGroup = ChipGroup.this;
            if (chipGroup.Wwwwwwwwwwww) {
                return;
            }
            if (chipGroup.getCheckedChipIds().isEmpty()) {
                ChipGroup chipGroup2 = ChipGroup.this;
                if (chipGroup2.Wwwwwwwwwwwwwwwww) {
                    chipGroup2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(compoundButton.getId(), true);
                    ChipGroup chipGroup3 = ChipGroup.this;
                    chipGroup3.Wwwwwwwwwwwww = compoundButton.getId();
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = chipGroup3.Wwwwwwwwwwwwwwww;
                    return;
                }
            }
            int id = compoundButton.getId();
            if (z) {
                ChipGroup chipGroup4 = ChipGroup.this;
                int i = chipGroup4.Wwwwwwwwwwwww;
                if (i != -1 && i != id && chipGroup4.Wwwwwwwwwwwwwwwwww) {
                    chipGroup4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, false);
                }
                ChipGroup.this.setCheckedId(id);
                return;
            }
            ChipGroup chipGroup5 = ChipGroup.this;
            if (chipGroup5.Wwwwwwwwwwwww != id) {
                return;
            }
            chipGroup5.setCheckedId(-1);
        }
    }

    public ChipGroup(Context context) {
        this(context, null);
    }

    public ChipGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.chipGroupStyle);
    }

    public ChipGroup(Context context, AttributeSet attributeSet, int i) {
        super(C1957bs.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, attributeSet, i, Wwwwwwwwwww), attributeSet, i);
        this.Wwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null);
        this.Wwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null);
        this.Wwwwwwwwwwwww = -1;
        this.Wwwwwwwwwwww = false;
        TypedArray Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2415np.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getContext(), attributeSet, R$styleable.ChipGroup, i, Wwwwwwwwwww, new int[0]);
        int dimensionPixelOffset = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getDimensionPixelOffset(R$styleable.ChipGroup_chipSpacing, 0);
        setChipSpacingHorizontal(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getDimensionPixelOffset(R$styleable.ChipGroup_chipSpacingHorizontal, dimensionPixelOffset));
        setChipSpacingVertical(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getDimensionPixelOffset(R$styleable.ChipGroup_chipSpacingVertical, dimensionPixelOffset));
        setSingleLine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getBoolean(R$styleable.ChipGroup_singleLine, false));
        setSingleSelection(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getBoolean(R$styleable.ChipGroup_singleSelection, false));
        setSelectionRequired(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getBoolean(R$styleable.ChipGroup_selectionRequired, false));
        int resourceId = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getResourceId(R$styleable.ChipGroup_checkedChip, -1);
        if (resourceId != -1) {
            this.Wwwwwwwwwwwww = resourceId;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.recycle();
        super.setOnHierarchyChangeListener(this.Wwwwwwwwwwwwww);
        ViewCompat.setImportantForAccessibility(this, 1);
    }

    private int getChipCount() {
        int i = 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            if (getChildAt(i2) instanceof Chip) {
                i++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCheckedId(int i) {
        this.Wwwwwwwwwwwww = i;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null || !this.Wwwwwwwwwwwwwwwwww) {
            return;
        }
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, i);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@IdRes int i) {
        int i2 = this.Wwwwwwwwwwwww;
        if (i == i2) {
            return;
        }
        if (i2 != -1 && this.Wwwwwwwwwwwwwwwwww) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, false);
        }
        if (i != -1) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, true);
        }
        setCheckedId(i);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@IdRes int i, boolean z) {
        View findViewById = findViewById(i);
        if (findViewById instanceof Chip) {
            this.Wwwwwwwwwwww = true;
            ((Chip) findViewById).setChecked(z);
            this.Wwwwwwwwwwww = false;
        }
    }

    @Override // me.tvspark.C2230ip
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof Chip) {
            Chip chip = (Chip) view;
            if (chip.isChecked()) {
                int i2 = this.Wwwwwwwwwwwww;
                if (i2 != -1 && this.Wwwwwwwwwwwwwwwwww) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, false);
                }
                setCheckedId(chip.getId());
            }
        }
        super.addView(view, i, layoutParams);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    @Override // android.view.ViewGroup
    @NonNull
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(-2, -2);
    }

    @Override // android.view.ViewGroup
    @NonNull
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    @NonNull
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(layoutParams);
    }

    @IdRes
    public int getCheckedChipId() {
        if (this.Wwwwwwwwwwwwwwwwww) {
            return this.Wwwwwwwwwwwww;
        }
        return -1;
    }

    @NonNull
    public List<Integer> getCheckedChipIds() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if ((childAt instanceof Chip) && ((Chip) childAt).isChecked()) {
                arrayList.add(Integer.valueOf(childAt.getId()));
                if (this.Wwwwwwwwwwwwwwwwww) {
                    return arrayList;
                }
            }
        }
        return arrayList;
    }

    @Dimension
    public int getChipSpacingHorizontal() {
        return this.Wwwwwwwwwwwwwwwwwwww;
    }

    @Dimension
    public int getChipSpacingVertical() {
        return this.Wwwwwwwwwwwwwwwwwww;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        int i = this.Wwwwwwwwwwwww;
        if (i != -1) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, true);
            setCheckedId(this.Wwwwwwwwwwwww);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(getRowCount(), this.Wwwwwwwwwwwwwwwwwwwwww ? getChipCount() : -1, false, this.Wwwwwwwwwwwwwwwwww ? 1 : 2));
    }

    public void setChipSpacing(@Dimension int i) {
        setChipSpacingHorizontal(i);
        setChipSpacingVertical(i);
    }

    public void setChipSpacingHorizontal(@Dimension int i) {
        if (this.Wwwwwwwwwwwwwwwwwwww != i) {
            this.Wwwwwwwwwwwwwwwwwwww = i;
            setItemSpacing(i);
            requestLayout();
        }
    }

    public void setChipSpacingHorizontalResource(@DimenRes int i) {
        setChipSpacingHorizontal(getResources().getDimensionPixelOffset(i));
    }

    public void setChipSpacingResource(@DimenRes int i) {
        setChipSpacing(getResources().getDimensionPixelOffset(i));
    }

    public void setChipSpacingVertical(@Dimension int i) {
        if (this.Wwwwwwwwwwwwwwwwwww != i) {
            this.Wwwwwwwwwwwwwwwwwww = i;
            setLineSpacing(i);
            requestLayout();
        }
    }

    public void setChipSpacingVerticalResource(@DimenRes int i) {
        setChipSpacingVertical(getResources().getDimensionPixelOffset(i));
    }

    @Deprecated
    public void setDividerDrawableHorizontal(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setDividerDrawableVertical(@Nullable Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setFlexWrap(int i) {
        throw new UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
    }

    public void setOnCheckedChangeListener(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww = onHierarchyChangeListener;
    }

    public void setSelectionRequired(boolean z) {
        this.Wwwwwwwwwwwwwwwww = z;
    }

    @Deprecated
    public void setShowDividerHorizontal(int i) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setShowDividerVertical(int i) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    public void setSingleLine(@BoolRes int i) {
        setSingleLine(getResources().getBoolean(i));
    }

    @Override // me.tvspark.C2230ip
    public void setSingleLine(boolean z) {
        super.setSingleLine(z);
    }

    public void setSingleSelection(@BoolRes int i) {
        setSingleSelection(getResources().getBoolean(i));
    }

    public void setSingleSelection(boolean z) {
        if (this.Wwwwwwwwwwwwwwwwww != z) {
            this.Wwwwwwwwwwwwwwwwww = z;
            this.Wwwwwwwwwwww = true;
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof Chip) {
                    ((Chip) childAt).setChecked(false);
                }
            }
            this.Wwwwwwwwwwww = false;
            setCheckedId(-1);
        }
    }
}
