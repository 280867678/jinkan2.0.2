package com.just.agentweb;

import android.os.Handler;
import android.os.Looper;
import android.webkit.ValueCallback;
import android.webkit.WebView;

/* loaded from: classes3.dex */
public class JsAccessEntraceImpl extends BaseJsAccessEntrace {
    public Handler mHandler = new Handler(Looper.getMainLooper());
    public WebView mWebView;

    public JsAccessEntraceImpl(WebView webView) {
        super(webView);
        this.mWebView = webView;
    }

    public static JsAccessEntraceImpl getInstance(WebView webView) {
        return new JsAccessEntraceImpl(webView);
    }

    private void safeCallJs(final String str, final ValueCallback valueCallback) {
        this.mHandler.post(new Runnable() { // from class: com.just.agentweb.JsAccessEntraceImpl.1
            @Override // java.lang.Runnable
            public void run() {
                JsAccessEntraceImpl.this.callJs(str, valueCallback);
            }
        });
    }

    @Override // com.just.agentweb.BaseJsAccessEntrace, com.just.agentweb.JsAccessEntrace
    public void callJs(String str, ValueCallback<String> valueCallback) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            safeCallJs(str, valueCallback);
        } else {
            super.callJs(str, valueCallback);
        }
    }
}
