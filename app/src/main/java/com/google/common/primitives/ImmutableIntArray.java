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
public final class ImmutableIntArray implements Serializable {
    public static final ImmutableIntArray EMPTY = new ImmutableIntArray(new int[0]);
    public final int[] array;
    public final int end;
    public final transient int start;

    /* loaded from: classes3.dex */
    public static class AsList extends AbstractList<Integer> implements RandomAccess, Serializable {
        public final ImmutableIntArray parent;

        public AsList(ImmutableIntArray immutableIntArray) {
            this.parent = immutableIntArray;
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
                if (obj2 instanceof Integer) {
                    int i2 = i + 1;
                    if (this.parent.array[i] == ((Integer) obj2).intValue()) {
                        i = i2;
                    }
                }
                return false;
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.List
        /* renamed from: get */
        public Integer mo4814get(int i) {
            return Integer.valueOf(this.parent.get(i));
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            return this.parent.hashCode();
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            if (obj instanceof Integer) {
                return this.parent.indexOf(((Integer) obj).intValue());
            }
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            if (obj instanceof Integer) {
                return this.parent.lastIndexOf(((Integer) obj).intValue());
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.parent.length();
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Integer> subList(int i, int i2) {
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
        public int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new int[i];
        }

        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + i;
            int[] iArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i2 > iArr.length) {
                int length = iArr.length;
                if (i2 >= 0) {
                    int i3 = length + (length >> 1) + 1;
                    if (i3 < i2) {
                        i3 = Integer.highestOneBit(i2 - 1) << 1;
                    }
                    if (i3 < 0) {
                        i3 = Integer.MAX_VALUE;
                    }
                    int[] iArr2 = new int[i3];
                    System.arraycopy(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, iArr2, 0, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = iArr2;
                    return;
                }
                throw new AssertionError("cannot store more than MAX_VALUE elements");
            }
        }
    }

    public ImmutableIntArray(int[] iArr) {
        this(iArr, 0, iArr.length);
    }

    public ImmutableIntArray(int[] iArr, int i, int i2) {
        this.array = iArr;
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

    public static ImmutableIntArray copyOf(Iterable<Integer> iterable) {
        boolean z = iterable instanceof Collection;
        if (z) {
            return copyOf((Collection<Integer>) iterable);
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww builder = builder();
        if (builder != null) {
            if (z) {
                Collection<Integer> collection = (Collection) iterable;
                builder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(collection.size());
                for (Integer num : collection) {
                    int[] iArr = builder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    int i = builder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    builder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i + 1;
                    iArr[i] = num.intValue();
                }
            } else {
                for (Integer num2 : iterable) {
                    int intValue = num2.intValue();
                    builder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
                    int[] iArr2 = builder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    int i2 = builder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    iArr2[i2] = intValue;
                    builder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2 + 1;
                }
            }
            int i3 = builder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            return i3 == 0 ? EMPTY : new ImmutableIntArray(builder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, i3);
        }
        throw null;
    }

    public static ImmutableIntArray copyOf(Collection<Integer> collection) {
        return collection.isEmpty() ? EMPTY : new ImmutableIntArray(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Collection<? extends Number>) collection));
    }

    public static ImmutableIntArray copyOf(int[] iArr) {
        return iArr.length == 0 ? EMPTY : new ImmutableIntArray(Arrays.copyOf(iArr, iArr.length));
    }

    private boolean isPartialView() {
        return this.start > 0 || this.end < this.array.length;
    }

    /* renamed from: of */
    public static ImmutableIntArray m3810of() {
        return EMPTY;
    }

    /* renamed from: of */
    public static ImmutableIntArray m3809of(int i) {
        return new ImmutableIntArray(new int[]{i});
    }

    /* renamed from: of */
    public static ImmutableIntArray m3808of(int i, int i2) {
        return new ImmutableIntArray(new int[]{i, i2});
    }

    /* renamed from: of */
    public static ImmutableIntArray m3807of(int i, int i2, int i3) {
        return new ImmutableIntArray(new int[]{i, i2, i3});
    }

    /* renamed from: of */
    public static ImmutableIntArray m3806of(int i, int i2, int i3, int i4) {
        return new ImmutableIntArray(new int[]{i, i2, i3, i4});
    }

    /* renamed from: of */
    public static ImmutableIntArray m3805of(int i, int i2, int i3, int i4, int i5) {
        return new ImmutableIntArray(new int[]{i, i2, i3, i4, i5});
    }

    /* renamed from: of */
    public static ImmutableIntArray m3804of(int i, int i2, int i3, int i4, int i5, int i6) {
        return new ImmutableIntArray(new int[]{i, i2, i3, i4, i5, i6});
    }

    /* renamed from: of */
    public static ImmutableIntArray m3803of(int i, int... iArr) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iArr.length <= 2147483646, "the total number of elements must fit in an int");
        int[] iArr2 = new int[iArr.length + 1];
        iArr2[0] = i;
        System.arraycopy(iArr, 0, iArr2, 1, iArr.length);
        return new ImmutableIntArray(iArr2);
    }

    public List<Integer> asList() {
        return new AsList();
    }

    public boolean contains(int i) {
        return indexOf(i) >= 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableIntArray)) {
            return false;
        }
        ImmutableIntArray immutableIntArray = (ImmutableIntArray) obj;
        if (length() != immutableIntArray.length()) {
            return false;
        }
        for (int i = 0; i < length(); i++) {
            if (get(i) != immutableIntArray.get(i)) {
                return false;
            }
        }
        return true;
    }

    public int get(int i) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, length());
        return this.array[this.start + i];
    }

    public int hashCode() {
        int i = 1;
        for (int i2 = this.start; i2 < this.end; i2++) {
            i = (i * 31) + this.array[i2];
        }
        return i;
    }

    public int indexOf(int i) {
        for (int i2 = this.start; i2 < this.end; i2++) {
            if (this.array[i2] == i) {
                return i2 - this.start;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.end == this.start;
    }

    public int lastIndexOf(int i) {
        int i2 = this.end;
        while (true) {
            i2--;
            int i3 = this.start;
            if (i2 >= i3) {
                if (this.array[i2] == i) {
                    return i2 - i3;
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

    public ImmutableIntArray subArray(int i, int i2) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i2, length());
        if (i == i2) {
            return EMPTY;
        }
        int[] iArr = this.array;
        int i3 = this.start;
        return new ImmutableIntArray(iArr, i + i3, i3 + i2);
    }

    public int[] toArray() {
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

    public ImmutableIntArray trimmed() {
        return isPartialView() ? new ImmutableIntArray(toArray()) : this;
    }

    public Object writeReplace() {
        return trimmed();
    }
}
