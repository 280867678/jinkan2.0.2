package me.tvspark.view.fragment;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import white.whale.R;

/* loaded from: classes4.dex */
public class WebSoFragment_ViewBinding implements Unbinder {
    public WebSoFragment Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    @UiThread
    public WebSoFragment_ViewBinding(WebSoFragment webSoFragment, View view) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = webSoFragment;
        webSoFragment.llytRoot = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.llyt_root, "field 'llytRoot'", LinearLayout.class);
        webSoFragment.mRefreshLayout = (SwipeRefreshLayout) Utils.findRequiredViewAsType(view, R.id.swipe_refresh, "field 'mRefreshLayout'", SwipeRefreshLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        WebSoFragment webSoFragment = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (webSoFragment != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            webSoFragment.llytRoot = null;
            webSoFragment.mRefreshLayout = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
