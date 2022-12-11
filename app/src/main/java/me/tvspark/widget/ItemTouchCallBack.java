package me.tvspark.widget;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

/* loaded from: classes4.dex */
public class ItemTouchCallBack extends ItemTouchHelper.Callback {
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -1;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -1;

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2);

        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2);
    }

    public ItemTouchCallBack(boolean z) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        int i;
        super.clearView(recyclerView, viewHolder);
        int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i2 != -1 && (i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) != -1) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, i);
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -1;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -1;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        int i;
        int i2;
        if ((recyclerView.getLayoutManager() instanceof GridLayoutManager) || (recyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager)) {
            i = 15;
            i2 = 0;
        } else {
            i = 3;
            i2 = 8;
        }
        return ItemTouchHelper.Callback.makeMovementFlags(i, i2);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean isItemViewSwipeEnabled() {
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean isLongPressDragEnabled() {
        return !this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
        int adapterPosition = viewHolder.getAdapterPosition();
        int adapterPosition2 = viewHolder2.getAdapterPosition();
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -1) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = adapterPosition;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = adapterPosition2;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(adapterPosition, adapterPosition2);
        return true;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int i) {
        super.onSelectedChanged(viewHolder, i);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int i) {
        viewHolder.getAdapterPosition();
    }
}
