package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsError;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue;
import java.net.URL;

/* loaded from: classes4.dex */
public final class JsContext {

    /* renamed from: a */
    public final JsVirtualMachine f1713a;

    /* renamed from: b */
    public final IX5JsContext f1714b;

    /* renamed from: c */
    public ExceptionHandler f1715c;

    /* renamed from: d */
    public String f1716d;

    /* loaded from: classes4.dex */
    public interface ExceptionHandler {
        void handleException(JsContext jsContext, JsError jsError);
    }

    public JsContext(Context context) {
        this(new JsVirtualMachine(context));
    }

    public JsContext(JsVirtualMachine jsVirtualMachine) {
        if (jsVirtualMachine != null) {
            this.f1713a = jsVirtualMachine;
            IX5JsContext m2844a = jsVirtualMachine.m2844a();
            this.f1714b = m2844a;
            try {
                m2844a.setPerContextData(this);
                return;
            } catch (AbstractMethodError unused) {
                return;
            }
        }
        throw new IllegalArgumentException("The virtualMachine value can not be null");
    }

    public static JsContext current() {
        return (JsContext) X5JsCore.m2665a();
    }

    public void addJavascriptInterface(Object obj, String str) {
        this.f1714b.addJavascriptInterface(obj, str);
    }

    public void destroy() {
        this.f1714b.destroy();
    }

    public void evaluateJavascript(String str, android.webkit.ValueCallback<String> valueCallback) {
        evaluateJavascript(str, valueCallback, null);
    }

    public void evaluateJavascript(String str, android.webkit.ValueCallback<String> valueCallback, URL url) {
        this.f1714b.evaluateJavascript(str, valueCallback, url);
    }

    public JsValue evaluateScript(String str) {
        return evaluateScript(str, null);
    }

    public JsValue evaluateScript(String str, URL url) {
        IX5JsValue evaluateScript = this.f1714b.evaluateScript(str, url);
        if (evaluateScript == null) {
            return null;
        }
        return new JsValue(this, evaluateScript);
    }

    public void evaluateScriptAsync(String str, final android.webkit.ValueCallback<JsValue> valueCallback, URL url) {
        this.f1714b.evaluateScriptAsync(str, valueCallback == null ? null : new android.webkit.ValueCallback<IX5JsValue>() { // from class: com.tencent.smtt.sdk.JsContext.1
            @Override // android.webkit.ValueCallback
            /* renamed from: a */
            public void onReceiveValue(IX5JsValue iX5JsValue) {
                valueCallback.onReceiveValue(iX5JsValue == null ? null : new JsValue(JsContext.this, iX5JsValue));
            }
        }, url);
    }

    public ExceptionHandler exceptionHandler() {
        return this.f1715c;
    }

    public byte[] getNativeBuffer(int i) {
        return this.f1714b.getNativeBuffer(i);
    }

    public int getNativeBufferId() {
        return this.f1714b.getNativeBufferId();
    }

    public String name() {
        return this.f1716d;
    }

    public void removeJavascriptInterface(String str) {
        this.f1714b.removeJavascriptInterface(str);
    }

    public void setExceptionHandler(ExceptionHandler exceptionHandler) {
        IX5JsContext iX5JsContext;
        android.webkit.ValueCallback<IX5JsError> valueCallback;
        this.f1715c = exceptionHandler;
        if (exceptionHandler == null) {
            iX5JsContext = this.f1714b;
            valueCallback = null;
        } else {
            iX5JsContext = this.f1714b;
            valueCallback = new android.webkit.ValueCallback<IX5JsError>() { // from class: com.tencent.smtt.sdk.JsContext.2
                @Override // android.webkit.ValueCallback
                /* renamed from: a */
                public void onReceiveValue(IX5JsError iX5JsError) {
                    JsContext.this.f1715c.handleException(JsContext.this, new JsError(iX5JsError));
                }
            };
        }
        iX5JsContext.setExceptionHandler(valueCallback);
    }

    public void setName(String str) {
        this.f1716d = str;
        this.f1714b.setName(str);
    }

    public int setNativeBuffer(int i, byte[] bArr) {
        return this.f1714b.setNativeBuffer(i, bArr);
    }

    public void stealValueFromOtherCtx(String str, JsContext jsContext, String str2) {
        this.f1714b.stealValueFromOtherCtx(str, jsContext.f1714b, str2);
    }

    public JsVirtualMachine virtualMachine() {
        return this.f1713a;
    }
}
