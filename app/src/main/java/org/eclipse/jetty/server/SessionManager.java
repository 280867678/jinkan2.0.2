package org.eclipse.jetty.server;

import java.util.EventListener;
import java.util.Set;
import javax.servlet.SessionCookieConfig;
import javax.servlet.SessionTrackingMode;
import me.tvspark.ae0;
import me.tvspark.ee0;
import org.eclipse.jetty.http.HttpCookie;
import org.eclipse.jetty.server.session.SessionHandler;
import org.eclipse.jetty.util.component.LifeCycle;

/* loaded from: classes4.dex */
public interface SessionManager extends LifeCycle {
    public static final String __CheckRemoteSessionEncoding = "org.eclipse.jetty.servlet.CheckingRemoteSessionIdEncoding";
    public static final String __DefaultSessionCookie = "JSESSIONID";
    public static final String __DefaultSessionDomain = null;
    public static final String __DefaultSessionIdPathParameterName = "jsessionid";
    public static final String __MaxAgeProperty = "org.eclipse.jetty.servlet.MaxAge";
    public static final String __SessionCookieProperty = "org.eclipse.jetty.servlet.SessionCookie";
    public static final String __SessionDomainProperty = "org.eclipse.jetty.servlet.SessionDomain";
    public static final String __SessionIdPathParameterNameProperty = "org.eclipse.jetty.servlet.SessionIdPathParameterName";
    public static final String __SessionPathProperty = "org.eclipse.jetty.servlet.SessionPath";

    HttpCookie access(ee0 ee0Var, boolean z);

    void addEventListener(EventListener eventListener);

    void clearEventListeners();

    void complete(ee0 ee0Var);

    String getClusterId(ee0 ee0Var);

    Set<SessionTrackingMode> getDefaultSessionTrackingModes();

    Set<SessionTrackingMode> getEffectiveSessionTrackingModes();

    boolean getHttpOnly();

    ee0 getHttpSession(String str);

    int getMaxInactiveInterval();

    @Deprecated
    SessionIdManager getMetaManager();

    String getNodeId(ee0 ee0Var);

    HttpCookie getSessionCookie(ee0 ee0Var, String str, boolean z);

    SessionCookieConfig getSessionCookieConfig();

    SessionIdManager getSessionIdManager();

    String getSessionIdPathParameterName();

    String getSessionIdPathParameterNamePrefix();

    boolean isCheckingRemoteSessionIdEncoding();

    boolean isUsingCookies();

    boolean isUsingURLs();

    boolean isValid(ee0 ee0Var);

    ee0 newHttpSession(ae0 ae0Var);

    void removeEventListener(EventListener eventListener);

    void setCheckingRemoteSessionIdEncoding(boolean z);

    void setMaxInactiveInterval(int i);

    void setSessionHandler(SessionHandler sessionHandler);

    void setSessionIdManager(SessionIdManager sessionIdManager);

    void setSessionIdPathParameterName(String str);

    void setSessionTrackingModes(Set<SessionTrackingMode> set);
}
