package me.tvspark.view.fragment;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import me.tvspark.widget.selectionLayout.SelectionLayout;
import white.whale.R;

/* loaded from: classes4.dex */
public class LiveFrameFragment_ViewBinding implements Unbinder {
    public View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public LiveFrameFragment Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends DebouncingOnClickListener {
        public final /* synthetic */ LiveFrameFragment Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(LiveFrameFragment_ViewBinding liveFrameFragment_ViewBinding, LiveFrameFragment liveFrameFragment) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = liveFrameFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            LiveFrameFragment liveFrameFragment = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            if (liveFrameFragment != null) {
                if (view.getId() != R.id.tv_retry) {
                    return;
                }
                liveFrameFragment.Wwwwwwwwwwwwww();
                return;
            }
            throw null;
        }
    }

    @UiThread
    public LiveFrameFragment_ViewBinding(LiveFrameFragment liveFrameFragment, View view) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = liveFrameFragment;
        liveFrameFragment.rlytTopBar = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rlyt_top_bar, "field 'rlytTopBar'", RelativeLayout.class);
        liveFrameFragment.viewpager = (ViewPager) Utils.findRequiredViewAsType(view, R.id.viewpager, "field 'viewpager'", ViewPager.class);
        liveFrameFragment.slOverall = (SelectionLayout) Utils.findRequiredViewAsType(view, R.id.slOverall, "field 'slOverall'", SelectionLayout.class);
        liveFrameFragment.llytError = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.llyt_error, "field 'llytError'", LinearLayout.class);
        liveFrameFragment.pbAll = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.pb_all, "field 'pbAll'", ProgressBar.class);
        liveFrameFragment.rvType = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_type, "field 'rvType'", RecyclerView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.tv_retry, "method 'onViewClicked'");
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = findRequiredView;
        findRequiredView.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, liveFrameFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        LiveFrameFragment liveFrameFragment = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (liveFrameFragment != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            liveFrameFragment.rlytTopBar = null;
            liveFrameFragment.viewpager = null;
            liveFrameFragment.slOverall = null;
            liveFrameFragment.llytError = null;
            liveFrameFragment.pbAll = null;
            liveFrameFragment.rvType = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setOnClickListener(null);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
