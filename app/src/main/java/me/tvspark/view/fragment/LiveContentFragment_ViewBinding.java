package me.tvspark.view.fragment;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import white.whale.R;

/* loaded from: classes4.dex */
public class LiveContentFragment_ViewBinding implements Unbinder {
    public View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public LiveContentFragment Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends DebouncingOnClickListener {
        public final /* synthetic */ LiveContentFragment Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(LiveContentFragment_ViewBinding liveContentFragment_ViewBinding, LiveContentFragment liveContentFragment) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = liveContentFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onViewClicked(view);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends DebouncingOnClickListener {
        public final /* synthetic */ LiveContentFragment Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(LiveContentFragment_ViewBinding liveContentFragment_ViewBinding, LiveContentFragment liveContentFragment) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = liveContentFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onViewClicked(view);
        }
    }

    @UiThread
    public LiveContentFragment_ViewBinding(LiveContentFragment liveContentFragment, View view) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = liveContentFragment;
        liveContentFragment.rvChannel = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_channel, "field 'rvChannel'", RecyclerView.class);
        liveContentFragment.rvEpisode = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_episode, "field 'rvEpisode'", RecyclerView.class);
        liveContentFragment.llytAll = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.llyt_all, "field 'llytAll'", LinearLayout.class);
        liveContentFragment.pbAll = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.pb_all, "field 'pbAll'", ProgressBar.class);
        liveContentFragment.pbRight = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.pb_right, "field 'pbRight'", ProgressBar.class);
        liveContentFragment.llytError = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.llyt_error, "field 'llytError'", LinearLayout.class);
        liveContentFragment.llytRightRetry = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.llyt_right_retry, "field 'llytRightRetry'", LinearLayout.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.tv_right_retry, "method 'onViewClicked'");
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = findRequiredView;
        findRequiredView.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, liveContentFragment));
        View findRequiredView2 = Utils.findRequiredView(view, R.id.tv_retry, "method 'onViewClicked'");
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = findRequiredView2;
        findRequiredView2.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, liveContentFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        LiveContentFragment liveContentFragment = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (liveContentFragment != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            liveContentFragment.rvChannel = null;
            liveContentFragment.rvEpisode = null;
            liveContentFragment.llytAll = null;
            liveContentFragment.pbAll = null;
            liveContentFragment.pbRight = null;
            liveContentFragment.llytError = null;
            liveContentFragment.llytRightRetry = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setOnClickListener(null);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setOnClickListener(null);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
