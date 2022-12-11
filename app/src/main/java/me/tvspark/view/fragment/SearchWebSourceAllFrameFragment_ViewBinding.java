package me.tvspark.view.fragment;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import white.whale.R;

/* loaded from: classes4.dex */
public class SearchWebSourceAllFrameFragment_ViewBinding implements Unbinder {
    public View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public SearchWebSourceAllFrameFragment Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends DebouncingOnClickListener {
        public final /* synthetic */ SearchWebSourceAllFrameFragment Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(SearchWebSourceAllFrameFragment_ViewBinding searchWebSourceAllFrameFragment_ViewBinding, SearchWebSourceAllFrameFragment searchWebSourceAllFrameFragment) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = searchWebSourceAllFrameFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onViewClicked(view);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends DebouncingOnClickListener {
        public final /* synthetic */ SearchWebSourceAllFrameFragment Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(SearchWebSourceAllFrameFragment_ViewBinding searchWebSourceAllFrameFragment_ViewBinding, SearchWebSourceAllFrameFragment searchWebSourceAllFrameFragment) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = searchWebSourceAllFrameFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onViewClicked(view);
        }
    }

    @UiThread
    public SearchWebSourceAllFrameFragment_ViewBinding(SearchWebSourceAllFrameFragment searchWebSourceAllFrameFragment, View view) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = searchWebSourceAllFrameFragment;
        searchWebSourceAllFrameFragment.tvSearchStatus = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_search_status, "field 'tvSearchStatus'", TextView.class);
        searchWebSourceAllFrameFragment.pBar = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.pbar, "field 'pBar'", ProgressBar.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.tv_official, "field 'tvOfficial' and method 'onViewClicked'");
        searchWebSourceAllFrameFragment.tvOfficial = (TextView) Utils.castView(findRequiredView, R.id.tv_official, "field 'tvOfficial'", TextView.class);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = findRequiredView;
        findRequiredView.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, searchWebSourceAllFrameFragment));
        View findRequiredView2 = Utils.findRequiredView(view, R.id.tv_custom, "field 'tvCustom' and method 'onViewClicked'");
        searchWebSourceAllFrameFragment.tvCustom = (TextView) Utils.castView(findRequiredView2, R.id.tv_custom, "field 'tvCustom'", TextView.class);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = findRequiredView2;
        findRequiredView2.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, searchWebSourceAllFrameFragment));
        searchWebSourceAllFrameFragment.flytBanner = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.flyt_banner, "field 'flytBanner'", FrameLayout.class);
        searchWebSourceAllFrameFragment.viewpager = (ViewPager) Utils.findRequiredViewAsType(view, R.id.viewpager, "field 'viewpager'", ViewPager.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SearchWebSourceAllFrameFragment searchWebSourceAllFrameFragment = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (searchWebSourceAllFrameFragment != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            searchWebSourceAllFrameFragment.tvSearchStatus = null;
            searchWebSourceAllFrameFragment.pBar = null;
            searchWebSourceAllFrameFragment.tvOfficial = null;
            searchWebSourceAllFrameFragment.tvCustom = null;
            searchWebSourceAllFrameFragment.flytBanner = null;
            searchWebSourceAllFrameFragment.viewpager = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setOnClickListener(null);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setOnClickListener(null);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
