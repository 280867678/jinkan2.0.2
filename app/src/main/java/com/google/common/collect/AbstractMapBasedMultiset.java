package com.google.common.collect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import me.tvspark.AbstractC2090ex;
import me.tvspark.AbstractC2346lu;
import me.tvspark.C2275jx;
import me.tvspark.C2312kx;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public abstract class AbstractMapBasedMultiset<E> extends AbstractC2346lu<E> implements Serializable {
    public static final long serialVersionUID = 0;
    public transient C2312kx<E> backingMap;
    public transient long size;

    /* loaded from: classes3.dex */
    public abstract class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> implements Iterator<T> {
        public int Wwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwww = -1;
        public int Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = AbstractMapBasedMultiset.this.backingMap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            this.Wwwwwwwwwwwwwwwwwwwwww = AbstractMapBasedMultiset.this.backingMap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        public abstract T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i);

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (AbstractMapBasedMultiset.this.backingMap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == this.Wwwwwwwwwwwwwwwwwwwwww) {
                return this.Wwwwwwwwwwwwwwwwwwwwwwww >= 0;
            }
            throw new ConcurrentModificationException();
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww);
                int i = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                this.Wwwwwwwwwwwwwwwwwwwwwww = i;
                this.Wwwwwwwwwwwwwwwwwwwwwwww = AbstractMapBasedMultiset.this.backingMap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            AbstractMapBasedMultiset abstractMapBasedMultiset;
            if (AbstractMapBasedMultiset.this.backingMap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == this.Wwwwwwwwwwwwwwwwwwwwww) {
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww != -1, "no calls to next() since the last call to remove()");
                AbstractMapBasedMultiset.this.size -= abstractMapBasedMultiset.backingMap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww);
                this.Wwwwwwwwwwwwwwwwwwwwwwww = AbstractMapBasedMultiset.this.backingMap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwww);
                this.Wwwwwwwwwwwwwwwwwwwwwww = -1;
                this.Wwwwwwwwwwwwwwwwwwwwww = AbstractMapBasedMultiset.this.backingMap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                return;
            }
            throw new ConcurrentModificationException();
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractMapBasedMultiset<E>.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            super();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultiset.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            C2312kx<E> c2312kx = AbstractMapBasedMultiset.this.backingMap;
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, c2312kx.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            return new C2312kx.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractMapBasedMultiset<E>.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            super();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultiset.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public E Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            C2312kx<E> c2312kx = AbstractMapBasedMultiset.this.backingMap;
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, c2312kx.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            return (E) c2312kx.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i];
        }
    }

    public AbstractMapBasedMultiset(int i) {
        init(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        init(3);
        for (int i = 0; i < readInt; i++) {
            add(objectInputStream.readObject(), objectInputStream.readInt());
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2090ex) this, objectOutputStream);
    }

    @Override // me.tvspark.AbstractC2346lu, me.tvspark.AbstractC2090ex
    public final int add(E e, int i) {
        if (i == 0) {
            return count(e);
        }
        boolean z = true;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i > 0, "occurrences cannot be negative: %s", i);
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.backingMap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(e);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == -1) {
            this.backingMap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((C2312kx<E>) e, i);
            this.size += i;
            return 0;
        }
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.backingMap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        long j = i;
        long j2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 + j;
        if (j2 > 2147483647L) {
            z = false;
        }
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z, "too many occurrences: %s", j2);
        this.backingMap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, (int) j2);
        this.size += j;
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
    }

    public void addTo(AbstractC2090ex<? super E> abstractC2090ex) {
        if (abstractC2090ex != null) {
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.backingMap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            while (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 >= 0) {
                abstractC2090ex.add((E) this.backingMap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2), this.backingMap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2));
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.backingMap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            }
            return;
        }
        throw null;
    }

    @Override // me.tvspark.AbstractC2346lu, java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.backingMap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.size = 0L;
    }

    @Override // me.tvspark.AbstractC2090ex
    public final int count(Object obj) {
        return this.backingMap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj);
    }

    @Override // me.tvspark.AbstractC2346lu
    public final int distinctElements() {
        return this.backingMap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.AbstractC2346lu
    public final Iterator<E> elementIterator() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.AbstractC2346lu
    public final Iterator<AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>> entryIterator() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public abstract void init(int i);

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, me.tvspark.AbstractC2090ex
    public final Iterator<E> iterator() {
        return new C2275jx(this, mo4575entrySet().iterator());
    }

    @Override // me.tvspark.AbstractC2346lu, me.tvspark.AbstractC2090ex
    public final int remove(Object obj, int i) {
        if (i == 0) {
            return count(obj);
        }
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i > 0, "occurrences cannot be negative: %s", i);
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.backingMap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == -1) {
            return 0;
        }
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.backingMap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 > i) {
            this.backingMap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 - i);
        } else {
            this.backingMap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            i = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        }
        this.size -= i;
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
    }

    @Override // me.tvspark.AbstractC2346lu, me.tvspark.AbstractC2090ex
    public final int setCount(E e, int i) {
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, "count");
        C2312kx<E> c2312kx = this.backingMap;
        if (i != 0) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2312kx.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((C2312kx<E>) e, i);
        } else if (c2312kx == null) {
            throw null;
        } else {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2312kx.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(e, Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(e));
        }
        this.size += i - Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
    }

    @Override // me.tvspark.AbstractC2346lu, me.tvspark.AbstractC2090ex
    public final boolean setCount(E e, int i, int i2) {
        long j;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, "oldCount");
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, "newCount");
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.backingMap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(e);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == -1) {
            if (i != 0) {
                return false;
            }
            if (i2 > 0) {
                this.backingMap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((C2312kx<E>) e, i2);
                this.size += i2;
            }
            return true;
        } else if (this.backingMap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) != i) {
            return false;
        } else {
            C2312kx<E> c2312kx = this.backingMap;
            if (i2 == 0) {
                c2312kx.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                j = this.size - i;
            } else {
                c2312kx.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, i2);
                j = this.size + (i2 - i);
            }
            this.size = j;
            return true;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, me.tvspark.AbstractC2090ex
    public final int size() {
        return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.size);
    }
}
