package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import java.io.Serializable;
import java.util.Map;
import me.tvspark.AbstractC2162gv;
import me.tvspark.AbstractC2726vu;
import me.tvspark.C1927az;

/* loaded from: classes3.dex */
public final class ImmutableClassToInstanceMap<B> extends AbstractC2162gv<Class<? extends B>, B> implements AbstractC2726vu<B>, Serializable {
    public static final ImmutableClassToInstanceMap<Object> EMPTY = new ImmutableClassToInstanceMap<>(ImmutableMap.m3900of());
    public final ImmutableMap<Class<? extends B>, B> delegate;

    /* loaded from: classes3.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<B> {
        public final ImmutableMap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Class<? extends B>, B> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ImmutableMap.builder();
    }

    public ImmutableClassToInstanceMap(ImmutableMap<Class<? extends B>, B> immutableMap) {
        this.delegate = immutableMap;
    }

    public static <B> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<B> builder() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<>();
    }

    public static <B, S extends B> ImmutableClassToInstanceMap<B> copyOf(Map<? extends Class<? extends S>, ? extends S> map) {
        if (map instanceof ImmutableClassToInstanceMap) {
            return (ImmutableClassToInstanceMap) map;
        }
        ImmutableMap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww builder = ImmutableMap.builder();
        for (Map.Entry<? extends Class<? extends S>, ? extends S> entry : map.entrySet()) {
            Class<? extends S> key = entry.getKey();
            builder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(key, C1927az.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(key).cast(entry.getValue()));
        }
        ImmutableMap mo4533Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = builder.mo4533Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        return mo4533Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isEmpty() ? m3921of() : new ImmutableClassToInstanceMap<>(mo4533Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    /* renamed from: of */
    public static <B> ImmutableClassToInstanceMap<B> m3921of() {
        return (ImmutableClassToInstanceMap<B>) EMPTY;
    }

    /* renamed from: of */
    public static <B, T extends B> ImmutableClassToInstanceMap<B> m3920of(Class<T> cls, T t) {
        return new ImmutableClassToInstanceMap<>(ImmutableMap.m3899of(cls, t));
    }

    @Override // me.tvspark.AbstractC2162gv, me.tvspark.AbstractC2310kv
    /* renamed from: delegate  reason: collision with other method in class */
    public Map<Class<? extends B>, B> mo4974delegate() {
        return this.delegate;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [T extends B, java.lang.Object] */
    public <T extends B> T getInstance(Class<T> cls) {
        ImmutableMap<Class<? extends B>, B> immutableMap = this.delegate;
        if (cls != null) {
            return immutableMap.mo4554get(cls);
        }
        throw null;
    }

    @Deprecated
    public <T extends B> T putInstance(Class<T> cls, T t) {
        throw new UnsupportedOperationException();
    }

    public Object readResolve() {
        return isEmpty() ? m3921of() : this;
    }
}
