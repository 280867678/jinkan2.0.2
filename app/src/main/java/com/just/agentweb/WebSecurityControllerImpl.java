package com.just.agentweb;

import android.webkit.WebView;
import androidx.collection.ArrayMap;
import com.just.agentweb.AgentWeb;

/* loaded from: classes3.dex */
public class WebSecurityControllerImpl implements WebSecurityController<WebSecurityCheckLogic> {
    public ArrayMap<String, Object> mMap;
    public AgentWeb.SecurityType mSecurityType;
    public WebView mWebView;

    public WebSecurityControllerImpl(WebView webView, ArrayMap<String, Object> arrayMap, AgentWeb.SecurityType securityType) {
        this.mWebView = webView;
        this.mMap = arrayMap;
        this.mSecurityType = securityType;
    }

    @Override // com.just.agentweb.WebSecurityController
    public void check(WebSecurityCheckLogic webSecurityCheckLogic) {
        webSecurityCheckLogic.dealHoneyComb(this.mWebView);
        ArrayMap<String, Object> arrayMap = this.mMap;
        if (arrayMap == null || this.mSecurityType != AgentWeb.SecurityType.STRICT_CHECK || arrayMap.isEmpty()) {
            return;
        }
        webSecurityCheckLogic.dealJsInterface(this.mMap, this.mSecurityType);
    }
}
