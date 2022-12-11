package org.apache.http.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.http.ConnectionClosedException;
import org.apache.http.Header;
import org.apache.http.HttpConnection;
import org.apache.http.HttpConnectionMetrics;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpInetConnection;
import org.apache.http.HttpMessage;
import org.apache.http.config.MessageConstraints;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.impl.entity.LaxContentLengthStrategy;
import org.apache.http.impl.entity.StrictContentLengthStrategy;
import org.apache.http.impl.p057io.ChunkedInputStream;
import org.apache.http.impl.p057io.ChunkedOutputStream;
import org.apache.http.impl.p057io.ContentLengthInputStream;
import org.apache.http.impl.p057io.ContentLengthOutputStream;
import org.apache.http.impl.p057io.EmptyInputStream;
import org.apache.http.impl.p057io.HttpTransportMetricsImpl;
import org.apache.http.impl.p057io.IdentityInputStream;
import org.apache.http.impl.p057io.IdentityOutputStream;
import org.apache.http.impl.p057io.SessionInputBufferImpl;
import org.apache.http.impl.p057io.SessionOutputBufferImpl;
import org.apache.http.p058io.SessionInputBuffer;
import org.apache.http.p058io.SessionOutputBuffer;
import org.apache.http.util.Args;
import org.apache.http.util.NetUtils;

/* loaded from: classes4.dex */
public class BHttpConnectionBase implements HttpConnection, HttpInetConnection {
    public final HttpConnectionMetricsImpl connMetrics;
    public final SessionInputBufferImpl inbuffer;
    public final ContentLengthStrategy incomingContentStrategy;
    public final MessageConstraints messageConstraints;
    public final SessionOutputBufferImpl outbuffer;
    public final ContentLengthStrategy outgoingContentStrategy;
    public final AtomicReference<Socket> socketHolder;

    public BHttpConnectionBase(int i, int i2, CharsetDecoder charsetDecoder, CharsetEncoder charsetEncoder, MessageConstraints messageConstraints, ContentLengthStrategy contentLengthStrategy, ContentLengthStrategy contentLengthStrategy2) {
        Args.positive(i, "Buffer size");
        HttpTransportMetricsImpl httpTransportMetricsImpl = new HttpTransportMetricsImpl();
        HttpTransportMetricsImpl httpTransportMetricsImpl2 = new HttpTransportMetricsImpl();
        this.inbuffer = new SessionInputBufferImpl(httpTransportMetricsImpl, i, -1, messageConstraints != null ? messageConstraints : MessageConstraints.DEFAULT, charsetDecoder);
        this.outbuffer = new SessionOutputBufferImpl(httpTransportMetricsImpl2, i, i2, charsetEncoder);
        this.messageConstraints = messageConstraints;
        this.connMetrics = new HttpConnectionMetricsImpl(httpTransportMetricsImpl, httpTransportMetricsImpl2);
        this.incomingContentStrategy = contentLengthStrategy != null ? contentLengthStrategy : LaxContentLengthStrategy.INSTANCE;
        this.outgoingContentStrategy = contentLengthStrategy2 != null ? contentLengthStrategy2 : StrictContentLengthStrategy.INSTANCE;
        this.socketHolder = new AtomicReference<>();
    }

    private int fillInputBuffer(int i) throws IOException {
        Socket socket = this.socketHolder.get();
        int soTimeout = socket.getSoTimeout();
        try {
            socket.setSoTimeout(i);
            return this.inbuffer.fillBuffer();
        } finally {
            socket.setSoTimeout(soTimeout);
        }
    }

    public boolean awaitInput(int i) throws IOException {
        if (this.inbuffer.hasBufferedData()) {
            return true;
        }
        fillInputBuffer(i);
        return this.inbuffer.hasBufferedData();
    }

    public void bind(Socket socket) throws IOException {
        Args.notNull(socket, "Socket");
        this.socketHolder.set(socket);
        this.inbuffer.bind(null);
        this.outbuffer.bind(null);
    }

    @Override // org.apache.http.HttpConnection, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Socket andSet = this.socketHolder.getAndSet(null);
        if (andSet != null) {
            try {
                this.inbuffer.clear();
                this.outbuffer.flush();
                try {
                    try {
                        andSet.shutdownOutput();
                    } catch (IOException unused) {
                    }
                    andSet.shutdownInput();
                } catch (IOException | UnsupportedOperationException unused2) {
                }
            } finally {
                andSet.close();
            }
        }
    }

    public InputStream createInputStream(long j, SessionInputBuffer sessionInputBuffer) {
        return j == -2 ? new ChunkedInputStream(sessionInputBuffer, this.messageConstraints) : j == -1 ? new IdentityInputStream(sessionInputBuffer) : j == 0 ? EmptyInputStream.INSTANCE : new ContentLengthInputStream(sessionInputBuffer, j);
    }

    public OutputStream createOutputStream(long j, SessionOutputBuffer sessionOutputBuffer) {
        return j == -2 ? new ChunkedOutputStream(2048, sessionOutputBuffer) : j == -1 ? new IdentityOutputStream(sessionOutputBuffer) : new ContentLengthOutputStream(sessionOutputBuffer, j);
    }

    public void doFlush() throws IOException {
        this.outbuffer.flush();
    }

    public void ensureOpen() throws IOException {
        Socket socket = this.socketHolder.get();
        if (socket != null) {
            if (!this.inbuffer.isBound()) {
                this.inbuffer.bind(getSocketInputStream(socket));
            }
            if (this.outbuffer.isBound()) {
                return;
            }
            this.outbuffer.bind(getSocketOutputStream(socket));
            return;
        }
        throw new ConnectionClosedException("Connection is closed");
    }

    @Override // org.apache.http.HttpInetConnection
    public InetAddress getLocalAddress() {
        Socket socket = this.socketHolder.get();
        if (socket != null) {
            return socket.getLocalAddress();
        }
        return null;
    }

    @Override // org.apache.http.HttpInetConnection
    public int getLocalPort() {
        Socket socket = this.socketHolder.get();
        if (socket != null) {
            return socket.getLocalPort();
        }
        return -1;
    }

    @Override // org.apache.http.HttpConnection
    public HttpConnectionMetrics getMetrics() {
        return this.connMetrics;
    }

    @Override // org.apache.http.HttpInetConnection
    public InetAddress getRemoteAddress() {
        Socket socket = this.socketHolder.get();
        if (socket != null) {
            return socket.getInetAddress();
        }
        return null;
    }

    @Override // org.apache.http.HttpInetConnection
    public int getRemotePort() {
        Socket socket = this.socketHolder.get();
        if (socket != null) {
            return socket.getPort();
        }
        return -1;
    }

    public SessionInputBuffer getSessionInputBuffer() {
        return this.inbuffer;
    }

    public SessionOutputBuffer getSessionOutputBuffer() {
        return this.outbuffer;
    }

    public Socket getSocket() {
        return this.socketHolder.get();
    }

    public InputStream getSocketInputStream(Socket socket) throws IOException {
        return socket.getInputStream();
    }

    public OutputStream getSocketOutputStream(Socket socket) throws IOException {
        return socket.getOutputStream();
    }

    @Override // org.apache.http.HttpConnection
    public int getSocketTimeout() {
        Socket socket = this.socketHolder.get();
        if (socket != null) {
            try {
                return socket.getSoTimeout();
            } catch (SocketException unused) {
            }
        }
        return -1;
    }

    public void incrementRequestCount() {
        this.connMetrics.incrementRequestCount();
    }

    public void incrementResponseCount() {
        this.connMetrics.incrementResponseCount();
    }

    @Override // org.apache.http.HttpConnection
    public boolean isOpen() {
        return this.socketHolder.get() != null;
    }

    @Override // org.apache.http.HttpConnection
    public boolean isStale() {
        if (!isOpen()) {
            return true;
        }
        try {
            return fillInputBuffer(1) < 0;
        } catch (SocketTimeoutException unused) {
            return false;
        } catch (IOException unused2) {
            return true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public HttpEntity prepareInput(HttpMessage httpMessage) throws HttpException {
        Header firstHeader;
        Header firstHeader2;
        BasicHttpEntity basicHttpEntity = new BasicHttpEntity();
        long determineLength = this.incomingContentStrategy.determineLength(httpMessage);
        InputStream createInputStream = createInputStream(determineLength, this.inbuffer);
        if (determineLength == -2) {
            basicHttpEntity.setChunked(true);
        } else {
            int i = (determineLength > (-1L) ? 1 : (determineLength == (-1L) ? 0 : -1));
            basicHttpEntity.setChunked(false);
            if (i != 0) {
                basicHttpEntity.setContentLength(determineLength);
                basicHttpEntity.setContent(createInputStream);
                firstHeader = httpMessage.getFirstHeader("Content-Type");
                if (firstHeader != null) {
                    basicHttpEntity.setContentType(firstHeader);
                }
                firstHeader2 = httpMessage.getFirstHeader("Content-Encoding");
                if (firstHeader2 != null) {
                    basicHttpEntity.setContentEncoding(firstHeader2);
                }
                return basicHttpEntity;
            }
        }
        basicHttpEntity.setContentLength(-1L);
        basicHttpEntity.setContent(createInputStream);
        firstHeader = httpMessage.getFirstHeader("Content-Type");
        if (firstHeader != null) {
        }
        firstHeader2 = httpMessage.getFirstHeader("Content-Encoding");
        if (firstHeader2 != null) {
        }
        return basicHttpEntity;
    }

    public OutputStream prepareOutput(HttpMessage httpMessage) throws HttpException {
        return createOutputStream(this.outgoingContentStrategy.determineLength(httpMessage), this.outbuffer);
    }

    @Override // org.apache.http.HttpConnection
    public void setSocketTimeout(int i) {
        Socket socket = this.socketHolder.get();
        if (socket != null) {
            try {
                socket.setSoTimeout(i);
            } catch (SocketException unused) {
            }
        }
    }

    @Override // org.apache.http.HttpConnection
    public void shutdown() throws IOException {
        Socket andSet = this.socketHolder.getAndSet(null);
        if (andSet != null) {
            try {
                andSet.setSoLinger(true, 0);
            } catch (IOException unused) {
            } catch (Throwable th) {
                andSet.close();
                throw th;
            }
            andSet.close();
        }
    }

    public String toString() {
        Socket socket = this.socketHolder.get();
        if (socket != null) {
            StringBuilder sb = new StringBuilder();
            SocketAddress remoteSocketAddress = socket.getRemoteSocketAddress();
            SocketAddress localSocketAddress = socket.getLocalSocketAddress();
            if (remoteSocketAddress != null && localSocketAddress != null) {
                NetUtils.formatAddress(sb, localSocketAddress);
                sb.append("<->");
                NetUtils.formatAddress(sb, remoteSocketAddress);
            }
            return sb.toString();
        }
        return "[Not bound]";
    }
}
