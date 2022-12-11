package org.eclipse.jetty.server;

import java.io.IOException;
import java.security.Principal;
import java.util.Collection;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestWrapper;
import javax.servlet.http.Cookie;
import me.tvspark.ae0;
import me.tvspark.ce0;
import me.tvspark.ee0;
import me.tvspark.me0;

/* loaded from: classes4.dex */
public class ServletRequestHttpWrapper extends ServletRequestWrapper implements ae0 {
    public ServletRequestHttpWrapper(ServletRequest servletRequest) {
        super(servletRequest);
    }

    @Override // me.tvspark.ae0
    public boolean authenticate(ce0 ce0Var) throws IOException, ServletException {
        return false;
    }

    @Override // me.tvspark.ae0
    public String getAuthType() {
        return null;
    }

    @Override // me.tvspark.ae0
    public String getContextPath() {
        return null;
    }

    @Override // me.tvspark.ae0
    public Cookie[] getCookies() {
        return null;
    }

    @Override // me.tvspark.ae0
    public long getDateHeader(String str) {
        return 0L;
    }

    @Override // me.tvspark.ae0
    public String getHeader(String str) {
        return null;
    }

    @Override // me.tvspark.ae0
    public Enumeration getHeaderNames() {
        return null;
    }

    @Override // me.tvspark.ae0
    public Enumeration getHeaders(String str) {
        return null;
    }

    @Override // me.tvspark.ae0
    public int getIntHeader(String str) {
        return 0;
    }

    @Override // me.tvspark.ae0
    public String getMethod() {
        return null;
    }

    @Override // me.tvspark.ae0
    public me0 getPart(String str) throws IOException, ServletException {
        return null;
    }

    @Override // me.tvspark.ae0
    public Collection<me0> getParts() throws IOException, ServletException {
        return null;
    }

    @Override // me.tvspark.ae0
    public String getPathInfo() {
        return null;
    }

    @Override // me.tvspark.ae0
    public String getPathTranslated() {
        return null;
    }

    @Override // me.tvspark.ae0
    public String getQueryString() {
        return null;
    }

    @Override // me.tvspark.ae0
    public String getRemoteUser() {
        return null;
    }

    @Override // me.tvspark.ae0
    public String getRequestURI() {
        return null;
    }

    @Override // me.tvspark.ae0
    public StringBuffer getRequestURL() {
        return null;
    }

    @Override // me.tvspark.ae0
    public String getRequestedSessionId() {
        return null;
    }

    @Override // me.tvspark.ae0
    public String getServletPath() {
        return null;
    }

    @Override // me.tvspark.ae0
    public ee0 getSession() {
        return null;
    }

    @Override // me.tvspark.ae0
    public ee0 getSession(boolean z) {
        return null;
    }

    @Override // me.tvspark.ae0
    public Principal getUserPrincipal() {
        return null;
    }

    @Override // me.tvspark.ae0
    public boolean isRequestedSessionIdFromCookie() {
        return false;
    }

    @Override // me.tvspark.ae0
    public boolean isRequestedSessionIdFromURL() {
        return false;
    }

    @Override // me.tvspark.ae0
    public boolean isRequestedSessionIdFromUrl() {
        return false;
    }

    @Override // me.tvspark.ae0
    public boolean isRequestedSessionIdValid() {
        return false;
    }

    @Override // me.tvspark.ae0
    public boolean isUserInRole(String str) {
        return false;
    }

    @Override // me.tvspark.ae0
    public void login(String str, String str2) throws ServletException {
    }

    @Override // me.tvspark.ae0
    public void logout() throws ServletException {
    }
}
