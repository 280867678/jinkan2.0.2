package org.eclipse.jetty.util;

import java.util.AbstractList;
import java.util.NoSuchElementException;
import java.util.Queue;

/* loaded from: classes5.dex */
public class ArrayQueue<E> extends AbstractList<E> implements Queue<E> {
    public static final int DEFAULT_CAPACITY = 64;
    public static final int DEFAULT_GROWTH = 32;
    public Object[] _elements;
    public final int _growCapacity;
    public final Object _lock;
    public int _nextE;
    public int _nextSlot;
    public int _size;

    public ArrayQueue() {
        this(64, -1);
    }

    public ArrayQueue(int i) {
        this(i, -1);
    }

    public ArrayQueue(int i, int i2) {
        this(i, i2, null);
    }

    public ArrayQueue(int i, int i2, Object obj) {
        this._lock = obj == null ? this : obj;
        this._growCapacity = i2;
        this._elements = new Object[i];
    }

    /* renamed from: at */
    private E m37at(int i) {
        return (E) this._elements[i];
    }

    private E dequeue() {
        E m37at = m37at(this._nextE);
        Object[] objArr = this._elements;
        int i = this._nextE;
        objArr[i] = null;
        this._size--;
        int i2 = i + 1;
        this._nextE = i2;
        if (i2 == objArr.length) {
            this._nextE = 0;
        }
        return m37at;
    }

    private boolean enqueue(E e) {
        if (this._size != this._elements.length || grow()) {
            this._size++;
            Object[] objArr = this._elements;
            int i = this._nextSlot;
            int i2 = i + 1;
            this._nextSlot = i2;
            objArr[i] = e;
            if (i2 == objArr.length) {
                this._nextSlot = 0;
            }
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, E e) {
        synchronized (this._lock) {
            if (i >= 0) {
                if (i <= this._size) {
                    if (this._size == this._elements.length && !grow()) {
                        throw new IllegalStateException("Full");
                    }
                    if (i == this._size) {
                        add(e);
                    } else {
                        int i2 = this._nextE + i;
                        if (i2 >= this._elements.length) {
                            i2 -= this._elements.length;
                        }
                        this._size++;
                        int i3 = this._nextSlot + 1;
                        this._nextSlot = i3;
                        if (i3 == this._elements.length) {
                            this._nextSlot = 0;
                        }
                        if (i2 < this._nextSlot) {
                            System.arraycopy(this._elements, i2, this._elements, i2 + 1, this._nextSlot - i2);
                            this._elements[i2] = e;
                        } else {
                            if (this._nextSlot > 0) {
                                System.arraycopy(this._elements, 0, this._elements, 1, this._nextSlot);
                                this._elements[0] = this._elements[this._elements.length - 1];
                            }
                            System.arraycopy(this._elements, i2, this._elements, i2 + 1, (this._elements.length - i2) - 1);
                            this._elements[i2] = e;
                        }
                    }
                }
            }
            throw new IndexOutOfBoundsException("!(0<" + i + "<=" + this._size + ")");
        }
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Queue
    public boolean add(E e) {
        if (offer(e)) {
            return true;
        }
        throw new IllegalStateException("Full");
    }

    public void addUnsafe(E e) {
        if (enqueue(e)) {
            return;
        }
        throw new IllegalStateException("Full");
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        synchronized (this._lock) {
            this._size = 0;
            this._nextE = 0;
            this._nextSlot = 0;
        }
    }

    @Override // java.util.Queue
    public E element() {
        E m37at;
        synchronized (this._lock) {
            if (isEmpty()) {
                throw new NoSuchElementException();
            }
            m37at = m37at(this._nextE);
        }
        return m37at;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i) {
        E unsafe;
        synchronized (this._lock) {
            if (i >= 0) {
                if (i < this._size) {
                    unsafe = getUnsafe(i);
                }
            }
            throw new IndexOutOfBoundsException("!(0<" + i + "<=" + this._size + ")");
        }
        return unsafe;
    }

    public int getCapacity() {
        int length;
        synchronized (this._lock) {
            length = this._elements.length;
        }
        return length;
    }

    public E getUnsafe(int i) {
        return m37at((this._nextE + i) % this._elements.length);
    }

    public boolean grow() {
        synchronized (this._lock) {
            if (this._growCapacity <= 0) {
                return false;
            }
            Object[] objArr = new Object[this._elements.length + this._growCapacity];
            int length = this._elements.length - this._nextE;
            if (length > 0) {
                System.arraycopy(this._elements, this._nextE, objArr, 0, length);
            }
            if (this._nextE != 0) {
                System.arraycopy(this._elements, 0, objArr, length, this._nextSlot);
            }
            this._elements = objArr;
            this._nextE = 0;
            this._nextSlot = this._size;
            return true;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        boolean z;
        synchronized (this._lock) {
            z = this._size == 0;
        }
        return z;
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        boolean enqueue;
        synchronized (this._lock) {
            enqueue = enqueue(e);
        }
        return enqueue;
    }

    @Override // java.util.Queue
    public E peek() {
        synchronized (this._lock) {
            if (isEmpty()) {
                return null;
            }
            return m37at(this._nextE);
        }
    }

    @Override // java.util.Queue
    public E poll() {
        synchronized (this._lock) {
            if (this._size == 0) {
                return null;
            }
            return dequeue();
        }
    }

    @Override // java.util.Queue
    public E remove() {
        E dequeue;
        synchronized (this._lock) {
            if (this._size == 0) {
                throw new NoSuchElementException();
            }
            dequeue = dequeue();
        }
        return dequeue;
    }

    @Override // java.util.AbstractList, java.util.List
    public E remove(int i) {
        E m37at;
        int length;
        int i2;
        synchronized (this._lock) {
            if (i >= 0) {
                if (i < this._size) {
                    int length2 = (this._nextE + i) % this._elements.length;
                    m37at = m37at(length2);
                    if (length2 < this._nextSlot) {
                        System.arraycopy(this._elements, length2 + 1, this._elements, length2, this._nextSlot - length2);
                        this._nextSlot--;
                        i2 = this._size;
                    } else {
                        System.arraycopy(this._elements, length2 + 1, this._elements, length2, (this._elements.length - length2) - 1);
                        if (this._nextSlot > 0) {
                            this._elements[this._elements.length - 1] = this._elements[0];
                            System.arraycopy(this._elements, 1, this._elements, 0, this._nextSlot - 1);
                            length = this._nextSlot;
                        } else {
                            length = this._elements.length;
                        }
                        this._nextSlot = length - 1;
                        i2 = this._size;
                    }
                    this._size = i2 - 1;
                }
            }
            throw new IndexOutOfBoundsException("!(0<" + i + "<=" + this._size + ")");
        }
        return m37at;
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int i, E e) {
        E m37at;
        synchronized (this._lock) {
            if (i >= 0) {
                if (i < this._size) {
                    int i2 = this._nextE + i;
                    if (i2 >= this._elements.length) {
                        i2 -= this._elements.length;
                    }
                    m37at = m37at(i2);
                    this._elements[i2] = e;
                }
            }
            throw new IndexOutOfBoundsException("!(0<" + i + "<=" + this._size + ")");
        }
        return m37at;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        int i;
        synchronized (this._lock) {
            i = this._size;
        }
        return i;
    }
}
