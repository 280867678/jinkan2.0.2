package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewParent;
import androidx.annotation.AbstractC0047Px;
import androidx.annotation.NonNull;
import androidx.core.util.Preconditions;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

/* loaded from: classes3.dex */
public final class MarginPageTransformer implements ViewPager2.PageTransformer {
    public final int mMarginPx;

    public MarginPageTransformer(@AbstractC0047Px int i) {
        Preconditions.checkArgumentNonnegative(i, "Margin must be non-negative");
        this.mMarginPx = i;
    }

    private ViewPager2 requireViewPager(@NonNull View view) {
        ViewParent parent = view.getParent();
        ViewParent parent2 = parent.getParent();
        if (!(parent instanceof RecyclerView) || !(parent2 instanceof ViewPager2)) {
            throw new IllegalStateException("Expected the page view to be managed by a ViewPager2 instance.");
        }
        return (ViewPager2) parent2;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(@NonNull View view, float f) {
        ViewPager2 requireViewPager = requireViewPager(view);
        float f2 = this.mMarginPx * f;
        if (requireViewPager.getOrientation() != 0) {
            view.setTranslationY(f2);
            return;
        }
        if (requireViewPager.isRtl()) {
            f2 = -f2;
        }
        view.setTranslationX(f2);
    }
}
