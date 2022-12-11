package me.tvspark;

import android.app.Activity;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import me.tvspark.widget.listener.BasicOnScrollListener;

/* loaded from: classes4.dex */
public class wu0 extends WebViewClient {
    public final /* synthetic */ BasicOnScrollListener Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ WebView Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ Activity Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // java.lang.Runnable
        public void run() {
            wu0 wu0Var = wu0.this;
            wu0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("", wu0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {
        public final /* synthetic */ String Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            WebView webView = wu0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("javascript:window.HTMLOUT.processHTML('<head>'+document.getElementsByTagName('html')[0].innerHTML+'</head>','");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.Wwwwwwwwwwwwwwwwwwwwwwww);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("')");
            webView.loadUrl(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
    }

    public wu0(BasicOnScrollListener basicOnScrollListener, Activity activity, WebView webView, int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = basicOnScrollListener;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = activity;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = webView;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.runOnUiThread(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(webView.getTitle()));
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.runOnUiThread(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        sslErrorHandler.proceed();
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        return true;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return true;
    }
}
