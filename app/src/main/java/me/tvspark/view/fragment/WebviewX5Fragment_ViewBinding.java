package me.tvspark.view.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.tencent.smtt.sdk.WebView;
import white.whale.R;

/* loaded from: classes4.dex */
public class WebviewX5Fragment_ViewBinding implements Unbinder {
    public View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public WebviewX5Fragment Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends DebouncingOnClickListener {
        public final /* synthetic */ WebviewX5Fragment Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(WebviewX5Fragment_ViewBinding webviewX5Fragment_ViewBinding, WebviewX5Fragment webviewX5Fragment) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = webviewX5Fragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onViewClicked(view);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends DebouncingOnClickListener {
        public final /* synthetic */ WebviewX5Fragment Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(WebviewX5Fragment_ViewBinding webviewX5Fragment_ViewBinding, WebviewX5Fragment webviewX5Fragment) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = webviewX5Fragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onViewClicked(view);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends DebouncingOnClickListener {
        public final /* synthetic */ WebviewX5Fragment Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(WebviewX5Fragment_ViewBinding webviewX5Fragment_ViewBinding, WebviewX5Fragment webviewX5Fragment) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = webviewX5Fragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onViewClicked(view);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends DebouncingOnClickListener {
        public final /* synthetic */ WebviewX5Fragment Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(WebviewX5Fragment_ViewBinding webviewX5Fragment_ViewBinding, WebviewX5Fragment webviewX5Fragment) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = webviewX5Fragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onViewClicked(view);
        }
    }

    @UiThread
    public WebviewX5Fragment_ViewBinding(WebviewX5Fragment webviewX5Fragment, View view) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = webviewX5Fragment;
        webviewX5Fragment.webView = (WebView) Utils.findRequiredViewAsType(view, R.id.webView, "field 'webView'", WebView.class);
        webviewX5Fragment.ivWebBack = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_web_back, "field 'ivWebBack'", ImageView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.rlyt_web_back, "field 'rlytWebBack' and method 'onViewClicked'");
        webviewX5Fragment.rlytWebBack = (RelativeLayout) Utils.castView(findRequiredView, R.id.rlyt_web_back, "field 'rlytWebBack'", RelativeLayout.class);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = findRequiredView;
        findRequiredView.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, webviewX5Fragment));
        webviewX5Fragment.ivWebForward = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_web_forward, "field 'ivWebForward'", ImageView.class);
        View findRequiredView2 = Utils.findRequiredView(view, R.id.rlyt_web_forward, "field 'rlytWebForward' and method 'onViewClicked'");
        webviewX5Fragment.rlytWebForward = (RelativeLayout) Utils.castView(findRequiredView2, R.id.rlyt_web_forward, "field 'rlytWebForward'", RelativeLayout.class);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = findRequiredView2;
        findRequiredView2.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, webviewX5Fragment));
        ImageView imageView = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_web_refresh, "field 'ivWebRefresh'", ImageView.class);
        View findRequiredView3 = Utils.findRequiredView(view, R.id.rlyt_web_refresh, "field 'rlytWebRefresh' and method 'onViewClicked'");
        RelativeLayout relativeLayout = (RelativeLayout) Utils.castView(findRequiredView3, R.id.rlyt_web_refresh, "field 'rlytWebRefresh'", RelativeLayout.class);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = findRequiredView3;
        findRequiredView3.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, webviewX5Fragment));
        webviewX5Fragment.pBar = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.pbar, "field 'pBar'", ProgressBar.class);
        View findRequiredView4 = Utils.findRequiredView(view, R.id.rlyt_web_close, "field 'rlytWebClose' and method 'onViewClicked'");
        RelativeLayout relativeLayout2 = (RelativeLayout) Utils.castView(findRequiredView4, R.id.rlyt_web_close, "field 'rlytWebClose'", RelativeLayout.class);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = findRequiredView4;
        findRequiredView4.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, webviewX5Fragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        WebviewX5Fragment webviewX5Fragment = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (webviewX5Fragment != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            webviewX5Fragment.webView = null;
            webviewX5Fragment.ivWebBack = null;
            webviewX5Fragment.rlytWebBack = null;
            webviewX5Fragment.ivWebForward = null;
            webviewX5Fragment.rlytWebForward = null;
            webviewX5Fragment.pBar = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setOnClickListener(null);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setOnClickListener(null);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setOnClickListener(null);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setOnClickListener(null);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
