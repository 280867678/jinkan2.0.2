package me.tvspark;

import java.io.IOException;
import java.security.Principal;
import java.util.Collection;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.ServletRequestWrapper;
import javax.servlet.http.Cookie;

/* loaded from: classes4.dex */
public class be0 extends ServletRequestWrapper implements ae0 {
    public be0(ae0 ae0Var) {
        super(ae0Var);
    }

    private ae0 _getHttpServletRequest() {
        return (ae0) super.getRequest();
    }

    @Override // me.tvspark.ae0
    public boolean authenticate(ce0 ce0Var) throws IOException, ServletException {
        return _getHttpServletRequest().authenticate(ce0Var);
    }

    @Override // me.tvspark.ae0
    public String getAuthType() {
        return _getHttpServletRequest().getAuthType();
    }

    @Override // me.tvspark.ae0
    public String getContextPath() {
        return _getHttpServletRequest().getContextPath();
    }

    @Override // me.tvspark.ae0
    public Cookie[] getCookies() {
        return _getHttpServletRequest().getCookies();
    }

    @Override // me.tvspark.ae0
    public long getDateHeader(String str) {
        return _getHttpServletRequest().getDateHeader(str);
    }

    @Override // me.tvspark.ae0
    public String getHeader(String str) {
        return _getHttpServletRequest().getHeader(str);
    }

    @Override // me.tvspark.ae0
    public Enumeration<String> getHeaderNames() {
        return _getHttpServletRequest().getHeaderNames();
    }

    @Override // me.tvspark.ae0
    public Enumeration<String> getHeaders(String str) {
        return _getHttpServletRequest().getHeaders(str);
    }

    @Override // me.tvspark.ae0
    public int getIntHeader(String str) {
        return _getHttpServletRequest().getIntHeader(str);
    }

    @Override // me.tvspark.ae0
    public String getMethod() {
        return _getHttpServletRequest().getMethod();
    }

    @Override // me.tvspark.ae0
    public me0 getPart(String str) throws IOException, ServletException {
        return _getHttpServletRequest().getPart(str);
    }

    @Override // me.tvspark.ae0
    public Collection<me0> getParts() throws IOException, ServletException {
        return _getHttpServletRequest().getParts();
    }

    @Override // me.tvspark.ae0
    public String getPathInfo() {
        return _getHttpServletRequest().getPathInfo();
    }

    @Override // me.tvspark.ae0
    public String getPathTranslated() {
        return _getHttpServletRequest().getPathTranslated();
    }

    @Override // me.tvspark.ae0
    public String getQueryString() {
        return _getHttpServletRequest().getQueryString();
    }

    @Override // me.tvspark.ae0
    public String getRemoteUser() {
        return _getHttpServletRequest().getRemoteUser();
    }

    @Override // me.tvspark.ae0
    public String getRequestURI() {
        return _getHttpServletRequest().getRequestURI();
    }

    @Override // me.tvspark.ae0
    public StringBuffer getRequestURL() {
        return _getHttpServletRequest().getRequestURL();
    }

    @Override // me.tvspark.ae0
    public String getRequestedSessionId() {
        return _getHttpServletRequest().getRequestedSessionId();
    }

    @Override // me.tvspark.ae0
    public String getServletPath() {
        return _getHttpServletRequest().getServletPath();
    }

    @Override // me.tvspark.ae0
    public ee0 getSession() {
        return _getHttpServletRequest().getSession();
    }

    @Override // me.tvspark.ae0
    public ee0 getSession(boolean z) {
        return _getHttpServletRequest().getSession(z);
    }

    @Override // me.tvspark.ae0
    public Principal getUserPrincipal() {
        return _getHttpServletRequest().getUserPrincipal();
    }

    @Override // me.tvspark.ae0
    public boolean isRequestedSessionIdFromCookie() {
        return _getHttpServletRequest().isRequestedSessionIdFromCookie();
    }

    @Override // me.tvspark.ae0
    public boolean isRequestedSessionIdFromURL() {
        return _getHttpServletRequest().isRequestedSessionIdFromURL();
    }

    @Override // me.tvspark.ae0
    public boolean isRequestedSessionIdFromUrl() {
        return _getHttpServletRequest().isRequestedSessionIdFromUrl();
    }

    @Override // me.tvspark.ae0
    public boolean isRequestedSessionIdValid() {
        return _getHttpServletRequest().isRequestedSessionIdValid();
    }

    @Override // me.tvspark.ae0
    public boolean isUserInRole(String str) {
        return _getHttpServletRequest().isUserInRole(str);
    }

    @Override // me.tvspark.ae0
    public void login(String str, String str2) throws ServletException {
        _getHttpServletRequest().login(str, str2);
    }

    @Override // me.tvspark.ae0
    public void logout() throws ServletException {
        _getHttpServletRequest().logout();
    }
}
