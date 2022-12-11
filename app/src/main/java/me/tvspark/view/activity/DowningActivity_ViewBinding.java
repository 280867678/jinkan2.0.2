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
public class DowningActivity_ViewBinding implements Unbinder {
    public View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public DowningActivity Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends DebouncingOnClickListener {
        public final /* synthetic */ DowningActivity Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DowningActivity_ViewBinding downingActivity_ViewBinding, DowningActivity downingActivity) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = downingActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onViewClicked(view);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends DebouncingOnClickListener {
        public final /* synthetic */ DowningActivity Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DowningActivity_ViewBinding downingActivity_ViewBinding, DowningActivity downingActivity) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = downingActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onViewClicked(view);
        }
    }

    @UiThread
    public DowningActivity_ViewBinding(DowningActivity downingActivity, View view) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = downingActivity;
        downingActivity.rlytTopBar = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rlyt_top_bar, "field 'rlytTopBar'", RelativeLayout.class);
        downingActivity.tvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'tvTitle'", TextView.class);
        downingActivity.rvContent = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_content, "field 'rvContent'", RecyclerView.class);
        downingActivity.flytBanner = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.flyt_banner, "field 'flytBanner'", FrameLayout.class);
        downingActivity.llytEmpty = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.llyt_empty, "field 'llytEmpty'", LinearLayout.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.img_add_more, "field 'imgAddMore' and method 'onViewClicked'");
        ImageView imageView = (ImageView) Utils.castView(findRequiredView, R.id.img_add_more, "field 'imgAddMore'", ImageView.class);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = findRequiredView;
        findRequiredView.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, downingActivity));
        View findRequiredView2 = Utils.findRequiredView(view, R.id.iv_top_back, "method 'onViewClicked'");
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = findRequiredView2;
        findRequiredView2.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, downingActivity));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        DowningActivity downingActivity = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (downingActivity != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            downingActivity.tvTitle = null;
            downingActivity.rvContent = null;
            downingActivity.flytBanner = null;
            downingActivity.llytEmpty = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setOnClickListener(null);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setOnClickListener(null);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
