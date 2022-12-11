package com.thegrizzlylabs.sardineandroid.model;

import java.util.ArrayList;
import java.util.List;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Namespace(prefix = "D", reference = "DAV:")
@Root
/* loaded from: classes4.dex */
public class Grant {
    @ElementList(required = false)
    public List<Object> content;
    @ElementList(inline = true)
    public List<Privilege> privilege;

    public List<Object> getContent() {
        if (this.content == null) {
            this.content = new ArrayList();
        }
        return this.content;
    }

    public List<Privilege> getPrivilege() {
        return this.privilege;
    }

    public void setPrivilege(List<Privilege> list) {
        this.privilege = list;
    }
}
