package me.tvspark;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.Arrays;

/* renamed from: me.tvspark.ld */
/* loaded from: classes4.dex */
public final class C2329ld extends AbstractC2255jd {
    public static final Parcelable.Creator<C2329ld> CREATOR = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public final int[] Wwwwwwwwwwwwwwwwwww;
    public final int[] Wwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: me.tvspark.ld$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Parcelable.Creator<C2329ld> {
        @Override // android.os.Parcelable.Creator
        public C2329ld createFromParcel(Parcel parcel) {
            return new C2329ld(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public C2329ld[] newArray(int i) {
            return new C2329ld[i];
        }
    }

    public C2329ld(int i, int i2, int i3, int[] iArr, int[] iArr2) {
        super("MLLT");
        this.Wwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwww = i2;
        this.Wwwwwwwwwwwwwwwwwwwww = i3;
        this.Wwwwwwwwwwwwwwwwwwww = iArr;
        this.Wwwwwwwwwwwwwwwwwww = iArr2;
    }

    public C2329ld(Parcel parcel) {
        super("MLLT");
        this.Wwwwwwwwwwwwwwwwwwwwwww = parcel.readInt();
        this.Wwwwwwwwwwwwwwwwwwwwww = parcel.readInt();
        this.Wwwwwwwwwwwwwwwwwwwww = parcel.readInt();
        int[] createIntArray = parcel.createIntArray();
        C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(createIntArray);
        this.Wwwwwwwwwwwwwwwwwwww = createIntArray;
        this.Wwwwwwwwwwwwwwwwwww = parcel.createIntArray();
    }

    @Override // me.tvspark.AbstractC2255jd, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C2329ld.class != obj.getClass()) {
            return false;
        }
        C2329ld c2329ld = (C2329ld) obj;
        return this.Wwwwwwwwwwwwwwwwwwwwwww == c2329ld.Wwwwwwwwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwwwwwww == c2329ld.Wwwwwwwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwwwwww == c2329ld.Wwwwwwwwwwwwwwwwwwwww && Arrays.equals(this.Wwwwwwwwwwwwwwwwwwww, c2329ld.Wwwwwwwwwwwwwwwwwwww) && Arrays.equals(this.Wwwwwwwwwwwwwwwwwww, c2329ld.Wwwwwwwwwwwwwwwwwww);
    }

    public int hashCode() {
        int hashCode = Arrays.hashCode(this.Wwwwwwwwwwwwwwwwwwww);
        return Arrays.hashCode(this.Wwwwwwwwwwwwwwwwwww) + ((hashCode + ((((((527 + this.Wwwwwwwwwwwwwwwwwwwwwww) * 31) + this.Wwwwwwwwwwwwwwwwwwwwww) * 31) + this.Wwwwwwwwwwwwwwwwwwwww) * 31)) * 31);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.Wwwwwwwwwwwwwwwwwwwwwww);
        parcel.writeInt(this.Wwwwwwwwwwwwwwwwwwwwww);
        parcel.writeInt(this.Wwwwwwwwwwwwwwwwwwwww);
        parcel.writeIntArray(this.Wwwwwwwwwwwwwwwwwwww);
        parcel.writeIntArray(this.Wwwwwwwwwwwwwwwwwww);
    }
}
