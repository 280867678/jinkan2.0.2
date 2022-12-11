package org.apache.http.impl;

import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpConnectionMetrics;
import org.apache.http.p058io.HttpTransportMetrics;

/* loaded from: classes4.dex */
public class HttpConnectionMetricsImpl implements HttpConnectionMetrics {
    public static final String RECEIVED_BYTES_COUNT = "http.received-bytes-count";
    public static final String REQUEST_COUNT = "http.request-count";
    public static final String RESPONSE_COUNT = "http.response-count";
    public static final String SENT_BYTES_COUNT = "http.sent-bytes-count";
    public final HttpTransportMetrics inTransportMetric;
    public Map<String, Object> metricsCache;
    public final HttpTransportMetrics outTransportMetric;
    public long requestCount = 0;
    public long responseCount = 0;

    public HttpConnectionMetricsImpl(HttpTransportMetrics httpTransportMetrics, HttpTransportMetrics httpTransportMetrics2) {
        this.inTransportMetric = httpTransportMetrics;
        this.outTransportMetric = httpTransportMetrics2;
    }

    @Override // org.apache.http.HttpConnectionMetrics
    public Object getMetric(String str) {
        HttpTransportMetrics httpTransportMetrics;
        long j;
        Map<String, Object> map = this.metricsCache;
        Object obj = map != null ? map.get(str) : null;
        if (obj == null) {
            if (REQUEST_COUNT.equals(str)) {
                j = this.requestCount;
            } else if (!RESPONSE_COUNT.equals(str)) {
                if (RECEIVED_BYTES_COUNT.equals(str)) {
                    httpTransportMetrics = this.inTransportMetric;
                    if (httpTransportMetrics == null) {
                        return null;
                    }
                } else if (!SENT_BYTES_COUNT.equals(str)) {
                    return obj;
                } else {
                    httpTransportMetrics = this.outTransportMetric;
                    if (httpTransportMetrics == null) {
                        return null;
                    }
                }
                return Long.valueOf(httpTransportMetrics.getBytesTransferred());
            } else {
                j = this.responseCount;
            }
            return Long.valueOf(j);
        }
        return obj;
    }

    @Override // org.apache.http.HttpConnectionMetrics
    public long getReceivedBytesCount() {
        HttpTransportMetrics httpTransportMetrics = this.inTransportMetric;
        if (httpTransportMetrics != null) {
            return httpTransportMetrics.getBytesTransferred();
        }
        return -1L;
    }

    @Override // org.apache.http.HttpConnectionMetrics
    public long getRequestCount() {
        return this.requestCount;
    }

    @Override // org.apache.http.HttpConnectionMetrics
    public long getResponseCount() {
        return this.responseCount;
    }

    @Override // org.apache.http.HttpConnectionMetrics
    public long getSentBytesCount() {
        HttpTransportMetrics httpTransportMetrics = this.outTransportMetric;
        if (httpTransportMetrics != null) {
            return httpTransportMetrics.getBytesTransferred();
        }
        return -1L;
    }

    public void incrementRequestCount() {
        this.requestCount++;
    }

    public void incrementResponseCount() {
        this.responseCount++;
    }

    @Override // org.apache.http.HttpConnectionMetrics
    public void reset() {
        HttpTransportMetrics httpTransportMetrics = this.outTransportMetric;
        if (httpTransportMetrics != null) {
            httpTransportMetrics.reset();
        }
        HttpTransportMetrics httpTransportMetrics2 = this.inTransportMetric;
        if (httpTransportMetrics2 != null) {
            httpTransportMetrics2.reset();
        }
        this.requestCount = 0L;
        this.responseCount = 0L;
        this.metricsCache = null;
    }

    public void setMetric(String str, Object obj) {
        if (this.metricsCache == null) {
            this.metricsCache = new HashMap();
        }
        this.metricsCache.put(str, obj);
    }
}
