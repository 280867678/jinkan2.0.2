package org.eclipse.jetty.server.handler;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.ServletException;
import me.tvspark.ae0;
import me.tvspark.ce0;
import org.eclipse.jetty.continuation.Continuation;
import org.eclipse.jetty.continuation.ContinuationListener;
import org.eclipse.jetty.server.AsyncContinuation;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.RequestLog;
import org.eclipse.jetty.server.Response;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.component.AbstractLifeCycle;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: classes4.dex */
public class RequestLogHandler extends HandlerWrapper {
    public static final Logger LOG = Log.getLogger(RequestLogHandler.class);
    public RequestLog _requestLog;

    /* loaded from: classes4.dex */
    public static class NullRequestLog extends AbstractLifeCycle implements RequestLog {
        public NullRequestLog() {
        }

        @Override // org.eclipse.jetty.server.RequestLog
        public void log(Request request, Response response) {
        }
    }

    @Override // org.eclipse.jetty.server.handler.HandlerWrapper, org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.util.component.AggregateLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        if (this._requestLog == null) {
            LOG.warn("!RequestLog", new Object[0]);
            this._requestLog = new NullRequestLog();
        }
        super.doStart();
        this._requestLog.start();
    }

    @Override // org.eclipse.jetty.server.handler.HandlerWrapper, org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.util.component.AggregateLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStop() throws Exception {
        super.doStop();
        this._requestLog.stop();
        if (this._requestLog instanceof NullRequestLog) {
            this._requestLog = null;
        }
    }

    public RequestLog getRequestLog() {
        return this._requestLog;
    }

    @Override // org.eclipse.jetty.server.handler.HandlerWrapper, org.eclipse.jetty.server.Handler
    public void handle(String str, final Request request, ae0 ae0Var, final ce0 ce0Var) throws IOException, ServletException {
        AsyncContinuation asyncContinuation = request.getAsyncContinuation();
        if (!asyncContinuation.isInitial()) {
            request.setDispatchTime(System.currentTimeMillis());
        }
        try {
            super.handle(str, request, ae0Var, ce0Var);
            if (this._requestLog == null || !request.getDispatcherType().equals(DispatcherType.REQUEST)) {
                return;
            }
            if (!asyncContinuation.isAsync()) {
                this._requestLog.log(request, (Response) ce0Var);
            } else if (!asyncContinuation.isInitial()) {
            } else {
                asyncContinuation.addContinuationListener(new ContinuationListener() { // from class: org.eclipse.jetty.server.handler.RequestLogHandler.1
                    @Override // org.eclipse.jetty.continuation.ContinuationListener
                    public void onComplete(Continuation continuation) {
                        RequestLogHandler.this._requestLog.log(request, (Response) ce0Var);
                    }

                    @Override // org.eclipse.jetty.continuation.ContinuationListener
                    public void onTimeout(Continuation continuation) {
                    }
                });
            }
        } catch (Throwable th) {
            if (this._requestLog != null && request.getDispatcherType().equals(DispatcherType.REQUEST)) {
                if (!asyncContinuation.isAsync()) {
                    this._requestLog.log(request, (Response) ce0Var);
                } else if (asyncContinuation.isInitial()) {
                    asyncContinuation.addContinuationListener(new ContinuationListener() { // from class: org.eclipse.jetty.server.handler.RequestLogHandler.1
                        @Override // org.eclipse.jetty.continuation.ContinuationListener
                        public void onComplete(Continuation continuation) {
                            RequestLogHandler.this._requestLog.log(request, (Response) ce0Var);
                        }

                        @Override // org.eclipse.jetty.continuation.ContinuationListener
                        public void onTimeout(Continuation continuation) {
                        }
                    });
                }
            }
            throw th;
        }
    }

    public void setRequestLog(RequestLog requestLog) {
        try {
            if (this._requestLog != null) {
                this._requestLog.stop();
            }
        } catch (Exception e) {
            LOG.warn(e);
        }
        if (getServer() != null) {
            getServer().getContainer().update((Object) this, (Object) this._requestLog, (Object) requestLog, "logimpl", true);
        }
        this._requestLog = requestLog;
        try {
            if (!isStarted() || this._requestLog == null) {
                return;
            }
            this._requestLog.start();
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // org.eclipse.jetty.server.handler.HandlerWrapper, org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.server.Handler
    public void setServer(Server server) {
        if (this._requestLog == null) {
            super.setServer(server);
            return;
        }
        if (getServer() != null && getServer() != server) {
            getServer().getContainer().update((Object) this, (Object) this._requestLog, (Object) null, "logimpl", true);
        }
        super.setServer(server);
        if (server == null || server == getServer()) {
            return;
        }
        server.getContainer().update((Object) this, (Object) null, (Object) this._requestLog, "logimpl", true);
    }
}
