package com.just.agentweb;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.webkit.DownloadListener;
import android.webkit.WebView;

/* loaded from: classes3.dex */
public class AgentWebSettingsImpl extends AbsAgentWebSettings {
    public AgentWeb mAgentWeb;

    private Activity getActivityByContext(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    @Override // com.just.agentweb.AbsAgentWebSettings
    public void bindAgentWebSupport(AgentWeb agentWeb) {
        this.mAgentWeb = agentWeb;
    }

    @Override // com.just.agentweb.AbsAgentWebSettings, com.just.agentweb.WebListenerManager
    public WebListenerManager setDownloader(WebView webView, DownloadListener downloadListener) {
        if (downloadListener == null) {
            downloadListener = DefaultDownloadImpl.create(this.mAgentWeb.getActivity(), webView, this.mAgentWeb.getPermissionInterceptor());
        }
        return super.setDownloader(webView, downloadListener);
    }
}
