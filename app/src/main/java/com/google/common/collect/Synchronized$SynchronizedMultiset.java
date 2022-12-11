package com.google.common.collect;

import java.util.Set;
import me.tvspark.AbstractC2090ex;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public class Synchronized$SynchronizedMultiset<E> extends Synchronized$SynchronizedCollection<E> implements AbstractC2090ex<E> {
    public static final long serialVersionUID = 0;
    public transient Set<E> elementSet;
    public transient Set<AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>> entrySet;

    public Synchronized$SynchronizedMultiset(AbstractC2090ex<E> abstractC2090ex, Object obj) {
        super(abstractC2090ex, obj);
    }

    @Override // me.tvspark.AbstractC2090ex
    public int add(E e, int i) {
        int add;
        synchronized (this.mutex) {
            add = mo4780delegate().add(e, i);
        }
        return add;
    }

    @Override // me.tvspark.AbstractC2090ex
    public int count(Object obj) {
        int count;
        synchronized (this.mutex) {
            count = mo4780delegate().count(obj);
        }
        return count;
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedCollection, com.google.common.collect.Synchronized$SynchronizedObject
    /* renamed from: delegate */
    public AbstractC2090ex<E> mo4780delegate() {
        return (AbstractC2090ex) super.mo4780delegate();
    }

    @Override // me.tvspark.AbstractC2090ex
    /* renamed from: elementSet */
    public Set<E> mo4975elementSet() {
        Set<E> set;
        synchronized (this.mutex) {
            if (this.elementSet == null) {
                this.elementSet = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Set) mo4780delegate().mo4975elementSet(), this.mutex);
            }
            set = this.elementSet;
        }
        return set;
    }

    @Override // me.tvspark.AbstractC2090ex
    /* renamed from: entrySet */
    public Set<AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>> mo4575entrySet() {
        Set<AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>> set;
        synchronized (this.mutex) {
            if (this.entrySet == null) {
                this.entrySet = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Set) mo4780delegate().mo4575entrySet(), this.mutex);
            }
            set = this.entrySet;
        }
        return set;
    }

    @Override // java.util.Collection, me.tvspark.AbstractC2090ex
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

    @Override // java.util.Collection, me.tvspark.AbstractC2090ex
    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = mo4780delegate().hashCode();
        }
        return hashCode;
    }

    @Override // me.tvspark.AbstractC2090ex
    public int remove(Object obj, int i) {
        int remove;
        synchronized (this.mutex) {
            remove = mo4780delegate().remove(obj, i);
        }
        return remove;
    }

    @Override // me.tvspark.AbstractC2090ex
    public int setCount(E e, int i) {
        int count;
        synchronized (this.mutex) {
            count = mo4780delegate().setCount(e, i);
        }
        return count;
    }

    @Override // me.tvspark.AbstractC2090ex
    public boolean setCount(E e, int i, int i2) {
        boolean count;
        synchronized (this.mutex) {
            count = mo4780delegate().setCount(e, i, i2);
        }
        return count;
    }
}
