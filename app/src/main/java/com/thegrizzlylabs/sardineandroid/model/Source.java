package com.thegrizzlylabs.sardineandroid.model;

import java.util.ArrayList;
import java.util.List;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Namespace(prefix = "D", reference = "DAV:")
@Root
/* loaded from: classes4.dex */
public class Source {
    public List<Link> link;

    public List<Link> getLink() {
        if (this.link == null) {
            this.link = new ArrayList();
        }
        return this.link;
    }
}
