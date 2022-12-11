package com.thegrizzlylabs.sardineandroid.model;

import java.util.ArrayList;
import java.util.List;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Namespace(prefix = "D", reference = "DAV:")
@Root
/* loaded from: classes4.dex */
public class Supportedlock {
    @ElementList(inline = true, required = false)
    public List<Lockentry> lockentryList;

    public List<Lockentry> getLockentryList() {
        if (this.lockentryList == null) {
            this.lockentryList = new ArrayList();
        }
        return this.lockentryList;
    }
}
