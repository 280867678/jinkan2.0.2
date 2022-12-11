package com.thegrizzlylabs.sardineandroid.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Namespace(prefix = "D", reference = "DAV:")
@Root
/* loaded from: classes4.dex */
public class Lockscope {
    @Element(required = false)
    public Exclusive exclusive;
    @Element(required = false)
    public Shared shared;

    public Exclusive getExclusive() {
        return this.exclusive;
    }

    public Shared getShared() {
        return this.shared;
    }

    public void setExclusive(Exclusive exclusive) {
        this.exclusive = exclusive;
    }

    public void setShared(Shared shared) {
        this.shared = shared;
    }
}
