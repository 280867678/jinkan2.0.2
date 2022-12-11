package com.thegrizzlylabs.sardineandroid.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Namespace(prefix = "D", reference = "DAV:")
@Root
/* loaded from: classes4.dex */
public class Propfind {
    @Element(required = false)
    public Allprop allprop;
    @Element(required = false)
    public Prop prop;
    @Element(required = false)
    public Propname propname;

    public Allprop getAllprop() {
        return this.allprop;
    }

    public Prop getProp() {
        return this.prop;
    }

    public Propname getPropname() {
        return this.propname;
    }

    public void setAllprop(Allprop allprop) {
        this.allprop = allprop;
    }

    public void setProp(Prop prop) {
        this.prop = prop;
    }

    public void setPropname(Propname propname) {
        this.propname = propname;
    }
}
