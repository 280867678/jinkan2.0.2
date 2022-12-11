package com.thegrizzlylabs.sardineandroid.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Namespace(prefix = "D", reference = "DAV:")
@Root
/* loaded from: classes4.dex */
public class Locktype {
    @Element(required = false)
    public Write write;

    public Write getWrite() {
        return this.write;
    }

    public void setWrite(Write write) {
        this.write = write;
    }
}
