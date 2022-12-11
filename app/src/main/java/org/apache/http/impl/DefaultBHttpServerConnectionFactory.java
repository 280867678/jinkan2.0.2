package org.apache.http.impl;

import java.io.IOException;
import java.net.Socket;
import org.apache.http.HttpConnectionFactory;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.p058io.HttpMessageParserFactory;
import org.apache.http.p058io.HttpMessageWriterFactory;

@Contract(threading = ThreadingBehavior.IMMUTABLE_CONDITIONAL)
/* loaded from: classes4.dex */
public class DefaultBHttpServerConnectionFactory implements HttpConnectionFactory<DefaultBHttpServerConnection> {
    public static final DefaultBHttpServerConnectionFactory INSTANCE = new DefaultBHttpServerConnectionFactory();
    public final ConnectionConfig cconfig;
    public final ContentLengthStrategy incomingContentStrategy;
    public final ContentLengthStrategy outgoingContentStrategy;
    public final HttpMessageParserFactory<HttpRequest> requestParserFactory;
    public final HttpMessageWriterFactory<HttpResponse> responseWriterFactory;

    public DefaultBHttpServerConnectionFactory() {
        this(null, null, null, null, null);
    }

    public DefaultBHttpServerConnectionFactory(ConnectionConfig connectionConfig) {
        this(connectionConfig, null, null, null, null);
    }

    public DefaultBHttpServerConnectionFactory(ConnectionConfig connectionConfig, ContentLengthStrategy contentLengthStrategy, ContentLengthStrategy contentLengthStrategy2, HttpMessageParserFactory<HttpRequest> httpMessageParserFactory, HttpMessageWriterFactory<HttpResponse> httpMessageWriterFactory) {
        this.cconfig = connectionConfig == null ? ConnectionConfig.DEFAULT : connectionConfig;
        this.incomingContentStrategy = contentLengthStrategy;
        this.outgoingContentStrategy = contentLengthStrategy2;
        this.requestParserFactory = httpMessageParserFactory;
        this.responseWriterFactory = httpMessageWriterFactory;
    }

    public DefaultBHttpServerConnectionFactory(ConnectionConfig connectionConfig, HttpMessageParserFactory<HttpRequest> httpMessageParserFactory, HttpMessageWriterFactory<HttpResponse> httpMessageWriterFactory) {
        this(connectionConfig, null, null, httpMessageParserFactory, httpMessageWriterFactory);
    }

    @Override // org.apache.http.HttpConnectionFactory
    public DefaultBHttpServerConnection createConnection(Socket socket) throws IOException {
        DefaultBHttpServerConnection defaultBHttpServerConnection = new DefaultBHttpServerConnection(this.cconfig.getBufferSize(), this.cconfig.getFragmentSizeHint(), ConnSupport.createDecoder(this.cconfig), ConnSupport.createEncoder(this.cconfig), this.cconfig.getMessageConstraints(), this.incomingContentStrategy, this.outgoingContentStrategy, this.requestParserFactory, this.responseWriterFactory);
        defaultBHttpServerConnection.bind(socket);
        return defaultBHttpServerConnection;
    }
}
