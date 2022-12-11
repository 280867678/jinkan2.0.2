package me.tvspark.view.fragment;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.zhy.view.flowlayout.TagFlowLayout;
import white.whale.R;

/* loaded from: classes4.dex */
public class SearchHistoryFragment_ViewBinding implements Unbinder {
    public SearchHistoryFragment Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    @UiThread
    public SearchHistoryFragment_ViewBinding(SearchHistoryFragment searchHistoryFragment, View view) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = searchHistoryFragment;
        searchHistoryFragment.tags = (TagFlowLayout) Utils.findRequiredViewAsType(view, R.id.tags, "field 'tags'", TagFlowLayout.class);
        searchHistoryFragment.ivDel = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_del, "field 'ivDel'", ImageView.class);
        searchHistoryFragment.flytBanner = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.flyt_banner, "field 'flytBanner'", FrameLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SearchHistoryFragment searchHistoryFragment = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (searchHistoryFragment != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            searchHistoryFragment.tags = null;
            searchHistoryFragment.ivDel = null;
            searchHistoryFragment.flytBanner = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
