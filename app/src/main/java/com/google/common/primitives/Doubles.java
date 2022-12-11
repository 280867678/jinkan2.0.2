package com.google.common.primitives;

import com.google.common.base.Converter;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import java.util.regex.Pattern;
import me.tvspark.Illllllllllllllllllllllllllll;
import me.tvspark.outline;
import org.slf4j.Marker;

/* loaded from: classes3.dex */
public final class Doubles {

    /* loaded from: classes3.dex */
    public static class DoubleArrayAsList extends AbstractList<Double> implements RandomAccess, Serializable {
        public static final long serialVersionUID = 0;
        public final double[] array;
        public final int end;
        public final int start;

        public DoubleArrayAsList(double[] dArr) {
            this(dArr, 0, dArr.length);
        }

        public DoubleArrayAsList(double[] dArr, int i, int i2) {
            this.array = dArr;
            this.start = i;
            this.end = i2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return (obj instanceof Double) && Doubles.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.array, ((Double) obj).doubleValue(), this.start, this.end) != -1;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof DoubleArrayAsList)) {
                return super.equals(obj);
            }
            DoubleArrayAsList doubleArrayAsList = (DoubleArrayAsList) obj;
            int size = size();
            if (doubleArrayAsList.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (this.array[this.start + i] != doubleArrayAsList.array[doubleArrayAsList.start + i]) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.List
        /* renamed from: get */
        public Double mo4811get(int i) {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, size());
            return Double.valueOf(this.array[this.start + i]);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int i = 1;
            for (int i2 = this.start; i2 < this.end; i2++) {
                i = (i * 31) + Doubles.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.array[i2]);
            }
            return i;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (!(obj instanceof Double) || (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Doubles.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.array, ((Double) obj).doubleValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - this.start;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (!(obj instanceof Double) || (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Doubles.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.array, ((Double) obj).doubleValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public Double set(int i, Double d) {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, size());
            double[] dArr = this.array;
            int i2 = this.start;
            double d2 = dArr[i2 + i];
            int i3 = i2 + i;
            if (d != null) {
                dArr[i3] = d.doubleValue();
                return Double.valueOf(d2);
            }
            throw null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Double> subList(int i, int i2) {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i2, size());
            if (i == i2) {
                return Collections.emptyList();
            }
            double[] dArr = this.array;
            int i3 = this.start;
            return new DoubleArrayAsList(dArr, i + i3, i3 + i2);
        }

        public double[] toDoubleArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 12);
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

    /* loaded from: classes3.dex */
    public static final class DoubleConverter extends Converter<String, Double> implements Serializable {
        public static final DoubleConverter INSTANCE = new DoubleConverter();
        public static final long serialVersionUID = 1;

        private Object readResolve() {
            return INSTANCE;
        }

        @Override // com.google.common.base.Converter
        public String doBackward(Double d) {
            return d.toString();
        }

        @Override // com.google.common.base.Converter
        public Double doForward(String str) {
            return Double.valueOf(str);
        }

        public String toString() {
            return "Doubles.stringConverter()";
        }
    }

    /* loaded from: classes3.dex */
    public enum LexicographicalComparator implements Comparator<double[]> {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(double[] dArr, double[] dArr2) {
            int min = Math.min(dArr.length, dArr2.length);
            for (int i = 0; i < min; i++) {
                int compare = Double.compare(dArr[i], dArr2[i]);
                if (compare != 0) {
                    return compare;
                }
            }
            return dArr.length - dArr2.length;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Doubles.lexicographicalComparator()";
        }
    }

    static {
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("(?:\\d+#(?:\\.\\d*#)?|\\.\\d+#)", "(?:[eE][+-]?\\d+#)?[fFdD]?");
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("0[xX]", "(?:[0-9a-fA-F]+#(?:\\.[0-9a-fA-F]*#)?|\\.[0-9a-fA-F]+#)", "[pP][+-]?\\d+#[fFdD]?");
        Pattern.compile(("[+-]?(?:NaN|Infinity|" + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + "|" + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 + ")").replace("#", Marker.ANY_NON_NULL_MARKER));
    }

    public static /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(double[] dArr, double d, int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            if (dArr[i3] == d) {
                return i3;
            }
        }
        return -1;
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(double d) {
        return Double.NEGATIVE_INFINITY < d && d < Double.POSITIVE_INFINITY;
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(double d) {
        return Double.valueOf(d).hashCode();
    }

    public static /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(double[] dArr, double d, int i, int i2) {
        while (i < i2) {
            if (dArr[i] == d) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static double[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Collection<? extends Number> collection) {
        if (collection instanceof DoubleArrayAsList) {
            return ((DoubleArrayAsList) collection).toDoubleArray();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        double[] dArr = new double[length];
        for (int i = 0; i < length; i++) {
            Object obj = array[i];
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj);
            dArr[i] = ((Number) obj).doubleValue();
        }
        return dArr;
    }
}
