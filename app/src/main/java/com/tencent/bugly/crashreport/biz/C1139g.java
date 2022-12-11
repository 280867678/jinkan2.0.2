package com.tencent.bugly.crashreport.biz;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.tencent.bugly.crashreport.biz.g */
/* loaded from: classes3.dex */
public class C1139g implements Parcelable.Creator<UserInfoBean> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    /* renamed from: createFromParcel */
    public UserInfoBean mo4836createFromParcel(Parcel parcel) {
        return new UserInfoBean(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    /* renamed from: newArray */
    public UserInfoBean[] mo4837newArray(int i) {
        return new UserInfoBean[i];
    }
}
