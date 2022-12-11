package com.tencent.bugly.beta.global;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public class ResBean implements Parcelable, Parcelable.Creator<ResBean> {

    /* renamed from: a */
    public static ResBean f725a;

    /* renamed from: c */
    public Map<String, String> f727c = new ConcurrentHashMap();

    /* renamed from: d */
    public final String f728d = "#273238";

    /* renamed from: e */
    public final String f729e = "#757575";

    /* renamed from: b */
    public static final String[] f726b = {"IMG_title", "VAL_style", "tacticsSource", "h5"};
    public static final Parcelable.Creator<ResBean> CREATOR = new ResBean();

    public ResBean() {
    }

    public ResBean(Parcel parcel) {
        try {
            for (String str : f726b) {
                this.f727c.put(str, parcel.readString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public String m3628a(String str) {
        return this.f727c.get(str);
    }

    /* renamed from: a */
    public void m3627a(String str, Object obj) {
        if (obj instanceof String) {
            this.f727c.put(str, (String) obj);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    /* renamed from: createFromParcel */
    public ResBean mo4829createFromParcel(Parcel parcel) {
        return new ResBean(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    /* renamed from: newArray */
    public ResBean[] mo4830newArray(int i) {
        return new ResBean[0];
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        for (String str : f726b) {
            parcel.writeString(this.f727c.get(str));
        }
    }
}
