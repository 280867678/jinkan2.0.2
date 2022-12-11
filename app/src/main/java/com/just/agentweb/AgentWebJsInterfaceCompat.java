package com.just.agentweb;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.webkit.JavascriptInterface;
import java.lang.ref.WeakReference;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public class AgentWebJsInterfaceCompat {
    public String TAG = AgentWebJsInterfaceCompat.class.getSimpleName();
    public WeakReference<Activity> mActivityWeakReference;
    public WeakReference<AgentWeb> mReference;

    public AgentWebJsInterfaceCompat(AgentWeb agentWeb, Activity activity) {
        this.mReference = null;
        this.mActivityWeakReference = null;
        this.mReference = new WeakReference<>(agentWeb);
        this.mActivityWeakReference = new WeakReference<>(activity);
    }

    @JavascriptInterface
    public void uploadFile() {
        uploadFile("*/*");
    }

    @JavascriptInterface
    public void uploadFile(String str) {
        String str2 = this.TAG;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "  ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mActivityWeakReference.get());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("  ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mReference.get());
        LogUtils.m3701i(str2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        if (this.mActivityWeakReference.get() == null || this.mReference.get() == null) {
            return;
        }
        AgentWebUtils.showFileChooserCompat(this.mActivityWeakReference.get(), this.mReference.get().getWebCreator().getWebView(), null, null, this.mReference.get().getPermissionInterceptor(), null, str, new Handler.Callback() { // from class: com.just.agentweb.AgentWebJsInterfaceCompat.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (AgentWebJsInterfaceCompat.this.mReference.get() != null) {
                    JsAccessEntrace jsAccessEntrace = ((AgentWeb) AgentWebJsInterfaceCompat.this.mReference.get()).getJsAccessEntrace();
                    String[] strArr = new String[1];
                    Object obj = message.obj;
                    strArr[0] = obj instanceof String ? (String) obj : null;
                    jsAccessEntrace.quickCallJs("uploadFileResult", strArr);
                }
                return true;
            }
        });
    }
}
