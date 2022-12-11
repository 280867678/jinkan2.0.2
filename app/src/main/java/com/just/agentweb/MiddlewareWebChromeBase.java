package com.just.agentweb;

/* loaded from: classes3.dex */
public class MiddlewareWebChromeBase extends WebChromeClientDelegate {
    public MiddlewareWebChromeBase mMiddlewareWebChromeBase;

    public MiddlewareWebChromeBase() {
        super(null);
    }

    public MiddlewareWebChromeBase(android.webkit.WebChromeClient webChromeClient) {
        super(webChromeClient);
    }

    public final MiddlewareWebChromeBase enq(MiddlewareWebChromeBase middlewareWebChromeBase) {
        setDelegate(middlewareWebChromeBase);
        this.mMiddlewareWebChromeBase = middlewareWebChromeBase;
        return middlewareWebChromeBase;
    }

    public final MiddlewareWebChromeBase next() {
        return this.mMiddlewareWebChromeBase;
    }

    @Override // com.just.agentweb.WebChromeClientDelegate
    public final void setDelegate(android.webkit.WebChromeClient webChromeClient) {
        super.setDelegate(webChromeClient);
    }
}
