package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultimap;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import me.tvspark.AbstractC2684ut;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public class Multimaps$CustomMultimap<K, V> extends AbstractMapBasedMultimap<K, V> {
    public static final long serialVersionUID = 0;
    public transient AbstractC2684ut<? extends Collection<V>> factory;

    public Multimaps$CustomMultimap(Map<K, Collection<V>> map, AbstractC2684ut<? extends Collection<V>> abstractC2684ut) {
        super(map);
        if (abstractC2684ut != null) {
            this.factory = abstractC2684ut;
            return;
        }
        throw null;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.factory = (AbstractC2684ut) objectInputStream.readObject();
        setMap((Map) objectInputStream.readObject());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.factory);
        objectOutputStream.writeObject(mo4489backingMap());
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, me.tvspark.AbstractC2309ku
    public Map<K, Collection<V>> createAsMap() {
        return createMaybeNavigableAsMap();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap
    /* renamed from: createCollection */
    public Collection<V> mo4791createCollection() {
        return this.factory.mo4804get();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, me.tvspark.AbstractC2309ku
    public Set<K> createKeySet() {
        return createMaybeNavigableKeySet();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap
    /* renamed from: unmodifiableCollectionSubclass */
    public <E> Collection<E> mo4496unmodifiableCollectionSubclass(Collection<E> collection) {
        return collection instanceof NavigableSet ? Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((NavigableSet) collection) : collection instanceof SortedSet ? Collections.unmodifiableSortedSet((SortedSet) collection) : collection instanceof Set ? Collections.unmodifiableSet((Set) collection) : collection instanceof List ? Collections.unmodifiableList((List) collection) : Collections.unmodifiableCollection(collection);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap
    public Collection<V> wrapCollection(K k, Collection<V> collection) {
        return collection instanceof List ? wrapList(k, (List) collection, null) : collection instanceof NavigableSet ? new AbstractMapBasedMultimap.Wwwwwwwwwwwwwwwwwwwwww(k, (NavigableSet) collection, null) : collection instanceof SortedSet ? new AbstractMapBasedMultimap.Wwwwwwwwwwwwwwwwwwww(k, (SortedSet) collection, null) : collection instanceof Set ? new AbstractMapBasedMultimap.Wwwwwwwwwwwwwwwwwwwww(k, (Set) collection) : new AbstractMapBasedMultimap.Wwwwwwwwwwwwwwwwwwwwwwww(k, collection, null);
    }
}
