package com.thegrizzlylabs.sardineandroid.model;

import java.util.ArrayList;
import java.util.List;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementListUnion;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Namespace(prefix = "D", reference = "DAV:")
@Root
/* loaded from: classes4.dex */
public class Propertyupdate {
    @ElementListUnion({@ElementList(entry = "remove", inline = true, type = Remove.class), @ElementList(entry = "set", inline = true, type = Set.class)})
    public List<Object> removeOrSet;

    public List<Object> getRemoveOrSet() {
        if (this.removeOrSet == null) {
            this.removeOrSet = new ArrayList();
        }
        return this.removeOrSet;
    }
}
