package com.google.common.primitives;

import java.util.Comparator;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public enum Ints$LexicographicalComparator implements Comparator<int[]> {
    INSTANCE;

    @Override // java.util.Comparator
    public int compare(int[] iArr, int[] iArr2) {
        int min = Math.min(iArr.length, iArr2.length);
        for (int i = 0; i < min; i++) {
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iArr[i], iArr2[i]);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != 0) {
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
        }
        return iArr.length - iArr2.length;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "Ints.lexicographicalComparator()";
    }
}
