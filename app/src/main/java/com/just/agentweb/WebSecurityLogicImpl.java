package com.just.agentweb;

import android.annotation.TargetApi;
import android.webkit.WebView;
import androidx.collection.ArrayMap;
import com.just.agentweb.AgentWeb;

/* loaded from: classes3.dex */
public class WebSecurityLogicImpl implements WebSecurityCheckLogic {
    public String TAG = WebSecurityLogicImpl.class.getSimpleName();
    public int webviewType;

    public WebSecurityLogicImpl(int i) {
        this.webviewType = i;
    }

    public static WebSecurityLogicImpl getInstance(int i) {
        return new WebSecurityLogicImpl(i);
    }

    @Override // com.just.agentweb.WebSecurityCheckLogic
    @TargetApi(11)
    public void dealHoneyComb(WebView webView) {
    }

    @Override // com.just.agentweb.WebSecurityCheckLogic
    public void dealJsInterface(ArrayMap<String, Object> arrayMap, AgentWeb.SecurityType securityType) {
        if (securityType == AgentWeb.SecurityType.STRICT_CHECK) {
            int i = this.webviewType;
        }
    }
}
