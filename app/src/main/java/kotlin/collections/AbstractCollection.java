package kotlin.collections;

import java.util.Collection;
import me.tvspark.ef0;
import me.tvspark.fi0;
import me.tvspark.ii0;
import me.tvspark.pi0;
import me.tvspark.r40;

@ef0
/* loaded from: classes4.dex */
public abstract class AbstractCollection<E> implements Collection<E>, pi0 {
    public abstract int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    @Override // java.util.Collection
    public boolean add(E e) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        if (isEmpty()) {
            return false;
        }
        for (E e : this) {
            if (ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(e, obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<? extends Object> collection) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(collection, "elements");
        if (collection.isEmpty()) {
            return true;
        }
        for (Object obj : collection) {
            if (!contains(obj)) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == 0;
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return fi0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(tArr, "array");
        T[] tArr2 = (T[]) fi0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, tArr);
        if (tArr2 != null) {
            return tArr2;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public String toString() {
        return r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, ", ", "[", "]", 0, (CharSequence) null, new AbstractCollection$toString$1(this), 24);
    }
}
