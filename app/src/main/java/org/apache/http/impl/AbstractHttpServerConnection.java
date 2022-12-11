package org.apache.http.impl;

import java.io.IOException;
import org.apache.http.HttpConnectionMetrics;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestFactory;
import org.apache.http.HttpResponse;
import org.apache.http.HttpServerConnection;
import org.apache.http.impl.entity.DisallowIdentityContentLengthStrategy;
import org.apache.http.impl.entity.EntityDeserializer;
import org.apache.http.impl.entity.EntitySerializer;
import org.apache.http.impl.entity.LaxContentLengthStrategy;
import org.apache.http.impl.entity.StrictContentLengthStrategy;
import org.apache.http.impl.p057io.DefaultHttpRequestParser;
import org.apache.http.impl.p057io.HttpResponseWriter;
import org.apache.http.message.LineParser;
import org.apache.http.p058io.EofSensor;
import org.apache.http.p058io.HttpMessageParser;
import org.apache.http.p058io.HttpMessageWriter;
import org.apache.http.p058io.HttpTransportMetrics;
import org.apache.http.p058io.SessionInputBuffer;
import org.apache.http.p058io.SessionOutputBuffer;
import org.apache.http.params.HttpParams;
import org.apache.http.util.Args;

@Deprecated
/* loaded from: classes4.dex */
public abstract class AbstractHttpServerConnection implements HttpServerConnection {
    public SessionInputBuffer inbuffer = null;
    public SessionOutputBuffer outbuffer = null;
    public EofSensor eofSensor = null;
    public HttpMessageParser<HttpRequest> requestParser = null;
    public HttpMessageWriter<HttpResponse> responseWriter = null;
    public HttpConnectionMetricsImpl metrics = null;
    public final EntitySerializer entityserializer = createEntitySerializer();
    public final EntityDeserializer entitydeserializer = createEntityDeserializer();

    public abstract void assertOpen() throws IllegalStateException;

    public HttpConnectionMetricsImpl createConnectionMetrics(HttpTransportMetrics httpTransportMetrics, HttpTransportMetrics httpTransportMetrics2) {
        return new HttpConnectionMetricsImpl(httpTransportMetrics, httpTransportMetrics2);
    }

    public EntityDeserializer createEntityDeserializer() {
        return new EntityDeserializer(new DisallowIdentityContentLengthStrategy(new LaxContentLengthStrategy(0)));
    }

    public EntitySerializer createEntitySerializer() {
        return new EntitySerializer(new StrictContentLengthStrategy());
    }

    public HttpRequestFactory createHttpRequestFactory() {
        return DefaultHttpRequestFactory.INSTANCE;
    }

    public HttpMessageParser<HttpRequest> createRequestParser(SessionInputBuffer sessionInputBuffer, HttpRequestFactory httpRequestFactory, HttpParams httpParams) {
        return new DefaultHttpRequestParser(sessionInputBuffer, (LineParser) null, httpRequestFactory, httpParams);
    }

    public HttpMessageWriter<HttpResponse> createResponseWriter(SessionOutputBuffer sessionOutputBuffer, HttpParams httpParams) {
        return new HttpResponseWriter(sessionOutputBuffer, null, httpParams);
    }

    public void doFlush() throws IOException {
        this.outbuffer.flush();
    }

    @Override // org.apache.http.HttpServerConnection
    public void flush() throws IOException {
        assertOpen();
        doFlush();
    }

    @Override // org.apache.http.HttpConnection
    public HttpConnectionMetrics getMetrics() {
        return this.metrics;
    }

    public void init(SessionInputBuffer sessionInputBuffer, SessionOutputBuffer sessionOutputBuffer, HttpParams httpParams) {
        this.inbuffer = (SessionInputBuffer) Args.notNull(sessionInputBuffer, "Input session buffer");
        this.outbuffer = (SessionOutputBuffer) Args.notNull(sessionOutputBuffer, "Output session buffer");
        if (sessionInputBuffer instanceof EofSensor) {
            this.eofSensor = (EofSensor) sessionInputBuffer;
        }
        this.requestParser = createRequestParser(sessionInputBuffer, createHttpRequestFactory(), httpParams);
        this.responseWriter = createResponseWriter(sessionOutputBuffer, httpParams);
        this.metrics = createConnectionMetrics(sessionInputBuffer.getMetrics(), sessionOutputBuffer.getMetrics());
    }

    public boolean isEof() {
        EofSensor eofSensor = this.eofSensor;
        return eofSensor != null && eofSensor.isEof();
    }

    @Override // org.apache.http.HttpConnection
    public boolean isStale() {
        if (isOpen() && !isEof()) {
            try {
                this.inbuffer.isDataAvailable(1);
                return isEof();
            } catch (IOException unused) {
                return true;
            }
        }
        return true;
    }

    @Override // org.apache.http.HttpServerConnection
    public void receiveRequestEntity(HttpEntityEnclosingRequest httpEntityEnclosingRequest) throws HttpException, IOException {
        Args.notNull(httpEntityEnclosingRequest, "HTTP request");
        assertOpen();
        httpEntityEnclosingRequest.setEntity(this.entitydeserializer.deserialize(this.inbuffer, httpEntityEnclosingRequest));
    }

    @Override // org.apache.http.HttpServerConnection
    public HttpRequest receiveRequestHeader() throws HttpException, IOException {
        assertOpen();
        HttpRequest parse = this.requestParser.parse();
        this.metrics.incrementRequestCount();
        return parse;
    }

    @Override // org.apache.http.HttpServerConnection
    public void sendResponseEntity(HttpResponse httpResponse) throws HttpException, IOException {
        if (httpResponse.getEntity() == null) {
            return;
        }
        this.entityserializer.serialize(this.outbuffer, httpResponse, httpResponse.getEntity());
    }

    @Override // org.apache.http.HttpServerConnection
    public void sendResponseHeader(HttpResponse httpResponse) throws HttpException, IOException {
        Args.notNull(httpResponse, "HTTP response");
        assertOpen();
        this.responseWriter.write(httpResponse);
        if (httpResponse.getStatusLine().getStatusCode() >= 200) {
            this.metrics.incrementResponseCount();
        }
    }
}
