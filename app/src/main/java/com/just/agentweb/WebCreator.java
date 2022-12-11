package com.just.agentweb;

import android.webkit.WebView;
import android.widget.FrameLayout;

/* loaded from: classes3.dex */
public interface WebCreator extends IWebIndicator {
    /* renamed from: create */
    WebCreator mo4827create();

    FrameLayout getWebParentLayout();

    WebView getWebView();

    int getWebViewType();
}
