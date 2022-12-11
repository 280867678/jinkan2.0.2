package com.google.common.primitives;

import java.util.Comparator;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public enum Booleans$LexicographicalComparator implements Comparator<boolean[]> {
    INSTANCE;

    @Override // java.util.Comparator
    public int compare(boolean[] zArr, boolean[] zArr2) {
        int min = Math.min(zArr.length, zArr2.length);
        for (int i = 0; i < min; i++) {
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(zArr[i], zArr2[i]);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != 0) {
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
        }
        return zArr.length - zArr2.length;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "Booleans.lexicographicalComparator()";
    }
}
