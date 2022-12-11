package me.tvspark.view.activity;

import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import me.tvspark.widget.NoScrollViewPager;
import white.whale.R;

/* loaded from: classes4.dex */
public class HomeActivity_ViewBinding implements Unbinder {
    public HomeActivity Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    @UiThread
    public HomeActivity_ViewBinding(HomeActivity homeActivity, View view) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = homeActivity;
        homeActivity.rbHome = (RadioButton) Utils.findRequiredViewAsType(view, R.id.rb_home, "field 'rbHome'", RadioButton.class);
        homeActivity.rbWebSource = (RadioButton) Utils.findRequiredViewAsType(view, R.id.rb_webSource, "field 'rbWebSource'", RadioButton.class);
        homeActivity.rbCategory = (RadioButton) Utils.findRequiredViewAsType(view, R.id.rb_category, "field 'rbCategory'", RadioButton.class);
        homeActivity.rbMe = (RadioButton) Utils.findRequiredViewAsType(view, R.id.rb_me, "field 'rbMe'", RadioButton.class);
        homeActivity.mViewPager = (NoScrollViewPager) Utils.findRequiredViewAsType(view, R.id.view_pager_main, "field 'mViewPager'", NoScrollViewPager.class);
        homeActivity.radioGroup = (RadioGroup) Utils.findRequiredViewAsType(view, R.id.rg_bottom, "field 'radioGroup'", RadioGroup.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        HomeActivity homeActivity = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (homeActivity != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            homeActivity.rbHome = null;
            homeActivity.rbWebSource = null;
            homeActivity.rbCategory = null;
            homeActivity.rbMe = null;
            homeActivity.mViewPager = null;
            homeActivity.radioGroup = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
