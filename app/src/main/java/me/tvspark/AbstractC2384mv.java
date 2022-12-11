package me.tvspark;

import java.util.Collection;
import java.util.Set;

/* renamed from: me.tvspark.mv */
/* loaded from: classes4.dex */
public abstract class AbstractC2384mv<E> extends AbstractC2051dv<E> implements Set<E> {
    @Override // me.tvspark.AbstractC2051dv, me.tvspark.AbstractC2310kv
    /* renamed from: delegate */
    public abstract /* bridge */ /* synthetic */ Object mo4974delegate();

    @Override // me.tvspark.AbstractC2051dv, me.tvspark.AbstractC2310kv
    /* renamed from: delegate  reason: collision with other method in class */
    public abstract /* bridge */ /* synthetic */ Collection mo4974delegate();

    @Override // me.tvspark.AbstractC2051dv, me.tvspark.AbstractC2310kv
    /* renamed from: delegate */
    public abstract Set<E> mo4974delegate();

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        return obj == this || mo4974delegate().equals(obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return mo4974delegate().hashCode();
    }

    public boolean standardEquals(Object obj) {
        return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Set<?>) this, obj);
    }

    public int standardHashCode() {
        return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Set<?>) this);
    }

    @Override // me.tvspark.AbstractC2051dv
    public boolean standardRemoveAll(Collection<?> collection) {
        if (collection != null) {
            return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Set<?>) this, collection);
        }
        throw null;
    }
}
