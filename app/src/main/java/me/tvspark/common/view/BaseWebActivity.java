package me.tvspark.common.view;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
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
import me.tvspark.bl0;
import me.tvspark.hl0;
import me.tvspark.nn0;
import me.tvspark.outline;
import white.whale.R;

/* loaded from: classes4.dex */
public abstract class BaseWebActivity<T extends bl0> extends BaseActivity<T> {
    public WebView Wwwwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwwwww;
    public WebView Wwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwww = 0;
    public View.OnLayoutChangeListener Wwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

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
                BaseWebActivity baseWebActivity = BaseWebActivity.this;
                baseWebActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseWebActivity.Wwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwww);
            }
        }

        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(hl0 hl0Var) {
        }

        @JavascriptInterface
        public void showSource(String str) {
            BaseWebActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww.runOnUiThread(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str));
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnLayoutChangeListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            BaseWebActivity baseWebActivity = BaseWebActivity.this;
            baseWebActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((ViewGroup) baseWebActivity.getWindow().getDecorView());
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends WebViewClient {
        public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = "";
        public final InputStream Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ByteArrayInputStream(new byte[0]);

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            BaseWebActivity.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(webView, str);
            webView.loadUrl("javascript:window.local_obj.showSource('<html>'+document.getElementsByTagName('html')[0].innerHTML+'</html>');");
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            BaseWebActivity.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(webView, str, bitmap);
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            BaseWebActivity.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(webView, i, str, str2);
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
                    BaseWebActivity.this.Wwwwwwwwwwwwwwww++;
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
            BaseWebActivity.this.Wwwwwwwwwwwww();
            return super.shouldInterceptRequest(webView, str);
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            BaseWebActivity.this.Wwwwwwwwwwwwwwww = 0;
            webView.loadUrl(str);
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends WebChromeClient {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
            BaseWebActivity.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(webView, i);
        }
    }

    public void Wwwwwwwwwwwww() {
    }

    public abstract WebView Wwwwwwwwwwwwww();

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

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(WebView webView) {
        webView.getView().setBackgroundColor(ContextCompat.getColor(this.Wwwwwwwwwwwwwwwwwwwwwwww, R.color.bg_half_player));
        webView.addJavascriptInterface(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null), "local_obj");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setPluginState(WebSettings.PluginState.ON);
        webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setLoadsImagesAutomatically(false);
        webView.getSettings().setBlockNetworkImage(true);
        webView.getSettings().setCacheMode(-1);
        webView.getSettings().setDatabasePath(this.Wwwwwwwwwwwwwwwwwwwwww);
        webView.getSettings().setAppCachePath(this.Wwwwwwwwwwwwwwwwwwwwww);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setDatabaseEnabled(true);
        webView.getSettings().setAppCacheEnabled(true);
        webView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        webView.getSettings().setMixedContentMode(0);
    }

    @Override // me.tvspark.common.view.BaseActivity
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Bundle bundle) {
        WebView Wwwwwwwwwwwwww = Wwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwww;
        if (Wwwwwwwwwwwwww == null) {
            return;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwww.setWebChromeClient(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        this.Wwwwwwwwwwwwwwwwwww.setWebViewClient(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        if (!nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Activity) this.Wwwwwwwwwwwwwwwwwwwwwwww)) {
            return;
        }
        getWindow().getDecorView().addOnLayoutChangeListener(this.Wwwwwwwwwwwwwww);
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
                            getWindow().getDecorView().removeOnLayoutChangeListener(this.Wwwwwwwwwwwwwww);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(WebView webView) {
        IX5WebViewExtension x5WebViewExtension = webView.getX5WebViewExtension();
        if (x5WebViewExtension != null) {
            x5WebViewExtension.setScrollBarFadingEnabled(false);
            Bundle bundle = new Bundle();
            bundle.putBoolean("standardFullScreen", false);
            bundle.putBoolean("supportLiteWnd", true);
            bundle.putInt("DefaultVideoScreen", 1);
            x5WebViewExtension.invokeMiscMethod("setVideoParams", bundle);
        }
    }

    public abstract void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(WebView webView, int i);

    public abstract void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(WebView webView, int i, String str, String str2);

    public abstract void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(WebView webView, String str);

    public abstract void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(WebView webView, String str, Bitmap bitmap);

    public abstract void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2);

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Activity) this.Wwwwwwwwwwwwwwwwwwwwwwww) || this.Wwwwwwwwwwwwwww == null) {
            return;
        }
        getWindow().getDecorView().addOnLayoutChangeListener(this.Wwwwwwwwwwwwwww);
    }

    @Override // me.tvspark.common.view.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        WebView webView = this.Wwwwwwwwwwwwwwwwwww;
        if (webView != null) {
            try {
                webView.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
                this.Wwwwwwwwwwwwwwwwwww.clearCache(true);
                this.Wwwwwwwwwwwwwwwwwww.clearHistory();
                this.Wwwwwwwwwwwwwwwwwww.setWebChromeClient(null);
                try {
                    if (this.Wwwwwwwwwwwwwwwwwww.getParent() != null) {
                        ((ViewGroup) this.Wwwwwwwwwwwwwwwwwww.getParent()).removeView(this.Wwwwwwwwwwwwwwwwwww);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.Wwwwwwwwwwwwwwwwwww.destroy();
                this.Wwwwwwwwwwwwwwwwwww = null;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        WebView webView2 = this.Wwwwwwwwwwwwwwwww;
        if (webView2 != null) {
            try {
                webView2.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
                this.Wwwwwwwwwwwwwwwww.clearCache(true);
                this.Wwwwwwwwwwwwwwwww.clearHistory();
                this.Wwwwwwwwwwwwwwwww.setWebChromeClient(null);
                try {
                    ((ViewGroup) this.Wwwwwwwwwwwwwwwww.getParent()).removeView(this.Wwwwwwwwwwwwwwwww);
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                this.Wwwwwwwwwwwwwwwww.destroy();
                this.Wwwwwwwwwwwwwwwww = null;
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        Wwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.common.view.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        WebView webView = this.Wwwwwwwwwwwwwwwwwww;
        if (webView != null) {
            webView.onPause();
        }
        WebView webView2 = this.Wwwwwwwwwwwwwwwww;
        if (webView2 != null) {
            webView2.onPause();
        }
    }
}
