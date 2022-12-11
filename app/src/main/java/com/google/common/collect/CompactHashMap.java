package com.google.common.collect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import me.tvspark.AbstractC2272ju;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public class CompactHashMap<K, V> extends AbstractMap<K, V> implements Serializable {
    public static final float DEFAULT_LOAD_FACTOR = 1.0f;
    public static final int DEFAULT_SIZE = 3;
    public static final long HASH_MASK = -4294967296L;
    public static final int MAXIMUM_CAPACITY = 1073741824;
    public static final long NEXT_MASK = 4294967295L;
    public static final int UNSET = -1;
    public transient long[] entries;
    public transient Set<Map.Entry<K, V>> entrySetView;
    public transient Set<K> keySetView;
    public transient Object[] keys;
    public transient float loadFactor;
    public transient int modCount;
    public transient int size;
    public transient int[] table;
    public transient int threshold;
    public transient Object[] values;
    public transient Collection<V> valuesView;

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractCollection<V> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            CompactHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return CompactHashMap.this.valuesIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return CompactHashMap.this.size;
        }
    }

    /* loaded from: classes3.dex */
    public final class Wwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2272ju<K, V> {
        public int Wwwwwwwwwwwwwwwwwwwwwww;
        public final K Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = (K) CompactHashMap.this.keys[i];
            this.Wwwwwwwwwwwwwwwwwwwwwww = i;
        }

        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            int i = this.Wwwwwwwwwwwwwwwwwwwwwww;
            if (i == -1 || i >= CompactHashMap.this.size() || !Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, CompactHashMap.this.keys[this.Wwwwwwwwwwwwwwwwwwwwwww])) {
                this.Wwwwwwwwwwwwwwwwwwwwwww = CompactHashMap.this.indexOf(this.Wwwwwwwwwwwwwwwwwwwwwwww);
            }
        }

        @Override // me.tvspark.AbstractC2272ju, java.util.Map.Entry
        public K getKey() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.AbstractC2272ju, java.util.Map.Entry
        public V getValue() {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            int i = this.Wwwwwwwwwwwwwwwwwwwwwww;
            if (i == -1) {
                return null;
            }
            return (V) CompactHashMap.this.values[i];
        }

        @Override // me.tvspark.AbstractC2272ju, java.util.Map.Entry
        public V setValue(V v) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            int i = this.Wwwwwwwwwwwwwwwwwwwwwww;
            if (i == -1) {
                CompactHashMap.this.put(this.Wwwwwwwwwwwwwwwwwwwwwwww, v);
                return null;
            }
            Object[] objArr = CompactHashMap.this.values;
            V v2 = (V) objArr[i];
            objArr[i] = v;
            return v2;
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractSet<K> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            CompactHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return CompactHashMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return CompactHashMap.this.keySetIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int indexOf = CompactHashMap.this.indexOf(obj);
            if (indexOf == -1) {
                return false;
            }
            CompactHashMap.this.removeEntry(indexOf);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return CompactHashMap.this.size;
        }
    }

    /* loaded from: classes3.dex */
    public abstract class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> implements Iterator<T> {
        public int Wwwwwwwwwwwwwwwwwwwwww = -1;
        public int Wwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwww;

        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            CompactHashMap compactHashMap = CompactHashMap.this;
            this.Wwwwwwwwwwwwwwwwwwwwwwww = compactHashMap.modCount;
            this.Wwwwwwwwwwwwwwwwwwwwwww = compactHashMap.firstEntryIndex();
        }

        public abstract T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i);

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.Wwwwwwwwwwwwwwwwwwwwwww >= 0;
        }

        @Override // java.util.Iterator
        public T next() {
            if (CompactHashMap.this.modCount == this.Wwwwwwwwwwwwwwwwwwwwwwww) {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                int i = this.Wwwwwwwwwwwwwwwwwwwwwww;
                this.Wwwwwwwwwwwwwwwwwwwwww = i;
                T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
                this.Wwwwwwwwwwwwwwwwwwwwwww = CompactHashMap.this.getSuccessor(this.Wwwwwwwwwwwwwwwwwwwwwww);
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            throw new ConcurrentModificationException();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (CompactHashMap.this.modCount == this.Wwwwwwwwwwwwwwwwwwwwwwww) {
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwww >= 0, "no calls to next() since the last call to remove()");
                this.Wwwwwwwwwwwwwwwwwwwwwwww++;
                CompactHashMap.this.removeEntry(this.Wwwwwwwwwwwwwwwwwwwwww);
                this.Wwwwwwwwwwwwwwwwwwwwwww = CompactHashMap.this.adjustAfterRemove(this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww);
                this.Wwwwwwwwwwwwwwwwwwwwww = -1;
                return;
            }
            throw new ConcurrentModificationException();
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractSet<Map.Entry<K, V>> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            CompactHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                int indexOf = CompactHashMap.this.indexOf(entry.getKey());
                return indexOf != -1 && Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CompactHashMap.this.values[indexOf], entry.getValue());
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return CompactHashMap.this.entrySetIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                int indexOf = CompactHashMap.this.indexOf(entry.getKey());
                if (indexOf == -1 || !Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CompactHashMap.this.values[indexOf], entry.getValue())) {
                    return false;
                }
                CompactHashMap.this.removeEntry(indexOf);
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return CompactHashMap.this.size;
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends CompactHashMap<K, V>.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<V> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            super(null);
        }

        @Override // com.google.common.collect.CompactHashMap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public V Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            return (V) CompactHashMap.this.values[i];
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends CompactHashMap<K, V>.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Map.Entry<K, V>> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            super(null);
        }

        @Override // com.google.common.collect.CompactHashMap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends CompactHashMap<K, V>.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            super(null);
        }

        @Override // com.google.common.collect.CompactHashMap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public K Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            return (K) CompactHashMap.this.keys[i];
        }
    }

    public CompactHashMap() {
        init(3, 1.0f);
    }

    public CompactHashMap(int i) {
        this(i, 1.0f);
    }

    public CompactHashMap(int i, float f) {
        init(i, f);
    }

    public static <K, V> CompactHashMap<K, V> create() {
        return new CompactHashMap<>();
    }

    public static <K, V> CompactHashMap<K, V> createWithExpectedSize(int i) {
        return new CompactHashMap<>(i);
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

    /* JADX INFO: Access modifiers changed from: private */
    public int indexOf(Object obj) {
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj);
        int i = this.table[hashTableMask() & Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2];
        while (i != -1) {
            long j = this.entries[i];
            if (getHash(j) == Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2 && Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj, this.keys[i])) {
                return i;
            }
            i = getNext(j);
        }
        return -1;
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
                put(objectInputStream.readObject(), objectInputStream.readObject());
            } else {
                return;
            }
        }
    }

    private V remove(Object obj, int i) {
        int hashTableMask = hashTableMask() & i;
        int i2 = this.table[hashTableMask];
        if (i2 == -1) {
            return null;
        }
        int i3 = -1;
        while (true) {
            if (getHash(this.entries[i2]) == i && Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj, this.keys[i2])) {
                V v = (V) this.values[i2];
                if (i3 == -1) {
                    this.table[hashTableMask] = getNext(this.entries[i2]);
                } else {
                    long[] jArr = this.entries;
                    jArr[i3] = swapNext(jArr[i3], getNext(jArr[i2]));
                }
                moveLastEntry(i2);
                this.size--;
                this.modCount++;
                return v;
            }
            int next = getNext(this.entries[i2]);
            if (next == -1) {
                return null;
            }
            i3 = i2;
            i2 = next;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public V removeEntry(int i) {
        return remove(this.keys[i], getHash(this.entries[i]));
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
        for (int i = 0; i < this.size; i++) {
            objectOutputStream.writeObject(this.keys[i]);
            objectOutputStream.writeObject(this.values[i]);
        }
    }

    public void accessEntry(int i) {
    }

    public int adjustAfterRemove(int i, int i2) {
        return i - 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.modCount++;
        Arrays.fill(this.keys, 0, this.size, (Object) null);
        Arrays.fill(this.values, 0, this.size, (Object) null);
        Arrays.fill(this.table, -1);
        Arrays.fill(this.entries, -1L);
        this.size = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        for (int i = 0; i < this.size; i++) {
            if (Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj, this.values[i])) {
                return true;
            }
        }
        return false;
    }

    public Set<Map.Entry<K, V>> createEntrySet() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public Set<K> createKeySet() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public Collection<V> createValues() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySetView;
        if (set == null) {
            Set<Map.Entry<K, V>> createEntrySet = createEntrySet();
            this.entrySetView = createEntrySet;
            return createEntrySet;
        }
        return set;
    }

    public Iterator<Map.Entry<K, V>> entrySetIterator() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public int firstEntryIndex() {
        return isEmpty() ? -1 : 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        int indexOf = indexOf(obj);
        accessEntry(indexOf);
        if (indexOf == -1) {
            return null;
        }
        return (V) this.values[indexOf];
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
        this.keys = new Object[i];
        this.values = new Object[i];
        this.entries = newEntries(i);
        this.threshold = Math.max(1, (int) (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 * f));
    }

    public void insertEntry(int i, K k, V v, int i2) {
        this.entries[i] = (i2 << 32) | 4294967295L;
        this.keys[i] = k;
        this.values[i] = v;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.keySetView;
        if (set == null) {
            Set<K> createKeySet = createKeySet();
            this.keySetView = createKeySet;
            return createKeySet;
        }
        return set;
    }

    public Iterator<K> keySetIterator() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public void moveLastEntry(int i) {
        int size = size() - 1;
        if (i >= size) {
            this.keys[i] = null;
            this.values[i] = null;
            this.entries[i] = -1;
            return;
        }
        Object[] objArr = this.keys;
        objArr[i] = objArr[size];
        Object[] objArr2 = this.values;
        objArr2[i] = objArr2[size];
        objArr[size] = null;
        objArr2[size] = null;
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

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        long[] jArr = this.entries;
        Object[] objArr = this.keys;
        Object[] objArr2 = this.values;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(k);
        int hashTableMask = hashTableMask() & Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        int i = this.size;
        int[] iArr = this.table;
        int i2 = iArr[hashTableMask];
        if (i2 == -1) {
            iArr[hashTableMask] = i;
        } else {
            while (true) {
                long j = jArr[i2];
                if (getHash(j) == Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2 && Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k, objArr[i2])) {
                    V v2 = (V) objArr2[i2];
                    objArr2[i2] = v;
                    accessEntry(i2);
                    return v2;
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
            insertEntry(i, k, v, Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            this.size = i3;
            if (i >= this.threshold) {
                resizeTable(this.table.length * 2);
            }
            this.modCount++;
            return null;
        }
        throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        return remove(obj, Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj));
    }

    public void resizeEntries(int i) {
        this.keys = Arrays.copyOf(this.keys, i);
        this.values = Arrays.copyOf(this.values, i);
        long[] jArr = this.entries;
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, i);
        if (i > length) {
            Arrays.fill(copyOf, length, i, -1L);
        }
        this.entries = copyOf;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
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

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.valuesView;
        if (collection == null) {
            Collection<V> createValues = createValues();
            this.valuesView = createValues;
            return createValues;
        }
        return collection;
    }

    public Iterator<V> valuesIterator() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }
}
