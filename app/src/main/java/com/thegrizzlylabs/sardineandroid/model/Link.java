package com.thegrizzlylabs.sardineandroid.model;

import java.util.ArrayList;
import java.util.List;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Namespace(prefix = "D", reference = "DAV:")
@Root
/* loaded from: classes4.dex */
public class Link {
    public List<String> dst;
    public List<String> src;

    public List<String> getDst() {
        if (this.dst == null) {
            this.dst = new ArrayList();
        }
        return this.dst;
    }

    public List<String> getSrc() {
        if (this.src == null) {
            this.src = new ArrayList();
        }
        return this.src;
    }
}
