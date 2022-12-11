package com.google.common.collect;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import me.tvspark.AbstractC2090ex;
import me.tvspark.AbstractC2239iy;
import me.tvspark.AbstractC2611su;
import me.tvspark.AbstractC2876zw;
import me.tvspark.C2577rx;
import me.tvspark.C2838yv;
import me.tvspark.Illllllllllllllllllllllllllll;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public abstract class ImmutableMultimap<K, V> extends AbstractC2611su<K, V> implements Serializable {
    public static final long serialVersionUID = 0;
    public final transient ImmutableMap<K, ? extends ImmutableCollection<V>> map;
    public final transient int size;

    /* loaded from: classes3.dex */
    public static class EntryCollection<K, V> extends ImmutableCollection<Map.Entry<K, V>> {
        public static final long serialVersionUID = 0;
        public final ImmutableMultimap<K, V> multimap;

        public EntryCollection(ImmutableMultimap<K, V> immutableMultimap) {
            this.multimap = immutableMultimap;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                return this.multimap.containsEntry(entry.getKey(), entry.getValue());
            }
            return false;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return this.multimap.isPartialView();
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        /* renamed from: iterator  reason: collision with other method in class */
        public AbstractC2239iy<Map.Entry<K, V>> mo4735iterator() {
            return this.multimap.mo4563entryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.multimap.size();
        }
    }

    /* loaded from: classes3.dex */
    public class Keys extends ImmutableMultiset<K> {
        public Keys() {
        }

        @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return ImmutableMultimap.this.containsKey(obj);
        }

        @Override // me.tvspark.AbstractC2090ex
        public int count(Object obj) {
            ImmutableCollection<V> mo4554get = ImmutableMultimap.this.map.mo4554get(obj);
            if (mo4554get == null) {
                return 0;
            }
            return mo4554get.size();
        }

        @Override // com.google.common.collect.ImmutableMultiset, me.tvspark.AbstractC2090ex
        /* renamed from: elementSet */
        public ImmutableSet<K> mo4975elementSet() {
            return ImmutableMultimap.this.mo4794keySet();
        }

        @Override // com.google.common.collect.ImmutableMultiset
        public AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K> getEntry(int i) {
            Map.Entry<K, ? extends ImmutableCollection<V>> entry = ImmutableMultimap.this.map.mo4551entrySet().asList().get(i);
            return new Multisets$ImmutableEntry(entry.getKey(), entry.getValue().size());
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, me.tvspark.AbstractC2090ex
        public int size() {
            return ImmutableMultimap.this.size();
        }

        @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection
        public Object writeReplace() {
            return new KeysSerializedForm(ImmutableMultimap.this);
        }
    }

    /* loaded from: classes3.dex */
    public static final class KeysSerializedForm implements Serializable {
        public final ImmutableMultimap<?, ?> multimap;

        public KeysSerializedForm(ImmutableMultimap<?, ?> immutableMultimap) {
            this.multimap = immutableMultimap;
        }

        public Object readResolve() {
            return this.multimap.mo4566keys();
        }
    }

    /* loaded from: classes3.dex */
    public static final class Values<K, V> extends ImmutableCollection<V> {
        public static final long serialVersionUID = 0;
        public final transient ImmutableMultimap<K, V> multimap;

        public Values(ImmutableMultimap<K, V> immutableMultimap) {
            this.multimap = immutableMultimap;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.multimap.containsValue(obj);
        }

        @Override // com.google.common.collect.ImmutableCollection
        public int copyIntoArray(Object[] objArr, int i) {
            AbstractC2239iy<? extends ImmutableCollection<V>> mo4735iterator = this.multimap.map.values().mo4735iterator();
            while (mo4735iterator.hasNext()) {
                i = mo4735iterator.next().copyIntoArray(objArr, i);
            }
            return i;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        /* renamed from: iterator  reason: collision with other method in class */
        public AbstractC2239iy<V> mo4735iterator() {
            return this.multimap.mo4569valueIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.multimap.size();
        }
    }

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public static final C2577rx<ImmutableMultimap> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ImmutableMultimap.class, "map");
        public static final C2577rx<ImmutableMultimap> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ImmutableMultimap.class, "size");
    }

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> {
        public Map<K, Collection<V>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = CompactHashMap.create();

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            for (Map.Entry<? extends K, ? extends V> entry : iterable) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(entry);
            }
            return this;
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(K k, Iterable<? extends V> iterable) {
            if (k == null) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("null key in entry: null=");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Iterable<?>) iterable));
                throw new NullPointerException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            }
            Collection<V> collection = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(k);
            Iterator<? extends V> it = iterable.iterator();
            if (collection != null) {
                while (it.hasNext()) {
                    V next = it.next();
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k, next);
                    collection.add(next);
                }
                return this;
            } else if (!it.hasNext()) {
                return this;
            } else {
                Collection<V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                while (it.hasNext()) {
                    V next2 = it.next();
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k, next2);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.add(next2);
                }
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(k, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                return this;
            }
        }

        /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> mo4604Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(K k, V v) {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k, v);
            Collection<V> collection = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(k);
            if (collection == null) {
                Map<K, Collection<V>> map = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                Collection<V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                map.put(k, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                collection = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            collection.add(v);
            return this;
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Map.Entry<? extends K, ? extends V> entry) {
            return mo4604Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V>) entry.getKey(), (K) entry.getValue());
        }

        public Collection<V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return new ArrayList();
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2239iy<V> {
        public Iterator<V> Wwwwwwwwwwwwwwwwwwwwwww = C2838yv.Wwwwwwwwwwwwwwwwwwww;
        public Iterator<? extends ImmutableCollection<V>> Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = ImmutableMultimap.this.map.values().mo4735iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.Wwwwwwwwwwwwwwwwwwwwwww.hasNext() || this.Wwwwwwwwwwwwwwwwwwwwwwww.hasNext();
        }

        @Override // java.util.Iterator
        public V next() {
            if (!this.Wwwwwwwwwwwwwwwwwwwwwww.hasNext()) {
                this.Wwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww.next().mo4735iterator();
            }
            return this.Wwwwwwwwwwwwwwwwwwwwwww.next();
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2239iy<Map.Entry<K, V>> {
        public final Iterator<? extends Map.Entry<K, ? extends ImmutableCollection<V>>> Wwwwwwwwwwwwwwwwwwwwwwww;
        public K Wwwwwwwwwwwwwwwwwwwwwww = null;
        public Iterator<V> Wwwwwwwwwwwwwwwwwwwwww = C2838yv.Wwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = ImmutableMultimap.this.map.mo4551entrySet().mo4735iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.Wwwwwwwwwwwwwwwwwwwwww.hasNext() || this.Wwwwwwwwwwwwwwwwwwwwwwww.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            if (!this.Wwwwwwwwwwwwwwwwwwwwww.hasNext()) {
                Map.Entry<K, ? extends ImmutableCollection<V>> next = this.Wwwwwwwwwwwwwwwwwwwwwwww.next();
                this.Wwwwwwwwwwwwwwwwwwwwwww = next.getKey();
                this.Wwwwwwwwwwwwwwwwwwwwww = next.getValue().mo4735iterator();
            }
            return new ImmutableEntry(this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww.next());
        }
    }

    public ImmutableMultimap(ImmutableMap<K, ? extends ImmutableCollection<V>> immutableMap, int i) {
        this.map = immutableMap;
        this.size = i;
    }

    public static <K, V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> builder() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<>();
    }

    public static <K, V> ImmutableMultimap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        return ImmutableListMultimap.copyOf((Iterable) iterable);
    }

    public static <K, V> ImmutableMultimap<K, V> copyOf(AbstractC2876zw<? extends K, ? extends V> abstractC2876zw) {
        if (abstractC2876zw instanceof ImmutableMultimap) {
            ImmutableMultimap<K, V> immutableMultimap = (ImmutableMultimap) abstractC2876zw;
            if (!immutableMultimap.isPartialView()) {
                return immutableMultimap;
            }
        }
        return ImmutableListMultimap.copyOf((AbstractC2876zw) abstractC2876zw);
    }

    /* renamed from: of */
    public static <K, V> ImmutableMultimap<K, V> m3894of() {
        return ImmutableListMultimap.m3906of();
    }

    /* renamed from: of */
    public static <K, V> ImmutableMultimap<K, V> m3893of(K k, V v) {
        return ImmutableListMultimap.m3905of((Object) k, (Object) v);
    }

    /* renamed from: of */
    public static <K, V> ImmutableMultimap<K, V> m3892of(K k, V v, K k2, V v2) {
        return ImmutableListMultimap.m3904of((Object) k, (Object) v, (Object) k2, (Object) v2);
    }

    /* renamed from: of */
    public static <K, V> ImmutableMultimap<K, V> m3891of(K k, V v, K k2, V v2, K k3, V v3) {
        return ImmutableListMultimap.m3903of((Object) k, (Object) v, (Object) k2, (Object) v2, (Object) k3, (Object) v3);
    }

    /* renamed from: of */
    public static <K, V> ImmutableMultimap<K, V> m3890of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        return ImmutableListMultimap.m3902of((Object) k, (Object) v, (Object) k2, (Object) v2, (Object) k3, (Object) v3, (Object) k4, (Object) v4);
    }

    /* renamed from: of */
    public static <K, V> ImmutableMultimap<K, V> m3889of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        return ImmutableListMultimap.m3901of((Object) k, (Object) v, (Object) k2, (Object) v2, (Object) k3, (Object) v3, (Object) k4, (Object) v4, (Object) k5, (Object) v5);
    }

    @Override // me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    /* renamed from: asMap */
    public ImmutableMap<K, Collection<V>> mo4790asMap() {
        return (ImmutableMap<K, ? extends ImmutableCollection<V>>) this.map;
    }

    @Override // me.tvspark.AbstractC2876zw
    @Deprecated
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    public /* bridge */ /* synthetic */ boolean containsEntry(Object obj, Object obj2) {
        return super.containsEntry(obj, obj2);
    }

    @Override // me.tvspark.AbstractC2876zw
    public boolean containsKey(Object obj) {
        return this.map.containsKey(obj);
    }

    @Override // me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    public boolean containsValue(Object obj) {
        return obj != null && super.containsValue(obj);
    }

    @Override // me.tvspark.AbstractC2309ku
    public Map<K, Collection<V>> createAsMap() {
        throw new AssertionError("should never be called");
    }

    @Override // me.tvspark.AbstractC2309ku
    /* renamed from: createEntries */
    public ImmutableCollection<Map.Entry<K, V>> mo4647createEntries() {
        return new EntryCollection(this);
    }

    @Override // me.tvspark.AbstractC2309ku
    public Set<K> createKeySet() {
        throw new AssertionError("unreachable");
    }

    @Override // me.tvspark.AbstractC2309ku
    /* renamed from: createKeys */
    public ImmutableMultiset<K> mo4560createKeys() {
        return new Keys();
    }

    @Override // me.tvspark.AbstractC2309ku
    /* renamed from: createValues */
    public ImmutableCollection<V> mo4648createValues() {
        return new Values(this);
    }

    @Override // me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    /* renamed from: entries */
    public ImmutableCollection<Map.Entry<K, V>> mo4768entries() {
        return (ImmutableCollection) super.mo4768entries();
    }

    @Override // me.tvspark.AbstractC2309ku
    /* renamed from: entryIterator  reason: collision with other method in class */
    public AbstractC2239iy<Map.Entry<K, V>> mo4563entryIterator() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: get */
    public abstract ImmutableCollection<V> mo4793get(K k);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: get  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Collection mo4793get(Object obj) {
        return mo4793get((ImmutableMultimap<K, V>) obj);
    }

    @Override // me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    /* renamed from: inverse */
    public abstract ImmutableMultimap<V, K> mo4598inverse();

    @Override // me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    public boolean isPartialView() {
        return this.map.isPartialView();
    }

    @Override // me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    /* renamed from: keySet */
    public ImmutableSet<K> mo4794keySet() {
        return this.map.mo4552keySet();
    }

    @Override // me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    /* renamed from: keys */
    public ImmutableMultiset<K> mo4566keys() {
        return (ImmutableMultiset) super.mo4566keys();
    }

    @Override // me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    @Deprecated
    public boolean put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Override // me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    @Deprecated
    public boolean putAll(K k, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override // me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    @Deprecated
    public boolean putAll(AbstractC2876zw<? extends K, ? extends V> abstractC2876zw) {
        throw new UnsupportedOperationException();
    }

    @Override // me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    @Deprecated
    public boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    @Deprecated
    /* renamed from: removeAll */
    public ImmutableCollection<V> mo4778removeAll(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    @Deprecated
    /* renamed from: replaceValues */
    public ImmutableCollection<V> mo4779replaceValues(K k, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    @Deprecated
    /* renamed from: replaceValues  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Collection mo4779replaceValues(Object obj, Iterable iterable) {
        return mo4779replaceValues((ImmutableMultimap<K, V>) obj, iterable);
    }

    @Override // me.tvspark.AbstractC2876zw
    public int size() {
        return this.size;
    }

    @Override // me.tvspark.AbstractC2309ku
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // me.tvspark.AbstractC2309ku
    /* renamed from: valueIterator  reason: collision with other method in class */
    public AbstractC2239iy<V> mo4569valueIterator() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    /* renamed from: values */
    public ImmutableCollection<V> mo4653values() {
        return (ImmutableCollection) super.mo4653values();
    }
}
