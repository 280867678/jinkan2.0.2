package org.eclipse.jetty.servlet;

import java.io.IOException;
import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import me.tvspark.ae0;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.util.URIUtil;
import org.eclipse.jetty.util.resource.Resource;

/* loaded from: classes5.dex */
public class JspPropertyGroupServlet extends GenericServlet {
    public static final String NAME = "__org.eclipse.jetty.servlet.JspPropertyGroupServlet__";
    public static final long serialVersionUID = 3681783214726776945L;
    public final ContextHandler _contextHandler;
    public ServletHolder _dftServlet;
    public ServletHolder _jspServlet;
    public final ServletHandler _servletHandler;
    public boolean _starJspMapped;

    public JspPropertyGroupServlet(ContextHandler contextHandler, ServletHandler servletHandler) {
        this._contextHandler = contextHandler;
        this._servletHandler = servletHandler;
    }

    @Override // javax.servlet.GenericServlet
    public void init() throws ServletException {
        String str;
        ServletMapping[] servletMappings;
        ServletMapping servletMapping = this._servletHandler.getServletMapping("*.jsp");
        if (servletMapping != null) {
            this._starJspMapped = true;
            for (ServletMapping servletMapping2 : this._servletHandler.getServletMappings()) {
                String[] pathSpecs = servletMapping2.getPathSpecs();
                if (pathSpecs != null) {
                    for (String str2 : pathSpecs) {
                        if ("*.jsp".equals(str2) && !NAME.equals(servletMapping2.getServletName())) {
                            servletMapping = servletMapping2;
                        }
                    }
                }
            }
            str = servletMapping.getServletName();
        } else {
            str = "jsp";
        }
        this._jspServlet = this._servletHandler.getServlet(str);
        ServletMapping servletMapping3 = this._servletHandler.getServletMapping("/");
        this._dftServlet = this._servletHandler.getServlet(servletMapping3 != null ? servletMapping3.getServletName() : "default");
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x001f, code lost:
        if (r1 == null) goto L22;
     */
    @Override // javax.servlet.GenericServlet, javax.servlet.Servlet
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        String servletPath;
        String pathInfo;
        Resource resource;
        if (servletRequest instanceof ae0) {
            ae0 ae0Var = (ae0) servletRequest;
            if (ae0Var.getAttribute(RequestDispatcher.INCLUDE_REQUEST_URI) != null) {
                servletPath = (String) ae0Var.getAttribute(RequestDispatcher.INCLUDE_SERVLET_PATH);
                pathInfo = (String) ae0Var.getAttribute(RequestDispatcher.INCLUDE_PATH_INFO);
            }
            servletPath = ae0Var.getServletPath();
            pathInfo = ae0Var.getPathInfo();
            String addPaths = URIUtil.addPaths(servletPath, pathInfo);
            ((!addPaths.endsWith("/") && ((this._starJspMapped && addPaths.toLowerCase().endsWith(".jsp")) || (resource = this._contextHandler.getResource(addPaths)) == null || !resource.isDirectory())) ? this._jspServlet : this._dftServlet).getServlet().service(servletRequest, servletResponse);
            return;
        }
        throw new ServletException("Request not HttpServletRequest");
    }
}
