package me.tvspark.view.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import white.whale.R;

/* loaded from: classes4.dex */
public class GActivity_ViewBinding implements Unbinder {
    public View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public GActivity Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends DebouncingOnClickListener {
        public final /* synthetic */ GActivity Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(GActivity_ViewBinding gActivity_ViewBinding, GActivity gActivity) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = gActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onViewClicked(view);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends DebouncingOnClickListener {
        public final /* synthetic */ GActivity Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(GActivity_ViewBinding gActivity_ViewBinding, GActivity gActivity) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = gActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onViewClicked(view);
        }
    }

    @UiThread
    public GActivity_ViewBinding(GActivity gActivity, View view) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = gActivity;
        gActivity.container1 = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.splash_container1, "field 'container1'", RelativeLayout.class);
        gActivity.tvVersion = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_version, "field 'tvVersion'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.iv_splash, "field 'ivSplash' and method 'onViewClicked'");
        gActivity.ivSplash = (ImageView) Utils.castView(findRequiredView, R.id.iv_splash, "field 'ivSplash'", ImageView.class);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = findRequiredView;
        findRequiredView.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, gActivity));
        View findRequiredView2 = Utils.findRequiredView(view, R.id.tv_skip_view, "field 'tvSkipView' and method 'onViewClicked'");
        gActivity.tvSkipView = (TextView) Utils.castView(findRequiredView2, R.id.tv_skip_view, "field 'tvSkipView'", TextView.class);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = findRequiredView2;
        findRequiredView2.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, gActivity));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        GActivity gActivity = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (gActivity != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            gActivity.container1 = null;
            gActivity.tvVersion = null;
            gActivity.ivSplash = null;
            gActivity.tvSkipView = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setOnClickListener(null);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setOnClickListener(null);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
