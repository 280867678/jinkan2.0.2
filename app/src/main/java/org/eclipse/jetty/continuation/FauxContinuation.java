package org.eclipse.jetty.continuation;

import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletResponseWrapper;
import org.eclipse.jetty.continuation.ContinuationFilter;
import org.eclipse.jetty.server.AsyncContinuation;

/* loaded from: classes4.dex */
public class FauxContinuation implements ContinuationFilter.FilteredContinuation {
    public static final int __COMPLETE = 7;
    public static final int __COMPLETING = 4;
    public static final int __HANDLING = 1;
    public static final int __RESUMING = 3;
    public static final int __SUSPENDED = 5;
    public static final int __SUSPENDING = 2;
    public static final int __UNSUSPENDING = 6;
    public static final ContinuationThrowable __exception = new ContinuationThrowable();
    public ArrayList<ContinuationListener> _listeners;
    public final ServletRequest _request;
    public ServletResponse _response;
    public int _state = 1;
    public boolean _initial = true;
    public boolean _resumed = false;
    public boolean _timeout = false;
    public boolean _responseWrapped = false;
    public long _timeoutMs = AsyncContinuation.DEFAULT_TIMEOUT;

    public FauxContinuation(ServletRequest servletRequest) {
        this._request = servletRequest;
    }

    private void fauxResume() {
        this._timeoutMs = 0L;
        notifyAll();
    }

    private void fauxSuspend() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = this._timeoutMs;
        long j2 = currentTimeMillis + j;
        while (this._timeoutMs > 0 && j > 0) {
            try {
                wait(j);
                j = j2 - System.currentTimeMillis();
            } catch (InterruptedException unused) {
            }
        }
        if (this._timeoutMs <= 0 || j > 0) {
            return;
        }
        expire();
    }

    @Override // org.eclipse.jetty.continuation.Continuation
    public void addContinuationListener(ContinuationListener continuationListener) {
        if (this._listeners == null) {
            this._listeners = new ArrayList<>();
        }
        this._listeners.add(continuationListener);
    }

    @Override // org.eclipse.jetty.continuation.Continuation
    public void complete() {
        synchronized (this) {
            switch (this._state) {
                case 1:
                    throw new IllegalStateException(getStatusString());
                case 2:
                    this._state = 4;
                    break;
                case 3:
                    break;
                case 4:
                    return;
                case 5:
                    this._state = 4;
                    fauxResume();
                    break;
                case 6:
                    return;
                default:
                    throw new IllegalStateException(getStatusString());
            }
        }
    }

    @Override // org.eclipse.jetty.continuation.ContinuationFilter.FilteredContinuation
    public boolean enter(ServletResponse servletResponse) {
        this._response = servletResponse;
        return true;
    }

    @Override // org.eclipse.jetty.continuation.ContinuationFilter.FilteredContinuation
    public boolean exit() {
        synchronized (this) {
            int i = this._state;
            if (i == 1) {
                this._state = 7;
                onComplete();
                return true;
            } else if (i != 2) {
                if (i == 3) {
                    this._initial = false;
                    this._state = 1;
                    return false;
                } else if (i != 4) {
                    throw new IllegalStateException(getStatusString());
                } else {
                    this._initial = false;
                    this._state = 7;
                    onComplete();
                    return true;
                }
            } else {
                this._initial = false;
                this._state = 5;
                fauxSuspend();
                if (this._state != 5 && this._state != 4) {
                    this._initial = false;
                    this._state = 1;
                    return false;
                }
                onComplete();
                return true;
            }
        }
    }

    public void expire() {
        synchronized (this) {
            this._timeout = true;
        }
        onTimeout();
        synchronized (this) {
            switch (this._state) {
                case 1:
                    return;
                case 2:
                    this._timeout = true;
                    this._state = 3;
                    fauxResume();
                    return;
                case 3:
                    return;
                case 4:
                    return;
                case 5:
                    this._timeout = true;
                    this._state = 6;
                    return;
                case 6:
                    this._timeout = true;
                    return;
                default:
                    throw new IllegalStateException(getStatusString());
            }
        }
    }

    @Override // org.eclipse.jetty.continuation.Continuation
    public Object getAttribute(String str) {
        return this._request.getAttribute(str);
    }

    @Override // org.eclipse.jetty.continuation.Continuation
    public ServletResponse getServletResponse() {
        return this._response;
    }

    public String getStatusString() {
        String str;
        String sb;
        synchronized (this) {
            StringBuilder sb2 = new StringBuilder();
            if (this._state == 1) {
                str = "HANDLING";
            } else if (this._state == 2) {
                str = "SUSPENDING";
            } else if (this._state == 5) {
                str = "SUSPENDED";
            } else if (this._state == 3) {
                str = "RESUMING";
            } else if (this._state == 6) {
                str = "UNSUSPENDING";
            } else if (this._state == 4) {
                str = "COMPLETING";
            } else {
                str = "???" + this._state;
            }
            sb2.append(str);
            sb2.append(this._initial ? ",initial" : "");
            sb2.append(this._resumed ? ",resumed" : "");
            sb2.append(this._timeout ? ",timeout" : "");
            sb = sb2.toString();
        }
        return sb;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void handling() {
        synchronized (this) {
            this._responseWrapped = false;
            switch (this._state) {
                case 1:
                    throw new IllegalStateException(getStatusString());
                case 2:
                case 3:
                    throw new IllegalStateException(getStatusString());
                case 4:
                    return;
                case 5:
                    fauxResume();
                    break;
                case 6:
                    break;
                default:
                    throw new IllegalStateException("" + this._state);
            }
            this._state = 1;
        }
    }

    @Override // org.eclipse.jetty.continuation.Continuation
    public boolean isExpired() {
        boolean z;
        synchronized (this) {
            z = this._timeout;
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
            if (i != 1) {
                return i == 2 || i == 3 || i == 4 || i == 5;
            }
            return false;
        }
    }

    public void onComplete() {
        ArrayList<ContinuationListener> arrayList = this._listeners;
        if (arrayList != null) {
            Iterator<ContinuationListener> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onComplete(this);
            }
        }
    }

    public void onTimeout() {
        ArrayList<ContinuationListener> arrayList = this._listeners;
        if (arrayList != null) {
            Iterator<ContinuationListener> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onTimeout(this);
            }
        }
    }

    @Override // org.eclipse.jetty.continuation.Continuation
    public void removeAttribute(String str) {
        this._request.removeAttribute(str);
    }

    @Override // org.eclipse.jetty.continuation.Continuation
    public void resume() {
        synchronized (this) {
            switch (this._state) {
                case 1:
                    this._resumed = true;
                    return;
                case 2:
                    this._resumed = true;
                    this._state = 3;
                    return;
                case 3:
                case 4:
                    return;
                case 5:
                    fauxResume();
                    this._resumed = true;
                    this._state = 6;
                    return;
                case 6:
                    this._resumed = true;
                    return;
                default:
                    throw new IllegalStateException(getStatusString());
            }
        }
    }

    @Override // org.eclipse.jetty.continuation.Continuation
    public void setAttribute(String str, Object obj) {
        this._request.setAttribute(str, obj);
    }

    @Override // org.eclipse.jetty.continuation.Continuation
    public void setTimeout(long j) {
        this._timeoutMs = j;
    }

    @Override // org.eclipse.jetty.continuation.Continuation
    public void suspend() {
        synchronized (this) {
            switch (this._state) {
                case 1:
                    this._timeout = false;
                    this._resumed = false;
                    this._state = 2;
                    return;
                case 2:
                case 3:
                    return;
                case 4:
                case 5:
                case 6:
                    throw new IllegalStateException(getStatusString());
                default:
                    throw new IllegalStateException("" + this._state);
            }
        }
    }

    @Override // org.eclipse.jetty.continuation.Continuation
    public void suspend(ServletResponse servletResponse) {
        this._response = servletResponse;
        this._responseWrapped = servletResponse instanceof ServletResponseWrapper;
        suspend();
    }

    public String toString() {
        return getStatusString();
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
