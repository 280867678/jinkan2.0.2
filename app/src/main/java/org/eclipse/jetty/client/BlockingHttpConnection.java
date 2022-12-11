package org.eclipse.jetty.client;

import java.io.IOException;
import java.io.InterruptedIOException;
import org.eclipse.jetty.p059io.Buffer;
import org.eclipse.jetty.p059io.Buffers;
import org.eclipse.jetty.p059io.Connection;
import org.eclipse.jetty.p059io.EndPoint;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.slf4j.helpers.MessageFormatter;

/* loaded from: classes4.dex */
public class BlockingHttpConnection extends AbstractHttpConnection {
    public static final Logger LOG = Log.getLogger(BlockingHttpConnection.class);
    public boolean _expired = false;
    public boolean _requestComplete;
    public Buffer _requestContentChunk;

    public BlockingHttpConnection(Buffers buffers, Buffers buffers2, EndPoint endPoint) {
        super(buffers, buffers2, endPoint);
    }

    @Override // org.eclipse.jetty.client.AbstractHttpConnection
    public void exchangeExpired(HttpExchange httpExchange) {
        synchronized (this) {
            super.exchangeExpired(httpExchange);
            this._expired = true;
            notifyAll();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:130:0x0003 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0158 A[SYNTHETIC] */
    @Override // org.eclipse.jetty.client.AbstractHttpConnection, org.eclipse.jetty.p059io.Connection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Connection handle() throws IOException {
        HttpExchange httpExchange;
        boolean z;
        BlockingHttpConnection blockingHttpConnection = this;
        while (this._endp.isOpen() && blockingHttpConnection == this) {
            try {
                boolean z2 = true;
                LOG.debug("open={} more={}", Boolean.valueOf(this._endp.isOpen()), Boolean.valueOf(this._parser.isMoreInBuffer()));
                synchronized (this) {
                    httpExchange = this._exchange;
                    while (httpExchange == null) {
                        try {
                            wait();
                            httpExchange = this._exchange;
                            if (this._expired) {
                                throw new InterruptedException();
                            }
                        } catch (InterruptedException unused) {
                            throw new InterruptedIOException();
                        }
                    }
                }
                LOG.debug("exchange {}", httpExchange);
                if (!this._generator.isCommitted() && httpExchange.getStatus() == 2) {
                    LOG.debug("commit", new Object[0]);
                    commitRequest();
                }
                while (this._generator.isCommitted() && !this._generator.isComplete()) {
                    if (this._generator.flushBuffer() > 0) {
                        LOG.debug("flushed", new Object[0]);
                    }
                    if (this._generator.isState(2)) {
                        if (this._requestContentChunk == null) {
                            this._requestContentChunk = httpExchange.getRequestContentChunk(null);
                        }
                        if (this._requestContentChunk == null) {
                            LOG.debug("complete", new Object[0]);
                            this._generator.complete();
                        } else if (this._generator.isEmpty()) {
                            LOG.debug("addChunk", new Object[0]);
                            Buffer buffer = this._requestContentChunk;
                            Buffer requestContentChunk = httpExchange.getRequestContentChunk(null);
                            this._requestContentChunk = requestContentChunk;
                            this._generator.addContent(buffer, requestContentChunk == null);
                            if (this._requestContentChunk == null) {
                                httpExchange.setStatus(4);
                            }
                        }
                    }
                }
                if (this._generator.isComplete() && !this._requestComplete) {
                    LOG.debug("requestComplete", new Object[0]);
                    this._requestComplete = true;
                    httpExchange.getEventListener().onRequestComplete();
                }
                if (!this._parser.isComplete() && this._parser.parseAvailable()) {
                    LOG.debug("parsed", new Object[0]);
                }
                this._endp.flush();
                LOG.debug("{} {}", this._generator, this._parser);
                LOG.debug(MessageFormatter.DELIM_STR, this._endp);
                if (0 == 0 && (!this._generator.isComplete() || !this._parser.isComplete())) {
                    z = false;
                    if (z) {
                        boolean z3 = 0 == 0 && this._parser.isPersistent() && this._generator.isPersistent();
                        this._generator.setPersistent(z3);
                        reset();
                        if (z3) {
                            this._endp.setMaxIdleTime((int) this._destination.getHttpClient().getIdleTimeout());
                        }
                        synchronized (this) {
                            HttpExchange httpExchange2 = this._exchange;
                            this._exchange = null;
                            if (httpExchange2 != null) {
                                httpExchange2.cancelTimeout(this._destination.getHttpClient());
                            }
                            blockingHttpConnection = blockingHttpConnection;
                            if (this._status == 101) {
                                Connection onSwitchProtocol = httpExchange2.onSwitchProtocol(this._endp);
                                this._pipeline = null;
                                if (0 != 0) {
                                    this._destination.send(null);
                                }
                                this._pipeline = null;
                                blockingHttpConnection = onSwitchProtocol;
                            }
                            if (this._pipeline != null) {
                                if (z3 && blockingHttpConnection == this) {
                                    this._exchange = this._pipeline;
                                    this._pipeline = null;
                                }
                                this._destination.send(this._pipeline);
                                this._pipeline = null;
                            }
                            if (this._exchange == null && !isReserved()) {
                                HttpDestination httpDestination = this._destination;
                                if (z3) {
                                    z2 = false;
                                }
                                httpDestination.returnConnection(this, z2);
                            }
                        }
                    }
                }
                z = true;
                if (z) {
                }
            } finally {
                this._parser.returnBuffers();
                this._generator.returnBuffers();
            }
        }
        return blockingHttpConnection;
    }

    @Override // org.eclipse.jetty.p059io.AbstractConnection, org.eclipse.jetty.p059io.Connection
    public void onIdleExpired(long j) {
        try {
            LOG.debug("onIdleExpired {}ms {} {}", Long.valueOf(j), this, this._endp);
            this._expired = true;
            this._endp.close();
        } catch (IOException e) {
            LOG.ignore(e);
            try {
                this._endp.close();
            } catch (IOException e2) {
                LOG.ignore(e2);
            }
        }
        synchronized (this) {
            notifyAll();
        }
    }

    @Override // org.eclipse.jetty.client.AbstractHttpConnection
    public void reset() throws IOException {
        this._requestComplete = false;
        this._expired = false;
        super.reset();
    }

    @Override // org.eclipse.jetty.client.AbstractHttpConnection
    public boolean send(HttpExchange httpExchange) throws IOException {
        boolean send = super.send(httpExchange);
        if (send) {
            synchronized (this) {
                notifyAll();
            }
        }
        return send;
    }
}
