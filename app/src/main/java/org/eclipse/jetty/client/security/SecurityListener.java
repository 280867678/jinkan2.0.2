package org.eclipse.jetty.client.security;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import me.tvspark.outline;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.jetty.client.HttpDestination;
import org.eclipse.jetty.client.HttpEventListenerWrapper;
import org.eclipse.jetty.client.HttpExchange;
import org.eclipse.jetty.http.HttpHeaders;
import org.eclipse.jetty.p059io.Buffer;
import org.eclipse.jetty.util.StringUtil;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: classes4.dex */
public class SecurityListener extends HttpEventListenerWrapper {
    public static final Logger LOG = Log.getLogger(SecurityListener.class);
    public int _attempts = 0;
    public HttpDestination _destination;
    public HttpExchange _exchange;
    public boolean _needIntercept;
    public boolean _requestComplete;
    public boolean _responseComplete;

    public SecurityListener(HttpDestination httpDestination, HttpExchange httpExchange) {
        super(httpExchange.getEventListener(), true);
        this._destination = httpDestination;
        this._exchange = httpExchange;
    }

    @Override // org.eclipse.jetty.client.HttpEventListenerWrapper, org.eclipse.jetty.client.HttpEventListener
    public void onRequestComplete() throws IOException {
        this._requestComplete = true;
        if (this._needIntercept) {
            if (1 != 0 && this._responseComplete) {
                if (LOG.isDebugEnabled()) {
                    Logger logger = LOG;
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("onRequestComplete, Both complete: Resending from onResponseComplete ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._exchange);
                    logger.debug(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), new Object[0]);
                }
                this._responseComplete = false;
                this._requestComplete = false;
                setDelegatingRequests(true);
                setDelegatingResponses(true);
                this._destination.resend(this._exchange);
                return;
            } else if (LOG.isDebugEnabled()) {
                Logger logger2 = LOG;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("onRequestComplete, Response not yet complete onRequestComplete, calling super for ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this._exchange);
                logger2.debug(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString(), new Object[0]);
            }
        } else if (LOG.isDebugEnabled()) {
            Logger logger3 = LOG;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("onRequestComplete, delegating to super with Request complete=");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(this._requestComplete);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(", response complete=");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(this._responseComplete);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(StringUtils.SPACE);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(this._exchange);
            logger3.debug(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString(), new Object[0]);
        }
        super.onRequestComplete();
    }

    @Override // org.eclipse.jetty.client.HttpEventListenerWrapper, org.eclipse.jetty.client.HttpEventListener
    public void onResponseComplete() throws IOException {
        this._responseComplete = true;
        if (this._needIntercept) {
            if (this._requestComplete && 1 != 0) {
                if (LOG.isDebugEnabled()) {
                    Logger logger = LOG;
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("onResponseComplete, Both complete: Resending from onResponseComplete");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._exchange);
                    logger.debug(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), new Object[0]);
                }
                this._responseComplete = false;
                this._requestComplete = false;
                setDelegatingResponses(true);
                setDelegatingRequests(true);
                this._destination.resend(this._exchange);
                return;
            } else if (LOG.isDebugEnabled()) {
                Logger logger2 = LOG;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("onResponseComplete, Request not yet complete from onResponseComplete,  calling super ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this._exchange);
                logger2.debug(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString(), new Object[0]);
            }
        } else if (LOG.isDebugEnabled()) {
            Logger logger3 = LOG;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("OnResponseComplete, delegating to super with Request complete=");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(this._requestComplete);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(", response complete=");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(this._responseComplete);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(StringUtils.SPACE);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(this._exchange);
            logger3.debug(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString(), new Object[0]);
        }
        super.onResponseComplete();
    }

    @Override // org.eclipse.jetty.client.HttpEventListenerWrapper, org.eclipse.jetty.client.HttpEventListener
    public void onResponseHeader(Buffer buffer, Buffer buffer2) throws IOException {
        if (LOG.isDebugEnabled()) {
            Logger logger = LOG;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("SecurityListener:Header: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(buffer.toString());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" / ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(buffer2.toString());
            logger.debug(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), new Object[0]);
        }
        if (!isDelegatingResponses() && HttpHeaders.CACHE.getOrdinal(buffer) == 51) {
            String obj = buffer2.toString();
            String scrapeAuthenticationType = scrapeAuthenticationType(obj);
            Map<String, String> scrapeAuthenticationDetails = scrapeAuthenticationDetails(obj);
            RealmResolver realmResolver = this._destination.getHttpClient().getRealmResolver();
            if (realmResolver != null) {
                Realm realm = realmResolver.getRealm(scrapeAuthenticationDetails.get("realm"), this._destination, "/");
                if (realm == null) {
                    Logger logger2 = LOG;
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unknown Security Realm: ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(scrapeAuthenticationDetails.get("realm"));
                    logger2.warn(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString(), new Object[0]);
                } else if ("digest".equalsIgnoreCase(scrapeAuthenticationType)) {
                    this._destination.addAuthorization("/", new DigestAuthentication(realm, scrapeAuthenticationDetails));
                } else if ("basic".equalsIgnoreCase(scrapeAuthenticationType)) {
                    this._destination.addAuthorization("/", new BasicAuthentication(realm));
                }
            }
        }
        super.onResponseHeader(buffer, buffer2);
    }

    @Override // org.eclipse.jetty.client.HttpEventListenerWrapper, org.eclipse.jetty.client.HttpEventListener
    public void onResponseStatus(Buffer buffer, int i, Buffer buffer2) throws IOException {
        if (LOG.isDebugEnabled()) {
            LOG.debug(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("SecurityListener:Response Status: ", i), new Object[0]);
        }
        if (i != 401 || this._attempts >= this._destination.getHttpClient().maxRetries()) {
            setDelegatingResponses(true);
            setDelegatingRequests(true);
            this._needIntercept = false;
        } else {
            setDelegatingResponses(false);
            this._needIntercept = true;
        }
        super.onResponseStatus(buffer, i, buffer2);
    }

    @Override // org.eclipse.jetty.client.HttpEventListenerWrapper, org.eclipse.jetty.client.HttpEventListener
    public void onRetry() {
        this._attempts++;
        setDelegatingRequests(true);
        setDelegatingResponses(true);
        this._requestComplete = false;
        this._responseComplete = false;
        this._needIntercept = false;
        super.onRetry();
    }

    public Map<String, String> scrapeAuthenticationDetails(String str) {
        HashMap hashMap = new HashMap();
        StringTokenizer stringTokenizer = new StringTokenizer(str.substring(str.indexOf(StringUtils.SPACE) + 1, str.length()), ",");
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            String[] split = nextToken.split("=");
            if (split.length == 2) {
                hashMap.put(split[0].trim(), StringUtil.unquote(split[1].trim()));
            } else {
                LOG.debug(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("SecurityListener: missed scraping authentication details - ", nextToken), new Object[0]);
            }
        }
        return hashMap;
    }

    public String scrapeAuthenticationType(String str) {
        if (str.indexOf(StringUtils.SPACE) != -1) {
            str = str.substring(0, str.indexOf(StringUtils.SPACE));
        }
        return str.trim();
    }
}
