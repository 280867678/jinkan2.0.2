package me.tvspark.view.activity;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.androidkun.xtablayout.XTabLayout;
import white.whale.R;

/* loaded from: classes4.dex */
public class CollectActivity_ViewBinding implements Unbinder {
    public View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public CollectActivity Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends DebouncingOnClickListener {
        public final /* synthetic */ CollectActivity Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CollectActivity_ViewBinding collectActivity_ViewBinding, CollectActivity collectActivity) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = collectActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onViewClicked(view);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends DebouncingOnClickListener {
        public final /* synthetic */ CollectActivity Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CollectActivity_ViewBinding collectActivity_ViewBinding, CollectActivity collectActivity) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = collectActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onViewClicked(view);
        }
    }

    @UiThread
    public CollectActivity_ViewBinding(CollectActivity collectActivity, View view) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = collectActivity;
        collectActivity.rlytTopBar = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rlyt_action_bar, "field 'rlytTopBar'", RelativeLayout.class);
        collectActivity.flytBanner = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.flyt_banner, "field 'flytBanner'", FrameLayout.class);
        collectActivity.tabLayout = (XTabLayout) Utils.findRequiredViewAsType(view, R.id.tablayout, "field 'tabLayout'", XTabLayout.class);
        collectActivity.viewPager = (ViewPager) Utils.findRequiredViewAsType(view, R.id.viewpager, "field 'viewPager'", ViewPager.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.iv_top_back, "field 'ivTopBack' and method 'onViewClicked'");
        ImageView imageView = (ImageView) Utils.castView(findRequiredView, R.id.iv_top_back, "field 'ivTopBack'", ImageView.class);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = findRequiredView;
        findRequiredView.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, collectActivity));
        collectActivity.tvToolbar = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_toolbar, "field 'tvToolbar'", TextView.class);
        View findRequiredView2 = Utils.findRequiredView(view, R.id.fab_del, "method 'onViewClicked'");
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = findRequiredView2;
        findRequiredView2.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, collectActivity));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CollectActivity collectActivity = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (collectActivity != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            collectActivity.flytBanner = null;
            collectActivity.tabLayout = null;
            collectActivity.viewPager = null;
            collectActivity.tvToolbar = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setOnClickListener(null);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setOnClickListener(null);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
