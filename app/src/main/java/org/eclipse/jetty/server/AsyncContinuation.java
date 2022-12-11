package org.eclipse.jetty.server;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import me.tvspark.ae0;
import org.eclipse.jetty.continuation.Continuation;
import org.eclipse.jetty.continuation.ContinuationListener;
import org.eclipse.jetty.continuation.ContinuationThrowable;
import org.eclipse.jetty.p059io.AsyncEndPoint;
import org.eclipse.jetty.p059io.EndPoint;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.util.URIUtil;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.thread.Timeout;

/* loaded from: classes4.dex */
public class AsyncContinuation implements AsyncContext, Continuation {
    public static final long DEFAULT_TIMEOUT = 30000;
    public static final int __ASYNCSTARTED = 2;
    public static final int __ASYNCWAIT = 4;
    public static final int __COMPLETED = 9;
    public static final int __COMPLETING = 7;
    public static final int __DISPATCHED = 1;
    public static final int __IDLE = 0;
    public static final int __REDISPATCH = 5;
    public static final int __REDISPATCHED = 6;
    public static final int __REDISPATCHING = 3;
    public static final int __UNCOMPLETED = 8;
    public List<AsyncListener> _asyncListeners;
    public AbstractHttpConnection _connection;
    public volatile boolean _continuation;
    public List<ContinuationListener> _continuationListeners;
    public AsyncEventState _event;
    public volatile long _expireAt;
    public boolean _expired;
    public List<AsyncListener> _lastAsyncListeners;
    public volatile boolean _responseWrapped;
    public boolean _resumed;
    public static final Logger LOG = Log.getLogger(AsyncContinuation.class);
    public static final ContinuationThrowable __exception = new ContinuationThrowable();
    public long _timeoutMs = DEFAULT_TIMEOUT;
    public int _state = 0;
    public boolean _initial = true;

    /* loaded from: classes4.dex */
    public class AsyncEventState extends AsyncEvent {
        public ServletContext _dispatchContext;
        public String _pathInContext;
        public final ServletContext _suspendedContext;
        public Timeout.Task _timeout;

        public AsyncEventState(ServletContext servletContext, ServletRequest servletRequest, ServletResponse servletResponse) {
            super(AsyncContinuation.this, servletRequest, servletResponse);
            Object queryString;
            this._timeout = new AsyncTimeout();
            this._suspendedContext = servletContext;
            Request request = AsyncContinuation.this._connection.getRequest();
            if (request.getAttribute(AsyncContext.ASYNC_REQUEST_URI) == null) {
                String str = (String) request.getAttribute(RequestDispatcher.FORWARD_REQUEST_URI);
                if (str != null) {
                    request.setAttribute(AsyncContext.ASYNC_REQUEST_URI, str);
                    request.setAttribute(AsyncContext.ASYNC_CONTEXT_PATH, request.getAttribute(RequestDispatcher.FORWARD_CONTEXT_PATH));
                    request.setAttribute(AsyncContext.ASYNC_SERVLET_PATH, request.getAttribute(RequestDispatcher.FORWARD_SERVLET_PATH));
                    request.setAttribute(AsyncContext.ASYNC_PATH_INFO, request.getAttribute(RequestDispatcher.FORWARD_PATH_INFO));
                    queryString = request.getAttribute(RequestDispatcher.FORWARD_QUERY_STRING);
                } else {
                    request.setAttribute(AsyncContext.ASYNC_REQUEST_URI, request.getRequestURI());
                    request.setAttribute(AsyncContext.ASYNC_CONTEXT_PATH, request.getContextPath());
                    request.setAttribute(AsyncContext.ASYNC_SERVLET_PATH, request.getServletPath());
                    request.setAttribute(AsyncContext.ASYNC_PATH_INFO, request.getPathInfo());
                    queryString = request.getQueryString();
                }
                request.setAttribute(AsyncContext.ASYNC_QUERY_STRING, queryString);
            }
        }

        public ServletContext getDispatchContext() {
            return this._dispatchContext;
        }

        public String getPath() {
            return this._pathInContext;
        }

        public ServletContext getServletContext() {
            ServletContext servletContext = this._dispatchContext;
            return servletContext == null ? this._suspendedContext : servletContext;
        }

        public ServletContext getSuspendedContext() {
            return this._suspendedContext;
        }

        public void setPath(String str) {
            this._pathInContext = str;
        }
    }

    /* loaded from: classes4.dex */
    public class AsyncTimeout extends Timeout.Task implements Runnable {
        public AsyncTimeout() {
        }

        @Override // org.eclipse.jetty.util.thread.Timeout.Task
        public void expired() {
            AsyncContinuation.this.expired();
        }

        @Override // java.lang.Runnable
        public void run() {
            AsyncContinuation.this.expired();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0056 A[Catch: all -> 0x007c, TryCatch #1 {, blocks: (B:3:0x0001, B:8:0x000a, B:9:0x0013, B:11:0x0014, B:13:0x001d, B:15:0x0025, B:17:0x002d, B:20:0x0036, B:21:0x0049, B:23:0x0056, B:24:0x0059, B:42:0x0042), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void doSuspend(ServletContext servletContext, ServletRequest servletRequest, ServletResponse servletResponse) {
        List<AsyncListener> list;
        synchronized (this) {
            int i = this._state;
            if (i != 1 && i != 6) {
                throw new IllegalStateException(getStatusString());
            }
            this._resumed = false;
            this._expired = false;
            if (this._event != null && servletRequest == this._event.getSuppliedRequest() && servletResponse == this._event.getSuppliedResponse() && servletContext == this._event.getServletContext()) {
                this._event._dispatchContext = null;
                this._event._pathInContext = null;
                this._state = 2;
                list = this._lastAsyncListeners;
                this._lastAsyncListeners = this._asyncListeners;
                this._asyncListeners = list;
                if (list != null) {
                    list.clear();
                }
            }
            this._event = new AsyncEventState(servletContext, servletRequest, servletResponse);
            this._state = 2;
            list = this._lastAsyncListeners;
            this._lastAsyncListeners = this._asyncListeners;
            this._asyncListeners = list;
            if (list != null) {
            }
        }
        List<AsyncListener> list2 = this._lastAsyncListeners;
        if (list2 != null) {
            for (AsyncListener asyncListener : list2) {
                try {
                    asyncListener.onStartAsync(this._event);
                } catch (Exception e) {
                    LOG.warn(e);
                }
            }
        }
    }

    @Override // org.eclipse.jetty.continuation.Continuation
    public void addContinuationListener(ContinuationListener continuationListener) {
        synchronized (this) {
            if (this._continuationListeners == null) {
                this._continuationListeners = new ArrayList();
            }
            this._continuationListeners.add(continuationListener);
        }
    }

    @Override // javax.servlet.AsyncContext
    public void addListener(AsyncListener asyncListener) {
        synchronized (this) {
            if (this._asyncListeners == null) {
                this._asyncListeners = new ArrayList();
            }
            this._asyncListeners.add(asyncListener);
        }
    }

    @Override // javax.servlet.AsyncContext
    public void addListener(AsyncListener asyncListener, ServletRequest servletRequest, ServletResponse servletResponse) {
        synchronized (this) {
            if (this._asyncListeners == null) {
                this._asyncListeners = new ArrayList();
            }
            this._asyncListeners.add(asyncListener);
        }
    }

    public void cancel() {
        synchronized (this) {
            cancelTimeout();
            this._continuationListeners = null;
        }
    }

    public void cancelTimeout() {
        EndPoint endPoint = this._connection.getEndPoint();
        if (endPoint.isBlocking()) {
            synchronized (this) {
                this._expireAt = 0L;
                notifyAll();
            }
            return;
        }
        AsyncEventState asyncEventState = this._event;
        if (asyncEventState == null) {
            return;
        }
        ((AsyncEndPoint) endPoint).cancelTimeout(asyncEventState._timeout);
    }

    @Override // javax.servlet.AsyncContext, org.eclipse.jetty.continuation.Continuation
    public void complete() {
        synchronized (this) {
            int i = this._state;
            if (i != 1) {
                if (i == 2) {
                    this._state = 7;
                    return;
                } else if (i == 4) {
                    this._state = 7;
                    boolean z = !this._expired;
                    if (!z) {
                        return;
                    }
                    cancelTimeout();
                    scheduleDispatch();
                    return;
                } else if (i != 6) {
                    throw new IllegalStateException(getStatusString());
                }
            }
            throw new IllegalStateException(getStatusString());
        }
    }

    @Override // javax.servlet.AsyncContext
    public <T extends AsyncListener> T createListener(Class<T> cls) throws ServletException {
        try {
            return cls.newInstance();
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    @Override // javax.servlet.AsyncContext
    public void dispatch() {
        synchronized (this) {
            int i = this._state;
            if (i == 2) {
                this._state = 3;
                this._resumed = true;
            } else if (i != 4) {
                if (i != 5) {
                    throw new IllegalStateException(getStatusString());
                }
            } else {
                boolean z = !this._expired;
                this._state = 5;
                this._resumed = true;
                if (!z) {
                    return;
                }
                cancelTimeout();
                scheduleDispatch();
            }
        }
    }

    @Override // javax.servlet.AsyncContext
    public void dispatch(String str) {
        this._event.setPath(str);
        dispatch();
    }

    @Override // javax.servlet.AsyncContext
    public void dispatch(ServletContext servletContext, String str) {
        this._event._dispatchContext = servletContext;
        this._event.setPath(str);
        dispatch();
    }

    public void doComplete(Throwable th) {
        List<ContinuationListener> list;
        List<AsyncListener> list2;
        synchronized (this) {
            if (this._state != 8) {
                throw new IllegalStateException(getStatusString());
            }
            this._state = 9;
            list = this._continuationListeners;
            list2 = this._asyncListeners;
        }
        if (list2 != null) {
            for (AsyncListener asyncListener : list2) {
                if (th != null) {
                    try {
                        this._event.getSuppliedRequest().setAttribute(RequestDispatcher.ERROR_EXCEPTION, th);
                        this._event.getSuppliedRequest().setAttribute(RequestDispatcher.ERROR_MESSAGE, th.getMessage());
                        asyncListener.onError(this._event);
                    } catch (Exception e) {
                        LOG.warn(e);
                    }
                } else {
                    asyncListener.onComplete(this._event);
                }
            }
        }
        if (list != null) {
            for (ContinuationListener continuationListener : list) {
                try {
                    continuationListener.onComplete(this);
                } catch (Exception e2) {
                    LOG.warn(e2);
                }
            }
        }
    }

    public void errorComplete() {
        synchronized (this) {
            int i = this._state;
            if (i == 2 || i == 3) {
                this._state = 7;
                this._resumed = false;
            } else if (i != 7) {
                throw new IllegalStateException(getStatusString());
            }
        }
    }

    public void expired() {
        synchronized (this) {
            int i = this._state;
            if (i == 2 || i == 4) {
                List<ContinuationListener> list = this._continuationListeners;
                List<AsyncListener> list2 = this._asyncListeners;
                this._expired = true;
                if (list2 != null) {
                    for (AsyncListener asyncListener : list2) {
                        try {
                            asyncListener.onTimeout(this._event);
                        } catch (Exception e) {
                            LOG.debug(e);
                            this._connection.getRequest().setAttribute(RequestDispatcher.ERROR_EXCEPTION, e);
                        }
                    }
                }
                if (list != null) {
                    for (ContinuationListener continuationListener : list) {
                        try {
                            continuationListener.onTimeout(this);
                        } catch (Exception e2) {
                            LOG.warn(e2);
                        }
                    }
                }
                synchronized (this) {
                    int i2 = this._state;
                    if (i2 == 2 || i2 == 4) {
                        dispatch();
                    } else if (!this._continuation) {
                        this._expired = false;
                    }
                }
                scheduleDispatch();
            }
        }
    }

    public AsyncEventState getAsyncEventState() {
        AsyncEventState asyncEventState;
        synchronized (this) {
            asyncEventState = this._event;
        }
        return asyncEventState;
    }

    @Override // org.eclipse.jetty.continuation.Continuation
    public Object getAttribute(String str) {
        return this._connection.getRequest().getAttribute(str);
    }

    public Request getBaseRequest() {
        return this._connection.getRequest();
    }

    public ContextHandler getContextHandler() {
        AsyncEventState asyncEventState = this._event;
        if (asyncEventState != null) {
            return ((ContextHandler.Context) asyncEventState.getServletContext()).getContextHandler();
        }
        return null;
    }

    @Override // javax.servlet.AsyncContext
    public ServletRequest getRequest() {
        AsyncEventState asyncEventState = this._event;
        return asyncEventState != null ? asyncEventState.getSuppliedRequest() : this._connection.getRequest();
    }

    @Override // javax.servlet.AsyncContext
    public ServletResponse getResponse() {
        AsyncEventState asyncEventState;
        return (!this._responseWrapped || (asyncEventState = this._event) == null || asyncEventState.getSuppliedResponse() == null) ? this._connection.getResponse() : this._event.getSuppliedResponse();
    }

    @Override // org.eclipse.jetty.continuation.Continuation
    public ServletResponse getServletResponse() {
        AsyncEventState asyncEventState;
        return (!this._responseWrapped || (asyncEventState = this._event) == null || asyncEventState.getSuppliedResponse() == null) ? this._connection.getResponse() : this._event.getSuppliedResponse();
    }

    public String getStatusString() {
        String str;
        String sb;
        synchronized (this) {
            StringBuilder sb2 = new StringBuilder();
            if (this._state == 0) {
                str = "IDLE";
            } else if (this._state == 1) {
                str = "DISPATCHED";
            } else if (this._state == 2) {
                str = "ASYNCSTARTED";
            } else if (this._state == 4) {
                str = "ASYNCWAIT";
            } else if (this._state == 3) {
                str = "REDISPATCHING";
            } else if (this._state == 5) {
                str = "REDISPATCH";
            } else if (this._state == 6) {
                str = "REDISPATCHED";
            } else if (this._state == 7) {
                str = "COMPLETING";
            } else if (this._state == 8) {
                str = "UNCOMPLETED";
            } else if (this._state == 9) {
                str = "COMPLETE";
            } else {
                str = "UNKNOWN?" + this._state;
            }
            sb2.append(str);
            sb2.append(this._initial ? ",initial" : "");
            sb2.append(this._resumed ? ",resumed" : "");
            sb2.append(this._expired ? ",expired" : "");
            sb = sb2.toString();
        }
        return sb;
    }

    @Override // javax.servlet.AsyncContext
    public long getTimeout() {
        long j;
        synchronized (this) {
            j = this._timeoutMs;
        }
        return j;
    }

    public boolean handling() {
        synchronized (this) {
            this._continuation = false;
            int i = this._state;
            if (i != 0) {
                if (i == 7) {
                    this._state = 8;
                    return false;
                } else if (i == 4) {
                    return false;
                } else {
                    if (i != 5) {
                        throw new IllegalStateException(getStatusString());
                    }
                    this._state = 6;
                    return true;
                }
            }
            this._initial = true;
            this._state = 1;
            if (this._lastAsyncListeners != null) {
                this._lastAsyncListeners.clear();
            }
            if (this._asyncListeners != null) {
                this._asyncListeners.clear();
            } else {
                this._asyncListeners = this._lastAsyncListeners;
                this._lastAsyncListeners = null;
            }
            return true;
        }
    }

    @Override // javax.servlet.AsyncContext
    public boolean hasOriginalRequestAndResponse() {
        boolean z;
        synchronized (this) {
            z = this._event != null && this._event.getSuppliedRequest() == this._connection._request && this._event.getSuppliedResponse() == this._connection._response;
        }
        return z;
    }

    public boolean isAsync() {
        synchronized (this) {
            int i = this._state;
            return (i == 0 || i == 1 || i == 8 || i == 9) ? false : true;
        }
    }

    public boolean isAsyncStarted() {
        synchronized (this) {
            int i = this._state;
            return i == 2 || i == 3 || i == 4 || i == 5;
        }
    }

    public boolean isComplete() {
        boolean z;
        synchronized (this) {
            z = this._state == 9;
        }
        return z;
    }

    public boolean isCompleting() {
        boolean z;
        synchronized (this) {
            z = this._state == 7;
        }
        return z;
    }

    public boolean isContinuation() {
        return this._continuation;
    }

    public boolean isDispatchable() {
        synchronized (this) {
            int i = this._state;
            return i == 3 || i == 5 || i == 6 || i == 7;
        }
    }

    @Override // org.eclipse.jetty.continuation.Continuation
    public boolean isExpired() {
        boolean z;
        synchronized (this) {
            z = this._expired;
        }
        return z;
    }

    @Override // org.eclipse.jetty.continuation.Continuation
    public boolean isInitial() {
        boolean z;
        synchronized (this) {
            z = this._initial;
        }
        return z;
    }

    @Override // org.eclipse.jetty.continuation.Continuation
    public boolean isResponseWrapped() {
        return this._responseWrapped;
    }

    @Override // org.eclipse.jetty.continuation.Continuation
    public boolean isResumed() {
        boolean z;
        synchronized (this) {
            z = this._resumed;
        }
        return z;
    }

    @Override // org.eclipse.jetty.continuation.Continuation
    public boolean isSuspended() {
        synchronized (this) {
            int i = this._state;
            return i == 2 || i == 3 || i == 4 || i == 7;
        }
    }

    public boolean isSuspending() {
        synchronized (this) {
            int i = this._state;
            return i == 2 || i == 4;
        }
    }

    public boolean isUncompleted() {
        boolean z;
        synchronized (this) {
            z = this._state == 8;
        }
        return z;
    }

    public void recycle() {
        synchronized (this) {
            int i = this._state;
            if (i == 1 || i == 6) {
                throw new IllegalStateException(getStatusString());
            }
            this._state = 0;
            this._initial = true;
            this._resumed = false;
            this._expired = false;
            this._responseWrapped = false;
            cancelTimeout();
            this._timeoutMs = DEFAULT_TIMEOUT;
            this._continuationListeners = null;
        }
    }

    @Override // org.eclipse.jetty.continuation.Continuation
    public void removeAttribute(String str) {
        this._connection.getRequest().removeAttribute(str);
    }

    @Override // org.eclipse.jetty.continuation.Continuation
    public void resume() {
        dispatch();
    }

    public void scheduleDispatch() {
        EndPoint endPoint = this._connection.getEndPoint();
        if (!endPoint.isBlocking()) {
            ((AsyncEndPoint) endPoint).asyncDispatch();
        }
    }

    public void scheduleTimeout() {
        EndPoint endPoint = this._connection.getEndPoint();
        if (this._timeoutMs > 0) {
            if (!endPoint.isBlocking()) {
                ((AsyncEndPoint) endPoint).scheduleTimeout(this._event._timeout, this._timeoutMs);
                return;
            }
            synchronized (this) {
                this._expireAt = System.currentTimeMillis() + this._timeoutMs;
                long j = this._timeoutMs;
                while (this._expireAt > 0 && j > 0 && this._connection.getServer().isRunning()) {
                    try {
                        wait(j);
                    } catch (InterruptedException e) {
                        LOG.ignore(e);
                    }
                    j = this._expireAt - System.currentTimeMillis();
                }
                if (this._expireAt > 0 && j <= 0 && this._connection.getServer().isRunning()) {
                    expired();
                }
            }
        }
    }

    @Override // org.eclipse.jetty.continuation.Continuation
    public void setAttribute(String str, Object obj) {
        this._connection.getRequest().setAttribute(str, obj);
    }

    public void setConnection(AbstractHttpConnection abstractHttpConnection) {
        synchronized (this) {
            this._connection = abstractHttpConnection;
        }
    }

    @Override // javax.servlet.AsyncContext, org.eclipse.jetty.continuation.Continuation
    public void setTimeout(long j) {
        synchronized (this) {
            this._timeoutMs = j;
        }
    }

    @Override // javax.servlet.AsyncContext
    public void start(final Runnable runnable) {
        final AsyncEventState asyncEventState = this._event;
        if (asyncEventState != null) {
            this._connection.getServer().getThreadPool().dispatch(new Runnable() { // from class: org.eclipse.jetty.server.AsyncContinuation.1
                @Override // java.lang.Runnable
                public void run() {
                    ((ContextHandler.Context) asyncEventState.getServletContext()).getContextHandler().handle(runnable);
                }
            });
        }
    }

    public void startAsync() {
        this._responseWrapped = false;
        this._continuation = false;
        doSuspend(this._connection.getRequest().getServletContext(), this._connection.getRequest(), this._connection.getResponse());
    }

    public void startAsync(ServletContext servletContext, ServletRequest servletRequest, ServletResponse servletResponse) {
        synchronized (this) {
            this._responseWrapped = !(servletResponse instanceof Response);
            doSuspend(servletContext, servletRequest, servletResponse);
            if (servletRequest instanceof ae0) {
                this._event._pathInContext = URIUtil.addPaths(((ae0) servletRequest).getServletPath(), ((ae0) servletRequest).getPathInfo());
            }
        }
    }

    @Override // org.eclipse.jetty.continuation.Continuation
    public void suspend() {
        this._responseWrapped = false;
        this._continuation = true;
        doSuspend(this._connection.getRequest().getServletContext(), this._connection.getRequest(), this._connection.getResponse());
    }

    @Override // org.eclipse.jetty.continuation.Continuation
    public void suspend(ServletResponse servletResponse) {
        this._continuation = true;
        this._responseWrapped = true ^ (servletResponse instanceof Response);
        doSuspend(this._connection.getRequest().getServletContext(), this._connection.getRequest(), servletResponse);
    }

    public String toString() {
        String str;
        synchronized (this) {
            str = super.toString() + "@" + getStatusString();
        }
        return str;
    }

    @Override // org.eclipse.jetty.continuation.Continuation
    public void undispatch() {
        if (isSuspended()) {
            if (!LOG.isDebugEnabled()) {
                throw __exception;
            }
            throw new ContinuationThrowable();
        }
        throw new IllegalStateException("!suspended");
    }

    public boolean unhandle() {
        synchronized (this) {
            int i = this._state;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        this._initial = false;
                        this._state = 4;
                        scheduleTimeout();
                        if (this._state == 4) {
                            return true;
                        }
                        if (this._state == 7) {
                            this._state = 8;
                            return true;
                        }
                        this._initial = false;
                        this._state = 6;
                        return false;
                    } else if (i == 3) {
                        this._initial = false;
                        this._state = 6;
                        return false;
                    } else if (i != 6) {
                        if (i != 7) {
                            throw new IllegalStateException(getStatusString());
                        }
                        this._initial = false;
                        this._state = 8;
                        return true;
                    }
                }
                this._state = 8;
                return true;
            }
            throw new IllegalStateException(getStatusString());
        }
    }
}
