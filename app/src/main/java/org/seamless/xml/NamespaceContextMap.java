package org.seamless.xml;

import java.util.HashMap;
import java.util.Iterator;
import me.tvspark.ne0;

/* loaded from: classes5.dex */
public abstract class NamespaceContextMap extends HashMap<String, String> implements ne0 {
    public abstract String getDefaultNamespaceURI();

    public String getNamespaceURI(String str) {
        if (str != null) {
            return str.equals("") ? getDefaultNamespaceURI() : get(str) != null ? get(str) : "";
        }
        throw new IllegalArgumentException("No prefix provided!");
    }

    public String getPrefix(String str) {
        return null;
    }

    public Iterator getPrefixes(String str) {
        return null;
    }
}
