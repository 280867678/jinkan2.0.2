package me.tvspark.view.activity;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import white.whale.R;

/* loaded from: classes4.dex */
public class DelWebsiteActivity_ViewBinding implements Unbinder {
    public View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public DelWebsiteActivity Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends DebouncingOnClickListener {
        public final /* synthetic */ DelWebsiteActivity Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DelWebsiteActivity_ViewBinding delWebsiteActivity_ViewBinding, DelWebsiteActivity delWebsiteActivity) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = delWebsiteActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onViewClicked(view);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends DebouncingOnClickListener {
        public final /* synthetic */ DelWebsiteActivity Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DelWebsiteActivity_ViewBinding delWebsiteActivity_ViewBinding, DelWebsiteActivity delWebsiteActivity) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = delWebsiteActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onViewClicked(view);
        }
    }

    @UiThread
    public DelWebsiteActivity_ViewBinding(DelWebsiteActivity delWebsiteActivity, View view) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = delWebsiteActivity;
        delWebsiteActivity.flytBanner = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.flyt_banner, "field 'flytBanner'", FrameLayout.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'ivBack' and method 'onViewClicked'");
        ImageView imageView = (ImageView) Utils.castView(findRequiredView, R.id.iv_back, "field 'ivBack'", ImageView.class);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = findRequiredView;
        findRequiredView.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, delWebsiteActivity));
        TextView textView = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_toolbar, "field 'tvToolbar'", TextView.class);
        RelativeLayout relativeLayout = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rlyt_action_bar, "field 'rlytActionBar'", RelativeLayout.class);
        delWebsiteActivity.rvContent = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recycler_view, "field 'rvContent'", RecyclerView.class);
        LinearLayout linearLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.frameLayout, "field 'frameLayout'", LinearLayout.class);
        View findRequiredView2 = Utils.findRequiredView(view, R.id.tv_more, "method 'onViewClicked'");
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = findRequiredView2;
        findRequiredView2.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, delWebsiteActivity));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        DelWebsiteActivity delWebsiteActivity = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (delWebsiteActivity != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            delWebsiteActivity.flytBanner = null;
            delWebsiteActivity.rvContent = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setOnClickListener(null);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setOnClickListener(null);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
