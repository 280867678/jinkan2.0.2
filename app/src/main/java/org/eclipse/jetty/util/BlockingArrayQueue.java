package org.eclipse.jetty.util;

import java.util.AbstractList;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes5.dex */
public class BlockingArrayQueue<E> extends AbstractList<E> implements BlockingQueue<E> {
    public final int DEFAULT_CAPACITY;
    public final int DEFAULT_GROWTH;
    public volatile int _capacity;
    public Object[] _elements;
    public final int _growCapacity;
    public int _head;
    public final ReentrantLock _headLock;
    public final int _limit;
    public final Condition _notEmpty;
    public final AtomicInteger _size;
    public long _space0;
    public long _space1;
    public long _space2;
    public long _space3;
    public long _space4;
    public long _space5;
    public long _space6;
    public long _space7;
    public int _tail;
    public final ReentrantLock _tailLock;

    public BlockingArrayQueue() {
        this.DEFAULT_CAPACITY = 128;
        this.DEFAULT_GROWTH = 64;
        this._size = new AtomicInteger();
        ReentrantLock reentrantLock = new ReentrantLock();
        this._headLock = reentrantLock;
        this._notEmpty = reentrantLock.newCondition();
        this._tailLock = new ReentrantLock();
        Object[] objArr = new Object[128];
        this._elements = objArr;
        this._growCapacity = 64;
        this._capacity = objArr.length;
        this._limit = Integer.MAX_VALUE;
    }

    public BlockingArrayQueue(int i) {
        this.DEFAULT_CAPACITY = 128;
        this.DEFAULT_GROWTH = 64;
        this._size = new AtomicInteger();
        ReentrantLock reentrantLock = new ReentrantLock();
        this._headLock = reentrantLock;
        this._notEmpty = reentrantLock.newCondition();
        this._tailLock = new ReentrantLock();
        Object[] objArr = new Object[i];
        this._elements = objArr;
        this._capacity = objArr.length;
        this._growCapacity = -1;
        this._limit = i;
    }

    public BlockingArrayQueue(int i, int i2) {
        this.DEFAULT_CAPACITY = 128;
        this.DEFAULT_GROWTH = 64;
        this._size = new AtomicInteger();
        ReentrantLock reentrantLock = new ReentrantLock();
        this._headLock = reentrantLock;
        this._notEmpty = reentrantLock.newCondition();
        this._tailLock = new ReentrantLock();
        Object[] objArr = new Object[i];
        this._elements = objArr;
        this._capacity = objArr.length;
        this._growCapacity = i2;
        this._limit = Integer.MAX_VALUE;
    }

    public BlockingArrayQueue(int i, int i2, int i3) {
        this.DEFAULT_CAPACITY = 128;
        this.DEFAULT_GROWTH = 64;
        this._size = new AtomicInteger();
        ReentrantLock reentrantLock = new ReentrantLock();
        this._headLock = reentrantLock;
        this._notEmpty = reentrantLock.newCondition();
        this._tailLock = new ReentrantLock();
        if (i <= i3) {
            Object[] objArr = new Object[i];
            this._elements = objArr;
            this._capacity = objArr.length;
            this._growCapacity = i2;
            this._limit = i3;
            return;
        }
        throw new IllegalArgumentException();
    }

    private boolean grow() {
        int i;
        if (this._growCapacity <= 0) {
            return false;
        }
        this._tailLock.lock();
        try {
            this._headLock.lock();
            int i2 = this._head;
            int i3 = this._tail;
            Object[] objArr = new Object[this._capacity + this._growCapacity];
            if (i2 < i3) {
                i = i3 - i2;
                System.arraycopy(this._elements, i2, objArr, 0, i);
            } else {
                if (i2 <= i3 && this._size.get() <= 0) {
                    i = 0;
                }
                int i4 = (this._capacity + i3) - i2;
                int i5 = this._capacity - i2;
                System.arraycopy(this._elements, i2, objArr, 0, i5);
                System.arraycopy(this._elements, 0, objArr, i5, i3);
                i = i4;
            }
            this._elements = objArr;
            this._capacity = objArr.length;
            this._head = 0;
            this._tail = i;
            this._headLock.unlock();
            return true;
        } finally {
            this._tailLock.unlock();
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, E e) {
        if (e != null) {
            this._tailLock.lock();
            try {
                this._headLock.lock();
                if (i < 0 || i > this._size.get()) {
                    throw new IndexOutOfBoundsException("!(0<" + i + "<=" + this._size + ")");
                }
                if (i == this._size.get()) {
                    add(e);
                } else {
                    if (this._tail == this._head && !grow()) {
                        throw new IllegalStateException("full");
                    }
                    int i2 = this._head + i;
                    if (i2 >= this._capacity) {
                        i2 -= this._capacity;
                    }
                    this._size.incrementAndGet();
                    int i3 = (this._tail + 1) % this._capacity;
                    this._tail = i3;
                    if (i2 < i3) {
                        System.arraycopy(this._elements, i2, this._elements, i2 + 1, i3 - i2);
                        this._elements[i2] = e;
                    } else {
                        if (i3 > 0) {
                            System.arraycopy(this._elements, 0, this._elements, 1, i3);
                            this._elements[0] = this._elements[this._capacity - 1];
                        }
                        System.arraycopy(this._elements, i2, this._elements, i2 + 1, (this._capacity - i2) - 1);
                        this._elements[i2] = e;
                    }
                }
                this._headLock.unlock();
                return;
            } finally {
                this._tailLock.unlock();
            }
        }
        throw null;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.concurrent.BlockingQueue, java.util.Queue
    public boolean add(E e) {
        return offer(e);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this._tailLock.lock();
        try {
            this._headLock.lock();
            this._head = 0;
            this._tail = 0;
            this._size.set(0);
            this._headLock.unlock();
        } finally {
            this._tailLock.unlock();
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Queue
    public E element() {
        E peek = peek();
        if (peek != null) {
            return peek;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i) {
        this._tailLock.lock();
        try {
            this._headLock.lock();
            if (i >= 0 && i < this._size.get()) {
                int i2 = this._head + i;
                if (i2 >= this._capacity) {
                    i2 -= this._capacity;
                }
                E e = (E) this._elements[i2];
                this._headLock.unlock();
                return e;
            }
            throw new IndexOutOfBoundsException("!(0<" + i + "<=" + this._size + ")");
        } finally {
            this._tailLock.unlock();
        }
    }

    public int getCapacity() {
        return this._capacity;
    }

    public int getLimit() {
        return this._limit;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return this._size.get() == 0;
    }

    @Override // java.util.concurrent.BlockingQueue, java.util.Queue
    public boolean offer(E e) {
        if (e != null) {
            this._tailLock.lock();
            try {
                boolean z = false;
                if (this._size.get() < this._limit) {
                    if (this._size.get() == this._capacity) {
                        this._headLock.lock();
                        if (!grow()) {
                            this._headLock.unlock();
                        } else {
                            this._headLock.unlock();
                        }
                    }
                    this._elements[this._tail] = e;
                    this._tail = (this._tail + 1) % this._capacity;
                    if (this._size.getAndIncrement() == 0) {
                        z = true;
                    }
                    if (z) {
                        this._headLock.lock();
                        try {
                            this._notEmpty.signal();
                        } finally {
                            this._headLock.unlock();
                        }
                    }
                    return true;
                }
                return false;
            } finally {
                this._tailLock.unlock();
            }
        }
        throw null;
    }

    @Override // java.util.concurrent.BlockingQueue
    public boolean offer(E e, long j, TimeUnit timeUnit) throws InterruptedException {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Queue
    public E peek() {
        E e = null;
        if (this._size.get() == 0) {
            return null;
        }
        this._headLock.lock();
        try {
            if (this._size.get() > 0) {
                e = (E) this._elements[this._head];
            }
            return e;
        } finally {
            this._headLock.unlock();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r2v1 */
    @Override // java.util.Queue
    public E poll() {
        E e = null;
        if (this._size.get() == 0) {
            return null;
        }
        this._headLock.lock();
        try {
            if (this._size.get() > 0) {
                int i = this._head;
                ?? r2 = this._elements[i];
                this._elements[i] = null;
                this._head = (i + 1) % this._capacity;
                if (this._size.decrementAndGet() > 0) {
                    this._notEmpty.signal();
                }
                e = r2;
            }
            return e;
        } finally {
            this._headLock.unlock();
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public E poll(long j, TimeUnit timeUnit) throws InterruptedException {
        long nanos = timeUnit.toNanos(j);
        this._headLock.lockInterruptibly();
        while (this._size.get() == 0) {
            try {
                try {
                    if (nanos <= 0) {
                        return null;
                    }
                    nanos = this._notEmpty.awaitNanos(nanos);
                } catch (InterruptedException e) {
                    this._notEmpty.signal();
                    throw e;
                }
            } finally {
                this._headLock.unlock();
            }
        }
        E e2 = (E) this._elements[this._head];
        this._elements[this._head] = null;
        this._head = (this._head + 1) % this._capacity;
        if (this._size.decrementAndGet() > 0) {
            this._notEmpty.signal();
        }
        return e2;
    }

    @Override // java.util.concurrent.BlockingQueue
    public void put(E e) throws InterruptedException {
        if (add(e)) {
            return;
        }
        throw new IllegalStateException("full");
    }

    @Override // java.util.concurrent.BlockingQueue
    public int remainingCapacity() {
        this._tailLock.lock();
        try {
            this._headLock.lock();
            int capacity = getCapacity() - size();
            this._headLock.unlock();
            return capacity;
        } finally {
            this._tailLock.unlock();
        }
    }

    @Override // java.util.Queue
    public E remove() {
        E poll = poll();
        if (poll != null) {
            return poll;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.AbstractList, java.util.List
    public E remove(int i) {
        int i2;
        AtomicInteger atomicInteger;
        this._tailLock.lock();
        try {
            this._headLock.lock();
            if (i < 0 || i >= this._size.get()) {
                throw new IndexOutOfBoundsException("!(0<" + i + "<=" + this._size + ")");
            }
            int i3 = this._head + i;
            if (i3 >= this._capacity) {
                i3 -= this._capacity;
            }
            E e = (E) this._elements[i3];
            if (i3 < this._tail) {
                System.arraycopy(this._elements, i3 + 1, this._elements, i3, this._tail - i3);
                this._tail--;
                atomicInteger = this._size;
            } else {
                System.arraycopy(this._elements, i3 + 1, this._elements, i3, (this._capacity - i3) - 1);
                if (this._tail > 0) {
                    this._elements[this._capacity] = this._elements[0];
                    System.arraycopy(this._elements, 1, this._elements, 0, this._tail - 1);
                    i2 = this._tail;
                } else {
                    i2 = this._capacity;
                }
                this._tail = i2 - 1;
                atomicInteger = this._size;
            }
            atomicInteger.decrementAndGet();
            this._headLock.unlock();
            return e;
        } finally {
            this._tailLock.unlock();
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int i, E e) {
        if (e != null) {
            this._tailLock.lock();
            try {
                this._headLock.lock();
                if (i < 0 || i >= this._size.get()) {
                    throw new IndexOutOfBoundsException("!(0<" + i + "<=" + this._size + ")");
                }
                int i2 = this._head + i;
                if (i2 >= this._capacity) {
                    i2 -= this._capacity;
                }
                E e2 = (E) this._elements[i2];
                this._elements[i2] = e;
                this._headLock.unlock();
                return e2;
            } finally {
                this._tailLock.unlock();
            }
        }
        throw null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this._size.get();
    }

    public long sumOfSpace() {
        long j = this._space0;
        this._space0 = j + 1;
        long j2 = this._space1;
        this._space1 = j2 + 1;
        long j3 = j + j2;
        long j4 = this._space2;
        this._space2 = j4 + 1;
        long j5 = j3 + j4;
        long j6 = this._space3;
        this._space3 = j6 + 1;
        long j7 = j5 + j6;
        long j8 = this._space4;
        this._space4 = j8 + 1;
        long j9 = j7 + j8;
        long j10 = this._space5;
        this._space5 = j10 + 1;
        long j11 = j9 + j10;
        long j12 = this._space6;
        this._space6 = j12 + 1;
        long j13 = j11 + j12;
        long j14 = this._space7;
        this._space7 = 1 + j14;
        return j13 + j14;
    }

    @Override // java.util.concurrent.BlockingQueue
    public E take() throws InterruptedException {
        this._headLock.lockInterruptibly();
        while (this._size.get() == 0) {
            try {
                try {
                    this._notEmpty.await();
                } catch (InterruptedException e) {
                    this._notEmpty.signal();
                    throw e;
                }
            } finally {
                this._headLock.unlock();
            }
        }
        int i = this._head;
        E e2 = (E) this._elements[i];
        this._elements[i] = null;
        this._head = (i + 1) % this._capacity;
        if (this._size.decrementAndGet() > 0) {
            this._notEmpty.signal();
        }
        return e2;
    }
}
