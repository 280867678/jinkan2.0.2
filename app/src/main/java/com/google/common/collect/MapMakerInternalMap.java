package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.collect.MapMaker;
import com.google.common.collect.MapMakerInternalMap.Segment;
import com.google.common.collect.MapMakerInternalMap.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import me.tvspark.AbstractC2272ju;
import me.tvspark.AbstractConcurrentMapC2088ev;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public class MapMakerInternalMap<K, V, E extends Wwwwwwwwwwwwwwwwwwwwwwwwwww<K, V, E>, S extends Segment<K, V, E, S>> extends AbstractMap<K, V> implements ConcurrentMap<K, V>, Serializable {
    public static final long CLEANUP_EXECUTOR_DELAY_SECS = 60;
    public static final int CONTAINS_VALUE_RETRIES = 3;
    public static final int DRAIN_MAX = 16;
    public static final int DRAIN_THRESHOLD = 63;
    public static final int MAXIMUM_CAPACITY = 1073741824;
    public static final int MAX_SEGMENTS = 65536;
    public static final Wwwwwwwwwwww<Object, Object, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> UNSET_WEAK_VALUE_REFERENCE = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public static final long serialVersionUID = 5;
    public final int concurrencyLevel;
    public final transient Wwwwwwwwwwwwwwwwwwwwwwwwww<K, V, E, S> entryHelper;
    public transient Set<Map.Entry<K, V>> entrySet;
    public final Equivalence<Object> keyEquivalence;
    public transient Set<K> keySet;
    public final transient int segmentMask;
    public final transient int segmentShift;
    public final transient Segment<K, V, E, S>[] segments;
    public transient Collection<V> values;

    /* loaded from: classes3.dex */
    public static abstract class AbstractSerializationProxy<K, V> extends AbstractConcurrentMapC2088ev<K, V> implements Serializable {
        public static final long serialVersionUID = 3;
        public final int concurrencyLevel;
        public transient ConcurrentMap<K, V> delegate;
        public final Equivalence<Object> keyEquivalence;
        public final Strength keyStrength;
        public final Equivalence<Object> valueEquivalence;
        public final Strength valueStrength;

        public AbstractSerializationProxy(Strength strength, Strength strength2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, int i, ConcurrentMap<K, V> concurrentMap) {
            this.keyStrength = strength;
            this.valueStrength = strength2;
            this.keyEquivalence = equivalence;
            this.valueEquivalence = equivalence2;
            this.concurrencyLevel = i;
            this.delegate = concurrentMap;
        }

        @Override // me.tvspark.AbstractConcurrentMapC2088ev, me.tvspark.AbstractC2162gv, me.tvspark.AbstractC2310kv
        /* renamed from: delegate */
        public ConcurrentMap<K, V> mo4974delegate() {
            return this.delegate;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void readEntries(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            while (true) {
                Object readObject = objectInputStream.readObject();
                if (readObject == null) {
                    return;
                }
                this.delegate.put(readObject, objectInputStream.readObject());
            }
        }

        public MapMaker readMapMaker(ObjectInputStream objectInputStream) throws IOException {
            int readInt = objectInputStream.readInt();
            MapMaker mapMaker = new MapMaker();
            boolean z = false;
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mapMaker.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -1, "initial capacity was already set to %s", mapMaker.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(readInt >= 0);
            mapMaker.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = readInt;
            mapMaker.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.keyStrength);
            Strength strength = this.valueStrength;
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mapMaker.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null, "Value strength was already set to %s", mapMaker.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            if (strength != null) {
                mapMaker.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = strength;
                if (strength != Strength.STRONG) {
                    mapMaker.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
                }
                Equivalence<Object> equivalence = this.keyEquivalence;
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mapMaker.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww == null, "key equivalence was already set to %s", mapMaker.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                if (equivalence != null) {
                    mapMaker.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = equivalence;
                    mapMaker.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
                    int i = this.concurrencyLevel;
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mapMaker.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -1, "concurrency level was already set to %s", mapMaker.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    if (i > 0) {
                        z = true;
                    }
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z);
                    mapMaker.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
                    return mapMaker;
                }
                throw null;
            }
            throw null;
        }

        public void writeMapTo(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeInt(this.delegate.size());
            for (Map.Entry<K, V> entry : this.delegate.entrySet()) {
                objectOutputStream.writeObject(entry.getKey());
                objectOutputStream.writeObject(entry.getValue());
            }
            objectOutputStream.writeObject(null);
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class Segment<K, V, E extends Wwwwwwwwwwwwwwwwwwwwwwwwwww<K, V, E>, S extends Segment<K, V, E, S>> extends ReentrantLock {
        public volatile int count;
        public final MapMakerInternalMap<K, V, E, S> map;
        public final int maxSegmentSize;
        public int modCount;
        public final AtomicInteger readCount = new AtomicInteger();
        public volatile AtomicReferenceArray<E> table;
        public int threshold;

        public Segment(MapMakerInternalMap<K, V, E, S> mapMakerInternalMap, int i, int i2) {
            this.map = mapMakerInternalMap;
            this.maxSegmentSize = i2;
            initTable(newEntryArray(i));
        }

        public static <K, V, E extends Wwwwwwwwwwwwwwwwwwwwwwwwwww<K, V, E>> boolean isCollected(E e) {
            return e.getValue() == null;
        }

        /* renamed from: castForTesting */
        public abstract E mo4669castForTesting(Wwwwwwwwwwwwwwwwwwwwwwwwwww<K, V, ?> wwwwwwwwwwwwwwwwwwwwwwwwwww);

        public void clear() {
            if (this.count != 0) {
                lock();
                try {
                    AtomicReferenceArray<E> atomicReferenceArray = this.table;
                    for (int i = 0; i < atomicReferenceArray.length(); i++) {
                        atomicReferenceArray.set(i, null);
                    }
                    maybeClearReferenceQueues();
                    this.readCount.set(0);
                    this.modCount++;
                    this.count = 0;
                } finally {
                    unlock();
                }
            }
        }

        public <T> void clearReferenceQueue(ReferenceQueue<T> referenceQueue) {
            do {
            } while (referenceQueue.poll() != null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public boolean clearValueForTesting(K k, int i, Wwwwwwwwwwww<K, V, ? extends Wwwwwwwwwwwwwwwwwwwwwwwwwww<K, V, ?>> wwwwwwwwwwww) {
            lock();
            try {
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                E e = atomicReferenceArray.get(length);
                for (Wwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwww = e; wwwwwwwwwwwwwwwwwwwwwwwwwww != null; wwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwww.getNext()) {
                    Object key = wwwwwwwwwwwwwwwwwwwwwwwwwww.getKey();
                    if (wwwwwwwwwwwwwwwwwwwwwwwwwww.getHash() == i && key != null && this.map.keyEquivalence.equivalent(k, key)) {
                        if (((Wwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwww).getValueReference() != wwwwwwwwwwww) {
                            return false;
                        }
                        atomicReferenceArray.set(length, removeFromChain(e, wwwwwwwwwwwwwwwwwwwwwwwwwww));
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
            }
        }

        public boolean containsKey(Object obj, int i) {
            try {
                boolean z = false;
                if (this.count == 0) {
                    return false;
                }
                E liveEntry = getLiveEntry(obj, i);
                if (liveEntry != null) {
                    if (liveEntry.getValue() != null) {
                        z = true;
                    }
                }
                return z;
            } finally {
                postReadCleanup();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public boolean containsValue(Object obj) {
            try {
                if (this.count != 0) {
                    AtomicReferenceArray<E> atomicReferenceArray = this.table;
                    int length = atomicReferenceArray.length();
                    for (int i = 0; i < length; i++) {
                        for (E e = atomicReferenceArray.get(i); e != null; e = e.getNext()) {
                            Object liveValue = getLiveValue(e);
                            if (liveValue != null && this.map.valueEquivalence().equivalent(obj, liveValue)) {
                                postReadCleanup();
                                return true;
                            }
                        }
                    }
                }
                return false;
            } finally {
                postReadCleanup();
            }
        }

        public E copyEntry(E e, E e2) {
            return this.map.entryHelper.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwww<K, V, E, S>) mo4670self(), (Wwwwwwwwwwwwwwwwwwwwwwwwwww) e, (Wwwwwwwwwwwwwwwwwwwwwwwwwww) e2);
        }

        public E copyForTesting(Wwwwwwwwwwwwwwwwwwwwwwwwwww<K, V, ?> wwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwww<K, V, ?> wwwwwwwwwwwwwwwwwwwwwwwwwww2) {
            return this.map.entryHelper.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwww<K, V, E, S>) mo4670self(), (Wwwwwwwwwwwwwwwwwwwwwwwwwww) mo4669castForTesting(wwwwwwwwwwwwwwwwwwwwwwwwwww), (Wwwwwwwwwwwwwwwwwwwwwwwwwww) mo4669castForTesting(wwwwwwwwwwwwwwwwwwwwwwwwwww2));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void drainKeyReferenceQueue(ReferenceQueue<K> referenceQueue) {
            int i = 0;
            do {
                Reference<? extends K> poll = referenceQueue.poll();
                if (poll == null) {
                    return;
                }
                this.map.reclaimKey((Wwwwwwwwwwwwwwwwwwwwwwwwwww) poll);
                i++;
            } while (i != 16);
        }

        public void drainValueReferenceQueue(ReferenceQueue<V> referenceQueue) {
            int i = 0;
            do {
                Reference<? extends V> poll = referenceQueue.poll();
                if (poll == null) {
                    return;
                }
                this.map.reclaimValue((Wwwwwwwwwwww) poll);
                i++;
            } while (i != 16);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void expand() {
            AtomicReferenceArray<E> atomicReferenceArray = this.table;
            int length = atomicReferenceArray.length();
            if (length >= 1073741824) {
                return;
            }
            int i = this.count;
            AtomicReferenceArray<E> atomicReferenceArray2 = (AtomicReferenceArray<E>) newEntryArray(length << 1);
            this.threshold = (atomicReferenceArray2.length() * 3) / 4;
            int length2 = atomicReferenceArray2.length() - 1;
            for (int i2 = 0; i2 < length; i2++) {
                E e = atomicReferenceArray.get(i2);
                if (e != null) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwww next = e.getNext();
                    int hash = e.getHash() & length2;
                    if (next == null) {
                        atomicReferenceArray2.set(hash, e);
                    } else {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwww = e;
                        while (next != null) {
                            int hash2 = next.getHash() & length2;
                            if (hash2 != hash) {
                                wwwwwwwwwwwwwwwwwwwwwwwwwww = next;
                                hash = hash2;
                            }
                            next = next.getNext();
                        }
                        atomicReferenceArray2.set(hash, wwwwwwwwwwwwwwwwwwwwwwwwwww);
                        while (e != wwwwwwwwwwwwwwwwwwwwwwwwwww) {
                            int hash3 = e.getHash() & length2;
                            Wwwwwwwwwwwwwwwwwwwwwwwwwww copyEntry = copyEntry(e, (Wwwwwwwwwwwwwwwwwwwwwwwwwww) atomicReferenceArray2.get(hash3));
                            if (copyEntry != null) {
                                atomicReferenceArray2.set(hash3, copyEntry);
                            } else {
                                i--;
                            }
                            e = e.getNext();
                        }
                    }
                }
            }
            this.table = atomicReferenceArray2;
            this.count = i;
        }

        public V get(Object obj, int i) {
            try {
                E liveEntry = getLiveEntry(obj, i);
                if (liveEntry == null) {
                    return null;
                }
                V v = (V) liveEntry.getValue();
                if (v == null) {
                    tryDrainReferenceQueues();
                }
                return v;
            } finally {
                postReadCleanup();
            }
        }

        public E getEntry(Object obj, int i) {
            if (this.count != 0) {
                for (E first = getFirst(i); first != null; first = (E) first.getNext()) {
                    if (first.getHash() == i) {
                        Object key = first.getKey();
                        if (key == null) {
                            tryDrainReferenceQueues();
                        } else if (this.map.keyEquivalence.equivalent(obj, key)) {
                            return first;
                        }
                    }
                }
                return null;
            }
            return null;
        }

        public E getFirst(int i) {
            AtomicReferenceArray<E> atomicReferenceArray = this.table;
            return atomicReferenceArray.get(i & (atomicReferenceArray.length() - 1));
        }

        public ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            throw new AssertionError();
        }

        public E getLiveEntry(Object obj, int i) {
            return getEntry(obj, i);
        }

        public V getLiveValue(E e) {
            if (e.getKey() == null) {
                tryDrainReferenceQueues();
                return null;
            }
            V v = (V) e.getValue();
            if (v != null) {
                return v;
            }
            tryDrainReferenceQueues();
            return null;
        }

        public V getLiveValueForTesting(Wwwwwwwwwwwwwwwwwwwwwwwwwww<K, V, ?> wwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return getLiveValue(mo4669castForTesting(wwwwwwwwwwwwwwwwwwwwwwwwwww));
        }

        public ReferenceQueue<V> getValueReferenceQueueForTesting() {
            throw new AssertionError();
        }

        public Wwwwwwwwwwww<K, V, E> getWeakValueReferenceForTesting(Wwwwwwwwwwwwwwwwwwwwwwwwwww<K, V, ?> wwwwwwwwwwwwwwwwwwwwwwwwwww) {
            throw new AssertionError();
        }

        public void initTable(AtomicReferenceArray<E> atomicReferenceArray) {
            int length = (atomicReferenceArray.length() * 3) / 4;
            this.threshold = length;
            if (length == this.maxSegmentSize) {
                this.threshold = length + 1;
            }
            this.table = atomicReferenceArray;
        }

        public void maybeClearReferenceQueues() {
        }

        public void maybeDrainReferenceQueues() {
        }

        public AtomicReferenceArray<E> newEntryArray(int i) {
            return new AtomicReferenceArray<>(i);
        }

        public E newEntryForTesting(K k, int i, Wwwwwwwwwwwwwwwwwwwwwwwwwww<K, V, ?> wwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return this.map.entryHelper.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mo4670self(), k, i, mo4669castForTesting(wwwwwwwwwwwwwwwwwwwwwwwwwww));
        }

        public Wwwwwwwwwwww<K, V, E> newWeakValueReferenceForTesting(Wwwwwwwwwwwwwwwwwwwwwwwwwww<K, V, ?> wwwwwwwwwwwwwwwwwwwwwwwwwww, V v) {
            throw new AssertionError();
        }

        public void postReadCleanup() {
            if ((this.readCount.incrementAndGet() & 63) == 0) {
                runCleanup();
            }
        }

        public void preWriteCleanup() {
            runLockedCleanup();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public V put(K k, int i, V v, boolean z) {
            lock();
            try {
                preWriteCleanup();
                int i2 = this.count + 1;
                if (i2 > this.threshold) {
                    expand();
                    i2 = this.count + 1;
                }
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                E e = atomicReferenceArray.get(length);
                for (Wwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwww = e; wwwwwwwwwwwwwwwwwwwwwwwwwww != null; wwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwww.getNext()) {
                    Object key = wwwwwwwwwwwwwwwwwwwwwwwwwww.getKey();
                    if (wwwwwwwwwwwwwwwwwwwwwwwwwww.getHash() == i && key != null && this.map.keyEquivalence.equivalent(k, key)) {
                        V v2 = (V) wwwwwwwwwwwwwwwwwwwwwwwwwww.getValue();
                        if (v2 == null) {
                            this.modCount++;
                            setValue(wwwwwwwwwwwwwwwwwwwwwwwwwww, v);
                            this.count = this.count;
                            return null;
                        } else if (z) {
                            return v2;
                        } else {
                            this.modCount++;
                            setValue(wwwwwwwwwwwwwwwwwwwwwwwwwww, v);
                            return v2;
                        }
                    }
                }
                this.modCount++;
                E Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.map.entryHelper.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mo4670self(), k, i, e);
                setValue(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, v);
                atomicReferenceArray.set(length, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                this.count = i2;
                return null;
            } finally {
                unlock();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public boolean reclaimKey(E e, int i) {
            lock();
            try {
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                E e2 = atomicReferenceArray.get(length);
                for (Wwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwww = e2; wwwwwwwwwwwwwwwwwwwwwwwwwww != null; wwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwww.getNext()) {
                    if (wwwwwwwwwwwwwwwwwwwwwwwwwww == e) {
                        this.modCount++;
                        atomicReferenceArray.set(length, removeFromChain(e2, wwwwwwwwwwwwwwwwwwwwwwwwwww));
                        this.count--;
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public boolean reclaimValue(K k, int i, Wwwwwwwwwwww<K, V, E> wwwwwwwwwwww) {
            lock();
            try {
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                E e = atomicReferenceArray.get(length);
                for (Wwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwww = e; wwwwwwwwwwwwwwwwwwwwwwwwwww != null; wwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwww.getNext()) {
                    Object key = wwwwwwwwwwwwwwwwwwwwwwwwwww.getKey();
                    if (wwwwwwwwwwwwwwwwwwwwwwwwwww.getHash() == i && key != null && this.map.keyEquivalence.equivalent(k, key)) {
                        if (((Wwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwww).getValueReference() != wwwwwwwwwwww) {
                            return false;
                        }
                        this.modCount++;
                        atomicReferenceArray.set(length, removeFromChain(e, wwwwwwwwwwwwwwwwwwwwwwwwwww));
                        this.count--;
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public V remove(Object obj, int i) {
            lock();
            try {
                preWriteCleanup();
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                E e = atomicReferenceArray.get(length);
                for (Wwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwww = e; wwwwwwwwwwwwwwwwwwwwwwwwwww != null; wwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwww.getNext()) {
                    Object key = wwwwwwwwwwwwwwwwwwwwwwwwwww.getKey();
                    if (wwwwwwwwwwwwwwwwwwwwwwwwwww.getHash() == i && key != null && this.map.keyEquivalence.equivalent(obj, key)) {
                        V v = (V) wwwwwwwwwwwwwwwwwwwwwwwwwww.getValue();
                        if (v == null && !isCollected(wwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                            return null;
                        }
                        this.modCount++;
                        atomicReferenceArray.set(length, removeFromChain(e, wwwwwwwwwwwwwwwwwwwwwwwwwww));
                        this.count--;
                        return v;
                    }
                }
                return null;
            } finally {
                unlock();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x003d, code lost:
            if (r8.map.valueEquivalence().equivalent(r11, r4.getValue()) == false) goto L20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x003f, code lost:
            r5 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0047, code lost:
            r8.modCount++;
            r0.set(r1, removeFromChain(r3, r4));
            r8.count--;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x005b, code lost:
            return r5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0045, code lost:
            if (isCollected(r4) == false) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x005f, code lost:
            return false;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean remove(Object obj, int i, Object obj2) {
            lock();
            try {
                preWriteCleanup();
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                E e = atomicReferenceArray.get(length);
                Wwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwww = e;
                while (true) {
                    boolean z = false;
                    if (wwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                        return false;
                    }
                    Object key = wwwwwwwwwwwwwwwwwwwwwwwwwww.getKey();
                    if (wwwwwwwwwwwwwwwwwwwwwwwwwww.getHash() == i && key != null && this.map.keyEquivalence.equivalent(obj, key)) {
                        break;
                    }
                    wwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwww.getNext();
                }
            } finally {
                unlock();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public boolean removeEntryForTesting(E e) {
            int hash = e.getHash();
            AtomicReferenceArray<E> atomicReferenceArray = this.table;
            int length = hash & (atomicReferenceArray.length() - 1);
            E e2 = atomicReferenceArray.get(length);
            for (Wwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwww = e2; wwwwwwwwwwwwwwwwwwwwwwwwwww != null; wwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwww.getNext()) {
                if (wwwwwwwwwwwwwwwwwwwwwwwwwww == e) {
                    this.modCount++;
                    atomicReferenceArray.set(length, removeFromChain(e2, wwwwwwwwwwwwwwwwwwwwwwwwwww));
                    this.count--;
                    return true;
                }
            }
            return false;
        }

        public E removeFromChain(E e, E e2) {
            int i = this.count;
            E e3 = (E) e2.getNext();
            while (e != e2) {
                E copyEntry = copyEntry(e, e3);
                if (copyEntry != null) {
                    e3 = copyEntry;
                } else {
                    i--;
                }
                e = (E) e.getNext();
            }
            this.count = i;
            return e3;
        }

        public E removeFromChainForTesting(Wwwwwwwwwwwwwwwwwwwwwwwwwww<K, V, ?> wwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwww<K, V, ?> wwwwwwwwwwwwwwwwwwwwwwwwwww2) {
            return removeFromChain(mo4669castForTesting(wwwwwwwwwwwwwwwwwwwwwwwwwww), mo4669castForTesting(wwwwwwwwwwwwwwwwwwwwwwwwwww2));
        }

        public boolean removeTableEntryForTesting(Wwwwwwwwwwwwwwwwwwwwwwwwwww<K, V, ?> wwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return removeEntryForTesting(mo4669castForTesting(wwwwwwwwwwwwwwwwwwwwwwwwwww));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public V replace(K k, int i, V v) {
            lock();
            try {
                preWriteCleanup();
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                E e = atomicReferenceArray.get(length);
                for (Wwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwww = e; wwwwwwwwwwwwwwwwwwwwwwwwwww != null; wwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwww.getNext()) {
                    Object key = wwwwwwwwwwwwwwwwwwwwwwwwwww.getKey();
                    if (wwwwwwwwwwwwwwwwwwwwwwwwwww.getHash() == i && key != null && this.map.keyEquivalence.equivalent(k, key)) {
                        V v2 = (V) wwwwwwwwwwwwwwwwwwwwwwwwwww.getValue();
                        if (v2 != null) {
                            this.modCount++;
                            setValue(wwwwwwwwwwwwwwwwwwwwwwwwwww, v);
                            return v2;
                        }
                        if (isCollected(wwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                            this.modCount++;
                            atomicReferenceArray.set(length, removeFromChain(e, wwwwwwwwwwwwwwwwwwwwwwwwwww));
                            this.count--;
                        }
                        return null;
                    }
                }
                return null;
            } finally {
                unlock();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public boolean replace(K k, int i, V v, V v2) {
            lock();
            try {
                preWriteCleanup();
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                E e = atomicReferenceArray.get(length);
                for (Wwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwww = e; wwwwwwwwwwwwwwwwwwwwwwwwwww != null; wwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwww.getNext()) {
                    Object key = wwwwwwwwwwwwwwwwwwwwwwwwwww.getKey();
                    if (wwwwwwwwwwwwwwwwwwwwwwwwwww.getHash() == i && key != null && this.map.keyEquivalence.equivalent(k, key)) {
                        Object value = wwwwwwwwwwwwwwwwwwwwwwwwwww.getValue();
                        if (value != null) {
                            if (!this.map.valueEquivalence().equivalent(v, value)) {
                                return false;
                            }
                            this.modCount++;
                            setValue(wwwwwwwwwwwwwwwwwwwwwwwwwww, v2);
                            return true;
                        }
                        if (isCollected(wwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                            this.modCount++;
                            atomicReferenceArray.set(length, removeFromChain(e, wwwwwwwwwwwwwwwwwwwwwwwwwww));
                            this.count--;
                        }
                        return false;
                    }
                }
                return false;
            } finally {
                unlock();
            }
        }

        public void runCleanup() {
            runLockedCleanup();
        }

        public void runLockedCleanup() {
            if (tryLock()) {
                try {
                    maybeDrainReferenceQueues();
                    this.readCount.set(0);
                } finally {
                    unlock();
                }
            }
        }

        /* renamed from: self */
        public abstract S mo4670self();

        public void setTableEntryForTesting(int i, Wwwwwwwwwwwwwwwwwwwwwwwwwww<K, V, ?> wwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.table.set(i, mo4669castForTesting(wwwwwwwwwwwwwwwwwwwwwwwwwww));
        }

        public void setValue(E e, V v) {
            this.map.entryHelper.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwww<K, V, E, S>) mo4670self(), (S) e, (E) v);
        }

        public void setValueForTesting(Wwwwwwwwwwwwwwwwwwwwwwwwwww<K, V, ?> wwwwwwwwwwwwwwwwwwwwwwwwwww, V v) {
            this.map.entryHelper.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwww<K, V, E, S>) mo4670self(), (S) mo4669castForTesting(wwwwwwwwwwwwwwwwwwwwwwwwwww), (E) v);
        }

        public void setWeakValueReferenceForTesting(Wwwwwwwwwwwwwwwwwwwwwwwwwww<K, V, ?> wwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwww<K, V, ? extends Wwwwwwwwwwwwwwwwwwwwwwwwwww<K, V, ?>> wwwwwwwwwwww) {
            throw new AssertionError();
        }

        public void tryDrainReferenceQueues() {
            if (tryLock()) {
                try {
                    maybeDrainReferenceQueues();
                } finally {
                    unlock();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class SerializationProxy<K, V> extends AbstractSerializationProxy<K, V> {
        public static final long serialVersionUID = 3;

        public SerializationProxy(Strength strength, Strength strength2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, int i, ConcurrentMap<K, V> concurrentMap) {
            super(strength, strength2, equivalence, equivalence2, i, concurrentMap);
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.delegate = readMapMaker(objectInputStream).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            readEntries(objectInputStream);
        }

        private Object readResolve() {
            return this.delegate;
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            writeMapTo(objectOutputStream);
        }
    }

    /* loaded from: classes3.dex */
    public enum Strength {
        STRONG { // from class: com.google.common.collect.MapMakerInternalMap.Strength.1
            @Override // com.google.common.collect.MapMakerInternalMap.Strength
            public Equivalence<Object> defaultEquivalence() {
                return Equivalence.equals();
            }
        },
        WEAK { // from class: com.google.common.collect.MapMakerInternalMap.Strength.2
            @Override // com.google.common.collect.MapMakerInternalMap.Strength
            public Equivalence<Object> defaultEquivalence() {
                return Equivalence.identity();
            }
        };

        /* synthetic */ Strength(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this();
        }

        public abstract Equivalence<Object> defaultEquivalence();
    }

    /* loaded from: classes3.dex */
    public static final class StrongKeyDummyValueSegment<K> extends Segment<K, MapMaker.Dummy, Wwwwwwwwwwwwwwwwwwwwww<K>, StrongKeyDummyValueSegment<K>> {
        public StrongKeyDummyValueSegment(MapMakerInternalMap<K, MapMaker.Dummy, Wwwwwwwwwwwwwwwwwwwwww<K>, StrongKeyDummyValueSegment<K>> mapMakerInternalMap, int i, int i2) {
            super(mapMakerInternalMap, i, i2);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        /* renamed from: castForTesting */
        public Wwwwwwwwwwwwwwwwwwwwww<K> mo4669castForTesting(Wwwwwwwwwwwwwwwwwwwwwwwwwww<K, MapMaker.Dummy, ?> wwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return (Wwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        /* renamed from: self  reason: collision with other method in class */
        public StrongKeyDummyValueSegment<K> mo4670self() {
            return this;
        }
    }

    /* loaded from: classes3.dex */
    public static final class StrongKeyStrongValueSegment<K, V> extends Segment<K, V, Wwwwwwwwwwwwwwwwwwwww<K, V>, StrongKeyStrongValueSegment<K, V>> {
        public StrongKeyStrongValueSegment(MapMakerInternalMap<K, V, Wwwwwwwwwwwwwwwwwwwww<K, V>, StrongKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i, int i2) {
            super(mapMakerInternalMap, i, i2);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        /* renamed from: castForTesting */
        public Wwwwwwwwwwwwwwwwwwwww<K, V> mo4669castForTesting(Wwwwwwwwwwwwwwwwwwwwwwwwwww<K, V, ?> wwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return (Wwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        /* renamed from: self  reason: collision with other method in class */
        public StrongKeyStrongValueSegment<K, V> mo4670self() {
            return this;
        }
    }

    /* loaded from: classes3.dex */
    public static final class StrongKeyWeakValueSegment<K, V> extends Segment<K, V, Wwwwwwwwwwwwwwwwwwww<K, V>, StrongKeyWeakValueSegment<K, V>> {
        public final ReferenceQueue<V> queueForValues = new ReferenceQueue<>();

        public StrongKeyWeakValueSegment(MapMakerInternalMap<K, V, Wwwwwwwwwwwwwwwwwwww<K, V>, StrongKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i, int i2) {
            super(mapMakerInternalMap, i, i2);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        /* renamed from: castForTesting */
        public Wwwwwwwwwwwwwwwwwwww<K, V> mo4669castForTesting(Wwwwwwwwwwwwwwwwwwwwwwwwwww<K, V, ?> wwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return (Wwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public ReferenceQueue<V> getValueReferenceQueueForTesting() {
            return this.queueForValues;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public Wwwwwwwwwwww<K, V, Wwwwwwwwwwwwwwwwwwww<K, V>> getWeakValueReferenceForTesting(Wwwwwwwwwwwwwwwwwwwwwwwwwww<K, V, ?> wwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return mo4669castForTesting((Wwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwww;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeClearReferenceQueues() {
            clearReferenceQueue((ReferenceQueue<V>) this.queueForValues);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeDrainReferenceQueues() {
            drainValueReferenceQueue(this.queueForValues);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public Wwwwwwwwwwww<K, V, Wwwwwwwwwwwwwwwwwwww<K, V>> newWeakValueReferenceForTesting(Wwwwwwwwwwwwwwwwwwwwwwwwwww<K, V, ?> wwwwwwwwwwwwwwwwwwwwwwwwwww, V v) {
            return new Wwwwwwwwwww(this.queueForValues, v, mo4669castForTesting((Wwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwww));
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        /* renamed from: self  reason: collision with other method in class */
        public StrongKeyWeakValueSegment<K, V> mo4670self() {
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void setWeakValueReferenceForTesting(Wwwwwwwwwwwwwwwwwwwwwwwwwww<K, V, ?> wwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwww<K, V, ? extends Wwwwwwwwwwwwwwwwwwwwwwwwwww<K, V, ?>> wwwwwwwwwwww) {
            Wwwwwwwwwwwwwwwwwwww<K, V> mo4669castForTesting = mo4669castForTesting((Wwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwww);
            Wwwwwwwwwwww<K, V, Wwwwwwwwwwwwwwwwwwww<K, V>> wwwwwwwwwwww2 = mo4669castForTesting.Wwwwwwwwwwwwwwwwwwwww;
            mo4669castForTesting.Wwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwww;
            wwwwwwwwwwww2.clear();
        }
    }

    /* loaded from: classes3.dex */
    public static final class WeakKeyDummyValueSegment<K> extends Segment<K, MapMaker.Dummy, Wwwwwwwwwwwwwwww<K>, WeakKeyDummyValueSegment<K>> {
        public final ReferenceQueue<K> queueForKeys = new ReferenceQueue<>();

        public WeakKeyDummyValueSegment(MapMakerInternalMap<K, MapMaker.Dummy, Wwwwwwwwwwwwwwww<K>, WeakKeyDummyValueSegment<K>> mapMakerInternalMap, int i, int i2) {
            super(mapMakerInternalMap, i, i2);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        /* renamed from: castForTesting */
        public Wwwwwwwwwwwwwwww<K> mo4669castForTesting(Wwwwwwwwwwwwwwwwwwwwwwwwwww<K, MapMaker.Dummy, ?> wwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return (Wwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            return this.queueForKeys;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeClearReferenceQueues() {
            clearReferenceQueue((ReferenceQueue<K>) this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeDrainReferenceQueues() {
            drainKeyReferenceQueue(this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        /* renamed from: self  reason: collision with other method in class */
        public WeakKeyDummyValueSegment<K> mo4670self() {
            return this;
        }
    }

    /* loaded from: classes3.dex */
    public static final class WeakKeyStrongValueSegment<K, V> extends Segment<K, V, Wwwwwwwwwwwwwww<K, V>, WeakKeyStrongValueSegment<K, V>> {
        public final ReferenceQueue<K> queueForKeys = new ReferenceQueue<>();

        public WeakKeyStrongValueSegment(MapMakerInternalMap<K, V, Wwwwwwwwwwwwwww<K, V>, WeakKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i, int i2) {
            super(mapMakerInternalMap, i, i2);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        /* renamed from: castForTesting */
        public Wwwwwwwwwwwwwww<K, V> mo4669castForTesting(Wwwwwwwwwwwwwwwwwwwwwwwwwww<K, V, ?> wwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return (Wwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            return this.queueForKeys;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeClearReferenceQueues() {
            clearReferenceQueue((ReferenceQueue<K>) this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeDrainReferenceQueues() {
            drainKeyReferenceQueue(this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        /* renamed from: self  reason: collision with other method in class */
        public WeakKeyStrongValueSegment<K, V> mo4670self() {
            return this;
        }
    }

    /* loaded from: classes3.dex */
    public static final class WeakKeyWeakValueSegment<K, V> extends Segment<K, V, Wwwwwwwwwwwwww<K, V>, WeakKeyWeakValueSegment<K, V>> {
        public final ReferenceQueue<K> queueForKeys = new ReferenceQueue<>();
        public final ReferenceQueue<V> queueForValues = new ReferenceQueue<>();

        public WeakKeyWeakValueSegment(MapMakerInternalMap<K, V, Wwwwwwwwwwwwww<K, V>, WeakKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i, int i2) {
            super(mapMakerInternalMap, i, i2);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        /* renamed from: castForTesting */
        public Wwwwwwwwwwwwww<K, V> mo4669castForTesting(Wwwwwwwwwwwwwwwwwwwwwwwwwww<K, V, ?> wwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return (Wwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            return this.queueForKeys;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public ReferenceQueue<V> getValueReferenceQueueForTesting() {
            return this.queueForValues;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public Wwwwwwwwwwww<K, V, Wwwwwwwwwwwwww<K, V>> getWeakValueReferenceForTesting(Wwwwwwwwwwwwwwwwwwwwwwwwwww<K, V, ?> wwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return mo4669castForTesting((Wwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeClearReferenceQueues() {
            clearReferenceQueue((ReferenceQueue<K>) this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeDrainReferenceQueues() {
            drainKeyReferenceQueue(this.queueForKeys);
            drainValueReferenceQueue(this.queueForValues);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public Wwwwwwwwwwww<K, V, Wwwwwwwwwwwwww<K, V>> newWeakValueReferenceForTesting(Wwwwwwwwwwwwwwwwwwwwwwwwwww<K, V, ?> wwwwwwwwwwwwwwwwwwwwwwwwwww, V v) {
            return new Wwwwwwwwwww(this.queueForValues, v, mo4669castForTesting((Wwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwww));
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        /* renamed from: self  reason: collision with other method in class */
        public WeakKeyWeakValueSegment<K, V> mo4670self() {
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void setWeakValueReferenceForTesting(Wwwwwwwwwwwwwwwwwwwwwwwwwww<K, V, ?> wwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwww<K, V, ? extends Wwwwwwwwwwwwwwwwwwwwwwwwwww<K, V, ?>> wwwwwwwwwwww) {
            Wwwwwwwwwwwwww<K, V> mo4669castForTesting = mo4669castForTesting((Wwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwww);
            Wwwwwwwwwwww<K, V, Wwwwwwwwwwwwww<K, V>> wwwwwwwwwwww2 = mo4669castForTesting.Wwwwwwwwwwwwwwwwwwwwww;
            mo4669castForTesting.Wwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwww;
            wwwwwwwwwwww2.clear();
        }
    }

    /* loaded from: classes3.dex */
    public final class Wwwwwwwwww extends AbstractC2272ju<K, V> {
        public V Wwwwwwwwwwwwwwwwwwwwwww;
        public final K Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwww(K k, V v) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = k;
            this.Wwwwwwwwwwwwwwwwwwwwwww = v;
        }

        @Override // me.tvspark.AbstractC2272ju, java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                return this.Wwwwwwwwwwwwwwwwwwwwwwww.equals(entry.getKey()) && this.Wwwwwwwwwwwwwwwwwwwwwww.equals(entry.getValue());
            }
            return false;
        }

        @Override // me.tvspark.AbstractC2272ju, java.util.Map.Entry
        public K getKey() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.AbstractC2272ju, java.util.Map.Entry
        public V getValue() {
            return this.Wwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.AbstractC2272ju, java.util.Map.Entry
        public int hashCode() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww.hashCode() ^ this.Wwwwwwwwwwwwwwwwwwwwwww.hashCode();
        }

        @Override // me.tvspark.AbstractC2272ju, java.util.Map.Entry
        public V setValue(V v) {
            V v2 = (V) MapMakerInternalMap.this.put(this.Wwwwwwwwwwwwwwwwwwwwwwww, v);
            this.Wwwwwwwwwwwwwwwwwwwwwww = v;
            return v2;
        }
    }

    /* loaded from: classes3.dex */
    public static final class Wwwwwwwwwww<K, V, E extends Wwwwwwwwwwwwwwwwwwwwwwwwwww<K, V, E>> extends WeakReference<V> implements Wwwwwwwwwwww<K, V, E> {
        public final E Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwww(ReferenceQueue<V> referenceQueue, V v, E e) {
            super(v, referenceQueue);
            this.Wwwwwwwwwwwwwwwwwwwwwwww = e;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Wwwwwwwwwwww
        public Wwwwwwwwwwww<K, V, E> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ReferenceQueue<V> referenceQueue, E e) {
            return new Wwwwwwwwwww(referenceQueue, get(), e);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Wwwwwwwwwwww
        public E getEntry() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww;
        }
    }

    /* loaded from: classes3.dex */
    public interface Wwwwwwwwwwww<K, V, E extends Wwwwwwwwwwwwwwwwwwwwwwwwwww<K, V, E>> {
        Wwwwwwwwwwww<K, V, E> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ReferenceQueue<V> referenceQueue, E e);

        void clear();

        V get();

        E getEntry();
    }

    /* loaded from: classes3.dex */
    public interface Wwwwwwwwwwwww<K, V, E extends Wwwwwwwwwwwwwwwwwwwwwwwwwww<K, V, E>> extends Wwwwwwwwwwwwwwwwwwwwwwwwwww<K, V, E> {
        Wwwwwwwwwwww<K, V, E> getValueReference();
    }

    /* loaded from: classes3.dex */
    public final class Wwwwwwwwwwwwwwwww extends AbstractCollection<V> {
        public Wwwwwwwwwwwwwwwww() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            MapMakerInternalMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return MapMakerInternalMap.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new Wwwwwwwwwwwwwwwwww(MapMakerInternalMap.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return MapMakerInternalMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return MapMakerInternalMap.toArrayList(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) MapMakerInternalMap.toArrayList(this).toArray(tArr);
        }
    }

    /* loaded from: classes3.dex */
    public final class Wwwwwwwwwwwwwwwwww extends MapMakerInternalMap<K, V, E, S>.Wwwwwwwwwwwwwwwwwwwwwwwwwwww<V> {
        public Wwwwwwwwwwwwwwwwww(MapMakerInternalMap mapMakerInternalMap) {
            super();
        }

        @Override // java.util.Iterator
        public V next() {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwww;
        }
    }

    /* loaded from: classes3.dex */
    public interface Wwwwwwwwwwwwwwwwwww<K, V, E extends Wwwwwwwwwwwwwwwwwwwwwwwwwww<K, V, E>> extends Wwwwwwwwwwwwwwwwwwwwwwwwwww<K, V, E> {
    }

    /* loaded from: classes3.dex */
    public static final class Wwwwwwwwwwwwwwwwwwww<K, V> extends Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V, Wwwwwwwwwwwwwwwwwwww<K, V>> implements Wwwwwwwwwwwww<K, V, Wwwwwwwwwwwwwwwwwwww<K, V>> {
        public volatile Wwwwwwwwwwww<K, V, Wwwwwwwwwwwwwwwwwwww<K, V>> Wwwwwwwwwwwwwwwwwwwww = MapMakerInternalMap.unsetWeakValueReference();

        public Wwwwwwwwwwwwwwwwwwww(K k, int i, Wwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwww) {
            super(k, i, wwwwwwwwwwwwwwwwwwww);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Wwwwwwwwwwwwwwwwwwwwwwwwwww
        public V getValue() {
            return this.Wwwwwwwwwwwwwwwwwwwww.get();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Wwwwwwwwwwwww
        public Wwwwwwwwwwww<K, V, Wwwwwwwwwwwwwwwwwwww<K, V>> getValueReference() {
            return this.Wwwwwwwwwwwwwwwwwwwww;
        }

        /* loaded from: classes3.dex */
        public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> implements Wwwwwwwwwwwwwwwwwwwwwwwwww<K, V, Wwwwwwwwwwwwwwwwwwww<K, V>, StrongKeyWeakValueSegment<K, V>> {
            public static final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?, ?> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<>();

            @Override // com.google.common.collect.MapMakerInternalMap.Wwwwwwwwwwwwwwwwwwwwwwwwww
            public Strength Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
                return Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.Wwwwwwwwwwwwwwwwwwwwwwwwww
            public Strength Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.Wwwwwwwwwwwwwwwwwwwwwwwwww
            public Wwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Segment segment, Wwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwww2) {
                StrongKeyWeakValueSegment strongKeyWeakValueSegment = (StrongKeyWeakValueSegment) segment;
                Wwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwww;
                Wwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwww2 = (Wwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwww2;
                if (Segment.isCollected(wwwwwwwwwwwwwwwwwwww)) {
                    return null;
                }
                ReferenceQueue<V> referenceQueue = strongKeyWeakValueSegment.queueForValues;
                Wwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwww3 = new Wwwwwwwwwwwwwwwwwwww<>(wwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwww2);
                wwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(referenceQueue, wwwwwwwwwwwwwwwwwwww3);
                return wwwwwwwwwwwwwwwwwwww3;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.Wwwwwwwwwwwwwwwwwwwwwwwwww
            public Wwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Segment segment, Object obj, int i, Wwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwww) {
                StrongKeyWeakValueSegment strongKeyWeakValueSegment = (StrongKeyWeakValueSegment) segment;
                return new Wwwwwwwwwwwwwwwwwwww(obj, i, (Wwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwww);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.Wwwwwwwwwwwwwwwwwwwwwwwwww
            public Segment Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(MapMakerInternalMap mapMakerInternalMap, int i, int i2) {
                return new StrongKeyWeakValueSegment(mapMakerInternalMap, i, i2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.Wwwwwwwwwwwwwwwwwwwwwwwwww
            public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Segment segment, Wwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwww, Object obj) {
                Wwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwww;
                ReferenceQueue referenceQueue = ((StrongKeyWeakValueSegment) segment).queueForValues;
                Wwwwwwwwwwww<K, V, Wwwwwwwwwwwwwwwwwwww<K, V>> wwwwwwwwwwww = wwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww;
                wwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwww(referenceQueue, obj, wwwwwwwwwwwwwwwwwwww);
                wwwwwwwwwwww.clear();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwww<K, V> extends Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V, Wwwwwwwwwwwwwwwwwwwww<K, V>> implements Wwwwwwwwwwwwwwwwwww<K, V, Wwwwwwwwwwwwwwwwwwwww<K, V>> {
        public volatile V Wwwwwwwwwwwwwwwwwwwww = null;

        /* loaded from: classes3.dex */
        public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> implements Wwwwwwwwwwwwwwwwwwwwwwwwww<K, V, Wwwwwwwwwwwwwwwwwwwww<K, V>, StrongKeyStrongValueSegment<K, V>> {
            public static final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?, ?> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<>();

            @Override // com.google.common.collect.MapMakerInternalMap.Wwwwwwwwwwwwwwwwwwwwwwwwww
            public Strength Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.Wwwwwwwwwwwwwwwwwwwwwwwwww
            public Strength Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.Wwwwwwwwwwwwwwwwwwwwwwwwww
            public Wwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Segment segment, Wwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwww2) {
                StrongKeyStrongValueSegment strongKeyStrongValueSegment = (StrongKeyStrongValueSegment) segment;
                Wwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwww;
                Wwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwww2 = new Wwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww, (Wwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwww2);
                wwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww;
                return wwwwwwwwwwwwwwwwwwwww2;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.Wwwwwwwwwwwwwwwwwwwwwwwwww
            public Wwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Segment segment, Object obj, int i, Wwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwww) {
                StrongKeyStrongValueSegment strongKeyStrongValueSegment = (StrongKeyStrongValueSegment) segment;
                return new Wwwwwwwwwwwwwwwwwwwww(obj, i, (Wwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwww);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.Wwwwwwwwwwwwwwwwwwwwwwwwww
            public Segment Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(MapMakerInternalMap mapMakerInternalMap, int i, int i2) {
                return new StrongKeyStrongValueSegment(mapMakerInternalMap, i, i2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.MapMakerInternalMap.Wwwwwwwwwwwwwwwwwwwwwwwwww
            public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Segment segment, Wwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwww, Object obj) {
                StrongKeyStrongValueSegment strongKeyStrongValueSegment = (StrongKeyStrongValueSegment) segment;
                ((Wwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwww = obj;
            }
        }

        public Wwwwwwwwwwwwwwwwwwwww(K k, int i, Wwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwww) {
            super(k, i, wwwwwwwwwwwwwwwwwwwww);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Wwwwwwwwwwwwwwwwwwwwwwwwwww
        public V getValue() {
            return this.Wwwwwwwwwwwwwwwwwwwww;
        }
    }

    /* loaded from: classes3.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwww<K> extends Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, MapMaker.Dummy, Wwwwwwwwwwwwwwwwwwwwww<K>> implements Wwwwwwwwwwwwwwwwwww<K, MapMaker.Dummy, Wwwwwwwwwwwwwwwwwwwwww<K>> {

        /* loaded from: classes3.dex */
        public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K> implements Wwwwwwwwwwwwwwwwwwwwwwwwww<K, MapMaker.Dummy, Wwwwwwwwwwwwwwwwwwwwww<K>, StrongKeyDummyValueSegment<K>> {
            public static final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<>();

            @Override // com.google.common.collect.MapMakerInternalMap.Wwwwwwwwwwwwwwwwwwwwwwwwww
            public Strength Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.Wwwwwwwwwwwwwwwwwwwwwwwwww
            public Strength Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.Wwwwwwwwwwwwwwwwwwwwwwwwww
            public Wwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Segment segment, Wwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwww2) {
                StrongKeyDummyValueSegment strongKeyDummyValueSegment = (StrongKeyDummyValueSegment) segment;
                Wwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwww;
                return new Wwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww, (Wwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwww2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.Wwwwwwwwwwwwwwwwwwwwwwwwww
            public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Segment segment, Wwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwww, MapMaker.Dummy dummy) {
                StrongKeyDummyValueSegment strongKeyDummyValueSegment = (StrongKeyDummyValueSegment) segment;
                Wwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwww;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.Wwwwwwwwwwwwwwwwwwwwwwwwww
            public Wwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Segment segment, Object obj, int i, Wwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwww) {
                StrongKeyDummyValueSegment strongKeyDummyValueSegment = (StrongKeyDummyValueSegment) segment;
                return new Wwwwwwwwwwwwwwwwwwwwww(obj, i, (Wwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwww);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.Wwwwwwwwwwwwwwwwwwwwwwwwww
            public Segment Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(MapMakerInternalMap mapMakerInternalMap, int i, int i2) {
                return new StrongKeyDummyValueSegment(mapMakerInternalMap, i, i2);
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwww(K k, int i, Wwwwwwwwwwwwwwwwwwwwww<K> wwwwwwwwwwwwwwwwwwwwww) {
            super(k, i, wwwwwwwwwwwwwwwwwwwwww);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Wwwwwwwwwwwwwwwwwwwwwwwwwww
        public Object getValue() {
            return MapMaker.Dummy.VALUE;
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class Wwwwwwwwwwwwwwwwwwwwwww<E> extends AbstractSet<E> {
        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return MapMakerInternalMap.toArrayList(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) MapMakerInternalMap.toArrayList(this).toArray(tArr);
        }
    }

    /* loaded from: classes3.dex */
    public final class Wwwwwwwwwwwwwwwwwwwwwwww extends Wwwwwwwwwwwwwwwwwwwwwww<K> {
        public Wwwwwwwwwwwwwwwwwwwwwwww() {
            super(null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            MapMakerInternalMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return MapMakerInternalMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new Wwwwwwwwwwwwwwwwwwwwwwwww(MapMakerInternalMap.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return MapMakerInternalMap.this.remove(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return MapMakerInternalMap.this.size();
        }
    }

    /* loaded from: classes3.dex */
    public final class Wwwwwwwwwwwwwwwwwwwwwwwww extends MapMakerInternalMap<K, V, E, S>.Wwwwwwwwwwwwwwwwwwwwwwwwwwww<K> {
        public Wwwwwwwwwwwwwwwwwwwwwwwww(MapMakerInternalMap mapMakerInternalMap) {
            super();
        }

        @Override // java.util.Iterator
        public K next() {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwww;
        }
    }

    /* loaded from: classes3.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwww<K, V, E extends Wwwwwwwwwwwwwwwwwwwwwwwwwww<K, V, E>, S extends Segment<K, V, E, S>> {
        Strength Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

        S Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(MapMakerInternalMap<K, V, E, S> mapMakerInternalMap, int i, int i2);

        Strength Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

        E Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(S s, E e, E e2);

        E Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(S s, K k, int i, E e);

        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(S s, E e, V v);
    }

    /* loaded from: classes3.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwww<K, V, E extends Wwwwwwwwwwwwwwwwwwwwwwwwwww<K, V, E>> {
        int getHash();

        K getKey();

        E getNext();

        V getValue();
    }

    /* loaded from: classes3.dex */
    public abstract class Wwwwwwwwwwwwwwwwwwwwwwwwwwww<T> implements Iterator<T> {
        public MapMakerInternalMap<K, V, E, S>.Wwwwwwwwww Wwwwwwwwwwwwwwwwww;
        public MapMakerInternalMap<K, V, E, S>.Wwwwwwwwww Wwwwwwwwwwwwwwwwwww;
        public E Wwwwwwwwwwwwwwwwwwww;
        public AtomicReferenceArray<E> Wwwwwwwwwwwwwwwwwwwww;
        public Segment<K, V, E, S> Wwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwww = -1;
        public int Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = MapMakerInternalMap.this.segments.length - 1;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }

        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            while (true) {
                int i = this.Wwwwwwwwwwwwwwwwwwwwwww;
                if (i >= 0) {
                    AtomicReferenceArray<E> atomicReferenceArray = this.Wwwwwwwwwwwwwwwwwwwww;
                    this.Wwwwwwwwwwwwwwwwwwwwwww = i - 1;
                    E e = atomicReferenceArray.get(i);
                    this.Wwwwwwwwwwwwwwwwwwww = e;
                    if (e != null && (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(e) || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww())) {
                        return true;
                    }
                } else {
                    return false;
                }
            }
        }

        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            E e = this.Wwwwwwwwwwwwwwwwwwww;
            if (e != null) {
                while (true) {
                    this.Wwwwwwwwwwwwwwwwwwww = (E) e.getNext();
                    E e2 = this.Wwwwwwwwwwwwwwwwwwww;
                    if (e2 == null) {
                        return false;
                    }
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(e2)) {
                        return true;
                    }
                    e = this.Wwwwwwwwwwwwwwwwwwww;
                }
            } else {
                return false;
            }
        }

        public MapMakerInternalMap<K, V, E, S>.Wwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            MapMakerInternalMap<K, V, E, S>.Wwwwwwwwww wwwwwwwwww = this.Wwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwww != null) {
                this.Wwwwwwwwwwwwwwwwww = wwwwwwwwww;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                return this.Wwwwwwwwwwwwwwwwww;
            }
            throw new NoSuchElementException();
        }

        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            this.Wwwwwwwwwwwwwwwwwww = null;
            if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() && !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                while (true) {
                    int i = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                    if (i < 0) {
                        return;
                    }
                    Segment<K, V, E, S>[] segmentArr = MapMakerInternalMap.this.segments;
                    this.Wwwwwwwwwwwwwwwwwwwwwwww = i - 1;
                    Segment<K, V, E, S> segment = segmentArr[i];
                    this.Wwwwwwwwwwwwwwwwwwwwww = segment;
                    if (segment.count != 0) {
                        AtomicReferenceArray<E> atomicReferenceArray = this.Wwwwwwwwwwwwwwwwwwwwww.table;
                        this.Wwwwwwwwwwwwwwwwwwwww = atomicReferenceArray;
                        this.Wwwwwwwwwwwwwwwwwwwwwww = atomicReferenceArray.length() - 1;
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                            return;
                        }
                    }
                }
            }
        }

        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(E e) {
            boolean z;
            try {
                Object key = e.getKey();
                Object liveValue = MapMakerInternalMap.this.getLiveValue(e);
                if (liveValue != null) {
                    this.Wwwwwwwwwwwwwwwwwww = new Wwwwwwwwww(key, liveValue);
                    z = true;
                } else {
                    z = false;
                }
                return z;
            } finally {
                this.Wwwwwwwwwwwwwwwwwwwwww.postReadCleanup();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.Wwwwwwwwwwwwwwwwwww != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwww != null, "no calls to next() since the last call to remove()");
            MapMakerInternalMap.this.remove(this.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwww = null;
        }
    }

    /* loaded from: classes3.dex */
    public final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwww extends Wwwwwwwwwwwwwwwwwwwwwww<Map.Entry<K, V>> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            super(null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            MapMakerInternalMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry;
            Object key;
            Object obj2;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (obj2 = MapMakerInternalMap.this.get(key)) != null && MapMakerInternalMap.this.valueEquivalence().equivalent(entry.getValue(), obj2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(MapMakerInternalMap.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry;
            Object key;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && MapMakerInternalMap.this.remove(key, entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return MapMakerInternalMap.this.size();
        }
    }

    /* loaded from: classes3.dex */
    public final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends MapMakerInternalMap<K, V, E, S>.Wwwwwwwwwwwwwwwwwwwwwwwwwwww<Map.Entry<K, V>> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(MapMakerInternalMap mapMakerInternalMap) {
            super();
        }

        @Override // java.util.Iterator
        public Object next() {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    /* loaded from: classes3.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Wwwwwwwwwwwwwwwwwwwwwwwwwww<Object, Object, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Wwwwwwwwwwwwwwwwwwwwwwwwwww
        public int getHash() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Wwwwwwwwwwwwwwwwwwwwwwwwwww
        public Object getKey() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Wwwwwwwwwwwwwwwwwwwwwwwwwww
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww getNext() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Wwwwwwwwwwwwwwwwwwwwwwwwwww
        public Object getValue() {
            throw new AssertionError();
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V, E extends Wwwwwwwwwwwwwwwwwwwwwwwwwww<K, V, E>> extends WeakReference<K> implements Wwwwwwwwwwwwwwwwwwwwwwwwwww<K, V, E> {
        public final E Wwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ReferenceQueue<K> referenceQueue, K k, int i, E e) {
            super(k, referenceQueue);
            this.Wwwwwwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwwwwwwwww = e;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Wwwwwwwwwwwwwwwwwwwwwwwwwww
        public int getHash() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Wwwwwwwwwwwwwwwwwwwwwwwwwww
        public K getKey() {
            return get();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Wwwwwwwwwwwwwwwwwwwwwwwwwww
        public E getNext() {
            return this.Wwwwwwwwwwwwwwwwwwwwwww;
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V, E extends Wwwwwwwwwwwwwwwwwwwwwwwwwww<K, V, E>> implements Wwwwwwwwwwwwwwwwwwwwwwwwwww<K, V, E> {
        public final E Wwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwww;
        public final K Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(K k, int i, E e) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = k;
            this.Wwwwwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwwwwwwww = e;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Wwwwwwwwwwwwwwwwwwwwwwwwwww
        public int getHash() {
            return this.Wwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Wwwwwwwwwwwwwwwwwwwwwwwwwww
        public K getKey() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Wwwwwwwwwwwwwwwwwwwwwwwwwww
        public E getNext() {
            return this.Wwwwwwwwwwwwwwwwwwwwww;
        }
    }

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Wwwwwwwwwwww<Object, Object, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> {
        @Override // com.google.common.collect.MapMakerInternalMap.Wwwwwwwwwwww
        public Wwwwwwwwwwww<Object, Object, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ReferenceQueue<Object> referenceQueue, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Wwwwwwwwwwww
        public void clear() {
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Wwwwwwwwwwww
        public Object get() {
            return null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Wwwwwwwwwwww
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww getEntry() {
            return null;
        }
    }

    public MapMakerInternalMap(MapMaker mapMaker, Wwwwwwwwwwwwwwwwwwwwwwwwww<K, V, E, S> wwwwwwwwwwwwwwwwwwwwwwwwww) {
        int i = mapMaker.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.concurrencyLevel = Math.min(i == -1 ? 4 : i, 65536);
        this.keyEquivalence = (Equivalence) Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mapMaker.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, mapMaker.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().defaultEquivalence());
        this.entryHelper = wwwwwwwwwwwwwwwwwwwwwwwwww;
        int i2 = mapMaker.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int min = Math.min(i2 == -1 ? 16 : i2, 1073741824);
        int i3 = 0;
        int i4 = 1;
        int i5 = 1;
        int i6 = 0;
        while (i5 < this.concurrencyLevel) {
            i6++;
            i5 <<= 1;
        }
        this.segmentShift = 32 - i6;
        this.segmentMask = i5 - 1;
        this.segments = newSegmentArray(i5);
        int i7 = min / i5;
        while (i4 < (i5 * i7 < min ? i7 + 1 : i7)) {
            i4 <<= 1;
        }
        while (true) {
            Segment<K, V, E, S>[] segmentArr = this.segments;
            if (i3 < segmentArr.length) {
                segmentArr[i3] = createSegment(i4, -1);
                i3++;
            } else {
                return;
            }
        }
    }

    public static <K, V> MapMakerInternalMap<K, V, ? extends Wwwwwwwwwwwwwwwwwwwwwwwwwww<K, V, ?>, ?> create(MapMaker mapMaker) {
        if (mapMaker.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == Strength.STRONG && mapMaker.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == Strength.STRONG) {
            return new MapMakerInternalMap<>(mapMaker, Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        if (mapMaker.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == Strength.STRONG && mapMaker.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == Strength.WEAK) {
            return new MapMakerInternalMap<>(mapMaker, Wwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        if (mapMaker.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == Strength.WEAK && mapMaker.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == Strength.STRONG) {
            return new MapMakerInternalMap<>(mapMaker, Wwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        if (mapMaker.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() != Strength.WEAK || mapMaker.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() != Strength.WEAK) {
            throw new AssertionError();
        }
        return new MapMakerInternalMap<>(mapMaker, Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public static <K> MapMakerInternalMap<K, MapMaker.Dummy, ? extends Wwwwwwwwwwwwwwwwwwwwwwwwwww<K, MapMaker.Dummy, ?>, ?> createWithDummyValues(MapMaker mapMaker) {
        if (mapMaker.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == Strength.STRONG && mapMaker.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == Strength.STRONG) {
            return new MapMakerInternalMap<>(mapMaker, Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        if (mapMaker.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == Strength.WEAK && mapMaker.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == Strength.STRONG) {
            return new MapMakerInternalMap<>(mapMaker, Wwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        if (mapMaker.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() != Strength.WEAK) {
            throw new AssertionError();
        }
        throw new IllegalArgumentException("Map cannot have both weak and dummy values");
    }

    public static int rehash(int i) {
        int i2 = i + ((i << 15) ^ (-12931));
        int i3 = i2 ^ (i2 >>> 10);
        int i4 = i3 + (i3 << 3);
        int i5 = i4 ^ (i4 >>> 6);
        int i6 = (i5 << 2) + (i5 << 14) + i5;
        return (i6 >>> 16) ^ i6;
    }

    public static <E> ArrayList<E> toArrayList(Collection<E> collection) {
        ArrayList<E> arrayList = new ArrayList<>(collection.size());
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Collection) arrayList, (Iterator) collection.iterator());
        return arrayList;
    }

    public static <K, V, E extends Wwwwwwwwwwwwwwwwwwwwwwwwwww<K, V, E>> Wwwwwwwwwwww<K, V, E> unsetWeakValueReference() {
        return (Wwwwwwwwwwww<K, V, E>) UNSET_WEAK_VALUE_REFERENCE;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        for (Segment<K, V, E, S> segment : this.segments) {
            segment.clear();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        if (obj == null) {
            return false;
        }
        int hash = hash(obj);
        return segmentFor(hash).containsKey(obj, hash);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        if (obj == null) {
            return false;
        }
        Segment<K, V, E, S>[] segmentArr = this.segments;
        long j = -1;
        int i = 0;
        while (i < 3) {
            long j2 = 0;
            for (WeakKeyWeakValueSegment weakKeyWeakValueSegment : segmentArr) {
                int i2 = weakKeyWeakValueSegment.count;
                AtomicReferenceArray<E> atomicReferenceArray = weakKeyWeakValueSegment.table;
                for (int i3 = 0; i3 < atomicReferenceArray.length(); i3++) {
                    for (E e = atomicReferenceArray.get(i3); e != null; e = e.getNext()) {
                        Object liveValue = weakKeyWeakValueSegment.getLiveValue(e);
                        if (liveValue != null && valueEquivalence().equivalent(obj, liveValue)) {
                            return true;
                        }
                    }
                }
                j2 += weakKeyWeakValueSegment.modCount;
            }
            if (j2 == j) {
                return false;
            }
            i++;
            j = j2;
        }
        return false;
    }

    public E copyEntry(E e, E e2) {
        return segmentFor(e.getHash()).copyEntry(e, e2);
    }

    public Segment<K, V, E, S> createSegment(int i, int i2) {
        return (S) this.entryHelper.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, i, i2);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.entrySet = wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        return wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        if (obj == null) {
            return null;
        }
        int hash = hash(obj);
        return segmentFor(hash).get(obj, hash);
    }

    public E getEntry(Object obj) {
        if (obj == null) {
            return null;
        }
        int hash = hash(obj);
        return segmentFor(hash).getEntry(obj, hash);
    }

    public V getLiveValue(E e) {
        V v;
        if (e.getKey() == null || (v = (V) e.getValue()) == null) {
            return null;
        }
        return v;
    }

    public int hash(Object obj) {
        return rehash(this.keyEquivalence.hash(obj));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        Segment<K, V, E, S>[] segmentArr = this.segments;
        long j = 0;
        for (int i = 0; i < segmentArr.length; i++) {
            if (segmentArr[i].count != 0) {
                return false;
            }
            j += segmentArr[i].modCount;
        }
        if (j != 0) {
            for (int i2 = 0; i2 < segmentArr.length; i2++) {
                if (segmentArr[i2].count != 0) {
                    return false;
                }
                j -= segmentArr[i2].modCount;
            }
            return j == 0;
        }
        return true;
    }

    public boolean isLiveForTesting(Wwwwwwwwwwwwwwwwwwwwwwwwwww<K, V, ?> wwwwwwwwwwwwwwwwwwwwwwwwwww) {
        return segmentFor(wwwwwwwwwwwwwwwwwwwwwwwwwww.getHash()).getLiveValueForTesting(wwwwwwwwwwwwwwwwwwwwwwwwwww) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set != null) {
            return set;
        }
        Wwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwww();
        this.keySet = wwwwwwwwwwwwwwwwwwwwwwww;
        return wwwwwwwwwwwwwwwwwwwwwwww;
    }

    public Strength keyStrength() {
        return this.entryHelper.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public final Segment<K, V, E, S>[] newSegmentArray(int i) {
        return new Segment[i];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        if (k != null) {
            if (v == null) {
                throw null;
            }
            int hash = hash(k);
            return segmentFor(hash).put(k, hash, v, false);
        }
        throw null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V putIfAbsent(K k, V v) {
        if (k != null) {
            if (v == null) {
                throw null;
            }
            int hash = hash(k);
            return segmentFor(hash).put(k, hash, v, true);
        }
        throw null;
    }

    public void reclaimKey(E e) {
        int hash = e.getHash();
        segmentFor(hash).reclaimKey(e, hash);
    }

    public void reclaimValue(Wwwwwwwwwwww<K, V, E> wwwwwwwwwwww) {
        E entry = wwwwwwwwwwww.getEntry();
        int hash = entry.getHash();
        segmentFor(hash).reclaimValue((K) entry.getKey(), hash, wwwwwwwwwwww);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        if (obj == null) {
            return null;
        }
        int hash = hash(obj);
        return segmentFor(hash).remove(obj, hash);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean remove(Object obj, Object obj2) {
        if (obj == null || obj2 == null) {
            return false;
        }
        int hash = hash(obj);
        return segmentFor(hash).remove(obj, hash, obj2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V replace(K k, V v) {
        if (k != null) {
            if (v == null) {
                throw null;
            }
            int hash = hash(k);
            return segmentFor(hash).replace(k, hash, v);
        }
        throw null;
    }

    public Segment<K, V, E, S> segmentFor(int i) {
        return this.segments[(i >>> this.segmentShift) & this.segmentMask];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        long j = 0;
        for (Segment<K, V, E, S> segment : this.segments) {
            j += segment.count;
        }
        return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j);
    }

    public Equivalence<Object> valueEquivalence() {
        return this.entryHelper.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().defaultEquivalence();
    }

    public Strength valueStrength() {
        return this.entryHelper.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.values;
        if (collection != null) {
            return collection;
        }
        Wwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwww();
        this.values = wwwwwwwwwwwwwwwww;
        return wwwwwwwwwwwwwwwww;
    }

    public Object writeReplace() {
        return new SerializationProxy(this.entryHelper.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), this.entryHelper.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), this.keyEquivalence, this.entryHelper.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().defaultEquivalence(), this.concurrencyLevel, this);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean replace(K k, V v, V v2) {
        if (k != null) {
            if (v2 == null) {
                throw null;
            }
            if (v == null) {
                return false;
            }
            int hash = hash(k);
            return segmentFor(hash).replace(k, hash, v, v2);
        }
        throw null;
    }

    /* loaded from: classes3.dex */
    public static final class Wwwwwwwwwwwwww<K, V> extends Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V, Wwwwwwwwwwwwww<K, V>> implements Wwwwwwwwwwwww<K, V, Wwwwwwwwwwwwww<K, V>> {
        public volatile Wwwwwwwwwwww<K, V, Wwwwwwwwwwwwww<K, V>> Wwwwwwwwwwwwwwwwwwwwww = MapMakerInternalMap.unsetWeakValueReference();

        public Wwwwwwwwwwwwww(ReferenceQueue<K> referenceQueue, K k, int i, Wwwwwwwwwwwwww<K, V> wwwwwwwwwwwwww) {
            super(referenceQueue, k, i, wwwwwwwwwwwwww);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Wwwwwwwwwwwwwwwwwwwwwwwwwww
        public V getValue() {
            return this.Wwwwwwwwwwwwwwwwwwwwww.get();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Wwwwwwwwwwwww
        public Wwwwwwwwwwww<K, V, Wwwwwwwwwwwwww<K, V>> getValueReference() {
            return this.Wwwwwwwwwwwwwwwwwwwwww;
        }

        /* loaded from: classes3.dex */
        public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> implements Wwwwwwwwwwwwwwwwwwwwwwwwww<K, V, Wwwwwwwwwwwwww<K, V>, WeakKeyWeakValueSegment<K, V>> {
            public static final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?, ?> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<>();

            @Override // com.google.common.collect.MapMakerInternalMap.Wwwwwwwwwwwwwwwwwwwwwwwwww
            public Strength Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
                return Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.Wwwwwwwwwwwwwwwwwwwwwwwwww
            public Strength Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
                return Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.Wwwwwwwwwwwwwwwwwwwwwwwwww
            public Wwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Segment segment, Wwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwww2) {
                WeakKeyWeakValueSegment weakKeyWeakValueSegment = (WeakKeyWeakValueSegment) segment;
                Wwwwwwwwwwwwww wwwwwwwwwwwwww = (Wwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwww;
                Wwwwwwwwwwwwww wwwwwwwwwwwwww2 = (Wwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwww2;
                if (wwwwwwwwwwwwww.get() != null && !Segment.isCollected(wwwwwwwwwwwwww)) {
                    ReferenceQueue referenceQueue = weakKeyWeakValueSegment.queueForKeys;
                    ReferenceQueue<V> referenceQueue2 = weakKeyWeakValueSegment.queueForValues;
                    Wwwwwwwwwwwwww<K, V> wwwwwwwwwwwwww3 = new Wwwwwwwwwwwwww<>(referenceQueue, wwwwwwwwwwwwww.get(), wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwww2);
                    wwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(referenceQueue2, wwwwwwwwwwwwww3);
                    return wwwwwwwwwwwwww3;
                }
                return null;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.Wwwwwwwwwwwwwwwwwwwwwwwwww
            public Wwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Segment segment, Object obj, int i, Wwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwww) {
                return new Wwwwwwwwwwwwww(((WeakKeyWeakValueSegment) segment).queueForKeys, obj, i, (Wwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwww);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.Wwwwwwwwwwwwwwwwwwwwwwwwww
            public Segment Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(MapMakerInternalMap mapMakerInternalMap, int i, int i2) {
                return new WeakKeyWeakValueSegment(mapMakerInternalMap, i, i2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.Wwwwwwwwwwwwwwwwwwwwwwwwww
            public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Segment segment, Wwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwww, Object obj) {
                Wwwwwwwwwwwwww wwwwwwwwwwwwww = (Wwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwww;
                ReferenceQueue referenceQueue = ((WeakKeyWeakValueSegment) segment).queueForValues;
                Wwwwwwwwwwww<K, V, Wwwwwwwwwwwwww<K, V>> wwwwwwwwwwww = wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww;
                wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwww(referenceQueue, obj, wwwwwwwwwwwwww);
                wwwwwwwwwwww.clear();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class Wwwwwwwwwwwwwwww<K> extends Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, MapMaker.Dummy, Wwwwwwwwwwwwwwww<K>> implements Wwwwwwwwwwwwwwwwwww<K, MapMaker.Dummy, Wwwwwwwwwwwwwwww<K>> {
        public Wwwwwwwwwwwwwwww(ReferenceQueue<K> referenceQueue, K k, int i, Wwwwwwwwwwwwwwww<K> wwwwwwwwwwwwwwww) {
            super(referenceQueue, k, i, wwwwwwwwwwwwwwww);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Wwwwwwwwwwwwwwwwwwwwwwwwwww
        public Object getValue() {
            return MapMaker.Dummy.VALUE;
        }

        /* loaded from: classes3.dex */
        public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K> implements Wwwwwwwwwwwwwwwwwwwwwwwwww<K, MapMaker.Dummy, Wwwwwwwwwwwwwwww<K>, WeakKeyDummyValueSegment<K>> {
            public static final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<>();

            @Override // com.google.common.collect.MapMakerInternalMap.Wwwwwwwwwwwwwwwwwwwwwwwwww
            public Strength Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.Wwwwwwwwwwwwwwwwwwwwwwwwww
            public Strength Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
                return Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.Wwwwwwwwwwwwwwwwwwwwwwwwww
            public Wwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Segment segment, Wwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwww2) {
                WeakKeyDummyValueSegment weakKeyDummyValueSegment = (WeakKeyDummyValueSegment) segment;
                Wwwwwwwwwwwwwwww wwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwww;
                Wwwwwwwwwwwwwwww wwwwwwwwwwwwwwww2 = (Wwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwww2;
                if (wwwwwwwwwwwwwwww.get() == null) {
                    return null;
                }
                return new Wwwwwwwwwwwwwwww(weakKeyDummyValueSegment.queueForKeys, wwwwwwwwwwwwwwww.get(), wwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwww2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.Wwwwwwwwwwwwwwwwwwwwwwwwww
            public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Segment segment, Wwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwww, MapMaker.Dummy dummy) {
                WeakKeyDummyValueSegment weakKeyDummyValueSegment = (WeakKeyDummyValueSegment) segment;
                Wwwwwwwwwwwwwwww wwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwww;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.Wwwwwwwwwwwwwwwwwwwwwwwwww
            public Wwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Segment segment, Object obj, int i, Wwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwww) {
                return new Wwwwwwwwwwwwwwww(((WeakKeyDummyValueSegment) segment).queueForKeys, obj, i, (Wwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwww);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.Wwwwwwwwwwwwwwwwwwwwwwwwww
            public Segment Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(MapMakerInternalMap mapMakerInternalMap, int i, int i2) {
                return new WeakKeyDummyValueSegment(mapMakerInternalMap, i, i2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class Wwwwwwwwwwwwwww<K, V> extends Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V, Wwwwwwwwwwwwwww<K, V>> implements Wwwwwwwwwwwwwwwwwww<K, V, Wwwwwwwwwwwwwww<K, V>> {
        public volatile V Wwwwwwwwwwwwwwwwwwwwww = null;

        public Wwwwwwwwwwwwwww(ReferenceQueue<K> referenceQueue, K k, int i, Wwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwww) {
            super(referenceQueue, k, i, wwwwwwwwwwwwwww);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Wwwwwwwwwwwwwwwwwwwwwwwwwww
        public V getValue() {
            return this.Wwwwwwwwwwwwwwwwwwwwww;
        }

        /* loaded from: classes3.dex */
        public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> implements Wwwwwwwwwwwwwwwwwwwwwwwwww<K, V, Wwwwwwwwwwwwwww<K, V>, WeakKeyStrongValueSegment<K, V>> {
            public static final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?, ?> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<>();

            @Override // com.google.common.collect.MapMakerInternalMap.Wwwwwwwwwwwwwwwwwwwwwwwwww
            public Strength Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.Wwwwwwwwwwwwwwwwwwwwwwwwww
            public Strength Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
                return Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.Wwwwwwwwwwwwwwwwwwwwwwwwww
            public Wwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Segment segment, Wwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwww2) {
                WeakKeyStrongValueSegment weakKeyStrongValueSegment = (WeakKeyStrongValueSegment) segment;
                Wwwwwwwwwwwwwww wwwwwwwwwwwwwww = (Wwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwww;
                Wwwwwwwwwwwwwww wwwwwwwwwwwwwww2 = (Wwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwww2;
                if (wwwwwwwwwwwwwww.get() == null) {
                    return null;
                }
                Wwwwwwwwwwwwwww wwwwwwwwwwwwwww3 = new Wwwwwwwwwwwwwww(weakKeyStrongValueSegment.queueForKeys, wwwwwwwwwwwwwww.get(), wwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwww2);
                wwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww;
                return wwwwwwwwwwwwwww3;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.Wwwwwwwwwwwwwwwwwwwwwwwwww
            public Wwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Segment segment, Object obj, int i, Wwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwww) {
                return new Wwwwwwwwwwwwwww(((WeakKeyStrongValueSegment) segment).queueForKeys, obj, i, (Wwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwww);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.Wwwwwwwwwwwwwwwwwwwwwwwwww
            public Segment Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(MapMakerInternalMap mapMakerInternalMap, int i, int i2) {
                return new WeakKeyStrongValueSegment(mapMakerInternalMap, i, i2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.MapMakerInternalMap.Wwwwwwwwwwwwwwwwwwwwwwwwww
            public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Segment segment, Wwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwww, Object obj) {
                WeakKeyStrongValueSegment weakKeyStrongValueSegment = (WeakKeyStrongValueSegment) segment;
                ((Wwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwww = obj;
            }
        }
    }
}
