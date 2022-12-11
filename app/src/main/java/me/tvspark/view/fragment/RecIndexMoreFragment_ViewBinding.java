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
public class RecIndexMoreFragment_ViewBinding extends RecyclerFragment_ViewBinding {
    public RecIndexMoreFragment Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    @UiThread
    public RecIndexMoreFragment_ViewBinding(RecIndexMoreFragment recIndexMoreFragment, View view) {
        super(recIndexMoreFragment, view);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = recIndexMoreFragment;
        recIndexMoreFragment.mRecyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recycler_view, "field 'mRecyclerView'", RecyclerView.class);
        recIndexMoreFragment.mRefreshLayout = (SwipeRefreshLayout) Utils.findRequiredViewAsType(view, R.id.refresh_layout, "field 'mRefreshLayout'", SwipeRefreshLayout.class);
        recIndexMoreFragment.llytError = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.llyt_error, "field 'llytError'", LinearLayout.class);
        recIndexMoreFragment.tvRetry = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_retry, "field 'tvRetry'", TextView.class);
        recIndexMoreFragment.tvGoWeb = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_go_web, "field 'tvGoWeb'", TextView.class);
    }

    @Override // me.tvspark.common.view.RecyclerFragment_ViewBinding, butterknife.Unbinder
    public void unbind() {
        RecIndexMoreFragment recIndexMoreFragment = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (recIndexMoreFragment != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            recIndexMoreFragment.mRecyclerView = null;
            recIndexMoreFragment.mRefreshLayout = null;
            recIndexMoreFragment.llytError = null;
            recIndexMoreFragment.tvRetry = null;
            recIndexMoreFragment.tvGoWeb = null;
            super.unbind();
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
