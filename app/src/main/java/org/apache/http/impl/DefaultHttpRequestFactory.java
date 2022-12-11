package org.apache.http.impl;

import me.tvspark.outline;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestFactory;
import org.apache.http.MethodNotSupportedException;
import org.apache.http.RequestLine;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;
import org.apache.http.message.BasicHttpRequest;
import org.apache.http.util.Args;
import org.eclipse.jetty.http.HttpMethods;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: classes4.dex */
public class DefaultHttpRequestFactory implements HttpRequestFactory {
    public static final DefaultHttpRequestFactory INSTANCE = new DefaultHttpRequestFactory();
    public static final String[] RFC2616_COMMON_METHODS = {"GET"};
    public static final String[] RFC2616_ENTITY_ENC_METHODS = {"POST", "PUT"};
    public static final String[] RFC2616_SPECIAL_METHODS = {"HEAD", "OPTIONS", "DELETE", "TRACE", HttpMethods.CONNECT};
    public static final String[] RFC5789_ENTITY_ENC_METHODS = {"PATCH"};

    public static boolean isOneOf(String[] strArr, String str) {
        for (String str2 : strArr) {
            if (str2.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.apache.http.HttpRequestFactory
    public HttpRequest newHttpRequest(String str, String str2) throws MethodNotSupportedException {
        if (isOneOf(RFC2616_COMMON_METHODS, str)) {
            return new BasicHttpRequest(str, str2);
        }
        if (isOneOf(RFC2616_ENTITY_ENC_METHODS, str)) {
            return new BasicHttpEntityEnclosingRequest(str, str2);
        }
        if (isOneOf(RFC2616_SPECIAL_METHODS, str)) {
            return new BasicHttpRequest(str, str2);
        }
        if (!isOneOf(RFC5789_ENTITY_ENC_METHODS, str)) {
            throw new MethodNotSupportedException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, " method not supported"));
        }
        return new BasicHttpEntityEnclosingRequest(str, str2);
    }

    @Override // org.apache.http.HttpRequestFactory
    public HttpRequest newHttpRequest(RequestLine requestLine) throws MethodNotSupportedException {
        Args.notNull(requestLine, "Request line");
        String method = requestLine.getMethod();
        if (isOneOf(RFC2616_COMMON_METHODS, method)) {
            return new BasicHttpRequest(requestLine);
        }
        if (isOneOf(RFC2616_ENTITY_ENC_METHODS, method)) {
            return new BasicHttpEntityEnclosingRequest(requestLine);
        }
        if (isOneOf(RFC2616_SPECIAL_METHODS, method)) {
            return new BasicHttpRequest(requestLine);
        }
        if (!isOneOf(RFC5789_ENTITY_ENC_METHODS, method)) {
            throw new MethodNotSupportedException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(method, " method not supported"));
        }
        return new BasicHttpEntityEnclosingRequest(requestLine);
    }
}
