package com.tencent.bugly.crashreport.common.info;

import android.os.Parcel;
import android.os.Parcelable;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public class PlugInBean implements Parcelable {
    public static final Parcelable.Creator<PlugInBean> CREATOR = new C1142c();

    /* renamed from: a */
    public final String f1000a;

    /* renamed from: b */
    public final String f1001b;

    /* renamed from: c */
    public final String f1002c;

    public PlugInBean(Parcel parcel) {
        this.f1000a = parcel.readString();
        this.f1001b = parcel.readString();
        this.f1002c = parcel.readString();
    }

    public PlugInBean(String str, String str2, String str3) {
        this.f1000a = str;
        this.f1001b = str2;
        this.f1002c = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("plid:");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.f1000a);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" plV:");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.f1001b);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" plUUID:");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.f1002c);
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f1000a);
        parcel.writeString(this.f1001b);
        parcel.writeString(this.f1002c);
    }
}
