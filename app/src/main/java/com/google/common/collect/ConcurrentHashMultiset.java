package com.google.common.collect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import me.tvspark.AbstractC2090ex;
import me.tvspark.AbstractC2125fv;
import me.tvspark.AbstractC2346lu;
import me.tvspark.AbstractC2384mv;
import me.tvspark.C2275jx;
import me.tvspark.C2577rx;
import me.tvspark.C2763wu;
import me.tvspark.C2767wy;
import me.tvspark.Illllllllllllllllllllllllllll;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public final class ConcurrentHashMultiset<E> extends AbstractC2346lu<E> implements Serializable {
    public static final long serialVersionUID = 1;
    public final transient ConcurrentMap<E, AtomicInteger> countMap;

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public static final C2577rx<ConcurrentHashMultiset> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ConcurrentHashMultiset.class, "countMap");
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2125fv<AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>> {
        public final /* synthetic */ Iterator Wwwwwwwwwwwwwwwwwwwwwww;
        public AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Iterator it) {
            this.Wwwwwwwwwwwwwwwwwwwwwww = it;
        }

        @Override // me.tvspark.AbstractC2310kv
        /* renamed from: delegate */
        public Object mo4974delegate() {
            return this.Wwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // java.util.Iterator
        public Object next() {
            AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) this.Wwwwwwwwwwwwwwwwwwwwwww.next();
            this.Wwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // java.util.Iterator
        public void remove() {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww != null, "no calls to next() since the last call to remove()");
            ConcurrentHashMultiset.this.setCount(this.Wwwwwwwwwwwwwwwwwwwwwwww.getElement(), 0);
            this.Wwwwwwwwwwwwwwwwwwwwwwww = null;
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractIterator<AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>> {
        public final Iterator<Map.Entry<E, AtomicInteger>> Wwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            this.Wwwwwwwwwwwwwwwwwwwwww = ConcurrentHashMultiset.this.countMap.entrySet().iterator();
        }

        @Override // com.google.common.collect.AbstractIterator
        public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            while (this.Wwwwwwwwwwwwwwwwwwwwww.hasNext()) {
                Map.Entry<E, AtomicInteger> next = this.Wwwwwwwwwwwwwwwwwwwwww.next();
                int i = next.getValue().get();
                if (i != 0) {
                    return new Multisets$ImmutableEntry(next.getKey(), i);
                }
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2384mv<E> {
        public final /* synthetic */ Set Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ConcurrentHashMultiset concurrentHashMultiset, Set set) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = set;
        }

        @Override // me.tvspark.AbstractC2051dv, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return obj != null && C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, obj);
        }

        @Override // me.tvspark.AbstractC2051dv, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return standardContainsAll(collection);
        }

        @Override // me.tvspark.AbstractC2384mv, me.tvspark.AbstractC2051dv, me.tvspark.AbstractC2310kv
        /* renamed from: delegate */
        public Object mo4974delegate() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.AbstractC2384mv, me.tvspark.AbstractC2051dv, me.tvspark.AbstractC2310kv
        /* renamed from: delegate */
        public Set<E> mo4974delegate() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.AbstractC2051dv, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            boolean z;
            if (obj != null) {
                Set set = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                if (set != null) {
                    try {
                        z = set.remove(obj);
                    } catch (ClassCastException | NullPointerException unused) {
                        z = false;
                    }
                    return z;
                }
                throw null;
            }
            return false;
        }

        @Override // me.tvspark.AbstractC2051dv, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            return standardRemoveAll(collection);
        }

        @Override // me.tvspark.AbstractC2384mv, me.tvspark.AbstractC2051dv, me.tvspark.AbstractC2310kv
        /* renamed from: delegate  reason: collision with other method in class */
        public Collection mo4974delegate() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww;
        }
    }

    public ConcurrentHashMultiset(ConcurrentMap<E, AtomicInteger> concurrentMap) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(concurrentMap.isEmpty(), "the backing map (%s) must be empty", concurrentMap);
        this.countMap = concurrentMap;
    }

    public static <E> ConcurrentHashMultiset<E> create() {
        return new ConcurrentHashMultiset<>(new ConcurrentHashMap());
    }

    public static <E> ConcurrentHashMultiset<E> create(Iterable<? extends E> iterable) {
        ConcurrentHashMultiset<E> create = create();
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Collection) create, (Iterable) iterable);
        return create;
    }

    public static <E> ConcurrentHashMultiset<E> create(ConcurrentMap<E, AtomicInteger> concurrentMap) {
        return new ConcurrentHashMultiset<>(concurrentMap);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, (ConcurrentMap) objectInputStream.readObject());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private List<E> snapshot() {
        ArrayList Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(size());
        for (AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : mo4575entrySet()) {
            Object element = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getElement();
            for (int count = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getCount(); count > 0; count--) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.add(element);
            }
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.countMap);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0048, code lost:
        r2 = new java.util.concurrent.atomic.AtomicInteger(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0053, code lost:
        if (r4.countMap.putIfAbsent(r5, r2) == null) goto L31;
     */
    @Override // me.tvspark.AbstractC2346lu, me.tvspark.AbstractC2090ex
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int add(E e, int i) {
        AtomicInteger atomicInteger;
        AtomicInteger atomicInteger2;
        if (e != null) {
            if (i == 0) {
                return count(e);
            }
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, "occurences");
            do {
                atomicInteger = (AtomicInteger) C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.countMap, e);
                if (atomicInteger != null || (atomicInteger = this.countMap.putIfAbsent(e, new AtomicInteger(i))) != null) {
                    while (true) {
                        int i2 = atomicInteger.get();
                        if (i2 == 0) {
                            break;
                        }
                        try {
                            if (atomicInteger.compareAndSet(i2, C2767wy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, i))) {
                                return i2;
                            }
                        } catch (ArithmeticException unused) {
                            throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Overflow adding ", i, " occurrences to a count of ", i2));
                        }
                    }
                } else {
                    return 0;
                }
            } while (!this.countMap.replace(e, atomicInteger, atomicInteger2));
            return 0;
        }
        throw null;
    }

    @Override // me.tvspark.AbstractC2346lu, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.countMap.clear();
    }

    @Override // me.tvspark.AbstractC2346lu, java.util.AbstractCollection, java.util.Collection, me.tvspark.AbstractC2090ex
    public /* bridge */ /* synthetic */ boolean contains(Object obj) {
        return super.contains(obj);
    }

    @Override // me.tvspark.AbstractC2090ex
    public int count(Object obj) {
        AtomicInteger atomicInteger = (AtomicInteger) C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.countMap, obj);
        if (atomicInteger == null) {
            return 0;
        }
        return atomicInteger.get();
    }

    @Override // me.tvspark.AbstractC2346lu
    /* renamed from: createElementSet */
    public Set<E> mo4951createElementSet() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, this.countMap.keySet());
    }

    @Override // me.tvspark.AbstractC2346lu
    @Deprecated
    public Set<AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>> createEntrySet() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null);
    }

    @Override // me.tvspark.AbstractC2346lu
    public int distinctElements() {
        return this.countMap.size();
    }

    @Override // me.tvspark.AbstractC2346lu
    public Iterator<E> elementIterator() {
        throw new AssertionError("should never be called");
    }

    @Override // me.tvspark.AbstractC2346lu, me.tvspark.AbstractC2090ex
    /* renamed from: elementSet */
    public /* bridge */ /* synthetic */ Set mo4975elementSet() {
        return super.mo4975elementSet();
    }

    @Override // me.tvspark.AbstractC2346lu
    public Iterator<AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>> entryIterator() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
    }

    @Override // me.tvspark.AbstractC2346lu, me.tvspark.AbstractC2090ex
    /* renamed from: entrySet */
    public /* bridge */ /* synthetic */ Set mo4575entrySet() {
        return super.mo4575entrySet();
    }

    @Override // me.tvspark.AbstractC2346lu, java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.countMap.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, me.tvspark.AbstractC2090ex
    public Iterator<E> iterator() {
        return new C2275jx(this, mo4575entrySet().iterator());
    }

    @Override // me.tvspark.AbstractC2346lu, me.tvspark.AbstractC2090ex
    public int remove(Object obj, int i) {
        int i2;
        int max;
        if (i == 0) {
            return count(obj);
        }
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, "occurences");
        AtomicInteger atomicInteger = (AtomicInteger) C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.countMap, obj);
        if (atomicInteger == null) {
            return 0;
        }
        do {
            i2 = atomicInteger.get();
            if (i2 == 0) {
                return 0;
            }
            max = Math.max(0, i2 - i);
        } while (!atomicInteger.compareAndSet(i2, max));
        if (max == 0) {
            this.countMap.remove(obj, atomicInteger);
        }
        return i2;
    }

    public boolean removeExactly(Object obj, int i) {
        int i2;
        int i3;
        if (i == 0) {
            return true;
        }
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, "occurences");
        AtomicInteger atomicInteger = (AtomicInteger) C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.countMap, obj);
        if (atomicInteger == null) {
            return false;
        }
        do {
            i2 = atomicInteger.get();
            if (i2 < i) {
                return false;
            }
            i3 = i2 - i;
        } while (!atomicInteger.compareAndSet(i2, i3));
        if (i3 == 0) {
            this.countMap.remove(obj, atomicInteger);
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x002b, code lost:
        if (r6 != 0) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x002e, code lost:
        r2 = new java.util.concurrent.atomic.AtomicInteger(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0039, code lost:
        if (r4.countMap.putIfAbsent(r5, r2) == null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x002d, code lost:
        return 0;
     */
    @Override // me.tvspark.AbstractC2346lu, me.tvspark.AbstractC2090ex
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int setCount(E e, int i) {
        AtomicInteger atomicInteger;
        AtomicInteger atomicInteger2;
        if (e != null) {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, "count");
            do {
                atomicInteger = (AtomicInteger) C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.countMap, e);
                if (atomicInteger == null && (i == 0 || (atomicInteger = this.countMap.putIfAbsent(e, new AtomicInteger(i))) == null)) {
                    return 0;
                }
                while (true) {
                    int i2 = atomicInteger.get();
                    if (i2 == 0) {
                        break;
                    } else if (atomicInteger.compareAndSet(i2, i)) {
                        if (i == 0) {
                            this.countMap.remove(e, atomicInteger);
                        }
                        return i2;
                    }
                }
            } while (!this.countMap.replace(e, atomicInteger, atomicInteger2));
            return 0;
        }
        throw null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, me.tvspark.AbstractC2090ex
    public int size() {
        long j = 0;
        for (AtomicInteger atomicInteger : this.countMap.values()) {
            j += atomicInteger.get();
        }
        return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        return snapshot().toArray();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) snapshot().toArray(tArr);
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2346lu<E>.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            super();
        }

        @Override // me.tvspark.AbstractC2346lu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, me.tvspark.AbstractC2238ix
        public AbstractC2090ex Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return ConcurrentHashMultiset.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            ArrayList Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(size());
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Collection) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, (Iterator) iterator());
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            ArrayList Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(size());
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Collection) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, (Iterator) iterator());
            return (T[]) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toArray(tArr);
        }
    }

    @Override // me.tvspark.AbstractC2346lu, me.tvspark.AbstractC2090ex
    public boolean setCount(E e, int i, int i2) {
        if (e != null) {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, "oldCount");
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, "newCount");
            AtomicInteger atomicInteger = (AtomicInteger) C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.countMap, e);
            if (atomicInteger == null) {
                if (i != 0) {
                    return false;
                }
                return i2 == 0 || this.countMap.putIfAbsent(e, new AtomicInteger(i2)) == null;
            }
            int i3 = atomicInteger.get();
            if (i3 == i) {
                if (i3 == 0) {
                    if (i2 == 0) {
                        this.countMap.remove(e, atomicInteger);
                        return true;
                    }
                    AtomicInteger atomicInteger2 = new AtomicInteger(i2);
                    return this.countMap.putIfAbsent(e, atomicInteger2) == null || this.countMap.replace(e, atomicInteger, atomicInteger2);
                } else if (atomicInteger.compareAndSet(i3, i2)) {
                    if (i2 == 0) {
                        this.countMap.remove(e, atomicInteger);
                    }
                    return true;
                }
            }
            return false;
        }
        throw null;
    }
}
