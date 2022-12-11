package org.apache.http;

/* loaded from: classes4.dex */
public interface HttpRequestFactory {
    HttpRequest newHttpRequest(String str, String str2) throws MethodNotSupportedException;

    HttpRequest newHttpRequest(RequestLine requestLine) throws MethodNotSupportedException;
}
