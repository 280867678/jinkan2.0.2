package com.google.common.collect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public class CompactHashSet<E> extends AbstractSet<E> implements Serializable {
    public static final float DEFAULT_LOAD_FACTOR = 1.0f;
    public static final int DEFAULT_SIZE = 3;
    public static final long HASH_MASK = -4294967296L;
    public static final int MAXIMUM_CAPACITY = 1073741824;
    public static final long NEXT_MASK = 4294967295L;
    public static final int UNSET = -1;
    public transient Object[] elements;
    public transient long[] entries;
    public transient float loadFactor;
    public transient int modCount;
    public transient int size;
    public transient int[] table;
    public transient int threshold;

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Iterator<E> {
        public int Wwwwwwwwwwwwwwwwwwwwww = -1;
        public int Wwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            CompactHashSet compactHashSet = CompactHashSet.this;
            this.Wwwwwwwwwwwwwwwwwwwwwwww = compactHashSet.modCount;
            this.Wwwwwwwwwwwwwwwwwwwwwww = compactHashSet.firstEntryIndex();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.Wwwwwwwwwwwwwwwwwwwwwww >= 0;
        }

        @Override // java.util.Iterator
        public E next() {
            if (CompactHashSet.this.modCount == this.Wwwwwwwwwwwwwwwwwwwwwwww) {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                int i = this.Wwwwwwwwwwwwwwwwwwwwwww;
                this.Wwwwwwwwwwwwwwwwwwwwww = i;
                CompactHashSet compactHashSet = CompactHashSet.this;
                E e = (E) compactHashSet.elements[i];
                this.Wwwwwwwwwwwwwwwwwwwwwww = compactHashSet.getSuccessor(i);
                return e;
            }
            throw new ConcurrentModificationException();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (CompactHashSet.this.modCount == this.Wwwwwwwwwwwwwwwwwwwwwwww) {
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwww >= 0, "no calls to next() since the last call to remove()");
                this.Wwwwwwwwwwwwwwwwwwwwwwww++;
                CompactHashSet compactHashSet = CompactHashSet.this;
                compactHashSet.remove(compactHashSet.elements[this.Wwwwwwwwwwwwwwwwwwwwww], CompactHashSet.getHash(compactHashSet.entries[this.Wwwwwwwwwwwwwwwwwwwwww]));
                this.Wwwwwwwwwwwwwwwwwwwwwww = CompactHashSet.this.adjustAfterRemove(this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww);
                this.Wwwwwwwwwwwwwwwwwwwwww = -1;
                return;
            }
            throw new ConcurrentModificationException();
        }
    }

    public CompactHashSet() {
        init(3, 1.0f);
    }

    public CompactHashSet(int i) {
        init(i, 1.0f);
    }

    public static <E> CompactHashSet<E> create() {
        return new CompactHashSet<>();
    }

    public static <E> CompactHashSet<E> create(Collection<? extends E> collection) {
        CompactHashSet<E> createWithExpectedSize = createWithExpectedSize(collection.size());
        createWithExpectedSize.addAll(collection);
        return createWithExpectedSize;
    }

    public static <E> CompactHashSet<E> create(E... eArr) {
        CompactHashSet<E> createWithExpectedSize = createWithExpectedSize(eArr.length);
        Collections.addAll(createWithExpectedSize, eArr);
        return createWithExpectedSize;
    }

    public static <E> CompactHashSet<E> createWithExpectedSize(int i) {
        return new CompactHashSet<>(i);
    }

    public static int getHash(long j) {
        return (int) (j >>> 32);
    }

    public static int getNext(long j) {
        return (int) j;
    }

    private int hashTableMask() {
        return this.table.length - 1;
    }

    public static long[] newEntries(int i) {
        long[] jArr = new long[i];
        Arrays.fill(jArr, -1L);
        return jArr;
    }

    public static int[] newTable(int i) {
        int[] iArr = new int[i];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        init(3, 1.0f);
        int readInt = objectInputStream.readInt();
        while (true) {
            readInt--;
            if (readInt >= 0) {
                add(objectInputStream.readObject());
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean remove(Object obj, int i) {
        int hashTableMask = hashTableMask() & i;
        int i2 = this.table[hashTableMask];
        if (i2 == -1) {
            return false;
        }
        int i3 = -1;
        while (true) {
            if (getHash(this.entries[i2]) == i && Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj, this.elements[i2])) {
                if (i3 == -1) {
                    this.table[hashTableMask] = getNext(this.entries[i2]);
                } else {
                    long[] jArr = this.entries;
                    jArr[i3] = swapNext(jArr[i3], getNext(jArr[i2]));
                }
                moveEntry(i2);
                this.size--;
                this.modCount++;
                return true;
            }
            int next = getNext(this.entries[i2]);
            if (next == -1) {
                return false;
            }
            i3 = i2;
            i2 = next;
        }
    }

    private void resizeMeMaybe(int i) {
        int length = this.entries.length;
        if (i > length) {
            int max = Math.max(1, length >>> 1) + length;
            if (max < 0) {
                max = Integer.MAX_VALUE;
            }
            if (max == length) {
                return;
            }
            resizeEntries(max);
        }
    }

    private void resizeTable(int i) {
        if (this.table.length >= 1073741824) {
            this.threshold = Integer.MAX_VALUE;
            return;
        }
        int i2 = ((int) (i * this.loadFactor)) + 1;
        int[] newTable = newTable(i);
        long[] jArr = this.entries;
        int length = newTable.length - 1;
        for (int i3 = 0; i3 < this.size; i3++) {
            int hash = getHash(jArr[i3]);
            int i4 = hash & length;
            int i5 = newTable[i4];
            newTable[i4] = i3;
            jArr[i3] = (hash << 32) | (i5 & 4294967295L);
        }
        this.threshold = i2;
        this.table = newTable;
    }

    public static long swapNext(long j, int i) {
        return (j & (-4294967296L)) | (i & 4294967295L);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.size);
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            objectOutputStream.writeObject(it.next());
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E e) {
        long[] jArr = this.entries;
        Object[] objArr = this.elements;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(e);
        int hashTableMask = hashTableMask() & Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i = this.size;
        int[] iArr = this.table;
        int i2 = iArr[hashTableMask];
        if (i2 == -1) {
            iArr[hashTableMask] = i;
        } else {
            while (true) {
                long j = jArr[i2];
                if (getHash(j) == Wwwwwwwwwwwwwwwwwwwwwwwwwwwww && Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(e, objArr[i2])) {
                    return false;
                }
                int next = getNext(j);
                if (next == -1) {
                    jArr[i2] = swapNext(j, i);
                    break;
                }
                i2 = next;
            }
        }
        if (i != Integer.MAX_VALUE) {
            int i3 = i + 1;
            resizeMeMaybe(i3);
            insertEntry(i, e, Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            this.size = i3;
            if (i >= this.threshold) {
                resizeTable(this.table.length * 2);
            }
            this.modCount++;
            return true;
        }
        throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
    }

    public int adjustAfterRemove(int i, int i2) {
        return i - 1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.modCount++;
        Arrays.fill(this.elements, 0, this.size, (Object) null);
        Arrays.fill(this.table, -1);
        Arrays.fill(this.entries, -1L);
        this.size = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj);
        int i = this.table[hashTableMask() & Wwwwwwwwwwwwwwwwwwwwwwwwwwwww];
        while (i != -1) {
            long j = this.entries[i];
            if (getHash(j) == Wwwwwwwwwwwwwwwwwwwwwwwwwwwww && Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj, this.elements[i])) {
                return true;
            }
            i = getNext(j);
        }
        return false;
    }

    public int firstEntryIndex() {
        return isEmpty() ? -1 : 0;
    }

    public int getSuccessor(int i) {
        int i2 = i + 1;
        if (i2 < this.size) {
            return i2;
        }
        return -1;
    }

    public void init(int i, float f) {
        boolean z = false;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i >= 0, "Initial capacity must be non-negative");
        if (f > 0.0f) {
            z = true;
        }
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z, "Illegal load factor");
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, f);
        this.table = newTable(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        this.loadFactor = f;
        this.elements = new Object[i];
        this.entries = newEntries(i);
        this.threshold = Math.max(1, (int) (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 * f));
    }

    public void insertEntry(int i, E e, int i2) {
        this.entries[i] = (i2 << 32) | 4294967295L;
        this.elements[i] = e;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public void moveEntry(int i) {
        int size = size() - 1;
        if (i >= size) {
            this.elements[i] = null;
            this.entries[i] = -1;
            return;
        }
        Object[] objArr = this.elements;
        objArr[i] = objArr[size];
        objArr[size] = null;
        long[] jArr = this.entries;
        long j = jArr[size];
        jArr[i] = j;
        jArr[size] = -1;
        int hash = getHash(j) & hashTableMask();
        int[] iArr = this.table;
        int i2 = iArr[hash];
        if (i2 == size) {
            iArr[hash] = i;
            return;
        }
        while (true) {
            long j2 = this.entries[i2];
            int next = getNext(j2);
            if (next == size) {
                this.entries[i2] = swapNext(j2, i);
                return;
            }
            i2 = next;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        return remove(obj, Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj));
    }

    public void resizeEntries(int i) {
        this.elements = Arrays.copyOf(this.elements, i);
        long[] jArr = this.entries;
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, i);
        if (i > length) {
            Arrays.fill(copyOf, length, i, -1L);
        }
        this.entries = copyOf;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return Arrays.copyOf(this.elements, this.size);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        Object[] objArr = this.elements;
        int i = this.size;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, 0 + i, objArr.length);
        if (tArr.length < i) {
            tArr = (T[]) Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object[]) tArr, i);
        } else if (tArr.length > i) {
            tArr[i] = null;
        }
        System.arraycopy(objArr, 0, tArr, 0, i);
        return tArr;
    }

    public void trimToSize() {
        int i = this.size;
        if (i < this.entries.length) {
            resizeEntries(i);
        }
        int max = Math.max(1, Integer.highestOneBit((int) (i / this.loadFactor)));
        if (max < 1073741824 && i / max > this.loadFactor) {
            max <<= 1;
        }
        if (max < this.table.length) {
            resizeTable(max);
        }
    }
}
