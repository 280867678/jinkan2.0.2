package com.google.common.primitives;

import java.util.Comparator;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public enum UnsignedLongs$LexicographicalComparator implements Comparator<long[]> {
    INSTANCE;

    @Override // java.util.Comparator
    public int compare(long[] jArr, long[] jArr2) {
        int min = Math.min(jArr.length, jArr2.length);
        for (int i = 0; i < min; i++) {
            if (jArr[i] != jArr2[i]) {
                return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(jArr[i], jArr2[i]);
            }
        }
        return jArr.length - jArr2.length;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "UnsignedLongs.lexicographicalComparator()";
    }
}
