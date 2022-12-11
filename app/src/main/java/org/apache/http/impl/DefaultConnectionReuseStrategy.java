package org.apache.http.impl;

import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.ParseException;
import org.apache.http.ProtocolVersion;
import org.apache.http.TokenIterator;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.message.BasicTokenIterator;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;
import org.eclipse.jetty.http.HttpHeaders;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: classes4.dex */
public class DefaultConnectionReuseStrategy implements ConnectionReuseStrategy {
    public static final DefaultConnectionReuseStrategy INSTANCE = new DefaultConnectionReuseStrategy();

    private boolean canResponseHaveBody(HttpRequest httpRequest, HttpResponse httpResponse) {
        int statusCode;
        return ((httpRequest != null && httpRequest.getRequestLine().getMethod().equalsIgnoreCase("HEAD")) || (statusCode = httpResponse.getStatusLine().getStatusCode()) < 200 || statusCode == 204 || statusCode == 304 || statusCode == 205) ? false : true;
    }

    public TokenIterator createTokenIterator(HeaderIterator headerIterator) {
        return new BasicTokenIterator(headerIterator);
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x008f, code lost:
        if (java.lang.Integer.parseInt(r9[0].getValue()) < 0) goto L59;
     */
    @Override // org.apache.http.ConnectionReuseStrategy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean keepAlive(HttpResponse httpResponse, HttpContext httpContext) {
        BasicTokenIterator basicTokenIterator;
        Args.notNull(httpResponse, "HTTP response");
        Args.notNull(httpContext, "HTTP context");
        if (httpResponse.getStatusLine().getStatusCode() == 204) {
            Header firstHeader = httpResponse.getFirstHeader("Content-Length");
            if (firstHeader != null) {
                try {
                    if (Integer.parseInt(firstHeader.getValue()) > 0) {
                        return false;
                    }
                } catch (NumberFormatException unused) {
                }
            }
            if (httpResponse.getFirstHeader("Transfer-Encoding") != null) {
                return false;
            }
        }
        HttpRequest httpRequest = (HttpRequest) httpContext.getAttribute("http.request");
        if (httpRequest != null) {
            try {
                basicTokenIterator = new BasicTokenIterator(httpRequest.headerIterator("Connection"));
            } catch (ParseException unused2) {
            }
            while (basicTokenIterator.hasNext()) {
                if (HTTP.CONN_CLOSE.equalsIgnoreCase(basicTokenIterator.nextToken())) {
                    return false;
                }
            }
        }
        ProtocolVersion protocolVersion = httpResponse.getStatusLine().getProtocolVersion();
        Header firstHeader2 = httpResponse.getFirstHeader("Transfer-Encoding");
        if (firstHeader2 != null) {
            if (!"chunked".equalsIgnoreCase(firstHeader2.getValue())) {
                return false;
            }
        } else if (canResponseHaveBody(httpRequest, httpResponse)) {
            Header[] headers = httpResponse.getHeaders("Content-Length");
            if (headers.length == 1) {
            }
            return false;
        }
        HeaderIterator headerIterator = httpResponse.headerIterator("Connection");
        if (!headerIterator.hasNext()) {
            headerIterator = httpResponse.headerIterator(HttpHeaders.PROXY_CONNECTION);
        }
        if (headerIterator.hasNext()) {
            try {
                BasicTokenIterator basicTokenIterator2 = new BasicTokenIterator(headerIterator);
                boolean z = false;
                while (basicTokenIterator2.hasNext()) {
                    String nextToken = basicTokenIterator2.nextToken();
                    if (HTTP.CONN_CLOSE.equalsIgnoreCase(nextToken)) {
                        return false;
                    }
                    if ("Keep-Alive".equalsIgnoreCase(nextToken)) {
                        z = true;
                    }
                }
                if (z) {
                    return true;
                }
            } catch (ParseException unused3) {
                return false;
            }
        }
        return !protocolVersion.lessEquals(HttpVersion.HTTP_1_0);
    }
}
