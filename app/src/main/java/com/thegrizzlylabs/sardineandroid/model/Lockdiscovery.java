package com.thegrizzlylabs.sardineandroid.model;

import java.util.ArrayList;
import java.util.List;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Namespace(prefix = "D", reference = "DAV:")
@Root
/* loaded from: classes4.dex */
public class Lockdiscovery {
    @ElementList(inline = true, required = false)
    public List<Activelock> activelock;

    public List<Activelock> getActivelock() {
        if (this.activelock == null) {
            this.activelock = new ArrayList();
        }
        return this.activelock;
    }
}
