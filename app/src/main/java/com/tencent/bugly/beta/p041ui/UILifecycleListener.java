package com.tencent.bugly.beta.p041ui;

import android.content.Context;
import android.view.View;

/* renamed from: com.tencent.bugly.beta.ui.UILifecycleListener */
/* loaded from: classes3.dex */
public interface UILifecycleListener<T> {
    void onCreate(Context context, View view, T t);

    void onDestroy(Context context, View view, T t);

    void onPause(Context context, View view, T t);

    void onResume(Context context, View view, T t);

    void onStart(Context context, View view, T t);

    void onStop(Context context, View view, T t);
}
