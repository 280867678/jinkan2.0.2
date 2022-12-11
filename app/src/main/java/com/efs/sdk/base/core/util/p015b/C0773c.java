package com.efs.sdk.base.core.util.p015b;

import androidx.annotation.NonNull;
import com.efs.sdk.base.core.util.p014a.RunnableC0768e;
import com.efs.sdk.base.http.HttpResponse;

/* renamed from: com.efs.sdk.base.core.util.b.c */
/* loaded from: classes3.dex */
public final class C0773c extends RunnableC0768e<HttpResponse> {

    /* renamed from: a */
    public C0772b f330a;

    public C0773c(@NonNull C0772b c0772b) {
        super(c0772b);
        this.f330a = c0772b;
    }

    @NonNull
    /* renamed from: b */
    public final HttpResponse m4019b() {
        this.f330a.f327e = "post";
        return m4040a();
    }
}
