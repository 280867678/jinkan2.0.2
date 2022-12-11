package com.thegrizzlylabs.sardineandroid.model;

import java.util.ArrayList;
import java.util.List;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Namespace(prefix = "D", reference = "DAV:")
@Root
/* loaded from: classes4.dex */
public class Owner {
    @ElementList(required = false)
    public List<Object> content;
    @Element(required = false)
    public String href;
    @Element(required = false)
    public Unauthenticated unauthenticated;

    public List<Object> getContent() {
        if (this.content == null) {
            this.content = new ArrayList();
        }
        return this.content;
    }

    public String getHref() {
        return this.href;
    }

    public Unauthenticated getUnauthenticated() {
        return this.unauthenticated;
    }

    public void setHref(String str) {
        this.href = str;
    }

    public void setUnauthenticated(Unauthenticated unauthenticated) {
        this.unauthenticated = unauthenticated;
    }
}
