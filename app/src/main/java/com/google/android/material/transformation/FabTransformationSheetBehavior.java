package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import java.util.HashMap;
import java.util.Map;

@Deprecated
/* loaded from: classes3.dex */
public class FabTransformationSheetBehavior extends FabTransformationBehavior {
    @Nullable
    public Map<View, Integer> Wwwwwwwwwwwwwwwwwwwwwwwwww;

    public FabTransformationSheetBehavior() {
    }

    public FabTransformationSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior, com.google.android.material.transformation.ExpandableBehavior
    @CallSuper
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull View view, @NonNull View view2, boolean z, boolean z2) {
        int i;
        ViewParent parent = view2.getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwww = new HashMap(childCount);
            }
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = coordinatorLayout.getChildAt(i2);
                boolean z3 = (childAt.getLayoutParams() instanceof CoordinatorLayout.LayoutParams) && (((CoordinatorLayout.LayoutParams) childAt.getLayoutParams()).getBehavior() instanceof FabTransformationScrimBehavior);
                if (childAt != view2 && !z3) {
                    Map<View, Integer> map = this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (z) {
                        map.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        i = 4;
                    } else if (map != null && map.containsKey(childAt)) {
                        i = this.Wwwwwwwwwwwwwwwwwwwwwwwwww.get(childAt).intValue();
                    }
                    ViewCompat.setImportantForAccessibility(childAt, i);
                }
            }
            if (!z) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwww = null;
            }
        }
        super.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view, view2, z, z2);
        return true;
    }
}
