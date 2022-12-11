package me.tvspark;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import me.tvspark.AbstractC2090ex;

/* renamed from: me.tvspark.jv */
/* loaded from: classes4.dex */
public abstract class AbstractC2273jv<E> extends AbstractC2051dv<E> implements AbstractC2090ex<E> {
    public int add(E e, int i) {
        return mo4974delegate().add(e, i);
    }

    @Override // me.tvspark.AbstractC2090ex
    public int count(Object obj) {
        return mo4974delegate().count(obj);
    }

    @Override // me.tvspark.AbstractC2051dv, me.tvspark.AbstractC2310kv
    /* renamed from: delegate */
    public abstract /* bridge */ /* synthetic */ Object mo4974delegate();

    @Override // me.tvspark.AbstractC2051dv, me.tvspark.AbstractC2310kv
    /* renamed from: delegate  reason: collision with other method in class */
    public abstract /* bridge */ /* synthetic */ Collection mo4974delegate();

    @Override // me.tvspark.AbstractC2051dv, me.tvspark.AbstractC2310kv
    /* renamed from: delegate */
    public abstract AbstractC2090ex<E> mo4974delegate();

    /* renamed from: elementSet */
    public abstract Set<E> mo4975elementSet();

    /* renamed from: entrySet */
    public abstract Set<AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>> mo4575entrySet();

    @Override // java.util.Collection, me.tvspark.AbstractC2090ex
    public boolean equals(Object obj) {
        return obj == this || mo4974delegate().equals(obj);
    }

    @Override // java.util.Collection, me.tvspark.AbstractC2090ex
    public int hashCode() {
        return mo4974delegate().hashCode();
    }

    public int remove(Object obj, int i) {
        return mo4974delegate().remove(obj, i);
    }

    public int setCount(E e, int i) {
        return mo4974delegate().setCount(e, i);
    }

    public boolean setCount(E e, int i, int i2) {
        return mo4974delegate().setCount(e, i, i2);
    }

    public boolean standardAdd(E e) {
        add(e, 1);
        return true;
    }

    @Override // me.tvspark.AbstractC2051dv
    public boolean standardAddAll(Collection<? extends E> collection) {
        return C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2090ex) this, (Collection) collection);
    }

    @Override // me.tvspark.AbstractC2051dv
    public void standardClear() {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Iterator<?>) mo4575entrySet().iterator());
    }

    @Override // me.tvspark.AbstractC2051dv
    public boolean standardContains(Object obj) {
        return count(obj) > 0;
    }

    public int standardCount(Object obj) {
        for (AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : mo4575entrySet()) {
            if (Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getElement(), obj)) {
                return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getCount();
            }
        }
        return 0;
    }

    public boolean standardEquals(Object obj) {
        return C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2090ex<?>) this, obj);
    }

    public int standardHashCode() {
        return mo4575entrySet().hashCode();
    }

    public Iterator<E> standardIterator() {
        return new C2275jx(this, mo4575entrySet().iterator());
    }

    @Override // me.tvspark.AbstractC2051dv
    public boolean standardRemove(Object obj) {
        return remove(obj, 1) > 0;
    }

    @Override // me.tvspark.AbstractC2051dv
    public boolean standardRemoveAll(Collection<?> collection) {
        if (collection instanceof AbstractC2090ex) {
            collection = ((AbstractC2090ex) collection).mo4975elementSet();
        }
        return mo4975elementSet().removeAll(collection);
    }

    @Override // me.tvspark.AbstractC2051dv
    public boolean standardRetainAll(Collection<?> collection) {
        return C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, collection);
    }

    public int standardSetCount(E e, int i) {
        return C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, e, i);
    }

    public boolean standardSetCount(E e, int i, int i2) {
        return C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, e, i, i2);
    }

    public int standardSize() {
        long j = 0;
        for (AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : mo4575entrySet()) {
            j += wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getCount();
        }
        return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j);
    }

    @Override // me.tvspark.AbstractC2051dv
    public String standardToString() {
        return mo4575entrySet().toString();
    }
}
