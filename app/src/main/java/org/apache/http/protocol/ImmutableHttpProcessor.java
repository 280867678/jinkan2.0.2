package org.apache.http.protocol;

import java.io.IOException;
import java.util.List;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;

@Contract(threading = ThreadingBehavior.IMMUTABLE_CONDITIONAL)
/* loaded from: classes4.dex */
public final class ImmutableHttpProcessor implements HttpProcessor {
    public final HttpRequestInterceptor[] requestInterceptors;
    public final HttpResponseInterceptor[] responseInterceptors;

    public ImmutableHttpProcessor(List<HttpRequestInterceptor> list, List<HttpResponseInterceptor> list2) {
        if (list != null) {
            this.requestInterceptors = (HttpRequestInterceptor[]) list.toArray(new HttpRequestInterceptor[list.size()]);
        } else {
            this.requestInterceptors = new HttpRequestInterceptor[0];
        }
        if (list2 != null) {
            this.responseInterceptors = (HttpResponseInterceptor[]) list2.toArray(new HttpResponseInterceptor[list2.size()]);
        } else {
            this.responseInterceptors = new HttpResponseInterceptor[0];
        }
    }

    @Deprecated
    public ImmutableHttpProcessor(HttpRequestInterceptorList httpRequestInterceptorList, HttpResponseInterceptorList httpResponseInterceptorList) {
        if (httpRequestInterceptorList != null) {
            int requestInterceptorCount = httpRequestInterceptorList.getRequestInterceptorCount();
            this.requestInterceptors = new HttpRequestInterceptor[requestInterceptorCount];
            for (int i = 0; i < requestInterceptorCount; i++) {
                this.requestInterceptors[i] = httpRequestInterceptorList.getRequestInterceptor(i);
            }
        } else {
            this.requestInterceptors = new HttpRequestInterceptor[0];
        }
        if (httpResponseInterceptorList == null) {
            this.responseInterceptors = new HttpResponseInterceptor[0];
            return;
        }
        int responseInterceptorCount = httpResponseInterceptorList.getResponseInterceptorCount();
        this.responseInterceptors = new HttpResponseInterceptor[responseInterceptorCount];
        for (int i2 = 0; i2 < responseInterceptorCount; i2++) {
            this.responseInterceptors[i2] = httpResponseInterceptorList.getResponseInterceptor(i2);
        }
    }

    public ImmutableHttpProcessor(HttpRequestInterceptor... httpRequestInterceptorArr) {
        this(httpRequestInterceptorArr, (HttpResponseInterceptor[]) null);
    }

    public ImmutableHttpProcessor(HttpRequestInterceptor[] httpRequestInterceptorArr, HttpResponseInterceptor[] httpResponseInterceptorArr) {
        if (httpRequestInterceptorArr != null) {
            int length = httpRequestInterceptorArr.length;
            HttpRequestInterceptor[] httpRequestInterceptorArr2 = new HttpRequestInterceptor[length];
            this.requestInterceptors = httpRequestInterceptorArr2;
            System.arraycopy(httpRequestInterceptorArr, 0, httpRequestInterceptorArr2, 0, length);
        } else {
            this.requestInterceptors = new HttpRequestInterceptor[0];
        }
        if (httpResponseInterceptorArr == null) {
            this.responseInterceptors = new HttpResponseInterceptor[0];
            return;
        }
        int length2 = httpResponseInterceptorArr.length;
        HttpResponseInterceptor[] httpResponseInterceptorArr2 = new HttpResponseInterceptor[length2];
        this.responseInterceptors = httpResponseInterceptorArr2;
        System.arraycopy(httpResponseInterceptorArr, 0, httpResponseInterceptorArr2, 0, length2);
    }

    public ImmutableHttpProcessor(HttpResponseInterceptor... httpResponseInterceptorArr) {
        this((HttpRequestInterceptor[]) null, httpResponseInterceptorArr);
    }

    @Override // org.apache.http.HttpRequestInterceptor
    public void process(HttpRequest httpRequest, HttpContext httpContext) throws IOException, HttpException {
        for (HttpRequestInterceptor httpRequestInterceptor : this.requestInterceptors) {
            httpRequestInterceptor.process(httpRequest, httpContext);
        }
    }

    @Override // org.apache.http.HttpResponseInterceptor
    public void process(HttpResponse httpResponse, HttpContext httpContext) throws IOException, HttpException {
        for (HttpResponseInterceptor httpResponseInterceptor : this.responseInterceptors) {
            httpResponseInterceptor.process(httpResponse, httpContext);
        }
    }
}
