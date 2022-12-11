package org.eclipse.jetty.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletSecurityElement;
import javax.servlet.UnavailableException;
import me.tvspark.ae0;
import me.tvspark.ce0;
import me.tvspark.outline;
import org.eclipse.jetty.continuation.ContinuationThrowable;
import org.eclipse.jetty.http.HttpException;
import org.eclipse.jetty.http.PathMap;
import org.eclipse.jetty.p059io.EofException;
import org.eclipse.jetty.p059io.RuntimeIOException;
import org.eclipse.jetty.security.IdentityService;
import org.eclipse.jetty.security.SecurityHandler;
import org.eclipse.jetty.server.AbstractHttpConnection;
import org.eclipse.jetty.server.AsyncContinuation;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServletRequestHttpWrapper;
import org.eclipse.jetty.server.ServletResponseHttpWrapper;
import org.eclipse.jetty.server.UserIdentity;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.ScopedHandler;
import org.eclipse.jetty.servlet.Holder;
import org.eclipse.jetty.util.LazyList;
import org.eclipse.jetty.util.MultiException;
import org.eclipse.jetty.util.MultiMap;
import org.eclipse.jetty.util.TypeUtil;
import org.eclipse.jetty.util.URIUtil;
import org.eclipse.jetty.util.component.AggregateLifeCycle;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: classes5.dex */
public class ServletHandler extends ScopedHandler {
    public static final Logger LOG;
    public static final Logger LOG_UNHANDLED;
    public static final String __DEFAULT_SERVLET = "default";
    public ServletContextHandler _contextHandler;
    public FilterMapping[] _filterMappings;
    public MultiMap<String> _filterNameMappings;
    public List<FilterMapping> _filterPathMappings;
    public IdentityService _identityService;
    public ContextHandler.Context _servletContext;
    public ServletMapping[] _servletMappings;
    public PathMap _servletPathMap;
    public FilterHolder[] _filters = new FilterHolder[0];
    public int _matchBeforeIndex = -1;
    public int _matchAfterIndex = -1;
    public boolean _filterChainsCached = true;
    public int _maxFilterChainsCacheSize = 512;
    public boolean _startWithUnavailable = false;
    public ServletHolder[] _servlets = new ServletHolder[0];
    public final Map<String, FilterHolder> _filterNameMap = new HashMap();
    public final Map<String, ServletHolder> _servletNameMap = new HashMap();
    public final ConcurrentMap<String, FilterChain>[] _chainCache = new ConcurrentMap[31];
    public final Queue<String>[] _chainLRU = new Queue[31];

    /* loaded from: classes5.dex */
    public class CachedChain implements FilterChain {
        public FilterHolder _filterHolder;
        public CachedChain _next;
        public ServletHolder _servletHolder;

        public CachedChain(Object obj, ServletHolder servletHolder) {
            if (LazyList.size(obj) <= 0) {
                this._servletHolder = servletHolder;
                return;
            }
            this._filterHolder = (FilterHolder) LazyList.get(obj, 0);
            this._next = ServletHandler.this.newCachedChain(LazyList.remove(obj, 0), servletHolder);
        }

        @Override // javax.servlet.FilterChain
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException, ServletException {
            Request request = servletRequest instanceof Request ? (Request) servletRequest : AbstractHttpConnection.getCurrentConnection().getRequest();
            if (this._filterHolder == null) {
                ae0 ae0Var = (ae0) servletRequest;
                if (this._servletHolder == null) {
                    if (ServletHandler.this.getHandler() == null) {
                        ServletHandler.this.notFound(ae0Var, (ce0) servletResponse);
                        return;
                    } else {
                        ServletHandler.this.nextHandle(URIUtil.addPaths(ae0Var.getServletPath(), ae0Var.getPathInfo()), request, ae0Var, (ce0) servletResponse);
                        return;
                    }
                }
                if (ServletHandler.LOG.isDebugEnabled()) {
                    Logger logger = ServletHandler.LOG;
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("call servlet ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._servletHolder);
                    logger.debug(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), new Object[0]);
                }
                this._servletHolder.handle(request, servletRequest, servletResponse);
                return;
            }
            if (ServletHandler.LOG.isDebugEnabled()) {
                Logger logger2 = ServletHandler.LOG;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("call filter ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this._filterHolder);
                logger2.debug(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString(), new Object[0]);
            }
            Filter filter = this._filterHolder.getFilter();
            if (this._filterHolder.isAsyncSupported() || !request.isAsyncSupported()) {
                filter.doFilter(servletRequest, servletResponse, this._next);
                return;
            }
            try {
                request.setAsyncSupported(false);
                filter.doFilter(servletRequest, servletResponse, this._next);
            } finally {
                request.setAsyncSupported(true);
            }
        }

        public String toString() {
            if (this._filterHolder == null) {
                ServletHolder servletHolder = this._servletHolder;
                return servletHolder != null ? servletHolder.toString() : "null";
            }
            return this._filterHolder + "->" + this._next.toString();
        }
    }

    /* loaded from: classes5.dex */
    public class Chain implements FilterChain {
        public final Request _baseRequest;
        public final Object _chain;
        public int _filter = 0;
        public final ServletHolder _servletHolder;

        public Chain(Request request, Object obj, ServletHolder servletHolder) {
            this._baseRequest = request;
            this._chain = obj;
            this._servletHolder = servletHolder;
        }

        @Override // javax.servlet.FilterChain
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException, ServletException {
            if (ServletHandler.LOG.isDebugEnabled()) {
                Logger logger = ServletHandler.LOG;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("doFilter ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._filter);
                logger.debug(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), new Object[0]);
            }
            if (this._filter >= LazyList.size(this._chain)) {
                ae0 ae0Var = (ae0) servletRequest;
                if (this._servletHolder == null) {
                    if (ServletHandler.this.getHandler() == null) {
                        ServletHandler.this.notFound(ae0Var, (ce0) servletResponse);
                        return;
                    } else {
                        ServletHandler.this.nextHandle(URIUtil.addPaths(ae0Var.getServletPath(), ae0Var.getPathInfo()), servletRequest instanceof Request ? (Request) servletRequest : AbstractHttpConnection.getCurrentConnection().getRequest(), ae0Var, (ce0) servletResponse);
                        return;
                    }
                }
                if (ServletHandler.LOG.isDebugEnabled()) {
                    Logger logger2 = ServletHandler.LOG;
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("call servlet ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this._servletHolder);
                    logger2.debug(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString(), new Object[0]);
                }
                this._servletHolder.handle(this._baseRequest, servletRequest, servletResponse);
                return;
            }
            Object obj = this._chain;
            int i = this._filter;
            this._filter = i + 1;
            FilterHolder filterHolder = (FilterHolder) LazyList.get(obj, i);
            if (ServletHandler.LOG.isDebugEnabled()) {
                Logger logger3 = ServletHandler.LOG;
                logger3.debug("call filter " + filterHolder, new Object[0]);
            }
            Filter filter = filterHolder.getFilter();
            if (filterHolder.isAsyncSupported() || !this._baseRequest.isAsyncSupported()) {
                filter.doFilter(servletRequest, servletResponse, this);
                return;
            }
            try {
                this._baseRequest.setAsyncSupported(false);
                filter.doFilter(servletRequest, servletResponse, this);
            } finally {
                this._baseRequest.setAsyncSupported(true);
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < LazyList.size(this._chain); i++) {
                sb.append(LazyList.get(this._chain, i).toString());
                sb.append("->");
            }
            sb.append(this._servletHolder);
            return sb.toString();
        }
    }

    static {
        Logger logger = Log.getLogger(ServletHandler.class);
        LOG = logger;
        LOG_UNHANDLED = logger.getLogger("unhandled");
    }

    public FilterHolder addFilter(String str, String str2, EnumSet<DispatcherType> enumSet) {
        return addFilterWithMapping(str, str2, enumSet);
    }

    public void addFilter(FilterHolder filterHolder) {
        if (filterHolder != null) {
            setFilters((FilterHolder[]) LazyList.addToArray(getFilters(), filterHolder, FilterHolder.class));
        }
    }

    public void addFilter(FilterHolder filterHolder, FilterMapping filterMapping) {
        if (filterHolder != null) {
            setFilters((FilterHolder[]) LazyList.addToArray(getFilters(), filterHolder, FilterHolder.class));
        }
        if (filterMapping != null) {
            addFilterMapping(filterMapping);
        }
    }

    public void addFilterMapping(FilterMapping filterMapping) {
        if (filterMapping != null) {
            Holder.Source source = filterMapping.getFilterHolder() == null ? null : filterMapping.getFilterHolder().getSource();
            FilterMapping[] filterMappings = getFilterMappings();
            if (filterMappings == null || filterMappings.length == 0) {
                setFilterMappings(insertFilterMapping(filterMapping, 0, false));
                if (source == null || source != Holder.Source.JAVAX_API) {
                    return;
                }
                this._matchAfterIndex = 0;
            } else if (source != null && Holder.Source.JAVAX_API == source) {
                setFilterMappings(insertFilterMapping(filterMapping, filterMappings.length - 1, false));
                if (this._matchAfterIndex >= 0) {
                    return;
                }
                this._matchAfterIndex = getFilterMappings().length - 1;
            } else {
                int i = this._matchAfterIndex;
                if (i < 0) {
                    setFilterMappings(insertFilterMapping(filterMapping, filterMappings.length - 1, false));
                    return;
                }
                FilterMapping[] insertFilterMapping = insertFilterMapping(filterMapping, i, true);
                this._matchAfterIndex++;
                setFilterMappings(insertFilterMapping);
            }
        }
    }

    public FilterHolder addFilterWithMapping(Class<? extends Filter> cls, String str, int i) {
        FilterHolder newFilterHolder = newFilterHolder(Holder.Source.EMBEDDED);
        newFilterHolder.setHeldClass(cls);
        addFilterWithMapping(newFilterHolder, str, i);
        return newFilterHolder;
    }

    public FilterHolder addFilterWithMapping(Class<? extends Filter> cls, String str, EnumSet<DispatcherType> enumSet) {
        FilterHolder newFilterHolder = newFilterHolder(Holder.Source.EMBEDDED);
        newFilterHolder.setHeldClass(cls);
        addFilterWithMapping(newFilterHolder, str, enumSet);
        return newFilterHolder;
    }

    public FilterHolder addFilterWithMapping(String str, String str2, int i) {
        FilterHolder newFilterHolder = newFilterHolder(Holder.Source.EMBEDDED);
        newFilterHolder.setClassName(str);
        addFilterWithMapping(newFilterHolder, str2, i);
        return newFilterHolder;
    }

    public FilterHolder addFilterWithMapping(String str, String str2, EnumSet<DispatcherType> enumSet) {
        FilterHolder newFilterHolder = newFilterHolder(Holder.Source.EMBEDDED);
        newFilterHolder.setClassName(str);
        addFilterWithMapping(newFilterHolder, str2, enumSet);
        return newFilterHolder;
    }

    public void addFilterWithMapping(FilterHolder filterHolder, String str, int i) {
        FilterHolder[] filters = getFilters();
        if (filters != null) {
            filters = (FilterHolder[]) filters.clone();
        }
        try {
            setFilters((FilterHolder[]) LazyList.addToArray(filters, filterHolder, FilterHolder.class));
            FilterMapping filterMapping = new FilterMapping();
            filterMapping.setFilterName(filterHolder.getName());
            filterMapping.setPathSpec(str);
            filterMapping.setDispatches(i);
            addFilterMapping(filterMapping);
        } catch (Error e) {
            setFilters(filters);
            throw e;
        } catch (RuntimeException e2) {
            setFilters(filters);
            throw e2;
        }
    }

    public void addFilterWithMapping(FilterHolder filterHolder, String str, EnumSet<DispatcherType> enumSet) {
        FilterHolder[] filters = getFilters();
        if (filters != null) {
            filters = (FilterHolder[]) filters.clone();
        }
        try {
            setFilters((FilterHolder[]) LazyList.addToArray(filters, filterHolder, FilterHolder.class));
            FilterMapping filterMapping = new FilterMapping();
            filterMapping.setFilterName(filterHolder.getName());
            filterMapping.setPathSpec(str);
            filterMapping.setDispatcherTypes(enumSet);
            addFilterMapping(filterMapping);
        } catch (Error e) {
            setFilters(filters);
            throw e;
        } catch (RuntimeException e2) {
            setFilters(filters);
            throw e2;
        }
    }

    public void addServlet(ServletHolder servletHolder) {
        setServlets((ServletHolder[]) LazyList.addToArray(getServlets(), servletHolder, ServletHolder.class));
    }

    public void addServletMapping(ServletMapping servletMapping) {
        setServletMappings((ServletMapping[]) LazyList.addToArray(getServletMappings(), servletMapping, ServletMapping.class));
    }

    public ServletHolder addServletWithMapping(Class<? extends Servlet> cls, String str) {
        ServletHolder newServletHolder = newServletHolder(Holder.Source.EMBEDDED);
        newServletHolder.setHeldClass(cls);
        addServletWithMapping(newServletHolder, str);
        return newServletHolder;
    }

    public ServletHolder addServletWithMapping(String str, String str2) {
        ServletHolder newServletHolder = newServletHolder(Holder.Source.EMBEDDED);
        newServletHolder.setClassName(str);
        addServletWithMapping(newServletHolder, str2);
        return newServletHolder;
    }

    public void addServletWithMapping(ServletHolder servletHolder, String str) {
        ServletHolder[] servlets = getServlets();
        if (servlets != null) {
            servlets = (ServletHolder[]) servlets.clone();
        }
        try {
            setServlets((ServletHolder[]) LazyList.addToArray(servlets, servletHolder, ServletHolder.class));
            ServletMapping servletMapping = new ServletMapping();
            servletMapping.setServletName(servletHolder.getName());
            servletMapping.setPathSpec(str);
            setServletMappings((ServletMapping[]) LazyList.addToArray(getServletMappings(), servletMapping, ServletMapping.class));
        } catch (Exception e) {
            setServlets(servlets);
            if (!(e instanceof RuntimeException)) {
                throw new RuntimeException(e);
            }
            throw ((RuntimeException) e);
        }
    }

    public void destroyFilter(Filter filter) {
        ServletContextHandler servletContextHandler = this._contextHandler;
        if (servletContextHandler != null) {
            servletContextHandler.destroyFilter(filter);
        }
    }

    public void destroyServlet(Servlet servlet) {
        ServletContextHandler servletContextHandler = this._contextHandler;
        if (servletContextHandler != null) {
            servletContextHandler.destroyServlet(servlet);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0208 A[Catch: all -> 0x0089, TryCatch #3 {all -> 0x0089, blocks: (B:12:0x0051, B:14:0x0057, B:20:0x005b, B:21:0x005f, B:23:0x0063, B:24:0x006c, B:26:0x0070, B:28:0x007b, B:29:0x007f, B:118:0x008e, B:120:0x0096, B:123:0x009f, B:46:0x00fe, B:48:0x0106, B:50:0x010e, B:52:0x0112, B:54:0x0116, B:57:0x011b, B:58:0x011d, B:59:0x011e, B:60:0x0120, B:61:0x0121, B:62:0x0123, B:67:0x0143, B:69:0x0147, B:71:0x014b, B:73:0x014f, B:75:0x0157, B:76:0x01af, B:78:0x01bf, B:80:0x01c3, B:82:0x01cc, B:90:0x01d2, B:91:0x01d8, B:92:0x01dc, B:93:0x016c, B:95:0x0170, B:98:0x0175, B:100:0x019e, B:101:0x01a4, B:102:0x01a8, B:103:0x0200, B:104:0x0203, B:105:0x0204, B:106:0x0207, B:107:0x0208, B:108:0x020b, B:115:0x0210, B:43:0x0212, B:137:0x0214), top: B:10:0x004f, inners: #6, #7, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0147 A[Catch: all -> 0x0089, TryCatch #3 {all -> 0x0089, blocks: (B:12:0x0051, B:14:0x0057, B:20:0x005b, B:21:0x005f, B:23:0x0063, B:24:0x006c, B:26:0x0070, B:28:0x007b, B:29:0x007f, B:118:0x008e, B:120:0x0096, B:123:0x009f, B:46:0x00fe, B:48:0x0106, B:50:0x010e, B:52:0x0112, B:54:0x0116, B:57:0x011b, B:58:0x011d, B:59:0x011e, B:60:0x0120, B:61:0x0121, B:62:0x0123, B:67:0x0143, B:69:0x0147, B:71:0x014b, B:73:0x014f, B:75:0x0157, B:76:0x01af, B:78:0x01bf, B:80:0x01c3, B:82:0x01cc, B:90:0x01d2, B:91:0x01d8, B:92:0x01dc, B:93:0x016c, B:95:0x0170, B:98:0x0175, B:100:0x019e, B:101:0x01a4, B:102:0x01a8, B:103:0x0200, B:104:0x0203, B:105:0x0204, B:106:0x0207, B:107:0x0208, B:108:0x020b, B:115:0x0210, B:43:0x0212, B:137:0x0214), top: B:10:0x004f, inners: #6, #7, #6 }] */
    @Override // org.eclipse.jetty.server.handler.ScopedHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void doHandle(String str, Request request, ae0 ae0Var, ce0 ce0Var) throws IOException, ServletException {
        FilterMapping[] filterMappingArr;
        FilterChain filterChain;
        Exception exc;
        Logger logger;
        String requestURI;
        FilterMapping[] filterMappingArr2;
        DispatcherType dispatcherType = request.getDispatcherType();
        ServletHolder servletHolder = (ServletHolder) request.getUserIdentityScope();
        FilterChain filterChain2 = null;
        if (str.startsWith("/")) {
            if (servletHolder != null && (filterMappingArr2 = this._filterMappings) != null && filterMappingArr2.length > 0) {
                filterChain = getFilterChain(request, str, servletHolder);
            }
            filterChain = null;
        } else {
            if (servletHolder != null && (filterMappingArr = this._filterMappings) != null && filterMappingArr.length > 0) {
                filterChain = getFilterChain(request, null, servletHolder);
            }
            filterChain = null;
        }
        LOG.debug("chain={}", filterChain);
        try {
            try {
                try {
                    try {
                        try {
                            if (servletHolder != null) {
                                ServletRequest request2 = ae0Var instanceof ServletRequestHttpWrapper ? ((ServletRequestHttpWrapper) ae0Var).getRequest() : ae0Var;
                                ServletResponse response = ce0Var instanceof ServletResponseHttpWrapper ? ((ServletResponseHttpWrapper) ce0Var).getResponse() : ce0Var;
                                if (filterChain != null) {
                                    filterChain.doFilter(request2, response);
                                } else {
                                    servletHolder.handle(request, request2, response);
                                }
                            } else if (getHandler() == null) {
                                notFound(ae0Var, ce0Var);
                            } else {
                                nextHandle(str, request, ae0Var, ce0Var);
                            }
                            if (servletHolder == null) {
                                return;
                            }
                            request.setHandled(true);
                        } catch (Throwable th) {
                            th = th;
                            if (servletHolder != null) {
                                request.setHandled(true);
                            }
                            if (filterChain2 != null && ae0Var.isAsyncStarted()) {
                                ((AsyncContinuation) ae0Var.getAsyncContext()).errorComplete();
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        filterChain2 = filterChain;
                        if (servletHolder != null) {
                        }
                        if (filterChain2 != null) {
                            ((AsyncContinuation) ae0Var.getAsyncContext()).errorComplete();
                        }
                        throw th;
                    }
                } catch (RuntimeIOException e) {
                    throw e;
                }
            } catch (Exception e2) {
                if (!DispatcherType.REQUEST.equals(dispatcherType) && !DispatcherType.ASYNC.equals(dispatcherType)) {
                    if (e2 instanceof IOException) {
                        throw ((IOException) e2);
                    }
                    if (e2 instanceof RuntimeException) {
                        throw ((RuntimeException) e2);
                    }
                    if (e2 instanceof ServletException) {
                        throw ((ServletException) e2);
                    }
                }
                if (e2 instanceof UnavailableException) {
                    LOG.debug(e2);
                } else if (e2 instanceof ServletException) {
                    LOG.warn(e2);
                    Throwable rootCause = ((ServletException) e2).getRootCause();
                    if (rootCause != null) {
                        exc = rootCause;
                        if (!(exc instanceof HttpException)) {
                            throw ((HttpException) exc);
                        }
                        if (exc instanceof RuntimeIOException) {
                            throw ((RuntimeIOException) exc);
                        }
                        if (exc instanceof EofException) {
                            throw ((EofException) exc);
                        }
                        if (LOG.isDebugEnabled()) {
                            LOG.warn(ae0Var.getRequestURI(), exc);
                            LOG.debug(ae0Var.toString(), new Object[0]);
                        } else {
                            if (!(exc instanceof IOException) && !(exc instanceof UnavailableException)) {
                                LOG.warn("Error Processing URI: {} - ({}) {}", ae0Var.getRequestURI(), exc.getClass().getName(), exc.getMessage());
                                if (LOG_UNHANDLED.isDebugEnabled()) {
                                    logger = LOG_UNHANDLED;
                                    requestURI = ae0Var.getRequestURI();
                                    logger.debug(requestURI, exc);
                                }
                            }
                            logger = LOG;
                            requestURI = ae0Var.getRequestURI();
                            logger.debug(requestURI, exc);
                        }
                        ae0Var.setAttribute(RequestDispatcher.ERROR_EXCEPTION_TYPE, exc.getClass());
                        ae0Var.setAttribute(RequestDispatcher.ERROR_EXCEPTION, exc);
                        if (ce0Var.isCommitted()) {
                            LOG.debug("Response already committed for handling " + exc, new Object[0]);
                        } else if (!(exc instanceof UnavailableException)) {
                            ce0Var.sendError(500);
                        } else if (((UnavailableException) exc).isPermanent()) {
                            ce0Var.sendError(404);
                        } else {
                            ce0Var.sendError(503);
                        }
                        if (servletHolder != null) {
                            request.setHandled(true);
                        }
                        if (!ae0Var.isAsyncStarted()) {
                            return;
                        }
                        ((AsyncContinuation) ae0Var.getAsyncContext()).errorComplete();
                    }
                }
                exc = e2;
                if (!(exc instanceof HttpException)) {
                }
            } catch (ContinuationThrowable e3) {
                throw e3;
            }
        } catch (Error e4) {
            if (!DispatcherType.REQUEST.equals(dispatcherType) && !DispatcherType.ASYNC.equals(dispatcherType)) {
                throw e4;
            }
            LOG.warn("Error for " + ae0Var.getRequestURI(), e4);
            if (LOG.isDebugEnabled()) {
                LOG.debug(ae0Var.toString(), new Object[0]);
            }
            ae0Var.setAttribute(RequestDispatcher.ERROR_EXCEPTION_TYPE, e4.getClass());
            ae0Var.setAttribute(RequestDispatcher.ERROR_EXCEPTION, e4);
            if (!ce0Var.isCommitted()) {
                ce0Var.sendError(500);
            } else {
                LOG.debug("Response already committed for handling ", e4);
            }
            if (servletHolder != null) {
                request.setHandled(true);
            }
            if (!ae0Var.isAsyncStarted()) {
                return;
            }
            ((AsyncContinuation) ae0Var.getAsyncContext()).errorComplete();
        } catch (EofException e5) {
            throw e5;
        }
    }

    @Override // org.eclipse.jetty.server.handler.ScopedHandler
    public void doScope(String str, Request request, ae0 ae0Var, ce0 ce0Var) throws IOException, ServletException {
        UserIdentity.Scope scope;
        String servletPath = request.getServletPath();
        String pathInfo = request.getPathInfo();
        DispatcherType dispatcherType = request.getDispatcherType();
        UserIdentity.Scope scope2 = null;
        if (str.startsWith("/")) {
            PathMap.Entry holderEntry = getHolderEntry(str);
            if (holderEntry != null) {
                scope = (ServletHolder) holderEntry.getValue();
                String str2 = (String) holderEntry.getKey();
                String mapped = holderEntry.getMapped() != null ? holderEntry.getMapped() : PathMap.pathMatch(str2, str);
                String pathInfo2 = PathMap.pathInfo(str2, str);
                if (DispatcherType.INCLUDE.equals(dispatcherType)) {
                    request.setAttribute(RequestDispatcher.INCLUDE_SERVLET_PATH, mapped);
                    request.setAttribute(RequestDispatcher.INCLUDE_PATH_INFO, pathInfo2);
                } else {
                    request.setServletPath(mapped);
                    request.setPathInfo(pathInfo2);
                }
            } else {
                scope = scope2;
            }
        } else {
            scope = (ServletHolder) this._servletNameMap.get(str);
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug("servlet {}|{}|{} -> {}", request.getContextPath(), request.getServletPath(), request.getPathInfo(), scope);
        }
        try {
            scope2 = request.getUserIdentityScope();
            request.setUserIdentityScope(scope);
            if (never()) {
                nextScope(str, request, ae0Var, ce0Var);
            } else if (this._nextScope != null) {
                this._nextScope.doScope(str, request, ae0Var, ce0Var);
            } else if (this._outerScope != null) {
                this._outerScope.doHandle(str, request, ae0Var, ce0Var);
            } else {
                doHandle(str, request, ae0Var, ce0Var);
            }
        } finally {
            if (scope2 != null) {
                request.setUserIdentityScope(scope2);
            }
            if (!DispatcherType.INCLUDE.equals(dispatcherType)) {
                request.setServletPath(servletPath);
                request.setPathInfo(pathInfo);
            }
        }
    }

    @Override // org.eclipse.jetty.server.handler.ScopedHandler, org.eclipse.jetty.server.handler.HandlerWrapper, org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.util.component.AggregateLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public synchronized void doStart() throws Exception {
        SecurityHandler securityHandler;
        ContextHandler.Context currentContext = ContextHandler.getCurrentContext();
        this._servletContext = currentContext;
        ServletContextHandler servletContextHandler = (ServletContextHandler) (currentContext == null ? null : currentContext.getContextHandler());
        this._contextHandler = servletContextHandler;
        if (servletContextHandler != null && (securityHandler = (SecurityHandler) servletContextHandler.getChildHandlerByClass(SecurityHandler.class)) != null) {
            this._identityService = securityHandler.getIdentityService();
        }
        updateNameMappings();
        updateMappings();
        if (this._filterChainsCached) {
            this._chainCache[1] = new ConcurrentHashMap();
            this._chainCache[2] = new ConcurrentHashMap();
            this._chainCache[4] = new ConcurrentHashMap();
            this._chainCache[8] = new ConcurrentHashMap();
            this._chainCache[16] = new ConcurrentHashMap();
            this._chainLRU[1] = new ConcurrentLinkedQueue();
            this._chainLRU[2] = new ConcurrentLinkedQueue();
            this._chainLRU[4] = new ConcurrentLinkedQueue();
            this._chainLRU[8] = new ConcurrentLinkedQueue();
            this._chainLRU[16] = new ConcurrentLinkedQueue();
        }
        super.doStart();
        if (this._contextHandler == null || !(this._contextHandler instanceof ServletContextHandler)) {
            initialize();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00a5 A[Catch: all -> 0x0121, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0013, B:9:0x001a, B:10:0x002a, B:12:0x0036, B:13:0x0047, B:15:0x004d, B:18:0x0065, B:24:0x0069, B:28:0x0023, B:30:0x0072, B:32:0x0089, B:35:0x008d, B:36:0x0092, B:38:0x00a5, B:42:0x00ac, B:43:0x00bc, B:45:0x00c8, B:46:0x00d9, B:48:0x00df, B:51:0x00f7, B:57:0x00fb, B:61:0x00b5, B:63:0x0104), top: B:2:0x0001, inners: #1, #2 }] */
    @Override // org.eclipse.jetty.server.handler.HandlerWrapper, org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.util.component.AggregateLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void doStop() throws Exception {
        int i;
        super.doStop();
        ArrayList arrayList = new ArrayList();
        List array2List = LazyList.array2List(this._filterMappings);
        if (this._filters != null) {
            int length = this._filters.length;
            while (true) {
                int i2 = length - 1;
                if (length <= 0) {
                    break;
                }
                try {
                    this._filters[i2].stop();
                } catch (Exception e) {
                    LOG.warn(Log.EXCEPTION, e);
                }
                if (this._filters[i2].getSource() != Holder.Source.EMBEDDED) {
                    this._filterNameMap.remove(this._filters[i2].getName());
                    ListIterator listIterator = array2List.listIterator();
                    while (listIterator.hasNext()) {
                        if (((FilterMapping) listIterator.next()).getFilterName().equals(this._filters[i2].getName())) {
                            listIterator.remove();
                        }
                    }
                } else {
                    arrayList.add(this._filters[i2]);
                }
                length = i2;
            }
        }
        this._filters = (FilterHolder[]) LazyList.toArray(arrayList, FilterHolder.class);
        FilterMapping[] filterMappingArr = (FilterMapping[]) LazyList.toArray(array2List, FilterMapping.class);
        this._filterMappings = filterMappingArr;
        if (filterMappingArr != null && filterMappingArr.length != 0) {
            i = filterMappingArr.length - 1;
            this._matchAfterIndex = i;
            this._matchBeforeIndex = -1;
            ArrayList arrayList2 = new ArrayList();
            List array2List2 = LazyList.array2List(this._servletMappings);
            if (this._servlets != null) {
                int length2 = this._servlets.length;
                while (true) {
                    int i3 = length2 - 1;
                    if (length2 <= 0) {
                        break;
                    }
                    try {
                        this._servlets[i3].stop();
                    } catch (Exception e2) {
                        LOG.warn(Log.EXCEPTION, e2);
                    }
                    if (this._servlets[i3].getSource() != Holder.Source.EMBEDDED) {
                        this._servletNameMap.remove(this._servlets[i3].getName());
                        ListIterator listIterator2 = array2List2.listIterator();
                        while (listIterator2.hasNext()) {
                            if (((ServletMapping) listIterator2.next()).getServletName().equals(this._servlets[i3].getName())) {
                                listIterator2.remove();
                            }
                        }
                    } else {
                        arrayList2.add(this._servlets[i3]);
                    }
                    length2 = i3;
                }
            }
            this._servlets = (ServletHolder[]) LazyList.toArray(arrayList2, ServletHolder.class);
            this._servletMappings = (ServletMapping[]) LazyList.toArray(array2List2, ServletMapping.class);
            this._filterPathMappings = null;
            this._filterNameMappings = null;
            this._servletPathMap = null;
        }
        i = -1;
        this._matchAfterIndex = i;
        this._matchBeforeIndex = -1;
        ArrayList arrayList22 = new ArrayList();
        List array2List22 = LazyList.array2List(this._servletMappings);
        if (this._servlets != null) {
        }
        this._servlets = (ServletHolder[]) LazyList.toArray(arrayList22, ServletHolder.class);
        this._servletMappings = (ServletMapping[]) LazyList.toArray(array2List22, ServletMapping.class);
        this._filterPathMappings = null;
        this._filterNameMappings = null;
        this._servletPathMap = null;
    }

    @Override // org.eclipse.jetty.server.handler.AbstractHandlerContainer, org.eclipse.jetty.util.component.AggregateLifeCycle, org.eclipse.jetty.util.component.Dumpable
    public void dump(Appendable appendable, String str) throws IOException {
        super.dumpThis(appendable);
        AggregateLifeCycle.dump(appendable, str, TypeUtil.asList(getHandlers()), getBeans(), TypeUtil.asList(getFilterMappings()), TypeUtil.asList(getFilters()), TypeUtil.asList(getServletMappings()), TypeUtil.asList(getServlets()));
    }

    public Object getContextLog() {
        return null;
    }

    public FilterHolder getFilter(String str) {
        return this._filterNameMap.get(str);
    }

    public FilterChain getFilterChain(Request request, String str, ServletHolder servletHolder) {
        Object obj;
        MultiMap<String> multiMap;
        ConcurrentMap<String, FilterChain>[] concurrentMapArr;
        FilterChain filterChain;
        String name = str == null ? servletHolder.getName() : str;
        int dispatch = FilterMapping.dispatch(request.getDispatcherType());
        if (!this._filterChainsCached || (concurrentMapArr = this._chainCache) == null || (filterChain = concurrentMapArr[dispatch].get(name)) == null) {
            CachedChain cachedChain = null;
            if (str == null || this._filterPathMappings == null) {
                obj = null;
            } else {
                obj = null;
                for (int i = 0; i < this._filterPathMappings.size(); i++) {
                    FilterMapping filterMapping = this._filterPathMappings.get(i);
                    if (filterMapping.appliesTo(str, dispatch)) {
                        obj = LazyList.add(obj, filterMapping.getFilterHolder());
                    }
                }
            }
            if (servletHolder != null && (multiMap = this._filterNameMappings) != null && multiMap.size() > 0 && this._filterNameMappings.size() > 0) {
                Object obj2 = this._filterNameMappings.get(servletHolder.getName());
                for (int i2 = 0; i2 < LazyList.size(obj2); i2++) {
                    FilterMapping filterMapping2 = (FilterMapping) LazyList.get(obj2, i2);
                    if (filterMapping2.appliesTo(dispatch)) {
                        obj = LazyList.add(obj, filterMapping2.getFilterHolder());
                    }
                }
                Object obj3 = this._filterNameMappings.get("*");
                for (int i3 = 0; i3 < LazyList.size(obj3); i3++) {
                    FilterMapping filterMapping3 = (FilterMapping) LazyList.get(obj3, i3);
                    if (filterMapping3.appliesTo(dispatch)) {
                        obj = LazyList.add(obj, filterMapping3.getFilterHolder());
                    }
                }
            }
            if (obj == null) {
                return null;
            }
            if (!this._filterChainsCached) {
                if (LazyList.size(obj) <= 0) {
                    return null;
                }
                return new Chain(request, obj, servletHolder);
            }
            if (LazyList.size(obj) > 0) {
                cachedChain = newCachedChain(obj, servletHolder);
            }
            ConcurrentMap<String, FilterChain> concurrentMap = this._chainCache[dispatch];
            Queue<String> queue = this._chainLRU[dispatch];
            while (true) {
                if (this._maxFilterChainsCacheSize <= 0 || concurrentMap.size() < this._maxFilterChainsCacheSize) {
                    break;
                }
                String poll = queue.poll();
                if (poll == null) {
                    concurrentMap.clear();
                    break;
                }
                concurrentMap.remove(poll);
            }
            concurrentMap.put(name, cachedChain);
            queue.add(name);
            return cachedChain;
        }
        return filterChain;
    }

    public FilterMapping[] getFilterMappings() {
        return this._filterMappings;
    }

    public FilterHolder[] getFilters() {
        return this._filters;
    }

    public PathMap.Entry getHolderEntry(String str) {
        PathMap pathMap = this._servletPathMap;
        if (pathMap == null) {
            return null;
        }
        return pathMap.getMatch(str);
    }

    public IdentityService getIdentityService() {
        return this._identityService;
    }

    public int getMaxFilterChainsCacheSize() {
        return this._maxFilterChainsCacheSize;
    }

    public ServletHolder getServlet(String str) {
        return this._servletNameMap.get(str);
    }

    public ServletContext getServletContext() {
        return this._servletContext;
    }

    public ServletMapping getServletMapping(String str) {
        ServletMapping[] servletMappingArr = this._servletMappings;
        ServletMapping servletMapping = null;
        if (servletMappingArr != null) {
            for (ServletMapping servletMapping2 : servletMappingArr) {
                String[] pathSpecs = servletMapping2.getPathSpecs();
                if (pathSpecs != null) {
                    for (String str2 : pathSpecs) {
                        if (str.equals(str2)) {
                            servletMapping = servletMapping2;
                        }
                    }
                }
            }
        }
        return servletMapping;
    }

    public ServletMapping[] getServletMappings() {
        return this._servletMappings;
    }

    public ServletHolder[] getServlets() {
        return this._servlets;
    }

    public void initialize() throws Exception {
        MultiException multiException = new MultiException();
        if (this._filters != null) {
            int i = 0;
            while (true) {
                FilterHolder[] filterHolderArr = this._filters;
                if (i >= filterHolderArr.length) {
                    break;
                }
                filterHolderArr[i].start();
                i++;
            }
        }
        ServletHolder[] servletHolderArr = this._servlets;
        if (servletHolderArr != null) {
            ServletHolder[] servletHolderArr2 = (ServletHolder[]) servletHolderArr.clone();
            Arrays.sort(servletHolderArr2);
            for (int i2 = 0; i2 < servletHolderArr2.length; i2++) {
                try {
                } catch (Throwable th) {
                    LOG.debug(Log.EXCEPTION, th);
                    multiException.add(th);
                }
                if (servletHolderArr2[i2].getClassName() == null && servletHolderArr2[i2].getForcedPath() != null) {
                    ServletHolder servletHolder = (ServletHolder) this._servletPathMap.match(servletHolderArr2[i2].getForcedPath());
                    if (servletHolder != null && servletHolder.getClassName() != null) {
                        servletHolderArr2[i2].setClassName(servletHolder.getClassName());
                    }
                    multiException.add(new IllegalStateException("No forced path servlet for " + servletHolderArr2[i2].getForcedPath()));
                }
                servletHolderArr2[i2].start();
            }
            multiException.ifExceptionThrow();
        }
    }

    public FilterMapping[] insertFilterMapping(FilterMapping filterMapping, int i, boolean z) {
        if (i >= 0) {
            FilterMapping[] filterMappings = getFilterMappings();
            if (filterMappings == null || filterMappings.length == 0) {
                return new FilterMapping[]{filterMapping};
            }
            FilterMapping[] filterMappingArr = new FilterMapping[filterMappings.length + 1];
            if (z) {
                System.arraycopy(filterMappings, 0, filterMappingArr, 0, i);
                filterMappingArr[i] = filterMapping;
                System.arraycopy(filterMappings, i, filterMappingArr, i + 1, filterMappings.length - i);
            } else {
                int i2 = i + 1;
                System.arraycopy(filterMappings, 0, filterMappingArr, 0, i2);
                filterMappingArr[i2] = filterMapping;
                if (filterMappings.length > i2) {
                    System.arraycopy(filterMappings, i2, filterMappingArr, i + 2, filterMappings.length - i2);
                }
            }
            return filterMappingArr;
        }
        throw new IllegalArgumentException("FilterMapping insertion pos < 0");
    }

    public void invalidateChainsCache() {
        Queue<String>[] queueArr = this._chainLRU;
        if (queueArr[1] != null) {
            queueArr[1].clear();
            this._chainLRU[2].clear();
            this._chainLRU[4].clear();
            this._chainLRU[8].clear();
            this._chainLRU[16].clear();
            this._chainCache[1].clear();
            this._chainCache[2].clear();
            this._chainCache[4].clear();
            this._chainCache[8].clear();
            this._chainCache[16].clear();
        }
    }

    public boolean isAvailable() {
        ServletHolder[] servlets;
        if (!isStarted()) {
            return false;
        }
        for (ServletHolder servletHolder : getServlets()) {
            if (servletHolder != null && !servletHolder.isAvailable()) {
                return false;
            }
        }
        return true;
    }

    public boolean isFilterChainsCached() {
        return this._filterChainsCached;
    }

    public boolean isStartWithUnavailable() {
        return this._startWithUnavailable;
    }

    public CachedChain newCachedChain(Object obj, ServletHolder servletHolder) {
        return new CachedChain(obj, servletHolder);
    }

    public FilterHolder newFilterHolder(Holder.Source source) {
        return new FilterHolder(source);
    }

    public ServletHolder newServletHolder(Holder.Source source) {
        return new ServletHolder(source);
    }

    public void notFound(ae0 ae0Var, ce0 ce0Var) throws IOException {
        if (LOG.isDebugEnabled()) {
            Logger logger = LOG;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Not Found ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(ae0Var.getRequestURI());
            logger.debug(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), new Object[0]);
        }
    }

    public void prependFilterMapping(FilterMapping filterMapping) {
        if (filterMapping != null) {
            Holder.Source source = filterMapping.getFilterHolder().getSource();
            FilterMapping[] filterMappings = getFilterMappings();
            if (filterMappings == null || filterMappings.length == 0) {
                setFilterMappings(insertFilterMapping(filterMapping, 0, false));
                if (source == null || Holder.Source.JAVAX_API != source) {
                    return;
                }
                this._matchBeforeIndex = 0;
                return;
            }
            if (source == null || Holder.Source.JAVAX_API != source) {
                setFilterMappings(insertFilterMapping(filterMapping, 0, true));
            } else {
                int i = this._matchBeforeIndex;
                if (i < 0) {
                    this._matchBeforeIndex = 0;
                    setFilterMappings(insertFilterMapping(filterMapping, 0, true));
                } else {
                    FilterMapping[] insertFilterMapping = insertFilterMapping(filterMapping, i, false);
                    this._matchBeforeIndex++;
                    setFilterMappings(insertFilterMapping);
                }
            }
            int i2 = this._matchAfterIndex;
            if (i2 < 0) {
                return;
            }
            this._matchAfterIndex = i2 + 1;
        }
    }

    public void setFilterChainsCached(boolean z) {
        this._filterChainsCached = z;
    }

    public void setFilterMappings(FilterMapping[] filterMappingArr) {
        if (getServer() != null) {
            getServer().getContainer().update((Object) this, (Object[]) this._filterMappings, (Object[]) filterMappingArr, "filterMapping", true);
        }
        this._filterMappings = filterMappingArr;
        updateMappings();
        invalidateChainsCache();
    }

    public synchronized void setFilters(FilterHolder[] filterHolderArr) {
        if (getServer() != null) {
            getServer().getContainer().update((Object) this, (Object[]) this._filters, (Object[]) filterHolderArr, "filter", true);
        }
        this._filters = filterHolderArr;
        updateNameMappings();
        invalidateChainsCache();
    }

    public void setMaxFilterChainsCacheSize(int i) {
        this._maxFilterChainsCacheSize = i;
    }

    @Override // org.eclipse.jetty.server.handler.HandlerWrapper, org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.server.Handler
    public void setServer(Server server) {
        Server server2 = getServer();
        if (server2 != null && server2 != server) {
            getServer().getContainer().update((Object) this, (Object[]) this._filters, (Object[]) null, "filter", true);
            getServer().getContainer().update((Object) this, (Object[]) this._filterMappings, (Object[]) null, "filterMapping", true);
            getServer().getContainer().update((Object) this, (Object[]) this._servlets, (Object[]) null, "servlet", true);
            getServer().getContainer().update((Object) this, (Object[]) this._servletMappings, (Object[]) null, "servletMapping", true);
        }
        super.setServer(server);
        if (server == null || server2 == server) {
            return;
        }
        server.getContainer().update((Object) this, (Object[]) null, (Object[]) this._filters, "filter", true);
        server.getContainer().update((Object) this, (Object[]) null, (Object[]) this._filterMappings, "filterMapping", true);
        server.getContainer().update((Object) this, (Object[]) null, (Object[]) this._servlets, "servlet", true);
        server.getContainer().update((Object) this, (Object[]) null, (Object[]) this._servletMappings, "servletMapping", true);
    }

    public void setServletMappings(ServletMapping[] servletMappingArr) {
        if (getServer() != null) {
            getServer().getContainer().update((Object) this, (Object[]) this._servletMappings, (Object[]) servletMappingArr, "servletMapping", true);
        }
        this._servletMappings = servletMappingArr;
        updateMappings();
        invalidateChainsCache();
    }

    public Set<String> setServletSecurity(ServletRegistration.Dynamic dynamic, ServletSecurityElement servletSecurityElement) {
        ServletContextHandler servletContextHandler = this._contextHandler;
        return servletContextHandler != null ? servletContextHandler.setServletSecurity(dynamic, servletSecurityElement) : Collections.emptySet();
    }

    public synchronized void setServlets(ServletHolder[] servletHolderArr) {
        if (getServer() != null) {
            getServer().getContainer().update((Object) this, (Object[]) this._servlets, (Object[]) servletHolderArr, "servlet", true);
        }
        this._servlets = servletHolderArr;
        updateNameMappings();
        invalidateChainsCache();
    }

    public void setStartWithUnavailable(boolean z) {
        this._startWithUnavailable = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0110 A[Catch: all -> 0x01d2, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0007, B:6:0x0097, B:8:0x009b, B:11:0x00a0, B:12:0x00a6, B:14:0x00ab, B:16:0x00bd, B:18:0x00c3, B:20:0x00cd, B:21:0x00d6, B:23:0x00d9, B:25:0x00dd, B:27:0x00e2, B:30:0x00e5, B:34:0x00e8, B:35:0x0106, B:38:0x0107, B:39:0x010c, B:41:0x0110, B:42:0x0113, B:44:0x0117, B:46:0x011d, B:51:0x0126, B:53:0x012e, B:55:0x01b0, B:57:0x01b4, B:59:0x01c6, B:63:0x01bc, B:65:0x01c0, B:68:0x01cc, B:69:0x01d1, B:70:0x010a, B:71:0x000d, B:72:0x001c, B:74:0x0021, B:76:0x0033, B:78:0x0044, B:79:0x004d, B:81:0x0057, B:82:0x0060, B:84:0x0063, B:86:0x0067, B:88:0x0072, B:91:0x0075, B:94:0x0078, B:95:0x0096), top: B:2:0x0001, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x012e A[Catch: all -> 0x01d2, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0007, B:6:0x0097, B:8:0x009b, B:11:0x00a0, B:12:0x00a6, B:14:0x00ab, B:16:0x00bd, B:18:0x00c3, B:20:0x00cd, B:21:0x00d6, B:23:0x00d9, B:25:0x00dd, B:27:0x00e2, B:30:0x00e5, B:34:0x00e8, B:35:0x0106, B:38:0x0107, B:39:0x010c, B:41:0x0110, B:42:0x0113, B:44:0x0117, B:46:0x011d, B:51:0x0126, B:53:0x012e, B:55:0x01b0, B:57:0x01b4, B:59:0x01c6, B:63:0x01bc, B:65:0x01c0, B:68:0x01cc, B:69:0x01d1, B:70:0x010a, B:71:0x000d, B:72:0x001c, B:74:0x0021, B:76:0x0033, B:78:0x0044, B:79:0x004d, B:81:0x0057, B:82:0x0060, B:84:0x0063, B:86:0x0067, B:88:0x0072, B:91:0x0075, B:94:0x0078, B:95:0x0096), top: B:2:0x0001, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void updateMappings() {
        if (this._filterMappings == null) {
            this._filterPathMappings = null;
            this._filterNameMappings = null;
        } else {
            this._filterPathMappings = new ArrayList();
            this._filterNameMappings = new MultiMap<>();
            for (int i = 0; i < this._filterMappings.length; i++) {
                FilterHolder filterHolder = this._filterNameMap.get(this._filterMappings[i].getFilterName());
                if (filterHolder == null) {
                    throw new IllegalStateException("No filter named " + this._filterMappings[i].getFilterName());
                }
                this._filterMappings[i].setFilterHolder(filterHolder);
                if (this._filterMappings[i].getPathSpecs() != null) {
                    this._filterPathMappings.add(this._filterMappings[i]);
                }
                if (this._filterMappings[i].getServletNames() != null) {
                    String[] servletNames = this._filterMappings[i].getServletNames();
                    for (int i2 = 0; i2 < servletNames.length; i2++) {
                        if (servletNames[i2] != null) {
                            this._filterNameMappings.add(servletNames[i2], this._filterMappings[i]);
                        }
                    }
                }
            }
        }
        try {
            if (this._servletMappings != null && this._servletNameMap != null) {
                PathMap pathMap = new PathMap();
                for (int i3 = 0; i3 < this._servletMappings.length; i3++) {
                    ServletHolder servletHolder = this._servletNameMap.get(this._servletMappings[i3].getServletName());
                    if (servletHolder == null) {
                        throw new IllegalStateException("No such servlet: " + this._servletMappings[i3].getServletName());
                    }
                    if (servletHolder.isEnabled() && this._servletMappings[i3].getPathSpecs() != null) {
                        String[] pathSpecs = this._servletMappings[i3].getPathSpecs();
                        for (int i4 = 0; i4 < pathSpecs.length; i4++) {
                            if (pathSpecs[i4] != null) {
                                pathMap.put(pathSpecs[i4], servletHolder);
                            }
                        }
                    }
                }
                this._servletPathMap = pathMap;
                if (this._chainCache != null) {
                    int length = this._chainCache.length;
                    while (true) {
                        int i5 = length - 1;
                        if (length <= 0) {
                            break;
                        }
                        if (this._chainCache[i5] != null) {
                            this._chainCache[i5].clear();
                        }
                        length = i5;
                    }
                }
                if (LOG.isDebugEnabled()) {
                    LOG.debug("filterNameMap=" + this._filterNameMap, new Object[0]);
                    LOG.debug("pathFilters=" + this._filterPathMappings, new Object[0]);
                    LOG.debug("servletFilterMap=" + this._filterNameMappings, new Object[0]);
                    LOG.debug("servletPathMap=" + this._servletPathMap, new Object[0]);
                    LOG.debug("servletNameMap=" + this._servletNameMap, new Object[0]);
                }
                if ((this._contextHandler != null && this._contextHandler.isStarted()) || (this._contextHandler == null && isStarted())) {
                    initialize();
                }
            }
            if (this._contextHandler != null) {
                initialize();
            }
            initialize();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        this._servletPathMap = null;
        if (this._chainCache != null) {
        }
        if (LOG.isDebugEnabled()) {
        }
    }

    public synchronized void updateNameMappings() {
        this._filterNameMap.clear();
        if (this._filters != null) {
            for (int i = 0; i < this._filters.length; i++) {
                this._filterNameMap.put(this._filters[i].getName(), this._filters[i]);
                this._filters[i].setServletHandler(this);
            }
        }
        this._servletNameMap.clear();
        if (this._servlets != null) {
            for (int i2 = 0; i2 < this._servlets.length; i2++) {
                this._servletNameMap.put(this._servlets[i2].getName(), this._servlets[i2]);
                this._servlets[i2].setServletHandler(this);
            }
        }
    }
}
