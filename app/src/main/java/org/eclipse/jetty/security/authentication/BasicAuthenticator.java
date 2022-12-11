package org.eclipse.jetty.security.authentication;

import java.io.IOException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import me.tvspark.ae0;
import me.tvspark.ce0;
import org.eclipse.jetty.security.ServerAuthException;
import org.eclipse.jetty.security.UserAuthentication;
import org.eclipse.jetty.server.Authentication;
import org.eclipse.jetty.server.UserIdentity;
import org.eclipse.jetty.util.B64Code;
import org.eclipse.jetty.util.security.Constraint;

/* loaded from: classes4.dex */
public class BasicAuthenticator extends LoginAuthenticator {
    @Override // org.eclipse.jetty.security.Authenticator
    public String getAuthMethod() {
        return Constraint.__BASIC_AUTH;
    }

    @Override // org.eclipse.jetty.security.Authenticator
    public boolean secureResponse(ServletRequest servletRequest, ServletResponse servletResponse, boolean z, Authentication.User user) throws ServerAuthException {
        return true;
    }

    @Override // org.eclipse.jetty.security.Authenticator
    public Authentication validateRequest(ServletRequest servletRequest, ServletResponse servletResponse, boolean z) throws ServerAuthException {
        int indexOf;
        String decode;
        int indexOf2;
        UserIdentity login;
        ae0 ae0Var = (ae0) servletRequest;
        ce0 ce0Var = (ce0) servletResponse;
        String header = ae0Var.getHeader("Authorization");
        try {
            if (!z) {
                return new DeferredAuthentication(this);
            }
            if (header != null && (indexOf = header.indexOf(32)) > 0 && "basic".equalsIgnoreCase(header.substring(0, indexOf)) && (indexOf2 = (decode = B64Code.decode(header.substring(indexOf + 1), "ISO-8859-1")).indexOf(58)) > 0 && (login = login(decode.substring(0, indexOf2), decode.substring(indexOf2 + 1), ae0Var)) != null) {
                return new UserAuthentication(getAuthMethod(), login);
            }
            if (DeferredAuthentication.isDeferred(ce0Var)) {
                return Authentication.UNAUTHENTICATED;
            }
            ce0Var.setHeader("WWW-Authenticate", "basic realm=\"" + this._loginService.getName() + '\"');
            ce0Var.sendError(401);
            return Authentication.SEND_CONTINUE;
        } catch (IOException e) {
            throw new ServerAuthException(e);
        }
    }
}
