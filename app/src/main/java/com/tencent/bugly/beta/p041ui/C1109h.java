package com.tencent.bugly.beta.p041ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Message;
import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* renamed from: com.tencent.bugly.beta.ui.h */
/* loaded from: classes3.dex */
public class C1109h extends WebView {

    /* renamed from: a */
    public Context f834a;

    /* renamed from: com.tencent.bugly.beta.ui.h$a */
    /* loaded from: classes3.dex */
    public static class C1110a extends WebChromeClient {
        @Override // android.webkit.WebChromeClient
        public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
            ((WebView.WebViewTransport) message.obj).setWebView(webView);
            message.sendToTarget();
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public void onGeolocationPermissionsHidePrompt() {
            super.onGeolocationPermissionsHidePrompt();
        }

        @Override // android.webkit.WebChromeClient
        public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
            callback.invoke(str, true, false);
            super.onGeolocationPermissionsShowPrompt(str, callback);
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedIcon(WebView webView, Bitmap bitmap) {
            super.onReceivedIcon(webView, bitmap);
        }
    }

    /* renamed from: com.tencent.bugly.beta.ui.h$b */
    /* loaded from: classes3.dex */
    public static class C1111b extends WebViewClient {
        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            webView.loadUrl(str);
            return true;
        }
    }

    public C1109h(Context context) {
        super(context);
        this.f834a = context;
        m3589a();
    }

    /* renamed from: a */
    private void m3589a() {
        WebSettings settings = getSettings();
        settings.setSupportZoom(true);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setDefaultTextEncodingName("utf-8");
        settings.setLoadsImagesAutomatically(true);
        settings.setJavaScriptEnabled(true);
        settings.setSupportMultipleWindows(true);
        if (Build.VERSION.SDK_INT > 21) {
            settings.setMixedContentMode(0);
        }
        settings.setBlockNetworkImage(false);
        m3588a(settings);
        setWebChromeClient(new C1110a());
        setWebViewClient(new C1111b());
        removeJavascriptInterface("searchBoxJavaBridge_");
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
    }

    /* renamed from: a */
    private void m3588a(WebSettings webSettings) {
        webSettings.setSupportMultipleWindows(false);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
    }
}
