package org.mozilla.javascript;

import java.util.Comparator;

/* loaded from: classes5.dex */
public final class Sorting {
    public static final int SMALLSORT = 16;
    public static final Sorting sorting = new Sorting();

    public static Sorting get() {
        return sorting;
    }

    private void hybridSort(Object[] objArr, int i, int i2, Comparator<Object> comparator, int i3) {
        if (i < i2) {
            if (i3 == 0 || i2 - i <= 16) {
                insertionSort(objArr, i, i2, comparator);
                return;
            }
            int partition = partition(objArr, i, i2, comparator);
            int i4 = i3 - 1;
            hybridSort(objArr, i, partition, comparator, i4);
            hybridSort(objArr, partition + 1, i2, comparator, i4);
        }
    }

    private void insertionSort(Object[] objArr, int i, int i2, Comparator<Object> comparator) {
        for (int i3 = i; i3 <= i2; i3++) {
            Object obj = objArr[i3];
            int i4 = i3 - 1;
            while (i4 >= i && comparator.compare(objArr[i4], obj) > 0) {
                objArr[i4 + 1] = objArr[i4];
                i4--;
            }
            objArr[i4 + 1] = obj;
        }
    }

    private int log2(int i) {
        return (int) (Math.log10(i) / Math.log10(2.0d));
    }

    private int partition(Object[] objArr, int i, int i2, Comparator<Object> comparator) {
        int median = median(objArr, i, i2, comparator);
        Object obj = objArr[median];
        objArr[median] = objArr[i];
        objArr[i] = obj;
        int i3 = i2 + 1;
        int i4 = i;
        while (true) {
            i4++;
            if (comparator.compare(objArr[i4], obj) >= 0 || i4 == i2) {
                do {
                    i3--;
                    if (comparator.compare(objArr[i3], obj) < 0) {
                        break;
                    }
                } while (i3 != i);
                if (i4 >= i3) {
                    swap(objArr, i, i3);
                    return i3;
                }
                swap(objArr, i4, i3);
            }
        }
    }

    private void swap(Object[] objArr, int i, int i2) {
        Object obj = objArr[i];
        objArr[i] = objArr[i2];
        objArr[i2] = obj;
    }

    public void hybridSort(Object[] objArr, Comparator<Object> comparator) {
        hybridSort(objArr, 0, objArr.length - 1, comparator, log2(objArr.length) * 2);
    }

    public void insertionSort(Object[] objArr, Comparator<Object> comparator) {
        insertionSort(objArr, 0, objArr.length - 1, comparator);
    }

    public int median(Object[] objArr, int i, int i2, Comparator<Object> comparator) {
        int i3 = ((i2 - i) / 2) + i;
        int i4 = comparator.compare(objArr[i], objArr[i3]) > 0 ? i3 : i;
        if (comparator.compare(objArr[i4], objArr[i2]) > 0) {
            i4 = i2;
        }
        return i4 == i ? comparator.compare(objArr[i3], objArr[i2]) < 0 ? i3 : i2 : i4 == i3 ? comparator.compare(objArr[i], objArr[i2]) < 0 ? i : i2 : comparator.compare(objArr[i], objArr[i3]) < 0 ? i : i3;
    }
}
