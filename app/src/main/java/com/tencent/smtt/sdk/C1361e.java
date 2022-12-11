package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.view.View;
import android.webkit.WebChromeClient;
import com.tencent.smtt.sdk.SystemWebChromeClient;

/* renamed from: com.tencent.smtt.sdk.e */
/* loaded from: classes4.dex */
public class C1361e extends SystemWebChromeClient {
    public C1361e(WebView webView, WebChromeClient webChromeClient) {
        super(webView, webChromeClient);
    }

    @Override // android.webkit.WebChromeClient
    @TargetApi(7)
    public void onHideCustomView() {
        this.f1784a.onHideCustomView();
    }

    @Override // android.webkit.WebChromeClient
    @TargetApi(14)
    @Deprecated
    public void onShowCustomView(View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
        this.f1784a.onShowCustomView(view, i, new SystemWebChromeClient.C1303b(customViewCallback));
    }

    @Override // android.webkit.WebChromeClient
    @TargetApi(7)
    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        this.f1784a.onShowCustomView(view, new SystemWebChromeClient.C1303b(customViewCallback));
    }
}
