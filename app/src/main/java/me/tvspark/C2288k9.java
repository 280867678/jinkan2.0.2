package me.tvspark;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.Arrays;
import me.tvspark.C2254jc;

/* renamed from: me.tvspark.k9 */
/* loaded from: classes4.dex */
public final class C2288k9 implements C2254jc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    public static final Parcelable.Creator<C2288k9> CREATOR = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public final int Wwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwww;
    public final byte[] Wwwwwwwwwwwwwwwwwwwwwww;
    public final String Wwwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: me.tvspark.k9$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Parcelable.Creator<C2288k9> {
        @Override // android.os.Parcelable.Creator
        public C2288k9 createFromParcel(Parcel parcel) {
            return new C2288k9(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        public C2288k9[] newArray(int i) {
            return new C2288k9[i];
        }
    }

    public /* synthetic */ C2288k9(Parcel parcel, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        String readString = parcel.readString();
        C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(readString);
        this.Wwwwwwwwwwwwwwwwwwwwwwww = readString;
        this.Wwwwwwwwwwwwwwwwwwwwwww = parcel.createByteArray();
        this.Wwwwwwwwwwwwwwwwwwwwww = parcel.readInt();
        this.Wwwwwwwwwwwwwwwwwwwww = parcel.readInt();
    }

    public C2288k9(String str, byte[] bArr, int i, int i2) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = str;
        this.Wwwwwwwwwwwwwwwwwwwwwww = bArr;
        this.Wwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwww = i2;
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
        if (obj == null || C2288k9.class != obj.getClass()) {
            return false;
        }
        C2288k9 c2288k9 = (C2288k9) obj;
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.equals(c2288k9.Wwwwwwwwwwwwwwwwwwwwwwww) && Arrays.equals(this.Wwwwwwwwwwwwwwwwwwwwwww, c2288k9.Wwwwwwwwwwwwwwwwwwwwwww) && this.Wwwwwwwwwwwwwwwwwwwwww == c2288k9.Wwwwwwwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwwwwww == c2288k9.Wwwwwwwwwwwwwwwwwwwww;
    }

    public int hashCode() {
        return ((((Arrays.hashCode(this.Wwwwwwwwwwwwwwwwwwwwwww) + outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, 527, 31)) * 31) + this.Wwwwwwwwwwwwwwwwwwwwww) * 31) + this.Wwwwwwwwwwwwwwwwwwwww;
    }

    public String toString() {
        String valueOf = String.valueOf(this.Wwwwwwwwwwwwwwwwwwwwwwww);
        return valueOf.length() != 0 ? "mdta: key=".concat(valueOf) : new String("mdta: key=");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.Wwwwwwwwwwwwwwwwwwwwwwww);
        parcel.writeByteArray(this.Wwwwwwwwwwwwwwwwwwwwwww);
        parcel.writeInt(this.Wwwwwwwwwwwwwwwwwwwwww);
        parcel.writeInt(this.Wwwwwwwwwwwwwwwwwwwww);
    }
}
