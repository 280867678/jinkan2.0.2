package com.thegrizzlylabs.sardineandroid.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Namespace(prefix = "D", reference = "DAV:")
@Root(strict = false)
/* loaded from: classes4.dex */
public class Activelock {
    @Element
    public String depth;
    @Element
    public Lockscope lockscope;
    @Element(required = false)
    public Locktoken locktoken;
    @Element
    public Locktype locktype;
    @Element(required = false)
    public Owner owner;
    @Element(required = false)
    public String timeout;

    public String getDepth() {
        return this.depth;
    }

    public Lockscope getLockscope() {
        return this.lockscope;
    }

    public Locktoken getLocktoken() {
        return this.locktoken;
    }

    public Locktype getLocktype() {
        return this.locktype;
    }

    public Owner getOwner() {
        return this.owner;
    }

    public String getTimeout() {
        return this.timeout;
    }

    public void setDepth(String str) {
        this.depth = str;
    }

    public void setLockscope(Lockscope lockscope) {
        this.lockscope = lockscope;
    }

    public void setLocktoken(Locktoken locktoken) {
        this.locktoken = locktoken;
    }

    public void setLocktype(Locktype locktype) {
        this.locktype = locktype;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public void setTimeout(String str) {
        this.timeout = str;
    }
}
