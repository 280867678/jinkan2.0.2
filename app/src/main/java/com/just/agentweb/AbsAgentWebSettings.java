package com.just.agentweb;

import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public abstract class AbsAgentWebSettings implements IAgentWebSettings, WebListenerManager {
    public static final String TAG = "AbsAgentWebSettings";
    public static final String USERAGENT_AGENTWEB = " AgentWeb/5.0.0 ";
    public static final String USERAGENT_QQ_BROWSER = " MQQBrowser/8.0 ";
    public static final String USERAGENT_UC = " UCBrowser/11.6.4.950 ";
    public AgentWeb mAgentWeb;
    public WebSettings mWebSettings;

    public static AbsAgentWebSettings getInstance() {
        return new AgentWebSettingsImpl();
    }

    private void settings(WebView webView) {
        WebSettings settings = webView.getSettings();
        this.mWebSettings = settings;
        settings.setJavaScriptEnabled(true);
        this.mWebSettings.setSupportZoom(true);
        this.mWebSettings.setBuiltInZoomControls(false);
        this.mWebSettings.setSavePassword(false);
        if (AgentWebUtils.checkNetwork(webView.getContext())) {
            this.mWebSettings.setCacheMode(-1);
        } else {
            this.mWebSettings.setCacheMode(1);
        }
        this.mWebSettings.setMixedContentMode(0);
        webView.setLayerType(2, null);
        this.mWebSettings.setTextZoom(100);
        this.mWebSettings.setDatabaseEnabled(true);
        this.mWebSettings.setAppCacheEnabled(true);
        this.mWebSettings.setLoadsImagesAutomatically(true);
        this.mWebSettings.setSupportMultipleWindows(false);
        this.mWebSettings.setBlockNetworkImage(false);
        this.mWebSettings.setAllowFileAccess(true);
        this.mWebSettings.setAllowFileAccessFromFileURLs(false);
        this.mWebSettings.setAllowUniversalAccessFromFileURLs(false);
        this.mWebSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        this.mWebSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        this.mWebSettings.setLoadWithOverviewMode(false);
        this.mWebSettings.setUseWideViewPort(false);
        this.mWebSettings.setDomStorageEnabled(true);
        this.mWebSettings.setNeedInitialFocus(true);
        this.mWebSettings.setDefaultTextEncodingName("utf-8");
        this.mWebSettings.setDefaultFontSize(16);
        this.mWebSettings.setMinimumFontSize(12);
        this.mWebSettings.setGeolocationEnabled(true);
        String cachePath = AgentWebConfig.getCachePath(webView.getContext());
        String str = TAG;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("dir:", cachePath, "   appcache:");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(AgentWebConfig.getCachePath(webView.getContext()));
        LogUtils.m3701i(str, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        this.mWebSettings.setGeolocationDatabasePath(cachePath);
        this.mWebSettings.setDatabasePath(cachePath);
        this.mWebSettings.setAppCachePath(cachePath);
        this.mWebSettings.setAppCacheMaxSize(Long.MAX_VALUE);
        this.mWebSettings.setUserAgentString(getWebSettings().getUserAgentString().concat(USERAGENT_AGENTWEB).concat(USERAGENT_UC));
        String str2 = TAG;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("UserAgentString : ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mWebSettings.getUserAgentString());
        LogUtils.m3701i(str2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
    }

    public final void bindAgentWeb(AgentWeb agentWeb) {
        this.mAgentWeb = agentWeb;
        bindAgentWebSupport(agentWeb);
    }

    public abstract void bindAgentWebSupport(AgentWeb agentWeb);

    @Override // com.just.agentweb.IAgentWebSettings
    public WebSettings getWebSettings() {
        return this.mWebSettings;
    }

    @Override // com.just.agentweb.WebListenerManager
    public WebListenerManager setDownloader(WebView webView, DownloadListener downloadListener) {
        webView.setDownloadListener(downloadListener);
        return this;
    }

    @Override // com.just.agentweb.WebListenerManager
    public WebListenerManager setWebChromeClient(WebView webView, android.webkit.WebChromeClient webChromeClient) {
        webView.setWebChromeClient(webChromeClient);
        return this;
    }

    @Override // com.just.agentweb.WebListenerManager
    public WebListenerManager setWebViewClient(WebView webView, android.webkit.WebViewClient webViewClient) {
        webView.setWebViewClient(webViewClient);
        return this;
    }

    @Override // com.just.agentweb.IAgentWebSettings
    public IAgentWebSettings toSetting(WebView webView) {
        settings(webView);
        return this;
    }
}
