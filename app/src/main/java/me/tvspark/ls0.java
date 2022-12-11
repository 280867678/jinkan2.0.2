package me.tvspark;

import android.graphics.Rect;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import me.tvspark.view.activity.DetailActivity;

/* loaded from: classes4.dex */
public class ls0 extends RecyclerView.ItemDecoration {
    public ls0(DetailActivity detailActivity) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        rect.top = 0;
        rect.bottom = 0;
        if (recyclerView.getChildLayoutPosition(view) == 0) {
            rect.left = 0;
        } else {
            rect.left = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(10);
        }
        rect.right = 0;
    }
}
