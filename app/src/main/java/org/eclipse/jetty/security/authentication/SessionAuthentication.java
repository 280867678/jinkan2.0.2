package org.eclipse.jetty.security.authentication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import me.tvspark.ee0;
import me.tvspark.fe0;
import me.tvspark.he0;
import me.tvspark.outline;
import org.eclipse.jetty.security.LoginService;
import org.eclipse.jetty.security.SecurityHandler;
import org.eclipse.jetty.server.Authentication;
import org.eclipse.jetty.server.UserIdentity;
import org.eclipse.jetty.server.session.AbstractSessionManager;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: classes4.dex */
public class SessionAuthentication implements Authentication.User, Serializable, fe0, he0 {
    public static final Logger LOG = Log.getLogger(SessionAuthentication.class);
    public static final String __J_AUTHENTICATED = "org.eclipse.jetty.security.UserIdentity";
    public static final long serialVersionUID = -4643200685888258706L;
    public final Object _credentials;
    public final String _method;
    public final String _name;
    public transient ee0 _session;
    public transient UserIdentity _userIdentity;

    public SessionAuthentication(String str, UserIdentity userIdentity, Object obj) {
        this._method = str;
        this._userIdentity = userIdentity;
        this._name = userIdentity.getUserPrincipal().getName();
        this._credentials = obj;
    }

    private void doLogout() {
        SecurityHandler currentSecurityHandler = SecurityHandler.getCurrentSecurityHandler();
        if (currentSecurityHandler != null) {
            currentSecurityHandler.logout(this);
        }
        ee0 ee0Var = this._session;
        if (ee0Var != null) {
            ee0Var.removeAttribute(AbstractSessionManager.SESSION_KNOWN_ONLY_TO_AUTHENTICATED);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        SecurityHandler currentSecurityHandler = SecurityHandler.getCurrentSecurityHandler();
        if (currentSecurityHandler != null) {
            LoginService loginService = currentSecurityHandler.getLoginService();
            if (loginService == null) {
                throw new IllegalStateException("!LoginService");
            }
            this._userIdentity = loginService.login(this._name, this._credentials);
            LOG.debug("Deserialized and relogged in {}", this);
            return;
        }
        throw new IllegalStateException("!SecurityHandler");
    }

    @Override // org.eclipse.jetty.server.Authentication.User
    public String getAuthMethod() {
        return this._method;
    }

    @Override // org.eclipse.jetty.server.Authentication.User
    public UserIdentity getUserIdentity() {
        return this._userIdentity;
    }

    @Override // org.eclipse.jetty.server.Authentication.User
    public boolean isUserInRole(UserIdentity.Scope scope, String str) {
        return this._userIdentity.isUserInRole(str, scope);
    }

    @Override // org.eclipse.jetty.server.Authentication.User
    public void logout() {
        ee0 ee0Var = this._session;
        if (ee0Var != null && ee0Var.getAttribute(__J_AUTHENTICATED) != null) {
            this._session.removeAttribute(__J_AUTHENTICATED);
        }
        doLogout();
    }

    @Override // me.tvspark.fe0
    public void sessionDidActivate(HttpSessionEvent httpSessionEvent) {
        if (this._session == null) {
            this._session = httpSessionEvent.getSession();
        }
    }

    @Override // me.tvspark.fe0
    public void sessionWillPassivate(HttpSessionEvent httpSessionEvent) {
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Session");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(super.toString());
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    @Override // me.tvspark.he0
    public void valueBound(HttpSessionBindingEvent httpSessionBindingEvent) {
        if (this._session == null) {
            this._session = httpSessionBindingEvent.getSession();
        }
    }

    @Override // me.tvspark.he0
    public void valueUnbound(HttpSessionBindingEvent httpSessionBindingEvent) {
        doLogout();
    }
}
