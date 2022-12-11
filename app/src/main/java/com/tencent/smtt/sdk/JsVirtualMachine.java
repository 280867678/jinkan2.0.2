package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Looper;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsError;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsVirtualMachine;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes4.dex */
public final class JsVirtualMachine {

    /* renamed from: a */
    public final Context f1723a;

    /* renamed from: b */
    public final IX5JsVirtualMachine f1724b;

    /* renamed from: c */
    public final HashSet<WeakReference<C1280a>> f1725c;

    /* renamed from: com.tencent.smtt.sdk.JsVirtualMachine$a */
    /* loaded from: classes4.dex */
    public static class C1280a implements IX5JsContext {

        /* renamed from: a */
        public WebView f1726a;

        public C1280a(Context context) {
            WebView webView = new WebView(context);
            this.f1726a = webView;
            webView.getSettings().setJavaScriptEnabled(true);
        }

        /* renamed from: a */
        public void m2843a() {
            WebView webView = this.f1726a;
            if (webView == null) {
                return;
            }
            webView.onPause();
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public void addJavascriptInterface(Object obj, String str) {
            WebView webView = this.f1726a;
            if (webView == null) {
                return;
            }
            webView.addJavascriptInterface(obj, str);
            this.f1726a.loadUrl("about:blank");
        }

        /* renamed from: b */
        public void m2842b() {
            WebView webView = this.f1726a;
            if (webView == null) {
                return;
            }
            webView.onResume();
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public void destroy() {
            WebView webView = this.f1726a;
            if (webView == null) {
                return;
            }
            webView.clearHistory();
            this.f1726a.clearCache(true);
            this.f1726a.loadUrl("about:blank");
            this.f1726a.freeMemory();
            this.f1726a.pauseTimers();
            this.f1726a.destroy();
            this.f1726a = null;
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public void evaluateJavascript(String str, final android.webkit.ValueCallback<String> valueCallback, URL url) {
            WebView webView = this.f1726a;
            if (webView == null) {
                return;
            }
            webView.evaluateJavascript(str, valueCallback == null ? null : new ValueCallback<String>() { // from class: com.tencent.smtt.sdk.JsVirtualMachine.a.1
                @Override // com.tencent.smtt.sdk.ValueCallback, android.webkit.ValueCallback
                /* renamed from: a */
                public void onReceiveValue(String str2) {
                    valueCallback.onReceiveValue(str2);
                }
            });
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public IX5JsValue evaluateScript(String str, URL url) {
            WebView webView = this.f1726a;
            if (webView == null) {
                return null;
            }
            webView.evaluateJavascript(str, null);
            return null;
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public void evaluateScriptAsync(String str, final android.webkit.ValueCallback<IX5JsValue> valueCallback, URL url) {
            WebView webView = this.f1726a;
            if (webView == null) {
                return;
            }
            webView.evaluateJavascript(str, valueCallback == null ? null : new ValueCallback<String>() { // from class: com.tencent.smtt.sdk.JsVirtualMachine.a.2
                @Override // com.tencent.smtt.sdk.ValueCallback, android.webkit.ValueCallback
                /* renamed from: a */
                public void onReceiveValue(String str2) {
                    valueCallback.onReceiveValue(null);
                }
            });
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public byte[] getNativeBuffer(int i) {
            return null;
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public int getNativeBufferId() {
            return -1;
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public void removeJavascriptInterface(String str) {
            WebView webView = this.f1726a;
            if (webView == null) {
                return;
            }
            webView.removeJavascriptInterface(str);
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public void setExceptionHandler(android.webkit.ValueCallback<IX5JsError> valueCallback) {
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public void setName(String str) {
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public int setNativeBuffer(int i, byte[] bArr) {
            return -1;
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public void setPerContextData(Object obj) {
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public void stealValueFromOtherCtx(String str, IX5JsContext iX5JsContext, String str2) {
        }
    }

    public JsVirtualMachine(Context context) {
        this(context, null);
    }

    public JsVirtualMachine(Context context, Looper looper) {
        this.f1725c = new HashSet<>();
        this.f1723a = context;
        this.f1724b = X5JsCore.m2664a(context, looper);
    }

    /* renamed from: a */
    public IX5JsContext m2844a() {
        IX5JsVirtualMachine iX5JsVirtualMachine = this.f1724b;
        if (iX5JsVirtualMachine == null) {
            C1280a c1280a = new C1280a(this.f1723a);
            this.f1725c.add(new WeakReference<>(c1280a));
            return c1280a;
        }
        return iX5JsVirtualMachine.createJsContext();
    }

    public void destroy() {
        IX5JsVirtualMachine iX5JsVirtualMachine = this.f1724b;
        if (iX5JsVirtualMachine != null) {
            iX5JsVirtualMachine.destroy();
            return;
        }
        Iterator<WeakReference<C1280a>> it = this.f1725c.iterator();
        while (it.hasNext()) {
            WeakReference<C1280a> next = it.next();
            if (next.get() != null) {
                next.get().destroy();
            }
        }
    }

    public Looper getLooper() {
        IX5JsVirtualMachine iX5JsVirtualMachine = this.f1724b;
        return iX5JsVirtualMachine != null ? iX5JsVirtualMachine.getLooper() : Looper.myLooper();
    }

    public boolean isFallback() {
        return this.f1724b == null;
    }

    public void onPause() {
        IX5JsVirtualMachine iX5JsVirtualMachine = this.f1724b;
        if (iX5JsVirtualMachine != null) {
            iX5JsVirtualMachine.onPause();
            return;
        }
        Iterator<WeakReference<C1280a>> it = this.f1725c.iterator();
        while (it.hasNext()) {
            WeakReference<C1280a> next = it.next();
            if (next.get() != null) {
                next.get().m2843a();
            }
        }
    }

    public void onResume() {
        IX5JsVirtualMachine iX5JsVirtualMachine = this.f1724b;
        if (iX5JsVirtualMachine != null) {
            iX5JsVirtualMachine.onResume();
            return;
        }
        Iterator<WeakReference<C1280a>> it = this.f1725c.iterator();
        while (it.hasNext()) {
            WeakReference<C1280a> next = it.next();
            if (next.get() != null) {
                next.get().m2842b();
            }
        }
    }
}
