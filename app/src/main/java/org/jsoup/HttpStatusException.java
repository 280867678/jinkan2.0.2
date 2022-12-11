package org.jsoup;

import java.io.IOException;

/* loaded from: classes5.dex */
public class HttpStatusException extends IOException {
    public int statusCode;
    public String url;

    public HttpStatusException(String str, int i, String str2) {
        super(str);
        this.statusCode = i;
        this.url = str2;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String getUrl() {
        return this.url;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return super.toString() + ". Status=" + this.statusCode + ", URL=" + this.url;
    }
}
