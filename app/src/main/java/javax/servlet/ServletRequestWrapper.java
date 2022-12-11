package javax.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;
import me.tvspark.outline;

/* loaded from: classes4.dex */
public class ServletRequestWrapper implements ServletRequest {
    public ServletRequest request;

    public ServletRequestWrapper(ServletRequest servletRequest) {
        if (servletRequest != null) {
            this.request = servletRequest;
            return;
        }
        throw new IllegalArgumentException("Request cannot be null");
    }

    @Override // javax.servlet.ServletRequest
    public AsyncContext getAsyncContext() {
        return this.request.getAsyncContext();
    }

    @Override // javax.servlet.ServletRequest
    public Object getAttribute(String str) {
        return this.request.getAttribute(str);
    }

    @Override // javax.servlet.ServletRequest
    public Enumeration<String> getAttributeNames() {
        return this.request.getAttributeNames();
    }

    @Override // javax.servlet.ServletRequest
    public String getCharacterEncoding() {
        return this.request.getCharacterEncoding();
    }

    @Override // javax.servlet.ServletRequest
    public int getContentLength() {
        return this.request.getContentLength();
    }

    @Override // javax.servlet.ServletRequest
    public String getContentType() {
        return this.request.getContentType();
    }

    @Override // javax.servlet.ServletRequest
    public DispatcherType getDispatcherType() {
        return this.request.getDispatcherType();
    }

    @Override // javax.servlet.ServletRequest
    public ServletInputStream getInputStream() throws IOException {
        return this.request.getInputStream();
    }

    @Override // javax.servlet.ServletRequest
    public String getLocalAddr() {
        return this.request.getLocalAddr();
    }

    @Override // javax.servlet.ServletRequest
    public String getLocalName() {
        return this.request.getLocalName();
    }

    @Override // javax.servlet.ServletRequest
    public int getLocalPort() {
        return this.request.getLocalPort();
    }

    @Override // javax.servlet.ServletRequest
    public Locale getLocale() {
        return this.request.getLocale();
    }

    @Override // javax.servlet.ServletRequest
    public Enumeration<Locale> getLocales() {
        return this.request.getLocales();
    }

    @Override // javax.servlet.ServletRequest
    public String getParameter(String str) {
        return this.request.getParameter(str);
    }

    @Override // javax.servlet.ServletRequest
    public Map<String, String[]> getParameterMap() {
        return this.request.getParameterMap();
    }

    @Override // javax.servlet.ServletRequest
    public Enumeration<String> getParameterNames() {
        return this.request.getParameterNames();
    }

    @Override // javax.servlet.ServletRequest
    public String[] getParameterValues(String str) {
        return this.request.getParameterValues(str);
    }

    @Override // javax.servlet.ServletRequest
    public String getProtocol() {
        return this.request.getProtocol();
    }

    @Override // javax.servlet.ServletRequest
    public BufferedReader getReader() throws IOException {
        return this.request.getReader();
    }

    @Override // javax.servlet.ServletRequest
    public String getRealPath(String str) {
        return this.request.getRealPath(str);
    }

    @Override // javax.servlet.ServletRequest
    public String getRemoteAddr() {
        return this.request.getRemoteAddr();
    }

    @Override // javax.servlet.ServletRequest
    public String getRemoteHost() {
        return this.request.getRemoteHost();
    }

    @Override // javax.servlet.ServletRequest
    public int getRemotePort() {
        return this.request.getRemotePort();
    }

    public ServletRequest getRequest() {
        return this.request;
    }

    @Override // javax.servlet.ServletRequest
    public RequestDispatcher getRequestDispatcher(String str) {
        return this.request.getRequestDispatcher(str);
    }

    @Override // javax.servlet.ServletRequest
    public String getScheme() {
        return this.request.getScheme();
    }

    @Override // javax.servlet.ServletRequest
    public String getServerName() {
        return this.request.getServerName();
    }

    @Override // javax.servlet.ServletRequest
    public int getServerPort() {
        return this.request.getServerPort();
    }

    @Override // javax.servlet.ServletRequest
    public ServletContext getServletContext() {
        return this.request.getServletContext();
    }

    @Override // javax.servlet.ServletRequest
    public boolean isAsyncStarted() {
        return this.request.isAsyncStarted();
    }

    @Override // javax.servlet.ServletRequest
    public boolean isAsyncSupported() {
        return this.request.isAsyncSupported();
    }

    @Override // javax.servlet.ServletRequest
    public boolean isSecure() {
        return this.request.isSecure();
    }

    public boolean isWrapperFor(Class cls) {
        if (!ServletRequest.class.isAssignableFrom(cls)) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Given class ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(cls.getName());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" not a subinterface of ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(ServletRequest.class.getName());
            throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        } else if (cls.isAssignableFrom(this.request.getClass())) {
            return true;
        } else {
            ServletRequest servletRequest = this.request;
            if (!(servletRequest instanceof ServletRequestWrapper)) {
                return false;
            }
            return ((ServletRequestWrapper) servletRequest).isWrapperFor(cls);
        }
    }

    public boolean isWrapperFor(ServletRequest servletRequest) {
        ServletRequest servletRequest2 = this.request;
        if (servletRequest2 == servletRequest) {
            return true;
        }
        if (!(servletRequest2 instanceof ServletRequestWrapper)) {
            return false;
        }
        return ((ServletRequestWrapper) servletRequest2).isWrapperFor(servletRequest);
    }

    @Override // javax.servlet.ServletRequest
    public void removeAttribute(String str) {
        this.request.removeAttribute(str);
    }

    @Override // javax.servlet.ServletRequest
    public void setAttribute(String str, Object obj) {
        this.request.setAttribute(str, obj);
    }

    @Override // javax.servlet.ServletRequest
    public void setCharacterEncoding(String str) throws UnsupportedEncodingException {
        this.request.setCharacterEncoding(str);
    }

    public void setRequest(ServletRequest servletRequest) {
        if (servletRequest != null) {
            this.request = servletRequest;
            return;
        }
        throw new IllegalArgumentException("Request cannot be null");
    }

    @Override // javax.servlet.ServletRequest
    public AsyncContext startAsync() throws IllegalStateException {
        return this.request.startAsync();
    }

    @Override // javax.servlet.ServletRequest
    public AsyncContext startAsync(ServletRequest servletRequest, ServletResponse servletResponse) throws IllegalStateException {
        return this.request.startAsync(servletRequest, servletResponse);
    }
}
