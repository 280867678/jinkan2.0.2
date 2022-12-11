package org.simpleframework.xml.core;

import java.util.Iterator;
import java.util.LinkedHashMap;

/* loaded from: classes5.dex */
public class ContactMap extends LinkedHashMap<Object, Contact> implements Iterable<Contact> {
    @Override // java.lang.Iterable
    public Iterator<Contact> iterator() {
        return values().iterator();
    }
}
