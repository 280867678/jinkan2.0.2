package com.just.agentweb;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Pair;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.webkit.JsPromptResult;
import android.webkit.WebBackForwardList;
import android.webkit.WebView;
import android.widget.Toast;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import me.tvspark.outline;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class AgentWebView extends LollipopFixedWebView {
    public static final String TAG = AgentWebView.class.getSimpleName();
    public FixedOnReceivedTitle mFixedOnReceivedTitle;
    public Map<String, String> mInjectJavaScripts;
    public Boolean mIsAccessibilityEnabledOriginal;
    public boolean mIsInited;
    public Map<String, JsCallJava> mJsCallJavas;

    /* loaded from: classes3.dex */
    public static class AgentWebChrome extends MiddlewareWebChromeBase {
        public AgentWebView mAgentWebView;

        public AgentWebChrome(AgentWebView agentWebView) {
            this.mAgentWebView = agentWebView;
        }

        @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            JsCallJava jsCallJava;
            String unused = AgentWebView.TAG;
            if (this.mAgentWebView.mJsCallJavas == null || !JsCallJava.isSafeWebViewCallMsg(str2)) {
                return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
            }
            JSONObject msgJSONObject = JsCallJava.getMsgJSONObject(str2);
            String interfacedName = JsCallJava.getInterfacedName(msgJSONObject);
            if (interfacedName == null || (jsCallJava = (JsCallJava) this.mAgentWebView.mJsCallJavas.get(interfacedName)) == null) {
                return true;
            }
            jsPromptResult.confirm(jsCallJava.call(webView, msgJSONObject));
            return true;
        }

        @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            if (this.mAgentWebView.mJsCallJavas != null) {
                this.mAgentWebView.injectJavaScript();
                if (LogUtils.isDebug()) {
                    String unused = AgentWebView.TAG;
                    webView.getUrl();
                }
            }
            if (this.mAgentWebView.mInjectJavaScripts != null) {
                this.mAgentWebView.injectExtraJavaScript();
            }
            super.onProgressChanged(webView, i);
        }

        @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            this.mAgentWebView.mFixedOnReceivedTitle.onReceivedTitle();
            super.onReceivedTitle(webView, str);
        }
    }

    /* loaded from: classes3.dex */
    public static class AgentWebClient extends MiddlewareWebClientBase {
        public AgentWebView mAgentWebView;

        public AgentWebClient(AgentWebView agentWebView) {
            this.mAgentWebView = agentWebView;
        }

        @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            this.mAgentWebView.mFixedOnReceivedTitle.onPageFinished(webView);
            if (LogUtils.isDebug()) {
                String unused = AgentWebView.TAG;
                webView.getUrl();
            }
        }

        @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            if (this.mAgentWebView.mJsCallJavas != null) {
                this.mAgentWebView.injectJavaScript();
                if (LogUtils.isDebug()) {
                    String unused = AgentWebView.TAG;
                    webView.getUrl();
                }
            }
            if (this.mAgentWebView.mInjectJavaScripts != null) {
                this.mAgentWebView.injectExtraJavaScript();
            }
            this.mAgentWebView.mFixedOnReceivedTitle.onPageStarted();
            this.mAgentWebView.fixedAccessibilityInjectorExceptionForOnPageFinished(str);
        }
    }

    /* loaded from: classes3.dex */
    public static class FixedOnReceivedTitle {
        public boolean mIsOnReceivedTitle;
        public android.webkit.WebChromeClient mWebChromeClient;

        public FixedOnReceivedTitle() {
        }

        public void onPageFinished(WebView webView) {
            if (this.mIsOnReceivedTitle || this.mWebChromeClient == null) {
                return;
            }
            WebBackForwardList webBackForwardList = null;
            try {
                webBackForwardList = webView.copyBackForwardList();
            } catch (NullPointerException e) {
                if (LogUtils.isDebug()) {
                    e.printStackTrace();
                }
            }
            if (webBackForwardList == null || webBackForwardList.getSize() <= 0 || webBackForwardList.getCurrentIndex() < 0 || webBackForwardList.getItemAtIndex(webBackForwardList.getCurrentIndex()) == null) {
                return;
            }
            this.mWebChromeClient.onReceivedTitle(webView, webBackForwardList.getItemAtIndex(webBackForwardList.getCurrentIndex()).getTitle());
        }

        public void onPageStarted() {
            this.mIsOnReceivedTitle = false;
        }

        public void onReceivedTitle() {
            this.mIsOnReceivedTitle = true;
        }

        public void setWebChromeClient(android.webkit.WebChromeClient webChromeClient) {
            this.mWebChromeClient = webChromeClient;
        }
    }

    public AgentWebView(Context context) {
        this(context, null);
    }

    public AgentWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        removeSearchBoxJavaBridge();
        this.mIsInited = true;
        this.mFixedOnReceivedTitle = new FixedOnReceivedTitle();
    }

    private void fixedStillAttached() {
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).removeAllViewsInLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void injectExtraJavaScript() {
        for (Map.Entry<String, String> entry : this.mInjectJavaScripts.entrySet()) {
            loadUrl(buildNotRepeatInjectJS(entry.getKey(), entry.getValue()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void injectJavaScript() {
        for (Map.Entry<String, JsCallJava> entry : this.mJsCallJavas.entrySet()) {
            loadUrl(buildNotRepeatInjectJS(entry.getKey(), entry.getValue().getPreloadInterfaceJs()));
        }
    }

    private boolean isAccessibilityEnabled() {
        return ((AccessibilityManager) getContext().getSystemService("accessibility")).isEnabled();
    }

    public static Pair<Boolean, String> isWebViewPackageException(Throwable th) {
        String th2 = th.getCause() == null ? th.toString() : th.getCause().toString();
        String stackTraceString = Log.getStackTraceString(th);
        if (stackTraceString.contains("android.content.pm.PackageManager$NameNotFoundException") || stackTraceString.contains("java.lang.RuntimeException: Cannot load WebView") || stackTraceString.contains("android.webkit.WebViewFactory$MissingWebViewPackageException: Failed to load WebView provider: No WebView installed")) {
            LogUtils.safeCheckCrash(TAG, "isWebViewPackageException", th);
            return new Pair<>(true, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("WebView load failed, ", th2));
        }
        return new Pair<>(false, th2);
    }

    private void releaseConfigCallback() {
    }

    private void resetAccessibilityEnabled() {
        Boolean bool = this.mIsAccessibilityEnabledOriginal;
        if (bool != null) {
            setAccessibilityEnabled(bool.booleanValue());
        }
    }

    private void setAccessibilityEnabled(boolean z) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        try {
            Method declaredMethod = accessibilityManager.getClass().getDeclaredMethod("setAccessibilityState", Boolean.TYPE);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(accessibilityManager, Boolean.valueOf(z));
            declaredMethod.setAccessible(false);
        } catch (Throwable th) {
            if (!LogUtils.isDebug()) {
                return;
            }
            LogUtils.m3702e(TAG, "setAccessibilityEnabled", th);
        }
    }

    public void addInjectJavaScript(String str) {
        if (this.mInjectJavaScripts == null) {
            this.mInjectJavaScripts = new HashMap();
        }
        this.mInjectJavaScripts.put(String.valueOf(str.hashCode()), str);
        injectExtraJavaScript();
    }

    @Override // android.webkit.WebView
    @Deprecated
    public final void addJavascriptInterface(Object obj, String str) {
        super.addJavascriptInterface(obj, str);
    }

    public void addJavascriptInterfaceSupport(Object obj, String str) {
    }

    public String buildNotRepeatInjectJS(String str, String str2) {
        String format = String.format("__injectFlag_%1$s__", str);
        return "javascript:try{(function(){if(window." + format + "){console.log('" + format + " has been injected');return;}window." + format + "=true;" + str2 + "}())}catch(e){console.warn(e)}";
    }

    public String buildTryCatchInjectJS(String str) {
        return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("javascript:try{", str, "}catch(e){console.warn(e)}");
    }

    @Override // android.webkit.WebView
    public void clearHistory() {
        if (this.mIsInited) {
            super.clearHistory();
        }
    }

    @Override // android.webkit.WebView
    public void destroy() {
        setVisibility(8);
        Map<String, JsCallJava> map = this.mJsCallJavas;
        if (map != null) {
            map.clear();
        }
        Map<String, String> map2 = this.mInjectJavaScripts;
        if (map2 != null) {
            map2.clear();
        }
        removeAllViewsInLayout();
        fixedStillAttached();
        releaseConfigCallback();
        if (this.mIsInited) {
            resetAccessibilityEnabled();
            LogUtils.m3701i(TAG, "destroy web");
            super.destroy();
        }
    }

    public void fixedAccessibilityInjectorException() {
    }

    public void fixedAccessibilityInjectorExceptionForOnPageFinished(String str) {
    }

    @Override // android.webkit.WebView
    public boolean isPrivateBrowsingEnabled() {
        return super.isPrivateBrowsingEnabled();
    }

    @TargetApi(11)
    public boolean removeSearchBoxJavaBridge() {
        return false;
    }

    @Override // android.webkit.WebView, android.view.View
    public void setOverScrollMode(int i) {
        try {
            super.setOverScrollMode(i);
        } catch (Throwable th) {
            Pair<Boolean, String> isWebViewPackageException = isWebViewPackageException(th);
            if (!((Boolean) isWebViewPackageException.first).booleanValue()) {
                throw th;
            }
            Toast.makeText(getContext(), (CharSequence) isWebViewPackageException.second, 0).show();
            destroy();
        }
    }

    @Override // android.webkit.WebView
    public final void setWebChromeClient(android.webkit.WebChromeClient webChromeClient) {
        AgentWebChrome agentWebChrome = new AgentWebChrome();
        agentWebChrome.setDelegate(webChromeClient);
        this.mFixedOnReceivedTitle.setWebChromeClient(webChromeClient);
        super.setWebChromeClient(agentWebChrome);
        setWebChromeClientSupport(agentWebChrome);
    }

    public final void setWebChromeClientSupport(android.webkit.WebChromeClient webChromeClient) {
    }

    @Override // android.webkit.WebView
    public final void setWebViewClient(android.webkit.WebViewClient webViewClient) {
        AgentWebClient agentWebClient = new AgentWebClient();
        agentWebClient.setDelegate(webViewClient);
        super.setWebViewClient(agentWebClient);
        setWebViewClientSupport(agentWebClient);
    }

    public final void setWebViewClientSupport(android.webkit.WebViewClient webViewClient) {
    }

    @TargetApi(19)
    public void trySetWebDebuggEnabled() {
        if (LogUtils.isDebug()) {
            try {
                WebView.class.getMethod("setWebContentsDebuggingEnabled", Boolean.TYPE).invoke(null, true);
            } catch (Throwable th) {
                if (!LogUtils.isDebug()) {
                    return;
                }
                th.printStackTrace();
            }
        }
    }
}
