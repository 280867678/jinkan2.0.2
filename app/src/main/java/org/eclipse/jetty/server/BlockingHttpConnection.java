package org.eclipse.jetty.server;

import java.io.IOException;
import org.eclipse.jetty.http.Generator;
import org.eclipse.jetty.http.HttpException;
import org.eclipse.jetty.http.Parser;
import org.eclipse.jetty.p059io.Connection;
import org.eclipse.jetty.p059io.EndPoint;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: classes4.dex */
public class BlockingHttpConnection extends AbstractHttpConnection {
    public static final Logger LOG = Log.getLogger(BlockingHttpConnection.class);

    public BlockingHttpConnection(Connector connector, EndPoint endPoint, Server server) {
        super(connector, endPoint, server);
    }

    public BlockingHttpConnection(Connector connector, EndPoint endPoint, Server server, Parser parser, Generator generator, Request request) {
        super(connector, endPoint, server, parser, generator, request);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v19, types: [org.eclipse.jetty.io.Connection] */
    /* JADX WARN: Type inference failed for: r4v37, types: [org.eclipse.jetty.io.Connection] */
    @Override // org.eclipse.jetty.server.AbstractHttpConnection, org.eclipse.jetty.p059io.Connection
    public Connection handle() throws IOException {
        EndPoint endPoint;
        ?? r4;
        ?? r42;
        try {
            AbstractHttpConnection.setCurrentConnection(this);
            BlockingHttpConnection blockingHttpConnection = this;
            while (this._endp.isOpen() && blockingHttpConnection == this) {
                try {
                    if (!this._parser.isComplete() && !this._endp.isInputShutdown()) {
                        this._parser.parseAvailable();
                    }
                    if (this._generator.isCommitted() && !this._generator.isComplete() && !this._endp.isOutputShutdown()) {
                        this._generator.flushBuffer();
                    }
                    this._endp.flush();
                    if (this._parser.isComplete() && this._generator.isComplete()) {
                        reset();
                        if (this._response.getStatus() == 101 && (r42 = (Connection) this._request.getAttribute("org.eclipse.jetty.io.Connection")) != 0) {
                            blockingHttpConnection = r42;
                        }
                        if (!this._generator.isPersistent() && !this._endp.isOutputShutdown()) {
                            LOG.warn("Safety net oshut!!! Please open a bugzilla", new Object[0]);
                            this._endp.shutdownOutput();
                        }
                    }
                } catch (HttpException e) {
                    if (LOG.isDebugEnabled()) {
                        Logger logger = LOG;
                        logger.debug("uri=" + this._uri, new Object[0]);
                        Logger logger2 = LOG;
                        logger2.debug("fields=" + this._requestFields, new Object[0]);
                        LOG.debug(e);
                    }
                    this._generator.sendError(e.getStatus(), e.getReason(), null, true);
                    this._parser.reset();
                    this._endp.shutdownOutput();
                    if (this._parser.isComplete() && this._generator.isComplete()) {
                        reset();
                        if (this._response.getStatus() == 101 && (r4 = (Connection) this._request.getAttribute("org.eclipse.jetty.io.Connection")) != 0) {
                            blockingHttpConnection = r4;
                        }
                        if (!this._generator.isPersistent() && !this._endp.isOutputShutdown()) {
                            LOG.warn("Safety net oshut!!! Please open a bugzilla", new Object[0]);
                            this._endp.shutdownOutput();
                        }
                    }
                    if (this._endp.isInputShutdown() && this._generator.isIdle() && !this._request.getAsyncContinuation().isSuspended()) {
                        endPoint = this._endp;
                    }
                }
                if (this._endp.isInputShutdown() && this._generator.isIdle() && !this._request.getAsyncContinuation().isSuspended()) {
                    endPoint = this._endp;
                    endPoint.close();
                }
            }
            return blockingHttpConnection;
        } finally {
            AbstractHttpConnection.setCurrentConnection(null);
            this._parser.returnBuffers();
            this._generator.returnBuffers();
        }
    }

    @Override // org.eclipse.jetty.server.AbstractHttpConnection
    public void handleRequest() throws IOException {
        super.handleRequest();
    }
}
