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
public class Multistatus {
    @ElementList(inline = true)
    public List<Response> response;
    @Element(required = false)
    public String responsedescription;
    public String syncToken;

    public List<Response> getResponse() {
        if (this.response == null) {
            this.response = new ArrayList();
        }
        return this.response;
    }

    public String getResponsedescription() {
        return this.responsedescription;
    }

    public String getSyncToken() {
        return this.syncToken;
    }

    public void setResponsedescription(String str) {
        this.responsedescription = str;
    }

    public void setSyncToken(String str) {
        this.syncToken = str;
    }
}
