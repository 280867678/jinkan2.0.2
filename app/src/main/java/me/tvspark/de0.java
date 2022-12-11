package me.tvspark;

import java.io.IOException;
import java.util.Collection;
import javax.servlet.ServletResponseWrapper;
import javax.servlet.http.Cookie;

/* loaded from: classes4.dex */
public class de0 extends ServletResponseWrapper implements ce0 {
    public de0(ce0 ce0Var) {
        super(ce0Var);
    }

    private ce0 _getHttpServletResponse() {
        return (ce0) super.getResponse();
    }

    @Override // me.tvspark.ce0
    public void addCookie(Cookie cookie) {
        _getHttpServletResponse().addCookie(cookie);
    }

    @Override // me.tvspark.ce0
    public void addDateHeader(String str, long j) {
        _getHttpServletResponse().addDateHeader(str, j);
    }

    @Override // me.tvspark.ce0
    public void addHeader(String str, String str2) {
        _getHttpServletResponse().addHeader(str, str2);
    }

    @Override // me.tvspark.ce0
    public void addIntHeader(String str, int i) {
        _getHttpServletResponse().addIntHeader(str, i);
    }

    @Override // me.tvspark.ce0
    public boolean containsHeader(String str) {
        return _getHttpServletResponse().containsHeader(str);
    }

    @Override // me.tvspark.ce0
    public String encodeRedirectURL(String str) {
        return _getHttpServletResponse().encodeRedirectURL(str);
    }

    @Override // me.tvspark.ce0
    public String encodeRedirectUrl(String str) {
        return _getHttpServletResponse().encodeRedirectUrl(str);
    }

    @Override // me.tvspark.ce0
    public String encodeURL(String str) {
        return _getHttpServletResponse().encodeURL(str);
    }

    @Override // me.tvspark.ce0
    public String encodeUrl(String str) {
        return _getHttpServletResponse().encodeUrl(str);
    }

    @Override // me.tvspark.ce0
    public String getHeader(String str) {
        return _getHttpServletResponse().getHeader(str);
    }

    @Override // me.tvspark.ce0
    public Collection<String> getHeaderNames() {
        return _getHttpServletResponse().getHeaderNames();
    }

    @Override // me.tvspark.ce0
    public Collection<String> getHeaders(String str) {
        return _getHttpServletResponse().getHeaders(str);
    }

    @Override // me.tvspark.ce0
    public int getStatus() {
        return _getHttpServletResponse().getStatus();
    }

    @Override // me.tvspark.ce0
    public void sendError(int i) throws IOException {
        _getHttpServletResponse().sendError(i);
    }

    @Override // me.tvspark.ce0
    public void sendError(int i, String str) throws IOException {
        _getHttpServletResponse().sendError(i, str);
    }

    @Override // me.tvspark.ce0
    public void sendRedirect(String str) throws IOException {
        _getHttpServletResponse().sendRedirect(str);
    }

    @Override // me.tvspark.ce0
    public void setDateHeader(String str, long j) {
        _getHttpServletResponse().setDateHeader(str, j);
    }

    @Override // me.tvspark.ce0
    public void setHeader(String str, String str2) {
        _getHttpServletResponse().setHeader(str, str2);
    }

    @Override // me.tvspark.ce0
    public void setIntHeader(String str, int i) {
        _getHttpServletResponse().setIntHeader(str, i);
    }

    @Override // me.tvspark.ce0
    public void setStatus(int i) {
        _getHttpServletResponse().setStatus(i);
    }

    @Override // me.tvspark.ce0
    public void setStatus(int i, String str) {
        _getHttpServletResponse().setStatus(i, str);
    }
}
