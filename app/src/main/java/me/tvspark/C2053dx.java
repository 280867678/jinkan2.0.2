package me.tvspark;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import me.tvspark.AbstractC2090ex;

/* renamed from: me.tvspark.dx */
/* loaded from: classes4.dex */
public class C2053dx<K, V> extends AbstractC2346lu<K> {
    public final AbstractC2876zw<K, V> Wwwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: me.tvspark.dx$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2165gy<Map.Entry<K, Collection<V>>, AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K>> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2053dx c2053dx, Iterator it) {
            super(it);
        }

        @Override // me.tvspark.AbstractC2165gy
        public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
            return new C1999cx(this, (Map.Entry) obj);
        }
    }

    public C2053dx(AbstractC2876zw<K, V> abstractC2876zw) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = abstractC2876zw;
    }

    @Override // me.tvspark.AbstractC2346lu, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.clear();
    }

    @Override // me.tvspark.AbstractC2346lu, java.util.AbstractCollection, java.util.Collection, me.tvspark.AbstractC2090ex
    public boolean contains(Object obj) {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.containsKey(obj);
    }

    @Override // me.tvspark.AbstractC2090ex
    public int count(Object obj) {
        Collection collection = (Collection) C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww.mo4790asMap(), obj);
        if (collection == null) {
            return 0;
        }
        return collection.size();
    }

    @Override // me.tvspark.AbstractC2346lu
    public int distinctElements() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.mo4790asMap().size();
    }

    @Override // me.tvspark.AbstractC2346lu
    public Iterator<K> elementIterator() {
        throw new AssertionError("should never be called");
    }

    @Override // me.tvspark.AbstractC2346lu, me.tvspark.AbstractC2090ex
    /* renamed from: elementSet */
    public Set<K> mo4975elementSet() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.mo4794keySet();
    }

    @Override // me.tvspark.AbstractC2346lu
    public Iterator<AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K>> entryIterator() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, this.Wwwwwwwwwwwwwwwwwwwwwwww.mo4790asMap().entrySet().iterator());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, me.tvspark.AbstractC2090ex
    public Iterator<K> iterator() {
        return new C2126fw(this.Wwwwwwwwwwwwwwwwwwwwwwww.mo4768entries().iterator());
    }

    @Override // me.tvspark.AbstractC2346lu, me.tvspark.AbstractC2090ex
    public int remove(Object obj, int i) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, "occurrences");
        if (i == 0) {
            return count(obj);
        }
        Collection collection = (Collection) C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww.mo4790asMap(), obj);
        if (collection == null) {
            return 0;
        }
        int size = collection.size();
        if (i >= size) {
            collection.clear();
        } else {
            Iterator it = collection.iterator();
            for (int i2 = 0; i2 < i; i2++) {
                it.next();
                it.remove();
            }
        }
        return size;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, me.tvspark.AbstractC2090ex
    public int size() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.size();
    }
}
