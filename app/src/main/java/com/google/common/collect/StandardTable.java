package com.google.common.collect;

import com.google.common.base.Predicates$CompositionPredicate;
import com.google.common.base.Predicates$IsEqualToPredicate;
import com.google.common.base.Predicates$NotPredicate;
import com.google.common.base.Predicates$ObjectPredicate;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import me.tvspark.AbstractC2128fy;
import me.tvspark.AbstractC2271jt;
import me.tvspark.AbstractC2502pw;
import me.tvspark.AbstractC2537qu;
import me.tvspark.AbstractC2573rt;
import me.tvspark.AbstractC2651tx;
import me.tvspark.AbstractC2684ut;
import me.tvspark.AbstractC2839yw;
import me.tvspark.C1963by;
import me.tvspark.C2000cy;
import me.tvspark.C2539qw;
import me.tvspark.C2763wu;
import me.tvspark.C2802xw;
import me.tvspark.C2838yv;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public class StandardTable<R, C, V> extends AbstractC2537qu<R, C, V> implements Serializable {
    public static final long serialVersionUID = 0;
    public final Map<R, Map<C, V>> backingMap;
    public transient Set<C> columnKeySet;
    public transient StandardTable<R, C, V>.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww columnMap;
    public final AbstractC2684ut<? extends Map<C, V>> factory;
    public transient Map<R, Map<C, V>> rowMap;

    /* loaded from: classes3.dex */
    public abstract class Wwwwwwwwwwwwwwwwwwwwwwwwww<T> extends AbstractC2651tx<T> {
        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            StandardTable.this.backingMap.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return StandardTable.this.backingMap.isEmpty();
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2839yw<R, Map<C, V>> {

        /* loaded from: classes3.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends StandardTable<R, C, V>.Wwwwwwwwwwwwwwwwwwwwwwwwww<Map.Entry<R, Map<C, V>>> {

            /* renamed from: com.google.common.collect.StandardTable$Wwwwwwwwwwwwwwwwwwwwwwwwwww$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class C3456Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements AbstractC2271jt<R, Map<C, V>> {
                public C3456Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
                }

                @Override // me.tvspark.AbstractC2271jt
                /* renamed from: apply */
                public Object mo4462apply(Object obj) {
                    return StandardTable.this.mo4785row(obj);
                }
            }

            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
                super(null);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    return entry.getKey() != null && (entry.getValue() instanceof Map) && C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(StandardTable.this.backingMap.entrySet(), entry);
                }
                return false;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<R, Map<C, V>>> iterator() {
                return C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Set) StandardTable.this.backingMap.keySet(), (AbstractC2271jt) new C3456Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    return entry.getKey() != null && (entry.getValue() instanceof Map) && StandardTable.this.backingMap.entrySet().remove(entry);
                }
                return false;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return StandardTable.this.backingMap.size();
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.AbstractC2839yw
        public Set<Map.Entry<R, Map<C, V>>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return StandardTable.this.containsRow(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object get(Object obj) {
            if (StandardTable.this.containsRow(obj)) {
                return StandardTable.this.mo4785row(obj);
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object remove(Object obj) {
            if (obj == null) {
                return null;
            }
            return StandardTable.this.backingMap.remove(obj);
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2502pw<C, V> {
        public Map<C, V> Wwwwwwwwwwwwwwwwwwwwwww;
        public final R Wwwwwwwwwwwwwwwwwwwwwwww;

        /* loaded from: classes3.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Iterator<Map.Entry<C, V>> {
            public final /* synthetic */ Iterator Wwwwwwwwwwwwwwwwwwwwwwww;

            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Iterator it) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.Wwwwwwwwwwwwwwwwwwwwwwww.hasNext();
            }

            @Override // java.util.Iterator
            public Object next() {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwww.this;
                Map.Entry entry = (Map.Entry) this.Wwwwwwwwwwwwwwwwwwwwwwww.next();
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                    return new C2000cy(wwwwwwwwwwwwwwwwwwwwwwwwwwww, entry);
                }
                throw null;
            }

            @Override // java.util.Iterator
            public void remove() {
                this.Wwwwwwwwwwwwwwwwwwwwwwww.remove();
                Wwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwww(R r) {
            if (r != null) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww = r;
                return;
            }
            throw null;
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            if (mo4789Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == null || !this.Wwwwwwwwwwwwwwwwwwwwwww.isEmpty()) {
                return;
            }
            StandardTable.this.backingMap.remove(this.Wwwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwww = null;
        }

        public Map<C, V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return StandardTable.this.backingMap.get(this.Wwwwwwwwwwwwwwwwwwwwwwww);
        }

        /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
        public Map<C, V> mo4789Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            Map<C, V> map = this.Wwwwwwwwwwwwwwwwwwwwwww;
            if (map == null || (map.isEmpty() && StandardTable.this.backingMap.containsKey(this.Wwwwwwwwwwwwwwwwwwwwwwww))) {
                Map<C, V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                this.Wwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            return this.Wwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.AbstractC2502pw
        public Iterator<Map.Entry<C, V>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            Map<C, V> mo4789Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = mo4789Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            if (mo4789Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                return Iterators$EmptyModifiableIterator.INSTANCE;
            }
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mo4789Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.entrySet().iterator());
        }

        @Override // me.tvspark.AbstractC2502pw, java.util.AbstractMap, java.util.Map
        public void clear() {
            Map<C, V> mo4789Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = mo4789Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            if (mo4789Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                mo4789Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            Map<C, V> mo4789Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = mo4789Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            return (obj == null || mo4789Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null || !C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Map<?, ?>) mo4789Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, obj)) ? false : true;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object obj) {
            Map<C, V> mo4789Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = mo4789Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            if (obj == null || mo4789Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                return null;
            }
            try {
                return mo4789Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(obj);
            } catch (ClassCastException | NullPointerException unused) {
                return null;
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(C c, V v) {
            if (c != null) {
                if (v == null) {
                    throw null;
                }
                Map<C, V> map = this.Wwwwwwwwwwwwwwwwwwwwwww;
                return (map == null || map.isEmpty()) ? (V) StandardTable.this.put(this.Wwwwwwwwwwwwwwwwwwwwwwww, c, v) : this.Wwwwwwwwwwwwwwwwwwwwwww.put(c, v);
            }
            throw null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(Object obj) {
            Map<C, V> mo4789Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = mo4789Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            V v = null;
            if (mo4789Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                return null;
            }
            try {
                v = mo4789Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.remove(obj);
            } catch (ClassCastException | NullPointerException unused) {
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            return v;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            Map<C, V> mo4789Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = mo4789Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            if (mo4789Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                return 0;
            }
            return mo4789Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size();
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2839yw<C, Map<R, V>> {

        /* loaded from: classes3.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends C2802xw<C, Map<R, V>> {
            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
                super(Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.this);
            }

            @Override // me.tvspark.C2802xw, java.util.AbstractCollection, java.util.Collection
            public boolean remove(Object obj) {
                for (Map.Entry<C, Map<R, V>> entry : Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.entrySet()) {
                    if (entry.getValue().equals(obj)) {
                        StandardTable.this.removeColumn(entry.getKey());
                        return true;
                    }
                }
                return false;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // me.tvspark.C2802xw, java.util.AbstractCollection, java.util.Collection
            public boolean removeAll(Collection<?> collection) {
                if (collection != null) {
                    boolean z = false;
                    Iterator it = C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(StandardTable.this.mo4635columnKeySet().iterator()).iterator();
                    while (it.hasNext()) {
                        Object next = it.next();
                        if (collection.contains(StandardTable.this.mo4736column(next))) {
                            StandardTable.this.removeColumn(next);
                            z = true;
                        }
                    }
                    return z;
                }
                throw null;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // me.tvspark.C2802xw, java.util.AbstractCollection, java.util.Collection
            public boolean retainAll(Collection<?> collection) {
                if (collection != null) {
                    boolean z = false;
                    Iterator it = C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(StandardTable.this.mo4635columnKeySet().iterator()).iterator();
                    while (it.hasNext()) {
                        Object next = it.next();
                        if (!collection.contains(StandardTable.this.mo4736column(next))) {
                            StandardTable.this.removeColumn(next);
                            z = true;
                        }
                    }
                    return z;
                }
                throw null;
            }
        }

        /* loaded from: classes3.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends StandardTable<R, C, V>.Wwwwwwwwwwwwwwwwwwwwwwwwww<Map.Entry<C, Map<R, V>>> {

            /* renamed from: com.google.common.collect.StandardTable$Wwwwwwwwwwwwwwwwwwwwwwwwwwwww$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class C3457Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements AbstractC2271jt<C, Map<R, V>> {
                public C3457Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
                }

                @Override // me.tvspark.AbstractC2271jt
                /* renamed from: apply */
                public Object mo4462apply(Object obj) {
                    return StandardTable.this.mo4736column(obj);
                }
            }

            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
                super(null);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    if (!StandardTable.this.containsColumn(entry.getKey())) {
                        return false;
                    }
                    Object key = entry.getKey();
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.this;
                    return (StandardTable.this.containsColumn(key) ? StandardTable.this.mo4736column(key) : null).equals(entry.getValue());
                }
                return false;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<C, Map<R, V>>> iterator() {
                return C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Set) StandardTable.this.mo4635columnKeySet(), (AbstractC2271jt) new C3457Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (contains(obj)) {
                    StandardTable.this.removeColumn(((Map.Entry) obj).getKey());
                    return true;
                }
                return false;
            }

            @Override // me.tvspark.AbstractC2651tx, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean removeAll(Collection<?> collection) {
                if (collection != null) {
                    return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Set<?>) this, collection.iterator());
                }
                throw null;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // me.tvspark.AbstractC2651tx, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                if (collection != null) {
                    boolean z = false;
                    Iterator it = C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(StandardTable.this.mo4635columnKeySet().iterator()).iterator();
                    while (it.hasNext()) {
                        Object next = it.next();
                        if (!collection.contains(new ImmutableEntry(next, StandardTable.this.mo4736column(next)))) {
                            StandardTable.this.removeColumn(next);
                            z = true;
                        }
                    }
                    return z;
                }
                throw null;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return StandardTable.this.mo4635columnKeySet().size();
            }
        }

        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        }

        @Override // me.tvspark.AbstractC2839yw
        public Collection<Map<R, V>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }

        @Override // me.tvspark.AbstractC2839yw
        public Set<Map.Entry<C, Map<R, V>>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return StandardTable.this.containsColumn(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object get(Object obj) {
            if (StandardTable.this.containsColumn(obj)) {
                return StandardTable.this.mo4736column(obj);
            }
            return null;
        }

        @Override // me.tvspark.AbstractC2839yw, java.util.AbstractMap, java.util.Map, java.util.SortedMap
        /* renamed from: keySet */
        public Set<C> mo4481keySet() {
            return StandardTable.this.mo4635columnKeySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object remove(Object obj) {
            if (StandardTable.this.containsColumn(obj)) {
                return StandardTable.this.removeColumn(obj);
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends StandardTable<R, C, V>.Wwwwwwwwwwwwwwwwwwwwwwwwww<C> {
        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            super(null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return StandardTable.this.containsColumn(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<C> iterator() {
            return StandardTable.this.createColumnKeyIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            boolean z = false;
            if (obj == null) {
                return false;
            }
            Iterator<Map<C, V>> it = StandardTable.this.backingMap.values().iterator();
            while (it.hasNext()) {
                Map<C, V> next = it.next();
                if (next.keySet().remove(obj)) {
                    z = true;
                    if (next.isEmpty()) {
                        it.remove();
                    }
                }
            }
            return z;
        }

        @Override // me.tvspark.AbstractC2651tx, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            if (collection != null) {
                boolean z = false;
                Iterator<Map<C, V>> it = StandardTable.this.backingMap.values().iterator();
                while (it.hasNext()) {
                    Map<C, V> next = it.next();
                    if (Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Iterator<?>) next.keySet().iterator(), collection)) {
                        z = true;
                        if (next.isEmpty()) {
                            it.remove();
                        }
                    }
                }
                return z;
            }
            throw null;
        }

        @Override // me.tvspark.AbstractC2651tx, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            if (collection != null) {
                boolean z = false;
                Iterator<Map<C, V>> it = StandardTable.this.backingMap.values().iterator();
                while (it.hasNext()) {
                    Map<C, V> next = it.next();
                    if (next.keySet().retainAll(collection)) {
                        z = true;
                        if (next.isEmpty()) {
                            it.remove();
                        }
                    }
                }
                return z;
            }
            throw null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Iterator<?>) iterator());
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractIterator<C> {
        public Iterator<Map.Entry<C, V>> Wwwwwwwwwwwwwwwwwwww = C2838yv.Wwwwwwwwwwwwwwwwwwww;
        public final Iterator<Map<C, V>> Wwwwwwwwwwwwwwwwwwwww;
        public final Map<C, V> Wwwwwwwwwwwwwwwwwwwwww;

        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwww = StandardTable.this.factory.mo4804get();
            this.Wwwwwwwwwwwwwwwwwwwww = StandardTable.this.backingMap.values().iterator();
        }

        @Override // com.google.common.collect.AbstractIterator
        public C Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            while (true) {
                if (this.Wwwwwwwwwwwwwwwwwwww.hasNext()) {
                    Map.Entry<C, V> next = this.Wwwwwwwwwwwwwwwwwwww.next();
                    if (!this.Wwwwwwwwwwwwwwwwwwwwww.containsKey(next.getKey())) {
                        this.Wwwwwwwwwwwwwwwwwwwwww.put(next.getKey(), next.getValue());
                        return next.getKey();
                    }
                } else if (!this.Wwwwwwwwwwwwwwwwwwwww.hasNext()) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    return null;
                } else {
                    this.Wwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwww.next().entrySet().iterator();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2839yw<R, V> {
        public final C Wwwwwwwwwwwwwwwwwwwww;

        /* loaded from: classes3.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends C2802xw<R, V> {
            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
                super(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this);
            }

            @Override // me.tvspark.C2802xw, java.util.AbstractCollection, java.util.Collection
            public boolean remove(Object obj) {
                return obj != null && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Predicates$IsEqualToPredicate(obj)));
            }

            @Override // me.tvspark.C2802xw, java.util.AbstractCollection, java.util.Collection
            public boolean removeAll(Collection<?> collection) {
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Collection) collection)));
            }

            @Override // me.tvspark.C2802xw, java.util.AbstractCollection, java.util.Collection
            public boolean retainAll(Collection<?> collection) {
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Predicates$NotPredicate(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Collection) collection))));
            }
        }

        /* renamed from: com.google.common.collect.StandardTable$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C3458Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends C2539qw<R, V> {
            public C3458Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
                super(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this);
            }

            @Override // me.tvspark.C2539qw, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this;
                return StandardTable.this.contains(obj, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww);
            }

            @Override // me.tvspark.C2539qw, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this;
                return StandardTable.this.remove(obj, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww) != null;
            }

            @Override // me.tvspark.AbstractC2651tx, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Predicates$CompositionPredicate(new Predicates$NotPredicate(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Collection) collection)), Maps$EntryFunction.KEY));
            }
        }

        /* loaded from: classes3.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractIterator<Map.Entry<R, V>> {
            public final Iterator<Map.Entry<R, Map<C, V>>> Wwwwwwwwwwwwwwwwwwwwww;

            public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                this.Wwwwwwwwwwwwwwwwwwwwww = StandardTable.this.backingMap.entrySet().iterator();
            }

            @Override // com.google.common.collect.AbstractIterator
            public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
                while (this.Wwwwwwwwwwwwwwwwwwwwww.hasNext()) {
                    Map.Entry<R, Map<C, V>> next = this.Wwwwwwwwwwwwwwwwwwwwww.next();
                    if (next.getValue().containsKey(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwww)) {
                        return new C1963by(this, next);
                    }
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                return null;
            }
        }

        /* loaded from: classes3.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2651tx<Map.Entry<R, V>> {
            public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Predicates$ObjectPredicate.ALWAYS_TRUE.withNarrowedType());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    return StandardTable.this.containsMapping(entry.getKey(), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwww, entry.getValue());
                }
                return false;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean isEmpty() {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this;
                return !StandardTable.this.containsColumn(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<R, V>> iterator() {
                return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    return StandardTable.this.removeMapping(entry.getKey(), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwww, entry.getValue());
                }
                return false;
            }

            @Override // me.tvspark.AbstractC2651tx, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Predicates$NotPredicate(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Collection) collection)));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                int i = 0;
                for (Map<C, V> map : StandardTable.this.backingMap.values()) {
                    if (map.containsKey(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwww)) {
                        i++;
                    }
                }
                return i;
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C c) {
            if (c != null) {
                this.Wwwwwwwwwwwwwwwwwwwww = c;
                return;
            }
            throw null;
        }

        @Override // me.tvspark.AbstractC2839yw
        public Collection<V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }

        @Override // me.tvspark.AbstractC2839yw
        /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
        public Set<R> mo4480Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return new C3458Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }

        @Override // me.tvspark.AbstractC2839yw
        public Set<Map.Entry<R, V>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null);
        }

        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2573rt<? super Map.Entry<R, V>> abstractC2573rt) {
            Iterator<Map.Entry<R, Map<C, V>>> it = StandardTable.this.backingMap.entrySet().iterator();
            boolean z = false;
            while (it.hasNext()) {
                Map.Entry<R, Map<C, V>> next = it.next();
                Map<C, V> value = next.getValue();
                V v = value.get(this.Wwwwwwwwwwwwwwwwwwwww);
                if (v != null && abstractC2573rt.apply(new ImmutableEntry(next.getKey(), v))) {
                    value.remove(this.Wwwwwwwwwwwwwwwwwwwww);
                    z = true;
                    if (value.isEmpty()) {
                        it.remove();
                    }
                }
            }
            return z;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return StandardTable.this.contains(obj, this.Wwwwwwwwwwwwwwwwwwwww);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object obj) {
            return (V) StandardTable.this.get(obj, this.Wwwwwwwwwwwwwwwwwwwww);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(R r, V v) {
            return (V) StandardTable.this.put(r, this.Wwwwwwwwwwwwwwwwwwwww, v);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(Object obj) {
            return (V) StandardTable.this.remove(obj, this.Wwwwwwwwwwwwwwwwwwwww);
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Iterator<AbstractC2128fy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<R, C, V>> {
        public Iterator<Map.Entry<C, V>> Wwwwwwwwwwwwwwwwwwwwww = Iterators$EmptyModifiableIterator.INSTANCE;
        public Map.Entry<R, Map<C, V>> Wwwwwwwwwwwwwwwwwwwwwww;
        public final Iterator<Map.Entry<R, Map<C, V>>> Wwwwwwwwwwwwwwwwwwwwwwww;

        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = StandardTable.this.backingMap.entrySet().iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww.hasNext() || this.Wwwwwwwwwwwwwwwwwwwwww.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            if (!this.Wwwwwwwwwwwwwwwwwwwwww.hasNext()) {
                Map.Entry<R, Map<C, V>> next = this.Wwwwwwwwwwwwwwwwwwwwwwww.next();
                this.Wwwwwwwwwwwwwwwwwwwwwww = next;
                this.Wwwwwwwwwwwwwwwwwwwwww = next.getValue().entrySet().iterator();
            }
            Map.Entry<C, V> next2 = this.Wwwwwwwwwwwwwwwwwwwwww.next();
            return Tables.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww.getKey(), next2.getKey(), next2.getValue());
        }

        @Override // java.util.Iterator
        public void remove() {
            this.Wwwwwwwwwwwwwwwwwwwwww.remove();
            if (this.Wwwwwwwwwwwwwwwwwwwwwww.getValue().isEmpty()) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww.remove();
                this.Wwwwwwwwwwwwwwwwwwwwwww = null;
            }
        }
    }

    public StandardTable(Map<R, Map<C, V>> map, AbstractC2684ut<? extends Map<C, V>> abstractC2684ut) {
        this.backingMap = map;
        this.factory = abstractC2684ut;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean containsMapping(Object obj, Object obj2, Object obj3) {
        return obj3 != null && obj3.equals(get(obj, obj2));
    }

    private Map<C, V> getOrCreate(R r) {
        Map<C, V> map = this.backingMap.get(r);
        if (map == null) {
            Map<C, V> mo4804get = this.factory.mo4804get();
            this.backingMap.put(r, mo4804get);
            return mo4804get;
        }
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<R, V> removeColumn(Object obj) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<Map.Entry<R, Map<C, V>>> it = this.backingMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<R, Map<C, V>> next = it.next();
            V remove = next.getValue().remove(obj);
            if (remove != null) {
                linkedHashMap.put(next.getKey(), remove);
                if (next.getValue().isEmpty()) {
                    it.remove();
                }
            }
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean removeMapping(Object obj, Object obj2, Object obj3) {
        if (containsMapping(obj, obj2, obj3)) {
            remove(obj, obj2);
            return true;
        }
        return false;
    }

    @Override // me.tvspark.AbstractC2537qu
    /* renamed from: cellIterator */
    public Iterator<AbstractC2128fy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<R, C, V>> mo4632cellIterator() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null);
    }

    @Override // me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    /* renamed from: cellSet */
    public Set<AbstractC2128fy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<R, C, V>> mo4633cellSet() {
        return super.mo4633cellSet();
    }

    @Override // me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    public void clear() {
        this.backingMap.clear();
    }

    @Override // me.tvspark.AbstractC2128fy
    /* renamed from: column */
    public Map<R, V> mo4736column(C c) {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c);
    }

    @Override // me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    /* renamed from: columnKeySet */
    public Set<C> mo4635columnKeySet() {
        Set<C> set = this.columnKeySet;
        if (set == null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null);
            this.columnKeySet = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            return wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        return set;
    }

    @Override // me.tvspark.AbstractC2128fy
    /* renamed from: columnMap */
    public Map<C, Map<R, V>> mo4741columnMap() {
        StandardTable<R, C, V>.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.columnMap;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            StandardTable<R, C, V>.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(null);
            this.columnMap = wwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            return wwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        }
        return wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    public boolean contains(Object obj, Object obj2) {
        return (obj == null || obj2 == null || !super.contains(obj, obj2)) ? false : true;
    }

    @Override // me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    public boolean containsColumn(Object obj) {
        if (obj == null) {
            return false;
        }
        for (Map<C, V> map : this.backingMap.values()) {
            if (C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Map<?, ?>) map, obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    public boolean containsRow(Object obj) {
        return obj != null && C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Map<?, ?>) this.backingMap, obj);
    }

    @Override // me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    public boolean containsValue(Object obj) {
        return obj != null && super.containsValue(obj);
    }

    public Iterator<C> createColumnKeyIterator() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null);
    }

    /* renamed from: createRowMap */
    public Map<R, Map<C, V>> mo4743createRowMap() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    public V get(Object obj, Object obj2) {
        if (obj == null || obj2 == null) {
            return null;
        }
        return (V) super.get(obj, obj2);
    }

    @Override // me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    public boolean isEmpty() {
        return this.backingMap.isEmpty();
    }

    @Override // me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    public V put(R r, C c, V v) {
        if (r != null) {
            if (c == null) {
                throw null;
            }
            if (v == null) {
                throw null;
            }
            return getOrCreate(r).put(c, v);
        }
        throw null;
    }

    @Override // me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    public V remove(Object obj, Object obj2) {
        Map map;
        if (obj == null || obj2 == null || (map = (Map) C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.backingMap, obj)) == null) {
            return null;
        }
        V v = (V) map.remove(obj2);
        if (map.isEmpty()) {
            this.backingMap.remove(obj);
        }
        return v;
    }

    @Override // me.tvspark.AbstractC2128fy
    /* renamed from: row */
    public Map<C, V> mo4785row(R r) {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwww(r);
    }

    @Override // me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    /* renamed from: rowKeySet */
    public Set<R> mo4786rowKeySet() {
        return mo4787rowMap().keySet();
    }

    @Override // me.tvspark.AbstractC2128fy
    /* renamed from: rowMap */
    public Map<R, Map<C, V>> mo4787rowMap() {
        Map<R, Map<C, V>> map = this.rowMap;
        if (map == null) {
            Map<R, Map<C, V>> mo4743createRowMap = mo4743createRowMap();
            this.rowMap = mo4743createRowMap;
            return mo4743createRowMap;
        }
        return map;
    }

    @Override // me.tvspark.AbstractC2128fy
    public int size() {
        int i = 0;
        for (Map<C, V> map : this.backingMap.values()) {
            i += map.size();
        }
        return i;
    }

    @Override // me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    /* renamed from: values */
    public Collection<V> mo4642values() {
        return super.mo4642values();
    }
}
