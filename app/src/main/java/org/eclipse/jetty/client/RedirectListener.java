package org.eclipse.jetty.client;

import java.io.IOException;
import org.eclipse.jetty.http.HttpHeaders;
import org.eclipse.jetty.p059io.Buffer;

/* loaded from: classes4.dex */
public class RedirectListener extends HttpEventListenerWrapper {
    public int _attempts;
    public HttpDestination _destination;
    public final HttpExchange _exchange;
    public String _location;
    public boolean _redirected;
    public boolean _requestComplete;
    public boolean _responseComplete;

    public RedirectListener(HttpDestination httpDestination, HttpExchange httpExchange) {
        super(httpExchange.getEventListener(), true);
        this._destination = httpDestination;
        this._exchange = httpExchange;
    }

    public boolean checkExchangeComplete() throws IOException {
        if (!this._redirected || !this._requestComplete || !this._responseComplete) {
            return true;
        }
        String str = this._location;
        if (str == null) {
            setDelegationResult(false);
            return true;
        }
        if (str.indexOf("://") > 0) {
            this._exchange.setURL(this._location);
        } else {
            this._exchange.setRequestURI(this._location);
        }
        boolean equals = "https".equals(String.valueOf(this._exchange.getScheme()));
        HttpDestination destination = this._destination.getHttpClient().getDestination(this._exchange.getAddress(), equals);
        HttpDestination httpDestination = this._destination;
        if (httpDestination == destination) {
            httpDestination.resend(this._exchange);
        } else {
            HttpEventListener httpEventListener = this;
            while (httpEventListener instanceof HttpEventListenerWrapper) {
                httpEventListener = ((HttpEventListenerWrapper) httpEventListener).getEventListener();
            }
            this._exchange.getEventListener().onRetry();
            this._exchange.reset();
            this._exchange.setEventListener(httpEventListener);
            Address address = this._exchange.getAddress();
            int port = address.getPort();
            StringBuilder sb = new StringBuilder(64);
            sb.append(address.getHost());
            if ((port != 80 || equals) && (port != 443 || !equals)) {
                sb.append(':');
                sb.append(port);
            }
            this._exchange.setRequestHeader("Host", sb.toString());
            destination.send(this._exchange);
        }
        return false;
    }

    @Override // org.eclipse.jetty.client.HttpEventListenerWrapper, org.eclipse.jetty.client.HttpEventListener
    public void onConnectionFailed(Throwable th) {
        setDelegatingRequests(true);
        setDelegatingResponses(true);
        super.onConnectionFailed(th);
    }

    @Override // org.eclipse.jetty.client.HttpEventListenerWrapper, org.eclipse.jetty.client.HttpEventListener
    public void onException(Throwable th) {
        setDelegatingRequests(true);
        setDelegatingResponses(true);
        super.onException(th);
    }

    @Override // org.eclipse.jetty.client.HttpEventListenerWrapper, org.eclipse.jetty.client.HttpEventListener
    public void onRequestComplete() throws IOException {
        this._requestComplete = true;
        if (checkExchangeComplete()) {
            super.onRequestComplete();
        }
    }

    @Override // org.eclipse.jetty.client.HttpEventListenerWrapper, org.eclipse.jetty.client.HttpEventListener
    public void onResponseComplete() throws IOException {
        this._responseComplete = true;
        if (checkExchangeComplete()) {
            super.onResponseComplete();
        }
    }

    @Override // org.eclipse.jetty.client.HttpEventListenerWrapper, org.eclipse.jetty.client.HttpEventListener
    public void onResponseHeader(Buffer buffer, Buffer buffer2) throws IOException {
        if (this._redirected && HttpHeaders.CACHE.getOrdinal(buffer) == 45) {
            this._location = buffer2.toString();
        }
        super.onResponseHeader(buffer, buffer2);
    }

    @Override // org.eclipse.jetty.client.HttpEventListenerWrapper, org.eclipse.jetty.client.HttpEventListener
    public void onResponseStatus(Buffer buffer, int i, Buffer buffer2) throws IOException {
        boolean z = (i == 301 || i == 302) && this._attempts < this._destination.getHttpClient().maxRedirects();
        this._redirected = z;
        if (z) {
            setDelegatingRequests(false);
            setDelegatingResponses(false);
        }
        super.onResponseStatus(buffer, i, buffer2);
    }

    @Override // org.eclipse.jetty.client.HttpEventListenerWrapper, org.eclipse.jetty.client.HttpEventListener
    public void onRetry() {
        this._redirected = false;
        this._attempts++;
        setDelegatingRequests(true);
        setDelegatingResponses(true);
        this._requestComplete = false;
        this._responseComplete = false;
        super.onRetry();
    }
}
