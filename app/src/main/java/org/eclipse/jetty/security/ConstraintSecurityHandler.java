package org.eclipse.jetty.security;

import com.just.agentweb.DefaultWebClient;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.servlet.HttpConstraintElement;
import javax.servlet.HttpMethodConstraintElement;
import javax.servlet.ServletSecurityElement;
import javax.servlet.annotation.ServletSecurity;
import me.tvspark.outline;
import org.eclipse.jetty.http.PathMap;
import org.eclipse.jetty.server.AbstractHttpConnection;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Response;
import org.eclipse.jetty.server.UserIdentity;
import org.eclipse.jetty.util.StringMap;
import org.eclipse.jetty.util.TypeUtil;
import org.eclipse.jetty.util.component.AggregateLifeCycle;
import org.eclipse.jetty.util.security.Constraint;

/* loaded from: classes4.dex */
public class ConstraintSecurityHandler extends SecurityHandler implements ConstraintAware {
    public static final String OMISSION_SUFFIX = ".omission";
    public final List<ConstraintMapping> _constraintMappings = new CopyOnWriteArrayList();
    public final Set<String> _roles = new CopyOnWriteArraySet();
    public final PathMap _constraintMap = new PathMap();
    public boolean _strict = true;

    public static Constraint createConstraint() {
        return new Constraint();
    }

    public static Constraint createConstraint(String str, HttpConstraintElement httpConstraintElement) {
        return createConstraint(str, httpConstraintElement.getRolesAllowed(), httpConstraintElement.getEmptyRoleSemantic(), httpConstraintElement.getTransportGuarantee());
    }

    public static Constraint createConstraint(String str, boolean z, String[] strArr, int i) {
        Constraint createConstraint = createConstraint();
        if (str != null) {
            createConstraint.setName(str);
        }
        createConstraint.setAuthenticate(z);
        createConstraint.setRoles(strArr);
        createConstraint.setDataConstraint(i);
        return createConstraint;
    }

    public static Constraint createConstraint(String str, String[] strArr, ServletSecurity.EmptyRoleSemantic emptyRoleSemantic, ServletSecurity.TransportGuarantee transportGuarantee) {
        Constraint createConstraint = createConstraint();
        int i = 0;
        if (strArr != null && strArr.length != 0) {
            createConstraint.setAuthenticate(true);
            createConstraint.setRoles(strArr);
            createConstraint.setName(str + "-RolesAllowed");
        } else if (emptyRoleSemantic.equals(ServletSecurity.EmptyRoleSemantic.DENY)) {
            createConstraint.setName(str + "-Deny");
            createConstraint.setAuthenticate(true);
        } else {
            createConstraint.setName(str + "-Permit");
            createConstraint.setAuthenticate(false);
        }
        if (transportGuarantee.equals(ServletSecurity.TransportGuarantee.CONFIDENTIAL)) {
            i = 2;
        }
        createConstraint.setDataConstraint(i);
        return createConstraint;
    }

    public static Constraint createConstraint(Constraint constraint) {
        try {
            return (Constraint) constraint.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException(e);
        }
    }

    public static List<ConstraintMapping> createConstraintsWithMappingsForPath(String str, String str2, ServletSecurityElement servletSecurityElement) {
        ArrayList arrayList = new ArrayList();
        Constraint createConstraint = createConstraint(str, servletSecurityElement);
        ConstraintMapping constraintMapping = new ConstraintMapping();
        constraintMapping.setPathSpec(str2);
        constraintMapping.setConstraint(createConstraint);
        arrayList.add(constraintMapping);
        ArrayList arrayList2 = new ArrayList();
        Collection<HttpMethodConstraintElement> httpMethodConstraints = servletSecurityElement.getHttpMethodConstraints();
        if (httpMethodConstraints != null) {
            for (HttpMethodConstraintElement httpMethodConstraintElement : httpMethodConstraints) {
                Constraint createConstraint2 = createConstraint(str, httpMethodConstraintElement);
                ConstraintMapping constraintMapping2 = new ConstraintMapping();
                constraintMapping2.setConstraint(createConstraint2);
                constraintMapping2.setPathSpec(str2);
                if (httpMethodConstraintElement.getMethodName() != null) {
                    constraintMapping2.setMethod(httpMethodConstraintElement.getMethodName());
                    arrayList2.add(httpMethodConstraintElement.getMethodName());
                }
                arrayList.add(constraintMapping2);
            }
        }
        if (arrayList2.size() > 0) {
            constraintMapping.setMethodOmissions((String[]) arrayList2.toArray(new String[arrayList2.size()]));
        }
        return arrayList;
    }

    public static List<ConstraintMapping> getConstraintMappingsForPath(String str, List<ConstraintMapping> list) {
        if (str == null || "".equals(str.trim()) || list == null || list.size() == 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (ConstraintMapping constraintMapping : list) {
            if (str.equals(constraintMapping.getPathSpec())) {
                arrayList.add(constraintMapping);
            }
        }
        return arrayList;
    }

    public static List<ConstraintMapping> removeConstraintMappingsForPath(String str, List<ConstraintMapping> list) {
        if (str == null || "".equals(str.trim()) || list == null || list.size() == 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (ConstraintMapping constraintMapping : list) {
            if (!str.equals(constraintMapping.getPathSpec())) {
                arrayList.add(constraintMapping);
            }
        }
        return arrayList;
    }

    @Override // org.eclipse.jetty.security.ConstraintAware
    public void addConstraintMapping(ConstraintMapping constraintMapping) {
        this._constraintMappings.add(constraintMapping);
        if (constraintMapping.getConstraint() != null && constraintMapping.getConstraint().getRoles() != null) {
            for (String str : constraintMapping.getConstraint().getRoles()) {
                addRole(str);
            }
        }
        if (isStarted()) {
            processConstraintMapping(constraintMapping);
        }
    }

    @Override // org.eclipse.jetty.security.ConstraintAware
    public void addRole(String str) {
        boolean add = this._roles.add(str);
        if (!isStarted() || !add || !this._strict) {
            return;
        }
        for (Map map : this._constraintMap.values()) {
            for (RoleInfo roleInfo : map.values()) {
                if (roleInfo.isAnyRole()) {
                    roleInfo.addRole(str);
                }
            }
        }
    }

    @Override // org.eclipse.jetty.security.SecurityHandler
    public boolean checkUserDataPermissions(String str, Request request, Response response, Object obj) throws IOException {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        if (obj == null) {
            return true;
        }
        RoleInfo roleInfo = (RoleInfo) obj;
        if (roleInfo.isForbidden()) {
            return false;
        }
        UserDataConstraint userDataConstraint = roleInfo.getUserDataConstraint();
        if (userDataConstraint == null || userDataConstraint == UserDataConstraint.None) {
            return true;
        }
        Connector connector = AbstractHttpConnection.getCurrentConnection().getConnector();
        if (userDataConstraint == UserDataConstraint.Integral) {
            if (connector.isIntegral(request)) {
                return true;
            }
            if (connector.getIntegralPort() > 0) {
                String integralScheme = connector.getIntegralScheme();
                int integralPort = connector.getIntegralPort();
                if (!"https".equalsIgnoreCase(integralScheme) || integralPort != 443) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(integralScheme, "://");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(request.getServerName());
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(":");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(integralPort);
                } else {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DefaultWebClient.HTTPS_SCHEME);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(request.getServerName());
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(request.getRequestURI());
                String sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
                if (request.getQueryString() != null) {
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, "?");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(request.getQueryString());
                    sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString();
                }
                response.setContentLength(0);
                response.sendRedirect(sb);
            } else {
                response.sendError(403, "!Integral");
            }
            request.setHandled(true);
            return false;
        } else if (userDataConstraint != UserDataConstraint.Confidential) {
            throw new IllegalArgumentException("Invalid dataConstraint value: " + userDataConstraint);
        } else if (connector.isConfidential(request)) {
            return true;
        } else {
            if (connector.getConfidentialPort() > 0) {
                String confidentialScheme = connector.getConfidentialScheme();
                int confidentialPort = connector.getConfidentialPort();
                if (!"https".equalsIgnoreCase(confidentialScheme) || confidentialPort != 443) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(confidentialScheme, "://");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(request.getServerName());
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(":");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(confidentialPort);
                } else {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DefaultWebClient.HTTPS_SCHEME);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(request.getServerName());
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(request.getRequestURI());
                String sb2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
                if (request.getQueryString() != null) {
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb2, "?");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.append(request.getQueryString());
                    sb2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.toString();
                }
                response.setContentLength(0);
                response.sendRedirect(sb2);
            } else {
                response.sendError(403, "!Confidential");
            }
            request.setHandled(true);
            return false;
        }
    }

    @Override // org.eclipse.jetty.security.SecurityHandler
    public boolean checkWebResourcePermissions(String str, Request request, Response response, Object obj, UserIdentity userIdentity) throws IOException {
        if (obj == null) {
            return true;
        }
        RoleInfo roleInfo = (RoleInfo) obj;
        if (!roleInfo.isChecked()) {
            return true;
        }
        if (roleInfo.isAnyRole() && request.getAuthType() != null) {
            return true;
        }
        for (String str2 : roleInfo.getRoles()) {
            if (userIdentity.isUserInRole(str2, null)) {
                return true;
            }
        }
        return false;
    }

    public void configureRoleInfo(RoleInfo roleInfo, ConstraintMapping constraintMapping) {
        String[] roles;
        roleInfo.setForbidden(constraintMapping.getConstraint().isForbidden());
        roleInfo.setUserDataConstraint(UserDataConstraint.get(constraintMapping.getConstraint().getDataConstraint()));
        if (!roleInfo.isForbidden()) {
            roleInfo.setChecked(constraintMapping.getConstraint().getAuthenticate());
            if (!roleInfo.isChecked()) {
                return;
            }
            if (constraintMapping.getConstraint().isAnyRole()) {
                if (!this._strict) {
                    roleInfo.setAnyRole(true);
                    return;
                }
                for (String str : this._roles) {
                    roleInfo.addRole(str);
                }
                return;
            }
            for (String str2 : constraintMapping.getConstraint().getRoles()) {
                if (this._strict && !this._roles.contains(str2)) {
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Attempt to use undeclared role: ", str2, ", known roles: ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._roles);
                    throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                }
                roleInfo.addRole(str2);
            }
        }
    }

    @Override // org.eclipse.jetty.security.SecurityHandler, org.eclipse.jetty.server.handler.HandlerWrapper, org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.util.component.AggregateLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        this._constraintMap.clear();
        List<ConstraintMapping> list = this._constraintMappings;
        if (list != null) {
            for (ConstraintMapping constraintMapping : list) {
                processConstraintMapping(constraintMapping);
            }
        }
        super.doStart();
    }

    @Override // org.eclipse.jetty.security.SecurityHandler, org.eclipse.jetty.server.handler.HandlerWrapper, org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.util.component.AggregateLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStop() throws Exception {
        this._constraintMap.clear();
        this._constraintMappings.clear();
        this._roles.clear();
        super.doStop();
    }

    @Override // org.eclipse.jetty.server.handler.AbstractHandlerContainer, org.eclipse.jetty.util.component.AggregateLifeCycle, org.eclipse.jetty.util.component.Dumpable
    public void dump(Appendable appendable, String str) throws IOException {
        dumpThis(appendable);
        AggregateLifeCycle.dump(appendable, str, Collections.singleton(getLoginService()), Collections.singleton(getIdentityService()), Collections.singleton(getAuthenticator()), Collections.singleton(this._roles), this._constraintMap.entrySet(), getBeans(), TypeUtil.asList(getHandlers()));
    }

    @Override // org.eclipse.jetty.security.ConstraintAware
    public List<ConstraintMapping> getConstraintMappings() {
        return this._constraintMappings;
    }

    @Override // org.eclipse.jetty.security.ConstraintAware
    public Set<String> getRoles() {
        return this._roles;
    }

    @Override // org.eclipse.jetty.security.SecurityHandler
    public boolean isAuthMandatory(Request request, Response response, Object obj) {
        if (obj == null) {
            return false;
        }
        return ((RoleInfo) obj).isChecked();
    }

    public boolean isStrict() {
        return this._strict;
    }

    @Override // org.eclipse.jetty.security.SecurityHandler
    public Object prepareConstraintInfo(String str, Request request) {
        Map map = (Map) this._constraintMap.match(str);
        if (map != null) {
            String method = request.getMethod();
            RoleInfo roleInfo = (RoleInfo) map.get(method);
            if (roleInfo != null) {
                return roleInfo;
            }
            ArrayList arrayList = new ArrayList();
            RoleInfo roleInfo2 = (RoleInfo) map.get(null);
            if (roleInfo2 != null) {
                arrayList.add(roleInfo2);
            }
            for (Map.Entry entry : map.entrySet()) {
                if (entry.getKey() != null && ((String) entry.getKey()).contains(OMISSION_SUFFIX) && !outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(method, OMISSION_SUFFIX).equals(entry.getKey())) {
                    arrayList.add(entry.getValue());
                }
            }
            if (arrayList.size() == 1) {
                return (RoleInfo) arrayList.get(0);
            }
            RoleInfo roleInfo3 = new RoleInfo();
            roleInfo3.setUserDataConstraint(UserDataConstraint.None);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                roleInfo3.combine((RoleInfo) it.next());
            }
            return roleInfo3;
        }
        return null;
    }

    public void processConstraintMapping(ConstraintMapping constraintMapping) {
        Map<String, RoleInfo> map = (Map) this._constraintMap.get(constraintMapping.getPathSpec());
        if (map == null) {
            map = new StringMap();
            this._constraintMap.put(constraintMapping.getPathSpec(), map);
        }
        RoleInfo roleInfo = map.get(null);
        if (roleInfo == null || !roleInfo.isForbidden()) {
            if (constraintMapping.getMethodOmissions() != null && constraintMapping.getMethodOmissions().length > 0) {
                processConstraintMappingWithMethodOmissions(constraintMapping, map);
                return;
            }
            String method = constraintMapping.getMethod();
            RoleInfo roleInfo2 = map.get(method);
            if (roleInfo2 == null) {
                roleInfo2 = new RoleInfo();
                map.put(method, roleInfo2);
                if (roleInfo != null) {
                    roleInfo2.combine(roleInfo);
                }
            }
            if (roleInfo2.isForbidden()) {
                return;
            }
            configureRoleInfo(roleInfo2, constraintMapping);
            if (roleInfo2.isForbidden()) {
                if (method != null) {
                    return;
                }
                map.clear();
                map.put(null, roleInfo2);
            } else if (method == null) {
                for (Map.Entry<String, RoleInfo> entry : map.entrySet()) {
                    if (entry.getKey() != null) {
                        entry.getValue().combine(roleInfo2);
                    }
                }
            }
        }
    }

    public void processConstraintMappingWithMethodOmissions(ConstraintMapping constraintMapping, Map<String, RoleInfo> map) {
        String[] methodOmissions;
        for (String str : constraintMapping.getMethodOmissions()) {
            RoleInfo roleInfo = map.get(str + OMISSION_SUFFIX);
            if (roleInfo == null) {
                roleInfo = new RoleInfo();
                map.put(str + OMISSION_SUFFIX, roleInfo);
            }
            configureRoleInfo(roleInfo, constraintMapping);
        }
    }

    public void setConstraintMappings(List<ConstraintMapping> list) {
        setConstraintMappings(list, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [org.eclipse.jetty.util.component.AbstractLifeCycle, org.eclipse.jetty.security.ConstraintSecurityHandler] */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.util.Set<java.lang.String>] */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.util.Set] */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.util.HashSet] */
    @Override // org.eclipse.jetty.security.ConstraintAware
    public void setConstraintMappings(List<ConstraintMapping> list, Set<String> set) {
        this._constraintMappings.clear();
        this._constraintMappings.addAll(list);
        if (set == 0) {
            set = new HashSet<>();
            for (ConstraintMapping constraintMapping : list) {
                String[] roles = constraintMapping.getConstraint().getRoles();
                if (roles != null) {
                    for (String str : roles) {
                        if (!"*".equals(str)) {
                            set.add(str);
                        }
                    }
                }
            }
        }
        setRoles(set);
        if (isStarted()) {
            for (ConstraintMapping constraintMapping2 : this._constraintMappings) {
                processConstraintMapping(constraintMapping2);
            }
        }
    }

    public void setConstraintMappings(ConstraintMapping[] constraintMappingArr) {
        setConstraintMappings(Arrays.asList(constraintMappingArr), null);
    }

    public void setRoles(Set<String> set) {
        this._roles.clear();
        this._roles.addAll(set);
    }

    public void setStrict(boolean z) {
        this._strict = z;
    }
}
