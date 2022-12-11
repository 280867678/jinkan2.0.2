package com.google.common.collect;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import me.tvspark.AbstractC2162gv;
import me.tvspark.AbstractC2165gy;
import me.tvspark.AbstractC2199hv;
import me.tvspark.AbstractC2384mv;
import me.tvspark.AbstractC2726vu;
import me.tvspark.C1927az;

/* loaded from: classes3.dex */
public final class MutableClassToInstanceMap<B> extends AbstractC2162gv<Class<? extends B>, B> implements AbstractC2726vu<B>, Serializable {
    public final Map<Class<? extends B>, B> delegate;

    /* loaded from: classes3.dex */
    public static final class SerializedForm<B> implements Serializable {
        public static final long serialVersionUID = 0;
        public final Map<Class<? extends B>, B> backingMap;

        public SerializedForm(Map<Class<? extends B>, B> map) {
            this.backingMap = map;
        }

        public Object readResolve() {
            return MutableClassToInstanceMap.create(this.backingMap);
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2384mv<Map.Entry<Class<? extends B>, B>> {

        /* loaded from: classes3.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2165gy<Map.Entry<Class<? extends B>, B>, Map.Entry<Class<? extends B>, B>> {
            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Iterator it) {
                super(it);
            }

            @Override // me.tvspark.AbstractC2165gy
            public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
                return MutableClassToInstanceMap.checkedEntry((Map.Entry) obj);
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.AbstractC2384mv, me.tvspark.AbstractC2051dv, me.tvspark.AbstractC2310kv
        /* renamed from: delegate */
        public Set<Map.Entry<Class<? extends B>, B>> mo4974delegate() {
            return MutableClassToInstanceMap.this.mo4974delegate().entrySet();
        }

        @Override // me.tvspark.AbstractC2051dv, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<Class<? extends B>, B>> iterator() {
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, mo4974delegate().iterator());
        }

        @Override // me.tvspark.AbstractC2051dv, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return standardToArray();
        }

        @Override // me.tvspark.AbstractC2051dv, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) standardToArray(tArr);
        }
    }

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2199hv<Class<? extends B>, B> {
        public final /* synthetic */ Map.Entry Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Map.Entry entry) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = entry;
        }

        @Override // me.tvspark.AbstractC2199hv, me.tvspark.AbstractC2310kv
        /* renamed from: delegate */
        public Object mo4974delegate() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.AbstractC2199hv, me.tvspark.AbstractC2310kv
        /* renamed from: delegate  reason: collision with other method in class */
        public Map.Entry<Class<? extends B>, B> mo4974delegate() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.AbstractC2199hv, java.util.Map.Entry
        public B setValue(B b) {
            return (B) super.setValue(MutableClassToInstanceMap.cast(getKey(), b));
        }
    }

    public MutableClassToInstanceMap(Map<Class<? extends B>, B> map) {
        if (map != null) {
            this.delegate = map;
            return;
        }
        throw null;
    }

    public static <B, T extends B> T cast(Class<T> cls, B b) {
        return (T) C1927az.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls).cast(b);
    }

    public static <B> Map.Entry<Class<? extends B>, B> checkedEntry(Map.Entry<Class<? extends B>, B> entry) {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(entry);
    }

    public static <B> MutableClassToInstanceMap<B> create() {
        return new MutableClassToInstanceMap<>(new HashMap());
    }

    public static <B> MutableClassToInstanceMap<B> create(Map<Class<? extends B>, B> map) {
        return new MutableClassToInstanceMap<>(map);
    }

    private Object writeReplace() {
        return new SerializedForm(mo4974delegate());
    }

    @Override // me.tvspark.AbstractC2162gv, me.tvspark.AbstractC2310kv
    /* renamed from: delegate  reason: collision with other method in class */
    public Map<Class<? extends B>, B> mo4974delegate() {
        return this.delegate;
    }

    @Override // me.tvspark.AbstractC2162gv, java.util.Map
    public Set<Map.Entry<Class<? extends B>, B>> entrySet() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public <T extends B> T getInstance(Class<T> cls) {
        return (T) cast(cls, get(cls));
    }

    public B put(Class<? extends B> cls, B b) {
        return (B) super.put((MutableClassToInstanceMap<B>) cls, (Class<? extends B>) cast(cls, b));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.tvspark.AbstractC2162gv, java.util.Map
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return put((Class<? extends Class<? extends B>>) obj, (Class<? extends B>) obj2);
    }

    @Override // me.tvspark.AbstractC2162gv, java.util.Map
    public void putAll(Map<? extends Class<? extends B>, ? extends B> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            cast((Class) entry.getKey(), entry.getValue());
        }
        super.putAll(linkedHashMap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T extends B> T putInstance(Class<T> cls, T t) {
        return (T) cast(cls, put((Class<? extends Class<T>>) cls, (Class<T>) t));
    }
}
