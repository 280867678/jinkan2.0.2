package me.tvspark.view.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import me.tvspark.widget.RoundImageView;
import white.whale.R;

/* loaded from: classes4.dex */
public class RankListActivity_ViewBinding implements Unbinder {
    public RankListActivity Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    @UiThread
    public RankListActivity_ViewBinding(RankListActivity rankListActivity, View view) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = rankListActivity;
        rankListActivity.ivCoverBg = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_cover_bg, "field 'ivCoverBg'", ImageView.class);
        rankListActivity.ivCoverMask = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_cover_mask, "field 'ivCoverMask'", ImageView.class);
        rankListActivity.tvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'tvTitle'", TextView.class);
        rankListActivity.tvHot = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_hot, "field 'tvHot'", TextView.class);
        rankListActivity.toolbar = (Toolbar) Utils.findRequiredViewAsType(view, R.id.toolbar, "field 'toolbar'", Toolbar.class);
        rankListActivity.collapsingToolbar = (CollapsingToolbarLayout) Utils.findRequiredViewAsType(view, R.id.collapsing_toolbar, "field 'collapsingToolbar'", CollapsingToolbarLayout.class);
        rankListActivity.appBar = (AppBarLayout) Utils.findRequiredViewAsType(view, R.id.app_bar, "field 'appBar'", AppBarLayout.class);
        rankListActivity.recyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recycler_view, "field 'recyclerView'", RecyclerView.class);
        rankListActivity.ivColor = (RoundImageView) Utils.findRequiredViewAsType(view, R.id.iv_color, "field 'ivColor'", RoundImageView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        RankListActivity rankListActivity = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (rankListActivity != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            rankListActivity.ivCoverBg = null;
            rankListActivity.ivCoverMask = null;
            rankListActivity.tvTitle = null;
            rankListActivity.tvHot = null;
            rankListActivity.toolbar = null;
            rankListActivity.collapsingToolbar = null;
            rankListActivity.appBar = null;
            rankListActivity.recyclerView = null;
            rankListActivity.ivColor = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
