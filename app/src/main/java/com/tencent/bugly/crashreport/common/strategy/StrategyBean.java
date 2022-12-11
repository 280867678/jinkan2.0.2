package com.tencent.bugly.crashreport.common.strategy;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.proguard.C1208ca;
import java.util.Map;
import me.tvspark.outline;
import org.eclipse.jetty.server.AsyncContinuation;

/* loaded from: classes3.dex */
public class StrategyBean implements Parcelable {
    public static final Parcelable.Creator<StrategyBean> CREATOR = new C1143a();

    /* renamed from: a */
    public static String f1084a = "https://android.bugly.qq.com/rqd/async";

    /* renamed from: b */
    public static String f1085b = "https://android.bugly.qq.com/rqd/async";

    /* renamed from: c */
    public static String f1086c;

    /* renamed from: d */
    public long f1087d;

    /* renamed from: e */
    public long f1088e;

    /* renamed from: f */
    public boolean f1089f;

    /* renamed from: g */
    public boolean f1090g;

    /* renamed from: h */
    public boolean f1091h;

    /* renamed from: i */
    public boolean f1092i;

    /* renamed from: j */
    public boolean f1093j;

    /* renamed from: k */
    public boolean f1094k;

    /* renamed from: l */
    public boolean f1095l;

    /* renamed from: m */
    public boolean f1096m;

    /* renamed from: n */
    public boolean f1097n;

    /* renamed from: o */
    public long f1098o;

    /* renamed from: p */
    public long f1099p;

    /* renamed from: q */
    public String f1100q;

    /* renamed from: r */
    public String f1101r;

    /* renamed from: s */
    public String f1102s;

    /* renamed from: t */
    public Map<String, String> f1103t;

    /* renamed from: u */
    public int f1104u;

    /* renamed from: v */
    public long f1105v;

    /* renamed from: w */
    public long f1106w;

    public StrategyBean() {
        this.f1087d = -1L;
        this.f1088e = -1L;
        this.f1089f = true;
        this.f1090g = true;
        this.f1091h = true;
        this.f1092i = true;
        this.f1093j = false;
        this.f1094k = true;
        this.f1095l = true;
        this.f1096m = true;
        this.f1097n = true;
        this.f1099p = AsyncContinuation.DEFAULT_TIMEOUT;
        this.f1100q = f1084a;
        this.f1101r = f1085b;
        this.f1104u = 10;
        this.f1105v = 300000L;
        this.f1106w = -1L;
        this.f1088e = System.currentTimeMillis();
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("S(", "@L@L", "@)");
        f1086c = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setLength(0);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("*^");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("@K#K");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("@!");
        this.f1102s = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    public StrategyBean(Parcel parcel) {
        this.f1087d = -1L;
        this.f1088e = -1L;
        boolean z = true;
        this.f1089f = true;
        this.f1090g = true;
        this.f1091h = true;
        this.f1092i = true;
        this.f1093j = false;
        this.f1094k = true;
        this.f1095l = true;
        this.f1096m = true;
        this.f1097n = true;
        this.f1099p = AsyncContinuation.DEFAULT_TIMEOUT;
        this.f1100q = f1084a;
        this.f1101r = f1085b;
        this.f1104u = 10;
        this.f1105v = 300000L;
        this.f1106w = -1L;
        try {
            f1086c = "S(@L@L@)";
            this.f1088e = parcel.readLong();
            this.f1089f = parcel.readByte() == 1;
            this.f1090g = parcel.readByte() == 1;
            this.f1091h = parcel.readByte() == 1;
            this.f1100q = parcel.readString();
            this.f1101r = parcel.readString();
            this.f1102s = parcel.readString();
            this.f1103t = C1208ca.m3014b(parcel);
            this.f1092i = parcel.readByte() == 1;
            this.f1093j = parcel.readByte() == 1;
            this.f1096m = parcel.readByte() == 1;
            this.f1097n = parcel.readByte() == 1;
            this.f1099p = parcel.readLong();
            this.f1094k = parcel.readByte() == 1;
            if (parcel.readByte() != 1) {
                z = false;
            }
            this.f1095l = z;
            this.f1098o = parcel.readLong();
            this.f1104u = parcel.readInt();
            this.f1105v = parcel.readLong();
            this.f1106w = parcel.readLong();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f1088e);
        parcel.writeByte(this.f1089f ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f1090g ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f1091h ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f1100q);
        parcel.writeString(this.f1101r);
        parcel.writeString(this.f1102s);
        C1208ca.m3013b(parcel, this.f1103t);
        parcel.writeByte(this.f1092i ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f1093j ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f1096m ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f1097n ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f1099p);
        parcel.writeByte(this.f1094k ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f1095l ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f1098o);
        parcel.writeInt(this.f1104u);
        parcel.writeLong(this.f1105v);
        parcel.writeLong(this.f1106w);
    }
}
