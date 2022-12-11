package com.tencent.bugly.crashreport.crash;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.proguard.C1208ca;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes3.dex */
public class CrashDetailBean implements Parcelable, Comparable<CrashDetailBean> {
    public static final Parcelable.Creator<CrashDetailBean> CREATOR = new C1159c();

    /* renamed from: A */
    public String f1121A;

    /* renamed from: B */
    public String f1122B;

    /* renamed from: C */
    public long f1123C;

    /* renamed from: D */
    public long f1124D;

    /* renamed from: E */
    public long f1125E;

    /* renamed from: F */
    public long f1126F;

    /* renamed from: G */
    public long f1127G;

    /* renamed from: H */
    public long f1128H;

    /* renamed from: I */
    public String f1129I;

    /* renamed from: J */
    public String f1130J;

    /* renamed from: K */
    public String f1131K;

    /* renamed from: L */
    public String f1132L;

    /* renamed from: M */
    public String f1133M;

    /* renamed from: N */
    public long f1134N;

    /* renamed from: O */
    public boolean f1135O;

    /* renamed from: P */
    public Map<String, String> f1136P;

    /* renamed from: Q */
    public Map<String, String> f1137Q;

    /* renamed from: R */
    public int f1138R;

    /* renamed from: S */
    public int f1139S;

    /* renamed from: T */
    public Map<String, String> f1140T;

    /* renamed from: U */
    public Map<String, String> f1141U;

    /* renamed from: V */
    public byte[] f1142V;

    /* renamed from: W */
    public String f1143W;

    /* renamed from: X */
    public String f1144X;

    /* renamed from: a */
    public long f1145a;

    /* renamed from: b */
    public int f1146b;

    /* renamed from: c */
    public String f1147c;

    /* renamed from: d */
    public boolean f1148d;

    /* renamed from: e */
    public String f1149e;

    /* renamed from: f */
    public String f1150f;

    /* renamed from: g */
    public String f1151g;

    /* renamed from: h */
    public Map<String, PlugInBean> f1152h;

    /* renamed from: i */
    public Map<String, PlugInBean> f1153i;

    /* renamed from: j */
    public boolean f1154j;

    /* renamed from: k */
    public boolean f1155k;

    /* renamed from: l */
    public int f1156l;

    /* renamed from: m */
    public String f1157m;

    /* renamed from: n */
    public String f1158n;

    /* renamed from: o */
    public String f1159o;

    /* renamed from: p */
    public String f1160p;

    /* renamed from: q */
    public String f1161q;

    /* renamed from: r */
    public long f1162r;

    /* renamed from: s */
    public String f1163s;

    /* renamed from: t */
    public int f1164t;

    /* renamed from: u */
    public String f1165u;

    /* renamed from: v */
    public String f1166v;

    /* renamed from: w */
    public String f1167w;

    /* renamed from: x */
    public String f1168x;

    /* renamed from: y */
    public byte[] f1169y;

    /* renamed from: z */
    public Map<String, String> f1170z;

    public CrashDetailBean() {
        this.f1145a = -1L;
        this.f1146b = 0;
        this.f1147c = UUID.randomUUID().toString();
        this.f1148d = false;
        this.f1149e = "";
        this.f1150f = "";
        this.f1151g = "";
        this.f1152h = null;
        this.f1153i = null;
        this.f1154j = false;
        this.f1155k = false;
        this.f1156l = 0;
        this.f1157m = "";
        this.f1158n = "";
        this.f1159o = "";
        this.f1160p = "";
        this.f1161q = "";
        this.f1162r = -1L;
        this.f1163s = null;
        this.f1164t = 0;
        this.f1165u = "";
        this.f1166v = "";
        this.f1167w = null;
        this.f1168x = null;
        this.f1169y = null;
        this.f1170z = null;
        this.f1121A = "";
        this.f1122B = "";
        this.f1123C = -1L;
        this.f1124D = -1L;
        this.f1125E = -1L;
        this.f1126F = -1L;
        this.f1127G = -1L;
        this.f1128H = -1L;
        this.f1129I = "";
        this.f1130J = "";
        this.f1131K = "";
        this.f1132L = "";
        this.f1133M = "";
        this.f1134N = -1L;
        this.f1135O = false;
        this.f1136P = null;
        this.f1137Q = null;
        this.f1138R = -1;
        this.f1139S = -1;
        this.f1140T = null;
        this.f1141U = null;
        this.f1142V = null;
        this.f1143W = null;
        this.f1144X = null;
    }

    public CrashDetailBean(Parcel parcel) {
        this.f1145a = -1L;
        boolean z = false;
        this.f1146b = 0;
        this.f1147c = UUID.randomUUID().toString();
        this.f1148d = false;
        this.f1149e = "";
        this.f1150f = "";
        this.f1151g = "";
        this.f1152h = null;
        this.f1153i = null;
        this.f1154j = false;
        this.f1155k = false;
        this.f1156l = 0;
        this.f1157m = "";
        this.f1158n = "";
        this.f1159o = "";
        this.f1160p = "";
        this.f1161q = "";
        this.f1162r = -1L;
        this.f1163s = null;
        this.f1164t = 0;
        this.f1165u = "";
        this.f1166v = "";
        this.f1167w = null;
        this.f1168x = null;
        this.f1169y = null;
        this.f1170z = null;
        this.f1121A = "";
        this.f1122B = "";
        this.f1123C = -1L;
        this.f1124D = -1L;
        this.f1125E = -1L;
        this.f1126F = -1L;
        this.f1127G = -1L;
        this.f1128H = -1L;
        this.f1129I = "";
        this.f1130J = "";
        this.f1131K = "";
        this.f1132L = "";
        this.f1133M = "";
        this.f1134N = -1L;
        this.f1135O = false;
        this.f1136P = null;
        this.f1137Q = null;
        this.f1138R = -1;
        this.f1139S = -1;
        this.f1140T = null;
        this.f1141U = null;
        this.f1142V = null;
        this.f1143W = null;
        this.f1144X = null;
        this.f1146b = parcel.readInt();
        this.f1147c = parcel.readString();
        this.f1148d = parcel.readByte() == 1;
        this.f1149e = parcel.readString();
        this.f1150f = parcel.readString();
        this.f1151g = parcel.readString();
        this.f1154j = parcel.readByte() == 1;
        this.f1155k = parcel.readByte() == 1;
        this.f1156l = parcel.readInt();
        this.f1157m = parcel.readString();
        this.f1158n = parcel.readString();
        this.f1159o = parcel.readString();
        this.f1160p = parcel.readString();
        this.f1161q = parcel.readString();
        this.f1162r = parcel.readLong();
        this.f1163s = parcel.readString();
        this.f1164t = parcel.readInt();
        this.f1165u = parcel.readString();
        this.f1166v = parcel.readString();
        this.f1167w = parcel.readString();
        this.f1170z = C1208ca.m3014b(parcel);
        this.f1121A = parcel.readString();
        this.f1122B = parcel.readString();
        this.f1123C = parcel.readLong();
        this.f1124D = parcel.readLong();
        this.f1125E = parcel.readLong();
        this.f1126F = parcel.readLong();
        this.f1127G = parcel.readLong();
        this.f1128H = parcel.readLong();
        this.f1129I = parcel.readString();
        this.f1130J = parcel.readString();
        this.f1131K = parcel.readString();
        this.f1132L = parcel.readString();
        this.f1133M = parcel.readString();
        this.f1134N = parcel.readLong();
        this.f1135O = parcel.readByte() == 1 ? true : z;
        this.f1136P = C1208ca.m3014b(parcel);
        this.f1152h = C1208ca.m3038a(parcel);
        this.f1153i = C1208ca.m3038a(parcel);
        this.f1138R = parcel.readInt();
        this.f1139S = parcel.readInt();
        this.f1140T = C1208ca.m3014b(parcel);
        this.f1141U = C1208ca.m3014b(parcel);
        this.f1142V = parcel.createByteArray();
        this.f1169y = parcel.createByteArray();
        this.f1143W = parcel.readString();
        this.f1144X = parcel.readString();
        this.f1168x = parcel.readString();
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(CrashDetailBean crashDetailBean) {
        int i;
        if (crashDetailBean == null || this.f1162r - crashDetailBean.f1162r > 0) {
            return 1;
        }
        return i < 0 ? -1 : 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f1146b);
        parcel.writeString(this.f1147c);
        parcel.writeByte(this.f1148d ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f1149e);
        parcel.writeString(this.f1150f);
        parcel.writeString(this.f1151g);
        parcel.writeByte(this.f1154j ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f1155k ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f1156l);
        parcel.writeString(this.f1157m);
        parcel.writeString(this.f1158n);
        parcel.writeString(this.f1159o);
        parcel.writeString(this.f1160p);
        parcel.writeString(this.f1161q);
        parcel.writeLong(this.f1162r);
        parcel.writeString(this.f1163s);
        parcel.writeInt(this.f1164t);
        parcel.writeString(this.f1165u);
        parcel.writeString(this.f1166v);
        parcel.writeString(this.f1167w);
        C1208ca.m3013b(parcel, this.f1170z);
        parcel.writeString(this.f1121A);
        parcel.writeString(this.f1122B);
        parcel.writeLong(this.f1123C);
        parcel.writeLong(this.f1124D);
        parcel.writeLong(this.f1125E);
        parcel.writeLong(this.f1126F);
        parcel.writeLong(this.f1127G);
        parcel.writeLong(this.f1128H);
        parcel.writeString(this.f1129I);
        parcel.writeString(this.f1130J);
        parcel.writeString(this.f1131K);
        parcel.writeString(this.f1132L);
        parcel.writeString(this.f1133M);
        parcel.writeLong(this.f1134N);
        parcel.writeByte(this.f1135O ? (byte) 1 : (byte) 0);
        C1208ca.m3013b(parcel, this.f1136P);
        C1208ca.m3037a(parcel, this.f1152h);
        C1208ca.m3037a(parcel, this.f1153i);
        parcel.writeInt(this.f1138R);
        parcel.writeInt(this.f1139S);
        C1208ca.m3013b(parcel, this.f1140T);
        C1208ca.m3013b(parcel, this.f1141U);
        parcel.writeByteArray(this.f1142V);
        parcel.writeByteArray(this.f1169y);
        parcel.writeString(this.f1143W);
        parcel.writeString(this.f1144X);
        parcel.writeString(this.f1168x);
    }
}
