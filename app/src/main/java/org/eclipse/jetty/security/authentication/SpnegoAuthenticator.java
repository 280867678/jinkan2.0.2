package org.eclipse.jetty.security.authentication;

import java.io.IOException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import me.tvspark.ae0;
import me.tvspark.ce0;
import org.eclipse.jetty.http.HttpHeaders;
import org.eclipse.jetty.security.ServerAuthException;
import org.eclipse.jetty.security.UserAuthentication;
import org.eclipse.jetty.server.Authentication;
import org.eclipse.jetty.server.UserIdentity;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.security.Constraint;

/* loaded from: classes4.dex */
public class SpnegoAuthenticator extends LoginAuthenticator {
    public static final Logger LOG = Log.getLogger(SpnegoAuthenticator.class);
    public String _authMethod;

    public SpnegoAuthenticator() {
        this._authMethod = Constraint.__SPNEGO_AUTH;
    }

    public SpnegoAuthenticator(String str) {
        this._authMethod = Constraint.__SPNEGO_AUTH;
        this._authMethod = str;
    }

    @Override // org.eclipse.jetty.security.Authenticator
    public String getAuthMethod() {
        return this._authMethod;
    }

    @Override // org.eclipse.jetty.security.Authenticator
    public boolean secureResponse(ServletRequest servletRequest, ServletResponse servletResponse, boolean z, Authentication.User user) throws ServerAuthException {
        return true;
    }

    @Override // org.eclipse.jetty.security.Authenticator
    public Authentication validateRequest(ServletRequest servletRequest, ServletResponse servletResponse, boolean z) throws ServerAuthException {
        UserIdentity login;
        ce0 ce0Var = (ce0) servletResponse;
        String header = ((ae0) servletRequest).getHeader("Authorization");
        if (!z) {
            return new DeferredAuthentication(this);
        }
        if (header != null) {
            return (!header.startsWith(HttpHeaders.NEGOTIATE) || (login = login(null, header.substring(10), servletRequest)) == null) ? Authentication.UNAUTHENTICATED : new UserAuthentication(getAuthMethod(), login);
        }
        try {
            if (DeferredAuthentication.isDeferred(ce0Var)) {
                return Authentication.UNAUTHENTICATED;
            }
            LOG.debug("SpengoAuthenticator: sending challenge", new Object[0]);
            ce0Var.setHeader("WWW-Authenticate", HttpHeaders.NEGOTIATE);
            ce0Var.sendError(401);
            return Authentication.SEND_CONTINUE;
        } catch (IOException e) {
            throw new ServerAuthException(e);
        }
    }
}
