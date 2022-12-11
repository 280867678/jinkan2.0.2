package com.tencent.bugly.crashreport.common.info;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.tencent.bugly.crashreport.common.info.c */
/* loaded from: classes3.dex */
public class C1142c implements Parcelable.Creator<PlugInBean> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    /* renamed from: createFromParcel */
    public PlugInBean mo4838createFromParcel(Parcel parcel) {
        return new PlugInBean(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    /* renamed from: newArray */
    public PlugInBean[] mo4839newArray(int i) {
        return new PlugInBean[i];
    }
}
