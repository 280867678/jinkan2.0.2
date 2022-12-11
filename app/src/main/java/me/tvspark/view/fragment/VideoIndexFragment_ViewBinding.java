package me.tvspark.view.fragment;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.internal.Utils;
import me.tvspark.common.view.RecyclerFragment_ViewBinding;
import white.whale.R;

/* loaded from: classes4.dex */
public class VideoIndexFragment_ViewBinding extends RecyclerFragment_ViewBinding {
    public VideoIndexFragment Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    @UiThread
    public VideoIndexFragment_ViewBinding(VideoIndexFragment videoIndexFragment, View view) {
        super(videoIndexFragment, view);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = videoIndexFragment;
        videoIndexFragment.mRecyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recycler_view, "field 'mRecyclerView'", RecyclerView.class);
        videoIndexFragment.mRefreshLayout = (SwipeRefreshLayout) Utils.findRequiredViewAsType(view, R.id.refresh_layout, "field 'mRefreshLayout'", SwipeRefreshLayout.class);
        videoIndexFragment.llytError = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.llyt_error, "field 'llytError'", LinearLayout.class);
        videoIndexFragment.tvRetry = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_retry, "field 'tvRetry'", TextView.class);
        videoIndexFragment.tvGoWeb = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_go_web, "field 'tvGoWeb'", TextView.class);
    }

    @Override // me.tvspark.common.view.RecyclerFragment_ViewBinding, butterknife.Unbinder
    public void unbind() {
        VideoIndexFragment videoIndexFragment = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (videoIndexFragment != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            videoIndexFragment.mRecyclerView = null;
            videoIndexFragment.mRefreshLayout = null;
            videoIndexFragment.llytError = null;
            videoIndexFragment.tvRetry = null;
            videoIndexFragment.tvGoWeb = null;
            super.unbind();
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
