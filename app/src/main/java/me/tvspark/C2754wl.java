package me.tvspark;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.Arrays;

/* renamed from: me.tvspark.wl */
/* loaded from: classes4.dex */
public final class C2754wl implements Parcelable {
    public static final Parcelable.Creator<C2754wl> CREATOR = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public int Wwwwwwwwwwwwwwwwwwww;
    @Nullable
    public final byte[] Wwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: me.tvspark.wl$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Parcelable.Creator<C2754wl> {
        @Override // android.os.Parcelable.Creator
        public C2754wl createFromParcel(Parcel parcel) {
            return new C2754wl(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public C2754wl[] newArray(int i) {
            return new C2754wl[i];
        }
    }

    public C2754wl(int i, int i2, int i3, @Nullable byte[] bArr) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwwww = i2;
        this.Wwwwwwwwwwwwwwwwwwwwww = i3;
        this.Wwwwwwwwwwwwwwwwwwwww = bArr;
    }

    public C2754wl(Parcel parcel) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = parcel.readInt();
        this.Wwwwwwwwwwwwwwwwwwwwwww = parcel.readInt();
        this.Wwwwwwwwwwwwwwwwwwwwww = parcel.readInt();
        this.Wwwwwwwwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(parcel) ? parcel.createByteArray() : null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C2754wl.class != obj.getClass()) {
            return false;
        }
        C2754wl c2754wl = (C2754wl) obj;
        return this.Wwwwwwwwwwwwwwwwwwwwwwww == c2754wl.Wwwwwwwwwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwwwwwwww == c2754wl.Wwwwwwwwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwwwwwww == c2754wl.Wwwwwwwwwwwwwwwwwwwwww && Arrays.equals(this.Wwwwwwwwwwwwwwwwwwwww, c2754wl.Wwwwwwwwwwwwwwwwwwwww);
    }

    public int hashCode() {
        if (this.Wwwwwwwwwwwwwwwwwwww == 0) {
            this.Wwwwwwwwwwwwwwwwwwww = Arrays.hashCode(this.Wwwwwwwwwwwwwwwwwwwww) + ((((((527 + this.Wwwwwwwwwwwwwwwwwwwwwwww) * 31) + this.Wwwwwwwwwwwwwwwwwwwwwww) * 31) + this.Wwwwwwwwwwwwwwwwwwwwww) * 31);
        }
        return this.Wwwwwwwwwwwwwwwwwwww;
    }

    public String toString() {
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        int i2 = this.Wwwwwwwwwwwwwwwwwwwwwww;
        int i3 = this.Wwwwwwwwwwwwwwwwwwwwww;
        boolean z = this.Wwwwwwwwwwwwwwwwwwwww != null;
        StringBuilder sb = new StringBuilder(55);
        sb.append("ColorInfo(");
        sb.append(i);
        sb.append(", ");
        sb.append(i2);
        sb.append(", ");
        sb.append(i3);
        sb.append(", ");
        sb.append(z);
        sb.append(")");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.Wwwwwwwwwwwwwwwwwwwwwwww);
        parcel.writeInt(this.Wwwwwwwwwwwwwwwwwwwwwww);
        parcel.writeInt(this.Wwwwwwwwwwwwwwwwwwwwww);
        C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(parcel, this.Wwwwwwwwwwwwwwwwwwwww != null);
        byte[] bArr = this.Wwwwwwwwwwwwwwwwwwwww;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
    }
}
