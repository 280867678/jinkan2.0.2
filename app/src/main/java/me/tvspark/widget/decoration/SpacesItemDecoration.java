package me.tvspark.widget.decoration;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes4.dex */
public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public SpacesItemDecoration(int i, int i2) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int i;
        int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i2 == 0) {
            int i3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            rect.top = i3;
            rect.bottom = i3;
            if (recyclerView.getChildLayoutPosition(view) == 0) {
                rect.left = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            } else {
                rect.left = 0;
            }
            i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        } else if (i2 != 1) {
            return;
        } else {
            if (recyclerView.getChildLayoutPosition(view) == 0) {
                rect.top = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            } else {
                rect.top = 0;
            }
            i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            rect.bottom = i;
            rect.left = i;
        }
        rect.right = i;
    }
}
