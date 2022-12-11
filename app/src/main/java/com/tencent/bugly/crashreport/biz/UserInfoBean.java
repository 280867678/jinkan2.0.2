package com.tencent.bugly.crashreport.biz;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.proguard.C1208ca;
import java.util.Map;

/* loaded from: classes3.dex */
public class UserInfoBean implements Parcelable {
    public static final Parcelable.Creator<UserInfoBean> CREATOR = new C1139g();

    /* renamed from: a */
    public long f950a;

    /* renamed from: b */
    public int f951b;

    /* renamed from: c */
    public String f952c;

    /* renamed from: d */
    public String f953d;

    /* renamed from: e */
    public long f954e;

    /* renamed from: f */
    public long f955f;

    /* renamed from: g */
    public long f956g;

    /* renamed from: h */
    public long f957h;

    /* renamed from: i */
    public long f958i;

    /* renamed from: j */
    public String f959j;

    /* renamed from: k */
    public long f960k;

    /* renamed from: l */
    public boolean f961l;

    /* renamed from: m */
    public String f962m;

    /* renamed from: n */
    public String f963n;

    /* renamed from: o */
    public int f964o;

    /* renamed from: p */
    public int f965p;

    /* renamed from: q */
    public int f966q;

    /* renamed from: r */
    public Map<String, String> f967r;

    /* renamed from: s */
    public Map<String, String> f968s;

    public UserInfoBean() {
        this.f960k = 0L;
        this.f961l = false;
        this.f962m = "unknown";
        this.f965p = -1;
        this.f966q = -1;
        this.f967r = null;
        this.f968s = null;
    }

    public UserInfoBean(Parcel parcel) {
        this.f960k = 0L;
        boolean z = false;
        this.f961l = false;
        this.f962m = "unknown";
        this.f965p = -1;
        this.f966q = -1;
        this.f967r = null;
        this.f968s = null;
        this.f951b = parcel.readInt();
        this.f952c = parcel.readString();
        this.f953d = parcel.readString();
        this.f954e = parcel.readLong();
        this.f955f = parcel.readLong();
        this.f956g = parcel.readLong();
        this.f957h = parcel.readLong();
        this.f958i = parcel.readLong();
        this.f959j = parcel.readString();
        this.f960k = parcel.readLong();
        this.f961l = parcel.readByte() == 1 ? true : z;
        this.f962m = parcel.readString();
        this.f965p = parcel.readInt();
        this.f966q = parcel.readInt();
        this.f967r = C1208ca.m3014b(parcel);
        this.f968s = C1208ca.m3014b(parcel);
        this.f963n = parcel.readString();
        this.f964o = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f951b);
        parcel.writeString(this.f952c);
        parcel.writeString(this.f953d);
        parcel.writeLong(this.f954e);
        parcel.writeLong(this.f955f);
        parcel.writeLong(this.f956g);
        parcel.writeLong(this.f957h);
        parcel.writeLong(this.f958i);
        parcel.writeString(this.f959j);
        parcel.writeLong(this.f960k);
        parcel.writeByte(this.f961l ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f962m);
        parcel.writeInt(this.f965p);
        parcel.writeInt(this.f966q);
        C1208ca.m3013b(parcel, this.f967r);
        C1208ca.m3013b(parcel, this.f968s);
        parcel.writeString(this.f963n);
        parcel.writeInt(this.f964o);
    }
}
