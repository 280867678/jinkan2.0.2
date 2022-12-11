package com.thegrizzlylabs.sardineandroid.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Namespace(prefix = "D", reference = "DAV:")
@Root
/* loaded from: classes4.dex */
public class Lockinfo {
    @Element
    public Lockscope lockscope;
    @Element
    public Locktype locktype;
    @Element(required = false)
    public Owner owner;

    public Lockscope getLockscope() {
        return this.lockscope;
    }

    public Locktype getLocktype() {
        return this.locktype;
    }

    public Owner getOwner() {
        return this.owner;
    }

    public void setLockscope(Lockscope lockscope) {
        this.lockscope = lockscope;
    }

    public void setLocktype(Locktype locktype) {
        this.locktype = locktype;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
