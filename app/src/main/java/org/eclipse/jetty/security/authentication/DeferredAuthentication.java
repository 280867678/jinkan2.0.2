package org.eclipse.jetty.security.authentication;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Collections;
import java.util.Locale;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import me.tvspark.ce0;
import org.eclipse.jetty.security.IdentityService;
import org.eclipse.jetty.security.ServerAuthException;
import org.eclipse.jetty.security.UserAuthentication;
import org.eclipse.jetty.server.Authentication;
import org.eclipse.jetty.server.UserIdentity;
import org.eclipse.jetty.util.C3009IO;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: classes4.dex */
public class DeferredAuthentication implements Authentication.Deferred {
    public static final Logger LOG = Log.getLogger(DeferredAuthentication.class);
    public static final ce0 __deferredResponse = new ce0() { // from class: org.eclipse.jetty.security.authentication.DeferredAuthentication.1
        @Override // me.tvspark.ce0
        public void addCookie(Cookie cookie) {
        }

        @Override // me.tvspark.ce0
        public void addDateHeader(String str, long j) {
        }

        @Override // me.tvspark.ce0
        public void addHeader(String str, String str2) {
        }

        @Override // me.tvspark.ce0
        public void addIntHeader(String str, int i) {
        }

        @Override // me.tvspark.ce0
        public boolean containsHeader(String str) {
            return false;
        }

        @Override // me.tvspark.ce0
        public String encodeRedirectURL(String str) {
            return null;
        }

        @Override // me.tvspark.ce0
        public String encodeRedirectUrl(String str) {
            return null;
        }

        @Override // me.tvspark.ce0
        public String encodeURL(String str) {
            return null;
        }

        @Override // me.tvspark.ce0
        public String encodeUrl(String str) {
            return null;
        }

        @Override // javax.servlet.ServletResponse
        public void flushBuffer() throws IOException {
        }

        @Override // javax.servlet.ServletResponse
        public int getBufferSize() {
            return 1024;
        }

        @Override // javax.servlet.ServletResponse
        public String getCharacterEncoding() {
            return null;
        }

        @Override // javax.servlet.ServletResponse
        public String getContentType() {
            return null;
        }

        @Override // me.tvspark.ce0
        public String getHeader(String str) {
            return null;
        }

        @Override // me.tvspark.ce0
        public Collection<String> getHeaderNames() {
            return Collections.emptyList();
        }

        @Override // me.tvspark.ce0
        public Collection<String> getHeaders(String str) {
            return Collections.emptyList();
        }

        @Override // javax.servlet.ServletResponse
        public Locale getLocale() {
            return null;
        }

        @Override // javax.servlet.ServletResponse
        public ServletOutputStream getOutputStream() throws IOException {
            return DeferredAuthentication.__nullOut;
        }

        @Override // me.tvspark.ce0
        public int getStatus() {
            return 0;
        }

        @Override // javax.servlet.ServletResponse
        public PrintWriter getWriter() throws IOException {
            return C3009IO.getNullPrintWriter();
        }

        @Override // javax.servlet.ServletResponse
        public boolean isCommitted() {
            return true;
        }

        @Override // javax.servlet.ServletResponse
        public void reset() {
        }

        @Override // javax.servlet.ServletResponse
        public void resetBuffer() {
        }

        @Override // me.tvspark.ce0
        public void sendError(int i) throws IOException {
        }

        @Override // me.tvspark.ce0
        public void sendError(int i, String str) throws IOException {
        }

        @Override // me.tvspark.ce0
        public void sendRedirect(String str) throws IOException {
        }

        @Override // javax.servlet.ServletResponse
        public void setBufferSize(int i) {
        }

        @Override // javax.servlet.ServletResponse
        public void setCharacterEncoding(String str) {
        }

        @Override // javax.servlet.ServletResponse
        public void setContentLength(int i) {
        }

        @Override // javax.servlet.ServletResponse
        public void setContentType(String str) {
        }

        @Override // me.tvspark.ce0
        public void setDateHeader(String str, long j) {
        }

        @Override // me.tvspark.ce0
        public void setHeader(String str, String str2) {
        }

        @Override // me.tvspark.ce0
        public void setIntHeader(String str, int i) {
        }

        @Override // javax.servlet.ServletResponse
        public void setLocale(Locale locale) {
        }

        @Override // me.tvspark.ce0
        public void setStatus(int i) {
        }

        @Override // me.tvspark.ce0
        public void setStatus(int i, String str) {
        }
    };
    public static ServletOutputStream __nullOut = new ServletOutputStream() { // from class: org.eclipse.jetty.security.authentication.DeferredAuthentication.2
        @Override // javax.servlet.ServletOutputStream
        public void print(String str) throws IOException {
        }

        @Override // javax.servlet.ServletOutputStream
        public void println(String str) throws IOException {
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
        }
    };
    public final LoginAuthenticator _authenticator;
    public Object _previousAssociation;

    public DeferredAuthentication(LoginAuthenticator loginAuthenticator) {
        if (loginAuthenticator != null) {
            this._authenticator = loginAuthenticator;
            return;
        }
        throw new NullPointerException("No Authenticator");
    }

    public static boolean isDeferred(ce0 ce0Var) {
        return ce0Var == __deferredResponse;
    }

    @Override // org.eclipse.jetty.server.Authentication.Deferred
    public Authentication authenticate(ServletRequest servletRequest) {
        try {
            Authentication validateRequest = this._authenticator.validateRequest(servletRequest, __deferredResponse, true);
            if (validateRequest != null && (validateRequest instanceof Authentication.User) && !(validateRequest instanceof Authentication.ResponseSent)) {
                IdentityService identityService = this._authenticator.getLoginService().getIdentityService();
                if (identityService != null) {
                    this._previousAssociation = identityService.associate(((Authentication.User) validateRequest).getUserIdentity());
                }
                return validateRequest;
            }
        } catch (ServerAuthException e) {
            LOG.debug(e);
        }
        return this;
    }

    @Override // org.eclipse.jetty.server.Authentication.Deferred
    public Authentication authenticate(ServletRequest servletRequest, ServletResponse servletResponse) {
        try {
            IdentityService identityService = this._authenticator.getLoginService().getIdentityService();
            Authentication validateRequest = this._authenticator.validateRequest(servletRequest, servletResponse, true);
            if ((validateRequest instanceof Authentication.User) && identityService != null) {
                this._previousAssociation = identityService.associate(((Authentication.User) validateRequest).getUserIdentity());
            }
            return validateRequest;
        } catch (ServerAuthException e) {
            LOG.debug(e);
            return this;
        }
    }

    public Object getPreviousAssociation() {
        return this._previousAssociation;
    }

    @Override // org.eclipse.jetty.server.Authentication.Deferred
    public Authentication login(String str, Object obj, ServletRequest servletRequest) {
        UserIdentity login = this._authenticator.login(str, obj, servletRequest);
        if (login != null) {
            IdentityService identityService = this._authenticator.getLoginService().getIdentityService();
            UserAuthentication userAuthentication = new UserAuthentication("API", login);
            if (identityService != null) {
                this._previousAssociation = identityService.associate(login);
            }
            return userAuthentication;
        }
        return null;
    }
}
