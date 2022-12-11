package com.thegrizzlylabs.sardineandroid.model;

import java.util.List;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root
/* loaded from: classes4.dex */
public class CurrentUserPrivilegeSet {
    @ElementList(inline = true)
    public List<Privilege> privileges;
}
