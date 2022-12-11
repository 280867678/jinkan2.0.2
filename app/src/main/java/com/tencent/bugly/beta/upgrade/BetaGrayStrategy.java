package com.tencent.bugly.beta.upgrade;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.proguard.AbstractC1228m;
import com.tencent.bugly.proguard.C1177B;
import com.tencent.bugly.proguard.C1189M;

/* loaded from: classes3.dex */
public class BetaGrayStrategy implements Parcelable, Parcelable.Creator<BetaGrayStrategy> {
    public static final Parcelable.Creator<BetaGrayStrategy> CREATOR = new BetaGrayStrategy();

    /* renamed from: a */
    public C1177B f858a;

    /* renamed from: b */
    public int f859b;

    /* renamed from: c */
    public long f860c;

    /* renamed from: d */
    public boolean f861d;

    /* renamed from: e */
    public long f862e;

    public BetaGrayStrategy() {
        this.f859b = 0;
        this.f860c = -1L;
        this.f861d = false;
        this.f862e = -1L;
    }

    public BetaGrayStrategy(Parcel parcel) {
        boolean z = false;
        this.f859b = 0;
        this.f860c = -1L;
        this.f861d = false;
        this.f862e = -1L;
        this.f858a = (C1177B) C1189M.m3130a(parcel.createByteArray(), C1177B.class);
        this.f859b = parcel.readInt();
        this.f860c = parcel.readLong();
        this.f861d = 1 == parcel.readByte() ? true : z;
        this.f862e = parcel.readLong();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    /* renamed from: createFromParcel */
    public BetaGrayStrategy mo4831createFromParcel(Parcel parcel) {
        return new BetaGrayStrategy(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    /* renamed from: newArray */
    public BetaGrayStrategy[] mo4832newArray(int i) {
        return new BetaGrayStrategy[i];
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByteArray(C1189M.m3134a((AbstractC1228m) this.f858a));
        parcel.writeInt(this.f859b);
        parcel.writeLong(this.f860c);
        parcel.writeByte(this.f861d ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f862e);
    }
}
