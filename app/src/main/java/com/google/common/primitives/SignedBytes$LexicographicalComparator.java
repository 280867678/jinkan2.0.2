package com.google.common.primitives;

import java.util.Comparator;

/* loaded from: classes3.dex */
public enum SignedBytes$LexicographicalComparator implements Comparator<byte[]> {
    INSTANCE;

    @Override // java.util.Comparator
    public int compare(byte[] bArr, byte[] bArr2) {
        int min = Math.min(bArr.length, bArr2.length);
        for (int i = 0; i < min; i++) {
            int i2 = bArr[i] - bArr2[i];
            if (i2 != 0) {
                return i2;
            }
        }
        return bArr.length - bArr2.length;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "SignedBytes.lexicographicalComparator()";
    }
}
