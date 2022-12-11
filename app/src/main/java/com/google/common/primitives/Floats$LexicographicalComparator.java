package com.google.common.primitives;

import java.util.Comparator;

/* loaded from: classes3.dex */
public enum Floats$LexicographicalComparator implements Comparator<float[]> {
    INSTANCE;

    @Override // java.util.Comparator
    public int compare(float[] fArr, float[] fArr2) {
        int min = Math.min(fArr.length, fArr2.length);
        for (int i = 0; i < min; i++) {
            int compare = Float.compare(fArr[i], fArr2[i]);
            if (compare != 0) {
                return compare;
            }
        }
        return fArr.length - fArr2.length;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "Floats.lexicographicalComparator()";
    }
}
