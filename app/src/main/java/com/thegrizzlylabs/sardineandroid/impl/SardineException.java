package com.thegrizzlylabs.sardineandroid.impl;

import java.io.IOException;
import java.util.Locale;

/* loaded from: classes4.dex */
public class SardineException extends IOException {
    public static final long serialVersionUID = -3900043433469104564L;
    public String responsePhrase;
    public final int statusCode;

    public SardineException(String str, int i, String str2) {
        super(str);
        this.statusCode = i;
        this.responsePhrase = str2;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return String.format(Locale.US, "%s (%d %s)", super.getMessage(), Integer.valueOf(getStatusCode()), getResponsePhrase());
    }

    public String getResponsePhrase() {
        return this.responsePhrase;
    }

    public int getStatusCode() {
        return this.statusCode;
    }
}
