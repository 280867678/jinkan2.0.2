package me.tvspark;

import java.util.AbstractCollection;
import java.util.Map;

/* renamed from: me.tvspark.bx */
/* loaded from: classes4.dex */
public abstract class AbstractC1962bx<K, V> extends AbstractCollection<Map.Entry<K, V>> {
    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        AbstractC2309ku.this.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            return AbstractC2309ku.this.containsEntry(entry.getKey(), entry.getValue());
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            return AbstractC2309ku.this.remove(entry.getKey(), entry.getValue());
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return AbstractC2309ku.this.size();
    }
}
