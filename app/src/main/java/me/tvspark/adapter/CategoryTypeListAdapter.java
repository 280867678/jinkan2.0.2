package me.tvspark.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.util.ArrayList;
import java.util.List;
import me.tvspark.data.bean.GenreParcel;
import me.tvspark.outline;
import white.whale.R;

/* loaded from: classes4.dex */
public class CategoryTypeListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public List<GenreParcel> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public Context Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_category)
        public TextView tvCategory;

        public ViewHolder(CategoryTypeListAdapter categoryTypeListAdapter, View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    /* loaded from: classes4.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        public ViewHolder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = viewHolder;
            viewHolder.tvCategory = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_category, "field 'tvCategory'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ViewHolder viewHolder = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (viewHolder != null) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                viewHolder.tvCategory = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(GenreParcel genreParcel);
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnClickListener {
        public final /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CategoryTypeListAdapter categoryTypeListAdapter = CategoryTypeListAdapter.this;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = categoryTypeListAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(categoryTypeListAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(this.Wwwwwwwwwwwwwwwwwwwwwwww));
                CategoryTypeListAdapter categoryTypeListAdapter2 = CategoryTypeListAdapter.this;
                categoryTypeListAdapter2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                categoryTypeListAdapter2.notifyDataSetChanged();
            }
        }
    }

    public CategoryTypeListAdapter(Context context, List<GenreParcel> list) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayList();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = context;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<GenreParcel> list = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        TextView textView;
        int i2;
        ((ViewHolder) viewHolder).tvCategory.setText(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i).getName());
        viewHolder.itemView.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i));
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == i) {
            viewHolder2.tvCategory.setTextColor(ContextCompat.getColor(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, R.color.colorPrimary));
            textView = viewHolder2.tvCategory;
            i2 = R.drawable.shape_bg_category;
        } else {
            viewHolder2.tvCategory.setTextColor(ContextCompat.getColor(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, R.color.black));
            textView = viewHolder2.tvCategory;
            i2 = R.drawable.shape_trans;
        }
        textView.setBackgroundResource(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(this, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(viewGroup, (int) R.layout.item_category, viewGroup, false));
    }
}
