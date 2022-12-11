package com.google.common.primitives;

import java.util.Comparator;

/* loaded from: classes3.dex */
public enum Booleans$BooleanComparator implements Comparator<Boolean> {
    TRUE_FIRST(1, "Booleans.trueFirst()"),
    FALSE_FIRST(-1, "Booleans.falseFirst()");
    
    public final String toString;
    public final int trueValue;

    Booleans$BooleanComparator(int i, String str) {
        this.trueValue = i;
        this.toString = str;
    }

    @Override // java.util.Comparator
    public int compare(Boolean bool, Boolean bool2) {
        int i = 0;
        int i2 = bool.booleanValue() ? this.trueValue : 0;
        if (bool2.booleanValue()) {
            i = this.trueValue;
        }
        return i - i2;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.toString;
    }
}
