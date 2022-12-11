package me.tvspark.common.view;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.widget.TextView;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import me.tvspark.ApplicationC1880C;
import me.tvspark.common.view.BaseFragment;
import me.tvspark.il0;
import me.tvspark.mn0;
import me.tvspark.nn0;
import me.tvspark.outline;
import me.tvspark.view.fragment.WebviewX5Fragment;

/* loaded from: classes4.dex */
public abstract class BaseWebFragment extends BaseFragment {
    public String Wwwwwwwwwwwwwwww;
    public WebView Wwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwww = 0;
    public View.OnLayoutChangeListener Wwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    /* loaded from: classes4.dex */
    public final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {

        /* loaded from: classes4.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {
            public final /* synthetic */ String Wwwwwwwwwwwwwwwwwwwwwwww;

            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                BaseWebFragment baseWebFragment = BaseWebFragment.this;
                String str = baseWebFragment.Wwwwwwwwwwwwwwww;
                if (((WebviewX5Fragment) baseWebFragment) != null) {
                    return;
                }
                throw null;
            }
        }

        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(il0 il0Var) {
        }

        @JavascriptInterface
        public void showSource(String str) {
            BaseWebFragment.this.Wwwwwwwwwwwwwwwwwwwwwww.runOnUiThread(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str));
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnLayoutChangeListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            BaseWebFragment baseWebFragment = BaseWebFragment.this;
            baseWebFragment.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((ViewGroup) baseWebFragment.Wwwwwwwwwwwwwwwwwwwwwww.getWindow().getDecorView());
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends WebChromeClient {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
            WebviewX5Fragment webviewX5Fragment = (WebviewX5Fragment) BaseWebFragment.this;
            if (i == 100) {
                webviewX5Fragment.pBar.setVisibility(4);
                String url = webView.getUrl();
                webviewX5Fragment.Wwwwwwwwwwwww();
                webviewX5Fragment.Wwwwwwwwwwwww = url;
                return;
            }
            webviewX5Fragment.pBar.setVisibility(0);
            webviewX5Fragment.pBar.setProgress(i);
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            if (((WebviewX5Fragment) BaseWebFragment.this) != null) {
                return;
            }
            throw null;
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ViewGroup viewGroup) {
        if (viewGroup != null) {
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt instanceof ViewGroup) {
                    if (TextUtils.isEmpty(childAt.getClass().getName()) || !childAt.getClass().getName().startsWith(DexLoader.TENCENT_PACKAGE_PREFIX)) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((ViewGroup) childAt);
                    } else {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((ViewGroup) childAt);
                    }
                }
            }
        }
    }

    @Override // me.tvspark.common.view.BaseFragment
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Bundle bundle) {
        WebView webView = ((WebviewX5Fragment) this).webView;
        this.Wwwwwwwwwwwwwwwww = webView;
        if (webView == null) {
            return;
        }
        IX5WebViewExtension x5WebViewExtension = webView.getX5WebViewExtension();
        if (x5WebViewExtension != null) {
            x5WebViewExtension.setScrollBarFadingEnabled(false);
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("standardFullScreen", false);
            bundle2.putBoolean("supportLiteWnd", true);
            bundle2.putInt("DefaultVideoScreen", 1);
            x5WebViewExtension.invokeMiscMethod("setVideoParams", bundle2);
        }
        WebView webView2 = this.Wwwwwwwwwwwwwwwww;
        webView2.addJavascriptInterface(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null), "local_obj");
        webView2.getSettings().setJavaScriptEnabled(true);
        webView2.getSettings().setPluginState(WebSettings.PluginState.ON);
        webView2.getSettings().setAllowFileAccess(true);
        webView2.getSettings().setCacheMode(-1);
        webView2.getSettings().setDatabasePath(this.Wwwwwwwwwwwwwwwwwwwww);
        webView2.getSettings().setAppCachePath(this.Wwwwwwwwwwwwwwwwwwwww);
        webView2.getSettings().setDomStorageEnabled(true);
        webView2.getSettings().setDatabaseEnabled(true);
        webView2.getSettings().setAppCacheEnabled(true);
        webView2.getSettings().setMediaPlaybackRequiresUserGesture(false);
        webView2.getSettings().setMixedContentMode(0);
        this.Wwwwwwwwwwwwwwwww.setWebViewClient(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        this.Wwwwwwwwwwwwwwwww.setWebChromeClient(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        if (!nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Activity) this.Wwwwwwwwwwwwwwwwwwwwwww)) {
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwww.getWindow().getDecorView().addOnLayoutChangeListener(this.Wwwwwwwwwwwwww);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ViewGroup viewGroup) {
        if (viewGroup != null) {
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt instanceof ViewGroup) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((ViewGroup) childAt);
                } else if (childAt instanceof TextView) {
                    String charSequence = ((TextView) childAt).getText().toString();
                    if (!TextUtils.isEmpty(charSequence) && (charSequence.equals("倍速") || charSequence.equals("下载") || charSequence.equals("缓存"))) {
                        childAt.setVisibility(0);
                        try {
                            this.Wwwwwwwwwwwwwwwwwwwwwww.getWindow().getDecorView().removeOnLayoutChangeListener(this.Wwwwwwwwwwwwww);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Activity) this.Wwwwwwwwwwwwwwwwwwwwwww) || this.Wwwwwwwwwwwwww == null) {
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwww.getWindow().getDecorView().addOnLayoutChangeListener(this.Wwwwwwwwwwwwww);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        WebView webView = this.Wwwwwwwwwwwwwwwww;
        if (webView != null) {
            try {
                webView.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
                this.Wwwwwwwwwwwwwwwww.clearCache(true);
                this.Wwwwwwwwwwwwwwwww.clearHistory();
                this.Wwwwwwwwwwwwwwwww.setWebChromeClient(null);
                try {
                    if (this.Wwwwwwwwwwwwwwwww.getParent() != null) {
                        ((ViewGroup) this.Wwwwwwwwwwwwwwwww.getParent()).removeView(this.Wwwwwwwwwwwwwwwww);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.Wwwwwwwwwwwwwwwww.destroy();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        new BaseFragment.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().start();
    }

    @Override // me.tvspark.common.view.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        WebView webView = this.Wwwwwwwwwwwwwwwww;
        if (webView != null) {
            webView.onPause();
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends WebViewClient {
        public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = "";
        public final InputStream Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ByteArrayInputStream(new byte[0]);

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            WebviewX5Fragment webviewX5Fragment = (WebviewX5Fragment) BaseWebFragment.this;
            webviewX5Fragment.Wwwwwwwwwwwww();
            webviewX5Fragment.Wwwwwwwwwwwww = str;
            webView.loadUrl("javascript:window.local_obj.showSource('<html>'+document.getElementsByTagName('html')[0].innerHTML+'</html>');");
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            WebviewX5Fragment webviewX5Fragment = (WebviewX5Fragment) BaseWebFragment.this;
            webviewX5Fragment.Wwwwwwwwwwwww();
            webviewX5Fragment.Wwwwwwwwwwwww = str;
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            if (((WebviewX5Fragment) BaseWebFragment.this) != null) {
                return;
            }
            throw null;
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            sslErrorHandler.proceed();
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            if (ApplicationC1880C.Wwwwwwwwwwwwww != null) {
                if (webResourceRequest.isForMainFrame()) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = webResourceRequest.getUrl().toString();
                }
                if (ApplicationC1880C.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(webResourceRequest.getUrl(), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("※ blocked:");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(webResourceRequest.getUrl());
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
                    BaseWebFragment.this.Wwwwwwwwwwwwwww++;
                    return new WebResourceResponse("text/plain", "UTF-8", this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                }
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("  unblocked:");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(webResourceRequest.getUrl());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
            }
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            if (BaseWebFragment.this != null) {
                return super.shouldInterceptRequest(webView, str);
            }
            throw null;
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            try {
                if (webResourceRequest.getUrl().toString().startsWith("weixin://")) {
                    webView.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(webResourceRequest.getUrl().toString())));
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            BaseWebFragment baseWebFragment = BaseWebFragment.this;
            webResourceRequest.getUrl().toString();
            if (((WebviewX5Fragment) baseWebFragment).Wwwwwwwwwwww) {
                webView.loadUrl(webResourceRequest.getUrl().toString());
                BaseWebFragment.this.Wwwwwwwwwwwwwww = 0;
            } else {
                mn0.Wwwwwwwwwwwwwwwwwwwwwwwwww(BaseWebFragment.this.Wwwwwwwwwwwwwwwwwwwwwww, webResourceRequest.getUrl().toString());
            }
            return true;
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            try {
                if (str.startsWith("weixin://")) {
                    webView.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            BaseWebFragment baseWebFragment = BaseWebFragment.this;
            if (((WebviewX5Fragment) baseWebFragment).Wwwwwwwwwwww) {
                webView.loadUrl(str);
                BaseWebFragment.this.Wwwwwwwwwwwwwww = 0;
            } else {
                mn0.Wwwwwwwwwwwwwwwwwwwwwwwwww(baseWebFragment.Wwwwwwwwwwwwwwwwwwwwwww, str);
            }
            return true;
        }
    }
}
