package me.tvspark.widget.decoration;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes4.dex */
public class GridSpanDecoration extends RecyclerView.ItemDecoration {
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public GridSpanDecoration(int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        int spanCount = ((GridLayoutManager) recyclerView.getLayoutManager()).getSpanCount();
        GridLayoutManager.LayoutParams layoutParams = (GridLayoutManager.LayoutParams) view.getLayoutParams();
        int spanIndex = layoutParams.getSpanIndex();
        int spanSize = layoutParams.getSpanSize();
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (spanIndex != 0) {
            i /= 2;
        }
        rect.left = i;
        int i2 = spanIndex + spanSize;
        int i3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i2 != spanCount) {
            i3 /= 2;
        }
        rect.right = i3;
        int i4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        rect.top = i4 / 2;
        rect.bottom = i4 / 2;
        int layoutDirection = recyclerView.getLayoutDirection();
        boolean z = true;
        if (layoutDirection != 1) {
            z = false;
        }
        if (z) {
            int i5 = rect.left;
            rect.left = rect.right;
            rect.right = i5;
        }
    }
}
