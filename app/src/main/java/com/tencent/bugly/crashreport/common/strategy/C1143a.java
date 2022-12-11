package com.tencent.bugly.crashreport.common.strategy;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.tencent.bugly.crashreport.common.strategy.a */
/* loaded from: classes3.dex */
public class C1143a implements Parcelable.Creator<StrategyBean> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    /* renamed from: createFromParcel */
    public StrategyBean mo4840createFromParcel(Parcel parcel) {
        return new StrategyBean(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    /* renamed from: newArray */
    public StrategyBean[] mo4841newArray(int i) {
        return new StrategyBean[i];
    }
}
