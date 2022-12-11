package javax.servlet;

import javax.servlet.annotation.ServletSecurity;

/* loaded from: classes4.dex */
public class HttpConstraintElement {
    public ServletSecurity.EmptyRoleSemantic emptyRoleSemantic;
    public String[] rolesAllowed;
    public ServletSecurity.TransportGuarantee transportGuarantee;

    public HttpConstraintElement() {
        this(ServletSecurity.EmptyRoleSemantic.PERMIT);
    }

    public HttpConstraintElement(ServletSecurity.EmptyRoleSemantic emptyRoleSemantic) {
        this(emptyRoleSemantic, ServletSecurity.TransportGuarantee.NONE, new String[0]);
    }

    public HttpConstraintElement(ServletSecurity.EmptyRoleSemantic emptyRoleSemantic, ServletSecurity.TransportGuarantee transportGuarantee, String... strArr) {
        if (emptyRoleSemantic != ServletSecurity.EmptyRoleSemantic.DENY || strArr.length <= 0) {
            this.emptyRoleSemantic = emptyRoleSemantic;
            this.transportGuarantee = transportGuarantee;
            this.rolesAllowed = strArr;
            return;
        }
        throw new IllegalArgumentException("Deny semantic with rolesAllowed");
    }

    public HttpConstraintElement(ServletSecurity.TransportGuarantee transportGuarantee, String... strArr) {
        this(ServletSecurity.EmptyRoleSemantic.PERMIT, transportGuarantee, strArr);
    }

    public ServletSecurity.EmptyRoleSemantic getEmptyRoleSemantic() {
        return this.emptyRoleSemantic;
    }

    public String[] getRolesAllowed() {
        return this.rolesAllowed;
    }

    public ServletSecurity.TransportGuarantee getTransportGuarantee() {
        return this.transportGuarantee;
    }
}
