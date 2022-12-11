package com.thegrizzlylabs.sardineandroid.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Namespace(prefix = "D", reference = "DAV:")
@Root
/* loaded from: classes4.dex */
public class Propstat {
    @Element(required = false)
    public Error error;
    @Element
    public Prop prop;
    @Element(required = false)
    public String responsedescription;
    @Element
    public String status;

    public Error getError() {
        return this.error;
    }

    public Prop getProp() {
        return this.prop;
    }

    public String getResponsedescription() {
        return this.responsedescription;
    }

    public String getStatus() {
        return this.status;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public void setProp(Prop prop) {
        this.prop = prop;
    }

    public void setResponsedescription(String str) {
        this.responsedescription = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }
}
