package me.tvspark;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import me.tvspark.C2254jc;

/* renamed from: me.tvspark.xc */
/* loaded from: classes4.dex */
public final class C2782xc implements C2254jc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    public static final Parcelable.Creator<C2782xc> CREATOR = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public final String Wwwwwwwwwwwwwwwwwwwwwww;
    public final String Wwwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: me.tvspark.xc$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Parcelable.Creator<C2782xc> {
        @Override // android.os.Parcelable.Creator
        public C2782xc createFromParcel(Parcel parcel) {
            return new C2782xc(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public C2782xc[] newArray(int i) {
            return new C2782xc[i];
        }
    }

    public C2782xc(Parcel parcel) {
        String readString = parcel.readString();
        C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(readString);
        this.Wwwwwwwwwwwwwwwwwwwwwwww = readString;
        this.Wwwwwwwwwwwwwwwwwwwwwww = parcel.readString();
    }

    public C2782xc(String str, String str2) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = str;
        this.Wwwwwwwwwwwwwwwwwwwwwww = str2;
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
        if (obj == null || C2782xc.class != obj.getClass()) {
            return false;
        }
        C2782xc c2782xc = (C2782xc) obj;
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.equals(c2782xc.Wwwwwwwwwwwwwwwwwwwwwwww) && this.Wwwwwwwwwwwwwwwwwwwwwww.equals(c2782xc.Wwwwwwwwwwwwwwwwwwwwwww);
    }

    public int hashCode() {
        return this.Wwwwwwwwwwwwwwwwwwwwwww.hashCode() + outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, 527, 31);
    }

    public String toString() {
        String str = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        String str2 = this.Wwwwwwwwwwwwwwwwwwwwwww;
        StringBuilder sb = new StringBuilder(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, 5)));
        sb.append("VC: ");
        sb.append(str);
        sb.append("=");
        sb.append(str2);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.Wwwwwwwwwwwwwwwwwwwwwwww);
        parcel.writeString(this.Wwwwwwwwwwwwwwwwwwwwwww);
    }
}
