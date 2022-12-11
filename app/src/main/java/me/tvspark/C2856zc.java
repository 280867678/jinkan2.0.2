package me.tvspark;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.List;
import java.util.Map;
import me.tvspark.C2254jc;

/* renamed from: me.tvspark.zc */
/* loaded from: classes4.dex */
public final class C2856zc implements C2254jc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    public static final Parcelable.Creator<C2856zc> CREATOR = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public final int Wwwwwwwwwwwwwwwwwww;
    public final boolean Wwwwwwwwwwwwwwwwwwww;
    @Nullable
    public final String Wwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public final String Wwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public final String Wwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: me.tvspark.zc$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Parcelable.Creator<C2856zc> {
        @Override // android.os.Parcelable.Creator
        public C2856zc createFromParcel(Parcel parcel) {
            return new C2856zc(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public C2856zc[] newArray(int i) {
            return new C2856zc[i];
        }
    }

    public C2856zc(int i, @Nullable String str, @Nullable String str2, @Nullable String str3, boolean z, int i2) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2 == -1 || i2 > 0);
        this.Wwwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwwww = str;
        this.Wwwwwwwwwwwwwwwwwwwwww = str2;
        this.Wwwwwwwwwwwwwwwwwwwww = str3;
        this.Wwwwwwwwwwwwwwwwwwww = z;
        this.Wwwwwwwwwwwwwwwwwww = i2;
    }

    public C2856zc(Parcel parcel) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = parcel.readInt();
        this.Wwwwwwwwwwwwwwwwwwwwwww = parcel.readString();
        this.Wwwwwwwwwwwwwwwwwwwwww = parcel.readString();
        this.Wwwwwwwwwwwwwwwwwwwww = parcel.readString();
        this.Wwwwwwwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(parcel);
        this.Wwwwwwwwwwwwwwwwwww = parcel.readInt();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0069  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static C2856zc Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Map<String, List<String>> map) {
        boolean z;
        int i;
        List<String> list;
        String str;
        List<String> list2;
        String str2;
        List<String> list3;
        String str3;
        List<String> list4;
        boolean z2;
        List<String> list5;
        int i2;
        List<String> list6 = map.get("icy-br");
        int i3 = -1;
        boolean z3 = true;
        if (list6 != null) {
            String str4 = list6.get(0);
            try {
                i2 = Integer.parseInt(str4) * 1000;
                if (i2 > 0) {
                    z = true;
                } else {
                    try {
                        String valueOf = String.valueOf(str4);
                        if (valueOf.length() != 0) {
                            "Invalid bitrate: ".concat(valueOf);
                        } else {
                            new String("Invalid bitrate: ");
                        }
                        z = false;
                        i2 = -1;
                    } catch (NumberFormatException unused) {
                        String valueOf2 = String.valueOf(str4);
                        if (valueOf2.length() != 0) {
                            "Invalid bitrate header: ".concat(valueOf2);
                        } else {
                            new String("Invalid bitrate header: ");
                        }
                        i = i2;
                        z = false;
                        list = map.get("icy-genre");
                        if (list == null) {
                        }
                        list2 = map.get("icy-name");
                        if (list2 == null) {
                        }
                        list3 = map.get("icy-url");
                        if (list3 == null) {
                        }
                        list4 = map.get("icy-pub");
                        if (list4 == null) {
                        }
                        list5 = map.get("icy-metaint");
                        if (list5 != null) {
                        }
                        if (z) {
                        }
                    }
                }
                i = i2;
            } catch (NumberFormatException unused2) {
                i2 = -1;
            }
        } else {
            z = false;
            i = -1;
        }
        list = map.get("icy-genre");
        if (list == null) {
            str = list.get(0);
            z = true;
        } else {
            str = null;
        }
        list2 = map.get("icy-name");
        if (list2 == null) {
            str2 = list2.get(0);
            z = true;
        } else {
            str2 = null;
        }
        list3 = map.get("icy-url");
        if (list3 == null) {
            str3 = list3.get(0);
            z = true;
        } else {
            str3 = null;
        }
        list4 = map.get("icy-pub");
        if (list4 == null) {
            z2 = list4.get(0).equals("1");
            z = true;
        } else {
            z2 = false;
        }
        list5 = map.get("icy-metaint");
        if (list5 != null) {
            String str5 = list5.get(0);
            try {
                int parseInt = Integer.parseInt(str5);
                if (parseInt > 0) {
                    i3 = parseInt;
                } else {
                    try {
                        String valueOf3 = String.valueOf(str5);
                        if (valueOf3.length() != 0) {
                            "Invalid metadata interval: ".concat(valueOf3);
                        } else {
                            new String("Invalid metadata interval: ");
                        }
                        z3 = z;
                    } catch (NumberFormatException unused3) {
                        i3 = parseInt;
                        String valueOf4 = String.valueOf(str5);
                        if (valueOf4.length() != 0) {
                            "Invalid metadata interval: ".concat(valueOf4);
                        } else {
                            new String("Invalid metadata interval: ");
                        }
                        if (z) {
                        }
                    }
                }
                z = z3;
            } catch (NumberFormatException unused4) {
            }
        }
        if (z) {
            return new C2856zc(i, str, str2, str3, z2, i3);
        }
        return null;
    }

    @Override // me.tvspark.C2254jc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    @Nullable
    public /* synthetic */ byte[] Wwwwwwwwwwwwwwwwwwwwww() {
        return C2291kc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
    }

    @Override // me.tvspark.C2254jc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    @Nullable
    public /* synthetic */ C2245j3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return C2291kc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C2856zc.class != obj.getClass()) {
            return false;
        }
        C2856zc c2856zc = (C2856zc) obj;
        return this.Wwwwwwwwwwwwwwwwwwwwwwww == c2856zc.Wwwwwwwwwwwwwwwwwwwwwwww && C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) this.Wwwwwwwwwwwwwwwwwwwwwww, (Object) c2856zc.Wwwwwwwwwwwwwwwwwwwwwww) && C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) this.Wwwwwwwwwwwwwwwwwwwwww, (Object) c2856zc.Wwwwwwwwwwwwwwwwwwwwww) && C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) this.Wwwwwwwwwwwwwwwwwwwww, (Object) c2856zc.Wwwwwwwwwwwwwwwwwwwww) && this.Wwwwwwwwwwwwwwwwwwww == c2856zc.Wwwwwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwwww == c2856zc.Wwwwwwwwwwwwwwwwwww;
    }

    public int hashCode() {
        int i = (527 + this.Wwwwwwwwwwwwwwwwwwwwwwww) * 31;
        String str = this.Wwwwwwwwwwwwwwwwwwwwwww;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.Wwwwwwwwwwwwwwwwwwwwww;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.Wwwwwwwwwwwwwwwwwwwww;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return ((((hashCode2 + i2) * 31) + (this.Wwwwwwwwwwwwwwwwwwww ? 1 : 0)) * 31) + this.Wwwwwwwwwwwwwwwwwww;
    }

    public String toString() {
        String str = this.Wwwwwwwwwwwwwwwwwwwwww;
        String str2 = this.Wwwwwwwwwwwwwwwwwwwwwww;
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        int i2 = this.Wwwwwwwwwwwwwwwwwww;
        StringBuilder sb = new StringBuilder(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, 80)));
        sb.append("IcyHeaders: name=\"");
        sb.append(str);
        sb.append("\", genre=\"");
        sb.append(str2);
        sb.append("\", bitrate=");
        sb.append(i);
        sb.append(", metadataInterval=");
        sb.append(i2);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.Wwwwwwwwwwwwwwwwwwwwwwww);
        parcel.writeString(this.Wwwwwwwwwwwwwwwwwwwwwww);
        parcel.writeString(this.Wwwwwwwwwwwwwwwwwwwwww);
        parcel.writeString(this.Wwwwwwwwwwwwwwwwwwwww);
        C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(parcel, this.Wwwwwwwwwwwwwwwwwwww);
        parcel.writeInt(this.Wwwwwwwwwwwwwwwwwww);
    }
}
