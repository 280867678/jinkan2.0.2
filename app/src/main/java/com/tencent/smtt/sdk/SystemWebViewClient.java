package com.tencent.smtt.sdk;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.os.Build;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceError;
import com.tencent.smtt.export.external.interfaces.ClientCertRequest;
import com.tencent.smtt.export.external.interfaces.HttpAuthHandler;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebViewClient;
import com.tencent.smtt.utils.C1460i;
import com.tencent.smtt.utils.C1468o;
import com.tencent.smtt.utils.TbsLog;
import java.io.InputStream;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Map;

@SuppressLint({"NewApi", "Override"})
/* loaded from: classes4.dex */
public class SystemWebViewClient extends android.webkit.WebViewClient {

    /* renamed from: c */
    public static String f1815c;

    /* renamed from: a */
    public WebViewClient f1816a;

    /* renamed from: b */
    public WebView f1817b;

    /* renamed from: com.tencent.smtt.sdk.SystemWebViewClient$a */
    /* loaded from: classes4.dex */
    public static class C1311a extends ClientCertRequest {

        /* renamed from: a */
        public android.webkit.ClientCertRequest f1823a;

        public C1311a(android.webkit.ClientCertRequest clientCertRequest) {
            this.f1823a = clientCertRequest;
        }

        @Override // com.tencent.smtt.export.external.interfaces.ClientCertRequest
        public void cancel() {
            this.f1823a.cancel();
        }

        @Override // com.tencent.smtt.export.external.interfaces.ClientCertRequest
        public String getHost() {
            return this.f1823a.getHost();
        }

        @Override // com.tencent.smtt.export.external.interfaces.ClientCertRequest
        public String[] getKeyTypes() {
            return this.f1823a.getKeyTypes();
        }

        @Override // com.tencent.smtt.export.external.interfaces.ClientCertRequest
        public int getPort() {
            return this.f1823a.getPort();
        }

        @Override // com.tencent.smtt.export.external.interfaces.ClientCertRequest
        public Principal[] getPrincipals() {
            return this.f1823a.getPrincipals();
        }

        @Override // com.tencent.smtt.export.external.interfaces.ClientCertRequest
        public void ignore() {
            this.f1823a.ignore();
        }

        @Override // com.tencent.smtt.export.external.interfaces.ClientCertRequest
        public void proceed(PrivateKey privateKey, X509Certificate[] x509CertificateArr) {
            this.f1823a.proceed(privateKey, x509CertificateArr);
        }
    }

    /* renamed from: com.tencent.smtt.sdk.SystemWebViewClient$b */
    /* loaded from: classes4.dex */
    public static class C1312b implements HttpAuthHandler {

        /* renamed from: a */
        public android.webkit.HttpAuthHandler f1824a;

        public C1312b(android.webkit.HttpAuthHandler httpAuthHandler) {
            this.f1824a = httpAuthHandler;
        }

        @Override // com.tencent.smtt.export.external.interfaces.HttpAuthHandler
        public void cancel() {
            this.f1824a.cancel();
        }

        @Override // com.tencent.smtt.export.external.interfaces.HttpAuthHandler
        public void proceed(String str, String str2) {
            this.f1824a.proceed(str, str2);
        }

        @Override // com.tencent.smtt.export.external.interfaces.HttpAuthHandler
        public boolean useHttpAuthUsernamePassword() {
            return this.f1824a.useHttpAuthUsernamePassword();
        }
    }

    /* renamed from: com.tencent.smtt.sdk.SystemWebViewClient$c */
    /* loaded from: classes4.dex */
    public static class C1313c implements SslErrorHandler {

        /* renamed from: a */
        public android.webkit.SslErrorHandler f1825a;

        public C1313c(android.webkit.SslErrorHandler sslErrorHandler) {
            this.f1825a = sslErrorHandler;
        }

        @Override // com.tencent.smtt.export.external.interfaces.SslErrorHandler
        public void cancel() {
            this.f1825a.cancel();
        }

        @Override // com.tencent.smtt.export.external.interfaces.SslErrorHandler
        public void proceed() {
            this.f1825a.proceed();
        }
    }

    /* renamed from: com.tencent.smtt.sdk.SystemWebViewClient$d */
    /* loaded from: classes4.dex */
    public static class C1314d implements SslError {

        /* renamed from: a */
        public android.net.http.SslError f1826a;

        public C1314d(android.net.http.SslError sslError) {
            this.f1826a = sslError;
        }

        @Override // com.tencent.smtt.export.external.interfaces.SslError
        public boolean addError(int i) {
            return this.f1826a.addError(i);
        }

        @Override // com.tencent.smtt.export.external.interfaces.SslError
        public SslCertificate getCertificate() {
            return this.f1826a.getCertificate();
        }

        @Override // com.tencent.smtt.export.external.interfaces.SslError
        public int getPrimaryError() {
            return this.f1826a.getPrimaryError();
        }

        @Override // com.tencent.smtt.export.external.interfaces.SslError
        public String getUrl() {
            return this.f1826a.getUrl();
        }

        @Override // com.tencent.smtt.export.external.interfaces.SslError
        public boolean hasError(int i) {
            return this.f1826a.hasError(i);
        }
    }

    /* renamed from: com.tencent.smtt.sdk.SystemWebViewClient$e */
    /* loaded from: classes4.dex */
    public static class C1315e implements WebResourceRequest {

        /* renamed from: a */
        public String f1827a;

        /* renamed from: b */
        public boolean f1828b;

        /* renamed from: c */
        public boolean f1829c;

        /* renamed from: d */
        public boolean f1830d;

        /* renamed from: e */
        public String f1831e;

        /* renamed from: f */
        public Map<String, String> f1832f;

        public C1315e(String str, boolean z, boolean z2, boolean z3, String str2, Map<String, String> map) {
            this.f1827a = str;
            this.f1828b = z;
            this.f1829c = z2;
            this.f1830d = z3;
            this.f1831e = str2;
            this.f1832f = map;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public String getMethod() {
            return this.f1831e;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public Map<String, String> getRequestHeaders() {
            return this.f1832f;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public Uri getUrl() {
            return Uri.parse(this.f1827a);
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public boolean hasGesture() {
            return this.f1830d;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public boolean isForMainFrame() {
            return this.f1828b;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public boolean isRedirect() {
            return this.f1829c;
        }
    }

    /* renamed from: com.tencent.smtt.sdk.SystemWebViewClient$f */
    /* loaded from: classes4.dex */
    public static class C1316f implements WebResourceRequest {

        /* renamed from: a */
        public android.webkit.WebResourceRequest f1833a;

        public C1316f(android.webkit.WebResourceRequest webResourceRequest) {
            this.f1833a = webResourceRequest;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public String getMethod() {
            return this.f1833a.getMethod();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public Map<String, String> getRequestHeaders() {
            return this.f1833a.getRequestHeaders();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public Uri getUrl() {
            return this.f1833a.getUrl();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public boolean hasGesture() {
            return this.f1833a.hasGesture();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public boolean isForMainFrame() {
            return this.f1833a.isForMainFrame();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public boolean isRedirect() {
            if (Build.VERSION.SDK_INT >= 24) {
                Object m2051a = C1460i.m2051a(this.f1833a, "isRedirect");
                if (m2051a instanceof Boolean) {
                    return ((Boolean) m2051a).booleanValue();
                }
            }
            return false;
        }
    }

    /* renamed from: com.tencent.smtt.sdk.SystemWebViewClient$g */
    /* loaded from: classes4.dex */
    public static class C1317g extends WebResourceResponse {

        /* renamed from: a */
        public android.webkit.WebResourceResponse f1834a;

        public C1317g(android.webkit.WebResourceResponse webResourceResponse) {
            this.f1834a = webResourceResponse;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public InputStream getData() {
            return this.f1834a.getData();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public String getEncoding() {
            return this.f1834a.getEncoding();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public String getMimeType() {
            return this.f1834a.getMimeType();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public String getReasonPhrase() {
            return this.f1834a.getReasonPhrase();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public Map<String, String> getResponseHeaders() {
            return this.f1834a.getResponseHeaders();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public int getStatusCode() {
            return this.f1834a.getStatusCode();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public void setData(InputStream inputStream) {
            this.f1834a.setData(inputStream);
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public void setEncoding(String str) {
            this.f1834a.setEncoding(str);
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public void setMimeType(String str) {
            this.f1834a.setMimeType(str);
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public void setResponseHeaders(Map<String, String> map) {
            this.f1834a.setResponseHeaders(map);
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public void setStatusCodeAndReasonPhrase(int i, String str) {
            this.f1834a.setStatusCodeAndReasonPhrase(i, str);
        }
    }

    public SystemWebViewClient(WebView webView, WebViewClient webViewClient) {
        this.f1817b = webView;
        this.f1816a = webViewClient;
    }

    @Override // android.webkit.WebViewClient
    public void doUpdateVisitedHistory(android.webkit.WebView webView, String str, boolean z) {
        this.f1817b.m2703a(webView);
        this.f1816a.doUpdateVisitedHistory(this.f1817b, str, z);
    }

    @Override // android.webkit.WebViewClient
    public void onFormResubmission(android.webkit.WebView webView, Message message, Message message2) {
        this.f1817b.m2703a(webView);
        this.f1816a.onFormResubmission(this.f1817b, message, message2);
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(android.webkit.WebView webView, String str) {
        this.f1817b.m2703a(webView);
        this.f1816a.onLoadResource(this.f1817b, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageCommitVisible(android.webkit.WebView webView, String str) {
        this.f1817b.m2703a(webView);
        this.f1816a.onPageCommitVisible(this.f1817b, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(android.webkit.WebView webView, String str) {
        C1468o m2006a;
        if (f1815c == null && (m2006a = C1468o.m2006a()) != null) {
            m2006a.m2004a(true);
            f1815c = Boolean.toString(true);
        }
        this.f1817b.m2703a(webView);
        this.f1817b.f2001a++;
        this.f1816a.onPageFinished(this.f1817b, str);
        if (TbsConfig.APP_QZONE.equals(webView.getContext().getApplicationInfo().packageName)) {
            this.f1817b.m2706a(webView.getContext());
        }
        TbsLog.app_extra("SystemWebViewClient", webView.getContext());
        WebView.m2689c();
        if (!TbsShareManager.mHasQueryed && this.f1817b.getContext() != null && TbsShareManager.isThirdPartyApp(this.f1817b.getContext())) {
            TbsShareManager.mHasQueryed = true;
            new Thread(new Runnable() { // from class: com.tencent.smtt.sdk.SystemWebViewClient.1
                @Override // java.lang.Runnable
                public void run() {
                    if (TbsShareManager.forceLoadX5FromTBSDemo(SystemWebViewClient.this.f1817b.getContext()) || !TbsDownloader.needDownload(SystemWebViewClient.this.f1817b.getContext(), false)) {
                        return;
                    }
                    TbsDownloader.startDownload(SystemWebViewClient.this.f1817b.getContext());
                }
            }).start();
        }
        if (this.f1817b.getContext() == null || TbsLogReport.getInstance(this.f1817b.getContext()).getShouldUploadEventReport()) {
            return;
        }
        TbsLogReport.getInstance(this.f1817b.getContext()).setShouldUploadEventReport(true);
        TbsLogReport.getInstance(this.f1817b.getContext()).dailyReport();
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(android.webkit.WebView webView, String str, Bitmap bitmap) {
        this.f1817b.m2703a(webView);
        this.f1816a.onPageStarted(this.f1817b, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedClientCertRequest(android.webkit.WebView webView, android.webkit.ClientCertRequest clientCertRequest) {
        this.f1817b.m2703a(webView);
        this.f1816a.onReceivedClientCertRequest(this.f1817b, new C1311a(clientCertRequest));
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(android.webkit.WebView webView, int i, String str, String str2) {
        this.f1817b.m2703a(webView);
        this.f1816a.onReceivedError(this.f1817b, i, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(android.webkit.WebView webView, android.webkit.WebResourceRequest webResourceRequest, final WebResourceError webResourceError) {
        this.f1817b.m2703a(webView);
        com.tencent.smtt.export.external.interfaces.WebResourceError webResourceError2 = null;
        C1316f c1316f = webResourceRequest != null ? new C1316f(webResourceRequest) : null;
        if (webResourceError != null) {
            webResourceError2 = new com.tencent.smtt.export.external.interfaces.WebResourceError() { // from class: com.tencent.smtt.sdk.SystemWebViewClient.2
                @Override // com.tencent.smtt.export.external.interfaces.WebResourceError
                public CharSequence getDescription() {
                    return webResourceError.getDescription();
                }

                @Override // com.tencent.smtt.export.external.interfaces.WebResourceError
                public int getErrorCode() {
                    return webResourceError.getErrorCode();
                }
            };
        }
        this.f1816a.onReceivedError(this.f1817b, c1316f, webResourceError2);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpAuthRequest(android.webkit.WebView webView, android.webkit.HttpAuthHandler httpAuthHandler, String str, String str2) {
        this.f1817b.m2703a(webView);
        this.f1816a.onReceivedHttpAuthRequest(this.f1817b, new C1312b(httpAuthHandler), str, str2);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(android.webkit.WebView webView, android.webkit.WebResourceRequest webResourceRequest, android.webkit.WebResourceResponse webResourceResponse) {
        this.f1817b.m2703a(webView);
        this.f1816a.onReceivedHttpError(this.f1817b, new C1316f(webResourceRequest), new C1317g(webResourceResponse));
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(12)
    public void onReceivedLoginRequest(android.webkit.WebView webView, String str, String str2, String str3) {
        this.f1817b.m2703a(webView);
        this.f1816a.onReceivedLoginRequest(this.f1817b, str, str2, str3);
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(8)
    public void onReceivedSslError(android.webkit.WebView webView, android.webkit.SslErrorHandler sslErrorHandler, android.net.http.SslError sslError) {
        this.f1817b.m2703a(webView);
        this.f1816a.onReceivedSslError(this.f1817b, new C1313c(sslErrorHandler), new C1314d(sslError));
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(android.webkit.WebView webView, final RenderProcessGoneDetail renderProcessGoneDetail) {
        this.f1817b.m2703a(webView);
        return this.f1816a.onRenderProcessGone(this.f1817b, new WebViewClient.RenderProcessGoneDetail() { // from class: com.tencent.smtt.sdk.SystemWebViewClient.3
            @Override // com.tencent.smtt.sdk.WebViewClient.RenderProcessGoneDetail
            public boolean didCrash() {
                return renderProcessGoneDetail.didCrash();
            }
        });
    }

    @Override // android.webkit.WebViewClient
    public void onScaleChanged(android.webkit.WebView webView, float f, float f2) {
        this.f1817b.m2703a(webView);
        this.f1816a.onScaleChanged(this.f1817b, f, f2);
    }

    @Override // android.webkit.WebViewClient
    public void onTooManyRedirects(android.webkit.WebView webView, Message message, Message message2) {
        this.f1817b.m2703a(webView);
        this.f1816a.onTooManyRedirects(this.f1817b, message, message2);
    }

    @Override // android.webkit.WebViewClient
    public void onUnhandledKeyEvent(android.webkit.WebView webView, KeyEvent keyEvent) {
        this.f1817b.m2703a(webView);
        this.f1816a.onUnhandledKeyEvent(this.f1817b, keyEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0046 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0047  */
    @Override // android.webkit.WebViewClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public android.webkit.WebResourceResponse shouldInterceptRequest(android.webkit.WebView webView, android.webkit.WebResourceRequest webResourceRequest) {
        boolean z;
        WebResourceResponse shouldInterceptRequest;
        int i = Build.VERSION.SDK_INT;
        if (webResourceRequest == null) {
            return null;
        }
        if (i >= 24) {
            Object m2051a = C1460i.m2051a(webResourceRequest, "isRedirect");
            if (m2051a instanceof Boolean) {
                z = ((Boolean) m2051a).booleanValue();
                shouldInterceptRequest = this.f1816a.shouldInterceptRequest(this.f1817b, new C1315e(webResourceRequest.getUrl().toString(), webResourceRequest.isForMainFrame(), z, webResourceRequest.hasGesture(), webResourceRequest.getMethod(), webResourceRequest.getRequestHeaders()));
                if (shouldInterceptRequest != null) {
                    return null;
                }
                android.webkit.WebResourceResponse webResourceResponse = new android.webkit.WebResourceResponse(shouldInterceptRequest.getMimeType(), shouldInterceptRequest.getEncoding(), shouldInterceptRequest.getData());
                webResourceResponse.setResponseHeaders(shouldInterceptRequest.getResponseHeaders());
                int statusCode = shouldInterceptRequest.getStatusCode();
                String reasonPhrase = shouldInterceptRequest.getReasonPhrase();
                if (statusCode != webResourceResponse.getStatusCode() || (reasonPhrase != null && !reasonPhrase.equals(webResourceResponse.getReasonPhrase()))) {
                    webResourceResponse.setStatusCodeAndReasonPhrase(statusCode, reasonPhrase);
                }
                return webResourceResponse;
            }
        }
        z = false;
        shouldInterceptRequest = this.f1816a.shouldInterceptRequest(this.f1817b, new C1315e(webResourceRequest.getUrl().toString(), webResourceRequest.isForMainFrame(), z, webResourceRequest.hasGesture(), webResourceRequest.getMethod(), webResourceRequest.getRequestHeaders()));
        if (shouldInterceptRequest != null) {
        }
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(11)
    public android.webkit.WebResourceResponse shouldInterceptRequest(android.webkit.WebView webView, String str) {
        WebResourceResponse shouldInterceptRequest = this.f1816a.shouldInterceptRequest(this.f1817b, str);
        if (shouldInterceptRequest == null) {
            return null;
        }
        return new android.webkit.WebResourceResponse(shouldInterceptRequest.getMimeType(), shouldInterceptRequest.getEncoding(), shouldInterceptRequest.getData());
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideKeyEvent(android.webkit.WebView webView, KeyEvent keyEvent) {
        this.f1817b.m2703a(webView);
        return this.f1816a.shouldOverrideKeyEvent(this.f1817b, keyEvent);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(android.webkit.WebView webView, android.webkit.WebResourceRequest webResourceRequest) {
        boolean z;
        String uri = (webResourceRequest == null || webResourceRequest.getUrl() == null) ? null : webResourceRequest.getUrl().toString();
        if (uri == null || this.f1817b.showDebugView(uri)) {
            return true;
        }
        this.f1817b.m2703a(webView);
        if (Build.VERSION.SDK_INT >= 24) {
            Object m2051a = C1460i.m2051a(webResourceRequest, "isRedirect");
            if (m2051a instanceof Boolean) {
                z = ((Boolean) m2051a).booleanValue();
                return this.f1816a.shouldOverrideUrlLoading(this.f1817b, new C1315e(webResourceRequest.getUrl().toString(), webResourceRequest.isForMainFrame(), z, webResourceRequest.hasGesture(), webResourceRequest.getMethod(), webResourceRequest.getRequestHeaders()));
            }
        }
        z = false;
        return this.f1816a.shouldOverrideUrlLoading(this.f1817b, new C1315e(webResourceRequest.getUrl().toString(), webResourceRequest.isForMainFrame(), z, webResourceRequest.hasGesture(), webResourceRequest.getMethod(), webResourceRequest.getRequestHeaders()));
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(android.webkit.WebView webView, String str) {
        if (str == null || this.f1817b.showDebugView(str)) {
            return true;
        }
        this.f1817b.m2703a(webView);
        return this.f1816a.shouldOverrideUrlLoading(this.f1817b, str);
    }
}
