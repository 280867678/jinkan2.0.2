package org.eclipse.jetty.server.handler;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.security.AccessController;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.EventListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterRegistration;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.SessionCookieConfig;
import javax.servlet.SessionTrackingMode;
import me.tvspark.ae0;
import me.tvspark.ce0;
import me.tvspark.outline;
import me.tvspark.xd0;
import okhttp3.CertificatePinner;
import org.eclipse.jetty.http.HttpException;
import org.eclipse.jetty.http.MimeTypes;
import org.eclipse.jetty.p059io.Buffer;
import org.eclipse.jetty.server.AbstractHttpConnection;
import org.eclipse.jetty.server.Dispatcher;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.HandlerContainer;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.Attributes;
import org.eclipse.jetty.util.AttributesMap;
import org.eclipse.jetty.util.LazyList;
import org.eclipse.jetty.util.Loader;
import org.eclipse.jetty.util.StringUtil;
import org.eclipse.jetty.util.TypeUtil;
import org.eclipse.jetty.util.URIUtil;
import org.eclipse.jetty.util.component.AggregateLifeCycle;
import org.eclipse.jetty.util.component.Dumpable;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.resource.Resource;

/* loaded from: classes4.dex */
public class ContextHandler extends ScopedHandler implements Attributes, Server.Graceful {
    public static final String MANAGED_ATTRIBUTES = "org.eclipse.jetty.server.context.ManagedAttributes";
    public static final int __AVAILABLE = 1;
    public static final int __SHUTDOWN = 2;
    public static final int __STOPPED = 0;
    public static final int __UNAVAILABLE = 3;
    public final CopyOnWriteArrayList<AliasCheck> _aliasChecks;
    public boolean _aliasesAllowed;
    public boolean _allowNullPathInfo;
    public final AttributesMap _attributes;
    public volatile int _availability;
    public boolean _available;
    public Resource _baseResource;
    public ClassLoader _classLoader;
    public boolean _compactPath;
    public Set<String> _connectors;
    public Object _contextAttributeListeners;
    public final AttributesMap _contextAttributes;
    public Object _contextListeners;
    public String _contextPath;
    public String _displayName;
    public Object _durableListeners;
    public ErrorHandler _errorHandler;
    public EventListener[] _eventListeners;
    public final Map<String, String> _initParams;
    public Map<String, String> _localeEncodingMap;
    public Logger _logger;
    public Map<String, Object> _managedAttributes;
    public int _maxFormContentSize;
    public int _maxFormKeys;
    public MimeTypes _mimeTypes;
    public String[] _protectedTargets;
    public Object _requestAttributeListeners;
    public Object _requestListeners;
    public Context _scontext;
    public boolean _shutdown;
    public String[] _vhosts;
    public String[] _welcomeFiles;
    public static final Logger LOG = Log.getLogger(ContextHandler.class);
    public static final ThreadLocal<Context> __context = new ThreadLocal<>();

    /* loaded from: classes4.dex */
    public interface AliasCheck {
        boolean check(String str, Resource resource);
    }

    /* loaded from: classes4.dex */
    public static class ApproveNonExistentDirectoryAliases implements AliasCheck {
        @Override // org.eclipse.jetty.server.handler.ContextHandler.AliasCheck
        public boolean check(String str, Resource resource) {
            if (resource.exists()) {
                return false;
            }
            String url = resource.getAlias().toString();
            String url2 = resource.getURL().toString();
            return url.length() > url2.length() ? url.startsWith(url2) && url.length() == url2.length() + 1 && url.endsWith("/") : url2.startsWith(url) && url2.length() == url.length() + 1 && url2.endsWith("/");
        }
    }

    @Deprecated
    /* loaded from: classes4.dex */
    public static class ApprovePathPrefixAliases implements AliasCheck {
        public ApprovePathPrefixAliases() {
            ContextHandler.LOG.warn("ApprovePathPrefixAliases is not safe for production", new Object[0]);
        }

        @Override // org.eclipse.jetty.server.handler.ContextHandler.AliasCheck
        public boolean check(String str, Resource resource) {
            int lastIndexOf = str.lastIndexOf(47);
            if (lastIndexOf < 0 || lastIndexOf == str.length() - 1) {
                return false;
            }
            return resource.toString().endsWith(str.substring(lastIndexOf));
        }
    }

    @Deprecated
    /* loaded from: classes4.dex */
    public static class ApproveSameSuffixAliases implements AliasCheck {
        public ApproveSameSuffixAliases() {
            ContextHandler.LOG.warn("ApproveSameSuffixAlias is not safe for production", new Object[0]);
        }

        @Override // org.eclipse.jetty.server.handler.ContextHandler.AliasCheck
        public boolean check(String str, Resource resource) {
            int lastIndexOf = str.lastIndexOf(46);
            if (lastIndexOf < 0) {
                return false;
            }
            return resource.toString().endsWith(str.substring(lastIndexOf));
        }
    }

    /* loaded from: classes4.dex */
    public static class CLDump implements Dumpable {
        public final ClassLoader _loader;

        public CLDump(ClassLoader classLoader) {
            this._loader = classLoader;
        }

        @Override // org.eclipse.jetty.util.component.Dumpable
        public String dump() {
            return AggregateLifeCycle.dump(this);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v7, types: [org.eclipse.jetty.server.handler.ContextHandler$CLDump] */
        @Override // org.eclipse.jetty.util.component.Dumpable
        public void dump(Appendable appendable, String str) throws IOException {
            ClassLoader parent;
            appendable.append(String.valueOf(this._loader)).append("\n");
            ClassLoader classLoader = this._loader;
            if (classLoader == null || (parent = classLoader.getParent()) == null) {
                return;
            }
            if (!(parent instanceof Dumpable)) {
                parent = new CLDump(parent);
            }
            ClassLoader classLoader2 = this._loader;
            if (classLoader2 instanceof URLClassLoader) {
                AggregateLifeCycle.dump(appendable, str, TypeUtil.asList(((URLClassLoader) classLoader2).getURLs()), Collections.singleton(parent));
            } else {
                AggregateLifeCycle.dump(appendable, str, Collections.singleton(parent));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class Context implements ServletContext {
        public static final String __unimplmented = "Unimplemented - use org.eclipse.jetty.servlet.ServletContextHandler";
        public int _majorVersion = 3;
        public int _minorVersion = 0;
        public boolean _enabled = true;

        public Context() {
        }

        @Override // javax.servlet.ServletContext
        public FilterRegistration.Dynamic addFilter(String str, Class<? extends Filter> cls) {
            ContextHandler.LOG.warn(__unimplmented, new Object[0]);
            return null;
        }

        @Override // javax.servlet.ServletContext
        public FilterRegistration.Dynamic addFilter(String str, String str2) {
            ContextHandler.LOG.warn(__unimplmented, new Object[0]);
            return null;
        }

        @Override // javax.servlet.ServletContext
        public FilterRegistration.Dynamic addFilter(String str, Filter filter) {
            ContextHandler.LOG.warn(__unimplmented, new Object[0]);
            return null;
        }

        @Override // javax.servlet.ServletContext
        public void addListener(Class<? extends EventListener> cls) {
            if (this._enabled) {
                try {
                    EventListener createListener = createListener(cls);
                    ContextHandler.this.addEventListener(createListener);
                    ContextHandler.this.restrictEventListener(createListener);
                    return;
                } catch (ServletException e) {
                    throw new IllegalArgumentException(e);
                }
            }
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // javax.servlet.ServletContext
        public void addListener(String str) {
            if (this._enabled) {
                try {
                    addListener((Class<? extends EventListener>) (ContextHandler.this._classLoader == null ? Loader.loadClass(ContextHandler.class, str) : ContextHandler.this._classLoader.loadClass(str)));
                    return;
                } catch (ClassNotFoundException e) {
                    throw new IllegalArgumentException(e);
                }
            }
            throw new UnsupportedOperationException();
        }

        @Override // javax.servlet.ServletContext
        public <T extends EventListener> void addListener(T t) {
            if (this._enabled) {
                ContextHandler.this.addEventListener(t);
                ContextHandler.this.restrictEventListener(t);
                return;
            }
            throw new UnsupportedOperationException();
        }

        @Override // javax.servlet.ServletContext
        public ServletRegistration.Dynamic addServlet(String str, Class<? extends Servlet> cls) {
            ContextHandler.LOG.warn(__unimplmented, new Object[0]);
            return null;
        }

        @Override // javax.servlet.ServletContext
        public ServletRegistration.Dynamic addServlet(String str, String str2) {
            ContextHandler.LOG.warn(__unimplmented, new Object[0]);
            return null;
        }

        @Override // javax.servlet.ServletContext
        public ServletRegistration.Dynamic addServlet(String str, Servlet servlet) {
            ContextHandler.LOG.warn(__unimplmented, new Object[0]);
            return null;
        }

        @Override // javax.servlet.ServletContext
        public <T extends Filter> T createFilter(Class<T> cls) throws ServletException {
            ContextHandler.LOG.warn(__unimplmented, new Object[0]);
            return null;
        }

        @Override // javax.servlet.ServletContext
        public <T extends EventListener> T createListener(Class<T> cls) throws ServletException {
            try {
                return cls.newInstance();
            } catch (IllegalAccessException e) {
                throw new ServletException(e);
            } catch (InstantiationException e2) {
                throw new ServletException(e2);
            }
        }

        @Override // javax.servlet.ServletContext
        public <T extends Servlet> T createServlet(Class<T> cls) throws ServletException {
            ContextHandler.LOG.warn(__unimplmented, new Object[0]);
            return null;
        }

        @Override // javax.servlet.ServletContext
        public void declareRoles(String... strArr) {
            if (ContextHandler.this.isStarting()) {
                if (!this._enabled) {
                    throw new UnsupportedOperationException();
                }
                return;
            }
            throw new IllegalStateException();
        }

        @Override // javax.servlet.ServletContext
        public synchronized Object getAttribute(String str) {
            Object attribute;
            attribute = ContextHandler.this.getAttribute(str);
            if (attribute == null && ContextHandler.this._contextAttributes != null) {
                attribute = ContextHandler.this._contextAttributes.getAttribute(str);
            }
            return attribute;
        }

        @Override // javax.servlet.ServletContext
        public synchronized Enumeration getAttributeNames() {
            HashSet hashSet;
            hashSet = new HashSet();
            if (ContextHandler.this._contextAttributes != null) {
                Enumeration<String> attributeNames = ContextHandler.this._contextAttributes.getAttributeNames();
                while (attributeNames.hasMoreElements()) {
                    hashSet.add(attributeNames.nextElement());
                }
            }
            Enumeration<String> attributeNames2 = ContextHandler.this._attributes.getAttributeNames();
            while (attributeNames2.hasMoreElements()) {
                hashSet.add(attributeNames2.nextElement());
            }
            return Collections.enumeration(hashSet);
        }

        @Override // javax.servlet.ServletContext
        public ClassLoader getClassLoader() {
            AccessController.checkPermission(new RuntimePermission("getClassLoader"));
            return ContextHandler.this._classLoader;
        }

        /* JADX WARN: Code restructure failed: missing block: B:30:0x008c, code lost:
            if (r12.length() > r8.length()) goto L37;
         */
        @Override // javax.servlet.ServletContext
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public ServletContext getContext(String str) {
            int i;
            String[] virtualHosts;
            int i2;
            Context context = this;
            ArrayList arrayList = new ArrayList();
            Handler[] childHandlersByClass = ContextHandler.this.getServer().getChildHandlersByClass(ContextHandler.class);
            int length = childHandlersByClass.length;
            int i3 = 0;
            String str2 = null;
            while (i3 < length) {
                Handler handler = childHandlersByClass[i3];
                if (handler != null) {
                    ContextHandler contextHandler = (ContextHandler) handler;
                    String contextPath = contextHandler.getContextPath();
                    if (str.equals(contextPath) || ((str.startsWith(contextPath) && str.charAt(contextPath.length()) == '/') || "/".equals(contextPath))) {
                        if (ContextHandler.this.getVirtualHosts() == null || ContextHandler.this.getVirtualHosts().length <= 0) {
                            i = length;
                            if (str2 == null || contextPath.length() > str2.length()) {
                                arrayList.clear();
                                str2 = contextPath;
                            }
                            if (str2.equals(contextPath)) {
                                arrayList.add(contextHandler);
                            }
                            i3++;
                            context = this;
                            length = i;
                        } else if (contextHandler.getVirtualHosts() != null && contextHandler.getVirtualHosts().length > 0) {
                            for (String str3 : ContextHandler.this.getVirtualHosts()) {
                                String[] virtualHosts2 = contextHandler.getVirtualHosts();
                                int length2 = virtualHosts2.length;
                                int i4 = 0;
                                while (i4 < length2) {
                                    if (str3.equals(virtualHosts2[i4])) {
                                        if (str2 != null) {
                                            i2 = length;
                                        } else {
                                            i2 = length;
                                        }
                                        arrayList.clear();
                                        str2 = contextPath;
                                        if (str2.equals(contextPath)) {
                                            arrayList.add(contextHandler);
                                        }
                                    } else {
                                        i2 = length;
                                    }
                                    i4++;
                                    length = i2;
                                }
                            }
                        }
                    }
                }
                i = length;
                i3++;
                context = this;
                length = i;
            }
            if (arrayList.size() <= 0) {
                String str4 = null;
                for (Handler handler2 : childHandlersByClass) {
                    if (handler2 != null) {
                        ContextHandler contextHandler2 = (ContextHandler) handler2;
                        String contextPath2 = contextHandler2.getContextPath();
                        if (str.equals(contextPath2) || ((str.startsWith(contextPath2) && str.charAt(contextPath2.length()) == '/') || "/".equals(contextPath2))) {
                            if (str4 == null || contextPath2.length() > str4.length()) {
                                arrayList.clear();
                                str4 = contextPath2;
                            }
                            if (str4.equals(contextPath2)) {
                                arrayList.add(contextHandler2);
                            }
                        }
                    }
                }
                if (arrayList.size() <= 0) {
                    return null;
                }
            }
            return ((ContextHandler) arrayList.get(0))._scontext;
        }

        public ContextHandler getContextHandler() {
            return ContextHandler.this;
        }

        @Override // javax.servlet.ServletContext
        public String getContextPath() {
            return (ContextHandler.this._contextPath == null || !ContextHandler.this._contextPath.equals("/")) ? ContextHandler.this._contextPath : "";
        }

        @Override // javax.servlet.ServletContext
        public Set<SessionTrackingMode> getDefaultSessionTrackingModes() {
            ContextHandler.LOG.warn(__unimplmented, new Object[0]);
            return null;
        }

        @Override // javax.servlet.ServletContext
        public int getEffectiveMajorVersion() {
            return this._majorVersion;
        }

        @Override // javax.servlet.ServletContext
        public int getEffectiveMinorVersion() {
            return this._minorVersion;
        }

        @Override // javax.servlet.ServletContext
        public Set<SessionTrackingMode> getEffectiveSessionTrackingModes() {
            ContextHandler.LOG.warn(__unimplmented, new Object[0]);
            return null;
        }

        @Override // javax.servlet.ServletContext
        public FilterRegistration getFilterRegistration(String str) {
            ContextHandler.LOG.warn(__unimplmented, new Object[0]);
            return null;
        }

        @Override // javax.servlet.ServletContext
        public Map<String, ? extends FilterRegistration> getFilterRegistrations() {
            ContextHandler.LOG.warn(__unimplmented, new Object[0]);
            return null;
        }

        @Override // javax.servlet.ServletContext
        public String getInitParameter(String str) {
            return ContextHandler.this.getInitParameter(str);
        }

        @Override // javax.servlet.ServletContext
        public Enumeration getInitParameterNames() {
            return ContextHandler.this.getInitParameterNames();
        }

        @Override // javax.servlet.ServletContext
        public xd0 getJspConfigDescriptor() {
            ContextHandler.LOG.warn(__unimplmented, new Object[0]);
            return null;
        }

        @Override // javax.servlet.ServletContext
        public int getMajorVersion() {
            return 3;
        }

        @Override // javax.servlet.ServletContext
        public String getMimeType(String str) {
            Buffer mimeByExtension;
            if (ContextHandler.this._mimeTypes == null || (mimeByExtension = ContextHandler.this._mimeTypes.getMimeByExtension(str)) == null) {
                return null;
            }
            return mimeByExtension.toString();
        }

        @Override // javax.servlet.ServletContext
        public int getMinorVersion() {
            return 0;
        }

        @Override // javax.servlet.ServletContext
        public RequestDispatcher getNamedDispatcher(String str) {
            return null;
        }

        @Override // javax.servlet.ServletContext
        public String getRealPath(String str) {
            File file;
            if (str == null) {
                return null;
            }
            if (str.length() == 0) {
                str = "/";
            } else if (str.charAt(0) != '/') {
                str = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("/", str);
            }
            try {
                Resource resource = ContextHandler.this.getResource(str);
                if (resource != null && (file = resource.getFile()) != null) {
                    return file.getCanonicalPath();
                }
            } catch (Exception e) {
                ContextHandler.LOG.ignore(e);
            }
            return null;
        }

        @Override // javax.servlet.ServletContext
        public RequestDispatcher getRequestDispatcher(String str) {
            String str2;
            if (str != null && str.startsWith("/")) {
                try {
                    int indexOf = str.indexOf(63);
                    if (indexOf > 0) {
                        str2 = str.substring(indexOf + 1);
                        str = str.substring(0, indexOf);
                    } else {
                        str2 = null;
                    }
                    String canonicalPath = URIUtil.canonicalPath(URIUtil.decodePath(str));
                    if (canonicalPath != null) {
                        return new Dispatcher(ContextHandler.this, URIUtil.addPaths(getContextPath(), str), canonicalPath, str2);
                    }
                } catch (Exception e) {
                    ContextHandler.LOG.ignore(e);
                }
                return null;
            }
            return null;
        }

        @Override // javax.servlet.ServletContext
        public URL getResource(String str) throws MalformedURLException {
            Resource resource = ContextHandler.this.getResource(str);
            if (resource == null || !resource.exists()) {
                return null;
            }
            return resource.getURL();
        }

        @Override // javax.servlet.ServletContext
        public InputStream getResourceAsStream(String str) {
            try {
                URL resource = getResource(str);
                if (resource != null) {
                    return Resource.newResource(resource).getInputStream();
                }
                return null;
            } catch (Exception e) {
                ContextHandler.LOG.ignore(e);
                return null;
            }
        }

        @Override // javax.servlet.ServletContext
        public Set getResourcePaths(String str) {
            return ContextHandler.this.getResourcePaths(str);
        }

        @Override // javax.servlet.ServletContext
        public String getServerInfo() {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("jetty/");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Server.getVersion());
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }

        @Override // javax.servlet.ServletContext
        @Deprecated
        public Servlet getServlet(String str) throws ServletException {
            return null;
        }

        @Override // javax.servlet.ServletContext
        public String getServletContextName() {
            String displayName = ContextHandler.this.getDisplayName();
            return displayName == null ? ContextHandler.this.getContextPath() : displayName;
        }

        @Override // javax.servlet.ServletContext
        @Deprecated
        public Enumeration getServletNames() {
            return Collections.enumeration(Collections.EMPTY_LIST);
        }

        @Override // javax.servlet.ServletContext
        public ServletRegistration getServletRegistration(String str) {
            ContextHandler.LOG.warn(__unimplmented, new Object[0]);
            return null;
        }

        @Override // javax.servlet.ServletContext
        public Map<String, ? extends ServletRegistration> getServletRegistrations() {
            ContextHandler.LOG.warn(__unimplmented, new Object[0]);
            return null;
        }

        @Override // javax.servlet.ServletContext
        @Deprecated
        public Enumeration getServlets() {
            return Collections.enumeration(Collections.EMPTY_LIST);
        }

        @Override // javax.servlet.ServletContext
        public SessionCookieConfig getSessionCookieConfig() {
            ContextHandler.LOG.warn(__unimplmented, new Object[0]);
            return null;
        }

        public boolean isEnabled() {
            return this._enabled;
        }

        @Override // javax.servlet.ServletContext
        public void log(Exception exc, String str) {
            ContextHandler.this._logger.warn(str, exc);
        }

        @Override // javax.servlet.ServletContext
        public void log(String str) {
            ContextHandler.this._logger.info(str, new Object[0]);
        }

        @Override // javax.servlet.ServletContext
        public void log(String str, Throwable th) {
            ContextHandler.this._logger.warn(str, th);
        }

        @Override // javax.servlet.ServletContext
        public synchronized void removeAttribute(String str) {
            ContextHandler.this.checkManagedAttribute(str, null);
            if (ContextHandler.this._contextAttributes == null) {
                ContextHandler.this._attributes.removeAttribute(str);
                return;
            }
            Object attribute = ContextHandler.this._contextAttributes.getAttribute(str);
            ContextHandler.this._contextAttributes.removeAttribute(str);
            if (attribute != null && ContextHandler.this._contextAttributeListeners != null) {
                ServletContextAttributeEvent servletContextAttributeEvent = new ServletContextAttributeEvent(ContextHandler.this._scontext, str, attribute);
                for (int i = 0; i < LazyList.size(ContextHandler.this._contextAttributeListeners); i++) {
                    ((ServletContextAttributeListener) LazyList.get(ContextHandler.this._contextAttributeListeners, i)).attributeRemoved(servletContextAttributeEvent);
                }
            }
        }

        @Override // javax.servlet.ServletContext
        public synchronized void setAttribute(String str, Object obj) {
            ContextHandler.this.checkManagedAttribute(str, obj);
            Object attribute = ContextHandler.this._contextAttributes.getAttribute(str);
            if (obj == null) {
                ContextHandler.this._contextAttributes.removeAttribute(str);
            } else {
                ContextHandler.this._contextAttributes.setAttribute(str, obj);
            }
            if (ContextHandler.this._contextAttributeListeners != null) {
                ServletContextAttributeEvent servletContextAttributeEvent = new ServletContextAttributeEvent(ContextHandler.this._scontext, str, attribute == null ? obj : attribute);
                for (int i = 0; i < LazyList.size(ContextHandler.this._contextAttributeListeners); i++) {
                    ServletContextAttributeListener servletContextAttributeListener = (ServletContextAttributeListener) LazyList.get(ContextHandler.this._contextAttributeListeners, i);
                    if (attribute == null) {
                        servletContextAttributeListener.attributeAdded(servletContextAttributeEvent);
                    } else if (obj == null) {
                        servletContextAttributeListener.attributeRemoved(servletContextAttributeEvent);
                    } else {
                        servletContextAttributeListener.attributeReplaced(servletContextAttributeEvent);
                    }
                }
            }
        }

        public void setEffectiveMajorVersion(int i) {
            this._majorVersion = i;
        }

        public void setEffectiveMinorVersion(int i) {
            this._minorVersion = i;
        }

        public void setEnabled(boolean z) {
            this._enabled = z;
        }

        @Override // javax.servlet.ServletContext
        public boolean setInitParameter(String str, String str2) {
            if (ContextHandler.this.getInitParameter(str) != null) {
                return false;
            }
            ContextHandler.this.getInitParams().put(str, str2);
            return true;
        }

        public void setJspConfigDescriptor(xd0 xd0Var) {
        }

        @Override // javax.servlet.ServletContext
        public void setSessionTrackingModes(Set<SessionTrackingMode> set) {
            ContextHandler.LOG.warn(__unimplmented, new Object[0]);
        }

        public String toString() {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("ServletContext@");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(ContextHandler.this.toString());
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
    }

    public ContextHandler() {
        this._contextPath = "/";
        this._maxFormKeys = Integer.getInteger("org.eclipse.jetty.server.Request.maxFormKeys", -1).intValue();
        this._maxFormContentSize = Integer.getInteger("org.eclipse.jetty.server.Request.maxFormContentSize", -1).intValue();
        this._compactPath = false;
        this._aliasesAllowed = false;
        this._aliasChecks = new CopyOnWriteArrayList<>();
        this._shutdown = false;
        this._available = true;
        this._scontext = new Context();
        this._attributes = new AttributesMap();
        this._contextAttributes = new AttributesMap();
        this._initParams = new HashMap();
        addAliasCheck(new ApproveNonExistentDirectoryAliases());
    }

    public ContextHandler(String str) {
        this();
        setContextPath(str);
    }

    public ContextHandler(HandlerContainer handlerContainer, String str) {
        this();
        setContextPath(str);
        if (handlerContainer instanceof HandlerWrapper) {
            ((HandlerWrapper) handlerContainer).setHandler(this);
        } else if (!(handlerContainer instanceof HandlerCollection)) {
        } else {
            ((HandlerCollection) handlerContainer).addHandler(this);
        }
    }

    public ContextHandler(Context context) {
        this._contextPath = "/";
        this._maxFormKeys = Integer.getInteger("org.eclipse.jetty.server.Request.maxFormKeys", -1).intValue();
        this._maxFormContentSize = Integer.getInteger("org.eclipse.jetty.server.Request.maxFormContentSize", -1).intValue();
        this._compactPath = false;
        this._aliasesAllowed = false;
        this._aliasChecks = new CopyOnWriteArrayList<>();
        this._shutdown = false;
        this._available = true;
        this._scontext = context;
        this._attributes = new AttributesMap();
        this._contextAttributes = new AttributesMap();
        this._initParams = new HashMap();
        addAliasCheck(new ApproveNonExistentDirectoryAliases());
    }

    public static Context getCurrentContext() {
        return __context.get();
    }

    private String normalizeHostname(String str) {
        if (str == null) {
            return null;
        }
        return str.endsWith(".") ? outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, -1, 0) : str;
    }

    public void addAliasCheck(AliasCheck aliasCheck) {
        this._aliasChecks.add(aliasCheck);
    }

    public void addEventListener(EventListener eventListener) {
        if (!isStarted() && !isStarting()) {
            this._durableListeners = LazyList.add(this._durableListeners, eventListener);
        }
        setEventListeners((EventListener[]) LazyList.addToArray(getEventListeners(), eventListener, EventListener.class));
    }

    public void addLocaleEncoding(String str, String str2) {
        if (this._localeEncodingMap == null) {
            this._localeEncodingMap = new HashMap();
        }
        this._localeEncodingMap.put(str, str2);
    }

    public void addVirtualHosts(String[] strArr) {
        if (strArr == null) {
            return;
        }
        ArrayList arrayList = this._vhosts != null ? new ArrayList(Arrays.asList(this._vhosts)) : new ArrayList();
        for (String str : strArr) {
            String normalizeHostname = normalizeHostname(str);
            if (!arrayList.contains(normalizeHostname)) {
                arrayList.add(normalizeHostname);
            }
        }
        this._vhosts = (String[]) arrayList.toArray(new String[0]);
    }

    public void callContextDestroyed(ServletContextListener servletContextListener, ServletContextEvent servletContextEvent) {
        servletContextListener.contextDestroyed(servletContextEvent);
    }

    public void callContextInitialized(ServletContextListener servletContextListener, ServletContextEvent servletContextEvent) {
        servletContextListener.contextInitialized(servletContextEvent);
    }

    public boolean checkAlias(String str, Resource resource) {
        if (this._aliasesAllowed || resource.getAlias() == null) {
            return true;
        }
        if (LOG.isDebugEnabled()) {
            Logger logger = LOG;
            logger.debug("Aliased resource: " + resource + "~=" + resource.getAlias(), new Object[0]);
        }
        Iterator<AliasCheck> it = this._aliasChecks.iterator();
        while (it.hasNext()) {
            AliasCheck next = it.next();
            if (next.check(str, resource)) {
                if (LOG.isDebugEnabled()) {
                    Logger logger2 = LOG;
                    logger2.debug("Aliased resource: " + resource + " approved by " + next, new Object[0]);
                }
                return true;
            }
        }
        return false;
    }

    public boolean checkContext(String str, Request request, ce0 ce0Var) throws IOException, ServletException {
        String addPaths;
        String name;
        DispatcherType dispatcherType = request.getDispatcherType();
        int i = this._availability;
        if (i != 0 && i != 2) {
            if (i != 3) {
                if (DispatcherType.REQUEST.equals(dispatcherType) && request.isHandled()) {
                    return false;
                }
                String[] strArr = this._vhosts;
                if (strArr != null && strArr.length > 0) {
                    String normalizeHostname = normalizeHostname(request.getServerName());
                    boolean z = false;
                    int i2 = 0;
                    while (!z) {
                        String[] strArr2 = this._vhosts;
                        if (i2 >= strArr2.length) {
                            break;
                        }
                        String str2 = strArr2[i2];
                        if (str2 != null) {
                            z = str2.startsWith(CertificatePinner.WILDCARD) ? str2.regionMatches(true, 2, normalizeHostname, normalizeHostname.indexOf(".") + 1, str2.length() - 2) : str2.equalsIgnoreCase(normalizeHostname);
                        }
                        i2++;
                    }
                    if (!z) {
                        return false;
                    }
                }
                Set<String> set = this._connectors;
                if (set != null && set.size() > 0 && ((name = AbstractHttpConnection.getCurrentConnection().getConnector().getName()) == null || !this._connectors.contains(name))) {
                    return false;
                }
                if (this._contextPath.length() > 1) {
                    if (!str.startsWith(this._contextPath)) {
                        return false;
                    }
                    if (str.length() > this._contextPath.length() && str.charAt(this._contextPath.length()) != '/') {
                        return false;
                    }
                    if (!this._allowNullPathInfo && this._contextPath.length() == str.length()) {
                        request.setHandled(true);
                        if (request.getQueryString() != null) {
                            addPaths = URIUtil.addPaths(request.getRequestURI(), "/") + "?" + request.getQueryString();
                        } else {
                            addPaths = URIUtil.addPaths(request.getRequestURI(), "/");
                        }
                        ce0Var.sendRedirect(addPaths);
                        return false;
                    }
                }
                return true;
            }
            request.setHandled(true);
            ce0Var.sendError(503);
        }
        return false;
    }

    public void checkManagedAttribute(String str, Object obj) {
        Map<String, Object> map = this._managedAttributes;
        if (map == null || !map.containsKey(str)) {
            return;
        }
        setManagedAttribute(str, obj);
    }

    @Override // org.eclipse.jetty.util.Attributes
    public void clearAttributes() {
        Enumeration<String> attributeNames = this._attributes.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            checkManagedAttribute(attributeNames.nextElement(), null);
        }
        this._attributes.clearAttributes();
    }

    @Override // org.eclipse.jetty.server.handler.ScopedHandler
    public void doHandle(String str, Request request, ae0 ae0Var, ce0 ce0Var) throws IOException, ServletException {
        DispatcherType dispatcherType = request.getDispatcherType();
        boolean takeNewContext = request.takeNewContext();
        try {
            if (takeNewContext) {
                try {
                    if (this._requestAttributeListeners != null) {
                        int size = LazyList.size(this._requestAttributeListeners);
                        for (int i = 0; i < size; i++) {
                            request.addEventListener((EventListener) LazyList.get(this._requestAttributeListeners, i));
                        }
                    }
                    if (this._requestListeners != null) {
                        int size2 = LazyList.size(this._requestListeners);
                        ServletRequestEvent servletRequestEvent = new ServletRequestEvent(this._scontext, ae0Var);
                        for (int i2 = 0; i2 < size2; i2++) {
                            ((ServletRequestListener) LazyList.get(this._requestListeners, i2)).requestInitialized(servletRequestEvent);
                        }
                    }
                } catch (HttpException e) {
                    LOG.debug(e);
                    request.setHandled(true);
                    ce0Var.sendError(e.getStatus(), e.getReason());
                    if (!takeNewContext) {
                        return;
                    }
                    if (this._requestListeners != null) {
                        ServletRequestEvent servletRequestEvent2 = new ServletRequestEvent(this._scontext, ae0Var);
                        int size3 = LazyList.size(this._requestListeners);
                        while (true) {
                            int i3 = size3 - 1;
                            if (size3 <= 0) {
                                break;
                            }
                            ((ServletRequestListener) LazyList.get(this._requestListeners, i3)).requestDestroyed(servletRequestEvent2);
                            size3 = i3;
                        }
                    }
                    Object obj = this._requestAttributeListeners;
                    if (obj == null) {
                        return;
                    }
                    int size4 = LazyList.size(obj);
                    while (true) {
                        int i4 = size4 - 1;
                        if (size4 <= 0) {
                            return;
                        }
                        request.removeEventListener((EventListener) LazyList.get(this._requestAttributeListeners, i4));
                        size4 = i4;
                    }
                }
            }
            if (DispatcherType.REQUEST.equals(dispatcherType) && isProtectedTarget(str)) {
                throw new HttpException(404);
            }
            if (never()) {
                nextHandle(str, request, ae0Var, ce0Var);
            } else if (this._nextScope != null && this._nextScope == this._handler) {
                this._nextScope.doHandle(str, request, ae0Var, ce0Var);
            } else if (this._handler != null) {
                this._handler.handle(str, request, ae0Var, ce0Var);
            }
            if (!takeNewContext) {
                return;
            }
            if (this._requestListeners != null) {
                ServletRequestEvent servletRequestEvent3 = new ServletRequestEvent(this._scontext, ae0Var);
                int size5 = LazyList.size(this._requestListeners);
                while (true) {
                    int i5 = size5 - 1;
                    if (size5 <= 0) {
                        break;
                    }
                    ((ServletRequestListener) LazyList.get(this._requestListeners, i5)).requestDestroyed(servletRequestEvent3);
                    size5 = i5;
                }
            }
            Object obj2 = this._requestAttributeListeners;
            if (obj2 == null) {
                return;
            }
            int size6 = LazyList.size(obj2);
            while (true) {
                int i6 = size6 - 1;
                if (size6 <= 0) {
                    return;
                }
                request.removeEventListener((EventListener) LazyList.get(this._requestAttributeListeners, i6));
                size6 = i6;
            }
        } catch (Throwable th) {
            if (takeNewContext) {
                if (this._requestListeners != null) {
                    ServletRequestEvent servletRequestEvent4 = new ServletRequestEvent(this._scontext, ae0Var);
                    int size7 = LazyList.size(this._requestListeners);
                    while (true) {
                        int i7 = size7 - 1;
                        if (size7 <= 0) {
                            break;
                        }
                        ((ServletRequestListener) LazyList.get(this._requestListeners, i7)).requestDestroyed(servletRequestEvent4);
                        size7 = i7;
                    }
                }
                Object obj3 = this._requestAttributeListeners;
                if (obj3 != null) {
                    int size8 = LazyList.size(obj3);
                    while (true) {
                        int i8 = size8 - 1;
                        if (size8 <= 0) {
                            break;
                        }
                        request.removeEventListener((EventListener) LazyList.get(this._requestAttributeListeners, i8));
                        size8 = i8;
                    }
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ef A[Catch: all -> 0x0163, TryCatch #0 {all -> 0x0163, blocks: (B:26:0x00c9, B:28:0x00dd, B:30:0x00e3, B:33:0x00f1, B:34:0x00ef, B:35:0x00fb, B:37:0x0103, B:38:0x0125, B:40:0x012b, B:50:0x012f, B:52:0x0133, B:53:0x0139, B:55:0x013d, B:56:0x0143), top: B:25:0x00c9 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0103 A[Catch: all -> 0x0163, TryCatch #0 {all -> 0x0163, blocks: (B:26:0x00c9, B:28:0x00dd, B:30:0x00e3, B:33:0x00f1, B:34:0x00ef, B:35:0x00fb, B:37:0x0103, B:38:0x0125, B:40:0x012b, B:50:0x012f, B:52:0x0133, B:53:0x0139, B:55:0x013d, B:56:0x0143), top: B:25:0x00c9 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x012b A[Catch: all -> 0x0163, TryCatch #0 {all -> 0x0163, blocks: (B:26:0x00c9, B:28:0x00dd, B:30:0x00e3, B:33:0x00f1, B:34:0x00ef, B:35:0x00fb, B:37:0x0103, B:38:0x0125, B:40:0x012b, B:50:0x012f, B:52:0x0133, B:53:0x0139, B:55:0x013d, B:56:0x0143), top: B:25:0x00c9 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012f A[Catch: all -> 0x0163, TryCatch #0 {all -> 0x0163, blocks: (B:26:0x00c9, B:28:0x00dd, B:30:0x00e3, B:33:0x00f1, B:34:0x00ef, B:35:0x00fb, B:37:0x0103, B:38:0x0125, B:40:0x012b, B:50:0x012f, B:52:0x0133, B:53:0x0139, B:55:0x013d, B:56:0x0143), top: B:25:0x00c9 }] */
    @Override // org.eclipse.jetty.server.handler.ScopedHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void doScope(String str, Request request, ae0 ae0Var, ce0 ce0Var) throws IOException, ServletException {
        String str2;
        String str3;
        ClassLoader classLoader;
        Thread thread;
        String str4;
        String str5;
        String str6;
        String contextPath;
        if (LOG.isDebugEnabled()) {
            LOG.debug("scope {}|{}|{} @ {}", request.getContextPath(), request.getServletPath(), request.getPathInfo(), this);
        }
        DispatcherType dispatcherType = request.getDispatcherType();
        Context context = request.getContext();
        try {
            try {
                try {
                    try {
                        if (context != this._scontext) {
                            if (DispatcherType.REQUEST.equals(dispatcherType) || DispatcherType.ASYNC.equals(dispatcherType) || (DispatcherType.ERROR.equals(dispatcherType) && request.getAsyncContinuation().isExpired())) {
                                str2 = this._compactPath ? URIUtil.compactPath(str) : str;
                                if (!checkContext(str2, request, ce0Var)) {
                                    return;
                                }
                                if (str2.length() > this._contextPath.length()) {
                                    if (this._contextPath.length() > 1) {
                                        str2 = str2.substring(this._contextPath.length());
                                    }
                                } else if (this._contextPath.length() == 1) {
                                    str2 = "/";
                                } else {
                                    str2 = "/";
                                    str3 = null;
                                    if (this._classLoader != null) {
                                        thread = Thread.currentThread();
                                        ClassLoader contextClassLoader = thread.getContextClassLoader();
                                        thread.setContextClassLoader(this._classLoader);
                                        classLoader = contextClassLoader;
                                        contextPath = request.getContextPath();
                                        str4 = request.getServletPath();
                                        str5 = request.getPathInfo();
                                        request.setContext(this._scontext);
                                        __context.set(this._scontext);
                                        if (!DispatcherType.INCLUDE.equals(dispatcherType) && str2.startsWith("/")) {
                                            request.setContextPath(this._contextPath.length() != 1 ? "" : this._contextPath);
                                            request.setServletPath(null);
                                            request.setPathInfo(str3);
                                        }
                                        if (LOG.isDebugEnabled()) {
                                            LOG.debug("context={}|{}|{} @ {}", request.getContextPath(), request.getServletPath(), request.getPathInfo(), this);
                                        }
                                        if (!never()) {
                                            nextScope(str2, request, ae0Var, ce0Var);
                                        } else if (this._nextScope != null) {
                                            this._nextScope.doScope(str2, request, ae0Var, ce0Var);
                                        } else if (this._outerScope != null) {
                                            this._outerScope.doHandle(str2, request, ae0Var, ce0Var);
                                        } else {
                                            doHandle(str2, request, ae0Var, ce0Var);
                                        }
                                        if (context != this._scontext) {
                                            return;
                                        }
                                        if (this._classLoader != null) {
                                            thread.setContextClassLoader(classLoader);
                                        }
                                        request.setContext(context);
                                        __context.set(context);
                                        request.setContextPath(contextPath);
                                        request.setServletPath(str4);
                                        request.setPathInfo(str5);
                                        return;
                                    }
                                }
                            } else {
                                str2 = str;
                            }
                            str3 = str2;
                            if (this._classLoader != null) {
                            }
                        } else {
                            str2 = str;
                            str3 = str2;
                        }
                        request.setContext(this._scontext);
                        __context.set(this._scontext);
                        if (!DispatcherType.INCLUDE.equals(dispatcherType)) {
                            request.setContextPath(this._contextPath.length() != 1 ? "" : this._contextPath);
                            request.setServletPath(null);
                            request.setPathInfo(str3);
                        }
                        if (LOG.isDebugEnabled()) {
                        }
                        if (!never()) {
                        }
                        if (context != this._scontext) {
                        }
                    } catch (Throwable th) {
                        th = th;
                        str6 = contextPath;
                        if (context != this._scontext) {
                            if (this._classLoader != null) {
                                thread.setContextClassLoader(classLoader);
                            }
                            request.setContext(context);
                            __context.set(context);
                            request.setContextPath(str6);
                            request.setServletPath(str4);
                            request.setPathInfo(str5);
                        }
                        throw th;
                    }
                    str5 = request.getPathInfo();
                } catch (Throwable th2) {
                    th = th2;
                    str5 = null;
                }
                str4 = request.getServletPath();
            } catch (Throwable th3) {
                th = th3;
                str4 = null;
                str5 = null;
            }
            contextPath = request.getContextPath();
        } catch (Throwable th4) {
            th = th4;
            str4 = null;
            str5 = null;
            str6 = null;
        }
        classLoader = null;
        thread = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0085  */
    @Override // org.eclipse.jetty.server.handler.ScopedHandler, org.eclipse.jetty.server.handler.HandlerWrapper, org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.util.component.AggregateLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void doStart() throws Exception {
        Thread thread;
        ClassLoader classLoader;
        Context context;
        this._availability = 0;
        if (this._contextPath != null) {
            this._logger = Log.getLogger(getDisplayName() == null ? getContextPath() : getDisplayName());
            Context context2 = null;
            try {
                if (this._classLoader != null) {
                    thread = Thread.currentThread();
                    try {
                        classLoader = thread.getContextClassLoader();
                        try {
                            thread.setContextClassLoader(this._classLoader);
                        } catch (Throwable th) {
                            th = th;
                            __context.set(context2);
                            if (this._classLoader != null) {
                                thread.setContextClassLoader(classLoader);
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        classLoader = null;
                        __context.set(context2);
                        if (this._classLoader != null) {
                        }
                        throw th;
                    }
                } else {
                    thread = null;
                    classLoader = null;
                }
                if (this._mimeTypes == null) {
                    this._mimeTypes = new MimeTypes();
                }
                context = __context.get();
            } catch (Throwable th3) {
                th = th3;
                thread = null;
                classLoader = null;
            }
            try {
                __context.set(this._scontext);
                startContext();
                synchronized (this) {
                    this._availability = this._shutdown ? 2 : this._available ? 1 : 3;
                }
                __context.set(context);
                if (this._classLoader == null) {
                    return;
                }
                thread.setContextClassLoader(classLoader);
                return;
            } catch (Throwable th4) {
                th = th4;
                context2 = context;
                __context.set(context2);
                if (this._classLoader != null) {
                }
                throw th;
            }
        }
        throw new IllegalStateException("Null contextPath");
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00b6  */
    @Override // org.eclipse.jetty.server.handler.HandlerWrapper, org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.util.component.AggregateLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void doStop() throws Exception {
        ClassLoader classLoader;
        Throwable th;
        Thread thread;
        this._availability = 0;
        Context context = __context.get();
        __context.set(this._scontext);
        try {
            if (this._classLoader != null) {
                thread = Thread.currentThread();
                try {
                    classLoader = thread.getContextClassLoader();
                } catch (Throwable th2) {
                    classLoader = null;
                    th = th2;
                    LOG.info("stopped {}", this);
                    __context.set(context);
                    if (this._classLoader != null) {
                        thread.setContextClassLoader(classLoader);
                    }
                    throw th;
                }
                try {
                    thread.setContextClassLoader(this._classLoader);
                } catch (Throwable th3) {
                    th = th3;
                    LOG.info("stopped {}", this);
                    __context.set(context);
                    if (this._classLoader != null) {
                    }
                    throw th;
                }
            } else {
                thread = null;
                classLoader = null;
            }
            super.doStop();
            if (this._contextListeners != null) {
                ServletContextEvent servletContextEvent = new ServletContextEvent(this._scontext);
                int size = LazyList.size(this._contextListeners);
                while (true) {
                    int i = size - 1;
                    if (size <= 0) {
                        break;
                    }
                    ((ServletContextListener) LazyList.get(this._contextListeners, i)).contextDestroyed(servletContextEvent);
                    size = i;
                }
            }
            setEventListeners((EventListener[]) LazyList.toArray(this._durableListeners, EventListener.class));
            this._durableListeners = null;
            if (this._errorHandler != null) {
                this._errorHandler.stop();
            }
            Enumeration attributeNames = this._scontext.getAttributeNames();
            while (attributeNames.hasMoreElements()) {
                checkManagedAttribute((String) attributeNames.nextElement(), null);
            }
            LOG.info("stopped {}", this);
            __context.set(context);
            if (this._classLoader != null) {
                thread.setContextClassLoader(classLoader);
            }
            this._contextAttributes.clearAttributes();
        } catch (Throwable th4) {
            classLoader = null;
            th = th4;
            thread = null;
        }
    }

    @Override // org.eclipse.jetty.server.handler.AbstractHandlerContainer, org.eclipse.jetty.util.component.AggregateLifeCycle, org.eclipse.jetty.util.component.Dumpable
    public void dump(Appendable appendable, String str) throws IOException {
        dumpThis(appendable);
        AggregateLifeCycle.dump(appendable, str, Collections.singletonList(new CLDump(getClassLoader())), TypeUtil.asList(getHandlers()), getBeans(), this._initParams.entrySet(), this._attributes.getAttributeEntrySet(), this._contextAttributes.getAttributeEntrySet());
    }

    public List<AliasCheck> getAliasChecks() {
        return this._aliasChecks;
    }

    public boolean getAllowNullPathInfo() {
        return this._allowNullPathInfo;
    }

    @Override // org.eclipse.jetty.util.Attributes
    public Object getAttribute(String str) {
        return this._attributes.getAttribute(str);
    }

    @Override // org.eclipse.jetty.util.Attributes
    public Enumeration getAttributeNames() {
        return AttributesMap.getAttributeNamesCopy(this._attributes);
    }

    public Attributes getAttributes() {
        return this._attributes;
    }

    public Resource getBaseResource() {
        Resource resource = this._baseResource;
        if (resource == null) {
            return null;
        }
        return resource;
    }

    public ClassLoader getClassLoader() {
        return this._classLoader;
    }

    public String getClassPath() {
        ClassLoader classLoader = this._classLoader;
        if (classLoader == null || !(classLoader instanceof URLClassLoader)) {
            return null;
        }
        URL[] uRLs = ((URLClassLoader) classLoader).getURLs();
        StringBuilder sb = new StringBuilder();
        for (URL url : uRLs) {
            try {
                File file = newResource(url).getFile();
                if (file != null && file.exists()) {
                    if (sb.length() > 0) {
                        sb.append(File.pathSeparatorChar);
                    }
                    sb.append(file.getAbsolutePath());
                }
            } catch (IOException e) {
                LOG.debug(e);
            }
        }
        if (sb.length() != 0) {
            return sb.toString();
        }
        return null;
    }

    public String[] getConnectorNames() {
        Set<String> set = this._connectors;
        if (set == null || set.size() == 0) {
            return null;
        }
        Set<String> set2 = this._connectors;
        return (String[]) set2.toArray(new String[set2.size()]);
    }

    public String getContextPath() {
        return this._contextPath;
    }

    public String getDisplayName() {
        return this._displayName;
    }

    public ErrorHandler getErrorHandler() {
        return this._errorHandler;
    }

    public EventListener[] getEventListeners() {
        return this._eventListeners;
    }

    public String getInitParameter(String str) {
        return this._initParams.get(str);
    }

    public Enumeration getInitParameterNames() {
        return Collections.enumeration(this._initParams.keySet());
    }

    public Map<String, String> getInitParams() {
        return this._initParams;
    }

    public String getLocaleEncoding(String str) {
        Map<String, String> map = this._localeEncodingMap;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public String getLocaleEncoding(Locale locale) {
        Map<String, String> map = this._localeEncodingMap;
        if (map == null) {
            return null;
        }
        String str = map.get(locale.toString());
        return str == null ? this._localeEncodingMap.get(locale.getLanguage()) : str;
    }

    public Logger getLogger() {
        return this._logger;
    }

    public int getMaxFormContentSize() {
        return this._maxFormContentSize;
    }

    public int getMaxFormKeys() {
        return this._maxFormKeys;
    }

    public MimeTypes getMimeTypes() {
        if (this._mimeTypes == null) {
            this._mimeTypes = new MimeTypes();
        }
        return this._mimeTypes;
    }

    public String[] getProtectedTargets() {
        String[] strArr = this._protectedTargets;
        if (strArr == null) {
            return null;
        }
        String[] strArr2 = new String[strArr.length];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        return strArr2;
    }

    public Resource getResource(String str) throws MalformedURLException {
        if (str == null || !str.startsWith("/")) {
            throw new MalformedURLException(str);
        }
        if (this._baseResource == null) {
            return null;
        }
        try {
            String canonicalPath = URIUtil.canonicalPath(str);
            Resource addPath = this._baseResource.addPath(canonicalPath);
            if (!checkAlias(canonicalPath, addPath)) {
                return null;
            }
            return addPath;
        } catch (Exception e) {
            LOG.ignore(e);
            return null;
        }
    }

    public String getResourceBase() {
        Resource resource = this._baseResource;
        if (resource == null) {
            return null;
        }
        return resource.toString();
    }

    public Set<String> getResourcePaths(String str) {
        try {
            String canonicalPath = URIUtil.canonicalPath(str);
            Resource resource = getResource(canonicalPath);
            if (resource != null && resource.exists()) {
                if (!canonicalPath.endsWith("/")) {
                    canonicalPath = canonicalPath + "/";
                }
                String[] list = resource.list();
                if (list != null) {
                    HashSet hashSet = new HashSet();
                    for (int i = 0; i < list.length; i++) {
                        hashSet.add(canonicalPath + list[i]);
                    }
                    return hashSet;
                }
            }
        } catch (Exception e) {
            LOG.ignore(e);
        }
        return Collections.emptySet();
    }

    public Context getServletContext() {
        return this._scontext;
    }

    public String[] getVirtualHosts() {
        return this._vhosts;
    }

    public String[] getWelcomeFiles() {
        return this._welcomeFiles;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [org.eclipse.jetty.server.handler.ContextHandler$Context, java.lang.Object] */
    public void handle(Runnable runnable) {
        ClassLoader classLoader;
        Thread thread;
        ClassLoader classLoader2 = null;
        try {
            Context context = __context.get();
            try {
                __context.set(this._scontext);
                if (this._classLoader != null) {
                    thread = Thread.currentThread();
                    try {
                        classLoader2 = thread.getContextClassLoader();
                        thread.setContextClassLoader(this._classLoader);
                    } catch (Throwable th) {
                        th = th;
                        classLoader = classLoader2;
                        classLoader2 = context;
                        __context.set(classLoader2);
                        if (classLoader != null) {
                            thread.setContextClassLoader(classLoader);
                        }
                        throw th;
                    }
                } else {
                    thread = null;
                }
                runnable.run();
                __context.set(context);
                if (classLoader2 == null) {
                    return;
                }
                thread.setContextClassLoader(classLoader2);
            } catch (Throwable th2) {
                th = th2;
                thread = null;
                classLoader2 = context;
                classLoader = null;
            }
        } catch (Throwable th3) {
            th = th3;
            classLoader = null;
            thread = null;
        }
    }

    public boolean isAliases() {
        return this._aliasesAllowed;
    }

    public boolean isAvailable() {
        boolean z;
        synchronized (this) {
            z = this._available;
        }
        return z;
    }

    public boolean isCompactPath() {
        return this._compactPath;
    }

    public boolean isProtectedTarget(String str) {
        boolean z = false;
        if (str != null && this._protectedTargets != null) {
            while (str.startsWith("//")) {
                str = URIUtil.compactPath(str);
            }
            int i = 0;
            while (!z) {
                String[] strArr = this._protectedTargets;
                if (i >= strArr.length) {
                    break;
                }
                int i2 = i + 1;
                boolean startsWithIgnoreCase = StringUtil.startsWithIgnoreCase(str, strArr[i]);
                i = i2;
                z = startsWithIgnoreCase;
            }
        }
        return z;
    }

    public boolean isShutdown() {
        boolean z;
        synchronized (this) {
            z = !this._shutdown;
        }
        return z;
    }

    public synchronized Class<?> loadClass(String str) throws ClassNotFoundException {
        if (str == null) {
            return null;
        }
        if (this._classLoader == null) {
            return Loader.loadClass(getClass(), str);
        }
        return this._classLoader.loadClass(str);
    }

    public Resource newResource(String str) throws IOException {
        return Resource.newResource(str);
    }

    public Resource newResource(URL url) throws IOException {
        return Resource.newResource(url);
    }

    @Override // org.eclipse.jetty.util.Attributes
    public void removeAttribute(String str) {
        checkManagedAttribute(str, null);
        this._attributes.removeAttribute(str);
    }

    public void removeVirtualHosts(String[] strArr) {
        String[] strArr2;
        if (strArr == null || (strArr2 = this._vhosts) == null || strArr2.length == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(this._vhosts));
        for (String str : strArr) {
            String normalizeHostname = normalizeHostname(str);
            if (arrayList.contains(normalizeHostname)) {
                arrayList.remove(normalizeHostname);
            }
        }
        if (arrayList.isEmpty()) {
            this._vhosts = null;
        } else {
            this._vhosts = (String[]) arrayList.toArray(new String[0]);
        }
    }

    public void restrictEventListener(EventListener eventListener) {
    }

    public void setAliases(boolean z) {
        this._aliasesAllowed = z;
    }

    public void setAllowNullPathInfo(boolean z) {
        this._allowNullPathInfo = z;
    }

    @Override // org.eclipse.jetty.util.Attributes
    public void setAttribute(String str, Object obj) {
        checkManagedAttribute(str, obj);
        this._attributes.setAttribute(str, obj);
    }

    public void setAttributes(Attributes attributes) {
        this._attributes.clearAttributes();
        this._attributes.addAll(attributes);
        Enumeration<String> attributeNames = this._attributes.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String nextElement = attributeNames.nextElement();
            checkManagedAttribute(nextElement, attributes.getAttribute(nextElement));
        }
    }

    public void setAvailable(boolean z) {
        synchronized (this) {
            this._available = z;
            this._availability = isRunning() ? this._shutdown ? 2 : this._available ? 1 : 3 : 0;
        }
    }

    public void setBaseResource(Resource resource) {
        this._baseResource = resource;
    }

    public void setClassLoader(ClassLoader classLoader) {
        this._classLoader = classLoader;
    }

    public void setCompactPath(boolean z) {
        this._compactPath = z;
    }

    public void setConnectorNames(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            this._connectors = null;
        } else {
            this._connectors = new HashSet(Arrays.asList(strArr));
        }
    }

    public void setContextPath(String str) {
        if (str == null || str.length() <= 1 || !str.endsWith("/")) {
            this._contextPath = str;
            if (getServer() == null) {
                return;
            }
            if (!getServer().isStarting() && !getServer().isStarted()) {
                return;
            }
            Handler[] childHandlersByClass = getServer().getChildHandlersByClass(ContextHandlerCollection.class);
            for (int i = 0; childHandlersByClass != null && i < childHandlersByClass.length; i++) {
                ((ContextHandlerCollection) childHandlersByClass[i]).mapContexts();
            }
            return;
        }
        throw new IllegalArgumentException("ends with /");
    }

    public void setDisplayName(String str) {
        this._displayName = str;
    }

    public void setErrorHandler(ErrorHandler errorHandler) {
        if (errorHandler != null) {
            errorHandler.setServer(getServer());
        }
        if (getServer() != null) {
            getServer().getContainer().update((Object) this, (Object) this._errorHandler, (Object) errorHandler, "errorHandler", true);
        }
        this._errorHandler = errorHandler;
    }

    public void setEventListeners(EventListener[] eventListenerArr) {
        this._contextListeners = null;
        this._contextAttributeListeners = null;
        this._requestListeners = null;
        this._requestAttributeListeners = null;
        this._eventListeners = eventListenerArr;
        for (int i = 0; eventListenerArr != null && i < eventListenerArr.length; i++) {
            EventListener eventListener = this._eventListeners[i];
            if (eventListener instanceof ServletContextListener) {
                this._contextListeners = LazyList.add(this._contextListeners, eventListener);
            }
            if (eventListener instanceof ServletContextAttributeListener) {
                this._contextAttributeListeners = LazyList.add(this._contextAttributeListeners, eventListener);
            }
            if (eventListener instanceof ServletRequestListener) {
                this._requestListeners = LazyList.add(this._requestListeners, eventListener);
            }
            if (eventListener instanceof ServletRequestAttributeListener) {
                this._requestAttributeListeners = LazyList.add(this._requestAttributeListeners, eventListener);
            }
        }
    }

    public String setInitParameter(String str, String str2) {
        return this._initParams.put(str, str2);
    }

    public void setLogger(Logger logger) {
        this._logger = logger;
    }

    public void setManagedAttribute(String str, Object obj) {
        getServer().getContainer().update((Object) this, this._managedAttributes.put(str, obj), obj, str, true);
    }

    public void setMaxFormContentSize(int i) {
        this._maxFormContentSize = i;
    }

    public void setMaxFormKeys(int i) {
        this._maxFormKeys = i;
    }

    public void setMimeTypes(MimeTypes mimeTypes) {
        this._mimeTypes = mimeTypes;
    }

    public void setProtectedTargets(String[] strArr) {
        if (strArr == null) {
            this._protectedTargets = null;
            return;
        }
        String[] strArr2 = new String[strArr.length];
        this._protectedTargets = strArr2;
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
    }

    public void setResourceBase(String str) {
        try {
            setBaseResource(newResource(str));
        } catch (Exception e) {
            LOG.warn(e.toString(), new Object[0]);
            LOG.debug(e);
            throw new IllegalArgumentException(str);
        }
    }

    @Override // org.eclipse.jetty.server.handler.HandlerWrapper, org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.server.Handler
    public void setServer(Server server) {
        if (this._errorHandler == null) {
            super.setServer(server);
            return;
        }
        Server server2 = getServer();
        if (server2 != null && server2 != server) {
            server2.getContainer().update((Object) this, (Object) this._errorHandler, (Object) null, "error", true);
        }
        super.setServer(server);
        if (server != null && server != server2) {
            server.getContainer().update((Object) this, (Object) null, (Object) this._errorHandler, "error", true);
        }
        this._errorHandler.setServer(server);
    }

    @Override // org.eclipse.jetty.server.Server.Graceful
    public void setShutdown(boolean z) {
        synchronized (this) {
            this._shutdown = z;
            this._availability = isRunning() ? this._shutdown ? 2 : this._available ? 1 : 3 : 0;
        }
    }

    public void setVirtualHosts(String[] strArr) {
        if (strArr == null) {
            this._vhosts = strArr;
            return;
        }
        this._vhosts = new String[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            this._vhosts[i] = normalizeHostname(strArr[i]);
        }
    }

    public void setWelcomeFiles(String[] strArr) {
        this._welcomeFiles = strArr;
    }

    public void startContext() throws Exception {
        String str = this._initParams.get(MANAGED_ATTRIBUTES);
        if (str != null) {
            this._managedAttributes = new HashMap();
            for (String str2 : str.split(",")) {
                this._managedAttributes.put(str2, null);
            }
            Enumeration attributeNames = this._scontext.getAttributeNames();
            while (attributeNames.hasMoreElements()) {
                String str3 = (String) attributeNames.nextElement();
                checkManagedAttribute(str3, this._scontext.getAttribute(str3));
            }
        }
        super.doStart();
        ErrorHandler errorHandler = this._errorHandler;
        if (errorHandler != null) {
            errorHandler.start();
        }
        if (this._contextListeners != null) {
            ServletContextEvent servletContextEvent = new ServletContextEvent(this._scontext);
            for (int i = 0; i < LazyList.size(this._contextListeners); i++) {
                callContextInitialized((ServletContextListener) LazyList.get(this._contextListeners, i), servletContextEvent);
            }
        }
    }

    public String toString() {
        String name;
        String[] virtualHosts = getVirtualHosts();
        StringBuilder sb = new StringBuilder();
        Package r2 = getClass().getPackage();
        if (r2 != null && (name = r2.getName()) != null && name.length() > 0) {
            for (String str : name.split("\\.")) {
                sb.append(str.charAt(0));
                sb.append('.');
            }
        }
        sb.append(getClass().getSimpleName());
        sb.append('{');
        sb.append(getContextPath());
        sb.append(',');
        sb.append(getBaseResource());
        if (virtualHosts != null && virtualHosts.length > 0) {
            sb.append(',');
            sb.append(virtualHosts[0]);
        }
        sb.append('}');
        return sb.toString();
    }
}
