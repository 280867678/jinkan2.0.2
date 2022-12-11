package me.tvspark.adapter;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.List;

/* loaded from: classes4.dex */
public abstract class ItemAdapter<I, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    public List<I> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(VH vh) {
        vh.itemView.clearAnimation();
        super.onViewDetachedFromWindow(vh);
    }
}
