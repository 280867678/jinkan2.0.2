package me.tvspark;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Set;

/* renamed from: me.tvspark.tx */
/* loaded from: classes4.dex */
public abstract class AbstractC2651tx<E> extends AbstractSet<E> {
    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Set<?>) this, collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        if (collection != null) {
            return super.retainAll(collection);
        }
        throw null;
    }
}
