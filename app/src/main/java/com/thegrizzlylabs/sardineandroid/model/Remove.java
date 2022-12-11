package com.thegrizzlylabs.sardineandroid.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Namespace(prefix = "D", reference = "DAV:")
@Root
/* loaded from: classes4.dex */
public class Remove {
    @Element
    public Prop prop;

    public Prop getProp() {
        return this.prop;
    }

    public void setProp(Prop prop) {
        this.prop = prop;
    }
}
