package com.google.common.collect;

import java.util.Set;

/* loaded from: classes3.dex */
public class Synchronized$SynchronizedSet<E> extends Synchronized$SynchronizedCollection<E> implements Set<E> {
    public static final long serialVersionUID = 0;

    public Synchronized$SynchronizedSet(Set<E> set, Object obj) {
        super(set, obj);
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedCollection, com.google.common.collect.Synchronized$SynchronizedObject
    /* renamed from: delegate */
    public Set<E> mo4780delegate() {
        return (Set) super.mo4780delegate();
    }

    public boolean equals(Object obj) {
        boolean equals;
        if (obj == this) {
            return true;
        }
        synchronized (this.mutex) {
            equals = mo4780delegate().equals(obj);
        }
        return equals;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = mo4780delegate().hashCode();
        }
        return hashCode;
    }
}
