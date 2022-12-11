package org.antlr.p055v4.runtime.misc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* renamed from: org.antlr.v4.runtime.misc.OrderedHashSet */
/* loaded from: classes4.dex */
public class OrderedHashSet<T> extends LinkedHashSet<T> {
    public ArrayList<T> elements = new ArrayList<>();

    @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(T t) {
        boolean add = super.add(t);
        if (add) {
            this.elements.add(t);
        }
        return add;
    }

    @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.elements.clear();
        super.clear();
    }

    @Override // java.util.HashSet
    public Object clone() {
        OrderedHashSet orderedHashSet = (OrderedHashSet) super.clone();
        orderedHashSet.elements = new ArrayList<>(this.elements);
        return orderedHashSet;
    }

    public List<T> elements() {
        return this.elements;
    }

    @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        ArrayList<T> arrayList;
        return (obj instanceof OrderedHashSet) && (arrayList = this.elements) != null && arrayList.equals(((OrderedHashSet) obj).elements);
    }

    public T get(int i) {
        return this.elements.get(i);
    }

    @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
    public int hashCode() {
        return this.elements.hashCode();
    }

    @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<T> iterator() {
        return this.elements.iterator();
    }

    public boolean remove(int i) {
        return super.remove(this.elements.remove(i));
    }

    @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public T set(int i, T t) {
        T t2 = this.elements.get(i);
        this.elements.set(i, t);
        super.remove(t2);
        super.add(t);
        return t2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return this.elements.toArray();
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return this.elements.toString();
    }
}
