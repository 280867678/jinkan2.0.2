package org.eclipse.jetty.continuation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.DispatcherType;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletResponseWrapper;

/* loaded from: classes4.dex */
public class Servlet3Continuation implements Continuation {
    public static final ContinuationThrowable __exception = new ContinuationThrowable();
    public AsyncContext _context;
    public final ServletRequest _request;
    public ServletResponse _response;
    public List<AsyncListener> _listeners = new ArrayList();
    public volatile boolean _initial = true;
    public volatile boolean _resumed = false;
    public volatile boolean _expired = false;
    public volatile boolean _responseWrapped = false;
    public long _timeoutMs = -1;

    public Servlet3Continuation(ServletRequest servletRequest) {
        this._request = servletRequest;
        this._listeners.add(new AsyncListener() { // from class: org.eclipse.jetty.continuation.Servlet3Continuation.1
            @Override // javax.servlet.AsyncListener
            public void onComplete(AsyncEvent asyncEvent) throws IOException {
            }

            @Override // javax.servlet.AsyncListener
            public void onError(AsyncEvent asyncEvent) throws IOException {
            }

            @Override // javax.servlet.AsyncListener
            public void onStartAsync(AsyncEvent asyncEvent) throws IOException {
                asyncEvent.getAsyncContext().addListener(this);
            }

            @Override // javax.servlet.AsyncListener
            public void onTimeout(AsyncEvent asyncEvent) throws IOException {
                Servlet3Continuation.this._initial = false;
                asyncEvent.getAsyncContext().dispatch();
            }
        });
    }

    @Override // org.eclipse.jetty.continuation.Continuation
    public void addContinuationListener(final ContinuationListener continuationListener) {
        AsyncListener asyncListener = new AsyncListener() { // from class: org.eclipse.jetty.continuation.Servlet3Continuation.2
            @Override // javax.servlet.AsyncListener
            public void onComplete(AsyncEvent asyncEvent) throws IOException {
                continuationListener.onComplete(Servlet3Continuation.this);
            }

            @Override // javax.servlet.AsyncListener
            public void onError(AsyncEvent asyncEvent) throws IOException {
                continuationListener.onComplete(Servlet3Continuation.this);
            }

            @Override // javax.servlet.AsyncListener
            public void onStartAsync(AsyncEvent asyncEvent) throws IOException {
                asyncEvent.getAsyncContext().addListener(this);
            }

            @Override // javax.servlet.AsyncListener
            public void onTimeout(AsyncEvent asyncEvent) throws IOException {
                Servlet3Continuation.this._expired = true;
                continuationListener.onTimeout(Servlet3Continuation.this);
            }
        };
        AsyncContext asyncContext = this._context;
        if (asyncContext != null) {
            asyncContext.addListener(asyncListener);
        } else {
            this._listeners.add(asyncListener);
        }
    }

    @Override // org.eclipse.jetty.continuation.Continuation
    public void complete() {
        AsyncContext asyncContext = this._context;
        if (asyncContext != null) {
            asyncContext.complete();
            return;
        }
        throw new IllegalStateException();
    }

    @Override // org.eclipse.jetty.continuation.Continuation
    public Object getAttribute(String str) {
        return this._request.getAttribute(str);
    }

    @Override // org.eclipse.jetty.continuation.Continuation
    public ServletResponse getServletResponse() {
        return this._response;
    }

    @Override // org.eclipse.jetty.continuation.Continuation
    public boolean isExpired() {
        return this._expired;
    }

    @Override // org.eclipse.jetty.continuation.Continuation
    public boolean isInitial() {
        return this._initial && this._request.getDispatcherType() != DispatcherType.ASYNC;
    }

    @Override // org.eclipse.jetty.continuation.Continuation
    public boolean isResponseWrapped() {
        return this._responseWrapped;
    }

    @Override // org.eclipse.jetty.continuation.Continuation
    public boolean isResumed() {
        return this._resumed;
    }

    @Override // org.eclipse.jetty.continuation.Continuation
    public boolean isSuspended() {
        return this._request.isAsyncStarted();
    }

    public void keepWrappers() {
        this._responseWrapped = true;
    }

    @Override // org.eclipse.jetty.continuation.Continuation
    public void removeAttribute(String str) {
        this._request.removeAttribute(str);
    }

    @Override // org.eclipse.jetty.continuation.Continuation
    public void resume() {
        if (this._context != null) {
            this._resumed = true;
            this._context.dispatch();
            return;
        }
        throw new IllegalStateException();
    }

    @Override // org.eclipse.jetty.continuation.Continuation
    public void setAttribute(String str, Object obj) {
        this._request.setAttribute(str, obj);
    }

    @Override // org.eclipse.jetty.continuation.Continuation
    public void setTimeout(long j) {
        this._timeoutMs = j;
        AsyncContext asyncContext = this._context;
        if (asyncContext != null) {
            asyncContext.setTimeout(j);
        }
    }

    @Override // org.eclipse.jetty.continuation.Continuation
    public void suspend() {
        this._resumed = false;
        this._expired = false;
        AsyncContext startAsync = this._request.startAsync();
        this._context = startAsync;
        startAsync.setTimeout(this._timeoutMs);
        for (AsyncListener asyncListener : this._listeners) {
            this._context.addListener(asyncListener);
        }
        this._listeners.clear();
    }

    @Override // org.eclipse.jetty.continuation.Continuation
    public void suspend(ServletResponse servletResponse) {
        this._response = servletResponse;
        this._responseWrapped = servletResponse instanceof ServletResponseWrapper;
        this._resumed = false;
        this._expired = false;
        AsyncContext startAsync = this._request.startAsync();
        this._context = startAsync;
        startAsync.setTimeout(this._timeoutMs);
        for (AsyncListener asyncListener : this._listeners) {
            this._context.addListener(asyncListener);
        }
        this._listeners.clear();
    }

    @Override // org.eclipse.jetty.continuation.Continuation
    public void undispatch() {
        if (isSuspended()) {
            if (!ContinuationFilter.__debug) {
                throw __exception;
            }
            throw new ContinuationThrowable();
        }
        throw new IllegalStateException("!suspended");
    }
}
