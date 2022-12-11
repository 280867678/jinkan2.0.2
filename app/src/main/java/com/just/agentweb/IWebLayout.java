package com.just.agentweb;

import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes3.dex */
public interface IWebLayout<T extends WebView, V extends ViewGroup> {
    @NonNull
    V getLayout();

    @Nullable
    T getWebView();
}
