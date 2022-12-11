package com.google.common.collect;

import java.io.Serializable;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import me.tvspark.AbstractC2162gv;
import me.tvspark.AbstractC2648tu;

/* loaded from: classes3.dex */
public class Maps$UnmodifiableBiMap<K, V> extends AbstractC2162gv<K, V> implements AbstractC2648tu<K, V>, Serializable {
    public static final long serialVersionUID = 0;
    public final AbstractC2648tu<? extends K, ? extends V> delegate;
    public AbstractC2648tu<V, K> inverse;
    public final Map<K, V> unmodifiableMap;
    public transient Set<V> values;

    public Maps$UnmodifiableBiMap(AbstractC2648tu<? extends K, ? extends V> abstractC2648tu, AbstractC2648tu<V, K> abstractC2648tu2) {
        this.unmodifiableMap = Collections.unmodifiableMap(abstractC2648tu);
        this.delegate = abstractC2648tu;
        this.inverse = abstractC2648tu2;
    }

    @Override // me.tvspark.AbstractC2162gv, me.tvspark.AbstractC2310kv
    /* renamed from: delegate  reason: collision with other method in class */
    public Map<K, V> mo4974delegate() {
        return this.unmodifiableMap;
    }

    @Override // me.tvspark.AbstractC2648tu
    public V forcePut(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Override // me.tvspark.AbstractC2648tu
    /* renamed from: inverse */
    public AbstractC2648tu<V, K> mo4713inverse() {
        AbstractC2648tu<V, K> abstractC2648tu = this.inverse;
        if (abstractC2648tu == null) {
            Maps$UnmodifiableBiMap maps$UnmodifiableBiMap = new Maps$UnmodifiableBiMap(this.delegate.mo4713inverse(), this);
            this.inverse = maps$UnmodifiableBiMap;
            return maps$UnmodifiableBiMap;
        }
        return abstractC2648tu;
    }

    @Override // me.tvspark.AbstractC2162gv, java.util.Map, me.tvspark.AbstractC2648tu
    /* renamed from: values  reason: collision with other method in class */
    public Set<V> mo4672values() {
        Set<V> set = this.values;
        if (set == null) {
            Set<V> unmodifiableSet = Collections.unmodifiableSet(this.delegate.mo4672values());
            this.values = unmodifiableSet;
            return unmodifiableSet;
        }
        return set;
    }
}
