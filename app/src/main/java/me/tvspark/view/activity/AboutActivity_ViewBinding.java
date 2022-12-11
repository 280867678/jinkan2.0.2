package me.tvspark.view.activity;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import white.whale.R;

/* loaded from: classes4.dex */
public class AboutActivity_ViewBinding implements Unbinder {
    public AboutActivity Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    @UiThread
    public AboutActivity_ViewBinding(AboutActivity aboutActivity, View view) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = aboutActivity;
        aboutActivity.toolbar = (Toolbar) Utils.findRequiredViewAsType(view, R.id.toolbar, "field 'toolbar'", Toolbar.class);
        aboutActivity.collapsingToolbar = (CollapsingToolbarLayout) Utils.findRequiredViewAsType(view, R.id.collapsing_toolbar, "field 'collapsingToolbar'", CollapsingToolbarLayout.class);
        AppBarLayout appBarLayout = (AppBarLayout) Utils.findRequiredViewAsType(view, R.id.app_bar, "field 'appBar'", AppBarLayout.class);
        aboutActivity.tvVersion = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_version, "field 'tvVersion'", TextView.class);
        aboutActivity.tvEmail = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_email, "field 'tvEmail'", TextView.class);
        TextView textView = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_mianze, "field 'tvMianze'", TextView.class);
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) Utils.findRequiredViewAsType(view, R.id.frameLayout, "field 'frameLayout'", CoordinatorLayout.class);
        aboutActivity.tvGod = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_god, "field 'tvGod'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AboutActivity aboutActivity = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (aboutActivity != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            aboutActivity.toolbar = null;
            aboutActivity.collapsingToolbar = null;
            aboutActivity.tvVersion = null;
            aboutActivity.tvEmail = null;
            aboutActivity.tvGod = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
