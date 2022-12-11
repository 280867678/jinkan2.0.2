package me.tvspark.common.view;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import white.whale.R;

/* loaded from: classes4.dex */
public class RecyclerFragment_ViewBinding implements Unbinder {
    public RecyclerFragment Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    @UiThread
    public RecyclerFragment_ViewBinding(RecyclerFragment recyclerFragment, View view) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = recyclerFragment;
        recyclerFragment.mRecyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recycler_view, "field 'mRecyclerView'", RecyclerView.class);
        recyclerFragment.mRefreshLayout = (SwipeRefreshLayout) Utils.findRequiredViewAsType(view, R.id.refresh_layout, "field 'mRefreshLayout'", SwipeRefreshLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        RecyclerFragment recyclerFragment = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (recyclerFragment != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            recyclerFragment.mRecyclerView = null;
            recyclerFragment.mRefreshLayout = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
