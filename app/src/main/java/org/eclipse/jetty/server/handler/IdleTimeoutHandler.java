package org.eclipse.jetty.server.handler;

import java.io.IOException;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletException;
import me.tvspark.ae0;
import me.tvspark.ce0;
import org.eclipse.jetty.p059io.EndPoint;
import org.eclipse.jetty.server.AbstractHttpConnection;
import org.eclipse.jetty.server.Request;

/* loaded from: classes4.dex */
public class IdleTimeoutHandler extends HandlerWrapper {
    public int _idleTimeoutMs = 1000;
    public boolean _applyToAsync = false;

    public long getIdleTimeoutMs() {
        return this._idleTimeoutMs;
    }

    @Override // org.eclipse.jetty.server.handler.HandlerWrapper, org.eclipse.jetty.server.Handler
    public void handle(String str, Request request, ae0 ae0Var, ce0 ce0Var) throws IOException, ServletException {
        final int maxIdleTime;
        AbstractHttpConnection currentConnection = AbstractHttpConnection.getCurrentConnection();
        final EndPoint endPoint = currentConnection == null ? null : currentConnection.getEndPoint();
        if (endPoint == null) {
            maxIdleTime = -1;
        } else {
            maxIdleTime = endPoint.getMaxIdleTime();
            endPoint.setMaxIdleTime(this._idleTimeoutMs);
        }
        try {
            super.handle(str, request, ae0Var, ce0Var);
            if (endPoint == null) {
                return;
            }
            if (!this._applyToAsync || !ae0Var.isAsyncStarted()) {
                endPoint.setMaxIdleTime(maxIdleTime);
            } else {
                ae0Var.getAsyncContext().addListener(new AsyncListener() { // from class: org.eclipse.jetty.server.handler.IdleTimeoutHandler.1
                    @Override // javax.servlet.AsyncListener
                    public void onComplete(AsyncEvent asyncEvent) throws IOException {
                        endPoint.setMaxIdleTime(maxIdleTime);
                    }

                    @Override // javax.servlet.AsyncListener
                    public void onError(AsyncEvent asyncEvent) throws IOException {
                        endPoint.setMaxIdleTime(maxIdleTime);
                    }

                    @Override // javax.servlet.AsyncListener
                    public void onStartAsync(AsyncEvent asyncEvent) throws IOException {
                    }

                    @Override // javax.servlet.AsyncListener
                    public void onTimeout(AsyncEvent asyncEvent) throws IOException {
                    }
                });
            }
        } catch (Throwable th) {
            if (endPoint != null) {
                if (!this._applyToAsync || !ae0Var.isAsyncStarted()) {
                    endPoint.setMaxIdleTime(maxIdleTime);
                } else {
                    ae0Var.getAsyncContext().addListener(new AsyncListener() { // from class: org.eclipse.jetty.server.handler.IdleTimeoutHandler.1
                        @Override // javax.servlet.AsyncListener
                        public void onComplete(AsyncEvent asyncEvent) throws IOException {
                            endPoint.setMaxIdleTime(maxIdleTime);
                        }

                        @Override // javax.servlet.AsyncListener
                        public void onError(AsyncEvent asyncEvent) throws IOException {
                            endPoint.setMaxIdleTime(maxIdleTime);
                        }

                        @Override // javax.servlet.AsyncListener
                        public void onStartAsync(AsyncEvent asyncEvent) throws IOException {
                        }

                        @Override // javax.servlet.AsyncListener
                        public void onTimeout(AsyncEvent asyncEvent) throws IOException {
                        }
                    });
                }
            }
            throw th;
        }
    }

    public boolean isApplyToAsync() {
        return this._applyToAsync;
    }

    public void setApplyToAsync(boolean z) {
        this._applyToAsync = z;
    }

    public void setIdleTimeoutMs(int i) {
        this._idleTimeoutMs = i;
    }
}
