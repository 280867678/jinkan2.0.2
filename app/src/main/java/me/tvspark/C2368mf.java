package me.tvspark;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.Arrays;

/* renamed from: me.tvspark.mf */
/* loaded from: classes4.dex */
public final class C2368mf implements Parcelable {
    public int Wwwwwwwwwwwwwwwwwwwwww;
    public final C2331lf[] Wwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwww;
    public static final C2368mf Wwwwwwwwwwwwwwwwwwwww = new C2368mf(new C2331lf[0]);
    public static final Parcelable.Creator<C2368mf> CREATOR = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    /* renamed from: me.tvspark.mf$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Parcelable.Creator<C2368mf> {
        @Override // android.os.Parcelable.Creator
        public C2368mf createFromParcel(Parcel parcel) {
            return new C2368mf(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public C2368mf[] newArray(int i) {
            return new C2368mf[i];
        }
    }

    public C2368mf(Parcel parcel) {
        int readInt = parcel.readInt();
        this.Wwwwwwwwwwwwwwwwwwwwwwww = readInt;
        this.Wwwwwwwwwwwwwwwwwwwwwww = new C2331lf[readInt];
        for (int i = 0; i < this.Wwwwwwwwwwwwwwwwwwwwwwww; i++) {
            this.Wwwwwwwwwwwwwwwwwwwwwww[i] = (C2331lf) parcel.readParcelable(C2331lf.class.getClassLoader());
        }
    }

    public C2368mf(C2331lf... c2331lfArr) {
        this.Wwwwwwwwwwwwwwwwwwwwwww = c2331lfArr;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = c2331lfArr.length;
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2331lf c2331lf) {
        for (int i = 0; i < this.Wwwwwwwwwwwwwwwwwwwwwwww; i++) {
            if (this.Wwwwwwwwwwwwwwwwwwwwwww[i] == c2331lf) {
                return i;
            }
        }
        return -1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C2368mf.class != obj.getClass()) {
            return false;
        }
        C2368mf c2368mf = (C2368mf) obj;
        return this.Wwwwwwwwwwwwwwwwwwwwwwww == c2368mf.Wwwwwwwwwwwwwwwwwwwwwwww && Arrays.equals(this.Wwwwwwwwwwwwwwwwwwwwwww, c2368mf.Wwwwwwwwwwwwwwwwwwwwwww);
    }

    public int hashCode() {
        if (this.Wwwwwwwwwwwwwwwwwwwwww == 0) {
            this.Wwwwwwwwwwwwwwwwwwwwww = Arrays.hashCode(this.Wwwwwwwwwwwwwwwwwwwwwww);
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
