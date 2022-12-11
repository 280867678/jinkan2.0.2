package com.google.common.collect;

import java.util.Collection;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class LinkedHashMultimapGwtSerializationDependencies<K, V> extends AbstractSetMultimap<K, V> {
    public LinkedHashMultimapGwtSerializationDependencies(Map<K, Collection<V>> map) {
        super(map);
    }
}
