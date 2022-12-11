package me.tvspark.view.fragment;

import android.view.View;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.internal.Utils;
import me.tvspark.common.view.RecyclerFragment_ViewBinding;
import white.whale.R;

/* loaded from: classes4.dex */
public class SearchWebSourceSignalFragment_ViewBinding extends RecyclerFragment_ViewBinding {
    public SearchWebSourceSignalFragment Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    @UiThread
    public SearchWebSourceSignalFragment_ViewBinding(SearchWebSourceSignalFragment searchWebSourceSignalFragment, View view) {
        super(searchWebSourceSignalFragment, view);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = searchWebSourceSignalFragment;
        searchWebSourceSignalFragment.mRecyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recycler_view, "field 'mRecyclerView'", RecyclerView.class);
        searchWebSourceSignalFragment.mRefreshLayout = (SwipeRefreshLayout) Utils.findRequiredViewAsType(view, R.id.refresh_layout, "field 'mRefreshLayout'", SwipeRefreshLayout.class);
    }

    @Override // me.tvspark.common.view.RecyclerFragment_ViewBinding, butterknife.Unbinder
    public void unbind() {
        SearchWebSourceSignalFragment searchWebSourceSignalFragment = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (searchWebSourceSignalFragment != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            searchWebSourceSignalFragment.mRecyclerView = null;
            searchWebSourceSignalFragment.mRefreshLayout = null;
            super.unbind();
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
