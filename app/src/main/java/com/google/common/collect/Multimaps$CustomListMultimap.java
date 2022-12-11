package com.google.common.collect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import me.tvspark.AbstractC2684ut;

/* loaded from: classes3.dex */
public class Multimaps$CustomListMultimap<K, V> extends AbstractListMultimap<K, V> {
    public static final long serialVersionUID = 0;
    public transient AbstractC2684ut<? extends List<V>> factory;

    public Multimaps$CustomListMultimap(Map<K, Collection<V>> map, AbstractC2684ut<? extends List<V>> abstractC2684ut) {
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

    @Override // com.google.common.collect.AbstractListMultimap, com.google.common.collect.AbstractMapBasedMultimap
    /* renamed from: createCollection  reason: collision with other method in class */
    public List<V> mo4791createCollection() {
        return this.factory.mo4804get();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, me.tvspark.AbstractC2309ku
    public Set<K> createKeySet() {
        return createMaybeNavigableKeySet();
    }
}
