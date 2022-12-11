package com.google.common.primitives;

import java.util.Comparator;

/* loaded from: classes3.dex */
public enum Chars$LexicographicalComparator implements Comparator<char[]> {
    INSTANCE;

    @Override // java.util.Comparator
    public int compare(char[] cArr, char[] cArr2) {
        int min = Math.min(cArr.length, cArr2.length);
        for (int i = 0; i < min; i++) {
            int i2 = cArr[i] - cArr2[i];
            if (i2 != 0) {
                return i2;
            }
        }
        return cArr.length - cArr2.length;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "Chars.lexicographicalComparator()";
    }
}
