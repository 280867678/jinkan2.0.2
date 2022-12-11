package me.tvspark.adapter;

import android.content.Context;
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
import me.tvspark.data.sql.WebSourceIndexData;
import me.tvspark.mn0;
import me.tvspark.outline;
import me.tvspark.r40;
import me.tvspark.sk0;
import me.tvspark.vn0;
import me.tvspark.widget.RoundImageView;
import white.whale.R;

/* loaded from: classes4.dex */
public class VideoIndexOtherAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements sk0 {
    public WebSourceIndexData Wwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwww;
    public List<VideoParcel> Wwwwwwwwwwwwwwwwwwwwwww = new ArrayList();
    public Context Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_gallery)
        public RoundImageView ivGallery;
        @BindView(R.id.tv_actor)
        public TextView tvActor;
        @BindView(R.id.tv_title)
        public TextView tvTitle;

        public ViewHolder(VideoIndexOtherAdapter videoIndexOtherAdapter, View view) {
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
            VideoIndexOtherAdapter videoIndexOtherAdapter = VideoIndexOtherAdapter.this;
            WebSourceIndexData webSourceIndexData = videoIndexOtherAdapter.Wwwwwwwwwwwwwwwwwwwww;
            if (webSourceIndexData != null) {
                mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(videoIndexOtherAdapter.Wwwwwwwwwwwwwwwwwwwwwwww, webSourceIndexData.getWebSourceBaseUrl(), this.Wwwwwwwwwwwwwwwwwwwwwwww.getLink(), this.Wwwwwwwwwwwwwwwwwwwwwwww.getTitle(), this.Wwwwwwwwwwwwwwwwwwwwwwww.getCoverUrl(), VideoIndexOtherAdapter.this.Wwwwwwwwwwwwwwwwwwwww.isCustomWebSource());
            }
        }
    }

    public VideoIndexOtherAdapter(List<VideoParcel> list, Context context, boolean z, WebSourceIndexData webSourceIndexData) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = context;
        this.Wwwwwwwwwwwwwwwwwwwww = webSourceIndexData;
        if (list != null && !list.isEmpty()) {
            this.Wwwwwwwwwwwwwwwwwwwwwww.clear();
            this.Wwwwwwwwwwwwwwwwwwwwwww.addAll(list);
        }
        this.Wwwwwwwwwwwwwwwwwwwwww = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (!this.Wwwwwwwwwwwwwwwwwwwwww) {
            List<VideoParcel> list = this.Wwwwwwwwwwwwwwwwwwwwwww;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        List<VideoParcel> list2 = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (list2 == null) {
            return 0;
        }
        if (list2.size() < 9 && this.Wwwwwwwwwwwwwwwwwwwwwww.size() >= 6) {
            return 6;
        }
        if (this.Wwwwwwwwwwwwwwwwwwwwwww.size() <= 9) {
            return this.Wwwwwwwwwwwwwwwwwwwwwww.size();
        }
        return 9;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return 0;
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
