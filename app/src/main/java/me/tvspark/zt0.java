package me.tvspark;

import android.util.SparseArray;
import android.view.View;

/* loaded from: classes4.dex */
public class zt0 {
    public SparseArray<View> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public SparseArray<View>[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public View[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new View[0];
    public int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new int[0];

    public static View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(SparseArray<View> sparseArray, int i) {
        int size = sparseArray.size();
        if (size > 0) {
            for (int i2 = 0; i2 < size; i2++) {
                int keyAt = sparseArray.keyAt(i2);
                View view = sparseArray.get(keyAt);
                if (keyAt == i) {
                    sparseArray.remove(keyAt);
                    return view;
                }
            }
            int i3 = size - 1;
            View valueAt = sparseArray.valueAt(i3);
            sparseArray.remove(sparseArray.keyAt(i3));
            return valueAt;
        }
        return null;
    }
}
