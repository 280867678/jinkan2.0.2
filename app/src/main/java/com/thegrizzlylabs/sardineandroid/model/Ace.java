package com.thegrizzlylabs.sardineandroid.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Namespace(prefix = "D", reference = "DAV:")
@Root
/* loaded from: classes4.dex */
public class Ace {
    @Element(required = false)
    public Deny deny;
    @Element(required = false)
    public Grant grant;
    @Element(required = false)
    public Inherited inherited;
    @Element(required = false)
    public Principal principal;
    @Element(name = "protected", required = false)
    public Protected protected1;

    public Deny getDeny() {
        return this.deny;
    }

    public Grant getGrant() {
        return this.grant;
    }

    public Inherited getInherited() {
        return this.inherited;
    }

    public Principal getPrincipal() {
        return this.principal;
    }

    public Protected getProtected() {
        return this.protected1;
    }

    public void setDeny(Deny deny) {
        this.deny = deny;
    }

    public void setGrant(Grant grant) {
        this.grant = grant;
    }

    public void setInherited(Inherited inherited) {
        this.inherited = inherited;
    }

    public void setPrincipal(Principal principal) {
        this.principal = principal;
    }

    public void setProtected(Protected r1) {
        this.protected1 = r1;
    }
}
