package org.eclipse.jetty.client;

import java.io.IOException;
import org.eclipse.jetty.p059io.AsyncEndPoint;
import org.eclipse.jetty.p059io.Buffer;
import org.eclipse.jetty.p059io.Buffers;
import org.eclipse.jetty.p059io.Connection;
import org.eclipse.jetty.p059io.EndPoint;
import org.eclipse.jetty.p059io.nio.AsyncConnection;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: classes4.dex */
public class AsyncHttpConnection extends AbstractHttpConnection implements AsyncConnection {
    public static final Logger LOG = Log.getLogger(AsyncHttpConnection.class);
    public final AsyncEndPoint _asyncEndp;
    public boolean _requestComplete;
    public Buffer _requestContentChunk;

    public AsyncHttpConnection(Buffers buffers, Buffers buffers2, EndPoint endPoint) {
        super(buffers, buffers2, endPoint);
        this._asyncEndp = (AsyncEndPoint) endPoint;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b8, code lost:
        if (r7.getStatus() < 4) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00ba, code lost:
        r7.setStatus(4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00bd, code lost:
        r12 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00e4, code lost:
        if (r16._requestContentChunk == null) goto L38;
     */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x02fb  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x016c  */
    @Override // org.eclipse.jetty.client.AbstractHttpConnection, org.eclipse.jetty.p059io.Connection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Connection handle() throws IOException {
        boolean z;
        boolean z2;
        Connection onSwitchProtocol;
        Connection onSwitchProtocol2;
        boolean z3;
        Connection onSwitchProtocol3;
        AsyncHttpConnection asyncHttpConnection = this;
        boolean z4 = true;
        boolean z5 = false;
        while (z4 && asyncHttpConnection == this) {
            try {
                LOG.debug("while open={} more={} progress={}", Boolean.valueOf(this._endp.isOpen()), Boolean.valueOf(this._parser.isMoreInBuffer()), Boolean.valueOf(z4));
                HttpExchange httpExchange = this._exchange;
                LOG.debug("exchange {} on {}", httpExchange, this);
                try {
                    if (this._generator.isCommitted() || httpExchange == null || httpExchange.getStatus() != 2) {
                        z = false;
                    } else {
                        LOG.debug("commit {}", httpExchange);
                        try {
                            commitRequest();
                            z = true;
                        } catch (Throwable th) {
                            th = th;
                            z = true;
                            try {
                                Logger logger = LOG;
                                logger.debug("Failure on " + this._exchange, th);
                                try {
                                    synchronized (this) {
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    z5 = true;
                                    LOG.debug("finally {} on {} progress={} {}", httpExchange, this, Boolean.valueOf(z), this._endp);
                                    if (!z5 && (!this._generator.isComplete() || !this._parser.isComplete())) {
                                        z2 = false;
                                        if (z2) {
                                            boolean z6 = !z5 && this._parser.isPersistent() && this._generator.isPersistent();
                                            this._generator.setPersistent(z6);
                                            reset();
                                            if (z6) {
                                                this._endp.setMaxIdleTime((int) this._destination.getHttpClient().getIdleTimeout());
                                            }
                                            synchronized (this) {
                                                HttpExchange httpExchange2 = this._exchange;
                                                this._exchange = null;
                                                if (httpExchange2 != null) {
                                                    httpExchange2.cancelTimeout(this._destination.getHttpClient());
                                                }
                                                if (this._status == 101 && (onSwitchProtocol = httpExchange2.onSwitchProtocol(this._endp)) != null) {
                                                    if (this._pipeline != null) {
                                                        this._destination.send(this._pipeline);
                                                    }
                                                    this._pipeline = null;
                                                    asyncHttpConnection = onSwitchProtocol;
                                                }
                                                if (this._pipeline != null) {
                                                    if (z6 && asyncHttpConnection == this) {
                                                        this._exchange = this._pipeline;
                                                        this._pipeline = null;
                                                    }
                                                    this._destination.send(this._pipeline);
                                                    this._pipeline = null;
                                                }
                                                if (this._exchange == null && !isReserved()) {
                                                    this._destination.returnConnection(this, !z6);
                                                }
                                            }
                                        }
                                        throw th;
                                    }
                                    z2 = true;
                                    if (z2) {
                                    }
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        }
                    }
                    try {
                        if (this._generator.isCommitted() && !this._generator.isComplete()) {
                            if (this._generator.flushBuffer() > 0) {
                                LOG.debug("flushed", new Object[0]);
                                z = true;
                            }
                            if (this._generator.isState(2)) {
                                if (this._requestContentChunk == null) {
                                    this._requestContentChunk = httpExchange.getRequestContentChunk(null);
                                }
                                if (this._requestContentChunk == null) {
                                    LOG.debug("complete {}", httpExchange);
                                    this._generator.complete();
                                } else if (this._generator.isEmpty()) {
                                    LOG.debug("addChunk", new Object[0]);
                                    Buffer buffer = this._requestContentChunk;
                                    Buffer requestContentChunk = httpExchange.getRequestContentChunk(null);
                                    this._requestContentChunk = requestContentChunk;
                                    this._generator.addContent(buffer, requestContentChunk == null);
                                }
                            }
                        }
                        if (this._generator.isComplete() && !this._requestComplete) {
                            LOG.debug("requestComplete {}", httpExchange);
                            this._requestComplete = true;
                            httpExchange.getEventListener().onRequestComplete();
                            z = true;
                        }
                        if (!this._parser.isComplete() && this._parser.parseAvailable()) {
                            LOG.debug("parsed {}", httpExchange);
                            z = true;
                        }
                        this._endp.flush();
                        if (this._asyncEndp.hasProgressed()) {
                            LOG.debug("hasProgressed {}", httpExchange);
                            z = true;
                        }
                        LOG.debug("finally {} on {} progress={} {}", httpExchange, this, Boolean.valueOf(z), this._endp);
                    } catch (Throwable th4) {
                        th = th4;
                        Logger logger2 = LOG;
                        logger2.debug("Failure on " + this._exchange, th);
                        synchronized (this) {
                            if (httpExchange == null) {
                                if (th instanceof IOException) {
                                    throw ((IOException) th);
                                }
                                if (th instanceof Error) {
                                    throw ((Error) th);
                                }
                                if (!(th instanceof RuntimeException)) {
                                    throw new RuntimeException(th);
                                }
                                throw th;
                            } else if (httpExchange.getStatus() != 10 && httpExchange.getStatus() != 11 && !httpExchange.isDone() && httpExchange.setStatus(9)) {
                                httpExchange.getEventListener().onException(th);
                            }
                        }
                        LOG.debug("finally {} on {} progress={} {}", httpExchange, this, Boolean.valueOf(z), this._endp);
                        this._generator.setPersistent(false);
                        reset();
                        synchronized (this) {
                            HttpExchange httpExchange3 = this._exchange;
                            this._exchange = null;
                            if (httpExchange3 != null) {
                                httpExchange3.cancelTimeout(this._destination.getHttpClient());
                            }
                            if (this._status == 101 && (onSwitchProtocol2 = httpExchange3.onSwitchProtocol(this._endp)) != null) {
                                if (this._pipeline != null) {
                                    this._destination.send(this._pipeline);
                                }
                                this._pipeline = null;
                                asyncHttpConnection = onSwitchProtocol2;
                            }
                            if (this._pipeline != null) {
                                this._destination.send(this._pipeline);
                                this._pipeline = null;
                            }
                            if (this._exchange == null && !isReserved()) {
                                this._destination.returnConnection(this, true);
                            }
                        }
                        z4 = z;
                        z5 = true;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    z = false;
                }
                if (!z5 && (!this._generator.isComplete() || !this._parser.isComplete())) {
                    z3 = false;
                    if (z3) {
                        boolean z7 = !z5 && this._parser.isPersistent() && this._generator.isPersistent();
                        this._generator.setPersistent(z7);
                        reset();
                        if (z7) {
                            this._endp.setMaxIdleTime((int) this._destination.getHttpClient().getIdleTimeout());
                        }
                        synchronized (this) {
                            HttpExchange httpExchange4 = this._exchange;
                            this._exchange = null;
                            if (httpExchange4 != null) {
                                httpExchange4.cancelTimeout(this._destination.getHttpClient());
                            }
                            if (this._status == 101 && (onSwitchProtocol3 = httpExchange4.onSwitchProtocol(this._endp)) != null) {
                                if (this._pipeline != null) {
                                    this._destination.send(this._pipeline);
                                }
                                this._pipeline = null;
                                asyncHttpConnection = onSwitchProtocol3;
                            }
                            if (this._pipeline != null) {
                                if (z7 && asyncHttpConnection == this) {
                                    this._exchange = this._pipeline;
                                    this._pipeline = null;
                                }
                                this._destination.send(this._pipeline);
                                this._pipeline = null;
                            }
                            if (this._exchange == null && !isReserved()) {
                                this._destination.returnConnection(this, !z7);
                            }
                        }
                    }
                    z4 = z;
                }
                z3 = true;
                if (z3) {
                }
                z4 = z;
            } catch (Throwable th6) {
                this._parser.returnBuffers();
                this._generator.returnBuffers();
                LOG.debug("unhandle {} on {}", this._exchange, this._endp);
                throw th6;
            }
        }
        this._parser.returnBuffers();
        this._generator.returnBuffers();
        LOG.debug("unhandle {} on {}", this._exchange, this._endp);
        return asyncHttpConnection;
    }

    @Override // org.eclipse.jetty.p059io.nio.AsyncConnection
    public void onInputShutdown() throws IOException {
        if (this._generator.isIdle()) {
            this._endp.shutdownOutput();
        }
    }

    @Override // org.eclipse.jetty.client.AbstractHttpConnection
    public void reset() throws IOException {
        this._requestComplete = false;
        super.reset();
    }

    @Override // org.eclipse.jetty.client.AbstractHttpConnection
    public boolean send(HttpExchange httpExchange) throws IOException {
        boolean send = super.send(httpExchange);
        if (send) {
            this._asyncEndp.asyncDispatch();
        }
        return send;
    }
}
