package org.eclipse.jetty.server.session;

import com.efs.sdk.base.Constants;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.EventListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.servlet.SessionCookieConfig;
import javax.servlet.SessionTrackingMode;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import me.tvspark.ae0;
import me.tvspark.ee0;
import me.tvspark.ge0;
import me.tvspark.ie0;
import me.tvspark.je0;
import me.tvspark.outline;
import org.eclipse.jetty.http.HttpCookie;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.SessionIdManager;
import org.eclipse.jetty.server.SessionManager;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.util.component.AbstractLifeCycle;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.statistic.CounterStatistic;
import org.eclipse.jetty.util.statistic.SampleStatistic;

/* loaded from: classes4.dex */
public abstract class AbstractSessionManager extends AbstractLifeCycle implements SessionManager {
    public static final String SESSION_KNOWN_ONLY_TO_AUTHENTICATED = "org.eclipse.jetty.security.sessionKnownOnlytoAuthenticated";
    public static final int __distantFuture = 628992000;
    public static final Logger __log = SessionHandler.LOG;
    public static final ie0 __nullSessionContext = new ie0() { // from class: org.eclipse.jetty.server.session.AbstractSessionManager.1
        public Enumeration getIds() {
            return Collections.enumeration(Collections.EMPTY_LIST);
        }

        public ee0 getSession(String str) {
            return null;
        }
    };
    public boolean _checkingRemoteSessionIdEncoding;
    public ContextHandler.Context _context;
    public ClassLoader _loader;
    public boolean _nodeIdInSessionId;
    public int _refreshCookieAge;
    public String _sessionComment;
    public String _sessionDomain;
    public SessionHandler _sessionHandler;
    public SessionIdManager _sessionIdManager;
    public String _sessionPath;
    public Set<SessionTrackingMode> _sessionTrackingModes;
    public boolean _usingURLs;
    public Set<SessionTrackingMode> __defaultSessionTrackingModes = Collections.unmodifiableSet(new HashSet(Arrays.asList(SessionTrackingMode.COOKIE, SessionTrackingMode.URL)));
    public boolean _usingCookies = true;
    public int _dftMaxIdleSecs = -1;
    public boolean _httpOnly = false;
    public boolean _secureCookies = false;
    public boolean _secureRequestOnly = true;
    public final List<ge0> _sessionAttributeListeners = new CopyOnWriteArrayList();
    public final List<je0> _sessionListeners = new CopyOnWriteArrayList();
    public String _sessionCookie = SessionManager.__DefaultSessionCookie;
    public String _sessionIdPathParameterName = SessionManager.__DefaultSessionIdPathParameterName;
    public String _sessionIdPathParameterNamePrefix = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(";"), this._sessionIdPathParameterName, "=");
    public int _maxCookieAge = -1;
    public final CounterStatistic _sessionsStats = new CounterStatistic();
    public final SampleStatistic _sessionTimeStats = new SampleStatistic();
    public SessionCookieConfig _cookieConfig = new SessionCookieConfig() { // from class: org.eclipse.jetty.server.session.AbstractSessionManager.2
        @Override // javax.servlet.SessionCookieConfig
        public String getComment() {
            return AbstractSessionManager.this._sessionComment;
        }

        @Override // javax.servlet.SessionCookieConfig
        public String getDomain() {
            return AbstractSessionManager.this._sessionDomain;
        }

        @Override // javax.servlet.SessionCookieConfig
        public int getMaxAge() {
            return AbstractSessionManager.this._maxCookieAge;
        }

        @Override // javax.servlet.SessionCookieConfig
        public String getName() {
            return AbstractSessionManager.this._sessionCookie;
        }

        @Override // javax.servlet.SessionCookieConfig
        public String getPath() {
            return AbstractSessionManager.this._sessionPath;
        }

        @Override // javax.servlet.SessionCookieConfig
        public boolean isHttpOnly() {
            return AbstractSessionManager.this._httpOnly;
        }

        @Override // javax.servlet.SessionCookieConfig
        public boolean isSecure() {
            return AbstractSessionManager.this._secureCookies;
        }

        @Override // javax.servlet.SessionCookieConfig
        public void setComment(String str) {
            AbstractSessionManager.this._sessionComment = str;
        }

        @Override // javax.servlet.SessionCookieConfig
        public void setDomain(String str) {
            AbstractSessionManager.this._sessionDomain = str;
        }

        @Override // javax.servlet.SessionCookieConfig
        public void setHttpOnly(boolean z) {
            AbstractSessionManager.this._httpOnly = z;
        }

        @Override // javax.servlet.SessionCookieConfig
        public void setMaxAge(int i) {
            AbstractSessionManager.this._maxCookieAge = i;
        }

        @Override // javax.servlet.SessionCookieConfig
        public void setName(String str) {
            AbstractSessionManager.this._sessionCookie = str;
        }

        @Override // javax.servlet.SessionCookieConfig
        public void setPath(String str) {
            AbstractSessionManager.this._sessionPath = str;
        }

        @Override // javax.servlet.SessionCookieConfig
        public void setSecure(boolean z) {
            AbstractSessionManager.this._secureCookies = z;
        }
    };

    /* loaded from: classes4.dex */
    public interface SessionIf extends ee0 {
        AbstractSession getSession();
    }

    public AbstractSessionManager() {
        setSessionTrackingModes(this.__defaultSessionTrackingModes);
    }

    public static ee0 renewSession(ae0 ae0Var, ee0 ee0Var, boolean z) {
        HashMap hashMap = new HashMap();
        Enumeration<String> attributeNames = ee0Var.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String nextElement = attributeNames.nextElement();
            hashMap.put(nextElement, ee0Var.getAttribute(nextElement));
            ee0Var.removeAttribute(nextElement);
        }
        ee0Var.invalidate();
        ee0 session = ae0Var.getSession(true);
        if (z) {
            session.setAttribute(SESSION_KNOWN_ONLY_TO_AUTHENTICATED, Boolean.TRUE);
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            session.setAttribute((String) entry.getKey(), entry.getValue());
        }
        return session;
    }

    @Override // org.eclipse.jetty.server.SessionManager
    public HttpCookie access(ee0 ee0Var, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        AbstractSession session = ((SessionIf) ee0Var).getSession();
        if (!session.access(currentTimeMillis) || !isUsingCookies()) {
            return null;
        }
        if (!session.isIdChanged() && (getSessionCookieConfig().getMaxAge() <= 0 || getRefreshCookieAge() <= 0 || (currentTimeMillis - session.getCookieSetTime()) / 1000 <= getRefreshCookieAge())) {
            return null;
        }
        ContextHandler.Context context = this._context;
        HttpCookie sessionCookie = getSessionCookie(ee0Var, context == null ? "/" : context.getContextPath(), z);
        session.cookieSet();
        session.setIdChanged(false);
        return sessionCookie;
    }

    @Override // org.eclipse.jetty.server.SessionManager
    public void addEventListener(EventListener eventListener) {
        if (eventListener instanceof ge0) {
            this._sessionAttributeListeners.add((ge0) eventListener);
        }
        if (eventListener instanceof je0) {
            this._sessionListeners.add((je0) eventListener);
        }
    }

    public abstract void addSession(AbstractSession abstractSession);

    public void addSession(AbstractSession abstractSession, boolean z) {
        synchronized (this._sessionIdManager) {
            this._sessionIdManager.addSession(abstractSession);
            addSession(abstractSession);
        }
        if (z) {
            this._sessionsStats.increment();
            if (this._sessionListeners == null) {
                return;
            }
            HttpSessionEvent httpSessionEvent = new HttpSessionEvent(abstractSession);
            for (je0 je0Var : this._sessionListeners) {
                je0Var.sessionCreated(httpSessionEvent);
            }
        }
    }

    @Override // org.eclipse.jetty.server.SessionManager
    public void clearEventListeners() {
        this._sessionAttributeListeners.clear();
        this._sessionListeners.clear();
    }

    @Override // org.eclipse.jetty.server.SessionManager
    public void complete(ee0 ee0Var) {
        ((SessionIf) ee0Var).getSession().complete();
    }

    public void doSessionAttributeListeners(AbstractSession abstractSession, String str, Object obj, Object obj2) {
        if (!this._sessionAttributeListeners.isEmpty()) {
            HttpSessionBindingEvent httpSessionBindingEvent = new HttpSessionBindingEvent(abstractSession, str, obj == null ? obj2 : obj);
            for (ge0 ge0Var : this._sessionAttributeListeners) {
                if (obj == null) {
                    ge0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(httpSessionBindingEvent);
                } else if (obj2 == null) {
                    ge0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(httpSessionBindingEvent);
                } else {
                    ge0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(httpSessionBindingEvent);
                }
            }
        }
    }

    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        String initParameter;
        this._context = ContextHandler.getCurrentContext();
        this._loader = Thread.currentThread().getContextClassLoader();
        if (this._sessionIdManager == null) {
            Server server = getSessionHandler().getServer();
            synchronized (server) {
                SessionIdManager sessionIdManager = server.getSessionIdManager();
                this._sessionIdManager = sessionIdManager;
                if (sessionIdManager == null) {
                    HashSessionIdManager hashSessionIdManager = new HashSessionIdManager();
                    this._sessionIdManager = hashSessionIdManager;
                    server.setSessionIdManager(hashSessionIdManager);
                }
            }
        }
        if (!this._sessionIdManager.isStarted()) {
            this._sessionIdManager.start();
        }
        ContextHandler.Context context = this._context;
        if (context != null) {
            String initParameter2 = context.getInitParameter(SessionManager.__SessionCookieProperty);
            if (initParameter2 != null) {
                this._sessionCookie = initParameter2;
            }
            String initParameter3 = this._context.getInitParameter(SessionManager.__SessionIdPathParameterNameProperty);
            if (initParameter3 != null) {
                setSessionIdPathParameterName(initParameter3);
            }
            if (this._maxCookieAge == -1 && (initParameter = this._context.getInitParameter(SessionManager.__MaxAgeProperty)) != null) {
                this._maxCookieAge = Integer.parseInt(initParameter.trim());
            }
            if (this._sessionDomain == null) {
                this._sessionDomain = this._context.getInitParameter(SessionManager.__SessionDomainProperty);
            }
            if (this._sessionPath == null) {
                this._sessionPath = this._context.getInitParameter(SessionManager.__SessionPathProperty);
            }
            String initParameter4 = this._context.getInitParameter(SessionManager.__CheckRemoteSessionEncoding);
            if (initParameter4 != null) {
                this._checkingRemoteSessionIdEncoding = Boolean.parseBoolean(initParameter4);
            }
        }
        super.doStart();
    }

    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStop() throws Exception {
        super.doStop();
        invalidateSessions();
        this._loader = null;
    }

    @Override // org.eclipse.jetty.server.SessionManager
    public String getClusterId(ee0 ee0Var) {
        return ((SessionIf) ee0Var).getSession().getClusterId();
    }

    public ContextHandler.Context getContext() {
        return this._context;
    }

    public ContextHandler getContextHandler() {
        return this._context.getContextHandler();
    }

    @Override // org.eclipse.jetty.server.SessionManager
    public Set<SessionTrackingMode> getDefaultSessionTrackingModes() {
        return this.__defaultSessionTrackingModes;
    }

    @Override // org.eclipse.jetty.server.SessionManager
    public Set<SessionTrackingMode> getEffectiveSessionTrackingModes() {
        return Collections.unmodifiableSet(this._sessionTrackingModes);
    }

    @Override // org.eclipse.jetty.server.SessionManager
    public boolean getHttpOnly() {
        return this._httpOnly;
    }

    @Override // org.eclipse.jetty.server.SessionManager
    public ee0 getHttpSession(String str) {
        AbstractSession mo5191getSession = mo5191getSession(getSessionIdManager().getClusterId(str));
        if (mo5191getSession != null && !mo5191getSession.getNodeId().equals(str)) {
            mo5191getSession.setIdChanged(true);
        }
        return mo5191getSession;
    }

    public SessionIdManager getIdManager() {
        return getSessionIdManager();
    }

    public int getMaxCookieAge() {
        return this._maxCookieAge;
    }

    @Override // org.eclipse.jetty.server.SessionManager
    public int getMaxInactiveInterval() {
        return this._dftMaxIdleSecs;
    }

    @Deprecated
    public int getMaxSessions() {
        return getSessionsMax();
    }

    @Override // org.eclipse.jetty.server.SessionManager
    @Deprecated
    public SessionIdManager getMetaManager() {
        return getSessionIdManager();
    }

    @Deprecated
    public int getMinSessions() {
        return 0;
    }

    @Override // org.eclipse.jetty.server.SessionManager
    public String getNodeId(ee0 ee0Var) {
        return ((SessionIf) ee0Var).getSession().getNodeId();
    }

    public int getRefreshCookieAge() {
        return this._refreshCookieAge;
    }

    public boolean getSecureCookies() {
        return this._secureCookies;
    }

    /* renamed from: getSession */
    public abstract AbstractSession mo5191getSession(String str);

    public String getSessionCookie() {
        return this._sessionCookie;
    }

    @Override // org.eclipse.jetty.server.SessionManager
    public HttpCookie getSessionCookie(ee0 ee0Var, String str, boolean z) {
        HttpCookie httpCookie;
        if (isUsingCookies()) {
            String str2 = this._sessionPath;
            if (str2 != null) {
                str = str2;
            }
            if (str == null || str.length() == 0) {
                str = "/";
            }
            String str3 = str;
            String nodeId = getNodeId(ee0Var);
            if (this._sessionComment == null) {
                httpCookie = new HttpCookie(this._sessionCookie, nodeId, this._sessionDomain, str3, this._cookieConfig.getMaxAge(), this._cookieConfig.isHttpOnly(), this._cookieConfig.isSecure() || (isSecureRequestOnly() && z));
            } else {
                httpCookie = new HttpCookie(this._sessionCookie, nodeId, this._sessionDomain, str3, this._cookieConfig.getMaxAge(), this._cookieConfig.isHttpOnly(), this._cookieConfig.isSecure() || (isSecureRequestOnly() && z), this._sessionComment, 1);
            }
            return httpCookie;
        }
        return null;
    }

    @Override // org.eclipse.jetty.server.SessionManager
    public SessionCookieConfig getSessionCookieConfig() {
        return this._cookieConfig;
    }

    public String getSessionDomain() {
        return this._sessionDomain;
    }

    public SessionHandler getSessionHandler() {
        return this._sessionHandler;
    }

    @Override // org.eclipse.jetty.server.SessionManager
    public SessionIdManager getSessionIdManager() {
        return this._sessionIdManager;
    }

    @Override // org.eclipse.jetty.server.SessionManager
    public String getSessionIdPathParameterName() {
        return this._sessionIdPathParameterName;
    }

    @Override // org.eclipse.jetty.server.SessionManager
    public String getSessionIdPathParameterNamePrefix() {
        return this._sessionIdPathParameterNamePrefix;
    }

    public Map getSessionMap() {
        throw new UnsupportedOperationException();
    }

    public String getSessionPath() {
        return this._sessionPath;
    }

    public long getSessionTimeMax() {
        return this._sessionTimeStats.getMax();
    }

    public double getSessionTimeMean() {
        return this._sessionTimeStats.getMean();
    }

    public double getSessionTimeStdDev() {
        return this._sessionTimeStats.getStdDev();
    }

    public long getSessionTimeTotal() {
        return this._sessionTimeStats.getTotal();
    }

    public int getSessions() {
        return (int) this._sessionsStats.getCurrent();
    }

    public int getSessionsMax() {
        return (int) this._sessionsStats.getMax();
    }

    public int getSessionsTotal() {
        return (int) this._sessionsStats.getTotal();
    }

    public abstract void invalidateSessions() throws Exception;

    @Override // org.eclipse.jetty.server.SessionManager
    public boolean isCheckingRemoteSessionIdEncoding() {
        return this._checkingRemoteSessionIdEncoding;
    }

    public boolean isNodeIdInSessionId() {
        return this._nodeIdInSessionId;
    }

    public boolean isSecureRequestOnly() {
        return this._secureRequestOnly;
    }

    @Override // org.eclipse.jetty.server.SessionManager
    public boolean isUsingCookies() {
        return this._usingCookies;
    }

    @Override // org.eclipse.jetty.server.SessionManager
    public boolean isUsingURLs() {
        return this._usingURLs;
    }

    @Override // org.eclipse.jetty.server.SessionManager
    public boolean isValid(ee0 ee0Var) {
        return ((SessionIf) ee0Var).getSession().isValid();
    }

    @Override // org.eclipse.jetty.server.SessionManager
    public ee0 newHttpSession(ae0 ae0Var) {
        AbstractSession newSession = newSession(ae0Var);
        newSession.setMaxInactiveInterval(this._dftMaxIdleSecs);
        addSession(newSession, true);
        return newSession;
    }

    public abstract AbstractSession newSession(ae0 ae0Var);

    @Override // org.eclipse.jetty.server.SessionManager
    public void removeEventListener(EventListener eventListener) {
        if (eventListener instanceof ge0) {
            this._sessionAttributeListeners.remove(eventListener);
        }
        if (eventListener instanceof je0) {
            this._sessionListeners.remove(eventListener);
        }
    }

    public void removeSession(ee0 ee0Var, boolean z) {
        removeSession(((SessionIf) ee0Var).getSession(), z);
    }

    public void removeSession(AbstractSession abstractSession, boolean z) {
        if (removeSession(abstractSession.getClusterId())) {
            this._sessionsStats.decrement();
            this._sessionTimeStats.set(Math.round((System.currentTimeMillis() - abstractSession.getCreationTime()) / 1000.0d));
            this._sessionIdManager.removeSession(abstractSession);
            if (z) {
                this._sessionIdManager.invalidateAll(abstractSession.getClusterId());
            }
            if (!z || this._sessionListeners == null) {
                return;
            }
            HttpSessionEvent httpSessionEvent = new HttpSessionEvent(abstractSession);
            for (je0 je0Var : this._sessionListeners) {
                je0Var.sessionDestroyed(httpSessionEvent);
            }
        }
    }

    public abstract boolean removeSession(String str);

    @Deprecated
    public void resetStats() {
        statsReset();
    }

    @Override // org.eclipse.jetty.server.SessionManager
    public void setCheckingRemoteSessionIdEncoding(boolean z) {
        this._checkingRemoteSessionIdEncoding = z;
    }

    public void setHttpOnly(boolean z) {
        this._httpOnly = z;
    }

    public void setIdManager(SessionIdManager sessionIdManager) {
        setSessionIdManager(sessionIdManager);
    }

    @Override // org.eclipse.jetty.server.SessionManager
    public void setMaxInactiveInterval(int i) {
        this._dftMaxIdleSecs = i;
    }

    public void setNodeIdInSessionId(boolean z) {
        this._nodeIdInSessionId = z;
    }

    public void setRefreshCookieAge(int i) {
        this._refreshCookieAge = i;
    }

    public void setSecureRequestOnly(boolean z) {
        this._secureRequestOnly = z;
    }

    public void setSessionCookie(String str) {
        this._sessionCookie = str;
    }

    @Override // org.eclipse.jetty.server.SessionManager
    public void setSessionHandler(SessionHandler sessionHandler) {
        this._sessionHandler = sessionHandler;
    }

    @Override // org.eclipse.jetty.server.SessionManager
    public void setSessionIdManager(SessionIdManager sessionIdManager) {
        this._sessionIdManager = sessionIdManager;
    }

    @Override // org.eclipse.jetty.server.SessionManager
    public void setSessionIdPathParameterName(String str) {
        String str2 = null;
        this._sessionIdPathParameterName = (str == null || Constants.CP_NONE.equals(str)) ? null : str;
        if (str != null && !Constants.CP_NONE.equals(str)) {
            str2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(";"), this._sessionIdPathParameterName, "=");
        }
        this._sessionIdPathParameterNamePrefix = str2;
    }

    @Override // org.eclipse.jetty.server.SessionManager
    public void setSessionTrackingModes(Set<SessionTrackingMode> set) {
        HashSet hashSet = new HashSet(set);
        this._sessionTrackingModes = hashSet;
        this._usingCookies = hashSet.contains(SessionTrackingMode.COOKIE);
        this._usingURLs = this._sessionTrackingModes.contains(SessionTrackingMode.URL);
    }

    public void setUsingCookies(boolean z) {
        this._usingCookies = z;
    }

    public void statsReset() {
        this._sessionsStats.reset(getSessions());
        this._sessionTimeStats.reset();
    }
}
