package com.google.common.primitives;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public class Floats$FloatArrayAsList extends AbstractList<Float> implements RandomAccess, Serializable {
    public static final long serialVersionUID = 0;
    public final float[] array;
    public final int end;
    public final int start;

    public Floats$FloatArrayAsList(float[] fArr) {
        this(fArr, 0, fArr.length);
    }

    public Floats$FloatArrayAsList(float[] fArr, int i, int i2) {
        this.array = fArr;
        this.start = i;
        this.end = i2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        if (obj instanceof Float) {
            float[] fArr = this.array;
            float floatValue = ((Float) obj).floatValue();
            int i = this.start;
            int i2 = this.end;
            while (true) {
                if (i >= i2) {
                    i = -1;
                    break;
                } else if (fArr[i] == floatValue) {
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
        if (!(obj instanceof Floats$FloatArrayAsList)) {
            return super.equals(obj);
        }
        Floats$FloatArrayAsList floats$FloatArrayAsList = (Floats$FloatArrayAsList) obj;
        int size = size();
        if (floats$FloatArrayAsList.size() != size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (this.array[this.start + i] != floats$FloatArrayAsList.array[floats$FloatArrayAsList.start + i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: get */
    public Float mo4812get(int i) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, size());
        return Float.valueOf(this.array[this.start + i]);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i = 1;
        for (int i2 = this.start; i2 < this.end; i2++) {
            i = (i * 31) + Float.valueOf(this.array[i2]).hashCode();
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (obj instanceof Float) {
            float[] fArr = this.array;
            float floatValue = ((Float) obj).floatValue();
            int i = this.start;
            int i2 = this.end;
            while (true) {
                if (i >= i2) {
                    i = -1;
                    break;
                } else if (fArr[i] == floatValue) {
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
        if (obj instanceof Float) {
            float[] fArr = this.array;
            float floatValue = ((Float) obj).floatValue();
            int i = this.start;
            int i2 = this.end - 1;
            while (true) {
                if (i2 < i) {
                    i2 = -1;
                    break;
                } else if (fArr[i2] == floatValue) {
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
    public Float set(int i, Float f) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, size());
        float[] fArr = this.array;
        int i2 = this.start;
        float f2 = fArr[i2 + i];
        int i3 = i2 + i;
        if (f != null) {
            fArr[i3] = f.floatValue();
            return Float.valueOf(f2);
        }
        throw null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.end - this.start;
    }

    @Override // java.util.AbstractList, java.util.List
    public List<Float> subList(int i, int i2) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i2, size());
        if (i == i2) {
            return Collections.emptyList();
        }
        float[] fArr = this.array;
        int i3 = this.start;
        return new Floats$FloatArrayAsList(fArr, i + i3, i3 + i2);
    }

    public float[] toFloatArray() {
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
