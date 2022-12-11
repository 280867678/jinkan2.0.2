package com.google.common.primitives;

import java.util.Comparator;

/* loaded from: classes3.dex */
public enum Shorts$LexicographicalComparator implements Comparator<short[]> {
    INSTANCE;

    @Override // java.util.Comparator
    public int compare(short[] sArr, short[] sArr2) {
        int min = Math.min(sArr.length, sArr2.length);
        for (int i = 0; i < min; i++) {
            int i2 = sArr[i] - sArr2[i];
            if (i2 != 0) {
                return i2;
            }
        }
        return sArr.length - sArr2.length;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "Shorts.lexicographicalComparator()";
    }
}
