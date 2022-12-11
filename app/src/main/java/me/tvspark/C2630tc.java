package me.tvspark;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.Arrays;
import me.tvspark.C2245j3;
import me.tvspark.C2254jc;

/* renamed from: me.tvspark.tc */
/* loaded from: classes4.dex */
public final class C2630tc implements C2254jc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    public static final Parcelable.Creator<C2630tc> CREATOR = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public static final C2245j3 Wwwwwwwwwwwwwwwww;
    public static final C2245j3 Wwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwww;
    public final byte[] Wwwwwwwwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwwwwwwwwww;
    public final String Wwwwwwwwwwwwwwwwwwwwwww;
    public final String Wwwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: me.tvspark.tc$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Parcelable.Creator<C2630tc> {
        @Override // android.os.Parcelable.Creator
        public C2630tc createFromParcel(Parcel parcel) {
            return new C2630tc(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public C2630tc[] newArray(int i) {
            return new C2630tc[i];
        }
    }

    static {
        C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww = "application/id3";
        Wwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = new C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwww = "application/x-scte35";
        Wwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public C2630tc(Parcel parcel) {
        String readString = parcel.readString();
        C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(readString);
        this.Wwwwwwwwwwwwwwwwwwwwwwww = readString;
        this.Wwwwwwwwwwwwwwwwwwwwwww = parcel.readString();
        this.Wwwwwwwwwwwwwwwwwwwwww = parcel.readLong();
        this.Wwwwwwwwwwwwwwwwwwwww = parcel.readLong();
        this.Wwwwwwwwwwwwwwwwwwww = parcel.createByteArray();
    }

    public C2630tc(String str, String str2, long j, long j2, byte[] bArr) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = str;
        this.Wwwwwwwwwwwwwwwwwwwwwww = str2;
        this.Wwwwwwwwwwwwwwwwwwwwww = j;
        this.Wwwwwwwwwwwwwwwwwwwww = j2;
        this.Wwwwwwwwwwwwwwwwwwww = bArr;
    }

    @Override // me.tvspark.C2254jc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    @Nullable
    public byte[] Wwwwwwwwwwwwwwwwwwwwww() {
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() != null) {
            return this.Wwwwwwwwwwwwwwwwwwww;
        }
        return null;
    }

    @Override // me.tvspark.C2254jc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    @Nullable
    public C2245j3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        char c;
        String str = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        int hashCode = str.hashCode();
        if (hashCode == -1468477611) {
            if (str.equals("urn:scte:scte35:2014:bin")) {
                c = 2;
            }
            c = 65535;
        } else if (hashCode != -795945609) {
            if (hashCode == 1303648457 && str.equals("https://developer.apple.com/streaming/emsg-id3")) {
                c = 1;
            }
            c = 65535;
        } else {
            if (str.equals("https://aomedia.org/emsg/ID3")) {
                c = 0;
            }
            c = 65535;
        }
        if (c == 0 || c == 1) {
            return Wwwwwwwwwwwwwwwwww;
        }
        if (c == 2) {
            return Wwwwwwwwwwwwwwwww;
        }
        return null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C2630tc.class != obj.getClass()) {
            return false;
        }
        C2630tc c2630tc = (C2630tc) obj;
        return this.Wwwwwwwwwwwwwwwwwwwwww == c2630tc.Wwwwwwwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwwwwww == c2630tc.Wwwwwwwwwwwwwwwwwwwww && C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) this.Wwwwwwwwwwwwwwwwwwwwwwww, (Object) c2630tc.Wwwwwwwwwwwwwwwwwwwwwwww) && C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) this.Wwwwwwwwwwwwwwwwwwwwwww, (Object) c2630tc.Wwwwwwwwwwwwwwwwwwwwwww) && Arrays.equals(this.Wwwwwwwwwwwwwwwwwwww, c2630tc.Wwwwwwwwwwwwwwwwwwww);
    }

    public int hashCode() {
        if (this.Wwwwwwwwwwwwwwwwwww == 0) {
            String str = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            int i = 0;
            int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.Wwwwwwwwwwwwwwwwwwwwwww;
            if (str2 != null) {
                i = str2.hashCode();
            }
            long j = this.Wwwwwwwwwwwwwwwwwwwwww;
            long j2 = this.Wwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwww = Arrays.hashCode(this.Wwwwwwwwwwwwwwwwwwww) + ((((((hashCode + i) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31);
        }
        return this.Wwwwwwwwwwwwwwwwwww;
    }

    public String toString() {
        String str = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        long j = this.Wwwwwwwwwwwwwwwwwwwww;
        long j2 = this.Wwwwwwwwwwwwwwwwwwwwww;
        String str2 = this.Wwwwwwwwwwwwwwwwwwwwwww;
        StringBuilder sb = new StringBuilder(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, 79)));
        sb.append("EMSG: scheme=");
        sb.append(str);
        sb.append(", id=");
        sb.append(j);
        sb.append(", durationMs=");
        sb.append(j2);
        sb.append(", value=");
        sb.append(str2);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.Wwwwwwwwwwwwwwwwwwwwwwww);
        parcel.writeString(this.Wwwwwwwwwwwwwwwwwwwwwww);
        parcel.writeLong(this.Wwwwwwwwwwwwwwwwwwwwww);
        parcel.writeLong(this.Wwwwwwwwwwwwwwwwwwwww);
        parcel.writeByteArray(this.Wwwwwwwwwwwwwwwwwwww);
    }
}
