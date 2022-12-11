package org.seamless.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes5.dex */
public class Iterators {

    /* loaded from: classes5.dex */
    public static class Empty<E> implements Iterator<E> {
        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public E next() {
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: classes5.dex */
    public static class Singular<E> implements Iterator<E> {
        public int current;
        public final E element;

        public Singular(E e) {
            this.element = e;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.current == 0;
        }

        @Override // java.util.Iterator
        public E next() {
            this.current++;
            return this.element;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: classes5.dex */
    public static abstract class Synchronized<E> implements Iterator<E> {
        public int nextIndex = 0;
        public boolean removedCurrent = false;
        public final Iterator<E> wrapped;

        public Synchronized(Collection<E> collection) {
            this.wrapped = new CopyOnWriteArrayList(collection).iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.wrapped.hasNext();
        }

        @Override // java.util.Iterator
        public E next() {
            this.removedCurrent = false;
            this.nextIndex++;
            return this.wrapped.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            int i = this.nextIndex;
            if (i != 0) {
                if (this.removedCurrent) {
                    throw new IllegalStateException("Already removed current, call next()");
                }
                synchronizedRemove(i - 1);
                this.removedCurrent = true;
                return;
            }
            throw new IllegalStateException("Call next() first");
        }

        public abstract void synchronizedRemove(int i);
    }
}
