package com.google.common.primitives;

import java.util.Comparator;

/* loaded from: classes3.dex */
public enum Longs$LexicographicalComparator implements Comparator<long[]> {
    INSTANCE;

    @Override // java.util.Comparator
    public int compare(long[] jArr, long[] jArr2) {
        int min = Math.min(jArr.length, jArr2.length);
        for (int i = 0; i < min; i++) {
            int i2 = (jArr[i] > jArr2[i] ? 1 : (jArr[i] == jArr2[i] ? 0 : -1));
            int i3 = i2 < 0 ? -1 : i2 > 0 ? 1 : 0;
            if (i3 != 0) {
                return i3;
            }
        }
        return jArr.length - jArr2.length;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "Longs.lexicographicalComparator()";
    }
}
