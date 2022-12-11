package com.google.common.collect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import me.tvspark.AbstractC2684ut;

/* loaded from: classes3.dex */
public class Multimaps$CustomSortedSetMultimap<K, V> extends AbstractSortedSetMultimap<K, V> {
    public static final long serialVersionUID = 0;
    public transient AbstractC2684ut<? extends SortedSet<V>> factory;
    public transient Comparator<? super V> valueComparator;

    public Multimaps$CustomSortedSetMultimap(Map<K, Collection<V>> map, AbstractC2684ut<? extends SortedSet<V>> abstractC2684ut) {
        super(map);
        if (abstractC2684ut != null) {
            this.factory = abstractC2684ut;
            this.valueComparator = abstractC2684ut.mo4804get().comparator();
            return;
        }
        throw null;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        AbstractC2684ut<? extends SortedSet<V>> abstractC2684ut = (AbstractC2684ut) objectInputStream.readObject();
        this.factory = abstractC2684ut;
        this.valueComparator = abstractC2684ut.mo4804get().comparator();
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

    @Override // com.google.common.collect.AbstractSortedSetMultimap, com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
    /* renamed from: createCollection */
    public SortedSet<V> mo4791createCollection() {
        return this.factory.mo4804get();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, me.tvspark.AbstractC2309ku
    public Set<K> createKeySet() {
        return createMaybeNavigableKeySet();
    }

    @Override // me.tvspark.AbstractC1926ay
    public Comparator<? super V> valueComparator() {
        return this.valueComparator;
    }
}
