package org.eclipse.jetty.client.webdav;

import java.io.IOException;
import me.tvspark.outline;
import org.eclipse.jetty.client.HttpDestination;
import org.eclipse.jetty.client.HttpEventListenerWrapper;
import org.eclipse.jetty.client.HttpExchange;
import org.eclipse.jetty.client.security.SecurityListener;
import org.eclipse.jetty.p059io.Buffer;
import org.eclipse.jetty.util.URIUtil;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: classes4.dex */
public class WebdavListener extends HttpEventListenerWrapper {
    public static final Logger LOG = Log.getLogger(WebdavListener.class);
    public HttpDestination _destination;
    public HttpExchange _exchange;
    public boolean _needIntercept;
    public boolean _requestComplete;
    public boolean _responseComplete;
    public boolean _webdavEnabled;

    public WebdavListener(HttpDestination httpDestination, HttpExchange httpExchange) {
        super(httpExchange.getEventListener(), true);
        this._destination = httpDestination;
        this._exchange = httpExchange;
        if ("PUT".equalsIgnoreCase(httpExchange.getMethod())) {
            this._webdavEnabled = true;
        }
    }

    private boolean checkExists(String str) throws IOException {
        if (str == null) {
            System.out.println("have failed miserably");
            return false;
        }
        PropfindExchange propfindExchange = new PropfindExchange();
        propfindExchange.setAddress(this._exchange.getAddress());
        propfindExchange.setMethod("GET");
        propfindExchange.setScheme(this._exchange.getScheme());
        propfindExchange.setEventListener(new SecurityListener(this._destination, propfindExchange));
        propfindExchange.setConfigureListeners(false);
        propfindExchange.setRequestURI(str);
        this._destination.send(propfindExchange);
        try {
            propfindExchange.waitForDone();
            return propfindExchange.exists();
        } catch (InterruptedException e) {
            LOG.ignore(e);
            return false;
        }
    }

    private boolean checkWebdavSupported() throws IOException {
        WebdavSupportedExchange webdavSupportedExchange = new WebdavSupportedExchange();
        webdavSupportedExchange.setAddress(this._exchange.getAddress());
        webdavSupportedExchange.setMethod("OPTIONS");
        webdavSupportedExchange.setScheme(this._exchange.getScheme());
        webdavSupportedExchange.setEventListener(new SecurityListener(this._destination, webdavSupportedExchange));
        webdavSupportedExchange.setConfigureListeners(false);
        webdavSupportedExchange.setRequestURI(this._exchange.getURI());
        this._destination.send(webdavSupportedExchange);
        try {
            webdavSupportedExchange.waitTilCompletion();
            return webdavSupportedExchange.isWebdavSupported();
        } catch (InterruptedException e) {
            LOG.ignore(e);
            return false;
        }
    }

    private boolean makeCollection(String str) throws IOException {
        MkcolExchange mkcolExchange = new MkcolExchange();
        mkcolExchange.setAddress(this._exchange.getAddress());
        mkcolExchange.setMethod("MKCOL " + str + " HTTP/1.1");
        mkcolExchange.setScheme(this._exchange.getScheme());
        mkcolExchange.setEventListener(new SecurityListener(this._destination, mkcolExchange));
        mkcolExchange.setConfigureListeners(false);
        mkcolExchange.setRequestURI(str);
        this._destination.send(mkcolExchange);
        try {
            mkcolExchange.waitForDone();
            return mkcolExchange.exists();
        } catch (InterruptedException e) {
            LOG.ignore(e);
            return false;
        }
    }

    private boolean resolveCollectionIssues() throws IOException {
        String uri = this._exchange.getURI();
        String[] split = this._exchange.getURI().split("/");
        int length = split.length;
        String parentPath = URIUtil.parentPath(uri);
        boolean z = false;
        int i = 0;
        while (parentPath != null && !checkExists(parentPath)) {
            i++;
            parentPath = URIUtil.parentPath(parentPath);
        }
        if (checkWebdavSupported()) {
            while (true) {
                z = true;
                if (i <= 0) {
                    break;
                }
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(parentPath, "/");
                int i2 = (length - i) - 1;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(split[i2]);
                makeCollection(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(parentPath, "/");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(split[i2]);
                parentPath = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
                i--;
            }
        }
        return z;
    }

    @Override // org.eclipse.jetty.client.HttpEventListenerWrapper, org.eclipse.jetty.client.HttpEventListener
    public void onRequestComplete() throws IOException {
        this._requestComplete = true;
        if (this._needIntercept) {
            if (1 != 0 && this._responseComplete) {
                try {
                    if (resolveCollectionIssues()) {
                        setDelegatingRequests(true);
                        setDelegatingResponses(true);
                        this._requestComplete = false;
                        this._responseComplete = false;
                        this._destination.resend(this._exchange);
                    } else {
                        setDelegatingRequests(true);
                        setDelegatingResponses(true);
                        super.onRequestComplete();
                    }
                    return;
                } catch (IOException unused) {
                    LOG.debug("WebdavListener:Complete:IOException: might not be dealing with dav server, delegate", new Object[0]);
                }
            } else if (LOG.isDebugEnabled()) {
                LOG.debug("WebdavListener:Not ready, calling super", new Object[0]);
            }
        }
        super.onRequestComplete();
    }

    @Override // org.eclipse.jetty.client.HttpEventListenerWrapper, org.eclipse.jetty.client.HttpEventListener
    public void onResponseComplete() throws IOException {
        this._responseComplete = true;
        if (this._needIntercept) {
            if (this._requestComplete && 1 != 0) {
                try {
                    if (resolveCollectionIssues()) {
                        setDelegatingRequests(true);
                        setDelegatingResponses(true);
                        this._requestComplete = false;
                        this._responseComplete = false;
                        this._destination.resend(this._exchange);
                    } else {
                        setDelegationResult(false);
                        setDelegatingRequests(true);
                        setDelegatingResponses(true);
                        super.onResponseComplete();
                    }
                    return;
                } catch (IOException unused) {
                    LOG.debug("WebdavListener:Complete:IOException: might not be dealing with dav server, delegate", new Object[0]);
                }
            } else if (LOG.isDebugEnabled()) {
                LOG.debug("WebdavListener:Not ready, calling super", new Object[0]);
            }
        }
        super.onResponseComplete();
    }

    @Override // org.eclipse.jetty.client.HttpEventListenerWrapper, org.eclipse.jetty.client.HttpEventListener
    public void onResponseStatus(Buffer buffer, int i, Buffer buffer2) throws IOException {
        if (!this._webdavEnabled) {
            this._needIntercept = false;
            super.onResponseStatus(buffer, i, buffer2);
            return;
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("WebdavListener:Response Status: ", i), new Object[0]);
        }
        if (i != 403 && i != 409) {
            this._needIntercept = false;
            setDelegatingResponses(true);
            setDelegatingRequests(true);
        } else if (this._webdavEnabled) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("WebdavListener:Response Status: dav enabled, taking a stab at resolving put issue", new Object[0]);
            }
            setDelegatingResponses(false);
            this._needIntercept = true;
        } else {
            if (LOG.isDebugEnabled()) {
                LOG.debug("WebdavListener:Response Status: Webdav Disabled", new Object[0]);
            }
            setDelegatingResponses(true);
            setDelegatingRequests(true);
            this._needIntercept = false;
        }
        super.onResponseStatus(buffer, i, buffer2);
    }
}
