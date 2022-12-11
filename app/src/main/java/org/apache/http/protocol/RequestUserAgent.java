package org.apache.http.protocol;

import java.io.IOException;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.params.HttpParams;
import org.apache.http.util.Args;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: classes4.dex */
public class RequestUserAgent implements HttpRequestInterceptor {
    public final String userAgent;

    public RequestUserAgent() {
        this(null);
    }

    public RequestUserAgent(String str) {
        this.userAgent = str;
    }

    @Override // org.apache.http.HttpRequestInterceptor
    public void process(HttpRequest httpRequest, HttpContext httpContext) throws HttpException, IOException {
        Args.notNull(httpRequest, "HTTP request");
        if (!httpRequest.containsHeader("User-Agent")) {
            String str = null;
            HttpParams params = httpRequest.getParams();
            if (params != null) {
                str = (String) params.getParameter(CoreProtocolPNames.USER_AGENT);
            }
            if (str == null) {
                str = this.userAgent;
            }
            if (str == null) {
                return;
            }
            httpRequest.addHeader("User-Agent", str);
        }
    }
}
