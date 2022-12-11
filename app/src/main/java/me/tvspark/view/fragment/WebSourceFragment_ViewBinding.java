package me.tvspark.view.fragment;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.androidkun.xtablayout.XTabLayout;
import java.util.List;
import me.tvspark.data.sql.WebSourceIndexData;
import me.tvspark.eo0;
import me.tvspark.mn0;
import white.whale.R;

/* loaded from: classes4.dex */
public class WebSourceFragment_ViewBinding implements Unbinder {
    public View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public WebSourceFragment Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends DebouncingOnClickListener {
        public final /* synthetic */ WebSourceFragment Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(WebSourceFragment_ViewBinding webSourceFragment_ViewBinding, WebSourceFragment webSourceFragment) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = webSourceFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            WebSourceFragment webSourceFragment = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            if (webSourceFragment != null) {
                if (view.getId() != R.id.rlyt_search || webSourceFragment.Wwwwwwwwwwwwwwww.get(webSourceFragment.Wwwwwwwwwwwwww) == null || !(webSourceFragment.Wwwwwwwwwwwwwwww.get(webSourceFragment.Wwwwwwwwwwwwww) instanceof SiteFragment)) {
                    return;
                }
                SiteFragment siteFragment = (SiteFragment) webSourceFragment.Wwwwwwwwwwwwwwww.get(webSourceFragment.Wwwwwwwwwwwwww);
                List<WebSourceIndexData> list = siteFragment.Wwwwwwwwwwwww;
                if (list == null || siteFragment.Wwwwwwwwwww >= list.size()) {
                    eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(siteFragment.Wwwwwwwwwwwwwwwwwwwwwww, "站源获取失败");
                    return;
                } else {
                    mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(siteFragment.Wwwwwwwwwwwwwwwwwwwwwww, "", siteFragment.Wwwwwwwwwwwww.get(siteFragment.Wwwwwwwwwww));
                    return;
                }
            }
            throw null;
        }
    }

    @UiThread
    public WebSourceFragment_ViewBinding(WebSourceFragment webSourceFragment, View view) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = webSourceFragment;
        View findRequiredView = Utils.findRequiredView(view, R.id.rlyt_search, "field 'rlytSearch' and method 'onViewClicked'");
        webSourceFragment.rlytSearch = (RelativeLayout) Utils.castView(findRequiredView, R.id.rlyt_search, "field 'rlytSearch'", RelativeLayout.class);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = findRequiredView;
        findRequiredView.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, webSourceFragment));
        webSourceFragment.tablayout = (XTabLayout) Utils.findRequiredViewAsType(view, R.id.tablayout, "field 'tablayout'", XTabLayout.class);
        webSourceFragment.viewpager = (ViewPager) Utils.findRequiredViewAsType(view, R.id.viewpager, "field 'viewpager'", ViewPager.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        WebSourceFragment webSourceFragment = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (webSourceFragment != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            webSourceFragment.tablayout = null;
            webSourceFragment.viewpager = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setOnClickListener(null);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
