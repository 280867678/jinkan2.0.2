package me.tvspark;

import androidx.lifecycle.SavedStateHandle;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes4.dex */
public final class tf0<T> implements Collection<T>, pi0 {
    public final boolean Wwwwwwwwwwwwwwwwwwwwwww;
    public final T[] Wwwwwwwwwwwwwwwwwwwwwwww;

    public tf0(T[] tArr, boolean z) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(tArr, SavedStateHandle.VALUES);
        this.Wwwwwwwwwwwwwwwwwwwwwwww = tArr;
        this.Wwwwwwwwwwwwwwwwwwwwwww = z;
    }

    @Override // java.util.Collection
    public boolean add(T t) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        int i;
        T[] tArr = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(tArr, "$this$contains");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(tArr, "$this$indexOf");
        if (obj == null) {
            int length = tArr.length;
            i = 0;
            while (i < length) {
                if (tArr[i] == null) {
                    break;
                }
                i++;
            }
            i = -1;
        } else {
            int length2 = tArr.length;
            for (int i2 = 0; i2 < length2; i2++) {
                if (ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj, tArr[i2])) {
                    i = i2;
                    break;
                }
            }
            i = -1;
        }
        return i >= 0;
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<? extends Object> collection) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(collection, "elements");
        if (collection.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.length == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object[]) this.Wwwwwwwwwwwwwwwwwwwwwwww);
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
    public final int size() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.length;
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        Object[] objArr = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        boolean z = this.Wwwwwwwwwwwwwwwwwwwwwww;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(objArr, "$this$copyToArrayOfAny");
        if (!z || !ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(objArr.getClass(), Object[].class)) {
            objArr = Arrays.copyOf(objArr, objArr.length, Object[].class);
        }
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(objArr, "if (isVarargs && this.ja… Array<Any?>::class.java)");
        return objArr;
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) fi0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, tArr);
    }
}
