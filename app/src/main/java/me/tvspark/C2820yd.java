package me.tvspark;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;

/* renamed from: me.tvspark.yd */
/* loaded from: classes4.dex */
public final class C2820yd implements Comparable<C2820yd>, Parcelable {
    public static final Parcelable.Creator<C2820yd> CREATOR = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public final int Wwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: me.tvspark.yd$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Parcelable.Creator<C2820yd> {
        @Override // android.os.Parcelable.Creator
        public C2820yd createFromParcel(Parcel parcel) {
            return new C2820yd(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public C2820yd[] newArray(int i) {
            return new C2820yd[i];
        }
    }

    public C2820yd(Parcel parcel) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = parcel.readInt();
        this.Wwwwwwwwwwwwwwwwwwwwwww = parcel.readInt();
        this.Wwwwwwwwwwwwwwwwwwwwww = parcel.readInt();
    }

    @Override // java.lang.Comparable
    public int compareTo(C2820yd c2820yd) {
        C2820yd c2820yd2 = c2820yd;
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwww - c2820yd2.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (i == 0) {
            int i2 = this.Wwwwwwwwwwwwwwwwwwwwwww - c2820yd2.Wwwwwwwwwwwwwwwwwwwwwww;
            return i2 == 0 ? this.Wwwwwwwwwwwwwwwwwwwwww - c2820yd2.Wwwwwwwwwwwwwwwwwwwwww : i2;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C2820yd.class != obj.getClass()) {
            return false;
        }
        C2820yd c2820yd = (C2820yd) obj;
        return this.Wwwwwwwwwwwwwwwwwwwwwwww == c2820yd.Wwwwwwwwwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwwwwwwww == c2820yd.Wwwwwwwwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwwwwwww == c2820yd.Wwwwwwwwwwwwwwwwwwwwww;
    }

    public int hashCode() {
        return (((this.Wwwwwwwwwwwwwwwwwwwwwwww * 31) + this.Wwwwwwwwwwwwwwwwwwwwwww) * 31) + this.Wwwwwwwwwwwwwwwwwwwwww;
    }

    public String toString() {
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        int i2 = this.Wwwwwwwwwwwwwwwwwwwwwww;
        int i3 = this.Wwwwwwwwwwwwwwwwwwwwww;
        StringBuilder sb = new StringBuilder(35);
        sb.append(i);
        sb.append(".");
        sb.append(i2);
        sb.append(".");
        sb.append(i3);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.Wwwwwwwwwwwwwwwwwwwwwwww);
        parcel.writeInt(this.Wwwwwwwwwwwwwwwwwwwwwww);
        parcel.writeInt(this.Wwwwwwwwwwwwwwwwwwwwww);
    }
}
