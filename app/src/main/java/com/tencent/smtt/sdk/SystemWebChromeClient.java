package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Message;
import android.view.View;
import android.webkit.GeolocationPermissions;
import android.webkit.PermissionRequest;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebStorage;
import com.tencent.smtt.sdk.WebView;

/* loaded from: classes4.dex */
public class SystemWebChromeClient extends android.webkit.WebChromeClient {

    /* renamed from: a */
    public WebChromeClient f1784a;

    /* renamed from: b */
    public WebView f1785b;

    /* renamed from: com.tencent.smtt.sdk.SystemWebChromeClient$a */
    /* loaded from: classes4.dex */
    public static class C1302a implements ConsoleMessage {

        /* renamed from: a */
        public ConsoleMessage.MessageLevel f1801a;

        /* renamed from: b */
        public String f1802b;

        /* renamed from: c */
        public String f1803c;

        /* renamed from: d */
        public int f1804d;

        public C1302a(android.webkit.ConsoleMessage consoleMessage) {
            this.f1801a = ConsoleMessage.MessageLevel.valueOf(consoleMessage.messageLevel().name());
            this.f1802b = consoleMessage.message();
            this.f1803c = consoleMessage.sourceId();
            this.f1804d = consoleMessage.lineNumber();
        }

        public C1302a(String str, String str2, int i) {
            this.f1801a = ConsoleMessage.MessageLevel.LOG;
            this.f1802b = str;
            this.f1803c = str2;
            this.f1804d = i;
        }

        @Override // com.tencent.smtt.export.external.interfaces.ConsoleMessage
        public int lineNumber() {
            return this.f1804d;
        }

        @Override // com.tencent.smtt.export.external.interfaces.ConsoleMessage
        public String message() {
            return this.f1802b;
        }

        @Override // com.tencent.smtt.export.external.interfaces.ConsoleMessage
        public ConsoleMessage.MessageLevel messageLevel() {
            return this.f1801a;
        }

        @Override // com.tencent.smtt.export.external.interfaces.ConsoleMessage
        public String sourceId() {
            return this.f1803c;
        }
    }

    /* renamed from: com.tencent.smtt.sdk.SystemWebChromeClient$b */
    /* loaded from: classes4.dex */
    public class C1303b implements IX5WebChromeClient.CustomViewCallback {

        /* renamed from: a */
        public WebChromeClient.CustomViewCallback f1805a;

        public C1303b(WebChromeClient.CustomViewCallback customViewCallback) {
            this.f1805a = customViewCallback;
        }

        @Override // com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback
        public void onCustomViewHidden() {
            this.f1805a.onCustomViewHidden();
        }
    }

    /* renamed from: com.tencent.smtt.sdk.SystemWebChromeClient$c */
    /* loaded from: classes4.dex */
    public class C1304c implements GeolocationPermissionsCallback {

        /* renamed from: a */
        public GeolocationPermissions.Callback f1807a;

        public C1304c(GeolocationPermissions.Callback callback) {
            this.f1807a = callback;
        }

        @Override // com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback
        public void invoke(String str, boolean z, boolean z2) {
            this.f1807a.invoke(str, z, z2);
        }
    }

    /* renamed from: com.tencent.smtt.sdk.SystemWebChromeClient$d */
    /* loaded from: classes4.dex */
    public class C1305d implements JsPromptResult {

        /* renamed from: a */
        public android.webkit.JsPromptResult f1809a;

        public C1305d(android.webkit.JsPromptResult jsPromptResult) {
            this.f1809a = jsPromptResult;
        }

        @Override // com.tencent.smtt.export.external.interfaces.JsResult
        public void cancel() {
            this.f1809a.cancel();
        }

        @Override // com.tencent.smtt.export.external.interfaces.JsResult
        public void confirm() {
            this.f1809a.confirm();
        }

        @Override // com.tencent.smtt.export.external.interfaces.JsPromptResult
        public void confirm(String str) {
            this.f1809a.confirm(str);
        }
    }

    /* renamed from: com.tencent.smtt.sdk.SystemWebChromeClient$e */
    /* loaded from: classes4.dex */
    public class C1306e implements JsResult {

        /* renamed from: a */
        public android.webkit.JsResult f1811a;

        public C1306e(android.webkit.JsResult jsResult) {
            this.f1811a = jsResult;
        }

        @Override // com.tencent.smtt.export.external.interfaces.JsResult
        public void cancel() {
            this.f1811a.cancel();
        }

        @Override // com.tencent.smtt.export.external.interfaces.JsResult
        public void confirm() {
            this.f1811a.confirm();
        }
    }

    /* renamed from: com.tencent.smtt.sdk.SystemWebChromeClient$f */
    /* loaded from: classes4.dex */
    public class C1307f implements WebStorage.QuotaUpdater {

        /* renamed from: a */
        public WebStorage.QuotaUpdater f1813a;

        public C1307f(WebStorage.QuotaUpdater quotaUpdater) {
            this.f1813a = quotaUpdater;
        }

        @Override // com.tencent.smtt.sdk.WebStorage.QuotaUpdater
        public void updateQuota(long j) {
            this.f1813a.updateQuota(j);
        }
    }

    public SystemWebChromeClient(WebView webView, WebChromeClient webChromeClient) {
        this.f1785b = webView;
        this.f1784a = webChromeClient;
    }

    @Override // android.webkit.WebChromeClient
    @TargetApi(7)
    public Bitmap getDefaultVideoPoster() {
        Bitmap defaultVideoPoster = this.f1784a.getDefaultVideoPoster();
        if (defaultVideoPoster == null) {
            try {
                return Build.VERSION.SDK_INT >= 24 ? BitmapFactory.decodeResource(this.f1785b.getResources(), 17301540) : defaultVideoPoster;
            } catch (Exception unused) {
                return defaultVideoPoster;
            }
        }
        return defaultVideoPoster;
    }

    @Override // android.webkit.WebChromeClient
    @TargetApi(7)
    public View getVideoLoadingProgressView() {
        return this.f1784a.getVideoLoadingProgressView();
    }

    @Override // android.webkit.WebChromeClient
    public void getVisitedHistory(final android.webkit.ValueCallback<String[]> valueCallback) {
        this.f1784a.getVisitedHistory(new ValueCallback<String[]>() { // from class: com.tencent.smtt.sdk.SystemWebChromeClient.1
            @Override // com.tencent.smtt.sdk.ValueCallback, android.webkit.ValueCallback
            /* renamed from: a */
            public void onReceiveValue(String[] strArr) {
                valueCallback.onReceiveValue(strArr);
            }
        });
    }

    @Override // android.webkit.WebChromeClient
    public void onCloseWindow(android.webkit.WebView webView) {
        this.f1785b.m2703a(webView);
        this.f1784a.onCloseWindow(this.f1785b);
    }

    @Override // android.webkit.WebChromeClient
    public void onConsoleMessage(String str, int i, String str2) {
        this.f1784a.onConsoleMessage(new C1302a(str, str2, i));
    }

    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(android.webkit.ConsoleMessage consoleMessage) {
        return this.f1784a.onConsoleMessage(new C1302a(consoleMessage));
    }

    @Override // android.webkit.WebChromeClient
    public boolean onCreateWindow(android.webkit.WebView webView, boolean z, boolean z2, final Message message) {
        WebView webView2 = this.f1785b;
        webView2.getClass();
        final WebView.WebViewTransport webViewTransport = new WebView.WebViewTransport();
        Message obtain = Message.obtain(message.getTarget(), new Runnable() { // from class: com.tencent.smtt.sdk.SystemWebChromeClient.2
            @Override // java.lang.Runnable
            public void run() {
                WebView webView3 = webViewTransport.getWebView();
                if (webView3 != null) {
                    ((WebView.WebViewTransport) message.obj).setWebView(webView3.m2707a());
                }
                message.sendToTarget();
            }
        });
        obtain.obj = webViewTransport;
        return this.f1784a.onCreateWindow(this.f1785b, z, z2, obtain);
    }

    @Override // android.webkit.WebChromeClient
    @TargetApi(5)
    @Deprecated
    public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        this.f1784a.onExceededDatabaseQuota(str, str2, j, j2, j3, new C1307f(quotaUpdater));
    }

    @Override // android.webkit.WebChromeClient
    @TargetApi(5)
    public void onGeolocationPermissionsHidePrompt() {
        this.f1784a.onGeolocationPermissionsHidePrompt();
    }

    @Override // android.webkit.WebChromeClient
    @TargetApi(5)
    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        this.f1784a.onGeolocationPermissionsShowPrompt(str, new C1304c(callback));
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(android.webkit.WebView webView, String str, String str2, android.webkit.JsResult jsResult) {
        this.f1785b.m2703a(webView);
        return this.f1784a.onJsAlert(this.f1785b, str, str2, new C1306e(jsResult));
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsBeforeUnload(android.webkit.WebView webView, String str, String str2, android.webkit.JsResult jsResult) {
        this.f1785b.m2703a(webView);
        return this.f1784a.onJsBeforeUnload(this.f1785b, str, str2, new C1306e(jsResult));
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsConfirm(android.webkit.WebView webView, String str, String str2, android.webkit.JsResult jsResult) {
        this.f1785b.m2703a(webView);
        return this.f1784a.onJsConfirm(this.f1785b, str, str2, new C1306e(jsResult));
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(android.webkit.WebView webView, String str, String str2, String str3, android.webkit.JsPromptResult jsPromptResult) {
        this.f1785b.m2703a(webView);
        return this.f1784a.onJsPrompt(this.f1785b, str, str2, str3, new C1305d(jsPromptResult));
    }

    @Override // android.webkit.WebChromeClient
    @TargetApi(7)
    public boolean onJsTimeout() {
        return this.f1784a.onJsTimeout();
    }

    @Override // android.webkit.WebChromeClient
    public void onPermissionRequest(final PermissionRequest permissionRequest) {
        this.f1784a.onPermissionRequest(new com.tencent.smtt.export.external.interfaces.PermissionRequest() { // from class: com.tencent.smtt.sdk.SystemWebChromeClient.6
            @Override // com.tencent.smtt.export.external.interfaces.PermissionRequest
            public void deny() {
                permissionRequest.deny();
            }

            @Override // com.tencent.smtt.export.external.interfaces.PermissionRequest
            public Uri getOrigin() {
                return permissionRequest.getOrigin();
            }

            @Override // com.tencent.smtt.export.external.interfaces.PermissionRequest
            public String[] getResources() {
                return permissionRequest.getResources();
            }

            @Override // com.tencent.smtt.export.external.interfaces.PermissionRequest
            public void grant(String[] strArr) {
                permissionRequest.grant(strArr);
            }
        });
    }

    @Override // android.webkit.WebChromeClient
    public void onPermissionRequestCanceled(final PermissionRequest permissionRequest) {
        this.f1784a.onPermissionRequestCanceled(new com.tencent.smtt.export.external.interfaces.PermissionRequest() { // from class: com.tencent.smtt.sdk.SystemWebChromeClient.7
            @Override // com.tencent.smtt.export.external.interfaces.PermissionRequest
            public void deny() {
                permissionRequest.deny();
            }

            @Override // com.tencent.smtt.export.external.interfaces.PermissionRequest
            public Uri getOrigin() {
                return permissionRequest.getOrigin();
            }

            @Override // com.tencent.smtt.export.external.interfaces.PermissionRequest
            public String[] getResources() {
                return permissionRequest.getResources();
            }

            @Override // com.tencent.smtt.export.external.interfaces.PermissionRequest
            public void grant(String[] strArr) {
                permissionRequest.grant(strArr);
            }
        });
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(android.webkit.WebView webView, int i) {
        this.f1785b.m2703a(webView);
        this.f1784a.onProgressChanged(this.f1785b, i);
    }

    @Override // android.webkit.WebChromeClient
    @TargetApi(7)
    @Deprecated
    public void onReachedMaxAppCacheSize(long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
        this.f1784a.onReachedMaxAppCacheSize(j, j2, new C1307f(quotaUpdater));
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedIcon(android.webkit.WebView webView, Bitmap bitmap) {
        this.f1785b.m2703a(webView);
        this.f1784a.onReceivedIcon(this.f1785b, bitmap);
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(android.webkit.WebView webView, String str) {
        this.f1785b.m2703a(webView);
        this.f1784a.onReceivedTitle(this.f1785b, str);
    }

    @Override // android.webkit.WebChromeClient
    @TargetApi(7)
    public void onReceivedTouchIconUrl(android.webkit.WebView webView, String str, boolean z) {
        this.f1785b.m2703a(webView);
        this.f1784a.onReceivedTouchIconUrl(this.f1785b, str, z);
    }

    @Override // android.webkit.WebChromeClient
    public void onRequestFocus(android.webkit.WebView webView) {
        this.f1785b.m2703a(webView);
        this.f1784a.onRequestFocus(this.f1785b);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onShowFileChooser(android.webkit.WebView webView, final android.webkit.ValueCallback<Uri[]> valueCallback, final WebChromeClient.FileChooserParams fileChooserParams) {
        ValueCallback<Uri[]> valueCallback2 = new ValueCallback<Uri[]>() { // from class: com.tencent.smtt.sdk.SystemWebChromeClient.4
            @Override // com.tencent.smtt.sdk.ValueCallback, android.webkit.ValueCallback
            /* renamed from: a */
            public void onReceiveValue(Uri[] uriArr) {
                valueCallback.onReceiveValue(uriArr);
            }
        };
        WebChromeClient.FileChooserParams fileChooserParams2 = new WebChromeClient.FileChooserParams() { // from class: com.tencent.smtt.sdk.SystemWebChromeClient.5
            @Override // com.tencent.smtt.sdk.WebChromeClient.FileChooserParams
            public Intent createIntent() {
                return fileChooserParams.createIntent();
            }

            @Override // com.tencent.smtt.sdk.WebChromeClient.FileChooserParams
            public String[] getAcceptTypes() {
                return fileChooserParams.getAcceptTypes();
            }

            @Override // com.tencent.smtt.sdk.WebChromeClient.FileChooserParams
            public String getFilenameHint() {
                return fileChooserParams.getFilenameHint();
            }

            @Override // com.tencent.smtt.sdk.WebChromeClient.FileChooserParams
            public int getMode() {
                return fileChooserParams.getMode();
            }

            @Override // com.tencent.smtt.sdk.WebChromeClient.FileChooserParams
            public CharSequence getTitle() {
                return fileChooserParams.getTitle();
            }

            @Override // com.tencent.smtt.sdk.WebChromeClient.FileChooserParams
            public boolean isCaptureEnabled() {
                return fileChooserParams.isCaptureEnabled();
            }
        };
        this.f1785b.m2703a(webView);
        return this.f1784a.onShowFileChooser(this.f1785b, valueCallback2, fileChooserParams2);
    }

    public void openFileChooser(android.webkit.ValueCallback<Uri> valueCallback) {
        openFileChooser(valueCallback, null, null);
    }

    public void openFileChooser(android.webkit.ValueCallback<Uri> valueCallback, String str) {
        openFileChooser(valueCallback, str, null);
    }

    public void openFileChooser(final android.webkit.ValueCallback<Uri> valueCallback, String str, String str2) {
        this.f1784a.openFileChooser(new ValueCallback<Uri>() { // from class: com.tencent.smtt.sdk.SystemWebChromeClient.3
            @Override // com.tencent.smtt.sdk.ValueCallback, android.webkit.ValueCallback
            /* renamed from: a */
            public void onReceiveValue(Uri uri) {
                valueCallback.onReceiveValue(uri);
            }
        }, str, str2);
    }

    public void setupAutoFill(Message message) {
    }
}
