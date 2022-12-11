package com.thegrizzlylabs.sardineandroid.model;

import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Namespace(prefix = "D", reference = "DAV:")
@Root
/* loaded from: classes4.dex */
public class SyncCollection {
    public Limit limit;
    public Prop prop;
    public String syncLevel;
    public String syncToken;

    public Limit getLimit() {
        return this.limit;
    }

    public Prop getProp() {
        return this.prop;
    }

    public String getSyncLevel() {
        return this.syncLevel;
    }

    public String getSyncToken() {
        return this.syncToken;
    }

    public void setLimit(Limit limit) {
        this.limit = limit;
    }

    public void setProp(Prop prop) {
        this.prop = prop;
    }

    public void setSyncLevel(String str) {
        this.syncLevel = str;
    }

    public void setSyncToken(String str) {
        this.syncToken = str;
    }
}
