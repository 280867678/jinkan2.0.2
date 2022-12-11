package me.tvspark;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.Arrays;
import me.tvspark.C2254jc;

/* renamed from: me.tvspark.wc */
/* loaded from: classes4.dex */
public final class C2745wc implements C2254jc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    public static final Parcelable.Creator<C2745wc> CREATOR = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public final byte[] Wwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwww;
    public final String Wwwwwwwwwwwwwwwwwwwwww;
    public final String Wwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: me.tvspark.wc$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Parcelable.Creator<C2745wc> {
        @Override // android.os.Parcelable.Creator
        public C2745wc createFromParcel(Parcel parcel) {
            return new C2745wc(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public C2745wc[] newArray(int i) {
            return new C2745wc[i];
        }
    }

    public C2745wc(int i, String str, String str2, int i2, int i3, int i4, int i5, byte[] bArr) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwwww = str;
        this.Wwwwwwwwwwwwwwwwwwwwww = str2;
        this.Wwwwwwwwwwwwwwwwwwwww = i2;
        this.Wwwwwwwwwwwwwwwwwwww = i3;
        this.Wwwwwwwwwwwwwwwwwww = i4;
        this.Wwwwwwwwwwwwwwwwww = i5;
        this.Wwwwwwwwwwwwwwwww = bArr;
    }

    public C2745wc(Parcel parcel) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = parcel.readInt();
        String readString = parcel.readString();
        C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(readString);
        this.Wwwwwwwwwwwwwwwwwwwwwww = readString;
        this.Wwwwwwwwwwwwwwwwwwwwww = parcel.readString();
        this.Wwwwwwwwwwwwwwwwwwwww = parcel.readInt();
        this.Wwwwwwwwwwwwwwwwwwww = parcel.readInt();
        this.Wwwwwwwwwwwwwwwwwww = parcel.readInt();
        this.Wwwwwwwwwwwwwwwwww = parcel.readInt();
        this.Wwwwwwwwwwwwwwwww = parcel.createByteArray();
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
        if (obj == null || C2745wc.class != obj.getClass()) {
            return false;
        }
        C2745wc c2745wc = (C2745wc) obj;
        return this.Wwwwwwwwwwwwwwwwwwwwwwww == c2745wc.Wwwwwwwwwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwwwwwwww.equals(c2745wc.Wwwwwwwwwwwwwwwwwwwwwww) && this.Wwwwwwwwwwwwwwwwwwwwww.equals(c2745wc.Wwwwwwwwwwwwwwwwwwwwww) && this.Wwwwwwwwwwwwwwwwwwwww == c2745wc.Wwwwwwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwwwww == c2745wc.Wwwwwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwwww == c2745wc.Wwwwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwww == c2745wc.Wwwwwwwwwwwwwwwwww && Arrays.equals(this.Wwwwwwwwwwwwwwwww, c2745wc.Wwwwwwwwwwwwwwwww);
    }

    public int hashCode() {
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww, (this.Wwwwwwwwwwwwwwwwwwwwwwww + 527) * 31, 31);
        return Arrays.hashCode(this.Wwwwwwwwwwwwwwwww) + ((((((((outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 31) + this.Wwwwwwwwwwwwwwwwwwwww) * 31) + this.Wwwwwwwwwwwwwwwwwwww) * 31) + this.Wwwwwwwwwwwwwwwwwww) * 31) + this.Wwwwwwwwwwwwwwwwww) * 31);
    }

    public String toString() {
        String str = this.Wwwwwwwwwwwwwwwwwwwwwww;
        String str2 = this.Wwwwwwwwwwwwwwwwwwwwww;
        StringBuilder sb = new StringBuilder(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, 32)));
        sb.append("Picture: mimeType=");
        sb.append(str);
        sb.append(", description=");
        sb.append(str2);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.Wwwwwwwwwwwwwwwwwwwwwwww);
        parcel.writeString(this.Wwwwwwwwwwwwwwwwwwwwwww);
        parcel.writeString(this.Wwwwwwwwwwwwwwwwwwwwww);
        parcel.writeInt(this.Wwwwwwwwwwwwwwwwwwwww);
        parcel.writeInt(this.Wwwwwwwwwwwwwwwwwwww);
        parcel.writeInt(this.Wwwwwwwwwwwwwwwwwww);
        parcel.writeInt(this.Wwwwwwwwwwwwwwwwww);
        parcel.writeByteArray(this.Wwwwwwwwwwwwwwwww);
    }
}
