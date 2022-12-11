package me.tvspark.view.fragment;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.androidkun.xtablayout.XTabLayout;
import white.whale.R;

/* loaded from: classes4.dex */
public class SearchWebFragment_ViewBinding implements Unbinder {
    public SearchWebFragment Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    @UiThread
    public SearchWebFragment_ViewBinding(SearchWebFragment searchWebFragment, View view) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = searchWebFragment;
        searchWebFragment.tablayout = (XTabLayout) Utils.findRequiredViewAsType(view, R.id.tablayout, "field 'tablayout'", XTabLayout.class);
        searchWebFragment.viewpager = (ViewPager) Utils.findRequiredViewAsType(view, R.id.viewpager, "field 'viewpager'", ViewPager.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SearchWebFragment searchWebFragment = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (searchWebFragment != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            searchWebFragment.tablayout = null;
            searchWebFragment.viewpager = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
