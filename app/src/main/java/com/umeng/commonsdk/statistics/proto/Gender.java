package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.AbstractC1564ax;

/* loaded from: classes4.dex */
public enum Gender implements AbstractC1564ax {
    MALE(0),
    FEMALE(1),
    UNKNOWN(2);
    
    public final int value;

    Gender(int i) {
        this.value = i;
    }

    public static Gender findByValue(int i) {
        if (i != 0) {
            if (i == 1) {
                return FEMALE;
            }
            if (i == 2) {
                return UNKNOWN;
            }
            return null;
        }
        return MALE;
    }

    @Override // com.umeng.analytics.pro.AbstractC1564ax
    public int getValue() {
        return this.value;
    }
}
