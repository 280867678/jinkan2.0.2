package me.tvspark;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.Arrays;

/* renamed from: me.tvspark.lf */
/* loaded from: classes4.dex */
public final class C2331lf implements Parcelable {
    public static final Parcelable.Creator<C2331lf> CREATOR = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public int Wwwwwwwwwwwwwwwwwwwwww;
    public final C2245j3[] Wwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: me.tvspark.lf$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Parcelable.Creator<C2331lf> {
        @Override // android.os.Parcelable.Creator
        public C2331lf createFromParcel(Parcel parcel) {
            return new C2331lf(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public C2331lf[] newArray(int i) {
            return new C2331lf[i];
        }
    }

    public C2331lf(Parcel parcel) {
        int readInt = parcel.readInt();
        this.Wwwwwwwwwwwwwwwwwwwwwwww = readInt;
        this.Wwwwwwwwwwwwwwwwwwwwwww = new C2245j3[readInt];
        for (int i = 0; i < this.Wwwwwwwwwwwwwwwwwwwwwwww; i++) {
            this.Wwwwwwwwwwwwwwwwwwwwwww[i] = (C2245j3) parcel.readParcelable(C2245j3.class.getClassLoader());
        }
    }

    public C2331lf(C2245j3... c2245j3Arr) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3Arr.length > 0);
        this.Wwwwwwwwwwwwwwwwwwwwwww = c2245j3Arr;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = c2245j3Arr.length;
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2245j3 c2245j3) {
        int i = 0;
        while (true) {
            C2245j3[] c2245j3Arr = this.Wwwwwwwwwwwwwwwwwwwwwww;
            if (i < c2245j3Arr.length) {
                if (c2245j3 == c2245j3Arr[i]) {
                    return i;
                }
                i++;
            } else {
                return -1;
            }
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C2331lf.class != obj.getClass()) {
            return false;
        }
        C2331lf c2331lf = (C2331lf) obj;
        return this.Wwwwwwwwwwwwwwwwwwwwwwww == c2331lf.Wwwwwwwwwwwwwwwwwwwwwwww && Arrays.equals(this.Wwwwwwwwwwwwwwwwwwwwwww, c2331lf.Wwwwwwwwwwwwwwwwwwwwwww);
    }

    public int hashCode() {
        if (this.Wwwwwwwwwwwwwwwwwwwwww == 0) {
            this.Wwwwwwwwwwwwwwwwwwwwww = 527 + Arrays.hashCode(this.Wwwwwwwwwwwwwwwwwwwwwww);
        }
        return this.Wwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.Wwwwwwwwwwwwwwwwwwwwwwww);
        for (int i2 = 0; i2 < this.Wwwwwwwwwwwwwwwwwwwwwwww; i2++) {
            parcel.writeParcelable(this.Wwwwwwwwwwwwwwwwwwwwwww[i2], 0);
        }
    }
}
