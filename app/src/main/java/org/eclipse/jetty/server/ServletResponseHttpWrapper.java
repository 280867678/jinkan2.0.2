package org.eclipse.jetty.server;

import java.io.IOException;
import java.util.Collection;
import javax.servlet.ServletResponse;
import javax.servlet.ServletResponseWrapper;
import javax.servlet.http.Cookie;
import me.tvspark.ce0;

/* loaded from: classes4.dex */
public class ServletResponseHttpWrapper extends ServletResponseWrapper implements ce0 {
    public ServletResponseHttpWrapper(ServletResponse servletResponse) {
        super(servletResponse);
    }

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

    @Override // me.tvspark.ce0
    public String getHeader(String str) {
        return null;
    }

    @Override // me.tvspark.ce0
    public Collection<String> getHeaderNames() {
        return null;
    }

    @Override // me.tvspark.ce0
    public Collection<String> getHeaders(String str) {
        return null;
    }

    @Override // me.tvspark.ce0
    public int getStatus() {
        return 0;
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

    @Override // me.tvspark.ce0
    public void setDateHeader(String str, long j) {
    }

    @Override // me.tvspark.ce0
    public void setHeader(String str, String str2) {
    }

    @Override // me.tvspark.ce0
    public void setIntHeader(String str, int i) {
    }

    @Override // me.tvspark.ce0
    public void setStatus(int i) {
    }

    @Override // me.tvspark.ce0
    public void setStatus(int i, String str) {
    }
}
