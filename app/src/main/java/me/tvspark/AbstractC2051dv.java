package me.tvspark;

import java.util.Collection;
import java.util.Iterator;

/* renamed from: me.tvspark.dv */
/* loaded from: classes4.dex */
public abstract class AbstractC2051dv<E> extends AbstractC2310kv implements Collection<E> {
    public boolean add(E e) {
        return mo4974delegate().add(e);
    }

    public boolean addAll(Collection<? extends E> collection) {
        return mo4974delegate().addAll(collection);
    }

    public void clear() {
        mo4974delegate().clear();
    }

    public boolean contains(Object obj) {
        return mo4974delegate().contains(obj);
    }

    public boolean containsAll(Collection<?> collection) {
        return mo4974delegate().containsAll(collection);
    }

    @Override // me.tvspark.AbstractC2310kv
    /* renamed from: delegate */
    public abstract /* bridge */ /* synthetic */ Object mo4974delegate();

    @Override // me.tvspark.AbstractC2310kv
    /* renamed from: delegate  reason: collision with other method in class */
    public abstract Collection<E> mo4974delegate();

    @Override // java.util.Collection
    public boolean isEmpty() {
        return mo4974delegate().isEmpty();
    }

    public Iterator<E> iterator() {
        return mo4974delegate().iterator();
    }

    public boolean remove(Object obj) {
        return mo4974delegate().remove(obj);
    }

    public boolean removeAll(Collection<?> collection) {
        return mo4974delegate().removeAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        return mo4974delegate().retainAll(collection);
    }

    @Override // java.util.Collection
    public int size() {
        return mo4974delegate().size();
    }

    public boolean standardAddAll(Collection<? extends E> collection) {
        return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Collection) this, (Iterator) collection.iterator());
    }

    public void standardClear() {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Iterator<?>) iterator());
    }

    public boolean standardContains(Object obj) {
        return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Iterator<?>) iterator(), obj);
    }

    public boolean standardContainsAll(Collection<?> collection) {
        return C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Collection<?>) this, collection);
    }

    public boolean standardIsEmpty() {
        return !iterator().hasNext();
    }

    public boolean standardRemove(Object obj) {
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            if (Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(it.next(), obj)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    public boolean standardRemoveAll(Collection<?> collection) {
        return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Iterator<?>) iterator(), collection);
    }

    public boolean standardRetainAll(Collection<?> collection) {
        return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Iterator<?>) iterator(), collection);
    }

    public Object[] standardToArray() {
        return toArray(new Object[size()]);
    }

    public <T> T[] standardToArray(T[] tArr) {
        return (T[]) Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Collection<?>) this, (Object[]) tArr);
    }

    public String standardToString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(size());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append('[');
        boolean z = true;
        for (E e : this) {
            if (!z) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", ");
            }
            z = false;
            if (e == this) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("(this Collection)");
            } else {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(e);
            }
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(']');
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    public Object[] toArray() {
        return mo4974delegate().toArray();
    }

    public <T> T[] toArray(T[] tArr) {
        return (T[]) mo4974delegate().toArray(tArr);
    }
}
