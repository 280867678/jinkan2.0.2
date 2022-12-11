package com.google.android.material.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import androidx.annotation.BoolRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.button.MaterialButton;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeMap;
import me.tvspark.AbstractC2157gq;
import me.tvspark.C1957bs;
import me.tvspark.C2083eq;
import me.tvspark.C2415np;
import me.tvspark.C2416nq;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public class MaterialButtonToggleGroup extends LinearLayout {
    @IdRes
    public int Wwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwww;
    public Integer[] Wwwwwwwwwwwwwwwwwww;
    public final Comparator<MaterialButton> Wwwwwwwwwwwwwwwwwwww;
    public final LinkedHashSet<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwww;
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwww;
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwww;
    public final List<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwwwww;
    public static final String Wwwwwwwwwwwwww = MaterialButtonToggleGroup.class.getSimpleName();
    public static final int Wwwwwwwwwwwww = R$style.Widget_MaterialComponents_MaterialButtonToggleGroup;

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwww implements MaterialButton.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        }
    }

    /* loaded from: classes3.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(MaterialButtonToggleGroup materialButtonToggleGroup, @IdRes int i, boolean z);
    }

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public static final AbstractC2157gq Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2083eq(0.0f);
        public AbstractC2157gq Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public AbstractC2157gq Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public AbstractC2157gq Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public AbstractC2157gq Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2157gq abstractC2157gq, AbstractC2157gq abstractC2157gq2, AbstractC2157gq abstractC2157gq3, AbstractC2157gq abstractC2157gq4) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2157gq;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2157gq3;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2157gq4;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2157gq2;
        }

        public static Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, View view) {
            if (Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view)) {
                AbstractC2157gq abstractC2157gq = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2157gq, abstractC2157gq, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            AbstractC2157gq abstractC2157gq2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            AbstractC2157gq abstractC2157gq3 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            AbstractC2157gq abstractC2157gq4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2157gq2, abstractC2157gq3, abstractC2157gq4, abstractC2157gq4);
        }

        public static Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, View view) {
            if (Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view)) {
                AbstractC2157gq abstractC2157gq = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                AbstractC2157gq abstractC2157gq2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                AbstractC2157gq abstractC2157gq3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2157gq, abstractC2157gq2, abstractC2157gq3, abstractC2157gq3);
            }
            AbstractC2157gq abstractC2157gq4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2157gq4, abstractC2157gq4, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements MaterialButton.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        }

        @Override // com.google.android.material.button.MaterialButton.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull MaterialButton materialButton, boolean z) {
            MaterialButtonToggleGroup materialButtonToggleGroup = MaterialButtonToggleGroup.this;
            if (materialButtonToggleGroup.Wwwwwwwwwwwwwwwwww) {
                return;
            }
            if (materialButtonToggleGroup.Wwwwwwwwwwwwwwwww) {
                materialButtonToggleGroup.Wwwwwwwwwwwwwww = z ? materialButton.getId() : -1;
            }
            if (MaterialButtonToggleGroup.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(materialButton.getId(), z)) {
                MaterialButtonToggleGroup.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(materialButton.getId(), materialButton.Wwwwwwwwwwwwww);
            }
            MaterialButtonToggleGroup.this.invalidate();
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AccessibilityDelegateCompat {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, MaterialButtonToggleGroup.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(MaterialButtonToggleGroup.this, view), 1, false, ((MaterialButton) view).Wwwwwwwwwwwwww));
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Comparator<MaterialButton> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // java.util.Comparator
        public int compare(MaterialButton materialButton, MaterialButton materialButton2) {
            MaterialButton materialButton3 = materialButton;
            MaterialButton materialButton4 = materialButton2;
            int compareTo = Boolean.valueOf(materialButton3.Wwwwwwwwwwwwww).compareTo(Boolean.valueOf(materialButton4.Wwwwwwwwwwwwww));
            if (compareTo != 0) {
                return compareTo;
            }
            int compareTo2 = Boolean.valueOf(materialButton3.isPressed()).compareTo(Boolean.valueOf(materialButton4.isPressed()));
            return compareTo2 != 0 ? compareTo2 : Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(materialButton3)).compareTo(Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(materialButton4)));
        }
    }

    public MaterialButtonToggleGroup(@NonNull Context context) {
        this(context, null);
    }

    public MaterialButtonToggleGroup(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.materialButtonToggleGroupStyle);
    }

    public MaterialButtonToggleGroup(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(C1957bs.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, attributeSet, i, Wwwwwwwwwwwww), attributeSet, i);
        this.Wwwwwwwwwwwwwwwwwwwwwwww = new ArrayList();
        this.Wwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null);
        this.Wwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(null);
        this.Wwwwwwwwwwwwwwwwwwwww = new LinkedHashSet<>();
        this.Wwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwwww = false;
        TypedArray Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2415np.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getContext(), attributeSet, R$styleable.MaterialButtonToggleGroup, i, Wwwwwwwwwwwww, new int[0]);
        setSingleSelection(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getBoolean(R$styleable.MaterialButtonToggleGroup_singleSelection, false));
        this.Wwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getResourceId(R$styleable.MaterialButtonToggleGroup_checkedButton, -1);
        this.Wwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getBoolean(R$styleable.MaterialButtonToggleGroup_selectionRequired, false);
        setChildrenDrawingOrderEnabled(true);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.recycle();
        ViewCompat.setImportantForAccessibility(this, 1);
    }

    public static /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(MaterialButtonToggleGroup materialButtonToggleGroup, View view) {
        if (materialButtonToggleGroup != null) {
            if (!(view instanceof MaterialButton)) {
                return -1;
            }
            int i = 0;
            for (int i2 = 0; i2 < materialButtonToggleGroup.getChildCount(); i2++) {
                if (materialButtonToggleGroup.getChildAt(i2) == view) {
                    return i;
                }
                if ((materialButtonToggleGroup.getChildAt(i2) instanceof MaterialButton) && materialButtonToggleGroup.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2)) {
                    i++;
                }
            }
            return -1;
        }
        throw null;
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i)) {
                return i;
            }
        }
        return -1;
    }

    private int getLastVisibleChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(childCount)) {
                return childCount;
            }
        }
        return -1;
    }

    private int getVisibleButtonCount() {
        int i = 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            if ((getChildAt(i2) instanceof MaterialButton) && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2)) {
                i++;
            }
        }
        return i;
    }

    private void setCheckedId(int i) {
        this.Wwwwwwwwwwwwwww = i;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, true);
    }

    private void setGeneratedIdIfNeeded(@NonNull MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            materialButton.setId(ViewCompat.generateViewId());
        }
    }

    private void setupButtonChild(@NonNull MaterialButton materialButton) {
        materialButton.setMaxLines(1);
        materialButton.setEllipsize(TextUtils.TruncateAt.END);
        materialButton.setCheckable(true);
        materialButton.Wwwwwwwwwwwwwwwwwwwwwww.add(this.Wwwwwwwwwwwwwwwwwwwwwww);
        materialButton.setOnPressedChangeListenerInternal(this.Wwwwwwwwwwwwwwwwwwwwww);
        materialButton.setShouldDrawSurfaceColorStroke(true);
    }

    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        return getChildAt(i).getVisibility() != 8;
    }

    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, boolean z) {
        List<Integer> checkedButtonIds = getCheckedButtonIds();
        if (this.Wwwwwwwwwwwwwwww && checkedButtonIds.isEmpty()) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, true);
            this.Wwwwwwwwwwwwwww = i;
            return false;
        }
        if (z && this.Wwwwwwwwwwwwwwwww) {
            checkedButtonIds.remove(Integer.valueOf(i));
            for (Integer num : checkedButtonIds) {
                int intValue = num.intValue();
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(intValue, false);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(intValue, false);
            }
        }
        return true;
    }

    public final MaterialButton Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        return (MaterialButton) getChildAt(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0078  */
    @VisibleForTesting
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int childCount = getChildCount();
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        int lastVisibleChildIndex = getLastVisibleChildIndex();
        for (int i = 0; i < childCount; i++) {
            MaterialButton Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getVisibility() != 8) {
                C2416nq shapeAppearanceModel = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getShapeAppearanceModel();
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                if (shapeAppearanceModel != null) {
                    C2416nq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2416nq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(shapeAppearanceModel);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwww.get(i);
                    if (firstVisibleChildIndex != lastVisibleChildIndex) {
                        boolean z = getOrientation() == 0;
                        if (i != firstVisibleChildIndex) {
                            if (i == lastVisibleChildIndex) {
                                if (z) {
                                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, this);
                                } else {
                                    AbstractC2157gq abstractC2157gq = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2157gq, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, abstractC2157gq, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                                }
                            }
                            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                            }
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.setShapeAppearanceModel(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                        } else if (z) {
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, this);
                        } else {
                            AbstractC2157gq abstractC2157gq2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            AbstractC2157gq abstractC2157gq3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2157gq2, abstractC2157gq3, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, abstractC2157gq3);
                            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0.0f);
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0.0f);
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0.0f);
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0.0f);
                            } else {
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            }
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.setShapeAppearanceModel(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                        }
                    }
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                    if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                    }
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.setShapeAppearanceModel(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                } else {
                    throw null;
                }
            }
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@IdRes int i, boolean z) {
        View findViewById = findViewById(i);
        if (findViewById instanceof MaterialButton) {
            this.Wwwwwwwwwwwwwwwwww = true;
            ((MaterialButton) findViewById).setChecked(z);
            this.Wwwwwwwwwwwwwwwwww = false;
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@IdRes int i, boolean z) {
        Iterator<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww> it = this.Wwwwwwwwwwwwwwwwwwwww.iterator();
        while (it.hasNext()) {
            it.next().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, i, z);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof MaterialButton)) {
            return;
        }
        super.addView(view, i, layoutParams);
        MaterialButton materialButton = (MaterialButton) view;
        setGeneratedIdIfNeeded(materialButton);
        setupButtonChild(materialButton);
        if (materialButton.Wwwwwwwwwwwwww) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(materialButton.getId(), true);
            setCheckedId(materialButton.getId());
        }
        C2416nq shapeAppearanceModel = materialButton.getShapeAppearanceModel();
        this.Wwwwwwwwwwwwwwwwwwwwwwww.add(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(shapeAppearanceModel.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, shapeAppearanceModel.Wwwwwwwwwwwwwwwwwwwwwwwwwww, shapeAppearanceModel.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, shapeAppearanceModel.Wwwwwwwwwwwwwwwwwwwwwwwwwwww));
        ViewCompat.setAccessibilityDelegate(materialButton, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(@NonNull Canvas canvas) {
        TreeMap treeMap = new TreeMap(this.Wwwwwwwwwwwwwwwwwwww);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            treeMap.put(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i), Integer.valueOf(i));
        }
        this.Wwwwwwwwwwwwwwwwwww = (Integer[]) treeMap.values().toArray(new Integer[0]);
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    @NonNull
    public CharSequence getAccessibilityClassName() {
        return MaterialButtonToggleGroup.class.getName();
    }

    @IdRes
    public int getCheckedButtonId() {
        if (this.Wwwwwwwwwwwwwwwww) {
            return this.Wwwwwwwwwwwwwww;
        }
        return -1;
    }

    @NonNull
    public List<Integer> getCheckedButtonIds() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < getChildCount(); i++) {
            MaterialButton Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwww) {
                arrayList.add(Integer.valueOf(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getId()));
            }
        }
        return arrayList;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i, int i2) {
        Integer[] numArr = this.Wwwwwwwwwwwwwwwwwww;
        return (numArr == null || i2 >= numArr.length) ? i2 : numArr[i2].intValue();
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        int i = this.Wwwwwwwwwwwwwww;
        if (i != -1) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, true);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, true);
            setCheckedId(i);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, getVisibleButtonCount(), false, this.Wwwwwwwwwwwwwwwww ? 1 : 2));
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        super.onMeasure(i, i2);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            MaterialButton materialButton = (MaterialButton) view;
            materialButton.Wwwwwwwwwwwwwwwwwwwwwww.remove(this.Wwwwwwwwwwwwwwwwwwwwwww);
            materialButton.setOnPressedChangeListenerInternal(null);
        }
        int indexOfChild = indexOfChild(view);
        if (indexOfChild >= 0) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.remove(indexOfChild);
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public void setSelectionRequired(boolean z) {
        this.Wwwwwwwwwwwwwwww = z;
    }

    public void setSingleSelection(@BoolRes int i) {
        setSingleSelection(getResources().getBoolean(i));
    }

    public void setSingleSelection(boolean z) {
        if (this.Wwwwwwwwwwwwwwwww != z) {
            this.Wwwwwwwwwwwwwwwww = z;
            this.Wwwwwwwwwwwwwwwwww = true;
            for (int i = 0; i < getChildCount(); i++) {
                MaterialButton Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.setChecked(false);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getId(), false);
            }
            this.Wwwwwwwwwwwwwwwwww = false;
            setCheckedId(-1);
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        if (firstVisibleChildIndex == -1) {
            return;
        }
        for (int i = firstVisibleChildIndex + 1; i < getChildCount(); i++) {
            MaterialButton Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
            int min = Math.min(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getStrokeWidth(), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i - 1).getStrokeWidth());
            ViewGroup.LayoutParams layoutParams = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : new LinearLayout.LayoutParams(layoutParams.width, layoutParams.height);
            if (getOrientation() == 0) {
                MarginLayoutParamsCompat.setMarginEnd(layoutParams2, 0);
                MarginLayoutParamsCompat.setMarginStart(layoutParams2, -min);
                layoutParams2.topMargin = 0;
            } else {
                layoutParams2.bottomMargin = 0;
                layoutParams2.topMargin = -min;
                MarginLayoutParamsCompat.setMarginStart(layoutParams2, 0);
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.setLayoutParams(layoutParams2);
        }
        if (getChildCount() == 0 || firstVisibleChildIndex == -1) {
            return;
        }
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) ((MaterialButton) getChildAt(firstVisibleChildIndex)).getLayoutParams();
        if (getOrientation() == 1) {
            layoutParams3.topMargin = 0;
            layoutParams3.bottomMargin = 0;
            return;
        }
        MarginLayoutParamsCompat.setMarginEnd(layoutParams3, 0);
        MarginLayoutParamsCompat.setMarginStart(layoutParams3, 0);
        layoutParams3.leftMargin = 0;
        layoutParams3.rightMargin = 0;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@IdRes int i) {
        if (i == this.Wwwwwwwwwwwwwww) {
            return;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, true);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, true);
        setCheckedId(i);
    }
}
