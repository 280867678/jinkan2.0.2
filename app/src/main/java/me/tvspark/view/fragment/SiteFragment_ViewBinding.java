package me.tvspark.view.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.androidkun.xtablayout.XTabLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import white.whale.R;

/* loaded from: classes4.dex */
public class SiteFragment_ViewBinding implements Unbinder {
    public View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public SiteFragment Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends DebouncingOnClickListener {
        public final /* synthetic */ SiteFragment Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(SiteFragment_ViewBinding siteFragment_ViewBinding, SiteFragment siteFragment) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = siteFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onViewClicked(view);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends DebouncingOnClickListener {
        public final /* synthetic */ SiteFragment Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(SiteFragment_ViewBinding siteFragment_ViewBinding, SiteFragment siteFragment) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = siteFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onViewClicked(view);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends DebouncingOnClickListener {
        public final /* synthetic */ SiteFragment Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(SiteFragment_ViewBinding siteFragment_ViewBinding, SiteFragment siteFragment) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = siteFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onViewClicked(view);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends DebouncingOnClickListener {
        public final /* synthetic */ SiteFragment Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(SiteFragment_ViewBinding siteFragment_ViewBinding, SiteFragment siteFragment) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = siteFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onViewClicked(view);
        }
    }

    @UiThread
    public SiteFragment_ViewBinding(SiteFragment siteFragment, View view) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = siteFragment;
        siteFragment.tablayout = (XTabLayout) Utils.findRequiredViewAsType(view, R.id.tablayout, "field 'tablayout'", XTabLayout.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.iv_sort, "field 'ivSort' and method 'onViewClicked'");
        ImageView imageView = (ImageView) Utils.castView(findRequiredView, R.id.iv_sort, "field 'ivSort'", ImageView.class);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = findRequiredView;
        findRequiredView.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, siteFragment));
        RelativeLayout relativeLayout = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rlyt_view_pager, "field 'rlytViewPager'", RelativeLayout.class);
        siteFragment.viewpager = (ViewPager) Utils.findRequiredViewAsType(view, R.id.viewpager, "field 'viewpager'", ViewPager.class);
        View findRequiredView2 = Utils.findRequiredView(view, R.id.tv_retry, "field 'tvRetry' and method 'onViewClicked'");
        TextView textView = (TextView) Utils.castView(findRequiredView2, R.id.tv_retry, "field 'tvRetry'", TextView.class);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = findRequiredView2;
        findRequiredView2.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, siteFragment));
        View findRequiredView3 = Utils.findRequiredView(view, R.id.tv_retry2, "field 'tvRetry2' and method 'onViewClicked'");
        TextView textView2 = (TextView) Utils.castView(findRequiredView3, R.id.tv_retry2, "field 'tvRetry2'", TextView.class);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = findRequiredView3;
        findRequiredView3.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, siteFragment));
        siteFragment.llytEmpty = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.llyt_empty, "field 'llytEmpty'", LinearLayout.class);
        siteFragment.pbWebsource = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.pb_websource, "field 'pbWebsource'", ProgressBar.class);
        View findRequiredView4 = Utils.findRequiredView(view, R.id.fab_add, "field 'fabAdd' and method 'onViewClicked'");
        siteFragment.fabAdd = (FloatingActionButton) Utils.castView(findRequiredView4, R.id.fab_add, "field 'fabAdd'", FloatingActionButton.class);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = findRequiredView4;
        findRequiredView4.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, siteFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SiteFragment siteFragment = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (siteFragment != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            siteFragment.tablayout = null;
            siteFragment.viewpager = null;
            siteFragment.llytEmpty = null;
            siteFragment.pbWebsource = null;
            siteFragment.fabAdd = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setOnClickListener(null);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setOnClickListener(null);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setOnClickListener(null);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setOnClickListener(null);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
