package com.efs.sdk.p020pa.config;

/* renamed from: com.efs.sdk.pa.config.PackageLevel */
/* loaded from: classes3.dex */
public enum PackageLevel {
    DAILY_DEVELOP(1),
    INTERNAL_TEST(2),
    TRIAL(3),
    RELEASE(4);
    
    public int mLevel;

    PackageLevel(int i) {
        this.mLevel = i;
    }

    public final int getLevel() {
        return this.mLevel;
    }
}
