package com.thegrizzlylabs.sardineandroid.model;

import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Namespace(prefix = "D", reference = "DAV:")
@Root
/* loaded from: classes4.dex */
public class Location {
    public String href;

    public String getHref() {
        return this.href;
    }

    public void setHref(String str) {
        this.href = str;
    }
}
