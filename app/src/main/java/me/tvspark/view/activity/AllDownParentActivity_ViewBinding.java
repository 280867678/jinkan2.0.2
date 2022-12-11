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
import me.tvspark.widget.selectionLayout.SelectionLayout;
import white.whale.R;

/* loaded from: classes4.dex */
public class AllDownParentActivity_ViewBinding implements Unbinder {
    public View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public AllDownParentActivity Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends DebouncingOnClickListener {
        public final /* synthetic */ AllDownParentActivity Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AllDownParentActivity_ViewBinding allDownParentActivity_ViewBinding, AllDownParentActivity allDownParentActivity) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = allDownParentActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onViewClicked(view);
        }
    }

    @UiThread
    public AllDownParentActivity_ViewBinding(AllDownParentActivity allDownParentActivity, View view) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = allDownParentActivity;
        allDownParentActivity.rlytTopBar = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rlyt_top_bar, "field 'rlytTopBar'", RelativeLayout.class);
        allDownParentActivity.tvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'tvTitle'", TextView.class);
        allDownParentActivity.rvContent = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_content, "field 'rvContent'", RecyclerView.class);
        allDownParentActivity.flytBanner = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.flyt_banner, "field 'flytBanner'", FrameLayout.class);
        allDownParentActivity.refreshLayout = (SwipeRefreshLayout) Utils.findRequiredViewAsType(view, R.id.refresh_layout, "field 'refreshLayout'", SwipeRefreshLayout.class);
        allDownParentActivity.slOverall = (SelectionLayout) Utils.findRequiredViewAsType(view, R.id.slOverall, "field 'slOverall'", SelectionLayout.class);
        allDownParentActivity.ibtnAdd = (FloatingActionButton) Utils.findRequiredViewAsType(view, R.id.fab_add, "field 'ibtnAdd'", FloatingActionButton.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.iv_top_back, "method 'onViewClicked'");
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = findRequiredView;
        findRequiredView.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, allDownParentActivity));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AllDownParentActivity allDownParentActivity = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (allDownParentActivity != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            allDownParentActivity.tvTitle = null;
            allDownParentActivity.rvContent = null;
            allDownParentActivity.flytBanner = null;
            allDownParentActivity.refreshLayout = null;
            allDownParentActivity.slOverall = null;
            allDownParentActivity.ibtnAdd = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setOnClickListener(null);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
