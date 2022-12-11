package com.thegrizzlylabs.sardineandroid.model;

import java.util.ArrayList;
import java.util.List;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;
import org.w3c.dom.Element;

@Namespace(prefix = "D", reference = "DAV:")
@Root
/* loaded from: classes4.dex */
public class Resourcetype implements EntityWithAnyElement {
    public List<Element> any;
    @org.simpleframework.xml.Element(required = false)
    public Collection collection;
    public Principal principal;

    @Override // com.thegrizzlylabs.sardineandroid.model.EntityWithAnyElement
    public List<Element> getAny() {
        if (this.any == null) {
            this.any = new ArrayList();
        }
        return this.any;
    }

    public Collection getCollection() {
        return this.collection;
    }

    public Principal getPrincipal() {
        return this.principal;
    }

    public void setCollection(Collection collection) {
        this.collection = collection;
    }

    public void setPrincipal(Principal principal) {
        this.principal = principal;
    }
}
