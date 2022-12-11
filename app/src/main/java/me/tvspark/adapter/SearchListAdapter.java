package me.tvspark.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.util.ArrayList;
import java.util.List;
import me.tvspark.data.bean.EngineResultParcel;
import me.tvspark.mn0;
import me.tvspark.nn0;
import me.tvspark.outline;
import me.tvspark.r40;
import me.tvspark.sk0;
import me.tvspark.vn0;
import me.tvspark.widget.RoundImageView;
import white.whale.R;

/* loaded from: classes4.dex */
public class SearchListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements sk0 {
    public String Wwwwwwwwwwwwwwwwwwwwww;
    public List<EngineResultParcel> Wwwwwwwwwwwwwwwwwwwwwww = new ArrayList();
    public Context Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_gallery)
        public RoundImageView ivGallery;
        @BindView(R.id.tv_actor)
        public TextView tvActor;
        @BindView(R.id.tv_title)
        public TextView tvTitle;

        public ViewHolder(SearchListAdapter searchListAdapter, View view) {
            super(view);
            ButterKnife.bind(this, view);
            this.ivGallery.setRectAdius(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3));
        }
    }

    /* loaded from: classes4.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        public ViewHolder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = viewHolder;
            viewHolder.tvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'tvTitle'", TextView.class);
            viewHolder.ivGallery = (RoundImageView) Utils.findRequiredViewAsType(view, R.id.iv_gallery, "field 'ivGallery'", RoundImageView.class);
            viewHolder.tvActor = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_actor, "field 'tvActor'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ViewHolder viewHolder = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (viewHolder != null) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                viewHolder.tvTitle = null;
                viewHolder.ivGallery = null;
                viewHolder.tvActor = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnClickListener {
        public final /* synthetic */ EngineResultParcel Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(EngineResultParcel engineResultParcel) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = engineResultParcel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(SearchListAdapter.this.Wwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwww.getWebSourceData().getWebSourceBaseUrl());
            mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(SearchListAdapter.this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwww.getWebSourceData().getWebSourceBaseUrl(), this.Wwwwwwwwwwwwwwwwwwwwwwww.getLink(), this.Wwwwwwwwwwwwwwwwwwwwwwww.getTitle(), this.Wwwwwwwwwwwwwwwwwwwwwwww.getCover(), this.Wwwwwwwwwwwwwwwwwwwwwwww.getWebSourceData().isCustomWebSource());
        }
    }

    public SearchListAdapter(List<EngineResultParcel> list, Context context, String str) {
        this.Wwwwwwwwwwwwwwwwwwwwww = "";
        this.Wwwwwwwwwwwwwwwwwwwwwwww = context;
        this.Wwwwwwwwwwwwwwwwwwwwww = str;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwww.clear();
        this.Wwwwwwwwwwwwwwwwwwwwwww.addAll(list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<EngineResultParcel> list = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        EngineResultParcel engineResultParcel = this.Wwwwwwwwwwwwwwwwwwwwwww.get(i);
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        viewHolder2.tvTitle.setText(engineResultParcel.getTitle());
        viewHolder2.tvActor.setText(TextUtils.isEmpty(engineResultParcel.getNumber()) ? engineResultParcel.getActor() : engineResultParcel.getNumber());
        viewHolder.itemView.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(engineResultParcel));
        vn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, engineResultParcel.getCover(), ((ViewHolder) viewHolder).ivGallery, engineResultParcel.getWebSourceData().getImgReferer());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(this, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(viewGroup, (int) R.layout.item_video_search_list, viewGroup, false));
    }
}
