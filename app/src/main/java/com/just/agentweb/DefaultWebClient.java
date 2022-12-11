package com.just.agentweb;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.annotation.RequiresApi;
import com.alipay.sdk.app.H5PayCallback;
import com.alipay.sdk.app.PayTask;
import com.alipay.sdk.util.H5PayResultModel;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public class DefaultWebClient extends MiddlewareWebClientBase {
    public static final String ALIPAYS_SCHEME = "alipays://";
    public static final int ASK_USER_OPEN_OTHER_PAGE = 250;
    public static final int CONSTANTS_ABNORMAL_BIG = 7;
    public static final int DERECT_OPEN_OTHER_PAGE = 1001;
    public static final int DISALLOW_OPEN_OTHER_APP = 62;
    public static final boolean HAS_ALIPAY_LIB;
    public static final String HTTPS_SCHEME = "https://";
    public static final String HTTP_SCHEME = "http://";
    public static final String INTENT_SCHEME = "intent://";
    public static final String SCHEME_SMS = "sms:";
    public static final String TAG = DefaultWebClient.class.getSimpleName();
    public static final String WEBCHAT_PAY_SCHEME = "weixin://wap/pay?";
    public WeakReference<AbsAgentWebUIController> mAgentWebUIController;
    public boolean mIsInterceptUnkownUrl;
    public Object mPayTask;
    public int mUrlHandleWays;
    public WeakReference<Activity> mWeakReference;
    public WebView mWebView;
    public android.webkit.WebViewClient mWebViewClient;
    public boolean webClientHelper;
    public Handler.Callback mCallback = null;
    public Method onMainFrameErrorMethod = null;
    public Set<String> mErrorUrlsSet = new HashSet();
    public Set<String> mWaittingFinishSet = new HashSet();

    /* loaded from: classes3.dex */
    public static class Builder {
        public Activity mActivity;
        public android.webkit.WebViewClient mClient;
        public boolean mIsInterceptUnkownScheme = true;
        public PermissionInterceptor mPermissionInterceptor;
        public int mUrlHandleWays;
        public boolean mWebClientHelper;
        public WebView mWebView;

        public DefaultWebClient build() {
            return new DefaultWebClient(this);
        }

        public Builder setActivity(Activity activity) {
            this.mActivity = activity;
            return this;
        }

        public Builder setClient(android.webkit.WebViewClient webViewClient) {
            this.mClient = webViewClient;
            return this;
        }

        public Builder setInterceptUnkownUrl(boolean z) {
            this.mIsInterceptUnkownScheme = z;
            return this;
        }

        public Builder setPermissionInterceptor(PermissionInterceptor permissionInterceptor) {
            this.mPermissionInterceptor = permissionInterceptor;
            return this;
        }

        public Builder setUrlHandleWays(int i) {
            this.mUrlHandleWays = i;
            return this;
        }

        public Builder setWebClientHelper(boolean z) {
            this.mWebClientHelper = z;
            return this;
        }

        public Builder setWebView(WebView webView) {
            this.mWebView = webView;
            return this;
        }
    }

    /* loaded from: classes3.dex */
    public enum OpenOtherPageWays {
        DERECT(1001),
        ASK(250),
        DISALLOW(62);
        
        public int code;

        OpenOtherPageWays(int i) {
            this.code = i;
        }
    }

    static {
        boolean z;
        try {
            Class.forName("com.alipay.sdk.app.PayTask");
            z = true;
        } catch (Throwable unused) {
            z = false;
        }
        HAS_ALIPAY_LIB = z;
        String str = TAG;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("HAS_ALIPAY_LIB:");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(HAS_ALIPAY_LIB);
        LogUtils.m3701i(str, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
    }

    public DefaultWebClient(Builder builder) {
        super(builder.mClient);
        this.mWeakReference = null;
        this.webClientHelper = true;
        this.mUrlHandleWays = 250;
        this.mIsInterceptUnkownUrl = true;
        this.mAgentWebUIController = null;
        this.mWebView = builder.mWebView;
        this.mWebViewClient = builder.mClient;
        this.mWeakReference = new WeakReference<>(builder.mActivity);
        this.webClientHelper = builder.mWebClientHelper;
        this.mAgentWebUIController = new WeakReference<>(AgentWebUtils.getAgentWebUIControllerByWebView(builder.mWebView));
        this.mIsInterceptUnkownUrl = builder.mIsInterceptUnkownScheme;
        if (builder.mUrlHandleWays <= 0) {
            this.mUrlHandleWays = 250;
        } else {
            this.mUrlHandleWays = builder.mUrlHandleWays;
        }
    }

    public static Builder createBuilder() {
        return new Builder();
    }

    private boolean deepLink(String str) {
        ResolveInfo lookupResolveInfo;
        int i = this.mUrlHandleWays;
        if (i != 250) {
            if (i != 1001) {
                return false;
            }
            lookup(str);
            return true;
        }
        Activity activity = this.mWeakReference.get();
        if (activity == null || (lookupResolveInfo = lookupResolveInfo(str)) == null) {
            return false;
        }
        ActivityInfo activityInfo = lookupResolveInfo.activityInfo;
        String str2 = TAG;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("resolve package:");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(lookupResolveInfo.activityInfo.packageName);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" app package:");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(activity.getPackageName());
        LogUtils.m3703e(str2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        if (activityInfo != null && !TextUtils.isEmpty(activityInfo.packageName) && activityInfo.packageName.equals(activity.getPackageName())) {
            return lookup(str);
        }
        if (this.mAgentWebUIController.get() != null) {
            WebView webView = this.mWebView;
            this.mAgentWebUIController.get().onOpenPagePrompt(webView, webView.getUrl(), getCallback(str));
        }
        return true;
    }

    private Handler.Callback getCallback(final String str) {
        Handler.Callback callback = this.mCallback;
        if (callback != null) {
            return callback;
        }
        Handler.Callback callback2 = new Handler.Callback() { // from class: com.just.agentweb.DefaultWebClient.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.what != 1) {
                    return true;
                }
                DefaultWebClient.this.lookup(str);
                return true;
            }
        };
        this.mCallback = callback2;
        return callback2;
    }

    private boolean handleCommonLink(String str) {
        if (str.startsWith(com.tencent.smtt.sdk.WebView.SCHEME_TEL) || str.startsWith(SCHEME_SMS) || str.startsWith("mailto:") || str.startsWith(com.tencent.smtt.sdk.WebView.SCHEME_GEO)) {
            try {
                Activity activity = this.mWeakReference.get();
                if (activity == null) {
                    return false;
                }
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                activity.startActivity(intent);
                return true;
            } catch (ActivityNotFoundException e) {
                if (!AgentWebConfig.DEBUG) {
                    return true;
                }
                e.printStackTrace();
                return true;
            }
        }
        return false;
    }

    private void handleIntentUrl(String str) {
        try {
            if (!TextUtils.isEmpty(str) && str.startsWith(INTENT_SCHEME)) {
                if (!lookup(str)) {
                }
            }
        } catch (Throwable th) {
            if (!LogUtils.isDebug()) {
                return;
            }
            th.printStackTrace();
        }
    }

    private boolean isAlipay(final WebView webView, String str) {
        try {
            Activity activity = this.mWeakReference.get();
            if (activity == null) {
                return false;
            }
            if (this.mPayTask == null) {
                this.mPayTask = Class.forName("com.alipay.sdk.app.PayTask").getConstructor(Activity.class).newInstance(activity);
            }
            boolean payInterceptorWithUrl = ((PayTask) this.mPayTask).payInterceptorWithUrl(str, true, new H5PayCallback() { // from class: com.just.agentweb.DefaultWebClient.1
                public void onPayResult(H5PayResultModel h5PayResultModel) {
                    final String returnUrl = h5PayResultModel.getReturnUrl();
                    if (!TextUtils.isEmpty(returnUrl)) {
                        AgentWebUtils.runInUiThread(new Runnable() { // from class: com.just.agentweb.DefaultWebClient.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                webView.loadUrl(returnUrl);
                            }
                        });
                    }
                }
            });
            if (payInterceptorWithUrl) {
                String str2 = TAG;
                LogUtils.m3701i(str2, "alipay-isIntercepted:" + payInterceptorWithUrl + "  url:" + str);
            }
            return payInterceptorWithUrl;
        } catch (Throwable unused) {
            boolean z = AgentWebConfig.DEBUG;
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean lookup(String str) {
        try {
            Activity activity = this.mWeakReference.get();
            if (activity == null) {
                return true;
            }
            PackageManager packageManager = activity.getPackageManager();
            Intent parseUri = Intent.parseUri(str, 1);
            if (packageManager.resolveActivity(parseUri, 65536) == null) {
                return false;
            }
            activity.startActivity(parseUri);
            return true;
        } catch (Throwable th) {
            if (!LogUtils.isDebug()) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    private ResolveInfo lookupResolveInfo(String str) {
        try {
            Activity activity = this.mWeakReference.get();
            if (activity != null) {
                return activity.getPackageManager().resolveActivity(Intent.parseUri(str, 1), 65536);
            }
            return null;
        } catch (Throwable th) {
            if (LogUtils.isDebug()) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0033, code lost:
        if (r2 != null) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void onMainFrameError(WebView webView, int i, String str, String str2) {
        this.mErrorUrlsSet.add(str2);
        android.webkit.WebViewClient webViewClient = this.mWebViewClient;
        if (webViewClient != null && this.webClientHelper) {
            Method method = this.onMainFrameErrorMethod;
            if (method == null) {
                method = AgentWebUtils.isExistMethod(webViewClient, "onMainFrameError", AbsAgentWebUIController.class, WebView.class, Integer.TYPE, String.class, String.class);
                this.onMainFrameErrorMethod = method;
            }
            try {
                method.invoke(this.mWebViewClient, this.mAgentWebUIController.get(), webView, Integer.valueOf(i), str, str2);
                return;
            } catch (Throwable th) {
                if (!LogUtils.isDebug()) {
                    return;
                }
                th.printStackTrace();
                return;
            }
        }
        if (this.mAgentWebUIController.get() != null) {
            this.mAgentWebUIController.get().onMainFrameError(webView, i, str, str2);
        }
    }

    private int queryActiviesNumber(String str) {
        try {
            if (this.mWeakReference.get() == null) {
                return 0;
            }
            List<ResolveInfo> queryIntentActivities = this.mWeakReference.get().getPackageManager().queryIntentActivities(Intent.parseUri(str, 1), 65536);
            if (queryIntentActivities != null) {
                return queryIntentActivities.size();
            }
            return 0;
        } catch (URISyntaxException e) {
            if (LogUtils.isDebug()) {
                e.printStackTrace();
            }
            return 0;
        }
    }

    private void startActivity(String str) {
        try {
            if (this.mWeakReference.get() == null) {
                return;
            }
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            this.mWeakReference.get().startActivity(intent);
        } catch (Exception e) {
            if (!LogUtils.isDebug()) {
                return;
            }
            e.printStackTrace();
        }
    }

    @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
    public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        if (!this.mWaittingFinishSet.contains(str)) {
            this.mWaittingFinishSet.add(str);
        }
        super.doUpdateVisitedHistory(webView, str, z);
    }

    @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        if (this.mErrorUrlsSet.contains(str) || !this.mWaittingFinishSet.contains(str)) {
            webView.setVisibility(0);
        } else if (this.mAgentWebUIController.get() != null) {
            this.mAgentWebUIController.get().onShowMainFrame();
        }
        if (this.mWaittingFinishSet.contains(str)) {
            this.mWaittingFinishSet.remove(str);
        }
        if (!this.mErrorUrlsSet.isEmpty()) {
            this.mErrorUrlsSet.clear();
        }
        super.onPageFinished(webView, str);
    }

    @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        if (!this.mWaittingFinishSet.contains(str)) {
            this.mWaittingFinishSet.add(str);
        }
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        String str3 = TAG;
        LogUtils.m3701i(str3, "onReceivedError：" + str + "  CODE:" + i);
        if ((str2 != null || i == -12) && i != -1) {
            if (i != -2 && str2 != null && !str2.equals(webView.getUrl()) && !str2.equals(webView.getOriginalUrl())) {
                return;
            }
            onMainFrameError(webView, i, str, str2);
        }
    }

    @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
    @RequiresApi(api = 21)
    @TargetApi(23)
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        String uri = webResourceRequest.getUrl().toString();
        int errorCode = webResourceError.getErrorCode();
        if (!webResourceRequest.isForMainFrame()) {
            return;
        }
        if ((uri == null && errorCode != -12) || errorCode == -1) {
            return;
        }
        String str = TAG;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("onReceivedError:");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append((Object) webResourceError.getDescription());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" code:");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(webResourceError.getErrorCode());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" failingUrl:");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(uri);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" getUrl:");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(webView.getUrl());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" getOriginalUrl:");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(webView.getOriginalUrl());
        LogUtils.m3701i(str, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        if (errorCode != -2 && uri != null && !uri.equals(webView.getUrl()) && !uri.equals(webView.getOriginalUrl())) {
            return;
        }
        onMainFrameError(webView, webResourceError.getErrorCode(), webResourceError.getDescription().toString(), webResourceRequest.getUrl().toString());
    }

    @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
    public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        super.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
    }

    @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
    }

    @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (this.mAgentWebUIController.get() != null) {
            this.mAgentWebUIController.get().onShowSslCertificateErrorDialog(webView, sslErrorHandler, sslError);
        }
    }

    @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
    public void onScaleChanged(WebView webView, float f, float f2) {
        String str = TAG;
        LogUtils.m3701i(str, "onScaleChanged:" + f + "   n:" + f2);
        if (f2 - f > 7.0f) {
            webView.setInitialScale((int) ((f / f2) * 100.0f));
        }
    }

    @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        return super.shouldInterceptRequest(webView, webResourceRequest);
    }

    @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return super.shouldInterceptRequest(webView, str);
    }

    @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        return super.shouldOverrideKeyEvent(webView, keyEvent);
    }

    @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
    @RequiresApi(api = 21)
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        String uri = webResourceRequest.getUrl().toString();
        if (uri.startsWith(HTTP_SCHEME) || uri.startsWith(HTTPS_SCHEME)) {
            return this.webClientHelper && HAS_ALIPAY_LIB && isAlipay(webView, uri);
        } else if (!this.webClientHelper) {
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        } else {
            if (handleCommonLink(uri)) {
                return true;
            }
            if (uri.startsWith(INTENT_SCHEME)) {
                handleIntentUrl(uri);
                LogUtils.m3701i(TAG, "intent url ");
                return true;
            } else if (uri.startsWith(WEBCHAT_PAY_SCHEME)) {
                LogUtils.m3701i(TAG, "lookup wechat to pay ~~");
                startActivity(uri);
                return true;
            } else if (uri.startsWith(ALIPAYS_SCHEME) && lookup(uri)) {
                LogUtils.m3701i(TAG, "alipays url lookup alipay ~~ ");
                return true;
            } else if (queryActiviesNumber(uri) > 0 && deepLink(uri)) {
                String str = TAG;
                LogUtils.m3701i(str, "intercept url:" + uri);
                return true;
            } else if (!this.mIsInterceptUnkownUrl) {
                return super.shouldOverrideUrlLoading(webView, webResourceRequest);
            } else {
                String str2 = TAG;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("intercept UnkownUrl :");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(webResourceRequest.getUrl());
                LogUtils.m3701i(str2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                return true;
            }
        }
    }

    @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        String str2;
        String str3;
        if (str.startsWith(HTTP_SCHEME) || str.startsWith(HTTPS_SCHEME)) {
            return this.webClientHelper && HAS_ALIPAY_LIB && isAlipay(webView, str);
        } else if (!this.webClientHelper) {
            return false;
        } else {
            if (handleCommonLink(str)) {
                return true;
            }
            if (str.startsWith(INTENT_SCHEME)) {
                handleIntentUrl(str);
                return true;
            } else if (str.startsWith(WEBCHAT_PAY_SCHEME)) {
                startActivity(str);
                return true;
            } else if (str.startsWith(ALIPAYS_SCHEME) && lookup(str)) {
                return true;
            } else {
                if (queryActiviesNumber(str) > 0 && deepLink(str)) {
                    str2 = TAG;
                    str3 = "intercept OtherAppScheme";
                } else if (!this.mIsInterceptUnkownUrl) {
                    return super.shouldOverrideUrlLoading(webView, str);
                } else {
                    str2 = TAG;
                    str3 = "intercept InterceptUnkownScheme : " + str;
                }
                LogUtils.m3701i(str2, str3);
                return true;
            }
        }
    }
}
