package me.tvspark.adapter;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
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
import me.tvspark.ApplicationC1880C;
import me.tvspark.bo0;
import me.tvspark.data.bean.VideoParcel;
import me.tvspark.mn0;
import me.tvspark.outline;
import me.tvspark.r40;
import me.tvspark.sk0;
import me.tvspark.vn0;
import me.tvspark.widget.RoundImageView;
import me.tvspark.xt0;
import white.whale.R;

/* loaded from: classes4.dex */
public class RankListDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements sk0 {
    public xt0 Wwwwwwwwwwwwwwwwwwww;
    public Context Wwwwwwwwwwwwwwwwwwwwwwww;
    public List<VideoParcel> Wwwwwwwwwwwwwwwwwwwwwww = new ArrayList();
    public int Wwwwwwwwwwwwwwwwwwwwww = 1;
    public int Wwwwwwwwwwwwwwwwwwwww = 0;

    /* loaded from: classes4.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_cover)
        public RoundImageView ivCover;
        @BindView(R.id.llyt_comment)
        public LinearLayout llytComment;
        @BindView(R.id.llyt_douban)
        public LinearLayout llytDouban;
        @BindView(R.id.ratingBar)
        public RatingBar ratingBar;
        @BindView(R.id.tv_info)
        public TextView tvInfo;
        @BindView(R.id.tv_rank_num)
        public TextView tvRankNum;
        @BindView(R.id.tv_rate)
        public TextView tvRate;
        @BindView(R.id.tv_title)
        public TextView tvTitle;
        @BindView(R.id.tv_comment)
        public TextView tv_comment;

        public ViewHolder(RankListDetailAdapter rankListDetailAdapter, View view) {
            super(view);
            ButterKnife.bind(this, view);
            this.ivCover.setRectAdius(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3));
        }
    }

    /* loaded from: classes4.dex */
    public class ViewHolderAD extends RecyclerView.ViewHolder {
        @BindView(R.id.flyt_ad)
        public FrameLayout flytAD;

        public ViewHolderAD(RankListDetailAdapter rankListDetailAdapter, View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    /* loaded from: classes4.dex */
    public class ViewHolderAD_ViewBinding implements Unbinder {
        public ViewHolderAD Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        @UiThread
        public ViewHolderAD_ViewBinding(ViewHolderAD viewHolderAD, View view) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = viewHolderAD;
            viewHolderAD.flytAD = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.flyt_ad, "field 'flytAD'", FrameLayout.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ViewHolderAD viewHolderAD = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (viewHolderAD != null) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                viewHolderAD.flytAD = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: classes4.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        public ViewHolder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = viewHolder;
            viewHolder.ivCover = (RoundImageView) Utils.findRequiredViewAsType(view, R.id.iv_cover, "field 'ivCover'", RoundImageView.class);
            viewHolder.tvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'tvTitle'", TextView.class);
            viewHolder.tvInfo = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_info, "field 'tvInfo'", TextView.class);
            viewHolder.tv_comment = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_comment, "field 'tv_comment'", TextView.class);
            viewHolder.ratingBar = (RatingBar) Utils.findRequiredViewAsType(view, R.id.ratingBar, "field 'ratingBar'", RatingBar.class);
            viewHolder.tvRate = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_rate, "field 'tvRate'", TextView.class);
            viewHolder.llytComment = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.llyt_comment, "field 'llytComment'", LinearLayout.class);
            viewHolder.llytDouban = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.llyt_douban, "field 'llytDouban'", LinearLayout.class);
            viewHolder.tvRankNum = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_rank_num, "field 'tvRankNum'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ViewHolder viewHolder = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (viewHolder != null) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                viewHolder.ivCover = null;
                viewHolder.tvTitle = null;
                viewHolder.tvInfo = null;
                viewHolder.tv_comment = null;
                viewHolder.ratingBar = null;
                viewHolder.tvRate = null;
                viewHolder.llytComment = null;
                viewHolder.llytDouban = null;
                viewHolder.tvRankNum = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnClickListener {
        public final /* synthetic */ VideoParcel Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(VideoParcel videoParcel) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = videoParcel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(RankListDetailAdapter.this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwww.getTitle());
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
            mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(RankListDetailAdapter.this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwww.getTitle());
        }
    }

    public RankListDetailAdapter(Activity activity, List<VideoParcel> list) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = activity;
        if (list != null && !list.isEmpty()) {
            this.Wwwwwwwwwwwwwwwwwwwwwww.addAll(list);
        }
        bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("ad_type");
        if (!ApplicationC1880C.Wwwwwwwww) {
            xt0 xt0Var = new xt0(activity);
            this.Wwwwwwwwwwwwwwwwwwww = xt0Var;
            xt0Var.Wwwwwwwwwwwwwwwwwwwwwwww = "8091823043098355";
            xt0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, RankListDetailAdapter.class.getSimpleName());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<VideoParcel> list = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (list == null || list.isEmpty()) {
            return 0;
        }
        return this.Wwwwwwwwwwwwwwwwwwwwwww.size() + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return i == 0 ? this.Wwwwwwwwwwwwwwwwwwwww : this.Wwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        if (getItemViewType(i) == this.Wwwwwwwwwwwwwwwwwwwww) {
            try {
                if (this.Wwwwwwwwwwwwwwwwwwww == null) {
                    return;
                }
                if (((ViewHolderAD) viewHolder).flytAD.getChildCount() > 0 && ((ViewHolderAD) viewHolder).flytAD.getChildAt(0) == this.Wwwwwwwwwwwwwwwwwwww) {
                    return;
                }
                if (((ViewHolderAD) viewHolder).flytAD.getChildCount() > 0) {
                    ((ViewHolderAD) viewHolder).flytAD.removeAllViews();
                }
                if (this.Wwwwwwwwwwwwwwwwwwww.getParent() != null) {
                    ((ViewGroup) this.Wwwwwwwwwwwwwwwwwwww.getParent()).removeView(this.Wwwwwwwwwwwwwwwwwwww);
                }
                ((ViewHolderAD) viewHolder).flytAD.addView(this.Wwwwwwwwwwwwwwwwwwww);
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        VideoParcel videoParcel = this.Wwwwwwwwwwwwwwwwwwwwwww.get(i - 1);
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        viewHolder2.tvTitle.setText(videoParcel.getTitle());
        viewHolder2.tvInfo.setText(videoParcel.getActor());
        if (TextUtils.isEmpty(videoParcel.getDesc())) {
            viewHolder2.llytComment.setVisibility(8);
        } else {
            viewHolder2.llytComment.setVisibility(0);
            viewHolder2.tv_comment.setText(videoParcel.getDesc());
        }
        TextView textView = viewHolder2.tvRankNum;
        textView.setText(i + "");
        viewHolder2.tvRate.setText(videoParcel.getScore());
        try {
            if (!TextUtils.isEmpty(videoParcel.getScore())) {
                ((ViewHolder) viewHolder).ratingBar.setStar(Float.valueOf(videoParcel.getScore()).floatValue() / 2.0f);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            viewHolder2.ratingBar.setStar(4.0f);
        }
        vn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, videoParcel.getCoverUrl(), viewHolder2.ivCover, "");
        viewHolder.itemView.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(videoParcel));
        ((ViewHolder) viewHolder).llytDouban.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(videoParcel));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return i == this.Wwwwwwwwwwwwwwwwwwwww ? new ViewHolderAD(this, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(viewGroup, (int) R.layout.item_rank_list_detail_ad, viewGroup, false)) : new ViewHolder(this, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(viewGroup, (int) R.layout.item_rank_list_detail_list, viewGroup, false));
    }
}
