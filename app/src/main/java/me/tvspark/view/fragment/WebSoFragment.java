package me.tvspark.view.fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.LinearLayout;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;
import com.just.agentweb.AgentWeb;
import com.just.agentweb.DefaultWebClient;
import com.just.agentweb.NestedScrollAgentWebView;
import com.just.agentweb.WebViewClient;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import me.tvspark.ApplicationC1880C;
import me.tvspark.bl0;
import me.tvspark.co0;
import me.tvspark.common.view.BaseFragment;
import me.tvspark.mn0;
import me.tvspark.outline;
import white.whale.R;

/* loaded from: classes4.dex */
public class WebSoFragment extends BaseFragment {
    public String Wwwwwwwwwwwww;
    public NestedScrollAgentWebView Wwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwwww;
    @BindView(R.id.llyt_root)
    public LinearLayout llytRoot;
    @BindView(R.id.swipe_refresh)
    public SwipeRefreshLayout mRefreshLayout;
    public AgentWeb Wwwwwwwwwwwwwww = null;
    public String Wwwwwwwwwwww = "";
    public WebViewClient Wwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements SwipeRefreshLayout.OnRefreshListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public void onRefresh() {
            WebSoFragment.this.mRefreshLayout.setRefreshing(false);
            AgentWeb agentWeb = WebSoFragment.this.Wwwwwwwwwwwwwww;
            if (agentWeb != null) {
                agentWeb.getWebCreator().getWebView().stopLoading();
                WebSoFragment.this.Wwwwwwwwwwwwwww.getWebCreator().getWebView().loadUrl(WebSoFragment.this.Wwwwwwwwwwwwwwwww);
            }
        }
    }

    public final void Wwwwwwwwwwwwww() {
        try {
            if (TextUtils.isEmpty(this.Wwwwwwwwwwwww)) {
                return;
            }
            if (this.Wwwwwwwwwwwwwww == null) {
                AgentWeb agentWeb = AgentWeb.with(this.Wwwwwwwwwwwwwwwwwwwwwww).setAgentWebParent(this.llytRoot, new LinearLayout.LayoutParams(-1, -1)).useDefaultIndicator().interceptUnkownUrl().setWebView(this.Wwwwwwwwwwwwww).setOpenOtherPageWays(DefaultWebClient.OpenOtherPageWays.ASK).setWebViewClient(this.Wwwwwwwwwww).setSecurityType(AgentWeb.SecurityType.STRICT_CHECK).createAgentWeb().ready().get();
                this.Wwwwwwwwwwwwwww = agentWeb;
                WebSettings webSettings = agentWeb.getAgentWebSettings().getWebSettings();
                webSettings.setUserAgentString(ApplicationC1880C.Wwwwwwwwwwwwwwwwwwwwww);
                webSettings.setSupportZoom(true);
                webSettings.setBuiltInZoomControls(true);
                webSettings.setUseWideViewPort(true);
                webSettings.setDisplayZoomControls(false);
                webSettings.setGeolocationEnabled(false);
            }
            this.Wwwwwwwwwwwwwww.getWebCreator().getWebView().stopLoading();
            this.Wwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwww.replace("{search}", this.Wwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwww.getWebCreator().getWebView().loadUrl(this.Wwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwww = co0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwww);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // me.tvspark.common.view.BaseFragment
    public bl0 Wwwwwwwwwwwwwwwww() {
        return null;
    }

    @Override // me.tvspark.common.view.BaseFragment
    public int Wwwwwwwwwwwwwwwwww() {
        return R.layout.fragment_web_so;
    }

    @Override // me.tvspark.common.view.BaseFragment
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Bundle bundle) {
        this.Wwwwwwwwwwwwwwww = getArguments().getString("key_string");
        this.Wwwwwwwwwwwww = getArguments().getString("key_string_one");
        this.Wwwwwwwwwwwwww = new NestedScrollAgentWebView(this.Wwwwwwwwwwwwwwwwwwwwwww);
        this.mRefreshLayout.setColorSchemeColors(ContextCompat.getColor(this.Wwwwwwwwwwwwwwwwwwwwwww, R.color.googleBlue), ContextCompat.getColor(this.Wwwwwwwwwwwwwwwwwwwwwww, R.color.googleGreen), ContextCompat.getColor(this.Wwwwwwwwwwwwwwwwwwwwwww, R.color.googleRed), ContextCompat.getColor(this.Wwwwwwwwwwwwwwwwwwwwwww, R.color.googleYellow));
        this.mRefreshLayout.setOnRefreshListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        Wwwwwwwwwwwwww();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        AgentWeb agentWeb = this.Wwwwwwwwwwwwwww;
        if (agentWeb != null) {
            agentWeb.getWebLifeCycle().onDestroy();
            this.Wwwwwwwwwwwwwww = null;
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends WebViewClient {
        public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = "";
        public final InputStream Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ByteArrayInputStream(new byte[0]);

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            if (TextUtils.isEmpty(WebSoFragment.this.Wwwwwwwwwwww) || !str.contains(WebSoFragment.this.Wwwwwwwwwwww)) {
                return;
            }
            WebSoFragment webSoFragment = WebSoFragment.this;
            webSoFragment.Wwwwwwwwwwwwwwwww = str;
            webSoFragment.Wwwwwwwwwwww = co0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
        }

        @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            if (TextUtils.isEmpty(WebSoFragment.this.Wwwwwwwwwwww) || !str.contains(WebSoFragment.this.Wwwwwwwwwwww)) {
                return;
            }
            WebSoFragment webSoFragment = WebSoFragment.this;
            webSoFragment.Wwwwwwwwwwwwwwwww = str;
            webSoFragment.Wwwwwwwwwwww = co0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
        }

        @Override // android.webkit.WebViewClient
        @RequiresApi(api = 26)
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            return !renderProcessGoneDetail.didCrash();
        }

        @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            if (ApplicationC1880C.Wwwwwwwwwwwwww != null) {
                if (webResourceRequest.isForMainFrame()) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = webResourceRequest.getUrl().toString();
                }
                if (ApplicationC1880C.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(webResourceRequest.getUrl(), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("※ blocked:");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(webResourceRequest.getUrl());
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
                    return new WebResourceResponse("text/plain", "UTF-8", this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                }
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("  unblocked:");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(webResourceRequest.getUrl());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
            }
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }

        @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
        @RequiresApi(api = 21)
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            if (!TextUtils.isEmpty(WebSoFragment.this.Wwwwwwwwwwww) && webResourceRequest.getUrl().toString().contains(WebSoFragment.this.Wwwwwwwwwwww)) {
                webView.loadUrl(webResourceRequest.getUrl().toString());
            } else if (webResourceRequest.getUrl().toString().startsWith("http")) {
                mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Context) WebSoFragment.this.Wwwwwwwwwwwwwwwwwwwwwww, webResourceRequest.getUrl().toString(), true);
            }
            return true;
        }

        @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (!TextUtils.isEmpty(WebSoFragment.this.Wwwwwwwwwwww) && str.contains(WebSoFragment.this.Wwwwwwwwwwww)) {
                webView.loadUrl(str);
            } else if (str.startsWith("http")) {
                mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Context) WebSoFragment.this.Wwwwwwwwwwwwwwwwwwwwwww, str, true);
            }
            return true;
        }
    }
}
