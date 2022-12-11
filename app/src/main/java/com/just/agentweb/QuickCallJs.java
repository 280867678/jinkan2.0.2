package com.just.agentweb;

import android.webkit.ValueCallback;
import androidx.annotation.RequiresApi;

/* loaded from: classes3.dex */
public interface QuickCallJs {
    void quickCallJs(String str);

    @RequiresApi(19)
    void quickCallJs(String str, ValueCallback<String> valueCallback, String... strArr);

    void quickCallJs(String str, String... strArr);
}
