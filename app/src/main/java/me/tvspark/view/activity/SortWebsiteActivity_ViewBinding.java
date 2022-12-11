package me.tvspark.view.activity;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import me.tvspark.widget.easytagdragview.EasyTipDragView;
import white.whale.R;

/* loaded from: classes4.dex */
public class SortWebsiteActivity_ViewBinding implements Unbinder {
    public View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public SortWebsiteActivity Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends DebouncingOnClickListener {
        public final /* synthetic */ SortWebsiteActivity Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(SortWebsiteActivity_ViewBinding sortWebsiteActivity_ViewBinding, SortWebsiteActivity sortWebsiteActivity) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = sortWebsiteActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onViewClicked(view);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends DebouncingOnClickListener {
        public final /* synthetic */ SortWebsiteActivity Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(SortWebsiteActivity_ViewBinding sortWebsiteActivity_ViewBinding, SortWebsiteActivity sortWebsiteActivity) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = sortWebsiteActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onViewClicked(view);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends DebouncingOnClickListener {
        public final /* synthetic */ SortWebsiteActivity Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(SortWebsiteActivity_ViewBinding sortWebsiteActivity_ViewBinding, SortWebsiteActivity sortWebsiteActivity) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = sortWebsiteActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onViewClicked(view);
        }
    }

    @UiThread
    public SortWebsiteActivity_ViewBinding(SortWebsiteActivity sortWebsiteActivity, View view) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = sortWebsiteActivity;
        sortWebsiteActivity.flytBanner = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.flyt_banner, "field 'flytBanner'", FrameLayout.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'ivBack' and method 'onViewClicked'");
        ImageView imageView = (ImageView) Utils.castView(findRequiredView, R.id.iv_back, "field 'ivBack'", ImageView.class);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = findRequiredView;
        findRequiredView.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, sortWebsiteActivity));
        TextView textView = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_toolbar, "field 'tvToolbar'", TextView.class);
        RelativeLayout relativeLayout = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rlyt_action_bar, "field 'rlytActionBar'", RelativeLayout.class);
        sortWebsiteActivity.dragView = (EasyTipDragView) Utils.findRequiredViewAsType(view, R.id.drag_view, "field 'dragView'", EasyTipDragView.class);
        LinearLayout linearLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.frameLayout, "field 'frameLayout'", LinearLayout.class);
        View findRequiredView2 = Utils.findRequiredView(view, R.id.tv_cancel, "field 'tvCancel' and method 'onViewClicked'");
        sortWebsiteActivity.tvCancel = (TextView) Utils.castView(findRequiredView2, R.id.tv_cancel, "field 'tvCancel'", TextView.class);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = findRequiredView2;
        findRequiredView2.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, sortWebsiteActivity));
        View findRequiredView3 = Utils.findRequiredView(view, R.id.tv_reset, "field 'tvReset' and method 'onViewClicked'");
        sortWebsiteActivity.tvReset = (TextView) Utils.castView(findRequiredView3, R.id.tv_reset, "field 'tvReset'", TextView.class);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = findRequiredView3;
        findRequiredView3.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, sortWebsiteActivity));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SortWebsiteActivity sortWebsiteActivity = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (sortWebsiteActivity != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            sortWebsiteActivity.flytBanner = null;
            sortWebsiteActivity.dragView = null;
            sortWebsiteActivity.tvCancel = null;
            sortWebsiteActivity.tvReset = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setOnClickListener(null);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setOnClickListener(null);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setOnClickListener(null);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
