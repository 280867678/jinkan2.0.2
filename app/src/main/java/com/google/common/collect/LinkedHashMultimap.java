package com.google.common.collect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import me.tvspark.AbstractC2090ex;
import me.tvspark.AbstractC2651tx;
import me.tvspark.AbstractC2876zw;
import me.tvspark.C2163gw;
import me.tvspark.C2763wu;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public final class LinkedHashMultimap<K, V> extends LinkedHashMultimapGwtSerializationDependencies<K, V> {
    public static final int DEFAULT_KEY_CAPACITY = 16;
    public static final int DEFAULT_VALUE_SET_CAPACITY = 2;
    public static final double VALUE_SET_LOAD_FACTOR = 1.0d;
    public static final long serialVersionUID = 1;
    public transient ValueEntry<K, V> multimapHeaderEntry;
    public transient int valueSetCapacity;

    /* loaded from: classes3.dex */
    public static final class ValueEntry<K, V> extends ImmutableEntry<K, V> implements Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> {
        public ValueEntry<K, V> nextInValueBucket;
        public ValueEntry<K, V> predecessorInMultimap;
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> predecessorInValueSet;
        public final int smearedValueHash;
        public ValueEntry<K, V> successorInMultimap;
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> successorInValueSet;

        public ValueEntry(K k, V v, int i, ValueEntry<K, V> valueEntry) {
            super(k, v);
            this.smearedValueHash = i;
            this.nextInValueBucket = valueEntry;
        }

        public ValueEntry<K, V> getPredecessorInMultimap() {
            return this.predecessorInMultimap;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> getPredecessorInValueSet() {
            return this.predecessorInValueSet;
        }

        public ValueEntry<K, V> getSuccessorInMultimap() {
            return this.successorInMultimap;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> getSuccessorInValueSet() {
            return this.successorInValueSet;
        }

        public boolean matchesValue(Object obj, int i) {
            return this.smearedValueHash == i && Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getValue(), obj);
        }

        public void setPredecessorInMultimap(ValueEntry<K, V> valueEntry) {
            this.predecessorInMultimap = valueEntry;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void setPredecessorInValueSet(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.predecessorInValueSet = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        public void setSuccessorInMultimap(ValueEntry<K, V> valueEntry) {
            this.successorInMultimap = valueEntry;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void setSuccessorInValueSet(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.successorInValueSet = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
    }

    /* loaded from: classes3.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> getPredecessorInValueSet();

        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> getSuccessorInValueSet();

        void setPredecessorInValueSet(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);

        void setSuccessorInValueSet(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    /* loaded from: classes3.dex */
    public final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2651tx<V> implements Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> {
        public ValueEntry<K, V>[] Wwwwwwwwwwwwwwwwwwwwwww;
        public final K Wwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwww = 0;
        public int Wwwwwwwwwwwwwwwwwwwww = 0;
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> Wwwwwwwwwwwwwwwwwwww = this;
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> Wwwwwwwwwwwwwwwwwww = this;

        /* loaded from: classes3.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Iterator<V> {
            public int Wwwwwwwwwwwwwwwwwwwwww;
            public ValueEntry<K, V> Wwwwwwwwwwwwwwwwwwwwwww;
            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> Wwwwwwwwwwwwwwwwwwwwwwww;

            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this;
                this.Wwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww;
                this.Wwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this;
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww == this.Wwwwwwwwwwwwwwwwwwwwww) {
                    return this.Wwwwwwwwwwwwwwwwwwwwwwww != wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                }
                throw new ConcurrentModificationException();
            }

            @Override // java.util.Iterator
            public V next() {
                if (hasNext()) {
                    ValueEntry<K, V> valueEntry = (ValueEntry) this.Wwwwwwwwwwwwwwwwwwwwwwww;
                    V value = valueEntry.getValue();
                    this.Wwwwwwwwwwwwwwwwwwwwwww = valueEntry;
                    this.Wwwwwwwwwwwwwwwwwwwwwwww = valueEntry.getSuccessorInValueSet();
                    return value;
                }
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public void remove() {
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwww == this.Wwwwwwwwwwwwwwwwwwwwww) {
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww != null, "no calls to next() since the last call to remove()");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.remove(this.Wwwwwwwwwwwwwwwwwwwwwww.getValue());
                    this.Wwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwww;
                    this.Wwwwwwwwwwwwwwwwwwwwwww = null;
                    return;
                }
                throw new ConcurrentModificationException();
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(K k, int i) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = k;
            this.Wwwwwwwwwwwwwwwwwwwwwww = new ValueEntry[Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, 1.0d)];
        }

        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return this.Wwwwwwwwwwwwwwwwwwwwwww.length - 1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(V v) {
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(v);
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() & Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            ValueEntry<K, V> valueEntry = this.Wwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2];
            ValueEntry<K, V> valueEntry2 = valueEntry;
            while (true) {
                boolean z = false;
                if (valueEntry2 == null) {
                    ValueEntry<K, V> valueEntry3 = new ValueEntry<>(this.Wwwwwwwwwwwwwwwwwwwwwwww, v, Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, valueEntry);
                    LinkedHashMultimap.succeedsInValueSet(this.Wwwwwwwwwwwwwwwwwww, valueEntry3);
                    LinkedHashMultimap.succeedsInValueSet(valueEntry3, this);
                    LinkedHashMultimap.succeedsInMultimap(LinkedHashMultimap.this.multimapHeaderEntry.getPredecessorInMultimap(), valueEntry3);
                    LinkedHashMultimap.succeedsInMultimap(valueEntry3, LinkedHashMultimap.this.multimapHeaderEntry);
                    ValueEntry<K, V>[] valueEntryArr = this.Wwwwwwwwwwwwwwwwwwwwwww;
                    valueEntryArr[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2] = valueEntry3;
                    int i = this.Wwwwwwwwwwwwwwwwwwwwww + 1;
                    this.Wwwwwwwwwwwwwwwwwwwwww = i;
                    this.Wwwwwwwwwwwwwwwwwwwww++;
                    int length = valueEntryArr.length;
                    if (i > length * 1.0d && length < 1073741824) {
                        z = true;
                    }
                    if (z) {
                        int length2 = this.Wwwwwwwwwwwwwwwwwwwwwww.length * 2;
                        ValueEntry<K, V>[] valueEntryArr2 = new ValueEntry[length2];
                        this.Wwwwwwwwwwwwwwwwwwwwwww = valueEntryArr2;
                        int i2 = length2 - 1;
                        for (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V>) this.Wwwwwwwwwwwwwwwwwwww; wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != this; wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V>) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getSuccessorInValueSet()) {
                            ValueEntry<K, V> valueEntry4 = (ValueEntry) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            int i3 = valueEntry4.smearedValueHash & i2;
                            valueEntry4.nextInValueBucket = valueEntryArr2[i3];
                            valueEntryArr2[i3] = valueEntry4;
                        }
                    }
                    return true;
                } else if (valueEntry2.matchesValue(v, Wwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                    return false;
                } else {
                    valueEntry2 = valueEntry2.nextInValueBucket;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Arrays.fill(this.Wwwwwwwwwwwwwwwwwwwwwww, (Object) null);
            this.Wwwwwwwwwwwwwwwwwwwwww = 0;
            for (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwww; wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != this; wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getSuccessorInValueSet()) {
                LinkedHashMultimap.deleteFromMultimap((ValueEntry) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            LinkedHashMultimap.succeedsInValueSet(this, this);
            this.Wwwwwwwwwwwwwwwwwwwww++;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj);
            for (ValueEntry<K, V> valueEntry = this.Wwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() & Wwwwwwwwwwwwwwwwwwwwwwwwwwwww]; valueEntry != null; valueEntry = valueEntry.nextInValueBucket) {
                if (valueEntry.matchesValue(obj, Wwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> getPredecessorInValueSet() {
            return this.Wwwwwwwwwwwwwwwwwww;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> getSuccessorInValueSet() {
            return this.Wwwwwwwwwwwwwwwwwwww;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<V> iterator() {
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj);
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() & Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            ValueEntry<K, V> valueEntry = null;
            for (ValueEntry<K, V> valueEntry2 = this.Wwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2]; valueEntry2 != null; valueEntry2 = valueEntry2.nextInValueBucket) {
                if (valueEntry2.matchesValue(obj, Wwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                    if (valueEntry == null) {
                        this.Wwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2] = valueEntry2.nextInValueBucket;
                    } else {
                        valueEntry.nextInValueBucket = valueEntry2.nextInValueBucket;
                    }
                    LinkedHashMultimap.deleteFromValueSet(valueEntry2);
                    LinkedHashMultimap.deleteFromMultimap(valueEntry2);
                    this.Wwwwwwwwwwwwwwwwwwwwww--;
                    this.Wwwwwwwwwwwwwwwwwwwww++;
                    return true;
                }
                valueEntry = valueEntry2;
            }
            return false;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void setPredecessorInValueSet(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void setSuccessorInValueSet(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.Wwwwwwwwwwwwwwwwwwwwww;
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Iterator<Map.Entry<K, V>> {
        public ValueEntry<K, V> Wwwwwwwwwwwwwwwwwwwwwww;
        public ValueEntry<K, V> Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = LinkedHashMultimap.this.multimapHeaderEntry.successorInMultimap;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww != LinkedHashMultimap.this.multimapHeaderEntry;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (hasNext()) {
                ValueEntry<K, V> valueEntry = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                this.Wwwwwwwwwwwwwwwwwwwwwww = valueEntry;
                this.Wwwwwwwwwwwwwwwwwwwwwwww = valueEntry.successorInMultimap;
                return valueEntry;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww != null, "no calls to next() since the last call to remove()");
            LinkedHashMultimap.this.remove(this.Wwwwwwwwwwwwwwwwwwwwwww.getKey(), this.Wwwwwwwwwwwwwwwwwwwwwww.getValue());
            this.Wwwwwwwwwwwwwwwwwwwwwww = null;
        }
    }

    public LinkedHashMultimap(int i, int i2) {
        super(CompactLinkedHashMap.createWithExpectedSize(i));
        this.valueSetCapacity = 2;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, "expectedValuesPerKey");
        this.valueSetCapacity = i2;
        ValueEntry<K, V> valueEntry = new ValueEntry<>(null, null, 0, null);
        this.multimapHeaderEntry = valueEntry;
        succeedsInMultimap(valueEntry, valueEntry);
    }

    public static <K, V> LinkedHashMultimap<K, V> create() {
        return new LinkedHashMultimap<>(16, 2);
    }

    public static <K, V> LinkedHashMultimap<K, V> create(int i, int i2) {
        return new LinkedHashMultimap<>(C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i), C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2));
    }

    public static <K, V> LinkedHashMultimap<K, V> create(AbstractC2876zw<? extends K, ? extends V> abstractC2876zw) {
        LinkedHashMultimap<K, V> create = create(abstractC2876zw.mo4794keySet().size(), 2);
        create.putAll(abstractC2876zw);
        return create;
    }

    public static <K, V> void deleteFromMultimap(ValueEntry<K, V> valueEntry) {
        succeedsInMultimap(valueEntry.getPredecessorInMultimap(), valueEntry.getSuccessorInMultimap());
    }

    public static <K, V> void deleteFromValueSet(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        succeedsInValueSet(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getPredecessorInValueSet(), wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getSuccessorInValueSet());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        ValueEntry<K, V> valueEntry = new ValueEntry<>(null, null, 0, null);
        this.multimapHeaderEntry = valueEntry;
        succeedsInMultimap(valueEntry, valueEntry);
        this.valueSetCapacity = 2;
        int readInt = objectInputStream.readInt();
        CompactLinkedHashMap createWithExpectedSize = CompactLinkedHashMap.createWithExpectedSize(12);
        for (int i = 0; i < readInt; i++) {
            Object readObject = objectInputStream.readObject();
            createWithExpectedSize.put(readObject, createCollection(readObject));
        }
        int readInt2 = objectInputStream.readInt();
        for (int i2 = 0; i2 < readInt2; i2++) {
            Object readObject2 = objectInputStream.readObject();
            ((Collection) createWithExpectedSize.get(readObject2)).add(objectInputStream.readObject());
        }
        setMap(createWithExpectedSize);
    }

    public static <K, V> void succeedsInMultimap(ValueEntry<K, V> valueEntry, ValueEntry<K, V> valueEntry2) {
        valueEntry.setSuccessorInMultimap(valueEntry2);
        valueEntry2.setPredecessorInMultimap(valueEntry);
    }

    public static <K, V> void succeedsInValueSet(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) {
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setSuccessorInValueSet(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.setPredecessorInValueSet(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(mo4794keySet().size());
        for (K k : mo4794keySet()) {
            objectOutputStream.writeObject(k);
        }
        objectOutputStream.writeInt(size());
        for (Map.Entry<K, V> entry : mo4768entries()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    @Override // com.google.common.collect.AbstractSetMultimap, me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    /* renamed from: asMap */
    public /* bridge */ /* synthetic */ Map mo4790asMap() {
        return super.mo4790asMap();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, me.tvspark.AbstractC2876zw
    public void clear() {
        super.clear();
        ValueEntry<K, V> valueEntry = this.multimapHeaderEntry;
        succeedsInMultimap(valueEntry, valueEntry);
    }

    @Override // me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    public /* bridge */ /* synthetic */ boolean containsEntry(Object obj, Object obj2) {
        return super.containsEntry(obj, obj2);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, me.tvspark.AbstractC2876zw
    public /* bridge */ /* synthetic */ boolean containsKey(Object obj) {
        return super.containsKey(obj);
    }

    @Override // me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    public /* bridge */ /* synthetic */ boolean containsValue(Object obj) {
        return super.containsValue(obj);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap
    public Collection<V> createCollection(K k) {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k, this.valueSetCapacity);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
    /* renamed from: createCollection  reason: collision with other method in class */
    public Set<V> mo4791createCollection() {
        return CompactLinkedHashSet.createWithExpectedSize(this.valueSetCapacity);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    /* renamed from: entries  reason: collision with other method in class */
    public Set<Map.Entry<K, V>> mo4768entries() {
        return super.mo4768entries();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, me.tvspark.AbstractC2309ku
    /* renamed from: entryIterator */
    public Iterator<Map.Entry<K, V>> mo4563entryIterator() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // com.google.common.collect.AbstractSetMultimap, me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: get */
    public /* bridge */ /* synthetic */ Set mo4793get(Object obj) {
        return super.mo4793get((LinkedHashMultimap<K, V>) obj);
    }

    @Override // me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    /* renamed from: keySet */
    public Set<K> mo4794keySet() {
        return super.mo4794keySet();
    }

    @Override // me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    /* renamed from: keys */
    public /* bridge */ /* synthetic */ AbstractC2090ex mo4566keys() {
        return super.mo4566keys();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    public /* bridge */ /* synthetic */ boolean put(Object obj, Object obj2) {
        return super.put(obj, obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    public /* bridge */ /* synthetic */ boolean putAll(Object obj, Iterable iterable) {
        return super.putAll(obj, iterable);
    }

    @Override // me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    public /* bridge */ /* synthetic */ boolean putAll(AbstractC2876zw abstractC2876zw) {
        return super.putAll(abstractC2876zw);
    }

    @Override // me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    public /* bridge */ /* synthetic */ boolean remove(Object obj, Object obj2) {
        return super.remove(obj, obj2);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: removeAll */
    public /* bridge */ /* synthetic */ Set mo4778removeAll(Object obj) {
        return super.mo4778removeAll(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: replaceValues */
    public /* bridge */ /* synthetic */ Collection mo4779replaceValues(Object obj, Iterable iterable) {
        return mo4779replaceValues((LinkedHashMultimap<K, V>) obj, iterable);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: replaceValues  reason: collision with other method in class */
    public Set<V> mo4779replaceValues(K k, Iterable<? extends V> iterable) {
        return super.mo4779replaceValues((LinkedHashMultimap<K, V>) k, (Iterable) iterable);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, me.tvspark.AbstractC2876zw
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // me.tvspark.AbstractC2309ku
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, me.tvspark.AbstractC2309ku
    /* renamed from: valueIterator */
    public Iterator<V> mo4569valueIterator() {
        return new C2163gw(mo4563entryIterator());
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    /* renamed from: values */
    public Collection<V> mo4653values() {
        return super.mo4653values();
    }
}
