package com.tencent.bugly.crashreport;

import android.webkit.WebSettings;
import android.webkit.WebView;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.bugly.crashreport.crash.p042h5.H5JavaScriptInterface;

/* renamed from: com.tencent.bugly.crashreport.a */
/* loaded from: classes3.dex */
public class C1128a implements CrashReport.WebViewInterface {

    /* renamed from: a */
    public final /* synthetic */ WebView f949a;

    public C1128a(WebView webView) {
        this.f949a = webView;
    }

    @Override // com.tencent.bugly.crashreport.CrashReport.WebViewInterface
    public void addJavascriptInterface(H5JavaScriptInterface h5JavaScriptInterface, String str) {
        this.f949a.addJavascriptInterface(h5JavaScriptInterface, str);
    }

    @Override // com.tencent.bugly.crashreport.CrashReport.WebViewInterface
    public CharSequence getContentDescription() {
        return this.f949a.getContentDescription();
    }

    @Override // com.tencent.bugly.crashreport.CrashReport.WebViewInterface
    public String getUrl() {
        return this.f949a.getUrl();
    }

    @Override // com.tencent.bugly.crashreport.CrashReport.WebViewInterface
    public void loadUrl(String str) {
        this.f949a.loadUrl(str);
    }

    @Override // com.tencent.bugly.crashreport.CrashReport.WebViewInterface
    public void setJavaScriptEnabled(boolean z) {
        WebSettings settings = this.f949a.getSettings();
        if (!settings.getJavaScriptEnabled()) {
            settings.setJavaScriptEnabled(true);
        }
    }
}
