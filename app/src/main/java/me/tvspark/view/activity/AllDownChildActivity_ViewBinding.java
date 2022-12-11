package me.tvspark.view.activity;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import white.whale.R;

/* loaded from: classes4.dex */
public class AllDownChildActivity_ViewBinding implements Unbinder {
    public View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public AllDownChildActivity Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends DebouncingOnClickListener {
        public final /* synthetic */ AllDownChildActivity Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AllDownChildActivity_ViewBinding allDownChildActivity_ViewBinding, AllDownChildActivity allDownChildActivity) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = allDownChildActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onViewClicked(view);
        }
    }

    @UiThread
    public AllDownChildActivity_ViewBinding(AllDownChildActivity allDownChildActivity, View view) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = allDownChildActivity;
        allDownChildActivity.rlytTopBar = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rlyt_top_bar, "field 'rlytTopBar'", RelativeLayout.class);
        allDownChildActivity.tvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'tvTitle'", TextView.class);
        allDownChildActivity.rvContent = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_content, "field 'rvContent'", RecyclerView.class);
        allDownChildActivity.flytBanner = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.flyt_banner, "field 'flytBanner'", FrameLayout.class);
        allDownChildActivity.refreshLayout = (SwipeRefreshLayout) Utils.findRequiredViewAsType(view, R.id.refresh_layout, "field 'refreshLayout'", SwipeRefreshLayout.class);
        allDownChildActivity.tvHistory = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_history, "field 'tvHistory'", TextView.class);
        allDownChildActivity.tvDlna = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_dlna, "field 'tvDlna'", TextView.class);
        allDownChildActivity.fabCast = (FloatingActionButton) Utils.findRequiredViewAsType(view, R.id.fab_cast, "field 'fabCast'", FloatingActionButton.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.iv_top_back, "method 'onViewClicked'");
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = findRequiredView;
        findRequiredView.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, allDownChildActivity));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AllDownChildActivity allDownChildActivity = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (allDownChildActivity != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            allDownChildActivity.tvTitle = null;
            allDownChildActivity.rvContent = null;
            allDownChildActivity.flytBanner = null;
            allDownChildActivity.refreshLayout = null;
            allDownChildActivity.tvHistory = null;
            allDownChildActivity.tvDlna = null;
            allDownChildActivity.fabCast = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setOnClickListener(null);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
