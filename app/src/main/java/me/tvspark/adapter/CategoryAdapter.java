package me.tvspark.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.hedgehog.ratingbar.RatingBar;
import java.util.ArrayList;
import java.util.List;
import me.tvspark.data.bean.DoubanCategoryParcel;
import me.tvspark.mn0;
import me.tvspark.outline;
import me.tvspark.r40;
import me.tvspark.vn0;
import me.tvspark.widget.RoundImageView;
import white.whale.R;

/* loaded from: classes4.dex */
public class CategoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public List<DoubanCategoryParcel.DataEntity> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayList();
    public Context Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_cover_grid)
        public RoundImageView ivCoverGrid;
        @BindView(R.id.ratingBar_grid)
        public RatingBar ratingBarGrid;
        @BindView(R.id.rlyt_grid)
        public RelativeLayout rlytGrid;
        @BindView(R.id.tv_rate_grid)
        public TextView tvRateGrid;
        @BindView(R.id.tv_title_grid)
        public TextView tvTitleGrid;

        public ViewHolder(CategoryAdapter categoryAdapter, View view) {
            super(view);
            ButterKnife.bind(this, view);
            this.ivCoverGrid.setRectAdius(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3));
        }
    }

    /* loaded from: classes4.dex */
    public class ViewHolderCategory extends RecyclerView.ViewHolder {
        public ViewHolderCategory(CategoryAdapter categoryAdapter, View view) {
            super(view);
        }
    }

    /* loaded from: classes4.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        public ViewHolder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = viewHolder;
            viewHolder.rlytGrid = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rlyt_grid, "field 'rlytGrid'", RelativeLayout.class);
            viewHolder.ivCoverGrid = (RoundImageView) Utils.findRequiredViewAsType(view, R.id.iv_cover_grid, "field 'ivCoverGrid'", RoundImageView.class);
            viewHolder.tvTitleGrid = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title_grid, "field 'tvTitleGrid'", TextView.class);
            viewHolder.tvRateGrid = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_rate_grid, "field 'tvRateGrid'", TextView.class);
            viewHolder.ratingBarGrid = (RatingBar) Utils.findRequiredViewAsType(view, R.id.ratingBar_grid, "field 'ratingBarGrid'", RatingBar.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ViewHolder viewHolder = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (viewHolder != null) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                viewHolder.ivCoverGrid = null;
                viewHolder.tvTitleGrid = null;
                viewHolder.tvRateGrid = null;
                viewHolder.ratingBarGrid = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnClickListener {
        public final /* synthetic */ DoubanCategoryParcel.DataEntity Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DoubanCategoryParcel.DataEntity dataEntity) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = dataEntity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(CategoryAdapter.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwww.getTitle());
        }
    }

    public CategoryAdapter(Context context) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = context;
    }

    public CategoryAdapter Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
        notifyDataSetChanged();
        return this;
    }

    public CategoryAdapter Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(List<DoubanCategoryParcel.DataEntity> list, boolean z) {
        if (list != null && !list.isEmpty()) {
            if (!z) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.addAll(list);
        }
        notifyDataSetChanged();
        return this;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<DoubanCategoryParcel.DataEntity> list = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (list == null) {
            return 1;
        }
        return 1 + list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return i == 0 ? 3 : 5;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        if (getItemViewType(i) == 3) {
            ((ViewHolderCategory) viewHolder).itemView.setTag(6);
            return;
        }
        DoubanCategoryParcel.DataEntity dataEntity = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i - 1);
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        viewHolder2.tvTitleGrid.setText(dataEntity.getTitle());
        viewHolder2.tvRateGrid.setText(dataEntity.getRate());
        try {
            ((ViewHolder) viewHolder).ratingBarGrid.setStar(Float.valueOf(dataEntity.getRate()).floatValue() / 2.0f);
        } catch (Exception e) {
            e.printStackTrace();
            viewHolder2.ratingBarGrid.setStar(0.0f);
        }
        vn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, dataEntity.getCover(), viewHolder2.ivCoverGrid, "");
        viewHolder.itemView.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(dataEntity));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return i == 3 ? new ViewHolderCategory(this, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(viewGroup, (int) R.layout.view_find_list_category, viewGroup, false)) : new ViewHolder(this, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(viewGroup, (int) R.layout.item_find_list, viewGroup, false));
    }
}
