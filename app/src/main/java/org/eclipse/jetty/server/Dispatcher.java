package org.eclipse.jetty.server;

import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Map;
import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import me.tvspark.ae0;
import me.tvspark.ce0;
import me.tvspark.outline;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.util.Attributes;
import org.eclipse.jetty.util.LazyList;
import org.eclipse.jetty.util.MultiMap;
import org.eclipse.jetty.util.UrlEncoded;

/* loaded from: classes4.dex */
public class Dispatcher implements RequestDispatcher {
    public static final String __FORWARD_PREFIX = "javax.servlet.forward.";
    public static final String __INCLUDE_PREFIX = "javax.servlet.include.";
    public static final String __JSP_FILE = "org.apache.catalina.jsp_file";
    public final ContextHandler _contextHandler;
    public final String _dQuery;
    public final String _named;
    public final String _path;
    public final String _uri;

    /* loaded from: classes4.dex */
    public class ForwardAttributes implements Attributes {
        public final Attributes _attr;
        public String _contextPath;
        public String _pathInfo;
        public String _query;
        public String _requestURI;
        public String _servletPath;

        public ForwardAttributes(Attributes attributes) {
            this._attr = attributes;
        }

        @Override // org.eclipse.jetty.util.Attributes
        public void clearAttributes() {
            throw new IllegalStateException();
        }

        @Override // org.eclipse.jetty.util.Attributes
        public Object getAttribute(String str) {
            if (Dispatcher.this._named == null) {
                if (str.equals(RequestDispatcher.FORWARD_PATH_INFO)) {
                    return this._pathInfo;
                }
                if (str.equals(RequestDispatcher.FORWARD_REQUEST_URI)) {
                    return this._requestURI;
                }
                if (str.equals(RequestDispatcher.FORWARD_SERVLET_PATH)) {
                    return this._servletPath;
                }
                if (str.equals(RequestDispatcher.FORWARD_CONTEXT_PATH)) {
                    return this._contextPath;
                }
                if (str.equals(RequestDispatcher.FORWARD_QUERY_STRING)) {
                    return this._query;
                }
            }
            if (str.startsWith(Dispatcher.__INCLUDE_PREFIX)) {
                return null;
            }
            return this._attr.getAttribute(str);
        }

        @Override // org.eclipse.jetty.util.Attributes
        public Enumeration getAttributeNames() {
            HashSet hashSet = new HashSet();
            Enumeration<String> attributeNames = this._attr.getAttributeNames();
            while (attributeNames.hasMoreElements()) {
                String nextElement = attributeNames.nextElement();
                if (!nextElement.startsWith(Dispatcher.__INCLUDE_PREFIX) && !nextElement.startsWith(Dispatcher.__FORWARD_PREFIX)) {
                    hashSet.add(nextElement);
                }
            }
            if (Dispatcher.this._named == null) {
                if (this._pathInfo != null) {
                    hashSet.add(RequestDispatcher.FORWARD_PATH_INFO);
                } else {
                    hashSet.remove(RequestDispatcher.FORWARD_PATH_INFO);
                }
                hashSet.add(RequestDispatcher.FORWARD_REQUEST_URI);
                hashSet.add(RequestDispatcher.FORWARD_SERVLET_PATH);
                hashSet.add(RequestDispatcher.FORWARD_CONTEXT_PATH);
                if (this._query != null) {
                    hashSet.add(RequestDispatcher.FORWARD_QUERY_STRING);
                } else {
                    hashSet.remove(RequestDispatcher.FORWARD_QUERY_STRING);
                }
            }
            return Collections.enumeration(hashSet);
        }

        @Override // org.eclipse.jetty.util.Attributes
        public void removeAttribute(String str) {
            setAttribute(str, null);
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:0x0051, code lost:
            if (r3 == null) goto L29;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x005c, code lost:
            r1._attr.setAttribute(r2, r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0061, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x0056, code lost:
            r1._attr.removeAttribute(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:?, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0054, code lost:
            if (r3 == null) goto L29;
         */
        @Override // org.eclipse.jetty.util.Attributes
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void setAttribute(String str, Object obj) {
            if (Dispatcher.this._named == null && str.startsWith("javax.servlet.")) {
                if (str.equals(RequestDispatcher.FORWARD_PATH_INFO)) {
                    this._pathInfo = (String) obj;
                } else if (str.equals(RequestDispatcher.FORWARD_REQUEST_URI)) {
                    this._requestURI = (String) obj;
                } else if (str.equals(RequestDispatcher.FORWARD_SERVLET_PATH)) {
                    this._servletPath = (String) obj;
                } else if (str.equals(RequestDispatcher.FORWARD_CONTEXT_PATH)) {
                    this._contextPath = (String) obj;
                } else if (str.equals(RequestDispatcher.FORWARD_QUERY_STRING)) {
                    this._query = (String) obj;
                }
            }
        }

        public String toString() {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("FORWARD+");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._attr.toString());
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
    }

    /* loaded from: classes4.dex */
    public class IncludeAttributes implements Attributes {
        public final Attributes _attr;
        public String _contextPath;
        public String _pathInfo;
        public String _query;
        public String _requestURI;
        public String _servletPath;

        public IncludeAttributes(Attributes attributes) {
            this._attr = attributes;
        }

        @Override // org.eclipse.jetty.util.Attributes
        public void clearAttributes() {
            throw new IllegalStateException();
        }

        @Override // org.eclipse.jetty.util.Attributes
        public Object getAttribute(String str) {
            if (Dispatcher.this._named == null) {
                if (str.equals(RequestDispatcher.INCLUDE_PATH_INFO)) {
                    return this._pathInfo;
                }
                if (str.equals(RequestDispatcher.INCLUDE_SERVLET_PATH)) {
                    return this._servletPath;
                }
                if (str.equals(RequestDispatcher.INCLUDE_CONTEXT_PATH)) {
                    return this._contextPath;
                }
                if (str.equals(RequestDispatcher.INCLUDE_QUERY_STRING)) {
                    return this._query;
                }
                if (str.equals(RequestDispatcher.INCLUDE_REQUEST_URI)) {
                    return this._requestURI;
                }
            } else if (str.startsWith(Dispatcher.__INCLUDE_PREFIX)) {
                return null;
            }
            return this._attr.getAttribute(str);
        }

        @Override // org.eclipse.jetty.util.Attributes
        public Enumeration getAttributeNames() {
            HashSet hashSet = new HashSet();
            Enumeration<String> attributeNames = this._attr.getAttributeNames();
            while (attributeNames.hasMoreElements()) {
                String nextElement = attributeNames.nextElement();
                if (!nextElement.startsWith(Dispatcher.__INCLUDE_PREFIX)) {
                    hashSet.add(nextElement);
                }
            }
            if (Dispatcher.this._named == null) {
                if (this._pathInfo != null) {
                    hashSet.add(RequestDispatcher.INCLUDE_PATH_INFO);
                } else {
                    hashSet.remove(RequestDispatcher.INCLUDE_PATH_INFO);
                }
                hashSet.add(RequestDispatcher.INCLUDE_REQUEST_URI);
                hashSet.add(RequestDispatcher.INCLUDE_SERVLET_PATH);
                hashSet.add(RequestDispatcher.INCLUDE_CONTEXT_PATH);
                if (this._query != null) {
                    hashSet.add(RequestDispatcher.INCLUDE_QUERY_STRING);
                } else {
                    hashSet.remove(RequestDispatcher.INCLUDE_QUERY_STRING);
                }
            }
            return Collections.enumeration(hashSet);
        }

        @Override // org.eclipse.jetty.util.Attributes
        public void removeAttribute(String str) {
            setAttribute(str, null);
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:0x0051, code lost:
            if (r3 == null) goto L29;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x005c, code lost:
            r1._attr.setAttribute(r2, r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0061, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x0056, code lost:
            r1._attr.removeAttribute(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:?, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0054, code lost:
            if (r3 == null) goto L29;
         */
        @Override // org.eclipse.jetty.util.Attributes
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void setAttribute(String str, Object obj) {
            if (Dispatcher.this._named == null && str.startsWith("javax.servlet.")) {
                if (str.equals(RequestDispatcher.INCLUDE_PATH_INFO)) {
                    this._pathInfo = (String) obj;
                } else if (str.equals(RequestDispatcher.INCLUDE_REQUEST_URI)) {
                    this._requestURI = (String) obj;
                } else if (str.equals(RequestDispatcher.INCLUDE_SERVLET_PATH)) {
                    this._servletPath = (String) obj;
                } else if (str.equals(RequestDispatcher.INCLUDE_CONTEXT_PATH)) {
                    this._contextPath = (String) obj;
                } else if (str.equals(RequestDispatcher.INCLUDE_QUERY_STRING)) {
                    this._query = (String) obj;
                }
            }
        }

        public String toString() {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("INCLUDE+");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._attr.toString());
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
    }

    public Dispatcher(ContextHandler contextHandler, String str) throws IllegalStateException {
        this._contextHandler = contextHandler;
        this._named = str;
        this._uri = null;
        this._path = null;
        this._dQuery = null;
    }

    public Dispatcher(ContextHandler contextHandler, String str, String str2, String str3) {
        this._contextHandler = contextHandler;
        this._uri = str;
        this._path = str2;
        this._dQuery = str3;
        this._named = null;
    }

    private void commitResponse(ServletResponse servletResponse, Request request) throws IOException {
        if (request.getResponse().isWriting()) {
            try {
                servletResponse.getWriter().close();
                return;
            } catch (IllegalStateException unused) {
                servletResponse.getOutputStream().close();
                return;
            }
        }
        try {
            servletResponse.getOutputStream().close();
        } catch (IllegalStateException unused2) {
            servletResponse.getWriter().close();
        }
    }

    public void error(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        forward(servletRequest, servletResponse, DispatcherType.ERROR);
    }

    @Override // javax.servlet.RequestDispatcher
    public void forward(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        forward(servletRequest, servletResponse, DispatcherType.FORWARD);
    }

    public void forward(ServletRequest servletRequest, ServletResponse servletResponse, DispatcherType dispatcherType) throws ServletException, IOException {
        Request request = servletRequest instanceof Request ? (Request) servletRequest : AbstractHttpConnection.getCurrentConnection().getRequest();
        Response response = request.getResponse();
        servletResponse.resetBuffer();
        response.fwdReset();
        if (!(servletRequest instanceof ae0)) {
            servletRequest = new ServletRequestHttpWrapper(servletRequest);
        }
        if (!(servletResponse instanceof ce0)) {
            servletResponse = new ServletResponseHttpWrapper(servletResponse);
        }
        boolean isHandled = request.isHandled();
        String requestURI = request.getRequestURI();
        String contextPath = request.getContextPath();
        String servletPath = request.getServletPath();
        String pathInfo = request.getPathInfo();
        String queryString = request.getQueryString();
        Attributes attributes = request.getAttributes();
        DispatcherType dispatcherType2 = request.getDispatcherType();
        MultiMap<String> parameters = request.getParameters();
        try {
            request.setHandled(false);
            request.setDispatcherType(dispatcherType);
            if (this._named != null) {
                this._contextHandler.handle(this._named, request, (ae0) servletRequest, (ce0) servletResponse);
            } else {
                String str = this._dQuery;
                if (str != null) {
                    if (parameters == null) {
                        request.extractParameters();
                        parameters = request.getParameters();
                    }
                    request.mergeQueryString(str);
                }
                ForwardAttributes forwardAttributes = new ForwardAttributes(attributes);
                if (attributes.getAttribute(RequestDispatcher.FORWARD_REQUEST_URI) != null) {
                    forwardAttributes._pathInfo = (String) attributes.getAttribute(RequestDispatcher.FORWARD_PATH_INFO);
                    forwardAttributes._query = (String) attributes.getAttribute(RequestDispatcher.FORWARD_QUERY_STRING);
                    forwardAttributes._requestURI = (String) attributes.getAttribute(RequestDispatcher.FORWARD_REQUEST_URI);
                    forwardAttributes._contextPath = (String) attributes.getAttribute(RequestDispatcher.FORWARD_CONTEXT_PATH);
                    forwardAttributes._servletPath = (String) attributes.getAttribute(RequestDispatcher.FORWARD_SERVLET_PATH);
                } else {
                    forwardAttributes._pathInfo = pathInfo;
                    forwardAttributes._query = queryString;
                    forwardAttributes._requestURI = requestURI;
                    forwardAttributes._contextPath = contextPath;
                    forwardAttributes._servletPath = servletPath;
                }
                request.setRequestURI(this._uri);
                request.setContextPath(this._contextHandler.getContextPath());
                request.setServletPath(null);
                request.setPathInfo(this._uri);
                request.setAttributes(forwardAttributes);
                this._contextHandler.handle(this._path, request, (ae0) servletRequest, (ce0) servletResponse);
                if (!request.getAsyncContinuation().isAsyncStarted()) {
                    commitResponse(servletResponse, request);
                }
            }
        } finally {
            request.setHandled(isHandled);
            request.setRequestURI(requestURI);
            request.setContextPath(contextPath);
            request.setServletPath(servletPath);
            request.setPathInfo(pathInfo);
            request.setAttributes(attributes);
            request.setParameters(parameters);
            request.setQueryString(queryString);
            request.setDispatcherType(dispatcherType2);
        }
    }

    @Override // javax.servlet.RequestDispatcher
    public void include(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        ContextHandler contextHandler;
        String str;
        ae0 ae0Var;
        ce0 ce0Var;
        Request request = servletRequest instanceof Request ? (Request) servletRequest : AbstractHttpConnection.getCurrentConnection().getRequest();
        if (!(servletRequest instanceof ae0)) {
            servletRequest = new ServletRequestHttpWrapper(servletRequest);
        }
        if (!(servletResponse instanceof ce0)) {
            servletResponse = new ServletResponseHttpWrapper(servletResponse);
        }
        DispatcherType dispatcherType = request.getDispatcherType();
        Attributes attributes = request.getAttributes();
        MultiMap<String> parameters = request.getParameters();
        try {
            request.setDispatcherType(DispatcherType.INCLUDE);
            request.getConnection().include();
            if (this._named != null) {
                contextHandler = this._contextHandler;
                str = this._named;
                ae0Var = (ae0) servletRequest;
                ce0Var = (ce0) servletResponse;
            } else {
                String str2 = this._dQuery;
                if (str2 != null) {
                    if (parameters == null) {
                        request.extractParameters();
                        parameters = request.getParameters();
                    }
                    MultiMap multiMap = new MultiMap();
                    UrlEncoded.decodeTo(str2, multiMap, request.getCharacterEncoding());
                    if (parameters != null && parameters.size() > 0) {
                        for (Map.Entry<String, Object> entry : parameters.entrySet()) {
                            String key = entry.getKey();
                            Object value = entry.getValue();
                            for (int i = 0; i < LazyList.size(value); i++) {
                                multiMap.add(key, LazyList.get(value, i));
                            }
                        }
                    }
                    request.setParameters(multiMap);
                }
                IncludeAttributes includeAttributes = new IncludeAttributes(attributes);
                includeAttributes._requestURI = this._uri;
                includeAttributes._contextPath = this._contextHandler.getContextPath();
                includeAttributes._servletPath = null;
                includeAttributes._pathInfo = this._path;
                includeAttributes._query = str2;
                request.setAttributes(includeAttributes);
                contextHandler = this._contextHandler;
                str = this._path;
                ae0Var = (ae0) servletRequest;
                ce0Var = (ce0) servletResponse;
            }
            contextHandler.handle(str, request, ae0Var, ce0Var);
        } finally {
            request.setAttributes(attributes);
            request.getConnection().included();
            request.setParameters(parameters);
            request.setDispatcherType(dispatcherType);
        }
    }
}
