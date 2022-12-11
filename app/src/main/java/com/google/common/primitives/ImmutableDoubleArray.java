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
public final class ImmutableDoubleArray implements Serializable {
    public static final ImmutableDoubleArray EMPTY = new ImmutableDoubleArray(new double[0]);
    public final double[] array;
    public final int end;
    public final transient int start;

    /* loaded from: classes3.dex */
    public static class AsList extends AbstractList<Double> implements RandomAccess, Serializable {
        public final ImmutableDoubleArray parent;

        public AsList(ImmutableDoubleArray immutableDoubleArray) {
            this.parent = immutableDoubleArray;
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
                if (obj2 instanceof Double) {
                    int i2 = i + 1;
                    if (ImmutableDoubleArray.areEqual(this.parent.array[i], ((Double) obj2).doubleValue())) {
                        i = i2;
                    }
                }
                return false;
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.List
        /* renamed from: get */
        public Double mo4813get(int i) {
            return Double.valueOf(this.parent.get(i));
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            return this.parent.hashCode();
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            if (obj instanceof Double) {
                return this.parent.indexOf(((Double) obj).doubleValue());
            }
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            if (obj instanceof Double) {
                return this.parent.lastIndexOf(((Double) obj).doubleValue());
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.parent.length();
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Double> subList(int i, int i2) {
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
        public double[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new double[i];
        }

        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + i;
            double[] dArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i2 > dArr.length) {
                int length = dArr.length;
                if (i2 >= 0) {
                    int i3 = length + (length >> 1) + 1;
                    if (i3 < i2) {
                        i3 = Integer.highestOneBit(i2 - 1) << 1;
                    }
                    if (i3 < 0) {
                        i3 = Integer.MAX_VALUE;
                    }
                    double[] dArr2 = new double[i3];
                    System.arraycopy(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, dArr2, 0, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = dArr2;
                    return;
                }
                throw new AssertionError("cannot store more than MAX_VALUE elements");
            }
        }
    }

    public ImmutableDoubleArray(double[] dArr) {
        this(dArr, 0, dArr.length);
    }

    public ImmutableDoubleArray(double[] dArr, int i, int i2) {
        this.array = dArr;
        this.start = i;
        this.end = i2;
    }

    public static boolean areEqual(double d, double d2) {
        return Double.doubleToLongBits(d) == Double.doubleToLongBits(d2);
    }

    public static Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww builder() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(10);
    }

    public static Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww builder(int i) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i >= 0, "Invalid initialCapacity: %s", i);
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
    }

    public static ImmutableDoubleArray copyOf(Iterable<Double> iterable) {
        boolean z = iterable instanceof Collection;
        if (z) {
            return copyOf((Collection<Double>) iterable);
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww builder = builder();
        if (builder != null) {
            if (z) {
                Collection<Double> collection = (Collection) iterable;
                builder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(collection.size());
                for (Double d : collection) {
                    double[] dArr = builder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    int i = builder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    builder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i + 1;
                    dArr[i] = d.doubleValue();
                }
            } else {
                for (Double d2 : iterable) {
                    double doubleValue = d2.doubleValue();
                    builder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
                    double[] dArr2 = builder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    int i2 = builder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    dArr2[i2] = doubleValue;
                    builder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2 + 1;
                }
            }
            int i3 = builder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            return i3 == 0 ? EMPTY : new ImmutableDoubleArray(builder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, i3);
        }
        throw null;
    }

    public static ImmutableDoubleArray copyOf(Collection<Double> collection) {
        return collection.isEmpty() ? EMPTY : new ImmutableDoubleArray(Doubles.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(collection));
    }

    public static ImmutableDoubleArray copyOf(double[] dArr) {
        return dArr.length == 0 ? EMPTY : new ImmutableDoubleArray(Arrays.copyOf(dArr, dArr.length));
    }

    private boolean isPartialView() {
        return this.start > 0 || this.end < this.array.length;
    }

    /* renamed from: of */
    public static ImmutableDoubleArray m3818of() {
        return EMPTY;
    }

    /* renamed from: of */
    public static ImmutableDoubleArray m3817of(double d) {
        return new ImmutableDoubleArray(new double[]{d});
    }

    /* renamed from: of */
    public static ImmutableDoubleArray m3816of(double d, double d2) {
        return new ImmutableDoubleArray(new double[]{d, d2});
    }

    /* renamed from: of */
    public static ImmutableDoubleArray m3815of(double d, double d2, double d3) {
        return new ImmutableDoubleArray(new double[]{d, d2, d3});
    }

    /* renamed from: of */
    public static ImmutableDoubleArray m3814of(double d, double d2, double d3, double d4) {
        return new ImmutableDoubleArray(new double[]{d, d2, d3, d4});
    }

    /* renamed from: of */
    public static ImmutableDoubleArray m3813of(double d, double d2, double d3, double d4, double d5) {
        return new ImmutableDoubleArray(new double[]{d, d2, d3, d4, d5});
    }

    /* renamed from: of */
    public static ImmutableDoubleArray m3812of(double d, double d2, double d3, double d4, double d5, double d6) {
        return new ImmutableDoubleArray(new double[]{d, d2, d3, d4, d5, d6});
    }

    /* renamed from: of */
    public static ImmutableDoubleArray m3811of(double d, double... dArr) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(dArr.length <= 2147483646, "the total number of elements must fit in an int");
        double[] dArr2 = new double[dArr.length + 1];
        dArr2[0] = d;
        System.arraycopy(dArr, 0, dArr2, 1, dArr.length);
        return new ImmutableDoubleArray(dArr2);
    }

    public List<Double> asList() {
        return new AsList();
    }

    public boolean contains(double d) {
        return indexOf(d) >= 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableDoubleArray)) {
            return false;
        }
        ImmutableDoubleArray immutableDoubleArray = (ImmutableDoubleArray) obj;
        if (length() != immutableDoubleArray.length()) {
            return false;
        }
        for (int i = 0; i < length(); i++) {
            if (!areEqual(get(i), immutableDoubleArray.get(i))) {
                return false;
            }
        }
        return true;
    }

    public double get(int i) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, length());
        return this.array[this.start + i];
    }

    public int hashCode() {
        int i = 1;
        for (int i2 = this.start; i2 < this.end; i2++) {
            i = (i * 31) + Doubles.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.array[i2]);
        }
        return i;
    }

    public int indexOf(double d) {
        for (int i = this.start; i < this.end; i++) {
            if (areEqual(this.array[i], d)) {
                return i - this.start;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.end == this.start;
    }

    public int lastIndexOf(double d) {
        int i = this.end;
        while (true) {
            i--;
            if (i >= this.start) {
                if (areEqual(this.array[i], d)) {
                    return i - this.start;
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

    public ImmutableDoubleArray subArray(int i, int i2) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i2, length());
        if (i == i2) {
            return EMPTY;
        }
        double[] dArr = this.array;
        int i3 = this.start;
        return new ImmutableDoubleArray(dArr, i + i3, i3 + i2);
    }

    public double[] toArray() {
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

    public ImmutableDoubleArray trimmed() {
        return isPartialView() ? new ImmutableDoubleArray(toArray()) : this;
    }

    public Object writeReplace() {
        return trimmed();
    }
}
