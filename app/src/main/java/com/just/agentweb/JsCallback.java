package com.just.agentweb;

import android.webkit.WebView;
import java.lang.ref.WeakReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class JsCallback {
    public static final String CALLBACK_JS_FORMAT = "javascript:%s.callback(%d, %d %s);";
    public boolean mCouldGoOn = true;
    public int mIndex;
    public String mInjectedName;
    public int mIsPermanent;
    public WeakReference<WebView> mWebViewRef;

    /* loaded from: classes3.dex */
    public static class JsCallbackException extends Exception {
        public JsCallbackException(String str) {
            super(str);
        }
    }

    public JsCallback(WebView webView, String str, int i) {
        this.mWebViewRef = new WeakReference<>(webView);
        this.mInjectedName = str;
        this.mIndex = i;
    }

    private boolean isJavaScriptObject(Object obj) {
        if ((obj instanceof JSONObject) || (obj instanceof JSONArray)) {
            return true;
        }
        String obj2 = obj.toString();
        try {
            try {
                new JSONObject(obj2);
            } catch (JSONException unused) {
                new JSONArray(obj2);
            }
            return true;
        } catch (JSONException unused2) {
            return false;
        }
    }

    public void apply(Object... objArr) throws JsCallbackException {
        if (this.mWebViewRef.get() != null) {
            if (!this.mCouldGoOn) {
                throw new JsCallbackException("the JsCallback isn't permanent,cannot be called more than once");
            }
            StringBuilder sb = new StringBuilder();
            boolean z = false;
            for (Object obj : objArr) {
                sb.append(",");
                boolean z2 = obj instanceof String;
                boolean isJavaScriptObject = isJavaScriptObject(obj);
                if (z2 && !isJavaScriptObject) {
                    sb.append("\"");
                }
                sb.append(String.valueOf(obj));
                if (z2 && !isJavaScriptObject) {
                    sb.append("\"");
                }
            }
            String format = String.format(CALLBACK_JS_FORMAT, this.mInjectedName, Integer.valueOf(this.mIndex), Integer.valueOf(this.mIsPermanent), sb.toString());
            LogUtils.isDebug();
            this.mWebViewRef.get().loadUrl(format);
            if (this.mIsPermanent > 0) {
                z = true;
            }
            this.mCouldGoOn = z;
            return;
        }
        throw new JsCallbackException("the WebView related to the JsCallback has been recycled");
    }

    public void setPermanent(boolean z) {
        this.mIsPermanent = z ? 1 : 0;
    }
}
