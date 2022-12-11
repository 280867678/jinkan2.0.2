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
public class RecIndexMoreActivity_ViewBinding implements Unbinder {
    public View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public RecIndexMoreActivity Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends DebouncingOnClickListener {
        public final /* synthetic */ RecIndexMoreActivity Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(RecIndexMoreActivity_ViewBinding recIndexMoreActivity_ViewBinding, RecIndexMoreActivity recIndexMoreActivity) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = recIndexMoreActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onViewClicked(view);
        }
    }

    @UiThread
    public RecIndexMoreActivity_ViewBinding(RecIndexMoreActivity recIndexMoreActivity, View view) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = recIndexMoreActivity;
        View findRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'ivBack' and method 'onViewClicked'");
        recIndexMoreActivity.ivBack = (ImageView) Utils.castView(findRequiredView, R.id.iv_back, "field 'ivBack'", ImageView.class);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = findRequiredView;
        findRequiredView.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, recIndexMoreActivity));
        recIndexMoreActivity.tvToolbar = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_toolbar, "field 'tvToolbar'", TextView.class);
        RelativeLayout relativeLayout = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rlyt_action_bar, "field 'rlytActionBar'", RelativeLayout.class);
        recIndexMoreActivity.tablayout = (XTabLayout) Utils.findRequiredViewAsType(view, R.id.tablayout, "field 'tablayout'", XTabLayout.class);
        Utils.findRequiredView(view, R.id.view_line_tab, "field 'viewLineTab'");
        recIndexMoreActivity.viewpager = (ViewPager) Utils.findRequiredViewAsType(view, R.id.viewpager, "field 'viewpager'", ViewPager.class);
        RelativeLayout relativeLayout2 = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rlyt_view_pager, "field 'rlytViewPager'", RelativeLayout.class);
        recIndexMoreActivity.flytBanner = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.flyt_banner, "field 'flytBanner'", FrameLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        RecIndexMoreActivity recIndexMoreActivity = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (recIndexMoreActivity != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            recIndexMoreActivity.tvToolbar = null;
            recIndexMoreActivity.tablayout = null;
            recIndexMoreActivity.viewpager = null;
            recIndexMoreActivity.flytBanner = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setOnClickListener(null);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
