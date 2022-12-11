package me.tvspark;

import com.umeng.analytics.pro.C1543ak;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.collections.AbstractCollection;
import org.litepal.parser.LitePalParser;

@ef0
/* loaded from: classes4.dex */
public abstract class rf0<E> extends AbstractCollection<E> implements List<E>, pi0 {

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> extends rf0<E> implements RandomAccess {
        public final int Wwwwwwwwwwwwwwwwwwwwww;
        public final rf0<E> Wwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwww;

        /* JADX WARN: Multi-variable type inference failed */
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(rf0<? extends E> rf0Var, int i, int i2) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(rf0Var, LitePalParser.NODE_LIST);
            this.Wwwwwwwwwwwwwwwwwwwwwww = rf0Var;
            this.Wwwwwwwwwwwwwwwwwwwwww = i;
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = rf0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            if (i >= 0 && i2 <= Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                if (i <= i2) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwww = i2 - this.Wwwwwwwwwwwwwwwwwwwwww;
                    return;
                }
                throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("fromIndex: ", i, " > toIndex: ", i2));
            }
            throw new IndexOutOfBoundsException("fromIndex: " + i + ", toIndex: " + i2 + ", size: " + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }

        @Override // kotlin.collections.AbstractCollection
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.rf0, java.util.List
        public E get(int i) {
            rf0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, this.Wwwwwwwwwwwwwwwwwwwwwwww);
            return this.Wwwwwwwwwwwwwwwwwwwwwww.get(this.Wwwwwwwwwwwwwwwwwwwwww + i);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends rf0<E>.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements ListIterator<E>, pi0 {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            super();
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = rf0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            if (i >= 0 && i <= Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww = i;
                return;
            }
            throw new IndexOutOfBoundsException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("index: ", i, ", size: ", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
        }

        @Override // java.util.ListIterator
        public void add(E e) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww > 0;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // java.util.ListIterator
        public E previous() {
            if (hasPrevious()) {
                rf0 rf0Var = rf0.this;
                int i = this.Wwwwwwwwwwwwwwwwwwwwwwww - 1;
                this.Wwwwwwwwwwwwwwwwwwwwwwww = i;
                return (E) rf0Var.get(i);
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww - 1;
        }

        @Override // java.util.ListIterator
        public void set(E e) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Iterator<E>, pi0 {
        public int Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww < rf0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }

        @Override // java.util.Iterator
        public E next() {
            if (hasNext()) {
                rf0 rf0Var = rf0.this;
                int i = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                this.Wwwwwwwwwwwwwwwwwwwwwwww = i + 1;
                return (E) rf0Var.get(i);
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public static final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("index: ", i, ", size: ", i2));
        }
    }

    @Override // java.util.List
    public void add(int i, E e) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        Collection collection = (Collection) obj;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, C1543ak.f2969aF);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(collection, "other");
        if (size() != collection.size()) {
            return false;
        }
        Iterator<E> it = collection.iterator();
        for (E e : this) {
            if (!ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(e, it.next())) {
                return false;
            }
        }
        return true;
    }

    public abstract E get(int i);

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, C1543ak.f2969aF);
        Iterator<E> it = iterator();
        int i = 1;
        while (it.hasNext()) {
            E next = it.next();
            i = (i * 31) + (next != null ? next.hashCode() : 0);
        }
        return i;
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        int i = 0;
        for (E e : this) {
            if (ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(e, obj)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        ListIterator<E> listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(listIterator.previous(), obj)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    @Override // java.util.List
    public ListIterator<E> listIterator() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int i) {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
    }

    @Override // java.util.List
    public E remove(int i) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public E set(int i, E e) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public List<E> subList(int i, int i2) {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, i, i2);
    }
}
