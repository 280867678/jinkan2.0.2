package org.eclipse.jetty.security;

import java.io.IOException;
import java.security.Principal;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.DispatcherType;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSessionEvent;
import me.tvspark.ae0;
import me.tvspark.ce0;
import me.tvspark.je0;
import me.tvspark.outline;
import org.eclipse.jetty.security.Authenticator;
import org.eclipse.jetty.security.authentication.DeferredAuthentication;
import org.eclipse.jetty.server.AbstractHttpConnection;
import org.eclipse.jetty.server.Authentication;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Response;
import org.eclipse.jetty.server.UserIdentity;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.HandlerWrapper;
import org.eclipse.jetty.server.session.AbstractSessionManager;
import org.eclipse.jetty.util.component.LifeCycle;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: classes4.dex */
public abstract class SecurityHandler extends HandlerWrapper implements Authenticator.AuthConfiguration {
    public String _authMethod;
    public Authenticator _authenticator;
    public IdentityService _identityService;
    public LoginService _loginService;
    public boolean _loginServiceShared;
    public String _realmName;
    public static final Logger LOG = Log.getLogger(SecurityHandler.class);
    public static Principal __NO_USER = new Principal() { // from class: org.eclipse.jetty.security.SecurityHandler.2
        @Override // java.security.Principal
        public String getName() {
            return null;
        }

        @Override // java.security.Principal
        public String toString() {
            return "No User";
        }
    };
    public static Principal __NOBODY = new Principal() { // from class: org.eclipse.jetty.security.SecurityHandler.3
        @Override // java.security.Principal
        public String getName() {
            return "Nobody";
        }

        @Override // java.security.Principal
        public String toString() {
            return getName();
        }
    };
    public boolean _checkWelcomeFiles = false;
    public Authenticator.Factory _authenticatorFactory = new DefaultAuthenticatorFactory();
    public final Map<String, String> _initParameters = new HashMap();
    public boolean _renewSession = true;

    /* renamed from: org.eclipse.jetty.security.SecurityHandler$4 */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class C29694 {
        public static final /* synthetic */ int[] $SwitchMap$javax$servlet$DispatcherType;

        static {
            int[] iArr = new int[DispatcherType.values().length];
            $SwitchMap$javax$servlet$DispatcherType = iArr;
            try {
                DispatcherType dispatcherType = DispatcherType.REQUEST;
                iArr[2] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = $SwitchMap$javax$servlet$DispatcherType;
                DispatcherType dispatcherType2 = DispatcherType.ASYNC;
                iArr2[3] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = $SwitchMap$javax$servlet$DispatcherType;
                DispatcherType dispatcherType3 = DispatcherType.FORWARD;
                iArr3[0] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class NotChecked implements Principal {
        public NotChecked() {
        }

        @Override // java.security.Principal
        public String getName() {
            return null;
        }

        public SecurityHandler getSecurityHandler() {
            return SecurityHandler.this;
        }

        @Override // java.security.Principal
        public String toString() {
            return "NOT CHECKED";
        }
    }

    public static SecurityHandler getCurrentSecurityHandler() {
        ContextHandler.Context currentContext = ContextHandler.getCurrentContext();
        if (currentContext == null) {
            return null;
        }
        return (SecurityHandler) currentContext.getContextHandler().getChildHandlerByClass(SecurityHandler.class);
    }

    public boolean checkSecurity(Request request) {
        int ordinal = request.getDispatcherType().ordinal();
        if (ordinal != 0) {
            return ordinal == 2 || ordinal == 3;
        } else if (!this._checkWelcomeFiles || request.getAttribute("org.eclipse.jetty.server.welcome") == null) {
            return false;
        } else {
            request.removeAttribute("org.eclipse.jetty.server.welcome");
            return true;
        }
    }

    public abstract boolean checkUserDataPermissions(String str, Request request, Response response, Object obj) throws IOException;

    public abstract boolean checkWebResourcePermissions(String str, Request request, Response response, Object obj, UserIdentity userIdentity) throws IOException;

    @Override // org.eclipse.jetty.server.handler.HandlerWrapper, org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.util.component.AggregateLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        Authenticator.Factory factory;
        ContextHandler.Context currentContext = ContextHandler.getCurrentContext();
        if (currentContext != null) {
            Enumeration initParameterNames = currentContext.getInitParameterNames();
            while (initParameterNames != null && initParameterNames.hasMoreElements()) {
                String str = (String) initParameterNames.nextElement();
                if (str.startsWith("org.eclipse.jetty.security.") && getInitParameter(str) == null) {
                    setInitParameter(str, currentContext.getInitParameter(str));
                }
            }
            currentContext.getContextHandler().addEventListener(new je0() { // from class: org.eclipse.jetty.security.SecurityHandler.1
                @Override // me.tvspark.je0
                public void sessionCreated(HttpSessionEvent httpSessionEvent) {
                    Request request;
                    AbstractHttpConnection currentConnection = AbstractHttpConnection.getCurrentConnection();
                    if (currentConnection == null || (request = currentConnection.getRequest()) == null || !request.isSecure()) {
                        return;
                    }
                    httpSessionEvent.getSession().setAttribute(AbstractSessionManager.SESSION_KNOWN_ONLY_TO_AUTHENTICATED, Boolean.TRUE);
                }

                @Override // me.tvspark.je0
                public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
                }
            });
        }
        if (this._loginService == null) {
            LoginService findLoginService = findLoginService();
            this._loginService = findLoginService;
            if (findLoginService != null) {
                this._loginServiceShared = true;
            }
        }
        if (this._identityService == null) {
            LoginService loginService = this._loginService;
            if (loginService != null) {
                this._identityService = loginService.getIdentityService();
            }
            if (this._identityService == null) {
                this._identityService = findIdentityService();
            }
            if (this._identityService == null && this._realmName != null) {
                this._identityService = new DefaultIdentityService();
            }
        }
        LoginService loginService2 = this._loginService;
        if (loginService2 != null) {
            if (loginService2.getIdentityService() == null) {
                this._loginService.setIdentityService(this._identityService);
            } else if (this._loginService.getIdentityService() != this._identityService) {
                throw new IllegalStateException("LoginService has different IdentityService to " + this);
            }
        }
        if (!this._loginServiceShared) {
            LoginService loginService3 = this._loginService;
            if (loginService3 instanceof LifeCycle) {
                ((LifeCycle) loginService3).start();
            }
        }
        if (this._authenticator == null && (factory = this._authenticatorFactory) != null && this._identityService != null) {
            Authenticator authenticator = factory.getAuthenticator(getServer(), ContextHandler.getCurrentContext(), this, this._identityService, this._loginService);
            this._authenticator = authenticator;
            if (authenticator != null) {
                this._authMethod = authenticator.getAuthMethod();
            }
        }
        Authenticator authenticator2 = this._authenticator;
        if (authenticator2 != null) {
            authenticator2.setConfiguration(this);
            Authenticator authenticator3 = this._authenticator;
            if (authenticator3 instanceof LifeCycle) {
                ((LifeCycle) authenticator3).start();
            }
        } else if (this._realmName != null) {
            Logger logger = LOG;
            logger.warn("No ServerAuthentication for " + this, new Object[0]);
            throw new IllegalStateException("No ServerAuthentication");
        }
        super.doStart();
    }

    @Override // org.eclipse.jetty.server.handler.HandlerWrapper, org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.util.component.AggregateLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStop() throws Exception {
        super.doStop();
        if (!this._loginServiceShared) {
            LoginService loginService = this._loginService;
            if (!(loginService instanceof LifeCycle)) {
                return;
            }
            ((LifeCycle) loginService).stop();
        }
    }

    public IdentityService findIdentityService() {
        return (IdentityService) getServer().getBean(IdentityService.class);
    }

    public LoginService findLoginService() {
        List<LoginService> beans = getServer().getBeans(LoginService.class);
        String realmName = getRealmName();
        if (realmName == null) {
            if (beans.size() != 1) {
                return null;
            }
            return (LoginService) beans.get(0);
        }
        for (LoginService loginService : beans) {
            if (loginService.getName() != null && loginService.getName().equals(realmName)) {
                return loginService;
            }
        }
        return null;
    }

    @Override // org.eclipse.jetty.security.Authenticator.AuthConfiguration
    public String getAuthMethod() {
        return this._authMethod;
    }

    public Authenticator getAuthenticator() {
        return this._authenticator;
    }

    public Authenticator.Factory getAuthenticatorFactory() {
        return this._authenticatorFactory;
    }

    @Override // org.eclipse.jetty.security.Authenticator.AuthConfiguration
    public IdentityService getIdentityService() {
        return this._identityService;
    }

    @Override // org.eclipse.jetty.security.Authenticator.AuthConfiguration
    public String getInitParameter(String str) {
        return this._initParameters.get(str);
    }

    @Override // org.eclipse.jetty.security.Authenticator.AuthConfiguration
    public Set<String> getInitParameterNames() {
        return this._initParameters.keySet();
    }

    @Override // org.eclipse.jetty.security.Authenticator.AuthConfiguration
    public LoginService getLoginService() {
        return this._loginService;
    }

    @Override // org.eclipse.jetty.security.Authenticator.AuthConfiguration
    public String getRealmName() {
        return this._realmName;
    }

    /* JADX WARN: Code restructure failed: missing block: B:115:0x0134, code lost:
        if (r10 != null) goto L103;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x015b  */
    /* JADX WARN: Type inference failed for: r1v1, types: [org.eclipse.jetty.security.IdentityService] */
    /* JADX WARN: Type inference failed for: r21v0, types: [org.eclipse.jetty.server.Request] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    @Override // org.eclipse.jetty.server.handler.HandlerWrapper, org.eclipse.jetty.server.Handler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handle(String str, Request request, ae0 ae0Var, ce0 ce0Var) throws IOException, ServletException {
        ce0 ce0Var2;
        ?? r1;
        IdentityService identityService;
        Object obj;
        Authentication.User user;
        ae0 ae0Var2 = ae0Var;
        ce0 ce0Var3 = ce0Var;
        Response response = request.getResponse();
        Handler handler = getHandler();
        if (handler == null) {
            return;
        }
        Authenticator authenticator = this._authenticator;
        if (!checkSecurity(request)) {
            handler.handle(str, request, ae0Var2, ce0Var3);
            return;
        }
        Object prepareConstraintInfo = prepareConstraintInfo(str, request);
        if (!checkUserDataPermissions(str, request, response, prepareConstraintInfo)) {
            if (request.isHandled()) {
                return;
            }
            ce0Var3.sendError(403);
            request.setHandled(true);
            return;
        }
        boolean isAuthMandatory = isAuthMandatory(request, response, prepareConstraintInfo);
        if (isAuthMandatory && authenticator == null) {
            LOG.warn(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("No authenticator for: ", prepareConstraintInfo), new Object[0]);
            if (request.isHandled()) {
                return;
            }
            ce0Var3.sendError(403);
            request.setHandled(true);
            return;
        }
        Object obj2 = null;
        try {
            try {
                Authentication authentication = request.getAuthentication();
                if (authentication == null || authentication == Authentication.NOT_CHECKED) {
                    authentication = authenticator == null ? Authentication.UNAUTHENTICATED : authenticator.validateRequest(ae0Var2, ce0Var3, isAuthMandatory);
                }
                if (authentication instanceof Authentication.Wrapped) {
                    ae0Var2 = ((Authentication.Wrapped) authentication).getHttpServletRequest();
                    ce0Var3 = ((Authentication.Wrapped) authentication).getHttpServletResponse();
                }
                ae0 ae0Var3 = ae0Var2;
                ce0Var2 = ce0Var3;
                try {
                    if (authentication instanceof Authentication.ResponseSent) {
                        request.setHandled(true);
                    } else {
                        try {
                            if (authentication instanceof Authentication.User) {
                                Authentication.User user2 = (Authentication.User) authentication;
                                request.setAuthentication(authentication);
                                if (this._identityService != null) {
                                    obj2 = this._identityService.associate(user2.getUserIdentity());
                                }
                                Object obj3 = obj2;
                                if (isAuthMandatory) {
                                    try {
                                        user = user2;
                                    } catch (Throwable th) {
                                        th = th;
                                        obj2 = obj3;
                                    }
                                    try {
                                        if (!checkWebResourcePermissions(str, request, response, prepareConstraintInfo, user2.getUserIdentity())) {
                                            ce0Var2.sendError(403, "!role");
                                            request.setHandled(true);
                                            IdentityService identityService2 = this._identityService;
                                            if (identityService2 == null) {
                                                return;
                                            }
                                            identityService2.disassociate(obj3);
                                            return;
                                        }
                                        obj2 = obj3;
                                    } catch (ServerAuthException e) {
                                        e = e;
                                        obj2 = obj3;
                                        ce0Var2.sendError(500, e.getMessage());
                                        identityService = this._identityService;
                                        if (identityService == null) {
                                        }
                                        identityService.disassociate(obj2);
                                    } catch (Throwable th2) {
                                        th = th2;
                                        obj2 = obj3;
                                        authentication = obj2;
                                        r1 = this._identityService;
                                        if (r1 != 0) {
                                        }
                                        throw th;
                                    }
                                } else {
                                    user = user2;
                                    obj2 = obj3;
                                }
                                try {
                                    handler.handle(str, request, ae0Var3, ce0Var2);
                                    if (authenticator != null) {
                                        authenticator.secureResponse(ae0Var3, ce0Var2, isAuthMandatory, user);
                                    }
                                } catch (ServerAuthException e2) {
                                    e = e2;
                                    authentication = obj2;
                                    obj2 = authentication;
                                    ce0Var2.sendError(500, e.getMessage());
                                    identityService = this._identityService;
                                    if (identityService == null) {
                                        return;
                                    }
                                    identityService.disassociate(obj2);
                                }
                            } else {
                                try {
                                    if (authentication instanceof Authentication.Deferred) {
                                        DeferredAuthentication deferredAuthentication = (DeferredAuthentication) authentication;
                                        request.setAuthentication(authentication);
                                        try {
                                            handler.handle(str, request, ae0Var3, ce0Var2);
                                            authentication = deferredAuthentication.getPreviousAssociation();
                                            if (authenticator != null) {
                                                Authentication authentication2 = request.getAuthentication();
                                                obj = authentication;
                                                if (authentication2 instanceof Authentication.User) {
                                                    authenticator.secureResponse(ae0Var3, ce0Var2, isAuthMandatory, (Authentication.User) authentication2);
                                                    authentication = authentication;
                                                }
                                                authenticator.secureResponse(ae0Var3, ce0Var2, isAuthMandatory, null);
                                                authentication = obj;
                                            }
                                            obj2 = authentication;
                                        } catch (Throwable th3) {
                                            deferredAuthentication.getPreviousAssociation();
                                            throw th3;
                                        }
                                    } else {
                                        request.setAuthentication(authentication);
                                        Object associate = this._identityService != null ? this._identityService.associate(null) : null;
                                        handler.handle(str, request, ae0Var3, ce0Var2);
                                        authentication = associate;
                                        obj = associate;
                                    }
                                } catch (Throwable th4) {
                                    th = th4;
                                    r1 = this._identityService;
                                    if (r1 != 0) {
                                        r1.disassociate(authentication);
                                    }
                                    throw th;
                                }
                            }
                        } catch (ServerAuthException e3) {
                            e = e3;
                        }
                    }
                    identityService = this._identityService;
                    if (identityService == null) {
                        return;
                    }
                } catch (ServerAuthException e4) {
                    e = e4;
                }
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (ServerAuthException e5) {
            e = e5;
            ce0Var2 = ce0Var3;
        }
        identityService.disassociate(obj2);
    }

    public abstract boolean isAuthMandatory(Request request, Response response, Object obj);

    public boolean isCheckWelcomeFiles() {
        return this._checkWelcomeFiles;
    }

    @Override // org.eclipse.jetty.security.Authenticator.AuthConfiguration
    public boolean isSessionRenewedOnAuthentication() {
        return this._renewSession;
    }

    public void logout(Authentication.User user) {
        LOG.debug("logout {}", user);
        LoginService loginService = getLoginService();
        if (loginService != null) {
            loginService.logout(user.getUserIdentity());
        }
        IdentityService identityService = getIdentityService();
        if (identityService != null) {
            identityService.disassociate(null);
        }
    }

    public abstract Object prepareConstraintInfo(String str, Request request);

    public void setAuthMethod(String str) {
        if (!isRunning()) {
            this._authMethod = str;
            return;
        }
        throw new IllegalStateException("running");
    }

    public void setAuthenticator(Authenticator authenticator) {
        if (!isStarted()) {
            this._authenticator = authenticator;
            return;
        }
        throw new IllegalStateException("Started");
    }

    public void setAuthenticatorFactory(Authenticator.Factory factory) {
        if (!isRunning()) {
            this._authenticatorFactory = factory;
            return;
        }
        throw new IllegalStateException("running");
    }

    public void setCheckWelcomeFiles(boolean z) {
        if (!isRunning()) {
            this._checkWelcomeFiles = z;
            return;
        }
        throw new IllegalStateException("running");
    }

    public void setIdentityService(IdentityService identityService) {
        if (!isStarted()) {
            this._identityService = identityService;
            return;
        }
        throw new IllegalStateException("Started");
    }

    public String setInitParameter(String str, String str2) {
        if (!isRunning()) {
            return this._initParameters.put(str, str2);
        }
        throw new IllegalStateException("running");
    }

    public void setLoginService(LoginService loginService) {
        if (!isStarted()) {
            this._loginService = loginService;
            this._loginServiceShared = false;
            return;
        }
        throw new IllegalStateException("Started");
    }

    public void setRealmName(String str) {
        if (!isRunning()) {
            this._realmName = str;
            return;
        }
        throw new IllegalStateException("running");
    }

    public void setSessionRenewedOnAuthentication(boolean z) {
        this._renewSession = z;
    }
}
