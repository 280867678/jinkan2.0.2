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
public class Response {
    public Error error;
    @Element
    public String href;
    public Location location;
    @ElementList(inline = true, required = false)
    public List<Propstat> propstat;
    public String responsedescription;
    public String status;

    public Error getError() {
        return this.error;
    }

    public String getHref() {
        return this.href;
    }

    public Location getLocation() {
        return this.location;
    }

    public List<Propstat> getPropstat() {
        if (this.propstat == null) {
            this.propstat = new ArrayList();
        }
        return this.propstat;
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

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setResponsedescription(String str) {
        this.responsedescription = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }
}
