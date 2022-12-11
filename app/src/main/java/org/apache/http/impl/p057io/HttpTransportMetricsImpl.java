package org.apache.http.impl.p057io;

import org.apache.http.p058io.HttpTransportMetrics;

/* renamed from: org.apache.http.impl.io.HttpTransportMetricsImpl */
/* loaded from: classes4.dex */
public class HttpTransportMetricsImpl implements HttpTransportMetrics {
    public long bytesTransferred = 0;

    @Override // org.apache.http.p058io.HttpTransportMetrics
    public long getBytesTransferred() {
        return this.bytesTransferred;
    }

    public void incrementBytesTransferred(long j) {
        this.bytesTransferred += j;
    }

    @Override // org.apache.http.p058io.HttpTransportMetrics
    public void reset() {
        this.bytesTransferred = 0L;
    }

    public void setBytesTransferred(long j) {
        this.bytesTransferred = j;
    }
}
