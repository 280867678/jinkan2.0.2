package me.tvspark.view.fragment;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import me.tvspark.common.view.RecyclerFragment_ViewBinding;
import white.whale.R;

/* loaded from: classes4.dex */
public class CNTVFragment_ViewBinding extends RecyclerFragment_ViewBinding {
    public View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public CNTVFragment Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends DebouncingOnClickListener {
        public final /* synthetic */ CNTVFragment Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CNTVFragment_ViewBinding cNTVFragment_ViewBinding, CNTVFragment cNTVFragment) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = cNTVFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            CNTVFragment cNTVFragment = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            if (cNTVFragment != null) {
                if (view.getId() != R.id.view_retry) {
                    return;
                }
                cNTVFragment.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true, true);
                return;
            }
            throw null;
        }
    }

    @UiThread
    public CNTVFragment_ViewBinding(CNTVFragment cNTVFragment, View view) {
        super(cNTVFragment, view);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = cNTVFragment;
        RecyclerView recyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recycler_view, "field 'rvContent'", RecyclerView.class);
        cNTVFragment.rvType = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_type, "field 'rvType'", RecyclerView.class);
        cNTVFragment.mRefreshLayout = (SwipeRefreshLayout) Utils.findRequiredViewAsType(view, R.id.refresh_layout, "field 'mRefreshLayout'", SwipeRefreshLayout.class);
        ProgressBar progressBar = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.view_progress, "field 'viewProgress'", ProgressBar.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.view_retry, "field 'viewRetry' and method 'onViewClicked'");
        LinearLayout linearLayout = (LinearLayout) Utils.castView(findRequiredView, R.id.view_retry, "field 'viewRetry'", LinearLayout.class);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = findRequiredView;
        findRequiredView.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, cNTVFragment));
        cNTVFragment.layoutIngRetry = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.layout_ing_retry, "field 'layoutIngRetry'", RelativeLayout.class);
    }

    @Override // me.tvspark.common.view.RecyclerFragment_ViewBinding, butterknife.Unbinder
    public void unbind() {
        CNTVFragment cNTVFragment = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (cNTVFragment != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            cNTVFragment.rvType = null;
            cNTVFragment.mRefreshLayout = null;
            cNTVFragment.layoutIngRetry = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setOnClickListener(null);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            super.unbind();
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
