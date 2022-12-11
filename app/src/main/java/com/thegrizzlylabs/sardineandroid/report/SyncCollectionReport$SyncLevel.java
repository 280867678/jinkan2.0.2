package com.thegrizzlylabs.sardineandroid.report;

/* loaded from: classes4.dex */
public enum SyncCollectionReport$SyncLevel {
    LEVEL_1("1"),
    LEVEL_INFINITY("infinite");
    
    public final String value;

    SyncCollectionReport$SyncLevel(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }
}
