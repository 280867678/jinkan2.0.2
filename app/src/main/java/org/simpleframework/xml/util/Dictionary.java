package org.simpleframework.xml.util;

import java.util.AbstractSet;
import java.util.HashMap;
import java.util.Iterator;
import org.simpleframework.xml.util.Entry;

/* loaded from: classes5.dex */
public class Dictionary<T extends Entry> extends AbstractSet<T> {
    public final Table<T> map = new Table<>();

    /* loaded from: classes5.dex */
    public static class Table<T> extends HashMap<String, T> {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        return add((Dictionary<T>) ((Entry) obj));
    }

    public boolean add(T t) {
        return this.map.put(t.getName(), t) != null;
    }

    public T get(String str) {
        return this.map.get(str);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<T> iterator() {
        return this.map.values().iterator();
    }

    public T remove(String str) {
        return this.map.remove(str);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.map.size();
    }
}
