package com.tencent.bugly.crashreport.crash;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.tencent.bugly.crashreport.crash.c */
/* loaded from: classes3.dex */
public class C1159c implements Parcelable.Creator<CrashDetailBean> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    /* renamed from: createFromParcel */
    public CrashDetailBean mo4842createFromParcel(Parcel parcel) {
        return new CrashDetailBean(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    /* renamed from: newArray */
    public CrashDetailBean[] mo4843newArray(int i) {
        return new CrashDetailBean[i];
    }
}
