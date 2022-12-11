package javax.servlet;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import javax.servlet.annotation.ServletSecurity;
import me.tvspark.outline;
import me.tvspark.vd0;

/* loaded from: classes4.dex */
public class ServletSecurityElement extends HttpConstraintElement {
    public Collection<HttpMethodConstraintElement> methodConstraints;
    public Collection<String> methodNames;

    public ServletSecurityElement() {
        this.methodConstraints = new HashSet();
        this.methodNames = Collections.emptySet();
    }

    public ServletSecurityElement(Collection<HttpMethodConstraintElement> collection) {
        collection = collection == null ? new HashSet<>() : collection;
        this.methodConstraints = collection;
        this.methodNames = checkMethodNames(collection);
    }

    public ServletSecurityElement(HttpConstraintElement httpConstraintElement) {
        super(httpConstraintElement.getEmptyRoleSemantic(), httpConstraintElement.getTransportGuarantee(), httpConstraintElement.getRolesAllowed());
        this.methodConstraints = new HashSet();
        this.methodNames = Collections.emptySet();
    }

    public ServletSecurityElement(HttpConstraintElement httpConstraintElement, Collection<HttpMethodConstraintElement> collection) {
        super(httpConstraintElement.getEmptyRoleSemantic(), httpConstraintElement.getTransportGuarantee(), httpConstraintElement.getRolesAllowed());
        collection = collection == null ? new HashSet<>() : collection;
        this.methodConstraints = collection;
        this.methodNames = checkMethodNames(collection);
    }

    public ServletSecurityElement(ServletSecurity servletSecurity) {
        super(servletSecurity.value().value(), servletSecurity.value().transportGuarantee(), servletSecurity.value().rolesAllowed());
        vd0[] httpMethodConstraints;
        this.methodConstraints = new HashSet();
        for (vd0 vd0Var : servletSecurity.httpMethodConstraints()) {
            this.methodConstraints.add(new HttpMethodConstraintElement(vd0Var.value(), new HttpConstraintElement(vd0Var.emptyRoleSemantic(), vd0Var.transportGuarantee(), vd0Var.rolesAllowed())));
        }
        this.methodNames = checkMethodNames(this.methodConstraints);
    }

    private Collection<String> checkMethodNames(Collection<HttpMethodConstraintElement> collection) {
        HashSet hashSet = new HashSet();
        for (HttpMethodConstraintElement httpMethodConstraintElement : collection) {
            String methodName = httpMethodConstraintElement.getMethodName();
            if (!hashSet.add(methodName)) {
                throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Duplicate HTTP method name: ", methodName));
            }
        }
        return hashSet;
    }

    public Collection<HttpMethodConstraintElement> getHttpMethodConstraints() {
        return Collections.unmodifiableCollection(this.methodConstraints);
    }

    public Collection<String> getMethodNames() {
        return Collections.unmodifiableCollection(this.methodNames);
    }
}
