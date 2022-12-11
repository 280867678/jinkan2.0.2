package com.tencent.smtt.sdk;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import com.tencent.smtt.export.external.interfaces.ClientCertRequest;
import com.tencent.smtt.export.external.interfaces.HttpAuthHandler;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceError;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.export.external.proxy.X5ProxyWebViewClient;
import com.tencent.smtt.utils.C1468o;
import com.tencent.smtt.utils.TbsLog;
import me.tvspark.outline;

/* renamed from: com.tencent.smtt.sdk.j */
/* loaded from: classes4.dex */
public class C1371j extends X5ProxyWebViewClient {

    /* renamed from: c */
    public static String f2137c;

    /* renamed from: a */
    public WebViewClient f2138a;

    /* renamed from: b */
    public WebView f2139b;

    public C1371j(IX5WebViewClient iX5WebViewClient, WebView webView, WebViewClient webViewClient) {
        super(iX5WebViewClient);
        this.f2139b = webView;
        this.f2138a = webViewClient;
        webViewClient.mX5Client = this;
    }

    /* renamed from: a */
    public void m2584a(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(this.f2139b.m2695b(), 0, 0, str, bitmap);
    }

    /* renamed from: a */
    public void m2582a(String str) {
        Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(str));
        intent.addFlags(268435456);
        try {
            if (this.f2139b.getContext() == null) {
                return;
            }
            this.f2139b.getContext().startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient
    public void countPVContentCacheCallBack(String str) {
        this.f2139b.f2001a++;
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void doUpdateVisitedHistory(IX5WebViewBase iX5WebViewBase, String str, boolean z) {
        this.f2139b.m2702a(iX5WebViewBase);
        this.f2138a.doUpdateVisitedHistory(this.f2139b, str, z);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onDetectedBlankScreen(IX5WebViewBase iX5WebViewBase, String str, int i) {
        this.f2139b.m2702a(iX5WebViewBase);
        this.f2138a.onDetectedBlankScreen(str, i);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onFormResubmission(IX5WebViewBase iX5WebViewBase, Message message, Message message2) {
        this.f2139b.m2702a(iX5WebViewBase);
        this.f2138a.onFormResubmission(this.f2139b, message, message2);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onLoadResource(IX5WebViewBase iX5WebViewBase, String str) {
        this.f2139b.m2702a(iX5WebViewBase);
        this.f2138a.onLoadResource(this.f2139b, str);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onPageCommitVisible(IX5WebViewBase iX5WebViewBase, String str) {
        this.f2139b.m2702a(iX5WebViewBase);
        this.f2138a.onPageCommitVisible(this.f2139b, str);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onPageFinished(IX5WebViewBase iX5WebViewBase, int i, int i2, String str) {
        C1468o m2006a;
        if (f2137c == null && (m2006a = C1468o.m2006a()) != null) {
            m2006a.m2004a(false);
            f2137c = Boolean.toString(false);
        }
        this.f2139b.m2702a(iX5WebViewBase);
        this.f2139b.f2001a++;
        this.f2138a.onPageFinished(this.f2139b, str);
        if (TbsConfig.APP_QZONE.equals(iX5WebViewBase.getView().getContext().getApplicationInfo().packageName)) {
            this.f2139b.m2706a(iX5WebViewBase.getView().getContext());
        }
        TbsLog.app_extra("SmttWebViewClient", iX5WebViewBase.getView().getContext());
        try {
            super.onPageFinished(iX5WebViewBase, i, i2, str);
        } catch (Exception unused) {
        }
        WebView.m2689c();
        if (!TbsShareManager.mHasQueryed && this.f2139b.getContext() != null && TbsShareManager.isThirdPartyApp(this.f2139b.getContext())) {
            TbsShareManager.mHasQueryed = true;
            new Thread(new Runnable() { // from class: com.tencent.smtt.sdk.j.1
                @Override // java.lang.Runnable
                public void run() {
                    if (TbsShareManager.forceLoadX5FromTBSDemo(C1371j.this.f2139b.getContext()) || !TbsDownloader.needDownload(C1371j.this.f2139b.getContext(), false)) {
                        return;
                    }
                    TbsDownloader.startDownload(C1371j.this.f2139b.getContext());
                }
            }).start();
        }
        if (this.f2139b.getContext() == null || TbsLogReport.getInstance(this.f2139b.getContext()).getShouldUploadEventReport()) {
            return;
        }
        TbsLogReport.getInstance(this.f2139b.getContext()).setShouldUploadEventReport(true);
        TbsLogReport.getInstance(this.f2139b.getContext()).dailyReport();
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onPageFinished(IX5WebViewBase iX5WebViewBase, String str) {
        onPageFinished(iX5WebViewBase, 0, 0, str);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onPageStarted(IX5WebViewBase iX5WebViewBase, int i, int i2, String str, Bitmap bitmap) {
        this.f2139b.m2702a(iX5WebViewBase);
        this.f2138a.onPageStarted(this.f2139b, str, bitmap);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onPageStarted(IX5WebViewBase iX5WebViewBase, String str, Bitmap bitmap) {
        onPageStarted(iX5WebViewBase, 0, 0, str, bitmap);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onReceivedClientCertRequest(IX5WebViewBase iX5WebViewBase, ClientCertRequest clientCertRequest) {
        this.f2139b.m2702a(iX5WebViewBase);
        this.f2138a.onReceivedClientCertRequest(this.f2139b, clientCertRequest);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onReceivedError(IX5WebViewBase iX5WebViewBase, int i, String str, String str2) {
        if (i < -15) {
            if (i != -17) {
                return;
            }
            i = -1;
        }
        this.f2139b.m2702a(iX5WebViewBase);
        this.f2138a.onReceivedError(this.f2139b, i, str, str2);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onReceivedError(IX5WebViewBase iX5WebViewBase, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        this.f2139b.m2702a(iX5WebViewBase);
        this.f2138a.onReceivedError(this.f2139b, webResourceRequest, webResourceError);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onReceivedHttpAuthRequest(IX5WebViewBase iX5WebViewBase, HttpAuthHandler httpAuthHandler, String str, String str2) {
        this.f2139b.m2702a(iX5WebViewBase);
        this.f2138a.onReceivedHttpAuthRequest(this.f2139b, httpAuthHandler, str, str2);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onReceivedHttpError(IX5WebViewBase iX5WebViewBase, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        this.f2139b.m2702a(iX5WebViewBase);
        this.f2138a.onReceivedHttpError(this.f2139b, webResourceRequest, webResourceResponse);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onReceivedLoginRequest(IX5WebViewBase iX5WebViewBase, String str, String str2, String str3) {
        this.f2139b.m2702a(iX5WebViewBase);
        this.f2138a.onReceivedLoginRequest(this.f2139b, str, str2, str3);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onReceivedSslError(IX5WebViewBase iX5WebViewBase, SslErrorHandler sslErrorHandler, SslError sslError) {
        this.f2139b.m2702a(iX5WebViewBase);
        this.f2138a.onReceivedSslError(this.f2139b, sslErrorHandler, sslError);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onScaleChanged(IX5WebViewBase iX5WebViewBase, float f, float f2) {
        this.f2139b.m2702a(iX5WebViewBase);
        this.f2138a.onScaleChanged(this.f2139b, f, f2);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onTooManyRedirects(IX5WebViewBase iX5WebViewBase, Message message, Message message2) {
        this.f2139b.m2702a(iX5WebViewBase);
        this.f2138a.onTooManyRedirects(this.f2139b, message, message2);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onUnhandledKeyEvent(IX5WebViewBase iX5WebViewBase, KeyEvent keyEvent) {
        this.f2139b.m2702a(iX5WebViewBase);
        this.f2138a.onUnhandledKeyEvent(this.f2139b, keyEvent);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public WebResourceResponse shouldInterceptRequest(IX5WebViewBase iX5WebViewBase, WebResourceRequest webResourceRequest) {
        this.f2139b.m2702a(iX5WebViewBase);
        return this.f2138a.shouldInterceptRequest(this.f2139b, webResourceRequest);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public WebResourceResponse shouldInterceptRequest(IX5WebViewBase iX5WebViewBase, WebResourceRequest webResourceRequest, Bundle bundle) {
        this.f2139b.m2702a(iX5WebViewBase);
        return this.f2138a.shouldInterceptRequest(this.f2139b, webResourceRequest, bundle);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public WebResourceResponse shouldInterceptRequest(IX5WebViewBase iX5WebViewBase, String str) {
        this.f2139b.m2702a(iX5WebViewBase);
        return this.f2138a.shouldInterceptRequest(this.f2139b, str);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public boolean shouldOverrideKeyEvent(IX5WebViewBase iX5WebViewBase, KeyEvent keyEvent) {
        this.f2139b.m2702a(iX5WebViewBase);
        return this.f2138a.shouldOverrideKeyEvent(this.f2139b, keyEvent);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public boolean shouldOverrideUrlLoading(IX5WebViewBase iX5WebViewBase, WebResourceRequest webResourceRequest) {
        String uri = (webResourceRequest == null || webResourceRequest.getUrl() == null) ? null : webResourceRequest.getUrl().toString();
        if (uri == null || this.f2139b.showDebugView(uri)) {
            return true;
        }
        this.f2139b.m2702a(iX5WebViewBase);
        boolean shouldOverrideUrlLoading = this.f2138a.shouldOverrideUrlLoading(this.f2139b, webResourceRequest);
        if (!shouldOverrideUrlLoading) {
            if (uri.startsWith("wtai://wp/mc;")) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(WebView.SCHEME_TEL);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(uri.substring(13));
                this.f2139b.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString())));
                return true;
            } else if (uri.startsWith(WebView.SCHEME_TEL)) {
                m2582a(uri);
                return true;
            }
        }
        return shouldOverrideUrlLoading;
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public boolean shouldOverrideUrlLoading(IX5WebViewBase iX5WebViewBase, String str) {
        if (str == null || this.f2139b.showDebugView(str)) {
            return true;
        }
        this.f2139b.m2702a(iX5WebViewBase);
        boolean shouldOverrideUrlLoading = this.f2138a.shouldOverrideUrlLoading(this.f2139b, str);
        if (!shouldOverrideUrlLoading) {
            if (str.startsWith("wtai://wp/mc;")) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(WebView.SCHEME_TEL);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(str.substring(13));
                this.f2139b.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString())));
                return true;
            } else if (str.startsWith(WebView.SCHEME_TEL)) {
                m2582a(str);
                return true;
            }
        }
        return shouldOverrideUrlLoading;
    }
}
