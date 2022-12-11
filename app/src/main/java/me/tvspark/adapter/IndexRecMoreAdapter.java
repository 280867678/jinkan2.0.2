package me.tvspark.adapter;

import android.app.Activity;
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
import me.tvspark.data.bean.VideoParcel;
import me.tvspark.outline;
import me.tvspark.r40;
import me.tvspark.sk0;
import me.tvspark.vn0;
import me.tvspark.widget.RoundImageView;
import me.tvspark.widget.dialog.DialogDesc;
import white.whale.R;

/* loaded from: classes4.dex */
public class IndexRecMoreAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements sk0 {
    public List<VideoParcel> Wwwwwwwwwwwwwwwwwwwwwww = new ArrayList();
    public Activity Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_gallery)
        public RoundImageView ivGallery;
        @BindView(R.id.tv_actor)
        public TextView tvActor;
        @BindView(R.id.tv_title)
        public TextView tvTitle;

        public ViewHolder(IndexRecMoreAdapter indexRecMoreAdapter, View view) {
            super(view);
            ButterKnife.bind(this, view);
            this.ivGallery.setRectAdius(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3));
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
        public final /* synthetic */ VideoParcel Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(VideoParcel videoParcel) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = videoParcel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            new DialogDesc(IndexRecMoreAdapter.this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwww.getTitle(), this.Wwwwwwwwwwwwwwwwwwwwwwww.getCoverUrl(), this.Wwwwwwwwwwwwwwwwwwwwwwww.getLink()).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    public IndexRecMoreAdapter(Activity activity, List<VideoParcel> list) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = activity;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwww.clear();
        this.Wwwwwwwwwwwwwwwwwwwwwww.addAll(list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<VideoParcel> list = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        VideoParcel videoParcel = this.Wwwwwwwwwwwwwwwwwwwwwww.get(i);
        if (videoParcel == null) {
            return;
        }
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        viewHolder2.tvTitle.setText(videoParcel.getTitle());
        viewHolder2.tvActor.setText(videoParcel.getActor());
        viewHolder.itemView.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(videoParcel));
        vn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, videoParcel.getCoverUrl(), "", ((ViewHolder) viewHolder).ivGallery, (vn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(this, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(viewGroup, (int) R.layout.item_video_list2, viewGroup, false));
    }
}
