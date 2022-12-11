package me.tvspark.widget.decoration;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes4.dex */
public class SpacesItemDecorationIndexRec extends RecyclerView.ItemDecoration {
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public SpacesItemDecorationIndexRec(int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        rect.left = recyclerView.getChildLayoutPosition(view) == 0 ? 0 : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }
}
