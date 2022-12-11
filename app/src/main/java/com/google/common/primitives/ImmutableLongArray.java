package com.google.common.primitives;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;
import me.tvspark.Illllllllllllllllllllllllllll;
import okhttp3.HttpUrl;

/* loaded from: classes3.dex */
public final class ImmutableLongArray implements Serializable {
    public static final ImmutableLongArray EMPTY = new ImmutableLongArray(new long[0]);
    public final long[] array;
    public final int end;
    public final transient int start;

    /* loaded from: classes3.dex */
    public static class AsList extends AbstractList<Long> implements RandomAccess, Serializable {
        public final ImmutableLongArray parent;

        public AsList(ImmutableLongArray immutableLongArray) {
            this.parent = immutableLongArray;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return indexOf(obj) >= 0;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object obj) {
            if (obj instanceof AsList) {
                return this.parent.equals(((AsList) obj).parent);
            }
            if (!(obj instanceof List)) {
                return false;
            }
            List list = (List) obj;
            if (size() != list.size()) {
                return false;
            }
            int i = this.parent.start;
            for (Object obj2 : list) {
                if (obj2 instanceof Long) {
                    int i2 = i + 1;
                    if (this.parent.array[i] == ((Long) obj2).longValue()) {
                        i = i2;
                    }
                }
                return false;
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.List
        /* renamed from: get */
        public Long mo4815get(int i) {
            return Long.valueOf(this.parent.get(i));
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            return this.parent.hashCode();
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            if (obj instanceof Long) {
                return this.parent.indexOf(((Long) obj).longValue());
            }
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            if (obj instanceof Long) {
                return this.parent.lastIndexOf(((Long) obj).longValue());
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.parent.length();
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Long> subList(int i, int i2) {
            return this.parent.subArray(i, i2).asList();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return this.parent.toString();
        }
    }

    /* loaded from: classes3.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        public long[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new long[i];
        }

        public ImmutableLongArray Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 0 ? ImmutableLongArray.EMPTY : new ImmutableLongArray(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }

        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + i;
            long[] jArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i2 > jArr.length) {
                int length = jArr.length;
                if (i2 >= 0) {
                    int i3 = length + (length >> 1) + 1;
                    if (i3 < i2) {
                        i3 = Integer.highestOneBit(i2 - 1) << 1;
                    }
                    if (i3 < 0) {
                        i3 = Integer.MAX_VALUE;
                    }
                    long[] jArr2 = new long[i3];
                    System.arraycopy(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, jArr2, 0, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = jArr2;
                    return;
                }
                throw new AssertionError("cannot store more than MAX_VALUE elements");
            }
        }
    }

    public ImmutableLongArray(long[] jArr) {
        this(jArr, 0, jArr.length);
    }

    public ImmutableLongArray(long[] jArr, int i, int i2) {
        this.array = jArr;
        this.start = i;
        this.end = i2;
    }

    public static Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww builder() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(10);
    }

    public static Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww builder(int i) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i >= 0, "Invalid initialCapacity: %s", i);
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
    }

    public static ImmutableLongArray copyOf(Iterable<Long> iterable) {
        boolean z = iterable instanceof Collection;
        if (z) {
            return copyOf((Collection<Long>) iterable);
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww builder = builder();
        if (builder != null) {
            if (z) {
                Collection<Long> collection = (Collection) iterable;
                builder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(collection.size());
                for (Long l : collection) {
                    long[] jArr = builder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    int i = builder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    builder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i + 1;
                    jArr[i] = l.longValue();
                }
            } else {
                for (Long l2 : iterable) {
                    long longValue = l2.longValue();
                    builder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
                    long[] jArr2 = builder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    int i2 = builder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    jArr2[i2] = longValue;
                    builder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2 + 1;
                }
            }
            return builder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        throw null;
    }

    public static ImmutableLongArray copyOf(long[] jArr) {
        return jArr.length == 0 ? EMPTY : new ImmutableLongArray(Arrays.copyOf(jArr, jArr.length));
    }

    private boolean isPartialView() {
        return this.start > 0 || this.end < this.array.length;
    }

    /* renamed from: of */
    public static ImmutableLongArray m3802of() {
        return EMPTY;
    }

    /* renamed from: of */
    public static ImmutableLongArray m3801of(long j) {
        return new ImmutableLongArray(new long[]{j});
    }

    /* renamed from: of */
    public static ImmutableLongArray m3800of(long j, long j2) {
        return new ImmutableLongArray(new long[]{j, j2});
    }

    /* renamed from: of */
    public static ImmutableLongArray m3799of(long j, long j2, long j3) {
        return new ImmutableLongArray(new long[]{j, j2, j3});
    }

    /* renamed from: of */
    public static ImmutableLongArray m3798of(long j, long j2, long j3, long j4) {
        return new ImmutableLongArray(new long[]{j, j2, j3, j4});
    }

    /* renamed from: of */
    public static ImmutableLongArray m3797of(long j, long j2, long j3, long j4, long j5) {
        return new ImmutableLongArray(new long[]{j, j2, j3, j4, j5});
    }

    /* renamed from: of */
    public static ImmutableLongArray m3796of(long j, long j2, long j3, long j4, long j5, long j6) {
        return new ImmutableLongArray(new long[]{j, j2, j3, j4, j5, j6});
    }

    /* renamed from: of */
    public static ImmutableLongArray m3795of(long j, long... jArr) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(jArr.length <= 2147483646, "the total number of elements must fit in an int");
        long[] jArr2 = new long[jArr.length + 1];
        jArr2[0] = j;
        System.arraycopy(jArr, 0, jArr2, 1, jArr.length);
        return new ImmutableLongArray(jArr2);
    }

    public List<Long> asList() {
        return new AsList();
    }

    public boolean contains(long j) {
        return indexOf(j) >= 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableLongArray)) {
            return false;
        }
        ImmutableLongArray immutableLongArray = (ImmutableLongArray) obj;
        if (length() != immutableLongArray.length()) {
            return false;
        }
        for (int i = 0; i < length(); i++) {
            if (get(i) != immutableLongArray.get(i)) {
                return false;
            }
        }
        return true;
    }

    public long get(int i) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, length());
        return this.array[this.start + i];
    }

    public int hashCode() {
        int i = 1;
        for (int i2 = this.start; i2 < this.end; i2++) {
            i = (i * 31) + Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.array[i2]);
        }
        return i;
    }

    public int indexOf(long j) {
        for (int i = this.start; i < this.end; i++) {
            if (this.array[i] == j) {
                return i - this.start;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.end == this.start;
    }

    public int lastIndexOf(long j) {
        int i = this.end;
        while (true) {
            i--;
            int i2 = this.start;
            if (i >= i2) {
                if (this.array[i] == j) {
                    return i - i2;
                }
            } else {
                return -1;
            }
        }
    }

    public int length() {
        return this.end - this.start;
    }

    public Object readResolve() {
        return isEmpty() ? EMPTY : this;
    }

    public ImmutableLongArray subArray(int i, int i2) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i2, length());
        if (i == i2) {
            return EMPTY;
        }
        long[] jArr = this.array;
        int i3 = this.start;
        return new ImmutableLongArray(jArr, i + i3, i3 + i2);
    }

    public long[] toArray() {
        return Arrays.copyOfRange(this.array, this.start, this.end);
    }

    public String toString() {
        if (isEmpty()) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuilder sb = new StringBuilder(length() * 5);
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

    public ImmutableLongArray trimmed() {
        return isPartialView() ? new ImmutableLongArray(toArray()) : this;
    }

    public Object writeReplace() {
        return trimmed();
    }

    public static ImmutableLongArray copyOf(Collection<Long> collection) {
        long[] jArr;
        if (collection.isEmpty()) {
            return EMPTY;
        }
        if (collection instanceof Longs$LongArrayAsList) {
            jArr = ((Longs$LongArrayAsList) collection).toLongArray();
        } else {
            Object[] array = collection.toArray();
            int length = array.length;
            long[] jArr2 = new long[length];
            for (int i = 0; i < length; i++) {
                Object obj = array[i];
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj);
                jArr2[i] = ((Number) obj).longValue();
            }
            jArr = jArr2;
        }
        return new ImmutableLongArray(jArr);
    }
}
