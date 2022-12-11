package com.just.agentweb;

import android.content.Context;
import android.content.pm.ProviderInfo;
import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;

/* loaded from: classes3.dex */
public class AgentWebFileProvider extends FileProvider {
    @Override // androidx.core.content.FileProvider, android.content.ContentProvider
    public void attachInfo(@NonNull Context context, @NonNull ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
    }
}
