package com.just.agentweb;

import android.webkit.ValueCallback;
import android.webkit.WebView;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public abstract class BaseJsAccessEntrace implements JsAccessEntrace {
    public static final String TAG = "BaseJsAccessEntrace";
    public WebView mWebView;

    public BaseJsAccessEntrace(WebView webView) {
        this.mWebView = webView;
    }

    private String concat(String... strArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            String str = strArr[i];
            if (!AgentWebUtils.isJson(str)) {
                outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, "\"", str, "\"");
            } else {
                sb.append(str);
            }
            if (i != strArr.length - 1) {
                sb.append(" , ");
            }
        }
        return sb.toString();
    }

    private void evaluateJs(String str, final ValueCallback<String> valueCallback) {
        this.mWebView.evaluateJavascript(str, new ValueCallback<String>() { // from class: com.just.agentweb.BaseJsAccessEntrace.1
            @Override // android.webkit.ValueCallback
            public void onReceiveValue(String str2) {
                ValueCallback valueCallback2 = valueCallback;
                if (valueCallback2 != null) {
                    valueCallback2.onReceiveValue(str2);
                }
            }
        });
    }

    private void loadJs(String str) {
        this.mWebView.loadUrl(str);
    }

    @Override // com.just.agentweb.JsAccessEntrace
    public void callJs(String str) {
        callJs(str, null);
    }

    @Override // com.just.agentweb.JsAccessEntrace
    public void callJs(String str, ValueCallback<String> valueCallback) {
        evaluateJs(str, valueCallback);
    }

    @Override // com.just.agentweb.QuickCallJs
    public void quickCallJs(String str) {
        quickCallJs(str, null);
    }

    @Override // com.just.agentweb.QuickCallJs
    public void quickCallJs(String str, ValueCallback<String> valueCallback, String... strArr) {
        String str2;
        StringBuilder sb = new StringBuilder();
        sb.append("javascript:" + str);
        if (strArr == null || strArr.length == 0) {
            str2 = "()";
        } else {
            sb.append("(");
            sb.append(concat(strArr));
            str2 = ")";
        }
        sb.append(str2);
        callJs(sb.toString(), valueCallback);
    }

    @Override // com.just.agentweb.QuickCallJs
    public void quickCallJs(String str, String... strArr) {
        quickCallJs(str, null, strArr);
    }
}
