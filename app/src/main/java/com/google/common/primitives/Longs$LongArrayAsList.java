package com.google.common.primitives;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public class Longs$LongArrayAsList extends AbstractList<Long> implements RandomAccess, Serializable {
    public static final long serialVersionUID = 0;
    public final long[] array;
    public final int end;
    public final int start;

    public Longs$LongArrayAsList(long[] jArr) {
        this(jArr, 0, jArr.length);
    }

    public Longs$LongArrayAsList(long[] jArr, int i, int i2) {
        this.array = jArr;
        this.start = i;
        this.end = i2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        if (obj instanceof Long) {
            long[] jArr = this.array;
            long longValue = ((Long) obj).longValue();
            int i = this.start;
            int i2 = this.end;
            while (true) {
                if (i >= i2) {
                    i = -1;
                    break;
                } else if (jArr[i] == longValue) {
                    break;
                } else {
                    i++;
                }
            }
            if (i != -1) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Longs$LongArrayAsList)) {
            return super.equals(obj);
        }
        Longs$LongArrayAsList longs$LongArrayAsList = (Longs$LongArrayAsList) obj;
        int size = size();
        if (longs$LongArrayAsList.size() != size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (this.array[this.start + i] != longs$LongArrayAsList.array[longs$LongArrayAsList.start + i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: get */
    public Long mo4817get(int i) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, size());
        return Long.valueOf(this.array[this.start + i]);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i = 1;
        for (int i2 = this.start; i2 < this.end; i2++) {
            i = (i * 31) + Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.array[i2]);
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (obj instanceof Long) {
            long[] jArr = this.array;
            long longValue = ((Long) obj).longValue();
            int i = this.start;
            int i2 = this.end;
            while (true) {
                if (i >= i2) {
                    i = -1;
                    break;
                } else if (jArr[i] == longValue) {
                    break;
                } else {
                    i++;
                }
            }
            if (i >= 0) {
                return i - this.start;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        if (obj instanceof Long) {
            long[] jArr = this.array;
            long longValue = ((Long) obj).longValue();
            int i = this.start;
            int i2 = this.end - 1;
            while (true) {
                if (i2 < i) {
                    i2 = -1;
                    break;
                } else if (jArr[i2] == longValue) {
                    break;
                } else {
                    i2--;
                }
            }
            if (i2 >= 0) {
                return i2 - this.start;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public Long set(int i, Long l) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, size());
        long[] jArr = this.array;
        int i2 = this.start;
        long j = jArr[i2 + i];
        int i3 = i2 + i;
        if (l != null) {
            jArr[i3] = l.longValue();
            return Long.valueOf(j);
        }
        throw null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.end - this.start;
    }

    @Override // java.util.AbstractList, java.util.List
    public List<Long> subList(int i, int i2) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i2, size());
        if (i == i2) {
            return Collections.emptyList();
        }
        long[] jArr = this.array;
        int i3 = this.start;
        return new Longs$LongArrayAsList(jArr, i + i3, i3 + i2);
    }

    public long[] toLongArray() {
        return Arrays.copyOfRange(this.array, this.start, this.end);
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        StringBuilder sb = new StringBuilder(size() * 10);
        sb.append('[');
        sb.append(this.array[this.start]);
        int i = this.start;
        while (true) {
            i++;
            if (i >= this.end) {
                sb.append(']');
                return sb.toString();
            }
            sb.append(", ");
            sb.append(this.array[i]);
        }
    }
}
