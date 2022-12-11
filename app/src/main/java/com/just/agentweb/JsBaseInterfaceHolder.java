package com.just.agentweb;

import android.webkit.JavascriptInterface;
import com.just.agentweb.AgentWeb;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public abstract class JsBaseInterfaceHolder implements JsInterfaceHolder {
    public AgentWeb.SecurityType mSecurityType;
    public WebCreator mWebCreator;

    public JsBaseInterfaceHolder(WebCreator webCreator, AgentWeb.SecurityType securityType) {
        this.mSecurityType = securityType;
        this.mWebCreator = webCreator;
    }

    @Override // com.just.agentweb.JsInterfaceHolder
    public boolean checkObject(Object obj) {
        if (this.mWebCreator.getWebViewType() == 2) {
            return true;
        }
        boolean z = false;
        for (Method method : obj.getClass().getMethods()) {
            Annotation[] annotations = method.getAnnotations();
            int length = annotations.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                } else if (annotations[i] instanceof JavascriptInterface) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
            if (z) {
                break;
            }
        }
        return z;
    }

    public boolean checkSecurity() {
        if (this.mSecurityType != AgentWeb.SecurityType.STRICT_CHECK) {
            return true;
        }
        this.mWebCreator.getWebViewType();
        return true;
    }
}
