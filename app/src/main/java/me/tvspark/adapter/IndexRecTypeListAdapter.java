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
import me.tvspark.outline;
import white.whale.R;

/* loaded from: classes4.dex */
public class IndexRecTypeListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public Context Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public List<String> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayList();
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;

    /* loaded from: classes4.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_title)
        public TextView tvTitle;

        public ViewHolder(IndexRecTypeListAdapter indexRecTypeListAdapter, View view) {
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
            viewHolder.tvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'tvTitle'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ViewHolder viewHolder = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (viewHolder != null) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                viewHolder.tvTitle = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i);
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnClickListener {
        public final /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IndexRecTypeListAdapter indexRecTypeListAdapter = IndexRecTypeListAdapter.this;
            indexRecTypeListAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            indexRecTypeListAdapter.notifyDataSetChanged();
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = IndexRecTypeListAdapter.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww);
            }
        }
    }

    public IndexRecTypeListAdapter(Context context, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = context;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.addAll(list);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<String> list = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        TextView textView;
        int i2;
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        viewHolder2.tvTitle.setText(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i));
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == i) {
            viewHolder2.tvTitle.setTextColor(ContextCompat.getColor(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, R.color.colorPrimary));
            textView = viewHolder2.tvTitle;
            i2 = R.drawable.shape_bg_category;
        } else {
            viewHolder2.tvTitle.setTextColor(ContextCompat.getColor(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, R.color.black));
            textView = viewHolder2.tvTitle;
            i2 = R.drawable.shape_trans;
        }
        textView.setBackgroundResource(i2);
        viewHolder.itemView.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(this, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(viewGroup, (int) R.layout.item_video_type_list, viewGroup, false));
    }
}
