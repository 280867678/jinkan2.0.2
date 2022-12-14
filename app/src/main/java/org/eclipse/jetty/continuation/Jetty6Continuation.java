package org.eclipse.jetty.continuation;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletResponseWrapper;
import org.eclipse.jetty.continuation.ContinuationFilter;
import org.mortbay.log.Log;
import org.mortbay.log.Logger;

/* loaded from: classes4.dex */
public class Jetty6Continuation implements ContinuationFilter.FilteredContinuation {
    public static final Logger LOG = Log.getLogger(Jetty6Continuation.class.getName());
    public static final ContinuationThrowable __exception = new ContinuationThrowable();
    public final org.mortbay.util.ajax.Continuation _j6Continuation;
    public List<ContinuationListener> _listeners;
    public final ServletRequest _request;
    public ServletResponse _response;
    public Throwable _retry;
    public int _timeout;
    public boolean _initial = true;
    public volatile boolean _completed = false;
    public volatile boolean _resumed = false;
    public volatile boolean _expired = false;
    public boolean _responseWrapped = false;

    public Jetty6Continuation(ServletRequest servletRequest, org.mortbay.util.ajax.Continuation continuation) {
        if (!ContinuationFilter._initialized) {
            LOG.warn("!ContinuationFilter installed", (Object) null, (Object) null);
            throw new IllegalStateException("!ContinuationFilter installed");
        }
        this._request = servletRequest;
        this._j6Continuation = continuation;
    }

    @Override // org.eclipse.jetty.continuation.Continuation
    public void addContinuationListener(ContinuationListener continuationListener) {
        if (this._listeners == null) {
            this._listeners = new ArrayList();
        }
        this._listeners.add(continuationListener);
    }

    @Override // org.eclipse.jetty.continuation.Continuation
    public void complete() {
        synchronized (this) {
            if (this._resumed) {
                throw new IllegalStateException();
            }
            this._completed = true;
            if (this._j6Continuation.isPending()) {
                this._j6Continuation.resume();
            }
        }
    }

    @Override // org.eclipse.jetty.continuation.ContinuationFilter.FilteredContinuation
    public boolean enter(ServletResponse servletResponse) {
        List<ContinuationListener> list;
        this._response = servletResponse;
        this._expired = !this._j6Continuation.isResumed();
        if (this._initial) {
            return true;
        }
        this._j6Continuation.reset();
        if (this._expired && (list = this._listeners) != null) {
            for (ContinuationListener continuationListener : list) {
                continuationListener.onTimeout(this);
            }
        }
        return !this._completed;
    }

    @Override // org.eclipse.jetty.continuation.ContinuationFilter.FilteredContinuation
    public boolean exit() {
        this._initial = false;
        Throwable th = this._retry;
        this._retry = null;
        if (!(th instanceof Error)) {
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            List<ContinuationListener> list = this._listeners;
            if (list == null) {
                return true;
            }
            for (ContinuationListener continuationListener : list) {
                continuationListener.onComplete(this);
            }
            return true;
        }
        throw ((Error) th);
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
        return this._initial;
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
        return this._retry != null;
    }

    @Override // org.eclipse.jetty.continuation.Continuation
    public void removeAttribute(String str) {
        this._request.removeAttribute(str);
    }

    @Override // org.eclipse.jetty.continuation.Continuation
    public void resume() {
        synchronized (this) {
            if (this._completed) {
                throw new IllegalStateException();
            }
            this._resumed = true;
            if (this._j6Continuation.isPending()) {
                this._j6Continuation.resume();
            }
        }
    }

    @Override // org.eclipse.jetty.continuation.Continuation
    public void setAttribute(String str, Object obj) {
        this._request.setAttribute(str, obj);
    }

    @Override // org.eclipse.jetty.continuation.Continuation
    public void setTimeout(long j) {
        this._timeout = j > 2147483647L ? Integer.MAX_VALUE : (int) j;
    }

    @Override // org.eclipse.jetty.continuation.Continuation
    public void suspend() {
        try {
            this._response = null;
            this._responseWrapped = false;
            this._resumed = false;
            this._expired = false;
            this._completed = false;
            this._j6Continuation.suspend(this._timeout);
        } catch (Throwable th) {
            this._retry = th;
        }
    }

    @Override // org.eclipse.jetty.continuation.Continuation
    public void suspend(ServletResponse servletResponse) {
        try {
            this._response = servletResponse;
            this._responseWrapped = servletResponse instanceof ServletResponseWrapper;
            this._resumed = false;
            this._expired = false;
            this._completed = false;
            this._j6Continuation.suspend(this._timeout);
        } catch (Throwable th) {
            this._retry = th;
        }
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
