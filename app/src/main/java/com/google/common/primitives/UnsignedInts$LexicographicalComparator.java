package com.google.common.primitives;

import java.util.Comparator;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public enum UnsignedInts$LexicographicalComparator implements Comparator<int[]> {
    INSTANCE;

    @Override // java.util.Comparator
    public int compare(int[] iArr, int[] iArr2) {
        int min = Math.min(iArr.length, iArr2.length);
        for (int i = 0; i < min; i++) {
            if (iArr[i] != iArr2[i]) {
                return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iArr[i] ^ Integer.MIN_VALUE, iArr2[i] ^ Integer.MIN_VALUE);
            }
        }
        return iArr.length - iArr2.length;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "UnsignedInts.lexicographicalComparator()";
    }
}
