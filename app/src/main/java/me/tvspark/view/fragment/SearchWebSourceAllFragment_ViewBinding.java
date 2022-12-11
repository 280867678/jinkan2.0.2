package me.tvspark.view.fragment;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import white.whale.R;

/* loaded from: classes4.dex */
public class SearchWebSourceAllFragment_ViewBinding implements Unbinder {
    public SearchWebSourceAllFragment Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    @UiThread
    public SearchWebSourceAllFragment_ViewBinding(SearchWebSourceAllFragment searchWebSourceAllFragment, View view) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = searchWebSourceAllFragment;
        searchWebSourceAllFragment.viewProgress = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.view_progress, "field 'viewProgress'", ProgressBar.class);
        searchWebSourceAllFragment.viewRetry = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.view_retry, "field 'viewRetry'", LinearLayout.class);
        searchWebSourceAllFragment.layoutIngRetry = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.layout_ing_retry, "field 'layoutIngRetry'", RelativeLayout.class);
        searchWebSourceAllFragment.tvRetry = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_retry, "field 'tvRetry'", TextView.class);
        searchWebSourceAllFragment.tvRetry2 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_retry2, "field 'tvRetry2'", TextView.class);
        searchWebSourceAllFragment.rvChannel = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_channel, "field 'rvChannel'", RecyclerView.class);
        searchWebSourceAllFragment.rvEpisode = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_episode, "field 'rvEpisode'", RecyclerView.class);
        searchWebSourceAllFragment.llytAll = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.llyt_all, "field 'llytAll'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SearchWebSourceAllFragment searchWebSourceAllFragment = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (searchWebSourceAllFragment != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            searchWebSourceAllFragment.viewRetry = null;
            searchWebSourceAllFragment.layoutIngRetry = null;
            searchWebSourceAllFragment.tvRetry = null;
            searchWebSourceAllFragment.tvRetry2 = null;
            searchWebSourceAllFragment.rvChannel = null;
            searchWebSourceAllFragment.rvEpisode = null;
            searchWebSourceAllFragment.llytAll = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
