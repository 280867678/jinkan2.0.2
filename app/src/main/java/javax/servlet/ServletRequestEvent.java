package javax.servlet;

import java.util.EventObject;

/* loaded from: classes4.dex */
public class ServletRequestEvent extends EventObject {
    public ServletRequest request;

    public ServletRequestEvent(ServletContext servletContext, ServletRequest servletRequest) {
        super(servletContext);
        this.request = servletRequest;
    }

    public ServletContext getServletContext() {
        return (ServletContext) super.getSource();
    }

    public ServletRequest getServletRequest() {
        return this.request;
    }
}
