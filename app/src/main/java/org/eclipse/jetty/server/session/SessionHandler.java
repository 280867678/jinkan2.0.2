package org.eclipse.jetty.server.session;

import java.io.IOException;
import java.util.EnumSet;
import java.util.EventListener;
import javax.servlet.DispatcherType;
import javax.servlet.ServletException;
import javax.servlet.SessionTrackingMode;
import javax.servlet.http.Cookie;
import me.tvspark.ae0;
import me.tvspark.ce0;
import me.tvspark.ee0;
import org.eclipse.jetty.http.HttpCookie;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.SessionManager;
import org.eclipse.jetty.server.handler.ScopedHandler;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: classes5.dex */
public class SessionHandler extends ScopedHandler {
    public SessionManager _sessionManager;
    public static final Logger LOG = Log.getLogger("org.eclipse.jetty.server.session");
    public static final EnumSet<SessionTrackingMode> DEFAULT_TRACKING = EnumSet.of(SessionTrackingMode.COOKIE, SessionTrackingMode.URL);

    public SessionHandler() {
        this(new HashSessionManager());
    }

    public SessionHandler(SessionManager sessionManager) {
        setSessionManager(sessionManager);
    }

    public void addEventListener(EventListener eventListener) {
        SessionManager sessionManager = this._sessionManager;
        if (sessionManager != null) {
            sessionManager.addEventListener(eventListener);
        }
    }

    public void checkRequestedSessionId(Request request, ae0 ae0Var) {
        boolean z;
        int indexOf;
        char charAt;
        Cookie[] cookies;
        String requestedSessionId = ae0Var.getRequestedSessionId();
        SessionManager sessionManager = getSessionManager();
        if (requestedSessionId != null && sessionManager != null) {
            ee0 httpSession = sessionManager.getHttpSession(requestedSessionId);
            if (httpSession == null || !sessionManager.isValid(httpSession)) {
                return;
            }
            request.setSession(httpSession);
        } else if (!DispatcherType.REQUEST.equals(request.getDispatcherType())) {
        } else {
            ee0 ee0Var = null;
            boolean z2 = true;
            if (!this._sessionManager.isUsingCookies() || (cookies = ae0Var.getCookies()) == null || cookies.length <= 0) {
                z = false;
            } else {
                String name = sessionManager.getSessionCookieConfig().getName();
                int i = 0;
                z = false;
                while (true) {
                    if (i >= cookies.length) {
                        break;
                    }
                    if (name.equalsIgnoreCase(cookies[i].getName())) {
                        requestedSessionId = cookies[i].getValue();
                        LOG.debug("Got Session ID {} from cookie", requestedSessionId);
                        if (requestedSessionId != null) {
                            ee0Var = sessionManager.getHttpSession(requestedSessionId);
                            if (ee0Var != null && sessionManager.isValid(ee0Var)) {
                                z = true;
                                break;
                            }
                        } else {
                            LOG.warn("null session id from cookie", new Object[0]);
                        }
                        z = true;
                    }
                    i++;
                }
            }
            if (requestedSessionId == null || ee0Var == null) {
                String requestURI = ae0Var.getRequestURI();
                String sessionIdPathParameterNamePrefix = sessionManager.getSessionIdPathParameterNamePrefix();
                if (sessionIdPathParameterNamePrefix != null && (indexOf = requestURI.indexOf(sessionIdPathParameterNamePrefix)) >= 0) {
                    int length = sessionIdPathParameterNamePrefix.length() + indexOf;
                    int i2 = length;
                    while (i2 < requestURI.length() && (charAt = requestURI.charAt(i2)) != ';' && charAt != '#' && charAt != '?' && charAt != '/') {
                        i2++;
                    }
                    requestedSessionId = requestURI.substring(length, i2);
                    ee0Var = sessionManager.getHttpSession(requestedSessionId);
                    if (LOG.isDebugEnabled()) {
                        LOG.debug("Got Session ID {} from URL", requestedSessionId);
                    }
                    z = false;
                }
            }
            request.setRequestedSessionId(requestedSessionId);
            if (requestedSessionId == null || !z) {
                z2 = false;
            }
            request.setRequestedSessionIdFromCookie(z2);
            if (ee0Var == null || !sessionManager.isValid(ee0Var)) {
                return;
            }
            request.setSession(ee0Var);
        }
    }

    public void clearEventListeners() {
        SessionManager sessionManager = this._sessionManager;
        if (sessionManager != null) {
            sessionManager.clearEventListeners();
        }
    }

    @Override // org.eclipse.jetty.server.handler.ScopedHandler
    public void doHandle(String str, Request request, ae0 ae0Var, ce0 ce0Var) throws IOException, ServletException {
        if (never()) {
            nextHandle(str, request, ae0Var, ce0Var);
            return;
        }
        ScopedHandler scopedHandler = this._nextScope;
        if (scopedHandler != null && scopedHandler == this._handler) {
            scopedHandler.doHandle(str, request, ae0Var, ce0Var);
            return;
        }
        Handler handler = this._handler;
        if (handler == null) {
            return;
        }
        handler.handle(str, request, ae0Var, ce0Var);
    }

    @Override // org.eclipse.jetty.server.handler.ScopedHandler
    public void doScope(String str, Request request, ae0 ae0Var, ce0 ce0Var) throws IOException, ServletException {
        SessionManager sessionManager;
        ee0 ee0Var;
        ee0 ee0Var2;
        ee0 ee0Var3 = null;
        try {
            sessionManager = request.getSessionManager();
            try {
                ee0Var = request.getSession(false);
                try {
                    if (sessionManager != this._sessionManager) {
                        request.setSessionManager(this._sessionManager);
                        request.setSession(null);
                        checkRequestedSessionId(request, ae0Var);
                    }
                    if (this._sessionManager != null) {
                        ee0Var2 = request.getSession(false);
                        if (ee0Var2 == null) {
                            ee0Var2 = request.recoverNewSession(this._sessionManager);
                            if (ee0Var2 != null) {
                                request.setSession(ee0Var2);
                            }
                        } else if (ee0Var2 != ee0Var) {
                            try {
                                HttpCookie access = this._sessionManager.access(ee0Var2, ae0Var.isSecure());
                                if (access != null) {
                                    request.getResponse().addCookie(access);
                                }
                                ee0Var3 = ee0Var2;
                            } catch (Throwable th) {
                                th = th;
                                ee0Var3 = ee0Var2;
                                if (ee0Var3 != null) {
                                    this._sessionManager.complete(ee0Var3);
                                }
                                ee0 session = request.getSession(false);
                                if (session != null && ee0Var == null && session != ee0Var3) {
                                    this._sessionManager.complete(session);
                                }
                                if (sessionManager != null && sessionManager != this._sessionManager) {
                                    request.setSessionManager(sessionManager);
                                    request.setSession(ee0Var);
                                }
                                throw th;
                            }
                        }
                        ee0 ee0Var4 = ee0Var2;
                        ee0Var2 = null;
                        ee0Var3 = ee0Var4;
                    } else {
                        ee0Var2 = null;
                    }
                    if (LOG.isDebugEnabled()) {
                        LOG.debug("sessionManager=" + this._sessionManager, new Object[0]);
                        LOG.debug("session=" + ee0Var3, new Object[0]);
                    }
                    if (this._nextScope != null) {
                        this._nextScope.doScope(str, request, ae0Var, ce0Var);
                    } else if (this._outerScope != null) {
                        this._outerScope.doHandle(str, request, ae0Var, ce0Var);
                    } else {
                        doHandle(str, request, ae0Var, ce0Var);
                    }
                    if (ee0Var2 != null) {
                        this._sessionManager.complete(ee0Var2);
                    }
                    ee0 session2 = request.getSession(false);
                    if (session2 != null && ee0Var == null && session2 != ee0Var2) {
                        this._sessionManager.complete(session2);
                    }
                    if (sessionManager == null || sessionManager == this._sessionManager) {
                        return;
                    }
                    request.setSessionManager(sessionManager);
                    request.setSession(ee0Var);
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                ee0Var = null;
            }
        } catch (Throwable th4) {
            th = th4;
            sessionManager = null;
            ee0Var = null;
        }
    }

    @Override // org.eclipse.jetty.server.handler.ScopedHandler, org.eclipse.jetty.server.handler.HandlerWrapper, org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.util.component.AggregateLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        this._sessionManager.start();
        super.doStart();
    }

    @Override // org.eclipse.jetty.server.handler.HandlerWrapper, org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.util.component.AggregateLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStop() throws Exception {
        this._sessionManager.stop();
        super.doStop();
    }

    public SessionManager getSessionManager() {
        return this._sessionManager;
    }

    @Override // org.eclipse.jetty.server.handler.HandlerWrapper, org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.server.Handler
    public void setServer(Server server) {
        Server server2 = getServer();
        if (server2 != null && server2 != server) {
            server2.getContainer().update((Object) this, (Object) this._sessionManager, (Object) null, "sessionManager", true);
        }
        super.setServer(server);
        if (server == null || server == server2) {
            return;
        }
        server.getContainer().update((Object) this, (Object) null, (Object) this._sessionManager, "sessionManager", true);
    }

    public void setSessionManager(SessionManager sessionManager) {
        if (!isStarted()) {
            SessionManager sessionManager2 = this._sessionManager;
            if (getServer() != null) {
                getServer().getContainer().update((Object) this, (Object) sessionManager2, (Object) sessionManager, "sessionManager", true);
            }
            if (sessionManager != null) {
                sessionManager.setSessionHandler(this);
            }
            this._sessionManager = sessionManager;
            if (sessionManager2 == null) {
                return;
            }
            sessionManager2.setSessionHandler(null);
            return;
        }
        throw new IllegalStateException();
    }
}
