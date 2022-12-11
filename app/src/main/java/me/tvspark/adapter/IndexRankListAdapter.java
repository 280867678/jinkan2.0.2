package me.tvspark.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
import me.tvspark.data.bean.IndexRankListParcel;
import me.tvspark.data.bean.VideoParcel;
import me.tvspark.data.sql.WebSourceIndexRecData;
import me.tvspark.mn0;
import me.tvspark.outline;
import me.tvspark.r40;
import me.tvspark.vn0;
import me.tvspark.widget.RoundImageView;
import white.whale.R;

/* loaded from: classes4.dex */
public class IndexRankListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public List<IndexRankListParcel> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayList();
    public WebSourceIndexRecData Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public Context Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_bg)
        public ImageView ivBg;
        @BindView(R.id.iv_gallery1)
        public RoundImageView ivGallery1;
        @BindView(R.id.iv_gallery2)
        public RoundImageView ivGallery2;
        @BindView(R.id.iv_gallery3)
        public RoundImageView ivGallery3;
        @BindView(R.id.iv_mask1)
        public ImageView ivMask1;
        @BindView(R.id.iv_mask2)
        public ImageView ivMask2;
        @BindView(R.id.ratingBar_grid1)
        public RatingBar rantingBar1;
        @BindView(R.id.ratingBar_grid2)
        public RatingBar rantingBar2;
        @BindView(R.id.ratingBar_grid3)
        public RatingBar rantingBar3;
        @BindView(R.id.rlyt_rank1)
        public RelativeLayout rlytRank1;
        @BindView(R.id.rlyt_rank2)
        public RelativeLayout rlytRank2;
        @BindView(R.id.rlyt_rank3)
        public RelativeLayout rlytRank3;
        @BindView(R.id.tv_rank_title)
        public TextView tvRankTitle;
        @BindView(R.id.tv_rate_1)
        public TextView tvRate1;
        @BindView(R.id.tv_rate_2)
        public TextView tvRate2;
        @BindView(R.id.tv_rate_3)
        public TextView tvRate3;
        @BindView(R.id.tv_title1)
        public TextView tvTitle1;
        @BindView(R.id.tv_title2)
        public TextView tvTitle2;
        @BindView(R.id.tv_title3)
        public TextView tvTitle3;

        public ViewHolder(IndexRankListAdapter indexRankListAdapter, View view) {
            super(view);
            ButterKnife.bind(this, view);
            this.ivGallery1.setRectAdius(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3));
            this.ivGallery2.setRectAdius(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3));
            this.ivGallery3.setRectAdius(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3));
        }
    }

    /* loaded from: classes4.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        public ViewHolder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = viewHolder;
            viewHolder.ivBg = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_bg, "field 'ivBg'", ImageView.class);
            viewHolder.ivMask1 = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_mask1, "field 'ivMask1'", ImageView.class);
            viewHolder.ivMask2 = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_mask2, "field 'ivMask2'", ImageView.class);
            viewHolder.tvRankTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_rank_title, "field 'tvRankTitle'", TextView.class);
            viewHolder.rlytRank1 = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rlyt_rank1, "field 'rlytRank1'", RelativeLayout.class);
            viewHolder.ivGallery1 = (RoundImageView) Utils.findRequiredViewAsType(view, R.id.iv_gallery1, "field 'ivGallery1'", RoundImageView.class);
            viewHolder.tvTitle1 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title1, "field 'tvTitle1'", TextView.class);
            viewHolder.rantingBar1 = (RatingBar) Utils.findRequiredViewAsType(view, R.id.ratingBar_grid1, "field 'rantingBar1'", RatingBar.class);
            viewHolder.tvRate1 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_rate_1, "field 'tvRate1'", TextView.class);
            viewHolder.rlytRank2 = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rlyt_rank2, "field 'rlytRank2'", RelativeLayout.class);
            viewHolder.ivGallery2 = (RoundImageView) Utils.findRequiredViewAsType(view, R.id.iv_gallery2, "field 'ivGallery2'", RoundImageView.class);
            viewHolder.tvTitle2 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title2, "field 'tvTitle2'", TextView.class);
            viewHolder.rantingBar2 = (RatingBar) Utils.findRequiredViewAsType(view, R.id.ratingBar_grid2, "field 'rantingBar2'", RatingBar.class);
            viewHolder.tvRate2 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_rate_2, "field 'tvRate2'", TextView.class);
            viewHolder.rlytRank3 = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rlyt_rank3, "field 'rlytRank3'", RelativeLayout.class);
            viewHolder.ivGallery3 = (RoundImageView) Utils.findRequiredViewAsType(view, R.id.iv_gallery3, "field 'ivGallery3'", RoundImageView.class);
            viewHolder.tvTitle3 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title3, "field 'tvTitle3'", TextView.class);
            viewHolder.rantingBar3 = (RatingBar) Utils.findRequiredViewAsType(view, R.id.ratingBar_grid3, "field 'rantingBar3'", RatingBar.class);
            viewHolder.tvRate3 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_rate_3, "field 'tvRate3'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ViewHolder viewHolder = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (viewHolder != null) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                viewHolder.ivBg = null;
                viewHolder.ivMask1 = null;
                viewHolder.ivMask2 = null;
                viewHolder.tvRankTitle = null;
                viewHolder.rlytRank1 = null;
                viewHolder.ivGallery1 = null;
                viewHolder.tvTitle1 = null;
                viewHolder.rantingBar1 = null;
                viewHolder.tvRate1 = null;
                viewHolder.rlytRank2 = null;
                viewHolder.ivGallery2 = null;
                viewHolder.tvTitle2 = null;
                viewHolder.rantingBar2 = null;
                viewHolder.tvRate2 = null;
                viewHolder.rlytRank3 = null;
                viewHolder.ivGallery3 = null;
                viewHolder.tvTitle3 = null;
                viewHolder.rantingBar3 = null;
                viewHolder.tvRate3 = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements vn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final /* synthetic */ RecyclerView.ViewHolder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(IndexRankListAdapter indexRankListAdapter, RecyclerView.ViewHolder viewHolder) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = viewHolder;
        }

        @Override // me.tvspark.vn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            ((ViewHolder) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).ivMask2.setBackgroundColor(i);
            ((ViewHolder) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).ivMask1.setBackground(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.parseColor("#00FFFFFF"), i}));
        }

        @Override // me.tvspark.vn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Bitmap bitmap) {
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnClickListener {
        public final /* synthetic */ IndexRankListParcel Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(IndexRankListParcel indexRankListParcel) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = indexRankListParcel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(IndexRankListAdapter.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwww.getTitleRank(), this.Wwwwwwwwwwwwwwwwwwwwwwww.getVideoList());
        }
    }

    public IndexRankListAdapter(Context context, WebSourceIndexRecData webSourceIndexRecData) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = context;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = webSourceIndexRecData;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(RecyclerView.ViewHolder viewHolder, List<VideoParcel> list) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        viewHolder2.tvTitle2.setText(list.get(1).getTitle());
        if (TextUtils.isEmpty(list.get(1).getTitle())) {
            viewHolder2.tvRate2.setVisibility(8);
        } else {
            viewHolder2.tvRate2.setText(list.get(1).getScore());
        }
        try {
            ((ViewHolder) viewHolder).rantingBar2.setStar(Float.valueOf(list.get(1).getScore()).floatValue() / 2.0f);
        } catch (Exception unused) {
            viewHolder2.rantingBar2.setStar(4.0f);
        }
        vn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, list.get(1).getCoverUrl(), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getImgRefererRank(), viewHolder2.ivGallery2, (vn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) null);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(RecyclerView.ViewHolder viewHolder, List<VideoParcel> list) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        viewHolder2.tvTitle1.setText(list.get(0).getTitle());
        if (TextUtils.isEmpty(list.get(0).getScore())) {
            viewHolder2.tvRate1.setVisibility(8);
        } else {
            viewHolder2.tvRate1.setText(list.get(0).getScore());
        }
        try {
            ((ViewHolder) viewHolder).rantingBar1.setStar(Float.valueOf(list.get(0).getScore()).floatValue() / 2.0f);
        } catch (Exception unused) {
            viewHolder2.rantingBar1.setStar(4.0f);
        }
        vn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, list.get(0).getCoverUrl(), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getImgRefererRank(), viewHolder2.ivGallery1, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, viewHolder));
        vn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, list.get(0).getCoverUrl(), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getImgRefererRank(), viewHolder2.ivBg, (vn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<IndexRankListParcel> list = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        IndexRankListParcel indexRankListParcel = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i);
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        viewHolder2.tvRankTitle.setText(indexRankListParcel.getTitleRank());
        List<VideoParcel> videoList = indexRankListParcel.getVideoList();
        if (videoList == null || videoList.isEmpty()) {
            viewHolder2.rlytRank1.setVisibility(8);
            viewHolder2.rlytRank2.setVisibility(8);
            viewHolder2.rlytRank3.setVisibility(8);
        } else if (videoList.size() == 1) {
            viewHolder2.rlytRank1.setVisibility(0);
            viewHolder2.rlytRank2.setVisibility(8);
            viewHolder2.rlytRank3.setVisibility(8);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(viewHolder, videoList);
        } else if (videoList.size() == 2) {
            viewHolder2.rlytRank1.setVisibility(0);
            viewHolder2.rlytRank2.setVisibility(0);
            viewHolder2.rlytRank3.setVisibility(8);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(viewHolder, videoList);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(viewHolder, videoList);
        } else {
            viewHolder2.rlytRank1.setVisibility(0);
            viewHolder2.rlytRank2.setVisibility(0);
            viewHolder2.rlytRank3.setVisibility(0);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(viewHolder, videoList);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(viewHolder, videoList);
            viewHolder2.tvTitle3.setText(videoList.get(2).getTitle());
            if (TextUtils.isEmpty(videoList.get(2).getTitle())) {
                viewHolder2.tvRate3.setVisibility(8);
            } else {
                viewHolder2.tvRate3.setText(videoList.get(2).getScore());
            }
            try {
                ((ViewHolder) viewHolder).rantingBar3.setStar(Float.valueOf(videoList.get(2).getScore()).floatValue() / 2.0f);
            } catch (Exception unused) {
                viewHolder2.rantingBar3.setStar(4.0f);
            }
            vn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, videoList.get(2).getCoverUrl(), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getImgRefererRank(), viewHolder2.ivGallery3, (vn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) null);
        }
        viewHolder.itemView.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(indexRankListParcel));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(this, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(viewGroup, (int) R.layout.item_video_list_rank, viewGroup, false));
    }
}
