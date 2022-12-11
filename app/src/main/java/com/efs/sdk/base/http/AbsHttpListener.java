package com.efs.sdk.base.http;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.efs.sdk.base.core.util.p014a.AbstractC0765b;

/* loaded from: classes3.dex */
public abstract class AbsHttpListener implements AbstractC0765b<HttpResponse> {
    public abstract void onError(@Nullable HttpResponse httpResponse);

    public abstract void onSuccess(@NonNull HttpResponse httpResponse);

    @Override // com.efs.sdk.base.core.util.p014a.AbstractC0765b
    public void result(@Nullable HttpResponse httpResponse) {
        if (httpResponse == null || !httpResponse.succ) {
            onError(httpResponse);
        } else {
            onSuccess(httpResponse);
        }
    }
}
