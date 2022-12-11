package com.just.agentweb;

import android.webkit.WebView;

/* loaded from: classes3.dex */
public interface IndicatorController {
    void finish();

    BaseIndicatorSpec offerIndicator();

    void progress(WebView webView, int i);

    void setProgress(int i);

    void showIndicator();
}
