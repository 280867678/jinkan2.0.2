package com.thegrizzlylabs.sardineandroid.model;

import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Namespace(prefix = "D", reference = "DAV:")
@Root
/* loaded from: classes4.dex */
public class Error {
    public Object any;

    public Object getAny() {
        return this.any;
    }

    public void setAny(Object obj) {
        this.any = obj;
    }
}
