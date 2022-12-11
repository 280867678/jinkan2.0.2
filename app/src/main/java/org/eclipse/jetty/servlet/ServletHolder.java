package org.eclipse.jetty.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import javax.servlet.MultipartConfigElement;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletSecurityElement;
import javax.servlet.SingleThreadModel;
import javax.servlet.UnavailableException;
import me.tvspark.outline;
import org.eclipse.jetty.security.IdentityService;
import org.eclipse.jetty.security.RunAsToken;
import org.eclipse.jetty.server.Dispatcher;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.UserIdentity;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.servlet.Holder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.util.Loader;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: classes5.dex */
public class ServletHolder extends Holder<Servlet> implements UserIdentity.Scope, Comparable {
    public static final Logger LOG = Log.getLogger(ServletHolder.class);
    public static final Map<String, String> NO_MAPPED_ROLES = Collections.emptyMap();
    public transient Config _config;
    public transient boolean _enabled;
    public String _forcedPath;
    public IdentityService _identityService;
    public boolean _initOnStartup;
    public int _initOrder;
    public ServletRegistration.Dynamic _registration;
    public Map<String, String> _roleMap;
    public String _runAsRole;
    public RunAsToken _runAsToken;
    public transient Servlet _servlet;
    public transient long _unavailable;
    public transient UnavailableException _unavailableEx;

    /* loaded from: classes5.dex */
    public class Config extends Holder<Servlet>.HolderConfig implements ServletConfig {
        public Config() {
            super();
        }

        @Override // javax.servlet.ServletConfig
        public String getServletName() {
            return ServletHolder.this.getName();
        }
    }

    /* loaded from: classes5.dex */
    public class Registration extends Holder<Servlet>.HolderRegistration implements ServletRegistration.Dynamic {
        public MultipartConfigElement _multipartConfig;

        public Registration() {
            super();
        }

        @Override // javax.servlet.ServletRegistration
        public Set<String> addMapping(String... strArr) {
            ServletHolder.this.illegalStateIfContextStarted();
            HashSet hashSet = null;
            for (String str : strArr) {
                ServletMapping servletMapping = ServletHolder.this._servletHandler.getServletMapping(str);
                if (servletMapping != null && !servletMapping.isDefault()) {
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(str);
                }
            }
            if (hashSet != null) {
                return hashSet;
            }
            ServletMapping servletMapping2 = new ServletMapping();
            servletMapping2.setServletName(ServletHolder.this.getName());
            servletMapping2.setPathSpecs(strArr);
            ServletHolder.this._servletHandler.addServletMapping(servletMapping2);
            return Collections.emptySet();
        }

        @Override // org.eclipse.jetty.servlet.Holder.HolderRegistration, javax.servlet.Registration
        public /* bridge */ /* synthetic */ String getClassName() {
            return super.getClassName();
        }

        public int getInitOrder() {
            return ServletHolder.this.getInitOrder();
        }

        @Override // org.eclipse.jetty.servlet.Holder.HolderRegistration, javax.servlet.Registration
        public /* bridge */ /* synthetic */ String getInitParameter(String str) {
            return super.getInitParameter(str);
        }

        @Override // org.eclipse.jetty.servlet.Holder.HolderRegistration, javax.servlet.Registration
        public /* bridge */ /* synthetic */ Map getInitParameters() {
            return super.getInitParameters();
        }

        @Override // javax.servlet.ServletRegistration
        public Collection<String> getMappings() {
            String[] pathSpecs;
            ServletMapping[] servletMappings = ServletHolder.this._servletHandler.getServletMappings();
            ArrayList arrayList = new ArrayList();
            if (servletMappings != null) {
                for (ServletMapping servletMapping : servletMappings) {
                    if (servletMapping.getServletName().equals(getName()) && (pathSpecs = servletMapping.getPathSpecs()) != null && pathSpecs.length > 0) {
                        arrayList.addAll(Arrays.asList(pathSpecs));
                    }
                }
            }
            return arrayList;
        }

        public MultipartConfigElement getMultipartConfig() {
            return this._multipartConfig;
        }

        @Override // org.eclipse.jetty.servlet.Holder.HolderRegistration, javax.servlet.Registration
        public /* bridge */ /* synthetic */ String getName() {
            return super.getName();
        }

        @Override // javax.servlet.ServletRegistration
        public String getRunAsRole() {
            return ServletHolder.this._runAsRole;
        }

        @Override // org.eclipse.jetty.servlet.Holder.HolderRegistration, javax.servlet.Registration.Dynamic
        public /* bridge */ /* synthetic */ void setAsyncSupported(boolean z) {
            super.setAsyncSupported(z);
        }

        @Override // org.eclipse.jetty.servlet.Holder.HolderRegistration
        public /* bridge */ /* synthetic */ void setDescription(String str) {
            super.setDescription(str);
        }

        @Override // org.eclipse.jetty.servlet.Holder.HolderRegistration, javax.servlet.Registration
        public /* bridge */ /* synthetic */ boolean setInitParameter(String str, String str2) {
            return super.setInitParameter(str, str2);
        }

        @Override // org.eclipse.jetty.servlet.Holder.HolderRegistration, javax.servlet.Registration
        public /* bridge */ /* synthetic */ Set setInitParameters(Map map) {
            return super.setInitParameters(map);
        }

        @Override // javax.servlet.ServletRegistration.Dynamic
        public void setLoadOnStartup(int i) {
            ServletHolder.this.illegalStateIfContextStarted();
            ServletHolder.this.setInitOrder(i);
        }

        @Override // javax.servlet.ServletRegistration.Dynamic
        public void setMultipartConfig(MultipartConfigElement multipartConfigElement) {
            this._multipartConfig = multipartConfigElement;
        }

        @Override // javax.servlet.ServletRegistration.Dynamic
        public void setRunAsRole(String str) {
            ServletHolder.this._runAsRole = str;
        }

        @Override // javax.servlet.ServletRegistration.Dynamic
        public Set<String> setServletSecurity(ServletSecurityElement servletSecurityElement) {
            return ServletHolder.this._servletHandler.setServletSecurity(this, servletSecurityElement);
        }
    }

    /* loaded from: classes5.dex */
    public class SingleThreadedWrapper implements Servlet {
        public Stack<Servlet> _stack;

        public SingleThreadedWrapper() {
            this._stack = new Stack<>();
        }

        @Override // javax.servlet.Servlet
        public void destroy() {
            synchronized (this) {
                while (this._stack.size() > 0) {
                    try {
                        this._stack.pop().destroy();
                    } catch (Exception e) {
                        ServletHolder.LOG.warn(e);
                    }
                }
            }
        }

        @Override // javax.servlet.Servlet
        public ServletConfig getServletConfig() {
            return ServletHolder.this._config;
        }

        @Override // javax.servlet.Servlet
        public String getServletInfo() {
            return null;
        }

        @Override // javax.servlet.Servlet
        public void init(ServletConfig servletConfig) throws ServletException {
            synchronized (this) {
                if (this._stack.size() == 0) {
                    try {
                        Servlet newInstance = ServletHolder.this.newInstance();
                        newInstance.init(servletConfig);
                        this._stack.push(newInstance);
                    } catch (ServletException e) {
                        throw e;
                    } catch (Exception e2) {
                        throw new ServletException(e2);
                    }
                }
            }
        }

        @Override // javax.servlet.Servlet
        public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
            Servlet newInstance;
            synchronized (this) {
                if (this._stack.size() > 0) {
                    newInstance = this._stack.pop();
                } else {
                    try {
                        newInstance = ServletHolder.this.newInstance();
                        newInstance.init(ServletHolder.this._config);
                    } catch (ServletException e) {
                        throw e;
                    } catch (Exception e2) {
                        throw new ServletException(e2);
                    }
                }
            }
            try {
                newInstance.service(servletRequest, servletResponse);
                synchronized (this) {
                    this._stack.push(newInstance);
                }
            } catch (Throwable th) {
                synchronized (this) {
                    this._stack.push(newInstance);
                    throw th;
                }
            }
        }
    }

    public ServletHolder() {
        this(Holder.Source.EMBEDDED);
    }

    public ServletHolder(Class<? extends Servlet> cls) {
        this(Holder.Source.EMBEDDED);
        setHeldClass(cls);
    }

    public ServletHolder(String str, Class<? extends Servlet> cls) {
        this(Holder.Source.EMBEDDED);
        setName(str);
        setHeldClass(cls);
    }

    public ServletHolder(String str, Servlet servlet) {
        this(Holder.Source.EMBEDDED);
        setName(str);
        setServlet(servlet);
    }

    public ServletHolder(Servlet servlet) {
        this(Holder.Source.EMBEDDED);
        setServlet(servlet);
    }

    public ServletHolder(Holder.Source source) {
        super(source);
        this._initOnStartup = false;
        this._enabled = true;
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x008f: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:49:0x008f */
    private void initServlet() throws ServletException {
        Object obj;
        Object runAs;
        Object obj2 = null;
        try {
            try {
                if (this._servlet == null) {
                    this._servlet = newInstance();
                }
                if (this._config == null) {
                    this._config = new Config();
                }
                runAs = this._identityService != null ? this._identityService.setRunAs(this._identityService.getSystemUserIdentity(), this._runAsToken) : null;
            } catch (Throwable th) {
                th = th;
                obj2 = obj;
            }
        } catch (UnavailableException e) {
            e = e;
        } catch (ServletException e2) {
            e = e2;
        } catch (Exception e3) {
            e = e3;
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            if (isJspServlet()) {
                initJspServlet();
            }
            initMultiPart();
            this._servlet.init(this._config);
            IdentityService identityService = this._identityService;
            if (identityService == null) {
                return;
            }
            identityService.unsetRunAs(runAs);
        } catch (UnavailableException e4) {
            e = e4;
            makeUnavailable(e);
            this._servlet = null;
            this._config = null;
            throw e;
        } catch (ServletException e5) {
            e = e5;
            makeUnavailable(e.getCause() == null ? e : e.getCause());
            this._servlet = null;
            this._config = null;
            throw e;
        } catch (Exception e6) {
            e = e6;
            makeUnavailable(e);
            this._servlet = null;
            this._config = null;
            throw new ServletException(toString(), e);
        } catch (Throwable th3) {
            Object obj3 = runAs;
            th = th3;
            obj2 = obj3;
            IdentityService identityService2 = this._identityService;
            if (identityService2 != null) {
                identityService2.unsetRunAs(obj2);
            }
            throw th;
        }
    }

    private boolean isJspServlet() {
        Servlet servlet = this._servlet;
        boolean z = false;
        if (servlet == null) {
            return false;
        }
        for (Class<?> cls = servlet.getClass(); cls != null && !z; cls = cls.getSuperclass()) {
            z = isJspServlet(cls.getName());
        }
        return z;
    }

    private boolean isJspServlet(String str) {
        if (str == null) {
            return false;
        }
        return "org.apache.jasper.servlet.JspServlet".equals(str);
    }

    private void makeUnavailable(final Throwable th) {
        if (th instanceof UnavailableException) {
            makeUnavailable((UnavailableException) th);
            return;
        }
        ServletContext servletContext = this._servletHandler.getServletContext();
        if (servletContext == null) {
            LOG.info("unavailable", th);
        } else {
            servletContext.log("unavailable", th);
        }
        this._unavailableEx = new UnavailableException(String.valueOf(th), -1) { // from class: org.eclipse.jetty.servlet.ServletHolder.1
            {
                initCause(th);
            }
        };
        this._unavailable = -1L;
    }

    private void makeUnavailable(UnavailableException unavailableException) {
        if (this._unavailableEx != unavailableException || this._unavailable == 0) {
            this._servletHandler.getServletContext().log("unavailable", unavailableException);
            this._unavailableEx = unavailableException;
            long j = -1;
            this._unavailable = -1L;
            if (!unavailableException.isPermanent()) {
                j = System.currentTimeMillis() + (this._unavailableEx.getUnavailableSeconds() > 0 ? this._unavailableEx.getUnavailableSeconds() * 1000 : 5000L);
            }
            this._unavailable = j;
        }
    }

    public void checkServletType() throws UnavailableException {
        Class<? extends T> cls = this._class;
        if (cls == 0 || !Servlet.class.isAssignableFrom(cls)) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Servlet ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._class);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" is not a javax.servlet.Servlet");
            throw new UnavailableException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        String str;
        if (obj instanceof ServletHolder) {
            ServletHolder servletHolder = (ServletHolder) obj;
            int i = 0;
            if (servletHolder == this) {
                return 0;
            }
            int i2 = servletHolder._initOrder;
            int i3 = this._initOrder;
            if (i2 < i3) {
                return 1;
            }
            if (i2 > i3) {
                return -1;
            }
            String str2 = this._className;
            if (str2 != null && (str = servletHolder._className) != null) {
                i = str2.compareTo(str);
            }
            return i == 0 ? this._name.compareTo(servletHolder._name) : i;
        }
        return 1;
    }

    @Override // org.eclipse.jetty.servlet.Holder
    public void destroyInstance(Object obj) throws Exception {
        if (obj == null) {
            return;
        }
        Servlet servlet = (Servlet) obj;
        getServletHandler().destroyServlet(servlet);
        servlet.destroy();
    }

    @Override // org.eclipse.jetty.servlet.Holder, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        String str;
        this._unavailable = 0L;
        if (!this._enabled) {
            return;
        }
        try {
            super.doStart();
        } catch (UnavailableException e) {
            e = e;
            makeUnavailable(e);
            if (!this._servletHandler.isStartWithUnavailable()) {
                throw e;
            }
        }
        try {
            checkServletType();
            IdentityService identityService = this._servletHandler.getIdentityService();
            this._identityService = identityService;
            if (identityService != null && (str = this._runAsRole) != null) {
                this._runAsToken = identityService.newRunAsToken(str);
            }
            this._config = new Config();
            Class<? extends T> cls = this._class;
            if (cls != 0 && SingleThreadModel.class.isAssignableFrom(cls)) {
                this._servlet = new SingleThreadedWrapper();
            }
            if (!this._extInstance && !this._initOnStartup) {
                return;
            }
            try {
                initServlet();
            } catch (Exception e2) {
                if (!this._servletHandler.isStartWithUnavailable()) {
                    throw e2;
                }
                LOG.ignore(e2);
            }
        } catch (UnavailableException e3) {
            e = e3;
            makeUnavailable(e);
            if (!this._servletHandler.isStartWithUnavailable()) {
                throw e;
            }
            LOG.ignore(e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:5:0x004f  */
    @Override // org.eclipse.jetty.servlet.Holder, org.eclipse.jetty.util.component.AbstractLifeCycle
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void doStop() throws Exception {
        Object obj;
        IdentityService identityService;
        Object runAs;
        Object obj2 = null;
        if (this._servlet != null) {
            try {
                runAs = this._identityService != null ? this._identityService.setRunAs(this._identityService.getSystemUserIdentity(), this._runAsToken) : null;
            } catch (Exception e) {
                e = e;
                obj = null;
            } catch (Throwable th) {
                th = th;
            }
            try {
                destroyInstance(this._servlet);
                IdentityService identityService2 = this._identityService;
                if (identityService2 != null) {
                    identityService2.unsetRunAs(runAs);
                }
            } catch (Exception e2) {
                obj = runAs;
                e = e2;
                try {
                    LOG.warn(e);
                    IdentityService identityService3 = this._identityService;
                    if (identityService3 != null) {
                        identityService3.unsetRunAs(obj);
                    }
                    if (!this._extInstance) {
                    }
                    this._config = null;
                } catch (Throwable th2) {
                    th = th2;
                    obj2 = obj;
                    identityService = this._identityService;
                    if (identityService != null) {
                        identityService.unsetRunAs(obj2);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                obj2 = runAs;
                th = th3;
                identityService = this._identityService;
                if (identityService != null) {
                }
                throw th;
            }
        }
        if (!this._extInstance) {
            this._servlet = null;
        }
        this._config = null;
    }

    public boolean equals(Object obj) {
        return compareTo(obj) == 0;
    }

    @Override // org.eclipse.jetty.server.UserIdentity.Scope
    public String getContextPath() {
        return this._config.getServletContext().getContextPath();
    }

    public String getForcedPath() {
        return this._forcedPath;
    }

    public int getInitOrder() {
        return this._initOrder;
    }

    public ServletRegistration.Dynamic getRegistration() {
        if (this._registration == null) {
            this._registration = new Registration();
        }
        return this._registration;
    }

    public Map<String, String> getRoleMap() {
        Map<String, String> map = this._roleMap;
        return map == null ? NO_MAPPED_ROLES : map;
    }

    @Override // org.eclipse.jetty.server.UserIdentity.Scope
    public Map<String, String> getRoleRefMap() {
        return this._roleMap;
    }

    public String getRunAsRole() {
        return this._runAsRole;
    }

    public synchronized Servlet getServlet() throws ServletException {
        if (this._unavailable != 0) {
            if (this._unavailable < 0 || (this._unavailable > 0 && System.currentTimeMillis() < this._unavailable)) {
                throw this._unavailableEx;
            }
            this._unavailable = 0L;
            this._unavailableEx = null;
        }
        if (this._servlet == null) {
            initServlet();
        }
        return this._servlet;
    }

    public Servlet getServletInstance() {
        return this._servlet;
    }

    public UnavailableException getUnavailableException() {
        return this._unavailableEx;
    }

    public String getUserRoleLink(String str) {
        String str2;
        Map<String, String> map = this._roleMap;
        return (map == null || (str2 = map.get(str)) == null) ? str : str2;
    }

    public void handle(Request request, ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, UnavailableException, IOException {
        if (this._class != null) {
            Servlet servlet = this._servlet;
            synchronized (this) {
                if (!isStarted()) {
                    throw new UnavailableException("Servlet not initialized", -1);
                }
                if (this._unavailable != 0 || !this._initOnStartup) {
                    servlet = getServlet();
                }
                if (servlet == null) {
                    throw new UnavailableException("Could not instantiate " + this._class);
                }
            }
            Object obj = null;
            boolean isAsyncSupported = request.isAsyncSupported();
            try {
                try {
                    if (this._forcedPath != null) {
                        servletRequest.setAttribute(Dispatcher.__JSP_FILE, this._forcedPath);
                    }
                    if (this._identityService != null) {
                        obj = this._identityService.setRunAs(request.getResolvedUserIdentity(), this._runAsToken);
                    }
                    if (!isAsyncSupported()) {
                        request.setAsyncSupported(false);
                    }
                    MultipartConfigElement multipartConfig = ((Registration) getRegistration()).getMultipartConfig();
                    if (multipartConfig != null) {
                        servletRequest.setAttribute(Request.__MULTIPART_CONFIG_ELEMENT, multipartConfig);
                    }
                    servlet.service(servletRequest, servletResponse);
                    request.setAsyncSupported(isAsyncSupported);
                    IdentityService identityService = this._identityService;
                    if (identityService == null) {
                        return;
                    }
                    identityService.unsetRunAs(obj);
                    return;
                } catch (UnavailableException e) {
                    makeUnavailable(e);
                    throw this._unavailableEx;
                }
            } catch (Throwable th) {
                request.setAsyncSupported(isAsyncSupported);
                IdentityService identityService2 = this._identityService;
                if (identityService2 != null) {
                    identityService2.unsetRunAs(obj);
                }
                servletRequest.setAttribute(RequestDispatcher.ERROR_SERVLET_NAME, getName());
                throw th;
            }
        }
        throw new UnavailableException("Servlet Not Initialized");
    }

    public int hashCode() {
        String str = this._name;
        return str == null ? System.identityHashCode(this) : str.hashCode();
    }

    public void initJspServlet() throws Exception {
        ContextHandler contextHandler = ((ContextHandler.Context) getServletHandler().getServletContext()).getContextHandler();
        contextHandler.setAttribute("org.apache.catalina.jsp_classpath", contextHandler.getClassPath());
        setInitParameter("com.sun.appserv.jsp.classpath", Loader.getClassPath(contextHandler.getClassLoader().getParent()));
        if ("?".equals(getInitParameter("classpath"))) {
            String classPath = contextHandler.getClassPath();
            LOG.debug(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("classpath=", classPath), new Object[0]);
            if (classPath == null) {
                return;
            }
            setInitParameter("classpath", classPath);
        }
    }

    public void initMultiPart() throws Exception {
        if (((Registration) getRegistration()).getMultipartConfig() != null) {
            ((ContextHandler.Context) getServletHandler().getServletContext()).getContextHandler().addEventListener(new Request.MultiPartCleanerListener());
        }
    }

    public boolean isAvailable() {
        if (!isStarted() || this._unavailable != 0) {
            try {
                getServlet();
            } catch (Exception e) {
                LOG.ignore(e);
            }
            return isStarted() && this._unavailable == 0;
        }
        return true;
    }

    public boolean isEnabled() {
        return this._enabled;
    }

    public boolean isSetInitOrder() {
        return this._initOnStartup;
    }

    public Servlet newInstance() throws ServletException, IllegalAccessException, InstantiationException {
        try {
            ServletContext servletContext = getServletHandler().getServletContext();
            return servletContext == null ? getHeldClass().newInstance() : ((ServletContextHandler.Context) servletContext).createServlet(getHeldClass());
        } catch (ServletException e) {
            Throwable rootCause = e.getRootCause();
            if (rootCause instanceof InstantiationException) {
                throw ((InstantiationException) rootCause);
            }
            if (!(rootCause instanceof IllegalAccessException)) {
                throw e;
            }
            throw ((IllegalAccessException) rootCause);
        }
    }

    public void setEnabled(boolean z) {
        this._enabled = z;
    }

    public void setForcedPath(String str) {
        this._forcedPath = str;
    }

    public void setInitOrder(int i) {
        this._initOnStartup = true;
        this._initOrder = i;
    }

    public void setRunAsRole(String str) {
        this._runAsRole = str;
    }

    public synchronized void setServlet(Servlet servlet) {
        if (servlet != null) {
            if (!(servlet instanceof SingleThreadModel)) {
                this._extInstance = true;
                this._servlet = servlet;
                setHeldClass(servlet.getClass());
                if (getName() == null) {
                    setName(servlet.getClass().getName() + "-" + super.hashCode());
                }
            }
        }
        throw new IllegalArgumentException();
    }

    public synchronized void setUserRoleLink(String str, String str2) {
        if (this._roleMap == null) {
            this._roleMap = new HashMap();
        }
        this._roleMap.put(str, str2);
    }
}
