package org.eclipse.jetty.client;

import java.io.IOException;
import org.eclipse.jetty.p059io.Buffer;

/* loaded from: classes4.dex */
public class HttpEventListenerWrapper implements HttpEventListener {
    public boolean _delegatingRequests;
    public boolean _delegatingResponses;
    public boolean _delegationResult;
    public HttpEventListener _listener;
    public Buffer _reason;
    public int _status;
    public Buffer _version;

    public HttpEventListenerWrapper() {
        this._delegationResult = true;
        this._listener = null;
        this._delegatingRequests = false;
        this._delegatingResponses = false;
    }

    public HttpEventListenerWrapper(HttpEventListener httpEventListener, boolean z) {
        this._delegationResult = true;
        this._listener = httpEventListener;
        this._delegatingRequests = z;
        this._delegatingResponses = z;
    }

    public HttpEventListener getEventListener() {
        return this._listener;
    }

    public boolean isDelegatingRequests() {
        return this._delegatingRequests;
    }

    public boolean isDelegatingResponses() {
        return this._delegatingResponses;
    }

    @Override // org.eclipse.jetty.client.HttpEventListener
    public void onConnectionFailed(Throwable th) {
        if (this._delegatingRequests) {
            this._listener.onConnectionFailed(th);
        }
    }

    @Override // org.eclipse.jetty.client.HttpEventListener
    public void onException(Throwable th) {
        if (this._delegatingRequests || this._delegatingResponses) {
            this._listener.onException(th);
        }
    }

    @Override // org.eclipse.jetty.client.HttpEventListener
    public void onExpire() {
        if (this._delegatingRequests || this._delegatingResponses) {
            this._listener.onExpire();
        }
    }

    @Override // org.eclipse.jetty.client.HttpEventListener
    public void onRequestCommitted() throws IOException {
        if (this._delegatingRequests) {
            this._listener.onRequestCommitted();
        }
    }

    @Override // org.eclipse.jetty.client.HttpEventListener
    public void onRequestComplete() throws IOException {
        if (this._delegatingRequests) {
            this._listener.onRequestComplete();
        }
    }

    @Override // org.eclipse.jetty.client.HttpEventListener
    public void onResponseComplete() throws IOException {
        if (this._delegatingResponses) {
            if (!this._delegationResult) {
                this._listener.onResponseStatus(this._version, this._status, this._reason);
            }
            this._listener.onResponseComplete();
        }
    }

    @Override // org.eclipse.jetty.client.HttpEventListener
    public void onResponseContent(Buffer buffer) throws IOException {
        if (this._delegatingResponses) {
            this._listener.onResponseContent(buffer);
        }
    }

    @Override // org.eclipse.jetty.client.HttpEventListener
    public void onResponseHeader(Buffer buffer, Buffer buffer2) throws IOException {
        if (this._delegatingResponses) {
            this._listener.onResponseHeader(buffer, buffer2);
        }
    }

    @Override // org.eclipse.jetty.client.HttpEventListener
    public void onResponseHeaderComplete() throws IOException {
        if (this._delegatingResponses) {
            this._listener.onResponseHeaderComplete();
        }
    }

    @Override // org.eclipse.jetty.client.HttpEventListener
    public void onResponseStatus(Buffer buffer, int i, Buffer buffer2) throws IOException {
        if (this._delegatingResponses) {
            this._listener.onResponseStatus(buffer, i, buffer2);
            return;
        }
        this._version = buffer;
        this._status = i;
        this._reason = buffer2;
    }

    @Override // org.eclipse.jetty.client.HttpEventListener
    public void onRetry() {
        if (this._delegatingRequests) {
            this._listener.onRetry();
        }
    }

    public void setDelegatingRequests(boolean z) {
        this._delegatingRequests = z;
    }

    public void setDelegatingResponses(boolean z) {
        this._delegatingResponses = z;
    }

    public void setDelegationResult(boolean z) {
        this._delegationResult = z;
    }

    public void setEventListener(HttpEventListener httpEventListener) {
        this._listener = httpEventListener;
    }
}
