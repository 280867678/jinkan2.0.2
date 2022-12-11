package com.tencent.bugly.beta.upgrade;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.AbstractC1228m;
import com.tencent.bugly.proguard.C1189M;
import com.tencent.bugly.proguard.C1241sa;

/* loaded from: classes3.dex */
public class BetaUploadStrategy implements Parcelable, Parcelable.Creator<BetaUploadStrategy> {
    public static final Parcelable.Creator<BetaUploadStrategy> CREATOR = new BetaUploadStrategy();

    /* renamed from: a */
    public C1241sa f863a;

    /* renamed from: b */
    public long f864b;

    public BetaUploadStrategy() {
        C1241sa c1241sa = new C1241sa();
        this.f863a = c1241sa;
        c1241sa.f1627e = true;
        c1241sa.f1628f = true;
        String str = StrategyBean.f1084a;
        c1241sa.f1629g = str;
        c1241sa.f1630h = str;
        long currentTimeMillis = System.currentTimeMillis();
        this.f863a.f1633k = currentTimeMillis;
        this.f864b = currentTimeMillis;
    }

    public BetaUploadStrategy(Parcel parcel) {
        this.f863a = (C1241sa) C1189M.m3130a(parcel.createByteArray(), C1241sa.class);
        this.f864b = parcel.readLong();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    /* renamed from: createFromParcel */
    public BetaUploadStrategy mo4833createFromParcel(Parcel parcel) {
        return new BetaUploadStrategy(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    /* renamed from: newArray */
    public BetaUploadStrategy[] mo4834newArray(int i) {
        return new BetaUploadStrategy[i];
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByteArray(C1189M.m3134a((AbstractC1228m) this.f863a));
        parcel.writeLong(this.f864b);
    }
}
