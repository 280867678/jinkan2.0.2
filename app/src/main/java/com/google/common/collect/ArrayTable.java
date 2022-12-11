package com.google.common.collect;

import com.google.common.collect.Tables;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import me.tvspark.AbstractC2128fy;
import me.tvspark.AbstractC2235iu;
import me.tvspark.AbstractC2502pw;
import me.tvspark.AbstractC2537qu;
import me.tvspark.C2574ru;
import me.tvspark.C2763wu;
import me.tvspark.Illllllllllllllllllllllllllll;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes3.dex */
public final class ArrayTable<R, C, V> extends AbstractC2537qu<R, C, V> implements Serializable {
    public static final long serialVersionUID = 0;
    public final V[][] array;
    public final ImmutableMap<C, Integer> columnKeyToIndex;
    public final ImmutableList<C> columnList;
    public transient ArrayTable<R, C, V>.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww columnMap;
    public final ImmutableMap<R, Integer> rowKeyToIndex;
    public final ImmutableList<R> rowList;
    public transient ArrayTable<R, C, V>.Wwwwwwwwwwwwwwwwwwwwwwwwwww rowMap;

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwww extends Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<R, Map<C, V>> {
        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            super(ArrayTable.this.rowKeyToIndex, null);
        }

        @Override // com.google.common.collect.ArrayTable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return "Row";
        }

        @Override // com.google.common.collect.ArrayTable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
        }

        @Override // com.google.common.collect.ArrayTable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, java.util.AbstractMap, java.util.Map
        public Object put(Object obj, Object obj2) {
            Map map = (Map) obj2;
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ArrayTable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, Object obj) {
            Map map = (Map) obj;
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwww extends Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<C, V> {
        public final int Wwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            super(ArrayTable.this.columnKeyToIndex, null);
            this.Wwwwwwwwwwwwwwwwwwwwwww = i;
        }

        @Override // com.google.common.collect.ArrayTable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return "Column";
        }

        @Override // com.google.common.collect.ArrayTable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public V Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            return (V) ArrayTable.this.m3928at(this.Wwwwwwwwwwwwwwwwwwwwwww, i);
        }

        @Override // com.google.common.collect.ArrayTable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public V Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, V v) {
            return (V) ArrayTable.this.set(this.Wwwwwwwwwwwwwwwwwwwwwww, i, v);
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwww extends Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<C, Map<R, V>> {
        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            super(ArrayTable.this.columnKeyToIndex, null);
        }

        @Override // com.google.common.collect.ArrayTable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return "Column";
        }

        @Override // com.google.common.collect.ArrayTable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
        }

        @Override // com.google.common.collect.ArrayTable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, java.util.AbstractMap, java.util.Map
        public Object put(Object obj, Object obj2) {
            Map map = (Map) obj2;
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ArrayTable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, Object obj) {
            Map map = (Map) obj;
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<R, V> {
        public final int Wwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            super(ArrayTable.this.rowKeyToIndex, null);
            this.Wwwwwwwwwwwwwwwwwwwwwww = i;
        }

        @Override // com.google.common.collect.ArrayTable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return "Row";
        }

        @Override // com.google.common.collect.ArrayTable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public V Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            return (V) ArrayTable.this.m3928at(i, this.Wwwwwwwwwwwwwwwwwwwwwww);
        }

        @Override // com.google.common.collect.ArrayTable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public V Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, V v) {
            return (V) ArrayTable.this.set(i, this.Wwwwwwwwwwwwwwwwwwwwwww, v);
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> extends AbstractC2502pw<K, V> {
        public final ImmutableMap<K, Integer> Wwwwwwwwwwwwwwwwwwwwwwww;

        /* loaded from: classes3.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2235iu<Map.Entry<K, V>> {
            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
                super(i);
            }

            @Override // me.tvspark.AbstractC2235iu
            public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this;
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size());
                return new C2574ru(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i);
            }
        }

        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ImmutableMap immutableMap, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = immutableMap;
        }

        public abstract String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

        public abstract V Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i);

        public abstract V Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, V v);

        @Override // me.tvspark.AbstractC2502pw
        public Iterator<Map.Entry<K, V>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(size());
        }

        @Override // me.tvspark.AbstractC2502pw, java.util.AbstractMap, java.util.Map
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww.containsKey(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object obj) {
            Integer mo4554get = this.Wwwwwwwwwwwwwwwwwwwwwwww.mo4554get(obj);
            if (mo4554get == null) {
                return null;
            }
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mo4554get.intValue());
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww.isEmpty();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww.mo4552keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(K k, V v) {
            Integer mo4554get = this.Wwwwwwwwwwwwwwwwwwwwwwww.mo4554get(k);
            if (mo4554get != null) {
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mo4554get.intValue(), v);
            }
            throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() + StringUtils.SPACE + k + " not in " + this.Wwwwwwwwwwwwwwwwwwwwwwww.mo4552keySet());
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww.size();
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2235iu<V> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            super(i);
        }

        @Override // me.tvspark.AbstractC2235iu
        public V Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            return (V) ArrayTable.this.getValue(i);
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends Tables.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<R, C, V> {
        public final /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            this.Wwwwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwww / ArrayTable.this.columnList.size();
            this.Wwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwww % ArrayTable.this.columnList.size();
        }

        @Override // me.tvspark.AbstractC2128fy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public C getColumnKey() {
            return (C) ArrayTable.this.columnList.get(this.Wwwwwwwwwwwwwwwwwwwwwww);
        }

        @Override // me.tvspark.AbstractC2128fy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public R getRowKey() {
            return (R) ArrayTable.this.rowList.get(this.Wwwwwwwwwwwwwwwwwwwwwwww);
        }

        @Override // me.tvspark.AbstractC2128fy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public V getValue() {
            return (V) ArrayTable.this.m3928at(this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2235iu<AbstractC2128fy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<R, C, V>> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            super(i);
        }

        @Override // me.tvspark.AbstractC2235iu
        public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            return ArrayTable.this.getCell(i);
        }
    }

    public ArrayTable(ArrayTable<R, C, V> arrayTable) {
        ImmutableList<R> immutableList = arrayTable.rowList;
        this.rowList = immutableList;
        this.columnList = arrayTable.columnList;
        this.rowKeyToIndex = arrayTable.rowKeyToIndex;
        this.columnKeyToIndex = arrayTable.columnKeyToIndex;
        V[][] vArr = (V[][]) ((Object[][]) Array.newInstance(Object.class, immutableList.size(), this.columnList.size()));
        this.array = vArr;
        for (int i = 0; i < this.rowList.size(); i++) {
            V[][] vArr2 = arrayTable.array;
            System.arraycopy(vArr2[i], 0, vArr[i], 0, vArr2[i].length);
        }
    }

    public ArrayTable(Iterable<? extends R> iterable, Iterable<? extends C> iterable2) {
        this.rowList = ImmutableList.copyOf(iterable);
        this.columnList = ImmutableList.copyOf(iterable2);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.rowList.isEmpty() == this.columnList.isEmpty());
        this.rowKeyToIndex = C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Collection) this.rowList);
        this.columnKeyToIndex = C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Collection) this.columnList);
        this.array = (V[][]) ((Object[][]) Array.newInstance(Object.class, this.rowList.size(), this.columnList.size()));
        eraseAll();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ArrayTable(AbstractC2128fy<R, C, V> abstractC2128fy) {
        this(abstractC2128fy.mo4786rowKeySet(), abstractC2128fy.mo4635columnKeySet());
        putAll(abstractC2128fy);
    }

    public static <R, C, V> ArrayTable<R, C, V> create(Iterable<? extends R> iterable, Iterable<? extends C> iterable2) {
        return new ArrayTable<>(iterable, iterable2);
    }

    public static <R, C, V> ArrayTable<R, C, V> create(AbstractC2128fy<R, C, V> abstractC2128fy) {
        return abstractC2128fy instanceof ArrayTable ? new ArrayTable<>((ArrayTable) abstractC2128fy) : new ArrayTable<>(abstractC2128fy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AbstractC2128fy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<R, C, V> getCell(int i) {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public V getValue(int i) {
        return m3928at(i / this.columnList.size(), i % this.columnList.size());
    }

    /* renamed from: at */
    public V m3928at(int i, int i2) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, this.rowList.size());
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, this.columnList.size());
        return this.array[i][i2];
    }

    @Override // me.tvspark.AbstractC2537qu
    /* renamed from: cellIterator */
    public Iterator<AbstractC2128fy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<R, C, V>> mo4632cellIterator() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(size());
    }

    @Override // me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    /* renamed from: cellSet */
    public Set<AbstractC2128fy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<R, C, V>> mo4633cellSet() {
        return super.mo4633cellSet();
    }

    @Override // me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    @Deprecated
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // me.tvspark.AbstractC2128fy
    /* renamed from: column */
    public Map<R, V> mo4736column(C c) {
        if (c != null) {
            Integer mo4554get = this.columnKeyToIndex.mo4554get(c);
            return mo4554get == null ? ImmutableMap.m3900of() : new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mo4554get.intValue());
        }
        throw null;
    }

    public ImmutableList<C> columnKeyList() {
        return this.columnList;
    }

    @Override // me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    /* renamed from: columnKeySet */
    public ImmutableSet<C> mo4635columnKeySet() {
        return this.columnKeyToIndex.mo4552keySet();
    }

    @Override // me.tvspark.AbstractC2128fy
    /* renamed from: columnMap */
    public Map<C, Map<R, V>> mo4741columnMap() {
        ArrayTable<R, C, V>.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.columnMap;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            ArrayTable<R, C, V>.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(null);
            this.columnMap = wwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            return wwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        }
        return wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    public boolean contains(Object obj, Object obj2) {
        return containsRow(obj) && containsColumn(obj2);
    }

    @Override // me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    public boolean containsColumn(Object obj) {
        return this.columnKeyToIndex.containsKey(obj);
    }

    @Override // me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    public boolean containsRow(Object obj) {
        return this.rowKeyToIndex.containsKey(obj);
    }

    @Override // me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    public boolean containsValue(Object obj) {
        V[][] vArr;
        for (V[] vArr2 : this.array) {
            for (V v : vArr2) {
                if (Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj, v)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public V erase(Object obj, Object obj2) {
        Integer mo4554get = this.rowKeyToIndex.mo4554get(obj);
        Integer mo4554get2 = this.columnKeyToIndex.mo4554get(obj2);
        if (mo4554get == null || mo4554get2 == null) {
            return null;
        }
        return set(mo4554get.intValue(), mo4554get2.intValue(), null);
    }

    public void eraseAll() {
        for (V[] vArr : this.array) {
            Arrays.fill(vArr, (Object) null);
        }
    }

    @Override // me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    public V get(Object obj, Object obj2) {
        Integer mo4554get = this.rowKeyToIndex.mo4554get(obj);
        Integer mo4554get2 = this.columnKeyToIndex.mo4554get(obj2);
        if (mo4554get == null || mo4554get2 == null) {
            return null;
        }
        return m3928at(mo4554get.intValue(), mo4554get2.intValue());
    }

    @Override // me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    public boolean isEmpty() {
        return this.rowList.isEmpty() || this.columnList.isEmpty();
    }

    @Override // me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    public V put(R r, C c, V v) {
        if (r != null) {
            if (c == null) {
                throw null;
            }
            Integer mo4554get = this.rowKeyToIndex.mo4554get(r);
            boolean z = true;
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mo4554get != null, "Row %s not in %s", r, this.rowList);
            Integer mo4554get2 = this.columnKeyToIndex.mo4554get(c);
            if (mo4554get2 == null) {
                z = false;
            }
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z, "Column %s not in %s", c, this.columnList);
            return set(mo4554get.intValue(), mo4554get2.intValue(), v);
        }
        throw null;
    }

    @Override // me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    public void putAll(AbstractC2128fy<? extends R, ? extends C, ? extends V> abstractC2128fy) {
        super.putAll(abstractC2128fy);
    }

    @Override // me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    @Deprecated
    public V remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // me.tvspark.AbstractC2128fy
    /* renamed from: row */
    public Map<C, V> mo4785row(R r) {
        if (r != null) {
            Integer mo4554get = this.rowKeyToIndex.mo4554get(r);
            return mo4554get == null ? ImmutableMap.m3900of() : new Wwwwwwwwwwwwwwwwwwwwwwwwwwww(mo4554get.intValue());
        }
        throw null;
    }

    public ImmutableList<R> rowKeyList() {
        return this.rowList;
    }

    @Override // me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    /* renamed from: rowKeySet */
    public ImmutableSet<R> mo4786rowKeySet() {
        return this.rowKeyToIndex.mo4552keySet();
    }

    @Override // me.tvspark.AbstractC2128fy
    /* renamed from: rowMap */
    public Map<R, Map<C, V>> mo4787rowMap() {
        ArrayTable<R, C, V>.Wwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwww = this.rowMap;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            ArrayTable<R, C, V>.Wwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwww2 = new Wwwwwwwwwwwwwwwwwwwwwwwwwww(null);
            this.rowMap = wwwwwwwwwwwwwwwwwwwwwwwwwww2;
            return wwwwwwwwwwwwwwwwwwwwwwwwwww2;
        }
        return wwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public V set(int i, int i2, V v) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, this.rowList.size());
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, this.columnList.size());
        V[][] vArr = this.array;
        V v2 = vArr[i][i2];
        vArr[i][i2] = v;
        return v2;
    }

    @Override // me.tvspark.AbstractC2128fy
    public int size() {
        return this.columnList.size() * this.rowList.size();
    }

    public V[][] toArray(Class<V> cls) {
        V[][] vArr = (V[][]) ((Object[][]) Array.newInstance((Class<?>) cls, this.rowList.size(), this.columnList.size()));
        for (int i = 0; i < this.rowList.size(); i++) {
            V[][] vArr2 = this.array;
            System.arraycopy(vArr2[i], 0, vArr[i], 0, vArr2[i].length);
        }
        return vArr;
    }

    @Override // me.tvspark.AbstractC2537qu
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    /* renamed from: values */
    public Collection<V> mo4642values() {
        return super.mo4642values();
    }

    @Override // me.tvspark.AbstractC2537qu
    public Iterator<V> valuesIterator() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(size());
    }
}
