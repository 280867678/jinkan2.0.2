package com.just.agentweb;

import android.webkit.WebView;
import com.just.agentweb.AgentWeb;
import java.util.Map;

/* loaded from: classes3.dex */
public class JsInterfaceHolderImpl extends JsBaseInterfaceHolder {
    public static final String TAG = "JsInterfaceHolderImpl";
    public AgentWeb.SecurityType mSecurityType;
    public WebCreator mWebCreator;
    public WebView mWebView;

    public JsInterfaceHolderImpl(WebCreator webCreator, AgentWeb.SecurityType securityType) {
        super(webCreator, securityType);
        this.mWebCreator = webCreator;
        this.mWebView = webCreator.getWebView();
        this.mSecurityType = securityType;
    }

    private JsInterfaceHolder addJavaObjectDirect(String str, Object obj) {
        String str2 = TAG;
        LogUtils.m3701i(str2, "k:" + str + "  v:" + obj);
        this.mWebView.addJavascriptInterface(obj, str);
        return this;
    }

    public static JsInterfaceHolderImpl getJsInterfaceHolder(WebCreator webCreator, AgentWeb.SecurityType securityType) {
        return new JsInterfaceHolderImpl(webCreator, securityType);
    }

    @Override // com.just.agentweb.JsInterfaceHolder
    public JsInterfaceHolder addJavaObject(String str, Object obj) {
        if (!checkSecurity()) {
            return this;
        }
        if (!checkObject(obj)) {
            throw new JsInterfaceObjectException("this object has not offer method javascript to call , please check addJavascriptInterface annotation was be added");
        }
        addJavaObjectDirect(str, obj);
        return this;
    }

    @Override // com.just.agentweb.JsInterfaceHolder
    public JsInterfaceHolder addJavaObjects(Map<String, Object> map) {
        if (!checkSecurity()) {
            LogUtils.m3703e(TAG, "The injected object is not safe, give up injection");
            return this;
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            Object value = entry.getValue();
            if (!checkObject(value)) {
                throw new JsInterfaceObjectException("This object has not offer method javascript to call ,please check addJavascriptInterface annotation was be added");
            }
            addJavaObjectDirect(entry.getKey(), value);
        }
        return this;
    }
}
