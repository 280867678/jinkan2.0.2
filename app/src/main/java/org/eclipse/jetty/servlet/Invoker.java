package org.eclipse.jetty.servlet;

import com.umeng.analytics.pro.C1543ak;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.UnavailableException;
import javax.servlet.http.HttpServlet;
import me.tvspark.ae0;
import me.tvspark.be0;
import me.tvspark.ce0;
import me.tvspark.outline;
import org.eclipse.jetty.http.PathMap;
import org.eclipse.jetty.server.AbstractHttpConnection;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.HandlerWrapper;
import org.eclipse.jetty.util.LazyList;
import org.eclipse.jetty.util.URIUtil;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: classes5.dex */
public class Invoker extends HttpServlet {
    public static final Logger LOG = Log.getLogger(Invoker.class);
    public ContextHandler _contextHandler;
    public Map.Entry _invokerEntry;
    public boolean _nonContextServlets;
    public Map _parameters;
    public ServletHandler _servletHandler;
    public boolean _verbose;

    /* loaded from: classes5.dex */
    public class InvokedRequest extends be0 {
        public boolean _included;
        public String _pathInfo;
        public String _servletPath;

        public InvokedRequest(ae0 ae0Var, boolean z, String str, String str2, String str3) {
            super(ae0Var);
            this._included = z;
            this._servletPath = URIUtil.addPaths(str2, str);
            String substring = str3.substring(str.length() + 1);
            this._pathInfo = substring;
            if (substring.length() == 0) {
                this._pathInfo = null;
            }
        }

        @Override // javax.servlet.ServletRequestWrapper, javax.servlet.ServletRequest
        public Object getAttribute(String str) {
            if (this._included) {
                if (str.equals(RequestDispatcher.INCLUDE_REQUEST_URI)) {
                    return URIUtil.addPaths(URIUtil.addPaths(getContextPath(), this._servletPath), this._pathInfo);
                }
                if (str.equals(RequestDispatcher.INCLUDE_PATH_INFO)) {
                    return this._pathInfo;
                }
                if (str.equals(RequestDispatcher.INCLUDE_SERVLET_PATH)) {
                    return this._servletPath;
                }
            }
            return super.getAttribute(str);
        }

        @Override // me.tvspark.be0, me.tvspark.ae0
        public String getPathInfo() {
            return this._included ? super.getPathInfo() : this._pathInfo;
        }

        @Override // me.tvspark.be0, me.tvspark.ae0
        public String getServletPath() {
            return this._included ? super.getServletPath() : this._servletPath;
        }
    }

    private ServletHolder getHolder(ServletHolder[] servletHolderArr, String str) {
        ServletHolder servletHolder = null;
        if (servletHolderArr == null) {
            return null;
        }
        for (int i = 0; servletHolder == null && i < servletHolderArr.length; i++) {
            if (servletHolderArr[i].getName().equals(str)) {
                servletHolder = servletHolderArr[i];
            }
        }
        return servletHolder;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [org.eclipse.jetty.server.handler.HandlerWrapper] */
    @Override // javax.servlet.GenericServlet
    public void init() {
        Handler handler;
        ContextHandler contextHandler = ((ContextHandler.Context) getServletContext()).getContextHandler();
        this._contextHandler = contextHandler;
        ContextHandler contextHandler2 = contextHandler;
        while (true) {
            handler = contextHandler2.getHandler();
            if (handler == null || (handler instanceof ServletHandler) || !(handler instanceof HandlerWrapper)) {
                break;
            }
            contextHandler2 = (HandlerWrapper) handler;
        }
        this._servletHandler = (ServletHandler) handler;
        Enumeration<String> initParameterNames = getInitParameterNames();
        while (initParameterNames.hasMoreElements()) {
            String nextElement = initParameterNames.nextElement();
            String initParameter = getInitParameter(nextElement);
            String lowerCase = initParameter.toLowerCase(Locale.ENGLISH);
            boolean z = true;
            if ("nonContextServlets".equals(nextElement)) {
                this._nonContextServlets = initParameter.length() > 0 && lowerCase.startsWith(C1543ak.f2971aH);
            }
            if ("verbose".equals(nextElement)) {
                if (initParameter.length() <= 0 || !lowerCase.startsWith(C1543ak.f2971aH)) {
                    z = false;
                }
                this._verbose = z;
            } else {
                if (this._parameters == null) {
                    this._parameters = new HashMap();
                }
                this._parameters.put(nextElement, initParameter);
            }
        }
    }

    @Override // javax.servlet.http.HttpServlet
    public void service(ae0 ae0Var, ce0 ce0Var) throws ServletException, IOException {
        String str;
        boolean z;
        ServletHolder servletHolder;
        String str2;
        String str3 = (String) ae0Var.getAttribute(RequestDispatcher.INCLUDE_SERVLET_PATH);
        int i = 1;
        if (str3 == null) {
            str = ae0Var.getServletPath();
            z = false;
        } else {
            str = str3;
            z = true;
        }
        String str4 = (String) ae0Var.getAttribute(RequestDispatcher.INCLUDE_PATH_INFO);
        if (str4 == null) {
            str4 = ae0Var.getPathInfo();
        }
        String str5 = str4;
        if (str5 == null || str5.length() <= 1) {
            ce0Var.sendError(404);
            return;
        }
        if (str5.charAt(0) != '/') {
            i = 0;
        }
        int indexOf = str5.indexOf(47, i);
        String substring = indexOf < 0 ? str5.substring(i) : str5.substring(i, indexOf);
        ServletHolder holder = getHolder(this._servletHandler.getServlets(), substring);
        if (holder != null) {
            if (LOG.isDebugEnabled()) {
                Logger logger = LOG;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Adding servlet mapping for named servlet:", substring, ":");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(URIUtil.addPaths(str, substring));
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("/*");
                logger.debug(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), new Object[0]);
            }
            ServletMapping servletMapping = new ServletMapping();
            servletMapping.setServletName(substring);
            servletMapping.setPathSpec(URIUtil.addPaths(str, substring) + "/*");
            ServletHandler servletHandler = this._servletHandler;
            servletHandler.setServletMappings((ServletMapping[]) LazyList.addToArray(servletHandler.getServletMappings(), servletMapping, ServletMapping.class));
            str2 = substring;
        } else {
            if (substring.endsWith(".class")) {
                substring = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(substring, -6, 0);
            }
            if (substring == null || substring.length() == 0) {
                ce0Var.sendError(404);
                return;
            }
            synchronized (this._servletHandler) {
                this._invokerEntry = this._servletHandler.getHolderEntry(str);
                String addPaths = URIUtil.addPaths(str, substring);
                PathMap.Entry holderEntry = this._servletHandler.getHolderEntry(addPaths);
                if (holderEntry == null || holderEntry.equals(this._invokerEntry)) {
                    if (LOG.isDebugEnabled()) {
                        Logger logger2 = LOG;
                        logger2.debug("Making new servlet=" + substring + " with path=" + addPaths + "/*", new Object[0]);
                    }
                    ServletHandler servletHandler2 = this._servletHandler;
                    ServletHolder addServletWithMapping = servletHandler2.addServletWithMapping(substring, addPaths + "/*");
                    if (this._parameters != null) {
                        addServletWithMapping.setInitParameters(this._parameters);
                    }
                    try {
                        addServletWithMapping.start();
                        if (!this._nonContextServlets) {
                            Servlet servlet = addServletWithMapping.getServlet();
                            if (this._contextHandler.getClassLoader() != servlet.getClass().getClassLoader()) {
                                try {
                                    addServletWithMapping.stop();
                                } catch (Exception e) {
                                    LOG.ignore(e);
                                }
                                Logger logger3 = LOG;
                                logger3.warn("Dynamic servlet " + servlet + " not loaded from context " + ae0Var.getContextPath(), new Object[0]);
                                throw new UnavailableException("Not in context");
                            }
                        }
                        if (this._verbose && LOG.isDebugEnabled()) {
                            Logger logger4 = LOG;
                            logger4.debug("Dynamic load '" + substring + "' at " + addPaths, new Object[0]);
                        }
                        servletHolder = addServletWithMapping;
                    } catch (Exception e2) {
                        LOG.debug(e2);
                        throw new UnavailableException(e2.toString());
                    }
                } else {
                    servletHolder = (ServletHolder) holderEntry.getValue();
                }
            }
            str2 = substring;
            holder = servletHolder;
        }
        if (holder != null) {
            holder.handle(ae0Var instanceof Request ? (Request) ae0Var : AbstractHttpConnection.getCurrentConnection().getRequest(), new InvokedRequest(ae0Var, z, str2, str, str5), ce0Var);
            return;
        }
        LOG.info(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Can't find holder for servlet: ", str2), new Object[0]);
        ce0Var.sendError(404);
    }
}
