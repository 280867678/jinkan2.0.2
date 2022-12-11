package com.just.agentweb;

import android.webkit.WebView;

/* loaded from: classes3.dex */
public class DefaultWebLifeCycleImpl implements WebLifeCycle {
    public WebView mWebView;

    public DefaultWebLifeCycleImpl(WebView webView) {
        this.mWebView = webView;
    }

    @Override // com.just.agentweb.WebLifeCycle
    public void onDestroy() {
        WebView webView = this.mWebView;
        if (webView != null) {
            webView.resumeTimers();
        }
        AgentWebUtils.clearWebView(this.mWebView);
    }

    @Override // com.just.agentweb.WebLifeCycle
    public void onPause() {
        WebView webView = this.mWebView;
        if (webView != null) {
            webView.onPause();
            this.mWebView.pauseTimers();
        }
    }

    @Override // com.just.agentweb.WebLifeCycle
    public void onResume() {
        WebView webView = this.mWebView;
        if (webView != null) {
            webView.onResume();
            this.mWebView.resumeTimers();
        }
    }
}
