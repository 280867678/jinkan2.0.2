package com.tencent.smtt.sdk;

import com.tencent.smtt.export.external.jscore.interfaces.IX5JsError;

/* loaded from: classes4.dex */
public class JsError {

    /* renamed from: a */
    public final IX5JsError f1720a;

    public JsError(IX5JsError iX5JsError) {
        this.f1720a = iX5JsError;
    }

    public String getMessage() {
        return this.f1720a.getMessage();
    }

    public String getStack() {
        return this.f1720a.getStack();
    }
}
