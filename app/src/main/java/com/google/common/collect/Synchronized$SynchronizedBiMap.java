package com.google.common.collect;

import java.io.Serializable;
import java.util.Set;
import me.tvspark.AbstractC2648tu;

/* loaded from: classes3.dex */
public class Synchronized$SynchronizedBiMap<K, V> extends Synchronized$SynchronizedMap<K, V> implements AbstractC2648tu<K, V>, Serializable {
    public static final long serialVersionUID = 0;
    public transient AbstractC2648tu<V, K> inverse;
    public transient Set<V> valueSet;

    public Synchronized$SynchronizedBiMap(AbstractC2648tu<K, V> abstractC2648tu, Object obj, AbstractC2648tu<V, K> abstractC2648tu2) {
        super(abstractC2648tu, obj);
        this.inverse = abstractC2648tu2;
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedMap, com.google.common.collect.Synchronized$SynchronizedObject
    /* renamed from: delegate */
    public AbstractC2648tu<K, V> mo4780delegate() {
        return (AbstractC2648tu) super.mo4780delegate();
    }

    @Override // me.tvspark.AbstractC2648tu
    public V forcePut(K k, V v) {
        V forcePut;
        synchronized (this.mutex) {
            forcePut = mo4780delegate().forcePut(k, v);
        }
        return forcePut;
    }

    @Override // me.tvspark.AbstractC2648tu
    /* renamed from: inverse */
    public AbstractC2648tu<V, K> mo4713inverse() {
        AbstractC2648tu<V, K> abstractC2648tu;
        synchronized (this.mutex) {
            if (this.inverse == null) {
                this.inverse = new Synchronized$SynchronizedBiMap(mo4780delegate().mo4713inverse(), this.mutex, this);
            }
            abstractC2648tu = this.inverse;
        }
        return abstractC2648tu;
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedMap, java.util.Map
    /* renamed from: values  reason: collision with other method in class */
    public Set<V> mo4748values() {
        Set<V> set;
        synchronized (this.mutex) {
            if (this.valueSet == null) {
                this.valueSet = new Synchronized$SynchronizedSet(mo4780delegate().mo4672values(), this.mutex);
            }
            set = this.valueSet;
        }
        return set;
    }
}
