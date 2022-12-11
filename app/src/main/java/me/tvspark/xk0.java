package me.tvspark;

import android.app.Activity;
import android.os.Handler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* loaded from: classes4.dex */
public final class xk0 extends WebViewClient {
    public final /* synthetic */ WebView Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ Activity Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {

        /* renamed from: me.tvspark.xk0$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC3506Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {
            public RunnableC3506Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            }

            @Override // java.lang.Runnable
            public void run() {
                xk0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.loadUrl("javascript:window.HTMLOUT.processHTML('<head>'+document.getElementsByTagName('html')[0].innerHTML+'</head>');");
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // java.lang.Runnable
        public void run() {
            new Handler().postDelayed(new RunnableC3506Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), 500L);
        }
    }

    public xk0(Activity activity, WebView webView) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = activity;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = webView;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.runOnUiThread(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
    }
}
