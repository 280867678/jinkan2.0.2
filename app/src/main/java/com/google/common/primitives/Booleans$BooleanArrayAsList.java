package com.google.common.primitives;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public class Booleans$BooleanArrayAsList extends AbstractList<Boolean> implements RandomAccess, Serializable {
    public static final long serialVersionUID = 0;
    public final boolean[] array;
    public final int end;
    public final int start;

    public Booleans$BooleanArrayAsList(boolean[] zArr) {
        this(zArr, 0, zArr.length);
    }

    public Booleans$BooleanArrayAsList(boolean[] zArr, int i, int i2) {
        this.array = zArr;
        this.start = i;
        this.end = i2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        if (obj instanceof Boolean) {
            boolean[] zArr = this.array;
            boolean booleanValue = ((Boolean) obj).booleanValue();
            int i = this.start;
            int i2 = this.end;
            while (true) {
                if (i >= i2) {
                    i = -1;
                    break;
                } else if (zArr[i] == booleanValue) {
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
        if (!(obj instanceof Booleans$BooleanArrayAsList)) {
            return super.equals(obj);
        }
        Booleans$BooleanArrayAsList booleans$BooleanArrayAsList = (Booleans$BooleanArrayAsList) obj;
        int size = size();
        if (booleans$BooleanArrayAsList.size() != size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (this.array[this.start + i] != booleans$BooleanArrayAsList.array[booleans$BooleanArrayAsList.start + i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: get */
    public Boolean mo4808get(int i) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, size());
        return Boolean.valueOf(this.array[this.start + i]);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i = 1;
        for (int i2 = this.start; i2 < this.end; i2++) {
            i = (i * 31) + (this.array[i2] ? 1231 : 1237);
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (obj instanceof Boolean) {
            boolean[] zArr = this.array;
            boolean booleanValue = ((Boolean) obj).booleanValue();
            int i = this.start;
            int i2 = this.end;
            while (true) {
                if (i >= i2) {
                    i = -1;
                    break;
                } else if (zArr[i] == booleanValue) {
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
        if (obj instanceof Boolean) {
            boolean[] zArr = this.array;
            boolean booleanValue = ((Boolean) obj).booleanValue();
            int i = this.start;
            int i2 = this.end - 1;
            while (true) {
                if (i2 < i) {
                    i2 = -1;
                    break;
                } else if (zArr[i2] == booleanValue) {
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
    public Boolean set(int i, Boolean bool) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, size());
        boolean[] zArr = this.array;
        int i2 = this.start;
        boolean z = zArr[i2 + i];
        int i3 = i2 + i;
        if (bool != null) {
            zArr[i3] = bool.booleanValue();
            return Boolean.valueOf(z);
        }
        throw null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.end - this.start;
    }

    @Override // java.util.AbstractList, java.util.List
    public List<Boolean> subList(int i, int i2) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i2, size());
        if (i == i2) {
            return Collections.emptyList();
        }
        boolean[] zArr = this.array;
        int i3 = this.start;
        return new Booleans$BooleanArrayAsList(zArr, i + i3, i3 + i2);
    }

    public boolean[] toBooleanArray() {
        return Arrays.copyOfRange(this.array, this.start, this.end);
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        StringBuilder sb = new StringBuilder(size() * 7);
        sb.append(this.array[this.start] ? "[true" : "[false");
        int i = this.start;
        while (true) {
            i++;
            if (i >= this.end) {
                sb.append(']');
                return sb.toString();
            }
            sb.append(this.array[i] ? ", true" : ", false");
        }
    }
}
