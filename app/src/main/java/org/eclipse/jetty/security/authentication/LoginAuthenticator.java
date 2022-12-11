package org.eclipse.jetty.security.authentication;

import javax.servlet.ServletRequest;
import me.tvspark.ae0;
import me.tvspark.ce0;
import me.tvspark.ee0;
import org.eclipse.jetty.security.Authenticator;
import org.eclipse.jetty.security.IdentityService;
import org.eclipse.jetty.security.LoginService;
import org.eclipse.jetty.server.UserIdentity;
import org.eclipse.jetty.server.session.AbstractSessionManager;

/* loaded from: classes4.dex */
public abstract class LoginAuthenticator implements Authenticator {
    public IdentityService _identityService;
    public LoginService _loginService;
    public boolean _renewSession;

    public LoginService getLoginService() {
        return this._loginService;
    }

    public UserIdentity login(String str, Object obj, ServletRequest servletRequest) {
        UserIdentity login = this._loginService.login(str, obj);
        if (login != null) {
            renewSession((ae0) servletRequest, null);
            return login;
        }
        return null;
    }

    public ee0 renewSession(ae0 ae0Var, ce0 ce0Var) {
        ee0 session = ae0Var.getSession(false);
        if (this._renewSession && session != null && session.getAttribute(AbstractSessionManager.SESSION_KNOWN_ONLY_TO_AUTHENTICATED) != Boolean.TRUE) {
            synchronized (this) {
                session = AbstractSessionManager.renewSession(ae0Var, session, true);
            }
        }
        return session;
    }

    @Override // org.eclipse.jetty.security.Authenticator
    public void setConfiguration(Authenticator.AuthConfiguration authConfiguration) {
        LoginService loginService = authConfiguration.getLoginService();
        this._loginService = loginService;
        if (loginService == null) {
            throw new IllegalStateException("No LoginService for " + this + " in " + authConfiguration);
        }
        IdentityService identityService = authConfiguration.getIdentityService();
        this._identityService = identityService;
        if (identityService != null) {
            this._renewSession = authConfiguration.isSessionRenewedOnAuthentication();
            return;
        }
        throw new IllegalStateException("No IdentityService for " + this + " in " + authConfiguration);
    }
}
